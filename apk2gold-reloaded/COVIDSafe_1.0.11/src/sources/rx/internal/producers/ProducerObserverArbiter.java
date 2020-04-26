package rx.internal.producers;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.internal.operators.BackpressureUtils;

public final class ProducerObserverArbiter<T> implements Producer, Observer<T> {
    static final Producer NULL_PRODUCER = new Producer() {
        public void request(long j) {
        }
    };
    final Subscriber<? super T> child;
    Producer currentProducer;
    boolean emitting;
    volatile boolean hasError;
    Producer missedProducer;
    long missedRequested;
    Object missedTerminal;
    List<T> queue;
    long requested;

    public ProducerObserverArbiter(Subscriber<? super T> subscriber) {
        this.child = subscriber;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r4.child.onNext(r5);
        r0 = r4.requested;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
        if (r0 == kotlin.jvm.internal.LongCompanionObject.MAX_VALUE) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002a, code lost:
        r4.requested = r0 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        emitLoop();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0032, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0033, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0034, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r4.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0039, code lost:
        throw r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onNext(T r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.emitting     // Catch:{ all -> 0x003d }
            if (r0 == 0) goto L_0x0016
            java.util.List<T> r0 = r4.queue     // Catch:{ all -> 0x003d }
            if (r0 != 0) goto L_0x0011
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x003d }
            r1 = 4
            r0.<init>(r1)     // Catch:{ all -> 0x003d }
            r4.queue = r0     // Catch:{ all -> 0x003d }
        L_0x0011:
            r0.add(r5)     // Catch:{ all -> 0x003d }
            monitor-exit(r4)     // Catch:{ all -> 0x003d }
            return
        L_0x0016:
            r0 = 1
            r4.emitting = r0     // Catch:{ all -> 0x003d }
            monitor-exit(r4)     // Catch:{ all -> 0x003d }
            rx.Subscriber<? super T> r0 = r4.child     // Catch:{ all -> 0x0033 }
            r0.onNext(r5)     // Catch:{ all -> 0x0033 }
            long r0 = r4.requested     // Catch:{ all -> 0x0033 }
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x002f
            r2 = 1
            long r0 = r0 - r2
            r4.requested = r0     // Catch:{ all -> 0x0033 }
        L_0x002f:
            r4.emitLoop()     // Catch:{ all -> 0x0033 }
            return
        L_0x0033:
            r5 = move-exception
            monitor-enter(r4)
            r0 = 0
            r4.emitting = r0     // Catch:{ all -> 0x003a }
            monitor-exit(r4)     // Catch:{ all -> 0x003a }
            throw r5
        L_0x003a:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x003a }
            throw r5
        L_0x003d:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x003d }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.producers.ProducerObserverArbiter.onNext(java.lang.Object):void");
    }

    public void onError(Throwable th) {
        boolean z;
        synchronized (this) {
            if (this.emitting) {
                this.missedTerminal = th;
                z = false;
            } else {
                this.emitting = true;
                z = true;
            }
        }
        if (z) {
            this.child.onError(th);
        } else {
            this.hasError = true;
        }
    }

    public void onCompleted() {
        synchronized (this) {
            if (this.emitting) {
                this.missedTerminal = Boolean.valueOf(true);
                return;
            }
            this.emitting = true;
            this.child.onCompleted();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0019, code lost:
        r2 = r5.currentProducer;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r3 = r5.requested + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0020, code lost:
        if (r3 >= 0) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0022, code lost:
        r3 = kotlin.jvm.internal.LongCompanionObject.MAX_VALUE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0027, code lost:
        r5.requested = r3;
        emitLoop();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002c, code lost:
        if (r2 == null) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002e, code lost:
        r2.request(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0031, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0032, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0033, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r5.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0038, code lost:
        throw r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void request(long r6) {
        /*
            r5 = this;
            r0 = 0
            int r2 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r2 < 0) goto L_0x003f
            if (r2 != 0) goto L_0x0009
            return
        L_0x0009:
            monitor-enter(r5)
            boolean r2 = r5.emitting     // Catch:{ all -> 0x003c }
            if (r2 == 0) goto L_0x0015
            long r0 = r5.missedRequested     // Catch:{ all -> 0x003c }
            long r0 = r0 + r6
            r5.missedRequested = r0     // Catch:{ all -> 0x003c }
            monitor-exit(r5)     // Catch:{ all -> 0x003c }
            return
        L_0x0015:
            r2 = 1
            r5.emitting = r2     // Catch:{ all -> 0x003c }
            monitor-exit(r5)     // Catch:{ all -> 0x003c }
            rx.Producer r2 = r5.currentProducer
            long r3 = r5.requested     // Catch:{ all -> 0x0032 }
            long r3 = r3 + r6
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x0027
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x0027:
            r5.requested = r3     // Catch:{ all -> 0x0032 }
            r5.emitLoop()     // Catch:{ all -> 0x0032 }
            if (r2 == 0) goto L_0x0031
            r2.request(r6)
        L_0x0031:
            return
        L_0x0032:
            r6 = move-exception
            monitor-enter(r5)
            r7 = 0
            r5.emitting = r7     // Catch:{ all -> 0x0039 }
            monitor-exit(r5)     // Catch:{ all -> 0x0039 }
            throw r6
        L_0x0039:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0039 }
            throw r6
        L_0x003c:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x003c }
            throw r6
        L_0x003f:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r7 = "n >= 0 required"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.producers.ProducerObserverArbiter.request(long):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0012, code lost:
        r4.currentProducer = r5;
        r0 = r4.requested;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        emitLoop();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0019, code lost:
        if (r5 == null) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001f, code lost:
        if (r0 == 0) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0021, code lost:
        r5.request(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0024, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0025, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0026, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r4.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x002b, code lost:
        throw r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProducer(rx.Producer r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.emitting     // Catch:{ all -> 0x002f }
            if (r0 == 0) goto L_0x000e
            if (r5 == 0) goto L_0x0008
            goto L_0x000a
        L_0x0008:
            rx.Producer r5 = NULL_PRODUCER     // Catch:{ all -> 0x002f }
        L_0x000a:
            r4.missedProducer = r5     // Catch:{ all -> 0x002f }
            monitor-exit(r4)     // Catch:{ all -> 0x002f }
            return
        L_0x000e:
            r0 = 1
            r4.emitting = r0     // Catch:{ all -> 0x002f }
            monitor-exit(r4)     // Catch:{ all -> 0x002f }
            r4.currentProducer = r5
            long r0 = r4.requested
            r4.emitLoop()     // Catch:{ all -> 0x0025 }
            if (r5 == 0) goto L_0x0024
            r2 = 0
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0024
            r5.request(r0)
        L_0x0024:
            return
        L_0x0025:
            r5 = move-exception
            monitor-enter(r4)
            r0 = 0
            r4.emitting = r0     // Catch:{ all -> 0x002c }
            monitor-exit(r4)     // Catch:{ all -> 0x002c }
            throw r5
        L_0x002c:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x002c }
            throw r5
        L_0x002f:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x002f }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.producers.ProducerObserverArbiter.setProducer(rx.Producer):void");
    }

    /* access modifiers changed from: 0000 */
    public void emitLoop() {
        long j;
        Producer producer;
        Object obj;
        List<T> list;
        int i;
        boolean z;
        boolean z2;
        long j2;
        Subscriber<? super T> subscriber = this.child;
        Producer producer2 = null;
        long j3 = 0;
        while (true) {
            synchronized (this) {
                j = this.missedRequested;
                producer = this.missedProducer;
                obj = this.missedTerminal;
                list = this.queue;
                i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                z = true;
                if (i == 0 && producer == null && list == null && obj == null) {
                    this.emitting = false;
                    z2 = true;
                } else {
                    this.missedRequested = 0;
                    this.missedProducer = null;
                    this.queue = null;
                    this.missedTerminal = null;
                    z2 = false;
                }
            }
            if (z2) {
                if (!(j3 == 0 || producer2 == null)) {
                    producer2.request(j3);
                }
                return;
            }
            if (list != null && !list.isEmpty()) {
                z = false;
            }
            if (obj != null) {
                if (obj != Boolean.TRUE) {
                    subscriber.onError((Throwable) obj);
                    return;
                } else if (z) {
                    subscriber.onCompleted();
                    return;
                }
            }
            if (list != null) {
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        j2 = ((long) list.size()) + 0;
                        break;
                    }
                    Object next = it.next();
                    if (!subscriber.isUnsubscribed()) {
                        if (this.hasError) {
                            break;
                        }
                        try {
                            subscriber.onNext(next);
                        } catch (Throwable th) {
                            Exceptions.throwOrReport(th, (Observer<?>) subscriber, next);
                            return;
                        }
                    } else {
                        return;
                    }
                }
            } else {
                j2 = 0;
            }
            long j4 = this.requested;
            if (j4 != LongCompanionObject.MAX_VALUE) {
                if (i != 0) {
                    j4 += j;
                    if (j4 < 0) {
                        j4 = Long.MAX_VALUE;
                    }
                }
                if (!(j2 == 0 || j4 == LongCompanionObject.MAX_VALUE)) {
                    j4 -= j2;
                    if (j4 < 0) {
                        throw new IllegalStateException("More produced than requested");
                    }
                }
                this.requested = j4;
            }
            if (producer == null) {
                producer = this.currentProducer;
                if (producer != null && i != 0) {
                    j3 = BackpressureUtils.addCap(j3, j);
                }
            } else if (producer == NULL_PRODUCER) {
                this.currentProducer = null;
            } else {
                this.currentProducer = producer;
                if (j4 != 0) {
                    j3 = BackpressureUtils.addCap(j3, j4);
                }
            }
            producer2 = producer;
        }
        while (true) {
        }
    }
}
