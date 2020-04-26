.class public final Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;
.super Ljava/lang/Object;
.source "BLEAdvertiser.kt"


# annotations
.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nBLEAdvertiser.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BLEAdvertiser.kt\nau/gov/health/covidsafe/bluetooth/BLEAdvertiser\n*L\n1#1,131:1\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\u0010\u0010&\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\u0008\u0010\'\u001a\u00020#H\u0002R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000c\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u000e\u0010\u000f\"\u0004\u0008\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u0014\u0010\u0016\"\u0004\u0008\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u001e\u0010\u0016\"\u0004\u0008\u001f\u0010\u0018R\u000e\u0010 \u001a\u00020!X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006("
    }
    d2 = {
        "Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;",
        "",
        "serviceUUID",
        "",
        "(Ljava/lang/String;)V",
        "TAG",
        "advertiser",
        "Landroid/bluetooth/le/BluetoothLeAdvertiser;",
        "callback",
        "Landroid/bluetooth/le/AdvertiseCallback;",
        "charLength",
        "",
        "data",
        "Landroid/bluetooth/le/AdvertiseData;",
        "getData",
        "()Landroid/bluetooth/le/AdvertiseData;",
        "setData",
        "(Landroid/bluetooth/le/AdvertiseData;)V",
        "handler",
        "Landroid/os/Handler;",
        "isAdvertising",
        "",
        "()Z",
        "setAdvertising",
        "(Z)V",
        "pUuid",
        "Landroid/os/ParcelUuid;",
        "settings",
        "Landroid/bluetooth/le/AdvertiseSettings;",
        "shouldBeAdvertising",
        "getShouldBeAdvertising",
        "setShouldBeAdvertising",
        "stopRunnable",
        "Ljava/lang/Runnable;",
        "startAdvertising",
        "",
        "timeoutInMillis",
        "",
        "startAdvertisingLegacy",
        "stopAdvertising",
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
.field private final TAG:Ljava/lang/String;

.field private advertiser:Landroid/bluetooth/le/BluetoothLeAdvertiser;

.field private callback:Landroid/bluetooth/le/AdvertiseCallback;

.field private charLength:I

.field private data:Landroid/bluetooth/le/AdvertiseData;

.field private handler:Landroid/os/Handler;

.field private isAdvertising:Z

.field private final pUuid:Landroid/os/ParcelUuid;

.field private final settings:Landroid/bluetooth/le/AdvertiseSettings;

.field private shouldBeAdvertising:Z

.field private stopRunnable:Ljava/lang/Runnable;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 2

    const-string v0, "serviceUUID"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    invoke-static {}, Landroid/bluetooth/BluetoothAdapter;->getDefaultAdapter()Landroid/bluetooth/BluetoothAdapter;

    move-result-object v0

    const-string v1, "BluetoothAdapter.getDefaultAdapter()"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothAdapter;->getBluetoothLeAdvertiser()Landroid/bluetooth/le/BluetoothLeAdvertiser;

    move-result-object v0

    iput-object v0, p0, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->advertiser:Landroid/bluetooth/le/BluetoothLeAdvertiser;

    const-string v0, "BLEAdvertiser"

    .line 18
    iput-object v0, p0, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->TAG:Ljava/lang/String;

    const/4 v0, 0x3

    .line 19
    iput v0, p0, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->charLength:I

    .line 20
    new-instance v1, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser$callback$1;

    invoke-direct {v1, p0}, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser$callback$1;-><init>(Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;)V

    check-cast v1, Landroid/bluetooth/le/AdvertiseCallback;

    iput-object v1, p0, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->callback:Landroid/bluetooth/le/AdvertiseCallback;

    .line 64
    new-instance v1, Landroid/os/ParcelUuid;

    invoke-static {p1}, Ljava/util/UUID;->fromString(Ljava/lang/String;)Ljava/util/UUID;

    move-result-object p1

    invoke-direct {v1, p1}, Landroid/os/ParcelUuid;-><init>(Ljava/util/UUID;)V

    iput-object v1, p0, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->pUuid:Landroid/os/ParcelUuid;

    .line 66
    new-instance p1, Landroid/bluetooth/le/AdvertiseSettings$Builder;

    invoke-direct {p1}, Landroid/bluetooth/le/AdvertiseSettings$Builder;-><init>()V

    .line 67
    invoke-virtual {p1, v0}, Landroid/bluetooth/le/AdvertiseSettings$Builder;->setTxPowerLevel(I)Landroid/bluetooth/le/AdvertiseSettings$Builder;

    move-result-object p1

    const/4 v0, 0x2

    .line 68
    invoke-virtual {p1, v0}, Landroid/bluetooth/le/AdvertiseSettings$Builder;->setAdvertiseMode(I)Landroid/bluetooth/le/AdvertiseSettings$Builder;

    move-result-object p1

    const/4 v0, 0x1

    .line 69
    invoke-virtual {p1, v0}, Landroid/bluetooth/le/AdvertiseSettings$Builder;->setConnectable(Z)Landroid/bluetooth/le/AdvertiseSettings$Builder;

    move-result-object p1

    const/4 v0, 0x0

    .line 70
    invoke-virtual {p1, v0}, Landroid/bluetooth/le/AdvertiseSettings$Builder;->setTimeout(I)Landroid/bluetooth/le/AdvertiseSettings$Builder;

    move-result-object p1

    .line 71
    invoke-virtual {p1}, Landroid/bluetooth/le/AdvertiseSettings$Builder;->build()Landroid/bluetooth/le/AdvertiseSettings;

    move-result-object p1

    iput-object p1, p0, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->settings:Landroid/bluetooth/le/AdvertiseSettings;

    .line 75
    new-instance p1, Landroid/os/Handler;

    invoke-direct {p1}, Landroid/os/Handler;-><init>()V

    iput-object p1, p0, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->handler:Landroid/os/Handler;

    .line 77
    new-instance p1, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser$stopRunnable$1;

    invoke-direct {p1, p0}, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser$stopRunnable$1;-><init>(Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;)V

    check-cast p1, Ljava/lang/Runnable;

    iput-object p1, p0, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->stopRunnable:Ljava/lang/Runnable;

    return-void
.end method

.method public static final synthetic access$getCharLength$p(Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;)I
    .locals 0

    .line 14
    iget p0, p0, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->charLength:I

    return p0
.end method

.method public static final synthetic access$getTAG$p(Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;)Ljava/lang/String;
    .locals 0

    .line 14
    iget-object p0, p0, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->TAG:Ljava/lang/String;

    return-object p0
.end method

.method public static final synthetic access$setCharLength$p(Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;I)V
    .locals 0

    .line 14
    iput p1, p0, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->charLength:I

    return-void
.end method

.method public static final synthetic access$stopAdvertising(Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;)V
    .locals 0

    .line 14
    invoke-direct {p0}, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->stopAdvertising()V

    return-void
.end method

.method private final startAdvertisingLegacy(J)V
    .locals 6

    .line 89
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "UUID.randomUUID().toString()"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 90
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    iget v2, p0, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->charLength:I

    sub-int/2addr v1, v2

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v2

    const-string v3, "null cannot be cast to non-null type java.lang.String"

    if-eqz v0, :cond_4

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    const-string v1, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 91
    sget-object v1, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v2, p0, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Unique string: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v2, v4}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 92
    sget-object v1, Lkotlin/text/Charsets;->UTF_8:Ljava/nio/charset/Charset;

    if-eqz v0, :cond_3

    invoke-virtual {v0, v1}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object v0

    const-string v1, "(this as java.lang.String).getBytes(charset)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 94
    iget-object v1, p0, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->data:Landroid/bluetooth/le/AdvertiseData;

    if-nez v1, :cond_0

    .line 95
    new-instance v1, Landroid/bluetooth/le/AdvertiseData$Builder;

    invoke-direct {v1}, Landroid/bluetooth/le/AdvertiseData$Builder;-><init>()V

    const/4 v2, 0x0

    .line 96
    invoke-virtual {v1, v2}, Landroid/bluetooth/le/AdvertiseData$Builder;->setIncludeDeviceName(Z)Landroid/bluetooth/le/AdvertiseData$Builder;

    move-result-object v1

    const/4 v2, 0x1

    .line 97
    invoke-virtual {v1, v2}, Landroid/bluetooth/le/AdvertiseData$Builder;->setIncludeTxPowerLevel(Z)Landroid/bluetooth/le/AdvertiseData$Builder;

    move-result-object v1

    .line 98
    iget-object v2, p0, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->pUuid:Landroid/os/ParcelUuid;

    invoke-virtual {v1, v2}, Landroid/bluetooth/le/AdvertiseData$Builder;->addServiceUuid(Landroid/os/ParcelUuid;)Landroid/bluetooth/le/AdvertiseData$Builder;

    move-result-object v1

    const/16 v2, 0x3ff

    .line 99
    invoke-virtual {v1, v2, v0}, Landroid/bluetooth/le/AdvertiseData$Builder;->addManufacturerData(I[B)Landroid/bluetooth/le/AdvertiseData$Builder;

    move-result-object v0

    .line 100
    invoke-virtual {v0}, Landroid/bluetooth/le/AdvertiseData$Builder;->build()Landroid/bluetooth/le/AdvertiseData;

    move-result-object v0

    iput-object v0, p0, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->data:Landroid/bluetooth/le/AdvertiseData;

    .line 104
    :cond_0
    :try_start_0
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v1, p0, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->TAG:Ljava/lang/String;

    const-string v2, "Start advertising"

    invoke-virtual {v0, v1, v2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 105
    iget-object v0, p0, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->advertiser:Landroid/bluetooth/le/BluetoothLeAdvertiser;

    if-eqz v0, :cond_1

    goto :goto_0

    :cond_1
    invoke-static {}, Landroid/bluetooth/BluetoothAdapter;->getDefaultAdapter()Landroid/bluetooth/BluetoothAdapter;

    move-result-object v0

    const-string v1, "BluetoothAdapter.getDefaultAdapter()"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothAdapter;->getBluetoothLeAdvertiser()Landroid/bluetooth/le/BluetoothLeAdvertiser;

    move-result-object v0

    :goto_0
    iput-object v0, p0, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->advertiser:Landroid/bluetooth/le/BluetoothLeAdvertiser;

    if-eqz v0, :cond_2

    .line 106
    iget-object v1, p0, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->settings:Landroid/bluetooth/le/AdvertiseSettings;

    iget-object v2, p0, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->data:Landroid/bluetooth/le/AdvertiseData;

    iget-object v3, p0, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->callback:Landroid/bluetooth/le/AdvertiseCallback;

    invoke-virtual {v0, v1, v2, v3}, Landroid/bluetooth/le/BluetoothLeAdvertiser;->startAdvertising(Landroid/bluetooth/le/AdvertiseSettings;Landroid/bluetooth/le/AdvertiseData;Landroid/bluetooth/le/AdvertiseCallback;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_1

    :catchall_0
    move-exception v0

    .line 108
    sget-object v1, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v2, p0, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Failed to start advertising legacy: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v2, v0}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 111
    :cond_2
    :goto_1
    iget-object v0, p0, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->handler:Landroid/os/Handler;

    iget-object v1, p0, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->stopRunnable:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    .line 112
    iget-object v0, p0, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->handler:Landroid/os/Handler;

    iget-object v1, p0, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->stopRunnable:Ljava/lang/Runnable;

    invoke-virtual {v0, v1, p1, p2}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    return-void

    .line 92
    :cond_3
    new-instance p1, Lkotlin/TypeCastException;

    invoke-direct {p1, v3}, Lkotlin/TypeCastException;-><init>(Ljava/lang/String;)V

    throw p1

    .line 90
    :cond_4
    new-instance p1, Lkotlin/TypeCastException;

    invoke-direct {p1, v3}, Lkotlin/TypeCastException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private final stopAdvertising()V
    .locals 5

    .line 122
    :try_start_0
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v1, p0, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->TAG:Ljava/lang/String;

    const-string v2, "stop advertising"

    invoke-virtual {v0, v1, v2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 123
    iget-object v0, p0, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->advertiser:Landroid/bluetooth/le/BluetoothLeAdvertiser;

    if-eqz v0, :cond_0

    iget-object v1, p0, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->callback:Landroid/bluetooth/le/AdvertiseCallback;

    invoke-virtual {v0, v1}, Landroid/bluetooth/le/BluetoothLeAdvertiser;->stopAdvertising(Landroid/bluetooth/le/AdvertiseCallback;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    .line 125
    sget-object v1, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v2, p0, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Failed to stop advertising: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v2, v0}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->e(Ljava/lang/String;Ljava/lang/String;)V

    :cond_0
    :goto_0
    const/4 v0, 0x0

    .line 127
    iput-boolean v0, p0, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->shouldBeAdvertising:Z

    .line 128
    iget-object v0, p0, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->handler:Landroid/os/Handler;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    return-void
.end method


# virtual methods
.method public final getData()Landroid/bluetooth/le/AdvertiseData;
    .locals 1

    .line 73
    iget-object v0, p0, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->data:Landroid/bluetooth/le/AdvertiseData;

    return-object v0
.end method

.method public final getShouldBeAdvertising()Z
    .locals 1

    .line 83
    iget-boolean v0, p0, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->shouldBeAdvertising:Z

    return v0
.end method

.method public final isAdvertising()Z
    .locals 1

    .line 82
    iget-boolean v0, p0, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->isAdvertising:Z

    return v0
.end method

.method public final setAdvertising(Z)V
    .locals 0

    .line 82
    iput-boolean p1, p0, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->isAdvertising:Z

    return-void
.end method

.method public final setData(Landroid/bluetooth/le/AdvertiseData;)V
    .locals 0

    .line 73
    iput-object p1, p0, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->data:Landroid/bluetooth/le/AdvertiseData;

    return-void
.end method

.method public final setShouldBeAdvertising(Z)V
    .locals 0

    .line 83
    iput-boolean p1, p0, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->shouldBeAdvertising:Z

    return-void
.end method

.method public final startAdvertising(J)V
    .locals 0

    .line 116
    invoke-direct {p0, p1, p2}, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->startAdvertisingLegacy(J)V

    const/4 p1, 0x1

    .line 117
    iput-boolean p1, p0, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->shouldBeAdvertising:Z

    return-void
.end method
