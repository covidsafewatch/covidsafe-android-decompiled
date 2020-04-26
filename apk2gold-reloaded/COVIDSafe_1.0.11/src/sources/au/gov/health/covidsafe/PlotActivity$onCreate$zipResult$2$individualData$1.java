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

    PlotActivity$onCreate$zipResult$2$individualData$1(List list, Map map, Map map2, SimpleDateFormat simpleDateFormat) {
        this.$sortedModelList = list;
        this.$dataByModelC = map;
        this.$dataByModelP = map2;
        this.$dateFormatter = simpleDateFormat;
        super(1);
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
        String str6 = "\"]";
        String str7 = "[\"";
        String str8 = "\", \"";
        String joinToString$default = list != null ? CollectionsKt.joinToString$default(list, str8, str7, str6, 0, null, new PlotActivity$onCreate$zipResult$2$individualData$1$x1$1(this), 24, null) : null;
        List list2 = (List) this.$dataByModelC.get(str5);
        String str9 = "]";
        String str10 = "[";
        String str11 = ", ";
        if (list2 != null) {
            Iterable<StreetPassRecord> iterable = list2;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (StreetPassRecord rssi : iterable) {
                arrayList.add(Integer.valueOf(rssi.getRssi()));
            }
            str2 = CollectionsKt.joinToString$default((List) arrayList, str11, str10, str9, 0, null, null, 56, null);
        } else {
            str2 = null;
        }
        List list3 = (List) this.$dataByModelP.get(str5);
        String joinToString$default2 = list3 != null ? CollectionsKt.joinToString$default(list3, str8, str7, str6, 0, null, new PlotActivity$onCreate$zipResult$2$individualData$1$x2$1(this), 24, null) : null;
        List list4 = (List) this.$dataByModelP.get(str5);
        if (list4 != null) {
            Iterable<StreetPassRecord> iterable2 = list4;
            Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
            for (StreetPassRecord rssi2 : iterable2) {
                arrayList2.add(Integer.valueOf(rssi2.getRssi()));
            }
            str3 = CollectionsKt.joinToString$default((List) arrayList2, str11, str10, str9, 0, null, null, 56, null);
        } else {
            str3 = null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("var data");
        sb.append(indexOf);
        sb.append(" = [];");
        String sb2 = sb.toString();
        String str12 = "";
        String str13 = ".concat(data";
        String str14 = " = data";
        String str15 = "',\n                                          yaxis: 'y";
        String str16 = ",\n                                          xaxis: 'x";
        String str17 = ",\n                                          y: ";
        String str18 = "\n                                        var data";
        if (!containsKey) {
            str4 = str12;
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str18);
            sb3.append(indexOf);
            sb3.append("a = {\n                                          name: 'central',\n                                          x: ");
            sb3.append(joinToString$default);
            sb3.append(str17);
            sb3.append(str2);
            sb3.append(str16);
            sb3.append(indexOf);
            sb3.append(str15);
            sb3.append(indexOf);
            sb3.append("',\n                                          mode: 'markers',\n                                          type: 'scatter',\n                                          line: {color: 'blue'}\n                                        };\n                                        data");
            sb3.append(indexOf);
            sb3.append(str14);
            sb3.append(indexOf);
            sb3.append(str13);
            sb3.append(indexOf);
            sb3.append("a);\n                                    ");
            str4 = StringsKt.trimIndent(sb3.toString());
        }
        if (containsKey2) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str18);
            sb4.append(indexOf);
            sb4.append("b = {\n                                          name: 'peripheral',\n                                          x: ");
            sb4.append(joinToString$default2);
            sb4.append(str17);
            sb4.append(str3);
            sb4.append(str16);
            sb4.append(indexOf);
            sb4.append(str15);
            sb4.append(indexOf);
            sb4.append("',\n                                          mode: 'markers',\n                                          type: 'scatter',\n                                          line: {color: 'red'}\n                                        };\n                                        data");
            sb4.append(indexOf);
            sb4.append(str14);
            sb4.append(indexOf);
            sb4.append(str13);
            sb4.append(indexOf);
            sb4.append("b);\n                                    ");
            str12 = StringsKt.trimIndent(sb4.toString());
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(sb2);
        sb5.append(str4);
        sb5.append(str12);
        return sb5.toString();
    }
}
