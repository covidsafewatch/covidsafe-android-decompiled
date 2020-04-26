.class final Lau/gov/health/covidsafe/services/BluetoothMonitoringService$isBluetoothEnabled$bluetoothAdapter$2;
.super Lkotlin/jvm/internal/Lambda;
.source "BluetoothMonitoringService.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function0;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->isBluetoothEnabled()Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lkotlin/jvm/internal/Lambda;",
        "Lkotlin/jvm/functions/Function0<",
        "Landroid/bluetooth/BluetoothAdapter;",
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
        "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n\u00a2\u0006\u0002\u0008\u0003"
    }
    d2 = {
        "<anonymous>",
        "Landroid/bluetooth/BluetoothAdapter;",
        "kotlin.jvm.PlatformType",
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

    iput-object p1, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$isBluetoothEnabled$bluetoothAdapter$2;->this$0:Lau/gov/health/covidsafe/services/BluetoothMonitoringService;

    const/4 p1, 0x0

    invoke-direct {p0, p1}, Lkotlin/jvm/internal/Lambda;-><init>(I)V

    return-void
.end method


# virtual methods
.method public final invoke()Landroid/bluetooth/BluetoothAdapter;
    .locals 2

    .line 166
    iget-object v0, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$isBluetoothEnabled$bluetoothAdapter$2;->this$0:Lau/gov/health/covidsafe/services/BluetoothMonitoringService;

    const-string v1, "bluetooth"

    invoke-virtual {v0, v1}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_0

    check-cast v0, Landroid/bluetooth/BluetoothManager;

    .line 167
    invoke-virtual {v0}, Landroid/bluetooth/BluetoothManager;->getAdapter()Landroid/bluetooth/BluetoothAdapter;

    move-result-object v0

    return-object v0

    .line 166
    :cond_0
    new-instance v0, Lkotlin/TypeCastException;

    const-string v1, "null cannot be cast to non-null type android.bluetooth.BluetoothManager"

    invoke-direct {v0, v1}, Lkotlin/TypeCastException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public bridge synthetic invoke()Ljava/lang/Object;
    .locals 1

    .line 44
    invoke-virtual {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$isBluetoothEnabled$bluetoothAdapter$2;->invoke()Landroid/bluetooth/BluetoothAdapter;

    move-result-object v0

    return-object v0
.end method
