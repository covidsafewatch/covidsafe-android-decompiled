package io.reactivex;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.schedulers.NewThreadWorker;
import io.reactivex.internal.schedulers.SchedulerWhen;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.SchedulerRunnableIntrospection;
import java.util.concurrent.TimeUnit;

public abstract class Scheduler {
    static final long CLOCK_DRIFT_TOLERANCE_NANOSECONDS = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    public abstract Worker createWorker();

    public void shutdown() {
    }

    public void start() {
    }

    public static long clockDriftTolerance() {
        return CLOCK_DRIFT_TOLERANCE_NANOSECONDS;
    }

    public long now(TimeUnit timeUnit) {
        return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    public Disposable scheduleDirect(Runnable runnable) {
        return scheduleDirect(runnable, 0, TimeUnit.NANOSECONDS);
    }

    public Disposable scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        Worker createWorker = createWorker();
        DisposeTask disposeTask = new DisposeTask(RxJavaPlugins.onSchedule(runnable), createWorker);
        createWorker.schedule(disposeTask, j, timeUnit);
        return disposeTask;
    }

    public Disposable schedulePeriodicallyDirect(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Worker createWorker = createWorker();
        PeriodicDirectTask periodicDirectTask = new PeriodicDirectTask(RxJavaPlugins.onSchedule(runnable), createWorker);
        Disposable schedulePeriodically = createWorker.schedulePeriodically(periodicDirectTask, j, j2, timeUnit);
        return schedulePeriodically == EmptyDisposable.INSTANCE ? schedulePeriodically : periodicDirectTask;
    }

    public <S extends Scheduler & Disposable> S when(Function<Flowable<Flowable<Completable>>, Completable> function) {
        return new SchedulerWhen(function, this);
    }

    public static abstract class Worker implements Disposable {
        public abstract Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit);

        public Disposable schedule(Runnable runnable) {
            return schedule(runnable, 0, TimeUnit.NANOSECONDS);
        }

        public Disposable schedulePeriodically(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            long j3 = j;
            TimeUnit timeUnit2 = timeUnit;
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
            long nanos = timeUnit2.toNanos(j2);
            long now = now(TimeUnit.NANOSECONDS);
            SequentialDisposable sequentialDisposable3 = sequentialDisposable;
            PeriodicTask periodicTask = r0;
            PeriodicTask periodicTask2 = new PeriodicTask(now + timeUnit2.toNanos(j3), onSchedule, now, sequentialDisposable2, nanos);
            Disposable schedule = schedule(periodicTask, j3, timeUnit2);
            if (schedule == EmptyDisposable.INSTANCE) {
                return schedule;
            }
            sequentialDisposable3.replace(schedule);
            return sequentialDisposable2;
        }

        public long now(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        final class PeriodicTask implements Runnable, SchedulerRunnableIntrospection {
            long count;
            final Runnable decoratedRun;
            long lastNowNanoseconds;
            final long periodInNanoseconds;
            final SequentialDisposable sd;
            long startInNanoseconds;

            PeriodicTask(long j, Runnable runnable, long j2, SequentialDisposable sequentialDisposable, long j3) {
                this.decoratedRun = runnable;
                this.sd = sequentialDisposable;
                this.periodInNanoseconds = j3;
                this.lastNowNanoseconds = j2;
                this.startInNanoseconds = j;
            }

            public void run() {
                long j;
                this.decoratedRun.run();
                if (!this.sd.isDisposed()) {
                    long now = Worker.this.now(TimeUnit.NANOSECONDS);
                    long j2 = this.lastNowNanoseconds;
                    if (Scheduler.CLOCK_DRIFT_TOLERANCE_NANOSECONDS + now < j2 || now >= j2 + this.periodInNanoseconds + Scheduler.CLOCK_DRIFT_TOLERANCE_NANOSECONDS) {
                        long j3 = this.periodInNanoseconds;
                        long j4 = now + j3;
                        long j5 = this.count + 1;
                        this.count = j5;
                        this.startInNanoseconds = j4 - (j3 * j5);
                        j = j4;
                    } else {
                        long j6 = this.startInNanoseconds;
                        long j7 = this.count + 1;
                        this.count = j7;
                        j = j6 + (j7 * this.periodInNanoseconds);
                    }
                    this.lastNowNanoseconds = now;
                    this.sd.replace(Worker.this.schedule(this, j - now, TimeUnit.NANOSECONDS));
                }
            }

            public Runnable getWrappedRunnable() {
                return this.decoratedRun;
            }
        }
    }

    static final class PeriodicDirectTask implements Disposable, Runnable, SchedulerRunnableIntrospection {
        volatile boolean disposed;
        final Runnable run;
        final Worker worker;

        PeriodicDirectTask(Runnable runnable, Worker worker2) {
            this.run = runnable;
            this.worker = worker2;
        }

        public void run() {
            if (!this.disposed) {
                try {
                    this.run.run();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.worker.dispose();
                    throw ExceptionHelper.wrapOrThrow(th);
                }
            }
        }

        public void dispose() {
            this.disposed = true;
            this.worker.dispose();
        }

        public boolean isDisposed() {
            return this.disposed;
        }

        public Runnable getWrappedRunnable() {
            return this.run;
        }
    }

    static final class DisposeTask implements Disposable, Runnable, SchedulerRunnableIntrospection {
        final Runnable decoratedRun;
        Thread runner;
        final Worker w;

        DisposeTask(Runnable runnable, Worker worker) {
            this.decoratedRun = runnable;
            this.w = worker;
        }

        public void run() {
            this.runner = Thread.currentThread();
            try {
                this.decoratedRun.run();
            } finally {
                dispose();
                this.runner = null;
            }
        }

        public void dispose() {
            if (this.runner == Thread.currentThread()) {
                Worker worker = this.w;
                if (worker instanceof NewThreadWorker) {
                    ((NewThreadWorker) worker).shutdown();
                    return;
                }
            }
            this.w.dispose();
        }

        public boolean isDisposed() {
            return this.w.isDisposed();
        }

        public Runnable getWrappedRunnable() {
            return this.decoratedRun;
        }
    }
}
