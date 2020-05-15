package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class TrampolineScheduler extends Scheduler {
    private static final TrampolineScheduler INSTANCE = new TrampolineScheduler();

    public static TrampolineScheduler instance() {
        return INSTANCE;
    }

    public Scheduler.Worker createWorker() {
        return new TrampolineWorker();
    }

    TrampolineScheduler() {
    }

    public Disposable scheduleDirect(Runnable runnable) {
        RxJavaPlugins.onSchedule(runnable).run();
        return EmptyDisposable.INSTANCE;
    }

    public Disposable scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j);
            RxJavaPlugins.onSchedule(runnable).run();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            RxJavaPlugins.onError(e);
        }
        return EmptyDisposable.INSTANCE;
    }

    static final class TrampolineWorker extends Scheduler.Worker implements Disposable {
        final AtomicInteger counter = new AtomicInteger();
        volatile boolean disposed;
        final PriorityBlockingQueue<TimedRunnable> queue = new PriorityBlockingQueue<>();
        private final AtomicInteger wip = new AtomicInteger();

        TrampolineWorker() {
        }

        public Disposable schedule(Runnable runnable) {
            return enqueue(runnable, now(TimeUnit.MILLISECONDS));
        }

        public Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            long now = now(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j);
            return enqueue(new SleepingRunnable(runnable, this, now), now);
        }

        /* access modifiers changed from: package-private */
        public Disposable enqueue(Runnable runnable, long j) {
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            TimedRunnable timedRunnable = new TimedRunnable(runnable, Long.valueOf(j), this.counter.incrementAndGet());
            this.queue.add(timedRunnable);
            if (this.wip.getAndIncrement() != 0) {
                return Disposables.fromRunnable(new AppendToQueueTask(timedRunnable));
            }
            int i = 1;
            while (!this.disposed) {
                TimedRunnable poll = this.queue.poll();
                if (poll == null) {
                    i = this.wip.addAndGet(-i);
                    if (i == 0) {
                        return EmptyDisposable.INSTANCE;
                    }
                } else if (!poll.disposed) {
                    poll.run.run();
                }
            }
            this.queue.clear();
            return EmptyDisposable.INSTANCE;
        }

        public void dispose() {
            this.disposed = true;
        }

        public boolean isDisposed() {
            return this.disposed;
        }

        final class AppendToQueueTask implements Runnable {
            final TimedRunnable timedRunnable;

            AppendToQueueTask(TimedRunnable timedRunnable2) {
                this.timedRunnable = timedRunnable2;
            }

            public void run() {
                this.timedRunnable.disposed = true;
                TrampolineWorker.this.queue.remove(this.timedRunnable);
            }
        }
    }

    static final class TimedRunnable implements Comparable<TimedRunnable> {
        final int count;
        volatile boolean disposed;
        final long execTime;
        final Runnable run;

        TimedRunnable(Runnable runnable, Long l, int i) {
            this.run = runnable;
            this.execTime = l.longValue();
            this.count = i;
        }

        public int compareTo(TimedRunnable timedRunnable) {
            int compare = ObjectHelper.compare(this.execTime, timedRunnable.execTime);
            return compare == 0 ? ObjectHelper.compare(this.count, timedRunnable.count) : compare;
        }
    }

    static final class SleepingRunnable implements Runnable {
        private final long execTime;
        private final Runnable run;
        private final TrampolineWorker worker;

        SleepingRunnable(Runnable runnable, TrampolineWorker trampolineWorker, long j) {
            this.run = runnable;
            this.worker = trampolineWorker;
            this.execTime = j;
        }

        public void run() {
            if (!this.worker.disposed) {
                long now = this.worker.now(TimeUnit.MILLISECONDS);
                long j = this.execTime;
                if (j > now) {
                    try {
                        Thread.sleep(j - now);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        RxJavaPlugins.onError(e);
                        return;
                    }
                }
                if (!this.worker.disposed) {
                    this.run.run();
                }
            }
        }
    }
}
