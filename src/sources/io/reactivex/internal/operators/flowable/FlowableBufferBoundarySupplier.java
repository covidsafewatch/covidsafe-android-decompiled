package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.DisposableSubscriber;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableBufferBoundarySupplier<T, U extends Collection<? super T>, B> extends AbstractFlowableWithUpstream<T, U> {
    final Callable<? extends Publisher<B>> boundarySupplier;
    final Callable<U> bufferSupplier;

    public FlowableBufferBoundarySupplier(Flowable<T> flowable, Callable<? extends Publisher<B>> callable, Callable<U> callable2) {
        super(flowable);
        this.boundarySupplier = callable;
        this.bufferSupplier = callable2;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super U> subscriber) {
        this.source.subscribe(new BufferBoundarySupplierSubscriber(new SerializedSubscriber(subscriber), this.bufferSupplier, this.boundarySupplier));
    }

    static final class BufferBoundarySupplierSubscriber<T, U extends Collection<? super T>, B> extends QueueDrainSubscriber<T, U, U> implements FlowableSubscriber<T>, Subscription, Disposable {
        final Callable<? extends Publisher<B>> boundarySupplier;
        U buffer;
        final Callable<U> bufferSupplier;
        final AtomicReference<Disposable> other = new AtomicReference<>();
        Subscription upstream;

        BufferBoundarySupplierSubscriber(Subscriber<? super U> subscriber, Callable<U> callable, Callable<? extends Publisher<B>> callable2) {
            super(subscriber, new MpscLinkedQueue());
            this.bufferSupplier = callable;
            this.boundarySupplier = callable2;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                Subscriber subscriber = this.downstream;
                try {
                    this.buffer = (Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The buffer supplied is null");
                    try {
                        Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.boundarySupplier.call(), "The boundary publisher supplied is null");
                        BufferBoundarySubscriber bufferBoundarySubscriber = new BufferBoundarySubscriber(this);
                        this.other.set(bufferBoundarySubscriber);
                        subscriber.onSubscribe(this);
                        if (!this.cancelled) {
                            subscription.request(LongCompanionObject.MAX_VALUE);
                            publisher.subscribe(bufferBoundarySubscriber);
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.cancelled = true;
                        subscription.cancel();
                        EmptySubscription.error(th, subscriber);
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.cancelled = true;
                    subscription.cancel();
                    EmptySubscription.error(th2, subscriber);
                }
            }
        }

        public void onNext(T t) {
            synchronized (this) {
                U u = this.buffer;
                if (u != null) {
                    u.add(t);
                }
            }
        }

        public void onError(Throwable th) {
            cancel();
            this.downstream.onError(th);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
            io.reactivex.internal.util.QueueDrainHelper.drainMaxLoop(r3.queue, r3.downstream, false, r3, r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x000b, code lost:
            r3.queue.offer(r0);
            r3.done = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
            if (enter() == false) goto L_?;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onComplete() {
            /*
                r3 = this;
                monitor-enter(r3)
                U r0 = r3.buffer     // Catch:{ all -> 0x0022 }
                if (r0 != 0) goto L_0x0007
                monitor-exit(r3)     // Catch:{ all -> 0x0022 }
                return
            L_0x0007:
                r1 = 0
                r3.buffer = r1     // Catch:{ all -> 0x0022 }
                monitor-exit(r3)     // Catch:{ all -> 0x0022 }
                io.reactivex.internal.fuseable.SimplePlainQueue r1 = r3.queue
                r1.offer(r0)
                r0 = 1
                r3.done = r0
                boolean r0 = r3.enter()
                if (r0 == 0) goto L_0x0021
                io.reactivex.internal.fuseable.SimplePlainQueue r0 = r3.queue
                org.reactivestreams.Subscriber r1 = r3.downstream
                r2 = 0
                io.reactivex.internal.util.QueueDrainHelper.drainMaxLoop(r0, r1, r2, r3, r3)
            L_0x0021:
                return
            L_0x0022:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0022 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableBufferBoundarySupplier.BufferBoundarySupplierSubscriber.onComplete():void");
        }

        public void request(long j) {
            requested(j);
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.cancel();
                disposeOther();
                if (enter()) {
                    this.queue.clear();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void disposeOther() {
            DisposableHelper.dispose(this.other);
        }

        /* access modifiers changed from: package-private */
        public void next() {
            try {
                U u = (Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The buffer supplied is null");
                try {
                    Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.boundarySupplier.call(), "The boundary publisher supplied is null");
                    BufferBoundarySubscriber bufferBoundarySubscriber = new BufferBoundarySubscriber(this);
                    if (DisposableHelper.replace(this.other, bufferBoundarySubscriber)) {
                        synchronized (this) {
                            U u2 = this.buffer;
                            if (u2 != null) {
                                this.buffer = u;
                                publisher.subscribe(bufferBoundarySubscriber);
                                fastPathEmitMax(u2, false, this);
                            }
                        }
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.cancelled = true;
                    this.upstream.cancel();
                    this.downstream.onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                cancel();
                this.downstream.onError(th2);
            }
        }

        public void dispose() {
            this.upstream.cancel();
            disposeOther();
        }

        public boolean isDisposed() {
            return this.other.get() == DisposableHelper.DISPOSED;
        }

        public boolean accept(Subscriber<? super U> subscriber, U u) {
            this.downstream.onNext(u);
            return true;
        }
    }

    static final class BufferBoundarySubscriber<T, U extends Collection<? super T>, B> extends DisposableSubscriber<B> {
        boolean once;
        final BufferBoundarySupplierSubscriber<T, U, B> parent;

        BufferBoundarySubscriber(BufferBoundarySupplierSubscriber<T, U, B> bufferBoundarySupplierSubscriber) {
            this.parent = bufferBoundarySupplierSubscriber;
        }

        public void onNext(B b) {
            if (!this.once) {
                this.once = true;
                cancel();
                this.parent.next();
            }
        }

        public void onError(Throwable th) {
            if (this.once) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.once = true;
            this.parent.onError(th);
        }

        public void onComplete() {
            if (!this.once) {
                this.once = true;
                this.parent.next();
            }
        }
    }
}
