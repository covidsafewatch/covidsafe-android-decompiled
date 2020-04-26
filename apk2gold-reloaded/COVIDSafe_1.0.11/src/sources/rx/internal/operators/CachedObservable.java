package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.internal.util.LinkedArrayList;
import rx.subscriptions.SerialSubscription;

public final class CachedObservable<T> extends Observable<T> {
    private final CacheState<T> state;

    static final class CacheState<T> extends LinkedArrayList implements Observer<T> {
        static final ReplayProducer<?>[] EMPTY = new ReplayProducer[0];
        final SerialSubscription connection = new SerialSubscription();
        volatile boolean isConnected;
        volatile ReplayProducer<?>[] producers = EMPTY;
        final Observable<? extends T> source;
        boolean sourceDone;

        public CacheState(Observable<? extends T> observable, int i) {
            super(i);
            this.source = observable;
        }

        public void addProducer(ReplayProducer<T> replayProducer) {
            synchronized (this.connection) {
                ReplayProducer<?>[] replayProducerArr = this.producers;
                int length = replayProducerArr.length;
                ReplayProducer<?>[] replayProducerArr2 = new ReplayProducer[(length + 1)];
                System.arraycopy(replayProducerArr, 0, replayProducerArr2, 0, length);
                replayProducerArr2[length] = replayProducer;
                this.producers = replayProducerArr2;
            }
        }

        public void removeProducer(ReplayProducer<T> replayProducer) {
            synchronized (this.connection) {
                ReplayProducer<?>[] replayProducerArr = this.producers;
                int length = replayProducerArr.length;
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (replayProducerArr[i2].equals(replayProducer)) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        this.producers = EMPTY;
                        return;
                    }
                    ReplayProducer<?>[] replayProducerArr2 = new ReplayProducer[(length - 1)];
                    System.arraycopy(replayProducerArr, 0, replayProducerArr2, 0, i);
                    System.arraycopy(replayProducerArr, i + 1, replayProducerArr2, i, (length - i) - 1);
                    this.producers = replayProducerArr2;
                }
            }
        }

        public void connect() {
            AnonymousClass1 r0 = new Subscriber<T>() {
                public void onNext(T t) {
                    CacheState.this.onNext(t);
                }

                public void onError(Throwable th) {
                    CacheState.this.onError(th);
                }

                public void onCompleted() {
                    CacheState.this.onCompleted();
                }
            };
            this.connection.set(r0);
            this.source.unsafeSubscribe(r0);
            this.isConnected = true;
        }

        public void onNext(T t) {
            if (!this.sourceDone) {
                add(NotificationLite.next(t));
                dispatch();
            }
        }

        public void onError(Throwable th) {
            if (!this.sourceDone) {
                this.sourceDone = true;
                add(NotificationLite.error(th));
                this.connection.unsubscribe();
                dispatch();
            }
        }

        public void onCompleted() {
            if (!this.sourceDone) {
                this.sourceDone = true;
                add(NotificationLite.completed());
                this.connection.unsubscribe();
                dispatch();
            }
        }

        /* access modifiers changed from: 0000 */
        public void dispatch() {
            for (ReplayProducer<?> replay : this.producers) {
                replay.replay();
            }
        }
    }

    static final class CachedSubscribe<T> extends AtomicBoolean implements OnSubscribe<T> {
        private static final long serialVersionUID = -2817751667698696782L;
        final CacheState<T> state;

        public CachedSubscribe(CacheState<T> cacheState) {
            this.state = cacheState;
        }

        public void call(Subscriber<? super T> subscriber) {
            ReplayProducer replayProducer = new ReplayProducer(subscriber, this.state);
            this.state.addProducer(replayProducer);
            subscriber.add(replayProducer);
            subscriber.setProducer(replayProducer);
            if (!get() && compareAndSet(false, true)) {
                this.state.connect();
            }
        }
    }

    static final class ReplayProducer<T> extends AtomicLong implements Producer, Subscription {
        private static final long serialVersionUID = -2557562030197141021L;
        final Subscriber<? super T> child;
        Object[] currentBuffer;
        int currentIndexInBuffer;
        boolean emitting;
        int index;
        boolean missed;
        final CacheState<T> state;

        public ReplayProducer(Subscriber<? super T> subscriber, CacheState<T> cacheState) {
            this.child = subscriber;
            this.state = cacheState;
        }

        public void request(long j) {
            long j2;
            long j3;
            do {
                j2 = get();
                if (j2 >= 0) {
                    j3 = j2 + j;
                    if (j3 < 0) {
                        j3 = LongCompanionObject.MAX_VALUE;
                    }
                } else {
                    return;
                }
            } while (!compareAndSet(j2, j3));
            replay();
        }

        public long produced(long j) {
            return addAndGet(-j);
        }

        public boolean isUnsubscribed() {
            return get() < 0;
        }

        public void unsubscribe() {
            if (get() >= 0 && getAndSet(-1) >= 0) {
                this.state.removeProducer(this);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:104:0x00e0, code lost:
            throw r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            r2 = r15.child;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0010, code lost:
            r3 = get();
            r7 = (r3 > 0 ? 1 : (r3 == 0 ? 0 : -1));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0018, code lost:
            if (r7 >= 0) goto L_0x001b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x001a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x001b, code lost:
            r8 = r15.state.size();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0021, code lost:
            if (r8 == 0) goto L_0x00bc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0023, code lost:
            r9 = r15.currentBuffer;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0025, code lost:
            if (r9 != null) goto L_0x002f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0027, code lost:
            r9 = r15.state.head();
            r15.currentBuffer = r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x002f, code lost:
            r10 = r9.length - 1;
            r11 = r15.index;
            r12 = r15.currentIndexInBuffer;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0035, code lost:
            if (r7 != 0) goto L_0x0057;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0037, code lost:
            r3 = r9[r12];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x003d, code lost:
            if (rx.internal.operators.NotificationLite.isCompleted(r3) == false) goto L_0x0046;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x003f, code lost:
            r2.onCompleted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0045, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x004a, code lost:
            if (rx.internal.operators.NotificationLite.isError(r3) == false) goto L_0x00bc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x004c, code lost:
            r2.onError(rx.internal.operators.NotificationLite.getError(r3));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0056, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0057, code lost:
            if (r7 <= 0) goto L_0x00bc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0059, code lost:
            r7 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x005a, code lost:
            if (r11 >= r8) goto L_0x00ab;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x005e, code lost:
            if (r3 <= 0) goto L_0x00ab;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0064, code lost:
            if (r2.isUnsubscribed() == false) goto L_0x0067;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0066, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0067, code lost:
            if (r12 != r10) goto L_0x0070;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0069, code lost:
            r9 = (java.lang.Object[]) r9[r10];
            r12 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0070, code lost:
            r13 = r9[r12];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0076, code lost:
            if (rx.internal.operators.NotificationLite.accept(r2, r13) == false) goto L_0x007f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
            unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x007b, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x007c, code lost:
            r3 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x007d, code lost:
            r4 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x007f, code lost:
            r12 = r12 + 1;
            r11 = r11 + 1;
            r3 = r3 - 1;
            r7 = r7 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x0089, code lost:
            r3 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x008a, code lost:
            r4 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
            rx.exceptions.Exceptions.throwIfFatal(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
            unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x009d, code lost:
            r2.onError(rx.exceptions.OnErrorThrowable.addValueAsLastCause(r3, rx.internal.operators.NotificationLite.getValue(r13)));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x00a8, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x00a9, code lost:
            r1 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x00af, code lost:
            if (r2.isUnsubscribed() == false) goto L_0x00b2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:0x00b1, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:0x00b2, code lost:
            r15.index = r11;
            r15.currentIndexInBuffer = r12;
            r15.currentBuffer = r9;
            produced((long) r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:0x00bc, code lost:
            monitor-enter(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x00bf, code lost:
            if (r15.missed != false) goto L_0x00c5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x00c1, code lost:
            r15.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:?, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x00c4, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:?, code lost:
            r15.missed = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:0x00c7, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:0x00ca, code lost:
            r2 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:85:0x00cb, code lost:
            r1 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:87:?, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:89:?, code lost:
            throw r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:90:0x00ce, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:0x00cf, code lost:
            r4 = r1;
            r1 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:0x00d2, code lost:
            r2 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:93:0x00d4, code lost:
            r1 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:94:0x00d5, code lost:
            r4 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:95:0x00d6, code lost:
            if (r4 == false) goto L_0x00d8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:96:0x00d8, code lost:
            monitor-enter(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:98:?, code lost:
            r15.emitting = false;
         */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x00d8  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void replay() {
            /*
                r15 = this;
                monitor-enter(r15)
                boolean r0 = r15.emitting     // Catch:{ all -> 0x00e1 }
                r1 = 1
                if (r0 == 0) goto L_0x000a
                r15.missed = r1     // Catch:{ all -> 0x00e1 }
                monitor-exit(r15)     // Catch:{ all -> 0x00e1 }
                return
            L_0x000a:
                r15.emitting = r1     // Catch:{ all -> 0x00e1 }
                monitor-exit(r15)     // Catch:{ all -> 0x00e1 }
                r0 = 0
                rx.Subscriber<? super T> r2 = r15.child     // Catch:{ all -> 0x00d4 }
            L_0x0010:
                long r3 = r15.get()     // Catch:{ all -> 0x00d4 }
                r5 = 0
                int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r7 >= 0) goto L_0x001b
                return
            L_0x001b:
                rx.internal.operators.CachedObservable$CacheState<T> r8 = r15.state     // Catch:{ all -> 0x00d4 }
                int r8 = r8.size()     // Catch:{ all -> 0x00d4 }
                if (r8 == 0) goto L_0x00bc
                java.lang.Object[] r9 = r15.currentBuffer     // Catch:{ all -> 0x00d4 }
                if (r9 != 0) goto L_0x002f
                rx.internal.operators.CachedObservable$CacheState<T> r9 = r15.state     // Catch:{ all -> 0x00d4 }
                java.lang.Object[] r9 = r9.head()     // Catch:{ all -> 0x00d4 }
                r15.currentBuffer = r9     // Catch:{ all -> 0x00d4 }
            L_0x002f:
                int r10 = r9.length     // Catch:{ all -> 0x00d4 }
                int r10 = r10 - r1
                int r11 = r15.index     // Catch:{ all -> 0x00d4 }
                int r12 = r15.currentIndexInBuffer     // Catch:{ all -> 0x00d4 }
                if (r7 != 0) goto L_0x0057
                r3 = r9[r12]     // Catch:{ all -> 0x00d4 }
                boolean r4 = rx.internal.operators.NotificationLite.isCompleted(r3)     // Catch:{ all -> 0x00d4 }
                if (r4 == 0) goto L_0x0046
                r2.onCompleted()     // Catch:{ all -> 0x00d4 }
                r15.unsubscribe()     // Catch:{ all -> 0x00ce }
                return
            L_0x0046:
                boolean r4 = rx.internal.operators.NotificationLite.isError(r3)     // Catch:{ all -> 0x00d4 }
                if (r4 == 0) goto L_0x00bc
                java.lang.Throwable r3 = rx.internal.operators.NotificationLite.getError(r3)     // Catch:{ all -> 0x00d4 }
                r2.onError(r3)     // Catch:{ all -> 0x00d4 }
                r15.unsubscribe()     // Catch:{ all -> 0x00ce }
                return
            L_0x0057:
                if (r7 <= 0) goto L_0x00bc
                r7 = r0
            L_0x005a:
                if (r11 >= r8) goto L_0x00ab
                int r13 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r13 <= 0) goto L_0x00ab
                boolean r13 = r2.isUnsubscribed()     // Catch:{ all -> 0x00d4 }
                if (r13 == 0) goto L_0x0067
                return
            L_0x0067:
                if (r12 != r10) goto L_0x0070
                r9 = r9[r10]     // Catch:{ all -> 0x00d4 }
                java.lang.Object[] r9 = (java.lang.Object[]) r9     // Catch:{ all -> 0x00d4 }
                java.lang.Object[] r9 = (java.lang.Object[]) r9     // Catch:{ all -> 0x00d4 }
                r12 = r0
            L_0x0070:
                r13 = r9[r12]     // Catch:{ all -> 0x00d4 }
                boolean r14 = rx.internal.operators.NotificationLite.accept(r2, r13)     // Catch:{ all -> 0x0089 }
                if (r14 == 0) goto L_0x007f
                r15.unsubscribe()     // Catch:{ all -> 0x007c }
                return
            L_0x007c:
                r3 = move-exception
                r4 = r1
                goto L_0x008b
            L_0x007f:
                int r12 = r12 + 1
                int r11 = r11 + 1
                r13 = 1
                long r3 = r3 - r13
                int r7 = r7 + 1
                goto L_0x005a
            L_0x0089:
                r3 = move-exception
                r4 = r0
            L_0x008b:
                rx.exceptions.Exceptions.throwIfFatal(r3)     // Catch:{ all -> 0x00a9 }
                r15.unsubscribe()     // Catch:{ all -> 0x00ce }
                boolean r4 = rx.internal.operators.NotificationLite.isError(r13)     // Catch:{ all -> 0x00ce }
                if (r4 != 0) goto L_0x00a8
                boolean r4 = rx.internal.operators.NotificationLite.isCompleted(r13)     // Catch:{ all -> 0x00ce }
                if (r4 != 0) goto L_0x00a8
                java.lang.Object r4 = rx.internal.operators.NotificationLite.getValue(r13)     // Catch:{ all -> 0x00ce }
                java.lang.Throwable r3 = rx.exceptions.OnErrorThrowable.addValueAsLastCause(r3, r4)     // Catch:{ all -> 0x00ce }
                r2.onError(r3)     // Catch:{ all -> 0x00ce }
            L_0x00a8:
                return
            L_0x00a9:
                r1 = move-exception
                goto L_0x00d6
            L_0x00ab:
                boolean r3 = r2.isUnsubscribed()     // Catch:{ all -> 0x00d4 }
                if (r3 == 0) goto L_0x00b2
                return
            L_0x00b2:
                r15.index = r11     // Catch:{ all -> 0x00d4 }
                r15.currentIndexInBuffer = r12     // Catch:{ all -> 0x00d4 }
                r15.currentBuffer = r9     // Catch:{ all -> 0x00d4 }
                long r3 = (long) r7     // Catch:{ all -> 0x00d4 }
                r15.produced(r3)     // Catch:{ all -> 0x00d4 }
            L_0x00bc:
                monitor-enter(r15)     // Catch:{ all -> 0x00d4 }
                boolean r3 = r15.missed     // Catch:{ all -> 0x00ca }
                if (r3 != 0) goto L_0x00c5
                r15.emitting = r0     // Catch:{ all -> 0x00ca }
                monitor-exit(r15)     // Catch:{ all -> 0x00d2 }
                return
            L_0x00c5:
                r15.missed = r0     // Catch:{ all -> 0x00ca }
                monitor-exit(r15)     // Catch:{ all -> 0x00ca }
                goto L_0x0010
            L_0x00ca:
                r2 = move-exception
                r1 = r0
            L_0x00cc:
                monitor-exit(r15)     // Catch:{ all -> 0x00d2 }
                throw r2     // Catch:{ all -> 0x00ce }
            L_0x00ce:
                r2 = move-exception
                r4 = r1
                r1 = r2
                goto L_0x00d6
            L_0x00d2:
                r2 = move-exception
                goto L_0x00cc
            L_0x00d4:
                r1 = move-exception
                r4 = r0
            L_0x00d6:
                if (r4 != 0) goto L_0x00e0
                monitor-enter(r15)
                r15.emitting = r0     // Catch:{ all -> 0x00dd }
                monitor-exit(r15)     // Catch:{ all -> 0x00dd }
                goto L_0x00e0
            L_0x00dd:
                r0 = move-exception
                monitor-exit(r15)     // Catch:{ all -> 0x00dd }
                throw r0
            L_0x00e0:
                throw r1
            L_0x00e1:
                r0 = move-exception
                monitor-exit(r15)     // Catch:{ all -> 0x00e1 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.CachedObservable.ReplayProducer.replay():void");
        }
    }

    public static <T> CachedObservable<T> from(Observable<? extends T> observable) {
        return from(observable, 16);
    }

    public static <T> CachedObservable<T> from(Observable<? extends T> observable, int i) {
        if (i >= 1) {
            CacheState cacheState = new CacheState(observable, i);
            return new CachedObservable<>(new CachedSubscribe(cacheState), cacheState);
        }
        throw new IllegalArgumentException("capacityHint > 0 required");
    }

    private CachedObservable(OnSubscribe<T> onSubscribe, CacheState<T> cacheState) {
        super(onSubscribe);
        this.state = cacheState;
    }

    /* access modifiers changed from: 0000 */
    public boolean isConnected() {
        return this.state.isConnected;
    }

    /* access modifiers changed from: 0000 */
    public boolean hasObservers() {
        return this.state.producers.length != 0;
    }
}
