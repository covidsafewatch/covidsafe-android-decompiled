package rx.internal.reactivestreams;

import java.util.NoSuchElementException;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import rx.Single;
import rx.SingleSubscriber;
import rx.Subscription;

public final class PublisherAsSingle<T> implements Single.OnSubscribe<T> {
    final Publisher<T> publisher;

    public PublisherAsSingle(Publisher<T> publisher2) {
        this.publisher = publisher2;
    }

    public void call(SingleSubscriber<? super T> singleSubscriber) {
        this.publisher.subscribe(new PublisherAsSingleSubscriber(singleSubscriber));
    }

    static final class PublisherAsSingleSubscriber<T> implements Subscriber<T>, Subscription {
        final SingleSubscriber<? super T> actual;
        boolean done;
        boolean hasValue;
        org.reactivestreams.Subscription s;
        T value;

        public PublisherAsSingleSubscriber(SingleSubscriber<? super T> singleSubscriber) {
            this.actual = singleSubscriber;
        }

        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            this.s = subscription;
            this.actual.add(this);
            subscription.request(LongCompanionObject.MAX_VALUE);
        }

        public void onNext(T t) {
            if (!this.done) {
                if (this.hasValue) {
                    this.done = true;
                    this.s.cancel();
                    this.actual.onError(new IndexOutOfBoundsException("The source Publisher emitted multiple values"));
                    return;
                }
                this.value = t;
                this.hasValue = true;
            }
        }

        public void onError(Throwable th) {
            if (!this.done) {
                this.actual.onError(th);
            }
        }

        public void onComplete() {
            if (!this.done) {
                if (this.hasValue) {
                    T t = this.value;
                    this.value = null;
                    this.actual.onSuccess(t);
                    return;
                }
                this.actual.onError(new NoSuchElementException("The source Publisher was empty"));
            }
        }

        public boolean isUnsubscribed() {
            return this.actual.isUnsubscribed();
        }

        public void unsubscribe() {
            this.s.cancel();
        }
    }
}
