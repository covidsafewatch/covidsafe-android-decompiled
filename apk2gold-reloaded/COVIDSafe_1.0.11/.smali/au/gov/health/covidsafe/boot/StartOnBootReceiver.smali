.class public final Lau/gov/health/covidsafe/boot/StartOnBootReceiver;
.super Landroid/content/BroadcastReceiver;
.source "StartOnBootReceiver.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016\u00a8\u0006\t"
    }
    d2 = {
        "Lau/gov/health/covidsafe/boot/StartOnBootReceiver;",
        "Landroid/content/BroadcastReceiver;",
        "()V",
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


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 3

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "intent"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 12
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object p2

    const-string v0, "android.intent.action.BOOT_COMPLETED"

    invoke-static {v0, p2}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p2

    if-eqz p2, :cond_0

    .line 13
    sget-object p2, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    const-string v0, "StartOnBootReceiver"

    const-string v1, "boot completed received"

    invoke-virtual {p2, v0, v1}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 17
    :try_start_0
    sget-object p2, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    const-string v1, "Attempting to start service"

    invoke-virtual {p2, v0, v1}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 18
    sget-object p2, Lau/gov/health/covidsafe/Utils;->INSTANCE:Lau/gov/health/covidsafe/Utils;

    const-wide/16 v1, 0x1f4

    invoke-virtual {p2, p1, v1, v2}, Lau/gov/health/covidsafe/Utils;->scheduleStartMonitoringService(Landroid/content/Context;J)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception p1

    .line 20
    sget-object p2, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    invoke-virtual {p1}, Ljava/lang/Throwable;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v1

    const-string v2, "e.localizedMessage"

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p2, v0, v1}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 21
    invoke-virtual {p1}, Ljava/lang/Throwable;->printStackTrace()V

    :cond_0
    :goto_0
    return-void
.end method
