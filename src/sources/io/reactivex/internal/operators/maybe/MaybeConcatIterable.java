package io.reactivex.internal.operators.maybe;

import io.reactivex.Flowable;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class MaybeConcatIterable<T> extends Flowable<T> {
    final Iterable<? extends MaybeSource<? extends T>> sources;

    public MaybeConcatIterable(Iterable<? extends MaybeSource<? extends T>> iterable) {
        this.sources = iterable;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            ConcatMaybeObserver concatMaybeObserver = new ConcatMaybeObserver(subscriber, (Iterator) ObjectHelper.requireNonNull(this.sources.iterator(), "The sources Iterable returned a null Iterator"));
            subscriber.onSubscribe(concatMaybeObserver);
            concatMaybeObserver.drain();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }

    static final class ConcatMaybeObserver<T> extends AtomicInteger implements MaybeObserver<T>, Subscription {
        private static final long serialVersionUID = 3520831347801429610L;
        final AtomicReference<Object> current = new AtomicReference<>(NotificationLite.COMPLETE);
        final SequentialDisposable disposables = new SequentialDisposable();
        final Subscriber<? super T> downstream;
        long produced;
        final AtomicLong requested = new AtomicLong();
        final Iterator<? extends MaybeSource<? extends T>> sources;

        ConcatMaybeObserver(Subscriber<? super T> subscriber, Iterator<? extends MaybeSource<? extends T>> it) {
            this.downstream = subscriber;
            this.sources = it;
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }

        public void cancel() {
            this.disposables.dispose();
        }

        public void onSubscribe(Disposable disposable) {
            this.disposables.replace(disposable);
        }

        public void onSuccess(T t) {
            this.current.lazySet(t);
            drain();
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public void onComplete() {
            this.current.lazySet(NotificationLite.COMPLETE);
            drain();
        }

        /* access modifiers changed from: package-private */
        public void drain() {
            if (getAndIncrement() == 0) {
                AtomicReference<Object> atomicReference = this.current;
                Subscriber<? super T> subscriber = this.downstream;
                SequentialDisposable sequentialDisposable = this.disposables;
                while (!sequentialDisposable.isDisposed()) {
                    Object obj = atomicReference.get();
                    if (obj != null) {
                        boolean z = true;
                        if (obj != NotificationLite.COMPLETE) {
                            long j = this.produced;
                            if (j != this.requested.get()) {
                                this.produced = j + 1;
                                atomicReference.lazySet((Object) null);
                                subscriber.onNext(obj);
                            } else {
                                z = false;
                            }
                        } else {
                            atomicReference.lazySet((Object) null);
                        }
                        if (z && !sequentialDisposable.isDisposed()) {
                            try {
                                if (this.sources.hasNext()) {
                                    try {
                                        ((MaybeSource) ObjectHelper.requireNonNull(this.sources.next(), "The source Iterator returned a null MaybeSource")).subscribe(this);
                                    } catch (Throwable th) {
                                        Exceptions.throwIfFatal(th);
                                        subscriber.onError(th);
                                        return;
                                    }
                                } else {
                                    subscriber.onComplete();
                                }
                            } catch (Throwable th2) {
                                Exceptions.throwIfFatal(th2);
                                subscriber.onError(th2);
                                return;
                            }
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                atomicReference.lazySet((Object) null);
            }
        }
    }
}
