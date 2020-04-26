package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscribers.InnerQueuedSubscriber;
import io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableConcatMapEager<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final ErrorMode errorMode;
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    final int maxConcurrency;
    final int prefetch;

    static final class ConcatMapEagerDelayErrorSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, InnerQueuedSubscriberSupport<R> {
        private static final long serialVersionUID = -4255299542215038287L;
        volatile boolean cancelled;
        volatile InnerQueuedSubscriber<R> current;
        volatile boolean done;
        final Subscriber<? super R> downstream;
        final ErrorMode errorMode;
        final AtomicThrowable errors = new AtomicThrowable();
        final Function<? super T, ? extends Publisher<? extends R>> mapper;
        final int maxConcurrency;
        final int prefetch;
        final AtomicLong requested = new AtomicLong();
        final SpscLinkedArrayQueue<InnerQueuedSubscriber<R>> subscribers;
        Subscription upstream;

        ConcatMapEagerDelayErrorSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i, int i2, ErrorMode errorMode2) {
            this.downstream = subscriber;
            this.mapper = function;
            this.maxConcurrency = i;
            this.prefetch = i2;
            this.errorMode = errorMode2;
            this.subscribers = new SpscLinkedArrayQueue<>(Math.min(i2, i));
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                int i = this.maxConcurrency;
                subscription.request(i == Integer.MAX_VALUE ? LongCompanionObject.MAX_VALUE : (long) i);
            }
        }

        public void onNext(T t) {
            try {
                Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper returned a null Publisher");
                InnerQueuedSubscriber innerQueuedSubscriber = new InnerQueuedSubscriber(this, this.prefetch);
                if (!this.cancelled) {
                    this.subscribers.offer(innerQueuedSubscriber);
                    publisher.subscribe(innerQueuedSubscriber);
                    if (this.cancelled) {
                        innerQueuedSubscriber.cancel();
                        drainAndCancel();
                    }
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.upstream.cancel();
                onError(th);
            }
        }

        public void onError(Throwable th) {
            if (this.errors.addThrowable(th)) {
                this.done = true;
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.cancel();
                drainAndCancel();
            }
        }

        /* access modifiers changed from: 0000 */
        public void drainAndCancel() {
            if (getAndIncrement() == 0) {
                do {
                    cancelAll();
                } while (decrementAndGet() != 0);
            }
        }

        /* access modifiers changed from: 0000 */
        public void cancelAll() {
            while (true) {
                InnerQueuedSubscriber innerQueuedSubscriber = (InnerQueuedSubscriber) this.subscribers.poll();
                if (innerQueuedSubscriber != null) {
                    innerQueuedSubscriber.cancel();
                } else {
                    return;
                }
            }
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }

        public void innerNext(InnerQueuedSubscriber<R> innerQueuedSubscriber, R r) {
            if (innerQueuedSubscriber.queue().offer(r)) {
                drain();
                return;
            }
            innerQueuedSubscriber.cancel();
            innerError(innerQueuedSubscriber, new MissingBackpressureException());
        }

        public void innerError(InnerQueuedSubscriber<R> innerQueuedSubscriber, Throwable th) {
            if (this.errors.addThrowable(th)) {
                innerQueuedSubscriber.setDone();
                if (this.errorMode != ErrorMode.END) {
                    this.upstream.cancel();
                }
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public void innerComplete(InnerQueuedSubscriber<R> innerQueuedSubscriber) {
            innerQueuedSubscriber.setDone();
            drain();
        }

        /* JADX WARNING: Removed duplicated region for block: B:78:0x012a  */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x012f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void drain() {
            /*
                r17 = this;
                r1 = r17
                int r0 = r17.getAndIncrement()
                if (r0 == 0) goto L_0x0009
                return
            L_0x0009:
                io.reactivex.internal.subscribers.InnerQueuedSubscriber<R> r0 = r1.current
                org.reactivestreams.Subscriber<? super R> r2 = r1.downstream
                io.reactivex.internal.util.ErrorMode r3 = r1.errorMode
                r5 = 1
            L_0x0010:
                java.util.concurrent.atomic.AtomicLong r6 = r1.requested
                long r6 = r6.get()
                if (r0 != 0) goto L_0x0056
                io.reactivex.internal.util.ErrorMode r0 = io.reactivex.internal.util.ErrorMode.END
                if (r3 == r0) goto L_0x0033
                io.reactivex.internal.util.AtomicThrowable r0 = r1.errors
                java.lang.Object r0 = r0.get()
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                if (r0 == 0) goto L_0x0033
                r17.cancelAll()
                io.reactivex.internal.util.AtomicThrowable r0 = r1.errors
                java.lang.Throwable r0 = r0.terminate()
                r2.onError(r0)
                return
            L_0x0033:
                boolean r0 = r1.done
                io.reactivex.internal.queue.SpscLinkedArrayQueue<io.reactivex.internal.subscribers.InnerQueuedSubscriber<R>> r8 = r1.subscribers
                java.lang.Object r8 = r8.poll()
                io.reactivex.internal.subscribers.InnerQueuedSubscriber r8 = (io.reactivex.internal.subscribers.InnerQueuedSubscriber) r8
                if (r0 == 0) goto L_0x0051
                if (r8 != 0) goto L_0x0051
                io.reactivex.internal.util.AtomicThrowable r0 = r1.errors
                java.lang.Throwable r0 = r0.terminate()
                if (r0 == 0) goto L_0x004d
                r2.onError(r0)
                goto L_0x0050
            L_0x004d:
                r2.onComplete()
            L_0x0050:
                return
            L_0x0051:
                if (r8 == 0) goto L_0x0057
                r1.current = r8
                goto L_0x0057
            L_0x0056:
                r8 = r0
            L_0x0057:
                r11 = 0
                if (r8 == 0) goto L_0x010e
                io.reactivex.internal.fuseable.SimpleQueue r12 = r8.queue()
                if (r12 == 0) goto L_0x010e
                r13 = 0
            L_0x0062:
                int r15 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
                r16 = r5
                r4 = 1
                if (r15 == 0) goto L_0x00cb
                boolean r0 = r1.cancelled
                if (r0 == 0) goto L_0x0072
                r17.cancelAll()
                return
            L_0x0072:
                io.reactivex.internal.util.ErrorMode r0 = io.reactivex.internal.util.ErrorMode.IMMEDIATE
                if (r3 != r0) goto L_0x0092
                io.reactivex.internal.util.AtomicThrowable r0 = r1.errors
                java.lang.Object r0 = r0.get()
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                if (r0 == 0) goto L_0x0092
                r1.current = r11
                r8.cancel()
                r17.cancelAll()
                io.reactivex.internal.util.AtomicThrowable r0 = r1.errors
                java.lang.Throwable r0 = r0.terminate()
                r2.onError(r0)
                return
            L_0x0092:
                boolean r0 = r8.isDone()
                java.lang.Object r9 = r12.poll()     // Catch:{ all -> 0x00ba }
                if (r9 != 0) goto L_0x009e
                r10 = 1
                goto L_0x009f
            L_0x009e:
                r10 = 0
            L_0x009f:
                if (r0 == 0) goto L_0x00ad
                if (r10 == 0) goto L_0x00ad
                r1.current = r11
                org.reactivestreams.Subscription r0 = r1.upstream
                r0.request(r4)
                r8 = r11
                r0 = 1
                goto L_0x00cc
            L_0x00ad:
                if (r10 == 0) goto L_0x00b0
                goto L_0x00cb
            L_0x00b0:
                r2.onNext(r9)
                long r13 = r13 + r4
                r8.requestOne()
                r5 = r16
                goto L_0x0062
            L_0x00ba:
                r0 = move-exception
                r3 = r0
                io.reactivex.exceptions.Exceptions.throwIfFatal(r3)
                r1.current = r11
                r8.cancel()
                r17.cancelAll()
                r2.onError(r3)
                return
            L_0x00cb:
                r0 = 0
            L_0x00cc:
                if (r15 != 0) goto L_0x010b
                boolean r9 = r1.cancelled
                if (r9 == 0) goto L_0x00d6
                r17.cancelAll()
                return
            L_0x00d6:
                io.reactivex.internal.util.ErrorMode r9 = io.reactivex.internal.util.ErrorMode.IMMEDIATE
                if (r3 != r9) goto L_0x00f6
                io.reactivex.internal.util.AtomicThrowable r9 = r1.errors
                java.lang.Object r9 = r9.get()
                java.lang.Throwable r9 = (java.lang.Throwable) r9
                if (r9 == 0) goto L_0x00f6
                r1.current = r11
                r8.cancel()
                r17.cancelAll()
                io.reactivex.internal.util.AtomicThrowable r0 = r1.errors
                java.lang.Throwable r0 = r0.terminate()
                r2.onError(r0)
                return
            L_0x00f6:
                boolean r9 = r8.isDone()
                boolean r10 = r12.isEmpty()
                if (r9 == 0) goto L_0x010b
                if (r10 == 0) goto L_0x010b
                r1.current = r11
                org.reactivestreams.Subscription r0 = r1.upstream
                r0.request(r4)
                r8 = r11
                r0 = 1
            L_0x010b:
                r4 = 0
                goto L_0x0115
            L_0x010e:
                r16 = r5
                r0 = 0
                r4 = 0
                r13 = 0
            L_0x0115:
                int r4 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
                if (r4 == 0) goto L_0x0128
                r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r4 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
                if (r4 == 0) goto L_0x0128
                java.util.concurrent.atomic.AtomicLong r4 = r1.requested
                long r5 = -r13
                r4.addAndGet(r5)
            L_0x0128:
                if (r0 == 0) goto L_0x012f
                r0 = r8
                r5 = r16
                goto L_0x0010
            L_0x012f:
                r4 = r16
                int r0 = -r4
                int r5 = r1.addAndGet(r0)
                if (r5 != 0) goto L_0x0139
                return
            L_0x0139:
                r0 = r8
                goto L_0x0010
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableConcatMapEager.ConcatMapEagerDelayErrorSubscriber.drain():void");
        }
    }

    public FlowableConcatMapEager(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends R>> function, int i, int i2, ErrorMode errorMode2) {
        super(flowable);
        this.mapper = function;
        this.maxConcurrency = i;
        this.prefetch = i2;
        this.errorMode = errorMode2;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super R> subscriber) {
        Flowable flowable = this.source;
        ConcatMapEagerDelayErrorSubscriber concatMapEagerDelayErrorSubscriber = new ConcatMapEagerDelayErrorSubscriber(subscriber, this.mapper, this.maxConcurrency, this.prefetch, this.errorMode);
        flowable.subscribe((FlowableSubscriber<? super T>) concatMapEagerDelayErrorSubscriber);
    }
}
