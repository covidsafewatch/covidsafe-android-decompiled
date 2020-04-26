package io.reactivex;

import io.reactivex.disposables.Disposable;

public interface SingleObserver<T> {
    void onError(Throwable th);

    void onSubscribe(Disposable disposable);

    void onSuccess(T t);
}
