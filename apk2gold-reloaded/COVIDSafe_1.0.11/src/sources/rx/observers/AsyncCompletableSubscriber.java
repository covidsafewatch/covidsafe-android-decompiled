package rx.observers;

import java.util.concurrent.atomic.AtomicReference;
import rx.CompletableSubscriber;
import rx.Subscription;
import rx.plugins.RxJavaHooks;

public abstract class AsyncCompletableSubscriber implements CompletableSubscriber, Subscription {
    static final Unsubscribed UNSUBSCRIBED = new Unsubscribed();
    private final AtomicReference<Subscription> upstream = new AtomicReference<>();

    static final class Unsubscribed implements Subscription {
        public boolean isUnsubscribed() {
            return true;
        }

        public void unsubscribe() {
        }

        Unsubscribed() {
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
    }

    public final void onSubscribe(Subscription subscription) {
        if (!this.upstream.compareAndSet(null, subscription)) {
            subscription.unsubscribe();
            if (this.upstream.get() != UNSUBSCRIBED) {
                RxJavaHooks.onError(new IllegalStateException("Subscription already set!"));
                return;
            }
            return;
        }
        onStart();
    }

    public final boolean isUnsubscribed() {
        return this.upstream.get() == UNSUBSCRIBED;
    }

    /* access modifiers changed from: protected */
    public final void clear() {
        this.upstream.set(UNSUBSCRIBED);
    }

    public final void unsubscribe() {
        Subscription subscription = (Subscription) this.upstream.get();
        Unsubscribed unsubscribed = UNSUBSCRIBED;
        if (subscription != unsubscribed) {
            Subscription subscription2 = (Subscription) this.upstream.getAndSet(unsubscribed);
            if (subscription2 != null && subscription2 != UNSUBSCRIBED) {
                subscription2.unsubscribe();
            }
        }
    }
}
