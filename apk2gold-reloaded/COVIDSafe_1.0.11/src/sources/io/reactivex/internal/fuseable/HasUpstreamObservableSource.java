package io.reactivex.internal.fuseable;

import io.reactivex.ObservableSource;

public interface HasUpstreamObservableSource<T> {
    ObservableSource<T> source();
}
