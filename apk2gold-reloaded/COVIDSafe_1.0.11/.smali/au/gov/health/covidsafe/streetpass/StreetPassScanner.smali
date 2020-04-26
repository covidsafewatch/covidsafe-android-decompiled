.class public final Lau/gov/health/covidsafe/streetpass/StreetPassScanner;
.super Ljava/lang/Object;
.source "StreetPassScanner.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lau/gov/health/covidsafe/streetpass/StreetPassScanner$BleScanCallback;
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001:\u0001\'B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\u0008J\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020%R\u000e\u0010\t\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R+\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00038B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00060\u0014R\u00020\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\u0016\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u00158B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\u0008\u001b\u0010\u0010\u001a\u0004\u0008\u0017\u0010\u0018\"\u0004\u0008\u0019\u0010\u001aR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u001e\u0010\u001f\"\u0004\u0008 \u0010!\u00a8\u0006("
    }
    d2 = {
        "Lau/gov/health/covidsafe/streetpass/StreetPassScanner;",
        "",
        "context",
        "Landroid/content/Context;",
        "serviceUUIDString",
        "",
        "scanDurationInMillis",
        "",
        "(Landroid/content/Context;Ljava/lang/String;J)V",
        "TAG",
        "<set-?>",
        "getContext",
        "()Landroid/content/Context;",
        "setContext",
        "(Landroid/content/Context;)V",
        "context$delegate",
        "Lkotlin/properties/ReadWriteProperty;",
        "handler",
        "Landroid/os/Handler;",
        "scanCallback",
        "Lau/gov/health/covidsafe/streetpass/StreetPassScanner$BleScanCallback;",
        "Lau/gov/health/covidsafe/bluetooth/BLEScanner;",
        "scanner",
        "getScanner",
        "()Lau/gov/health/covidsafe/bluetooth/BLEScanner;",
        "setScanner",
        "(Lau/gov/health/covidsafe/bluetooth/BLEScanner;)V",
        "scanner$delegate",
        "scannerCount",
        "",
        "getScannerCount",
        "()I",
        "setScannerCount",
        "(I)V",
        "isScanning",
        "",
        "startScan",
        "",
        "stopScan",
        "BleScanCallback",
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

.field private final context$delegate:Lkotlin/properties/ReadWriteProperty;

.field private handler:Landroid/os/Handler;

.field private final scanCallback:Lau/gov/health/covidsafe/streetpass/StreetPassScanner$BleScanCallback;

.field private final scanDurationInMillis:J

.field private final scanner$delegate:Lkotlin/properties/ReadWriteProperty;

.field private scannerCount:I


# direct methods
.method static constructor <clinit>()V
    .locals 6

    const-class v0, Lau/gov/health/covidsafe/streetpass/StreetPassScanner;

    const/4 v1, 0x2

    new-array v1, v1, [Lkotlin/reflect/KProperty;

    new-instance v2, Lkotlin/jvm/internal/MutablePropertyReference1Impl;

    invoke-static {v0}, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;

    move-result-object v3

    const-string v4, "scanner"

    const-string v5, "getScanner()Lau/gov/health/covidsafe/bluetooth/BLEScanner;"

    invoke-direct {v2, v3, v4, v5}, Lkotlin/jvm/internal/MutablePropertyReference1Impl;-><init>(Lkotlin/reflect/KDeclarationContainer;Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {v2}, Lkotlin/jvm/internal/Reflection;->mutableProperty1(Lkotlin/jvm/internal/MutablePropertyReference1;)Lkotlin/reflect/KMutableProperty1;

    move-result-object v2

    check-cast v2, Lkotlin/reflect/KProperty;

    const/4 v3, 0x0

    aput-object v2, v1, v3

    new-instance v2, Lkotlin/jvm/internal/MutablePropertyReference1Impl;

    invoke-static {v0}, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;

    move-result-object v0

    const-string v3, "context"

    const-string v4, "getContext()Landroid/content/Context;"

    invoke-direct {v2, v0, v3, v4}, Lkotlin/jvm/internal/MutablePropertyReference1Impl;-><init>(Lkotlin/reflect/KDeclarationContainer;Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {v2}, Lkotlin/jvm/internal/Reflection;->mutableProperty1(Lkotlin/jvm/internal/MutablePropertyReference1;)Lkotlin/reflect/KMutableProperty1;

    move-result-object v0

    check-cast v0, Lkotlin/reflect/KProperty;

    const/4 v2, 0x1

    aput-object v0, v1, v2

    sput-object v1, Lau/gov/health/covidsafe/streetpass/StreetPassScanner;->$$delegatedProperties:[Lkotlin/reflect/KProperty;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;J)V
    .locals 2

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "serviceUUIDString"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-wide p3, p0, Lau/gov/health/covidsafe/streetpass/StreetPassScanner;->scanDurationInMillis:J

    .line 20
    sget-object p3, Lkotlin/properties/Delegates;->INSTANCE:Lkotlin/properties/Delegates;

    invoke-virtual {p3}, Lkotlin/properties/Delegates;->notNull()Lkotlin/properties/ReadWriteProperty;

    move-result-object p3

    iput-object p3, p0, Lau/gov/health/covidsafe/streetpass/StreetPassScanner;->scanner$delegate:Lkotlin/properties/ReadWriteProperty;

    .line 22
    sget-object p3, Lkotlin/properties/Delegates;->INSTANCE:Lkotlin/properties/Delegates;

    invoke-virtual {p3}, Lkotlin/properties/Delegates;->notNull()Lkotlin/properties/ReadWriteProperty;

    move-result-object p3

    iput-object p3, p0, Lau/gov/health/covidsafe/streetpass/StreetPassScanner;->context$delegate:Lkotlin/properties/ReadWriteProperty;

    const-string p3, "StreetPassScanner"

    .line 23
    iput-object p3, p0, Lau/gov/health/covidsafe/streetpass/StreetPassScanner;->TAG:Ljava/lang/String;

    .line 25
    new-instance p3, Landroid/os/Handler;

    invoke-direct {p3}, Landroid/os/Handler;-><init>()V

    iput-object p3, p0, Lau/gov/health/covidsafe/streetpass/StreetPassScanner;->handler:Landroid/os/Handler;

    .line 29
    new-instance p3, Lau/gov/health/covidsafe/streetpass/StreetPassScanner$BleScanCallback;

    invoke-direct {p3, p0}, Lau/gov/health/covidsafe/streetpass/StreetPassScanner$BleScanCallback;-><init>(Lau/gov/health/covidsafe/streetpass/StreetPassScanner;)V

    iput-object p3, p0, Lau/gov/health/covidsafe/streetpass/StreetPassScanner;->scanCallback:Lau/gov/health/covidsafe/streetpass/StreetPassScanner$BleScanCallback;

    .line 32
    new-instance p3, Lau/gov/health/covidsafe/bluetooth/BLEScanner;

    const-wide/16 v0, 0x0

    invoke-direct {p3, p1, p2, v0, v1}, Lau/gov/health/covidsafe/bluetooth/BLEScanner;-><init>(Landroid/content/Context;Ljava/lang/String;J)V

    invoke-direct {p0, p3}, Lau/gov/health/covidsafe/streetpass/StreetPassScanner;->setScanner(Lau/gov/health/covidsafe/bluetooth/BLEScanner;)V

    .line 33
    invoke-direct {p0, p1}, Lau/gov/health/covidsafe/streetpass/StreetPassScanner;->setContext(Landroid/content/Context;)V

    return-void
.end method

.method public static final synthetic access$getContext$p(Lau/gov/health/covidsafe/streetpass/StreetPassScanner;)Landroid/content/Context;
    .locals 0

    .line 14
    invoke-direct {p0}, Lau/gov/health/covidsafe/streetpass/StreetPassScanner;->getContext()Landroid/content/Context;

    move-result-object p0

    return-object p0
.end method

.method public static final synthetic access$setContext$p(Lau/gov/health/covidsafe/streetpass/StreetPassScanner;Landroid/content/Context;)V
    .locals 0

    .line 14
    invoke-direct {p0, p1}, Lau/gov/health/covidsafe/streetpass/StreetPassScanner;->setContext(Landroid/content/Context;)V

    return-void
.end method

.method private final getContext()Landroid/content/Context;
    .locals 3

    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassScanner;->context$delegate:Lkotlin/properties/ReadWriteProperty;

    sget-object v1, Lau/gov/health/covidsafe/streetpass/StreetPassScanner;->$$delegatedProperties:[Lkotlin/reflect/KProperty;

    const/4 v2, 0x1

    aget-object v1, v1, v2

    invoke-interface {v0, p0, v1}, Lkotlin/properties/ReadWriteProperty;->getValue(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/Context;

    return-object v0
.end method

.method private final getScanner()Lau/gov/health/covidsafe/bluetooth/BLEScanner;
    .locals 3

    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassScanner;->scanner$delegate:Lkotlin/properties/ReadWriteProperty;

    sget-object v1, Lau/gov/health/covidsafe/streetpass/StreetPassScanner;->$$delegatedProperties:[Lkotlin/reflect/KProperty;

    const/4 v2, 0x0

    aget-object v1, v1, v2

    invoke-interface {v0, p0, v1}, Lkotlin/properties/ReadWriteProperty;->getValue(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lau/gov/health/covidsafe/bluetooth/BLEScanner;

    return-object v0
.end method

.method private final setContext(Landroid/content/Context;)V
    .locals 3

    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassScanner;->context$delegate:Lkotlin/properties/ReadWriteProperty;

    sget-object v1, Lau/gov/health/covidsafe/streetpass/StreetPassScanner;->$$delegatedProperties:[Lkotlin/reflect/KProperty;

    const/4 v2, 0x1

    aget-object v1, v1, v2

    invoke-interface {v0, p0, v1, p1}, Lkotlin/properties/ReadWriteProperty;->setValue(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V

    return-void
.end method

.method private final setScanner(Lau/gov/health/covidsafe/bluetooth/BLEScanner;)V
    .locals 3

    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassScanner;->scanner$delegate:Lkotlin/properties/ReadWriteProperty;

    sget-object v1, Lau/gov/health/covidsafe/streetpass/StreetPassScanner;->$$delegatedProperties:[Lkotlin/reflect/KProperty;

    const/4 v2, 0x0

    aget-object v1, v1, v2

    invoke-interface {v0, p0, v1, p1}, Lkotlin/properties/ReadWriteProperty;->setValue(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V

    return-void
.end method


# virtual methods
.method public final getScannerCount()I
    .locals 1

    .line 27
    iget v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassScanner;->scannerCount:I

    return v0
.end method

.method public final isScanning()Z
    .locals 1

    .line 64
    iget v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassScanner;->scannerCount:I

    if-lez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public final setScannerCount(I)V
    .locals 0

    .line 27
    iput p1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassScanner;->scannerCount:I

    return-void
.end method

.method public final startScan()V
    .locals 4

    .line 38
    new-instance v0, Lau/gov/health/covidsafe/status/Status;

    const-string v1, "Scanning Started"

    invoke-direct {v0, v1}, Lau/gov/health/covidsafe/status/Status;-><init>(Ljava/lang/String;)V

    .line 39
    sget-object v1, Lau/gov/health/covidsafe/Utils;->INSTANCE:Lau/gov/health/covidsafe/Utils;

    invoke-direct {p0}, Lau/gov/health/covidsafe/streetpass/StreetPassScanner;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Lau/gov/health/covidsafe/Utils;->broadcastStatusReceived(Landroid/content/Context;Lau/gov/health/covidsafe/status/Status;)V

    .line 41
    invoke-direct {p0}, Lau/gov/health/covidsafe/streetpass/StreetPassScanner;->getScanner()Lau/gov/health/covidsafe/bluetooth/BLEScanner;

    move-result-object v0

    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassScanner;->scanCallback:Lau/gov/health/covidsafe/streetpass/StreetPassScanner$BleScanCallback;

    check-cast v1, Landroid/bluetooth/le/ScanCallback;

    invoke-virtual {v0, v1}, Lau/gov/health/covidsafe/bluetooth/BLEScanner;->startScan(Landroid/bluetooth/le/ScanCallback;)V

    .line 42
    iget v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassScanner;->scannerCount:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassScanner;->scannerCount:I

    .line 44
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassScanner;->handler:Landroid/os/Handler;

    .line 45
    new-instance v1, Lau/gov/health/covidsafe/streetpass/StreetPassScanner$startScan$1;

    invoke-direct {v1, p0}, Lau/gov/health/covidsafe/streetpass/StreetPassScanner$startScan$1;-><init>(Lau/gov/health/covidsafe/streetpass/StreetPassScanner;)V

    check-cast v1, Ljava/lang/Runnable;

    .line 46
    iget-wide v2, p0, Lau/gov/health/covidsafe/streetpass/StreetPassScanner;->scanDurationInMillis:J

    .line 44
    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 49
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassScanner;->TAG:Ljava/lang/String;

    const-string v2, "scanning started"

    invoke-virtual {v0, v1, v2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->d(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public final stopScan()V
    .locals 3

    .line 54
    iget v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassScanner;->scannerCount:I

    if-lez v0, :cond_0

    .line 55
    new-instance v0, Lau/gov/health/covidsafe/status/Status;

    const-string v1, "Scanning Stopped"

    invoke-direct {v0, v1}, Lau/gov/health/covidsafe/status/Status;-><init>(Ljava/lang/String;)V

    .line 56
    sget-object v1, Lau/gov/health/covidsafe/Utils;->INSTANCE:Lau/gov/health/covidsafe/Utils;

    invoke-direct {p0}, Lau/gov/health/covidsafe/streetpass/StreetPassScanner;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Lau/gov/health/covidsafe/Utils;->broadcastStatusReceived(Landroid/content/Context;Lau/gov/health/covidsafe/status/Status;)V

    .line 57
    iget v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassScanner;->scannerCount:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassScanner;->scannerCount:I

    .line 58
    invoke-direct {p0}, Lau/gov/health/covidsafe/streetpass/StreetPassScanner;->getScanner()Lau/gov/health/covidsafe/bluetooth/BLEScanner;

    move-result-object v0

    invoke-virtual {v0}, Lau/gov/health/covidsafe/bluetooth/BLEScanner;->stopScan()V

    :cond_0
    return-void
.end method
