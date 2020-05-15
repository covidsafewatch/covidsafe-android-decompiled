package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableDefer<T> extends Flowable<T> {
    final Callable<? extends Publisher<? extends T>> supplier;

    public FlowableDefer(Callable<? extends Publisher<? extends T>> callable) {
        this.supplier = callable;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            ((Publisher) ObjectHelper.requireNonNull(this.supplier.call(), "The publisher supplied is null")).subscribe(subscriber);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
