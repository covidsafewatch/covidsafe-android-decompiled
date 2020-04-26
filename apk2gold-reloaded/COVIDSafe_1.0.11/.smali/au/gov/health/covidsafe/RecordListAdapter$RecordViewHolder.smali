.class public final Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "RecordListAdapter.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lau/gov/health/covidsafe/RecordListAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x11
    name = "RecordViewHolder"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0013\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0008\u001a\u00020\u0003\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\rR\u0011\u0010\u0012\u001a\u00020\u000b\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\rR\u0011\u0010\u0014\u001a\u00020\u000b\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\rR\u0011\u0010\u0016\u001a\u00020\u000b\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\rR\u0011\u0010\u0018\u001a\u00020\u000b\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\rR\u0011\u0010\u001a\u001a\u00020\u000b\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\rR\u0011\u0010\u001c\u001a\u00020\u000b\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\r\u00a8\u0006\u001e"
    }
    d2 = {
        "Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;",
        "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;",
        "itemView",
        "Landroid/view/View;",
        "(Lau/gov/health/covidsafe/RecordListAdapter;Landroid/view/View;)V",
        "filterModelC",
        "getFilterModelC",
        "()Landroid/view/View;",
        "filterModelP",
        "getFilterModelP",
        "findsView",
        "Landroid/widget/TextView;",
        "getFindsView",
        "()Landroid/widget/TextView;",
        "modelCView",
        "getModelCView",
        "modelPView",
        "getModelPView",
        "msgView",
        "getMsgView",
        "org",
        "getOrg",
        "signalStrengthView",
        "getSignalStrengthView",
        "timestampView",
        "getTimestampView",
        "txpowerView",
        "getTxpowerView",
        "version",
        "getVersion",
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
.field private final filterModelC:Landroid/view/View;

.field private final filterModelP:Landroid/view/View;

.field private final findsView:Landroid/widget/TextView;

.field private final modelCView:Landroid/widget/TextView;

.field private final modelPView:Landroid/widget/TextView;

.field private final msgView:Landroid/widget/TextView;

.field private final org:Landroid/widget/TextView;

.field private final signalStrengthView:Landroid/widget/TextView;

.field final synthetic this$0:Lau/gov/health/covidsafe/RecordListAdapter;

.field private final timestampView:Landroid/widget/TextView;

.field private final txpowerView:Landroid/widget/TextView;

.field private final version:Landroid/widget/TextView;


# direct methods
.method public constructor <init>(Lau/gov/health/covidsafe/RecordListAdapter;Landroid/view/View;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/View;",
            ")V"
        }
    .end annotation

    const-string v0, "itemView"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 25
    iput-object p1, p0, Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;->this$0:Lau/gov/health/covidsafe/RecordListAdapter;

    invoke-direct {p0, p2}, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V

    const p1, 0x7f0a011c

    .line 26
    invoke-virtual {p2, p1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    const-string v0, "itemView.findViewById(R.id.modelc)"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast p1, Landroid/widget/TextView;

    iput-object p1, p0, Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;->modelCView:Landroid/widget/TextView;

    const p1, 0x7f0a011d

    .line 27
    invoke-virtual {p2, p1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    const-string v0, "itemView.findViewById(R.id.modelp)"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast p1, Landroid/widget/TextView;

    iput-object p1, p0, Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;->modelPView:Landroid/widget/TextView;

    const p1, 0x7f0a01e4

    .line 28
    invoke-virtual {p2, p1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    const-string v0, "itemView.findViewById(R.id.timestamp)"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast p1, Landroid/widget/TextView;

    iput-object p1, p0, Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;->timestampView:Landroid/widget/TextView;

    const p1, 0x7f0a00c4

    .line 29
    invoke-virtual {p2, p1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    const-string v0, "itemView.findViewById(R.id.finds)"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast p1, Landroid/widget/TextView;

    iput-object p1, p0, Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;->findsView:Landroid/widget/TextView;

    const p1, 0x7f0a01f2

    .line 30
    invoke-virtual {p2, p1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    const-string v0, "itemView.findViewById(R.id.txpower)"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast p1, Landroid/widget/TextView;

    iput-object p1, p0, Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;->txpowerView:Landroid/widget/TextView;

    const p1, 0x7f0a01ad

    .line 31
    invoke-virtual {p2, p1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    const-string v0, "itemView.findViewById(R.id.signal_strength)"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast p1, Landroid/widget/TextView;

    iput-object p1, p0, Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;->signalStrengthView:Landroid/widget/TextView;

    const p1, 0x7f0a00c2

    .line 32
    invoke-virtual {p2, p1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    const-string v0, "itemView.findViewById(R.id.filter_by_modelp)"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    iput-object p1, p0, Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;->filterModelP:Landroid/view/View;

    const p1, 0x7f0a00c1

    .line 33
    invoke-virtual {p2, p1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    const-string v0, "itemView.findViewById(R.id.filter_by_modelc)"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    iput-object p1, p0, Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;->filterModelC:Landroid/view/View;

    const p1, 0x7f0a0124

    .line 34
    invoke-virtual {p2, p1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    const-string v0, "itemView.findViewById(R.id.msg)"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast p1, Landroid/widget/TextView;

    iput-object p1, p0, Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;->msgView:Landroid/widget/TextView;

    const p1, 0x7f0a0209

    .line 35
    invoke-virtual {p2, p1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    const-string v0, "itemView.findViewById(R.id.version)"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast p1, Landroid/widget/TextView;

    iput-object p1, p0, Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;->version:Landroid/widget/TextView;

    const p1, 0x7f0a014d

    .line 36
    invoke-virtual {p2, p1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    const-string p2, "itemView.findViewById(R.id.org)"

    invoke-static {p1, p2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast p1, Landroid/widget/TextView;

    iput-object p1, p0, Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;->org:Landroid/widget/TextView;

    return-void
.end method


# virtual methods
.method public final getFilterModelC()Landroid/view/View;
    .locals 1

    .line 33
    iget-object v0, p0, Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;->filterModelC:Landroid/view/View;

    return-object v0
.end method

.method public final getFilterModelP()Landroid/view/View;
    .locals 1

    .line 32
    iget-object v0, p0, Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;->filterModelP:Landroid/view/View;

    return-object v0
.end method

.method public final getFindsView()Landroid/widget/TextView;
    .locals 1

    .line 29
    iget-object v0, p0, Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;->findsView:Landroid/widget/TextView;

    return-object v0
.end method

.method public final getModelCView()Landroid/widget/TextView;
    .locals 1

    .line 26
    iget-object v0, p0, Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;->modelCView:Landroid/widget/TextView;

    return-object v0
.end method

.method public final getModelPView()Landroid/widget/TextView;
    .locals 1

    .line 27
    iget-object v0, p0, Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;->modelPView:Landroid/widget/TextView;

    return-object v0
.end method

.method public final getMsgView()Landroid/widget/TextView;
    .locals 1

    .line 34
    iget-object v0, p0, Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;->msgView:Landroid/widget/TextView;

    return-object v0
.end method

.method public final getOrg()Landroid/widget/TextView;
    .locals 1

    .line 36
    iget-object v0, p0, Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;->org:Landroid/widget/TextView;

    return-object v0
.end method

.method public final getSignalStrengthView()Landroid/widget/TextView;
    .locals 1

    .line 31
    iget-object v0, p0, Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;->signalStrengthView:Landroid/widget/TextView;

    return-object v0
.end method

.method public final getTimestampView()Landroid/widget/TextView;
    .locals 1

    .line 28
    iget-object v0, p0, Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;->timestampView:Landroid/widget/TextView;

    return-object v0
.end method

.method public final getTxpowerView()Landroid/widget/TextView;
    .locals 1

    .line 30
    iget-object v0, p0, Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;->txpowerView:Landroid/widget/TextView;

    return-object v0
.end method

.method public final getVersion()Landroid/widget/TextView;
    .locals 1

    .line 35
    iget-object v0, p0, Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;->version:Landroid/widget/TextView;

    return-object v0
.end method
