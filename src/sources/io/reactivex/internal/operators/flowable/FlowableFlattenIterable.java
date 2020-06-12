package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFlattenIterable<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final Function<? super T, ? extends Iterable<? extends R>> mapper;
    final int prefetch;

    public FlowableFlattenIterable(Flowable<T> flowable, Function<? super T, ? extends Iterable<? extends R>> function, int i) {
        super(flowable);
        this.mapper = function;
        this.prefetch = i;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        if (this.source instanceof Callable) {
            try {
                Object call = ((Callable) this.source).call();
                if (call == null) {
                    EmptySubscription.complete(subscriber);
                    return;
                }
                try {
                    FlowableFromIterable.subscribe(subscriber, ((Iterable) this.mapper.apply(call)).iterator());
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    EmptySubscription.error(th, subscriber);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                EmptySubscription.error(th2, subscriber);
            }
        } else {
            this.source.subscribe(new FlattenIterableSubscriber(subscriber, this.mapper, this.prefetch));
        }
    }

    static final class FlattenIterableSubscriber<T, R> extends BasicIntQueueSubscription<R> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -3096000382929934955L;
        volatile boolean cancelled;
        int consumed;
        Iterator<? extends R> current;
        volatile boolean done;
        final Subscriber<? super R> downstream;
        final AtomicReference<Throwable> error = new AtomicReference<>();
        int fusionMode;
        final int limit;
        final Function<? super T, ? extends Iterable<? extends R>> mapper;
        final int prefetch;
        SimpleQueue<T> queue;
        final AtomicLong requested = new AtomicLong();
        Subscription upstream;

        FlattenIterableSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Iterable<? extends R>> function, int i) {
            this.downstream = subscriber;
            this.mapper = function;
            this.prefetch = i;
            this.limit = i - (i >> 2);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.fusionMode = requestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        return;
                    } else if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = queueSubscription;
                        this.downstream.onSubscribe(this);
                        subscription.request((long) this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                this.downstream.onSubscribe(this);
                subscription.request((long) this.prefetch);
            }
        }

        public void onNext(T t) {
            if (!this.done) {
                if (this.fusionMode != 0 || this.queue.offer(t)) {
                    drain();
                } else {
                    onError(new MissingBackpressureException("Queue is full?!"));
                }
            }
        }

        public void onError(Throwable th) {
            if (this.done || !ExceptionHelper.addThrowable(this.error, th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            drain();
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                drain();
            }
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.cancel();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x0121, code lost:
            if (r6 == null) goto L_0x012c;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void drain() {
            /*
                r18 = this;
                r1 = r18
                int r0 = r18.getAndIncrement()
                if (r0 == 0) goto L_0x0009
                return
            L_0x0009:
                org.reactivestreams.Subscriber<? super R> r2 = r1.downstream
                io.reactivex.internal.fuseable.SimpleQueue<T> r3 = r1.queue
                int r0 = r1.fusionMode
                r4 = 0
                r5 = 1
                if (r0 == r5) goto L_0x0015
                r0 = 1
                goto L_0x0016
            L_0x0015:
                r0 = 0
            L_0x0016:
                java.util.Iterator<? extends R> r6 = r1.current
                r7 = 0
                r8 = 1
            L_0x001a:
                if (r6 != 0) goto L_0x0080
                boolean r9 = r1.done
                java.lang.Object r10 = r3.poll()     // Catch:{ all -> 0x0062 }
                if (r10 != 0) goto L_0x0026
                r11 = 1
                goto L_0x0027
            L_0x0026:
                r11 = 0
            L_0x0027:
                boolean r9 = r1.checkTerminated(r9, r11, r2, r3)
                if (r9 == 0) goto L_0x002e
                return
            L_0x002e:
                if (r10 == 0) goto L_0x0080
                io.reactivex.functions.Function<? super T, ? extends java.lang.Iterable<? extends R>> r6 = r1.mapper     // Catch:{ all -> 0x004a }
                java.lang.Object r6 = r6.apply(r10)     // Catch:{ all -> 0x004a }
                java.lang.Iterable r6 = (java.lang.Iterable) r6     // Catch:{ all -> 0x004a }
                java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x004a }
                boolean r9 = r6.hasNext()     // Catch:{ all -> 0x004a }
                if (r9 != 0) goto L_0x0047
                r1.consumedOne(r0)
                r6 = r7
                goto L_0x001a
            L_0x0047:
                r1.current = r6
                goto L_0x0080
            L_0x004a:
                r0 = move-exception
                io.reactivex.exceptions.Exceptions.throwIfFatal(r0)
                org.reactivestreams.Subscription r3 = r1.upstream
                r3.cancel()
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r3 = r1.error
                io.reactivex.internal.util.ExceptionHelper.addThrowable(r3, r0)
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r0 = r1.error
                java.lang.Throwable r0 = io.reactivex.internal.util.ExceptionHelper.terminate(r0)
                r2.onError(r0)
                return
            L_0x0062:
                r0 = move-exception
                r4 = r0
                io.reactivex.exceptions.Exceptions.throwIfFatal(r4)
                org.reactivestreams.Subscription r0 = r1.upstream
                r0.cancel()
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r0 = r1.error
                io.reactivex.internal.util.ExceptionHelper.addThrowable(r0, r4)
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r0 = r1.error
                java.lang.Throwable r0 = io.reactivex.internal.util.ExceptionHelper.terminate(r0)
                r1.current = r7
                r3.clear()
                r2.onError(r0)
                return
            L_0x0080:
                if (r6 == 0) goto L_0x0124
                java.util.concurrent.atomic.AtomicLong r9 = r1.requested
                long r9 = r9.get()
                r11 = 0
                r13 = r11
            L_0x008b:
                int r15 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1))
                if (r15 == 0) goto L_0x00f6
                boolean r15 = r1.done
                boolean r15 = r1.checkTerminated(r15, r4, r2, r3)
                if (r15 == 0) goto L_0x0098
                return
            L_0x0098:
                java.lang.Object r15 = r6.next()     // Catch:{ all -> 0x00dc }
                java.lang.String r5 = "The iterator returned a null value"
                java.lang.Object r5 = io.reactivex.internal.functions.ObjectHelper.requireNonNull(r15, (java.lang.String) r5)     // Catch:{ all -> 0x00dc }
                r2.onNext(r5)
                boolean r5 = r1.done
                boolean r5 = r1.checkTerminated(r5, r4, r2, r3)
                if (r5 == 0) goto L_0x00ae
                return
            L_0x00ae:
                r16 = 1
                long r13 = r13 + r16
                boolean r5 = r6.hasNext()     // Catch:{ all -> 0x00c1 }
                if (r5 != 0) goto L_0x00bf
                r1.consumedOne(r0)
                r1.current = r7
                r6 = r7
                goto L_0x00f6
            L_0x00bf:
                r5 = 1
                goto L_0x008b
            L_0x00c1:
                r0 = move-exception
                r3 = r0
                io.reactivex.exceptions.Exceptions.throwIfFatal(r3)
                r1.current = r7
                org.reactivestreams.Subscription r0 = r1.upstream
                r0.cancel()
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r0 = r1.error
                io.reactivex.internal.util.ExceptionHelper.addThrowable(r0, r3)
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r0 = r1.error
                java.lang.Throwable r0 = io.reactivex.internal.util.ExceptionHelper.terminate(r0)
                r2.onError(r0)
                return
            L_0x00dc:
                r0 = move-exception
                io.reactivex.exceptions.Exceptions.throwIfFatal(r0)
                r1.current = r7
                org.reactivestreams.Subscription r3 = r1.upstream
                r3.cancel()
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r3 = r1.error
                io.reactivex.internal.util.ExceptionHelper.addThrowable(r3, r0)
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r0 = r1.error
                java.lang.Throwable r0 = io.reactivex.internal.util.ExceptionHelper.terminate(r0)
                r2.onError(r0)
                return
            L_0x00f6:
                int r5 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1))
                if (r5 != 0) goto L_0x010e
                boolean r5 = r1.done
                boolean r15 = r3.isEmpty()
                if (r15 == 0) goto L_0x0106
                if (r6 != 0) goto L_0x0106
                r15 = 1
                goto L_0x0107
            L_0x0106:
                r15 = 0
            L_0x0107:
                boolean r5 = r1.checkTerminated(r5, r15, r2, r3)
                if (r5 == 0) goto L_0x010e
                return
            L_0x010e:
                int r5 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
                if (r5 == 0) goto L_0x0121
                r11 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r5 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
                if (r5 == 0) goto L_0x0121
                java.util.concurrent.atomic.AtomicLong r5 = r1.requested
                long r9 = -r13
                r5.addAndGet(r9)
            L_0x0121:
                if (r6 != 0) goto L_0x0124
                goto L_0x012c
            L_0x0124:
                int r5 = -r8
                int r8 = r1.addAndGet(r5)
                if (r8 != 0) goto L_0x012c
                return
            L_0x012c:
                r5 = 1
                goto L_0x001a
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFlattenIterable.FlattenIterableSubscriber.drain():void");
        }

        /* access modifiers changed from: package-private */
        public void consumedOne(boolean z) {
            if (z) {
                int i = this.consumed + 1;
                if (i == this.limit) {
                    this.consumed = 0;
                    this.upstream.request((long) i);
                    return;
                }
                this.consumed = i;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean checkTerminated(boolean z, boolean z2, Subscriber<?> subscriber, SimpleQueue<?> simpleQueue) {
            if (this.cancelled) {
                this.current = null;
                simpleQueue.clear();
                return true;
            } else if (!z) {
                return false;
            } else {
                if (this.error.get() != null) {
                    Throwable terminate = ExceptionHelper.terminate(this.error);
                    this.current = null;
                    simpleQueue.clear();
                    subscriber.onError(terminate);
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    subscriber.onComplete();
                    return true;
                }
            }
        }

        public void clear() {
            this.current = null;
            this.queue.clear();
        }

        public boolean isEmpty() {
            return this.current == null && this.queue.isEmpty();
        }

        public R poll() throws Exception {
            Iterator<? extends R> it = this.current;
            while (true) {
                if (it == null) {
                    T poll = this.queue.poll();
                    if (poll != null) {
                        it = ((Iterable) this.mapper.apply(poll)).iterator();
                        if (it.hasNext()) {
                            this.current = it;
                            break;
                        }
                        it = null;
                    } else {
                        return null;
                    }
                } else {
                    break;
                }
            }
            R requireNonNull = ObjectHelper.requireNonNull(it.next(), "The iterator returned a null value");
            if (!it.hasNext()) {
                this.current = null;
            }
            return requireNonNull;
        }

        public int requestFusion(int i) {
            return ((i & 1) == 0 || this.fusionMode != 1) ? 0 : 1;
        }
    }
}
