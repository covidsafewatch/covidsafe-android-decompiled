package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable.OnSubscribe;
import rx.Producer;
import rx.Subscriber;

public final class OnSubscribeFromArray<T> implements OnSubscribe<T> {
    final T[] array;

    static final class FromArrayProducer<T> extends AtomicLong implements Producer {
        private static final long serialVersionUID = 3534218984725836979L;
        final T[] array;
        final Subscriber<? super T> child;
        int index;

        public FromArrayProducer(Subscriber<? super T> subscriber, T[] tArr) {
            this.child = subscriber;
            this.array = tArr;
        }

        public void request(long j) {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("n >= 0 required but it was ");
                sb.append(j);
                throw new IllegalArgumentException(sb.toString());
            } else if (j == LongCompanionObject.MAX_VALUE) {
                if (BackpressureUtils.getAndAddRequest(this, j) == 0) {
                    fastPath();
                }
            } else if (i != 0 && BackpressureUtils.getAndAddRequest(this, j) == 0) {
                slowPath(j);
            }
        }

        /* access modifiers changed from: 0000 */
        public void fastPath() {
            Subscriber<? super T> subscriber = this.child;
            T[] tArr = this.array;
            int length = tArr.length;
            int i = 0;
            while (i < length) {
                T t = tArr[i];
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onNext(t);
                    i++;
                } else {
                    return;
                }
            }
            if (!subscriber.isUnsubscribed()) {
                subscriber.onCompleted();
            }
        }

        /* access modifiers changed from: 0000 */
        public void slowPath(long j) {
            Subscriber<? super T> subscriber = this.child;
            T[] tArr = this.array;
            int length = tArr.length;
            int i = this.index;
            do {
                long j2 = 0;
                while (true) {
                    if (r11 == 0 || i == length) {
                        r11 = get() + j2;
                        if (r11 == 0) {
                            this.index = i;
                            j = addAndGet(j2);
                        }
                    } else if (!subscriber.isUnsubscribed()) {
                        subscriber.onNext(tArr[i]);
                        i++;
                        if (i == length) {
                            if (!subscriber.isUnsubscribed()) {
                                subscriber.onCompleted();
                            }
                            return;
                        }
                        r11--;
                        j2--;
                    } else {
                        return;
                    }
                }
            } while (j != 0);
        }
    }

    public OnSubscribeFromArray(T[] tArr) {
        this.array = tArr;
    }

    public void call(Subscriber<? super T> subscriber) {
        subscriber.setProducer(new FromArrayProducer(subscriber, this.array));
    }
}
