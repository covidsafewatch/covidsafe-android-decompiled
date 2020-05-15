package rx.observers;

import rx.CompletableSubscriber;
import rx.Subscription;
import rx.exceptions.CompositeException;
import rx.exceptions.Exceptions;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
import rx.plugins.RxJavaHooks;

public final class SafeCompletableSubscriber implements CompletableSubscriber, Subscription {
    final CompletableSubscriber actual;
    boolean done;
    Subscription s;

    public SafeCompletableSubscriber(CompletableSubscriber completableSubscriber) {
        this.actual = completableSubscriber;
    }

    public void onCompleted() {
        if (!this.done) {
            this.done = true;
            try {
                this.actual.onCompleted();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                throw new OnCompletedFailedException(th);
            }
        }
    }

    public void onError(Throwable th) {
        if (this.done) {
            RxJavaHooks.onError(th);
            return;
        }
        this.done = true;
        try {
            this.actual.onError(th);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            throw new OnErrorFailedException(new CompositeException(th, th2));
        }
    }

    public void onSubscribe(Subscription subscription) {
        this.s = subscription;
        try {
            this.actual.onSubscribe(this);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            subscription.unsubscribe();
            onError(th);
        }
    }

    public void unsubscribe() {
        this.s.unsubscribe();
    }

    public boolean isUnsubscribed() {
        return this.done || this.s.isUnsubscribed();
    }
}
