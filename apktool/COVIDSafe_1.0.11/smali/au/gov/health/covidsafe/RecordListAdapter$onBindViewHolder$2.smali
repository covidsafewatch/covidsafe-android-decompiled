.class final Lau/gov/health/covidsafe/RecordListAdapter$onBindViewHolder$2;
.super Ljava/lang/Object;
.source "RecordListAdapter.kt"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lau/gov/health/covidsafe/RecordListAdapter;->onBindViewHolder(Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = null
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
        "it",
        "Landroid/view/View;",
        "kotlin.jvm.PlatformType",
        "onClick"
    }
    k = 0x3
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# instance fields
.field final synthetic this$0:Lau/gov/health/covidsafe/RecordListAdapter;


# direct methods
.method constructor <init>(Lau/gov/health/covidsafe/RecordListAdapter;)V
    .locals 0

    iput-object p1, p0, Lau/gov/health/covidsafe/RecordListAdapter$onBindViewHolder$2;->this$0:Lau/gov/health/covidsafe/RecordListAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 2

    const-string v0, "it"

    .line 68
    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object p1

    if-eqz p1, :cond_0

    check-cast p1, Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;

    .line 69
    iget-object v0, p0, Lau/gov/health/covidsafe/RecordListAdapter$onBindViewHolder$2;->this$0:Lau/gov/health/covidsafe/RecordListAdapter;

    sget-object v1, Lau/gov/health/covidsafe/RecordListAdapter$MODE;->MODEL_C:Lau/gov/health/covidsafe/RecordListAdapter$MODE;

    invoke-static {v0, v1, p1}, Lau/gov/health/covidsafe/RecordListAdapter;->access$setMode(Lau/gov/health/covidsafe/RecordListAdapter;Lau/gov/health/covidsafe/RecordListAdapter$MODE;Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;)V

    return-void

    .line 68
    :cond_0
    new-instance p1, Lkotlin/TypeCastException;

    const-string v0, "null cannot be cast to non-null type au.gov.health.covidsafe.streetpass.view.StreetPassRecordViewModel"

    invoke-direct {p1, v0}, Lkotlin/TypeCastException;-><init>(Ljava/lang/String;)V

    throw p1
.end method
