package rx.internal.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

public final class SequentialSubscription extends AtomicReference<Subscription> implements Subscription {
    private static final long serialVersionUID = 995205034283130269L;

    public SequentialSubscription() {
    }

    public SequentialSubscription(Subscription subscription) {
        lazySet(subscription);
    }

    public Subscription current() {
        Subscription subscription = (Subscription) super.get();
        return subscription == Unsubscribed.INSTANCE ? Subscriptions.unsubscribed() : subscription;
    }

    public boolean update(Subscription subscription) {
        Subscription subscription2;
        do {
            subscription2 = (Subscription) get();
            if (subscription2 == Unsubscribed.INSTANCE) {
                if (subscription != null) {
                    subscription.unsubscribe();
                }
                return false;
            }
        } while (!compareAndSet(subscription2, subscription));
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
        return true;
    }

    public boolean replace(Subscription subscription) {
        Subscription subscription2;
        do {
            subscription2 = (Subscription) get();
            if (subscription2 == Unsubscribed.INSTANCE) {
                if (subscription != null) {
                    subscription.unsubscribe();
                }
                return false;
            }
        } while (!compareAndSet(subscription2, subscription));
        return true;
    }

    public boolean updateWeak(Subscription subscription) {
        Subscription subscription2 = (Subscription) get();
        boolean z = false;
        if (subscription2 == Unsubscribed.INSTANCE) {
            if (subscription != null) {
                subscription.unsubscribe();
            }
            return false;
        } else if (compareAndSet(subscription2, subscription)) {
            return true;
        } else {
            Subscription subscription3 = (Subscription) get();
            if (subscription != null) {
                subscription.unsubscribe();
            }
            if (subscription3 == Unsubscribed.INSTANCE) {
                z = true;
            }
            return z;
        }
    }

    public boolean replaceWeak(Subscription subscription) {
        Subscription subscription2 = (Subscription) get();
        if (subscription2 == Unsubscribed.INSTANCE) {
            if (subscription != null) {
                subscription.unsubscribe();
            }
            return false;
        } else if (compareAndSet(subscription2, subscription) || ((Subscription) get()) != Unsubscribed.INSTANCE) {
            return true;
        } else {
            if (subscription != null) {
                subscription.unsubscribe();
            }
            return false;
        }
    }

    public void unsubscribe() {
        if (((Subscription) get()) != Unsubscribed.INSTANCE) {
            Subscription subscription = (Subscription) getAndSet(Unsubscribed.INSTANCE);
            if (subscription != null && subscription != Unsubscribed.INSTANCE) {
                subscription.unsubscribe();
            }
        }
    }

    public boolean isUnsubscribed() {
        return get() == Unsubscribed.INSTANCE;
    }
}
