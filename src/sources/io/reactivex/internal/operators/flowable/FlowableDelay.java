package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDelay<T> extends AbstractFlowableWithUpstream<T, T> {
    final long delay;
    final boolean delayError;
    final Scheduler scheduler;
    final TimeUnit unit;

    public FlowableDelay(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler2, boolean z) {
        super(flowable);
        this.delay = j;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
        this.delayError = z;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super T> subscriber) {
        SerializedSubscriber serializedSubscriber;
        if (this.delayError) {
            serializedSubscriber = subscriber;
        } else {
            serializedSubscriber = new SerializedSubscriber(subscriber);
        }
        this.source.subscribe(new DelaySubscriber(serializedSubscriber, this.delay, this.unit, this.scheduler.createWorker(), this.delayError));
    }

    static final class DelaySubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final long delay;
        final boolean delayError;
        final Subscriber<? super T> downstream;
        final TimeUnit unit;
        Subscription upstream;
        final Scheduler.Worker w;

        DelaySubscriber(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, Scheduler.Worker worker, boolean z) {
            this.downstream = subscriber;
            this.delay = j;
            this.unit = timeUnit;
            this.w = worker;
            this.delayError = z;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
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

        public void request(long j) {
            this.upstream.request(j);
        }

        public void cancel() {
            this.upstream.cancel();
            this.w.dispose();
        }

        final class OnNext implements Runnable {
            private final T t;

            OnNext(T t2) {
                this.t = t2;
            }

            public void run() {
                DelaySubscriber.this.downstream.onNext(this.t);
            }
        }

        final class OnError implements Runnable {
            private final Throwable t;

            OnError(Throwable th) {
                this.t = th;
            }

            public void run() {
                try {
                    DelaySubscriber.this.downstream.onError(this.t);
                } finally {
                    DelaySubscriber.this.w.dispose();
                }
            }
        }

        final class OnComplete implements Runnable {
            OnComplete() {
            }

            public void run() {
                try {
                    DelaySubscriber.this.downstream.onComplete();
                } finally {
                    DelaySubscriber.this.w.dispose();
                }
            }
        }
    }
}
