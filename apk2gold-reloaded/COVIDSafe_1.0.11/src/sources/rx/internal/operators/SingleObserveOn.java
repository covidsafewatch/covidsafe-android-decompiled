package rx.internal.operators;

import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Single.OnSubscribe;
import rx.SingleSubscriber;
import rx.functions.Action0;

public final class SingleObserveOn<T> implements OnSubscribe<T> {
    final Scheduler scheduler;
    final OnSubscribe<T> source;

    static final class ObserveOnSingleSubscriber<T> extends SingleSubscriber<T> implements Action0 {
        final SingleSubscriber<? super T> actual;
        Throwable error;
        T value;
        final Worker w;

        public ObserveOnSingleSubscriber(SingleSubscriber<? super T> singleSubscriber, Worker worker) {
            this.actual = singleSubscriber;
            this.w = worker;
        }

        public void onSuccess(T t) {
            this.value = t;
            this.w.schedule(this);
        }

        public void onError(Throwable th) {
            this.error = th;
            this.w.schedule(this);
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

    public SingleObserveOn(OnSubscribe<T> onSubscribe, Scheduler scheduler2) {
        this.source = onSubscribe;
        this.scheduler = scheduler2;
    }

    public void call(SingleSubscriber<? super T> singleSubscriber) {
        Worker createWorker = this.scheduler.createWorker();
        ObserveOnSingleSubscriber observeOnSingleSubscriber = new ObserveOnSingleSubscriber(singleSubscriber, createWorker);
        singleSubscriber.add(createWorker);
        singleSubscriber.add(observeOnSingleSubscriber);
        this.source.call(observeOnSingleSubscriber);
    }
}
