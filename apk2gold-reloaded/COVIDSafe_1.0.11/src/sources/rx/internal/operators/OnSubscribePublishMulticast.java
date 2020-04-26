package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable.OnSubscribe;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;

public final class OnSubscribePublishMulticast<T> extends AtomicInteger implements OnSubscribe<T>, Observer<T>, Subscription {
    static final PublishProducer<?>[] EMPTY = new PublishProducer[0];
    static final PublishProducer<?>[] TERMINATED = new PublishProducer[0];
    private static final long serialVersionUID = -3741892510772238743L;
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    final ParentSubscriber<T> parent;
    final int prefetch;
    volatile Producer producer;
    final Queue<T> queue;
    volatile PublishProducer<T>[] subscribers;

    static final class ParentSubscriber<T> extends Subscriber<T> {
        final OnSubscribePublishMulticast<T> state;

        public ParentSubscriber(OnSubscribePublishMulticast<T> onSubscribePublishMulticast) {
            this.state = onSubscribePublishMulticast;
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

        public void setProducer(Producer producer) {
            this.state.setProducer(producer);
        }
    }

    static final class PublishProducer<T> extends AtomicLong implements Producer, Subscription {
        private static final long serialVersionUID = 960704844171597367L;
        final Subscriber<? super T> actual;
        final AtomicBoolean once = new AtomicBoolean();
        final OnSubscribePublishMulticast<T> parent;

        public PublishProducer(Subscriber<? super T> subscriber, OnSubscribePublishMulticast<T> onSubscribePublishMulticast) {
            this.actual = subscriber;
            this.parent = onSubscribePublishMulticast;
        }

        public void request(long j) {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("n >= 0 required but it was ");
                sb.append(j);
                throw new IllegalArgumentException(sb.toString());
            } else if (i != 0) {
                BackpressureUtils.getAndAddRequest(this, j);
                this.parent.drain();
            }
        }

        public boolean isUnsubscribed() {
            return this.once.get();
        }

        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.parent.remove(this);
            }
        }
    }

    public OnSubscribePublishMulticast(int i, boolean z) {
        if (i > 0) {
            this.prefetch = i;
            this.delayError = z;
            if (UnsafeAccess.isUnsafeAvailable()) {
                this.queue = new SpscArrayQueue(i);
            } else {
                this.queue = new SpscAtomicArrayQueue(i);
            }
            this.subscribers = (PublishProducer[]) EMPTY;
            this.parent = new ParentSubscriber<>(this);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("prefetch > 0 required but it was ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    public void call(Subscriber<? super T> subscriber) {
        PublishProducer publishProducer = new PublishProducer(subscriber, this);
        subscriber.add(publishProducer);
        subscriber.setProducer(publishProducer);
        if (!add(publishProducer)) {
            Throwable th = this.error;
            if (th != null) {
                subscriber.onError(th);
            } else {
                subscriber.onCompleted();
            }
        } else if (publishProducer.isUnsubscribed()) {
            remove(publishProducer);
        } else {
            drain();
        }
    }

    public void onNext(T t) {
        if (!this.queue.offer(t)) {
            this.parent.unsubscribe();
            this.error = new MissingBackpressureException("Queue full?!");
            this.done = true;
        }
        drain();
    }

    public void onError(Throwable th) {
        this.error = th;
        this.done = true;
        drain();
    }

    public void onCompleted() {
        this.done = true;
        drain();
    }

    /* access modifiers changed from: 0000 */
    public void setProducer(Producer producer2) {
        this.producer = producer2;
        producer2.request((long) this.prefetch);
    }

    /* access modifiers changed from: 0000 */
    public void drain() {
        int i;
        if (getAndIncrement() == 0) {
            Queue<T> queue2 = this.queue;
            int i2 = 0;
            do {
                long j = LongCompanionObject.MAX_VALUE;
                PublishProducer<T>[] publishProducerArr = this.subscribers;
                int length = publishProducerArr.length;
                for (PublishProducer<T> publishProducer : publishProducerArr) {
                    j = Math.min(j, publishProducer.get());
                }
                if (length != 0) {
                    long j2 = 0;
                    while (true) {
                        i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                        if (i == 0) {
                            break;
                        }
                        boolean z = this.done;
                        Object poll = queue2.poll();
                        boolean z2 = poll == null;
                        if (!checkTerminated(z, z2)) {
                            if (z2) {
                                break;
                            }
                            for (PublishProducer<T> publishProducer2 : publishProducerArr) {
                                publishProducer2.actual.onNext(poll);
                            }
                            j2++;
                        } else {
                            return;
                        }
                    }
                    if (i == 0 && checkTerminated(this.done, queue2.isEmpty())) {
                        return;
                    }
                    if (j2 != 0) {
                        Producer producer2 = this.producer;
                        if (producer2 != null) {
                            producer2.request(j2);
                        }
                        for (PublishProducer<T> produced : publishProducerArr) {
                            BackpressureUtils.produced(produced, j2);
                        }
                    }
                }
                i2 = addAndGet(-i2);
            } while (i2 != 0);
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean checkTerminated(boolean z, boolean z2) {
        int i = 0;
        if (z) {
            if (!this.delayError) {
                Throwable th = this.error;
                if (th != null) {
                    this.queue.clear();
                    PublishProducer[] terminate = terminate();
                    int length = terminate.length;
                    while (i < length) {
                        terminate[i].actual.onError(th);
                        i++;
                    }
                    return true;
                } else if (z2) {
                    PublishProducer[] terminate2 = terminate();
                    int length2 = terminate2.length;
                    while (i < length2) {
                        terminate2[i].actual.onCompleted();
                        i++;
                    }
                    return true;
                }
            } else if (z2) {
                PublishProducer[] terminate3 = terminate();
                Throwable th2 = this.error;
                if (th2 != null) {
                    int length3 = terminate3.length;
                    while (i < length3) {
                        terminate3[i].actual.onError(th2);
                        i++;
                    }
                } else {
                    int length4 = terminate3.length;
                    while (i < length4) {
                        terminate3[i].actual.onCompleted();
                        i++;
                    }
                }
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public PublishProducer<T>[] terminate() {
        PublishProducer<T>[] publishProducerArr = this.subscribers;
        if (publishProducerArr != TERMINATED) {
            synchronized (this) {
                publishProducerArr = this.subscribers;
                if (publishProducerArr != TERMINATED) {
                    this.subscribers = (PublishProducer[]) TERMINATED;
                }
            }
        }
        return publishProducerArr;
    }

    /* access modifiers changed from: 0000 */
    public boolean add(PublishProducer<T> publishProducer) {
        if (this.subscribers == TERMINATED) {
            return false;
        }
        synchronized (this) {
            PublishProducer<T>[] publishProducerArr = this.subscribers;
            if (publishProducerArr == TERMINATED) {
                return false;
            }
            int length = publishProducerArr.length;
            PublishProducer<T>[] publishProducerArr2 = new PublishProducer[(length + 1)];
            System.arraycopy(publishProducerArr, 0, publishProducerArr2, 0, length);
            publishProducerArr2[length] = publishProducer;
            this.subscribers = publishProducerArr2;
            return true;
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0046, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void remove(rx.internal.operators.OnSubscribePublishMulticast.PublishProducer<T> r7) {
        /*
            r6 = this;
            rx.internal.operators.OnSubscribePublishMulticast$PublishProducer<T>[] r0 = r6.subscribers
            rx.internal.operators.OnSubscribePublishMulticast$PublishProducer<?>[] r1 = TERMINATED
            if (r0 == r1) goto L_0x004a
            rx.internal.operators.OnSubscribePublishMulticast$PublishProducer<?>[] r1 = EMPTY
            if (r0 != r1) goto L_0x000b
            goto L_0x004a
        L_0x000b:
            monitor-enter(r6)
            rx.internal.operators.OnSubscribePublishMulticast$PublishProducer<T>[] r0 = r6.subscribers     // Catch:{ all -> 0x0047 }
            rx.internal.operators.OnSubscribePublishMulticast$PublishProducer<?>[] r1 = TERMINATED     // Catch:{ all -> 0x0047 }
            if (r0 == r1) goto L_0x0045
            rx.internal.operators.OnSubscribePublishMulticast$PublishProducer<?>[] r1 = EMPTY     // Catch:{ all -> 0x0047 }
            if (r0 != r1) goto L_0x0017
            goto L_0x0045
        L_0x0017:
            r1 = -1
            int r2 = r0.length     // Catch:{ all -> 0x0047 }
            r3 = 0
            r4 = r3
        L_0x001b:
            if (r4 >= r2) goto L_0x0026
            r5 = r0[r4]     // Catch:{ all -> 0x0047 }
            if (r5 != r7) goto L_0x0023
            r1 = r4
            goto L_0x0026
        L_0x0023:
            int r4 = r4 + 1
            goto L_0x001b
        L_0x0026:
            if (r1 >= 0) goto L_0x002a
            monitor-exit(r6)     // Catch:{ all -> 0x0047 }
            return
        L_0x002a:
            r7 = 1
            if (r2 != r7) goto L_0x0032
            rx.internal.operators.OnSubscribePublishMulticast$PublishProducer<?>[] r7 = EMPTY     // Catch:{ all -> 0x0047 }
            rx.internal.operators.OnSubscribePublishMulticast$PublishProducer[] r7 = (rx.internal.operators.OnSubscribePublishMulticast.PublishProducer[]) r7     // Catch:{ all -> 0x0047 }
            goto L_0x0041
        L_0x0032:
            int r4 = r2 + -1
            rx.internal.operators.OnSubscribePublishMulticast$PublishProducer[] r4 = new rx.internal.operators.OnSubscribePublishMulticast.PublishProducer[r4]     // Catch:{ all -> 0x0047 }
            java.lang.System.arraycopy(r0, r3, r4, r3, r1)     // Catch:{ all -> 0x0047 }
            int r3 = r1 + 1
            int r2 = r2 - r1
            int r2 = r2 - r7
            java.lang.System.arraycopy(r0, r3, r4, r1, r2)     // Catch:{ all -> 0x0047 }
            r7 = r4
        L_0x0041:
            r6.subscribers = r7     // Catch:{ all -> 0x0047 }
            monitor-exit(r6)     // Catch:{ all -> 0x0047 }
            return
        L_0x0045:
            monitor-exit(r6)     // Catch:{ all -> 0x0047 }
            return
        L_0x0047:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0047 }
            throw r7
        L_0x004a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OnSubscribePublishMulticast.remove(rx.internal.operators.OnSubscribePublishMulticast$PublishProducer):void");
    }

    public Subscriber<T> subscriber() {
        return this.parent;
    }

    public void unsubscribe() {
        this.parent.unsubscribe();
    }

    public boolean isUnsubscribed() {
        return this.parent.isUnsubscribed();
    }
}
