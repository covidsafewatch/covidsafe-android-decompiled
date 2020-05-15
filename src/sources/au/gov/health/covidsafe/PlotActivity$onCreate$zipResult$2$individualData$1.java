package au.gov.health.covidsafe;

import au.gov.health.covidsafe.streetpass.persistence.StreetPassRecord;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "model", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: PlotActivity.kt */
final class PlotActivity$onCreate$zipResult$2$individualData$1 extends Lambda implements Function1<String, String> {
    final /* synthetic */ Map $dataByModelC;
    final /* synthetic */ Map $dataByModelP;
    final /* synthetic */ SimpleDateFormat $dateFormatter;
    final /* synthetic */ List $sortedModelList;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PlotActivity$onCreate$zipResult$2$individualData$1(List list, Map map, Map map2, SimpleDateFormat simpleDateFormat) {
        super(1);
        this.$sortedModelList = list;
        this.$dataByModelC = map;
        this.$dataByModelP = map2;
        this.$dateFormatter = simpleDateFormat;
    }

    public final String invoke(String str) {
        String str2;
        String str3;
        String str4;
        String str5 = str;
        Intrinsics.checkParameterIsNotNull(str5, "model");
        int indexOf = this.$sortedModelList.indexOf(str5) + 1;
        boolean containsKey = this.$dataByModelC.containsKey(str5);
        boolean containsKey2 = this.$dataByModelP.containsKey(str5);
        List list = (List) this.$dataByModelC.get(str5);
        String joinToString$default = list != null ? CollectionsKt.joinToString$default(list, "\", \"", "[\"", "\"]", 0, (CharSequence) null, new PlotActivity$onCreate$zipResult$2$individualData$1$x1$1(this), 24, (Object) null) : null;
        List list2 = (List) this.$dataByModelC.get(str5);
        if (list2 != null) {
            Iterable<StreetPassRecord> iterable = list2;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (StreetPassRecord rssi : iterable) {
                arrayList.add(Integer.valueOf(rssi.getRssi()));
            }
            str2 = CollectionsKt.joinToString$default((List) arrayList, ", ", "[", "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
        } else {
            str2 = null;
        }
        List list3 = (List) this.$dataByModelP.get(str5);
        String joinToString$default2 = list3 != null ? CollectionsKt.joinToString$default(list3, "\", \"", "[\"", "\"]", 0, (CharSequence) null, new PlotActivity$onCreate$zipResult$2$individualData$1$x2$1(this), 24, (Object) null) : null;
        List list4 = (List) this.$dataByModelP.get(str5);
        if (list4 != null) {
            Iterable<StreetPassRecord> iterable2 = list4;
            Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
            for (StreetPassRecord rssi2 : iterable2) {
                arrayList2.add(Integer.valueOf(rssi2.getRssi()));
            }
            str3 = CollectionsKt.joinToString$default((List) arrayList2, ", ", "[", "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
        } else {
            str3 = null;
        }
        String str6 = "var data" + indexOf + " = [];";
        String str7 = "";
        if (!containsKey) {
            str4 = str7;
        } else {
            str4 = StringsKt.trimIndent("\n                                        var data" + indexOf + "a = {\n                                          name: 'central',\n                                          x: " + joinToString$default + ",\n                                          y: " + str2 + ",\n                                          xaxis: 'x" + indexOf + "',\n                                          yaxis: 'y" + indexOf + "',\n                                          mode: 'markers',\n                                          type: 'scatter',\n                                          line: {color: 'blue'}\n                                        };\n                                        data" + indexOf + " = data" + indexOf + ".concat(data" + indexOf + "a);\n                                    ");
        }
        if (containsKey2) {
            str7 = StringsKt.trimIndent("\n                                        var data" + indexOf + "b = {\n                                          name: 'peripheral',\n                                          x: " + joinToString$default2 + ",\n                                          y: " + str3 + ",\n                                          xaxis: 'x" + indexOf + "',\n                                          yaxis: 'y" + indexOf + "',\n                                          mode: 'markers',\n                                          type: 'scatter',\n                                          line: {color: 'red'}\n                                        };\n                                        data" + indexOf + " = data" + indexOf + ".concat(data" + indexOf + "b);\n                                    ");
        }
        return str6 + str4 + str7;
    }
}
