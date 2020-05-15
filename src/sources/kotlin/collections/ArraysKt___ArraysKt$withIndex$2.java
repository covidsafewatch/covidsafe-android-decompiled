package kotlin.collections;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lkotlin/collections/ByteIterator;", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: _Arrays.kt */
final class ArraysKt___ArraysKt$withIndex$2 extends Lambda implements Function0<ByteIterator> {
    final /* synthetic */ byte[] $this_withIndex;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ArraysKt___ArraysKt$withIndex$2(byte[] bArr) {
        super(0);
        this.$this_withIndex = bArr;
    }

    public final ByteIterator invoke() {
        return ArrayIteratorsKt.iterator(this.$this_withIndex);
    }
}
