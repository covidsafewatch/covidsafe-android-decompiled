package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import java.util.concurrent.Callable;

public final class CompletableToSingle<T> extends Single<T> {
    final T completionValue;
    final Callable<? extends T> completionValueSupplier;
    final CompletableSource source;

    public CompletableToSingle(CompletableSource completableSource, Callable<? extends T> callable, T t) {
        this.source = completableSource;
        this.completionValue = t;
        this.completionValueSupplier = callable;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe(new ToSingle(singleObserver));
    }

    final class ToSingle implements CompletableObserver {
        private final SingleObserver<? super T> observer;

        ToSingle(SingleObserver<? super T> singleObserver) {
            this.observer = singleObserver;
        }

        public void onComplete() {
            T t;
            if (CompletableToSingle.this.completionValueSupplier != null) {
                try {
                    t = CompletableToSingle.this.completionValueSupplier.call();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.observer.onError(th);
                    return;
                }
            } else {
                t = CompletableToSingle.this.completionValue;
            }
            if (t == null) {
                this.observer.onError(new NullPointerException("The value supplied is null"));
            } else {
                this.observer.onSuccess(t);
            }
        }

        public void onError(Throwable th) {
            this.observer.onError(th);
        }

        public void onSubscribe(Disposable disposable) {
            this.observer.onSubscribe(disposable);
        }
    }
}
