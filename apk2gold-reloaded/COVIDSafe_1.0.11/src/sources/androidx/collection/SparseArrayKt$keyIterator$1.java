package androidx.collection;

import kotlin.Metadata;
import kotlin.collections.IntIterator;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\t\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"androidx/collection/SparseArrayKt$keyIterator$1", "Lkotlin/collections/IntIterator;", "index", "", "getIndex", "()I", "setIndex", "(I)V", "hasNext", "", "nextInt", "collection-ktx"}, k = 1, mv = {1, 1, 13})
/* compiled from: SparseArray.kt */
public final class SparseArrayKt$keyIterator$1 extends IntIterator {
    final /* synthetic */ SparseArrayCompat $this_keyIterator;
    private int index;

    SparseArrayKt$keyIterator$1(SparseArrayCompat<T> sparseArrayCompat) {
        this.$this_keyIterator = sparseArrayCompat;
    }

    public final int getIndex() {
        return this.index;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public boolean hasNext() {
        return this.index < this.$this_keyIterator.size();
    }

    public int nextInt() {
        SparseArrayCompat sparseArrayCompat = this.$this_keyIterator;
        int i = this.index;
        this.index = i + 1;
        return sparseArrayCompat.keyAt(i);
    }
}
