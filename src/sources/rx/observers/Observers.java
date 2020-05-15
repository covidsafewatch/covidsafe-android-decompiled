package rx.observers;

import rx.Observer;
import rx.exceptions.OnErrorNotImplementedException;
import rx.functions.Action0;
import rx.functions.Action1;

public final class Observers {
    private static final Observer<Object> EMPTY = new Observer<Object>() {
        public final void onCompleted() {
        }

        public final void onNext(Object obj) {
        }

        public final void onError(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }
    };

    private Observers() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Observer<T> empty() {
        return EMPTY;
    }

    public static <T> Observer<T> create(final Action1<? super T> action1) {
        if (action1 != null) {
            return new Observer<T>() {
                public final void onCompleted() {
                }

                public final void onError(Throwable th) {
                    throw new OnErrorNotImplementedException(th);
                }

                public final void onNext(T t) {
                    action1.call(t);
                }
            };
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    public static <T> Observer<T> create(final Action1<? super T> action1, final Action1<Throwable> action12) {
        if (action1 == null) {
            throw new IllegalArgumentException("onNext can not be null");
        } else if (action12 != null) {
            return new Observer<T>() {
                public final void onCompleted() {
                }

                public final void onError(Throwable th) {
                    action12.call(th);
                }

                public final void onNext(T t) {
                    action1.call(t);
                }
            };
        } else {
            throw new IllegalArgumentException("onError can not be null");
        }
    }

    public static <T> Observer<T> create(final Action1<? super T> action1, final Action1<Throwable> action12, final Action0 action0) {
        if (action1 == null) {
            throw new IllegalArgumentException("onNext can not be null");
        } else if (action12 == null) {
            throw new IllegalArgumentException("onError can not be null");
        } else if (action0 != null) {
            return new Observer<T>() {
                public final void onCompleted() {
                    action0.call();
                }

                public final void onError(Throwable th) {
                    action12.call(th);
                }

                public final void onNext(T t) {
                    action1.call(t);
                }
            };
        } else {
            throw new IllegalArgumentException("onComplete can not be null");
        }
    }
}
