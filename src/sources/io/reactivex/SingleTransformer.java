package io.reactivex;

public interface SingleTransformer<Upstream, Downstream> {
    SingleSource<Downstream> apply(Single<Upstream> single);
}
