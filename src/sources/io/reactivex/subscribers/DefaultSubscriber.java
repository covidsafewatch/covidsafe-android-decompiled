package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.EndConsumerHelper;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscription;

public abstract class DefaultSubscriber<T> implements FlowableSubscriber<T> {
    Subscription upstream;

    public final void onSubscribe(Subscription subscription) {
        if (EndConsumerHelper.validate(this.upstream, subscription, getClass())) {
            this.upstream = subscription;
            onStart();
        }
    }

    /* access modifiers changed from: protected */
    public final void request(long j) {
        Subscription subscription = this.upstream;
        if (subscription != null) {
            subscription.request(j);
        }
    }

    /* access modifiers changed from: protected */
    public final void cancel() {
        Subscription subscription = this.upstream;
        this.upstream = SubscriptionHelper.CANCELLED;
        subscription.cancel();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        request(LongCompanionObject.MAX_VALUE);
    }
}
