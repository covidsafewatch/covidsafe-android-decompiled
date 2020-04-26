package io.reactivex;

public interface MaybeConverter<T, R> {
    R apply(Maybe<T> maybe);
}
