package rx.internal.operators;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Completable;
import rx.CompletableSubscriber;
import rx.Subscription;
import rx.internal.util.atomic.MpscLinkedAtomicQueue;
import rx.internal.util.unsafe.MpscLinkedQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.subscriptions.CompositeSubscription;

public final class CompletableOnSubscribeMergeDelayErrorIterable implements Completable.OnSubscribe {
    final Iterable<? extends Completable> sources;

    public CompletableOnSubscribeMergeDelayErrorIterable(Iterable<? extends Completable> iterable) {
        this.sources = iterable;
    }

    public void call(CompletableSubscriber completableSubscriber) {
        Queue queue;
        CompositeSubscription compositeSubscription = new CompositeSubscription();
        completableSubscriber.onSubscribe(compositeSubscription);
        try {
            Iterator<? extends Completable> it = this.sources.iterator();
            if (it == null) {
                completableSubscriber.onError(new NullPointerException("The source iterator returned is null"));
                return;
            }
            AtomicInteger atomicInteger = new AtomicInteger(1);
            if (UnsafeAccess.isUnsafeAvailable()) {
                queue = new MpscLinkedQueue();
            } else {
                queue = new MpscLinkedAtomicQueue();
            }
            Queue queue2 = queue;
            while (!compositeSubscription.isUnsubscribed()) {
                try {
                    if (!it.hasNext()) {
                        if (atomicInteger.decrementAndGet() != 0) {
                            return;
                        }
                        if (queue2.isEmpty()) {
                            completableSubscriber.onCompleted();
                            return;
                        } else {
                            completableSubscriber.onError(CompletableOnSubscribeMerge.collectErrors(queue2));
                            return;
                        }
                    } else if (!compositeSubscription.isUnsubscribed()) {
                        try {
                            Completable completable = (Completable) it.next();
                            if (!compositeSubscription.isUnsubscribed()) {
                                if (completable == null) {
                                    queue2.offer(new NullPointerException("A completable source is null"));
                                    if (atomicInteger.decrementAndGet() != 0) {
                                        return;
                                    }
                                    if (queue2.isEmpty()) {
                                        completableSubscriber.onCompleted();
                                        return;
                                    } else {
                                        completableSubscriber.onError(CompletableOnSubscribeMerge.collectErrors(queue2));
                                        return;
                                    }
                                } else {
                                    atomicInteger.getAndIncrement();
                                    final CompositeSubscription compositeSubscription2 = compositeSubscription;
                                    final Queue queue3 = queue2;
                                    final AtomicInteger atomicInteger2 = atomicInteger;
                                    final CompletableSubscriber completableSubscriber2 = completableSubscriber;
                                    completable.unsafeSubscribe((CompletableSubscriber) new CompletableSubscriber() {
                                        public void onSubscribe(Subscription subscription) {
                                            compositeSubscription2.add(subscription);
                                        }

                                        public void onError(Throwable th) {
                                            queue3.offer(th);
                                            tryTerminate();
                                        }

                                        public void onCompleted() {
                                            tryTerminate();
                                        }

                                        /* access modifiers changed from: package-private */
                                        public void tryTerminate() {
                                            if (atomicInteger2.decrementAndGet() != 0) {
                                                return;
                                            }
                                            if (queue3.isEmpty()) {
                                                completableSubscriber2.onCompleted();
                                            } else {
                                                completableSubscriber2.onError(CompletableOnSubscribeMerge.collectErrors(queue3));
                                            }
                                        }
                                    });
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th) {
                            queue2.offer(th);
                            if (atomicInteger.decrementAndGet() != 0) {
                                return;
                            }
                            if (queue2.isEmpty()) {
                                completableSubscriber.onCompleted();
                                return;
                            } else {
                                completableSubscriber.onError(CompletableOnSubscribeMerge.collectErrors(queue2));
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th2) {
                    queue2.offer(th2);
                    if (atomicInteger.decrementAndGet() != 0) {
                        return;
                    }
                    if (queue2.isEmpty()) {
                        completableSubscriber.onCompleted();
                        return;
                    } else {
                        completableSubscriber.onError(CompletableOnSubscribeMerge.collectErrors(queue2));
                        return;
                    }
                }
            }
        } catch (Throwable th3) {
            completableSubscriber.onError(th3);
        }
    }
}
