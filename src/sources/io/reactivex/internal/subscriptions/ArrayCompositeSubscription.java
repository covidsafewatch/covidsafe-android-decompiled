package io.reactivex.internal.subscriptions;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Subscription;

public final class ArrayCompositeSubscription extends AtomicReferenceArray<Subscription> implements Disposable {
    private static final long serialVersionUID = 2746389416410565408L;

    public ArrayCompositeSubscription(int i) {
        super(i);
    }

    public boolean setResource(int i, Subscription subscription) {
        Subscription subscription2;
        do {
            subscription2 = (Subscription) get(i);
            if (subscription2 == SubscriptionHelper.CANCELLED) {
                if (subscription == null) {
                    return false;
                }
                subscription.cancel();
                return false;
            }
        } while (!compareAndSet(i, subscription2, subscription));
        if (subscription2 == null) {
            return true;
        }
        subscription2.cancel();
        return true;
    }

    public Subscription replaceResource(int i, Subscription subscription) {
        Subscription subscription2;
        do {
            subscription2 = (Subscription) get(i);
            if (subscription2 == SubscriptionHelper.CANCELLED) {
                if (subscription == null) {
                    return null;
                }
                subscription.cancel();
                return null;
            }
        } while (!compareAndSet(i, subscription2, subscription));
        return subscription2;
    }

    public void dispose() {
        Subscription subscription;
        if (get(0) != SubscriptionHelper.CANCELLED) {
            int length = length();
            for (int i = 0; i < length; i++) {
                if (!(((Subscription) get(i)) == SubscriptionHelper.CANCELLED || (subscription = (Subscription) getAndSet(i, SubscriptionHelper.CANCELLED)) == SubscriptionHelper.CANCELLED || subscription == null)) {
                    subscription.cancel();
                }
            }
        }
    }

    public boolean isDisposed() {
        return get(0) == SubscriptionHelper.CANCELLED;
    }
}
