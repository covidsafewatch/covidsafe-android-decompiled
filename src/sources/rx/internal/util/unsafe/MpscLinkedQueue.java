package rx.internal.util.unsafe;

import rx.internal.util.atomic.LinkedQueueNode;

public final class MpscLinkedQueue<E> extends BaseLinkedQueue<E> {
    public MpscLinkedQueue() {
        this.consumerNode = new LinkedQueueNode();
        xchgProducerNode(this.consumerNode);
    }

    /* access modifiers changed from: protected */
    public LinkedQueueNode<E> xchgProducerNode(LinkedQueueNode<E> linkedQueueNode) {
        LinkedQueueNode<E> linkedQueueNode2;
        do {
            linkedQueueNode2 = this.producerNode;
        } while (!UnsafeAccess.UNSAFE.compareAndSwapObject(this, P_NODE_OFFSET, linkedQueueNode2, linkedQueueNode));
        return linkedQueueNode2;
    }

    public boolean offer(E e) {
        if (e != null) {
            LinkedQueueNode linkedQueueNode = new LinkedQueueNode(e);
            xchgProducerNode(linkedQueueNode).soNext(linkedQueueNode);
            return true;
        }
        throw new NullPointerException("null elements not allowed");
    }

    public E poll() {
        LinkedQueueNode lvNext;
        LinkedQueueNode lpConsumerNode = lpConsumerNode();
        LinkedQueueNode lvNext2 = lpConsumerNode.lvNext();
        if (lvNext2 != null) {
            E andNullValue = lvNext2.getAndNullValue();
            spConsumerNode(lvNext2);
            return andNullValue;
        } else if (lpConsumerNode == lvProducerNode()) {
            return null;
        } else {
            do {
                lvNext = lpConsumerNode.lvNext();
            } while (lvNext == null);
            E andNullValue2 = lvNext.getAndNullValue();
            this.consumerNode = lvNext;
            return andNullValue2;
        }
    }

    public E peek() {
        LinkedQueueNode lvNext;
        LinkedQueueNode linkedQueueNode = this.consumerNode;
        LinkedQueueNode lvNext2 = linkedQueueNode.lvNext();
        if (lvNext2 != null) {
            return lvNext2.lpValue();
        }
        if (linkedQueueNode == lvProducerNode()) {
            return null;
        }
        do {
            lvNext = linkedQueueNode.lvNext();
        } while (lvNext == null);
        return lvNext.lpValue();
    }
}
