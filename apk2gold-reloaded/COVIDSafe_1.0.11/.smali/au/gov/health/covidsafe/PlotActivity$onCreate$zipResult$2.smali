.class final Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2;
.super Ljava/lang/Object;
.source "PlotActivity.kt"

# interfaces
.implements Lio/reactivex/functions/Consumer;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lau/gov/health/covidsafe/PlotActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lio/reactivex/functions/Consumer<",
        "Lau/gov/health/covidsafe/ui/upload/model/DebugData;",
        ">;"
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nPlotActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlotActivity.kt\nau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,304:1\n965#2:305\n706#2:306\n783#2,2:307\n1294#2:309\n1319#2,3:310\n1322#2,3:320\n1294#2:323\n1319#2,3:324\n1322#2,3:334\n352#3,7:313\n352#3,7:327\n*E\n*S KotlinDebug\n*F\n+ 1 PlotActivity.kt\nau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2\n*L\n61#1:305\n68#1:306\n68#1,2:307\n73#1:309\n73#1,3:310\n73#1,3:320\n74#1:323\n74#1,3:324\n74#1,3:334\n73#1,7:313\n74#1,7:327\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\u0008\u0005"
    }
    d2 = {
        "<anonymous>",
        "",
        "exportedData",
        "Lau/gov/health/covidsafe/ui/upload/model/DebugData;",
        "kotlin.jvm.PlatformType",
        "accept"
    }
    k = 0x3
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# instance fields
.field final synthetic $displayTimePeriod:I

.field final synthetic $webView:Landroid/webkit/WebView;


# direct methods
.method constructor <init>(ILandroid/webkit/WebView;)V
    .locals 0

    iput p1, p0, Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2;->$displayTimePeriod:I

    iput-object p2, p0, Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2;->$webView:Landroid/webkit/WebView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final accept(Lau/gov/health/covidsafe/ui/upload/model/DebugData;)V
    .locals 25

    move-object/from16 v6, p0

    .line 53
    invoke-virtual/range {p1 .. p1}, Lau/gov/health/covidsafe/ui/upload/model/DebugData;->getRecords()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    return-void

    .line 57
    :cond_0
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v1, "yyyy-MM-dd HH:mm:ss"

    invoke-direct {v0, v1}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    .line 61
    invoke-virtual/range {p1 .. p1}, Lau/gov/health/covidsafe/ui/upload/model/DebugData;->getRecords()Ljava/util/List;

    move-result-object v1

    check-cast v1, Ljava/lang/Iterable;

    .line 305
    new-instance v2, Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2$$special$$inlined$sortedByDescending$1;

    invoke-direct {v2}, Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2$$special$$inlined$sortedByDescending$1;-><init>()V

    check-cast v2, Ljava/util/Comparator;

    invoke-static {v1, v2}, Lkotlin/collections/CollectionsKt;->sortedWith(Ljava/lang/Iterable;Ljava/util/Comparator;)Ljava/util/List;

    move-result-object v1

    const/4 v2, 0x0

    .line 61
    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;

    invoke-virtual {v1}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->getTimestamp()J

    move-result-wide v3

    const/16 v1, 0x3e8

    int-to-long v7, v1

    div-long/2addr v3, v7

    const/16 v1, 0x3c

    int-to-long v9, v1

    add-long/2addr v3, v9

    .line 62
    new-instance v1, Ljava/util/Date;

    mul-long v9, v3, v7

    invoke-direct {v1, v9, v10}, Ljava/util/Date;-><init>(J)V

    invoke-virtual {v0, v1}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v9

    .line 65
    iget v1, v6, Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2;->$displayTimePeriod:I

    mul-int/lit16 v1, v1, 0xe10

    int-to-long v10, v1

    sub-long v10, v3, v10

    .line 66
    new-instance v1, Ljava/util/Date;

    mul-long v12, v10, v7

    invoke-direct {v1, v12, v13}, Ljava/util/Date;-><init>(J)V

    invoke-virtual {v0, v1}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v12

    .line 68
    invoke-virtual/range {p1 .. p1}, Lau/gov/health/covidsafe/ui/upload/model/DebugData;->getRecords()Ljava/util/List;

    move-result-object v1

    check-cast v1, Ljava/lang/Iterable;

    .line 306
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    check-cast v5, Ljava/util/Collection;

    .line 307
    invoke-interface {v1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_1
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v13

    const/4 v14, 0x1

    if-eqz v13, :cond_4

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v13

    move-object v15, v13

    check-cast v15, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;

    .line 69
    invoke-virtual {v15}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->getTimestamp()J

    move-result-wide v15

    div-long/2addr v15, v7

    cmp-long v17, v10, v15

    if-lez v17, :cond_2

    goto :goto_1

    :cond_2
    cmp-long v15, v3, v15

    if-ltz v15, :cond_3

    goto :goto_2

    :cond_3
    :goto_1
    move v14, v2

    :goto_2
    if-eqz v14, :cond_1

    invoke-interface {v5, v13}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 308
    :cond_4
    check-cast v5, Ljava/util/List;

    .line 72
    move-object v1, v5

    check-cast v1, Ljava/util/Collection;

    invoke-interface {v1}, Ljava/util/Collection;->isEmpty()Z

    move-result v1

    xor-int/2addr v1, v14

    const-string v7, "UTF-8"

    const-string v8, "text/html"

    if-eqz v1, :cond_9

    .line 73
    check-cast v5, Ljava/lang/Iterable;

    .line 309
    new-instance v1, Ljava/util/LinkedHashMap;

    invoke-direct {v1}, Ljava/util/LinkedHashMap;-><init>()V

    check-cast v1, Ljava/util/Map;

    .line 310
    invoke-interface {v5}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_3
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_6

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    .line 311
    move-object v4, v3

    check-cast v4, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;

    .line 73
    invoke-virtual {v4}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->getModelC()Ljava/lang/String;

    move-result-object v4

    .line 313
    invoke-interface {v1, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    if-nez v10, :cond_5

    .line 312
    new-instance v10, Ljava/util/ArrayList;

    invoke-direct {v10}, Ljava/util/ArrayList;-><init>()V

    .line 316
    invoke-interface {v1, v4, v10}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 312
    :cond_5
    check-cast v10, Ljava/util/List;

    .line 320
    invoke-interface {v10, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_3

    .line 323
    :cond_6
    new-instance v2, Ljava/util/LinkedHashMap;

    invoke-direct {v2}, Ljava/util/LinkedHashMap;-><init>()V

    check-cast v2, Ljava/util/Map;

    .line 324
    invoke-interface {v5}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_4
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_8

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    .line 325
    move-object v5, v4

    check-cast v5, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;

    .line 74
    invoke-virtual {v5}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->getModelP()Ljava/lang/String;

    move-result-object v5

    .line 327
    invoke-interface {v2, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    if-nez v10, :cond_7

    .line 326
    new-instance v10, Ljava/util/ArrayList;

    invoke-direct {v10}, Ljava/util/ArrayList;-><init>()V

    .line 330
    invoke-interface {v2, v5, v10}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 326
    :cond_7
    check-cast v10, Ljava/util/List;

    .line 334
    invoke-interface {v10, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_4

    .line 77
    :cond_8
    invoke-interface {v1}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v3

    check-cast v3, Ljava/lang/Iterable;

    invoke-interface {v2}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v4

    check-cast v4, Ljava/lang/Iterable;

    invoke-static {v4}, Lkotlin/collections/CollectionsKt;->toList(Ljava/lang/Iterable;)Ljava/util/List;

    move-result-object v4

    check-cast v4, Ljava/lang/Iterable;

    invoke-static {v3, v4}, Lkotlin/collections/CollectionsKt;->union(Ljava/lang/Iterable;Ljava/lang/Iterable;)Ljava/util/Set;

    move-result-object v10

    .line 81
    move-object v3, v10

    check-cast v3, Ljava/lang/Iterable;

    new-instance v4, Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2$sortedModelList$1;

    invoke-direct {v4, v1, v2}, Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2$sortedModelList$1;-><init>(Ljava/util/Map;Ljava/util/Map;)V

    check-cast v4, Ljava/util/Comparator;

    invoke-static {v3, v4}, Lkotlin/collections/CollectionsKt;->sortedWith(Ljava/lang/Iterable;Ljava/util/Comparator;)Ljava/util/List;

    move-result-object v11

    .line 114
    move-object/from16 v22, v11

    check-cast v22, Ljava/lang/Iterable;

    const-string v3, "\n"

    move-object v14, v3

    check-cast v14, Ljava/lang/CharSequence;

    const/4 v15, 0x0

    const/16 v16, 0x0

    const/16 v17, 0x0

    const/16 v18, 0x0

    new-instance v4, Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2$individualData$1;

    invoke-direct {v4, v11, v1, v2, v0}, Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2$individualData$1;-><init>(Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Ljava/text/SimpleDateFormat;)V

    move-object/from16 v19, v4

    check-cast v19, Lkotlin/jvm/functions/Function1;

    const/16 v20, 0x1e

    const/16 v21, 0x0

    move-object/from16 v13, v22

    invoke-static/range {v13 .. v21}, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;ILjava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    const/16 v4, 0x14

    .line 185
    move-object v14, v3

    check-cast v14, Ljava/lang/CharSequence;

    new-instance v0, Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2$combinedData$1;

    invoke-direct {v0, v11, v4}, Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2$combinedData$1;-><init>(Ljava/util/List;I)V

    move-object/from16 v19, v0

    check-cast v19, Lkotlin/jvm/functions/Function1;

    invoke-static/range {v13 .. v21}, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;ILjava/lang/Object;)Ljava/lang/String;

    move-result-object v15

    const-string v23, ",\n"

    .line 207
    move-object/from16 v14, v23

    check-cast v14, Ljava/lang/CharSequence;

    const/16 v17, 0x0

    const/16 v18, 0x0

    const/16 v19, 0x0

    new-instance v13, Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2$xAxis$1;

    const/16 v3, 0x14

    move-object v0, v13

    move-object/from16 v1, p0

    move-object v2, v11

    move-object v4, v12

    move-object/from16 v24, v5

    move-object v5, v9

    invoke-direct/range {v0 .. v5}, Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2$xAxis$1;-><init>(Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2;Ljava/util/List;ILjava/lang/String;Ljava/lang/String;)V

    move-object v0, v13

    check-cast v0, Lkotlin/jvm/functions/Function1;

    move-object/from16 v13, v22

    move-object v1, v15

    move-object/from16 v15, v16

    move-object/from16 v16, v17

    move/from16 v17, v18

    move-object/from16 v18, v19

    move-object/from16 v19, v0

    invoke-static/range {v13 .. v21}, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;ILjava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 238
    move-object/from16 v14, v23

    check-cast v14, Ljava/lang/CharSequence;

    const/4 v15, 0x0

    const/16 v16, 0x0

    const/16 v17, 0x0

    const/16 v18, 0x0

    new-instance v2, Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2$yAxis$1;

    const/16 v3, 0x14

    invoke-direct {v2, v11, v3}, Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2$yAxis$1;-><init>(Ljava/util/List;I)V

    move-object/from16 v19, v2

    check-cast v19, Lkotlin/jvm/functions/Function1;

    invoke-static/range {v13 .. v21}, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;ILjava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 253
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "\n                        <head>\n                            <script src=\'https://cdn.plot.ly/plotly-latest.min.js\'></script>\n                        </head>\n                        <body>\n                            <div id=\'myDiv\'></div>\n                            <script>\n                                "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-object/from16 v4, v24

    .line 260
    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v4, "\n                                \n                                var data = [];\n                                "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 263
    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "\n                                \n                                var layout = {\n                                  title: \'Activities from <b>"

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "startTimeString"

    .line 266
    invoke-static {v12, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    new-instance v1, Lkotlin/ranges/IntRange;

    const/16 v4, 0xf

    const/16 v5, 0xb

    invoke-direct {v1, v5, v4}, Lkotlin/ranges/IntRange;-><init>(II)V

    invoke-static {v12, v1}, Lkotlin/text/StringsKt;->substring(Ljava/lang/String;Lkotlin/ranges/IntRange;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "</b> to <b>"

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "endTimeString"

    invoke-static {v9, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    new-instance v1, Lkotlin/ranges/IntRange;

    invoke-direct {v1, v5, v4}, Lkotlin/ranges/IntRange;-><init>(II)V

    invoke-static {v9, v1}, Lkotlin/text/StringsKt;->substring(Ljava/lang/String;Lkotlin/ranges/IntRange;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "</b>   <span style=\"color:blue\">central</span> <span style=\"color:red\">peripheral</span>\',\n                                  height: 135 * "

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 267
    invoke-interface {v10}, Ljava/util/Set;->size()I

    move-result v1

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v1, ",\n                                  showlegend: false,\n                                  grid: {rows: "

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 269
    invoke-interface {v10}, Ljava/util/Set;->size()I

    move-result v1

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v1, ", columns: 1, pattern: \'independent\'},\n                                  margin: {\n                                    t: 30,\n                                    r: 30,\n                                    b: 20,\n                                    l: 50,\n                                    pad: 0\n                                  },\n                                  "

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 277
    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v0, ",\n                                  "

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 278
    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v0, "\n                                };\n                                \n                                var config = {\n                                    responsive: true, \n                                    displayModeBar: false, \n                                    displaylogo: false, \n                                    modeBarButtonsToRemove: [\'toImage\', \'sendDataToCloud\', \'editInChartStudio\', \'zoom2d\', \'select2d\', \'pan2d\', \'lasso2d\', \'autoScale2d\', \'resetScale2d\', \'zoomIn2d\', \'zoomOut2d\', \'hoverClosestCartesian\', \'hoverCompareCartesian\', \'toggleHover\', \'toggleSpikelines\']\n                                }\n                                \n                                Plotly.newPlot(\'myDiv\', data, layout, config);\n                            </script>\n                        </body>\n                    "

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 291
    invoke-static {v0}, Lkotlin/text/StringsKt;->trimIndent(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 293
    iget-object v1, v6, Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2;->$webView:Landroid/webkit/WebView;

    invoke-virtual {v1, v0, v8, v7}, Landroid/webkit/WebView;->loadData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_5

    .line 295
    :cond_9
    iget-object v0, v6, Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2;->$webView:Landroid/webkit/WebView;

    .line 296
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "No data received in the last "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v2, v6, Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2;->$displayTimePeriod:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v2, " hour(s) or more."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 295
    invoke-virtual {v0, v1, v8, v7}, Landroid/webkit/WebView;->loadData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    :goto_5
    return-void
.end method

.method public bridge synthetic accept(Ljava/lang/Object;)V
    .locals 0

    .line 22
    check-cast p1, Lau/gov/health/covidsafe/ui/upload/model/DebugData;

    invoke-virtual {p0, p1}, Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2;->accept(Lau/gov/health/covidsafe/ui/upload/model/DebugData;)V

    return-void
.end method
