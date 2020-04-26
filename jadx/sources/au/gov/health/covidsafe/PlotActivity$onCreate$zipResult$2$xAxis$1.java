package au.gov.health.covidsafe;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "model", "", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: PlotActivity.kt */
final class PlotActivity$onCreate$zipResult$2$xAxis$1 extends Lambda implements Function1<String, CharSequence> {
    final /* synthetic */ String $endTimeString;
    final /* synthetic */ List $sortedModelList;
    final /* synthetic */ String $startTimeString;
    final /* synthetic */ int $top;
    final /* synthetic */ PlotActivity$onCreate$zipResult$2 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PlotActivity$onCreate$zipResult$2$xAxis$1(PlotActivity$onCreate$zipResult$2 plotActivity$onCreate$zipResult$2, List list, int i, String str, String str2) {
        super(1);
        this.this$0 = plotActivity$onCreate$zipResult$2;
        this.$sortedModelList = list;
        this.$top = i;
        this.$startTimeString = str;
        this.$endTimeString = str2;
    }

    public final CharSequence invoke(String str) {
        String str2;
        Intrinsics.checkParameterIsNotNull(str, "model");
        int indexOf = this.$sortedModelList.indexOf(str) + 1;
        if (indexOf < this.$top) {
            str2 = StringsKt.trimIndent("\n                                              xaxis" + indexOf + ": {\n                                                type: 'date',\n                                                tickformat: '%H:%M:%S',\n                                                range: ['" + this.$startTimeString + "', '" + this.$endTimeString + "'],\n                                                dtick: " + (this.this$0.$displayTimePeriod * 5) + " * 60 * 1000\n                                              }\n                                    ");
        } else {
            str2 = "";
        }
        return str2;
    }
}
