package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable.OnSubscribe;
import rx.Producer;
import rx.Subscriber;

public final class OnSubscribeRange implements OnSubscribe<Integer> {
    private final int endIndex;
    private final int startIndex;

    static final class RangeProducer extends AtomicLong implements Producer {
        private static final long serialVersionUID = 4114392207069098388L;
        private final Subscriber<? super Integer> childSubscriber;
        private long currentIndex;
        private final int endOfRange;

        RangeProducer(Subscriber<? super Integer> subscriber, int i, int i2) {
            this.childSubscriber = subscriber;
            this.currentIndex = (long) i;
            this.endOfRange = i2;
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
            long j2 = ((long) this.endOfRange) + 1;
            long j3 = this.currentIndex;
            Subscriber<? super Integer> subscriber = this.childSubscriber;
            do {
                long j4 = 0;
                while (true) {
                    if (j4 == j || j3 == j2) {
                        if (!subscriber.isUnsubscribed()) {
                            if (j3 == j2) {
                                subscriber.onCompleted();
                                return;
                            }
                            j = get();
                            if (j == j4) {
                                this.currentIndex = j3;
                                j = addAndGet(-j4);
                            }
                        } else {
                            return;
                        }
                    } else if (!subscriber.isUnsubscribed()) {
                        subscriber.onNext(Integer.valueOf((int) j3));
                        j3++;
                        j4++;
                    } else {
                        return;
                    }
                }
            } while (j != 0);
        }

        /* access modifiers changed from: 0000 */
        public void fastPath() {
            long j = ((long) this.endOfRange) + 1;
            Subscriber<? super Integer> subscriber = this.childSubscriber;
            long j2 = this.currentIndex;
            while (j2 != j) {
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onNext(Integer.valueOf((int) j2));
                    j2++;
                } else {
                    return;
                }
            }
            if (!subscriber.isUnsubscribed()) {
                subscriber.onCompleted();
            }
        }
    }

    public OnSubscribeRange(int i, int i2) {
        this.startIndex = i;
        this.endIndex = i2;
    }

    public void call(Subscriber<? super Integer> subscriber) {
        subscriber.setProducer(new RangeProducer(subscriber, this.startIndex, this.endIndex));
    }
}
