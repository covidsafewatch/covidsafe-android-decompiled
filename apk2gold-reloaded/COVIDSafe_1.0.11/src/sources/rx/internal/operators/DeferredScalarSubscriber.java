package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;

public abstract class DeferredScalarSubscriber<T, R> extends Subscriber<T> {
    static final int HAS_REQUEST_HAS_VALUE = 3;
    static final int HAS_REQUEST_NO_VALUE = 1;
    static final int NO_REQUEST_HAS_VALUE = 2;
    static final int NO_REQUEST_NO_VALUE = 0;
    protected final Subscriber<? super R> actual;
    protected boolean hasValue;
    final AtomicInteger state = new AtomicInteger();
    protected R value;

    static final class InnerProducer implements Producer {
        final DeferredScalarSubscriber<?, ?> parent;

        public InnerProducer(DeferredScalarSubscriber<?, ?> deferredScalarSubscriber) {
            this.parent = deferredScalarSubscriber;
        }

        public void request(long j) {
            this.parent.downstreamRequest(j);
        }
    }

    public DeferredScalarSubscriber(Subscriber<? super R> subscriber) {
        this.actual = subscriber;
    }

    public void onError(Throwable th) {
        this.value = null;
        this.actual.onError(th);
    }

    public void onCompleted() {
        if (this.hasValue) {
            complete(this.value);
        } else {
            complete();
        }
    }

    /* access modifiers changed from: protected */
    public final void complete() {
        this.actual.onCompleted();
    }

    /* access modifiers changed from: protected */
    public final void complete(R r) {
        Subscriber<? super R> subscriber = this.actual;
        do {
            int i = this.state.get();
            if (i != 2 && i != 3 && !subscriber.isUnsubscribed()) {
                if (i == 1) {
                    subscriber.onNext(r);
                    if (!subscriber.isUnsubscribed()) {
                        subscriber.onCompleted();
                    }
                    this.state.lazySet(3);
                    return;
                }
                this.value = r;
            }
        } while (!this.state.compareAndSet(0, 2));
    }

    /* access modifiers changed from: 0000 */
    public final void downstreamRequest(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i >= 0) {
            if (i != 0) {
                Subscriber<? super R> subscriber = this.actual;
                do {
                    int i2 = this.state.get();
                    if (i2 == 1 || i2 == 3 || subscriber.isUnsubscribed()) {
                        break;
                    } else if (i2 == 2) {
                        if (this.state.compareAndSet(2, 3)) {
                            subscriber.onNext(this.value);
                            if (!subscriber.isUnsubscribed()) {
                                subscriber.onCompleted();
                            }
                        }
                        return;
                    }
                } while (!this.state.compareAndSet(0, 1));
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("n >= 0 required but it was ");
        sb.append(j);
        throw new IllegalArgumentException(sb.toString());
    }

    public final void setProducer(Producer producer) {
        producer.request(LongCompanionObject.MAX_VALUE);
    }

    public final void subscribeTo(Observable<? extends T> observable) {
        setupDownstream();
        observable.unsafeSubscribe(this);
    }

    /* access modifiers changed from: 0000 */
    public final void setupDownstream() {
        Subscriber<? super R> subscriber = this.actual;
        subscriber.add(this);
        subscriber.setProducer(new InnerProducer(this));
    }
}
