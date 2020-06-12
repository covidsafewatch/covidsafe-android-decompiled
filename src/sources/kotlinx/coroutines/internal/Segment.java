package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.Segment;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\b \u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u00020\u001cB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00018\u00002\b\u0010\b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\r\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\f\u001a\u0004\u0018\u00018\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/internal/Segment;", "S", "", "id", "prev", "<init>", "(JLkotlinx/coroutines/internal/Segment;)V", "expected", "value", "", "casNext", "(Lkotlinx/coroutines/internal/Segment;Lkotlinx/coroutines/internal/Segment;)Z", "next", "", "moveNextToRight", "(Lkotlinx/coroutines/internal/Segment;)V", "movePrevToLeft", "remove", "()V", "J", "getId", "()J", "getNext", "()Lkotlinx/coroutines/internal/Segment;", "getRemoved", "()Z", "removed", "kotlinx-coroutines-core", ""}, k = 1, mv = {1, 1, 16})
/* compiled from: SegmentQueue.kt */
public abstract class Segment<S extends Segment<S>> {
    private static final AtomicReferenceFieldUpdater _next$FU;
    static final AtomicReferenceFieldUpdater prev$FU;
    private volatile Object _next = null;
    private final long id;
    volatile Object prev = null;

    static {
        Class<Segment> cls = Segment.class;
        _next$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_next");
        prev$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "prev");
    }

    public abstract boolean getRemoved();

    public Segment(long j, S s) {
        this.id = j;
        this.prev = s;
    }

    public final long getId() {
        return this.id;
    }

    public final S getNext() {
        return (Segment) this._next;
    }

    public final boolean casNext(S s, S s2) {
        return _next$FU.compareAndSet(this, s, s2);
    }

    public final void remove() {
        Segment segment;
        Segment segment2;
        if (!DebugKt.getASSERTIONS_ENABLED() || getRemoved()) {
            Segment segment3 = (Segment) this._next;
            if (segment3 != null && (segment = (Segment) this.prev) != null) {
                segment.moveNextToRight(segment3);
                while (segment.getRemoved() && (segment2 = (Segment) segment.prev) != null) {
                    segment2.moveNextToRight(segment3);
                    segment = segment2;
                }
                segment3.movePrevToLeft(segment);
                while (segment3.getRemoved() && (segment3 = segment3.getNext()) != null) {
                    segment3.movePrevToLeft(segment);
                }
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void moveNextToRight(S r7) {
        /*
            r6 = this;
        L_0x0000:
            java.lang.Object r0 = r6._next
            if (r0 == 0) goto L_0x0018
            kotlinx.coroutines.internal.Segment r0 = (kotlinx.coroutines.internal.Segment) r0
            long r1 = r7.id
            long r3 = r0.id
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x000f
            return
        L_0x000f:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = _next$FU
            boolean r0 = r1.compareAndSet(r6, r0, r7)
            if (r0 == 0) goto L_0x0000
            return
        L_0x0018:
            kotlin.TypeCastException r7 = new kotlin.TypeCastException
            java.lang.String r0 = "null cannot be cast to non-null type S"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.Segment.moveNextToRight(kotlinx.coroutines.internal.Segment):void");
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    private final void movePrevToLeft(S r7) {
        /*
            r6 = this;
        L_0x0000:
            java.lang.Object r0 = r6.prev
            kotlinx.coroutines.internal.Segment r0 = (kotlinx.coroutines.internal.Segment) r0
            if (r0 == 0) goto L_0x0017
            long r1 = r0.id
            long r3 = r7.id
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x000f
            return
        L_0x000f:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = prev$FU
            boolean r0 = r1.compareAndSet(r6, r0, r7)
            if (r0 == 0) goto L_0x0000
        L_0x0017:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.Segment.movePrevToLeft(kotlinx.coroutines.internal.Segment):void");
    }
}
