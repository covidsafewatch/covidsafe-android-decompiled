package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;

public final class SingleContains<T> extends Single<Boolean> {
    final BiPredicate<Object, Object> comparer;
    final SingleSource<T> source;
    final Object value;

    public SingleContains(SingleSource<T> singleSource, Object obj, BiPredicate<Object, Object> biPredicate) {
        this.source = singleSource;
        this.value = obj;
        this.comparer = biPredicate;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.source.subscribe(new ContainsSingleObserver(singleObserver));
    }

    final class ContainsSingleObserver implements SingleObserver<T> {
        private final SingleObserver<? super Boolean> downstream;

        ContainsSingleObserver(SingleObserver<? super Boolean> singleObserver) {
            this.downstream = singleObserver;
        }

        public void onSubscribe(Disposable disposable) {
            this.downstream.onSubscribe(disposable);
        }

        public void onSuccess(T t) {
            try {
                this.downstream.onSuccess(Boolean.valueOf(SingleContains.this.comparer.test(t, SingleContains.this.value)));
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
