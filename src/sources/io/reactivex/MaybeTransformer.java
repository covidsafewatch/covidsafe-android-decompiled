package io.reactivex;

public interface MaybeTransformer<Upstream, Downstream> {
    MaybeSource<Downstream> apply(Maybe<Upstream> maybe);
}
