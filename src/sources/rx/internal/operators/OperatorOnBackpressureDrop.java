package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action1;
import rx.plugins.RxJavaHooks;

public class OperatorOnBackpressureDrop<T> implements Observable.Operator<T, T> {
    final Action1<? super T> onDrop;

    static final class Holder {
        static final OperatorOnBackpressureDrop<Object> INSTANCE = new OperatorOnBackpressureDrop<>();

        Holder() {
        }
    }

    public static <T> OperatorOnBackpressureDrop<T> instance() {
        return Holder.INSTANCE;
    }

    OperatorOnBackpressureDrop() {
        this((Action1) null);
    }

    public OperatorOnBackpressureDrop(Action1<? super T> action1) {
        this.onDrop = action1;
    }

    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        final AtomicLong atomicLong = new AtomicLong();
        subscriber.setProducer(new Producer() {
            public void request(long j) {
                BackpressureUtils.getAndAddRequest(atomicLong, j);
            }
        });
        return new Subscriber<T>(subscriber) {
            boolean done;

            public void onStart() {
                request(LongCompanionObject.MAX_VALUE);
            }

            public void onCompleted() {
                if (!this.done) {
                    this.done = true;
                    subscriber.onCompleted();
                }
            }

            public void onError(Throwable th) {
                if (!this.done) {
                    this.done = true;
                    subscriber.onError(th);
                    return;
                }
                RxJavaHooks.onError(th);
            }

            public void onNext(T t) {
                if (!this.done) {
                    if (atomicLong.get() > 0) {
                        subscriber.onNext(t);
                        atomicLong.decrementAndGet();
                    } else if (OperatorOnBackpressureDrop.this.onDrop != null) {
                        try {
                            OperatorOnBackpressureDrop.this.onDrop.call(t);
                        } catch (Throwable th) {
                            Exceptions.throwOrReport(th, (Observer<?>) this, (Object) t);
                        }
                    }
                }
            }
        };
    }
}
