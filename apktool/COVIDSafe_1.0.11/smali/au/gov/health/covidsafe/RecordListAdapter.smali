.class public final Lau/gov/health/covidsafe/RecordListAdapter;
.super Landroidx/recyclerview/widget/RecyclerView$Adapter;
.source "RecordListAdapter.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lau/gov/health/covidsafe/RecordListAdapter$MODE;,
        Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroidx/recyclerview/widget/RecyclerView$Adapter<",
        "Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;",
        ">;"
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nRecordListAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecordListAdapter.kt\nau/gov/health/covidsafe/RecordListAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,170:1\n706#2:171\n783#2,2:172\n706#2:174\n783#2,2:175\n1294#2:177\n1319#2,3:178\n1322#2,3:188\n1468#2,8:191\n1366#2:199\n1435#2,2:200\n1719#2,14:202\n1437#2:216\n1366#2:217\n1435#2,3:218\n352#3,7:181\n*E\n*S KotlinDebug\n*F\n+ 1 RecordListAdapter.kt\nau/gov/health/covidsafe/RecordListAdapter\n*L\n94#1:171\n94#1,2:172\n105#1:174\n105#1,2:175\n113#1:177\n113#1,3:178\n113#1,3:188\n117#1,8:191\n119#1:199\n119#1,2:200\n119#1,14:202\n119#1:216\n138#1:217\n138#1,3:218\n113#1,7:181\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\n\u0018\u00002\u000c\u0012\u0008\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002%&B\u000f\u0008\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0018\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000b2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u000cH\u0002J&\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000b2\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u000c2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u000bH\u0002J&\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000b2\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u000c2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u000bH\u0002J\u0008\u0010\u0015\u001a\u00020\u0016H\u0016J\u001c\u0010\u0017\u001a\u00020\u00182\n\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\u001c\u0010\u001b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0016H\u0016J\u001c\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000b2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u000bH\u0002J\u001c\u0010 \u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000b2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u000bH\u0002J\u000e\u0010!\u001a\u00020\u00182\u0006\u0010\u0008\u001a\u00020\tJ\u001a\u0010!\u001a\u00020\u00182\u0006\u0010\u0008\u001a\u00020\t2\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u000cH\u0002J\u0016\u0010\"\u001a\u00020\u00182\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000bH\u0002J\u001b\u0010#\u001a\u00020\u00182\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u000bH\u0000\u00a2\u0006\u0002\u0008$R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\'"
    }
    d2 = {
        "Lau/gov/health/covidsafe/RecordListAdapter;",
        "Landroidx/recyclerview/widget/RecyclerView$Adapter;",
        "Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;",
        "context",
        "Landroid/content/Context;",
        "(Landroid/content/Context;)V",
        "inflater",
        "Landroid/view/LayoutInflater;",
        "mode",
        "Lau/gov/health/covidsafe/RecordListAdapter$MODE;",
        "records",
        "",
        "Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;",
        "sourceData",
        "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;",
        "filter",
        "sample",
        "filterByModelC",
        "model",
        "words",
        "filterByModelP",
        "getItemCount",
        "",
        "onBindViewHolder",
        "",
        "holder",
        "position",
        "onCreateViewHolder",
        "parent",
        "Landroid/view/ViewGroup;",
        "viewType",
        "prepareCollapsedData",
        "prepareViewData",
        "setMode",
        "setRecords",
        "setSourceData",
        "setSourceData$app_release",
        "MODE",
        "RecordViewHolder",
        "app_release"
    }
    k = 0x1
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# instance fields
.field private final inflater:Landroid/view/LayoutInflater;

.field private mode:Lau/gov/health/covidsafe/RecordListAdapter$MODE;

.field private records:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;",
            ">;"
        }
    .end annotation
.end field

.field private sourceData:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 14
    invoke-direct {p0}, Landroidx/recyclerview/widget/RecyclerView$Adapter;-><init>()V

    .line 15
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object p1

    const-string v0, "LayoutInflater.from(context)"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    iput-object p1, p0, Lau/gov/health/covidsafe/RecordListAdapter;->inflater:Landroid/view/LayoutInflater;

    .line 16
    invoke-static {}, Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;

    move-result-object p1

    iput-object p1, p0, Lau/gov/health/covidsafe/RecordListAdapter;->records:Ljava/util/List;

    .line 17
    invoke-static {}, Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;

    move-result-object p1

    iput-object p1, p0, Lau/gov/health/covidsafe/RecordListAdapter;->sourceData:Ljava/util/List;

    .line 23
    sget-object p1, Lau/gov/health/covidsafe/RecordListAdapter$MODE;->ALL:Lau/gov/health/covidsafe/RecordListAdapter$MODE;

    iput-object p1, p0, Lau/gov/health/covidsafe/RecordListAdapter;->mode:Lau/gov/health/covidsafe/RecordListAdapter$MODE;

    return-void
.end method

.method public static final synthetic access$setMode(Lau/gov/health/covidsafe/RecordListAdapter;Lau/gov/health/covidsafe/RecordListAdapter$MODE;Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;)V
    .locals 0

    .line 13
    invoke-direct {p0, p1, p2}, Lau/gov/health/covidsafe/RecordListAdapter;->setMode(Lau/gov/health/covidsafe/RecordListAdapter$MODE;Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;)V

    return-void
.end method

.method private final filter(Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;)Ljava/util/List;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;",
            ")",
            "Ljava/util/List<",
            "Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;",
            ">;"
        }
    .end annotation

    .line 74
    iget-object v0, p0, Lau/gov/health/covidsafe/RecordListAdapter;->mode:Lau/gov/health/covidsafe/RecordListAdapter$MODE;

    sget-object v1, Lau/gov/health/covidsafe/RecordListAdapter$WhenMappings;->$EnumSwitchMapping$0:[I

    invoke-virtual {v0}, Lau/gov/health/covidsafe/RecordListAdapter$MODE;->ordinal()I

    move-result v0

    aget v0, v1, v0

    const/4 v1, 0x1

    if-eq v0, v1, :cond_3

    const/4 v1, 0x2

    if-eq v0, v1, :cond_2

    const/4 v1, 0x3

    if-eq v0, v1, :cond_1

    const/4 v1, 0x4

    if-eq v0, v1, :cond_0

    .line 84
    iget-object p1, p0, Lau/gov/health/covidsafe/RecordListAdapter;->sourceData:Ljava/util/List;

    invoke-direct {p0, p1}, Lau/gov/health/covidsafe/RecordListAdapter;->prepareViewData(Ljava/util/List;)Ljava/util/List;

    move-result-object p1

    goto :goto_0

    .line 81
    :cond_0
    iget-object v0, p0, Lau/gov/health/covidsafe/RecordListAdapter;->sourceData:Ljava/util/List;

    invoke-direct {p0, p1, v0}, Lau/gov/health/covidsafe/RecordListAdapter;->filterByModelC(Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;Ljava/util/List;)Ljava/util/List;

    move-result-object p1

    goto :goto_0

    .line 79
    :cond_1
    iget-object v0, p0, Lau/gov/health/covidsafe/RecordListAdapter;->sourceData:Ljava/util/List;

    invoke-direct {p0, p1, v0}, Lau/gov/health/covidsafe/RecordListAdapter;->filterByModelP(Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;Ljava/util/List;)Ljava/util/List;

    move-result-object p1

    goto :goto_0

    .line 77
    :cond_2
    iget-object p1, p0, Lau/gov/health/covidsafe/RecordListAdapter;->sourceData:Ljava/util/List;

    invoke-direct {p0, p1}, Lau/gov/health/covidsafe/RecordListAdapter;->prepareViewData(Ljava/util/List;)Ljava/util/List;

    move-result-object p1

    goto :goto_0

    .line 75
    :cond_3
    iget-object p1, p0, Lau/gov/health/covidsafe/RecordListAdapter;->sourceData:Ljava/util/List;

    invoke-direct {p0, p1}, Lau/gov/health/covidsafe/RecordListAdapter;->prepareCollapsedData(Ljava/util/List;)Ljava/util/List;

    move-result-object p1

    :goto_0
    return-object p1
.end method

.method private final filterByModelC(Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;Ljava/util/List;)Ljava/util/List;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;",
            "Ljava/util/List<",
            "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;",
            ">;)",
            "Ljava/util/List<",
            "Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;",
            ">;"
        }
    .end annotation

    if-eqz p1, :cond_2

    .line 94
    check-cast p2, Ljava/lang/Iterable;

    .line 171
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    check-cast v0, Ljava/util/Collection;

    .line 172
    invoke-interface {p2}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object p2

    :cond_0
    :goto_0
    invoke-interface {p2}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-interface {p2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    move-object v2, v1

    check-cast v2, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;

    .line 94
    invoke-virtual {v2}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->getModelC()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;->getModelC()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0, v1}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 173
    :cond_1
    check-cast v0, Ljava/util/List;

    .line 94
    invoke-direct {p0, v0}, Lau/gov/health/covidsafe/RecordListAdapter;->prepareViewData(Ljava/util/List;)Ljava/util/List;

    move-result-object p1

    return-object p1

    .line 96
    :cond_2
    invoke-direct {p0, p2}, Lau/gov/health/covidsafe/RecordListAdapter;->prepareViewData(Ljava/util/List;)Ljava/util/List;

    move-result-object p1

    return-object p1
.end method

.method private final filterByModelP(Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;Ljava/util/List;)Ljava/util/List;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;",
            "Ljava/util/List<",
            "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;",
            ">;)",
            "Ljava/util/List<",
            "Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;",
            ">;"
        }
    .end annotation

    if-eqz p1, :cond_2

    .line 105
    check-cast p2, Ljava/lang/Iterable;

    .line 174
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    check-cast v0, Ljava/util/Collection;

    .line 175
    invoke-interface {p2}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object p2

    :cond_0
    :goto_0
    invoke-interface {p2}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-interface {p2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    move-object v2, v1

    check-cast v2, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;

    .line 105
    invoke-virtual {v2}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->getModelP()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;->getModelP()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0, v1}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 176
    :cond_1
    check-cast v0, Ljava/util/List;

    .line 105
    invoke-direct {p0, v0}, Lau/gov/health/covidsafe/RecordListAdapter;->prepareViewData(Ljava/util/List;)Ljava/util/List;

    move-result-object p1

    return-object p1

    .line 107
    :cond_2
    invoke-direct {p0, p2}, Lau/gov/health/covidsafe/RecordListAdapter;->prepareViewData(Ljava/util/List;)Ljava/util/List;

    move-result-object p1

    return-object p1
.end method

.method private final prepareCollapsedData(Ljava/util/List;)Ljava/util/List;
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;",
            ">;)",
            "Ljava/util/List<",
            "Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;",
            ">;"
        }
    .end annotation

    .line 113
    check-cast p1, Ljava/lang/Iterable;

    .line 177
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0}, Ljava/util/LinkedHashMap;-><init>()V

    check-cast v0, Ljava/util/Map;

    .line 178
    invoke-interface {p1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    .line 179
    move-object v3, v2

    check-cast v3, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;

    .line 114
    invoke-virtual {v3}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->getModelC()Ljava/lang/String;

    move-result-object v3

    .line 181
    invoke-interface {v0, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    if-nez v4, :cond_0

    .line 180
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 184
    invoke-interface {v0, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 180
    :cond_0
    check-cast v4, Ljava/util/List;

    .line 188
    invoke-interface {v4, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 191
    :cond_1
    new-instance v1, Ljava/util/HashSet;

    invoke-direct {v1}, Ljava/util/HashSet;-><init>()V

    .line 192
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 193
    invoke-interface {p1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :cond_2
    :goto_1
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_3

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    .line 194
    move-object v4, v3

    check-cast v4, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;

    .line 117
    invoke-virtual {v4}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->getModelC()Ljava/lang/String;

    move-result-object v4

    .line 195
    invoke-virtual {v1, v4}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 196
    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 198
    :cond_3
    check-cast v2, Ljava/util/List;

    .line 119
    check-cast v2, Ljava/lang/Iterable;

    .line 199
    new-instance p1, Ljava/util/ArrayList;

    const/16 v1, 0xa

    invoke-static {v2, v1}, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable;I)I

    move-result v1

    invoke-direct {p1, v1}, Ljava/util/ArrayList;-><init>(I)V

    check-cast p1, Ljava/util/Collection;

    .line 200
    invoke-interface {v2}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_c

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    .line 201
    check-cast v2, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;

    .line 120
    invoke-virtual {v2}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->getModelC()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/List;

    const/4 v4, 0x0

    if-eqz v3, :cond_4

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    goto :goto_3

    :cond_4
    move-object v3, v4

    :goto_3
    if-eqz v3, :cond_b

    .line 122
    check-cast v3, Ljava/lang/Number;

    invoke-virtual {v3}, Ljava/lang/Number;->intValue()I

    move-result v3

    .line 123
    invoke-virtual {v2}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->getModelC()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v0, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/List;

    if-eqz v5, :cond_9

    check-cast v5, Ljava/lang/Iterable;

    .line 202
    invoke-interface {v5}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v5

    .line 203
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-nez v6, :cond_5

    goto :goto_4

    .line 204
    :cond_5
    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    .line 205
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-nez v6, :cond_6

    goto :goto_4

    .line 206
    :cond_6
    move-object v6, v4

    check-cast v6, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;

    .line 123
    invoke-virtual {v6}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->getTimestamp()J

    move-result-wide v6

    .line 208
    :cond_7
    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    .line 209
    move-object v9, v8

    check-cast v9, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;

    .line 123
    invoke-virtual {v9}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->getTimestamp()J

    move-result-wide v9

    cmp-long v11, v6, v9

    if-gez v11, :cond_8

    move-object v4, v8

    move-wide v6, v9

    .line 214
    :cond_8
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-nez v8, :cond_7

    .line 215
    :goto_4
    check-cast v4, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;

    :cond_9
    if-eqz v4, :cond_a

    .line 126
    new-instance v2, Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;

    invoke-direct {v2, v4, v3}, Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;-><init>(Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;I)V

    goto :goto_5

    .line 129
    :cond_a
    new-instance v4, Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;

    invoke-direct {v4, v2, v3}, Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;-><init>(Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;I)V

    move-object v2, v4

    goto :goto_5

    .line 132
    :cond_b
    new-instance v3, Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;

    invoke-direct {v3, v2}, Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;-><init>(Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;)V

    move-object v2, v3

    :goto_5
    invoke-interface {p1, v2}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    goto/16 :goto_2

    .line 216
    :cond_c
    check-cast p1, Ljava/util/List;

    return-object p1
.end method

.method private final prepareViewData(Ljava/util/List;)Ljava/util/List;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;",
            ">;)",
            "Ljava/util/List<",
            "Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;",
            ">;"
        }
    .end annotation

    .line 140
    check-cast p1, Ljava/lang/Iterable;

    invoke-static {p1}, Lkotlin/collections/CollectionsKt;->reversed(Ljava/lang/Iterable;)Ljava/util/List;

    move-result-object p1

    .line 141
    check-cast p1, Ljava/lang/Iterable;

    .line 217
    new-instance v0, Ljava/util/ArrayList;

    const/16 v1, 0xa

    invoke-static {p1, v1}, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable;I)I

    move-result v1

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    check-cast v0, Ljava/util/Collection;

    .line 218
    invoke-interface {p1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_0
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    .line 219
    check-cast v1, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;

    .line 142
    new-instance v2, Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;

    invoke-direct {v2, v1}, Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;-><init>(Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;)V

    invoke-interface {v0, v2}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 220
    :cond_0
    check-cast v0, Ljava/util/List;

    return-object v0
.end method

.method private final setMode(Lau/gov/health/covidsafe/RecordListAdapter$MODE;Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;)V
    .locals 0

    .line 152
    iput-object p1, p0, Lau/gov/health/covidsafe/RecordListAdapter;->mode:Lau/gov/health/covidsafe/RecordListAdapter$MODE;

    .line 154
    invoke-direct {p0, p2}, Lau/gov/health/covidsafe/RecordListAdapter;->filter(Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;)Ljava/util/List;

    move-result-object p1

    .line 155
    invoke-direct {p0, p1}, Lau/gov/health/covidsafe/RecordListAdapter;->setRecords(Ljava/util/List;)V

    return-void
.end method

.method private final setRecords(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;",
            ">;)V"
        }
    .end annotation

    .line 159
    iput-object p1, p0, Lau/gov/health/covidsafe/RecordListAdapter;->records:Ljava/util/List;

    .line 160
    invoke-virtual {p0}, Lau/gov/health/covidsafe/RecordListAdapter;->notifyDataSetChanged()V

    return-void
.end method


# virtual methods
.method public getItemCount()I
    .locals 1

    .line 168
    iget-object v0, p0, Lau/gov/health/covidsafe/RecordListAdapter;->records:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public bridge synthetic onBindViewHolder(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V
    .locals 0

    .line 13
    check-cast p1, Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;

    invoke-virtual {p0, p1, p2}, Lau/gov/health/covidsafe/RecordListAdapter;->onBindViewHolder(Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;I)V

    return-void
.end method

.method public onBindViewHolder(Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;I)V
    .locals 3

    const-string v0, "holder"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 45
    iget-object v0, p0, Lau/gov/health/covidsafe/RecordListAdapter;->records:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;

    .line 46
    invoke-virtual {p1}, Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;->getMsgView()Landroid/widget/TextView;

    move-result-object v0

    invoke-virtual {p2}, Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;->getMsg()Ljava/lang/String;

    move-result-object v1

    check-cast v1, Ljava/lang/CharSequence;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 47
    invoke-virtual {p1}, Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;->getModelCView()Landroid/widget/TextView;

    move-result-object v0

    invoke-virtual {p2}, Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;->getModelC()Ljava/lang/String;

    move-result-object v1

    check-cast v1, Ljava/lang/CharSequence;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 48
    invoke-virtual {p1}, Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;->getModelPView()Landroid/widget/TextView;

    move-result-object v0

    invoke-virtual {p2}, Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;->getModelP()Ljava/lang/String;

    move-result-object v1

    check-cast v1, Ljava/lang/CharSequence;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 49
    invoke-virtual {p1}, Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;->getFindsView()Landroid/widget/TextView;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Detections: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;->getNumber()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    check-cast v1, Ljava/lang/CharSequence;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 50
    sget-object v0, Lau/gov/health/covidsafe/Utils;->INSTANCE:Lau/gov/health/covidsafe/Utils;

    invoke-virtual {p2}, Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;->getTimeStamp()J

    move-result-wide v1

    invoke-virtual {v0, v1, v2}, Lau/gov/health/covidsafe/Utils;->getDate(J)Ljava/lang/String;

    move-result-object v0

    .line 51
    invoke-virtual {p1}, Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;->getTimestampView()Landroid/widget/TextView;

    move-result-object v1

    check-cast v0, Ljava/lang/CharSequence;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 52
    invoke-virtual {p1}, Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;->getVersion()Landroid/widget/TextView;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "v: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;->getVersion()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    check-cast v1, Ljava/lang/CharSequence;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 53
    invoke-virtual {p1}, Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;->getOrg()Landroid/widget/TextView;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "ORG: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;->getOrg()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    check-cast v1, Ljava/lang/CharSequence;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 55
    invoke-virtual {p1}, Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;->getFilterModelP()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p2}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 56
    invoke-virtual {p1}, Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;->getFilterModelC()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p2}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 58
    invoke-virtual {p1}, Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;->getSignalStrengthView()Landroid/widget/TextView;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Signal Strength: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;->getRssi()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    check-cast v1, Ljava/lang/CharSequence;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 60
    invoke-virtual {p1}, Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;->getTxpowerView()Landroid/widget/TextView;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Tx Power: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;->getTransmissionPower()Ljava/lang/Integer;

    move-result-object p2

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    check-cast p2, Ljava/lang/CharSequence;

    invoke-virtual {v0, p2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 62
    invoke-virtual {p1}, Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;->getFilterModelP()Landroid/view/View;

    move-result-object p2

    new-instance v0, Lau/gov/health/covidsafe/RecordListAdapter$onBindViewHolder$1;

    invoke-direct {v0, p0}, Lau/gov/health/covidsafe/RecordListAdapter$onBindViewHolder$1;-><init>(Lau/gov/health/covidsafe/RecordListAdapter;)V

    check-cast v0, Landroid/view/View$OnClickListener;

    invoke-virtual {p2, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 67
    invoke-virtual {p1}, Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;->getFilterModelC()Landroid/view/View;

    move-result-object p1

    new-instance p2, Lau/gov/health/covidsafe/RecordListAdapter$onBindViewHolder$2;

    invoke-direct {p2, p0}, Lau/gov/health/covidsafe/RecordListAdapter$onBindViewHolder$2;-><init>(Lau/gov/health/covidsafe/RecordListAdapter;)V

    check-cast p2, Landroid/view/View$OnClickListener;

    invoke-virtual {p1, p2}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    return-void
.end method

.method public bridge synthetic onCreateViewHolder(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    .locals 0

    .line 13
    invoke-virtual {p0, p1, p2}, Lau/gov/health/covidsafe/RecordListAdapter;->onCreateViewHolder(Landroid/view/ViewGroup;I)Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;

    move-result-object p1

    check-cast p1, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;

    return-object p1
.end method

.method public onCreateViewHolder(Landroid/view/ViewGroup;I)Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;
    .locals 2

    const-string p2, "parent"

    invoke-static {p1, p2}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 40
    iget-object p2, p0, Lau/gov/health/covidsafe/RecordListAdapter;->inflater:Landroid/view/LayoutInflater;

    const v0, 0x7f0d0071

    const/4 v1, 0x0

    invoke-virtual {p2, v0, p1, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p1

    .line 41
    new-instance p2, Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;

    const-string v0, "itemView"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {p2, p0, p1}, Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;-><init>(Lau/gov/health/covidsafe/RecordListAdapter;Landroid/view/View;)V

    return-object p2
.end method

.method public final setMode(Lau/gov/health/covidsafe/RecordListAdapter$MODE;)V
    .locals 1

    const-string v0, "mode"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v0, 0x0

    .line 148
    invoke-direct {p0, p1, v0}, Lau/gov/health/covidsafe/RecordListAdapter;->setMode(Lau/gov/health/covidsafe/RecordListAdapter$MODE;Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;)V

    return-void
.end method

.method public final setSourceData$app_release(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;",
            ">;)V"
        }
    .end annotation

    const-string v0, "records"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 164
    iput-object p1, p0, Lau/gov/health/covidsafe/RecordListAdapter;->sourceData:Ljava/util/List;

    .line 165
    iget-object p1, p0, Lau/gov/health/covidsafe/RecordListAdapter;->mode:Lau/gov/health/covidsafe/RecordListAdapter$MODE;

    invoke-virtual {p0, p1}, Lau/gov/health/covidsafe/RecordListAdapter;->setMode(Lau/gov/health/covidsafe/RecordListAdapter$MODE;)V

    return-void
.end method
