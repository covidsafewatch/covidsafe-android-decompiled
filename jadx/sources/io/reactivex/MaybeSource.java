package io.reactivex;

public interface MaybeSource<T> {
    void subscribe(MaybeObserver<? super T> maybeObserver);
}
