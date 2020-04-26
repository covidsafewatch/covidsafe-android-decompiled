package rx.internal.operators;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable.OnSubscribe;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;

public final class OnSubscribeFromIterable<T> implements OnSubscribe<T> {
    final Iterable<? extends T> is;

    static final class IterableProducer<T> extends AtomicLong implements Producer {
        private static final long serialVersionUID = -8730475647105475802L;
        private final Iterator<? extends T> it;
        private final Subscriber<? super T> o;

        IterableProducer(Subscriber<? super T> subscriber, Iterator<? extends T> it2) {
            this.o = subscriber;
            this.it = it2;
        }

        public void request(long j) {
            if (get() != LongCompanionObject.MAX_VALUE) {
                if (j == LongCompanionObject.MAX_VALUE && compareAndSet(0, LongCompanionObject.MAX_VALUE)) {
                    fastPath();
                } else if (j > 0 && BackpressureUtils.getAndAddRequest(this, j) == 0) {
                    slowPath(j);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void slowPath(long j) {
            Subscriber<? super T> subscriber = this.o;
            Iterator<? extends T> it2 = this.it;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 == j) {
                        j = get();
                        if (j2 == j) {
                            j = BackpressureUtils.produced(this, j2);
                        }
                    } else if (!subscriber.isUnsubscribed()) {
                        try {
                            subscriber.onNext(it2.next());
                            if (!subscriber.isUnsubscribed()) {
                                try {
                                    if (!it2.hasNext()) {
                                        if (!subscriber.isUnsubscribed()) {
                                            subscriber.onCompleted();
                                        }
                                        return;
                                    }
                                    j2++;
                                } catch (Throwable th) {
                                    Exceptions.throwOrReport(th, (Observer<?>) subscriber);
                                    return;
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th2) {
                            Exceptions.throwOrReport(th2, (Observer<?>) subscriber);
                            return;
                        }
                    } else {
                        return;
                    }
                }
            } while (j != 0);
        }

        /* access modifiers changed from: 0000 */
        public void fastPath() {
            Subscriber<? super T> subscriber = this.o;
            Iterator<? extends T> it2 = this.it;
            while (!subscriber.isUnsubscribed()) {
                try {
                    subscriber.onNext(it2.next());
                    if (!subscriber.isUnsubscribed()) {
                        try {
                            if (!it2.hasNext()) {
                                if (!subscriber.isUnsubscribed()) {
                                    subscriber.onCompleted();
                                }
                                return;
                            }
                        } catch (Throwable th) {
                            Exceptions.throwOrReport(th, (Observer<?>) subscriber);
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th2) {
                    Exceptions.throwOrReport(th2, (Observer<?>) subscriber);
                    return;
                }
            }
        }
    }

    public OnSubscribeFromIterable(Iterable<? extends T> iterable) {
        if (iterable != null) {
            this.is = iterable;
            return;
        }
        throw new NullPointerException("iterable must not be null");
    }

    public void call(Subscriber<? super T> subscriber) {
        try {
            Iterator it = this.is.iterator();
            boolean hasNext = it.hasNext();
            if (!subscriber.isUnsubscribed()) {
                if (!hasNext) {
                    subscriber.onCompleted();
                } else {
                    subscriber.setProducer(new IterableProducer(subscriber, it));
                }
            }
        } catch (Throwable th) {
            Exceptions.throwOrReport(th, (Observer<?>) subscriber);
        }
    }
}
