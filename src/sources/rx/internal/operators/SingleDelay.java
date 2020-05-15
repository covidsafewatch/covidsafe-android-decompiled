package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Scheduler;
import rx.Single;
import rx.SingleSubscriber;
import rx.functions.Action0;

public final class SingleDelay<T> implements Single.OnSubscribe<T> {
    final long delay;
    final Scheduler scheduler;
    final Single.OnSubscribe<T> source;
    final TimeUnit unit;

    public SingleDelay(Single.OnSubscribe<T> onSubscribe, long j, TimeUnit timeUnit, Scheduler scheduler2) {
        this.source = onSubscribe;
        this.scheduler = scheduler2;
        this.delay = j;
        this.unit = timeUnit;
    }

    public void call(SingleSubscriber<? super T> singleSubscriber) {
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        ObserveOnSingleSubscriber observeOnSingleSubscriber = new ObserveOnSingleSubscriber(singleSubscriber, createWorker, this.delay, this.unit);
        singleSubscriber.add(createWorker);
        singleSubscriber.add(observeOnSingleSubscriber);
        this.source.call(observeOnSingleSubscriber);
    }

    static final class ObserveOnSingleSubscriber<T> extends SingleSubscriber<T> implements Action0 {
        final SingleSubscriber<? super T> actual;
        final long delay;
        Throwable error;
        final TimeUnit unit;
        T value;
        final Scheduler.Worker w;

        public ObserveOnSingleSubscriber(SingleSubscriber<? super T> singleSubscriber, Scheduler.Worker worker, long j, TimeUnit timeUnit) {
            this.actual = singleSubscriber;
            this.w = worker;
            this.delay = j;
            this.unit = timeUnit;
        }

        public void onSuccess(T t) {
            this.value = t;
            this.w.schedule(this, this.delay, this.unit);
        }

        public void onError(Throwable th) {
            this.error = th;
            this.w.schedule(this, this.delay, this.unit);
        }

        public void call() {
            try {
                Throwable th = this.error;
                if (th != null) {
                    this.error = null;
                    this.actual.onError(th);
                } else {
                    T t = this.value;
                    this.value = null;
                    this.actual.onSuccess(t);
                }
            } finally {
                this.w.unsubscribe();
            }
        }
    }
}
