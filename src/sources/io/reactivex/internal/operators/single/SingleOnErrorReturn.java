package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;

public final class SingleOnErrorReturn<T> extends Single<T> {
    final SingleSource<? extends T> source;
    final T value;
    final Function<? super Throwable, ? extends T> valueSupplier;

    public SingleOnErrorReturn(SingleSource<? extends T> singleSource, Function<? super Throwable, ? extends T> function, T t) {
        this.source = singleSource;
        this.valueSupplier = function;
        this.value = t;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe(new OnErrorReturn(singleObserver));
    }

    final class OnErrorReturn implements SingleObserver<T> {
        private final SingleObserver<? super T> observer;

        OnErrorReturn(SingleObserver<? super T> singleObserver) {
            this.observer = singleObserver;
        }

        public void onError(Throwable th) {
            T t;
            if (SingleOnErrorReturn.this.valueSupplier != null) {
                try {
                    t = SingleOnErrorReturn.this.valueSupplier.apply(th);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.observer.onError(new CompositeException(th, th2));
                    return;
                }
            } else {
                t = SingleOnErrorReturn.this.value;
            }
            if (t == null) {
                NullPointerException nullPointerException = new NullPointerException("Value supplied was null");
                nullPointerException.initCause(th);
                this.observer.onError(nullPointerException);
                return;
            }
            this.observer.onSuccess(t);
        }

        public void onSubscribe(Disposable disposable) {
            this.observer.onSubscribe(disposable);
        }

        public void onSuccess(T t) {
            this.observer.onSuccess(t);
        }
    }
}
