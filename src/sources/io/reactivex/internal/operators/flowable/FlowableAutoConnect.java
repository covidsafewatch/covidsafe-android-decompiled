package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;

public final class FlowableAutoConnect<T> extends Flowable<T> {
    final AtomicInteger clients = new AtomicInteger();
    final Consumer<? super Disposable> connection;
    final int numberOfSubscribers;
    final ConnectableFlowable<? extends T> source;

    public FlowableAutoConnect(ConnectableFlowable<? extends T> connectableFlowable, int i, Consumer<? super Disposable> consumer) {
        this.source = connectableFlowable;
        this.numberOfSubscribers = i;
        this.connection = consumer;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(subscriber);
        if (this.clients.incrementAndGet() == this.numberOfSubscribers) {
            this.source.connect(this.connection);
        }
    }
}
