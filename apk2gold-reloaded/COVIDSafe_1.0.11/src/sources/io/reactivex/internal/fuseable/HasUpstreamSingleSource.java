package io.reactivex.internal.fuseable;

import io.reactivex.SingleSource;

public interface HasUpstreamSingleSource<T> {
    SingleSource<T> source();
}
