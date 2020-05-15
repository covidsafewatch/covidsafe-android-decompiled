package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable;
import rx.Producer;
import rx.Single;
import rx.SingleSubscriber;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.internal.util.ExceptionsUtils;
import rx.internal.util.atomic.MpscLinkedAtomicQueue;
import rx.internal.util.unsafe.MpscLinkedQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;

public final class OnSubscribeFlatMapSingle<T, R> implements Observable.OnSubscribe<R> {
    final boolean delayErrors;
    final Func1<? super T, ? extends Single<? extends R>> mapper;
    final int maxConcurrency;
    final Observable<T> source;

    public OnSubscribeFlatMapSingle(Observable<T> observable, Func1<? super T, ? extends Single<? extends R>> func1, boolean z, int i) {
        if (func1 == null) {
            throw new NullPointerException("mapper is null");
        } else if (i > 0) {
            this.source = observable;
            this.mapper = func1;
            this.delayErrors = z;
            this.maxConcurrency = i;
        } else {
            throw new IllegalArgumentException("maxConcurrency > 0 required but it was " + i);
        }
    }

    public void call(Subscriber<? super R> subscriber) {
        FlatMapSingleSubscriber flatMapSingleSubscriber = new FlatMapSingleSubscriber(subscriber, this.mapper, this.delayErrors, this.maxConcurrency);
        subscriber.add(flatMapSingleSubscriber.set);
        subscriber.add(flatMapSingleSubscriber.requested);
        subscriber.setProducer(flatMapSingleSubscriber.requested);
        this.source.unsafeSubscribe(flatMapSingleSubscriber);
    }

    static final class FlatMapSingleSubscriber<T, R> extends Subscriber<T> {
        final AtomicInteger active = new AtomicInteger();
        final Subscriber<? super R> actual;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final AtomicReference<Throwable> errors = new AtomicReference<>();
        final Func1<? super T, ? extends Single<? extends R>> mapper;
        final int maxConcurrency;
        final Queue<Object> queue;
        final FlatMapSingleSubscriber<T, R>.Requested requested = new Requested();
        final CompositeSubscription set = new CompositeSubscription();
        final AtomicInteger wip = new AtomicInteger();

        FlatMapSingleSubscriber(Subscriber<? super R> subscriber, Func1<? super T, ? extends Single<? extends R>> func1, boolean z, int i) {
            this.actual = subscriber;
            this.mapper = func1;
            this.delayErrors = z;
            this.maxConcurrency = i;
            if (UnsafeAccess.isUnsafeAvailable()) {
                this.queue = new MpscLinkedQueue();
            } else {
                this.queue = new MpscLinkedAtomicQueue();
            }
            request(i != Integer.MAX_VALUE ? (long) i : LongCompanionObject.MAX_VALUE);
        }

        public void onNext(T t) {
            try {
                Single single = (Single) this.mapper.call(t);
                if (single != null) {
                    InnerSubscriber innerSubscriber = new InnerSubscriber();
                    this.set.add(innerSubscriber);
                    this.active.incrementAndGet();
                    single.subscribe(innerSubscriber);
                    return;
                }
                throw new NullPointerException("The mapper returned a null Single");
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                unsubscribe();
                onError(th);
            }
        }

        public void onError(Throwable th) {
            if (this.delayErrors) {
                ExceptionsUtils.addThrowable(this.errors, th);
            } else {
                this.set.unsubscribe();
                if (!this.errors.compareAndSet((Object) null, th)) {
                    RxJavaHooks.onError(th);
                    return;
                }
            }
            this.done = true;
            drain();
        }

        public void onCompleted() {
            this.done = true;
            drain();
        }

        /* access modifiers changed from: package-private */
        public void innerSuccess(FlatMapSingleSubscriber<T, R>.InnerSubscriber innerSubscriber, R r) {
            this.queue.offer(NotificationLite.next(r));
            this.set.remove(innerSubscriber);
            this.active.decrementAndGet();
            drain();
        }

        /* access modifiers changed from: package-private */
        public void innerError(FlatMapSingleSubscriber<T, R>.InnerSubscriber innerSubscriber, Throwable th) {
            if (this.delayErrors) {
                ExceptionsUtils.addThrowable(this.errors, th);
                this.set.remove(innerSubscriber);
                if (!this.done && this.maxConcurrency != Integer.MAX_VALUE) {
                    request(1);
                }
            } else {
                this.set.unsubscribe();
                unsubscribe();
                if (!this.errors.compareAndSet((Object) null, th)) {
                    RxJavaHooks.onError(th);
                    return;
                }
                this.done = true;
            }
            this.active.decrementAndGet();
            drain();
        }

        /* access modifiers changed from: package-private */
        public void drain() {
            int i;
            if (this.wip.getAndIncrement() == 0) {
                Subscriber<? super R> subscriber = this.actual;
                Queue<Object> queue2 = this.queue;
                boolean z = this.delayErrors;
                AtomicInteger atomicInteger = this.active;
                int i2 = 1;
                do {
                    long j = this.requested.get();
                    long j2 = 0;
                    while (true) {
                        i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                        if (i == 0) {
                            break;
                        } else if (this.cancelled) {
                            queue2.clear();
                            return;
                        } else {
                            boolean z2 = this.done;
                            if (z || !z2 || this.errors.get() == null) {
                                Object poll = queue2.poll();
                                boolean z3 = poll == null;
                                if (!z2 || atomicInteger.get() != 0 || !z3) {
                                    if (z3) {
                                        break;
                                    }
                                    subscriber.onNext(NotificationLite.getValue(poll));
                                    j2++;
                                } else if (this.errors.get() != null) {
                                    subscriber.onError(ExceptionsUtils.terminate(this.errors));
                                    return;
                                } else {
                                    subscriber.onCompleted();
                                    return;
                                }
                            } else {
                                queue2.clear();
                                subscriber.onError(ExceptionsUtils.terminate(this.errors));
                                return;
                            }
                        }
                    }
                    if (i == 0) {
                        if (this.cancelled) {
                            queue2.clear();
                            return;
                        } else if (this.done) {
                            if (z) {
                                if (atomicInteger.get() == 0 && queue2.isEmpty()) {
                                    if (this.errors.get() != null) {
                                        subscriber.onError(ExceptionsUtils.terminate(this.errors));
                                        return;
                                    } else {
                                        subscriber.onCompleted();
                                        return;
                                    }
                                }
                            } else if (this.errors.get() != null) {
                                queue2.clear();
                                subscriber.onError(ExceptionsUtils.terminate(this.errors));
                                return;
                            } else if (atomicInteger.get() == 0 && queue2.isEmpty()) {
                                subscriber.onCompleted();
                                return;
                            }
                        }
                    }
                    if (j2 != 0) {
                        this.requested.produced(j2);
                        if (!this.done && this.maxConcurrency != Integer.MAX_VALUE) {
                            request(j2);
                        }
                    }
                    i2 = this.wip.addAndGet(-i2);
                } while (i2 != 0);
            }
        }

        final class Requested extends AtomicLong implements Producer, Subscription {
            private static final long serialVersionUID = -887187595446742742L;

            Requested() {
            }

            public void request(long j) {
                if (j > 0) {
                    BackpressureUtils.getAndAddRequest(this, j);
                    FlatMapSingleSubscriber.this.drain();
                }
            }

            /* access modifiers changed from: package-private */
            public void produced(long j) {
                BackpressureUtils.produced(this, j);
            }

            public void unsubscribe() {
                FlatMapSingleSubscriber.this.cancelled = true;
                FlatMapSingleSubscriber.this.unsubscribe();
                if (FlatMapSingleSubscriber.this.wip.getAndIncrement() == 0) {
                    FlatMapSingleSubscriber.this.queue.clear();
                }
            }

            public boolean isUnsubscribed() {
                return FlatMapSingleSubscriber.this.cancelled;
            }
        }

        final class InnerSubscriber extends SingleSubscriber<R> {
            InnerSubscriber() {
            }

            public void onSuccess(R r) {
                FlatMapSingleSubscriber.this.innerSuccess(this, r);
            }

            public void onError(Throwable th) {
                FlatMapSingleSubscriber.this.innerError(this, th);
            }
        }
    }
}
