package rx.observers;

import rx.Observer;
import rx.Subscriber;

public class SerializedSubscriber<T> extends Subscriber<T> {
    private final Observer<T> s;

    public SerializedSubscriber(Subscriber<? super T> subscriber) {
        this(subscriber, true);
    }

    public SerializedSubscriber(Subscriber<? super T> subscriber, boolean z) {
        super(subscriber, z);
        this.s = new SerializedObserver(subscriber);
    }

    public void onCompleted() {
        this.s.onCompleted();
    }

    public void onError(Throwable th) {
        this.s.onError(th);
    }

    public void onNext(T t) {
        this.s.onNext(t);
    }
}
