package io.reactivex.internal.operators.parallel;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelJoin<T> extends Flowable<T> {
    final boolean delayErrors;
    final int prefetch;
    final ParallelFlowable<? extends T> source;

    static final class JoinInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = 8410034718427740355L;
        final int limit;
        final JoinSubscriptionBase<T> parent;
        final int prefetch;
        long produced;
        volatile SimplePlainQueue<T> queue;

        JoinInnerSubscriber(JoinSubscriptionBase<T> joinSubscriptionBase, int i) {
            this.parent = joinSubscriptionBase;
            this.prefetch = i;
            this.limit = i - (i >> 2);
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, (long) this.prefetch);
        }

        public void onNext(T t) {
            this.parent.onNext(this, t);
        }

        public void onError(Throwable th) {
            this.parent.onError(th);
        }

        public void onComplete() {
            this.parent.onComplete();
        }

        public void requestOne() {
            long j = this.produced + 1;
            if (j == ((long) this.limit)) {
                this.produced = 0;
                ((Subscription) get()).request(j);
                return;
            }
            this.produced = j;
        }

        public void request(long j) {
            long j2 = this.produced + j;
            if (j2 >= ((long) this.limit)) {
                this.produced = 0;
                ((Subscription) get()).request(j2);
                return;
            }
            this.produced = j2;
        }

        public boolean cancel() {
            return SubscriptionHelper.cancel(this);
        }

        /* access modifiers changed from: 0000 */
        public SimplePlainQueue<T> getQueue() {
            SimplePlainQueue<T> simplePlainQueue = this.queue;
            if (simplePlainQueue != null) {
                return simplePlainQueue;
            }
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.prefetch);
            this.queue = spscArrayQueue;
            return spscArrayQueue;
        }
    }

    static final class JoinSubscription<T> extends JoinSubscriptionBase<T> {
        private static final long serialVersionUID = 6312374661811000451L;

        JoinSubscription(Subscriber<? super T> subscriber, int i, int i2) {
            super(subscriber, i, i2);
        }

        public void onNext(JoinInnerSubscriber<T> joinInnerSubscriber, T t) {
            String str = "Queue full?!";
            if (get() == 0 && compareAndSet(0, 1)) {
                if (this.requested.get() != 0) {
                    this.downstream.onNext(t);
                    if (this.requested.get() != LongCompanionObject.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    joinInnerSubscriber.request(1);
                } else if (!joinInnerSubscriber.getQueue().offer(t)) {
                    cancelAll();
                    MissingBackpressureException missingBackpressureException = new MissingBackpressureException(str);
                    if (this.errors.compareAndSet(null, missingBackpressureException)) {
                        this.downstream.onError(missingBackpressureException);
                    } else {
                        RxJavaPlugins.onError(missingBackpressureException);
                    }
                    return;
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!joinInnerSubscriber.getQueue().offer(t)) {
                cancelAll();
                onError(new MissingBackpressureException(str));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }

        public void onError(Throwable th) {
            if (this.errors.compareAndSet(null, th)) {
                cancelAll();
                drain();
            } else if (th != this.errors.get()) {
                RxJavaPlugins.onError(th);
            }
        }

        public void onComplete() {
            this.done.decrementAndGet();
            drain();
        }

        /* access modifiers changed from: 0000 */
        public void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x005d, code lost:
            if (r12 == false) goto L_0x0065;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x005f, code lost:
            if (r15 == false) goto L_0x0065;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0061, code lost:
            r3.onComplete();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0064, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0065, code lost:
            if (r15 == false) goto L_0x0011;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void drainLoop() {
            /*
                r18 = this;
                r0 = r18
                io.reactivex.internal.operators.parallel.ParallelJoin$JoinInnerSubscriber[] r1 = r0.subscribers
                int r2 = r1.length
                org.reactivestreams.Subscriber r3 = r0.downstream
                r5 = 1
            L_0x0008:
                java.util.concurrent.atomic.AtomicLong r6 = r0.requested
                long r6 = r6.get()
                r8 = 0
                r10 = r8
            L_0x0011:
                int r12 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                if (r12 == 0) goto L_0x0067
                boolean r12 = r0.cancelled
                if (r12 == 0) goto L_0x001d
                r18.cleanup()
                return
            L_0x001d:
                io.reactivex.internal.util.AtomicThrowable r12 = r0.errors
                java.lang.Object r12 = r12.get()
                java.lang.Throwable r12 = (java.lang.Throwable) r12
                if (r12 == 0) goto L_0x002e
                r18.cleanup()
                r3.onError(r12)
                return
            L_0x002e:
                java.util.concurrent.atomic.AtomicInteger r12 = r0.done
                int r12 = r12.get()
                if (r12 != 0) goto L_0x0038
                r12 = 1
                goto L_0x0039
            L_0x0038:
                r12 = 0
            L_0x0039:
                r14 = 0
                r15 = 1
            L_0x003b:
                int r4 = r1.length
                if (r14 >= r4) goto L_0x005d
                r4 = r1[r14]
                io.reactivex.internal.fuseable.SimplePlainQueue<T> r13 = r4.queue
                if (r13 == 0) goto L_0x005a
                java.lang.Object r13 = r13.poll()
                if (r13 == 0) goto L_0x005a
                r3.onNext(r13)
                r4.requestOne()
                r16 = 1
                long r10 = r10 + r16
                int r4 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                if (r4 != 0) goto L_0x0059
                goto L_0x0067
            L_0x0059:
                r15 = 0
            L_0x005a:
                int r14 = r14 + 1
                goto L_0x003b
            L_0x005d:
                if (r12 == 0) goto L_0x0065
                if (r15 == 0) goto L_0x0065
                r3.onComplete()
                return
            L_0x0065:
                if (r15 == 0) goto L_0x0011
            L_0x0067:
                int r4 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                if (r4 != 0) goto L_0x00ac
                boolean r4 = r0.cancelled
                if (r4 == 0) goto L_0x0073
                r18.cleanup()
                return
            L_0x0073:
                io.reactivex.internal.util.AtomicThrowable r4 = r0.errors
                java.lang.Object r4 = r4.get()
                java.lang.Throwable r4 = (java.lang.Throwable) r4
                if (r4 == 0) goto L_0x0084
                r18.cleanup()
                r3.onError(r4)
                return
            L_0x0084:
                java.util.concurrent.atomic.AtomicInteger r4 = r0.done
                int r4 = r4.get()
                if (r4 != 0) goto L_0x008e
                r4 = 1
                goto L_0x008f
            L_0x008e:
                r4 = 0
            L_0x008f:
                r12 = 0
            L_0x0090:
                if (r12 >= r2) goto L_0x00a3
                r13 = r1[r12]
                io.reactivex.internal.fuseable.SimplePlainQueue<T> r13 = r13.queue
                if (r13 == 0) goto L_0x00a0
                boolean r13 = r13.isEmpty()
                if (r13 != 0) goto L_0x00a0
                r13 = 0
                goto L_0x00a4
            L_0x00a0:
                int r12 = r12 + 1
                goto L_0x0090
            L_0x00a3:
                r13 = 1
            L_0x00a4:
                if (r4 == 0) goto L_0x00ac
                if (r13 == 0) goto L_0x00ac
                r3.onComplete()
                return
            L_0x00ac:
                int r4 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
                if (r4 == 0) goto L_0x00bf
                r8 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r4 == 0) goto L_0x00bf
                java.util.concurrent.atomic.AtomicLong r4 = r0.requested
                long r6 = -r10
                r4.addAndGet(r6)
            L_0x00bf:
                int r4 = r18.get()
                if (r4 != r5) goto L_0x00cd
                int r4 = -r5
                int r4 = r0.addAndGet(r4)
                if (r4 != 0) goto L_0x00cd
                return
            L_0x00cd:
                r5 = r4
                goto L_0x0008
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscription.drainLoop():void");
        }
    }

    static abstract class JoinSubscriptionBase<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 3100232009247827843L;
        volatile boolean cancelled;
        final AtomicInteger done = new AtomicInteger();
        final Subscriber<? super T> downstream;
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicLong requested = new AtomicLong();
        final JoinInnerSubscriber<T>[] subscribers;

        /* access modifiers changed from: 0000 */
        public abstract void drain();

        /* access modifiers changed from: 0000 */
        public abstract void onComplete();

        /* access modifiers changed from: 0000 */
        public abstract void onError(Throwable th);

        /* access modifiers changed from: 0000 */
        public abstract void onNext(JoinInnerSubscriber<T> joinInnerSubscriber, T t);

        JoinSubscriptionBase(Subscriber<? super T> subscriber, int i, int i2) {
            this.downstream = subscriber;
            JoinInnerSubscriber<T>[] joinInnerSubscriberArr = new JoinInnerSubscriber[i];
            for (int i3 = 0; i3 < i; i3++) {
                joinInnerSubscriberArr[i3] = new JoinInnerSubscriber<>(this, i2);
            }
            this.subscribers = joinInnerSubscriberArr;
            this.done.lazySet(i);
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                cancelAll();
                if (getAndIncrement() == 0) {
                    cleanup();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void cancelAll() {
            for (JoinInnerSubscriber<T> cancel : this.subscribers) {
                cancel.cancel();
            }
        }

        /* access modifiers changed from: 0000 */
        public void cleanup() {
            for (JoinInnerSubscriber<T> joinInnerSubscriber : this.subscribers) {
                joinInnerSubscriber.queue = null;
            }
        }
    }

    static final class JoinSubscriptionDelayError<T> extends JoinSubscriptionBase<T> {
        private static final long serialVersionUID = -5737965195918321883L;

        JoinSubscriptionDelayError(Subscriber<? super T> subscriber, int i, int i2) {
            super(subscriber, i, i2);
        }

        /* access modifiers changed from: 0000 */
        public void onNext(JoinInnerSubscriber<T> joinInnerSubscriber, T t) {
            String str = "Queue full?!";
            if (get() != 0 || !compareAndSet(0, 1)) {
                if (!joinInnerSubscriber.getQueue().offer(t) && joinInnerSubscriber.cancel()) {
                    this.errors.addThrowable(new MissingBackpressureException(str));
                    this.done.decrementAndGet();
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            } else {
                if (this.requested.get() != 0) {
                    this.downstream.onNext(t);
                    if (this.requested.get() != LongCompanionObject.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    joinInnerSubscriber.request(1);
                } else if (!joinInnerSubscriber.getQueue().offer(t)) {
                    joinInnerSubscriber.cancel();
                    this.errors.addThrowable(new MissingBackpressureException(str));
                    this.done.decrementAndGet();
                    drainLoop();
                    return;
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            drainLoop();
        }

        /* access modifiers changed from: 0000 */
        public void onError(Throwable th) {
            this.errors.addThrowable(th);
            this.done.decrementAndGet();
            drain();
        }

        /* access modifiers changed from: 0000 */
        public void onComplete() {
            this.done.decrementAndGet();
            drain();
        }

        /* access modifiers changed from: 0000 */
        public void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x004b, code lost:
            if (r12 == false) goto L_0x0067;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x004d, code lost:
            if (r15 == false) goto L_0x0067;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0057, code lost:
            if (((java.lang.Throwable) r0.errors.get()) == null) goto L_0x0063;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0059, code lost:
            r3.onError(r0.errors.terminate());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0063, code lost:
            r3.onComplete();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0066, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0067, code lost:
            if (r15 == false) goto L_0x0011;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void drainLoop() {
            /*
                r18 = this;
                r0 = r18
                io.reactivex.internal.operators.parallel.ParallelJoin$JoinInnerSubscriber[] r1 = r0.subscribers
                int r2 = r1.length
                org.reactivestreams.Subscriber r3 = r0.downstream
                r5 = 1
            L_0x0008:
                java.util.concurrent.atomic.AtomicLong r6 = r0.requested
                long r6 = r6.get()
                r8 = 0
                r10 = r8
            L_0x0011:
                int r12 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                if (r12 == 0) goto L_0x0069
                boolean r12 = r0.cancelled
                if (r12 == 0) goto L_0x001d
                r18.cleanup()
                return
            L_0x001d:
                java.util.concurrent.atomic.AtomicInteger r12 = r0.done
                int r12 = r12.get()
                if (r12 != 0) goto L_0x0027
                r12 = 1
                goto L_0x0028
            L_0x0027:
                r12 = 0
            L_0x0028:
                r14 = 0
                r15 = 1
            L_0x002a:
                if (r14 >= r2) goto L_0x004b
                r4 = r1[r14]
                io.reactivex.internal.fuseable.SimplePlainQueue<T> r13 = r4.queue
                if (r13 == 0) goto L_0x0048
                java.lang.Object r13 = r13.poll()
                if (r13 == 0) goto L_0x0048
                r3.onNext(r13)
                r4.requestOne()
                r16 = 1
                long r10 = r10 + r16
                int r4 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                if (r4 != 0) goto L_0x0047
                goto L_0x0069
            L_0x0047:
                r15 = 0
            L_0x0048:
                int r14 = r14 + 1
                goto L_0x002a
            L_0x004b:
                if (r12 == 0) goto L_0x0067
                if (r15 == 0) goto L_0x0067
                io.reactivex.internal.util.AtomicThrowable r1 = r0.errors
                java.lang.Object r1 = r1.get()
                java.lang.Throwable r1 = (java.lang.Throwable) r1
                if (r1 == 0) goto L_0x0063
                io.reactivex.internal.util.AtomicThrowable r1 = r0.errors
                java.lang.Throwable r1 = r1.terminate()
                r3.onError(r1)
                goto L_0x0066
            L_0x0063:
                r3.onComplete()
            L_0x0066:
                return
            L_0x0067:
                if (r15 == 0) goto L_0x0011
            L_0x0069:
                int r4 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                if (r4 != 0) goto L_0x00b1
                boolean r4 = r0.cancelled
                if (r4 == 0) goto L_0x0075
                r18.cleanup()
                return
            L_0x0075:
                java.util.concurrent.atomic.AtomicInteger r4 = r0.done
                int r4 = r4.get()
                if (r4 != 0) goto L_0x007f
                r4 = 1
                goto L_0x0080
            L_0x007f:
                r4 = 0
            L_0x0080:
                r12 = 0
            L_0x0081:
                if (r12 >= r2) goto L_0x0094
                r13 = r1[r12]
                io.reactivex.internal.fuseable.SimplePlainQueue<T> r13 = r13.queue
                if (r13 == 0) goto L_0x0091
                boolean r13 = r13.isEmpty()
                if (r13 != 0) goto L_0x0091
                r13 = 0
                goto L_0x0095
            L_0x0091:
                int r12 = r12 + 1
                goto L_0x0081
            L_0x0094:
                r13 = 1
            L_0x0095:
                if (r4 == 0) goto L_0x00b1
                if (r13 == 0) goto L_0x00b1
                io.reactivex.internal.util.AtomicThrowable r1 = r0.errors
                java.lang.Object r1 = r1.get()
                java.lang.Throwable r1 = (java.lang.Throwable) r1
                if (r1 == 0) goto L_0x00ad
                io.reactivex.internal.util.AtomicThrowable r1 = r0.errors
                java.lang.Throwable r1 = r1.terminate()
                r3.onError(r1)
                goto L_0x00b0
            L_0x00ad:
                r3.onComplete()
            L_0x00b0:
                return
            L_0x00b1:
                int r4 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
                if (r4 == 0) goto L_0x00c4
                r8 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r4 == 0) goto L_0x00c4
                java.util.concurrent.atomic.AtomicLong r4 = r0.requested
                long r6 = -r10
                r4.addAndGet(r6)
            L_0x00c4:
                int r4 = r18.get()
                if (r4 != r5) goto L_0x00d2
                int r4 = -r5
                int r4 = r0.addAndGet(r4)
                if (r4 != 0) goto L_0x00d2
                return
            L_0x00d2:
                r5 = r4
                goto L_0x0008
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionDelayError.drainLoop():void");
        }
    }

    public ParallelJoin(ParallelFlowable<? extends T> parallelFlowable, int i, boolean z) {
        this.source = parallelFlowable;
        this.prefetch = i;
        this.delayErrors = z;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super T> subscriber) {
        JoinSubscriptionBase joinSubscriptionBase;
        if (this.delayErrors) {
            joinSubscriptionBase = new JoinSubscriptionDelayError(subscriber, this.source.parallelism(), this.prefetch);
        } else {
            joinSubscriptionBase = new JoinSubscription(subscriber, this.source.parallelism(), this.prefetch);
        }
        subscriber.onSubscribe(joinSubscriptionBase);
        this.source.subscribe(joinSubscriptionBase.subscribers);
    }
}
