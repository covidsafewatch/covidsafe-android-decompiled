package rx.internal.operators;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Single;
import rx.Single.OnSubscribe;
import rx.SingleSubscriber;
import rx.exceptions.Exceptions;
import rx.functions.FuncN;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;

public final class SingleOperatorZip {
    private SingleOperatorZip() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, R> Single<R> zip(final Single<? extends T>[] singleArr, final FuncN<? extends R> funcN) {
        return Single.create(new OnSubscribe<R>() {
            public void call(SingleSubscriber<? super R> singleSubscriber) {
                if (singleArr.length == 0) {
                    singleSubscriber.onError(new NoSuchElementException("Can't zip 0 Singles."));
                    return;
                }
                AtomicInteger atomicInteger = new AtomicInteger(singleArr.length);
                AtomicBoolean atomicBoolean = new AtomicBoolean();
                Object[] objArr = new Object[singleArr.length];
                CompositeSubscription compositeSubscription = new CompositeSubscription();
                singleSubscriber.add(compositeSubscription);
                for (int i = 0; i < singleArr.length && !compositeSubscription.isUnsubscribed() && !atomicBoolean.get(); i++) {
                    final Object[] objArr2 = objArr;
                    final int i2 = i;
                    final AtomicInteger atomicInteger2 = atomicInteger;
                    final SingleSubscriber<? super R> singleSubscriber2 = singleSubscriber;
                    final AtomicBoolean atomicBoolean2 = atomicBoolean;
                    AnonymousClass1 r2 = new SingleSubscriber<T>() {
                        public void onSuccess(T t) {
                            objArr2[i2] = t;
                            if (atomicInteger2.decrementAndGet() == 0) {
                                try {
                                    singleSubscriber2.onSuccess(funcN.call(objArr2));
                                } catch (Throwable th) {
                                    Exceptions.throwIfFatal(th);
                                    onError(th);
                                }
                            }
                        }

                        public void onError(Throwable th) {
                            if (atomicBoolean2.compareAndSet(false, true)) {
                                singleSubscriber2.onError(th);
                            } else {
                                RxJavaHooks.onError(th);
                            }
                        }
                    };
                    compositeSubscription.add(r2);
                    if (compositeSubscription.isUnsubscribed() || atomicBoolean.get()) {
                        break;
                    }
                    singleArr[i].subscribe((SingleSubscriber<? super T>) r2);
                }
            }
        });
    }
}
