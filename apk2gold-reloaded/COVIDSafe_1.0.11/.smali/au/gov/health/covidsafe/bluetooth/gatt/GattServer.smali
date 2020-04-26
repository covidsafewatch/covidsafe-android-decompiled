.class public final Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;
.super Ljava/lang/Object;
.source "GattServer.kt"


# annotations
.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nGattServer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GattServer.kt\nau/gov/health/covidsafe/bluetooth/gatt/GattServer\n*L\n1#1,291:1\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000K\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002*\u0001\u001a\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&J\u0006\u0010\'\u001a\u00020(J\u0006\u0010)\u001a\u00020$R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\rR+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f8B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\u0008\u0015\u0010\u0016\u001a\u0004\u0008\u0011\u0010\u0012\"\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001bR+\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u000e\u001a\u00020\u001c8B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\u0008\"\u0010\u0016\u001a\u0004\u0008\u001e\u0010\u001f\"\u0004\u0008 \u0010!\u00a8\u0006*"
    }
    d2 = {
        "Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;",
        "",
        "context",
        "Landroid/content/Context;",
        "serviceUUIDString",
        "",
        "(Landroid/content/Context;Ljava/lang/String;)V",
        "TAG",
        "bluetoothGattServer",
        "Landroid/bluetooth/BluetoothGattServer;",
        "getBluetoothGattServer",
        "()Landroid/bluetooth/BluetoothGattServer;",
        "setBluetoothGattServer",
        "(Landroid/bluetooth/BluetoothGattServer;)V",
        "<set-?>",
        "Landroid/bluetooth/BluetoothManager;",
        "bluetoothManager",
        "getBluetoothManager",
        "()Landroid/bluetooth/BluetoothManager;",
        "setBluetoothManager",
        "(Landroid/bluetooth/BluetoothManager;)V",
        "bluetoothManager$delegate",
        "Lkotlin/properties/ReadWriteProperty;",
        "getContext",
        "()Landroid/content/Context;",
        "gattServerCallback",
        "au/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1",
        "Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;",
        "Ljava/util/UUID;",
        "serviceUUID",
        "getServiceUUID",
        "()Ljava/util/UUID;",
        "setServiceUUID",
        "(Ljava/util/UUID;)V",
        "serviceUUID$delegate",
        "addService",
        "",
        "service",
        "Lau/gov/health/covidsafe/bluetooth/gatt/GattService;",
        "startServer",
        "",
        "stop",
        "app_release"
    }
    k = 0x1
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# static fields
.field static final synthetic $$delegatedProperties:[Lkotlin/reflect/KProperty;


# instance fields
.field private final TAG:Ljava/lang/String;

.field private bluetoothGattServer:Landroid/bluetooth/BluetoothGattServer;

.field private final bluetoothManager$delegate:Lkotlin/properties/ReadWriteProperty;

.field private final context:Landroid/content/Context;

.field private final gattServerCallback:Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;

.field private final serviceUUID$delegate:Lkotlin/properties/ReadWriteProperty;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    const-class v0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;

    const/4 v1, 0x2

    new-array v1, v1, [Lkotlin/reflect/KProperty;

    new-instance v2, Lkotlin/jvm/internal/MutablePropertyReference1Impl;

    invoke-static {v0}, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;

    move-result-object v3

    const-string v4, "bluetoothManager"

    const-string v5, "getBluetoothManager()Landroid/bluetooth/BluetoothManager;"

    invoke-direct {v2, v3, v4, v5}, Lkotlin/jvm/internal/MutablePropertyReference1Impl;-><init>(Lkotlin/reflect/KDeclarationContainer;Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {v2}, Lkotlin/jvm/internal/Reflection;->mutableProperty1(Lkotlin/jvm/internal/MutablePropertyReference1;)Lkotlin/reflect/KMutableProperty1;

    move-result-object v2

    check-cast v2, Lkotlin/reflect/KProperty;

    const/4 v3, 0x0

    aput-object v2, v1, v3

    new-instance v2, Lkotlin/jvm/internal/MutablePropertyReference1Impl;

    invoke-static {v0}, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;

    move-result-object v0

    const-string v3, "serviceUUID"

    const-string v4, "getServiceUUID()Ljava/util/UUID;"

    invoke-direct {v2, v0, v3, v4}, Lkotlin/jvm/internal/MutablePropertyReference1Impl;-><init>(Lkotlin/reflect/KDeclarationContainer;Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {v2}, Lkotlin/jvm/internal/Reflection;->mutableProperty1(Lkotlin/jvm/internal/MutablePropertyReference1;)Lkotlin/reflect/KMutableProperty1;

    move-result-object v0

    check-cast v0, Lkotlin/reflect/KProperty;

    const/4 v2, 0x1

    aput-object v0, v1, v2

    sput-object v1, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->$$delegatedProperties:[Lkotlin/reflect/KProperty;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 1

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "serviceUUIDString"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->context:Landroid/content/Context;

    const-string p1, "GattServer"

    .line 17
    iput-object p1, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->TAG:Ljava/lang/String;

    .line 18
    sget-object p1, Lkotlin/properties/Delegates;->INSTANCE:Lkotlin/properties/Delegates;

    invoke-virtual {p1}, Lkotlin/properties/Delegates;->notNull()Lkotlin/properties/ReadWriteProperty;

    move-result-object p1

    iput-object p1, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->bluetoothManager$delegate:Lkotlin/properties/ReadWriteProperty;

    .line 20
    sget-object p1, Lkotlin/properties/Delegates;->INSTANCE:Lkotlin/properties/Delegates;

    invoke-virtual {p1}, Lkotlin/properties/Delegates;->notNull()Lkotlin/properties/ReadWriteProperty;

    move-result-object p1

    iput-object p1, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->serviceUUID$delegate:Lkotlin/properties/ReadWriteProperty;

    .line 24
    iget-object p1, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->context:Landroid/content/Context;

    const-string v0, "bluetooth"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p1

    if-eqz p1, :cond_0

    check-cast p1, Landroid/bluetooth/BluetoothManager;

    invoke-direct {p0, p1}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->setBluetoothManager(Landroid/bluetooth/BluetoothManager;)V

    .line 25
    invoke-static {p2}, Ljava/util/UUID;->fromString(Ljava/lang/String;)Ljava/util/UUID;

    move-result-object p1

    const-string p2, "UUID.fromString(serviceUUIDString)"

    invoke-static {p1, p2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {p0, p1}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->setServiceUUID(Ljava/util/UUID;)V

    .line 28
    new-instance p1, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;

    invoke-direct {p1, p0}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;-><init>(Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;)V

    iput-object p1, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->gattServerCallback:Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;

    return-void

    .line 24
    :cond_0
    new-instance p1, Lkotlin/TypeCastException;

    const-string p2, "null cannot be cast to non-null type android.bluetooth.BluetoothManager"

    invoke-direct {p1, p2}, Lkotlin/TypeCastException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public static final synthetic access$getBluetoothManager$p(Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;)Landroid/bluetooth/BluetoothManager;
    .locals 0

    .line 15
    invoke-direct {p0}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->getBluetoothManager()Landroid/bluetooth/BluetoothManager;

    move-result-object p0

    return-object p0
.end method

.method public static final synthetic access$getServiceUUID$p(Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;)Ljava/util/UUID;
    .locals 0

    .line 15
    invoke-direct {p0}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->getServiceUUID()Ljava/util/UUID;

    move-result-object p0

    return-object p0
.end method

.method public static final synthetic access$getTAG$p(Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;)Ljava/lang/String;
    .locals 0

    .line 15
    iget-object p0, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->TAG:Ljava/lang/String;

    return-object p0
.end method

.method public static final synthetic access$setBluetoothManager$p(Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;Landroid/bluetooth/BluetoothManager;)V
    .locals 0

    .line 15
    invoke-direct {p0, p1}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->setBluetoothManager(Landroid/bluetooth/BluetoothManager;)V

    return-void
.end method

.method public static final synthetic access$setServiceUUID$p(Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;Ljava/util/UUID;)V
    .locals 0

    .line 15
    invoke-direct {p0, p1}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->setServiceUUID(Ljava/util/UUID;)V

    return-void
.end method

.method private final getBluetoothManager()Landroid/bluetooth/BluetoothManager;
    .locals 3

    iget-object v0, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->bluetoothManager$delegate:Lkotlin/properties/ReadWriteProperty;

    sget-object v1, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->$$delegatedProperties:[Lkotlin/reflect/KProperty;

    const/4 v2, 0x0

    aget-object v1, v1, v2

    invoke-interface {v0, p0, v1}, Lkotlin/properties/ReadWriteProperty;->getValue(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/bluetooth/BluetoothManager;

    return-object v0
.end method

.method private final getServiceUUID()Ljava/util/UUID;
    .locals 3

    iget-object v0, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->serviceUUID$delegate:Lkotlin/properties/ReadWriteProperty;

    sget-object v1, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->$$delegatedProperties:[Lkotlin/reflect/KProperty;

    const/4 v2, 0x1

    aget-object v1, v1, v2

    invoke-interface {v0, p0, v1}, Lkotlin/properties/ReadWriteProperty;->getValue(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/UUID;

    return-object v0
.end method

.method private final setBluetoothManager(Landroid/bluetooth/BluetoothManager;)V
    .locals 3

    iget-object v0, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->bluetoothManager$delegate:Lkotlin/properties/ReadWriteProperty;

    sget-object v1, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->$$delegatedProperties:[Lkotlin/reflect/KProperty;

    const/4 v2, 0x0

    aget-object v1, v1, v2

    invoke-interface {v0, p0, v1, p1}, Lkotlin/properties/ReadWriteProperty;->setValue(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V

    return-void
.end method

.method private final setServiceUUID(Ljava/util/UUID;)V
    .locals 3

    iget-object v0, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->serviceUUID$delegate:Lkotlin/properties/ReadWriteProperty;

    sget-object v1, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->$$delegatedProperties:[Lkotlin/reflect/KProperty;

    const/4 v2, 0x1

    aget-object v1, v1, v2

    invoke-interface {v0, p0, v1, p1}, Lkotlin/properties/ReadWriteProperty;->setValue(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V

    return-void
.end method


# virtual methods
.method public final addService(Lau/gov/health/covidsafe/bluetooth/gatt/GattService;)V
    .locals 1

    const-string v0, "service"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 278
    iget-object v0, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->bluetoothGattServer:Landroid/bluetooth/BluetoothGattServer;

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lau/gov/health/covidsafe/bluetooth/gatt/GattService;->getGattService()Landroid/bluetooth/BluetoothGattService;

    move-result-object p1

    invoke-virtual {v0, p1}, Landroid/bluetooth/BluetoothGattServer;->addService(Landroid/bluetooth/BluetoothGattService;)Z

    :cond_0
    return-void
.end method

.method public final getBluetoothGattServer()Landroid/bluetooth/BluetoothGattServer;
    .locals 1

    .line 21
    iget-object v0, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->bluetoothGattServer:Landroid/bluetooth/BluetoothGattServer;

    return-object v0
.end method

.method public final getContext()Landroid/content/Context;
    .locals 1

    .line 15
    iget-object v0, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->context:Landroid/content/Context;

    return-object v0
.end method

.method public final setBluetoothGattServer(Landroid/bluetooth/BluetoothGattServer;)V
    .locals 0

    .line 21
    iput-object p1, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->bluetoothGattServer:Landroid/bluetooth/BluetoothGattServer;

    return-void
.end method

.method public final startServer()Z
    .locals 3

    .line 268
    invoke-direct {p0}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->getBluetoothManager()Landroid/bluetooth/BluetoothManager;

    move-result-object v0

    iget-object v1, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->context:Landroid/content/Context;

    iget-object v2, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->gattServerCallback:Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;

    check-cast v2, Landroid/bluetooth/BluetoothGattServerCallback;

    invoke-virtual {v0, v1, v2}, Landroid/bluetooth/BluetoothManager;->openGattServer(Landroid/content/Context;Landroid/bluetooth/BluetoothGattServerCallback;)Landroid/bluetooth/BluetoothGattServer;

    move-result-object v0

    iput-object v0, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->bluetoothGattServer:Landroid/bluetooth/BluetoothGattServer;

    if-eqz v0, :cond_0

    .line 271
    invoke-virtual {v0}, Landroid/bluetooth/BluetoothGattServer;->clearServices()V

    const/4 v0, 0x1

    return v0

    :cond_0
    const/4 v0, 0x0

    return v0
.end method

.method public final stop()V
    .locals 5

    .line 283
    :try_start_0
    iget-object v0, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->bluetoothGattServer:Landroid/bluetooth/BluetoothGattServer;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothGattServer;->clearServices()V

    .line 284
    :cond_0
    iget-object v0, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->bluetoothGattServer:Landroid/bluetooth/BluetoothGattServer;

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothGattServer;->close()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    .line 286
    sget-object v1, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v2, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "GATT server can\'t be closed elegantly "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/Throwable;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v2, v0}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->e(Ljava/lang/String;Ljava/lang/String;)V

    :cond_1
    :goto_0
    return-void
.end method
