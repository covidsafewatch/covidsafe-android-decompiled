.class final Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$1;
.super Ljava/lang/Object;
.source "PlotActivity.kt"

# interfaces
.implements Lio/reactivex/functions/BiFunction;


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
        "<T1:",
        "Ljava/lang/Object;",
        "T2:",
        "Ljava/lang/Object;",
        "R:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lio/reactivex/functions/BiFunction<",
        "Ljava/util/List<",
        "+",
        "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;",
        ">;",
        "Ljava/util/List<",
        "+",
        "Lau/gov/health/covidsafe/status/persistence/StatusRecord;",
        ">;",
        "Lau/gov/health/covidsafe/ui/upload/model/DebugData;",
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
        "\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0003H\n\u00a2\u0006\u0002\u0008\u0007"
    }
    d2 = {
        "<anonymous>",
        "Lau/gov/health/covidsafe/ui/upload/model/DebugData;",
        "records",
        "",
        "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;",
        "<anonymous parameter 1>",
        "Lau/gov/health/covidsafe/status/persistence/StatusRecord;",
        "apply"
    }
    k = 0x3
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# static fields
.field public static final INSTANCE:Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$1;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$1;

    invoke-direct {v0}, Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$1;-><init>()V

    sput-object v0, Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$1;->INSTANCE:Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$1;

    return-void
.end method

.method constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final apply(Ljava/util/List;Ljava/util/List;)Lau/gov/health/covidsafe/ui/upload/model/DebugData;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;",
            ">;",
            "Ljava/util/List<",
            "Lau/gov/health/covidsafe/status/persistence/StatusRecord;",
            ">;)",
            "Lau/gov/health/covidsafe/ui/upload/model/DebugData;"
        }
    .end annotation

    const-string v0, "records"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "<anonymous parameter 1>"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 47
    new-instance p2, Lau/gov/health/covidsafe/ui/upload/model/DebugData;

    invoke-direct {p2, p1}, Lau/gov/health/covidsafe/ui/upload/model/DebugData;-><init>(Ljava/util/List;)V

    return-object p2
.end method

.method public bridge synthetic apply(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 0

    .line 22
    check-cast p1, Ljava/util/List;

    check-cast p2, Ljava/util/List;

    invoke-virtual {p0, p1, p2}, Lau/gov/health/covidsafe/PlotActivity$onCreate$zipResult$1;->apply(Ljava/util/List;Ljava/util/List;)Lau/gov/health/covidsafe/ui/upload/model/DebugData;

    move-result-object p1

    return-object p1
.end method
