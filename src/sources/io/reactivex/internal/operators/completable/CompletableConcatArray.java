package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableConcatArray extends Completable {
    final CompletableSource[] sources;

    public CompletableConcatArray(CompletableSource[] completableSourceArr) {
        this.sources = completableSourceArr;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        ConcatInnerObserver concatInnerObserver = new ConcatInnerObserver(completableObserver, this.sources);
        completableObserver.onSubscribe(concatInnerObserver.sd);
        concatInnerObserver.next();
    }

    static final class ConcatInnerObserver extends AtomicInteger implements CompletableObserver {
        private static final long serialVersionUID = -7965400327305809232L;
        final CompletableObserver downstream;
        int index;
        final SequentialDisposable sd = new SequentialDisposable();
        final CompletableSource[] sources;

        ConcatInnerObserver(CompletableObserver completableObserver, CompletableSource[] completableSourceArr) {
            this.downstream = completableObserver;
            this.sources = completableSourceArr;
        }

        public void onSubscribe(Disposable disposable) {
            this.sd.replace(disposable);
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public void onComplete() {
            next();
        }

        /* access modifiers changed from: package-private */
        public void next() {
            if (!this.sd.isDisposed() && getAndIncrement() == 0) {
                CompletableSource[] completableSourceArr = this.sources;
                while (!this.sd.isDisposed()) {
                    int i = this.index;
                    this.index = i + 1;
                    if (i == completableSourceArr.length) {
                        this.downstream.onComplete();
                        return;
                    }
                    completableSourceArr[i].subscribe(this);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }
    }
}
