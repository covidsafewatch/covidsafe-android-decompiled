package rx.internal.reactivestreams;

import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import rx.Completable.OnSubscribe;
import rx.CompletableSubscriber;
import rx.Subscription;

public final class PublisherAsCompletable implements OnSubscribe {
    final Publisher<?> publisher;

    static final class PublisherAsCompletableSubscriber implements Subscriber<Object>, Subscription {
        final CompletableSubscriber actual;
        org.reactivestreams.Subscription s;
        volatile boolean unsubscribed;

        public void onNext(Object obj) {
        }

        public PublisherAsCompletableSubscriber(CompletableSubscriber completableSubscriber) {
            this.actual = completableSubscriber;
        }

        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            this.s = subscription;
            this.actual.onSubscribe(this);
            subscription.request(LongCompanionObject.MAX_VALUE);
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        public void onComplete() {
            this.actual.onCompleted();
        }

        public boolean isUnsubscribed() {
            return this.unsubscribed;
        }

        public void unsubscribe() {
            if (!this.unsubscribed) {
                this.unsubscribed = true;
                this.s.cancel();
            }
        }
    }

    public PublisherAsCompletable(Publisher<?> publisher2) {
        this.publisher = publisher2;
    }

    public void call(CompletableSubscriber completableSubscriber) {
        this.publisher.subscribe(new PublisherAsCompletableSubscriber(completableSubscriber));
    }
}
