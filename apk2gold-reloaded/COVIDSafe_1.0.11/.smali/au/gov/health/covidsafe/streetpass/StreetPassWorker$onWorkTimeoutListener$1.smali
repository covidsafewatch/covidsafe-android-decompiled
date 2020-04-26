.class public final Lau/gov/health/covidsafe/streetpass/StreetPassWorker$onWorkTimeoutListener$1;
.super Ljava/lang/Object;
.source "StreetPassWorker.kt"

# interfaces
.implements Lau/gov/health/covidsafe/streetpass/Work$OnWorkTimeoutListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lau/gov/health/covidsafe/streetpass/StreetPassWorker;-><init>(Landroid/content/Context;)V
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
        "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\u0006"
    }
    d2 = {
        "au/gov/health/covidsafe/streetpass/StreetPassWorker$onWorkTimeoutListener$1",
        "Lau/gov/health/covidsafe/streetpass/Work$OnWorkTimeoutListener;",
        "onWorkTimeout",
        "",
        "work",
        "Lau/gov/health/covidsafe/streetpass/Work;",
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
.field final synthetic this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;


# direct methods
.method constructor <init>(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .line 42
    iput-object p1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$onWorkTimeoutListener$1;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onWorkTimeout(Lau/gov/health/covidsafe/streetpass/Work;)V
    .locals 7

    const-string v0, "work"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 45
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$onWorkTimeoutListener$1;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v1

    invoke-virtual {v1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->isCurrentlyWorkedOn(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 46
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$onWorkTimeoutListener$1;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-static {v1}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->access$getTAG$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "Work already removed. Timeout ineffective??."

    invoke-virtual {v0, v1, v2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 49
    :cond_0
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 50
    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$onWorkTimeoutListener$1;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-static {v1}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->access$getTAG$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Ljava/lang/String;

    move-result-object v1

    .line 51
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Work timed out for "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v3

    invoke-virtual {v3}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v3, " @ "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getConnectable()Lau/gov/health/covidsafe/streetpass/ConnectablePeripheral;

    move-result-object v3

    invoke-virtual {v3}, Lau/gov/health/covidsafe/streetpass/ConnectablePeripheral;->getRssi()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v3, " queued for "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getChecklist()Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;

    move-result-object v3

    invoke-virtual {v3}, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->getStarted()Lau/gov/health/covidsafe/streetpass/Work$Check;

    move-result-object v3

    invoke-virtual {v3}, Lau/gov/health/covidsafe/streetpass/Work$Check;->getTimePerformed()J

    move-result-wide v3

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getTimeStamp()J

    move-result-wide v5

    sub-long/2addr v3, v5

    invoke-virtual {v2, v3, v4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    const-string v3, "ms"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 49
    invoke-virtual {v0, v1, v2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 53
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 54
    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$onWorkTimeoutListener$1;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-static {v1}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->access$getTAG$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Ljava/lang/String;

    move-result-object v1

    .line 55
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v3

    invoke-virtual {v3}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v3, " work status: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getChecklist()Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const/16 v3, 0x2e

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 53
    invoke-virtual {v0, v1, v2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 59
    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getChecklist()Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;

    move-result-object v0

    invoke-virtual {v0}, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->getConnected()Lau/gov/health/covidsafe/streetpass/Work$Check;

    move-result-object v0

    invoke-virtual {v0}, Lau/gov/health/covidsafe/streetpass/Work$Check;->getStatus()Z

    move-result v0

    const-string v1, ": "

    const/4 v2, 0x0

    if-nez v0, :cond_4

    .line 60
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v3, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$onWorkTimeoutListener$1;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-static {v3}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->access$getTAG$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Ljava/lang/String;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "No connection formed for "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v5

    invoke-virtual {v5}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 61
    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v0

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v0

    iget-object v3, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$onWorkTimeoutListener$1;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-static {v3}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->access$getCurrentPendingConnection$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Lau/gov/health/covidsafe/streetpass/Work;

    move-result-object v3

    if-eqz v3, :cond_1

    invoke-virtual {v3}, Lau/gov/health/covidsafe/streetpass/Work;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v3

    if-eqz v3, :cond_1

    invoke-virtual {v3}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v3

    goto :goto_0

    :cond_1
    move-object v3, v2

    :goto_0
    invoke-static {v0, v3}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 62
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$onWorkTimeoutListener$1;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    check-cast v2, Lau/gov/health/covidsafe/streetpass/Work;

    invoke-static {v0, v2}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->access$setCurrentPendingConnection$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;Lau/gov/health/covidsafe/streetpass/Work;)V

    .line 66
    :cond_2
    :try_start_0
    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getGatt()Landroid/bluetooth/BluetoothGatt;

    move-result-object v0

    if-eqz v0, :cond_3

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothGatt;->close()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    :catch_0
    move-exception v0

    .line 68
    sget-object v2, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 69
    iget-object v3, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$onWorkTimeoutListener$1;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-static {v3}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->access$getTAG$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Ljava/lang/String;

    move-result-object v3

    .line 70
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Unexpected error while attempting to close clientIf to "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v5

    invoke-virtual {v5}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 68
    invoke-virtual {v2, v3, v0}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 74
    :cond_3
    :goto_1
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$onWorkTimeoutListener$1;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-virtual {v0, p1}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->finishWork(Lau/gov/health/covidsafe/streetpass/Work;)V

    goto/16 :goto_3

    .line 77
    :cond_4
    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getChecklist()Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;

    move-result-object v0

    invoke-virtual {v0}, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->getConnected()Lau/gov/health/covidsafe/streetpass/Work$Check;

    move-result-object v0

    invoke-virtual {v0}, Lau/gov/health/covidsafe/streetpass/Work$Check;->getStatus()Z

    move-result v0

    if-eqz v0, :cond_9

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getChecklist()Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;

    move-result-object v0

    invoke-virtual {v0}, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->getDisconnected()Lau/gov/health/covidsafe/streetpass/Work$Check;

    move-result-object v0

    invoke-virtual {v0}, Lau/gov/health/covidsafe/streetpass/Work$Check;->getStatus()Z

    move-result v0

    if-nez v0, :cond_9

    .line 79
    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getChecklist()Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;

    move-result-object v0

    invoke-virtual {v0}, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->getReadCharacteristic()Lau/gov/health/covidsafe/streetpass/Work$Check;

    move-result-object v0

    invoke-virtual {v0}, Lau/gov/health/covidsafe/streetpass/Work$Check;->getStatus()Z

    move-result v0

    const-string v1, "Failed to clean up work, bluetooth state likely changed or other device\'s advertiser stopped: "

    if-nez v0, :cond_7

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getChecklist()Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;

    move-result-object v0

    invoke-virtual {v0}, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->getWriteCharacteristic()Lau/gov/health/covidsafe/streetpass/Work$Check;

    move-result-object v0

    invoke-virtual {v0}, Lau/gov/health/covidsafe/streetpass/Work$Check;->getStatus()Z

    move-result v0

    if-nez v0, :cond_7

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getChecklist()Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;

    move-result-object v0

    invoke-virtual {v0}, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->getSkipped()Lau/gov/health/covidsafe/streetpass/Work$Check;

    move-result-object v0

    invoke-virtual {v0}, Lau/gov/health/covidsafe/streetpass/Work$Check;->getStatus()Z

    move-result v0

    if-eqz v0, :cond_5

    goto :goto_2

    .line 100
    :cond_5
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 101
    iget-object v3, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$onWorkTimeoutListener$1;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-static {v3}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->access$getTAG$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Ljava/lang/String;

    move-result-object v3

    .line 102
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Connected but did nothing for "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v5

    invoke-virtual {v5}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 100
    invoke-virtual {v0, v3, v4}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 106
    :try_start_1
    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getGatt()Landroid/bluetooth/BluetoothGatt;

    move-result-object v0

    if-eqz v0, :cond_6

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothGatt;->disconnect()V

    .line 108
    :cond_6
    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getGatt()Landroid/bluetooth/BluetoothGatt;

    move-result-object v0

    if-nez v0, :cond_a

    .line 109
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$onWorkTimeoutListener$1;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    check-cast v2, Lau/gov/health/covidsafe/streetpass/Work;

    invoke-static {v0, v2}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->access$setCurrentPendingConnection$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;Lau/gov/health/covidsafe/streetpass/Work;)V

    .line 110
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$onWorkTimeoutListener$1;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-virtual {v0, p1}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->finishWork(Lau/gov/health/covidsafe/streetpass/Work;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto/16 :goto_3

    :catchall_0
    move-exception p1

    .line 113
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 114
    iget-object v2, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$onWorkTimeoutListener$1;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-static {v2}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->access$getTAG$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Ljava/lang/String;

    move-result-object v2

    .line 115
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Ljava/lang/Throwable;->getLocalizedMessage()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    .line 113
    invoke-virtual {v0, v2, p1}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_3

    .line 80
    :cond_7
    :goto_2
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 81
    iget-object v3, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$onWorkTimeoutListener$1;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-static {v3}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->access$getTAG$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Ljava/lang/String;

    move-result-object v3

    .line 82
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Connected but did not disconnect in time for "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v5

    invoke-virtual {v5}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 80
    invoke-virtual {v0, v3, v4}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 86
    :try_start_2
    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getGatt()Landroid/bluetooth/BluetoothGatt;

    move-result-object v0

    if-eqz v0, :cond_8

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothGatt;->disconnect()V

    .line 88
    :cond_8
    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getGatt()Landroid/bluetooth/BluetoothGatt;

    move-result-object v0

    if-nez v0, :cond_a

    .line 89
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$onWorkTimeoutListener$1;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    check-cast v2, Lau/gov/health/covidsafe/streetpass/Work;

    invoke-static {v0, v2}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->access$setCurrentPendingConnection$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;Lau/gov/health/covidsafe/streetpass/Work;)V

    .line 90
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$onWorkTimeoutListener$1;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-virtual {v0, p1}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->finishWork(Lau/gov/health/covidsafe/streetpass/Work;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    goto :goto_3

    :catchall_1
    move-exception p1

    .line 93
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 94
    iget-object v2, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$onWorkTimeoutListener$1;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-static {v2}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->access$getTAG$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Ljava/lang/String;

    move-result-object v2

    .line 95
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Ljava/lang/Throwable;->getLocalizedMessage()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    .line 93
    invoke-virtual {v0, v2, p1}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_3

    .line 123
    :cond_9
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 124
    iget-object v2, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$onWorkTimeoutListener$1;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-static {v2}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->access$getTAG$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Ljava/lang/String;

    move-result-object v2

    .line 125
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Disconnected but callback not invoked in time. Waiting.: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v4

    invoke-virtual {v4}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getChecklist()Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;

    move-result-object p1

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    .line 123
    invoke-virtual {v0, v2, p1}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->e(Ljava/lang/String;Ljava/lang/String;)V

    :cond_a
    :goto_3
    return-void
.end method
