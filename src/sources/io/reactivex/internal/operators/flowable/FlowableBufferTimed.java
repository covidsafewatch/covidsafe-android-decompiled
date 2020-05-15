package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableBufferTimed<T, U extends Collection<? super T>> extends AbstractFlowableWithUpstream<T, U> {
    final Callable<U> bufferSupplier;
    final int maxSize;
    final boolean restartTimerOnMaxSize;
    final Scheduler scheduler;
    final long timeskip;
    final long timespan;
    final TimeUnit unit;

    public FlowableBufferTimed(Flowable<T> flowable, long j, long j2, TimeUnit timeUnit, Scheduler scheduler2, Callable<U> callable, int i, boolean z) {
        super(flowable);
        this.timespan = j;
        this.timeskip = j2;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
        this.bufferSupplier = callable;
        this.maxSize = i;
        this.restartTimerOnMaxSize = z;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super U> subscriber) {
        if (this.timespan == this.timeskip && this.maxSize == Integer.MAX_VALUE) {
            this.source.subscribe(new BufferExactUnboundedSubscriber(new SerializedSubscriber(subscriber), this.bufferSupplier, this.timespan, this.unit, this.scheduler));
            return;
        }
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        if (this.timespan == this.timeskip) {
            this.source.subscribe(new BufferExactBoundedSubscriber(new SerializedSubscriber(subscriber), this.bufferSupplier, this.timespan, this.unit, this.maxSize, this.restartTimerOnMaxSize, createWorker));
        } else {
            this.source.subscribe(new BufferSkipBoundedSubscriber(new SerializedSubscriber(subscriber), this.bufferSupplier, this.timespan, this.timeskip, this.unit, createWorker));
        }
    }

    static final class BufferExactUnboundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable, Disposable {
        U buffer;
        final Callable<U> bufferSupplier;
        final Scheduler scheduler;
        final AtomicReference<Disposable> timer = new AtomicReference<>();
        final long timespan;
        final TimeUnit unit;
        Subscription upstream;

        BufferExactUnboundedSubscriber(Subscriber<? super U> subscriber, Callable<U> callable, long j, TimeUnit timeUnit, Scheduler scheduler2) {
            super(subscriber, new MpscLinkedQueue());
            this.bufferSupplier = callable;
            this.timespan = j;
            this.unit = timeUnit;
            this.scheduler = scheduler2;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                try {
                    this.buffer = (Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The supplied buffer is null");
                    this.downstream.onSubscribe(this);
                    if (!this.cancelled) {
                        subscription.request(LongCompanionObject.MAX_VALUE);
                        Scheduler scheduler2 = this.scheduler;
                        long j = this.timespan;
                        Disposable schedulePeriodicallyDirect = scheduler2.schedulePeriodicallyDirect(this, j, j, this.unit);
                        if (!this.timer.compareAndSet((Object) null, schedulePeriodicallyDirect)) {
                            schedulePeriodicallyDirect.dispose();
                        }
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    cancel();
                    EmptySubscription.error(th, this.downstream);
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
            DisposableHelper.dispose(this.timer);
            synchronized (this) {
                this.buffer = null;
            }
            this.downstream.onError(th);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
            if (enter() == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
            io.reactivex.internal.util.QueueDrainHelper.drainMaxLoop(r4.queue, r4.downstream, false, (io.reactivex.disposables.Disposable) null, r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0010, code lost:
            r4.queue.offer(r0);
            r4.done = true;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onComplete() {
            /*
                r4 = this;
                java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> r0 = r4.timer
                io.reactivex.internal.disposables.DisposableHelper.dispose(r0)
                monitor-enter(r4)
                U r0 = r4.buffer     // Catch:{ all -> 0x0027 }
                if (r0 != 0) goto L_0x000c
                monitor-exit(r4)     // Catch:{ all -> 0x0027 }
                return
            L_0x000c:
                r1 = 0
                r4.buffer = r1     // Catch:{ all -> 0x0027 }
                monitor-exit(r4)     // Catch:{ all -> 0x0027 }
                io.reactivex.internal.fuseable.SimplePlainQueue r2 = r4.queue
                r2.offer(r0)
                r0 = 1
                r4.done = r0
                boolean r0 = r4.enter()
                if (r0 == 0) goto L_0x0026
                io.reactivex.internal.fuseable.SimplePlainQueue r0 = r4.queue
                org.reactivestreams.Subscriber r2 = r4.downstream
                r3 = 0
                io.reactivex.internal.util.QueueDrainHelper.drainMaxLoop(r0, r2, r3, r1, r4)
            L_0x0026:
                return
            L_0x0027:
                r0 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x0027 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableBufferTimed.BufferExactUnboundedSubscriber.onComplete():void");
        }

        public void request(long j) {
            requested(j);
        }

        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            DisposableHelper.dispose(this.timer);
        }

        public void run() {
            try {
                U u = (Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The supplied buffer is null");
                synchronized (this) {
                    U u2 = this.buffer;
                    if (u2 != null) {
                        this.buffer = u;
                        fastPathEmitMax(u2, false, this);
                    }
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                cancel();
                this.downstream.onError(th);
            }
        }

        public boolean accept(Subscriber<? super U> subscriber, U u) {
            this.downstream.onNext(u);
            return true;
        }

        public void dispose() {
            cancel();
        }

        public boolean isDisposed() {
            return this.timer.get() == DisposableHelper.DISPOSED;
        }
    }

    static final class BufferSkipBoundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable {
        final Callable<U> bufferSupplier;
        final List<U> buffers = new LinkedList();
        final long timeskip;
        final long timespan;
        final TimeUnit unit;
        Subscription upstream;
        final Scheduler.Worker w;

        BufferSkipBoundedSubscriber(Subscriber<? super U> subscriber, Callable<U> callable, long j, long j2, TimeUnit timeUnit, Scheduler.Worker worker) {
            super(subscriber, new MpscLinkedQueue());
            this.bufferSupplier = callable;
            this.timespan = j;
            this.timeskip = j2;
            this.unit = timeUnit;
            this.w = worker;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                try {
                    Collection collection = (Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The supplied buffer is null");
                    this.buffers.add(collection);
                    this.downstream.onSubscribe(this);
                    subscription.request(LongCompanionObject.MAX_VALUE);
                    Scheduler.Worker worker = this.w;
                    long j = this.timeskip;
                    worker.schedulePeriodically(this, j, j, this.unit);
                    this.w.schedule(new RemoveFromBuffer(collection), this.timespan, this.unit);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.w.dispose();
                    subscription.cancel();
                    EmptySubscription.error(th, this.downstream);
                }
            }
        }

        public void onNext(T t) {
            synchronized (this) {
                for (U add : this.buffers) {
                    add.add(t);
                }
            }
        }

        public void onError(Throwable th) {
            this.done = true;
            this.w.dispose();
            clear();
            this.downstream.onError(th);
        }

        public void onComplete() {
            ArrayList<Collection> arrayList;
            synchronized (this) {
                arrayList = new ArrayList<>(this.buffers);
                this.buffers.clear();
            }
            for (Collection offer : arrayList) {
                this.queue.offer(offer);
            }
            this.done = true;
            if (enter()) {
                QueueDrainHelper.drainMaxLoop(this.queue, this.downstream, false, this.w, this);
            }
        }

        public void request(long j) {
            requested(j);
        }

        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            this.w.dispose();
            clear();
        }

        /* access modifiers changed from: package-private */
        public void clear() {
            synchronized (this) {
                this.buffers.clear();
            }
        }

        public void run() {
            if (!this.cancelled) {
                try {
                    Collection collection = (Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The supplied buffer is null");
                    synchronized (this) {
                        if (!this.cancelled) {
                            this.buffers.add(collection);
                            this.w.schedule(new RemoveFromBuffer(collection), this.timespan, this.unit);
                        }
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    cancel();
                    this.downstream.onError(th);
                }
            }
        }

        public boolean accept(Subscriber<? super U> subscriber, U u) {
            subscriber.onNext(u);
            return true;
        }

        final class RemoveFromBuffer implements Runnable {
            private final U buffer;

            RemoveFromBuffer(U u) {
                this.buffer = u;
            }

            public void run() {
                synchronized (BufferSkipBoundedSubscriber.this) {
                    BufferSkipBoundedSubscriber.this.buffers.remove(this.buffer);
                }
                BufferSkipBoundedSubscriber bufferSkipBoundedSubscriber = BufferSkipBoundedSubscriber.this;
                bufferSkipBoundedSubscriber.fastPathOrderedEmitMax(this.buffer, false, bufferSkipBoundedSubscriber.w);
            }
        }
    }

    static final class BufferExactBoundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable, Disposable {
        U buffer;
        final Callable<U> bufferSupplier;
        long consumerIndex;
        final int maxSize;
        long producerIndex;
        final boolean restartTimerOnMaxSize;
        Disposable timer;
        final long timespan;
        final TimeUnit unit;
        Subscription upstream;
        final Scheduler.Worker w;

        BufferExactBoundedSubscriber(Subscriber<? super U> subscriber, Callable<U> callable, long j, TimeUnit timeUnit, int i, boolean z, Scheduler.Worker worker) {
            super(subscriber, new MpscLinkedQueue());
            this.bufferSupplier = callable;
            this.timespan = j;
            this.unit = timeUnit;
            this.maxSize = i;
            this.restartTimerOnMaxSize = z;
            this.w = worker;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                try {
                    this.buffer = (Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The supplied buffer is null");
                    this.downstream.onSubscribe(this);
                    Scheduler.Worker worker = this.w;
                    long j = this.timespan;
                    this.timer = worker.schedulePeriodically(this, j, j, this.unit);
                    subscription.request(LongCompanionObject.MAX_VALUE);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.w.dispose();
                    subscription.cancel();
                    EmptySubscription.error(th, this.downstream);
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
            if (r7.restartTimerOnMaxSize == false) goto L_0x0028;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
            r7.timer.dispose();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0028, code lost:
            fastPathOrderedEmitMax(r0, false, r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            r8 = (java.util.Collection) io.reactivex.internal.functions.ObjectHelper.requireNonNull(r7.bufferSupplier.call(), "The supplied buffer is null");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x003a, code lost:
            monitor-enter(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            r7.buffer = r8;
            r7.consumerIndex++;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0042, code lost:
            monitor-exit(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0045, code lost:
            if (r7.restartTimerOnMaxSize == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0047, code lost:
            r0 = r7.w;
            r4 = r7.timespan;
            r7.timer = r0.schedulePeriodically(r7, r4, r4, r7.unit);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0059, code lost:
            r8 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x005a, code lost:
            io.reactivex.exceptions.Exceptions.throwIfFatal(r8);
            cancel();
            r7.downstream.onError(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0065, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onNext(T r8) {
            /*
                r7 = this;
                monitor-enter(r7)
                U r0 = r7.buffer     // Catch:{ all -> 0x0066 }
                if (r0 != 0) goto L_0x0007
                monitor-exit(r7)     // Catch:{ all -> 0x0066 }
                return
            L_0x0007:
                r0.add(r8)     // Catch:{ all -> 0x0066 }
                int r8 = r0.size()     // Catch:{ all -> 0x0066 }
                int r1 = r7.maxSize     // Catch:{ all -> 0x0066 }
                if (r8 >= r1) goto L_0x0014
                monitor-exit(r7)     // Catch:{ all -> 0x0066 }
                return
            L_0x0014:
                r8 = 0
                r7.buffer = r8     // Catch:{ all -> 0x0066 }
                long r1 = r7.producerIndex     // Catch:{ all -> 0x0066 }
                r3 = 1
                long r1 = r1 + r3
                r7.producerIndex = r1     // Catch:{ all -> 0x0066 }
                monitor-exit(r7)     // Catch:{ all -> 0x0066 }
                boolean r8 = r7.restartTimerOnMaxSize
                if (r8 == 0) goto L_0x0028
                io.reactivex.disposables.Disposable r8 = r7.timer
                r8.dispose()
            L_0x0028:
                r8 = 0
                r7.fastPathOrderedEmitMax(r0, r8, r7)
                java.util.concurrent.Callable<U> r8 = r7.bufferSupplier     // Catch:{ all -> 0x0059 }
                java.lang.Object r8 = r8.call()     // Catch:{ all -> 0x0059 }
                java.lang.String r0 = "The supplied buffer is null"
                java.lang.Object r8 = io.reactivex.internal.functions.ObjectHelper.requireNonNull(r8, (java.lang.String) r0)     // Catch:{ all -> 0x0059 }
                java.util.Collection r8 = (java.util.Collection) r8     // Catch:{ all -> 0x0059 }
                monitor-enter(r7)
                r7.buffer = r8     // Catch:{ all -> 0x0056 }
                long r0 = r7.consumerIndex     // Catch:{ all -> 0x0056 }
                long r0 = r0 + r3
                r7.consumerIndex = r0     // Catch:{ all -> 0x0056 }
                monitor-exit(r7)     // Catch:{ all -> 0x0056 }
                boolean r8 = r7.restartTimerOnMaxSize
                if (r8 == 0) goto L_0x0055
                io.reactivex.Scheduler$Worker r0 = r7.w
                long r4 = r7.timespan
                java.util.concurrent.TimeUnit r6 = r7.unit
                r1 = r7
                r2 = r4
                io.reactivex.disposables.Disposable r8 = r0.schedulePeriodically(r1, r2, r4, r6)
                r7.timer = r8
            L_0x0055:
                return
            L_0x0056:
                r8 = move-exception
                monitor-exit(r7)     // Catch:{ all -> 0x0056 }
                throw r8
            L_0x0059:
                r8 = move-exception
                io.reactivex.exceptions.Exceptions.throwIfFatal(r8)
                r7.cancel()
                org.reactivestreams.Subscriber r0 = r7.downstream
                r0.onError(r8)
                return
            L_0x0066:
                r8 = move-exception
                monitor-exit(r7)     // Catch:{ all -> 0x0066 }
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableBufferTimed.BufferExactBoundedSubscriber.onNext(java.lang.Object):void");
        }

        public void onError(Throwable th) {
            synchronized (this) {
                this.buffer = null;
            }
            this.downstream.onError(th);
            this.w.dispose();
        }

        public void onComplete() {
            U u;
            synchronized (this) {
                u = this.buffer;
                this.buffer = null;
            }
            this.queue.offer(u);
            this.done = true;
            if (enter()) {
                QueueDrainHelper.drainMaxLoop(this.queue, this.downstream, false, this, this);
            }
            this.w.dispose();
        }

        public boolean accept(Subscriber<? super U> subscriber, U u) {
            subscriber.onNext(u);
            return true;
        }

        public void request(long j) {
            requested(j);
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                dispose();
            }
        }

        public void dispose() {
            synchronized (this) {
                this.buffer = null;
            }
            this.upstream.cancel();
            this.w.dispose();
        }

        public boolean isDisposed() {
            return this.w.isDisposed();
        }

        public void run() {
            try {
                U u = (Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The supplied buffer is null");
                synchronized (this) {
                    U u2 = this.buffer;
                    if (u2 != null) {
                        if (this.producerIndex == this.consumerIndex) {
                            this.buffer = u;
                            fastPathOrderedEmitMax(u2, false, this);
                        }
                    }
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                cancel();
                this.downstream.onError(th);
            }
        }
    }
}
