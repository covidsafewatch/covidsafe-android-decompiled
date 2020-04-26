package rx;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Scheduler.Worker;
import rx.exceptions.CompositeException;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Actions;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.internal.observers.AssertableSubscriberObservable;
import rx.internal.operators.CompletableFromEmitter;
import rx.internal.operators.CompletableOnSubscribeConcat;
import rx.internal.operators.CompletableOnSubscribeConcatArray;
import rx.internal.operators.CompletableOnSubscribeConcatIterable;
import rx.internal.operators.CompletableOnSubscribeMerge;
import rx.internal.operators.CompletableOnSubscribeMergeArray;
import rx.internal.operators.CompletableOnSubscribeMergeDelayErrorArray;
import rx.internal.operators.CompletableOnSubscribeMergeDelayErrorIterable;
import rx.internal.operators.CompletableOnSubscribeMergeIterable;
import rx.internal.operators.CompletableOnSubscribeTimeout;
import rx.internal.util.SubscriptionList;
import rx.internal.util.UtilityFunctions;
import rx.observers.AssertableSubscriber;
import rx.observers.SafeCompletableSubscriber;
import rx.observers.SafeSubscriber;
import rx.plugins.RxJavaHooks;
import rx.schedulers.Schedulers;
import rx.subscriptions.BooleanSubscription;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.MultipleAssignmentSubscription;
import rx.subscriptions.SerialSubscription;
import rx.subscriptions.Subscriptions;

public class Completable {
    static final Completable COMPLETE = new Completable(new OnSubscribe() {
        public void call(CompletableSubscriber completableSubscriber) {
            completableSubscriber.onSubscribe(Subscriptions.unsubscribed());
            completableSubscriber.onCompleted();
        }
    }, false);
    static final Completable NEVER = new Completable(new OnSubscribe() {
        public void call(CompletableSubscriber completableSubscriber) {
            completableSubscriber.onSubscribe(Subscriptions.unsubscribed());
        }
    }, false);
    private final OnSubscribe onSubscribe;

    public interface OnSubscribe extends Action1<CompletableSubscriber> {
    }

    public interface Operator extends Func1<CompletableSubscriber, CompletableSubscriber> {
    }

    public interface Transformer extends Func1<Completable, Completable> {
    }

    public static Completable amb(final Completable... completableArr) {
        requireNonNull(completableArr);
        if (completableArr.length == 0) {
            return complete();
        }
        if (completableArr.length == 1) {
            return completableArr[0];
        }
        return create(new OnSubscribe() {
            public void call(final CompletableSubscriber completableSubscriber) {
                final CompositeSubscription compositeSubscription = new CompositeSubscription();
                completableSubscriber.onSubscribe(compositeSubscription);
                final AtomicBoolean atomicBoolean = new AtomicBoolean();
                AnonymousClass1 r2 = new CompletableSubscriber() {
                    public void onCompleted() {
                        if (atomicBoolean.compareAndSet(false, true)) {
                            compositeSubscription.unsubscribe();
                            completableSubscriber.onCompleted();
                        }
                    }

                    public void onError(Throwable th) {
                        if (atomicBoolean.compareAndSet(false, true)) {
                            compositeSubscription.unsubscribe();
                            completableSubscriber.onError(th);
                            return;
                        }
                        RxJavaHooks.onError(th);
                    }

                    public void onSubscribe(Subscription subscription) {
                        compositeSubscription.add(subscription);
                    }
                };
                Completable[] completableArr = completableArr;
                int length = completableArr.length;
                int i = 0;
                while (i < length) {
                    Completable completable = completableArr[i];
                    if (!compositeSubscription.isUnsubscribed()) {
                        if (completable != null) {
                            if (atomicBoolean.get() || compositeSubscription.isUnsubscribed()) {
                                break;
                            }
                            completable.unsafeSubscribe((CompletableSubscriber) r2);
                            i++;
                        } else {
                            NullPointerException nullPointerException = new NullPointerException("One of the sources is null");
                            if (atomicBoolean.compareAndSet(false, true)) {
                                compositeSubscription.unsubscribe();
                                completableSubscriber.onError(nullPointerException);
                            } else {
                                RxJavaHooks.onError(nullPointerException);
                            }
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        });
    }

    public static Completable amb(final Iterable<? extends Completable> iterable) {
        requireNonNull(iterable);
        return create(new OnSubscribe() {
            public void call(final CompletableSubscriber completableSubscriber) {
                final CompositeSubscription compositeSubscription = new CompositeSubscription();
                completableSubscriber.onSubscribe(compositeSubscription);
                try {
                    Iterator it = iterable.iterator();
                    if (it == null) {
                        completableSubscriber.onError(new NullPointerException("The iterator returned is null"));
                        return;
                    }
                    final AtomicBoolean atomicBoolean = new AtomicBoolean();
                    AnonymousClass1 r3 = new CompletableSubscriber() {
                        public void onCompleted() {
                            if (atomicBoolean.compareAndSet(false, true)) {
                                compositeSubscription.unsubscribe();
                                completableSubscriber.onCompleted();
                            }
                        }

                        public void onError(Throwable th) {
                            if (atomicBoolean.compareAndSet(false, true)) {
                                compositeSubscription.unsubscribe();
                                completableSubscriber.onError(th);
                                return;
                            }
                            RxJavaHooks.onError(th);
                        }

                        public void onSubscribe(Subscription subscription) {
                            compositeSubscription.add(subscription);
                        }
                    };
                    boolean z = true;
                    while (!atomicBoolean.get() && !compositeSubscription.isUnsubscribed()) {
                        try {
                            if (!it.hasNext()) {
                                if (z) {
                                    completableSubscriber.onCompleted();
                                }
                                return;
                            }
                            if (!atomicBoolean.get() && !compositeSubscription.isUnsubscribed()) {
                                try {
                                    Completable completable = (Completable) it.next();
                                    if (completable == null) {
                                        NullPointerException nullPointerException = new NullPointerException("One of the sources is null");
                                        if (atomicBoolean.compareAndSet(false, true)) {
                                            compositeSubscription.unsubscribe();
                                            completableSubscriber.onError(nullPointerException);
                                        } else {
                                            RxJavaHooks.onError(nullPointerException);
                                        }
                                        return;
                                    } else if (!atomicBoolean.get() && !compositeSubscription.isUnsubscribed()) {
                                        completable.unsafeSubscribe((CompletableSubscriber) r3);
                                        z = false;
                                    } else {
                                        return;
                                    }
                                } catch (Throwable th) {
                                    if (atomicBoolean.compareAndSet(false, true)) {
                                        compositeSubscription.unsubscribe();
                                        completableSubscriber.onError(th);
                                    } else {
                                        RxJavaHooks.onError(th);
                                    }
                                }
                            }
                            return;
                        } catch (Throwable th2) {
                            if (atomicBoolean.compareAndSet(false, true)) {
                                compositeSubscription.unsubscribe();
                                completableSubscriber.onError(th2);
                            } else {
                                RxJavaHooks.onError(th2);
                            }
                        }
                    }
                } catch (Throwable th3) {
                    completableSubscriber.onError(th3);
                }
            }
        });
    }

    public static Completable complete() {
        OnSubscribe onCreate = RxJavaHooks.onCreate(COMPLETE.onSubscribe);
        Completable completable = COMPLETE;
        if (onCreate == completable.onSubscribe) {
            return completable;
        }
        return new Completable(onCreate, false);
    }

    public static Completable concat(Completable... completableArr) {
        requireNonNull(completableArr);
        if (completableArr.length == 0) {
            return complete();
        }
        if (completableArr.length == 1) {
            return completableArr[0];
        }
        return create(new CompletableOnSubscribeConcatArray(completableArr));
    }

    public static Completable concat(Iterable<? extends Completable> iterable) {
        requireNonNull(iterable);
        return create(new CompletableOnSubscribeConcatIterable(iterable));
    }

    public static Completable concat(Observable<? extends Completable> observable) {
        return concat(observable, 2);
    }

    public static Completable concat(Observable<? extends Completable> observable, int i) {
        requireNonNull(observable);
        if (i >= 1) {
            return create(new CompletableOnSubscribeConcat(observable, i));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("prefetch > 0 required but it was ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    public static Completable create(OnSubscribe onSubscribe2) {
        requireNonNull(onSubscribe2);
        try {
            return new Completable(onSubscribe2);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            RxJavaHooks.onError(th);
            throw toNpe(th);
        }
    }

    public static Completable defer(final Func0<? extends Completable> func0) {
        requireNonNull(func0);
        return create(new OnSubscribe() {
            public void call(CompletableSubscriber completableSubscriber) {
                try {
                    Completable completable = (Completable) func0.call();
                    if (completable == null) {
                        completableSubscriber.onSubscribe(Subscriptions.unsubscribed());
                        completableSubscriber.onError(new NullPointerException("The completable returned is null"));
                        return;
                    }
                    completable.unsafeSubscribe(completableSubscriber);
                } catch (Throwable th) {
                    completableSubscriber.onSubscribe(Subscriptions.unsubscribed());
                    completableSubscriber.onError(th);
                }
            }
        });
    }

    public static Completable error(final Func0<? extends Throwable> func0) {
        requireNonNull(func0);
        return create(new OnSubscribe() {
            public void call(CompletableSubscriber completableSubscriber) {
                completableSubscriber.onSubscribe(Subscriptions.unsubscribed());
                try {
                    th = (Throwable) func0.call();
                } catch (Throwable th) {
                    th = th;
                }
                if (th == null) {
                    th = new NullPointerException("The error supplied is null");
                }
                completableSubscriber.onError(th);
            }
        });
    }

    public static Completable error(final Throwable th) {
        requireNonNull(th);
        return create(new OnSubscribe() {
            public void call(CompletableSubscriber completableSubscriber) {
                completableSubscriber.onSubscribe(Subscriptions.unsubscribed());
                completableSubscriber.onError(th);
            }
        });
    }

    public static Completable fromAction(final Action0 action0) {
        requireNonNull(action0);
        return create(new OnSubscribe() {
            public void call(CompletableSubscriber completableSubscriber) {
                BooleanSubscription booleanSubscription = new BooleanSubscription();
                completableSubscriber.onSubscribe(booleanSubscription);
                try {
                    action0.call();
                    if (!booleanSubscription.isUnsubscribed()) {
                        completableSubscriber.onCompleted();
                    }
                } catch (Throwable th) {
                    if (!booleanSubscription.isUnsubscribed()) {
                        completableSubscriber.onError(th);
                    }
                }
            }
        });
    }

    public static Completable fromCallable(final Callable<?> callable) {
        requireNonNull(callable);
        return create(new OnSubscribe() {
            public void call(CompletableSubscriber completableSubscriber) {
                BooleanSubscription booleanSubscription = new BooleanSubscription();
                completableSubscriber.onSubscribe(booleanSubscription);
                try {
                    callable.call();
                    if (!booleanSubscription.isUnsubscribed()) {
                        completableSubscriber.onCompleted();
                    }
                } catch (Throwable th) {
                    if (!booleanSubscription.isUnsubscribed()) {
                        completableSubscriber.onError(th);
                    }
                }
            }
        });
    }

    public static Completable fromEmitter(Action1<CompletableEmitter> action1) {
        return create(new CompletableFromEmitter(action1));
    }

    public static Completable fromFuture(Future<?> future) {
        requireNonNull(future);
        return fromObservable(Observable.from(future));
    }

    public static Completable fromObservable(final Observable<?> observable) {
        requireNonNull(observable);
        return create(new OnSubscribe() {
            public void call(final CompletableSubscriber completableSubscriber) {
                AnonymousClass1 r0 = new Subscriber<Object>() {
                    public void onNext(Object obj) {
                    }

                    public void onCompleted() {
                        completableSubscriber.onCompleted();
                    }

                    public void onError(Throwable th) {
                        completableSubscriber.onError(th);
                    }
                };
                completableSubscriber.onSubscribe(r0);
                observable.unsafeSubscribe(r0);
            }
        });
    }

    public static Completable fromSingle(final Single<?> single) {
        requireNonNull(single);
        return create(new OnSubscribe() {
            public void call(final CompletableSubscriber completableSubscriber) {
                AnonymousClass1 r0 = new SingleSubscriber<Object>() {
                    public void onError(Throwable th) {
                        completableSubscriber.onError(th);
                    }

                    public void onSuccess(Object obj) {
                        completableSubscriber.onCompleted();
                    }
                };
                completableSubscriber.onSubscribe(r0);
                single.subscribe((SingleSubscriber<? super T>) r0);
            }
        });
    }

    public static Completable merge(Completable... completableArr) {
        requireNonNull(completableArr);
        if (completableArr.length == 0) {
            return complete();
        }
        if (completableArr.length == 1) {
            return completableArr[0];
        }
        return create(new CompletableOnSubscribeMergeArray(completableArr));
    }

    public static Completable merge(Iterable<? extends Completable> iterable) {
        requireNonNull(iterable);
        return create(new CompletableOnSubscribeMergeIterable(iterable));
    }

    public static Completable merge(Observable<? extends Completable> observable) {
        return merge0(observable, Integer.MAX_VALUE, false);
    }

    public static Completable merge(Observable<? extends Completable> observable, int i) {
        return merge0(observable, i, false);
    }

    protected static Completable merge0(Observable<? extends Completable> observable, int i, boolean z) {
        requireNonNull(observable);
        if (i >= 1) {
            return create(new CompletableOnSubscribeMerge(observable, i, z));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("maxConcurrency > 0 required but it was ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    public static Completable mergeDelayError(Completable... completableArr) {
        requireNonNull(completableArr);
        return create(new CompletableOnSubscribeMergeDelayErrorArray(completableArr));
    }

    public static Completable mergeDelayError(Iterable<? extends Completable> iterable) {
        requireNonNull(iterable);
        return create(new CompletableOnSubscribeMergeDelayErrorIterable(iterable));
    }

    public static Completable mergeDelayError(Observable<? extends Completable> observable) {
        return merge0(observable, Integer.MAX_VALUE, true);
    }

    public static Completable mergeDelayError(Observable<? extends Completable> observable, int i) {
        return merge0(observable, i, true);
    }

    public static Completable never() {
        OnSubscribe onCreate = RxJavaHooks.onCreate(NEVER.onSubscribe);
        Completable completable = NEVER;
        if (onCreate == completable.onSubscribe) {
            return completable;
        }
        return new Completable(onCreate, false);
    }

    static <T> T requireNonNull(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    public static Completable timer(long j, TimeUnit timeUnit) {
        return timer(j, timeUnit, Schedulers.computation());
    }

    public static Completable timer(final long j, final TimeUnit timeUnit, final Scheduler scheduler) {
        requireNonNull(timeUnit);
        requireNonNull(scheduler);
        return create(new OnSubscribe() {
            public void call(final CompletableSubscriber completableSubscriber) {
                MultipleAssignmentSubscription multipleAssignmentSubscription = new MultipleAssignmentSubscription();
                completableSubscriber.onSubscribe(multipleAssignmentSubscription);
                if (!multipleAssignmentSubscription.isUnsubscribed()) {
                    final Worker createWorker = scheduler.createWorker();
                    multipleAssignmentSubscription.set(createWorker);
                    createWorker.schedule(new Action0() {
                        public void call() {
                            try {
                                completableSubscriber.onCompleted();
                            } finally {
                                createWorker.unsubscribe();
                            }
                        }
                    }, j, timeUnit);
                }
            }
        });
    }

    static NullPointerException toNpe(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    public static <R> Completable using(Func0<R> func0, Func1<? super R, ? extends Completable> func1, Action1<? super R> action1) {
        return using(func0, func1, action1, true);
    }

    public static <R> Completable using(final Func0<R> func0, final Func1<? super R, ? extends Completable> func1, final Action1<? super R> action1, final boolean z) {
        requireNonNull(func0);
        requireNonNull(func1);
        requireNonNull(action1);
        return create(new OnSubscribe() {
            public void call(final CompletableSubscriber completableSubscriber) {
                String str = "The completable supplied is null";
                try {
                    final Object call = func0.call();
                    try {
                        Completable completable = (Completable) func1.call(call);
                        if (completable == null) {
                            try {
                                action1.call(call);
                                completableSubscriber.onSubscribe(Subscriptions.unsubscribed());
                                completableSubscriber.onError(new NullPointerException(str));
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                completableSubscriber.onSubscribe(Subscriptions.unsubscribed());
                                completableSubscriber.onError(new CompositeException((Collection<? extends Throwable>) Arrays.asList(new Throwable[]{new NullPointerException(str), th})));
                            }
                        } else {
                            final AtomicBoolean atomicBoolean = new AtomicBoolean();
                            completable.unsafeSubscribe((CompletableSubscriber) new CompletableSubscriber() {
                                Subscription d;

                                /* access modifiers changed from: 0000 */
                                public void dispose() {
                                    this.d.unsubscribe();
                                    if (atomicBoolean.compareAndSet(false, true)) {
                                        try {
                                            action1.call(call);
                                        } catch (Throwable th) {
                                            RxJavaHooks.onError(th);
                                        }
                                    }
                                }

                                public void onCompleted() {
                                    if (z && atomicBoolean.compareAndSet(false, true)) {
                                        try {
                                            action1.call(call);
                                        } catch (Throwable th) {
                                            completableSubscriber.onError(th);
                                            return;
                                        }
                                    }
                                    completableSubscriber.onCompleted();
                                    if (!z) {
                                        dispose();
                                    }
                                }

                                public void onError(Throwable th) {
                                    if (z && atomicBoolean.compareAndSet(false, true)) {
                                        try {
                                            action1.call(call);
                                        } catch (Throwable th2) {
                                            th = new CompositeException((Collection<? extends Throwable>) Arrays.asList(new Throwable[]{th, th2}));
                                        }
                                    }
                                    completableSubscriber.onError(th);
                                    if (!z) {
                                        dispose();
                                    }
                                }

                                public void onSubscribe(Subscription subscription) {
                                    this.d = subscription;
                                    completableSubscriber.onSubscribe(Subscriptions.create(new Action0() {
                                        public void call() {
                                            AnonymousClass1.this.dispose();
                                        }
                                    }));
                                }
                            });
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th);
                        Exceptions.throwIfFatal(th2);
                        completableSubscriber.onSubscribe(Subscriptions.unsubscribed());
                        completableSubscriber.onError(new CompositeException((Collection<? extends Throwable>) Arrays.asList(new Throwable[]{th, th2})));
                    }
                } catch (Throwable th3) {
                    completableSubscriber.onSubscribe(Subscriptions.unsubscribed());
                    completableSubscriber.onError(th3);
                }
            }
        });
    }

    protected Completable(OnSubscribe onSubscribe2) {
        this.onSubscribe = RxJavaHooks.onCreate(onSubscribe2);
    }

    protected Completable(OnSubscribe onSubscribe2, boolean z) {
        if (z) {
            onSubscribe2 = RxJavaHooks.onCreate(onSubscribe2);
        }
        this.onSubscribe = onSubscribe2;
    }

    public final Completable ambWith(Completable completable) {
        requireNonNull(completable);
        return amb(this, completable);
    }

    public final void await() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final Throwable[] thArr = new Throwable[1];
        unsafeSubscribe((CompletableSubscriber) new CompletableSubscriber() {
            public void onSubscribe(Subscription subscription) {
            }

            public void onCompleted() {
                countDownLatch.countDown();
            }

            public void onError(Throwable th) {
                thArr[0] = th;
                countDownLatch.countDown();
            }
        });
        if (countDownLatch.getCount() == 0) {
            if (thArr[0] != null) {
                Exceptions.propagate(thArr[0]);
            }
            return;
        }
        try {
            countDownLatch.await();
            if (thArr[0] != null) {
                Exceptions.propagate(thArr[0]);
            }
        } catch (InterruptedException e) {
            throw Exceptions.propagate(e);
        }
    }

    public final boolean await(long j, TimeUnit timeUnit) {
        requireNonNull(timeUnit);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final Throwable[] thArr = new Throwable[1];
        unsafeSubscribe((CompletableSubscriber) new CompletableSubscriber() {
            public void onSubscribe(Subscription subscription) {
            }

            public void onCompleted() {
                countDownLatch.countDown();
            }

            public void onError(Throwable th) {
                thArr[0] = th;
                countDownLatch.countDown();
            }
        });
        if (countDownLatch.getCount() == 0) {
            if (thArr[0] != null) {
                Exceptions.propagate(thArr[0]);
            }
            return true;
        }
        try {
            boolean await = countDownLatch.await(j, timeUnit);
            if (await && thArr[0] != null) {
                Exceptions.propagate(thArr[0]);
            }
            return await;
        } catch (InterruptedException e) {
            throw Exceptions.propagate(e);
        }
    }

    public final Completable compose(Transformer transformer) {
        return (Completable) to(transformer);
    }

    public final <T> Observable<T> andThen(Observable<T> observable) {
        requireNonNull(observable);
        return observable.delaySubscription(toObservable());
    }

    public final <T> Single<T> andThen(Single<T> single) {
        requireNonNull(single);
        return single.delaySubscription(toObservable());
    }

    public final Completable andThen(Completable completable) {
        return concatWith(completable);
    }

    public final Completable concatWith(Completable completable) {
        requireNonNull(completable);
        return concat(this, completable);
    }

    public final Completable delay(long j, TimeUnit timeUnit) {
        return delay(j, timeUnit, Schedulers.computation(), false);
    }

    public final Completable delay(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return delay(j, timeUnit, scheduler, false);
    }

    public final Completable delay(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        requireNonNull(timeUnit);
        requireNonNull(scheduler);
        final Scheduler scheduler2 = scheduler;
        final long j2 = j;
        final TimeUnit timeUnit2 = timeUnit;
        final boolean z2 = z;
        AnonymousClass16 r0 = new OnSubscribe() {
            public void call(final CompletableSubscriber completableSubscriber) {
                final CompositeSubscription compositeSubscription = new CompositeSubscription();
                final Worker createWorker = scheduler2.createWorker();
                compositeSubscription.add(createWorker);
                Completable.this.unsafeSubscribe((CompletableSubscriber) new CompletableSubscriber() {
                    public void onCompleted() {
                        compositeSubscription.add(createWorker.schedule(new Action0() {
                            public void call() {
                                try {
                                    completableSubscriber.onCompleted();
                                } finally {
                                    createWorker.unsubscribe();
                                }
                            }
                        }, j2, timeUnit2));
                    }

                    public void onError(final Throwable th) {
                        if (z2) {
                            compositeSubscription.add(createWorker.schedule(new Action0() {
                                public void call() {
                                    try {
                                        completableSubscriber.onError(th);
                                    } finally {
                                        createWorker.unsubscribe();
                                    }
                                }
                            }, j2, timeUnit2));
                        } else {
                            completableSubscriber.onError(th);
                        }
                    }

                    public void onSubscribe(Subscription subscription) {
                        compositeSubscription.add(subscription);
                        completableSubscriber.onSubscribe(compositeSubscription);
                    }
                });
            }
        };
        return create(r0);
    }

    public final Completable doOnCompleted(Action0 action0) {
        return doOnLifecycle(Actions.empty(), Actions.empty(), action0, Actions.empty(), Actions.empty());
    }

    public final Completable doOnEach(final Action1<Notification<Object>> action1) {
        if (action1 != null) {
            return doOnLifecycle(Actions.empty(), new Action1<Throwable>() {
                public void call(Throwable th) {
                    action1.call(Notification.createOnError(th));
                }
            }, new Action0() {
                public void call() {
                    action1.call(Notification.createOnCompleted());
                }
            }, Actions.empty(), Actions.empty());
        }
        throw new IllegalArgumentException("onNotification is null");
    }

    public final Completable doOnUnsubscribe(Action0 action0) {
        return doOnLifecycle(Actions.empty(), Actions.empty(), Actions.empty(), Actions.empty(), action0);
    }

    public final Completable doOnError(Action1<? super Throwable> action1) {
        return doOnLifecycle(Actions.empty(), action1, Actions.empty(), Actions.empty(), Actions.empty());
    }

    /* access modifiers changed from: protected */
    public final Completable doOnLifecycle(Action1<? super Subscription> action1, Action1<? super Throwable> action12, Action0 action0, Action0 action02, Action0 action03) {
        requireNonNull(action1);
        requireNonNull(action12);
        requireNonNull(action0);
        requireNonNull(action02);
        requireNonNull(action03);
        final Action0 action04 = action0;
        final Action0 action05 = action02;
        final Action1<? super Throwable> action13 = action12;
        final Action1<? super Subscription> action14 = action1;
        final Action0 action06 = action03;
        AnonymousClass19 r0 = new OnSubscribe() {
            public void call(final CompletableSubscriber completableSubscriber) {
                Completable.this.unsafeSubscribe((CompletableSubscriber) new CompletableSubscriber() {
                    public void onCompleted() {
                        try {
                            action04.call();
                            completableSubscriber.onCompleted();
                            try {
                                action05.call();
                            } catch (Throwable th) {
                                RxJavaHooks.onError(th);
                            }
                        } catch (Throwable th2) {
                            completableSubscriber.onError(th2);
                        }
                    }

                    public void onError(Throwable th) {
                        try {
                            action13.call(th);
                        } catch (Throwable th2) {
                            th = new CompositeException((Collection<? extends Throwable>) Arrays.asList(new Throwable[]{th, th2}));
                        }
                        completableSubscriber.onError(th);
                        try {
                            action05.call();
                        } catch (Throwable th3) {
                            RxJavaHooks.onError(th3);
                        }
                    }

                    public void onSubscribe(final Subscription subscription) {
                        try {
                            action14.call(subscription);
                            completableSubscriber.onSubscribe(Subscriptions.create(new Action0() {
                                public void call() {
                                    try {
                                        action06.call();
                                    } catch (Throwable th) {
                                        RxJavaHooks.onError(th);
                                    }
                                    subscription.unsubscribe();
                                }
                            }));
                        } catch (Throwable th) {
                            subscription.unsubscribe();
                            completableSubscriber.onSubscribe(Subscriptions.unsubscribed());
                            completableSubscriber.onError(th);
                        }
                    }
                });
            }
        };
        return create(r0);
    }

    public final Completable doOnSubscribe(Action1<? super Subscription> action1) {
        return doOnLifecycle(action1, Actions.empty(), Actions.empty(), Actions.empty(), Actions.empty());
    }

    public final Completable doOnTerminate(final Action0 action0) {
        return doOnLifecycle(Actions.empty(), new Action1<Throwable>() {
            public void call(Throwable th) {
                action0.call();
            }
        }, action0, Actions.empty(), Actions.empty());
    }

    public final Completable doAfterTerminate(Action0 action0) {
        return doOnLifecycle(Actions.empty(), Actions.empty(), Actions.empty(), action0, Actions.empty());
    }

    public final Throwable get() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final Throwable[] thArr = new Throwable[1];
        unsafeSubscribe((CompletableSubscriber) new CompletableSubscriber() {
            public void onSubscribe(Subscription subscription) {
            }

            public void onCompleted() {
                countDownLatch.countDown();
            }

            public void onError(Throwable th) {
                thArr[0] = th;
                countDownLatch.countDown();
            }
        });
        if (countDownLatch.getCount() == 0) {
            return thArr[0];
        }
        try {
            countDownLatch.await();
            return thArr[0];
        } catch (InterruptedException e) {
            throw Exceptions.propagate(e);
        }
    }

    public final Throwable get(long j, TimeUnit timeUnit) {
        requireNonNull(timeUnit);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final Throwable[] thArr = new Throwable[1];
        unsafeSubscribe((CompletableSubscriber) new CompletableSubscriber() {
            public void onSubscribe(Subscription subscription) {
            }

            public void onCompleted() {
                countDownLatch.countDown();
            }

            public void onError(Throwable th) {
                thArr[0] = th;
                countDownLatch.countDown();
            }
        });
        if (countDownLatch.getCount() == 0) {
            return thArr[0];
        }
        try {
            if (countDownLatch.await(j, timeUnit)) {
                return thArr[0];
            }
            Exceptions.propagate(new TimeoutException());
            return null;
        } catch (InterruptedException e) {
            throw Exceptions.propagate(e);
        }
    }

    public final Completable lift(final Operator operator) {
        requireNonNull(operator);
        return create(new OnSubscribe() {
            public void call(CompletableSubscriber completableSubscriber) {
                try {
                    Completable.this.unsafeSubscribe((CompletableSubscriber) RxJavaHooks.onCompletableLift(operator).call(completableSubscriber));
                } catch (NullPointerException e) {
                    throw e;
                } catch (Throwable th) {
                    throw Completable.toNpe(th);
                }
            }
        });
    }

    public final Completable mergeWith(Completable completable) {
        requireNonNull(completable);
        return merge(this, completable);
    }

    public final Completable observeOn(final Scheduler scheduler) {
        requireNonNull(scheduler);
        return create(new OnSubscribe() {
            public void call(final CompletableSubscriber completableSubscriber) {
                final SubscriptionList subscriptionList = new SubscriptionList();
                final Worker createWorker = scheduler.createWorker();
                subscriptionList.add(createWorker);
                completableSubscriber.onSubscribe(subscriptionList);
                Completable.this.unsafeSubscribe((CompletableSubscriber) new CompletableSubscriber() {
                    public void onCompleted() {
                        createWorker.schedule(new Action0() {
                            public void call() {
                                try {
                                    completableSubscriber.onCompleted();
                                } finally {
                                    subscriptionList.unsubscribe();
                                }
                            }
                        });
                    }

                    public void onError(final Throwable th) {
                        createWorker.schedule(new Action0() {
                            public void call() {
                                try {
                                    completableSubscriber.onError(th);
                                } finally {
                                    subscriptionList.unsubscribe();
                                }
                            }
                        });
                    }

                    public void onSubscribe(Subscription subscription) {
                        subscriptionList.add(subscription);
                    }
                });
            }
        });
    }

    public final Completable onErrorComplete() {
        return onErrorComplete(UtilityFunctions.alwaysTrue());
    }

    public final Completable onErrorComplete(final Func1<? super Throwable, Boolean> func1) {
        requireNonNull(func1);
        return create(new OnSubscribe() {
            public void call(final CompletableSubscriber completableSubscriber) {
                Completable.this.unsafeSubscribe((CompletableSubscriber) new CompletableSubscriber() {
                    public void onCompleted() {
                        completableSubscriber.onCompleted();
                    }

                    public void onError(Throwable th) {
                        boolean z = false;
                        try {
                            z = ((Boolean) func1.call(th)).booleanValue();
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            th = new CompositeException((Collection<? extends Throwable>) Arrays.asList(new Throwable[]{th, th2}));
                        }
                        if (z) {
                            completableSubscriber.onCompleted();
                        } else {
                            completableSubscriber.onError(th);
                        }
                    }

                    public void onSubscribe(Subscription subscription) {
                        completableSubscriber.onSubscribe(subscription);
                    }
                });
            }
        });
    }

    public final Completable onErrorResumeNext(final Func1<? super Throwable, ? extends Completable> func1) {
        requireNonNull(func1);
        return create(new OnSubscribe() {
            public void call(final CompletableSubscriber completableSubscriber) {
                final SerialSubscription serialSubscription = new SerialSubscription();
                completableSubscriber.onSubscribe(serialSubscription);
                Completable.this.unsafeSubscribe((CompletableSubscriber) new CompletableSubscriber() {
                    public void onCompleted() {
                        completableSubscriber.onCompleted();
                    }

                    public void onError(Throwable th) {
                        try {
                            Completable completable = (Completable) func1.call(th);
                            if (completable == null) {
                                completableSubscriber.onError(new CompositeException((Collection<? extends Throwable>) Arrays.asList(new Throwable[]{th, new NullPointerException("The completable returned is null")})));
                                return;
                            }
                            completable.unsafeSubscribe((CompletableSubscriber) new CompletableSubscriber() {
                                public void onCompleted() {
                                    completableSubscriber.onCompleted();
                                }

                                public void onError(Throwable th) {
                                    completableSubscriber.onError(th);
                                }

                                public void onSubscribe(Subscription subscription) {
                                    serialSubscription.set(subscription);
                                }
                            });
                        } catch (Throwable th2) {
                            completableSubscriber.onError(new CompositeException((Collection<? extends Throwable>) Arrays.asList(new Throwable[]{th, th2})));
                        }
                    }

                    public void onSubscribe(Subscription subscription) {
                        serialSubscription.set(subscription);
                    }
                });
            }
        });
    }

    public final Completable repeat() {
        return fromObservable(toObservable().repeat());
    }

    public final Completable repeat(long j) {
        return fromObservable(toObservable().repeat(j));
    }

    public final Completable repeatWhen(Func1<? super Observable<? extends Void>, ? extends Observable<?>> func1) {
        requireNonNull(func1);
        return fromObservable(toObservable().repeatWhen(func1));
    }

    public final Completable retry() {
        return fromObservable(toObservable().retry());
    }

    public final Completable retry(Func2<Integer, Throwable, Boolean> func2) {
        return fromObservable(toObservable().retry(func2));
    }

    public final Completable retry(long j) {
        return fromObservable(toObservable().retry(j));
    }

    public final Completable retryWhen(Func1<? super Observable<? extends Throwable>, ? extends Observable<?>> func1) {
        return fromObservable(toObservable().retryWhen(func1));
    }

    public final Completable startWith(Completable completable) {
        requireNonNull(completable);
        return concat(completable, this);
    }

    public final <T> Observable<T> startWith(Observable<T> observable) {
        requireNonNull(observable);
        return toObservable().startWith(observable);
    }

    public final Subscription subscribe() {
        final MultipleAssignmentSubscription multipleAssignmentSubscription = new MultipleAssignmentSubscription();
        unsafeSubscribe((CompletableSubscriber) new CompletableSubscriber() {
            public void onCompleted() {
                multipleAssignmentSubscription.unsubscribe();
            }

            public void onError(Throwable th) {
                RxJavaHooks.onError(th);
                multipleAssignmentSubscription.unsubscribe();
                Completable.deliverUncaughtException(th);
            }

            public void onSubscribe(Subscription subscription) {
                multipleAssignmentSubscription.set(subscription);
            }
        });
        return multipleAssignmentSubscription;
    }

    public final Subscription subscribe(final Action0 action0) {
        requireNonNull(action0);
        final MultipleAssignmentSubscription multipleAssignmentSubscription = new MultipleAssignmentSubscription();
        unsafeSubscribe((CompletableSubscriber) new CompletableSubscriber() {
            boolean done;

            public void onCompleted() {
                if (!this.done) {
                    this.done = true;
                    try {
                        action0.call();
                    } catch (Throwable th) {
                        multipleAssignmentSubscription.unsubscribe();
                        throw th;
                    }
                    multipleAssignmentSubscription.unsubscribe();
                }
            }

            public void onError(Throwable th) {
                RxJavaHooks.onError(th);
                multipleAssignmentSubscription.unsubscribe();
                Completable.deliverUncaughtException(th);
            }

            public void onSubscribe(Subscription subscription) {
                multipleAssignmentSubscription.set(subscription);
            }
        });
        return multipleAssignmentSubscription;
    }

    public final Subscription subscribe(final Action0 action0, final Action1<? super Throwable> action1) {
        requireNonNull(action0);
        requireNonNull(action1);
        final MultipleAssignmentSubscription multipleAssignmentSubscription = new MultipleAssignmentSubscription();
        unsafeSubscribe((CompletableSubscriber) new CompletableSubscriber() {
            boolean done;

            public void onCompleted() {
                if (!this.done) {
                    this.done = true;
                    try {
                        action0.call();
                        multipleAssignmentSubscription.unsubscribe();
                    } catch (Throwable th) {
                        callOnError(th);
                    }
                }
            }

            public void onError(Throwable th) {
                if (!this.done) {
                    this.done = true;
                    callOnError(th);
                    return;
                }
                RxJavaHooks.onError(th);
                Completable.deliverUncaughtException(th);
            }

            /* access modifiers changed from: 0000 */
            public void callOnError(Throwable th) {
                try {
                    action1.call(th);
                } catch (Throwable th2) {
                    multipleAssignmentSubscription.unsubscribe();
                    throw th2;
                }
                multipleAssignmentSubscription.unsubscribe();
            }

            public void onSubscribe(Subscription subscription) {
                multipleAssignmentSubscription.set(subscription);
            }
        });
        return multipleAssignmentSubscription;
    }

    static void deliverUncaughtException(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public final void unsafeSubscribe(CompletableSubscriber completableSubscriber) {
        requireNonNull(completableSubscriber);
        try {
            RxJavaHooks.onCompletableStart(this, this.onSubscribe).call(completableSubscriber);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            Throwable onCompletableError = RxJavaHooks.onCompletableError(th);
            RxJavaHooks.onError(onCompletableError);
            throw toNpe(onCompletableError);
        }
    }

    public final void subscribe(CompletableSubscriber completableSubscriber) {
        if (!(completableSubscriber instanceof SafeCompletableSubscriber)) {
            completableSubscriber = new SafeCompletableSubscriber(completableSubscriber);
        }
        unsafeSubscribe(completableSubscriber);
    }

    public final <T> void unsafeSubscribe(Subscriber<T> subscriber) {
        unsafeSubscribe(subscriber, true);
    }

    private <T> void unsafeSubscribe(final Subscriber<T> subscriber, boolean z) {
        requireNonNull(subscriber);
        if (z) {
            try {
                subscriber.onStart();
            } catch (NullPointerException e) {
                throw e;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                Throwable onObservableError = RxJavaHooks.onObservableError(th);
                RxJavaHooks.onError(onObservableError);
                throw toNpe(onObservableError);
            }
        }
        unsafeSubscribe((CompletableSubscriber) new CompletableSubscriber() {
            public void onCompleted() {
                subscriber.onCompleted();
            }

            public void onError(Throwable th) {
                subscriber.onError(th);
            }

            public void onSubscribe(Subscription subscription) {
                subscriber.add(subscription);
            }
        });
        RxJavaHooks.onObservableReturn(subscriber);
    }

    public final <T> void subscribe(Subscriber<T> subscriber) {
        subscriber.onStart();
        if (!(subscriber instanceof SafeSubscriber)) {
            subscriber = new SafeSubscriber<>(subscriber);
        }
        unsafeSubscribe(subscriber, false);
    }

    public final Completable subscribeOn(final Scheduler scheduler) {
        requireNonNull(scheduler);
        return create(new OnSubscribe() {
            public void call(final CompletableSubscriber completableSubscriber) {
                final Worker createWorker = scheduler.createWorker();
                createWorker.schedule(new Action0() {
                    public void call() {
                        try {
                            Completable.this.unsafeSubscribe(completableSubscriber);
                        } finally {
                            createWorker.unsubscribe();
                        }
                    }
                });
            }
        });
    }

    public final Completable timeout(long j, TimeUnit timeUnit) {
        return timeout0(j, timeUnit, Schedulers.computation(), null);
    }

    public final Completable timeout(long j, TimeUnit timeUnit, Completable completable) {
        requireNonNull(completable);
        return timeout0(j, timeUnit, Schedulers.computation(), completable);
    }

    public final Completable timeout(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return timeout0(j, timeUnit, scheduler, null);
    }

    public final Completable timeout(long j, TimeUnit timeUnit, Scheduler scheduler, Completable completable) {
        requireNonNull(completable);
        return timeout0(j, timeUnit, scheduler, completable);
    }

    public final Completable timeout0(long j, TimeUnit timeUnit, Scheduler scheduler, Completable completable) {
        requireNonNull(timeUnit);
        requireNonNull(scheduler);
        CompletableOnSubscribeTimeout completableOnSubscribeTimeout = new CompletableOnSubscribeTimeout(this, j, timeUnit, scheduler, completable);
        return create(completableOnSubscribeTimeout);
    }

    public final <R> R to(Func1<? super Completable, R> func1) {
        return func1.call(this);
    }

    public final <T> Observable<T> toObservable() {
        return Observable.unsafeCreate(new rx.Observable.OnSubscribe<T>() {
            public void call(Subscriber<? super T> subscriber) {
                Completable.this.unsafeSubscribe(subscriber);
            }
        });
    }

    public final <T> Single<T> toSingle(final Func0<? extends T> func0) {
        requireNonNull(func0);
        return Single.create(new rx.Single.OnSubscribe<T>() {
            public void call(final SingleSubscriber<? super T> singleSubscriber) {
                Completable.this.unsafeSubscribe((CompletableSubscriber) new CompletableSubscriber() {
                    public void onCompleted() {
                        try {
                            Object call = func0.call();
                            if (call == null) {
                                singleSubscriber.onError(new NullPointerException("The value supplied is null"));
                            } else {
                                singleSubscriber.onSuccess(call);
                            }
                        } catch (Throwable th) {
                            singleSubscriber.onError(th);
                        }
                    }

                    public void onError(Throwable th) {
                        singleSubscriber.onError(th);
                    }

                    public void onSubscribe(Subscription subscription) {
                        singleSubscriber.add(subscription);
                    }
                });
            }
        });
    }

    public final <T> Single<T> toSingleDefault(final T t) {
        requireNonNull(t);
        return toSingle(new Func0<T>() {
            public T call() {
                return t;
            }
        });
    }

    public final Completable unsubscribeOn(final Scheduler scheduler) {
        requireNonNull(scheduler);
        return create(new OnSubscribe() {
            public void call(final CompletableSubscriber completableSubscriber) {
                Completable.this.unsafeSubscribe((CompletableSubscriber) new CompletableSubscriber() {
                    public void onCompleted() {
                        completableSubscriber.onCompleted();
                    }

                    public void onError(Throwable th) {
                        completableSubscriber.onError(th);
                    }

                    public void onSubscribe(final Subscription subscription) {
                        completableSubscriber.onSubscribe(Subscriptions.create(new Action0() {
                            public void call() {
                                final Worker createWorker = scheduler.createWorker();
                                createWorker.schedule(new Action0() {
                                    public void call() {
                                        try {
                                            subscription.unsubscribe();
                                        } finally {
                                            createWorker.unsubscribe();
                                        }
                                    }
                                });
                            }
                        }));
                    }
                });
            }
        });
    }

    public final AssertableSubscriber<Void> test() {
        AssertableSubscriberObservable create = AssertableSubscriberObservable.create(LongCompanionObject.MAX_VALUE);
        subscribe((Subscriber<T>) create);
        return create;
    }
}
