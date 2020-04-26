.class public final Lau/gov/health/covidsafe/services/BluetoothMonitoringService$connection$1;
.super Ljava/lang/Object;
.source "BluetoothMonitoringService.kt"

# interfaces
.implements Landroid/content/ServiceConnection;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lau/gov/health/covidsafe/services/BluetoothMonitoringService;-><init>()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = null
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0008\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0016\u00a8\u0006\n"
    }
    d2 = {
        "au/gov/health/covidsafe/services/BluetoothMonitoringService$connection$1",
        "Landroid/content/ServiceConnection;",
        "onServiceConnected",
        "",
        "className",
        "Landroid/content/ComponentName;",
        "service",
        "Landroid/os/IBinder;",
        "onServiceDisconnected",
        "arg0",
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
.field final synthetic this$0:Lau/gov/health/covidsafe/services/BluetoothMonitoringService;


# direct methods
.method constructor <init>(Lau/gov/health/covidsafe/services/BluetoothMonitoringService;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .line 79
    iput-object p1, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$connection$1;->this$0:Lau/gov/health/covidsafe/services/BluetoothMonitoringService;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onServiceConnected(Landroid/content/ComponentName;Landroid/os/IBinder;)V
    .locals 1

    const-string v0, "className"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p1, "service"

    invoke-static {p2, p1}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 83
    check-cast p2, Lau/gov/health/covidsafe/services/SensorMonitoringService$LocalBinder;

    .line 84
    iget-object p1, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$connection$1;->this$0:Lau/gov/health/covidsafe/services/BluetoothMonitoringService;

    invoke-virtual {p2}, Lau/gov/health/covidsafe/services/SensorMonitoringService$LocalBinder;->getService()Lau/gov/health/covidsafe/services/SensorMonitoringService;

    move-result-object p2

    invoke-static {p1, p2}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->access$setMService$p(Lau/gov/health/covidsafe/services/BluetoothMonitoringService;Lau/gov/health/covidsafe/services/SensorMonitoringService;)V

    .line 85
    iget-object p1, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$connection$1;->this$0:Lau/gov/health/covidsafe/services/BluetoothMonitoringService;

    const/4 p2, 0x1

    invoke-static {p1, p2}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->access$setMBound$p(Lau/gov/health/covidsafe/services/BluetoothMonitoringService;Z)V

    return-void
.end method

.method public onServiceDisconnected(Landroid/content/ComponentName;)V
    .locals 1

    const-string v0, "arg0"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 89
    iget-object p1, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$connection$1;->this$0:Lau/gov/health/covidsafe/services/BluetoothMonitoringService;

    const/4 v0, 0x0

    invoke-static {p1, v0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->access$setMBound$p(Lau/gov/health/covidsafe/services/BluetoothMonitoringService;Z)V

    return-void
.end method
