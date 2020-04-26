package rx.plugins;

import rx.Completable;
import rx.Completable.OnSubscribe;
import rx.Completable.Operator;

public abstract class RxJavaCompletableExecutionHook {
    @Deprecated
    public OnSubscribe onCreate(OnSubscribe onSubscribe) {
        return onSubscribe;
    }

    @Deprecated
    public Operator onLift(Operator operator) {
        return operator;
    }

    @Deprecated
    public Throwable onSubscribeError(Throwable th) {
        return th;
    }

    @Deprecated
    public OnSubscribe onSubscribeStart(Completable completable, OnSubscribe onSubscribe) {
        return onSubscribe;
    }
}
