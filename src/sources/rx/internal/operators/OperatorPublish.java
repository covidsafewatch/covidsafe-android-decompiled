package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.observables.ConnectableObservable;
import rx.subscriptions.Subscriptions;

public final class OperatorPublish<T> extends ConnectableObservable<T> {
    final AtomicReference<PublishSubscriber<T>> current;
    final Observable<? extends T> source;

    public static <T> ConnectableObservable<T> create(Observable<? extends T> observable) {
        final AtomicReference atomicReference = new AtomicReference();
        return new OperatorPublish(new Observable.OnSubscribe<T>() {
            public void call(Subscriber<? super T> subscriber) {
                while (true) {
                    PublishSubscriber publishSubscriber = (PublishSubscriber) atomicReference.get();
                    if (publishSubscriber == null || publishSubscriber.isUnsubscribed()) {
                        PublishSubscriber publishSubscriber2 = new PublishSubscriber(atomicReference);
                        publishSubscriber2.init();
                        if (!atomicReference.compareAndSet(publishSubscriber, publishSubscriber2)) {
                            continue;
                        } else {
                            publishSubscriber = publishSubscriber2;
                        }
                    }
                    InnerProducer innerProducer = new InnerProducer(publishSubscriber, subscriber);
                    if (publishSubscriber.add(innerProducer)) {
                        subscriber.add(innerProducer);
                        subscriber.setProducer(innerProducer);
                        return;
                    }
                }
            }
        }, observable, atomicReference);
    }

    public static <T, R> Observable<R> create(Observable<? extends T> observable, Func1<? super Observable<T>, ? extends Observable<R>> func1) {
        return create(observable, func1, false);
    }

    public static <T, R> Observable<R> create(final Observable<? extends T> observable, final Func1<? super Observable<T>, ? extends Observable<R>> func1, final boolean z) {
        return unsafeCreate(new Observable.OnSubscribe<R>() {
            public void call(final Subscriber<? super R> subscriber) {
                final OnSubscribePublishMulticast onSubscribePublishMulticast = new OnSubscribePublishMulticast(RxRingBuffer.SIZE, z);
                AnonymousClass1 r1 = new Subscriber<R>() {
                    public void onNext(R r) {
                        subscriber.onNext(r);
                    }

                    public void onError(Throwable th) {
                        onSubscribePublishMulticast.unsubscribe();
                        subscriber.onError(th);
                    }

                    public void onCompleted() {
                        onSubscribePublishMulticast.unsubscribe();
                        subscriber.onCompleted();
                    }

                    public void setProducer(Producer producer) {
                        subscriber.setProducer(producer);
                    }
                };
                subscriber.add(onSubscribePublishMulticast);
                subscriber.add(r1);
                ((Observable) func1.call(Observable.unsafeCreate(onSubscribePublishMulticast))).unsafeSubscribe(r1);
                observable.unsafeSubscribe(onSubscribePublishMulticast.subscriber());
            }
        });
    }

    private OperatorPublish(Observable.OnSubscribe<T> onSubscribe, Observable<? extends T> observable, AtomicReference<PublishSubscriber<T>> atomicReference) {
        super(onSubscribe);
        this.source = observable;
        this.current = atomicReference;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connect(rx.functions.Action1<? super rx.Subscription> r5) {
        /*
            r4 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<rx.internal.operators.OperatorPublish$PublishSubscriber<T>> r0 = r4.current
            java.lang.Object r0 = r0.get()
            rx.internal.operators.OperatorPublish$PublishSubscriber r0 = (rx.internal.operators.OperatorPublish.PublishSubscriber) r0
            if (r0 == 0) goto L_0x0010
            boolean r1 = r0.isUnsubscribed()
            if (r1 == 0) goto L_0x0024
        L_0x0010:
            rx.internal.operators.OperatorPublish$PublishSubscriber r1 = new rx.internal.operators.OperatorPublish$PublishSubscriber
            java.util.concurrent.atomic.AtomicReference<rx.internal.operators.OperatorPublish$PublishSubscriber<T>> r2 = r4.current
            r1.<init>(r2)
            r1.init()
            java.util.concurrent.atomic.AtomicReference<rx.internal.operators.OperatorPublish$PublishSubscriber<T>> r2 = r4.current
            boolean r0 = r2.compareAndSet(r0, r1)
            if (r0 != 0) goto L_0x0023
            goto L_0x0000
        L_0x0023:
            r0 = r1
        L_0x0024:
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.shouldConnect
            boolean r1 = r1.get()
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0037
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.shouldConnect
            boolean r1 = r1.compareAndSet(r3, r2)
            if (r1 == 0) goto L_0x0037
            goto L_0x0038
        L_0x0037:
            r2 = r3
        L_0x0038:
            r5.call(r0)
            if (r2 == 0) goto L_0x0042
            rx.Observable<? extends T> r5 = r4.source
            r5.unsafeSubscribe(r0)
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorPublish.connect(rx.functions.Action1):void");
    }

    static final class PublishSubscriber<T> extends Subscriber<T> implements Subscription {
        static final InnerProducer[] EMPTY = new InnerProducer[0];
        static final InnerProducer[] TERMINATED = new InnerProducer[0];
        final AtomicReference<PublishSubscriber<T>> current;
        boolean emitting;
        boolean missed;
        final AtomicReference<InnerProducer[]> producers;
        final Queue<Object> queue;
        final AtomicBoolean shouldConnect;
        volatile Object terminalEvent;

        public PublishSubscriber(AtomicReference<PublishSubscriber<T>> atomicReference) {
            this.queue = UnsafeAccess.isUnsafeAvailable() ? new SpscArrayQueue<>(RxRingBuffer.SIZE) : new SpscAtomicArrayQueue<>(RxRingBuffer.SIZE);
            this.producers = new AtomicReference<>(EMPTY);
            this.current = atomicReference;
            this.shouldConnect = new AtomicBoolean();
        }

        /* access modifiers changed from: package-private */
        public void init() {
            add(Subscriptions.create(new Action0() {
                public void call() {
                    PublishSubscriber.this.producers.getAndSet(PublishSubscriber.TERMINATED);
                    PublishSubscriber.this.current.compareAndSet(PublishSubscriber.this, (Object) null);
                }
            }));
        }

        public void onStart() {
            request((long) RxRingBuffer.SIZE);
        }

        public void onNext(T t) {
            if (!this.queue.offer(NotificationLite.next(t))) {
                onError(new MissingBackpressureException());
            } else {
                dispatch();
            }
        }

        public void onError(Throwable th) {
            if (this.terminalEvent == null) {
                this.terminalEvent = NotificationLite.error(th);
                dispatch();
            }
        }

        public void onCompleted() {
            if (this.terminalEvent == null) {
                this.terminalEvent = NotificationLite.completed();
                dispatch();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean add(InnerProducer<T> innerProducer) {
            InnerProducer[] innerProducerArr;
            InnerProducer[] innerProducerArr2;
            if (innerProducer != null) {
                do {
                    innerProducerArr = this.producers.get();
                    if (innerProducerArr == TERMINATED) {
                        return false;
                    }
                    int length = innerProducerArr.length;
                    innerProducerArr2 = new InnerProducer[(length + 1)];
                    System.arraycopy(innerProducerArr, 0, innerProducerArr2, 0, length);
                    innerProducerArr2[length] = innerProducer;
                } while (!this.producers.compareAndSet(innerProducerArr, innerProducerArr2));
                return true;
            }
            throw null;
        }

        /* access modifiers changed from: package-private */
        public void remove(InnerProducer<T> innerProducer) {
            InnerProducer[] innerProducerArr;
            InnerProducer[] innerProducerArr2;
            do {
                innerProducerArr = this.producers.get();
                if (innerProducerArr != EMPTY && innerProducerArr != TERMINATED) {
                    int i = -1;
                    int length = innerProducerArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (innerProducerArr[i2].equals(innerProducer)) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            innerProducerArr2 = EMPTY;
                        } else {
                            InnerProducer[] innerProducerArr3 = new InnerProducer[(length - 1)];
                            System.arraycopy(innerProducerArr, 0, innerProducerArr3, 0, i);
                            System.arraycopy(innerProducerArr, i + 1, innerProducerArr3, i, (length - i) - 1);
                            innerProducerArr2 = innerProducerArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.producers.compareAndSet(innerProducerArr, innerProducerArr2));
        }

        /* access modifiers changed from: package-private */
        public boolean checkTerminated(Object obj, boolean z) {
            int i = 0;
            if (obj != null) {
                if (!NotificationLite.isCompleted(obj)) {
                    Throwable error = NotificationLite.getError(obj);
                    this.current.compareAndSet(this, (Object) null);
                    try {
                        InnerProducer[] andSet = this.producers.getAndSet(TERMINATED);
                        int length = andSet.length;
                        while (i < length) {
                            andSet[i].child.onError(error);
                            i++;
                        }
                        return true;
                    } finally {
                        unsubscribe();
                    }
                } else if (z) {
                    this.current.compareAndSet(this, (Object) null);
                    try {
                        InnerProducer[] andSet2 = this.producers.getAndSet(TERMINATED);
                        int length2 = andSet2.length;
                        while (i < length2) {
                            andSet2[i].child.onCompleted();
                            i++;
                        }
                        return true;
                    } finally {
                        unsubscribe();
                    }
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            r0 = r1.terminalEvent;
            r4 = r1.queue.isEmpty();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
            if (checkTerminated(r0, r4) == false) goto L_0x0021;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0021, code lost:
            if (r4 != false) goto L_0x00c6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
            r5 = r1.producers.get();
            r0 = r5.length;
            r6 = kotlin.jvm.internal.LongCompanionObject.MAX_VALUE;
            r8 = r5.length;
            r9 = 0;
            r10 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0037, code lost:
            if (r9 >= r8) goto L_0x0053;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0039, code lost:
            r13 = r5[r9].get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0041, code lost:
            if (r13 < 0) goto L_0x0048;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0043, code lost:
            r6 = java.lang.Math.min(r6, r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x004c, code lost:
            if (r13 != Long.MIN_VALUE) goto L_0x0050;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x004e, code lost:
            r10 = r10 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0050, code lost:
            r9 = r9 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0055, code lost:
            if (r0 != r10) goto L_0x006f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0057, code lost:
            r0 = r1.terminalEvent;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x005f, code lost:
            if (r1.queue.poll() != null) goto L_0x0063;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0061, code lost:
            r4 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0063, code lost:
            r4 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0068, code lost:
            if (checkTerminated(r0, r4) == false) goto L_0x006b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x006a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x006b, code lost:
            request(1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x006f, code lost:
            r10 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0070, code lost:
            r13 = (long) r10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0073, code lost:
            if (r13 >= r6) goto L_0x00ba;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0075, code lost:
            r0 = r1.terminalEvent;
            r4 = r1.queue.poll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x007d, code lost:
            if (r4 != null) goto L_0x0081;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x007f, code lost:
            r15 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0081, code lost:
            r15 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0086, code lost:
            if (checkTerminated(r0, r15) == false) goto L_0x0089;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0088, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0089, code lost:
            if (r15 == false) goto L_0x008d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x008b, code lost:
            r4 = r15;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x008d, code lost:
            r4 = rx.internal.operators.NotificationLite.getValue(r4);
            r13 = r5.length;
            r14 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0093, code lost:
            if (r14 >= r13) goto L_0x00b5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0095, code lost:
            r2 = r5[r14];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x009d, code lost:
            if (r2.get() <= 0) goto L_0x00b1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
            r2.child.onNext(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
            r2.produced(1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x00a8, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x00a9, code lost:
            r2.unsubscribe();
            rx.exceptions.Exceptions.throwOrReport(r0, (rx.Observer<?>) r2.child, r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x00b5, code lost:
            r10 = r10 + 1;
            r4 = r15;
            r2 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x00ba, code lost:
            if (r10 <= 0) goto L_0x00bf;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x00bc, code lost:
            request(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x00c1, code lost:
            if (r6 == 0) goto L_0x00c6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x00c3, code lost:
            if (r4 != false) goto L_0x00c6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x00c6, code lost:
            monitor-enter(r18);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x00c9, code lost:
            if (r1.missed != false) goto L_0x00d2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x00cb, code lost:
            r1.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
            monitor-exit(r18);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:0x00ce, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x00cf, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x00d0, code lost:
            r2 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
            r1.missed = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x00d4, code lost:
            monitor-exit(r18);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x00d5, code lost:
            r2 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x00d8, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:0x00d9, code lost:
            r2 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:?, code lost:
            monitor-exit(r18);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:85:?, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:0x00dc, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:87:0x00de, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:88:0x00e0, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:89:0x00e1, code lost:
            r2 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:90:0x00e2, code lost:
            if (r2 == false) goto L_0x00e4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:0x00e4, code lost:
            monitor-enter(r18);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:93:?, code lost:
            r1.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:99:0x00ec, code lost:
            throw r0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void dispatch() {
            /*
                r18 = this;
                r1 = r18
                monitor-enter(r18)
                boolean r0 = r1.emitting     // Catch:{ all -> 0x00ed }
                r2 = 1
                if (r0 == 0) goto L_0x000c
                r1.missed = r2     // Catch:{ all -> 0x00ed }
                monitor-exit(r18)     // Catch:{ all -> 0x00ed }
                return
            L_0x000c:
                r1.emitting = r2     // Catch:{ all -> 0x00ed }
                r3 = 0
                r1.missed = r3     // Catch:{ all -> 0x00ed }
                monitor-exit(r18)     // Catch:{ all -> 0x00ed }
            L_0x0012:
                java.lang.Object r0 = r1.terminalEvent     // Catch:{ all -> 0x00e0 }
                java.util.Queue<java.lang.Object> r4 = r1.queue     // Catch:{ all -> 0x00e0 }
                boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x00e0 }
                boolean r0 = r1.checkTerminated(r0, r4)     // Catch:{ all -> 0x00e0 }
                if (r0 == 0) goto L_0x0021
                return
            L_0x0021:
                if (r4 != 0) goto L_0x00c6
                java.util.concurrent.atomic.AtomicReference<rx.internal.operators.OperatorPublish$InnerProducer[]> r0 = r1.producers     // Catch:{ all -> 0x00e0 }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x00e0 }
                r5 = r0
                rx.internal.operators.OperatorPublish$InnerProducer[] r5 = (rx.internal.operators.OperatorPublish.InnerProducer[]) r5     // Catch:{ all -> 0x00e0 }
                int r0 = r5.length     // Catch:{ all -> 0x00e0 }
                r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r8 = r5.length     // Catch:{ all -> 0x00e0 }
                r9 = r3
                r10 = r9
            L_0x0035:
                r11 = 0
                if (r9 >= r8) goto L_0x0053
                r13 = r5[r9]     // Catch:{ all -> 0x00e0 }
                long r13 = r13.get()     // Catch:{ all -> 0x00e0 }
                int r11 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
                if (r11 < 0) goto L_0x0048
                long r6 = java.lang.Math.min(r6, r13)     // Catch:{ all -> 0x00e0 }
                goto L_0x0050
            L_0x0048:
                r11 = -9223372036854775808
                int r11 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
                if (r11 != 0) goto L_0x0050
                int r10 = r10 + 1
            L_0x0050:
                int r9 = r9 + 1
                goto L_0x0035
            L_0x0053:
                r8 = 1
                if (r0 != r10) goto L_0x006f
                java.lang.Object r0 = r1.terminalEvent     // Catch:{ all -> 0x00e0 }
                java.util.Queue<java.lang.Object> r4 = r1.queue     // Catch:{ all -> 0x00e0 }
                java.lang.Object r4 = r4.poll()     // Catch:{ all -> 0x00e0 }
                if (r4 != 0) goto L_0x0063
                r4 = r2
                goto L_0x0064
            L_0x0063:
                r4 = r3
            L_0x0064:
                boolean r0 = r1.checkTerminated(r0, r4)     // Catch:{ all -> 0x00e0 }
                if (r0 == 0) goto L_0x006b
                return
            L_0x006b:
                r1.request(r8)     // Catch:{ all -> 0x00e0 }
                goto L_0x0012
            L_0x006f:
                r10 = r3
            L_0x0070:
                long r13 = (long) r10     // Catch:{ all -> 0x00e0 }
                int r0 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
                if (r0 >= 0) goto L_0x00ba
                java.lang.Object r0 = r1.terminalEvent     // Catch:{ all -> 0x00e0 }
                java.util.Queue<java.lang.Object> r4 = r1.queue     // Catch:{ all -> 0x00e0 }
                java.lang.Object r4 = r4.poll()     // Catch:{ all -> 0x00e0 }
                if (r4 != 0) goto L_0x0081
                r15 = r2
                goto L_0x0082
            L_0x0081:
                r15 = r3
            L_0x0082:
                boolean r0 = r1.checkTerminated(r0, r15)     // Catch:{ all -> 0x00e0 }
                if (r0 == 0) goto L_0x0089
                return
            L_0x0089:
                if (r15 == 0) goto L_0x008d
                r4 = r15
                goto L_0x00ba
            L_0x008d:
                java.lang.Object r4 = rx.internal.operators.NotificationLite.getValue(r4)     // Catch:{ all -> 0x00e0 }
                int r13 = r5.length     // Catch:{ all -> 0x00e0 }
                r14 = r3
            L_0x0093:
                if (r14 >= r13) goto L_0x00b5
                r2 = r5[r14]     // Catch:{ all -> 0x00e0 }
                long r16 = r2.get()     // Catch:{ all -> 0x00e0 }
                int r0 = (r16 > r11 ? 1 : (r16 == r11 ? 0 : -1))
                if (r0 <= 0) goto L_0x00b1
                rx.Subscriber<? super T> r0 = r2.child     // Catch:{ all -> 0x00a8 }
                r0.onNext(r4)     // Catch:{ all -> 0x00a8 }
                r2.produced(r8)     // Catch:{ all -> 0x00e0 }
                goto L_0x00b1
            L_0x00a8:
                r0 = move-exception
                r2.unsubscribe()     // Catch:{ all -> 0x00e0 }
                rx.Subscriber<? super T> r2 = r2.child     // Catch:{ all -> 0x00e0 }
                rx.exceptions.Exceptions.throwOrReport((java.lang.Throwable) r0, (rx.Observer<?>) r2, (java.lang.Object) r4)     // Catch:{ all -> 0x00e0 }
            L_0x00b1:
                int r14 = r14 + 1
                r2 = 1
                goto L_0x0093
            L_0x00b5:
                int r10 = r10 + 1
                r4 = r15
                r2 = 1
                goto L_0x0070
            L_0x00ba:
                if (r10 <= 0) goto L_0x00bf
                r1.request(r13)     // Catch:{ all -> 0x00e0 }
            L_0x00bf:
                int r0 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
                if (r0 == 0) goto L_0x00c6
                if (r4 != 0) goto L_0x00c6
                goto L_0x00d5
            L_0x00c6:
                monitor-enter(r18)     // Catch:{ all -> 0x00e0 }
                boolean r0 = r1.missed     // Catch:{ all -> 0x00d8 }
                if (r0 != 0) goto L_0x00d2
                r1.emitting = r3     // Catch:{ all -> 0x00d8 }
                monitor-exit(r18)     // Catch:{ all -> 0x00cf }
                return
            L_0x00cf:
                r0 = move-exception
                r2 = 1
                goto L_0x00da
            L_0x00d2:
                r1.missed = r3     // Catch:{ all -> 0x00d8 }
                monitor-exit(r18)     // Catch:{ all -> 0x00d8 }
            L_0x00d5:
                r2 = 1
                goto L_0x0012
            L_0x00d8:
                r0 = move-exception
                r2 = r3
            L_0x00da:
                monitor-exit(r18)     // Catch:{ all -> 0x00de }
                throw r0     // Catch:{ all -> 0x00dc }
            L_0x00dc:
                r0 = move-exception
                goto L_0x00e2
            L_0x00de:
                r0 = move-exception
                goto L_0x00da
            L_0x00e0:
                r0 = move-exception
                r2 = r3
            L_0x00e2:
                if (r2 != 0) goto L_0x00ec
                monitor-enter(r18)
                r1.emitting = r3     // Catch:{ all -> 0x00e9 }
                monitor-exit(r18)     // Catch:{ all -> 0x00e9 }
                goto L_0x00ec
            L_0x00e9:
                r0 = move-exception
                monitor-exit(r18)     // Catch:{ all -> 0x00e9 }
                throw r0
            L_0x00ec:
                throw r0
            L_0x00ed:
                r0 = move-exception
                monitor-exit(r18)     // Catch:{ all -> 0x00ed }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorPublish.PublishSubscriber.dispatch():void");
        }
    }

    static final class InnerProducer<T> extends AtomicLong implements Producer, Subscription {
        static final long NOT_REQUESTED = -4611686018427387904L;
        static final long UNSUBSCRIBED = Long.MIN_VALUE;
        private static final long serialVersionUID = -4453897557930727610L;
        final Subscriber<? super T> child;
        final PublishSubscriber<T> parent;

        public InnerProducer(PublishSubscriber<T> publishSubscriber, Subscriber<? super T> subscriber) {
            this.parent = publishSubscriber;
            this.child = subscriber;
            lazySet(NOT_REQUESTED);
        }

        public void request(long j) {
            long j2;
            long j3;
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i >= 0) {
                do {
                    j2 = get();
                    if (j2 != Long.MIN_VALUE) {
                        if (j2 >= 0 && i == 0) {
                            return;
                        }
                        if (j2 == NOT_REQUESTED) {
                            j3 = j;
                        } else {
                            j3 = j2 + j;
                            if (j3 < 0) {
                                j3 = LongCompanionObject.MAX_VALUE;
                            }
                        }
                    } else {
                        return;
                    }
                } while (!compareAndSet(j2, j3));
                this.parent.dispatch();
            }
        }

        public long produced(long j) {
            long j2;
            long j3;
            if (j > 0) {
                do {
                    j2 = get();
                    if (j2 == NOT_REQUESTED) {
                        throw new IllegalStateException("Produced without request");
                    } else if (j2 == Long.MIN_VALUE) {
                        return Long.MIN_VALUE;
                    } else {
                        j3 = j2 - j;
                        if (j3 < 0) {
                            throw new IllegalStateException("More produced (" + j + ") than requested (" + j2 + ")");
                        }
                    }
                } while (!compareAndSet(j2, j3));
                return j3;
            }
            throw new IllegalArgumentException("Cant produce zero or less");
        }

        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        public void unsubscribe() {
            if (get() != Long.MIN_VALUE && getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
                this.parent.dispatch();
            }
        }
    }
}
