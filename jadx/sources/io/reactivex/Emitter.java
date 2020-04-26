package io.reactivex;

public interface Emitter<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);
}
