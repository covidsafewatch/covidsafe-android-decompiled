package rx.internal.util.atomic;

import java.util.concurrent.atomic.AtomicReference;

public final class LinkedQueueNode<E> extends AtomicReference<LinkedQueueNode<E>> {
    private static final long serialVersionUID = 2404266111789071508L;
    private E value;

    public LinkedQueueNode() {
    }

    public LinkedQueueNode(E e) {
        spValue(e);
    }

    public E getAndNullValue() {
        E lpValue = lpValue();
        spValue((Object) null);
        return lpValue;
    }

    public E lpValue() {
        return this.value;
    }

    public void spValue(E e) {
        this.value = e;
    }

    public void soNext(LinkedQueueNode<E> linkedQueueNode) {
        lazySet(linkedQueueNode);
    }

    public LinkedQueueNode<E> lvNext() {
        return (LinkedQueueNode) get();
    }
}
