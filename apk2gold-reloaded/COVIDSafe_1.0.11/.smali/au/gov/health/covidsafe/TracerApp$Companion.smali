.class public final Lau/gov/health/covidsafe/TracerApp$Companion;
.super Ljava/lang/Object;
.source "TracerApp.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lau/gov/health/covidsafe/TracerApp;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Companion"
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nTracerApp.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TracerApp.kt\nau/gov/health/covidsafe/TracerApp$Companion\n*L\n1#1,49:1\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008R\u000e\u0010\t\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"
    }
    d2 = {
        "Lau/gov/health/covidsafe/TracerApp$Companion;",
        "",
        "()V",
        "AppContext",
        "Landroid/content/Context;",
        "getAppContext",
        "()Landroid/content/Context;",
        "setAppContext",
        "(Landroid/content/Context;)V",
        "ORG",
        "",
        "TAG",
        "protocolVersion",
        "",
        "asCentralDevice",
        "Lau/gov/health/covidsafe/streetpass/CentralDevice;",
        "asPeripheralDevice",
        "Lau/gov/health/covidsafe/streetpass/PeripheralDevice;",
        "thisDeviceMsg",
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
.method private constructor <init>()V
    .locals 0

    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public synthetic constructor <init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    .locals 0

    .line 21
    invoke-direct {p0}, Lau/gov/health/covidsafe/TracerApp$Companion;-><init>()V

    return-void
.end method


# virtual methods
.method public final asCentralDevice()Lau/gov/health/covidsafe/streetpass/CentralDevice;
    .locals 3

    .line 44
    new-instance v0, Lau/gov/health/covidsafe/streetpass/CentralDevice;

    sget-object v1, Landroid/os/Build;->MODEL:Ljava/lang/String;

    const-string v2, "Build.MODEL"

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v2, "SELF"

    invoke-direct {v0, v1, v2}, Lau/gov/health/covidsafe/streetpass/CentralDevice;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method public final asPeripheralDevice()Lau/gov/health/covidsafe/streetpass/PeripheralDevice;
    .locals 3

    .line 40
    new-instance v0, Lau/gov/health/covidsafe/streetpass/PeripheralDevice;

    sget-object v1, Landroid/os/Build;->MODEL:Ljava/lang/String;

    const-string v2, "Build.MODEL"

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v2, "SELF"

    invoke-direct {v0, v1, v2}, Lau/gov/health/covidsafe/streetpass/PeripheralDevice;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method public final getAppContext()Landroid/content/Context;
    .locals 2

    .line 27
    invoke-static {}, Lau/gov/health/covidsafe/TracerApp;->access$getAppContext$cp()Landroid/content/Context;

    move-result-object v0

    if-nez v0, :cond_0

    const-string v1, "AppContext"

    invoke-static {v1}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    :cond_0
    return-object v0
.end method

.method public final setAppContext(Landroid/content/Context;)V
    .locals 1

    const-string v0, "<set-?>"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 27
    invoke-static {p1}, Lau/gov/health/covidsafe/TracerApp;->access$setAppContext$cp(Landroid/content/Context;)V

    return-void
.end method

.method public final thisDeviceMsg()Ljava/lang/String;
    .locals 5

    .line 30
    sget-object v0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->Companion:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Companion;

    invoke-virtual {v0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Companion;->getBroadcastMessage()Ljava/lang/String;

    move-result-object v0

    const-string v1, "TracerApp"

    if-eqz v0, :cond_0

    .line 31
    sget-object v2, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Retrieved BM for storage: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v1, v3}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    return-object v0

    .line 35
    :cond_0
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    const-string v2, "No local Broadcast Message"

    invoke-virtual {v0, v1, v2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 36
    sget-object v0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->Companion:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Companion;

    invoke-virtual {v0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Companion;->getBroadcastMessage()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_1

    invoke-static {}, Lkotlin/jvm/internal/Intrinsics;->throwNpe()V

    :cond_1
    return-object v0
.end method
