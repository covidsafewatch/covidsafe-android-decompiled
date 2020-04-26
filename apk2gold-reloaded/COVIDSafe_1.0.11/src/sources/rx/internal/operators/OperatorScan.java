package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable.Operator;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func0;
import rx.functions.Func2;
import rx.internal.util.atomic.SpscLinkedAtomicQueue;
import rx.internal.util.unsafe.SpscLinkedQueue;
import rx.internal.util.unsafe.UnsafeAccess;

public final class OperatorScan<R, T> implements Operator<R, T> {
    private static final Object NO_INITIAL_VALUE = new Object();
    final Func2<R, ? super T, R> accumulator;
    private final Func0<R> initialValueFactory;

    static final class InitialProducer<R> implements Producer, Observer<R> {
        final Subscriber<? super R> child;
        volatile boolean done;
        boolean emitting;
        Throwable error;
        boolean missed;
        long missedRequested;
        volatile Producer producer;
        final Queue<Object> queue;
        final AtomicLong requested;

        public InitialProducer(R r, Subscriber<? super R> subscriber) {
            Queue<Object> queue2;
            this.child = subscriber;
            if (UnsafeAccess.isUnsafeAvailable()) {
                queue2 = new SpscLinkedQueue<>();
            } else {
                queue2 = new SpscLinkedAtomicQueue<>();
            }
            this.queue = queue2;
            queue2.offer(NotificationLite.next(r));
            this.requested = new AtomicLong();
        }

        public void onNext(R r) {
            this.queue.offer(NotificationLite.next(r));
            emit();
        }

        /* access modifiers changed from: 0000 */
        public boolean checkTerminated(boolean z, boolean z2, Subscriber<? super R> subscriber) {
            if (subscriber.isUnsubscribed()) {
                return true;
            }
            if (z) {
                Throwable th = this.error;
                if (th != null) {
                    subscriber.onError(th);
                    return true;
                } else if (z2) {
                    subscriber.onCompleted();
                    return true;
                }
            }
            return false;
        }

        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            emit();
        }

        public void onCompleted() {
            this.done = true;
            emit();
        }

        public void request(long j) {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("n >= required but it was ");
                sb.append(j);
                throw new IllegalArgumentException(sb.toString());
            } else if (i != 0) {
                BackpressureUtils.getAndAddRequest(this.requested, j);
                Producer producer2 = this.producer;
                if (producer2 == null) {
                    synchronized (this.requested) {
                        producer2 = this.producer;
                        if (producer2 == null) {
                            this.missedRequested = BackpressureUtils.addCap(this.missedRequested, j);
                        }
                    }
                }
                if (producer2 != null) {
                    producer2.request(j);
                }
                emit();
            }
        }

        public void setProducer(Producer producer2) {
            long j;
            if (producer2 != null) {
                synchronized (this.requested) {
                    if (this.producer == null) {
                        j = this.missedRequested;
                        if (j != LongCompanionObject.MAX_VALUE) {
                            j--;
                        }
                        this.missedRequested = 0;
                        this.producer = producer2;
                    } else {
                        throw new IllegalStateException("Can't set more than one Producer!");
                    }
                }
                if (j > 0) {
                    producer2.request(j);
                }
                emit();
                return;
            }
            throw null;
        }

        /* access modifiers changed from: 0000 */
        public void emit() {
            synchronized (this) {
                if (this.emitting) {
                    this.missed = true;
                    return;
                }
                this.emitting = true;
                emitLoop();
            }
        }

        /* access modifiers changed from: 0000 */
        public void emitLoop() {
            Subscriber<? super R> subscriber = this.child;
            Queue<Object> queue2 = this.queue;
            AtomicLong atomicLong = this.requested;
            long j = atomicLong.get();
            while (!checkTerminated(this.done, queue2.isEmpty(), subscriber)) {
                long j2 = 0;
                while (j2 != j) {
                    boolean z = this.done;
                    Object poll = queue2.poll();
                    boolean z2 = poll == null;
                    if (!checkTerminated(z, z2, subscriber)) {
                        if (z2) {
                            break;
                        }
                        Object value = NotificationLite.getValue(poll);
                        try {
                            subscriber.onNext(value);
                            j2++;
                        } catch (Throwable th) {
                            Exceptions.throwOrReport(th, (Observer<?>) subscriber, value);
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (!(j2 == 0 || j == LongCompanionObject.MAX_VALUE)) {
                    j = BackpressureUtils.produced(atomicLong, j2);
                }
                synchronized (this) {
                    if (!this.missed) {
                        this.emitting = false;
                        return;
                    }
                    this.missed = false;
                }
            }
        }
    }

    public OperatorScan(final R r, Func2<R, ? super T, R> func2) {
        this((Func0<R>) new Func0<R>() {
            public R call() {
                return r;
            }
        }, func2);
    }

    public OperatorScan(Func0<R> func0, Func2<R, ? super T, R> func2) {
        this.initialValueFactory = func0;
        this.accumulator = func2;
    }

    public OperatorScan(Func2<R, ? super T, R> func2) {
        this((R) NO_INITIAL_VALUE, func2);
    }

    public Subscriber<? super T> call(final Subscriber<? super R> subscriber) {
        final Object call = this.initialValueFactory.call();
        if (call == NO_INITIAL_VALUE) {
            return new Subscriber<T>(subscriber) {
                boolean once;
                R value;

                /* JADX WARNING: Incorrect type for immutable var: ssa=T, code=java.lang.Object, for r3v0, types: [T, java.lang.Object] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onNext(java.lang.Object r3) {
                    /*
                        r2 = this;
                        boolean r0 = r2.once
                        if (r0 != 0) goto L_0x0008
                        r0 = 1
                        r2.once = r0
                        goto L_0x0012
                    L_0x0008:
                        R r0 = r2.value
                        rx.internal.operators.OperatorScan r1 = rx.internal.operators.OperatorScan.this     // Catch:{ all -> 0x001a }
                        rx.functions.Func2<R, ? super T, R> r1 = r1.accumulator     // Catch:{ all -> 0x001a }
                        java.lang.Object r3 = r1.call(r0, r3)     // Catch:{ all -> 0x001a }
                    L_0x0012:
                        r2.value = r3
                        rx.Subscriber r0 = r4
                        r0.onNext(r3)
                        return
                    L_0x001a:
                        r0 = move-exception
                        rx.Subscriber r1 = r4
                        rx.exceptions.Exceptions.throwOrReport(r0, r1, r3)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorScan.AnonymousClass2.onNext(java.lang.Object):void");
                }

                public void onError(Throwable th) {
                    subscriber.onError(th);
                }

                public void onCompleted() {
                    subscriber.onCompleted();
                }
            };
        }
        final InitialProducer initialProducer = new InitialProducer(call, subscriber);
        AnonymousClass3 r2 = new Subscriber<T>() {
            private R value = call;

            public void onNext(T t) {
                try {
                    R call = OperatorScan.this.accumulator.call(this.value, t);
                    this.value = call;
                    initialProducer.onNext(call);
                } catch (Throwable th) {
                    Exceptions.throwOrReport(th, (Observer<?>) this, (Object) t);
                }
            }

            public void onError(Throwable th) {
                initialProducer.onError(th);
            }

            public void onCompleted() {
                initialProducer.onCompleted();
            }

            public void setProducer(Producer producer) {
                initialProducer.setProducer(producer);
            }
        };
        subscriber.add(r2);
        subscriber.setProducer(initialProducer);
        return r2;
    }
}
