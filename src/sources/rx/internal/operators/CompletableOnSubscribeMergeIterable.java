package rx.internal.operators;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Completable;
import rx.CompletableSubscriber;
import rx.Subscription;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;

public final class CompletableOnSubscribeMergeIterable implements Completable.OnSubscribe {
    final Iterable<? extends Completable> sources;

    public CompletableOnSubscribeMergeIterable(Iterable<? extends Completable> iterable) {
        this.sources = iterable;
    }

    public void call(CompletableSubscriber completableSubscriber) {
        CompositeSubscription compositeSubscription = new CompositeSubscription();
        completableSubscriber.onSubscribe(compositeSubscription);
        try {
            Iterator<? extends Completable> it = this.sources.iterator();
            if (it == null) {
                completableSubscriber.onError(new NullPointerException("The source iterator returned is null"));
                return;
            }
            AtomicInteger atomicInteger = new AtomicInteger(1);
            AtomicBoolean atomicBoolean = new AtomicBoolean();
            while (!compositeSubscription.isUnsubscribed()) {
                try {
                    if (!it.hasNext()) {
                        if (atomicInteger.decrementAndGet() == 0 && atomicBoolean.compareAndSet(false, true)) {
                            completableSubscriber.onCompleted();
                            return;
                        }
                        return;
                    } else if (!compositeSubscription.isUnsubscribed()) {
                        try {
                            Completable completable = (Completable) it.next();
                            if (!compositeSubscription.isUnsubscribed()) {
                                if (completable == null) {
                                    compositeSubscription.unsubscribe();
                                    NullPointerException nullPointerException = new NullPointerException("A completable source is null");
                                    if (atomicBoolean.compareAndSet(false, true)) {
                                        completableSubscriber.onError(nullPointerException);
                                        return;
                                    } else {
                                        RxJavaHooks.onError(nullPointerException);
                                        return;
                                    }
                                } else {
                                    atomicInteger.getAndIncrement();
                                    final CompositeSubscription compositeSubscription2 = compositeSubscription;
                                    final AtomicBoolean atomicBoolean2 = atomicBoolean;
                                    final CompletableSubscriber completableSubscriber2 = completableSubscriber;
                                    final AtomicInteger atomicInteger2 = atomicInteger;
                                    completable.unsafeSubscribe((CompletableSubscriber) new CompletableSubscriber() {
                                        public void onSubscribe(Subscription subscription) {
                                            compositeSubscription2.add(subscription);
                                        }

                                        public void onError(Throwable th) {
                                            compositeSubscription2.unsubscribe();
                                            if (atomicBoolean2.compareAndSet(false, true)) {
                                                completableSubscriber2.onError(th);
                                            } else {
                                                RxJavaHooks.onError(th);
                                            }
                                        }

                                        public void onCompleted() {
                                            if (atomicInteger2.decrementAndGet() == 0 && atomicBoolean2.compareAndSet(false, true)) {
                                                completableSubscriber2.onCompleted();
                                            }
                                        }
                                    });
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th) {
                            compositeSubscription.unsubscribe();
                            if (atomicBoolean.compareAndSet(false, true)) {
                                completableSubscriber.onError(th);
                                return;
                            } else {
                                RxJavaHooks.onError(th);
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th2) {
                    compositeSubscription.unsubscribe();
                    if (atomicBoolean.compareAndSet(false, true)) {
                        completableSubscriber.onError(th2);
                        return;
                    } else {
                        RxJavaHooks.onError(th2);
                        return;
                    }
                }
            }
        } catch (Throwable th3) {
            completableSubscriber.onError(th3);
        }
    }
}
