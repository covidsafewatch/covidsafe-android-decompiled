package io.reactivex;

import org.reactivestreams.Publisher;

public interface FlowableTransformer<Upstream, Downstream> {
    Publisher<Downstream> apply(Flowable<Upstream> flowable);
}
