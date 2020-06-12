package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.internal.util.LinkedArrayList;
import rx.subscriptions.SerialSubscription;

public final class CachedObservable<T> extends Observable<T> {
    private final CacheState<T> state;

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

    private CachedObservable(Observable.OnSubscribe<T> onSubscribe, CacheState<T> cacheState) {
        super(onSubscribe);
        this.state = cacheState;
    }

    /* access modifiers changed from: package-private */
    public boolean isConnected() {
        return this.state.isConnected;
    }

    /* access modifiers changed from: package-private */
    public boolean hasObservers() {
        return this.state.producers.length != 0;
    }

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

        /* access modifiers changed from: package-private */
        public void dispatch() {
            for (ReplayProducer<?> replay : this.producers) {
                replay.replay();
            }
        }
    }

    static final class CachedSubscribe<T> extends AtomicBoolean implements Observable.OnSubscribe<T> {
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

        /* JADX WARNING: Code restructure failed: missing block: B:105:0x00e5, code lost:
            throw r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:119:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            r2 = r15.child;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:121:?, code lost:
            return;
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
            if (r8 == 0) goto L_0x00c1;
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
            if (r7 != 0) goto L_0x005c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0037, code lost:
            r3 = r9[r12];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x003d, code lost:
            if (rx.internal.operators.NotificationLite.isCompleted(r3) == false) goto L_0x004b;
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
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0046, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0047, code lost:
            r1 = r2;
            r4 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x004f, code lost:
            if (rx.internal.operators.NotificationLite.isError(r3) == false) goto L_0x00c1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0051, code lost:
            r2.onError(rx.internal.operators.NotificationLite.getError(r3));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x005b, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x005c, code lost:
            if (r7 <= 0) goto L_0x00c1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x005e, code lost:
            r7 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x005f, code lost:
            if (r11 >= r8) goto L_0x00b0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0063, code lost:
            if (r3 <= 0) goto L_0x00b0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0069, code lost:
            if (r2.isUnsubscribed() == false) goto L_0x006c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x006b, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x006c, code lost:
            if (r12 != r10) goto L_0x0075;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x006e, code lost:
            r9 = (java.lang.Object[]) r9[r10];
            r12 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0075, code lost:
            r13 = r9[r12];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x007b, code lost:
            if (rx.internal.operators.NotificationLite.accept(r2, r13) == false) goto L_0x0084;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
            unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x0080, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x0081, code lost:
            r3 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x0082, code lost:
            r4 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x0084, code lost:
            r12 = r12 + 1;
            r11 = r11 + 1;
            r3 = r3 - 1;
            r7 = r7 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x008e, code lost:
            r3 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x008f, code lost:
            r4 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
            rx.exceptions.Exceptions.throwIfFatal(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
            unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x009a, code lost:
            if (rx.internal.operators.NotificationLite.isError(r13) != false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x00a2, code lost:
            r2.onError(rx.exceptions.OnErrorThrowable.addValueAsLastCause(r3, rx.internal.operators.NotificationLite.getValue(r13)));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x00ae, code lost:
            r1 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:0x00b4, code lost:
            if (r2.isUnsubscribed() == false) goto L_0x00b7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:0x00b6, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:0x00b7, code lost:
            r15.index = r11;
            r15.currentIndexInBuffer = r12;
            r15.currentBuffer = r9;
            produced((long) r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x00c1, code lost:
            monitor-enter(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x00c4, code lost:
            if (r15.missed != false) goto L_0x00ca;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x00c6, code lost:
            r15.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:?, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:0x00c9, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:?, code lost:
            r15.missed = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:0x00cc, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:85:0x00cf, code lost:
            r2 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:0x00d0, code lost:
            r1 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:90:?, code lost:
            throw r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:0x00d3, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:0x00d4, code lost:
            r4 = r1;
            r1 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:93:0x00d7, code lost:
            r2 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:94:0x00d9, code lost:
            r1 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:95:0x00da, code lost:
            r4 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:96:0x00db, code lost:
            if (r4 == false) goto L_0x00dd;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:97:0x00dd, code lost:
            monitor-enter(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:99:?, code lost:
            r15.emitting = false;
         */
        /* JADX WARNING: Removed duplicated region for block: B:121:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x00a2 A[Catch:{ all -> 0x0046 }] */
        /* JADX WARNING: Removed duplicated region for block: B:97:0x00dd  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void replay() {
            /*
                r15 = this;
                monitor-enter(r15)
                boolean r0 = r15.emitting     // Catch:{ all -> 0x00e6 }
                r1 = 1
                if (r0 == 0) goto L_0x000a
                r15.missed = r1     // Catch:{ all -> 0x00e6 }
                monitor-exit(r15)     // Catch:{ all -> 0x00e6 }
                return
            L_0x000a:
                r15.emitting = r1     // Catch:{ all -> 0x00e6 }
                monitor-exit(r15)     // Catch:{ all -> 0x00e6 }
                r0 = 0
                rx.Subscriber<? super T> r2 = r15.child     // Catch:{ all -> 0x00d9 }
            L_0x0010:
                long r3 = r15.get()     // Catch:{ all -> 0x00d9 }
                r5 = 0
                int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r7 >= 0) goto L_0x001b
                return
            L_0x001b:
                rx.internal.operators.CachedObservable$CacheState<T> r8 = r15.state     // Catch:{ all -> 0x00d9 }
                int r8 = r8.size()     // Catch:{ all -> 0x00d9 }
                if (r8 == 0) goto L_0x00c1
                java.lang.Object[] r9 = r15.currentBuffer     // Catch:{ all -> 0x00d9 }
                if (r9 != 0) goto L_0x002f
                rx.internal.operators.CachedObservable$CacheState<T> r9 = r15.state     // Catch:{ all -> 0x00d9 }
                java.lang.Object[] r9 = r9.head()     // Catch:{ all -> 0x00d9 }
                r15.currentBuffer = r9     // Catch:{ all -> 0x00d9 }
            L_0x002f:
                int r10 = r9.length     // Catch:{ all -> 0x00d9 }
                int r10 = r10 - r1
                int r11 = r15.index     // Catch:{ all -> 0x00d9 }
                int r12 = r15.currentIndexInBuffer     // Catch:{ all -> 0x00d9 }
                if (r7 != 0) goto L_0x005c
                r3 = r9[r12]     // Catch:{ all -> 0x00d9 }
                boolean r4 = rx.internal.operators.NotificationLite.isCompleted(r3)     // Catch:{ all -> 0x00d9 }
                if (r4 == 0) goto L_0x004b
                r2.onCompleted()     // Catch:{ all -> 0x00d9 }
                r15.unsubscribe()     // Catch:{ all -> 0x0046 }
                return
            L_0x0046:
                r2 = move-exception
                r1 = r2
                r4 = 1
                goto L_0x00db
            L_0x004b:
                boolean r4 = rx.internal.operators.NotificationLite.isError(r3)     // Catch:{ all -> 0x00d9 }
                if (r4 == 0) goto L_0x00c1
                java.lang.Throwable r3 = rx.internal.operators.NotificationLite.getError(r3)     // Catch:{ all -> 0x00d9 }
                r2.onError(r3)     // Catch:{ all -> 0x00d9 }
                r15.unsubscribe()     // Catch:{ all -> 0x0046 }
                return
            L_0x005c:
                if (r7 <= 0) goto L_0x00c1
                r7 = 0
            L_0x005f:
                if (r11 >= r8) goto L_0x00b0
                int r13 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r13 <= 0) goto L_0x00b0
                boolean r13 = r2.isUnsubscribed()     // Catch:{ all -> 0x00d9 }
                if (r13 == 0) goto L_0x006c
                return
            L_0x006c:
                if (r12 != r10) goto L_0x0075
                r9 = r9[r10]     // Catch:{ all -> 0x00d9 }
                java.lang.Object[] r9 = (java.lang.Object[]) r9     // Catch:{ all -> 0x00d9 }
                java.lang.Object[] r9 = (java.lang.Object[]) r9     // Catch:{ all -> 0x00d9 }
                r12 = 0
            L_0x0075:
                r13 = r9[r12]     // Catch:{ all -> 0x00d9 }
                boolean r14 = rx.internal.operators.NotificationLite.accept(r2, r13)     // Catch:{ all -> 0x008e }
                if (r14 == 0) goto L_0x0084
                r15.unsubscribe()     // Catch:{ all -> 0x0081 }
                return
            L_0x0081:
                r3 = move-exception
                r4 = 1
                goto L_0x0090
            L_0x0084:
                int r12 = r12 + 1
                int r11 = r11 + 1
                r13 = 1
                long r3 = r3 - r13
                int r7 = r7 + 1
                goto L_0x005f
            L_0x008e:
                r3 = move-exception
                r4 = 0
            L_0x0090:
                rx.exceptions.Exceptions.throwIfFatal(r3)     // Catch:{ all -> 0x00ae }
                r15.unsubscribe()     // Catch:{ all -> 0x0046 }
                boolean r4 = rx.internal.operators.NotificationLite.isError(r13)     // Catch:{ all -> 0x0046 }
                if (r4 != 0) goto L_0x00ad
                boolean r4 = rx.internal.operators.NotificationLite.isCompleted(r13)     // Catch:{ all -> 0x0046 }
                if (r4 != 0) goto L_0x00ad
                java.lang.Object r4 = rx.internal.operators.NotificationLite.getValue(r13)     // Catch:{ all -> 0x0046 }
                java.lang.Throwable r3 = rx.exceptions.OnErrorThrowable.addValueAsLastCause(r3, r4)     // Catch:{ all -> 0x0046 }
                r2.onError(r3)     // Catch:{ all -> 0x0046 }
            L_0x00ad:
                return
            L_0x00ae:
                r1 = move-exception
                goto L_0x00db
            L_0x00b0:
                boolean r3 = r2.isUnsubscribed()     // Catch:{ all -> 0x00d9 }
                if (r3 == 0) goto L_0x00b7
                return
            L_0x00b7:
                r15.index = r11     // Catch:{ all -> 0x00d9 }
                r15.currentIndexInBuffer = r12     // Catch:{ all -> 0x00d9 }
                r15.currentBuffer = r9     // Catch:{ all -> 0x00d9 }
                long r3 = (long) r7     // Catch:{ all -> 0x00d9 }
                r15.produced(r3)     // Catch:{ all -> 0x00d9 }
            L_0x00c1:
                monitor-enter(r15)     // Catch:{ all -> 0x00d9 }
                boolean r3 = r15.missed     // Catch:{ all -> 0x00cf }
                if (r3 != 0) goto L_0x00ca
                r15.emitting = r0     // Catch:{ all -> 0x00cf }
                monitor-exit(r15)     // Catch:{ all -> 0x00d7 }
                return
            L_0x00ca:
                r15.missed = r0     // Catch:{ all -> 0x00cf }
                monitor-exit(r15)     // Catch:{ all -> 0x00cf }
                goto L_0x0010
            L_0x00cf:
                r2 = move-exception
                r1 = 0
            L_0x00d1:
                monitor-exit(r15)     // Catch:{ all -> 0x00d7 }
                throw r2     // Catch:{ all -> 0x00d3 }
            L_0x00d3:
                r2 = move-exception
                r4 = r1
                r1 = r2
                goto L_0x00db
            L_0x00d7:
                r2 = move-exception
                goto L_0x00d1
            L_0x00d9:
                r1 = move-exception
                r4 = 0
            L_0x00db:
                if (r4 != 0) goto L_0x00e5
                monitor-enter(r15)
                r15.emitting = r0     // Catch:{ all -> 0x00e2 }
                monitor-exit(r15)     // Catch:{ all -> 0x00e2 }
                goto L_0x00e5
            L_0x00e2:
                r0 = move-exception
                monitor-exit(r15)     // Catch:{ all -> 0x00e2 }
                throw r0
            L_0x00e5:
                throw r1
            L_0x00e6:
                r0 = move-exception
                monitor-exit(r15)     // Catch:{ all -> 0x00e6 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.CachedObservable.ReplayProducer.replay():void");
        }
    }
}
