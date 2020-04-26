package rx.observables;

import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorNotImplementedException;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Actions;
import rx.functions.Func1;
import rx.internal.operators.BlockingOperatorLatest;
import rx.internal.operators.BlockingOperatorMostRecent;
import rx.internal.operators.BlockingOperatorNext;
import rx.internal.operators.BlockingOperatorToFuture;
import rx.internal.operators.BlockingOperatorToIterator;
import rx.internal.operators.NotificationLite;
import rx.internal.util.BlockingUtils;
import rx.internal.util.UtilityFunctions;
import rx.subscriptions.Subscriptions;

public final class BlockingObservable<T> {
    static final Object ON_START = new Object();
    static final Object SET_PRODUCER = new Object();
    static final Object UNSUBSCRIBE = new Object();
    private final Observable<? extends T> o;

    private BlockingObservable(Observable<? extends T> observable) {
        this.o = observable;
    }

    public static <T> BlockingObservable<T> from(Observable<? extends T> observable) {
        return new BlockingObservable<>(observable);
    }

    public void forEach(final Action1<? super T> action1) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final AtomicReference atomicReference = new AtomicReference();
        BlockingUtils.awaitForComplete(countDownLatch, this.o.subscribe(new Subscriber<T>() {
            public void onCompleted() {
                countDownLatch.countDown();
            }

            public void onError(Throwable th) {
                atomicReference.set(th);
                countDownLatch.countDown();
            }

            public void onNext(T t) {
                action1.call(t);
            }
        }));
        if (atomicReference.get() != null) {
            Exceptions.propagate((Throwable) atomicReference.get());
        }
    }

    public Iterator<T> getIterator() {
        return BlockingOperatorToIterator.toIterator(this.o);
    }

    public T first() {
        return blockForSingle(this.o.first());
    }

    public T first(Func1<? super T, Boolean> func1) {
        return blockForSingle(this.o.first(func1));
    }

    public T firstOrDefault(T t) {
        return blockForSingle(this.o.map(UtilityFunctions.identity()).firstOrDefault(t));
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [rx.functions.Func1<? super T, java.lang.Boolean>, rx.functions.Func1] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T firstOrDefault(T r2, rx.functions.Func1<? super T, java.lang.Boolean> r3) {
        /*
            r1 = this;
            rx.Observable<? extends T> r0 = r1.o
            rx.Observable r3 = r0.filter(r3)
            rx.functions.Func1 r0 = rx.internal.util.UtilityFunctions.identity()
            rx.Observable r3 = r3.map(r0)
            rx.Observable r2 = r3.firstOrDefault(r2)
            java.lang.Object r2 = r1.blockForSingle(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.observables.BlockingObservable.firstOrDefault(java.lang.Object, rx.functions.Func1):java.lang.Object");
    }

    public T last() {
        return blockForSingle(this.o.last());
    }

    public T last(Func1<? super T, Boolean> func1) {
        return blockForSingle(this.o.last(func1));
    }

    public T lastOrDefault(T t) {
        return blockForSingle(this.o.map(UtilityFunctions.identity()).lastOrDefault(t));
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [rx.functions.Func1<? super T, java.lang.Boolean>, rx.functions.Func1] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T lastOrDefault(T r2, rx.functions.Func1<? super T, java.lang.Boolean> r3) {
        /*
            r1 = this;
            rx.Observable<? extends T> r0 = r1.o
            rx.Observable r3 = r0.filter(r3)
            rx.functions.Func1 r0 = rx.internal.util.UtilityFunctions.identity()
            rx.Observable r3 = r3.map(r0)
            rx.Observable r2 = r3.lastOrDefault(r2)
            java.lang.Object r2 = r1.blockForSingle(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.observables.BlockingObservable.lastOrDefault(java.lang.Object, rx.functions.Func1):java.lang.Object");
    }

    public Iterable<T> mostRecent(T t) {
        return BlockingOperatorMostRecent.mostRecent(this.o, t);
    }

    public Iterable<T> next() {
        return BlockingOperatorNext.next(this.o);
    }

    public Iterable<T> latest() {
        return BlockingOperatorLatest.latest(this.o);
    }

    public T single() {
        return blockForSingle(this.o.single());
    }

    public T single(Func1<? super T, Boolean> func1) {
        return blockForSingle(this.o.single(func1));
    }

    public T singleOrDefault(T t) {
        return blockForSingle(this.o.map(UtilityFunctions.identity()).singleOrDefault(t));
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [rx.functions.Func1<? super T, java.lang.Boolean>, rx.functions.Func1] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T singleOrDefault(T r2, rx.functions.Func1<? super T, java.lang.Boolean> r3) {
        /*
            r1 = this;
            rx.Observable<? extends T> r0 = r1.o
            rx.Observable r3 = r0.filter(r3)
            rx.functions.Func1 r0 = rx.internal.util.UtilityFunctions.identity()
            rx.Observable r3 = r3.map(r0)
            rx.Observable r2 = r3.singleOrDefault(r2)
            java.lang.Object r2 = r1.blockForSingle(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.observables.BlockingObservable.singleOrDefault(java.lang.Object, rx.functions.Func1):java.lang.Object");
    }

    public Future<T> toFuture() {
        return BlockingOperatorToFuture.toFuture(this.o);
    }

    public Iterable<T> toIterable() {
        return new Iterable<T>() {
            public Iterator<T> iterator() {
                return BlockingObservable.this.getIterator();
            }
        };
    }

    private T blockForSingle(Observable<? extends T> observable) {
        final AtomicReference atomicReference = new AtomicReference();
        final AtomicReference atomicReference2 = new AtomicReference();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        BlockingUtils.awaitForComplete(countDownLatch, observable.subscribe((Subscriber<? super Object>) new Subscriber<T>() {
            public void onCompleted() {
                countDownLatch.countDown();
            }

            public void onError(Throwable th) {
                atomicReference2.set(th);
                countDownLatch.countDown();
            }

            public void onNext(T t) {
                atomicReference.set(t);
            }
        }));
        if (atomicReference2.get() != null) {
            Exceptions.propagate((Throwable) atomicReference2.get());
        }
        return atomicReference.get();
    }

    public void subscribe() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final Throwable[] thArr = {null};
        BlockingUtils.awaitForComplete(countDownLatch, this.o.subscribe(new Subscriber<T>() {
            public void onNext(T t) {
            }

            public void onError(Throwable th) {
                thArr[0] = th;
                countDownLatch.countDown();
            }

            public void onCompleted() {
                countDownLatch.countDown();
            }
        }));
        Throwable th = thArr[0];
        if (th != null) {
            Exceptions.propagate(th);
        }
    }

    public void subscribe(Observer<? super T> observer) {
        Object poll;
        final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        Subscription subscribe = this.o.subscribe(new Subscriber<T>() {
            public void onNext(T t) {
                linkedBlockingQueue.offer(NotificationLite.next(t));
            }

            public void onError(Throwable th) {
                linkedBlockingQueue.offer(NotificationLite.error(th));
            }

            public void onCompleted() {
                linkedBlockingQueue.offer(NotificationLite.completed());
            }
        });
        do {
            try {
                poll = linkedBlockingQueue.poll();
                if (poll == null) {
                    poll = linkedBlockingQueue.take();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                observer.onError(e);
                return;
            } finally {
                subscribe.unsubscribe();
            }
        } while (!NotificationLite.accept(observer, poll));
    }

    public void subscribe(Subscriber<? super T> subscriber) {
        final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        final Producer[] producerArr = {null};
        AnonymousClass6 r2 = new Subscriber<T>() {
            public void onNext(T t) {
                linkedBlockingQueue.offer(NotificationLite.next(t));
            }

            public void onError(Throwable th) {
                linkedBlockingQueue.offer(NotificationLite.error(th));
            }

            public void onCompleted() {
                linkedBlockingQueue.offer(NotificationLite.completed());
            }

            public void setProducer(Producer producer) {
                producerArr[0] = producer;
                linkedBlockingQueue.offer(BlockingObservable.SET_PRODUCER);
            }

            public void onStart() {
                linkedBlockingQueue.offer(BlockingObservable.ON_START);
            }
        };
        subscriber.add(r2);
        subscriber.add(Subscriptions.create(new Action0() {
            public void call() {
                linkedBlockingQueue.offer(BlockingObservable.UNSUBSCRIBE);
            }
        }));
        this.o.subscribe(r2);
        while (true) {
            try {
                if (subscriber.isUnsubscribed()) {
                    break;
                }
                Object poll = linkedBlockingQueue.poll();
                if (poll == null) {
                    poll = linkedBlockingQueue.take();
                }
                if (subscriber.isUnsubscribed()) {
                    break;
                } else if (poll == UNSUBSCRIBE) {
                    break;
                } else if (poll == ON_START) {
                    subscriber.onStart();
                } else if (poll == SET_PRODUCER) {
                    subscriber.setProducer(producerArr[0]);
                } else if (NotificationLite.accept(subscriber, poll)) {
                    r2.unsubscribe();
                    return;
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                subscriber.onError(e);
            } catch (Throwable th) {
                r2.unsubscribe();
                throw th;
            }
        }
        r2.unsubscribe();
    }

    public void subscribe(Action1<? super T> action1) {
        subscribe(action1, new Action1<Throwable>() {
            public void call(Throwable th) {
                throw new OnErrorNotImplementedException(th);
            }
        }, Actions.empty());
    }

    public void subscribe(Action1<? super T> action1, Action1<? super Throwable> action12) {
        subscribe(action1, action12, Actions.empty());
    }

    public void subscribe(final Action1<? super T> action1, final Action1<? super Throwable> action12, final Action0 action0) {
        subscribe(new Observer<T>() {
            public void onNext(T t) {
                action1.call(t);
            }

            public void onError(Throwable th) {
                action12.call(th);
            }

            public void onCompleted() {
                action0.call();
            }
        });
    }
}
