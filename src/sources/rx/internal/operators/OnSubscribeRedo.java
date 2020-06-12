package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Notification;
import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.internal.producers.ProducerArbiter;
import rx.observers.Subscribers;
import rx.schedulers.Schedulers;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;
import rx.subscriptions.SerialSubscription;

public final class OnSubscribeRedo<T> implements Observable.OnSubscribe<T> {
    static final Func1<Observable<? extends Notification<?>>, Observable<?>> REDO_INFINITE = new Func1<Observable<? extends Notification<?>>, Observable<?>>() {
        public Observable<?> call(Observable<? extends Notification<?>> observable) {
            return observable.map(new Func1<Notification<?>, Notification<?>>() {
                public Notification<?> call(Notification<?> notification) {
                    return Notification.createOnNext(null);
                }
            });
        }
    };
    private final Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> controlHandlerFunction;
    private final Scheduler scheduler;
    final Observable<T> source;
    final boolean stopOnComplete;
    final boolean stopOnError;

    public static final class RedoFinite implements Func1<Observable<? extends Notification<?>>, Observable<?>> {
        final long count;

        public RedoFinite(long j) {
            this.count = j;
        }

        public Observable<?> call(Observable<? extends Notification<?>> observable) {
            return observable.map(new Func1<Notification<?>, Notification<?>>() {
                int num;

                public Notification<?> call(Notification<?> notification) {
                    if (RedoFinite.this.count == 0) {
                        return notification;
                    }
                    int i = this.num + 1;
                    this.num = i;
                    return ((long) i) <= RedoFinite.this.count ? Notification.createOnNext(Integer.valueOf(this.num)) : notification;
                }
            }).dematerialize();
        }
    }

    public static final class RetryWithPredicate implements Func1<Observable<? extends Notification<?>>, Observable<? extends Notification<?>>> {
        final Func2<Integer, Throwable, Boolean> predicate;

        public RetryWithPredicate(Func2<Integer, Throwable, Boolean> func2) {
            this.predicate = func2;
        }

        public Observable<? extends Notification<?>> call(Observable<? extends Notification<?>> observable) {
            return observable.scan(Notification.createOnNext(0), new Func2<Notification<Integer>, Notification<?>, Notification<Integer>>() {
                public Notification<Integer> call(Notification<Integer> notification, Notification<?> notification2) {
                    int intValue = notification.getValue().intValue();
                    return RetryWithPredicate.this.predicate.call(Integer.valueOf(intValue), notification2.getThrowable()).booleanValue() ? Notification.createOnNext(Integer.valueOf(intValue + 1)) : notification2;
                }
            });
        }
    }

    public static <T> Observable<T> retry(Observable<T> observable) {
        return retry(observable, (Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>>) REDO_INFINITE);
    }

    public static <T> Observable<T> retry(Observable<T> observable, long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException("count >= 0 expected");
        } else if (i == 0) {
            return observable;
        } else {
            return retry(observable, (Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>>) new RedoFinite(j));
        }
    }

    public static <T> Observable<T> retry(Observable<T> observable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> func1) {
        return Observable.unsafeCreate(new OnSubscribeRedo(observable, func1, true, false, Schedulers.trampoline()));
    }

    public static <T> Observable<T> retry(Observable<T> observable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> func1, Scheduler scheduler2) {
        return Observable.unsafeCreate(new OnSubscribeRedo(observable, func1, true, false, scheduler2));
    }

    public static <T> Observable<T> repeat(Observable<T> observable) {
        return repeat(observable, Schedulers.trampoline());
    }

    public static <T> Observable<T> repeat(Observable<T> observable, Scheduler scheduler2) {
        return repeat(observable, (Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>>) REDO_INFINITE, scheduler2);
    }

    public static <T> Observable<T> repeat(Observable<T> observable, long j) {
        return repeat(observable, j, Schedulers.trampoline());
    }

    public static <T> Observable<T> repeat(Observable<T> observable, long j, Scheduler scheduler2) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i == 0) {
            return Observable.empty();
        }
        if (i >= 0) {
            return repeat(observable, (Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>>) new RedoFinite(j - 1), scheduler2);
        }
        throw new IllegalArgumentException("count >= 0 expected");
    }

    public static <T> Observable<T> repeat(Observable<T> observable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> func1) {
        return Observable.unsafeCreate(new OnSubscribeRedo(observable, func1, false, true, Schedulers.trampoline()));
    }

    public static <T> Observable<T> repeat(Observable<T> observable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> func1, Scheduler scheduler2) {
        return Observable.unsafeCreate(new OnSubscribeRedo(observable, func1, false, true, scheduler2));
    }

    public static <T> Observable<T> redo(Observable<T> observable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> func1, Scheduler scheduler2) {
        return Observable.unsafeCreate(new OnSubscribeRedo(observable, func1, false, false, scheduler2));
    }

    private OnSubscribeRedo(Observable<T> observable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> func1, boolean z, boolean z2, Scheduler scheduler2) {
        this.source = observable;
        this.controlHandlerFunction = func1;
        this.stopOnComplete = z;
        this.stopOnError = z2;
        this.scheduler = scheduler2;
    }

    public void call(Subscriber<? super T> subscriber) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        AtomicLong atomicLong = new AtomicLong();
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        subscriber.add(createWorker);
        final SerialSubscription serialSubscription = new SerialSubscription();
        subscriber.add(serialSubscription);
        SerializedSubject serialized = BehaviorSubject.create().toSerialized();
        serialized.subscribe(Subscribers.empty());
        ProducerArbiter producerArbiter = new ProducerArbiter();
        final Subscriber<? super T> subscriber2 = subscriber;
        final SerializedSubject serializedSubject = serialized;
        final ProducerArbiter producerArbiter2 = producerArbiter;
        final AtomicLong atomicLong2 = atomicLong;
        AnonymousClass2 r1 = new Action0() {
            public void call() {
                if (!subscriber2.isUnsubscribed()) {
                    AnonymousClass1 r0 = new Subscriber<T>() {
                        boolean done;

                        public void onCompleted() {
                            if (!this.done) {
                                this.done = true;
                                unsubscribe();
                                serializedSubject.onNext(Notification.createOnCompleted());
                            }
                        }

                        public void onError(Throwable th) {
                            if (!this.done) {
                                this.done = true;
                                unsubscribe();
                                serializedSubject.onNext(Notification.createOnError(th));
                            }
                        }

                        public void onNext(T t) {
                            if (!this.done) {
                                subscriber2.onNext(t);
                                decrementConsumerCapacity();
                                producerArbiter2.produced(1);
                            }
                        }

                        /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        private void decrementConsumerCapacity() {
                            /*
                                r5 = this;
                            L_0x0000:
                                rx.internal.operators.OnSubscribeRedo$2 r0 = rx.internal.operators.OnSubscribeRedo.AnonymousClass2.this
                                java.util.concurrent.atomic.AtomicLong r0 = r6
                                long r0 = r0.get()
                                r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                                if (r4 == 0) goto L_0x001f
                                rx.internal.operators.OnSubscribeRedo$2 r2 = rx.internal.operators.OnSubscribeRedo.AnonymousClass2.this
                                java.util.concurrent.atomic.AtomicLong r2 = r6
                                r3 = 1
                                long r3 = r0 - r3
                                boolean r0 = r2.compareAndSet(r0, r3)
                                if (r0 == 0) goto L_0x0000
                            L_0x001f:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OnSubscribeRedo.AnonymousClass2.AnonymousClass1.decrementConsumerCapacity():void");
                        }

                        public void setProducer(Producer producer) {
                            producerArbiter2.setProducer(producer);
                        }
                    };
                    serialSubscription.set(r0);
                    OnSubscribeRedo.this.source.unsafeSubscribe(r0);
                }
            }
        };
        final Observable observable = (Observable) this.controlHandlerFunction.call(serialized.lift(new Observable.Operator<Notification<?>, Notification<?>>() {
            public Subscriber<? super Notification<?>> call(final Subscriber<? super Notification<?>> subscriber) {
                return new Subscriber<Notification<?>>(subscriber) {
                    public void onCompleted() {
                        subscriber.onCompleted();
                    }

                    public void onError(Throwable th) {
                        subscriber.onError(th);
                    }

                    public void onNext(Notification<?> notification) {
                        if (notification.isOnCompleted() && OnSubscribeRedo.this.stopOnComplete) {
                            subscriber.onCompleted();
                        } else if (!notification.isOnError() || !OnSubscribeRedo.this.stopOnError) {
                            subscriber.onNext(notification);
                        } else {
                            subscriber.onError(notification.getThrowable());
                        }
                    }

                    public void setProducer(Producer producer) {
                        producer.request(LongCompanionObject.MAX_VALUE);
                    }
                };
            }
        }));
        final AtomicLong atomicLong3 = atomicLong;
        final Scheduler.Worker worker = createWorker;
        final AnonymousClass2 r6 = r1;
        final AtomicBoolean atomicBoolean2 = atomicBoolean;
        createWorker.schedule(new Action0() {
            public void call() {
                observable.unsafeSubscribe(new Subscriber<Object>(subscriber2) {
                    public void onCompleted() {
                        subscriber2.onCompleted();
                    }

                    public void onError(Throwable th) {
                        subscriber2.onError(th);
                    }

                    public void onNext(Object obj) {
                        if (subscriber2.isUnsubscribed()) {
                            return;
                        }
                        if (atomicLong3.get() > 0) {
                            worker.schedule(r6);
                        } else {
                            atomicBoolean2.compareAndSet(false, true);
                        }
                    }

                    public void setProducer(Producer producer) {
                        producer.request(LongCompanionObject.MAX_VALUE);
                    }
                });
            }
        });
        final AtomicLong atomicLong4 = atomicLong;
        final ProducerArbiter producerArbiter3 = producerArbiter;
        final AtomicBoolean atomicBoolean3 = atomicBoolean;
        subscriber.setProducer(new Producer() {
            public void request(long j) {
                if (j > 0) {
                    BackpressureUtils.getAndAddRequest(atomicLong4, j);
                    producerArbiter3.request(j);
                    if (atomicBoolean3.compareAndSet(true, false)) {
                        worker.schedule(r6);
                    }
                }
            }
        });
    }
}
