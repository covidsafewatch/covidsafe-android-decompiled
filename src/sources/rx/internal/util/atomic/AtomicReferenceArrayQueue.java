package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.unsafe.Pow2;

abstract class AtomicReferenceArrayQueue<E> extends AbstractQueue<E> {
    protected final AtomicReferenceArray<E> buffer;
    protected final int mask;

    /* access modifiers changed from: protected */
    public final int calcElementOffset(long j, int i) {
        return ((int) j) & i;
    }

    public AtomicReferenceArrayQueue(int i) {
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(i);
        this.mask = roundToPowerOfTwo - 1;
        this.buffer = new AtomicReferenceArray<>(roundToPowerOfTwo);
    }

    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final int calcElementOffset(long j) {
        return this.mask & ((int) j);
    }

    /* access modifiers changed from: protected */
    public final E lvElement(AtomicReferenceArray<E> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    /* access modifiers changed from: protected */
    public final E lpElement(AtomicReferenceArray<E> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    /* access modifiers changed from: protected */
    public final E lpElement(int i) {
        return this.buffer.get(i);
    }

    /* access modifiers changed from: protected */
    public final void spElement(AtomicReferenceArray<E> atomicReferenceArray, int i, E e) {
        atomicReferenceArray.lazySet(i, e);
    }

    /* access modifiers changed from: protected */
    public final void spElement(int i, E e) {
        this.buffer.lazySet(i, e);
    }

    /* access modifiers changed from: protected */
    public final void soElement(AtomicReferenceArray<E> atomicReferenceArray, int i, E e) {
        atomicReferenceArray.lazySet(i, e);
    }

    /* access modifiers changed from: protected */
    public final void soElement(int i, E e) {
        this.buffer.lazySet(i, e);
    }

    /* access modifiers changed from: protected */
    public final void svElement(AtomicReferenceArray<E> atomicReferenceArray, int i, E e) {
        atomicReferenceArray.set(i, e);
    }

    /* access modifiers changed from: protected */
    public final E lvElement(int i) {
        return lvElement(this.buffer, i);
    }
}
