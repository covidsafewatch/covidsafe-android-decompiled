package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;

public enum NeverObservableHolder implements Observable.OnSubscribe<Object> {
    INSTANCE;
    
    static final Observable<Object> NEVER = null;

    public void call(Subscriber<? super Object> subscriber) {
    }

    static {
        NeverObservableHolder neverObservableHolder;
        NEVER = Observable.unsafeCreate(neverObservableHolder);
    }

    public static <T> Observable<T> instance() {
        return NEVER;
    }
}
