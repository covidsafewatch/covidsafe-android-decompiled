package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Action;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableOnBackpressureBufferStrategy<T> extends AbstractFlowableWithUpstream<T, T> {
    final long bufferSize;
    final Action onOverflow;
    final BackpressureOverflowStrategy strategy;

    public FlowableOnBackpressureBufferStrategy(Flowable<T> flowable, long j, Action action, BackpressureOverflowStrategy backpressureOverflowStrategy) {
        super(flowable);
        this.bufferSize = j;
        this.onOverflow = action;
        this.strategy = backpressureOverflowStrategy;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new OnBackpressureBufferStrategySubscriber(subscriber, this.onOverflow, this.strategy, this.bufferSize));
    }

    static final class OnBackpressureBufferStrategySubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 3240706908776709697L;
        final long bufferSize;
        volatile boolean cancelled;
        final Deque<T> deque = new ArrayDeque();
        volatile boolean done;
        final Subscriber<? super T> downstream;
        Throwable error;
        final Action onOverflow;
        final AtomicLong requested = new AtomicLong();
        final BackpressureOverflowStrategy strategy;
        Subscription upstream;

        OnBackpressureBufferStrategySubscriber(Subscriber<? super T> subscriber, Action action, BackpressureOverflowStrategy backpressureOverflowStrategy, long j) {
            this.downstream = subscriber;
            this.onOverflow = action;
            this.strategy = backpressureOverflowStrategy;
            this.bufferSize = j;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(LongCompanionObject.MAX_VALUE);
            }
        }

        public void onNext(T t) {
            boolean z;
            boolean z2;
            if (!this.done) {
                Deque<T> deque2 = this.deque;
                synchronized (deque2) {
                    z = false;
                    z2 = true;
                    if (((long) deque2.size()) == this.bufferSize) {
                        int i = AnonymousClass1.$SwitchMap$io$reactivex$BackpressureOverflowStrategy[this.strategy.ordinal()];
                        if (i == 1) {
                            deque2.pollLast();
                            deque2.offer(t);
                        } else if (i == 2) {
                            deque2.poll();
                            deque2.offer(t);
                        }
                        z = true;
                    } else {
                        deque2.offer(t);
                    }
                    z2 = false;
                }
                if (z) {
                    Action action = this.onOverflow;
                    if (action != null) {
                        try {
                            action.run();
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            this.upstream.cancel();
                            onError(th);
                        }
                    }
                } else if (z2) {
                    this.upstream.cancel();
                    onError(new MissingBackpressureException());
                } else {
                    drain();
                }
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.error = th;
            this.done = true;
            drain();
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }

        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            if (getAndIncrement() == 0) {
                clear(this.deque);
            }
        }

        /* access modifiers changed from: package-private */
        public void clear(Deque<T> deque2) {
            synchronized (deque2) {
                deque2.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public void drain() {
            int i;
            boolean isEmpty;
            T poll;
            if (getAndIncrement() == 0) {
                Deque<T> deque2 = this.deque;
                Subscriber<? super T> subscriber = this.downstream;
                int i2 = 1;
                do {
                    long j = this.requested.get();
                    long j2 = 0;
                    while (true) {
                        i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                        if (i == 0) {
                            break;
                        } else if (this.cancelled) {
                            clear(deque2);
                            return;
                        } else {
                            boolean z = this.done;
                            synchronized (deque2) {
                                poll = deque2.poll();
                            }
                            boolean z2 = poll == null;
                            if (z) {
                                Throwable th = this.error;
                                if (th != null) {
                                    clear(deque2);
                                    subscriber.onError(th);
                                    return;
                                } else if (z2) {
                                    subscriber.onComplete();
                                    return;
                                }
                            }
                            if (z2) {
                                break;
                            }
                            subscriber.onNext(poll);
                            j2++;
                        }
                    }
                    if (i == 0) {
                        if (this.cancelled) {
                            clear(deque2);
                            return;
                        }
                        boolean z3 = this.done;
                        synchronized (deque2) {
                            isEmpty = deque2.isEmpty();
                        }
                        if (z3) {
                            Throwable th2 = this.error;
                            if (th2 != null) {
                                clear(deque2);
                                subscriber.onError(th2);
                                return;
                            } else if (isEmpty) {
                                subscriber.onComplete();
                                return;
                            }
                        }
                    }
                    if (j2 != 0) {
                        BackpressureHelper.produced(this.requested, j2);
                    }
                    i2 = addAndGet(-i2);
                } while (i2 != 0);
            }
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableOnBackpressureBufferStrategy$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$reactivex$BackpressureOverflowStrategy;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                io.reactivex.BackpressureOverflowStrategy[] r0 = io.reactivex.BackpressureOverflowStrategy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$reactivex$BackpressureOverflowStrategy = r0
                io.reactivex.BackpressureOverflowStrategy r1 = io.reactivex.BackpressureOverflowStrategy.DROP_LATEST     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$reactivex$BackpressureOverflowStrategy     // Catch:{ NoSuchFieldError -> 0x001d }
                io.reactivex.BackpressureOverflowStrategy r1 = io.reactivex.BackpressureOverflowStrategy.DROP_OLDEST     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableOnBackpressureBufferStrategy.AnonymousClass1.<clinit>():void");
        }
    }
}
