package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0015\n\u0000\n\u0002\u0010(\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\t\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\nR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0004¨\u0006\u000b"}, d2 = {"kotlin/sequences/MergingSequence$iterator$1", "", "iterator1", "getIterator1", "()Ljava/util/Iterator;", "iterator2", "getIterator2", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* compiled from: Sequences.kt */
public final class MergingSequence$iterator$1 implements Iterator<V>, KMappedMarker {
    private final Iterator<T1> iterator1;
    private final Iterator<T2> iterator2;
    final /* synthetic */ MergingSequence this$0;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    MergingSequence$iterator$1(MergingSequence mergingSequence) {
        this.this$0 = mergingSequence;
        this.iterator1 = mergingSequence.sequence1.iterator();
        this.iterator2 = mergingSequence.sequence2.iterator();
    }

    public final Iterator<T1> getIterator1() {
        return this.iterator1;
    }

    public final Iterator<T2> getIterator2() {
        return this.iterator2;
    }

    public V next() {
        return this.this$0.transform.invoke(this.iterator1.next(), this.iterator2.next());
    }

    public boolean hasNext() {
        return this.iterator1.hasNext() && this.iterator2.hasNext();
    }
}
