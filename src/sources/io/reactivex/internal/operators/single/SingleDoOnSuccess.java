package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;

public final class SingleDoOnSuccess<T> extends Single<T> {
    final Consumer<? super T> onSuccess;
    final SingleSource<T> source;

    public SingleDoOnSuccess(SingleSource<T> singleSource, Consumer<? super T> consumer) {
        this.source = singleSource;
        this.onSuccess = consumer;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe(new DoOnSuccess(singleObserver));
    }

    final class DoOnSuccess implements SingleObserver<T> {
        final SingleObserver<? super T> downstream;

        DoOnSuccess(SingleObserver<? super T> singleObserver) {
            this.downstream = singleObserver;
        }

        public void onSubscribe(Disposable disposable) {
            this.downstream.onSubscribe(disposable);
        }

        public void onSuccess(T t) {
            try {
                SingleDoOnSuccess.this.onSuccess.accept(t);
                this.downstream.onSuccess(t);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.downstream.onError(th);
            }
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
        }
    }
}
