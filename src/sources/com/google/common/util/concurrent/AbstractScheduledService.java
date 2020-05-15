package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Service;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class AbstractScheduledService implements Service {
    /* access modifiers changed from: private */
    public static final Logger logger = Logger.getLogger(AbstractScheduledService.class.getName());
    /* access modifiers changed from: private */
    public final AbstractService delegate = new ServiceDelegate();

    /* access modifiers changed from: protected */
    public abstract void runOneIteration() throws Exception;

    /* access modifiers changed from: protected */
    public abstract Scheduler scheduler();

    /* access modifiers changed from: protected */
    public void shutDown() throws Exception {
    }

    /* access modifiers changed from: protected */
    public void startUp() throws Exception {
    }

    public static abstract class Scheduler {
        /* access modifiers changed from: package-private */
        public abstract Future<?> schedule(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable);

        public static Scheduler newFixedDelaySchedule(long j, long j2, TimeUnit timeUnit) {
            Preconditions.checkNotNull(timeUnit);
            Preconditions.checkArgument(j2 > 0, "delay must be > 0, found %s", j2);
            final long j3 = j;
            final long j4 = j2;
            final TimeUnit timeUnit2 = timeUnit;
            return new Scheduler() {
                public Future<?> schedule(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
                    return scheduledExecutorService.scheduleWithFixedDelay(runnable, j3, j4, timeUnit2);
                }
            };
        }

        public static Scheduler newFixedRateSchedule(long j, long j2, TimeUnit timeUnit) {
            Preconditions.checkNotNull(timeUnit);
            Preconditions.checkArgument(j2 > 0, "period must be > 0, found %s", j2);
            final long j3 = j;
            final long j4 = j2;
            final TimeUnit timeUnit2 = timeUnit;
            return new Scheduler() {
                public Future<?> schedule(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
                    return scheduledExecutorService.scheduleAtFixedRate(runnable, j3, j4, timeUnit2);
                }
            };
        }

        private Scheduler() {
        }
    }

    private final class ServiceDelegate extends AbstractService {
        /* access modifiers changed from: private */
        @MonotonicNonNullDecl
        public volatile ScheduledExecutorService executorService;
        /* access modifiers changed from: private */
        public final ReentrantLock lock;
        /* access modifiers changed from: private */
        @MonotonicNonNullDecl
        public volatile Future<?> runningTask;
        /* access modifiers changed from: private */
        public final Runnable task;

        private ServiceDelegate() {
            this.lock = new ReentrantLock();
            this.task = new Task();
        }

        class Task implements Runnable {
            Task() {
            }

            public void run() {
                ServiceDelegate.this.lock.lock();
                try {
                    if (ServiceDelegate.this.runningTask.isCancelled()) {
                        ServiceDelegate.this.lock.unlock();
                        return;
                    }
                    AbstractScheduledService.this.runOneIteration();
                    ServiceDelegate.this.lock.unlock();
                } catch (Throwable th) {
                    ServiceDelegate.this.lock.unlock();
                    throw th;
                }
            }
        }

        /* access modifiers changed from: protected */
        public final void doStart() {
            this.executorService = MoreExecutors.renamingDecorator(AbstractScheduledService.this.executor(), (Supplier<String>) new Supplier<String>() {
                public String get() {
                    return AbstractScheduledService.this.serviceName() + " " + ServiceDelegate.this.state();
                }
            });
            this.executorService.execute(new Runnable() {
                public void run() {
                    ServiceDelegate.this.lock.lock();
                    try {
                        AbstractScheduledService.this.startUp();
                        Future unused = ServiceDelegate.this.runningTask = AbstractScheduledService.this.scheduler().schedule(AbstractScheduledService.this.delegate, ServiceDelegate.this.executorService, ServiceDelegate.this.task);
                        ServiceDelegate.this.notifyStarted();
                    } catch (Throwable th) {
                        ServiceDelegate.this.lock.unlock();
                        throw th;
                    }
                    ServiceDelegate.this.lock.unlock();
                }
            });
        }

        /* access modifiers changed from: protected */
        public final void doStop() {
            this.runningTask.cancel(false);
            this.executorService.execute(new Runnable() {
                public void run() {
                    try {
                        ServiceDelegate.this.lock.lock();
                        if (ServiceDelegate.this.state() != Service.State.STOPPING) {
                            ServiceDelegate.this.lock.unlock();
                            return;
                        }
                        AbstractScheduledService.this.shutDown();
                        ServiceDelegate.this.lock.unlock();
                        ServiceDelegate.this.notifyStopped();
                    } catch (Throwable th) {
                        ServiceDelegate.this.notifyFailed(th);
                    }
                }
            });
        }

        public String toString() {
            return AbstractScheduledService.this.toString();
        }
    }

    protected AbstractScheduledService() {
    }

    /* access modifiers changed from: protected */
    public ScheduledExecutorService executor() {
        final ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                return MoreExecutors.newThread(AbstractScheduledService.this.serviceName(), runnable);
            }
        });
        addListener(new Service.Listener() {
            public void terminated(Service.State state) {
                newSingleThreadScheduledExecutor.shutdown();
            }

            public void failed(Service.State state, Throwable th) {
                newSingleThreadScheduledExecutor.shutdown();
            }
        }, MoreExecutors.directExecutor());
        return newSingleThreadScheduledExecutor;
    }

    /* access modifiers changed from: protected */
    public String serviceName() {
        return getClass().getSimpleName();
    }

    public String toString() {
        return serviceName() + " [" + state() + "]";
    }

    public final boolean isRunning() {
        return this.delegate.isRunning();
    }

    public final Service.State state() {
        return this.delegate.state();
    }

    public final void addListener(Service.Listener listener, Executor executor) {
        this.delegate.addListener(listener, executor);
    }

    public final Throwable failureCause() {
        return this.delegate.failureCause();
    }

    public final Service startAsync() {
        this.delegate.startAsync();
        return this;
    }

    public final Service stopAsync() {
        this.delegate.stopAsync();
        return this;
    }

    public final void awaitRunning() {
        this.delegate.awaitRunning();
    }

    public final void awaitRunning(long j, TimeUnit timeUnit) throws TimeoutException {
        this.delegate.awaitRunning(j, timeUnit);
    }

    public final void awaitTerminated() {
        this.delegate.awaitTerminated();
    }

    public final void awaitTerminated(long j, TimeUnit timeUnit) throws TimeoutException {
        this.delegate.awaitTerminated(j, timeUnit);
    }

    public static abstract class CustomScheduler extends Scheduler {
        /* access modifiers changed from: protected */
        public abstract Schedule getNextSchedule() throws Exception;

        public CustomScheduler() {
            super();
        }

        private class ReschedulableCallable extends ForwardingFuture<Void> implements Callable<Void> {
            @NullableDecl
            private Future<Void> currentFuture;
            private final ScheduledExecutorService executor;
            private final ReentrantLock lock = new ReentrantLock();
            private final AbstractService service;
            private final Runnable wrappedRunnable;

            ReschedulableCallable(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
                this.wrappedRunnable = runnable;
                this.executor = scheduledExecutorService;
                this.service = abstractService;
            }

            public Void call() throws Exception {
                this.wrappedRunnable.run();
                reschedule();
                return null;
            }

            public void reschedule() {
                try {
                    Schedule nextSchedule = CustomScheduler.this.getNextSchedule();
                    Throwable th = null;
                    this.lock.lock();
                    try {
                        if (this.currentFuture == null || !this.currentFuture.isCancelled()) {
                            this.currentFuture = this.executor.schedule(this, nextSchedule.delay, nextSchedule.unit);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    this.lock.unlock();
                    if (th != null) {
                        this.service.notifyFailed(th);
                    }
                } catch (Throwable th3) {
                    this.service.notifyFailed(th3);
                }
            }

            public boolean cancel(boolean z) {
                this.lock.lock();
                try {
                    return this.currentFuture.cancel(z);
                } finally {
                    this.lock.unlock();
                }
            }

            public boolean isCancelled() {
                this.lock.lock();
                try {
                    return this.currentFuture.isCancelled();
                } finally {
                    this.lock.unlock();
                }
            }

            /* access modifiers changed from: protected */
            public Future<Void> delegate() {
                throw new UnsupportedOperationException("Only cancel and isCancelled is supported by this future");
            }
        }

        /* access modifiers changed from: package-private */
        public final Future<?> schedule(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
            ReschedulableCallable reschedulableCallable = new ReschedulableCallable(abstractService, scheduledExecutorService, runnable);
            reschedulableCallable.reschedule();
            return reschedulableCallable;
        }

        protected static final class Schedule {
            /* access modifiers changed from: private */
            public final long delay;
            /* access modifiers changed from: private */
            public final TimeUnit unit;

            public Schedule(long j, TimeUnit timeUnit) {
                this.delay = j;
                this.unit = (TimeUnit) Preconditions.checkNotNull(timeUnit);
            }
        }
    }
}
