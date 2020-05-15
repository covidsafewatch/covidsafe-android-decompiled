package io.reactivex.internal.util;

import io.reactivex.CompletableObserver;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public enum EmptyComponent implements FlowableSubscriber<Object>, Observer<Object>, MaybeObserver<Object>, SingleObserver<Object>, CompletableObserver, Subscription, Disposable {
    INSTANCE;

    public void cancel() {
    }

    public void dispose() {
    }

    public boolean isDisposed() {
        return true;
    }

    public void onComplete() {
    }

    public void onNext(Object obj) {
    }

    public void onSuccess(Object obj) {
    }

    public void request(long j) {
    }

    public static <T> Subscriber<T> asSubscriber() {
        return INSTANCE;
    }

    public static <T> Observer<T> asObserver() {
        return INSTANCE;
    }

    public void onSubscribe(Disposable disposable) {
        disposable.dispose();
    }

    public void onSubscribe(Subscription subscription) {
        subscription.cancel();
    }

    public void onError(Throwable th) {
        RxJavaPlugins.onError(th);
    }
}
