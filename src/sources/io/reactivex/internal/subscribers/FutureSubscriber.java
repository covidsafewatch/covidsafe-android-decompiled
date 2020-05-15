package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscription;

public final class FutureSubscriber<T> extends CountDownLatch implements FlowableSubscriber<T>, Future<T>, Subscription {
    Throwable error;
    final AtomicReference<Subscription> upstream = new AtomicReference<>();
    T value;

    public void cancel() {
    }

    public void request(long j) {
    }

    public FutureSubscriber() {
        super(1);
    }

    public boolean cancel(boolean z) {
        Subscription subscription;
        do {
            subscription = this.upstream.get();
            if (subscription == this || subscription == SubscriptionHelper.CANCELLED) {
                return false;
            }
        } while (!this.upstream.compareAndSet(subscription, SubscriptionHelper.CANCELLED));
        if (subscription != null) {
            subscription.cancel();
        }
        countDown();
        return true;
    }

    public boolean isCancelled() {
        return this.upstream.get() == SubscriptionHelper.CANCELLED;
    }

    public boolean isDone() {
        return getCount() == 0;
    }

    public T get() throws InterruptedException, ExecutionException {
        if (getCount() != 0) {
            BlockingHelper.verifyNonBlocking();
            await();
        }
        if (!isCancelled()) {
            Throwable th = this.error;
            if (th == null) {
                return this.value;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }

    public T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        if (getCount() != 0) {
            BlockingHelper.verifyNonBlocking();
            if (!await(j, timeUnit)) {
                throw new TimeoutException(ExceptionHelper.timeoutMessage(j, timeUnit));
            }
        }
        if (!isCancelled()) {
            Throwable th = this.error;
            if (th == null) {
                return this.value;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce(this.upstream, subscription, LongCompanionObject.MAX_VALUE);
    }

    public void onNext(T t) {
        if (this.value != null) {
            this.upstream.get().cancel();
            onError(new IndexOutOfBoundsException("More than one element received"));
            return;
        }
        this.value = t;
    }

    public void onError(Throwable th) {
        Subscription subscription;
        do {
            subscription = this.upstream.get();
            if (subscription == this || subscription == SubscriptionHelper.CANCELLED) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.error = th;
        } while (!this.upstream.compareAndSet(subscription, this));
        countDown();
    }

    public void onComplete() {
        Subscription subscription;
        if (this.value == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        do {
            subscription = this.upstream.get();
            if (subscription == this || subscription == SubscriptionHelper.CANCELLED) {
                return;
            }
        } while (!this.upstream.compareAndSet(subscription, this));
        countDown();
    }
}
