package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Completable;
import rx.CompletableSubscriber;
import rx.Subscription;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;

public final class CompletableOnSubscribeMergeArray implements Completable.OnSubscribe {
    final Completable[] sources;

    public CompletableOnSubscribeMergeArray(Completable[] completableArr) {
        this.sources = completableArr;
    }

    public void call(CompletableSubscriber completableSubscriber) {
        CompletableSubscriber completableSubscriber2 = completableSubscriber;
        CompositeSubscription compositeSubscription = new CompositeSubscription();
        boolean z = true;
        AtomicInteger atomicInteger = new AtomicInteger(this.sources.length + 1);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        completableSubscriber2.onSubscribe(compositeSubscription);
        Completable[] completableArr = this.sources;
        int length = completableArr.length;
        boolean z2 = false;
        int i = 0;
        while (i < length) {
            Completable completable = completableArr[i];
            if (!compositeSubscription.isUnsubscribed()) {
                if (completable == null) {
                    compositeSubscription.unsubscribe();
                    NullPointerException nullPointerException = new NullPointerException("A completable source is null");
                    if (atomicBoolean.compareAndSet(z2, z)) {
                        completableSubscriber2.onError(nullPointerException);
                        return;
                    }
                    RxJavaHooks.onError(nullPointerException);
                }
                final CompositeSubscription compositeSubscription2 = compositeSubscription;
                final AtomicBoolean atomicBoolean2 = atomicBoolean;
                AnonymousClass1 r10 = r0;
                final CompletableSubscriber completableSubscriber3 = completableSubscriber;
                Completable completable2 = completable;
                final AtomicInteger atomicInteger2 = atomicInteger;
                AnonymousClass1 r0 = new CompletableSubscriber() {
                    public void onSubscribe(Subscription subscription) {
                        compositeSubscription2.add(subscription);
                    }

                    public void onError(Throwable th) {
                        compositeSubscription2.unsubscribe();
                        if (atomicBoolean2.compareAndSet(false, true)) {
                            completableSubscriber3.onError(th);
                        } else {
                            RxJavaHooks.onError(th);
                        }
                    }

                    public void onCompleted() {
                        if (atomicInteger2.decrementAndGet() == 0 && atomicBoolean2.compareAndSet(false, true)) {
                            completableSubscriber3.onCompleted();
                        }
                    }
                };
                completable2.unsafeSubscribe((CompletableSubscriber) r10);
                i++;
                z = true;
                z2 = false;
            } else {
                return;
            }
        }
        if (atomicInteger.decrementAndGet() == 0 && atomicBoolean.compareAndSet(false, true)) {
            completableSubscriber.onCompleted();
        }
    }
}
