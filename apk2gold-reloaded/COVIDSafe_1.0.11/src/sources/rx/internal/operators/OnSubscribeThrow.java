package rx.internal.operators;

import rx.Observable.OnSubscribe;
import rx.Subscriber;

public final class OnSubscribeThrow<T> implements OnSubscribe<T> {
    private final Throwable exception;

    public OnSubscribeThrow(Throwable th) {
        this.exception = th;
    }

    public void call(Subscriber<? super T> subscriber) {
        subscriber.onError(this.exception);
    }
}
