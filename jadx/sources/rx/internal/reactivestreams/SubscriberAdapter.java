package rx.internal.reactivestreams;

import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class SubscriberAdapter<T> implements Subscriber<T> {
    private final rx.Subscriber<? super T> rxSubscriber;
    private final AtomicBoolean started = new AtomicBoolean();

    public SubscriberAdapter(rx.Subscriber<? super T> subscriber) {
        this.rxSubscriber = subscriber;
    }

    public void onSubscribe(Subscription subscription) {
        if (subscription == null) {
            throw new NullPointerException("onSubscribe(null)");
        } else if (this.started.compareAndSet(false, true)) {
            RxJavaSynchronizedProducer rxJavaSynchronizedProducer = new RxJavaSynchronizedProducer(subscription);
            this.rxSubscriber.add(rxJavaSynchronizedProducer);
            this.rxSubscriber.setProducer(rxJavaSynchronizedProducer);
        } else {
            subscription.cancel();
        }
    }

    public void onNext(T t) {
        if (t != null) {
            this.rxSubscriber.onNext(t);
            return;
        }
        throw new NullPointerException("onNext(null)");
    }

    public void onError(Throwable th) {
        if (th != null) {
            this.rxSubscriber.onError(th);
            return;
        }
        throw new NullPointerException("onError(null)");
    }

    public void onComplete() {
        this.rxSubscriber.onCompleted();
    }
}
