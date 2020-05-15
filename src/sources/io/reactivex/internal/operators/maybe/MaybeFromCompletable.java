package io.reactivex.internal.operators.maybe;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamCompletableSource;

public final class MaybeFromCompletable<T> extends Maybe<T> implements HasUpstreamCompletableSource {
    final CompletableSource source;

    public MaybeFromCompletable(CompletableSource completableSource) {
        this.source = completableSource;
    }

    public CompletableSource source() {
        return this.source;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new FromCompletableObserver(maybeObserver));
    }

    static final class FromCompletableObserver<T> implements CompletableObserver, Disposable {
        final MaybeObserver<? super T> downstream;
        Disposable upstream;

        FromCompletableObserver(MaybeObserver<? super T> maybeObserver) {
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

        public void onComplete() {
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onComplete();
        }

        public void onError(Throwable th) {
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onError(th);
        }
    }
}
