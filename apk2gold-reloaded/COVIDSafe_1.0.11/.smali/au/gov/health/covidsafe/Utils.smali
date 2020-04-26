.class public final Lau/gov/health/covidsafe/Utils;
.super Ljava/lang/Object;
.source "Utils.kt"


# annotations
.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\nau/gov/health/covidsafe/Utils\n*L\n1#1,249:1\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u000e\u0008\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u000b\u001a\u00020\u000cJ\u0016\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u000e\u001a\u00020\u0004J\u001e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u0013\u001a\u00020\u0014J\u0016\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u0016\u001a\u00020\u0017J\u0018\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u000e\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0008J\u000e\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0008J\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0008H\u0002J\u000e\u0010 \u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0008J\u000e\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u0004J\u000e\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020%J\u0011\u0010&\u001a\u0008\u0012\u0004\u0012\u00020\u00040\'\u00a2\u0006\u0002\u0010(J\u0006\u0010)\u001a\u00020\u0006J\u000e\u0010*\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008J\u0010\u0010+\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0008J\u0016\u0010,\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010-\u001a\u00020%J\u0016\u0010.\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010/\u001a\u00020%J\u0016\u00100\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010/\u001a\u00020%J\u000e\u00101\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0008J\u000e\u00102\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0008J\u0018\u00103\u001a\u00020\n2\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00082\u0006\u00104\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u00065"
    }
    d2 = {
        "Lau/gov/health/covidsafe/Utils;",
        "",
        "()V",
        "TAG",
        "",
        "bmValid",
        "",
        "context",
        "Landroid/content/Context;",
        "broadcastDeviceDisconnected",
        "",
        "device",
        "Landroid/bluetooth/BluetoothDevice;",
        "broadcastDeviceProcessed",
        "deviceAddress",
        "broadcastDeviceScanned",
        "connectableBleDevice",
        "Lau/gov/health/covidsafe/streetpass/ConnectablePeripheral;",
        "broadcastStatusReceived",
        "statusRecord",
        "Lau/gov/health/covidsafe/status/Status;",
        "broadcastStreetPassReceived",
        "streetpass",
        "Lau/gov/health/covidsafe/streetpass/ConnectionRecord;",
        "canHandleIntent",
        "batteryExemptionIntent",
        "Landroid/content/Intent;",
        "packageManager",
        "Landroid/content/pm/PackageManager;",
        "cancelBMUpdateCheck",
        "cancelNextAdvertise",
        "cancelNextHealthCheck",
        "cancelNextScan",
        "getBatteryOptimizerExemptionIntent",
        "packageName",
        "getDate",
        "milliSeconds",
        "",
        "getRequiredPermissions",
        "",
        "()[Ljava/lang/String;",
        "isBluetoothAvailable",
        "needToUpdate",
        "retrieveBroadcastMessage",
        "scheduleBMUpdateCheck",
        "bmCheckInterval",
        "scheduleNextHealthCheck",
        "timeInMillis",
        "scheduleStartMonitoringService",
        "startBluetoothMonitoringService",
        "stopBluetoothMonitoringService",
        "storeBroadcastMessage",
        "packet",
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
.field public static final INSTANCE:Lau/gov/health/covidsafe/Utils;

.field private static final TAG:Ljava/lang/String; = "Utils"


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 29
    new-instance v0, Lau/gov/health/covidsafe/Utils;

    invoke-direct {v0}, Lau/gov/health/covidsafe/Utils;-><init>()V

    sput-object v0, Lau/gov/health/covidsafe/Utils;->INSTANCE:Lau/gov/health/covidsafe/Utils;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private final cancelNextHealthCheck(Landroid/content/Context;)V
    .locals 3

    .line 163
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;

    invoke-direct {v0, p1, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 166
    sget-object v1, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->ACTION_SELF_CHECK:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

    invoke-virtual {v1}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->getIndex()I

    move-result v1

    const-string v2, "au.gov.health.covidsafe_CMD"

    .line 164
    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 168
    sget-object v1, Lau/gov/health/covidsafe/scheduler/Scheduler;->INSTANCE:Lau/gov/health/covidsafe/scheduler/Scheduler;

    const/16 v2, 0x9

    invoke-virtual {v1, v2, p1, v0}, Lau/gov/health/covidsafe/scheduler/Scheduler;->cancelServiceIntent(ILandroid/content/Context;Landroid/content/Intent;)V

    return-void
.end method


# virtual methods
.method public final bmValid(Landroid/content/Context;)Z
    .locals 8

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 240
    sget-object v0, Lau/gov/health/covidsafe/Preference;->INSTANCE:Lau/gov/health/covidsafe/Preference;

    invoke-virtual {v0, p1}, Lau/gov/health/covidsafe/Preference;->getExpiryTimeInMillis(Landroid/content/Context;)J

    move-result-wide v0

    .line 241
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    cmp-long p1, v2, v0

    const/4 v4, 0x1

    if-gez p1, :cond_0

    move p1, v4

    goto :goto_0

    :cond_0
    const/4 p1, 0x0

    .line 244
    :goto_0
    sget-object v5, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Is BM Valid? "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    const-string v0, " vs "

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    const-string v0, ": "

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6, p1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    const-string v0, "Utils"

    invoke-virtual {v5, v0, p1}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    return v4
.end method

.method public final broadcastDeviceDisconnected(Landroid/content/Context;Landroid/bluetooth/BluetoothDevice;)V
    .locals 2

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "device"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 202
    new-instance v0, Landroid/content/Intent;

    const-string v1, "au.gov.health.covidsafe.ACTION_GATT_DISCONNECTED"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 203
    check-cast p2, Landroid/os/Parcelable;

    const-string v1, "android.bluetooth.device.extra.DEVICE"

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 204
    invoke-static {p1}, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->getInstance(Landroid/content/Context;)Landroidx/localbroadcastmanager/content/LocalBroadcastManager;

    move-result-object p1

    invoke-virtual {p1, v0}, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->sendBroadcast(Landroid/content/Intent;)Z

    return-void
.end method

.method public final broadcastDeviceProcessed(Landroid/content/Context;Ljava/lang/String;)V
    .locals 2

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "deviceAddress"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 183
    new-instance v0, Landroid/content/Intent;

    const-string v1, "au.gov.health.covidsafe.ACTION_DEVICE_PROCESSED"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    const-string v1, "au.gov.health.covidsafe.DEVICE_ADDRESS"

    .line 184
    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 185
    invoke-static {p1}, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->getInstance(Landroid/content/Context;)Landroidx/localbroadcastmanager/content/LocalBroadcastManager;

    move-result-object p1

    invoke-virtual {p1, v0}, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->sendBroadcast(Landroid/content/Intent;)Z

    return-void
.end method

.method public final broadcastDeviceScanned(Landroid/content/Context;Landroid/bluetooth/BluetoothDevice;Lau/gov/health/covidsafe/streetpass/ConnectablePeripheral;)V
    .locals 2

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "device"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "connectableBleDevice"

    invoke-static {p3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 176
    new-instance v0, Landroid/content/Intent;

    const-string v1, "au.gov.health.covidsafe.ACTION_DEVICE_SCANNED"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 177
    check-cast p2, Landroid/os/Parcelable;

    const-string v1, "android.bluetooth.device.extra.DEVICE"

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 178
    check-cast p3, Landroid/os/Parcelable;

    const-string p2, "au.gov.health.covidsafe.CONNECTION_DATA"

    invoke-virtual {v0, p2, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 179
    invoke-static {p1}, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->getInstance(Landroid/content/Context;)Landroidx/localbroadcastmanager/content/LocalBroadcastManager;

    move-result-object p1

    invoke-virtual {p1, v0}, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->sendBroadcast(Landroid/content/Intent;)Z

    return-void
.end method

.method public final broadcastStatusReceived(Landroid/content/Context;Lau/gov/health/covidsafe/status/Status;)V
    .locals 2

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "statusRecord"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 196
    new-instance v0, Landroid/content/Intent;

    const-string v1, "au.gov.health.covidsafe.ACTION_RECEIVED_STATUS"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 197
    check-cast p2, Landroid/os/Parcelable;

    const-string v1, "au.gov.health.covidsafe.STATUS"

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 198
    invoke-static {p1}, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->getInstance(Landroid/content/Context;)Landroidx/localbroadcastmanager/content/LocalBroadcastManager;

    move-result-object p1

    invoke-virtual {p1, v0}, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->sendBroadcast(Landroid/content/Intent;)Z

    return-void
.end method

.method public final broadcastStreetPassReceived(Landroid/content/Context;Lau/gov/health/covidsafe/streetpass/ConnectionRecord;)V
    .locals 2

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "streetpass"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 190
    new-instance v0, Landroid/content/Intent;

    const-string v1, "au.gov.health.covidsafe.ACTION_RECEIVED_STREETPASS"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 191
    check-cast p2, Landroid/os/Parcelable;

    const-string v1, "au.gov.health.covidsafe.STREET_PASS"

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 192
    invoke-static {p1}, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->getInstance(Landroid/content/Context;)Landroidx/localbroadcastmanager/content/LocalBroadcastManager;

    move-result-object p1

    invoke-virtual {p1, v0}, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->sendBroadcast(Landroid/content/Intent;)Z

    return-void
.end method

.method public final canHandleIntent(Landroid/content/Intent;Landroid/content/pm/PackageManager;)Z
    .locals 1

    const-string v0, "batteryExemptionIntent"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v0, 0x0

    if-eqz p2, :cond_0

    .line 46
    invoke-virtual {p1, p2}, Landroid/content/Intent;->resolveActivity(Landroid/content/pm/PackageManager;)Landroid/content/ComponentName;

    move-result-object p1

    if-eqz p1, :cond_0

    const/4 v0, 0x1

    :cond_0
    return v0
.end method

.method public final cancelBMUpdateCheck(Landroid/content/Context;)V
    .locals 3

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 106
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;

    invoke-direct {v0, p1, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 109
    sget-object v1, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->ACTION_UPDATE_BM:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

    invoke-virtual {v1}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->getIndex()I

    move-result v1

    const-string v2, "au.gov.health.covidsafe_CMD"

    .line 107
    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 112
    sget-object v1, Lau/gov/health/covidsafe/scheduler/Scheduler;->INSTANCE:Lau/gov/health/covidsafe/scheduler/Scheduler;

    const/16 v2, 0xb

    invoke-virtual {v1, v2, p1, v0}, Lau/gov/health/covidsafe/scheduler/Scheduler;->cancelServiceIntent(ILandroid/content/Context;Landroid/content/Intent;)V

    return-void
.end method

.method public final cancelNextAdvertise(Landroid/content/Context;)V
    .locals 3

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 136
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;

    invoke-direct {v0, p1, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 139
    sget-object v1, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->ACTION_ADVERTISE:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

    invoke-virtual {v1}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->getIndex()I

    move-result v1

    const-string v2, "au.gov.health.covidsafe_CMD"

    .line 137
    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 141
    sget-object v1, Lau/gov/health/covidsafe/scheduler/Scheduler;->INSTANCE:Lau/gov/health/covidsafe/scheduler/Scheduler;

    const/16 v2, 0x8

    invoke-virtual {v1, v2, p1, v0}, Lau/gov/health/covidsafe/scheduler/Scheduler;->cancelServiceIntent(ILandroid/content/Context;Landroid/content/Intent;)V

    return-void
.end method

.method public final cancelNextScan(Landroid/content/Context;)V
    .locals 3

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 127
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;

    invoke-direct {v0, p1, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 130
    sget-object v1, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->ACTION_SCAN:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

    invoke-virtual {v1}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->getIndex()I

    move-result v1

    const-string v2, "au.gov.health.covidsafe_CMD"

    .line 128
    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 132
    sget-object v1, Lau/gov/health/covidsafe/scheduler/Scheduler;->INSTANCE:Lau/gov/health/covidsafe/scheduler/Scheduler;

    const/4 v2, 0x7

    invoke-virtual {v1, v2, p1, v0}, Lau/gov/health/covidsafe/scheduler/Scheduler;->cancelServiceIntent(ILandroid/content/Context;Landroid/content/Intent;)V

    return-void
.end method

.method public final getBatteryOptimizerExemptionIntent(Ljava/lang/String;)Landroid/content/Intent;
    .locals 3

    const-string v0, "packageName"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 38
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    const-string v1, "android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS"

    .line 39
    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 40
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "package:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-static {p1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object p1

    invoke-virtual {v0, p1}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    return-object v0
.end method

.method public final getDate(J)Ljava/lang/String;
    .locals 3

    .line 54
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v1, "dd/MM/yyyy HH:mm:ss.SSS"

    invoke-direct {v0, v1}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    .line 57
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v1

    const-string v2, "calendar"

    .line 58
    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v1, p1, p2}, Ljava/util/Calendar;->setTimeInMillis(J)V

    .line 59
    invoke-virtual {v1}, Ljava/util/Calendar;->getTime()Ljava/util/Date;

    move-result-object p1

    invoke-virtual {v0, p1}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object p1

    const-string p2, "formatter.format(calendar.time)"

    invoke-static {p1, p2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    return-object p1
.end method

.method public final getRequiredPermissions()[Ljava/lang/String;
    .locals 1

    const-string v0, "android.permission.ACCESS_FINE_LOCATION"

    .line 34
    filled-new-array {v0}, [Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final isBluetoothAvailable()Z
    .locals 2

    .line 208
    invoke-static {}, Landroid/bluetooth/BluetoothAdapter;->getDefaultAdapter()Landroid/bluetooth/BluetoothAdapter;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 210
    invoke-virtual {v0}, Landroid/bluetooth/BluetoothAdapter;->isEnabled()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothAdapter;->getState()I

    move-result v0

    const/16 v1, 0xc

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public final needToUpdate(Landroid/content/Context;)Z
    .locals 7

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 230
    sget-object v0, Lau/gov/health/covidsafe/Preference;->INSTANCE:Lau/gov/health/covidsafe/Preference;

    invoke-virtual {v0, p1}, Lau/gov/health/covidsafe/Preference;->getNextFetchTimeInMillis(Landroid/content/Context;)J

    move-result-wide v0

    .line 232
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    cmp-long p1, v2, v0

    if-ltz p1, :cond_0

    const/4 p1, 0x1

    goto :goto_0

    :cond_0
    const/4 p1, 0x0

    .line 235
    :goto_0
    sget-object v4, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Need to update BM? "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    const-string v0, " vs "

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    const-string v0, ": "

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "Utils"

    invoke-virtual {v4, v1, v0}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    return p1
.end method

.method public final retrieveBroadcastMessage(Landroid/content/Context;)Ljava/lang/String;
    .locals 3

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 220
    new-instance v0, Ljava/io/File;

    invoke-virtual {p1}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    move-result-object p1

    const-string v1, "packet"

    invoke-direct {v0, p1, v1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 221
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result p1

    const/4 v1, 0x0

    if-eqz p1, :cond_0

    const/4 p1, 0x1

    .line 222
    invoke-static {v0, v1, p1, v1}, Lkotlin/io/FilesKt;->readText$default(Ljava/io/File;Ljava/nio/charset/Charset;ILjava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    .line 223
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "fetched broadcastmessage from file:  "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Utils"

    invoke-virtual {v0, v2, v1}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->d(Ljava/lang/String;Ljava/lang/String;)V

    return-object p1

    :cond_0
    return-object v1
.end method

.method public final scheduleBMUpdateCheck(Landroid/content/Context;J)V
    .locals 7

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 89
    invoke-virtual {p0, p1}, Lau/gov/health/covidsafe/Utils;->cancelBMUpdateCheck(Landroid/content/Context;)V

    .line 91
    new-instance v4, Landroid/content/Intent;

    const-class v0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;

    invoke-direct {v4, p1, v0}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 94
    sget-object v0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->ACTION_UPDATE_BM:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

    invoke-virtual {v0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->getIndex()I

    move-result v0

    const-string v1, "au.gov.health.covidsafe_CMD"

    .line 92
    invoke-virtual {v4, v1, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 97
    sget-object v1, Lau/gov/health/covidsafe/scheduler/Scheduler;->INSTANCE:Lau/gov/health/covidsafe/scheduler/Scheduler;

    const/16 v2, 0xb

    move-object v3, p1

    move-wide v5, p2

    invoke-virtual/range {v1 .. v6}, Lau/gov/health/covidsafe/scheduler/Scheduler;->scheduleServiceIntent(ILandroid/content/Context;Landroid/content/Intent;J)V

    return-void
.end method

.method public final scheduleNextHealthCheck(Landroid/content/Context;J)V
    .locals 7

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 146
    invoke-direct {p0, p1}, Lau/gov/health/covidsafe/Utils;->cancelNextHealthCheck(Landroid/content/Context;)V

    .line 148
    new-instance v4, Landroid/content/Intent;

    const-class v0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;

    invoke-direct {v4, p1, v0}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 151
    sget-object v0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->ACTION_SELF_CHECK:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

    invoke-virtual {v0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->getIndex()I

    move-result v0

    const-string v1, "au.gov.health.covidsafe_CMD"

    .line 149
    invoke-virtual {v4, v1, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 154
    sget-object v1, Lau/gov/health/covidsafe/scheduler/Scheduler;->INSTANCE:Lau/gov/health/covidsafe/scheduler/Scheduler;

    const/16 v2, 0x9

    move-object v3, p1

    move-wide v5, p2

    invoke-virtual/range {v1 .. v6}, Lau/gov/health/covidsafe/scheduler/Scheduler;->scheduleServiceIntent(ILandroid/content/Context;Landroid/content/Intent;J)V

    return-void
.end method

.method public final scheduleStartMonitoringService(Landroid/content/Context;J)V
    .locals 7

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 73
    new-instance v4, Landroid/content/Intent;

    const-class v0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;

    invoke-direct {v4, p1, v0}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 76
    sget-object v0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->ACTION_START:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

    invoke-virtual {v0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->getIndex()I

    move-result v0

    const-string v1, "au.gov.health.covidsafe_CMD"

    .line 74
    invoke-virtual {v4, v1, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 79
    sget-object v1, Lau/gov/health/covidsafe/scheduler/Scheduler;->INSTANCE:Lau/gov/health/covidsafe/scheduler/Scheduler;

    const/4 v2, 0x6

    move-object v3, p1

    move-wide v5, p2

    invoke-virtual/range {v1 .. v6}, Lau/gov/health/covidsafe/scheduler/Scheduler;->scheduleServiceIntent(ILandroid/content/Context;Landroid/content/Intent;J)V

    return-void
.end method

.method public final startBluetoothMonitoringService(Landroid/content/Context;)V
    .locals 3

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 63
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;

    invoke-direct {v0, p1, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 66
    sget-object v1, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->ACTION_START:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

    invoke-virtual {v1}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->getIndex()I

    move-result v1

    const-string v2, "au.gov.health.covidsafe_CMD"

    .line 64
    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 69
    invoke-virtual {p1, v0}, Landroid/content/Context;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    return-void
.end method

.method public final stopBluetoothMonitoringService(Landroid/content/Context;)V
    .locals 3

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 116
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;

    invoke-direct {v0, p1, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 119
    sget-object v1, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->ACTION_STOP:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

    invoke-virtual {v1}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->getIndex()I

    move-result v1

    const-string v2, "au.gov.health.covidsafe_CMD"

    .line 117
    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 121
    invoke-virtual {p0, p1}, Lau/gov/health/covidsafe/Utils;->cancelNextScan(Landroid/content/Context;)V

    .line 122
    invoke-direct {p0, p1}, Lau/gov/health/covidsafe/Utils;->cancelNextHealthCheck(Landroid/content/Context;)V

    .line 123
    invoke-virtual {p1, v0}, Landroid/content/Context;->stopService(Landroid/content/Intent;)Z

    return-void
.end method

.method public final storeBroadcastMessage(Landroid/content/Context;Ljava/lang/String;)V
    .locals 4

    const-string v0, "packet"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 214
    sget-object v1, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    const-string v2, "Utils"

    const-string v3, "Storing packet into internal storage..."

    invoke-virtual {v1, v2, v3}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 215
    new-instance v1, Ljava/io/File;

    const/4 v2, 0x0

    if-eqz p1, :cond_0

    invoke-virtual {p1}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    move-result-object p1

    goto :goto_0

    :cond_0
    move-object p1, v2

    :goto_0
    invoke-direct {v1, p1, v0}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    const/4 p1, 0x2

    .line 216
    invoke-static {v1, p2, v2, p1, v2}, Lkotlin/io/FilesKt;->writeText$default(Ljava/io/File;Ljava/lang/String;Ljava/nio/charset/Charset;ILjava/lang/Object;)V

    return-void
.end method
