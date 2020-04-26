.class public final Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;
.super Landroid/bluetooth/BluetoothGattCallback;
.source "StreetPassWorker.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lau/gov/health/covidsafe/streetpass/StreetPassWorker;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x11
    name = "StreetPassGattCallback"
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nStreetPassWorker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreetPassWorker.kt\nau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback\n*L\n1#1,723:1\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0002J \u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\rH\u0016J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\rH\u0016J\"\u0010\u000f\u001a\u00020\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00082\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0016J\"\u0010\u0011\u001a\u00020\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00082\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000c\u001a\u00020\rH\u0016J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u000c\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"
    }
    d2 = {
        "Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;",
        "Landroid/bluetooth/BluetoothGattCallback;",
        "work",
        "Lau/gov/health/covidsafe/streetpass/Work;",
        "(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;Lau/gov/health/covidsafe/streetpass/Work;)V",
        "endWorkConnection",
        "",
        "gatt",
        "Landroid/bluetooth/BluetoothGatt;",
        "onCharacteristicRead",
        "characteristic",
        "Landroid/bluetooth/BluetoothGattCharacteristic;",
        "status",
        "",
        "onCharacteristicWrite",
        "onConnectionStateChange",
        "newState",
        "onMtuChanged",
        "mtu",
        "onServicesDiscovered",
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

.field private final work:Lau/gov/health/covidsafe/streetpass/Work;


# direct methods
.method public constructor <init>(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;Lau/gov/health/covidsafe/streetpass/Work;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lau/gov/health/covidsafe/streetpass/Work;",
            ")V"
        }
    .end annotation

    const-string v0, "work"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 397
    iput-object p1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-direct {p0}, Landroid/bluetooth/BluetoothGattCallback;-><init>()V

    iput-object p2, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->work:Lau/gov/health/covidsafe/streetpass/Work;

    return-void
.end method

.method private final endWorkConnection(Landroid/bluetooth/BluetoothGatt;)V
    .locals 5

    .line 400
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-static {v1}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->access$getTAG$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Ending connection with: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothGatt;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v3

    const-string v4, "gatt.device"

    invoke-static {v3, v4}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v3}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 401
    invoke-virtual {p1}, Landroid/bluetooth/BluetoothGatt;->disconnect()V

    return-void
.end method


# virtual methods
.method public onCharacteristicRead(Landroid/bluetooth/BluetoothGatt;Landroid/bluetooth/BluetoothGattCharacteristic;I)V
    .locals 11

    const-string v0, "gatt"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "characteristic"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 525
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-static {v1}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->access$getTAG$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Read Status: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    const-string v0, ": "

    const-string v1, "gatt.device"

    if-eqz p3, :cond_0

    .line 579
    sget-object v2, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 580
    iget-object v3, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-static {v3}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->access$getTAG$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Ljava/lang/String;

    move-result-object v3

    .line 581
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Failed to read characteristics from "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothGatt;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v5

    invoke-static {v5, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v5}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p3

    .line 579
    invoke-virtual {v2, v3, p3}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_1

    .line 528
    :cond_0
    sget-object p3, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 529
    iget-object v2, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-static {v2}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->access$getTAG$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Ljava/lang/String;

    move-result-object v2

    .line 530
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Characteristic read from "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothGatt;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v4

    invoke-static {v4, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v4}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/4 v4, 0x0

    invoke-virtual {p2, v4}, Landroid/bluetooth/BluetoothGattCharacteristic;->getStringValue(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 528
    invoke-virtual {p3, v2, v3}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 535
    invoke-virtual {p2}, Landroid/bluetooth/BluetoothGattCharacteristic;->getUuid()Ljava/util/UUID;

    move-result-object p3

    .line 537
    iget-object v2, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-static {v2}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->access$getServiceUUID$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Ljava/util/UUID;

    move-result-object v2

    invoke-static {p3, v2}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p3

    if-eqz p3, :cond_1

    .line 539
    sget-object p3, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 540
    iget-object v2, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-static {v2}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->access$getTAG$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Ljava/lang/String;

    move-result-object v2

    .line 541
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "onCharacteristicRead: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v4, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->work:Lau/gov/health/covidsafe/streetpass/Work;

    invoke-virtual {v4}, Lau/gov/health/covidsafe/streetpass/Work;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v4

    invoke-virtual {v4}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v4, " - ["

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v4, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->work:Lau/gov/health/covidsafe/streetpass/Work;

    invoke-virtual {v4}, Lau/gov/health/covidsafe/streetpass/Work;->getConnectable()Lau/gov/health/covidsafe/streetpass/ConnectablePeripheral;

    move-result-object v4

    invoke-virtual {v4}, Lau/gov/health/covidsafe/streetpass/ConnectablePeripheral;->getRssi()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const/16 v4, 0x5d

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 539
    invoke-virtual {p3, v2, v3}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 544
    invoke-virtual {p2}, Landroid/bluetooth/BluetoothGattCharacteristic;->getValue()[B

    move-result-object p3

    .line 547
    :try_start_0
    sget-object v2, Lau/gov/health/covidsafe/bluetooth/gatt/ReadRequestPayload;->Companion:Lau/gov/health/covidsafe/bluetooth/gatt/ReadRequestPayload$Companion;

    const-string v3, "dataBytes"

    invoke-static {p3, v3}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v2, p3}, Lau/gov/health/covidsafe/bluetooth/gatt/ReadRequestPayload$Companion;->createReadRequestPayload([B)Lau/gov/health/covidsafe/bluetooth/gatt/ReadRequestPayload;

    move-result-object p3

    .line 549
    new-instance v6, Lau/gov/health/covidsafe/streetpass/PeripheralDevice;

    invoke-virtual {p3}, Lau/gov/health/covidsafe/bluetooth/gatt/ReadRequestPayload;->getModelP()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->work:Lau/gov/health/covidsafe/streetpass/Work;

    invoke-virtual {v3}, Lau/gov/health/covidsafe/streetpass/Work;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v3

    invoke-virtual {v3}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v6, v2, v3}, Lau/gov/health/covidsafe/streetpass/PeripheralDevice;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 551
    new-instance v10, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;

    .line 552
    invoke-virtual {p3}, Lau/gov/health/covidsafe/bluetooth/gatt/ReadRequestPayload;->getV()I

    move-result v3

    .line 553
    invoke-virtual {p3}, Lau/gov/health/covidsafe/bluetooth/gatt/ReadRequestPayload;->getMsg()Ljava/lang/String;

    move-result-object v4

    .line 554
    invoke-virtual {p3}, Lau/gov/health/covidsafe/bluetooth/gatt/ReadRequestPayload;->getOrg()Ljava/lang/String;

    move-result-object v5

    .line 556
    sget-object p3, Lau/gov/health/covidsafe/TracerApp;->Companion:Lau/gov/health/covidsafe/TracerApp$Companion;

    invoke-virtual {p3}, Lau/gov/health/covidsafe/TracerApp$Companion;->asCentralDevice()Lau/gov/health/covidsafe/streetpass/CentralDevice;

    move-result-object v7

    .line 557
    iget-object p3, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->work:Lau/gov/health/covidsafe/streetpass/Work;

    invoke-virtual {p3}, Lau/gov/health/covidsafe/streetpass/Work;->getConnectable()Lau/gov/health/covidsafe/streetpass/ConnectablePeripheral;

    move-result-object p3

    invoke-virtual {p3}, Lau/gov/health/covidsafe/streetpass/ConnectablePeripheral;->getRssi()I

    move-result v8

    .line 558
    iget-object p3, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->work:Lau/gov/health/covidsafe/streetpass/Work;

    invoke-virtual {p3}, Lau/gov/health/covidsafe/streetpass/Work;->getConnectable()Lau/gov/health/covidsafe/streetpass/ConnectablePeripheral;

    move-result-object p3

    invoke-virtual {p3}, Lau/gov/health/covidsafe/streetpass/ConnectablePeripheral;->getTransmissionPower()Ljava/lang/Integer;

    move-result-object v9

    move-object v2, v10

    .line 551
    invoke-direct/range {v2 .. v9}, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;-><init>(ILjava/lang/String;Ljava/lang/String;Lau/gov/health/covidsafe/streetpass/PeripheralDevice;Lau/gov/health/covidsafe/streetpass/CentralDevice;ILjava/lang/Integer;)V

    .line 561
    sget-object p3, Lau/gov/health/covidsafe/Utils;->INSTANCE:Lau/gov/health/covidsafe/Utils;

    .line 562
    iget-object v2, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-virtual {v2}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->getContext()Landroid/content/Context;

    move-result-object v2

    .line 561
    invoke-virtual {p3, v2, v10}, Lau/gov/health/covidsafe/Utils;->broadcastStreetPassReceived(Landroid/content/Context;Lau/gov/health/covidsafe/streetpass/ConnectionRecord;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception p3

    .line 567
    sget-object v2, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 568
    iget-object v3, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-static {v3}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->access$getTAG$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Ljava/lang/String;

    move-result-object v3

    .line 569
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Failed to de-serialize request payload object - "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p3}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object p3

    invoke-virtual {v4, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p3

    .line 567
    invoke-virtual {v2, v3, p3}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 574
    :cond_1
    :goto_0
    iget-object p3, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->work:Lau/gov/health/covidsafe/streetpass/Work;

    invoke-virtual {p3}, Lau/gov/health/covidsafe/streetpass/Work;->getChecklist()Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;

    move-result-object p3

    invoke-virtual {p3}, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->getReadCharacteristic()Lau/gov/health/covidsafe/streetpass/Work$Check;

    move-result-object p3

    const/4 v2, 0x1

    invoke-virtual {p3, v2}, Lau/gov/health/covidsafe/streetpass/Work$Check;->setStatus(Z)V

    .line 575
    iget-object p3, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->work:Lau/gov/health/covidsafe/streetpass/Work;

    invoke-virtual {p3}, Lau/gov/health/covidsafe/streetpass/Work;->getChecklist()Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;

    move-result-object p3

    invoke-virtual {p3}, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->getReadCharacteristic()Lau/gov/health/covidsafe/streetpass/Work$Check;

    move-result-object p3

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-virtual {p3, v2, v3}, Lau/gov/health/covidsafe/streetpass/Work$Check;->setTimePerformed(J)V

    .line 587
    :goto_1
    sget-object p3, Lau/gov/health/covidsafe/Utils;->INSTANCE:Lau/gov/health/covidsafe/Utils;

    iget-object v2, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-virtual {v2}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {p3, v2}, Lau/gov/health/covidsafe/Utils;->bmValid(Landroid/content/Context;)Z

    move-result p3

    if-eqz p3, :cond_2

    .line 590
    sget-object p3, Lau/gov/health/covidsafe/TracerApp;->Companion:Lau/gov/health/covidsafe/TracerApp$Companion;

    invoke-virtual {p3}, Lau/gov/health/covidsafe/TracerApp$Companion;->asCentralDevice()Lau/gov/health/covidsafe/streetpass/CentralDevice;

    move-result-object p3

    .line 592
    new-instance v9, Lau/gov/health/covidsafe/bluetooth/gatt/WriteRequestPayload;

    const/4 v3, 0x1

    .line 594
    sget-object v2, Lau/gov/health/covidsafe/TracerApp;->Companion:Lau/gov/health/covidsafe/TracerApp$Companion;

    invoke-virtual {v2}, Lau/gov/health/covidsafe/TracerApp$Companion;->thisDeviceMsg()Ljava/lang/String;

    move-result-object v4

    .line 596
    invoke-virtual {p3}, Lau/gov/health/covidsafe/streetpass/CentralDevice;->getModelC()Ljava/lang/String;

    move-result-object v6

    .line 597
    iget-object p3, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->work:Lau/gov/health/covidsafe/streetpass/Work;

    invoke-virtual {p3}, Lau/gov/health/covidsafe/streetpass/Work;->getConnectable()Lau/gov/health/covidsafe/streetpass/ConnectablePeripheral;

    move-result-object p3

    invoke-virtual {p3}, Lau/gov/health/covidsafe/streetpass/ConnectablePeripheral;->getRssi()I

    move-result v7

    .line 598
    iget-object p3, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->work:Lau/gov/health/covidsafe/streetpass/Work;

    invoke-virtual {p3}, Lau/gov/health/covidsafe/streetpass/Work;->getConnectable()Lau/gov/health/covidsafe/streetpass/ConnectablePeripheral;

    move-result-object p3

    invoke-virtual {p3}, Lau/gov/health/covidsafe/streetpass/ConnectablePeripheral;->getTransmissionPower()Ljava/lang/Integer;

    move-result-object v8

    const-string v5, "AU_DTA"

    move-object v2, v9

    .line 592
    invoke-direct/range {v2 .. v8}, Lau/gov/health/covidsafe/bluetooth/gatt/WriteRequestPayload;-><init>(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;)V

    .line 601
    invoke-virtual {v9}, Lau/gov/health/covidsafe/bluetooth/gatt/WriteRequestPayload;->getPayload()[B

    move-result-object p3

    invoke-virtual {p2, p3}, Landroid/bluetooth/BluetoothGattCharacteristic;->setValue([B)Z

    .line 602
    invoke-virtual {p1, p2}, Landroid/bluetooth/BluetoothGatt;->writeCharacteristic(Landroid/bluetooth/BluetoothGattCharacteristic;)Z

    move-result p2

    .line 603
    sget-object p3, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 604
    iget-object v2, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-static {v2}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->access$getTAG$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Ljava/lang/String;

    move-result-object v2

    .line 605
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Attempt to write characteristic to our service on "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothGatt;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object p1

    invoke-static {p1, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    .line 603
    invoke-virtual {p3, v2, p1}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_2

    .line 608
    :cond_2
    sget-object p2, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 609
    iget-object p3, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-static {p3}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->access$getTAG$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Ljava/lang/String;

    move-result-object p3

    .line 610
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Expired BM. Skipping attempt to write characteristic to our service on "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothGatt;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v2

    invoke-static {v2, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v2}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 608
    invoke-virtual {p2, p3, v0}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 613
    invoke-direct {p0, p1}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->endWorkConnection(Landroid/bluetooth/BluetoothGatt;)V

    :goto_2
    return-void
.end method

.method public onCharacteristicWrite(Landroid/bluetooth/BluetoothGatt;Landroid/bluetooth/BluetoothGattCharacteristic;I)V
    .locals 3

    const-string v0, "gatt"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "characteristic"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    if-eqz p3, :cond_0

    .line 630
    sget-object p2, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-static {v0}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->access$getTAG$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Failed to write characteristics: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p3

    invoke-virtual {p2, v0, p3}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 625
    :cond_0
    sget-object p2, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object p3, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-static {p3}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->access$getTAG$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Ljava/lang/String;

    move-result-object p3

    const-string v0, "Characteristic wrote successfully"

    invoke-virtual {p2, p3, v0}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 626
    iget-object p2, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->work:Lau/gov/health/covidsafe/streetpass/Work;

    invoke-virtual {p2}, Lau/gov/health/covidsafe/streetpass/Work;->getChecklist()Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;

    move-result-object p2

    invoke-virtual {p2}, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->getWriteCharacteristic()Lau/gov/health/covidsafe/streetpass/Work$Check;

    move-result-object p2

    const/4 p3, 0x1

    invoke-virtual {p2, p3}, Lau/gov/health/covidsafe/streetpass/Work$Check;->setStatus(Z)V

    .line 627
    iget-object p2, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->work:Lau/gov/health/covidsafe/streetpass/Work;

    invoke-virtual {p2}, Lau/gov/health/covidsafe/streetpass/Work;->getChecklist()Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;

    move-result-object p2

    invoke-virtual {p2}, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->getWriteCharacteristic()Lau/gov/health/covidsafe/streetpass/Work$Check;

    move-result-object p2

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    invoke-virtual {p2, v0, v1}, Lau/gov/health/covidsafe/streetpass/Work$Check;->setTimePerformed(J)V

    .line 634
    :goto_0
    invoke-direct {p0, p1}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->endWorkConnection(Landroid/bluetooth/BluetoothGatt;)V

    return-void
.end method

.method public onConnectionStateChange(Landroid/bluetooth/BluetoothGatt;II)V
    .locals 4

    if-eqz p1, :cond_4

    const/4 p2, 0x1

    const-string v0, "gatt.device"

    if-eqz p3, :cond_1

    const/4 v1, 0x2

    if-eq p3, v1, :cond_0

    .line 441
    sget-object p2, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-static {v1}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->access$getTAG$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Connection status for "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothGatt;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v3

    invoke-static {v3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v3}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v0, ": "

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p3

    invoke-virtual {p2, v1, p3}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 442
    invoke-direct {p0, p1}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->endWorkConnection(Landroid/bluetooth/BluetoothGatt;)V

    goto/16 :goto_1

    .line 410
    :cond_0
    sget-object p3, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-static {v1}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->access$getTAG$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Connected to other GATT server - "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothGatt;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v3

    invoke-static {v3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v3}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p3, v1, v0}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    const/4 p3, 0x0

    .line 412
    invoke-virtual {p1, p3}, Landroid/bluetooth/BluetoothGatt;->requestConnectionPriority(I)Z

    const/16 p3, 0x200

    .line 413
    invoke-virtual {p1, p3}, Landroid/bluetooth/BluetoothGatt;->requestMtu(I)Z

    .line 415
    iget-object p1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->work:Lau/gov/health/covidsafe/streetpass/Work;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getChecklist()Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;

    move-result-object p1

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->getConnected()Lau/gov/health/covidsafe/streetpass/Work$Check;

    move-result-object p1

    invoke-virtual {p1, p2}, Lau/gov/health/covidsafe/streetpass/Work$Check;->setStatus(Z)V

    .line 416
    iget-object p1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->work:Lau/gov/health/covidsafe/streetpass/Work;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getChecklist()Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;

    move-result-object p1

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->getConnected()Lau/gov/health/covidsafe/streetpass/Work$Check;

    move-result-object p1

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide p2

    invoke-virtual {p1, p2, p3}, Lau/gov/health/covidsafe/streetpass/Work$Check;->setTimePerformed(J)V

    goto/16 :goto_1

    .line 421
    :cond_1
    sget-object p3, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 422
    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-static {v1}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->access$getTAG$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Ljava/lang/String;

    move-result-object v1

    .line 423
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Disconnected from other GATT server - "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothGatt;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v3

    invoke-static {v3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v3}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 421
    invoke-virtual {p3, v1, v0}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 425
    iget-object p3, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->work:Lau/gov/health/covidsafe/streetpass/Work;

    invoke-virtual {p3}, Lau/gov/health/covidsafe/streetpass/Work;->getChecklist()Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;

    move-result-object p3

    invoke-virtual {p3}, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->getDisconnected()Lau/gov/health/covidsafe/streetpass/Work$Check;

    move-result-object p3

    invoke-virtual {p3, p2}, Lau/gov/health/covidsafe/streetpass/Work$Check;->setStatus(Z)V

    .line 426
    iget-object p2, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->work:Lau/gov/health/covidsafe/streetpass/Work;

    invoke-virtual {p2}, Lau/gov/health/covidsafe/streetpass/Work;->getChecklist()Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;

    move-result-object p2

    invoke-virtual {p2}, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->getDisconnected()Lau/gov/health/covidsafe/streetpass/Work$Check;

    move-result-object p2

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    invoke-virtual {p2, v0, v1}, Lau/gov/health/covidsafe/streetpass/Work$Check;->setTimePerformed(J)V

    .line 429
    iget-object p2, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-static {p2}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->access$getTimeoutHandler$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Landroid/os/Handler;

    move-result-object p2

    iget-object p3, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->work:Lau/gov/health/covidsafe/streetpass/Work;

    invoke-virtual {p3}, Lau/gov/health/covidsafe/streetpass/Work;->getTimeoutRunnable()Ljava/lang/Runnable;

    move-result-object p3

    invoke-virtual {p2, p3}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 430
    sget-object p2, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object p3, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-static {p3}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->access$getTAG$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Ljava/lang/String;

    move-result-object p3

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Timeout removed for "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->work:Lau/gov/health/covidsafe/streetpass/Work;

    invoke-virtual {v1}, Lau/gov/health/covidsafe/streetpass/Work;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v1

    invoke-virtual {v1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, p3, v0}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 433
    iget-object p2, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->work:Lau/gov/health/covidsafe/streetpass/Work;

    invoke-virtual {p2}, Lau/gov/health/covidsafe/streetpass/Work;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object p2

    invoke-virtual {p2}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object p2

    iget-object p3, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-static {p3}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->access$getCurrentPendingConnection$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Lau/gov/health/covidsafe/streetpass/Work;

    move-result-object p3

    const/4 v0, 0x0

    if-eqz p3, :cond_2

    invoke-virtual {p3}, Lau/gov/health/covidsafe/streetpass/Work;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object p3

    if-eqz p3, :cond_2

    invoke-virtual {p3}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object p3

    goto :goto_0

    :cond_2
    move-object p3, v0

    :goto_0
    invoke-static {p2, p3}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p2

    if-eqz p2, :cond_3

    .line 434
    iget-object p2, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    check-cast v0, Lau/gov/health/covidsafe/streetpass/Work;

    invoke-static {p2, v0}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->access$setCurrentPendingConnection$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;Lau/gov/health/covidsafe/streetpass/Work;)V

    .line 436
    :cond_3
    invoke-virtual {p1}, Landroid/bluetooth/BluetoothGatt;->close()V

    .line 437
    iget-object p1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    iget-object p2, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->work:Lau/gov/health/covidsafe/streetpass/Work;

    invoke-virtual {p1, p2}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->finishWork(Lau/gov/health/covidsafe/streetpass/Work;)V

    :cond_4
    :goto_1
    return-void
.end method

.method public onMtuChanged(Landroid/bluetooth/BluetoothGatt;II)V
    .locals 5

    .line 450
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->work:Lau/gov/health/covidsafe/streetpass/Work;

    invoke-virtual {v0}, Lau/gov/health/covidsafe/streetpass/Work;->getChecklist()Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;

    move-result-object v0

    invoke-virtual {v0}, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->getMtuChanged()Lau/gov/health/covidsafe/streetpass/Work$Check;

    move-result-object v0

    invoke-virtual {v0}, Lau/gov/health/covidsafe/streetpass/Work$Check;->getStatus()Z

    move-result v0

    if-nez v0, :cond_2

    .line 452
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->work:Lau/gov/health/covidsafe/streetpass/Work;

    invoke-virtual {v0}, Lau/gov/health/covidsafe/streetpass/Work;->getChecklist()Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;

    move-result-object v0

    invoke-virtual {v0}, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->getMtuChanged()Lau/gov/health/covidsafe/streetpass/Work$Check;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lau/gov/health/covidsafe/streetpass/Work$Check;->setStatus(Z)V

    .line 453
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->work:Lau/gov/health/covidsafe/streetpass/Work;

    invoke-virtual {v0}, Lau/gov/health/covidsafe/streetpass/Work;->getChecklist()Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;

    move-result-object v0

    invoke-virtual {v0}, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->getMtuChanged()Lau/gov/health/covidsafe/streetpass/Work$Check;

    move-result-object v0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lau/gov/health/covidsafe/streetpass/Work$Check;->setTimePerformed(J)V

    .line 455
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 456
    iget-object v2, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-static {v2}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->access$getTAG$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Ljava/lang/String;

    move-result-object v2

    .line 457
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    if-eqz p1, :cond_0

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothGatt;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v4

    if-eqz v4, :cond_0

    invoke-virtual {v4}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v4

    goto :goto_0

    :cond_0
    const/4 v4, 0x0

    :goto_0
    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v4, " MTU is "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string p2, ". Was change successful? : "

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    if-nez p3, :cond_1

    goto :goto_1

    :cond_1
    const/4 v1, 0x0

    :goto_1
    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    .line 455
    invoke-virtual {v0, v2, p2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    if-eqz p1, :cond_2

    .line 461
    invoke-virtual {p1}, Landroid/bluetooth/BluetoothGatt;->discoverServices()Z

    move-result p2

    .line 462
    sget-object p3, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 463
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-static {v0}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->access$getTAG$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Ljava/lang/String;

    move-result-object v0

    .line 464
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Attempting to start service discovery on "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothGatt;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object p1

    const-string v2, "gatt.device"

    invoke-static {p1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p1, ": "

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    .line 462
    invoke-virtual {p3, v0, p1}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    :cond_2
    return-void
.end method

.method public onServicesDiscovered(Landroid/bluetooth/BluetoothGatt;I)V
    .locals 6

    const-string v0, "gatt"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "gatt.device"

    if-eqz p2, :cond_0

    .line 511
    sget-object p2, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-static {v1}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->access$getTAG$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "No services discovered on "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothGatt;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v3

    invoke-static {v3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v3}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v1, v0}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 512
    invoke-direct {p0, p1}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->endWorkConnection(Landroid/bluetooth/BluetoothGatt;)V

    goto/16 :goto_1

    .line 474
    :cond_0
    sget-object v1, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 475
    iget-object v2, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-static {v2}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->access$getTAG$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Ljava/lang/String;

    move-result-object v2

    .line 476
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "onServicesDiscovered received: BluetoothGatt.GATT_SUCCESS - "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    .line 474
    invoke-virtual {v1, v2, p2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 478
    sget-object p2, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 479
    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-static {v1}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->access$getTAG$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Ljava/lang/String;

    move-result-object v1

    .line 480
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Discovered "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothGatt;->getServices()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v3, " services on "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothGatt;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v3

    invoke-static {v3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v3}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 478
    invoke-virtual {p2, v1, v2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 483
    iget-object p2, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-static {p2}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->access$getServiceUUID$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Ljava/util/UUID;

    move-result-object p2

    invoke-virtual {p1, p2}, Landroid/bluetooth/BluetoothGatt;->getService(Ljava/util/UUID;)Landroid/bluetooth/BluetoothGattService;

    move-result-object p2

    if-eqz p2, :cond_2

    .line 486
    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-static {v1}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->access$getServiceUUID$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Ljava/util/UUID;

    move-result-object v1

    invoke-virtual {p2, v1}, Landroid/bluetooth/BluetoothGattService;->getCharacteristic(Ljava/util/UUID;)Landroid/bluetooth/BluetoothGattCharacteristic;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 488
    invoke-virtual {p1, v1}, Landroid/bluetooth/BluetoothGatt;->readCharacteristic(Landroid/bluetooth/BluetoothGattCharacteristic;)Z

    move-result v1

    .line 489
    sget-object v2, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 490
    iget-object v3, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-static {v3}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->access$getTAG$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Ljava/lang/String;

    move-result-object v3

    .line 491
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Attempt to read characteristic of our service on "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothGatt;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v5

    invoke-static {v5, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v5}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v5, ": "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 489
    invoke-virtual {v2, v3, v1}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 494
    :cond_1
    sget-object v1, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 495
    iget-object v2, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-static {v2}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->access$getTAG$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Ljava/lang/String;

    move-result-object v2

    .line 496
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothGatt;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v4

    invoke-static {v4, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v4}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v4, " does not have our characteristic"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 494
    invoke-virtual {v1, v2, v3}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 498
    invoke-direct {p0, p1}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->endWorkConnection(Landroid/bluetooth/BluetoothGatt;)V

    :cond_2
    :goto_0
    if-nez p2, :cond_3

    .line 503
    sget-object p2, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 504
    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-static {v1}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->access$getTAG$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Ljava/lang/String;

    move-result-object v1

    .line 505
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothGatt;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v3

    invoke-static {v3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v3}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v0, " does not have our service"

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 503
    invoke-virtual {p2, v1, v0}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 507
    invoke-direct {p0, p1}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;->endWorkConnection(Landroid/bluetooth/BluetoothGatt;)V

    :cond_3
    :goto_1
    return-void
.end method
