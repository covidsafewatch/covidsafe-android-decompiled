package au.gov.health.covidsafe;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "model", "", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: PlotActivity.kt */
final class PlotActivity$onCreate$zipResult$2$yAxis$1 extends Lambda implements Function1<String, CharSequence> {
    final /* synthetic */ List $sortedModelList;
    final /* synthetic */ int $top;

    PlotActivity$onCreate$zipResult$2$yAxis$1(List list, int i) {
        this.$sortedModelList = list;
        this.$top = i;
        super(1);
    }

    public final CharSequence invoke(String str) {
        String str2;
        Intrinsics.checkParameterIsNotNull(str, "model");
        int indexOf = this.$sortedModelList.indexOf(str) + 1;
        if (indexOf < this.$top) {
            StringBuilder sb = new StringBuilder();
            sb.append("\n                                              yaxis");
            sb.append(indexOf);
            sb.append(": {\n                                                range: [-100, -30],\n                                                ticks: 'outside',\n                                                dtick: 10,\n                                                title: {\n                                                  text: \"");
            sb.append(str);
            sb.append("\"\n                                                }\n                                              }\n                                    ");
            str2 = StringsKt.trimIndent(sb.toString());
        } else {
            str2 = "";
        }
        return str2;
    }
}
