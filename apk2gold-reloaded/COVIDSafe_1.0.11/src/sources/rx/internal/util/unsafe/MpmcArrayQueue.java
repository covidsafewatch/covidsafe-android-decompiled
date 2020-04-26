package rx.internal.util.unsafe;

import kotlin.jvm.internal.LongCompanionObject;

public class MpmcArrayQueue<E> extends MpmcArrayQueueConsumerField<E> {
    long p30;
    long p31;
    long p32;
    long p33;
    long p34;
    long p35;
    long p36;
    long p37;
    long p40;
    long p41;
    long p42;
    long p43;
    long p44;
    long p45;
    long p46;

    public MpmcArrayQueue(int i) {
        super(Math.max(2, i));
    }

    public boolean offer(E e) {
        E e2 = e;
        if (e2 != null) {
            long j = this.mask + 1;
            long[] jArr = this.sequenceBuffer;
            long j2 = LongCompanionObject.MAX_VALUE;
            while (true) {
                long lvProducerIndex = lvProducerIndex();
                long calcSequenceOffset = calcSequenceOffset(lvProducerIndex);
                int i = ((lvSequence(jArr, calcSequenceOffset) - lvProducerIndex) > 0 ? 1 : ((lvSequence(jArr, calcSequenceOffset) - lvProducerIndex) == 0 ? 0 : -1));
                if (i == 0) {
                    long j3 = lvProducerIndex + 1;
                    if (casProducerIndex(lvProducerIndex, j3)) {
                        spElement(calcElementOffset(lvProducerIndex), e2);
                        soSequence(jArr, calcSequenceOffset, j3);
                        return true;
                    }
                } else if (i < 0) {
                    long j4 = lvProducerIndex - j;
                    if (j4 <= j2) {
                        j2 = lvConsumerIndex();
                        if (j4 <= j2) {
                            return false;
                        }
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
        } else {
            throw new NullPointerException("Null is not a valid element");
        }
    }

    public E poll() {
        long[] jArr = this.sequenceBuffer;
        long j = -1;
        while (true) {
            long lvConsumerIndex = lvConsumerIndex();
            long calcSequenceOffset = calcSequenceOffset(lvConsumerIndex);
            long j2 = lvConsumerIndex + 1;
            int i = ((lvSequence(jArr, calcSequenceOffset) - j2) > 0 ? 1 : ((lvSequence(jArr, calcSequenceOffset) - j2) == 0 ? 0 : -1));
            if (i == 0) {
                if (casConsumerIndex(lvConsumerIndex, j2)) {
                    long calcElementOffset = calcElementOffset(lvConsumerIndex);
                    E lpElement = lpElement(calcElementOffset);
                    spElement(calcElementOffset, null);
                    soSequence(jArr, calcSequenceOffset, lvConsumerIndex + this.mask + 1);
                    return lpElement;
                }
            } else if (i < 0 && lvConsumerIndex >= j) {
                j = lvProducerIndex();
                if (lvConsumerIndex == j) {
                    return null;
                }
            }
        }
    }

    public E peek() {
        long lvConsumerIndex;
        E lpElement;
        do {
            lvConsumerIndex = lvConsumerIndex();
            lpElement = lpElement(calcElementOffset(lvConsumerIndex));
            if (lpElement != null) {
                break;
            }
        } while (lvConsumerIndex != lvProducerIndex());
        return lpElement;
    }

    public int size() {
        long lvConsumerIndex = lvConsumerIndex();
        while (true) {
            long lvProducerIndex = lvProducerIndex();
            long lvConsumerIndex2 = lvConsumerIndex();
            if (lvConsumerIndex == lvConsumerIndex2) {
                return (int) (lvProducerIndex - lvConsumerIndex2);
            }
            lvConsumerIndex = lvConsumerIndex2;
        }
    }

    public boolean isEmpty() {
        return lvConsumerIndex() == lvProducerIndex();
    }
}
