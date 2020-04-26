package io.reactivex.internal.subscribers;

import java.util.concurrent.atomic.AtomicLong;

/* compiled from: QueueDrainSubscriber */
class QueueDrainSubscriberPad3 extends QueueDrainSubscriberPad2 {
    final AtomicLong requested = new AtomicLong();

    QueueDrainSubscriberPad3() {
    }
}
