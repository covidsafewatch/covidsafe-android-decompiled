package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public final class AsyncSubject<T> extends Subject<T> {
    static final AsyncDisposable[] EMPTY = new AsyncDisposable[0];
    static final AsyncDisposable[] TERMINATED = new AsyncDisposable[0];
    Throwable error;
    final AtomicReference<AsyncDisposable<T>[]> subscribers = new AtomicReference<>(EMPTY);
    T value;

    @CheckReturnValue
    public static <T> AsyncSubject<T> create() {
        return new AsyncSubject<>();
    }

    AsyncSubject() {
    }

    public void onSubscribe(Disposable disposable) {
        if (this.subscribers.get() == TERMINATED) {
            disposable.dispose();
        }
    }

    public void onNext(T t) {
        ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.subscribers.get() != TERMINATED) {
            this.value = t;
        }
    }

    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        AsyncDisposable<T>[] asyncDisposableArr = this.subscribers.get();
        AsyncDisposable<T>[] asyncDisposableArr2 = TERMINATED;
        if (asyncDisposableArr == asyncDisposableArr2) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.value = null;
        this.error = th;
        for (AsyncDisposable onError : (AsyncDisposable[]) this.subscribers.getAndSet(asyncDisposableArr2)) {
            onError.onError(th);
        }
    }

    public void onComplete() {
        AsyncDisposable<T>[] asyncDisposableArr = this.subscribers.get();
        AsyncDisposable<T>[] asyncDisposableArr2 = TERMINATED;
        if (asyncDisposableArr != asyncDisposableArr2) {
            T t = this.value;
            AsyncDisposable[] asyncDisposableArr3 = (AsyncDisposable[]) this.subscribers.getAndSet(asyncDisposableArr2);
            int i = 0;
            if (t == null) {
                int length = asyncDisposableArr3.length;
                while (i < length) {
                    asyncDisposableArr3[i].onComplete();
                    i++;
                }
                return;
            }
            int length2 = asyncDisposableArr3.length;
            while (i < length2) {
                asyncDisposableArr3[i].complete(t);
                i++;
            }
        }
    }

    public boolean hasObservers() {
        return ((AsyncDisposable[]) this.subscribers.get()).length != 0;
    }

    public boolean hasThrowable() {
        return this.subscribers.get() == TERMINATED && this.error != null;
    }

    public boolean hasComplete() {
        return this.subscribers.get() == TERMINATED && this.error == null;
    }

    public Throwable getThrowable() {
        if (this.subscribers.get() == TERMINATED) {
            return this.error;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        AsyncDisposable asyncDisposable = new AsyncDisposable(observer, this);
        observer.onSubscribe(asyncDisposable);
        if (!add(asyncDisposable)) {
            Throwable th = this.error;
            if (th != null) {
                observer.onError(th);
                return;
            }
            T t = this.value;
            if (t != null) {
                asyncDisposable.complete(t);
            } else {
                asyncDisposable.onComplete();
            }
        } else if (asyncDisposable.isDisposed()) {
            remove(asyncDisposable);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean add(AsyncDisposable<T> asyncDisposable) {
        AsyncDisposable[] asyncDisposableArr;
        AsyncDisposable[] asyncDisposableArr2;
        do {
            asyncDisposableArr = (AsyncDisposable[]) this.subscribers.get();
            if (asyncDisposableArr == TERMINATED) {
                return false;
            }
            int length = asyncDisposableArr.length;
            asyncDisposableArr2 = new AsyncDisposable[(length + 1)];
            System.arraycopy(asyncDisposableArr, 0, asyncDisposableArr2, 0, length);
            asyncDisposableArr2[length] = asyncDisposable;
        } while (!this.subscribers.compareAndSet(asyncDisposableArr, asyncDisposableArr2));
        return true;
    }

    /* access modifiers changed from: package-private */
    public void remove(AsyncDisposable<T> asyncDisposable) {
        AsyncDisposable<T>[] asyncDisposableArr;
        AsyncDisposable[] asyncDisposableArr2;
        do {
            asyncDisposableArr = (AsyncDisposable[]) this.subscribers.get();
            int length = asyncDisposableArr.length;
            if (length != 0) {
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (asyncDisposableArr[i2] == asyncDisposable) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        asyncDisposableArr2 = EMPTY;
                    } else {
                        AsyncDisposable[] asyncDisposableArr3 = new AsyncDisposable[(length - 1)];
                        System.arraycopy(asyncDisposableArr, 0, asyncDisposableArr3, 0, i);
                        System.arraycopy(asyncDisposableArr, i + 1, asyncDisposableArr3, i, (length - i) - 1);
                        asyncDisposableArr2 = asyncDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.subscribers.compareAndSet(asyncDisposableArr, asyncDisposableArr2));
    }

    public boolean hasValue() {
        return this.subscribers.get() == TERMINATED && this.value != null;
    }

    public T getValue() {
        if (this.subscribers.get() == TERMINATED) {
            return this.value;
        }
        return null;
    }

    @Deprecated
    public Object[] getValues() {
        Object value2 = getValue();
        if (value2 == null) {
            return new Object[0];
        }
        return new Object[]{value2};
    }

    @Deprecated
    public T[] getValues(T[] tArr) {
        T value2 = getValue();
        if (value2 == null) {
            if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }
        if (tArr.length == 0) {
            tArr = Arrays.copyOf(tArr, 1);
        }
        tArr[0] = value2;
        if (tArr.length != 1) {
            tArr[1] = null;
        }
        return tArr;
    }

    static final class AsyncDisposable<T> extends DeferredScalarDisposable<T> {
        private static final long serialVersionUID = 5629876084736248016L;
        final AsyncSubject<T> parent;

        AsyncDisposable(Observer<? super T> observer, AsyncSubject<T> asyncSubject) {
            super(observer);
            this.parent = asyncSubject;
        }

        public void dispose() {
            if (super.tryDispose()) {
                this.parent.remove(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void onComplete() {
            if (!isDisposed()) {
                this.downstream.onComplete();
            }
        }

        /* access modifiers changed from: package-private */
        public void onError(Throwable th) {
            if (isDisposed()) {
                RxJavaPlugins.onError(th);
            } else {
                this.downstream.onError(th);
            }
        }
    }
}
