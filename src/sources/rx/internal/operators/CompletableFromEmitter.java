package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Completable;
import rx.CompletableEmitter;
import rx.CompletableSubscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Action1;
import rx.functions.Cancellable;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;
import rx.plugins.RxJavaHooks;

public final class CompletableFromEmitter implements Completable.OnSubscribe {
    final Action1<CompletableEmitter> producer;

    public CompletableFromEmitter(Action1<CompletableEmitter> action1) {
        this.producer = action1;
    }

    public void call(CompletableSubscriber completableSubscriber) {
        FromEmitter fromEmitter = new FromEmitter(completableSubscriber);
        completableSubscriber.onSubscribe(fromEmitter);
        try {
            this.producer.call(fromEmitter);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            fromEmitter.onError(th);
        }
    }

    static final class FromEmitter extends AtomicBoolean implements CompletableEmitter, Subscription {
        private static final long serialVersionUID = 5539301318568668881L;
        final CompletableSubscriber actual;
        final SequentialSubscription resource = new SequentialSubscription();

        public FromEmitter(CompletableSubscriber completableSubscriber) {
            this.actual = completableSubscriber;
        }

        public void onCompleted() {
            if (compareAndSet(false, true)) {
                try {
                    this.actual.onCompleted();
                } finally {
                    this.resource.unsubscribe();
                }
            }
        }

        public void onError(Throwable th) {
            if (compareAndSet(false, true)) {
                try {
                    this.actual.onError(th);
                } finally {
                    this.resource.unsubscribe();
                }
            } else {
                RxJavaHooks.onError(th);
            }
        }

        public void setSubscription(Subscription subscription) {
            this.resource.update(subscription);
        }

        public void setCancellation(Cancellable cancellable) {
            setSubscription(new CancellableSubscription(cancellable));
        }

        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.resource.unsubscribe();
            }
        }

        public boolean isUnsubscribed() {
            return get();
        }
    }
}
