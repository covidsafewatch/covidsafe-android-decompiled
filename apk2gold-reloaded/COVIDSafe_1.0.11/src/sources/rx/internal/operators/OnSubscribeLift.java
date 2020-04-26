package rx.internal.operators;

import rx.Observable.OnSubscribe;
import rx.Observable.Operator;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.plugins.RxJavaHooks;

public final class OnSubscribeLift<T, R> implements OnSubscribe<R> {
    final Operator<? extends R, ? super T> operator;
    final OnSubscribe<T> parent;

    public OnSubscribeLift(OnSubscribe<T> onSubscribe, Operator<? extends R, ? super T> operator2) {
        this.parent = onSubscribe;
        this.operator = operator2;
    }

    public void call(Subscriber<? super R> subscriber) {
        Subscriber subscriber2;
        try {
            subscriber2 = (Subscriber) RxJavaHooks.onObservableLift(this.operator).call(subscriber);
            subscriber2.onStart();
            this.parent.call(subscriber2);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            subscriber.onError(th);
        }
    }
}
