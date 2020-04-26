package rx.internal.producers;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;

public final class SingleProducer<T> extends AtomicBoolean implements Producer {
    private static final long serialVersionUID = -3353584923995471404L;
    final Subscriber<? super T> child;
    final T value;

    public SingleProducer(Subscriber<? super T> subscriber, T t) {
        this.child = subscriber;
        this.value = t;
    }

    public void request(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i >= 0) {
            if (i != 0 && compareAndSet(false, true)) {
                Subscriber<? super T> subscriber = this.child;
                if (!subscriber.isUnsubscribed()) {
                    T t = this.value;
                    try {
                        subscriber.onNext(t);
                        if (!subscriber.isUnsubscribed()) {
                            subscriber.onCompleted();
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.throwOrReport(th, (Observer<?>) subscriber, (Object) t);
                    }
                } else {
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException("n >= 0 required");
    }
}
