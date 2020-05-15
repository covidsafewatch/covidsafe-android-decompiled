package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableCache<T> extends AbstractObservableWithUpstream<T, T> implements Observer<T> {
    static final CacheDisposable[] EMPTY = new CacheDisposable[0];
    static final CacheDisposable[] TERMINATED = new CacheDisposable[0];
    final int capacityHint;
    volatile boolean done;
    Throwable error;
    final Node<T> head;
    final AtomicReference<CacheDisposable<T>[]> observers;
    final AtomicBoolean once = new AtomicBoolean();
    volatile long size;
    Node<T> tail;
    int tailOffset;

    public void onSubscribe(Disposable disposable) {
    }

    public ObservableCache(Observable<T> observable, int i) {
        super(observable);
        this.capacityHint = i;
        Node<T> node = new Node<>(i);
        this.head = node;
        this.tail = node;
        this.observers = new AtomicReference<>(EMPTY);
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        CacheDisposable cacheDisposable = new CacheDisposable(observer, this);
        observer.onSubscribe(cacheDisposable);
        add(cacheDisposable);
        if (this.once.get() || !this.once.compareAndSet(false, true)) {
            replay(cacheDisposable);
        } else {
            this.source.subscribe(this);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isConnected() {
        return this.once.get();
    }

    /* access modifiers changed from: package-private */
    public boolean hasObservers() {
        return ((CacheDisposable[]) this.observers.get()).length != 0;
    }

    /* access modifiers changed from: package-private */
    public long cachedEventCount() {
        return this.size;
    }

    /* access modifiers changed from: package-private */
    public void add(CacheDisposable<T> cacheDisposable) {
        CacheDisposable[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.observers.get();
            if (cacheDisposableArr != TERMINATED) {
                int length = cacheDisposableArr.length;
                cacheDisposableArr2 = new CacheDisposable[(length + 1)];
                System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
                cacheDisposableArr2[length] = cacheDisposable;
            } else {
                return;
            }
        } while (!this.observers.compareAndSet(cacheDisposableArr, cacheDisposableArr2));
    }

    /* access modifiers changed from: package-private */
    public void remove(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.observers.get();
            int length = cacheDisposableArr.length;
            if (length != 0) {
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (cacheDisposableArr[i2] == cacheDisposable) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        cacheDisposableArr2 = EMPTY;
                    } else {
                        CacheDisposable[] cacheDisposableArr3 = new CacheDisposable[(length - 1)];
                        System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr3, 0, i);
                        System.arraycopy(cacheDisposableArr, i + 1, cacheDisposableArr3, i, (length - i) - 1);
                        cacheDisposableArr2 = cacheDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.observers.compareAndSet(cacheDisposableArr, cacheDisposableArr2));
    }

    /* access modifiers changed from: package-private */
    public void replay(CacheDisposable<T> cacheDisposable) {
        if (cacheDisposable.getAndIncrement() == 0) {
            long j = cacheDisposable.index;
            int i = cacheDisposable.offset;
            Node<T> node = cacheDisposable.node;
            Observer<? super T> observer = cacheDisposable.downstream;
            int i2 = this.capacityHint;
            int i3 = 1;
            while (!cacheDisposable.disposed) {
                boolean z = this.done;
                boolean z2 = this.size == j;
                if (z && z2) {
                    cacheDisposable.node = null;
                    Throwable th = this.error;
                    if (th != null) {
                        observer.onError(th);
                        return;
                    } else {
                        observer.onComplete();
                        return;
                    }
                } else if (!z2) {
                    if (i == i2) {
                        node = node.next;
                        i = 0;
                    }
                    observer.onNext(node.values[i]);
                    i++;
                    j++;
                } else {
                    cacheDisposable.index = j;
                    cacheDisposable.offset = i;
                    cacheDisposable.node = node;
                    i3 = cacheDisposable.addAndGet(-i3);
                    if (i3 == 0) {
                        return;
                    }
                }
            }
            cacheDisposable.node = null;
        }
    }

    public void onNext(T t) {
        int i = this.tailOffset;
        if (i == this.capacityHint) {
            Node<T> node = new Node<>(i);
            node.values[0] = t;
            this.tailOffset = 1;
            this.tail.next = node;
            this.tail = node;
        } else {
            this.tail.values[i] = t;
            this.tailOffset = i + 1;
        }
        this.size++;
        for (CacheDisposable replay : (CacheDisposable[]) this.observers.get()) {
            replay(replay);
        }
    }

    public void onError(Throwable th) {
        this.error = th;
        this.done = true;
        for (CacheDisposable replay : (CacheDisposable[]) this.observers.getAndSet(TERMINATED)) {
            replay(replay);
        }
    }

    public void onComplete() {
        this.done = true;
        for (CacheDisposable replay : (CacheDisposable[]) this.observers.getAndSet(TERMINATED)) {
            replay(replay);
        }
    }

    static final class CacheDisposable<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 6770240836423125754L;
        volatile boolean disposed;
        final Observer<? super T> downstream;
        long index;
        Node<T> node;
        int offset;
        final ObservableCache<T> parent;

        CacheDisposable(Observer<? super T> observer, ObservableCache<T> observableCache) {
            this.downstream = observer;
            this.parent = observableCache;
            this.node = observableCache.head;
        }

        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.parent.remove(this);
            }
        }

        public boolean isDisposed() {
            return this.disposed;
        }
    }

    static final class Node<T> {
        volatile Node<T> next;
        final T[] values;

        Node(int i) {
            this.values = (Object[]) new Object[i];
        }
    }
}
