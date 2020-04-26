package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;
import rx.BackpressureOverflow;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.internal.util.BackpressureDrainManager;

public class OperatorOnBackpressureBuffer<T> implements Observable.Operator<T, T> {
    private final Long capacity;
    private final Action0 onOverflow;
    private final BackpressureOverflow.Strategy overflowStrategy;

    static final class Holder {
        static final OperatorOnBackpressureBuffer<?> INSTANCE = new OperatorOnBackpressureBuffer<>();

        Holder() {
        }
    }

    public static <T> OperatorOnBackpressureBuffer<T> instance() {
        return Holder.INSTANCE;
    }

    OperatorOnBackpressureBuffer() {
        this.capacity = null;
        this.onOverflow = null;
        this.overflowStrategy = BackpressureOverflow.ON_OVERFLOW_DEFAULT;
    }

    public OperatorOnBackpressureBuffer(long j) {
        this(j, (Action0) null, BackpressureOverflow.ON_OVERFLOW_DEFAULT);
    }

    public OperatorOnBackpressureBuffer(long j, Action0 action0) {
        this(j, action0, BackpressureOverflow.ON_OVERFLOW_DEFAULT);
    }

    public OperatorOnBackpressureBuffer(long j, Action0 action0, BackpressureOverflow.Strategy strategy) {
        if (j <= 0) {
            throw new IllegalArgumentException("Buffer capacity must be > 0");
        } else if (strategy != null) {
            this.capacity = Long.valueOf(j);
            this.onOverflow = action0;
            this.overflowStrategy = strategy;
        } else {
            throw new NullPointerException("The BackpressureOverflow strategy must not be null");
        }
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        BufferSubscriber bufferSubscriber = new BufferSubscriber(subscriber, this.capacity, this.onOverflow, this.overflowStrategy);
        subscriber.add(bufferSubscriber);
        subscriber.setProducer(bufferSubscriber.manager());
        return bufferSubscriber;
    }

    static final class BufferSubscriber<T> extends Subscriber<T> implements BackpressureDrainManager.BackpressureQueueCallback {
        private final AtomicLong capacity;
        private final Subscriber<? super T> child;
        private final BackpressureDrainManager manager;
        private final Action0 onOverflow;
        private final BackpressureOverflow.Strategy overflowStrategy;
        private final ConcurrentLinkedQueue<Object> queue = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean saturated = new AtomicBoolean(false);

        public BufferSubscriber(Subscriber<? super T> subscriber, Long l, Action0 action0, BackpressureOverflow.Strategy strategy) {
            this.child = subscriber;
            this.capacity = l != null ? new AtomicLong(l.longValue()) : null;
            this.onOverflow = action0;
            this.manager = new BackpressureDrainManager(this);
            this.overflowStrategy = strategy;
        }

        public void onStart() {
            request(LongCompanionObject.MAX_VALUE);
        }

        public void onCompleted() {
            if (!this.saturated.get()) {
                this.manager.terminateAndDrain();
            }
        }

        public void onError(Throwable th) {
            if (!this.saturated.get()) {
                this.manager.terminateAndDrain(th);
            }
        }

        public void onNext(T t) {
            if (assertCapacity()) {
                this.queue.offer(NotificationLite.next(t));
                this.manager.drain();
            }
        }

        public boolean accept(Object obj) {
            return NotificationLite.accept(this.child, obj);
        }

        public void complete(Throwable th) {
            if (th != null) {
                this.child.onError(th);
            } else {
                this.child.onCompleted();
            }
        }

        public Object peek() {
            return this.queue.peek();
        }

        public Object poll() {
            Object poll = this.queue.poll();
            AtomicLong atomicLong = this.capacity;
            if (!(atomicLong == null || poll == null)) {
                atomicLong.incrementAndGet();
            }
            return poll;
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0039 A[SYNTHETIC, Splitter:B:19:0x0039] */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0049 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean assertCapacity() {
            /*
                r6 = this;
                java.util.concurrent.atomic.AtomicLong r0 = r6.capacity
                r1 = 1
                if (r0 != 0) goto L_0x0006
                return r1
            L_0x0006:
                java.util.concurrent.atomic.AtomicLong r0 = r6.capacity
                long r2 = r0.get()
                r4 = 0
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 > 0) goto L_0x004a
                r0 = 0
                rx.BackpressureOverflow$Strategy r4 = r6.overflowStrategy     // Catch:{ MissingBackpressureException -> 0x0023 }
                boolean r4 = r4.mayAttemptDrop()     // Catch:{ MissingBackpressureException -> 0x0023 }
                if (r4 == 0) goto L_0x0034
                java.lang.Object r4 = r6.poll()     // Catch:{ MissingBackpressureException -> 0x0023 }
                if (r4 == 0) goto L_0x0034
                r4 = r1
                goto L_0x0035
            L_0x0023:
                r4 = move-exception
                java.util.concurrent.atomic.AtomicBoolean r5 = r6.saturated
                boolean r5 = r5.compareAndSet(r0, r1)
                if (r5 == 0) goto L_0x0034
                r6.unsubscribe()
                rx.Subscriber<? super T> r5 = r6.child
                r5.onError(r4)
            L_0x0034:
                r4 = r0
            L_0x0035:
                rx.functions.Action0 r5 = r6.onOverflow
                if (r5 == 0) goto L_0x0047
                r5.call()     // Catch:{ all -> 0x003d }
                goto L_0x0047
            L_0x003d:
                r1 = move-exception
                rx.exceptions.Exceptions.throwIfFatal(r1)
                rx.internal.util.BackpressureDrainManager r2 = r6.manager
                r2.terminateAndDrain(r1)
                return r0
            L_0x0047:
                if (r4 != 0) goto L_0x004a
                return r0
            L_0x004a:
                java.util.concurrent.atomic.AtomicLong r0 = r6.capacity
                r4 = 1
                long r4 = r2 - r4
                boolean r0 = r0.compareAndSet(r2, r4)
                if (r0 == 0) goto L_0x0006
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorOnBackpressureBuffer.BufferSubscriber.assertCapacity():boolean");
        }

        /* access modifiers changed from: protected */
        public Producer manager() {
            return this.manager;
        }
    }
}
