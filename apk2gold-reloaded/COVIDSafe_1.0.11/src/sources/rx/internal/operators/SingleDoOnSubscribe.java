package rx.internal.operators;

import rx.Single.OnSubscribe;
import rx.SingleSubscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action0;

public final class SingleDoOnSubscribe<T> implements OnSubscribe<T> {
    final Action0 onSubscribe;
    final OnSubscribe<T> source;

    public SingleDoOnSubscribe(OnSubscribe<T> onSubscribe2, Action0 action0) {
        this.source = onSubscribe2;
        this.onSubscribe = action0;
    }

    public void call(SingleSubscriber<? super T> singleSubscriber) {
        try {
            this.onSubscribe.call();
            this.source.call(singleSubscriber);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            singleSubscriber.onError(th);
        }
    }
}
