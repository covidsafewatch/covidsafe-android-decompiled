package rx.internal.reactivestreams;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import rx.Observable;
import rx.internal.operators.BackpressureUtils;

public class PublisherAdapter<T> implements Publisher<T> {
    private final Observable<T> observable;

    public PublisherAdapter(Observable<T> observable2) {
        this.observable = observable2.serialize();
    }

    public void subscribe(final Subscriber<? super T> subscriber) {
        this.observable.subscribe(new rx.Subscriber<T>() {
            private final AtomicLong childRequested = new AtomicLong();
            private final AtomicBoolean done = new AtomicBoolean();

            /* access modifiers changed from: private */
            public void doRequest(long j) {
                if (!this.done.get()) {
                    BackpressureUtils.getAndAddRequest(this.childRequested, j);
                    request(j);
                }
            }

            public void onStart() {
                final AtomicBoolean atomicBoolean = new AtomicBoolean();
                subscriber.onSubscribe(new Subscription() {
                    public void request(long j) {
                        if (j < 1) {
                            AnonymousClass1.this.unsubscribe();
                            AnonymousClass1.this.onError(new IllegalArgumentException("3.9 While the Subscription is not cancelled, Subscription.request(long n) MUST throw a java.lang.IllegalArgumentException if the argument is <= 0."));
                            return;
                        }
                        atomicBoolean.set(true);
                        AnonymousClass1.this.doRequest(j);
                    }

                    public void cancel() {
                        AnonymousClass1.this.unsubscribe();
                        AnonymousClass1.this.fireDone();
                    }
                });
                if (!atomicBoolean.get()) {
                    request(0);
                }
            }

            /* access modifiers changed from: package-private */
            public boolean fireDone() {
                return this.done.compareAndSet(false, true);
            }

            public void onCompleted() {
                if (fireDone()) {
                    subscriber.onComplete();
                }
            }

            public void onError(Throwable th) {
                if (fireDone()) {
                    subscriber.onError(th);
                }
            }

            public void onNext(T t) {
                if (this.done.get()) {
                    return;
                }
                if (this.childRequested.get() > 0) {
                    subscriber.onNext(t);
                    this.childRequested.decrementAndGet();
                    return;
                }
                try {
                    onError(new IllegalStateException("1.1 source doesn't respect backpressure"));
                } finally {
                    unsubscribe();
                }
            }
        });
    }
}
