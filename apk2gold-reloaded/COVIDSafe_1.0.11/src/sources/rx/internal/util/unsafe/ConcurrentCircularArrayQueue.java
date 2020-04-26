package rx.internal.util.unsafe;

import java.util.Iterator;

public abstract class ConcurrentCircularArrayQueue<E> extends ConcurrentCircularArrayQueueL0Pad<E> {
    protected static final int BUFFER_PAD = 32;
    private static final long REF_ARRAY_BASE = ((long) (UnsafeAccess.UNSAFE.arrayBaseOffset(Object[].class) + (32 << (REF_ELEMENT_SHIFT - SPARSE_SHIFT))));
    private static final int REF_ELEMENT_SHIFT;
    protected static final int SPARSE_SHIFT = Integer.getInteger("sparse.shift", 0).intValue();
    protected final E[] buffer;
    protected final long mask;

    static {
        int arrayIndexScale = UnsafeAccess.UNSAFE.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            REF_ELEMENT_SHIFT = SPARSE_SHIFT + 2;
        } else if (8 == arrayIndexScale) {
            REF_ELEMENT_SHIFT = SPARSE_SHIFT + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
    }

    public ConcurrentCircularArrayQueue(int i) {
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(i);
        this.mask = (long) (roundToPowerOfTwo - 1);
        this.buffer = (Object[]) new Object[((roundToPowerOfTwo << SPARSE_SHIFT) + 64)];
    }

    /* access modifiers changed from: protected */
    public final long calcElementOffset(long j) {
        return calcElementOffset(j, this.mask);
    }

    /* access modifiers changed from: protected */
    public final long calcElementOffset(long j, long j2) {
        return REF_ARRAY_BASE + ((j & j2) << REF_ELEMENT_SHIFT);
    }

    /* access modifiers changed from: protected */
    public final void spElement(long j, E e) {
        spElement(this.buffer, j, e);
    }

    /* access modifiers changed from: protected */
    public final void spElement(E[] eArr, long j, E e) {
        UnsafeAccess.UNSAFE.putObject(eArr, j, e);
    }

    /* access modifiers changed from: protected */
    public final void soElement(long j, E e) {
        soElement(this.buffer, j, e);
    }

    /* access modifiers changed from: protected */
    public final void soElement(E[] eArr, long j, E e) {
        UnsafeAccess.UNSAFE.putOrderedObject(eArr, j, e);
    }

    /* access modifiers changed from: protected */
    public final E lpElement(long j) {
        return lpElement(this.buffer, j);
    }

    /* access modifiers changed from: protected */
    public final E lpElement(E[] eArr, long j) {
        return UnsafeAccess.UNSAFE.getObject(eArr, j);
    }

    /* access modifiers changed from: protected */
    public final E lvElement(long j) {
        return lvElement(this.buffer, j);
    }

    /* access modifiers changed from: protected */
    public final E lvElement(E[] eArr, long j) {
        return UnsafeAccess.UNSAFE.getObjectVolatile(eArr, j);
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
}
