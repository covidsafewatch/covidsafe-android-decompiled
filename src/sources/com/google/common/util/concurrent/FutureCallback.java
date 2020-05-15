package com.google.common.util.concurrent;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public interface FutureCallback<V> {
    void onFailure(Throwable th);

    void onSuccess(@NullableDecl V v);
}
