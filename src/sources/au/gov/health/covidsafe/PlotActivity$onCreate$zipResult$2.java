package au.gov.health.covidsafe;

import android.webkit.WebView;
import au.gov.health.covidsafe.streetpass.persistence.StreetPassRecord;
import au.gov.health.covidsafe.ui.upload.model.DebugData;
import com.atlassian.mobilekit.module.core.utils.StringUtils;
import io.reactivex.functions.Consumer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "exportedData", "Lau/gov/health/covidsafe/ui/upload/model/DebugData;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 16})
/* compiled from: PlotActivity.kt */
final class PlotActivity$onCreate$zipResult$2<T> implements Consumer<DebugData> {
    final /* synthetic */ int $displayTimePeriod;
    final /* synthetic */ WebView $webView;

    PlotActivity$onCreate$zipResult$2(int i, WebView webView) {
        this.$displayTimePeriod = i;
        this.$webView = webView;
    }

    public final void accept(DebugData debugData) {
        if (!debugData.getRecords().isEmpty()) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            long j = (long) 1000;
            long timestamp = (((StreetPassRecord) CollectionsKt.sortedWith(debugData.getRecords(), new PlotActivity$onCreate$zipResult$2$$special$$inlined$sortedByDescending$1()).get(0)).getTimestamp() / j) + ((long) 60);
            String format = simpleDateFormat.format(new Date(timestamp * j));
            long j2 = timestamp - ((long) (this.$displayTimePeriod * 3600));
            String format2 = simpleDateFormat.format(new Date(j2 * j));
            Collection arrayList = new ArrayList();
            Iterator it = debugData.getRecords().iterator();
            while (true) {
                boolean z = true;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                long timestamp2 = ((StreetPassRecord) next).getTimestamp() / j;
                if (j2 > timestamp2 || timestamp < timestamp2) {
                    z = false;
                }
                if (z) {
                    arrayList.add(next);
                }
            }
            List list = (List) arrayList;
            if (!list.isEmpty()) {
                Iterable iterable = list;
                Map linkedHashMap = new LinkedHashMap();
                for (Object next2 : iterable) {
                    String modelC = ((StreetPassRecord) next2).getModelC();
                    Object obj = linkedHashMap.get(modelC);
                    if (obj == null) {
                        obj = new ArrayList();
                        linkedHashMap.put(modelC, obj);
                    }
                    ((List) obj).add(next2);
                }
                Map linkedHashMap2 = new LinkedHashMap();
                for (Object next3 : iterable) {
                    String modelP = ((StreetPassRecord) next3).getModelP();
                    Object obj2 = linkedHashMap2.get(modelP);
                    if (obj2 == null) {
                        obj2 = new ArrayList();
                        linkedHashMap2.put(modelP, obj2);
                    }
                    ((List) obj2).add(next3);
                }
                Set union = CollectionsKt.union(linkedHashMap.keySet(), CollectionsKt.toList(linkedHashMap2.keySet()));
                List sortedWith = CollectionsKt.sortedWith(union, new PlotActivity$onCreate$zipResult$2$sortedModelList$1(linkedHashMap, linkedHashMap2));
                Iterable iterable2 = sortedWith;
                Iterable iterable3 = iterable2;
                String joinToString$default = CollectionsKt.joinToString$default(iterable3, StringUtils.EOL, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new PlotActivity$onCreate$zipResult$2$individualData$1(sortedWith, linkedHashMap, linkedHashMap2, simpleDateFormat), 30, (Object) null);
                String joinToString$default2 = CollectionsKt.joinToString$default(iterable3, StringUtils.EOL, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new PlotActivity$onCreate$zipResult$2$combinedData$1(sortedWith, 20), 30, (Object) null);
                Iterable iterable4 = iterable2;
                String joinToString$default3 = CollectionsKt.joinToString$default(iterable4, ",\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new PlotActivity$onCreate$zipResult$2$xAxis$1(this, sortedWith, 20, format2, format), 30, (Object) null);
                String joinToString$default4 = CollectionsKt.joinToString$default(iterable4, ",\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new PlotActivity$onCreate$zipResult$2$yAxis$1(sortedWith, 20), 30, (Object) null);
                StringBuilder sb = new StringBuilder();
                sb.append("\n                        <head>\n                            <script src='https://cdn.plot.ly/plotly-latest.min.js'></script>\n                        </head>\n                        <body>\n                            <div id='myDiv'></div>\n                            <script>\n                                ");
                sb.append(joinToString$default);
                sb.append("\n                                \n                                var data = [];\n                                ");
                sb.append(joinToString$default2);
                sb.append("\n                                \n                                var layout = {\n                                  title: 'Activities from <b>");
                Intrinsics.checkExpressionValueIsNotNull(format2, "startTimeString");
                sb.append(StringsKt.substring(format2, new IntRange(11, 15)));
                sb.append("</b> to <b>");
                Intrinsics.checkExpressionValueIsNotNull(format, "endTimeString");
                sb.append(StringsKt.substring(format, new IntRange(11, 15)));
                sb.append("</b>   <span style=\"color:blue\">central</span> <span style=\"color:red\">peripheral</span>',\n                                  height: 135 * ");
                sb.append(union.size());
                sb.append(",\n                                  showlegend: false,\n                                  grid: {rows: ");
                sb.append(union.size());
                sb.append(", columns: 1, pattern: 'independent'},\n                                  margin: {\n                                    t: 30,\n                                    r: 30,\n                                    b: 20,\n                                    l: 50,\n                                    pad: 0\n                                  },\n                                  ");
                sb.append(joinToString$default3);
                sb.append(",\n                                  ");
                sb.append(joinToString$default4);
                sb.append("\n                                };\n                                \n                                var config = {\n                                    responsive: true, \n                                    displayModeBar: false, \n                                    displaylogo: false, \n                                    modeBarButtonsToRemove: ['toImage', 'sendDataToCloud', 'editInChartStudio', 'zoom2d', 'select2d', 'pan2d', 'lasso2d', 'autoScale2d', 'resetScale2d', 'zoomIn2d', 'zoomOut2d', 'hoverClosestCartesian', 'hoverCompareCartesian', 'toggleHover', 'toggleSpikelines']\n                                }\n                                \n                                Plotly.newPlot('myDiv', data, layout, config);\n                            </script>\n                        </body>\n                    ");
                this.$webView.loadData(StringsKt.trimIndent(sb.toString()), "text/html", "UTF-8");
                return;
            }
            this.$webView.loadData("No data received in the last " + this.$displayTimePeriod + " hour(s) or more.", "text/html", "UTF-8");
        }
    }
}
