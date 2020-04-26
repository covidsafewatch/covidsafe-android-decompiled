.class public final Lau/gov/health/covidsafe/bluetooth/gatt/GattService;
.super Ljava/lang/Object;
.source "GattService.kt"


# annotations
.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nGattService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GattService.kt\nau/gov/health/covidsafe/bluetooth/gatt/GattService\n*L\n1#1,36:1\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\u0008\u0010\u0010\u0011\u001a\u0004\u0008\u000c\u0010\r\"\u0004\u0008\u000e\u0010\u000fR+\u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00128F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\u0008\u0018\u0010\u0011\u001a\u0004\u0008\u0014\u0010\u0015\"\u0004\u0008\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "
    }
    d2 = {
        "Lau/gov/health/covidsafe/bluetooth/gatt/GattService;",
        "",
        "context",
        "Landroid/content/Context;",
        "serviceUUIDString",
        "",
        "(Landroid/content/Context;Ljava/lang/String;)V",
        "getContext",
        "()Landroid/content/Context;",
        "<set-?>",
        "Landroid/bluetooth/BluetoothGattCharacteristic;",
        "devicePropertyCharacteristic",
        "getDevicePropertyCharacteristic",
        "()Landroid/bluetooth/BluetoothGattCharacteristic;",
        "setDevicePropertyCharacteristic",
        "(Landroid/bluetooth/BluetoothGattCharacteristic;)V",
        "devicePropertyCharacteristic$delegate",
        "Lkotlin/properties/ReadWriteProperty;",
        "Landroid/bluetooth/BluetoothGattService;",
        "gattService",
        "getGattService",
        "()Landroid/bluetooth/BluetoothGattService;",
        "setGattService",
        "(Landroid/bluetooth/BluetoothGattService;)V",
        "gattService$delegate",
        "serviceUUID",
        "Ljava/util/UUID;",
        "kotlin.jvm.PlatformType",
        "setValue",
        "",
        "value",
        "",
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
.field private final context:Landroid/content/Context;

.field private final devicePropertyCharacteristic$delegate:Lkotlin/properties/ReadWriteProperty;

.field private final gattService$delegate:Lkotlin/properties/ReadWriteProperty;

.field private serviceUUID:Ljava/util/UUID;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    const-class v0, Lau/gov/health/covidsafe/bluetooth/gatt/GattService;

    const/4 v1, 0x2

    new-array v1, v1, [Lkotlin/reflect/KProperty;

    new-instance v2, Lkotlin/jvm/internal/MutablePropertyReference1Impl;

    invoke-static {v0}, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;

    move-result-object v3

    const-string v4, "gattService"

    const-string v5, "getGattService()Landroid/bluetooth/BluetoothGattService;"

    invoke-direct {v2, v3, v4, v5}, Lkotlin/jvm/internal/MutablePropertyReference1Impl;-><init>(Lkotlin/reflect/KDeclarationContainer;Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {v2}, Lkotlin/jvm/internal/Reflection;->mutableProperty1(Lkotlin/jvm/internal/MutablePropertyReference1;)Lkotlin/reflect/KMutableProperty1;

    move-result-object v2

    check-cast v2, Lkotlin/reflect/KProperty;

    const/4 v3, 0x0

    aput-object v2, v1, v3

    new-instance v2, Lkotlin/jvm/internal/MutablePropertyReference1Impl;

    invoke-static {v0}, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;

    move-result-object v0

    const-string v3, "devicePropertyCharacteristic"

    const-string v4, "getDevicePropertyCharacteristic()Landroid/bluetooth/BluetoothGattCharacteristic;"

    invoke-direct {v2, v0, v3, v4}, Lkotlin/jvm/internal/MutablePropertyReference1Impl;-><init>(Lkotlin/reflect/KDeclarationContainer;Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {v2}, Lkotlin/jvm/internal/Reflection;->mutableProperty1(Lkotlin/jvm/internal/MutablePropertyReference1;)Lkotlin/reflect/KMutableProperty1;

    move-result-object v0

    check-cast v0, Lkotlin/reflect/KProperty;

    const/4 v2, 0x1

    aput-object v0, v1, v2

    sput-object v1, Lau/gov/health/covidsafe/bluetooth/gatt/GattService;->$$delegatedProperties:[Lkotlin/reflect/KProperty;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 2

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "serviceUUIDString"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattService;->context:Landroid/content/Context;

    .line 11
    invoke-static {p2}, Ljava/util/UUID;->fromString(Ljava/lang/String;)Ljava/util/UUID;

    move-result-object p1

    iput-object p1, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattService;->serviceUUID:Ljava/util/UUID;

    .line 13
    sget-object p1, Lkotlin/properties/Delegates;->INSTANCE:Lkotlin/properties/Delegates;

    invoke-virtual {p1}, Lkotlin/properties/Delegates;->notNull()Lkotlin/properties/ReadWriteProperty;

    move-result-object p1

    iput-object p1, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattService;->gattService$delegate:Lkotlin/properties/ReadWriteProperty;

    .line 15
    sget-object p1, Lkotlin/properties/Delegates;->INSTANCE:Lkotlin/properties/Delegates;

    invoke-virtual {p1}, Lkotlin/properties/Delegates;->notNull()Lkotlin/properties/ReadWriteProperty;

    move-result-object p1

    iput-object p1, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattService;->devicePropertyCharacteristic$delegate:Lkotlin/properties/ReadWriteProperty;

    .line 18
    new-instance p1, Landroid/bluetooth/BluetoothGattService;

    iget-object p2, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattService;->serviceUUID:Ljava/util/UUID;

    const/4 v0, 0x0

    invoke-direct {p1, p2, v0}, Landroid/bluetooth/BluetoothGattService;-><init>(Ljava/util/UUID;I)V

    invoke-virtual {p0, p1}, Lau/gov/health/covidsafe/bluetooth/gatt/GattService;->setGattService(Landroid/bluetooth/BluetoothGattService;)V

    .line 21
    new-instance p1, Landroid/bluetooth/BluetoothGattCharacteristic;

    .line 22
    iget-object p2, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattService;->serviceUUID:Ljava/util/UUID;

    const/16 v0, 0xa

    const/16 v1, 0x11

    .line 21
    invoke-direct {p1, p2, v0, v1}, Landroid/bluetooth/BluetoothGattCharacteristic;-><init>(Ljava/util/UUID;II)V

    invoke-direct {p0, p1}, Lau/gov/health/covidsafe/bluetooth/gatt/GattService;->setDevicePropertyCharacteristic(Landroid/bluetooth/BluetoothGattCharacteristic;)V

    .line 26
    invoke-virtual {p0}, Lau/gov/health/covidsafe/bluetooth/gatt/GattService;->getGattService()Landroid/bluetooth/BluetoothGattService;

    move-result-object p1

    invoke-direct {p0}, Lau/gov/health/covidsafe/bluetooth/gatt/GattService;->getDevicePropertyCharacteristic()Landroid/bluetooth/BluetoothGattCharacteristic;

    move-result-object p2

    invoke-virtual {p1, p2}, Landroid/bluetooth/BluetoothGattService;->addCharacteristic(Landroid/bluetooth/BluetoothGattCharacteristic;)Z

    return-void
.end method

.method private final getDevicePropertyCharacteristic()Landroid/bluetooth/BluetoothGattCharacteristic;
    .locals 3

    iget-object v0, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattService;->devicePropertyCharacteristic$delegate:Lkotlin/properties/ReadWriteProperty;

    sget-object v1, Lau/gov/health/covidsafe/bluetooth/gatt/GattService;->$$delegatedProperties:[Lkotlin/reflect/KProperty;

    const/4 v2, 0x1

    aget-object v1, v1, v2

    invoke-interface {v0, p0, v1}, Lkotlin/properties/ReadWriteProperty;->getValue(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/bluetooth/BluetoothGattCharacteristic;

    return-object v0
.end method

.method private final setDevicePropertyCharacteristic(Landroid/bluetooth/BluetoothGattCharacteristic;)V
    .locals 3

    iget-object v0, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattService;->devicePropertyCharacteristic$delegate:Lkotlin/properties/ReadWriteProperty;

    sget-object v1, Lau/gov/health/covidsafe/bluetooth/gatt/GattService;->$$delegatedProperties:[Lkotlin/reflect/KProperty;

    const/4 v2, 0x1

    aget-object v1, v1, v2

    invoke-interface {v0, p0, v1, p1}, Lkotlin/properties/ReadWriteProperty;->setValue(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V

    return-void
.end method


# virtual methods
.method public final getContext()Landroid/content/Context;
    .locals 1

    .line 9
    iget-object v0, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattService;->context:Landroid/content/Context;

    return-object v0
.end method

.method public final getGattService()Landroid/bluetooth/BluetoothGattService;
    .locals 3

    iget-object v0, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattService;->gattService$delegate:Lkotlin/properties/ReadWriteProperty;

    sget-object v1, Lau/gov/health/covidsafe/bluetooth/gatt/GattService;->$$delegatedProperties:[Lkotlin/reflect/KProperty;

    const/4 v2, 0x0

    aget-object v1, v1, v2

    invoke-interface {v0, p0, v1}, Lkotlin/properties/ReadWriteProperty;->getValue(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/bluetooth/BluetoothGattService;

    return-object v0
.end method

.method public final setGattService(Landroid/bluetooth/BluetoothGattService;)V
    .locals 3

    const-string v0, "<set-?>"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    iget-object v0, p0, Lau/gov/health/covidsafe/bluetooth/gatt/GattService;->gattService$delegate:Lkotlin/properties/ReadWriteProperty;

    sget-object v1, Lau/gov/health/covidsafe/bluetooth/gatt/GattService;->$$delegatedProperties:[Lkotlin/reflect/KProperty;

    const/4 v2, 0x0

    aget-object v1, v1, v2

    invoke-interface {v0, p0, v1, p1}, Lkotlin/properties/ReadWriteProperty;->setValue(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V

    return-void
.end method

.method public final setValue(Ljava/lang/String;)V
    .locals 1

    const-string v0, "value"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 30
    sget-object v0, Lkotlin/text/Charsets;->UTF_8:Ljava/nio/charset/Charset;

    invoke-virtual {p1, v0}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object p1

    const-string v0, "(this as java.lang.String).getBytes(charset)"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p0, p1}, Lau/gov/health/covidsafe/bluetooth/gatt/GattService;->setValue([B)V

    return-void
.end method

.method public final setValue([B)V
    .locals 1

    const-string v0, "value"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 34
    invoke-direct {p0}, Lau/gov/health/covidsafe/bluetooth/gatt/GattService;->getDevicePropertyCharacteristic()Landroid/bluetooth/BluetoothGattCharacteristic;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/bluetooth/BluetoothGattCharacteristic;->setValue([B)Z

    return-void
.end method
