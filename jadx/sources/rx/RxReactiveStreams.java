package rx;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import rx.Observable;
import rx.internal.reactivestreams.CompletableAsPublisher;
import rx.internal.reactivestreams.PublisherAdapter;
import rx.internal.reactivestreams.PublisherAsCompletable;
import rx.internal.reactivestreams.PublisherAsSingle;
import rx.internal.reactivestreams.SingleAsPublisher;
import rx.internal.reactivestreams.SubscriberAdapter;

public abstract class RxReactiveStreams {
    private RxReactiveStreams() {
    }

    public static <T> Publisher<T> toPublisher(Observable<T> observable) {
        return new PublisherAdapter(observable);
    }

    public static <T> Observable<T> toObservable(final Publisher<T> publisher) {
        return Observable.create(new Observable.OnSubscribe<T>() {
            public void call(Subscriber<? super T> subscriber) {
                publisher.subscribe(RxReactiveStreams.toSubscriber(subscriber));
            }
        });
    }

    public static <T> Subscriber<T> toSubscriber(Subscriber<T> subscriber) {
        return new SubscriberAdapter(subscriber);
    }

    public static <T> Publisher<T> toPublisher(Completable completable) {
        if (completable != null) {
            return new CompletableAsPublisher(completable);
        }
        throw new NullPointerException("completable");
    }

    public static Completable toCompletable(Publisher<?> publisher) {
        if (publisher != null) {
            return Completable.create(new PublisherAsCompletable(publisher));
        }
        throw new NullPointerException("publisher");
    }

    public static <T> Publisher<T> toPublisher(Single<T> single) {
        if (single != null) {
            return new SingleAsPublisher(single);
        }
        throw new NullPointerException("single");
    }

    public static <T> Single<T> toSingle(Publisher<T> publisher) {
        if (publisher != null) {
            return Single.create(new PublisherAsSingle(publisher));
        }
        throw new NullPointerException("publisher");
    }
}
