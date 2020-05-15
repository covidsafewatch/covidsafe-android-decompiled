package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableDebounce<T, U> extends AbstractObservableWithUpstream<T, T> {
    final Function<? super T, ? extends ObservableSource<U>> debounceSelector;

    public ObservableDebounce(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<U>> function) {
        super(observableSource);
        this.debounceSelector = function;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new DebounceObserver(new SerializedObserver(observer), this.debounceSelector));
    }

    static final class DebounceObserver<T, U> implements Observer<T>, Disposable {
        final Function<? super T, ? extends ObservableSource<U>> debounceSelector;
        final AtomicReference<Disposable> debouncer = new AtomicReference<>();
        boolean done;
        final Observer<? super T> downstream;
        volatile long index;
        Disposable upstream;

        DebounceObserver(Observer<? super T> observer, Function<? super T, ? extends ObservableSource<U>> function) {
            this.downstream = observer;
            this.debounceSelector = function;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            if (!this.done) {
                long j = this.index + 1;
                this.index = j;
                Disposable disposable = this.debouncer.get();
                if (disposable != null) {
                    disposable.dispose();
                }
                try {
                    ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.debounceSelector.apply(t), "The ObservableSource supplied is null");
                    DebounceInnerObserver debounceInnerObserver = new DebounceInnerObserver(this, j, t);
                    if (this.debouncer.compareAndSet(disposable, debounceInnerObserver)) {
                        observableSource.subscribe(debounceInnerObserver);
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    dispose();
                    this.downstream.onError(th);
                }
            }
        }

        public void onError(Throwable th) {
            DisposableHelper.dispose(this.debouncer);
            this.downstream.onError(th);
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                Disposable disposable = this.debouncer.get();
                if (disposable != DisposableHelper.DISPOSED) {
                    ((DebounceInnerObserver) disposable).emit();
                    DisposableHelper.dispose(this.debouncer);
                    this.downstream.onComplete();
                }
            }
        }

        public void dispose() {
            this.upstream.dispose();
            DisposableHelper.dispose(this.debouncer);
        }

        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        /* access modifiers changed from: package-private */
        public void emit(long j, T t) {
            if (j == this.index) {
                this.downstream.onNext(t);
            }
        }

        static final class DebounceInnerObserver<T, U> extends DisposableObserver<U> {
            boolean done;
            final long index;
            final AtomicBoolean once = new AtomicBoolean();
            final DebounceObserver<T, U> parent;
            final T value;

            DebounceInnerObserver(DebounceObserver<T, U> debounceObserver, long j, T t) {
                this.parent = debounceObserver;
                this.index = j;
                this.value = t;
            }

            public void onNext(U u) {
                if (!this.done) {
                    this.done = true;
                    dispose();
                    emit();
                }
            }

            /* access modifiers changed from: package-private */
            public void emit() {
                if (this.once.compareAndSet(false, true)) {
                    this.parent.emit(this.index, this.value);
                }
            }

            public void onError(Throwable th) {
                if (this.done) {
                    RxJavaPlugins.onError(th);
                    return;
                }
                this.done = true;
                this.parent.onError(th);
            }

            public void onComplete() {
                if (!this.done) {
                    this.done = true;
                    emit();
                }
            }
        }
    }
}
