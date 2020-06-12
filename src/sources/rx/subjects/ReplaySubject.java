package rx.subjects;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.internal.operators.BackpressureUtils;
import rx.plugins.RxJavaHooks;
import rx.schedulers.Schedulers;

public final class ReplaySubject<T> extends Subject<T, T> {
    private static final Object[] EMPTY_ARRAY = new Object[0];
    final ReplayState<T> state;

    interface ReplayBuffer<T> {
        void complete();

        void drain(ReplayProducer<T> replayProducer);

        Throwable error();

        void error(Throwable th);

        boolean isComplete();

        boolean isEmpty();

        T last();

        void next(T t);

        int size();

        T[] toArray(T[] tArr);
    }

    public static <T> ReplaySubject<T> create() {
        return create(16);
    }

    public static <T> ReplaySubject<T> create(int i) {
        if (i > 0) {
            return new ReplaySubject<>(new ReplayState(new ReplayUnboundedBuffer(i)));
        }
        throw new IllegalArgumentException("capacity > 0 required but it was " + i);
    }

    static <T> ReplaySubject<T> createUnbounded() {
        return new ReplaySubject<>(new ReplayState(new ReplaySizeBoundBuffer(Integer.MAX_VALUE)));
    }

    static <T> ReplaySubject<T> createUnboundedTime() {
        return new ReplaySubject<>(new ReplayState(new ReplaySizeAndTimeBoundBuffer(Integer.MAX_VALUE, LongCompanionObject.MAX_VALUE, Schedulers.immediate())));
    }

    public static <T> ReplaySubject<T> createWithSize(int i) {
        return new ReplaySubject<>(new ReplayState(new ReplaySizeBoundBuffer(i)));
    }

    public static <T> ReplaySubject<T> createWithTime(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return createWithTimeAndSize(j, timeUnit, Integer.MAX_VALUE, scheduler);
    }

    public static <T> ReplaySubject<T> createWithTimeAndSize(long j, TimeUnit timeUnit, int i, Scheduler scheduler) {
        return new ReplaySubject<>(new ReplayState(new ReplaySizeAndTimeBoundBuffer(i, timeUnit.toMillis(j), scheduler)));
    }

    ReplaySubject(ReplayState<T> replayState) {
        super(replayState);
        this.state = replayState;
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

    /* access modifiers changed from: package-private */
    public int subscriberCount() {
        return ((ReplayProducer[]) this.state.get()).length;
    }

    public boolean hasObservers() {
        return ((ReplayProducer[]) this.state.get()).length != 0;
    }

    public boolean hasThrowable() {
        return this.state.isTerminated() && this.state.buffer.error() != null;
    }

    public boolean hasCompleted() {
        return this.state.isTerminated() && this.state.buffer.error() == null;
    }

    public Throwable getThrowable() {
        if (this.state.isTerminated()) {
            return this.state.buffer.error();
        }
        return null;
    }

    public int size() {
        return this.state.buffer.size();
    }

    public boolean hasAnyValue() {
        return !this.state.buffer.isEmpty();
    }

    public boolean hasValue() {
        return hasAnyValue();
    }

    public T[] getValues(T[] tArr) {
        return this.state.buffer.toArray(tArr);
    }

    public Object[] getValues() {
        Object[] values = getValues(EMPTY_ARRAY);
        return values == EMPTY_ARRAY ? new Object[0] : values;
    }

    public T getValue() {
        return this.state.buffer.last();
    }

    static final class ReplayState<T> extends AtomicReference<ReplayProducer<T>[]> implements Observable.OnSubscribe<T>, Observer<T> {
        static final ReplayProducer[] EMPTY = new ReplayProducer[0];
        static final ReplayProducer[] TERMINATED = new ReplayProducer[0];
        private static final long serialVersionUID = 5952362471246910544L;
        final ReplayBuffer<T> buffer;

        public ReplayState(ReplayBuffer<T> replayBuffer) {
            this.buffer = replayBuffer;
            lazySet(EMPTY);
        }

        public void call(Subscriber<? super T> subscriber) {
            ReplayProducer replayProducer = new ReplayProducer(subscriber, this);
            subscriber.add(replayProducer);
            subscriber.setProducer(replayProducer);
            if (!add(replayProducer) || !replayProducer.isUnsubscribed()) {
                this.buffer.drain(replayProducer);
            } else {
                remove(replayProducer);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean add(ReplayProducer<T> replayProducer) {
            ReplayProducer[] replayProducerArr;
            ReplayProducer[] replayProducerArr2;
            do {
                replayProducerArr = (ReplayProducer[]) get();
                if (replayProducerArr == TERMINATED) {
                    return false;
                }
                int length = replayProducerArr.length;
                replayProducerArr2 = new ReplayProducer[(length + 1)];
                System.arraycopy(replayProducerArr, 0, replayProducerArr2, 0, length);
                replayProducerArr2[length] = replayProducer;
            } while (!compareAndSet(replayProducerArr, replayProducerArr2));
            return true;
        }

        /* access modifiers changed from: package-private */
        public void remove(ReplayProducer<T> replayProducer) {
            ReplayProducer<T>[] replayProducerArr;
            ReplayProducer[] replayProducerArr2;
            do {
                replayProducerArr = (ReplayProducer[]) get();
                if (replayProducerArr != TERMINATED && replayProducerArr != EMPTY) {
                    int length = replayProducerArr.length;
                    int i = -1;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (replayProducerArr[i2] == replayProducer) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            replayProducerArr2 = EMPTY;
                        } else {
                            ReplayProducer[] replayProducerArr3 = new ReplayProducer[(length - 1)];
                            System.arraycopy(replayProducerArr, 0, replayProducerArr3, 0, i);
                            System.arraycopy(replayProducerArr, i + 1, replayProducerArr3, i, (length - i) - 1);
                            replayProducerArr2 = replayProducerArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!compareAndSet(replayProducerArr, replayProducerArr2));
        }

        public void onNext(T t) {
            ReplayBuffer<T> replayBuffer = this.buffer;
            replayBuffer.next(t);
            for (ReplayProducer drain : (ReplayProducer[]) get()) {
                replayBuffer.drain(drain);
            }
        }

        public void onError(Throwable th) {
            ReplayBuffer<T> replayBuffer = this.buffer;
            replayBuffer.error(th);
            ArrayList arrayList = null;
            for (ReplayProducer drain : (ReplayProducer[]) getAndSet(TERMINATED)) {
                try {
                    replayBuffer.drain(drain);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            Exceptions.throwIfAny(arrayList);
        }

        public void onCompleted() {
            ReplayBuffer<T> replayBuffer = this.buffer;
            replayBuffer.complete();
            for (ReplayProducer drain : (ReplayProducer[]) getAndSet(TERMINATED)) {
                replayBuffer.drain(drain);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean isTerminated() {
            return get() == TERMINATED;
        }
    }

    static final class ReplayUnboundedBuffer<T> implements ReplayBuffer<T> {
        final int capacity;
        volatile boolean done;
        Throwable error;
        final Object[] head;
        volatile int size;
        Object[] tail;
        int tailIndex;

        public ReplayUnboundedBuffer(int i) {
            this.capacity = i;
            Object[] objArr = new Object[(i + 1)];
            this.head = objArr;
            this.tail = objArr;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: T[]} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void next(T r6) {
            /*
                r5 = this;
                boolean r0 = r5.done
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                int r0 = r5.tailIndex
                java.lang.Object[] r1 = r5.tail
                int r2 = r1.length
                r3 = 1
                int r2 = r2 - r3
                if (r0 != r2) goto L_0x001b
                int r2 = r1.length
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r4 = 0
                r2[r4] = r6
                r5.tailIndex = r3
                r1[r0] = r2
                r5.tail = r2
                goto L_0x0020
            L_0x001b:
                r1[r0] = r6
                int r0 = r0 + r3
                r5.tailIndex = r0
            L_0x0020:
                int r6 = r5.size
                int r6 = r6 + r3
                r5.size = r6
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.subjects.ReplaySubject.ReplayUnboundedBuffer.next(java.lang.Object):void");
        }

        public void error(Throwable th) {
            if (this.done) {
                RxJavaHooks.onError(th);
                return;
            }
            this.error = th;
            this.done = true;
        }

        public void complete() {
            this.done = true;
        }

        public void drain(ReplayProducer<T> replayProducer) {
            int i;
            ReplayProducer<T> replayProducer2 = replayProducer;
            if (replayProducer.getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = replayProducer2.actual;
                int i2 = this.capacity;
                int i3 = 1;
                do {
                    long j = replayProducer2.requested.get();
                    Object[] objArr = (Object[]) replayProducer2.node;
                    if (objArr == null) {
                        objArr = this.head;
                    }
                    int i4 = replayProducer2.tailIndex;
                    int i5 = replayProducer2.index;
                    long j2 = 0;
                    while (true) {
                        i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                        if (i == 0) {
                            break;
                        } else if (subscriber.isUnsubscribed()) {
                            replayProducer2.node = null;
                            return;
                        } else {
                            boolean z = this.done;
                            boolean z2 = i5 == this.size;
                            if (z && z2) {
                                replayProducer2.node = null;
                                Throwable th = this.error;
                                if (th != null) {
                                    subscriber.onError(th);
                                    return;
                                } else {
                                    subscriber.onCompleted();
                                    return;
                                }
                            } else if (z2) {
                                break;
                            } else {
                                if (i4 == i2) {
                                    objArr = (Object[]) objArr[i4];
                                    i4 = 0;
                                }
                                subscriber.onNext(objArr[i4]);
                                j2++;
                                i4++;
                                i5++;
                            }
                        }
                    }
                    if (i == 0) {
                        if (subscriber.isUnsubscribed()) {
                            replayProducer2.node = null;
                            return;
                        }
                        boolean z3 = this.done;
                        boolean z4 = i5 == this.size;
                        if (z3 && z4) {
                            replayProducer2.node = null;
                            Throwable th2 = this.error;
                            if (th2 != null) {
                                subscriber.onError(th2);
                                return;
                            } else {
                                subscriber.onCompleted();
                                return;
                            }
                        }
                    }
                    if (!(j2 == 0 || j == LongCompanionObject.MAX_VALUE)) {
                        BackpressureUtils.produced(replayProducer2.requested, j2);
                    }
                    replayProducer2.index = i5;
                    replayProducer2.tailIndex = i4;
                    replayProducer2.node = objArr;
                    i3 = replayProducer2.addAndGet(-i3);
                } while (i3 != 0);
            }
        }

        public boolean isComplete() {
            return this.done;
        }

        public Throwable error() {
            return this.error;
        }

        public T last() {
            int i = this.size;
            if (i == 0) {
                return null;
            }
            T[] tArr = this.head;
            int i2 = this.capacity;
            while (i >= i2) {
                tArr = (Object[]) tArr[i2];
                i -= i2;
            }
            return tArr[i - 1];
        }

        public int size() {
            return this.size;
        }

        public boolean isEmpty() {
            return this.size == 0;
        }

        public T[] toArray(T[] tArr) {
            int i = this.size;
            if (tArr.length < i) {
                tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i);
            }
            Object[] objArr = this.head;
            int i2 = this.capacity;
            int i3 = 0;
            while (true) {
                int i4 = i3 + i2;
                if (i4 >= i) {
                    break;
                }
                System.arraycopy(objArr, 0, tArr, i3, i2);
                objArr = objArr[i2];
                i3 = i4;
            }
            System.arraycopy(objArr, 0, tArr, i3, i - i3);
            if (tArr.length > i) {
                tArr[i] = null;
            }
            return tArr;
        }
    }

    static final class ReplaySizeBoundBuffer<T> implements ReplayBuffer<T> {
        volatile boolean done;
        Throwable error;
        volatile Node<T> head;
        final int limit;
        int size;
        Node<T> tail;

        public ReplaySizeBoundBuffer(int i) {
            this.limit = i;
            Node<T> node = new Node<>(null);
            this.tail = node;
            this.head = node;
        }

        public void next(T t) {
            Node<T> node = new Node<>(t);
            this.tail.set(node);
            this.tail = node;
            int i = this.size;
            if (i == this.limit) {
                this.head = (Node) this.head.get();
            } else {
                this.size = i + 1;
            }
        }

        public void error(Throwable th) {
            this.error = th;
            this.done = true;
        }

        public void complete() {
            this.done = true;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v0, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: rx.subjects.ReplaySubject$ReplaySizeBoundBuffer$Node<T>} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void drain(rx.subjects.ReplaySubject.ReplayProducer<T> r18) {
            /*
                r17 = this;
                r0 = r17
                r1 = r18
                int r2 = r18.getAndIncrement()
                if (r2 == 0) goto L_0x000b
                return
            L_0x000b:
                rx.Subscriber<? super T> r2 = r1.actual
                r4 = 1
            L_0x000e:
                java.util.concurrent.atomic.AtomicLong r5 = r1.requested
                long r5 = r5.get()
                java.lang.Object r7 = r1.node
                rx.subjects.ReplaySubject$ReplaySizeBoundBuffer$Node r7 = (rx.subjects.ReplaySubject.ReplaySizeBoundBuffer.Node) r7
                r8 = 0
                if (r7 != 0) goto L_0x001e
                rx.subjects.ReplaySubject$ReplaySizeBoundBuffer$Node<T> r7 = r0.head
            L_0x001e:
                r10 = r8
            L_0x001f:
                r12 = 0
                r13 = 0
                int r14 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
                if (r14 == 0) goto L_0x005e
                boolean r15 = r2.isUnsubscribed()
                if (r15 == 0) goto L_0x002e
                r1.node = r13
                return
            L_0x002e:
                boolean r15 = r0.done
                java.lang.Object r16 = r7.get()
                r3 = r16
                rx.subjects.ReplaySubject$ReplaySizeBoundBuffer$Node r3 = (rx.subjects.ReplaySubject.ReplaySizeBoundBuffer.Node) r3
                if (r3 != 0) goto L_0x003d
                r16 = 1
                goto L_0x003f
            L_0x003d:
                r16 = 0
            L_0x003f:
                if (r15 == 0) goto L_0x0051
                if (r16 == 0) goto L_0x0051
                r1.node = r13
                java.lang.Throwable r1 = r0.error
                if (r1 == 0) goto L_0x004d
                r2.onError(r1)
                goto L_0x0050
            L_0x004d:
                r2.onCompleted()
            L_0x0050:
                return
            L_0x0051:
                if (r16 == 0) goto L_0x0054
                goto L_0x005e
            L_0x0054:
                T r7 = r3.value
                r2.onNext(r7)
                r12 = 1
                long r10 = r10 + r12
                r7 = r3
                goto L_0x001f
            L_0x005e:
                if (r14 != 0) goto L_0x0084
                boolean r3 = r2.isUnsubscribed()
                if (r3 == 0) goto L_0x0069
                r1.node = r13
                return
            L_0x0069:
                boolean r3 = r0.done
                java.lang.Object r14 = r7.get()
                if (r14 != 0) goto L_0x0072
                r12 = 1
            L_0x0072:
                if (r3 == 0) goto L_0x0084
                if (r12 == 0) goto L_0x0084
                r1.node = r13
                java.lang.Throwable r1 = r0.error
                if (r1 == 0) goto L_0x0080
                r2.onError(r1)
                goto L_0x0083
            L_0x0080:
                r2.onCompleted()
            L_0x0083:
                return
            L_0x0084:
                int r3 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
                if (r3 == 0) goto L_0x0096
                r8 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r3 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
                if (r3 == 0) goto L_0x0096
                java.util.concurrent.atomic.AtomicLong r3 = r1.requested
                rx.internal.operators.BackpressureUtils.produced(r3, r10)
            L_0x0096:
                r1.node = r7
                int r3 = -r4
                int r4 = r1.addAndGet(r3)
                if (r4 != 0) goto L_0x000e
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.subjects.ReplaySubject.ReplaySizeBoundBuffer.drain(rx.subjects.ReplaySubject$ReplayProducer):void");
        }

        static final class Node<T> extends AtomicReference<Node<T>> {
            private static final long serialVersionUID = 3713592843205853725L;
            final T value;

            public Node(T t) {
                this.value = t;
            }
        }

        public boolean isComplete() {
            return this.done;
        }

        public Throwable error() {
            return this.error;
        }

        public T last() {
            Node<T> node = this.head;
            while (true) {
                Node<T> node2 = (Node) node.get();
                if (node2 == null) {
                    return node.value;
                }
                node = node2;
            }
        }

        public int size() {
            Node node = (Node) this.head.get();
            int i = 0;
            while (node != null && i != Integer.MAX_VALUE) {
                node = (Node) node.get();
                i++;
            }
            return i;
        }

        public boolean isEmpty() {
            return this.head.get() == null;
        }

        public T[] toArray(T[] tArr) {
            ArrayList arrayList = new ArrayList();
            for (Node node = (Node) this.head.get(); node != null; node = (Node) node.get()) {
                arrayList.add(node.value);
            }
            return arrayList.toArray(tArr);
        }
    }

    static final class ReplaySizeAndTimeBoundBuffer<T> implements ReplayBuffer<T> {
        volatile boolean done;
        Throwable error;
        volatile TimedNode<T> head;
        final int limit;
        final long maxAgeMillis;
        final Scheduler scheduler;
        int size;
        TimedNode<T> tail;

        public ReplaySizeAndTimeBoundBuffer(int i, long j, Scheduler scheduler2) {
            this.limit = i;
            TimedNode<T> timedNode = new TimedNode<>(null, 0);
            this.tail = timedNode;
            this.head = timedNode;
            this.maxAgeMillis = j;
            this.scheduler = scheduler2;
        }

        public void next(T t) {
            TimedNode<T> timedNode;
            long now = this.scheduler.now();
            TimedNode<T> timedNode2 = new TimedNode<>(t, now);
            this.tail.set(timedNode2);
            this.tail = timedNode2;
            long j = now - this.maxAgeMillis;
            int i = this.size;
            TimedNode<T> timedNode3 = this.head;
            if (i == this.limit) {
                timedNode = (TimedNode) timedNode3.get();
            } else {
                i++;
                timedNode = timedNode3;
            }
            while (true) {
                TimedNode<T> timedNode4 = (TimedNode) timedNode.get();
                if (timedNode4 == null || timedNode4.timestamp > j) {
                    this.size = i;
                } else {
                    i--;
                    timedNode = timedNode4;
                }
            }
            this.size = i;
            if (timedNode != timedNode3) {
                this.head = timedNode;
            }
        }

        public void error(Throwable th) {
            evictFinal();
            this.error = th;
            this.done = true;
        }

        public void complete() {
            evictFinal();
            this.done = true;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:7:0x001f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void evictFinal() {
            /*
                r8 = this;
                rx.Scheduler r0 = r8.scheduler
                long r0 = r0.now()
                long r2 = r8.maxAgeMillis
                long r0 = r0 - r2
                rx.subjects.ReplaySubject$ReplaySizeAndTimeBoundBuffer$TimedNode<T> r2 = r8.head
                r3 = r2
            L_0x000c:
                java.lang.Object r4 = r3.get()
                rx.subjects.ReplaySubject$ReplaySizeAndTimeBoundBuffer$TimedNode r4 = (rx.subjects.ReplaySubject.ReplaySizeAndTimeBoundBuffer.TimedNode) r4
                if (r4 == 0) goto L_0x001d
                long r5 = r4.timestamp
                int r7 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
                if (r7 <= 0) goto L_0x001b
                goto L_0x001d
            L_0x001b:
                r3 = r4
                goto L_0x000c
            L_0x001d:
                if (r2 == r3) goto L_0x0021
                r8.head = r3
            L_0x0021:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.subjects.ReplaySubject.ReplaySizeAndTimeBoundBuffer.evictFinal():void");
        }

        /* access modifiers changed from: package-private */
        public TimedNode<T> latestHead() {
            long now = this.scheduler.now() - this.maxAgeMillis;
            TimedNode<T> timedNode = this.head;
            while (true) {
                TimedNode<T> timedNode2 = (TimedNode) timedNode.get();
                if (timedNode2 == null || timedNode2.timestamp > now) {
                    return timedNode;
                }
                timedNode = timedNode2;
            }
            return timedNode;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v0, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: rx.subjects.ReplaySubject$ReplaySizeAndTimeBoundBuffer$TimedNode} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void drain(rx.subjects.ReplaySubject.ReplayProducer<T> r18) {
            /*
                r17 = this;
                r0 = r17
                r1 = r18
                int r2 = r18.getAndIncrement()
                if (r2 == 0) goto L_0x000b
                return
            L_0x000b:
                rx.Subscriber<? super T> r2 = r1.actual
                r4 = 1
            L_0x000e:
                java.util.concurrent.atomic.AtomicLong r5 = r1.requested
                long r5 = r5.get()
                java.lang.Object r7 = r1.node
                rx.subjects.ReplaySubject$ReplaySizeAndTimeBoundBuffer$TimedNode r7 = (rx.subjects.ReplaySubject.ReplaySizeAndTimeBoundBuffer.TimedNode) r7
                r8 = 0
                if (r7 != 0) goto L_0x0020
                rx.subjects.ReplaySubject$ReplaySizeAndTimeBoundBuffer$TimedNode r7 = r17.latestHead()
            L_0x0020:
                r10 = r8
            L_0x0021:
                r12 = 0
                r13 = 0
                int r14 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
                if (r14 == 0) goto L_0x0060
                boolean r15 = r2.isUnsubscribed()
                if (r15 == 0) goto L_0x0030
                r1.node = r13
                return
            L_0x0030:
                boolean r15 = r0.done
                java.lang.Object r16 = r7.get()
                r3 = r16
                rx.subjects.ReplaySubject$ReplaySizeAndTimeBoundBuffer$TimedNode r3 = (rx.subjects.ReplaySubject.ReplaySizeAndTimeBoundBuffer.TimedNode) r3
                if (r3 != 0) goto L_0x003f
                r16 = 1
                goto L_0x0041
            L_0x003f:
                r16 = 0
            L_0x0041:
                if (r15 == 0) goto L_0x0053
                if (r16 == 0) goto L_0x0053
                r1.node = r13
                java.lang.Throwable r1 = r0.error
                if (r1 == 0) goto L_0x004f
                r2.onError(r1)
                goto L_0x0052
            L_0x004f:
                r2.onCompleted()
            L_0x0052:
                return
            L_0x0053:
                if (r16 == 0) goto L_0x0056
                goto L_0x0060
            L_0x0056:
                T r7 = r3.value
                r2.onNext(r7)
                r12 = 1
                long r10 = r10 + r12
                r7 = r3
                goto L_0x0021
            L_0x0060:
                if (r14 != 0) goto L_0x0086
                boolean r3 = r2.isUnsubscribed()
                if (r3 == 0) goto L_0x006b
                r1.node = r13
                return
            L_0x006b:
                boolean r3 = r0.done
                java.lang.Object r14 = r7.get()
                if (r14 != 0) goto L_0x0074
                r12 = 1
            L_0x0074:
                if (r3 == 0) goto L_0x0086
                if (r12 == 0) goto L_0x0086
                r1.node = r13
                java.lang.Throwable r1 = r0.error
                if (r1 == 0) goto L_0x0082
                r2.onError(r1)
                goto L_0x0085
            L_0x0082:
                r2.onCompleted()
            L_0x0085:
                return
            L_0x0086:
                int r3 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
                if (r3 == 0) goto L_0x0098
                r8 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r3 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
                if (r3 == 0) goto L_0x0098
                java.util.concurrent.atomic.AtomicLong r3 = r1.requested
                rx.internal.operators.BackpressureUtils.produced(r3, r10)
            L_0x0098:
                r1.node = r7
                int r3 = -r4
                int r4 = r1.addAndGet(r3)
                if (r4 != 0) goto L_0x000e
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.subjects.ReplaySubject.ReplaySizeAndTimeBoundBuffer.drain(rx.subjects.ReplaySubject$ReplayProducer):void");
        }

        static final class TimedNode<T> extends AtomicReference<TimedNode<T>> {
            private static final long serialVersionUID = 3713592843205853725L;
            final long timestamp;
            final T value;

            public TimedNode(T t, long j) {
                this.value = t;
                this.timestamp = j;
            }
        }

        public boolean isComplete() {
            return this.done;
        }

        public Throwable error() {
            return this.error;
        }

        public T last() {
            TimedNode latestHead = latestHead();
            while (true) {
                TimedNode timedNode = (TimedNode) latestHead.get();
                if (timedNode == null) {
                    return latestHead.value;
                }
                latestHead = timedNode;
            }
        }

        public int size() {
            TimedNode timedNode = (TimedNode) latestHead().get();
            int i = 0;
            while (timedNode != null && i != Integer.MAX_VALUE) {
                timedNode = (TimedNode) timedNode.get();
                i++;
            }
            return i;
        }

        public boolean isEmpty() {
            return latestHead().get() == null;
        }

        public T[] toArray(T[] tArr) {
            ArrayList arrayList = new ArrayList();
            for (TimedNode timedNode = (TimedNode) latestHead().get(); timedNode != null; timedNode = (TimedNode) timedNode.get()) {
                arrayList.add(timedNode.value);
            }
            return arrayList.toArray(tArr);
        }
    }

    static final class ReplayProducer<T> extends AtomicInteger implements Producer, Subscription {
        private static final long serialVersionUID = -5006209596735204567L;
        final Subscriber<? super T> actual;
        int index;
        Object node;
        final AtomicLong requested = new AtomicLong();
        final ReplayState<T> state;
        int tailIndex;

        public ReplayProducer(Subscriber<? super T> subscriber, ReplayState<T> replayState) {
            this.actual = subscriber;
            this.state = replayState;
        }

        public void unsubscribe() {
            this.state.remove(this);
        }

        public boolean isUnsubscribed() {
            return this.actual.isUnsubscribed();
        }

        public void request(long j) {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i > 0) {
                BackpressureUtils.getAndAddRequest(this.requested, j);
                this.state.buffer.drain(this);
            } else if (i < 0) {
                throw new IllegalArgumentException("n >= required but it was " + j);
            }
        }
    }
}
