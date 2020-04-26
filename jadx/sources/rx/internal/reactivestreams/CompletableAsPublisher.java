package rx.internal.reactivestreams;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import rx.Completable;
import rx.CompletableSubscriber;

public final class CompletableAsPublisher<T> implements Publisher<T> {
    final Completable completable;

    public CompletableAsPublisher(Completable completable2) {
        this.completable = completable2;
    }

    public void subscribe(Subscriber<? super T> subscriber) {
        if (subscriber != null) {
            this.completable.subscribe((CompletableSubscriber) new CompletableAsPublisherSubscriber(subscriber));
            return;
        }
        throw null;
    }

    static final class CompletableAsPublisherSubscriber<T> implements CompletableSubscriber, Subscription {
        final Subscriber<? super T> actual;
        rx.Subscription d;

        public void request(long j) {
        }

        public CompletableAsPublisherSubscriber(Subscriber<? super T> subscriber) {
            this.actual = subscriber;
        }

        public void onSubscribe(rx.Subscription subscription) {
            this.d = subscription;
            this.actual.onSubscribe(this);
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        public void onCompleted() {
            this.actual.onComplete();
        }

        public void cancel() {
            this.d.unsubscribe();
        }
    }
}
