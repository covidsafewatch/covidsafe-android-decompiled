package io.reactivex.internal.fuseable;

import org.reactivestreams.Publisher;

public interface HasUpstreamPublisher<T> {
    Publisher<T> source();
}
