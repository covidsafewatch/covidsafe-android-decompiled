package io.reactivex;

public interface CompletableConverter<R> {
    R apply(Completable completable);
}
