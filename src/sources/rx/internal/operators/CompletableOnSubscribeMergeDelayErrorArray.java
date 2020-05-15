package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Completable;
import rx.CompletableSubscriber;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public final class CompletableOnSubscribeMergeDelayErrorArray implements Completable.OnSubscribe {
    final Completable[] sources;

    public CompletableOnSubscribeMergeDelayErrorArray(Completable[] completableArr) {
        this.sources = completableArr;
    }

    public void call(CompletableSubscriber completableSubscriber) {
        CompositeSubscription compositeSubscription = new CompositeSubscription();
        AtomicInteger atomicInteger = new AtomicInteger(this.sources.length + 1);
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        completableSubscriber.onSubscribe(compositeSubscription);
        Completable[] completableArr = this.sources;
        int length = completableArr.length;
        int i = 0;
        while (i < length) {
            Completable completable = completableArr[i];
            if (!compositeSubscription.isUnsubscribed()) {
                if (completable == null) {
                    concurrentLinkedQueue.offer(new NullPointerException("A completable source is null"));
                    atomicInteger.decrementAndGet();
                } else {
                    final CompositeSubscription compositeSubscription2 = compositeSubscription;
                    final ConcurrentLinkedQueue concurrentLinkedQueue2 = concurrentLinkedQueue;
                    final AtomicInteger atomicInteger2 = atomicInteger;
                    final CompletableSubscriber completableSubscriber2 = completableSubscriber;
                    completable.unsafeSubscribe((CompletableSubscriber) new CompletableSubscriber() {
                        public void onSubscribe(Subscription subscription) {
                            compositeSubscription2.add(subscription);
                        }

                        public void onError(Throwable th) {
                            concurrentLinkedQueue2.offer(th);
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
                            if (concurrentLinkedQueue2.isEmpty()) {
                                completableSubscriber2.onCompleted();
                            } else {
                                completableSubscriber2.onError(CompletableOnSubscribeMerge.collectErrors(concurrentLinkedQueue2));
                            }
                        }
                    });
                }
                i++;
            } else {
                return;
            }
        }
        if (atomicInteger.decrementAndGet() != 0) {
            return;
        }
        if (concurrentLinkedQueue.isEmpty()) {
            completableSubscriber.onCompleted();
        } else {
            completableSubscriber.onError(CompletableOnSubscribeMerge.collectErrors(concurrentLinkedQueue));
        }
    }
}
