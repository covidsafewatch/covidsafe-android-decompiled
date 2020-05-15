package au.gov.health.covidsafe;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "a", "", "b", "compare"}, k = 3, mv = {1, 1, 16})
/* compiled from: PlotActivity.kt */
final class PlotActivity$onCreate$zipResult$2$sortedModelList$1<T> implements Comparator<String> {
    final /* synthetic */ Map $dataByModelC;
    final /* synthetic */ Map $dataByModelP;

    PlotActivity$onCreate$zipResult$2$sortedModelList$1(Map map, Map map2) {
        this.$dataByModelC = map;
        this.$dataByModelP = map2;
    }

    public final int compare(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "a");
        Intrinsics.checkParameterIsNotNull(str2, "b");
        List list = (List) this.$dataByModelC.get(str);
        int i = 0;
        int size = list != null ? list.size() : 0;
        List list2 = (List) this.$dataByModelP.get(str);
        int size2 = size + (list2 != null ? list2.size() : 0);
        List list3 = (List) this.$dataByModelC.get(str2);
        int size3 = list3 != null ? list3.size() : 0;
        List list4 = (List) this.$dataByModelP.get(str2);
        if (list4 != null) {
            i = list4.size();
        }
        return (size3 + i) - size2;
    }
}
