package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.Notification;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class MaterializeSingleObserver<T> implements SingleObserver<T>, MaybeObserver<T>, CompletableObserver, Disposable {
    final SingleObserver<? super Notification<T>> downstream;
    Disposable upstream;

    public MaterializeSingleObserver(SingleObserver<? super Notification<T>> singleObserver) {
        this.downstream = singleObserver;
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.upstream, disposable)) {
            this.upstream = disposable;
            this.downstream.onSubscribe(this);
        }
    }

    public void onComplete() {
        this.downstream.onSuccess(Notification.createOnComplete());
    }

    public void onSuccess(T t) {
        this.downstream.onSuccess(Notification.createOnNext(t));
    }

    public void onError(Throwable th) {
        this.downstream.onSuccess(Notification.createOnError(th));
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void dispose() {
        this.upstream.dispose();
    }
}
