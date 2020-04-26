package rx.internal.operators;

import java.util.Iterator;
import rx.Observable.Operator;
import rx.Observer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func2;
import rx.observers.Subscribers;

public final class OperatorZipIterable<T1, T2, R> implements Operator<R, T1> {
    final Iterable<? extends T2> iterable;
    final Func2<? super T1, ? super T2, ? extends R> zipFunction;

    public OperatorZipIterable(Iterable<? extends T2> iterable2, Func2<? super T1, ? super T2, ? extends R> func2) {
        this.iterable = iterable2;
        this.zipFunction = func2;
    }

    public Subscriber<? super T1> call(final Subscriber<? super R> subscriber) {
        final Iterator it = this.iterable.iterator();
        try {
            if (it.hasNext()) {
                return new Subscriber<T1>(subscriber) {
                    boolean done;

                    public void onCompleted() {
                        if (!this.done) {
                            this.done = true;
                            subscriber.onCompleted();
                        }
                    }

                    public void onError(Throwable th) {
                        if (this.done) {
                            Exceptions.throwIfFatal(th);
                            return;
                        }
                        this.done = true;
                        subscriber.onError(th);
                    }

                    public void onNext(T1 t1) {
                        if (!this.done) {
                            try {
                                subscriber.onNext(OperatorZipIterable.this.zipFunction.call(t1, it.next()));
                                if (!it.hasNext()) {
                                    onCompleted();
                                }
                            } catch (Throwable th) {
                                Exceptions.throwOrReport(th, (Observer<?>) this);
                            }
                        }
                    }
                };
            }
            subscriber.onCompleted();
            return Subscribers.empty();
        } catch (Throwable th) {
            Exceptions.throwOrReport(th, (Observer<?>) subscriber);
            return Subscribers.empty();
        }
    }
}
