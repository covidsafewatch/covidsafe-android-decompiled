.class final Lau/gov/health/covidsafe/PlotActivity$onCreate$observableStreetRecords$1;
.super Ljava/lang/Object;
.source "PlotActivity.kt"

# interfaces
.implements Lio/reactivex/ObservableOnSubscribe;


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
        "Lio/reactivex/ObservableOnSubscribe<",
        "TT;>;"
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0010\u0000\u001a\u00020\u00012 \u0010\u0002\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0005 \u0006*\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00040\u00040\u0003H\n\u00a2\u0006\u0002\u0008\u0007"
    }
    d2 = {
        "<anonymous>",
        "",
        "it",
        "Lio/reactivex/ObservableEmitter;",
        "",
        "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;",
        "kotlin.jvm.PlatformType",
        "subscribe"
    }
    k = 0x3
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# instance fields
.field final synthetic this$0:Lau/gov/health/covidsafe/PlotActivity;


# direct methods
.method constructor <init>(Lau/gov/health/covidsafe/PlotActivity;)V
    .locals 0

    iput-object p1, p0, Lau/gov/health/covidsafe/PlotActivity$onCreate$observableStreetRecords$1;->this$0:Lau/gov/health/covidsafe/PlotActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final subscribe(Lio/reactivex/ObservableEmitter;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/ObservableEmitter<",
            "Ljava/util/List<",
            "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;",
            ">;>;)V"
        }
    .end annotation

    const-string v0, "it"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 38
    new-instance v0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordStorage;

    iget-object v1, p0, Lau/gov/health/covidsafe/PlotActivity$onCreate$observableStreetRecords$1;->this$0:Lau/gov/health/covidsafe/PlotActivity;

    check-cast v1, Landroid/content/Context;

    invoke-direct {v0, v1}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordStorage;-><init>(Landroid/content/Context;)V

    invoke-virtual {v0}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordStorage;->getAllRecords()Ljava/util/List;

    move-result-object v0

    .line 39
    invoke-interface {p1, v0}, Lio/reactivex/ObservableEmitter;->onNext(Ljava/lang/Object;)V

    return-void
.end method
