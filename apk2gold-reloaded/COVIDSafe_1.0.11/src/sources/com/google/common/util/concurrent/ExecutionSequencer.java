package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

public final class ExecutionSequencer {
    private final AtomicReference<ListenableFuture<Object>> ref = new AtomicReference<>(Futures.immediateFuture(null));

    enum RunningState {
        NOT_RUN,
        CANCELLED,
        STARTED
    }

    private ExecutionSequencer() {
    }

    public static ExecutionSequencer create() {
        return new ExecutionSequencer();
    }

    public <T> ListenableFuture<T> submit(final Callable<T> callable, Executor executor) {
        Preconditions.checkNotNull(callable);
        return submitAsync(new AsyncCallable<T>() {
            public ListenableFuture<T> call() throws Exception {
                return Futures.immediateFuture(callable.call());
            }

            public String toString() {
                return callable.toString();
            }
        }, executor);
    }

    public <T> ListenableFuture<T> submitAsync(final AsyncCallable<T> asyncCallable, final Executor executor) {
        Preconditions.checkNotNull(asyncCallable);
        final AtomicReference atomicReference = new AtomicReference(RunningState.NOT_RUN);
        AnonymousClass2 r0 = new AsyncCallable<T>() {
            public ListenableFuture<T> call() throws Exception {
                if (!atomicReference.compareAndSet(RunningState.NOT_RUN, RunningState.STARTED)) {
                    return Futures.immediateCancelledFuture();
                }
                return asyncCallable.call();
            }

            public String toString() {
                return asyncCallable.toString();
            }
        };
        final SettableFuture create = SettableFuture.create();
        final ListenableFuture listenableFuture = (ListenableFuture) this.ref.getAndSet(create);
        ListenableFuture submitAsync = Futures.submitAsync(r0, new Executor() {
            public void execute(Runnable runnable) {
                listenableFuture.addListener(runnable, executor);
            }
        });
        ListenableFuture<T> nonCancellationPropagating = Futures.nonCancellationPropagating(submitAsync);
        final ListenableFuture listenableFuture2 = submitAsync;
        final ListenableFuture<T> listenableFuture3 = nonCancellationPropagating;
        AnonymousClass4 r02 = new Runnable() {
            public void run() {
                if (listenableFuture2.isDone() || (listenableFuture3.isCancelled() && atomicReference.compareAndSet(RunningState.NOT_RUN, RunningState.CANCELLED))) {
                    create.setFuture(listenableFuture);
                }
            }
        };
        nonCancellationPropagating.addListener(r02, MoreExecutors.directExecutor());
        submitAsync.addListener(r02, MoreExecutors.directExecutor());
        return nonCancellationPropagating;
    }
}
