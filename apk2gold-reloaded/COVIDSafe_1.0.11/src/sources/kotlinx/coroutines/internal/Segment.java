package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.TypeCastException;
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
        if (!DebugKt.getASSERTIONS_ENABLED() || getRemoved()) {
            Segment segment = (Segment) this._next;
            if (segment != null) {
                Segment segment2 = (Segment) this.prev;
                if (segment2 != null) {
                    segment2.moveNextToRight(segment);
                    while (segment2.getRemoved()) {
                        Segment segment3 = (Segment) segment2.prev;
                        if (segment3 == null) {
                            break;
                        }
                        segment3.moveNextToRight(segment);
                        segment2 = segment3;
                    }
                    segment.movePrevToLeft(segment2);
                    while (segment.getRemoved()) {
                        segment = segment.getNext();
                        if (segment != null) {
                            segment.movePrevToLeft(segment2);
                        } else {
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    private final void moveNextToRight(S s) {
        Segment segment;
        do {
            Object obj = this._next;
            if (obj != null) {
                segment = (Segment) obj;
                if (s.id <= segment.id) {
                    return;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type S");
            }
        } while (!_next$FU.compareAndSet(this, segment, s));
    }

    private final void movePrevToLeft(S s) {
        Segment segment;
        do {
            segment = (Segment) this.prev;
            if (segment == null || segment.id <= s.id) {
                return;
            }
        } while (!prev$FU.compareAndSet(this, segment, s));
    }
}
