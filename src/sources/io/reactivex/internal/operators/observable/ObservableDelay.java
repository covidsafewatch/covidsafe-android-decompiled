package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;

public final class ObservableDelay<T> extends AbstractObservableWithUpstream<T, T> {
    final long delay;
    final boolean delayError;
    final Scheduler scheduler;
    final TimeUnit unit;

    public ObservableDelay(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, Scheduler scheduler2, boolean z) {
        super(observableSource);
        this.delay = j;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
        this.delayError = z;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SerializedObserver serializedObserver;
        if (this.delayError) {
            serializedObserver = observer;
        } else {
            serializedObserver = new SerializedObserver(observer);
        }
        this.source.subscribe(new DelayObserver(serializedObserver, this.delay, this.unit, this.scheduler.createWorker(), this.delayError));
    }

    static final class DelayObserver<T> implements Observer<T>, Disposable {
        final long delay;
        final boolean delayError;
        final Observer<? super T> downstream;
        final TimeUnit unit;
        Disposable upstream;
        final Scheduler.Worker w;

        DelayObserver(Observer<? super T> observer, long j, TimeUnit timeUnit, Scheduler.Worker worker, boolean z) {
            this.downstream = observer;
            this.delay = j;
            this.unit = timeUnit;
            this.w = worker;
            this.delayError = z;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            this.w.schedule(new OnNext(t), this.delay, this.unit);
        }

        public void onError(Throwable th) {
            this.w.schedule(new OnError(th), this.delayError ? this.delay : 0, this.unit);
        }

        public void onComplete() {
            this.w.schedule(new OnComplete(), this.delay, this.unit);
        }

        public void dispose() {
            this.upstream.dispose();
            this.w.dispose();
        }

        public boolean isDisposed() {
            return this.w.isDisposed();
        }

        final class OnNext implements Runnable {
            private final T t;

            OnNext(T t2) {
                this.t = t2;
            }

            public void run() {
                DelayObserver.this.downstream.onNext(this.t);
            }
        }

        final class OnError implements Runnable {
            private final Throwable throwable;

            OnError(Throwable th) {
                this.throwable = th;
            }

            public void run() {
                try {
                    DelayObserver.this.downstream.onError(this.throwable);
                } finally {
                    DelayObserver.this.w.dispose();
                }
            }
        }

        final class OnComplete implements Runnable {
            OnComplete() {
            }

            public void run() {
                try {
                    DelayObserver.this.downstream.onComplete();
                } finally {
                    DelayObserver.this.w.dispose();
                }
            }
        }
    }
}
