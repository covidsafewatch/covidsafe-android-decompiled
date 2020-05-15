package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.observers.Subscribers;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.SerialSubscription;
import rx.subscriptions.Subscriptions;

public final class OnSubscribeDelaySubscriptionOther<T, U> implements Observable.OnSubscribe<T> {
    final Observable<? extends T> main;
    final Observable<U> other;

    public OnSubscribeDelaySubscriptionOther(Observable<? extends T> observable, Observable<U> observable2) {
        this.main = observable;
        this.other = observable2;
    }

    public void call(Subscriber<? super T> subscriber) {
        final SerialSubscription serialSubscription = new SerialSubscription();
        subscriber.add(serialSubscription);
        final Subscriber<? super T> wrap = Subscribers.wrap(subscriber);
        AnonymousClass1 r1 = new Subscriber<U>() {
            boolean done;

            public void onNext(U u) {
                onCompleted();
            }

            public void onError(Throwable th) {
                if (this.done) {
                    RxJavaHooks.onError(th);
                    return;
                }
                this.done = true;
                wrap.onError(th);
            }

            public void onCompleted() {
                if (!this.done) {
                    this.done = true;
                    serialSubscription.set(Subscriptions.unsubscribed());
                    OnSubscribeDelaySubscriptionOther.this.main.unsafeSubscribe(wrap);
                }
            }
        };
        serialSubscription.set(r1);
        this.other.unsafeSubscribe(r1);
    }
}
