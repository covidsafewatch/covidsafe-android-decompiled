package io.reactivex;

import io.reactivex.disposables.Disposable;

public interface CompletableObserver {
    void onComplete();

    void onError(Throwable th);

    void onSubscribe(Disposable disposable);
}
