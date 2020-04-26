package rx.internal.util.unsafe;

import java.util.AbstractQueue;

/* compiled from: SpscUnboundedArrayQueue */
abstract class SpscUnboundedArrayQueueProducerFields<E> extends AbstractQueue<E> {
    protected long producerIndex;

    SpscUnboundedArrayQueueProducerFields() {
    }
}
