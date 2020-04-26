package rx.internal.reactivestreams;

import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import rx.Single;
import rx.SingleSubscriber;

public final class SingleAsPublisher<T> implements Publisher<T> {
    final Single<T> single;

    static final class SingleAsPublisherSubscriber<T> extends SingleSubscriber<T> implements Subscription {
        static final int HAS_REQUEST_HAS_VALUE = 3;
        static final int HAS_REQUEST_NO_VALUE = 2;
        static final int NO_REQUEST_HAS_VALUE = 1;
        static final int NO_REQUEST_NO_VALUE = 0;
        final Subscriber<? super T> actual;
        volatile boolean cancelled;
        final AtomicInteger state = new AtomicInteger();
        T value;

        public SingleAsPublisherSubscriber(Subscriber<? super T> subscriber) {
            this.actual = subscriber;
        }

        public void onSuccess(T t) {
            int i;
            if (!this.cancelled) {
                if (t == null) {
                    this.state.lazySet(3);
                    this.actual.onError(new NullPointerException("value"));
                    return;
                }
                do {
                    i = this.state.get();
                    if (i != 1 && i != 3 && !this.cancelled) {
                        if (i == 2) {
                            this.actual.onNext(t);
                            if (!this.cancelled) {
                                this.actual.onComplete();
                            }
                            return;
                        }
                        this.value = t;
                    }
                } while (!this.state.compareAndSet(i, 1));
            }
        }

        public void onError(Throwable th) {
            if (!this.cancelled) {
                this.state.lazySet(3);
                this.actual.onError(th);
            }
        }

        public void request(long j) {
            if (j > 0) {
                do {
                    int i = this.state.get();
                    if (i != 3 && i != 2 && !this.cancelled) {
                        if (i == 1) {
                            if (this.state.compareAndSet(i, 3)) {
                                T t = this.value;
                                this.value = null;
                                this.actual.onNext(t);
                                if (!this.cancelled) {
                                    this.actual.onComplete();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    } else {
                        return;
                    }
                } while (!this.state.compareAndSet(0, 2));
            }
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                if (this.state.getAndSet(3) == 1) {
                    this.value = null;
                }
                unsubscribe();
            }
        }
    }

    public SingleAsPublisher(Single<T> single2) {
        this.single = single2;
    }

    public void subscribe(Subscriber<? super T> subscriber) {
        SingleAsPublisherSubscriber singleAsPublisherSubscriber = new SingleAsPublisherSubscriber(subscriber);
        subscriber.onSubscribe(singleAsPublisherSubscriber);
        this.single.subscribe((SingleSubscriber<? super T>) singleAsPublisherSubscriber);
    }
}
