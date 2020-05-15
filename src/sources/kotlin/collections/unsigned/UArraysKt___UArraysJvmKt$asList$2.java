package kotlin.collections.unsigned;

import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\u001b\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0006H\u0002ø\u0001\u0000J\u001a\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0013\u001a\u00020\nH\u0016J\u001a\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"kotlin/collections/unsigned/UArraysKt___UArraysJvmKt$asList$2", "Lkotlin/collections/AbstractList;", "Lkotlin/ULong;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "", "getSize", "()I", "contains", "", "element", "contains-VKZWuLQ", "(J)Z", "get", "index", "indexOf", "indexOf-VKZWuLQ", "(J)I", "isEmpty", "lastIndexOf", "lastIndexOf-VKZWuLQ", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* compiled from: _UArraysJvm.kt */
public final class UArraysKt___UArraysJvmKt$asList$2 extends AbstractList<ULong> implements RandomAccess {
    final /* synthetic */ long[] $this_asList;

    UArraysKt___UArraysJvmKt$asList$2(long[] jArr) {
        this.$this_asList = jArr;
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ULong) {
            return m374containsVKZWuLQ(((ULong) obj).m201unboximpl());
        }
        return false;
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ULong) {
            return m375indexOfVKZWuLQ(((ULong) obj).m201unboximpl());
        }
        return -1;
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ULong) {
            return m376lastIndexOfVKZWuLQ(((ULong) obj).m201unboximpl());
        }
        return -1;
    }

    public int getSize() {
        return ULongArray.m210getSizeimpl(this.$this_asList);
    }

    public boolean isEmpty() {
        return ULongArray.m212isEmptyimpl(this.$this_asList);
    }

    /* renamed from: contains-VKZWuLQ  reason: not valid java name */
    public boolean m374containsVKZWuLQ(long j) {
        return ULongArray.m205containsVKZWuLQ(this.$this_asList, j);
    }

    public ULong get(int i) {
        return ULong.m152boximpl(ULongArray.m209getimpl(this.$this_asList, i));
    }

    /* renamed from: indexOf-VKZWuLQ  reason: not valid java name */
    public int m375indexOfVKZWuLQ(long j) {
        return ArraysKt.indexOf(this.$this_asList, j);
    }

    /* renamed from: lastIndexOf-VKZWuLQ  reason: not valid java name */
    public int m376lastIndexOfVKZWuLQ(long j) {
        return ArraysKt.lastIndexOf(this.$this_asList, j);
    }
}
