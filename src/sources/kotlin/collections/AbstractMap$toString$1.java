package kotlin.collections;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010&\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0006\b\u0001\u0010\u0003 \u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "K", "V", "it", "", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: AbstractMap.kt */
final class AbstractMap$toString$1 extends Lambda implements Function1<Map.Entry<? extends K, ? extends V>, String> {
    final /* synthetic */ AbstractMap this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AbstractMap$toString$1(AbstractMap abstractMap) {
        super(1);
        this.this$0 = abstractMap;
    }

    public final String invoke(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkParameterIsNotNull(entry, "it");
        return this.this$0.toString(entry);
    }
}
