package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;

public final class OperatorOnBackpressureLatest<T> implements Observable.Operator<T, T> {

    static final class Holder {
        static final OperatorOnBackpressureLatest<Object> INSTANCE = new OperatorOnBackpressureLatest<>();

        Holder() {
        }
    }

    public static <T> OperatorOnBackpressureLatest<T> instance() {
        return Holder.INSTANCE;
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        LatestEmitter latestEmitter = new LatestEmitter(subscriber);
        LatestSubscriber<? super T> latestSubscriber = new LatestSubscriber<>(latestEmitter);
        latestEmitter.parent = latestSubscriber;
        subscriber.add(latestSubscriber);
        subscriber.add(latestEmitter);
        subscriber.setProducer(latestEmitter);
        return latestSubscriber;
    }

    static final class LatestEmitter<T> extends AtomicLong implements Producer, Subscription, Observer<T> {
        static final Object EMPTY = new Object();
        static final long NOT_REQUESTED = -4611686018427387904L;
        private static final long serialVersionUID = -1364393685005146274L;
        final Subscriber<? super T> child;
        volatile boolean done;
        boolean emitting;
        boolean missed;
        LatestSubscriber<? super T> parent;
        Throwable terminal;
        final AtomicReference<Object> value = new AtomicReference<>(EMPTY);

        public LatestEmitter(Subscriber<? super T> subscriber) {
            this.child = subscriber;
            lazySet(NOT_REQUESTED);
        }

        public void request(long j) {
            long j2;
            int i;
            long j3;
            if (j >= 0) {
                do {
                    j2 = get();
                    if (j2 != Long.MIN_VALUE) {
                        i = (j2 > NOT_REQUESTED ? 1 : (j2 == NOT_REQUESTED ? 0 : -1));
                        if (i == 0) {
                            j3 = j;
                        } else {
                            j3 = j2 + j;
                            if (j3 < 0) {
                                j3 = Long.MAX_VALUE;
                            }
                        }
                    } else {
                        return;
                    }
                } while (!compareAndSet(j2, j3));
                if (i == 0) {
                    this.parent.requestMore(LongCompanionObject.MAX_VALUE);
                }
                emit();
            }
        }

        /* access modifiers changed from: package-private */
        public long produced(long j) {
            long j2;
            long j3;
            do {
                j2 = get();
                if (j2 < 0) {
                    return j2;
                }
                j3 = j2 - j;
            } while (!compareAndSet(j2, j3));
            return j3;
        }

        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        public void unsubscribe() {
            if (get() >= 0) {
                getAndSet(Long.MIN_VALUE);
            }
        }

        public void onNext(T t) {
            this.value.lazySet(t);
            emit();
        }

        public void onError(Throwable th) {
            this.terminal = th;
            this.done = true;
            emit();
        }

        public void onCompleted() {
            this.done = true;
            emit();
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
            r2 = get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
            if (r2 != Long.MIN_VALUE) goto L_0x001b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
            r4 = r8.value.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
            if (r2 <= 0) goto L_0x003e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0029, code lost:
            if (r4 == EMPTY) goto L_0x003e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002b, code lost:
            r8.child.onNext(r4);
            r8.value.compareAndSet(r4, EMPTY);
            produced(1);
            r4 = EMPTY;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0040, code lost:
            if (r4 != EMPTY) goto L_0x0055;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0044, code lost:
            if (r8.done == false) goto L_0x0055;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0046, code lost:
            r2 = r8.terminal;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0048, code lost:
            if (r2 == null) goto L_0x0050;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x004a, code lost:
            r8.child.onError(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0050, code lost:
            r8.child.onCompleted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0055, code lost:
            monitor-enter(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0058, code lost:
            if (r8.missed != false) goto L_0x005e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x005a, code lost:
            r8.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
            monitor-exit(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            r8.missed = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0060, code lost:
            monitor-exit(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0062, code lost:
            r2 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0063, code lost:
            r1 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
            monitor-exit(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
            throw r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0066, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0067, code lost:
            r7 = r2;
            r2 = r1;
            r1 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x006b, code lost:
            r2 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x006d, code lost:
            r1 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x006e, code lost:
            r2 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x006f, code lost:
            if (r2 == false) goto L_0x0071;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0071, code lost:
            monitor-enter(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
            r8.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x0079, code lost:
            throw r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void emit() {
            /*
                r8 = this;
                monitor-enter(r8)
                boolean r0 = r8.emitting     // Catch:{ all -> 0x007a }
                r1 = 1
                if (r0 == 0) goto L_0x000a
                r8.missed = r1     // Catch:{ all -> 0x007a }
                monitor-exit(r8)     // Catch:{ all -> 0x007a }
                return
            L_0x000a:
                r8.emitting = r1     // Catch:{ all -> 0x007a }
                r0 = 0
                r8.missed = r0     // Catch:{ all -> 0x007a }
                monitor-exit(r8)     // Catch:{ all -> 0x007a }
            L_0x0010:
                long r2 = r8.get()     // Catch:{ all -> 0x006d }
                r4 = -9223372036854775808
                int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r4 != 0) goto L_0x001b
                goto L_0x005d
            L_0x001b:
                java.util.concurrent.atomic.AtomicReference<java.lang.Object> r4 = r8.value     // Catch:{ all -> 0x006d }
                java.lang.Object r4 = r4.get()     // Catch:{ all -> 0x006d }
                r5 = 0
                int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
                if (r2 <= 0) goto L_0x003e
                java.lang.Object r2 = EMPTY     // Catch:{ all -> 0x006d }
                if (r4 == r2) goto L_0x003e
                rx.Subscriber<? super T> r2 = r8.child     // Catch:{ all -> 0x006d }
                r2.onNext(r4)     // Catch:{ all -> 0x006d }
                java.util.concurrent.atomic.AtomicReference<java.lang.Object> r2 = r8.value     // Catch:{ all -> 0x006d }
                java.lang.Object r3 = EMPTY     // Catch:{ all -> 0x006d }
                r2.compareAndSet(r4, r3)     // Catch:{ all -> 0x006d }
                r2 = 1
                r8.produced(r2)     // Catch:{ all -> 0x006d }
                java.lang.Object r4 = EMPTY     // Catch:{ all -> 0x006d }
            L_0x003e:
                java.lang.Object r2 = EMPTY     // Catch:{ all -> 0x006d }
                if (r4 != r2) goto L_0x0055
                boolean r2 = r8.done     // Catch:{ all -> 0x006d }
                if (r2 == 0) goto L_0x0055
                java.lang.Throwable r2 = r8.terminal     // Catch:{ all -> 0x006d }
                if (r2 == 0) goto L_0x0050
                rx.Subscriber<? super T> r3 = r8.child     // Catch:{ all -> 0x006d }
                r3.onError(r2)     // Catch:{ all -> 0x006d }
                goto L_0x0055
            L_0x0050:
                rx.Subscriber<? super T> r2 = r8.child     // Catch:{ all -> 0x006d }
                r2.onCompleted()     // Catch:{ all -> 0x006d }
            L_0x0055:
                monitor-enter(r8)     // Catch:{ all -> 0x006d }
                boolean r2 = r8.missed     // Catch:{ all -> 0x0062 }
                if (r2 != 0) goto L_0x005e
                r8.emitting = r0     // Catch:{ all -> 0x0062 }
                monitor-exit(r8)     // Catch:{ all -> 0x006b }
            L_0x005d:
                return
            L_0x005e:
                r8.missed = r0     // Catch:{ all -> 0x0062 }
                monitor-exit(r8)     // Catch:{ all -> 0x0062 }
                goto L_0x0010
            L_0x0062:
                r2 = move-exception
                r1 = r0
            L_0x0064:
                monitor-exit(r8)     // Catch:{ all -> 0x006b }
                throw r2     // Catch:{ all -> 0x0066 }
            L_0x0066:
                r2 = move-exception
                r7 = r2
                r2 = r1
                r1 = r7
                goto L_0x006f
            L_0x006b:
                r2 = move-exception
                goto L_0x0064
            L_0x006d:
                r1 = move-exception
                r2 = r0
            L_0x006f:
                if (r2 != 0) goto L_0x0079
                monitor-enter(r8)
                r8.emitting = r0     // Catch:{ all -> 0x0076 }
                monitor-exit(r8)     // Catch:{ all -> 0x0076 }
                goto L_0x0079
            L_0x0076:
                r0 = move-exception
                monitor-exit(r8)     // Catch:{ all -> 0x0076 }
                throw r0
            L_0x0079:
                throw r1
            L_0x007a:
                r0 = move-exception
                monitor-exit(r8)     // Catch:{ all -> 0x007a }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorOnBackpressureLatest.LatestEmitter.emit():void");
        }
    }

    static final class LatestSubscriber<T> extends Subscriber<T> {
        private final LatestEmitter<T> producer;

        LatestSubscriber(LatestEmitter<T> latestEmitter) {
            this.producer = latestEmitter;
        }

        public void onStart() {
            request(0);
        }

        public void onNext(T t) {
            this.producer.onNext(t);
        }

        public void onError(Throwable th) {
            this.producer.onError(th);
        }

        public void onCompleted() {
            this.producer.onCompleted();
        }

        /* access modifiers changed from: package-private */
        public void requestMore(long j) {
            request(j);
        }
    }
}
