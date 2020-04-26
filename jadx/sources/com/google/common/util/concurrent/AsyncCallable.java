package com.google.common.util.concurrent;

public interface AsyncCallable<V> {
    ListenableFuture<V> call() throws Exception;
}
