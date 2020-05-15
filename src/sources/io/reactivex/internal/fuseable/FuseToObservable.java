package io.reactivex.internal.fuseable;

import io.reactivex.Observable;

public interface FuseToObservable<T> {
    Observable<T> fuseToObservable();
}
