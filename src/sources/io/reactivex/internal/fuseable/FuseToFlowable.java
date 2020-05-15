package io.reactivex.internal.fuseable;

import io.reactivex.Flowable;

public interface FuseToFlowable<T> {
    Flowable<T> fuseToFlowable();
}
