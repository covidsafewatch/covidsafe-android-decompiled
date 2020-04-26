package rx.internal.operators;

import rx.Observable.Operator;
import rx.Observer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.functions.Func2;

public final class OperatorSkipWhile<T> implements Operator<T, T> {
    final Func2<? super T, Integer, Boolean> predicate;

    public OperatorSkipWhile(Func2<? super T, Integer, Boolean> func2) {
        this.predicate = func2;
    }

    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        return new Subscriber<T>(subscriber) {
            int index;
            boolean skipping = true;

            public void onNext(T t) {
                if (!this.skipping) {
                    subscriber.onNext(t);
                } else {
                    try {
                        Func2<? super T, Integer, Boolean> func2 = OperatorSkipWhile.this.predicate;
                        int i = this.index;
                        this.index = i + 1;
                        if (!((Boolean) func2.call(t, Integer.valueOf(i))).booleanValue()) {
                            this.skipping = false;
                            subscriber.onNext(t);
                        } else {
                            request(1);
                        }
                    } catch (Throwable th) {
                        Exceptions.throwOrReport(th, (Observer<?>) subscriber, (Object) t);
                    }
                }
            }

            public void onError(Throwable th) {
                subscriber.onError(th);
            }

            public void onCompleted() {
                subscriber.onCompleted();
            }
        };
    }

    public static <T> Func2<T, Integer, Boolean> toPredicate2(final Func1<? super T, Boolean> func1) {
        return new Func2<T, Integer, Boolean>() {
            public Boolean call(T t, Integer num) {
                return (Boolean) func1.call(t);
            }
        };
    }
}
