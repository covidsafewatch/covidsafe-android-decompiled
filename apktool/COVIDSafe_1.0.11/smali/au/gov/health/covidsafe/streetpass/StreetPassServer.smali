.class public final Lau/gov/health/covidsafe/streetpass/StreetPassServer;
.super Ljava/lang/Object;
.source "StreetPassServer.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001a\u0010\u000c\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0007\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"
    }
    d2 = {
        "Lau/gov/health/covidsafe/streetpass/StreetPassServer;",
        "",
        "context",
        "Landroid/content/Context;",
        "serviceUUIDString",
        "",
        "(Landroid/content/Context;Ljava/lang/String;)V",
        "TAG",
        "getContext",
        "()Landroid/content/Context;",
        "gattServer",
        "Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;",
        "setupGattServer",
        "tearDown",
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


# instance fields
.field private final TAG:Ljava/lang/String;

.field private final context:Landroid/content/Context;

.field private gattServer:Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 1

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "serviceUUIDString"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassServer;->context:Landroid/content/Context;

    const-string v0, "StreetPassServer"

    .line 9
    iput-object v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassServer;->TAG:Ljava/lang/String;

    .line 13
    invoke-direct {p0, p1, p2}, Lau/gov/health/covidsafe/streetpass/StreetPassServer;->setupGattServer(Landroid/content/Context;Ljava/lang/String;)Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;

    move-result-object p1

    iput-object p1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassServer;->gattServer:Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;

    return-void
.end method

.method private final setupGattServer(Landroid/content/Context;Ljava/lang/String;)Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;
    .locals 2

    .line 17
    new-instance v0, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;

    invoke-direct {v0, p1, p2}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 18
    invoke-virtual {v0}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->startServer()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 21
    new-instance v1, Lau/gov/health/covidsafe/bluetooth/gatt/GattService;

    invoke-direct {v1, p1, p2}, Lau/gov/health/covidsafe/bluetooth/gatt/GattService;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 22
    invoke-virtual {v0, v1}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->addService(Lau/gov/health/covidsafe/bluetooth/gatt/GattService;)V

    return-object v0

    :cond_0
    const/4 p1, 0x0

    return-object p1
.end method


# virtual methods
.method public final getContext()Landroid/content/Context;
    .locals 1

    .line 7
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassServer;->context:Landroid/content/Context;

    return-object v0
.end method

.method public final tearDown()V
    .locals 1

    .line 29
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassServer;->gattServer:Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;->stop()V

    :cond_0
    return-void
.end method
