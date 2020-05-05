package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.CompositeException;
import rx.exceptions.MissingBackpressureException;
import rx.exceptions.OnErrorThrowable;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.atomic.SpscExactAtomicArrayQueue;
import rx.internal.util.atomic.SpscUnboundedAtomicArrayQueue;
import rx.internal.util.unsafe.Pow2;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.subscriptions.CompositeSubscription;

public final class OperatorMerge<T> implements Observable.Operator<T, Observable<? extends T>> {
    final boolean delayErrors;
    final int maxConcurrent;

    static final class HolderNoDelay {
        static final OperatorMerge<Object> INSTANCE = new OperatorMerge<>(false, Integer.MAX_VALUE);

        HolderNoDelay() {
        }
    }

    static final class HolderDelayErrors {
        static final OperatorMerge<Object> INSTANCE = new OperatorMerge<>(true, Integer.MAX_VALUE);

        HolderDelayErrors() {
        }
    }

    public static <T> OperatorMerge<T> instance(boolean z) {
        if (z) {
            return HolderDelayErrors.INSTANCE;
        }
        return HolderNoDelay.INSTANCE;
    }

    public static <T> OperatorMerge<T> instance(boolean z, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxConcurrent > 0 required but it was " + i);
        } else if (i == Integer.MAX_VALUE) {
            return instance(z);
        } else {
            return new OperatorMerge<>(z, i);
        }
    }

    OperatorMerge(boolean z, int i) {
        this.delayErrors = z;
        this.maxConcurrent = i;
    }

    public Subscriber<Observable<? extends T>> call(Subscriber<? super T> subscriber) {
        MergeSubscriber mergeSubscriber = new MergeSubscriber(subscriber, this.delayErrors, this.maxConcurrent);
        MergeProducer<T> mergeProducer = new MergeProducer<>(mergeSubscriber);
        mergeSubscriber.producer = mergeProducer;
        subscriber.add(mergeSubscriber);
        subscriber.setProducer(mergeProducer);
        return mergeSubscriber;
    }

    static final class MergeProducer<T> extends AtomicLong implements Producer {
        private static final long serialVersionUID = -1214379189873595503L;
        final MergeSubscriber<T> subscriber;

        public MergeProducer(MergeSubscriber<T> mergeSubscriber) {
            this.subscriber = mergeSubscriber;
        }

        public void request(long j) {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i > 0) {
                if (get() != LongCompanionObject.MAX_VALUE) {
                    BackpressureUtils.getAndAddRequest(this, j);
                    this.subscriber.emit();
                }
            } else if (i < 0) {
                throw new IllegalArgumentException("n >= 0 required");
            }
        }

        public long produced(int i) {
            return addAndGet((long) (-i));
        }
    }

    static final class MergeSubscriber<T> extends Subscriber<Observable<? extends T>> {
        static final InnerSubscriber<?>[] EMPTY = new InnerSubscriber[0];
        final Subscriber<? super T> child;
        final boolean delayErrors;
        volatile boolean done;
        boolean emitting;
        volatile ConcurrentLinkedQueue<Throwable> errors;
        final Object innerGuard = new Object();
        volatile InnerSubscriber<?>[] innerSubscribers = EMPTY;
        long lastId;
        int lastIndex;
        final int maxConcurrent;
        boolean missed;
        MergeProducer<T> producer;
        volatile Queue<Object> queue;
        int scalarEmissionCount;
        final int scalarEmissionLimit;
        volatile CompositeSubscription subscriptions;
        long uniqueId;

        public MergeSubscriber(Subscriber<? super T> subscriber, boolean z, int i) {
            this.child = subscriber;
            this.delayErrors = z;
            this.maxConcurrent = i;
            if (i == Integer.MAX_VALUE) {
                this.scalarEmissionLimit = Integer.MAX_VALUE;
                request(LongCompanionObject.MAX_VALUE);
                return;
            }
            this.scalarEmissionLimit = Math.max(1, i >> 1);
            request((long) i);
        }

        /* access modifiers changed from: package-private */
        public Queue<Throwable> getOrCreateErrorQueue() {
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.errors;
            if (concurrentLinkedQueue == null) {
                synchronized (this) {
                    concurrentLinkedQueue = this.errors;
                    if (concurrentLinkedQueue == null) {
                        concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                        this.errors = concurrentLinkedQueue;
                    }
                }
            }
            return concurrentLinkedQueue;
        }

        /* access modifiers changed from: package-private */
        public CompositeSubscription getOrCreateComposite() {
            CompositeSubscription compositeSubscription;
            CompositeSubscription compositeSubscription2 = this.subscriptions;
            if (compositeSubscription2 != null) {
                return compositeSubscription2;
            }
            boolean z = false;
            synchronized (this) {
                compositeSubscription = this.subscriptions;
                if (compositeSubscription == null) {
                    CompositeSubscription compositeSubscription3 = new CompositeSubscription();
                    this.subscriptions = compositeSubscription3;
                    compositeSubscription = compositeSubscription3;
                    z = true;
                }
            }
            if (z) {
                add(compositeSubscription);
            }
            return compositeSubscription;
        }

        public void onNext(Observable<? extends T> observable) {
            if (observable != null) {
                if (observable == Observable.empty()) {
                    emitEmpty();
                } else if (observable instanceof ScalarSynchronousObservable) {
                    tryEmit(((ScalarSynchronousObservable) observable).get());
                } else {
                    long j = this.uniqueId;
                    this.uniqueId = 1 + j;
                    InnerSubscriber innerSubscriber = new InnerSubscriber(this, j);
                    addInner(innerSubscriber);
                    observable.unsafeSubscribe(innerSubscriber);
                    emit();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void emitEmpty() {
            int i = this.scalarEmissionCount + 1;
            if (i == this.scalarEmissionLimit) {
                this.scalarEmissionCount = 0;
                requestMore((long) i);
                return;
            }
            this.scalarEmissionCount = i;
        }

        private void reportError() {
            ArrayList arrayList = new ArrayList(this.errors);
            if (arrayList.size() == 1) {
                this.child.onError((Throwable) arrayList.get(0));
            } else {
                this.child.onError(new CompositeException((Collection<? extends Throwable>) arrayList));
            }
        }

        public void onError(Throwable th) {
            getOrCreateErrorQueue().offer(th);
            this.done = true;
            emit();
        }

        public void onCompleted() {
            this.done = true;
            emit();
        }

        /* access modifiers changed from: package-private */
        public void addInner(InnerSubscriber<T> innerSubscriber) {
            getOrCreateComposite().add(innerSubscriber);
            synchronized (this.innerGuard) {
                InnerSubscriber<?>[] innerSubscriberArr = this.innerSubscribers;
                int length = innerSubscriberArr.length;
                InnerSubscriber<?>[] innerSubscriberArr2 = new InnerSubscriber[(length + 1)];
                System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, length);
                innerSubscriberArr2[length] = innerSubscriber;
                this.innerSubscribers = innerSubscriberArr2;
            }
        }

        /* access modifiers changed from: package-private */
        public void removeInner(InnerSubscriber<T> innerSubscriber) {
            RxRingBuffer rxRingBuffer = innerSubscriber.queue;
            if (rxRingBuffer != null) {
                rxRingBuffer.release();
            }
            this.subscriptions.remove(innerSubscriber);
            synchronized (this.innerGuard) {
                InnerSubscriber<?>[] innerSubscriberArr = this.innerSubscribers;
                int length = innerSubscriberArr.length;
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (innerSubscriber.equals(innerSubscriberArr[i2])) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        this.innerSubscribers = EMPTY;
                        return;
                    }
                    InnerSubscriber<?>[] innerSubscriberArr2 = new InnerSubscriber[(length - 1)];
                    System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, i);
                    System.arraycopy(innerSubscriberArr, i + 1, innerSubscriberArr2, i, (length - i) - 1);
                    this.innerSubscribers = innerSubscriberArr2;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void tryEmit(InnerSubscriber<T> innerSubscriber, T t) {
            long j = this.producer.get();
            boolean z = false;
            if (j != 0) {
                synchronized (this) {
                    j = this.producer.get();
                    if (!this.emitting && j != 0) {
                        this.emitting = true;
                        z = true;
                    }
                }
            }
            if (z) {
                RxRingBuffer rxRingBuffer = innerSubscriber.queue;
                if (rxRingBuffer == null || rxRingBuffer.isEmpty()) {
                    emitScalar(innerSubscriber, t, j);
                    return;
                }
                queueScalar(innerSubscriber, t);
                emitLoop();
                return;
            }
            queueScalar(innerSubscriber, t);
            emit();
        }

        /* access modifiers changed from: protected */
        public void queueScalar(InnerSubscriber<T> innerSubscriber, T t) {
            RxRingBuffer rxRingBuffer = innerSubscriber.queue;
            if (rxRingBuffer == null) {
                rxRingBuffer = RxRingBuffer.getSpscInstance();
                innerSubscriber.add(rxRingBuffer);
                innerSubscriber.queue = rxRingBuffer;
            }
            try {
                rxRingBuffer.onNext(NotificationLite.next(t));
            } catch (MissingBackpressureException e) {
                innerSubscriber.unsubscribe();
                innerSubscriber.onError(e);
            } catch (IllegalStateException e2) {
                if (!innerSubscriber.isUnsubscribed()) {
                    innerSubscriber.unsubscribe();
                    innerSubscriber.onError(e2);
                }
            }
        }

        /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Unknown Source)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Unknown Source)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Unknown Source)
            	at java.base/java.util.Objects.checkIndex(Unknown Source)
            	at java.base/java.util.ArrayList.get(Unknown Source)
            	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processHandlersOutBlocks(RegionMaker.java:1008)
            	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:978)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
            */
        protected void emitScalar(rx.internal.operators.OperatorMerge.InnerSubscriber<T> r5, T r6, long r7) {
            /*
                r4 = this;
                r0 = 1
                r1 = 0
                rx.Subscriber<? super T> r2 = r4.child     // Catch:{ all -> 0x0008 }
                r2.onNext(r6)     // Catch:{ all -> 0x0008 }
                goto L_0x0020
            L_0x0008:
                r6 = move-exception
                boolean r2 = r4.delayErrors     // Catch:{ all -> 0x0046 }
                if (r2 != 0) goto L_0x0019
                rx.exceptions.Exceptions.throwIfFatal(r6)     // Catch:{ all -> 0x0046 }
                r5.unsubscribe()     // Catch:{ all -> 0x0017 }
                r5.onError(r6)     // Catch:{ all -> 0x0017 }
                return
            L_0x0017:
                r5 = move-exception
                goto L_0x0048
            L_0x0019:
                java.util.Queue r2 = r4.getOrCreateErrorQueue()     // Catch:{ all -> 0x0046 }
                r2.offer(r6)     // Catch:{ all -> 0x0046 }
            L_0x0020:
                r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r6 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
                if (r6 == 0) goto L_0x002e
                rx.internal.operators.OperatorMerge$MergeProducer<T> r6 = r4.producer     // Catch:{ all -> 0x0046 }
                r6.produced(r0)     // Catch:{ all -> 0x0046 }
            L_0x002e:
                r6 = 1
                r5.requestMore(r6)     // Catch:{ all -> 0x0046 }
                monitor-enter(r4)     // Catch:{ all -> 0x0046 }
                boolean r5 = r4.missed     // Catch:{ all -> 0x0043 }
                if (r5 != 0) goto L_0x003c
                r4.emitting = r1     // Catch:{ all -> 0x0043 }
                monitor-exit(r4)     // Catch:{ all -> 0x0043 }
                return
            L_0x003c:
                r4.missed = r1     // Catch:{ all -> 0x0043 }
                monitor-exit(r4)     // Catch:{ all -> 0x0043 }
                r4.emitLoop()
                return
            L_0x0043:
                r5 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x0043 }
                throw r5     // Catch:{ all -> 0x0017 }
            L_0x0046:
                r5 = move-exception
                r0 = r1
            L_0x0048:
                if (r0 != 0) goto L_0x0052
                monitor-enter(r4)
                r4.emitting = r1     // Catch:{ all -> 0x004f }
                monitor-exit(r4)     // Catch:{ all -> 0x004f }
                goto L_0x0052
            L_0x004f:
                r5 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x004f }
                throw r5
            L_0x0052:
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorMerge.MergeSubscriber.emitScalar(rx.internal.operators.OperatorMerge$InnerSubscriber, java.lang.Object, long):void");
        }

        public void requestMore(long j) {
            request(j);
        }

        /* access modifiers changed from: package-private */
        public void tryEmit(T t) {
            long j = this.producer.get();
            boolean z = false;
            if (j != 0) {
                synchronized (this) {
                    j = this.producer.get();
                    if (!this.emitting && j != 0) {
                        this.emitting = true;
                        z = true;
                    }
                }
            }
            if (z) {
                Queue<Object> queue2 = this.queue;
                if (queue2 == null || queue2.isEmpty()) {
                    emitScalar(t, j);
                    return;
                }
                queueScalar(t);
                emitLoop();
                return;
            }
            queueScalar(t);
            emit();
        }

        /* access modifiers changed from: protected */
        public void queueScalar(T t) {
            Queue<Object> queue2;
            Queue<Object> queue3 = this.queue;
            if (queue3 == null) {
                int i = this.maxConcurrent;
                if (i == Integer.MAX_VALUE) {
                    queue3 = new SpscUnboundedAtomicArrayQueue<>(RxRingBuffer.SIZE);
                } else {
                    if (!Pow2.isPowerOfTwo(i)) {
                        queue2 = new SpscExactAtomicArrayQueue<>(i);
                    } else if (UnsafeAccess.isUnsafeAvailable()) {
                        queue2 = new SpscArrayQueue<>(i);
                    } else {
                        queue2 = new SpscAtomicArrayQueue<>(i);
                    }
                    queue3 = queue2;
                }
                this.queue = queue3;
            }
            if (!queue3.offer(NotificationLite.next(t))) {
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(new MissingBackpressureException(), t));
            }
        }

        /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Unknown Source)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Unknown Source)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Unknown Source)
            	at java.base/java.util.Objects.checkIndex(Unknown Source)
            	at java.base/java.util.ArrayList.get(Unknown Source)
            	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processHandlersOutBlocks(RegionMaker.java:1008)
            	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:978)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
            */
        protected void emitScalar(T r5, long r6) {
            /*
                r4 = this;
                r0 = 1
                r1 = 0
                rx.Subscriber<? super T> r2 = r4.child     // Catch:{ all -> 0x0008 }
                r2.onNext(r5)     // Catch:{ all -> 0x0008 }
                goto L_0x0020
            L_0x0008:
                r5 = move-exception
                boolean r2 = r4.delayErrors     // Catch:{ all -> 0x0051 }
                if (r2 != 0) goto L_0x0019
                rx.exceptions.Exceptions.throwIfFatal(r5)     // Catch:{ all -> 0x0051 }
                r4.unsubscribe()     // Catch:{ all -> 0x0017 }
                r4.onError(r5)     // Catch:{ all -> 0x0017 }
                return
            L_0x0017:
                r5 = move-exception
                goto L_0x0053
            L_0x0019:
                java.util.Queue r2 = r4.getOrCreateErrorQueue()     // Catch:{ all -> 0x0051 }
                r2.offer(r5)     // Catch:{ all -> 0x0051 }
            L_0x0020:
                r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r5 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
                if (r5 == 0) goto L_0x002e
                rx.internal.operators.OperatorMerge$MergeProducer<T> r5 = r4.producer     // Catch:{ all -> 0x0051 }
                r5.produced(r0)     // Catch:{ all -> 0x0051 }
            L_0x002e:
                int r5 = r4.scalarEmissionCount     // Catch:{ all -> 0x0051 }
                int r5 = r5 + r0
                int r6 = r4.scalarEmissionLimit     // Catch:{ all -> 0x0051 }
                if (r5 != r6) goto L_0x003c
                r4.scalarEmissionCount = r1     // Catch:{ all -> 0x0051 }
                long r5 = (long) r5     // Catch:{ all -> 0x0051 }
                r4.requestMore(r5)     // Catch:{ all -> 0x0051 }
                goto L_0x003e
            L_0x003c:
                r4.scalarEmissionCount = r5     // Catch:{ all -> 0x0051 }
            L_0x003e:
                monitor-enter(r4)     // Catch:{ all -> 0x0051 }
                boolean r5 = r4.missed     // Catch:{ all -> 0x004e }
                if (r5 != 0) goto L_0x0047
                r4.emitting = r1     // Catch:{ all -> 0x004e }
                monitor-exit(r4)     // Catch:{ all -> 0x004e }
                return
            L_0x0047:
                r4.missed = r1     // Catch:{ all -> 0x004e }
                monitor-exit(r4)     // Catch:{ all -> 0x004e }
                r4.emitLoop()
                return
            L_0x004e:
                r5 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x004e }
                throw r5     // Catch:{ all -> 0x0017 }
            L_0x0051:
                r5 = move-exception
                r0 = r1
            L_0x0053:
                if (r0 != 0) goto L_0x005d
                monitor-enter(r4)
                r4.emitting = r1     // Catch:{ all -> 0x005a }
                monitor-exit(r4)     // Catch:{ all -> 0x005a }
                goto L_0x005d
            L_0x005a:
                r5 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x005a }
                throw r5
            L_0x005d:
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorMerge.MergeSubscriber.emitScalar(java.lang.Object, long):void");
        }

        /* access modifiers changed from: package-private */
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

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:162:0x0193, code lost:
            r0 = th;
         */
        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* JADX WARNING: Removed duplicated region for block: B:167:0x019b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void emitLoop() {
            /*
                r22 = this;
                r1 = r22
                r3 = 0
                rx.Subscriber<? super T> r4 = r1.child     // Catch:{ all -> 0x0197 }
            L_0x0005:
                boolean r0 = r22.checkTerminate()     // Catch:{ all -> 0x0197 }
                if (r0 == 0) goto L_0x000c
                return
            L_0x000c:
                java.util.Queue<java.lang.Object> r5 = r1.queue     // Catch:{ all -> 0x0197 }
                rx.internal.operators.OperatorMerge$MergeProducer<T> r0 = r1.producer     // Catch:{ all -> 0x0197 }
                long r6 = r0.get()     // Catch:{ all -> 0x0197 }
                r8 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r0 != 0) goto L_0x001f
                r10 = 1
                goto L_0x0020
            L_0x001f:
                r10 = r3
            L_0x0020:
                r11 = 1
                r14 = 0
                if (r5 == 0) goto L_0x0089
                r0 = r3
            L_0x0027:
                r16 = r6
                r6 = r0
                r7 = r3
                r0 = 0
            L_0x002c:
                int r18 = (r16 > r14 ? 1 : (r16 == r14 ? 0 : -1))
                if (r18 <= 0) goto L_0x0071
                java.lang.Object r18 = r5.poll()     // Catch:{ all -> 0x0197 }
                boolean r0 = r22.checkTerminate()     // Catch:{ all -> 0x0197 }
                if (r0 == 0) goto L_0x003b
                return
            L_0x003b:
                if (r18 != 0) goto L_0x0040
                r0 = r18
                goto L_0x0071
            L_0x0040:
                java.lang.Object r0 = rx.internal.operators.NotificationLite.getValue(r18)     // Catch:{ all -> 0x0197 }
                r4.onNext(r0)     // Catch:{ all -> 0x0048 }
                goto L_0x0068
            L_0x0048:
                r0 = move-exception
                r19 = r0
                boolean r0 = r1.delayErrors     // Catch:{ all -> 0x0197 }
                if (r0 != 0) goto L_0x005f
                rx.exceptions.Exceptions.throwIfFatal(r19)     // Catch:{ all -> 0x0197 }
                r22.unsubscribe()     // Catch:{ all -> 0x005b }
                r5 = r19
                r4.onError(r5)     // Catch:{ all -> 0x005b }
                return
            L_0x005b:
                r0 = move-exception
                r2 = 1
                goto L_0x0199
            L_0x005f:
                r2 = r19
                java.util.Queue r0 = r22.getOrCreateErrorQueue()     // Catch:{ all -> 0x0197 }
                r0.offer(r2)     // Catch:{ all -> 0x0197 }
            L_0x0068:
                int r6 = r6 + 1
                int r7 = r7 + 1
                long r16 = r16 - r11
                r0 = r18
                goto L_0x002c
            L_0x0071:
                if (r7 <= 0) goto L_0x007e
                if (r10 == 0) goto L_0x0078
                r16 = r8
                goto L_0x007e
            L_0x0078:
                rx.internal.operators.OperatorMerge$MergeProducer<T> r2 = r1.producer     // Catch:{ all -> 0x0197 }
                long r16 = r2.produced(r7)     // Catch:{ all -> 0x0197 }
            L_0x007e:
                int r2 = (r16 > r14 ? 1 : (r16 == r14 ? 0 : -1))
                if (r2 == 0) goto L_0x008c
                if (r0 != 0) goto L_0x0085
                goto L_0x008c
            L_0x0085:
                r0 = r6
                r6 = r16
                goto L_0x0027
            L_0x0089:
                r16 = r6
                r6 = r3
            L_0x008c:
                boolean r0 = r1.done     // Catch:{ all -> 0x0197 }
                java.util.Queue<java.lang.Object> r2 = r1.queue     // Catch:{ all -> 0x0197 }
                rx.internal.operators.OperatorMerge$InnerSubscriber<?>[] r5 = r1.innerSubscribers     // Catch:{ all -> 0x0197 }
                int r7 = r5.length     // Catch:{ all -> 0x0197 }
                if (r0 == 0) goto L_0x00b2
                if (r2 == 0) goto L_0x009d
                boolean r0 = r2.isEmpty()     // Catch:{ all -> 0x0197 }
                if (r0 == 0) goto L_0x00b2
            L_0x009d:
                if (r7 != 0) goto L_0x00b2
                java.util.concurrent.ConcurrentLinkedQueue<java.lang.Throwable> r0 = r1.errors     // Catch:{ all -> 0x0197 }
                if (r0 == 0) goto L_0x00ae
                boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0197 }
                if (r0 == 0) goto L_0x00aa
                goto L_0x00ae
            L_0x00aa:
                r22.reportError()     // Catch:{ all -> 0x0197 }
                goto L_0x00b1
            L_0x00ae:
                r4.onCompleted()     // Catch:{ all -> 0x0197 }
            L_0x00b1:
                return
            L_0x00b2:
                if (r7 <= 0) goto L_0x0173
                long r8 = r1.lastId     // Catch:{ all -> 0x0197 }
                int r0 = r1.lastIndex     // Catch:{ all -> 0x0197 }
                if (r7 <= r0) goto L_0x00c2
                r2 = r5[r0]     // Catch:{ all -> 0x0197 }
                long r11 = r2.id     // Catch:{ all -> 0x0197 }
                int r2 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
                if (r2 == 0) goto L_0x00e1
            L_0x00c2:
                if (r7 > r0) goto L_0x00c5
                r0 = r3
            L_0x00c5:
                r2 = r3
            L_0x00c6:
                if (r2 >= r7) goto L_0x00d9
                r11 = r5[r0]     // Catch:{ all -> 0x0197 }
                long r11 = r11.id     // Catch:{ all -> 0x0197 }
                int r11 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
                if (r11 != 0) goto L_0x00d1
                goto L_0x00d9
            L_0x00d1:
                int r0 = r0 + 1
                if (r0 != r7) goto L_0x00d6
                r0 = r3
            L_0x00d6:
                int r2 = r2 + 1
                goto L_0x00c6
            L_0x00d9:
                r1.lastIndex = r0     // Catch:{ all -> 0x0197 }
                r2 = r5[r0]     // Catch:{ all -> 0x0197 }
                long r8 = r2.id     // Catch:{ all -> 0x0197 }
                r1.lastId = r8     // Catch:{ all -> 0x0197 }
            L_0x00e1:
                r2 = r3
                r8 = r2
            L_0x00e3:
                if (r2 >= r7) goto L_0x016a
                boolean r9 = r22.checkTerminate()     // Catch:{ all -> 0x0197 }
                if (r9 == 0) goto L_0x00ec
                return
            L_0x00ec:
                r9 = r5[r0]     // Catch:{ all -> 0x0197 }
                r11 = 0
            L_0x00ef:
                r12 = r3
            L_0x00f0:
                int r18 = (r16 > r14 ? 1 : (r16 == r14 ? 0 : -1))
                if (r18 <= 0) goto L_0x0106
                boolean r18 = r22.checkTerminate()     // Catch:{ all -> 0x0197 }
                if (r18 == 0) goto L_0x00fb
                return
            L_0x00fb:
                rx.internal.util.RxRingBuffer r13 = r9.queue     // Catch:{ all -> 0x0197 }
                if (r13 != 0) goto L_0x0100
                goto L_0x0106
            L_0x0100:
                java.lang.Object r11 = r13.poll()     // Catch:{ all -> 0x0197 }
                if (r11 != 0) goto L_0x0109
            L_0x0106:
                r20 = 1
                goto L_0x0129
            L_0x0109:
                java.lang.Object r13 = rx.internal.operators.NotificationLite.getValue(r11)     // Catch:{ all -> 0x0197 }
                r4.onNext(r13)     // Catch:{ all -> 0x0117 }
                r20 = 1
                long r16 = r16 - r20
                int r12 = r12 + 1
                goto L_0x00f0
            L_0x0117:
                r0 = move-exception
                r2 = r0
                rx.exceptions.Exceptions.throwIfFatal(r2)     // Catch:{ all -> 0x005b }
                r4.onError(r2)     // Catch:{ all -> 0x0123 }
                r22.unsubscribe()     // Catch:{ all -> 0x005b }
                return
            L_0x0123:
                r0 = move-exception
                r2 = r0
                r22.unsubscribe()     // Catch:{ all -> 0x005b }
                throw r2     // Catch:{ all -> 0x005b }
            L_0x0129:
                if (r12 <= 0) goto L_0x013d
                if (r10 != 0) goto L_0x0134
                rx.internal.operators.OperatorMerge$MergeProducer<T> r13 = r1.producer     // Catch:{ all -> 0x0197 }
                long r16 = r13.produced(r12)     // Catch:{ all -> 0x0197 }
                goto L_0x0139
            L_0x0134:
                r16 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            L_0x0139:
                long r12 = (long) r12     // Catch:{ all -> 0x0197 }
                r9.requestMore(r12)     // Catch:{ all -> 0x0197 }
            L_0x013d:
                int r12 = (r16 > r14 ? 1 : (r16 == r14 ? 0 : -1))
                if (r12 == 0) goto L_0x0143
                if (r11 != 0) goto L_0x00ef
            L_0x0143:
                boolean r11 = r9.done     // Catch:{ all -> 0x0197 }
                rx.internal.util.RxRingBuffer r13 = r9.queue     // Catch:{ all -> 0x0197 }
                if (r11 == 0) goto L_0x015e
                if (r13 == 0) goto L_0x0151
                boolean r11 = r13.isEmpty()     // Catch:{ all -> 0x0197 }
                if (r11 == 0) goto L_0x015e
            L_0x0151:
                r1.removeInner(r9)     // Catch:{ all -> 0x0197 }
                boolean r8 = r22.checkTerminate()     // Catch:{ all -> 0x0197 }
                if (r8 == 0) goto L_0x015b
                return
            L_0x015b:
                int r6 = r6 + 1
                r8 = 1
            L_0x015e:
                if (r12 != 0) goto L_0x0161
                goto L_0x016a
            L_0x0161:
                int r0 = r0 + 1
                if (r0 != r7) goto L_0x0166
                r0 = r3
            L_0x0166:
                int r2 = r2 + 1
                goto L_0x00e3
            L_0x016a:
                r1.lastIndex = r0     // Catch:{ all -> 0x0197 }
                r0 = r5[r0]     // Catch:{ all -> 0x0197 }
                long r9 = r0.id     // Catch:{ all -> 0x0197 }
                r1.lastId = r9     // Catch:{ all -> 0x0197 }
                goto L_0x0174
            L_0x0173:
                r8 = r3
            L_0x0174:
                if (r6 <= 0) goto L_0x017a
                long r5 = (long) r6     // Catch:{ all -> 0x0197 }
                r1.request(r5)     // Catch:{ all -> 0x0197 }
            L_0x017a:
                if (r8 == 0) goto L_0x017e
                goto L_0x0005
            L_0x017e:
                monitor-enter(r22)     // Catch:{ all -> 0x0197 }
                boolean r0 = r1.missed     // Catch:{ all -> 0x018f }
                if (r0 != 0) goto L_0x018a
                r1.emitting = r3     // Catch:{ all -> 0x0187 }
                monitor-exit(r22)     // Catch:{ all -> 0x0187 }
                return
            L_0x0187:
                r0 = move-exception
                r2 = 1
                goto L_0x0191
            L_0x018a:
                r1.missed = r3     // Catch:{ all -> 0x018f }
                monitor-exit(r22)     // Catch:{ all -> 0x018f }
                goto L_0x0005
            L_0x018f:
                r0 = move-exception
                r2 = r3
            L_0x0191:
                monitor-exit(r22)     // Catch:{ all -> 0x0195 }
                throw r0     // Catch:{ all -> 0x0193 }
            L_0x0193:
                r0 = move-exception
                goto L_0x0199
            L_0x0195:
                r0 = move-exception
                goto L_0x0191
            L_0x0197:
                r0 = move-exception
                r2 = r3
            L_0x0199:
                if (r2 != 0) goto L_0x01a3
                monitor-enter(r22)
                r1.emitting = r3     // Catch:{ all -> 0x01a0 }
                monitor-exit(r22)     // Catch:{ all -> 0x01a0 }
                goto L_0x01a3
            L_0x01a0:
                r0 = move-exception
                monitor-exit(r22)     // Catch:{ all -> 0x01a0 }
                throw r0
            L_0x01a3:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorMerge.MergeSubscriber.emitLoop():void");
        }

        /* access modifiers changed from: package-private */
        public boolean checkTerminate() {
            if (this.child.isUnsubscribed()) {
                return true;
            }
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.errors;
            if (this.delayErrors || concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
                return false;
            }
            try {
                reportError();
                return true;
            } finally {
                unsubscribe();
            }
        }
    }

    static final class InnerSubscriber<T> extends Subscriber<T> {
        static final int LIMIT = (RxRingBuffer.SIZE / 4);
        volatile boolean done;
        final long id;
        int outstanding;
        final MergeSubscriber<T> parent;
        volatile RxRingBuffer queue;

        public InnerSubscriber(MergeSubscriber<T> mergeSubscriber, long j) {
            this.parent = mergeSubscriber;
            this.id = j;
        }

        public void onStart() {
            this.outstanding = RxRingBuffer.SIZE;
            request((long) RxRingBuffer.SIZE);
        }

        public void onNext(T t) {
            this.parent.tryEmit(this, t);
        }

        public void onError(Throwable th) {
            this.parent.getOrCreateErrorQueue().offer(th);
            this.done = true;
            this.parent.emit();
        }

        public void onCompleted() {
            this.done = true;
            this.parent.emit();
        }

        public void requestMore(long j) {
            int i = this.outstanding - ((int) j);
            if (i > LIMIT) {
                this.outstanding = i;
                return;
            }
            this.outstanding = RxRingBuffer.SIZE;
            int i2 = RxRingBuffer.SIZE - i;
            if (i2 > 0) {
                request((long) i2);
            }
        }
    }
}
