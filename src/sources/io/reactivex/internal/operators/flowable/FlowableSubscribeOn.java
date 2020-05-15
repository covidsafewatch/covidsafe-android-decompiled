package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSubscribeOn<T> extends AbstractFlowableWithUpstream<T, T> {
    final boolean nonScheduledRequests;
    final Scheduler scheduler;

    public FlowableSubscribeOn(Flowable<T> flowable, Scheduler scheduler2, boolean z) {
        super(flowable);
        this.scheduler = scheduler2;
        this.nonScheduledRequests = z;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        SubscribeOnSubscriber subscribeOnSubscriber = new SubscribeOnSubscriber(subscriber, createWorker, this.source, this.nonScheduledRequests);
        subscriber.onSubscribe(subscribeOnSubscriber);
        createWorker.schedule(subscribeOnSubscriber);
    }

    static final class SubscribeOnSubscriber<T> extends AtomicReference<Thread> implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = 8094547886072529208L;
        final Subscriber<? super T> downstream;
        final boolean nonScheduledRequests;
        final AtomicLong requested = new AtomicLong();
        Publisher<T> source;
        final AtomicReference<Subscription> upstream = new AtomicReference<>();
        final Scheduler.Worker worker;

        SubscribeOnSubscriber(Subscriber<? super T> subscriber, Scheduler.Worker worker2, Publisher<T> publisher, boolean z) {
            this.downstream = subscriber;
            this.worker = worker2;
            this.source = publisher;
            this.nonScheduledRequests = !z;
        }

        public void run() {
            lazySet(Thread.currentThread());
            Publisher<T> publisher = this.source;
            this.source = null;
            publisher.subscribe(this);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.upstream, subscription)) {
                long andSet = this.requested.getAndSet(0);
                if (andSet != 0) {
                    requestUpstream(andSet, subscription);
                }
            }
        }

        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
            this.worker.dispose();
        }

        public void onComplete() {
            this.downstream.onComplete();
            this.worker.dispose();
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                Subscription subscription = this.upstream.get();
                if (subscription != null) {
                    requestUpstream(j, subscription);
                    return;
                }
                BackpressureHelper.add(this.requested, j);
                Subscription subscription2 = this.upstream.get();
                if (subscription2 != null) {
                    long andSet = this.requested.getAndSet(0);
                    if (andSet != 0) {
                        requestUpstream(andSet, subscription2);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void requestUpstream(long j, Subscription subscription) {
            if (this.nonScheduledRequests || Thread.currentThread() == get()) {
                subscription.request(j);
            } else {
                this.worker.schedule(new Request(subscription, j));
            }
        }

        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
            this.worker.dispose();
        }

        static final class Request implements Runnable {
            final long n;
            final Subscription upstream;

            Request(Subscription subscription, long j) {
                this.upstream = subscription;
                this.n = j;
            }

            public void run() {
                this.upstream.request(this.n);
            }
        }
    }
}
