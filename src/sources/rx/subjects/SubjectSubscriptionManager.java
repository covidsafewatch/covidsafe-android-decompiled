package rx.subjects;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Actions;
import rx.internal.operators.NotificationLite;
import rx.subscriptions.Subscriptions;

final class SubjectSubscriptionManager<T> extends AtomicReference<State<T>> implements Observable.OnSubscribe<T> {
    private static final long serialVersionUID = 6035251036011671568L;
    boolean active = true;
    volatile Object latest;
    Action1<SubjectObserver<T>> onAdded = Actions.empty();
    Action1<SubjectObserver<T>> onStart = Actions.empty();
    Action1<SubjectObserver<T>> onTerminated = Actions.empty();

    public SubjectSubscriptionManager() {
        super(State.EMPTY);
    }

    public void call(Subscriber<? super T> subscriber) {
        SubjectObserver subjectObserver = new SubjectObserver(subscriber);
        addUnsubscriber(subscriber, subjectObserver);
        this.onStart.call(subjectObserver);
        if (!subscriber.isUnsubscribed() && add(subjectObserver) && subscriber.isUnsubscribed()) {
            remove(subjectObserver);
        }
    }

    /* access modifiers changed from: package-private */
    public void addUnsubscriber(Subscriber<? super T> subscriber, final SubjectObserver<T> subjectObserver) {
        subscriber.add(Subscriptions.create(new Action0() {
            public void call() {
                SubjectSubscriptionManager.this.remove(subjectObserver);
            }
        }));
    }

    /* access modifiers changed from: package-private */
    public void setLatest(Object obj) {
        this.latest = obj;
    }

    /* access modifiers changed from: package-private */
    public Object getLatest() {
        return this.latest;
    }

    /* access modifiers changed from: package-private */
    public SubjectObserver<T>[] observers() {
        return ((State) get()).observers;
    }

    /* access modifiers changed from: package-private */
    public boolean add(SubjectObserver<T> subjectObserver) {
        State state;
        do {
            state = (State) get();
            if (state.terminated) {
                this.onTerminated.call(subjectObserver);
                return false;
            }
        } while (!compareAndSet(state, state.add(subjectObserver)));
        this.onAdded.call(subjectObserver);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void remove(rx.subjects.SubjectSubscriptionManager.SubjectObserver<T> r3) {
        /*
            r2 = this;
        L_0x0000:
            java.lang.Object r0 = r2.get()
            rx.subjects.SubjectSubscriptionManager$State r0 = (rx.subjects.SubjectSubscriptionManager.State) r0
            boolean r1 = r0.terminated
            if (r1 == 0) goto L_0x000b
            return
        L_0x000b:
            rx.subjects.SubjectSubscriptionManager$State r1 = r0.remove(r3)
            if (r1 == r0) goto L_0x0017
            boolean r0 = r2.compareAndSet(r0, r1)
            if (r0 == 0) goto L_0x0000
        L_0x0017:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.subjects.SubjectSubscriptionManager.remove(rx.subjects.SubjectSubscriptionManager$SubjectObserver):void");
    }

    /* access modifiers changed from: package-private */
    public SubjectObserver<T>[] next(Object obj) {
        setLatest(obj);
        return ((State) get()).observers;
    }

    /* access modifiers changed from: package-private */
    public SubjectObserver<T>[] terminate(Object obj) {
        setLatest(obj);
        this.active = false;
        if (((State) get()).terminated) {
            return State.NO_OBSERVERS;
        }
        return ((State) getAndSet(State.TERMINATED)).observers;
    }

    protected static final class State<T> {
        static final State EMPTY = new State(false, NO_OBSERVERS);
        static final SubjectObserver[] NO_OBSERVERS = new SubjectObserver[0];
        static final State TERMINATED = new State(true, NO_OBSERVERS);
        final SubjectObserver[] observers;
        final boolean terminated;

        public State(boolean z, SubjectObserver[] subjectObserverArr) {
            this.terminated = z;
            this.observers = subjectObserverArr;
        }

        public State add(SubjectObserver subjectObserver) {
            SubjectObserver[] subjectObserverArr = this.observers;
            int length = subjectObserverArr.length;
            SubjectObserver[] subjectObserverArr2 = new SubjectObserver[(length + 1)];
            System.arraycopy(subjectObserverArr, 0, subjectObserverArr2, 0, length);
            subjectObserverArr2[length] = subjectObserver;
            return new State(this.terminated, subjectObserverArr2);
        }

        public State remove(SubjectObserver subjectObserver) {
            SubjectObserver[] subjectObserverArr = this.observers;
            if (r1 == 1 && subjectObserverArr[0] == subjectObserver) {
                return EMPTY;
            }
            if (r1 == 0) {
                return this;
            }
            int i = r1 - 1;
            SubjectObserver[] subjectObserverArr2 = new SubjectObserver[i];
            int i2 = 0;
            for (SubjectObserver subjectObserver2 : subjectObserverArr) {
                if (subjectObserver2 != subjectObserver) {
                    if (i2 == i) {
                        return this;
                    }
                    subjectObserverArr2[i2] = subjectObserver2;
                    i2++;
                }
            }
            if (i2 == 0) {
                return EMPTY;
            }
            if (i2 < i) {
                SubjectObserver[] subjectObserverArr3 = new SubjectObserver[i2];
                System.arraycopy(subjectObserverArr2, 0, subjectObserverArr3, 0, i2);
                subjectObserverArr2 = subjectObserverArr3;
            }
            return new State(this.terminated, subjectObserverArr2);
        }
    }

    protected static final class SubjectObserver<T> implements Observer<T> {
        final Subscriber<? super T> actual;
        volatile boolean caughtUp;
        boolean emitting;
        boolean fastPath;
        boolean first = true;
        private volatile Object index;
        List<Object> queue;

        public SubjectObserver(Subscriber<? super T> subscriber) {
            this.actual = subscriber;
        }

        public void onNext(T t) {
            this.actual.onNext(t);
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        public void onCompleted() {
            this.actual.onCompleted();
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
            r1.fastPath = true;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void emitNext(java.lang.Object r2) {
            /*
                r1 = this;
                boolean r0 = r1.fastPath
                if (r0 != 0) goto L_0x0026
                monitor-enter(r1)
                r0 = 0
                r1.first = r0     // Catch:{ all -> 0x0023 }
                boolean r0 = r1.emitting     // Catch:{ all -> 0x0023 }
                if (r0 == 0) goto L_0x001e
                java.util.List<java.lang.Object> r0 = r1.queue     // Catch:{ all -> 0x0023 }
                if (r0 != 0) goto L_0x0017
                java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0023 }
                r0.<init>()     // Catch:{ all -> 0x0023 }
                r1.queue = r0     // Catch:{ all -> 0x0023 }
            L_0x0017:
                java.util.List<java.lang.Object> r0 = r1.queue     // Catch:{ all -> 0x0023 }
                r0.add(r2)     // Catch:{ all -> 0x0023 }
                monitor-exit(r1)     // Catch:{ all -> 0x0023 }
                return
            L_0x001e:
                monitor-exit(r1)     // Catch:{ all -> 0x0023 }
                r0 = 1
                r1.fastPath = r0
                goto L_0x0026
            L_0x0023:
                r2 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0023 }
                throw r2
            L_0x0026:
                rx.Subscriber<? super T> r0 = r1.actual
                rx.internal.operators.NotificationLite.accept(r0, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.subjects.SubjectSubscriptionManager.SubjectObserver.emitNext(java.lang.Object):void");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0013, code lost:
            if (r2 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0015, code lost:
            emitLoop((java.util.List<java.lang.Object>) null, r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void emitFirst(java.lang.Object r2) {
            /*
                r1 = this;
                monitor-enter(r1)
                boolean r0 = r1.first     // Catch:{ all -> 0x001c }
                if (r0 == 0) goto L_0x001a
                boolean r0 = r1.emitting     // Catch:{ all -> 0x001c }
                if (r0 == 0) goto L_0x000a
                goto L_0x001a
            L_0x000a:
                r0 = 0
                r1.first = r0     // Catch:{ all -> 0x001c }
                if (r2 == 0) goto L_0x0010
                r0 = 1
            L_0x0010:
                r1.emitting = r0     // Catch:{ all -> 0x001c }
                monitor-exit(r1)     // Catch:{ all -> 0x001c }
                if (r2 == 0) goto L_0x0019
                r0 = 0
                r1.emitLoop(r0, r2)
            L_0x0019:
                return
            L_0x001a:
                monitor-exit(r1)     // Catch:{ all -> 0x001c }
                return
            L_0x001c:
                r2 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x001c }
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.subjects.SubjectSubscriptionManager.SubjectObserver.emitFirst(java.lang.Object):void");
        }

        /* access modifiers changed from: package-private */
        public void emitLoop(List<Object> list, Object obj) {
            boolean z = true;
            boolean z2 = true;
            while (true) {
                if (list != null) {
                    try {
                        for (Object accept : list) {
                            accept(accept);
                        }
                    } catch (Throwable th) {
                        th = th;
                        z = false;
                        if (!z) {
                            synchronized (this) {
                                this.emitting = false;
                            }
                        }
                        throw th;
                    }
                }
                if (z2) {
                    accept(obj);
                    z2 = false;
                }
                synchronized (this) {
                    try {
                        list = this.queue;
                        this.queue = null;
                        if (list == null) {
                            this.emitting = false;
                            try {
                                return;
                            } catch (Throwable th2) {
                                th = th2;
                                try {
                                    throw th;
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        z = false;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void accept(Object obj) {
            if (obj != null) {
                NotificationLite.accept(this.actual, obj);
            }
        }

        /* access modifiers changed from: package-private */
        public Observer<? super T> getActual() {
            return this.actual;
        }

        public <I> I index() {
            return this.index;
        }

        public void index(Object obj) {
            this.index = obj;
        }
    }
}
