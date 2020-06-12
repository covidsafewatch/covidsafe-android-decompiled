package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.CompositeException;
import rx.functions.Action0;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.atomic.SpscLinkedArrayQueue;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.SerialSubscription;
import rx.subscriptions.Subscriptions;

public final class OperatorSwitch<T> implements Observable.Operator<T, Observable<? extends T>> {
    final boolean delayError;

    static final class Holder {
        static final OperatorSwitch<Object> INSTANCE = new OperatorSwitch<>(false);

        Holder() {
        }
    }

    static final class HolderDelayError {
        static final OperatorSwitch<Object> INSTANCE = new OperatorSwitch<>(true);

        HolderDelayError() {
        }
    }

    public static <T> OperatorSwitch<T> instance(boolean z) {
        if (z) {
            return HolderDelayError.INSTANCE;
        }
        return Holder.INSTANCE;
    }

    OperatorSwitch(boolean z) {
        this.delayError = z;
    }

    public Subscriber<? super Observable<? extends T>> call(Subscriber<? super T> subscriber) {
        SwitchSubscriber switchSubscriber = new SwitchSubscriber(subscriber, this.delayError);
        subscriber.add(switchSubscriber);
        switchSubscriber.init();
        return switchSubscriber;
    }

    static final class SwitchSubscriber<T> extends Subscriber<Observable<? extends T>> {
        static final Throwable TERMINAL_ERROR = new Throwable("Terminal error");
        final Subscriber<? super T> child;
        final boolean delayError;
        boolean emitting;
        Throwable error;
        final AtomicLong index;
        boolean innerActive;
        volatile boolean mainDone;
        boolean missed;
        Producer producer;
        final SpscLinkedArrayQueue<Object> queue;
        long requested;
        final SerialSubscription serial = new SerialSubscription();

        SwitchSubscriber(Subscriber<? super T> subscriber, boolean z) {
            this.child = subscriber;
            this.delayError = z;
            this.index = new AtomicLong();
            this.queue = new SpscLinkedArrayQueue<>(RxRingBuffer.SIZE);
        }

        /* access modifiers changed from: package-private */
        public void init() {
            this.child.add(this.serial);
            this.child.add(Subscriptions.create(new Action0() {
                public void call() {
                    SwitchSubscriber.this.clearProducer();
                }
            }));
            this.child.setProducer(new Producer() {
                public void request(long j) {
                    int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                    if (i > 0) {
                        SwitchSubscriber.this.childRequested(j);
                    } else if (i < 0) {
                        throw new IllegalArgumentException("n >= 0 expected but it was " + j);
                    }
                }
            });
        }

        /* access modifiers changed from: package-private */
        public void clearProducer() {
            synchronized (this) {
                this.producer = null;
            }
        }

        public void onNext(Observable<? extends T> observable) {
            InnerSubscriber innerSubscriber;
            long incrementAndGet = this.index.incrementAndGet();
            Subscription subscription = this.serial.get();
            if (subscription != null) {
                subscription.unsubscribe();
            }
            synchronized (this) {
                innerSubscriber = new InnerSubscriber(incrementAndGet, this);
                this.innerActive = true;
                this.producer = null;
            }
            this.serial.set(innerSubscriber);
            observable.unsafeSubscribe(innerSubscriber);
        }

        public void onError(Throwable th) {
            boolean updateError;
            synchronized (this) {
                updateError = updateError(th);
            }
            if (updateError) {
                this.mainDone = true;
                drain();
                return;
            }
            pluginError(th);
        }

        /* access modifiers changed from: package-private */
        public boolean updateError(Throwable th) {
            Throwable th2 = this.error;
            if (th2 == TERMINAL_ERROR) {
                return false;
            }
            if (th2 == null) {
                this.error = th;
            } else if (th2 instanceof CompositeException) {
                ArrayList arrayList = new ArrayList(((CompositeException) th2).getExceptions());
                arrayList.add(th);
                this.error = new CompositeException((Collection<? extends Throwable>) arrayList);
            } else {
                this.error = new CompositeException(th2, th);
            }
            return true;
        }

        public void onCompleted() {
            this.mainDone = true;
            drain();
        }

        /* access modifiers changed from: package-private */
        public void emit(T t, InnerSubscriber<T> innerSubscriber) {
            synchronized (this) {
                if (this.index.get() == innerSubscriber.id) {
                    this.queue.offer(innerSubscriber, NotificationLite.next(t));
                    drain();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void error(Throwable th, long j) {
            boolean z;
            synchronized (this) {
                if (this.index.get() == j) {
                    z = updateError(th);
                    this.innerActive = false;
                    this.producer = null;
                } else {
                    z = true;
                }
            }
            if (z) {
                drain();
            } else {
                pluginError(th);
            }
        }

        /* access modifiers changed from: package-private */
        public void complete(long j) {
            synchronized (this) {
                if (this.index.get() == j) {
                    this.innerActive = false;
                    this.producer = null;
                    drain();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void pluginError(Throwable th) {
            RxJavaHooks.onError(th);
        }

        /* access modifiers changed from: package-private */
        public void innerProducer(Producer producer2, long j) {
            synchronized (this) {
                if (this.index.get() == j) {
                    long j2 = this.requested;
                    this.producer = producer2;
                    producer2.request(j2);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void childRequested(long j) {
            Producer producer2;
            synchronized (this) {
                producer2 = this.producer;
                this.requested = BackpressureUtils.addCap(this.requested, j);
            }
            if (producer2 != null) {
                producer2.request(j);
            }
            drain();
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0023, code lost:
            r9 = r8.queue;
            r10 = r8.index;
            r11 = r8.child;
            r12 = r1;
            r14 = r3;
            r15 = r8.mainDone;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002e, code lost:
            r16 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0032, code lost:
            r18 = (r16 > r12 ? 1 : (r16 == r12 ? 0 : -1));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0034, code lost:
            if (r18 == 0) goto L_0x0076;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x003a, code lost:
            if (r11.isUnsubscribed() == false) goto L_0x003d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x003c, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x003d, code lost:
            r19 = r9.isEmpty();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x004e, code lost:
            if (checkTerminated(r15, r0, r14, r9, r11, r19) == false) goto L_0x0051;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0050, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0051, code lost:
            if (r19 == false) goto L_0x0054;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0054, code lost:
            r2 = rx.internal.operators.NotificationLite.getValue(r9.poll());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x006c, code lost:
            if (r10.get() != rx.internal.operators.OperatorSwitch.InnerSubscriber.access$000((rx.internal.operators.OperatorSwitch.InnerSubscriber) r9.poll())) goto L_0x0032;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x006e, code lost:
            r11.onNext(r2);
            r16 = r16 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0076, code lost:
            if (r18 != 0) goto L_0x0092;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x007c, code lost:
            if (r11.isUnsubscribed() == false) goto L_0x007f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x007e, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x008f, code lost:
            if (checkTerminated(r8.mainDone, r0, r14, r9, r11, r9.isEmpty()) == false) goto L_0x0092;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0091, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0092, code lost:
            monitor-enter(r20);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
            r0 = r8.requested;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x009c, code lost:
            if (r0 == kotlin.jvm.internal.LongCompanionObject.MAX_VALUE) goto L_0x00a2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x009e, code lost:
            r0 = r0 - r16;
            r8.requested = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a2, code lost:
            r12 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a6, code lost:
            if (r8.missed != false) goto L_0x00ac;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a8, code lost:
            r8.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x00aa, code lost:
            monitor-exit(r20);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ab, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ac, code lost:
            r8.missed = false;
            r15 = r8.mainDone;
            r0 = r8.innerActive;
            r14 = r8.error;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x00b4, code lost:
            if (r14 == null) goto L_0x00c2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x00b8, code lost:
            if (r14 == TERMINAL_ERROR) goto L_0x00c2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x00bc, code lost:
            if (r8.delayError != false) goto L_0x00c2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x00be, code lost:
            r8.error = TERMINAL_ERROR;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x00c2, code lost:
            monitor-exit(r20);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void drain() {
            /*
                r20 = this;
                r8 = r20
                monitor-enter(r20)
                boolean r0 = r8.emitting     // Catch:{ all -> 0x00c8 }
                r1 = 1
                if (r0 == 0) goto L_0x000c
                r8.missed = r1     // Catch:{ all -> 0x00c8 }
                monitor-exit(r20)     // Catch:{ all -> 0x00c8 }
                return
            L_0x000c:
                r8.emitting = r1     // Catch:{ all -> 0x00c8 }
                boolean r0 = r8.innerActive     // Catch:{ all -> 0x00c8 }
                long r1 = r8.requested     // Catch:{ all -> 0x00c8 }
                java.lang.Throwable r3 = r8.error     // Catch:{ all -> 0x00c8 }
                if (r3 == 0) goto L_0x0022
                java.lang.Throwable r4 = TERMINAL_ERROR     // Catch:{ all -> 0x00c8 }
                if (r3 == r4) goto L_0x0022
                boolean r4 = r8.delayError     // Catch:{ all -> 0x00c8 }
                if (r4 != 0) goto L_0x0022
                java.lang.Throwable r4 = TERMINAL_ERROR     // Catch:{ all -> 0x00c8 }
                r8.error = r4     // Catch:{ all -> 0x00c8 }
            L_0x0022:
                monitor-exit(r20)     // Catch:{ all -> 0x00c8 }
                rx.internal.util.atomic.SpscLinkedArrayQueue<java.lang.Object> r9 = r8.queue
                java.util.concurrent.atomic.AtomicLong r10 = r8.index
                rx.Subscriber<? super T> r11 = r8.child
                boolean r4 = r8.mainDone
                r12 = r1
                r14 = r3
                r15 = r4
            L_0x002e:
                r1 = 0
                r16 = r1
            L_0x0032:
                int r18 = (r16 > r12 ? 1 : (r16 == r12 ? 0 : -1))
                if (r18 == 0) goto L_0x0076
                boolean r1 = r11.isUnsubscribed()
                if (r1 == 0) goto L_0x003d
                return
            L_0x003d:
                boolean r19 = r9.isEmpty()
                r1 = r20
                r2 = r15
                r3 = r0
                r4 = r14
                r5 = r9
                r6 = r11
                r7 = r19
                boolean r1 = r1.checkTerminated(r2, r3, r4, r5, r6, r7)
                if (r1 == 0) goto L_0x0051
                return
            L_0x0051:
                if (r19 == 0) goto L_0x0054
                goto L_0x0076
            L_0x0054:
                java.lang.Object r1 = r9.poll()
                rx.internal.operators.OperatorSwitch$InnerSubscriber r1 = (rx.internal.operators.OperatorSwitch.InnerSubscriber) r1
                java.lang.Object r2 = r9.poll()
                java.lang.Object r2 = rx.internal.operators.NotificationLite.getValue(r2)
                long r3 = r10.get()
                long r5 = r1.id
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 != 0) goto L_0x0032
                r11.onNext(r2)
                r1 = 1
                long r16 = r16 + r1
                goto L_0x0032
            L_0x0076:
                if (r18 != 0) goto L_0x0092
                boolean r1 = r11.isUnsubscribed()
                if (r1 == 0) goto L_0x007f
                return
            L_0x007f:
                boolean r2 = r8.mainDone
                boolean r7 = r9.isEmpty()
                r1 = r20
                r3 = r0
                r4 = r14
                r5 = r9
                r6 = r11
                boolean r0 = r1.checkTerminated(r2, r3, r4, r5, r6, r7)
                if (r0 == 0) goto L_0x0092
                return
            L_0x0092:
                monitor-enter(r20)
                long r0 = r8.requested     // Catch:{ all -> 0x00c5 }
                r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 == 0) goto L_0x00a2
                long r0 = r0 - r16
                r8.requested = r0     // Catch:{ all -> 0x00c5 }
            L_0x00a2:
                r12 = r0
                boolean r0 = r8.missed     // Catch:{ all -> 0x00c5 }
                r1 = 0
                if (r0 != 0) goto L_0x00ac
                r8.emitting = r1     // Catch:{ all -> 0x00c5 }
                monitor-exit(r20)     // Catch:{ all -> 0x00c5 }
                return
            L_0x00ac:
                r8.missed = r1     // Catch:{ all -> 0x00c5 }
                boolean r15 = r8.mainDone     // Catch:{ all -> 0x00c5 }
                boolean r0 = r8.innerActive     // Catch:{ all -> 0x00c5 }
                java.lang.Throwable r14 = r8.error     // Catch:{ all -> 0x00c5 }
                if (r14 == 0) goto L_0x00c2
                java.lang.Throwable r1 = TERMINAL_ERROR     // Catch:{ all -> 0x00c5 }
                if (r14 == r1) goto L_0x00c2
                boolean r1 = r8.delayError     // Catch:{ all -> 0x00c5 }
                if (r1 != 0) goto L_0x00c2
                java.lang.Throwable r1 = TERMINAL_ERROR     // Catch:{ all -> 0x00c5 }
                r8.error = r1     // Catch:{ all -> 0x00c5 }
            L_0x00c2:
                monitor-exit(r20)     // Catch:{ all -> 0x00c5 }
                goto L_0x002e
            L_0x00c5:
                r0 = move-exception
                monitor-exit(r20)     // Catch:{ all -> 0x00c5 }
                throw r0
            L_0x00c8:
                r0 = move-exception
                monitor-exit(r20)     // Catch:{ all -> 0x00c8 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorSwitch.SwitchSubscriber.drain():void");
        }

        /* access modifiers changed from: protected */
        public boolean checkTerminated(boolean z, boolean z2, Throwable th, SpscLinkedArrayQueue<Object> spscLinkedArrayQueue, Subscriber<? super T> subscriber, boolean z3) {
            if (this.delayError) {
                if (!z || z2 || !z3) {
                    return false;
                }
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onCompleted();
                }
                return true;
            } else if (th != null) {
                spscLinkedArrayQueue.clear();
                subscriber.onError(th);
                return true;
            } else if (!z || z2 || !z3) {
                return false;
            } else {
                subscriber.onCompleted();
                return true;
            }
        }
    }

    static final class InnerSubscriber<T> extends Subscriber<T> {
        /* access modifiers changed from: private */
        public final long id;
        private final SwitchSubscriber<T> parent;

        InnerSubscriber(long j, SwitchSubscriber<T> switchSubscriber) {
            this.id = j;
            this.parent = switchSubscriber;
        }

        public void setProducer(Producer producer) {
            this.parent.innerProducer(producer, this.id);
        }

        public void onNext(T t) {
            this.parent.emit(t, this);
        }

        public void onError(Throwable th) {
            this.parent.error(th, this.id);
        }

        public void onCompleted() {
            this.parent.complete(this.id);
        }
    }
}
