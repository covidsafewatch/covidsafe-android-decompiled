package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class TimeoutFuture<V> extends TrustedFuture<V> {
    /* access modifiers changed from: private */
    @NullableDecl
    public ListenableFuture<V> delegateRef;
    /* access modifiers changed from: private */
    @NullableDecl
    public ScheduledFuture<?> timer;

    private static final class Fire<V> implements Runnable {
        @NullableDecl
        TimeoutFuture<V> timeoutFutureRef;

        Fire(TimeoutFuture<V> timeoutFuture) {
            this.timeoutFutureRef = timeoutFuture;
        }

        public void run() {
            String str;
            TimeoutFuture<V> timeoutFuture = this.timeoutFutureRef;
            if (timeoutFuture != null) {
                ListenableFuture access$000 = timeoutFuture.delegateRef;
                if (access$000 != null) {
                    this.timeoutFutureRef = null;
                    if (access$000.isDone()) {
                        timeoutFuture.setFuture(access$000);
                    } else {
                        try {
                            ScheduledFuture access$100 = timeoutFuture.timer;
                            timeoutFuture.timer = null;
                            str = "Timed out";
                            if (access$100 != null) {
                                long abs = Math.abs(access$100.getDelay(TimeUnit.MILLISECONDS));
                                if (abs > 10) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(str);
                                    sb.append(" (timeout delayed by ");
                                    sb.append(abs);
                                    sb.append(" ms after scheduled time)");
                                    str = sb.toString();
                                }
                            }
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(str);
                            sb2.append(": ");
                            sb2.append(access$000);
                            timeoutFuture.setException(new TimeoutFutureException(sb2.toString()));
                            access$000.cancel(true);
                        } catch (Throwable th) {
                            access$000.cancel(true);
                            throw th;
                        }
                    }
                }
            }
        }
    }

    private static final class TimeoutFutureException extends TimeoutException {
        private TimeoutFutureException(String str) {
            super(str);
        }

        public synchronized Throwable fillInStackTrace() {
            setStackTrace(new StackTraceElement[0]);
            return this;
        }
    }

    static <V> ListenableFuture<V> create(ListenableFuture<V> listenableFuture, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        TimeoutFuture timeoutFuture = new TimeoutFuture(listenableFuture);
        Fire fire = new Fire(timeoutFuture);
        timeoutFuture.timer = scheduledExecutorService.schedule(fire, j, timeUnit);
        listenableFuture.addListener(fire, MoreExecutors.directExecutor());
        return timeoutFuture;
    }

    private TimeoutFuture(ListenableFuture<V> listenableFuture) {
        this.delegateRef = (ListenableFuture) Preconditions.checkNotNull(listenableFuture);
    }

    /* access modifiers changed from: protected */
    public String pendingToString() {
        ListenableFuture<V> listenableFuture = this.delegateRef;
        ScheduledFuture<?> scheduledFuture = this.timer;
        if (listenableFuture == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("inputFuture=[");
        sb.append(listenableFuture);
        sb.append("]");
        String sb2 = sb.toString();
        if (scheduledFuture != null) {
            long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
            if (delay > 0) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(sb2);
                sb3.append(", remaining delay=[");
                sb3.append(delay);
                sb3.append(" ms]");
                sb2 = sb3.toString();
            }
        }
        return sb2;
    }

    /* access modifiers changed from: protected */
    public void afterDone() {
        maybePropagateCancellationTo(this.delegateRef);
        ScheduledFuture<?> scheduledFuture = this.timer;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.delegateRef = null;
        this.timer = null;
    }
}
