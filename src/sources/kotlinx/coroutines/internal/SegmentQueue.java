package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.Segment;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u0000\b \u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0019B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0004¢\u0006\u0004\b\b\u0010\tJ!\u0010\n\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0004¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ#\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00028\u00008D@\u0004X\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00028\u00008D@\u0004X\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/internal/SegmentQueue;", "Lkotlinx/coroutines/internal/Segment;", "S", "<init>", "()V", "startFrom", "", "id", "getSegment", "(Lkotlinx/coroutines/internal/Segment;J)Lkotlinx/coroutines/internal/Segment;", "getSegmentAndMoveHead", "new", "", "moveHeadForward", "(Lkotlinx/coroutines/internal/Segment;)V", "moveTailForward", "prev", "newSegment", "(JLkotlinx/coroutines/internal/Segment;)Lkotlinx/coroutines/internal/Segment;", "getHead", "()Lkotlinx/coroutines/internal/Segment;", "head", "getTail", "tail", "kotlinx-coroutines-core", ""}, k = 1, mv = {1, 1, 16})
/* compiled from: SegmentQueue.kt */
public abstract class SegmentQueue<S extends Segment<S>> {
    private static final AtomicReferenceFieldUpdater _head$FU;
    private static final AtomicReferenceFieldUpdater _tail$FU;
    private volatile Object _head;
    private volatile Object _tail;

    static {
        Class<SegmentQueue> cls = SegmentQueue.class;
        _head$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_head");
        _tail$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_tail");
    }

    public abstract S newSegment(long j, S s);

    public SegmentQueue() {
        Segment newSegment$default = newSegment$default(this, 0, (Segment) null, 2, (Object) null);
        this._head = newSegment$default;
        this._tail = newSegment$default;
    }

    /* access modifiers changed from: protected */
    public final S getHead() {
        return (Segment) this._head;
    }

    /* access modifiers changed from: protected */
    public final S getTail() {
        return (Segment) this._tail;
    }

    public static /* synthetic */ Segment newSegment$default(SegmentQueue segmentQueue, long j, Segment segment, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                segment = null;
            }
            return segmentQueue.newSegment(j, segment);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: newSegment");
    }

    /* access modifiers changed from: protected */
    public final S getSegment(S s, long j) {
        while (s.getId() < j) {
            S next = s.getNext();
            if (next == null) {
                next = newSegment(s.getId() + 1, s);
                if (s.casNext(null, next)) {
                    if (s.getRemoved()) {
                        s.remove();
                    }
                    moveTailForward(next);
                } else {
                    next = s.getNext();
                    if (next == null) {
                        Intrinsics.throwNpe();
                    }
                }
            }
            s = next;
        }
        if (s.getId() != j) {
            return null;
        }
        return s;
    }

    /* access modifiers changed from: protected */
    public final S getSegmentAndMoveHead(S s, long j) {
        if (s.getId() == j) {
            return s;
        }
        S segment = getSegment(s, j);
        if (segment == null) {
            return null;
        }
        moveHeadForward(segment);
        return segment;
    }

    private final void moveHeadForward(S s) {
        Segment segment;
        do {
            segment = (Segment) this._head;
            if (segment.getId() > s.getId()) {
                return;
            }
        } while (!_head$FU.compareAndSet(this, segment, s));
        s.prev = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void moveTailForward(S r7) {
        /*
            r6 = this;
        L_0x0000:
            java.lang.Object r0 = r6._tail
            kotlinx.coroutines.internal.Segment r0 = (kotlinx.coroutines.internal.Segment) r0
            long r1 = r0.getId()
            long r3 = r7.getId()
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0011
            return
        L_0x0011:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = _tail$FU
            boolean r0 = r1.compareAndSet(r6, r0, r7)
            if (r0 == 0) goto L_0x0000
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.SegmentQueue.moveTailForward(kotlinx.coroutines.internal.Segment):void");
    }
}
