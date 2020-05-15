package rx.internal.operators;

import rx.Single;
import rx.SingleSubscriber;
import rx.functions.Action0;
import rx.subscriptions.Subscriptions;

public final class SingleDoOnUnsubscribe<T> implements Single.OnSubscribe<T> {
    final Action0 onUnsubscribe;
    final Single.OnSubscribe<T> source;

    public SingleDoOnUnsubscribe(Single.OnSubscribe<T> onSubscribe, Action0 action0) {
        this.source = onSubscribe;
        this.onUnsubscribe = action0;
    }

    public void call(SingleSubscriber<? super T> singleSubscriber) {
        singleSubscriber.add(Subscriptions.create(this.onUnsubscribe));
        this.source.call(singleSubscriber);
    }
}
