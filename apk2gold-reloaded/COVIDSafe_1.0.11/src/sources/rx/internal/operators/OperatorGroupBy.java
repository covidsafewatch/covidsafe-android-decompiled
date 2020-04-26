package rx.internal.operators;

import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable.OnSubscribe;
import rx.Observable.Operator;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.internal.producers.ProducerArbiter;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.UtilityFunctions;
import rx.observables.GroupedObservable;
import rx.observers.Subscribers;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.Subscriptions;

@Deprecated
public final class OperatorGroupBy<T, K, V> implements Operator<GroupedObservable<K, V>, T> {
    final int bufferSize;
    final boolean delayError;
    final Func1<? super T, ? extends K> keySelector;
    final Func1<Action1<K>, Map<K, Object>> mapFactory;
    final Func1<? super T, ? extends V> valueSelector;

    public static final class GroupByProducer implements Producer {
        final GroupBySubscriber<?, ?, ?> parent;

        public GroupByProducer(GroupBySubscriber<?, ?, ?> groupBySubscriber) {
            this.parent = groupBySubscriber;
        }

        public void request(long j) {
            this.parent.requestMore(j);
        }
    }

    public static final class GroupBySubscriber<T, K, V> extends Subscriber<T> {
        static final Object NULL_KEY = new Object();
        final Subscriber<? super GroupedObservable<K, V>> actual;
        final int bufferSize;
        final AtomicBoolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final Queue<K> evictedKeys;
        final AtomicInteger groupCount;
        final Map<Object, GroupedUnicast<K, V>> groups;
        final Map<Object, GroupedUnicast<K, V>> groupsCopy;
        final Func1<? super T, ? extends K> keySelector;
        final GroupByProducer producer;
        final Queue<GroupedObservable<K, V>> queue = new ConcurrentLinkedQueue();
        final AtomicLong requested;
        final ProducerArbiter s;
        final Func1<? super T, ? extends V> valueSelector;
        final AtomicInteger wip;

        static class EvictionAction<K> implements Action1<K> {
            final Queue<K> evictedKeys;

            EvictionAction(Queue<K> queue) {
                this.evictedKeys = queue;
            }

            public void call(K k) {
                this.evictedKeys.offer(k);
            }
        }

        public GroupBySubscriber(Subscriber<? super GroupedObservable<K, V>> subscriber, Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12, int i, boolean z, Func1<Action1<K>, Map<K, Object>> func13) {
            this.actual = subscriber;
            this.keySelector = func1;
            this.valueSelector = func12;
            this.bufferSize = i;
            this.delayError = z;
            ProducerArbiter producerArbiter = new ProducerArbiter();
            this.s = producerArbiter;
            producerArbiter.request((long) i);
            this.producer = new GroupByProducer(this);
            this.cancelled = new AtomicBoolean();
            this.requested = new AtomicLong();
            this.groupCount = new AtomicInteger(1);
            this.wip = new AtomicInteger();
            if (func13 == null) {
                this.groups = new ConcurrentHashMap();
                this.evictedKeys = null;
            } else {
                ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
                this.evictedKeys = concurrentLinkedQueue;
                this.groups = createMap(func13, new EvictionAction(concurrentLinkedQueue));
            }
            this.groupsCopy = new ConcurrentHashMap();
        }

        private Map<Object, GroupedUnicast<K, V>> createMap(Func1<Action1<K>, Map<K, Object>> func1, Action1<K> action1) {
            return (Map) func1.call(action1);
        }

        public void setProducer(Producer producer2) {
            this.s.setProducer(producer2);
        }

        public void onNext(T t) {
            Object obj;
            if (!this.done) {
                Queue<GroupedObservable<K, V>> queue2 = this.queue;
                Subscriber<? super GroupedObservable<K, V>> subscriber = this.actual;
                try {
                    Object call = this.keySelector.call(t);
                    boolean z = false;
                    if (call != null) {
                        obj = call;
                    } else {
                        obj = NULL_KEY;
                    }
                    GroupedUnicast groupedUnicast = (GroupedUnicast) this.groups.get(obj);
                    if (groupedUnicast == null) {
                        if (!this.cancelled.get()) {
                            groupedUnicast = GroupedUnicast.createWith(call, this.bufferSize, this, this.delayError);
                            this.groups.put(obj, groupedUnicast);
                            if (this.evictedKeys != null) {
                                this.groupsCopy.put(obj, groupedUnicast);
                            }
                            this.groupCount.getAndIncrement();
                            z = true;
                        } else {
                            return;
                        }
                    }
                    try {
                        groupedUnicast.onNext(this.valueSelector.call(t));
                        if (this.evictedKeys != null) {
                            while (true) {
                                Object poll = this.evictedKeys.poll();
                                if (poll == null) {
                                    break;
                                }
                                GroupedUnicast groupedUnicast2 = (GroupedUnicast) this.groupsCopy.remove(poll);
                                if (groupedUnicast2 != null) {
                                    groupedUnicast2.onComplete();
                                }
                            }
                        }
                        if (z) {
                            queue2.offer(groupedUnicast);
                            drain();
                        }
                    } catch (Throwable th) {
                        unsubscribe();
                        errorAll(subscriber, queue2, th);
                    }
                } catch (Throwable th2) {
                    unsubscribe();
                    errorAll(subscriber, queue2, th2);
                }
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaHooks.onError(th);
                return;
            }
            this.error = th;
            this.done = true;
            this.groupCount.decrementAndGet();
            drain();
        }

        public void onCompleted() {
            if (!this.done) {
                for (GroupedUnicast onComplete : this.groups.values()) {
                    onComplete.onComplete();
                }
                this.groups.clear();
                if (this.evictedKeys != null) {
                    this.groupsCopy.clear();
                    this.evictedKeys.clear();
                }
                this.done = true;
                this.groupCount.decrementAndGet();
                drain();
            }
        }

        public void requestMore(long j) {
            if (j >= 0) {
                BackpressureUtils.getAndAddRequest(this.requested, j);
                drain();
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("n >= 0 required but it was ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        }

        public void cancel() {
            if (this.cancelled.compareAndSet(false, true) && this.groupCount.decrementAndGet() == 0) {
                unsubscribe();
            }
        }

        public void cancel(K k) {
            if (k == null) {
                k = NULL_KEY;
            }
            if (this.groups.remove(k) != null && this.groupCount.decrementAndGet() == 0) {
                unsubscribe();
            }
            if (this.evictedKeys != null) {
                this.groupsCopy.remove(k);
            }
        }

        /* access modifiers changed from: 0000 */
        public void drain() {
            if (this.wip.getAndIncrement() == 0) {
                Queue<GroupedObservable<K, V>> queue2 = this.queue;
                Subscriber<? super GroupedObservable<K, V>> subscriber = this.actual;
                int i = 1;
                while (!checkTerminated(this.done, queue2.isEmpty(), subscriber, queue2)) {
                    long j = this.requested.get();
                    long j2 = 0;
                    while (j2 != j) {
                        boolean z = this.done;
                        GroupedObservable groupedObservable = (GroupedObservable) queue2.poll();
                        boolean z2 = groupedObservable == null;
                        if (!checkTerminated(z, z2, subscriber, queue2)) {
                            if (z2) {
                                break;
                            }
                            subscriber.onNext(groupedObservable);
                            j2++;
                        } else {
                            return;
                        }
                    }
                    if (j2 != 0) {
                        if (j != LongCompanionObject.MAX_VALUE) {
                            BackpressureUtils.produced(this.requested, j2);
                        }
                        this.s.request(j2);
                    }
                    i = this.wip.addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void errorAll(Subscriber<? super GroupedObservable<K, V>> subscriber, Queue<?> queue2, Throwable th) {
            queue2.clear();
            ArrayList<GroupedUnicast> arrayList = new ArrayList<>(this.groups.values());
            this.groups.clear();
            if (this.evictedKeys != null) {
                this.groupsCopy.clear();
                this.evictedKeys.clear();
            }
            for (GroupedUnicast onError : arrayList) {
                onError.onError(th);
            }
            subscriber.onError(th);
        }

        /* access modifiers changed from: 0000 */
        public boolean checkTerminated(boolean z, boolean z2, Subscriber<? super GroupedObservable<K, V>> subscriber, Queue<?> queue2) {
            if (z) {
                Throwable th = this.error;
                if (th != null) {
                    errorAll(subscriber, queue2, th);
                    return true;
                } else if (z2) {
                    this.actual.onCompleted();
                    return true;
                }
            }
            return false;
        }
    }

    static final class GroupedUnicast<K, T> extends GroupedObservable<K, T> {
        final State<T, K> state;

        public static <T, K> GroupedUnicast<K, T> createWith(K k, int i, GroupBySubscriber<?, K, T> groupBySubscriber, boolean z) {
            return new GroupedUnicast<>(k, new State(i, groupBySubscriber, k, z));
        }

        protected GroupedUnicast(K k, State<T, K> state2) {
            super(k, state2);
            this.state = state2;
        }

        public void onNext(T t) {
            this.state.onNext(t);
        }

        public void onError(Throwable th) {
            this.state.onError(th);
        }

        public void onComplete() {
            this.state.onComplete();
        }
    }

    static final class State<T, K> extends AtomicInteger implements Producer, Subscription, OnSubscribe<T> {
        private static final long serialVersionUID = -3852313036005250360L;
        final AtomicReference<Subscriber<? super T>> actual;
        final AtomicBoolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final K key;
        final AtomicBoolean once;
        final GroupBySubscriber<?, K, T> parent;
        final Queue<Object> queue = new ConcurrentLinkedQueue();
        final AtomicLong requested;

        public State(int i, GroupBySubscriber<?, K, T> groupBySubscriber, K k, boolean z) {
            this.parent = groupBySubscriber;
            this.key = k;
            this.delayError = z;
            this.cancelled = new AtomicBoolean();
            this.actual = new AtomicReference<>();
            this.once = new AtomicBoolean();
            this.requested = new AtomicLong();
        }

        public void request(long j) {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("n >= required but it was ");
                sb.append(j);
                throw new IllegalArgumentException(sb.toString());
            } else if (i != 0) {
                BackpressureUtils.getAndAddRequest(this.requested, j);
                drain();
            }
        }

        public boolean isUnsubscribed() {
            return this.cancelled.get();
        }

        public void unsubscribe() {
            if (this.cancelled.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.parent.cancel(this.key);
            }
        }

        public void call(Subscriber<? super T> subscriber) {
            if (this.once.compareAndSet(false, true)) {
                subscriber.add(this);
                subscriber.setProducer(this);
                this.actual.lazySet(subscriber);
                drain();
                return;
            }
            subscriber.onError(new IllegalStateException("Only one Subscriber allowed!"));
        }

        public void onNext(T t) {
            if (t == null) {
                this.error = new NullPointerException();
                this.done = true;
            } else {
                this.queue.offer(NotificationLite.next(t));
            }
            drain();
        }

        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        /* access modifiers changed from: 0000 */
        public void drain() {
            if (getAndIncrement() == 0) {
                Queue<Object> queue2 = this.queue;
                boolean z = this.delayError;
                Subscriber subscriber = (Subscriber) this.actual.get();
                int i = 1;
                while (true) {
                    if (subscriber != null) {
                        if (!checkTerminated(this.done, queue2.isEmpty(), subscriber, z)) {
                            long j = this.requested.get();
                            long j2 = 0;
                            while (j2 != j) {
                                boolean z2 = this.done;
                                Object poll = queue2.poll();
                                boolean z3 = poll == null;
                                if (!checkTerminated(z2, z3, subscriber, z)) {
                                    if (z3) {
                                        break;
                                    }
                                    subscriber.onNext(NotificationLite.getValue(poll));
                                    j2++;
                                } else {
                                    return;
                                }
                            }
                            if (j2 != 0) {
                                if (j != LongCompanionObject.MAX_VALUE) {
                                    BackpressureUtils.produced(this.requested, j2);
                                }
                                this.parent.s.request(j2);
                            }
                        } else {
                            return;
                        }
                    }
                    i = addAndGet(-i);
                    if (i != 0) {
                        if (subscriber == null) {
                            subscriber = (Subscriber) this.actual.get();
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public boolean checkTerminated(boolean z, boolean z2, Subscriber<? super T> subscriber, boolean z3) {
            if (this.cancelled.get()) {
                this.queue.clear();
                this.parent.cancel(this.key);
                return true;
            }
            if (z) {
                if (!z3) {
                    Throwable th = this.error;
                    if (th != null) {
                        this.queue.clear();
                        subscriber.onError(th);
                        return true;
                    } else if (z2) {
                        subscriber.onCompleted();
                        return true;
                    }
                } else if (z2) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        subscriber.onError(th2);
                    } else {
                        subscriber.onCompleted();
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public OperatorGroupBy(Func1<? super T, ? extends K> func1) {
        this(func1, UtilityFunctions.identity(), RxRingBuffer.SIZE, false, null);
    }

    public OperatorGroupBy(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12) {
        this(func1, func12, RxRingBuffer.SIZE, false, null);
    }

    public OperatorGroupBy(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12, Func1<Action1<K>, Map<K, Object>> func13) {
        this(func1, func12, RxRingBuffer.SIZE, false, func13);
    }

    public OperatorGroupBy(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12, int i, boolean z, Func1<Action1<K>, Map<K, Object>> func13) {
        this.keySelector = func1;
        this.valueSelector = func12;
        this.bufferSize = i;
        this.delayError = z;
        this.mapFactory = func13;
    }

    public Subscriber<? super T> call(Subscriber<? super GroupedObservable<K, V>> subscriber) {
        try {
            final GroupBySubscriber groupBySubscriber = new GroupBySubscriber(subscriber, this.keySelector, this.valueSelector, this.bufferSize, this.delayError, this.mapFactory);
            subscriber.add(Subscriptions.create(new Action0() {
                public void call() {
                    groupBySubscriber.cancel();
                }
            }));
            subscriber.setProducer(groupBySubscriber.producer);
            return groupBySubscriber;
        } catch (Throwable th) {
            Exceptions.throwOrReport(th, (Observer<?>) subscriber);
            Subscriber<? super T> empty = Subscribers.empty();
            empty.unsubscribe();
            return empty;
        }
    }
}
