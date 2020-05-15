package rx.plugins;

import rx.Observable;
import rx.Single;
import rx.Subscription;

public abstract class RxJavaSingleExecutionHook {
    @Deprecated
    public <T> Single.OnSubscribe<T> onCreate(Single.OnSubscribe<T> onSubscribe) {
        return onSubscribe;
    }

    @Deprecated
    public <T, R> Observable.Operator<? extends R, ? super T> onLift(Observable.Operator<? extends R, ? super T> operator) {
        return operator;
    }

    @Deprecated
    public <T> Throwable onSubscribeError(Throwable th) {
        return th;
    }

    @Deprecated
    public <T> Subscription onSubscribeReturn(Subscription subscription) {
        return subscription;
    }

    @Deprecated
    public <T> Observable.OnSubscribe<T> onSubscribeStart(Single<? extends T> single, Observable.OnSubscribe<T> onSubscribe) {
        return onSubscribe;
    }
}
