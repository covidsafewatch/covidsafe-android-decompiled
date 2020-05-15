package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableMergeArray extends Completable {
    final CompletableSource[] sources;

    public CompletableMergeArray(CompletableSource[] completableSourceArr) {
        this.sources = completableSourceArr;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        InnerCompletableObserver innerCompletableObserver = new InnerCompletableObserver(completableObserver, new AtomicBoolean(), compositeDisposable, this.sources.length + 1);
        completableObserver.onSubscribe(compositeDisposable);
        CompletableSource[] completableSourceArr = this.sources;
        int length = completableSourceArr.length;
        int i = 0;
        while (i < length) {
            CompletableSource completableSource = completableSourceArr[i];
            if (!compositeDisposable.isDisposed()) {
                if (completableSource == null) {
                    compositeDisposable.dispose();
                    innerCompletableObserver.onError(new NullPointerException("A completable source is null"));
                    return;
                }
                completableSource.subscribe(innerCompletableObserver);
                i++;
            } else {
                return;
            }
        }
        innerCompletableObserver.onComplete();
    }

    static final class InnerCompletableObserver extends AtomicInteger implements CompletableObserver {
        private static final long serialVersionUID = -8360547806504310570L;
        final CompletableObserver downstream;
        final AtomicBoolean once;
        final CompositeDisposable set;

        InnerCompletableObserver(CompletableObserver completableObserver, AtomicBoolean atomicBoolean, CompositeDisposable compositeDisposable, int i) {
            this.downstream = completableObserver;
            this.once = atomicBoolean;
            this.set = compositeDisposable;
            lazySet(i);
        }

        public void onSubscribe(Disposable disposable) {
            this.set.add(disposable);
        }

        public void onError(Throwable th) {
            this.set.dispose();
            if (this.once.compareAndSet(false, true)) {
                this.downstream.onError(th);
            } else {
                RxJavaPlugins.onError(th);
            }
        }

        public void onComplete() {
            if (decrementAndGet() == 0 && this.once.compareAndSet(false, true)) {
                this.downstream.onComplete();
            }
        }
    }
}
