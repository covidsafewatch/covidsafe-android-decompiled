package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Notification;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Observable.Operator;
import rx.Producer;
import rx.Scheduler;
import rx.Scheduler.Worker;
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

public final class OnSubscribeRedo<T> implements OnSubscribe<T> {
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
                    if (((long) i) <= RedoFinite.this.count) {
                        notification = Notification.createOnNext(Integer.valueOf(this.num));
                    }
                    return notification;
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
            return observable.scan(Notification.createOnNext(Integer.valueOf(0)), new Func2<Notification<Integer>, Notification<?>, Notification<Integer>>() {
                public Notification<Integer> call(Notification<Integer> notification, Notification<?> notification2) {
                    int intValue = ((Integer) notification.getValue()).intValue();
                    return ((Boolean) RetryWithPredicate.this.predicate.call(Integer.valueOf(intValue), notification2.getThrowable())).booleanValue() ? Notification.createOnNext(Integer.valueOf(intValue + 1)) : notification2;
                }
            });
        }
    }

    public static <T> Observable<T> retry(Observable<T> observable) {
        return retry(observable, REDO_INFINITE);
    }

    public static <T> Observable<T> retry(Observable<T> observable, long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException("count >= 0 expected");
        } else if (i == 0) {
            return observable;
        } else {
            return retry(observable, (Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>>) new RedoFinite<Object,Object>(j));
        }
    }

    public static <T> Observable<T> retry(Observable<T> observable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> func1) {
        OnSubscribeRedo onSubscribeRedo = new OnSubscribeRedo(observable, func1, true, false, Schedulers.trampoline());
        return Observable.unsafeCreate(onSubscribeRedo);
    }

    public static <T> Observable<T> retry(Observable<T> observable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> func1, Scheduler scheduler2) {
        OnSubscribeRedo onSubscribeRedo = new OnSubscribeRedo(observable, func1, true, false, scheduler2);
        return Observable.unsafeCreate(onSubscribeRedo);
    }

    public static <T> Observable<T> repeat(Observable<T> observable) {
        return repeat(observable, Schedulers.trampoline());
    }

    public static <T> Observable<T> repeat(Observable<T> observable, Scheduler scheduler2) {
        return repeat(observable, REDO_INFINITE, scheduler2);
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
            return repeat(observable, (Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>>) new RedoFinite<Object,Object>(j - 1), scheduler2);
        }
        throw new IllegalArgumentException("count >= 0 expected");
    }

    public static <T> Observable<T> repeat(Observable<T> observable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> func1) {
        OnSubscribeRedo onSubscribeRedo = new OnSubscribeRedo(observable, func1, false, true, Schedulers.trampoline());
        return Observable.unsafeCreate(onSubscribeRedo);
    }

    public static <T> Observable<T> repeat(Observable<T> observable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> func1, Scheduler scheduler2) {
        OnSubscribeRedo onSubscribeRedo = new OnSubscribeRedo(observable, func1, false, true, scheduler2);
        return Observable.unsafeCreate(onSubscribeRedo);
    }

    public static <T> Observable<T> redo(Observable<T> observable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> func1, Scheduler scheduler2) {
        OnSubscribeRedo onSubscribeRedo = new OnSubscribeRedo(observable, func1, false, false, scheduler2);
        return Observable.unsafeCreate(onSubscribeRedo);
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
        Worker createWorker = this.scheduler.createWorker();
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

                        private void decrementConsumerCapacity() {
                            long j;
                            do {
                                j = atomicLong2.get();
                                if (j == LongCompanionObject.MAX_VALUE) {
                                    return;
                                }
                            } while (!atomicLong2.compareAndSet(j, j - 1));
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
        final Observable observable = (Observable) this.controlHandlerFunction.call(serialized.lift(new Operator<Notification<?>, Notification<?>>() {
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
        final Worker worker = createWorker;
        final AnonymousClass2 r6 = r1;
        final AtomicBoolean atomicBoolean2 = atomicBoolean;
        AnonymousClass4 r0 = new Action0() {
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
        };
        createWorker.schedule(r0);
        final AtomicLong atomicLong4 = atomicLong;
        final ProducerArbiter producerArbiter3 = producerArbiter;
        final AtomicBoolean atomicBoolean3 = atomicBoolean;
        AnonymousClass5 r02 = new Producer() {
            public void request(long j) {
                if (j > 0) {
                    BackpressureUtils.getAndAddRequest(atomicLong4, j);
                    producerArbiter3.request(j);
                    if (atomicBoolean3.compareAndSet(true, false)) {
                        worker.schedule(r6);
                    }
                }
            }
        };
        subscriber.setProducer(r02);
    }
}
