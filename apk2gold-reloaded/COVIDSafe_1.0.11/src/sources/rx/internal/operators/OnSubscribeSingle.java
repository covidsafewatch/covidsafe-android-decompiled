package rx.internal.operators;

import java.util.NoSuchElementException;
import rx.Observable;
import rx.Single.OnSubscribe;
import rx.SingleSubscriber;
import rx.Subscriber;

public class OnSubscribeSingle<T> implements OnSubscribe<T> {
    private final Observable<T> observable;

    public OnSubscribeSingle(Observable<T> observable2) {
        this.observable = observable2;
    }

    public void call(final SingleSubscriber<? super T> singleSubscriber) {
        AnonymousClass1 r0 = new Subscriber<T>() {
            private T emission;
            private boolean emittedTooMany;
            private boolean itemEmitted;

            public void onStart() {
                request(2);
            }

            public void onCompleted() {
                if (!this.emittedTooMany) {
                    if (this.itemEmitted) {
                        singleSubscriber.onSuccess(this.emission);
                    } else {
                        singleSubscriber.onError(new NoSuchElementException("Observable emitted no items"));
                    }
                }
            }

            public void onError(Throwable th) {
                singleSubscriber.onError(th);
                unsubscribe();
            }

            public void onNext(T t) {
                if (this.itemEmitted) {
                    this.emittedTooMany = true;
                    singleSubscriber.onError(new IllegalArgumentException("Observable emitted too many elements"));
                    unsubscribe();
                    return;
                }
                this.itemEmitted = true;
                this.emission = t;
            }
        };
        singleSubscriber.add(r0);
        this.observable.unsafeSubscribe(r0);
    }

    public static <T> OnSubscribeSingle<T> create(Observable<T> observable2) {
        return new OnSubscribeSingle<>(observable2);
    }
}
