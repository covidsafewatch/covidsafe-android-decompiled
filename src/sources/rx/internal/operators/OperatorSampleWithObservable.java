package rx.internal.operators;

import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.observers.SerializedSubscriber;

public final class OperatorSampleWithObservable<T, U> implements Observable.Operator<T, T> {
    static final Object EMPTY_TOKEN = new Object();
    final Observable<U> sampler;

    public OperatorSampleWithObservable(Observable<U> observable) {
        this.sampler = observable;
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        final SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        final AtomicReference atomicReference = new AtomicReference(EMPTY_TOKEN);
        final AtomicReference atomicReference2 = new AtomicReference();
        final AnonymousClass1 r3 = new Subscriber<U>() {
            public void onNext(U u) {
                Object andSet = atomicReference.getAndSet(OperatorSampleWithObservable.EMPTY_TOKEN);
                if (andSet != OperatorSampleWithObservable.EMPTY_TOKEN) {
                    serializedSubscriber.onNext(andSet);
                }
            }

            public void onError(Throwable th) {
                serializedSubscriber.onError(th);
                ((Subscription) atomicReference2.get()).unsubscribe();
            }

            public void onCompleted() {
                onNext((Object) null);
                serializedSubscriber.onCompleted();
                ((Subscription) atomicReference2.get()).unsubscribe();
            }
        };
        AnonymousClass2 r4 = new Subscriber<T>() {
            public void onNext(T t) {
                atomicReference.set(t);
            }

            public void onError(Throwable th) {
                serializedSubscriber.onError(th);
                r3.unsubscribe();
            }

            public void onCompleted() {
                r3.onNext(null);
                serializedSubscriber.onCompleted();
                r3.unsubscribe();
            }
        };
        atomicReference2.lazySet(r4);
        subscriber.add(r4);
        subscriber.add(r3);
        this.sampler.unsafeSubscribe(r3);
        return r4;
    }
}
