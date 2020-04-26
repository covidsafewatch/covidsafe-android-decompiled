.class public final Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;
.super Landroid/bluetooth/BluetoothGattServerCallback;
.source "GattServer.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;-><init>(Landroid/content/Context;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = null
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nGattServer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GattServer.kt\nau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,291:1\n352#2,7:292\n*E\n*S KotlinDebug\n*F\n+ 1 GattServer.kt\nau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1\n*L\n67#1,7:292\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\t*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J,\u0010\n\u001a\u00020\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016JD\u0010\u0013\u001a\u00020\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0016J\"\u0010\u0018\u001a\u00020\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000fH\u0016J \u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u0015H\u0016J\u000e\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\rR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u001d\u0010\u0008\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0007\u00a8\u0006\u001e"
    }
    d2 = {
        "au/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1",
        "Landroid/bluetooth/BluetoothGattServerCallback;",
        "readPayloadMap",
        "",
        "",
        "",
        "getReadPayloadMap",
        "()Ljava/util/Map;",
        "writeDataPayload",
        "getWriteDataPayload",
        "onCharacteristicReadRequest",
        "",
        "device",
        "Landroid/bluetooth/BluetoothDevice;",
        "requestId",
        "",
        "offset",
        "characteristic",
        "Landroid/bluetooth/BluetoothGattCharacteristic;",
        "onCharacteristicWriteRequest",
        "preparedWrite",
        "",
        "responseNeeded",
        "value",
        "onConnectionStateChange",
        "status",
        "newState",
        "onExecuteWrite",
        "execute",
        "saveDataSaved",
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
.field private final readPayloadMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "[B>;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;

.field private final writeDataPayload:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "[B>;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .line 28
    iput-object p1, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->this$0:Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;

    invoke-direct {p0}, Landroid/bluetooth/BluetoothGattServerCallback;-><init>()V

    .line 32
    new-instance p1, Ljava/util/HashMap;

    invoke-direct {p1}, Ljava/util/HashMap;-><init>()V

    check-cast p1, Ljava/util/Map;

    iput-object p1, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->writeDataPayload:Ljava/util/Map;

    .line 33
    new-instance p1, Ljava/util/HashMap;

    invoke-direct {p1}, Ljava/util/HashMap;-><init>()V

    check-cast p1, Ljava/util/Map;

    iput-object p1, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->readPayloadMap:Ljava/util/Map;

    return-void
.end method


# virtual methods
.method public final getReadPayloadMap()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "[B>;"
        }
    .end annotation

    .line 33
    iget-object v0, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->readPayloadMap:Ljava/util/Map;

    return-object v0
.end method

.method public final getWriteDataPayload()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "[B>;"
        }
    .end annotation

    .line 32
    iget-object v0, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->writeDataPayload:Ljava/util/Map;

    return-object v0
.end method

.method public onCharacteristicReadRequest(Landroid/bluetooth/BluetoothDevice;IILandroid/bluetooth/BluetoothGattCharacteristic;)V
    .locals 11

    if-eqz p1, :cond_4

    .line 69
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v1, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->this$0:Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;

    invoke-static {v1}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->access$getTAG$p(Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;)Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "onCharacteristicReadRequest from "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 71
    iget-object v0, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->this$0:Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;

    invoke-static {v0}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->access$getServiceUUID$p(Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;)Ljava/util/UUID;

    move-result-object v0

    if-eqz p4, :cond_0

    invoke-virtual {p4}, Landroid/bluetooth/BluetoothGattCharacteristic;->getUuid()Ljava/util/UUID;

    move-result-object p4

    goto :goto_0

    :cond_0
    const/4 p4, 0x0

    :goto_0
    invoke-static {v0, p4}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p4

    if-eqz p4, :cond_3

    .line 73
    sget-object p4, Lau/gov/health/covidsafe/Utils;->INSTANCE:Lau/gov/health/covidsafe/Utils;

    iget-object v0, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->this$0:Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;

    invoke-virtual {v0}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {p4, v0}, Lau/gov/health/covidsafe/Utils;->bmValid(Landroid/content/Context;)Z

    move-result p4

    const-string v0, "- "

    const-string v1, " - "

    if-eqz p4, :cond_2

    .line 74
    iget-object p4, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->readPayloadMap:Ljava/util/Map;

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v2

    const-string v4, "device.address"

    invoke-static {v2, v4}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 292
    invoke-interface {p4, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    if-nez v4, :cond_1

    .line 75
    new-instance v4, Lau/gov/health/covidsafe/bluetooth/gatt/ReadRequestPayload;

    const/4 v5, 0x1

    .line 77
    sget-object v6, Lau/gov/health/covidsafe/TracerApp;->Companion:Lau/gov/health/covidsafe/TracerApp$Companion;

    invoke-virtual {v6}, Lau/gov/health/covidsafe/TracerApp$Companion;->thisDeviceMsg()Ljava/lang/String;

    move-result-object v6

    .line 79
    sget-object v7, Lau/gov/health/covidsafe/TracerApp;->Companion:Lau/gov/health/covidsafe/TracerApp$Companion;

    invoke-virtual {v7}, Lau/gov/health/covidsafe/TracerApp$Companion;->asPeripheralDevice()Lau/gov/health/covidsafe/streetpass/PeripheralDevice;

    move-result-object v7

    const-string v8, "AU_DTA"

    .line 75
    invoke-direct {v4, v5, v6, v8, v7}, Lau/gov/health/covidsafe/bluetooth/gatt/ReadRequestPayload;-><init>(ILjava/lang/String;Ljava/lang/String;Lau/gov/health/covidsafe/streetpass/PeripheralDevice;)V

    .line 80
    invoke-virtual {v4}, Lau/gov/health/covidsafe/bluetooth/gatt/ReadRequestPayload;->getPayload()[B

    move-result-object v4

    .line 295
    invoke-interface {p4, v2, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 74
    :cond_1
    check-cast v4, [B

    .line 83
    array-length p4, v4

    invoke-static {v4, p3, p4}, Lkotlin/collections/ArraysKt;->copyOfRange([BII)[B

    move-result-object v10

    .line 85
    sget-object p4, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 86
    iget-object v2, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->this$0:Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;

    invoke-static {v2}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->access$getTAG$p(Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;)Ljava/lang/String;

    move-result-object v2

    .line 87
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 89
    sget-object p3, Lkotlin/text/Charsets;->UTF_8:Ljava/nio/charset/Charset;

    .line 87
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0, v10, p3}, Ljava/lang/String;-><init>([BLjava/nio/charset/Charset;)V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p3

    .line 85
    invoke-virtual {p4, v2, p3}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 93
    iget-object p3, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->this$0:Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;

    invoke-virtual {p3}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->getBluetoothGattServer()Landroid/bluetooth/BluetoothGattServer;

    move-result-object v5

    if-eqz v5, :cond_4

    const/4 v8, 0x0

    const/4 v9, 0x0

    move-object v6, p1

    move v7, p2

    invoke-virtual/range {v5 .. v10}, Landroid/bluetooth/BluetoothGattServer;->sendResponse(Landroid/bluetooth/BluetoothDevice;III[B)Z

    goto/16 :goto_1

    .line 95
    :cond_2
    sget-object p4, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 96
    iget-object v2, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->this$0:Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;

    invoke-static {v2}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->access$getTAG$p(Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;)Ljava/lang/String;

    move-result-object v2

    .line 97
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string p3, " - BM Expired"

    invoke-virtual {v4, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p3

    .line 95
    invoke-virtual {p4, v2, p3}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 99
    iget-object p3, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->this$0:Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;

    invoke-virtual {p3}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->getBluetoothGattServer()Landroid/bluetooth/BluetoothGattServer;

    move-result-object v0

    if-eqz v0, :cond_4

    const/16 v3, 0x101

    const/4 v4, 0x0

    const/4 p3, 0x0

    new-array v5, p3, [B

    move-object v1, p1

    move v2, p2

    invoke-virtual/range {v0 .. v5}, Landroid/bluetooth/BluetoothGattServer;->sendResponse(Landroid/bluetooth/BluetoothDevice;III[B)Z

    goto :goto_1

    .line 108
    :cond_3
    sget-object p3, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object p4, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->this$0:Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;

    invoke-static {p4}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->access$getTAG$p(Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;)Ljava/lang/String;

    move-result-object p4

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "incorrect serviceUUID from "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p3, p4, v0}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 109
    iget-object p3, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->this$0:Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;

    invoke-virtual {p3}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->getBluetoothGattServer()Landroid/bluetooth/BluetoothGattServer;

    move-result-object v0

    if-eqz v0, :cond_4

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    move-object v1, p1

    move v2, p2

    invoke-virtual/range {v0 .. v5}, Landroid/bluetooth/BluetoothGattServer;->sendResponse(Landroid/bluetooth/BluetoothDevice;III[B)Z

    :cond_4
    :goto_1
    if-nez p1, :cond_5

    .line 114
    sget-object p1, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object p2, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->this$0:Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;

    invoke-static {p2}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->access$getTAG$p(Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;)Ljava/lang/String;

    move-result-object p2

    const-string p3, "No device"

    invoke-virtual {p1, p2, p3}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    :cond_5
    return-void
.end method

.method public onCharacteristicWriteRequest(Landroid/bluetooth/BluetoothDevice;ILandroid/bluetooth/BluetoothGattCharacteristic;ZZI[B)V
    .locals 13

    move-object v0, p0

    move/from16 v7, p4

    move-object/from16 v6, p7

    const-string v1, "characteristic"

    move-object/from16 v2, p3

    invoke-static {v2, v1}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    if-eqz p1, :cond_4

    .line 132
    sget-object v1, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 133
    iget-object v3, v0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->this$0:Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;

    invoke-static {v3}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->access$getTAG$p(Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;)Ljava/lang/String;

    move-result-object v3

    .line 134
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "onCharacteristicWriteRequest - "

    invoke-virtual {v4, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v9, " - preparedWrite: "

    invoke-virtual {v4, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, v7}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 132
    invoke-virtual {v1, v3, v4}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 137
    sget-object v1, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 138
    iget-object v3, v0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->this$0:Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;

    invoke-static {v3}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->access$getTAG$p(Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;)Ljava/lang/String;

    move-result-object v3

    .line 139
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "onCharacteristicWriteRequest from "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v4, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v10, " - "

    invoke-virtual {v4, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move v11, p2

    invoke-virtual {v4, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v4, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move/from16 v12, p6

    invoke-virtual {v4, v12}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 137
    invoke-virtual {v1, v3, v4}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 142
    iget-object v1, v0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->this$0:Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;

    invoke-static {v1}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->access$getServiceUUID$p(Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;)Ljava/util/UUID;

    move-result-object v1

    invoke-virtual/range {p3 .. p3}, Landroid/bluetooth/BluetoothGattCharacteristic;->getUuid()Ljava/util/UUID;

    move-result-object v2

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    if-eqz v6, :cond_0

    .line 145
    sget-object v1, Lkotlin/text/Charsets;->UTF_8:Ljava/nio/charset/Charset;

    new-instance v2, Ljava/lang/String;

    invoke-direct {v2, v6, v1}, Ljava/lang/String;-><init>([BLjava/nio/charset/Charset;)V

    goto :goto_0

    :cond_0
    const-string v2, ""

    .line 147
    :goto_0
    sget-object v1, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 148
    iget-object v3, v0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->this$0:Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;

    invoke-static {v3}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->access$getTAG$p(Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;)Ljava/lang/String;

    move-result-object v3

    .line 149
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 147
    invoke-virtual {v1, v3, v2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    if-eqz v6, :cond_3

    .line 152
    iget-object v1, v0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->writeDataPayload:Ljava/util/Map;

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [B

    if-nez v1, :cond_1

    const/4 v1, 0x0

    new-array v1, v1, [B

    .line 158
    :cond_1
    invoke-static {v1, v6}, Lkotlin/collections/ArraysKt;->plus([B[B)[B

    move-result-object v1

    .line 159
    iget-object v2, v0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->writeDataPayload:Ljava/util/Map;

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v3

    const-string v4, "device.address"

    invoke-static {v3, v4}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-interface {v2, v3, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 161
    sget-object v2, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 162
    iget-object v3, v0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->this$0:Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;

    invoke-static {v3}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->access$getTAG$p(Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;)Ljava/lang/String;

    move-result-object v3

    .line 163
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Accumulated characteristic: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 165
    sget-object v5, Lkotlin/text/Charsets;->UTF_8:Ljava/nio/charset/Charset;

    .line 163
    new-instance v10, Ljava/lang/String;

    invoke-direct {v10, v1, v5}, Ljava/lang/String;-><init>([BLjava/nio/charset/Charset;)V

    invoke-virtual {v4, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 161
    invoke-virtual {v2, v3, v4}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    if-eqz p5, :cond_3

    .line 170
    sget-object v2, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v3, v0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->this$0:Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;

    invoke-static {v3}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->access$getTAG$p(Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;)Ljava/lang/String;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Sending response offset: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    array-length v5, v1

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 171
    iget-object v2, v0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->this$0:Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;

    invoke-virtual {v2}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->getBluetoothGattServer()Landroid/bluetooth/BluetoothGattServer;

    move-result-object v2

    if-eqz v2, :cond_3

    const/4 v4, 0x0

    .line 175
    array-length v5, v1

    move-object v1, v2

    move-object v2, p1

    move v3, p2

    move-object/from16 v6, p7

    .line 171
    invoke-virtual/range {v1 .. v6}, Landroid/bluetooth/BluetoothGattServer;->sendResponse(Landroid/bluetooth/BluetoothDevice;III[B)Z

    goto :goto_1

    .line 181
    :cond_2
    sget-object v1, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v2, v0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->this$0:Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;

    invoke-static {v2}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->access$getTAG$p(Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "no data from "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 182
    iget-object v1, v0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->this$0:Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;

    invoke-virtual {v1}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->getBluetoothGattServer()Landroid/bluetooth/BluetoothGattServer;

    move-result-object v1

    if-eqz v1, :cond_3

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    move-object v2, p1

    move v3, p2

    invoke-virtual/range {v1 .. v6}, Landroid/bluetooth/BluetoothGattServer;->sendResponse(Landroid/bluetooth/BluetoothDevice;III[B)Z

    :cond_3
    :goto_1
    if-nez v7, :cond_4

    .line 187
    sget-object v1, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 188
    iget-object v2, v0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->this$0:Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;

    invoke-static {v2}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->access$getTAG$p(Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;)Ljava/lang/String;

    move-result-object v2

    .line 189
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v7}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 187
    invoke-virtual {v1, v2, v3}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 192
    invoke-virtual {p0, p1}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->saveDataSaved(Landroid/bluetooth/BluetoothDevice;)V

    .line 193
    iget-object v1, v0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->this$0:Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;

    invoke-virtual {v1}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->getBluetoothGattServer()Landroid/bluetooth/BluetoothGattServer;

    move-result-object v1

    if-eqz v1, :cond_4

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    move-object v2, p1

    move v3, p2

    invoke-virtual/range {v1 .. v6}, Landroid/bluetooth/BluetoothGattServer;->sendResponse(Landroid/bluetooth/BluetoothDevice;III[B)Z

    :cond_4
    if-nez p1, :cond_5

    .line 198
    sget-object v1, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v2, v0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->this$0:Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;

    invoke-static {v2}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->access$getTAG$p(Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "Write stopped - no device"

    invoke-virtual {v1, v2, v3}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->e(Ljava/lang/String;Ljava/lang/String;)V

    :cond_5
    return-void
.end method

.method public onConnectionStateChange(Landroid/bluetooth/BluetoothDevice;II)V
    .locals 4

    const/4 p2, 0x0

    if-eqz p3, :cond_3

    const/4 v0, 0x2

    if-eq p3, v0, :cond_1

    .line 54
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v1, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->this$0:Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;

    invoke-static {v1}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->access$getTAG$p(Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;)Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Connection status: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string p3, " - "

    invoke-virtual {v2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    if-eqz p1, :cond_0

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object p2

    :cond_0
    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v0, v1, p1}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 38
    :cond_1
    sget-object p3, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v0, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->this$0:Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;

    invoke-static {v0}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->access$getTAG$p(Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;)Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    if-eqz p1, :cond_2

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object p2

    :cond_2
    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p2, " Connected to local GATT server"

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-virtual {p3, v0, p2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    if-eqz p1, :cond_5

    .line 40
    iget-object p2, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->this$0:Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;

    invoke-static {p2}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->access$getBluetoothManager$p(Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;)Landroid/bluetooth/BluetoothManager;

    move-result-object p2

    const/4 p3, 0x7

    invoke-virtual {p2, p3}, Landroid/bluetooth/BluetoothManager;->getConnectedDevices(I)Ljava/util/List;

    move-result-object p2

    .line 41
    invoke-interface {p2, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    goto :goto_0

    .line 46
    :cond_3
    sget-object p3, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v0, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->this$0:Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;

    invoke-static {v0}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->access$getTAG$p(Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;)Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    if-eqz p1, :cond_4

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object p2

    :cond_4
    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p2, " Disconnected from local GATT server."

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-virtual {p3, v0, p2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    if-eqz p1, :cond_5

    .line 48
    sget-object p2, Lau/gov/health/covidsafe/Utils;->INSTANCE:Lau/gov/health/covidsafe/Utils;

    iget-object p3, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->this$0:Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;

    invoke-virtual {p3}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->getContext()Landroid/content/Context;

    move-result-object p3

    invoke-virtual {p2, p3, p1}, Lau/gov/health/covidsafe/Utils;->broadcastDeviceDisconnected(Landroid/content/Context;Landroid/bluetooth/BluetoothDevice;)V

    :cond_5
    :goto_0
    return-void
.end method

.method public onExecuteWrite(Landroid/bluetooth/BluetoothDevice;IZ)V
    .locals 6

    const-string v0, "device"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 203
    invoke-super {p0, p1, p2, p3}, Landroid/bluetooth/BluetoothGattServerCallback;->onExecuteWrite(Landroid/bluetooth/BluetoothDevice;IZ)V

    .line 204
    iget-object p3, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->writeDataPayload:Ljava/util/Map;

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v0

    invoke-interface {p3, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p3

    check-cast p3, [B

    if-eqz p3, :cond_0

    .line 209
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 210
    iget-object v1, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->this$0:Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;

    invoke-static {v1}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->access$getTAG$p(Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;)Ljava/lang/String;

    move-result-object v1

    .line 211
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "onExecuteWrite - "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v3, "- "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v3, " - "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 213
    sget-object v3, Lkotlin/text/Charsets;->UTF_8:Ljava/nio/charset/Charset;

    .line 211
    new-instance v4, Ljava/lang/String;

    invoke-direct {v4, p3, v3}, Ljava/lang/String;-><init>([BLjava/nio/charset/Charset;)V

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p3

    .line 209
    invoke-virtual {v0, v1, p3}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 216
    invoke-virtual {p0, p1}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->saveDataSaved(Landroid/bluetooth/BluetoothDevice;)V

    .line 217
    iget-object p3, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->this$0:Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;

    invoke-virtual {p3}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->getBluetoothGattServer()Landroid/bluetooth/BluetoothGattServer;

    move-result-object v0

    if-eqz v0, :cond_1

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    move-object v1, p1

    move v2, p2

    invoke-virtual/range {v0 .. v5}, Landroid/bluetooth/BluetoothGattServer;->sendResponse(Landroid/bluetooth/BluetoothDevice;III[B)Z

    goto :goto_0

    .line 220
    :cond_0
    iget-object p3, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->this$0:Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;

    invoke-virtual {p3}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->getBluetoothGattServer()Landroid/bluetooth/BluetoothGattServer;

    move-result-object v0

    if-eqz v0, :cond_1

    const/16 v3, 0x101

    const/4 v4, 0x0

    const/4 v5, 0x0

    move-object v1, p1

    move v2, p2

    invoke-virtual/range {v0 .. v5}, Landroid/bluetooth/BluetoothGattServer;->sendResponse(Landroid/bluetooth/BluetoothDevice;III[B)Z

    :cond_1
    :goto_0
    return-void
.end method

.method public final saveDataSaved(Landroid/bluetooth/BluetoothDevice;)V
    .locals 10

    const-string v0, "device"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 226
    iget-object v0, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->writeDataPayload:Ljava/util/Map;

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [B

    if-eqz v0, :cond_0

    .line 230
    :try_start_0
    sget-object v1, Lau/gov/health/covidsafe/bluetooth/gatt/WriteRequestPayload;->Companion:Lau/gov/health/covidsafe/bluetooth/gatt/WriteRequestPayload$Companion;

    invoke-virtual {v1, v0}, Lau/gov/health/covidsafe/bluetooth/gatt/WriteRequestPayload$Companion;->createReadRequestPayload([B)Lau/gov/health/covidsafe/bluetooth/gatt/WriteRequestPayload;

    move-result-object v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 235
    :try_start_1
    new-instance v6, Lau/gov/health/covidsafe/streetpass/CentralDevice;

    invoke-virtual {v0}, Lau/gov/health/covidsafe/bluetooth/gatt/WriteRequestPayload;->getModelC()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v6, v1, v2}, Lau/gov/health/covidsafe/streetpass/CentralDevice;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 236
    new-instance v9, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;

    .line 237
    invoke-virtual {v0}, Lau/gov/health/covidsafe/bluetooth/gatt/WriteRequestPayload;->getV()I

    move-result v2

    .line 238
    invoke-virtual {v0}, Lau/gov/health/covidsafe/bluetooth/gatt/WriteRequestPayload;->getMsg()Ljava/lang/String;

    move-result-object v3

    .line 239
    invoke-virtual {v0}, Lau/gov/health/covidsafe/bluetooth/gatt/WriteRequestPayload;->getOrg()Ljava/lang/String;

    move-result-object v4

    .line 240
    sget-object v1, Lau/gov/health/covidsafe/TracerApp;->Companion:Lau/gov/health/covidsafe/TracerApp$Companion;

    invoke-virtual {v1}, Lau/gov/health/covidsafe/TracerApp$Companion;->asPeripheralDevice()Lau/gov/health/covidsafe/streetpass/PeripheralDevice;

    move-result-object v5

    .line 242
    invoke-virtual {v0}, Lau/gov/health/covidsafe/bluetooth/gatt/WriteRequestPayload;->getRssi()I

    move-result v7

    .line 243
    invoke-virtual {v0}, Lau/gov/health/covidsafe/bluetooth/gatt/WriteRequestPayload;->getTxPower()Ljava/lang/Integer;

    move-result-object v8

    move-object v1, v9

    .line 236
    invoke-direct/range {v1 .. v8}, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;-><init>(ILjava/lang/String;Ljava/lang/String;Lau/gov/health/covidsafe/streetpass/PeripheralDevice;Lau/gov/health/covidsafe/streetpass/CentralDevice;ILjava/lang/Integer;)V

    .line 246
    sget-object v0, Lau/gov/health/covidsafe/Utils;->INSTANCE:Lau/gov/health/covidsafe/Utils;

    .line 247
    iget-object v1, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->this$0:Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;

    invoke-virtual {v1}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->getContext()Landroid/content/Context;

    move-result-object v1

    .line 246
    invoke-virtual {v0, v1, v9}, Lau/gov/health/covidsafe/Utils;->broadcastStreetPassReceived(Landroid/content/Context;Lau/gov/health/covidsafe/streetpass/ConnectionRecord;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    .line 251
    :try_start_2
    sget-object v1, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v2, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->this$0:Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;

    invoke-static {v2}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->access$getTAG$p(Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "caught error here "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v2, v0}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    goto :goto_0

    :catchall_1
    move-exception v0

    .line 255
    sget-object v1, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v2, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->this$0:Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;

    invoke-static {v2}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->access$getTAG$p(Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Failed to save write payload - "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v2, v0}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 258
    :goto_0
    sget-object v0, Lau/gov/health/covidsafe/Utils;->INSTANCE:Lau/gov/health/covidsafe/Utils;

    iget-object v1, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->this$0:Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;

    invoke-virtual {v1}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v2

    const-string v3, "device.address"

    invoke-static {v2, v3}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v0, v1, v2}, Lau/gov/health/covidsafe/Utils;->broadcastDeviceProcessed(Landroid/content/Context;Ljava/lang/String;)V

    .line 259
    iget-object v0, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->writeDataPayload:Ljava/util/Map;

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 260
    iget-object v0, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;->readPayloadMap:Ljava/util/Map;

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object p1

    invoke-interface {v0, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, [B

    :cond_0
    return-void
.end method
