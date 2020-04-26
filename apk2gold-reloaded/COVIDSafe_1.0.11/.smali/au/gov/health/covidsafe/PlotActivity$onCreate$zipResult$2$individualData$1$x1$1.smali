.class final Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2$individualData$1$x1$1;
.super Lkotlin/jvm/internal/Lambda;
.source "PlotActivity.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function1;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2$individualData$1;->invoke(Ljava/lang/String;)Ljava/lang/String;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lkotlin/jvm/internal/Lambda;",
        "Lkotlin/jvm/functions/Function1<",
        "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n\u00a2\u0006\u0002\u0008\u0005"
    }
    d2 = {
        "<anonymous>",
        "",
        "kotlin.jvm.PlatformType",
        "it",
        "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;",
        "invoke"
    }
    k = 0x3
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# instance fields
.field final synthetic this$0:Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2$individualData$1;


# direct methods
.method constructor <init>(Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2$individualData$1;)V
    .locals 0

    iput-object p1, p0, Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2$individualData$1$x1$1;->this$0:Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2$individualData$1;

    const/4 p1, 0x1

    invoke-direct {p0, p1}, Lkotlin/jvm/internal/Lambda;-><init>(I)V

    return-void
.end method


# virtual methods
.method public bridge synthetic invoke(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 0

    .line 22
    check-cast p1, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;

    invoke-virtual {p0, p1}, Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2$individualData$1$x1$1;->invoke(Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;)Ljava/lang/String;

    move-result-object p1

    return-object p1
.end method

.method public final invoke(Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;)Ljava/lang/String;
    .locals 4

    const-string v0, "it"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 121
    iget-object v0, p0, Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2$individualData$1$x1$1;->this$0:Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2$individualData$1;

    iget-object v0, v0, Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$2$individualData$1;->$dateFormatter:Ljava/text/SimpleDateFormat;

    new-instance v1, Ljava/util/Date;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->getTimestamp()J

    move-result-wide v2

    invoke-direct {v1, v2, v3}, Ljava/util/Date;-><init>(J)V

    invoke-virtual {v0, v1}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object p1

    const-string v0, "dateFormatter.format(Date(it.timestamp))"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    return-object p1
.end method
