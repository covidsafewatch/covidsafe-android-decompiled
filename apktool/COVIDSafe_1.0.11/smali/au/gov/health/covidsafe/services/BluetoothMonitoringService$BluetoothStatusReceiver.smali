.class public final Lau/gov/health/covidsafe/services/BluetoothMonitoringService$BluetoothStatusReceiver;
.super Landroid/content/BroadcastReceiver;
.source "BluetoothMonitoringService.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lau/gov/health/covidsafe/services/BluetoothMonitoringService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x11
    name = "BluetoothStatusReceiver"
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nBluetoothMonitoringService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BluetoothMonitoringService.kt\nau/gov/health/covidsafe/services/BluetoothMonitoringService$BluetoothStatusReceiver\n*L\n1#1,671:1\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008H\u0016\u00a8\u0006\t"
    }
    d2 = {
        "Lau/gov/health/covidsafe/services/BluetoothMonitoringService$BluetoothStatusReceiver;",
        "Landroid/content/BroadcastReceiver;",
        "(Lau/gov/health/covidsafe/services/BluetoothMonitoringService;)V",
        "onReceive",
        "",
        "context",
        "Landroid/content/Context;",
        "intent",
        "Landroid/content/Intent;",
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
.method public constructor <init>(Lau/gov/health/covidsafe/services/BluetoothMonitoringService;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .line 513
    iput-object p1, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$BluetoothStatusReceiver;->this$0:Lau/gov/health/covidsafe/services/BluetoothMonitoringService;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 2

    if-eqz p2, :cond_0

    .line 517
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object p1

    const-string v0, "android.bluetooth.adapter.action.STATE_CHANGED"

    .line 518
    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_0

    const/4 p1, -0x1

    const-string v0, "android.bluetooth.adapter.extra.STATE"

    .line 520
    invoke-virtual {p2, v0, p1}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result p1

    const-string p2, "this@BluetoothMonitoringService.applicationContext"

    const-string v0, "BTMService"

    packed-switch p1, :pswitch_data_0

    goto :goto_0

    .line 522
    :pswitch_0
    sget-object p1, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    const-string v1, "BluetoothAdapter.STATE_TURNING_OFF"

    invoke-virtual {p1, v0, v1}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 523
    sget-object p1, Lau/gov/health/covidsafe/notifications/NotificationTemplates;->Companion:Lau/gov/health/covidsafe/notifications/NotificationTemplates$Companion;

    .line 524
    iget-object v0, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$BluetoothStatusReceiver;->this$0:Lau/gov/health/covidsafe/services/BluetoothMonitoringService;

    invoke-virtual {v0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0, p2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p2, "COVIDSafe Updates"

    .line 523
    invoke-virtual {p1, v0, p2}, Lau/gov/health/covidsafe/notifications/NotificationTemplates$Companion;->lackingThingsNotification(Landroid/content/Context;Ljava/lang/String;)Landroid/app/Notification;

    move-result-object p1

    .line 527
    iget-object p2, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$BluetoothStatusReceiver;->this$0:Lau/gov/health/covidsafe/services/BluetoothMonitoringService;

    const v0, 0xbc5fb

    invoke-virtual {p2, v0, p1}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->startForeground(ILandroid/app/Notification;)V

    .line 528
    iget-object p1, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$BluetoothStatusReceiver;->this$0:Lau/gov/health/covidsafe/services/BluetoothMonitoringService;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->teardown()V

    goto :goto_0

    .line 537
    :pswitch_1
    sget-object p1, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    const-string v1, "BluetoothAdapter.STATE_ON"

    invoke-virtual {p1, v0, v1}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 538
    sget-object p1, Lau/gov/health/covidsafe/Utils;->INSTANCE:Lau/gov/health/covidsafe/Utils;

    iget-object v0, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$BluetoothStatusReceiver;->this$0:Lau/gov/health/covidsafe/services/BluetoothMonitoringService;

    invoke-virtual {v0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0, p2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p1, v0}, Lau/gov/health/covidsafe/Utils;->startBluetoothMonitoringService(Landroid/content/Context;)V

    goto :goto_0

    .line 534
    :pswitch_2
    sget-object p1, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    const-string p2, "BluetoothAdapter.STATE_TURNING_ON"

    invoke-virtual {p1, v0, p2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 531
    :pswitch_3
    sget-object p1, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    const-string p2, "BluetoothAdapter.STATE_OFF"

    invoke-virtual {p1, v0, p2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->d(Ljava/lang/String;Ljava/lang/String;)V

    :cond_0
    :goto_0
    return-void

    nop

    :pswitch_data_0
    .packed-switch 0xa
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
