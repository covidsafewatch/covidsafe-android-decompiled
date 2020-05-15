package kotlin.text;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "currentIndex", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: Strings.kt */
final class StringsKt__StringsKt$rangesDelimitedBy$4 extends Lambda implements Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {
    final /* synthetic */ List $delimitersList;
    final /* synthetic */ boolean $ignoreCase;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StringsKt__StringsKt$rangesDelimitedBy$4(List list, boolean z) {
        super(2);
        this.$delimitersList = list;
        this.$ignoreCase = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((CharSequence) obj, ((Number) obj2).intValue());
    }

    public final Pair<Integer, Integer> invoke(CharSequence charSequence, int i) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        Pair access$findAnyOf = StringsKt__StringsKt.findAnyOf$StringsKt__StringsKt(charSequence, this.$delimitersList, i, this.$ignoreCase, false);
        if (access$findAnyOf != null) {
            return TuplesKt.to(access$findAnyOf.getFirst(), Integer.valueOf(((String) access$findAnyOf.getSecond()).length()));
        }
        return null;
    }
}
