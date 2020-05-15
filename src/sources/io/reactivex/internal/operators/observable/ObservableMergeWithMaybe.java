package io.reactivex.internal.operators.observable;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableMergeWithMaybe<T> extends AbstractObservableWithUpstream<T, T> {
    final MaybeSource<? extends T> other;

    public ObservableMergeWithMaybe(Observable<T> observable, MaybeSource<? extends T> maybeSource) {
        super(observable);
        this.other = maybeSource;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(observer);
        observer.onSubscribe(mergeWithObserver);
        this.source.subscribe(mergeWithObserver);
        this.other.subscribe(mergeWithObserver.otherObserver);
    }

    static final class MergeWithObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        static final int OTHER_STATE_CONSUMED_OR_EMPTY = 2;
        static final int OTHER_STATE_HAS_VALUE = 1;
        private static final long serialVersionUID = -4592979584110982903L;
        volatile boolean disposed;
        final Observer<? super T> downstream;
        final AtomicThrowable error = new AtomicThrowable();
        final AtomicReference<Disposable> mainDisposable = new AtomicReference<>();
        volatile boolean mainDone;
        final OtherObserver<T> otherObserver = new OtherObserver<>(this);
        volatile int otherState;
        volatile SimplePlainQueue<T> queue;
        T singleItem;

        MergeWithObserver(Observer<? super T> observer) {
            this.downstream = observer;
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.mainDisposable, disposable);
        }

        public void onNext(T t) {
            if (compareAndSet(0, 1)) {
                this.downstream.onNext(t);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                getOrCreateQueue().offer(t);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        public void onError(Throwable th) {
            if (this.error.addThrowable(th)) {
                DisposableHelper.dispose(this.mainDisposable);
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public void onComplete() {
            this.mainDone = true;
            drain();
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.mainDisposable.get());
        }

        public void dispose() {
            this.disposed = true;
            DisposableHelper.dispose(this.mainDisposable);
            DisposableHelper.dispose(this.otherObserver);
            if (getAndIncrement() == 0) {
                this.queue = null;
                this.singleItem = null;
            }
        }

        /* access modifiers changed from: package-private */
        public void otherSuccess(T t) {
            if (compareAndSet(0, 1)) {
                this.downstream.onNext(t);
                this.otherState = 2;
            } else {
                this.singleItem = t;
                this.otherState = 1;
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        /* access modifiers changed from: package-private */
        public void otherError(Throwable th) {
            if (this.error.addThrowable(th)) {
                DisposableHelper.dispose(this.mainDisposable);
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        /* access modifiers changed from: package-private */
        public void otherComplete() {
            this.otherState = 2;
            drain();
        }

        /* access modifiers changed from: package-private */
        public SimplePlainQueue<T> getOrCreateQueue() {
            SimplePlainQueue<T> simplePlainQueue = this.queue;
            if (simplePlainQueue != null) {
                return simplePlainQueue;
            }
            SpscLinkedArrayQueue spscLinkedArrayQueue = new SpscLinkedArrayQueue(Observable.bufferSize());
            this.queue = spscLinkedArrayQueue;
            return spscLinkedArrayQueue;
        }

        /* access modifiers changed from: package-private */
        public void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* access modifiers changed from: package-private */
        public void drainLoop() {
            Observer<? super T> observer = this.downstream;
            int i = 1;
            while (!this.disposed) {
                if (this.error.get() != null) {
                    this.singleItem = null;
                    this.queue = null;
                    observer.onError(this.error.terminate());
                    return;
                }
                int i2 = this.otherState;
                if (i2 == 1) {
                    T t = this.singleItem;
                    this.singleItem = null;
                    this.otherState = 2;
                    observer.onNext(t);
                    i2 = 2;
                }
                boolean z = this.mainDone;
                SimplePlainQueue<T> simplePlainQueue = this.queue;
                T poll = simplePlainQueue != null ? simplePlainQueue.poll() : null;
                boolean z2 = poll == null;
                if (z && z2 && i2 == 2) {
                    this.queue = null;
                    observer.onComplete();
                    return;
                } else if (z2) {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    observer.onNext(poll);
                }
            }
            this.singleItem = null;
            this.queue = null;
        }

        static final class OtherObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
            private static final long serialVersionUID = -2935427570954647017L;
            final MergeWithObserver<T> parent;

            OtherObserver(MergeWithObserver<T> mergeWithObserver) {
                this.parent = mergeWithObserver;
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public void onSuccess(T t) {
                this.parent.otherSuccess(t);
            }

            public void onError(Throwable th) {
                this.parent.otherError(th);
            }

            public void onComplete() {
                this.parent.otherComplete();
            }
        }
    }
}
