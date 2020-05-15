package io.reactivex.internal.operators.observable;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class ObservableLastMaybe<T> extends Maybe<T> {
    final ObservableSource<T> source;

    public ObservableLastMaybe(ObservableSource<T> observableSource) {
        this.source = observableSource;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new LastObserver(maybeObserver));
    }

    static final class LastObserver<T> implements Observer<T>, Disposable {
        final MaybeObserver<? super T> downstream;
        T item;
        Disposable upstream;

        LastObserver(MaybeObserver<? super T> maybeObserver) {
            this.downstream = maybeObserver;
        }

        public void dispose() {
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.upstream == DisposableHelper.DISPOSED;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            this.item = t;
        }

        public void onError(Throwable th) {
            this.upstream = DisposableHelper.DISPOSED;
            this.item = null;
            this.downstream.onError(th);
        }

        public void onComplete() {
            this.upstream = DisposableHelper.DISPOSED;
            T t = this.item;
            if (t != null) {
                this.item = null;
                this.downstream.onSuccess(t);
                return;
            }
            this.downstream.onComplete();
        }
    }
}
