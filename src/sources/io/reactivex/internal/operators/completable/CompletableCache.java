package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableCache extends Completable implements CompletableObserver {
    static final InnerCompletableCache[] EMPTY = new InnerCompletableCache[0];
    static final InnerCompletableCache[] TERMINATED = new InnerCompletableCache[0];
    Throwable error;
    final AtomicReference<InnerCompletableCache[]> observers = new AtomicReference<>(EMPTY);
    final AtomicBoolean once = new AtomicBoolean();
    final CompletableSource source;

    public void onSubscribe(Disposable disposable) {
    }

    public CompletableCache(CompletableSource completableSource) {
        this.source = completableSource;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        InnerCompletableCache innerCompletableCache = new InnerCompletableCache(completableObserver);
        completableObserver.onSubscribe(innerCompletableCache);
        if (add(innerCompletableCache)) {
            if (innerCompletableCache.isDisposed()) {
                remove(innerCompletableCache);
            }
            if (this.once.compareAndSet(false, true)) {
                this.source.subscribe(this);
                return;
            }
            return;
        }
        Throwable th = this.error;
        if (th != null) {
            completableObserver.onError(th);
        } else {
            completableObserver.onComplete();
        }
    }

    public void onError(Throwable th) {
        this.error = th;
        for (InnerCompletableCache innerCompletableCache : this.observers.getAndSet(TERMINATED)) {
            if (!innerCompletableCache.get()) {
                innerCompletableCache.downstream.onError(th);
            }
        }
    }

    public void onComplete() {
        for (InnerCompletableCache innerCompletableCache : this.observers.getAndSet(TERMINATED)) {
            if (!innerCompletableCache.get()) {
                innerCompletableCache.downstream.onComplete();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean add(InnerCompletableCache innerCompletableCache) {
        InnerCompletableCache[] innerCompletableCacheArr;
        InnerCompletableCache[] innerCompletableCacheArr2;
        do {
            innerCompletableCacheArr = this.observers.get();
            if (innerCompletableCacheArr == TERMINATED) {
                return false;
            }
            int length = innerCompletableCacheArr.length;
            innerCompletableCacheArr2 = new InnerCompletableCache[(length + 1)];
            System.arraycopy(innerCompletableCacheArr, 0, innerCompletableCacheArr2, 0, length);
            innerCompletableCacheArr2[length] = innerCompletableCache;
        } while (!this.observers.compareAndSet(innerCompletableCacheArr, innerCompletableCacheArr2));
        return true;
    }

    /* access modifiers changed from: package-private */
    public void remove(InnerCompletableCache innerCompletableCache) {
        InnerCompletableCache[] innerCompletableCacheArr;
        InnerCompletableCache[] innerCompletableCacheArr2;
        do {
            innerCompletableCacheArr = this.observers.get();
            int length = innerCompletableCacheArr.length;
            if (length != 0) {
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (innerCompletableCacheArr[i2] == innerCompletableCache) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        innerCompletableCacheArr2 = EMPTY;
                    } else {
                        InnerCompletableCache[] innerCompletableCacheArr3 = new InnerCompletableCache[(length - 1)];
                        System.arraycopy(innerCompletableCacheArr, 0, innerCompletableCacheArr3, 0, i);
                        System.arraycopy(innerCompletableCacheArr, i + 1, innerCompletableCacheArr3, i, (length - i) - 1);
                        innerCompletableCacheArr2 = innerCompletableCacheArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.observers.compareAndSet(innerCompletableCacheArr, innerCompletableCacheArr2));
    }

    final class InnerCompletableCache extends AtomicBoolean implements Disposable {
        private static final long serialVersionUID = 8943152917179642732L;
        final CompletableObserver downstream;

        InnerCompletableCache(CompletableObserver completableObserver) {
            this.downstream = completableObserver;
        }

        public boolean isDisposed() {
            return get();
        }

        public void dispose() {
            if (compareAndSet(false, true)) {
                CompletableCache.this.remove(this);
            }
        }
    }
}
