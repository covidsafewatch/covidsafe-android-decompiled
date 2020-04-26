.class final Lau/gov/health/covidsafe/services/BluetoothMonitoringService$actionStart$1;
.super Lkotlin/jvm/internal/Lambda;
.source "BluetoothMonitoringService.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function1;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->actionStart()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lkotlin/jvm/internal/Lambda;",
        "Lkotlin/jvm/functions/Function1<",
        "Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;",
        "Lkotlin/Unit;",
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
        "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\u0008\u0004"
    }
    d2 = {
        "<anonymous>",
        "",
        "it",
        "Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;",
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
.field final synthetic this$0:Lau/gov/health/covidsafe/services/BluetoothMonitoringService;


# direct methods
.method constructor <init>(Lau/gov/health/covidsafe/services/BluetoothMonitoringService;)V
    .locals 0

    iput-object p1, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$actionStart$1;->this$0:Lau/gov/health/covidsafe/services/BluetoothMonitoringService;

    const/4 p1, 0x1

    invoke-direct {p0, p1}, Lkotlin/jvm/internal/Lambda;-><init>(I)V

    return-void
.end method


# virtual methods
.method public bridge synthetic invoke(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 0

    .line 44
    check-cast p1, Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;

    invoke-virtual {p0, p1}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$actionStart$1;->invoke(Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;)V

    sget-object p1, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p1
.end method

.method public final invoke(Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;)V
    .locals 1

    const-string v0, "it"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 290
    sget-object v0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->Companion:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Companion;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;->getTempId()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v0, p1}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Companion;->setBroadcastMessage(Ljava/lang/String;)V

    .line 291
    iget-object p1, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$actionStart$1;->this$0:Lau/gov/health/covidsafe/services/BluetoothMonitoringService;

    invoke-static {p1}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->access$setupCycles(Lau/gov/health/covidsafe/services/BluetoothMonitoringService;)V

    return-void
.end method
