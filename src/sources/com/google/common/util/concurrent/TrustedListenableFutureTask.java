package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FluentFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

class TrustedListenableFutureTask<V> extends FluentFuture.TrustedFuture<V> implements RunnableFuture<V> {
    private volatile InterruptibleTask<?> task;

    static <V> TrustedListenableFutureTask<V> create(AsyncCallable<V> asyncCallable) {
        return new TrustedListenableFutureTask<>(asyncCallable);
    }

    static <V> TrustedListenableFutureTask<V> create(Callable<V> callable) {
        return new TrustedListenableFutureTask<>(callable);
    }

    static <V> TrustedListenableFutureTask<V> create(Runnable runnable, @NullableDecl V v) {
        return new TrustedListenableFutureTask<>(Executors.callable(runnable, v));
    }

    TrustedListenableFutureTask(Callable<V> callable) {
        this.task = new TrustedFutureInterruptibleTask(callable);
    }

    TrustedListenableFutureTask(AsyncCallable<V> asyncCallable) {
        this.task = new TrustedFutureInterruptibleAsyncTask(asyncCallable);
    }

    public void run() {
        InterruptibleTask<?> interruptibleTask = this.task;
        if (interruptibleTask != null) {
            interruptibleTask.run();
        }
        this.task = null;
    }

    /* access modifiers changed from: protected */
    public void afterDone() {
        InterruptibleTask<?> interruptibleTask;
        super.afterDone();
        if (wasInterrupted() && (interruptibleTask = this.task) != null) {
            interruptibleTask.interruptTask();
        }
        this.task = null;
    }

    /* access modifiers changed from: protected */
    public String pendingToString() {
        InterruptibleTask<?> interruptibleTask = this.task;
        if (interruptibleTask == null) {
            return super.pendingToString();
        }
        return "task=[" + interruptibleTask + "]";
    }

    private final class TrustedFutureInterruptibleTask extends InterruptibleTask<V> {
        private final Callable<V> callable;

        TrustedFutureInterruptibleTask(Callable<V> callable2) {
            this.callable = (Callable) Preconditions.checkNotNull(callable2);
        }

        /* access modifiers changed from: package-private */
        public final boolean isDone() {
            return TrustedListenableFutureTask.this.isDone();
        }

        /* access modifiers changed from: package-private */
        public V runInterruptibly() throws Exception {
            return this.callable.call();
        }

        /* access modifiers changed from: package-private */
        public void afterRanInterruptibly(V v, Throwable th) {
            if (th == null) {
                TrustedListenableFutureTask.this.set(v);
            } else {
                TrustedListenableFutureTask.this.setException(th);
            }
        }

        /* access modifiers changed from: package-private */
        public String toPendingString() {
            return this.callable.toString();
        }
    }

    private final class TrustedFutureInterruptibleAsyncTask extends InterruptibleTask<ListenableFuture<V>> {
        private final AsyncCallable<V> callable;

        TrustedFutureInterruptibleAsyncTask(AsyncCallable<V> asyncCallable) {
            this.callable = (AsyncCallable) Preconditions.checkNotNull(asyncCallable);
        }

        /* access modifiers changed from: package-private */
        public final boolean isDone() {
            return TrustedListenableFutureTask.this.isDone();
        }

        /* access modifiers changed from: package-private */
        public ListenableFuture<V> runInterruptibly() throws Exception {
            return (ListenableFuture) Preconditions.checkNotNull(this.callable.call(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", (Object) this.callable);
        }

        /* access modifiers changed from: package-private */
        public void afterRanInterruptibly(ListenableFuture<V> listenableFuture, Throwable th) {
            if (th == null) {
                TrustedListenableFutureTask.this.setFuture(listenableFuture);
            } else {
                TrustedListenableFutureTask.this.setException(th);
            }
        }

        /* access modifiers changed from: package-private */
        public String toPendingString() {
            return this.callable.toString();
        }
    }
}
