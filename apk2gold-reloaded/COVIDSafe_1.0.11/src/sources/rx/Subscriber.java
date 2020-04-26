package rx;

import kotlin.jvm.internal.LongCompanionObject;
import rx.internal.util.SubscriptionList;

public abstract class Subscriber<T> implements Observer<T>, Subscription {
    private static final long NOT_SET = Long.MIN_VALUE;
    private Producer producer;
    private long requested;
    private final Subscriber<?> subscriber;
    private final SubscriptionList subscriptions;

    public void onStart() {
    }

    protected Subscriber() {
        this(null, false);
    }

    protected Subscriber(Subscriber<?> subscriber2) {
        this(subscriber2, true);
    }

    protected Subscriber(Subscriber<?> subscriber2, boolean z) {
        this.requested = Long.MIN_VALUE;
        this.subscriber = subscriber2;
        this.subscriptions = (!z || subscriber2 == null) ? new SubscriptionList() : subscriber2.subscriptions;
    }

    public final void add(Subscription subscription) {
        this.subscriptions.add(subscription);
    }

    public final void unsubscribe() {
        this.subscriptions.unsubscribe();
    }

    public final boolean isUnsubscribed() {
        return this.subscriptions.isUnsubscribed();
    }

    /* access modifiers changed from: protected */
    public final void request(long j) {
        if (j >= 0) {
            synchronized (this) {
                if (this.producer != null) {
                    Producer producer2 = this.producer;
                    producer2.request(j);
                    return;
                }
                addToRequested(j);
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("number requested cannot be negative: ");
        sb.append(j);
        throw new IllegalArgumentException(sb.toString());
    }

    private void addToRequested(long j) {
        long j2 = this.requested;
        if (j2 == Long.MIN_VALUE) {
            this.requested = j;
            return;
        }
        long j3 = j2 + j;
        if (j3 < 0) {
            this.requested = LongCompanionObject.MAX_VALUE;
        } else {
            this.requested = j3;
        }
    }

    public void setProducer(Producer producer2) {
        long j;
        boolean z;
        synchronized (this) {
            j = this.requested;
            this.producer = producer2;
            z = this.subscriber != null && j == Long.MIN_VALUE;
        }
        if (z) {
            this.subscriber.setProducer(this.producer);
        } else if (j == Long.MIN_VALUE) {
            this.producer.request(LongCompanionObject.MAX_VALUE);
        } else {
            this.producer.request(j);
        }
    }
}
