package rx.subjects;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable.OnSubscribe;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.internal.operators.BackpressureUtils;
import rx.internal.operators.NotificationLite;
import rx.internal.util.atomic.SpscLinkedAtomicQueue;
import rx.internal.util.atomic.SpscUnboundedAtomicArrayQueue;
import rx.internal.util.unsafe.SpscLinkedQueue;
import rx.internal.util.unsafe.SpscUnboundedArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;

public final class UnicastSubject<T> extends Subject<T, T> {
    final State<T> state;

    static final class State<T> extends AtomicLong implements Producer, Observer<T>, OnSubscribe<T>, Subscription {
        private static final long serialVersionUID = -9044104859202255786L;
        volatile boolean caughtUp;
        final boolean delayError;
        volatile boolean done;
        boolean emitting;
        Throwable error;
        boolean missed;
        final Queue<Object> queue;
        final AtomicReference<Subscriber<? super T>> subscriber = new AtomicReference<>();
        final AtomicReference<Action0> terminateOnce;

        public State(int i, boolean z, Action0 action0) {
            Queue<Object> queue2;
            this.terminateOnce = action0 != null ? new AtomicReference<>(action0) : null;
            this.delayError = z;
            if (i > 1) {
                queue2 = UnsafeAccess.isUnsafeAvailable() ? new SpscUnboundedArrayQueue<>(i) : new SpscUnboundedAtomicArrayQueue<>(i);
            } else {
                queue2 = UnsafeAccess.isUnsafeAvailable() ? new SpscLinkedQueue<>() : new SpscLinkedAtomicQueue<>();
            }
            this.queue = queue2;
        }

        public void onNext(T t) {
            if (!this.done) {
                if (!this.caughtUp) {
                    boolean z = false;
                    synchronized (this) {
                        if (!this.caughtUp) {
                            this.queue.offer(NotificationLite.next(t));
                            z = true;
                        }
                    }
                    if (z) {
                        replay();
                        return;
                    }
                }
                Subscriber subscriber2 = (Subscriber) this.subscriber.get();
                try {
                    subscriber2.onNext(t);
                } catch (Throwable th) {
                    Exceptions.throwOrReport(th, (Observer<?>) subscriber2, (Object) t);
                }
            }
        }

        public void onError(Throwable th) {
            if (!this.done) {
                doTerminate();
                this.error = th;
                boolean z = true;
                this.done = true;
                if (!this.caughtUp) {
                    synchronized (this) {
                        if (this.caughtUp) {
                            z = false;
                        }
                    }
                    if (z) {
                        replay();
                        return;
                    }
                }
                ((Subscriber) this.subscriber.get()).onError(th);
            }
        }

        public void onCompleted() {
            if (!this.done) {
                doTerminate();
                boolean z = true;
                this.done = true;
                if (!this.caughtUp) {
                    synchronized (this) {
                        if (this.caughtUp) {
                            z = false;
                        }
                    }
                    if (z) {
                        replay();
                        return;
                    }
                }
                ((Subscriber) this.subscriber.get()).onCompleted();
            }
        }

        public void request(long j) {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i < 0) {
                throw new IllegalArgumentException("n >= 0 required");
            } else if (i > 0) {
                BackpressureUtils.getAndAddRequest(this, j);
                replay();
            } else if (this.done) {
                replay();
            }
        }

        public void call(Subscriber<? super T> subscriber2) {
            if (this.subscriber.compareAndSet(null, subscriber2)) {
                subscriber2.add(this);
                subscriber2.setProducer(this);
                return;
            }
            subscriber2.onError(new IllegalStateException("Only a single subscriber is allowed"));
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0011, code lost:
            r3 = (rx.Subscriber) r15.subscriber.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001a, code lost:
            if (r3 == null) goto L_0x007b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0026, code lost:
            if (checkTerminated(r15.done, r0.isEmpty(), r2, r3) == false) goto L_0x0029;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
            r5 = get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0034, code lost:
            if (r5 != kotlin.jvm.internal.LongCompanionObject.MAX_VALUE) goto L_0x0038;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0036, code lost:
            r7 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0038, code lost:
            r7 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0039, code lost:
            r10 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x003e, code lost:
            if (r5 == 0) goto L_0x0070;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0040, code lost:
            r12 = r15.done;
            r13 = r0.poll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0046, code lost:
            if (r13 != null) goto L_0x004a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0048, code lost:
            r14 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x004a, code lost:
            r14 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x004f, code lost:
            if (checkTerminated(r12, r14, r2, r3) == false) goto L_0x0052;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0051, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0052, code lost:
            if (r14 == false) goto L_0x0055;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0055, code lost:
            r12 = rx.internal.operators.NotificationLite.getValue(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
            r3.onNext(r12);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x005c, code lost:
            r5 = r5 - 1;
            r10 = r10 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0061, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0062, code lost:
            r0.clear();
            rx.exceptions.Exceptions.throwIfFatal(r1);
            r3.onError(rx.exceptions.OnErrorThrowable.addValueAsLastCause(r1, r12));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x006f, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0070, code lost:
            if (r7 != false) goto L_0x007c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0074, code lost:
            if (r10 == 0) goto L_0x007c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0076, code lost:
            addAndGet(-r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x007b, code lost:
            r7 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x007c, code lost:
            monitor-enter(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x007f, code lost:
            if (r15.missed != false) goto L_0x008f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0081, code lost:
            if (r7 == false) goto L_0x008b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0087, code lost:
            if (r0.isEmpty() == false) goto L_0x008b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0089, code lost:
            r15.caughtUp = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x008b, code lost:
            r15.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x008d, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x008e, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x008f, code lost:
            r15.missed = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x0091, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x000d, code lost:
            r0 = r15.queue;
            r2 = r15.delayError;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void replay() {
            /*
                r15 = this;
                monitor-enter(r15)
                boolean r0 = r15.emitting     // Catch:{ all -> 0x0097 }
                r1 = 1
                if (r0 == 0) goto L_0x000a
                r15.missed = r1     // Catch:{ all -> 0x0097 }
                monitor-exit(r15)     // Catch:{ all -> 0x0097 }
                return
            L_0x000a:
                r15.emitting = r1     // Catch:{ all -> 0x0097 }
                monitor-exit(r15)     // Catch:{ all -> 0x0097 }
                java.util.Queue<java.lang.Object> r0 = r15.queue
                boolean r2 = r15.delayError
            L_0x0011:
                java.util.concurrent.atomic.AtomicReference<rx.Subscriber<? super T>> r3 = r15.subscriber
                java.lang.Object r3 = r3.get()
                rx.Subscriber r3 = (rx.Subscriber) r3
                r4 = 0
                if (r3 == 0) goto L_0x007b
                boolean r5 = r15.done
                boolean r6 = r0.isEmpty()
                boolean r5 = r15.checkTerminated(r5, r6, r2, r3)
                if (r5 == 0) goto L_0x0029
                return
            L_0x0029:
                long r5 = r15.get()
                r7 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r7 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r7 != 0) goto L_0x0038
                r7 = r1
                goto L_0x0039
            L_0x0038:
                r7 = r4
            L_0x0039:
                r8 = 0
                r10 = r8
            L_0x003c:
                int r12 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
                if (r12 == 0) goto L_0x0070
                boolean r12 = r15.done
                java.lang.Object r13 = r0.poll()
                if (r13 != 0) goto L_0x004a
                r14 = r1
                goto L_0x004b
            L_0x004a:
                r14 = r4
            L_0x004b:
                boolean r12 = r15.checkTerminated(r12, r14, r2, r3)
                if (r12 == 0) goto L_0x0052
                return
            L_0x0052:
                if (r14 == 0) goto L_0x0055
                goto L_0x0070
            L_0x0055:
                java.lang.Object r12 = rx.internal.operators.NotificationLite.getValue(r13)
                r3.onNext(r12)     // Catch:{ all -> 0x0061 }
                r12 = 1
                long r5 = r5 - r12
                long r10 = r10 + r12
                goto L_0x003c
            L_0x0061:
                r1 = move-exception
                r0.clear()
                rx.exceptions.Exceptions.throwIfFatal(r1)
                java.lang.Throwable r0 = rx.exceptions.OnErrorThrowable.addValueAsLastCause(r1, r12)
                r3.onError(r0)
                return
            L_0x0070:
                if (r7 != 0) goto L_0x007c
                int r3 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
                if (r3 == 0) goto L_0x007c
                long r5 = -r10
                r15.addAndGet(r5)
                goto L_0x007c
            L_0x007b:
                r7 = r4
            L_0x007c:
                monitor-enter(r15)
                boolean r3 = r15.missed     // Catch:{ all -> 0x0094 }
                if (r3 != 0) goto L_0x008f
                if (r7 == 0) goto L_0x008b
                boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0094 }
                if (r0 == 0) goto L_0x008b
                r15.caughtUp = r1     // Catch:{ all -> 0x0094 }
            L_0x008b:
                r15.emitting = r4     // Catch:{ all -> 0x0094 }
                monitor-exit(r15)     // Catch:{ all -> 0x0094 }
                return
            L_0x008f:
                r15.missed = r4     // Catch:{ all -> 0x0094 }
                monitor-exit(r15)     // Catch:{ all -> 0x0094 }
                goto L_0x0011
            L_0x0094:
                r0 = move-exception
                monitor-exit(r15)     // Catch:{ all -> 0x0094 }
                throw r0
            L_0x0097:
                r0 = move-exception
                monitor-exit(r15)     // Catch:{ all -> 0x0097 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.subjects.UnicastSubject.State.replay():void");
        }

        public void unsubscribe() {
            doTerminate();
            this.done = true;
            synchronized (this) {
                if (!this.emitting) {
                    this.emitting = true;
                    this.queue.clear();
                }
            }
        }

        public boolean isUnsubscribed() {
            return this.done;
        }

        /* access modifiers changed from: 0000 */
        public boolean checkTerminated(boolean z, boolean z2, boolean z3, Subscriber<? super T> subscriber2) {
            if (subscriber2.isUnsubscribed()) {
                this.queue.clear();
                return true;
            }
            if (z) {
                Throwable th = this.error;
                if (th != null && !z3) {
                    this.queue.clear();
                    subscriber2.onError(th);
                    return true;
                } else if (z2) {
                    if (th != null) {
                        subscriber2.onError(th);
                    } else {
                        subscriber2.onCompleted();
                    }
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: 0000 */
        public void doTerminate() {
            AtomicReference<Action0> atomicReference = this.terminateOnce;
            if (atomicReference != null) {
                Action0 action0 = (Action0) atomicReference.get();
                if (action0 != null && atomicReference.compareAndSet(action0, null)) {
                    action0.call();
                }
            }
        }
    }

    public static <T> UnicastSubject<T> create() {
        return create(16);
    }

    public static <T> UnicastSubject<T> create(int i) {
        return new UnicastSubject<>(new State(i, false, null));
    }

    public static <T> UnicastSubject<T> create(boolean z) {
        return new UnicastSubject<>(new State(16, z, null));
    }

    public static <T> UnicastSubject<T> create(int i, Action0 action0) {
        return new UnicastSubject<>(new State(i, false, action0));
    }

    public static <T> UnicastSubject<T> create(int i, Action0 action0, boolean z) {
        return new UnicastSubject<>(new State(i, z, action0));
    }

    private UnicastSubject(State<T> state2) {
        super(state2);
        this.state = state2;
    }

    public void onNext(T t) {
        this.state.onNext(t);
    }

    public void onError(Throwable th) {
        this.state.onError(th);
    }

    public void onCompleted() {
        this.state.onCompleted();
    }

    public boolean hasObservers() {
        return this.state.subscriber.get() != null;
    }
}
