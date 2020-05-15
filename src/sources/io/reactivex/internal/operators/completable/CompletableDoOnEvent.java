package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;

public final class CompletableDoOnEvent extends Completable {
    final Consumer<? super Throwable> onEvent;
    final CompletableSource source;

    public CompletableDoOnEvent(CompletableSource completableSource, Consumer<? super Throwable> consumer) {
        this.source = completableSource;
        this.onEvent = consumer;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(new DoOnEvent(completableObserver));
    }

    final class DoOnEvent implements CompletableObserver {
        private final CompletableObserver observer;

        DoOnEvent(CompletableObserver completableObserver) {
            this.observer = completableObserver;
        }

        public void onComplete() {
            try {
                CompletableDoOnEvent.this.onEvent.accept(null);
                this.observer.onComplete();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.observer.onError(th);
            }
        }

        public void onError(Throwable th) {
            try {
                CompletableDoOnEvent.this.onEvent.accept(th);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                th = new CompositeException(th, th2);
            }
            this.observer.onError(th);
        }

        public void onSubscribe(Disposable disposable) {
            this.observer.onSubscribe(disposable);
        }
    }
}
