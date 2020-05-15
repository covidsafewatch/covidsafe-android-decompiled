package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamSingleSource;

public final class MaybeFromSingle<T> extends Maybe<T> implements HasUpstreamSingleSource<T> {
    final SingleSource<T> source;

    public MaybeFromSingle(SingleSource<T> singleSource) {
        this.source = singleSource;
    }

    public SingleSource<T> source() {
        return this.source;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new FromSingleObserver(maybeObserver));
    }

    static final class FromSingleObserver<T> implements SingleObserver<T>, Disposable {
        final MaybeObserver<? super T> downstream;
        Disposable upstream;

        FromSingleObserver(MaybeObserver<? super T> maybeObserver) {
            this.downstream = maybeObserver;
        }

        public void dispose() {
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onSuccess(t);
        }

        public void onError(Throwable th) {
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onError(th);
        }
    }
}
