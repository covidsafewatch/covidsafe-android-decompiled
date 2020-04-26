.class public final Lau/gov/health/covidsafe/services/BluetoothMonitoringService;
.super Landroidx/lifecycle/LifecycleService;
.source "BluetoothMonitoringService.kt"

# interfaces
.implements Lkotlinx/coroutines/CoroutineScope;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lau/gov/health/covidsafe/services/BluetoothMonitoringService$BluetoothStatusReceiver;,
        Lau/gov/health/covidsafe/services/BluetoothMonitoringService$StreetPassReceiver;,
        Lau/gov/health/covidsafe/services/BluetoothMonitoringService$StatusReceiver;,
        Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;,
        Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Companion;
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nBluetoothMonitoringService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BluetoothMonitoringService.kt\nau/gov/health/covidsafe/services/BluetoothMonitoringService\n*L\n1#1,671:1\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u00ab\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\n\u0002\u0010\t\n\u0002\u0008\u0007\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0011*\u0001\r\u0008\u0007\u0018\u0000 U2\u00020\u00012\u00020\u0002:\u0005STUVWB\u0005\u00a2\u0006\u0002\u0010\u0003J\u0008\u0010-\u001a\u00020.H\u0002J\u0008\u0010/\u001a\u00020.H\u0002J\u0008\u00100\u001a\u00020.H\u0002J\u0008\u00101\u001a\u00020.H\u0002J\u0008\u00102\u001a\u00020.H\u0002J\u0008\u00103\u001a\u00020.H\u0002J\u0018\u00104\u001a\u0002052\u0006\u00106\u001a\u0002052\u0006\u00107\u001a\u000205H\u0002J\u0008\u00108\u001a\u00020\u0018H\u0002J\u0008\u00109\u001a\u00020\u0018H\u0002J\u0008\u0010:\u001a\u00020.H\u0016J\u0008\u0010;\u001a\u00020.H\u0016J\"\u0010<\u001a\u00020=2\u0008\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020=2\u0006\u0010A\u001a\u00020=H\u0016J\u0008\u0010B\u001a\u00020.H\u0002J\u0008\u0010C\u001a\u00020.H\u0002J\u0008\u0010D\u001a\u00020.H\u0002J\u0010\u0010E\u001a\u00020.2\u0008\u0010F\u001a\u0004\u0018\u00010GJ\u0008\u0010H\u001a\u00020.H\u0002J\u0008\u0010I\u001a\u00020.H\u0002J\u0008\u0010J\u001a\u00020.H\u0002J\u0008\u0010K\u001a\u00020.H\u0002J\u0008\u0010L\u001a\u00020.H\u0002J\u0008\u0010M\u001a\u00020.H\u0002J\u0008\u0010N\u001a\u00020.H\u0002J\u0008\u0010O\u001a\u00020.H\u0002J\u0008\u0010P\u001a\u00020.H\u0002J\u0006\u0010Q\u001a\u00020.J\u0008\u0010R\u001a\u00020.H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0008\u001a\u00060\tR\u00020\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000c\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00020\u001e8\u0002@\u0002X\u0083.\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u00060 R\u00020\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.\u00a2\u0006\u0002\n\u0000R\u0012\u0010#\u001a\u00060$R\u00020\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\'\u001a\u0004\u0018\u00010(X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006X"
    }
    d2 = {
        "Lau/gov/health/covidsafe/services/BluetoothMonitoringService;",
        "Landroidx/lifecycle/LifecycleService;",
        "Lkotlinx/coroutines/CoroutineScope;",
        "()V",
        "advertiser",
        "Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;",
        "awsClient",
        "Lau/gov/health/covidsafe/networking/service/AwsClient;",
        "bluetoothStatusReceiver",
        "Lau/gov/health/covidsafe/services/BluetoothMonitoringService$BluetoothStatusReceiver;",
        "commandHandler",
        "Lau/gov/health/covidsafe/services/CommandHandler;",
        "connection",
        "au/gov/health/covidsafe/services/BluetoothMonitoringService$connection$1",
        "Lau/gov/health/covidsafe/services/BluetoothMonitoringService$connection$1;",
        "coroutineContext",
        "Lkotlin/coroutines/CoroutineContext;",
        "getCoroutineContext",
        "()Lkotlin/coroutines/CoroutineContext;",
        "job",
        "Lkotlinx/coroutines/Job;",
        "localBroadcastManager",
        "Landroidx/localbroadcastmanager/content/LocalBroadcastManager;",
        "mBound",
        "",
        "mNotificationManager",
        "Landroid/app/NotificationManager;",
        "mService",
        "Lau/gov/health/covidsafe/services/SensorMonitoringService;",
        "serviceUUID",
        "",
        "statusReceiver",
        "Lau/gov/health/covidsafe/services/BluetoothMonitoringService$StatusReceiver;",
        "statusRecordStorage",
        "Lau/gov/health/covidsafe/status/persistence/StatusRecordStorage;",
        "streetPassReceiver",
        "Lau/gov/health/covidsafe/services/BluetoothMonitoringService$StreetPassReceiver;",
        "streetPassRecordStorage",
        "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordStorage;",
        "streetPassScanner",
        "Lau/gov/health/covidsafe/streetpass/StreetPassScanner;",
        "streetPassServer",
        "Lau/gov/health/covidsafe/streetpass/StreetPassServer;",
        "worker",
        "Lau/gov/health/covidsafe/streetpass/StreetPassWorker;",
        "actionAdvertise",
        "",
        "actionHealthCheck",
        "actionScan",
        "actionStart",
        "actionStop",
        "actionUpdateBm",
        "calcPhaseShift",
        "",
        "min",
        "max",
        "hasLocationPermissions",
        "isBluetoothEnabled",
        "onCreate",
        "onDestroy",
        "onStartCommand",
        "",
        "intent",
        "Landroid/content/Intent;",
        "flags",
        "startId",
        "performHealthCheck",
        "performScanAndScheduleNextScan",
        "registerReceivers",
        "runService",
        "cmd",
        "Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;",
        "setup",
        "setupAdvertiser",
        "setupAdvertisingCycles",
        "setupCycles",
        "setupNotifications",
        "setupScanCycles",
        "setupScanner",
        "setupService",
        "startScan",
        "teardown",
        "unregisterReceivers",
        "BluetoothStatusReceiver",
        "Command",
        "Companion",
        "StatusReceiver",
        "StreetPassReceiver",
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
.field private static final CHANNEL_ID:Ljava/lang/String; = "COVIDSafe Updates"

.field public static final CHANNEL_SERVICE:Ljava/lang/String; = "Foreground Service"

.field public static final COMMAND_KEY:Ljava/lang/String; = "au.gov.health.covidsafe_CMD"

.field public static final Companion:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Companion;

.field public static final DAILY_UPLOAD_NOTIFICATION_CODE:I = 0xd

.field private static final NOTIFICATION_ID:I = 0xbc5fb

.field public static final PENDING_ACTIVITY:I = 0x5

.field public static final PENDING_ADVERTISE_REQ_CODE:I = 0x8

.field public static final PENDING_BM_UPDATE:I = 0xb

.field public static final PENDING_HEALTH_CHECK_CODE:I = 0x9

.field public static final PENDING_PRIVACY_CLEANER_CODE:I = 0xc

.field public static final PENDING_SCAN_REQ_CODE:I = 0x7

.field public static final PENDING_START:I = 0x6

.field public static final PENDING_WIZARD_REQ_CODE:I = 0xa

.field private static final TAG:Ljava/lang/String; = "BTMService"

.field public static final advertisingDuration:J = 0x2bf20L

.field public static final advertisingGap:J = 0x1388L

.field public static final blacklistDuration:J = 0x186a0L

.field public static final bmCheckInterval:J = 0x83d60L

.field private static broadcastMessage:Ljava/lang/String; = null

.field public static final connectionTimeout:J = 0x1770L

.field public static final healthCheckInterval:J = 0xdbba0L

.field public static final maxQueueTime:J = 0x1b58L

.field public static final maxScanInterval:J = 0xa7f8L

.field public static final minScanInterval:J = 0x8ca0L

.field public static final scanDuration:J = 0x1f40L


# instance fields
.field private advertiser:Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;

.field private final awsClient:Lau/gov/health/covidsafe/networking/service/AwsClient;

.field private final bluetoothStatusReceiver:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$BluetoothStatusReceiver;

.field private commandHandler:Lau/gov/health/covidsafe/services/CommandHandler;

.field private final connection:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$connection$1;

.field private job:Lkotlinx/coroutines/Job;

.field private localBroadcastManager:Landroidx/localbroadcastmanager/content/LocalBroadcastManager;

.field private mBound:Z

.field private mNotificationManager:Landroid/app/NotificationManager;

.field private mService:Lau/gov/health/covidsafe/services/SensorMonitoringService;

.field private serviceUUID:Ljava/lang/String;

.field private final statusReceiver:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$StatusReceiver;

.field private statusRecordStorage:Lau/gov/health/covidsafe/status/persistence/StatusRecordStorage;

.field private final streetPassReceiver:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$StreetPassReceiver;

.field private streetPassRecordStorage:Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordStorage;

.field private streetPassScanner:Lau/gov/health/covidsafe/streetpass/StreetPassScanner;

.field private streetPassServer:Lau/gov/health/covidsafe/streetpass/StreetPassServer;

.field private worker:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Companion;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V

    sput-object v0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->Companion:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Companion;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .line 44
    invoke-direct {p0}, Landroidx/lifecycle/LifecycleService;-><init>()V

    .line 57
    new-instance v0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$StreetPassReceiver;

    invoke-direct {v0, p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$StreetPassReceiver;-><init>(Lau/gov/health/covidsafe/services/BluetoothMonitoringService;)V

    iput-object v0, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->streetPassReceiver:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$StreetPassReceiver;

    .line 58
    new-instance v0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$StatusReceiver;

    invoke-direct {v0, p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$StatusReceiver;-><init>(Lau/gov/health/covidsafe/services/BluetoothMonitoringService;)V

    iput-object v0, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->statusReceiver:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$StatusReceiver;

    .line 59
    new-instance v0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$BluetoothStatusReceiver;

    invoke-direct {v0, p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$BluetoothStatusReceiver;-><init>(Lau/gov/health/covidsafe/services/BluetoothMonitoringService;)V

    iput-object v0, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->bluetoothStatusReceiver:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$BluetoothStatusReceiver;

    const/4 v0, 0x0

    const/4 v1, 0x1

    .line 64
    invoke-static {v0, v1, v0}, Lkotlinx/coroutines/JobKt;->Job$default(Lkotlinx/coroutines/Job;ILjava/lang/Object;)Lkotlinx/coroutines/CompletableJob;

    move-result-object v0

    check-cast v0, Lkotlinx/coroutines/Job;

    iput-object v0, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->job:Lkotlinx/coroutines/Job;

    .line 76
    sget-object v0, Lau/gov/health/covidsafe/factory/NetworkFactory;->Companion:Lau/gov/health/covidsafe/factory/NetworkFactory$Companion;

    invoke-virtual {v0}, Lau/gov/health/covidsafe/factory/NetworkFactory$Companion;->getAwsClient()Lau/gov/health/covidsafe/networking/service/AwsClient;

    move-result-object v0

    iput-object v0, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->awsClient:Lau/gov/health/covidsafe/networking/service/AwsClient;

    .line 79
    new-instance v0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$connection$1;

    invoke-direct {v0, p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$connection$1;-><init>(Lau/gov/health/covidsafe/services/BluetoothMonitoringService;)V

    iput-object v0, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->connection:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$connection$1;

    return-void
.end method

.method public static final synthetic access$getBroadcastMessage$cp()Ljava/lang/String;
    .locals 1

    .line 44
    sget-object v0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->broadcastMessage:Ljava/lang/String;

    return-object v0
.end method

.method public static final synthetic access$getMBound$p(Lau/gov/health/covidsafe/services/BluetoothMonitoringService;)Z
    .locals 0

    .line 44
    iget-boolean p0, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->mBound:Z

    return p0
.end method

.method public static final synthetic access$getMService$p(Lau/gov/health/covidsafe/services/BluetoothMonitoringService;)Lau/gov/health/covidsafe/services/SensorMonitoringService;
    .locals 1

    .line 44
    iget-object p0, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->mService:Lau/gov/health/covidsafe/services/SensorMonitoringService;

    if-nez p0, :cond_0

    const-string v0, "mService"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    :cond_0
    return-object p0
.end method

.method public static final synthetic access$getStatusRecordStorage$p(Lau/gov/health/covidsafe/services/BluetoothMonitoringService;)Lau/gov/health/covidsafe/status/persistence/StatusRecordStorage;
    .locals 1

    .line 44
    iget-object p0, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->statusRecordStorage:Lau/gov/health/covidsafe/status/persistence/StatusRecordStorage;

    if-nez p0, :cond_0

    const-string v0, "statusRecordStorage"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    :cond_0
    return-object p0
.end method

.method public static final synthetic access$getStreetPassRecordStorage$p(Lau/gov/health/covidsafe/services/BluetoothMonitoringService;)Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordStorage;
    .locals 1

    .line 44
    iget-object p0, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->streetPassRecordStorage:Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordStorage;

    if-nez p0, :cond_0

    const-string v0, "streetPassRecordStorage"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    :cond_0
    return-object p0
.end method

.method public static final synthetic access$performScanAndScheduleNextScan(Lau/gov/health/covidsafe/services/BluetoothMonitoringService;)V
    .locals 0

    .line 44
    invoke-direct {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->performScanAndScheduleNextScan()V

    return-void
.end method

.method public static final synthetic access$setBroadcastMessage$cp(Ljava/lang/String;)V
    .locals 0

    .line 44
    sput-object p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->broadcastMessage:Ljava/lang/String;

    return-void
.end method

.method public static final synthetic access$setMBound$p(Lau/gov/health/covidsafe/services/BluetoothMonitoringService;Z)V
    .locals 0

    .line 44
    iput-boolean p1, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->mBound:Z

    return-void
.end method

.method public static final synthetic access$setMService$p(Lau/gov/health/covidsafe/services/BluetoothMonitoringService;Lau/gov/health/covidsafe/services/SensorMonitoringService;)V
    .locals 0

    .line 44
    iput-object p1, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->mService:Lau/gov/health/covidsafe/services/SensorMonitoringService;

    return-void
.end method

.method public static final synthetic access$setStatusRecordStorage$p(Lau/gov/health/covidsafe/services/BluetoothMonitoringService;Lau/gov/health/covidsafe/status/persistence/StatusRecordStorage;)V
    .locals 0

    .line 44
    iput-object p1, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->statusRecordStorage:Lau/gov/health/covidsafe/status/persistence/StatusRecordStorage;

    return-void
.end method

.method public static final synthetic access$setStreetPassRecordStorage$p(Lau/gov/health/covidsafe/services/BluetoothMonitoringService;Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordStorage;)V
    .locals 0

    .line 44
    iput-object p1, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->streetPassRecordStorage:Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordStorage;

    return-void
.end method

.method public static final synthetic access$setupCycles(Lau/gov/health/covidsafe/services/BluetoothMonitoringService;)V
    .locals 0

    .line 44
    invoke-direct {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->setupCycles()V

    return-void
.end method

.method private final actionAdvertise()V
    .locals 3

    .line 346
    invoke-direct {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->setupAdvertiser()V

    .line 348
    invoke-direct {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->isBluetoothEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 349
    iget-object v0, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->advertiser:Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;

    if-eqz v0, :cond_1

    const-wide/32 v1, 0x2bf20

    invoke-virtual {v0, v1, v2}, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->startAdvertising(J)V

    goto :goto_0

    .line 351
    :cond_0
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    const-string v1, "BTMService"

    const-string v2, "Unable to start advertising, bluetooth is off"

    invoke-virtual {v0, v1, v2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 354
    :cond_1
    :goto_0
    iget-object v0, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->commandHandler:Lau/gov/health/covidsafe/services/CommandHandler;

    if-nez v0, :cond_2

    const-string v1, "commandHandler"

    invoke-static {v1}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    :cond_2
    const-wide/32 v1, 0x2d2a8

    invoke-virtual {v0, v1, v2}, Lau/gov/health/covidsafe/services/CommandHandler;->scheduleNextAdvertise(J)V

    return-void
.end method

.method private final actionHealthCheck()V
    .locals 4

    .line 268
    sget-object v0, Lau/gov/health/covidsafe/Utils;->INSTANCE:Lau/gov/health/covidsafe/Utils;

    invoke-virtual {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "this.applicationContext"

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-wide/32 v2, 0xdbba0

    invoke-virtual {v0, v1, v2, v3}, Lau/gov/health/covidsafe/Utils;->scheduleNextHealthCheck(Landroid/content/Context;J)V

    .line 269
    invoke-direct {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->performHealthCheck()V

    return-void
.end method

.method private final actionScan()V
    .locals 5

    .line 329
    sget-object v0, Lau/gov/health/covidsafe/Preference;->INSTANCE:Lau/gov/health/covidsafe/Preference;

    move-object v1, p0

    check-cast v1, Landroid/content/Context;

    invoke-virtual {v0, v1}, Lau/gov/health/covidsafe/Preference;->isOnBoarded(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Lau/gov/health/covidsafe/Utils;->INSTANCE:Lau/gov/health/covidsafe/Utils;

    invoke-virtual {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    const-string v3, "this.applicationContext"

    invoke-static {v2, v3}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v0, v2}, Lau/gov/health/covidsafe/Utils;->needToUpdate(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    sget-object v0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->broadcastMessage:Ljava/lang/String;

    if-nez v0, :cond_2

    .line 331
    :cond_1
    new-instance v0, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff;

    iget-object v1, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->awsClient:Lau/gov/health/covidsafe/networking/service/AwsClient;

    invoke-virtual {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    const-string v3, "applicationContext"

    invoke-static {v2, v3}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->getLifecycle()Landroidx/lifecycle/Lifecycle;

    move-result-object v3

    const-string v4, "lifecycle"

    invoke-static {v3, v4}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {v0, v1, v2, v3}, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff;-><init>(Lau/gov/health/covidsafe/networking/service/AwsClient;Landroid/content/Context;Landroidx/lifecycle/Lifecycle;)V

    const/4 v1, 0x0

    .line 333
    new-instance v2, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$actionScan$1;

    invoke-direct {v2, p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$actionScan$1;-><init>(Lau/gov/health/covidsafe/services/BluetoothMonitoringService;)V

    check-cast v2, Lkotlin/jvm/functions/Function1;

    .line 337
    sget-object v3, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$actionScan$2;->INSTANCE:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$actionScan$2;

    check-cast v3, Lkotlin/jvm/functions/Function1;

    .line 331
    invoke-virtual {v0, v1, v2, v3}, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff;->invoke(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V

    goto :goto_0

    .line 340
    :cond_2
    sget-object v0, Lau/gov/health/covidsafe/Preference;->INSTANCE:Lau/gov/health/covidsafe/Preference;

    invoke-virtual {v0, v1}, Lau/gov/health/covidsafe/Preference;->isOnBoarded(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 341
    invoke-direct {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->performScanAndScheduleNextScan()V

    :cond_3
    :goto_0
    return-void
.end method

.method private final actionStart()V
    .locals 6

    .line 273
    sget-object v0, Lau/gov/health/covidsafe/Preference;->INSTANCE:Lau/gov/health/covidsafe/Preference;

    move-object v1, p0

    check-cast v1, Landroid/content/Context;

    invoke-virtual {v0, v1}, Lau/gov/health/covidsafe/Preference;->isOnBoarded(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 274
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    const-string v2, "BTMService"

    const-string v3, "Service Starting "

    invoke-virtual {v0, v2, v3}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->d(Ljava/lang/String;Ljava/lang/String;)V

    const v0, 0xbc5fb

    .line 278
    sget-object v2, Lau/gov/health/covidsafe/notifications/NotificationTemplates;->Companion:Lau/gov/health/covidsafe/notifications/NotificationTemplates$Companion;

    .line 279
    invoke-virtual {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    const-string v4, "this.applicationContext"

    invoke-static {v3, v4}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v5, "COVIDSafe Updates"

    .line 278
    invoke-virtual {v2, v3, v5}, Lau/gov/health/covidsafe/notifications/NotificationTemplates$Companion;->getRunningNotification(Landroid/content/Context;Ljava/lang/String;)Landroid/app/Notification;

    move-result-object v2

    .line 276
    invoke-virtual {p0, v0, v2}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->startForeground(ILandroid/app/Notification;)V

    .line 284
    sget-object v0, Lau/gov/health/covidsafe/Preference;->INSTANCE:Lau/gov/health/covidsafe/Preference;

    invoke-virtual {v0, v1}, Lau/gov/health/covidsafe/Preference;->isOnBoarded(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Lau/gov/health/covidsafe/Utils;->INSTANCE:Lau/gov/health/covidsafe/Utils;

    invoke-virtual {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2, v4}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v0, v2}, Lau/gov/health/covidsafe/Utils;->needToUpdate(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    sget-object v0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->broadcastMessage:Ljava/lang/String;

    if-nez v0, :cond_2

    .line 287
    :cond_1
    new-instance v0, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff;

    iget-object v1, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->awsClient:Lau/gov/health/covidsafe/networking/service/AwsClient;

    invoke-virtual {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    const-string v3, "applicationContext"

    invoke-static {v2, v3}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->getLifecycle()Landroidx/lifecycle/Lifecycle;

    move-result-object v3

    const-string v4, "lifecycle"

    invoke-static {v3, v4}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {v0, v1, v2, v3}, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff;-><init>(Lau/gov/health/covidsafe/networking/service/AwsClient;Landroid/content/Context;Landroidx/lifecycle/Lifecycle;)V

    const/4 v1, 0x0

    .line 289
    new-instance v2, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$actionStart$1;

    invoke-direct {v2, p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$actionStart$1;-><init>(Lau/gov/health/covidsafe/services/BluetoothMonitoringService;)V

    check-cast v2, Lkotlin/jvm/functions/Function1;

    .line 293
    sget-object v3, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$actionStart$2;->INSTANCE:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$actionStart$2;

    check-cast v3, Lkotlin/jvm/functions/Function1;

    .line 287
    invoke-virtual {v0, v1, v2, v3}, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff;->invoke(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V

    goto :goto_0

    .line 296
    :cond_2
    sget-object v0, Lau/gov/health/covidsafe/Preference;->INSTANCE:Lau/gov/health/covidsafe/Preference;

    invoke-virtual {v0, v1}, Lau/gov/health/covidsafe/Preference;->isOnBoarded(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 297
    invoke-direct {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->setupCycles()V

    :cond_3
    :goto_0
    return-void
.end method

.method private final actionStop()V
    .locals 3

    const/4 v0, 0x1

    .line 262
    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->stopForeground(Z)V

    .line 263
    invoke-virtual {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->stopSelf()V

    .line 264
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    const-string v1, "BTMService"

    const-string v2, "Service Stopping"

    invoke-virtual {v0, v1, v2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->w(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method private final actionUpdateBm()V
    .locals 5

    .line 304
    sget-object v0, Lau/gov/health/covidsafe/Utils;->INSTANCE:Lau/gov/health/covidsafe/Utils;

    invoke-virtual {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "this.applicationContext"

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-wide/32 v3, 0x83d60

    invoke-virtual {v0, v1, v3, v4}, Lau/gov/health/covidsafe/Utils;->scheduleBMUpdateCheck(Landroid/content/Context;J)V

    .line 306
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    const-string v1, "BTMService"

    const-string v3, "checking need to update BM"

    invoke-virtual {v0, v1, v3}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 307
    sget-object v0, Lau/gov/health/covidsafe/Preference;->INSTANCE:Lau/gov/health/covidsafe/Preference;

    move-object v3, p0

    check-cast v3, Landroid/content/Context;

    invoke-virtual {v0, v3}, Lau/gov/health/covidsafe/Preference;->isOnBoarded(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Lau/gov/health/covidsafe/Utils;->INSTANCE:Lau/gov/health/covidsafe/Utils;

    invoke-virtual {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3, v2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v0, v3}, Lau/gov/health/covidsafe/Utils;->needToUpdate(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    sget-object v0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->broadcastMessage:Ljava/lang/String;

    if-nez v0, :cond_2

    .line 310
    :cond_1
    new-instance v0, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff;

    iget-object v1, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->awsClient:Lau/gov/health/covidsafe/networking/service/AwsClient;

    invoke-virtual {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    const-string v3, "applicationContext"

    invoke-static {v2, v3}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->getLifecycle()Landroidx/lifecycle/Lifecycle;

    move-result-object v3

    const-string v4, "lifecycle"

    invoke-static {v3, v4}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {v0, v1, v2, v3}, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff;-><init>(Lau/gov/health/covidsafe/networking/service/AwsClient;Landroid/content/Context;Landroidx/lifecycle/Lifecycle;)V

    const/4 v1, 0x0

    .line 312
    sget-object v2, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$actionUpdateBm$1;->INSTANCE:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$actionUpdateBm$1;

    check-cast v2, Lkotlin/jvm/functions/Function1;

    .line 315
    sget-object v3, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$actionUpdateBm$2;->INSTANCE:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$actionUpdateBm$2;

    check-cast v3, Lkotlin/jvm/functions/Function1;

    .line 310
    invoke-virtual {v0, v1, v2, v3}, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff;->invoke(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V

    goto :goto_0

    .line 319
    :cond_2
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    const-string v2, "Don\'t need to update bm"

    invoke-virtual {v0, v1, v2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    :goto_0
    return-void
.end method

.method private final calcPhaseShift(JJ)J
    .locals 4

    long-to-double v0, p1

    .line 325
    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v2

    sub-long/2addr p3, p1

    long-to-double p1, p3

    mul-double/2addr v2, p1

    add-double/2addr v0, v2

    double-to-long p1, v0

    return-wide p1
.end method

.method private final hasLocationPermissions()Z
    .locals 3

    .line 159
    sget-object v0, Lau/gov/health/covidsafe/Utils;->INSTANCE:Lau/gov/health/covidsafe/Utils;

    invoke-virtual {v0}, Lau/gov/health/covidsafe/Utils;->getRequiredPermissions()[Ljava/lang/String;

    move-result-object v0

    .line 160
    invoke-virtual {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    array-length v2, v0

    invoke-static {v0, v2}, Ljava/util/Arrays;->copyOf([Ljava/lang/Object;I)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Ljava/lang/String;

    invoke-static {v1, v0}, Lpub/devrel/easypermissions/EasyPermissions;->hasPermissions(Landroid/content/Context;[Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method private final isBluetoothEnabled()Z
    .locals 2

    .line 165
    sget-object v0, Lkotlin/LazyThreadSafetyMode;->NONE:Lkotlin/LazyThreadSafetyMode;

    new-instance v1, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$isBluetoothEnabled$bluetoothAdapter$2;

    invoke-direct {v1, p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$isBluetoothEnabled$bluetoothAdapter$2;-><init>(Lau/gov/health/covidsafe/services/BluetoothMonitoringService;)V

    check-cast v1, Lkotlin/jvm/functions/Function0;

    invoke-static {v0, v1}, Lkotlin/LazyKt;->lazy(Lkotlin/LazyThreadSafetyMode;Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;

    move-result-object v0

    .line 170
    invoke-interface {v0}, Lkotlin/Lazy;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/bluetooth/BluetoothAdapter;

    if-eqz v0, :cond_0

    .line 171
    invoke-virtual {v0}, Landroid/bluetooth/BluetoothAdapter;->isEnabled()Z

    move-result v0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method private final performHealthCheck()V
    .locals 6

    .line 422
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    const-string v1, "BTMService"

    const-string v2, "Performing self diagnosis"

    invoke-virtual {v0, v1, v2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 424
    invoke-direct {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->hasLocationPermissions()Z

    move-result v0

    const v2, 0xbc5fb

    const-string v3, "COVIDSafe Updates"

    const-string v4, "this.applicationContext"

    if-eqz v0, :cond_7

    invoke-direct {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->isBluetoothEnabled()Z

    move-result v0

    if-nez v0, :cond_0

    goto/16 :goto_3

    .line 434
    :cond_0
    sget-object v0, Lau/gov/health/covidsafe/notifications/NotificationTemplates;->Companion:Lau/gov/health/covidsafe/notifications/NotificationTemplates$Companion;

    .line 435
    invoke-virtual {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    invoke-static {v5, v4}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 434
    invoke-virtual {v0, v5, v3}, Lau/gov/health/covidsafe/notifications/NotificationTemplates$Companion;->getRunningNotification(Landroid/content/Context;Ljava/lang/String;)Landroid/app/Notification;

    move-result-object v0

    .line 432
    invoke-virtual {p0, v2, v0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->startForeground(ILandroid/app/Notification;)V

    .line 441
    invoke-direct {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->setupService()V

    .line 443
    iget-object v0, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->commandHandler:Lau/gov/health/covidsafe/services/CommandHandler;

    const-string v2, "commandHandler"

    if-nez v0, :cond_1

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    :cond_1
    invoke-virtual {v0}, Lau/gov/health/covidsafe/services/CommandHandler;->hasScanScheduled()Z

    move-result v0

    if-nez v0, :cond_2

    .line 444
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    const-string v3, "Missing Scan Schedule - rectifying"

    invoke-virtual {v0, v1, v3}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 445
    invoke-direct {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->setupScanCycles()V

    goto :goto_0

    .line 447
    :cond_2
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    const-string v3, "Scan Schedule present"

    invoke-virtual {v0, v1, v3}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 450
    :goto_0
    iget-object v0, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->commandHandler:Lau/gov/health/covidsafe/services/CommandHandler;

    if-nez v0, :cond_3

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    :cond_3
    invoke-virtual {v0}, Lau/gov/health/covidsafe/services/CommandHandler;->hasAdvertiseScheduled()Z

    move-result v0

    if-nez v0, :cond_4

    .line 451
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    const-string v2, "Missing Advertise Schedule - rectifying"

    invoke-virtual {v0, v1, v2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 452
    invoke-direct {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->setupAdvertisingCycles()V

    goto :goto_2

    .line 454
    :cond_4
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 456
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Advertise Schedule present. Should be advertising?:  "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v3, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->advertiser:Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;

    const/4 v4, 0x0

    if-eqz v3, :cond_5

    invoke-virtual {v3}, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->getShouldBeAdvertising()Z

    move-result v3

    goto :goto_1

    :cond_5
    move v3, v4

    .line 457
    :goto_1
    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    const-string v3, ". Is Advertising?: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v3, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->advertiser:Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;

    if-eqz v3, :cond_6

    invoke-virtual {v3}, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->isAdvertising()Z

    move-result v4

    :cond_6
    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 454
    invoke-virtual {v0, v1, v2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->w(Ljava/lang/String;Ljava/lang/String;)V

    :goto_2
    return-void

    .line 425
    :cond_7
    :goto_3
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    const-string v5, "no location permission"

    invoke-virtual {v0, v1, v5}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 427
    sget-object v0, Lau/gov/health/covidsafe/notifications/NotificationTemplates;->Companion:Lau/gov/health/covidsafe/notifications/NotificationTemplates$Companion;

    invoke-virtual {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1, v4}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v0, v1, v3}, Lau/gov/health/covidsafe/notifications/NotificationTemplates$Companion;->lackingThingsNotification(Landroid/content/Context;Ljava/lang/String;)Landroid/app/Notification;

    move-result-object v0

    .line 428
    invoke-virtual {p0, v2, v0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->startForeground(ILandroid/app/Notification;)V

    return-void
.end method

.method private final performScanAndScheduleNextScan()V
    .locals 7

    .line 391
    invoke-direct {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->setupScanner()V

    .line 393
    iget-object v0, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->commandHandler:Lau/gov/health/covidsafe/services/CommandHandler;

    if-nez v0, :cond_0

    const-string v1, "commandHandler"

    invoke-static {v1}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    :cond_0
    const-wide/16 v1, 0x1f40

    const-wide/32 v3, 0x8ca0

    const-wide/32 v5, 0xa7f8

    .line 394
    invoke-direct {p0, v3, v4, v5, v6}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->calcPhaseShift(JJ)J

    move-result-wide v3

    add-long/2addr v3, v1

    .line 393
    invoke-virtual {v0, v3, v4}, Lau/gov/health/covidsafe/services/CommandHandler;->scheduleNextScan(J)V

    .line 400
    invoke-direct {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->startScan()V

    return-void
.end method

.method private final registerReceivers()V
    .locals 4

    .line 481
    new-instance v0, Landroid/content/IntentFilter;

    const-string v1, "au.gov.health.covidsafe.ACTION_RECEIVED_STREETPASS"

    invoke-direct {v0, v1}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    .line 482
    iget-object v1, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->localBroadcastManager:Landroidx/localbroadcastmanager/content/LocalBroadcastManager;

    const-string v2, "localBroadcastManager"

    if-nez v1, :cond_0

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    :cond_0
    iget-object v3, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->streetPassReceiver:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$StreetPassReceiver;

    check-cast v3, Landroid/content/BroadcastReceiver;

    invoke-virtual {v1, v3, v0}, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)V

    .line 484
    new-instance v0, Landroid/content/IntentFilter;

    const-string v1, "au.gov.health.covidsafe.ACTION_RECEIVED_STATUS"

    invoke-direct {v0, v1}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    .line 485
    iget-object v1, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->localBroadcastManager:Landroidx/localbroadcastmanager/content/LocalBroadcastManager;

    if-nez v1, :cond_1

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    :cond_1
    iget-object v2, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->statusReceiver:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$StatusReceiver;

    check-cast v2, Landroid/content/BroadcastReceiver;

    invoke-virtual {v1, v2, v0}, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)V

    .line 487
    new-instance v0, Landroid/content/IntentFilter;

    const-string v1, "android.bluetooth.adapter.action.STATE_CHANGED"

    invoke-direct {v0, v1}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    .line 488
    iget-object v1, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->bluetoothStatusReceiver:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$BluetoothStatusReceiver;

    check-cast v1, Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v1, v0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 490
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    const-string v1, "BTMService"

    const-string v2, "Receivers registered"

    invoke-virtual {v0, v1, v2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method private final setup()V
    .locals 3

    const-string v0, "power"

    .line 100
    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_0

    check-cast v0, Landroid/os/PowerManager;

    .line 102
    sget-object v1, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    invoke-virtual {v1, v0}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->setPowerManager(Landroid/os/PowerManager;)V

    .line 104
    new-instance v0, Lau/gov/health/covidsafe/services/CommandHandler;

    new-instance v1, Ljava/lang/ref/WeakReference;

    invoke-direct {v1, p0}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    invoke-direct {v0, v1}, Lau/gov/health/covidsafe/services/CommandHandler;-><init>(Ljava/lang/ref/WeakReference;)V

    iput-object v0, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->commandHandler:Lau/gov/health/covidsafe/services/CommandHandler;

    .line 106
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    const-string v1, "BTMService"

    const-string v2, "Creating service - BluetoothMonitoringService"

    invoke-virtual {v0, v1, v2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->d(Ljava/lang/String;Ljava/lang/String;)V

    const-string v0, "B82AB3FC-1595-4F6A-80F0-FE094CC218F9"

    .line 107
    iput-object v0, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->serviceUUID:Ljava/lang/String;

    .line 109
    new-instance v0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-virtual {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "this.applicationContext"

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {v0, v1}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->worker:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    .line 111
    invoke-direct {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->unregisterReceivers()V

    .line 112
    invoke-direct {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->registerReceivers()V

    .line 114
    new-instance v0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordStorage;

    invoke-virtual {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {v0, v1}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordStorage;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->streetPassRecordStorage:Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordStorage;

    .line 115
    new-instance v0, Lau/gov/health/covidsafe/status/persistence/StatusRecordStorage;

    invoke-virtual {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {v0, v1}, Lau/gov/health/covidsafe/status/persistence/StatusRecordStorage;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->statusRecordStorage:Lau/gov/health/covidsafe/status/persistence/StatusRecordStorage;

    .line 116
    sget-object v0, Lau/gov/health/covidsafe/receivers/PrivacyCleanerReceiver;->Companion:Lau/gov/health/covidsafe/receivers/PrivacyCleanerReceiver$Companion;

    invoke-virtual {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lau/gov/health/covidsafe/receivers/PrivacyCleanerReceiver$Companion;->startAlarm(Landroid/content/Context;)V

    .line 117
    invoke-direct {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->setupNotifications()V

    .line 118
    sget-object v0, Lau/gov/health/covidsafe/Utils;->INSTANCE:Lau/gov/health/covidsafe/Utils;

    invoke-virtual {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lau/gov/health/covidsafe/Utils;->retrieveBroadcastMessage(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->broadcastMessage:Ljava/lang/String;

    return-void

    .line 100
    :cond_0
    new-instance v0, Lkotlin/TypeCastException;

    const-string v1, "null cannot be cast to non-null type android.os.PowerManager"

    invoke-direct {v0, v1}, Lkotlin/TypeCastException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private final setupAdvertiser()V
    .locals 3

    .line 373
    iget-object v0, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->advertiser:Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    new-instance v0, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;

    iget-object v1, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->serviceUUID:Ljava/lang/String;

    if-nez v1, :cond_1

    const-string v2, "serviceUUID"

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    :cond_1
    invoke-direct {v0, v1}, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;-><init>(Ljava/lang/String;)V

    :goto_0
    iput-object v0, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->advertiser:Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;

    return-void
.end method

.method private final setupAdvertisingCycles()V
    .locals 0

    .line 386
    invoke-direct {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->actionAdvertise()V

    return-void
.end method

.method private final setupCycles()V
    .locals 0

    .line 377
    invoke-direct {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->setupScanCycles()V

    .line 378
    invoke-direct {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->setupAdvertisingCycles()V

    return-void
.end method

.method private final setupNotifications()V
    .locals 6

    const-string v0, "notification"

    .line 139
    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_1

    check-cast v0, Landroid/app/NotificationManager;

    .line 142
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x1a

    if-lt v1, v2, :cond_0

    .line 146
    new-instance v1, Landroid/app/NotificationChannel;

    const-string v2, "Foreground Service"

    check-cast v2, Ljava/lang/CharSequence;

    const/4 v3, 0x2

    const-string v4, "COVIDSafe Updates"

    invoke-direct {v1, v4, v2, v3}, Landroid/app/NotificationChannel;-><init>(Ljava/lang/String;Ljava/lang/CharSequence;I)V

    const/4 v2, 0x0

    .line 147
    invoke-virtual {v1, v2}, Landroid/app/NotificationChannel;->enableLights(Z)V

    const/4 v3, 0x1

    .line 148
    invoke-virtual {v1, v3}, Landroid/app/NotificationChannel;->enableVibration(Z)V

    new-array v3, v3, [J

    const-wide/16 v4, 0x0

    aput-wide v4, v3, v2

    .line 149
    invoke-virtual {v1, v3}, Landroid/app/NotificationChannel;->setVibrationPattern([J)V

    const/4 v3, 0x0

    .line 150
    invoke-virtual {v1, v3, v3}, Landroid/app/NotificationChannel;->setSound(Landroid/net/Uri;Landroid/media/AudioAttributes;)V

    .line 151
    invoke-virtual {v1, v2}, Landroid/app/NotificationChannel;->setShowBadge(Z)V

    .line 154
    invoke-virtual {v0, v1}, Landroid/app/NotificationManager;->createNotificationChannel(Landroid/app/NotificationChannel;)V

    :cond_0
    return-void

    .line 139
    :cond_1
    new-instance v0, Lkotlin/TypeCastException;

    const-string v1, "null cannot be cast to non-null type android.app.NotificationManager"

    invoke-direct {v0, v1}, Lkotlin/TypeCastException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private final setupScanCycles()V
    .locals 0

    .line 382
    invoke-direct {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->actionScan()V

    return-void
.end method

.method private final setupScanner()V
    .locals 5

    .line 365
    iget-object v0, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->streetPassScanner:Lau/gov/health/covidsafe/streetpass/StreetPassScanner;

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    new-instance v0, Lau/gov/health/covidsafe/streetpass/StreetPassScanner;

    .line 366
    move-object v1, p0

    check-cast v1, Landroid/content/Context;

    .line 367
    iget-object v2, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->serviceUUID:Ljava/lang/String;

    if-nez v2, :cond_1

    const-string v3, "serviceUUID"

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    :cond_1
    const-wide/16 v3, 0x1f40

    .line 365
    invoke-direct {v0, v1, v2, v3, v4}, Lau/gov/health/covidsafe/streetpass/StreetPassScanner;-><init>(Landroid/content/Context;Ljava/lang/String;J)V

    :goto_0
    iput-object v0, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->streetPassScanner:Lau/gov/health/covidsafe/streetpass/StreetPassScanner;

    return-void
.end method

.method private final setupService()V
    .locals 4

    .line 359
    iget-object v0, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->streetPassServer:Lau/gov/health/covidsafe/streetpass/StreetPassServer;

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    new-instance v0, Lau/gov/health/covidsafe/streetpass/StreetPassServer;

    invoke-virtual {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "this.applicationContext"

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    iget-object v2, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->serviceUUID:Ljava/lang/String;

    if-nez v2, :cond_1

    const-string v3, "serviceUUID"

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    :cond_1
    invoke-direct {v0, v1, v2}, Lau/gov/health/covidsafe/streetpass/StreetPassServer;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    :goto_0
    iput-object v0, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->streetPassServer:Lau/gov/health/covidsafe/streetpass/StreetPassServer;

    .line 360
    invoke-direct {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->setupScanner()V

    .line 361
    invoke-direct {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->setupAdvertiser()V

    return-void
.end method

.method private final startScan()V
    .locals 3

    .line 406
    invoke-direct {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->isBluetoothEnabled()Z

    move-result v0

    const-string v1, "BTMService"

    if-eqz v0, :cond_1

    .line 408
    iget-object v0, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->streetPassScanner:Lau/gov/health/covidsafe/streetpass/StreetPassScanner;

    if-eqz v0, :cond_2

    .line 409
    invoke-virtual {v0}, Lau/gov/health/covidsafe/streetpass/StreetPassScanner;->isScanning()Z

    move-result v2

    if-nez v2, :cond_0

    .line 410
    invoke-virtual {v0}, Lau/gov/health/covidsafe/streetpass/StreetPassScanner;->startScan()V

    goto :goto_0

    .line 412
    :cond_0
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    const-string v2, "Already scanning!"

    invoke-virtual {v0, v1, v2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 416
    :cond_1
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    const-string v2, "Unable to start scan - bluetooth is off"

    invoke-virtual {v0, v1, v2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->w(Ljava/lang/String;Ljava/lang/String;)V

    :cond_2
    :goto_0
    return-void
.end method

.method private final unregisterReceivers()V
    .locals 4

    const-string v0, "localBroadcastManager"

    const-string v1, "BTMService"

    .line 495
    :try_start_0
    iget-object v2, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->localBroadcastManager:Landroidx/localbroadcastmanager/content/LocalBroadcastManager;

    if-nez v2, :cond_0

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    :cond_0
    iget-object v3, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->streetPassReceiver:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$StreetPassReceiver;

    check-cast v3, Landroid/content/BroadcastReceiver;

    invoke-virtual {v2, v3}, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 497
    :catchall_0
    sget-object v2, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    const-string v3, "streetPassReceiver is not registered?"

    invoke-virtual {v2, v1, v3}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 501
    :goto_0
    :try_start_1
    iget-object v2, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->localBroadcastManager:Landroidx/localbroadcastmanager/content/LocalBroadcastManager;

    if-nez v2, :cond_1

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    :cond_1
    iget-object v0, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->statusReceiver:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$StatusReceiver;

    check-cast v0, Landroid/content/BroadcastReceiver;

    invoke-virtual {v2, v0}, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    goto :goto_1

    .line 503
    :catchall_1
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    const-string v2, "statusReceiver is not registered?"

    invoke-virtual {v0, v1, v2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 507
    :goto_1
    :try_start_2
    iget-object v0, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->bluetoothStatusReceiver:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$BluetoothStatusReceiver;

    check-cast v0, Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    goto :goto_2

    .line 509
    :catchall_2
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    const-string v2, "bluetoothStatusReceiver is not registered?"

    invoke-virtual {v0, v1, v2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->w(Ljava/lang/String;Ljava/lang/String;)V

    :goto_2
    return-void
.end method


# virtual methods
.method public getCoroutineContext()Lkotlin/coroutines/CoroutineContext;
    .locals 2

    .line 67
    invoke-static {}, Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;

    move-result-object v0

    iget-object v1, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->job:Lkotlinx/coroutines/Job;

    check-cast v1, Lkotlin/coroutines/CoroutineContext;

    invoke-virtual {v0, v1}, Lkotlinx/coroutines/MainCoroutineDispatcher;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;

    move-result-object v0

    return-object v0
.end method

.method public onCreate()V
    .locals 2

    .line 94
    invoke-super {p0}, Landroidx/lifecycle/LifecycleService;->onCreate()V

    .line 95
    move-object v0, p0

    check-cast v0, Landroid/content/Context;

    invoke-static {v0}, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->getInstance(Landroid/content/Context;)Landroidx/localbroadcastmanager/content/LocalBroadcastManager;

    move-result-object v0

    const-string v1, "LocalBroadcastManager.getInstance(this)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    iput-object v0, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->localBroadcastManager:Landroidx/localbroadcastmanager/content/LocalBroadcastManager;

    .line 96
    invoke-direct {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->setup()V

    return-void
.end method

.method public onDestroy()V
    .locals 4

    .line 463
    invoke-super {p0}, Landroidx/lifecycle/LifecycleService;->onDestroy()V

    .line 464
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    const-string v1, "BTMService"

    const-string v2, "BluetoothMonitoringService destroyed - tearing down"

    invoke-virtual {v0, v1, v2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 466
    invoke-virtual {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->teardown()V

    .line 467
    invoke-direct {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->unregisterReceivers()V

    .line 469
    iget-object v0, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->worker:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->terminateConnections()V

    .line 470
    :cond_0
    iget-object v0, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->worker:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->unregisterReceivers()V

    .line 472
    :cond_1
    iget-object v0, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->job:Lkotlinx/coroutines/Job;

    const/4 v2, 0x1

    const/4 v3, 0x0

    invoke-static {v0, v3, v2, v3}, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job;Ljava/util/concurrent/CancellationException;ILjava/lang/Object;)V

    .line 474
    iget-object v0, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->connection:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$connection$1;

    check-cast v0, Landroid/content/ServiceConnection;

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->unbindService(Landroid/content/ServiceConnection;)V

    const/4 v0, 0x0

    .line 475
    iput-boolean v0, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->mBound:Z

    .line 477
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    const-string v2, "BluetoothMonitoringService destroyed"

    invoke-virtual {v0, v1, v2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public onStartCommand(Landroid/content/Intent;II)I
    .locals 2

    .line 177
    invoke-super {p0, p1, p2, p3}, Landroidx/lifecycle/LifecycleService;->onStartCommand(Landroid/content/Intent;II)I

    .line 178
    sget-object p2, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    const-string p3, "BTMService"

    const-string v0, "Service onStartCommand"

    invoke-virtual {p2, p3, v0}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 181
    new-instance p2, Landroid/content/Intent;

    invoke-virtual {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    const-class v1, Lau/gov/health/covidsafe/services/SensorMonitoringService;

    invoke-direct {p2, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 182
    iget-object v0, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->connection:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$connection$1;

    check-cast v0, Landroid/content/ServiceConnection;

    const/4 v1, 0x1

    invoke-virtual {p0, p2, v0, v1}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->bindService(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z

    .line 186
    invoke-direct {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->hasLocationPermissions()Z

    move-result p2

    if-eqz p2, :cond_3

    invoke-direct {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->isBluetoothEnabled()Z

    move-result p2

    if-nez p2, :cond_0

    goto :goto_0

    :cond_0
    if-eqz p1, :cond_1

    .line 198
    sget-object p2, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->INVALID:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

    invoke-virtual {p2}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->getIndex()I

    move-result p2

    const-string p3, "au.gov.health.covidsafe_CMD"

    invoke-virtual {p1, p3, p2}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result p1

    .line 199
    sget-object p2, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->Companion:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command$Companion;

    invoke-virtual {p2, p1}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command$Companion;->findByValue(I)Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

    move-result-object p1

    invoke-virtual {p0, p1}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->runService(Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;)V

    return v1

    .line 205
    :cond_1
    sget-object p1, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    const-string p2, "Nothing in intent @ onStartCommand"

    invoke-virtual {p1, p3, p2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 206
    iget-object p1, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->commandHandler:Lau/gov/health/covidsafe/services/CommandHandler;

    if-nez p1, :cond_2

    const-string p2, "commandHandler"

    invoke-static {p2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    :cond_2
    invoke-virtual {p1}, Lau/gov/health/covidsafe/services/CommandHandler;->startBluetoothMonitoringService()V

    return v1

    .line 187
    :cond_3
    :goto_0
    sget-object p1, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 189
    new-instance p2, Ljava/lang/StringBuilder;

    invoke-direct {p2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v0, "location permission: "

    invoke-virtual {p2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-direct {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->hasLocationPermissions()Z

    move-result v0

    invoke-virtual {p2, v0}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    const-string v0, " bluetooth: "

    invoke-virtual {p2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-direct {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->isBluetoothEnabled()Z

    move-result v0

    invoke-virtual {p2, v0}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    .line 187
    invoke-virtual {p1, p3, p2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 192
    sget-object p1, Lau/gov/health/covidsafe/notifications/NotificationTemplates;->Companion:Lau/gov/health/covidsafe/notifications/NotificationTemplates$Companion;

    invoke-virtual {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->getApplicationContext()Landroid/content/Context;

    move-result-object p2

    const-string p3, "this.applicationContext"

    invoke-static {p2, p3}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p3, "COVIDSafe Updates"

    invoke-virtual {p1, p2, p3}, Lau/gov/health/covidsafe/notifications/NotificationTemplates$Companion;->lackingThingsNotification(Landroid/content/Context;Ljava/lang/String;)Landroid/app/Notification;

    move-result-object p1

    const p2, 0xbc5fb

    .line 193
    invoke-virtual {p0, p2, p1}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->startForeground(ILandroid/app/Notification;)V

    return v1
.end method

.method public final runService(Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;)V
    .locals 4

    .line 215
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Command is:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->getString()Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    :cond_0
    const/4 v2, 0x0

    :goto_0
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "BTMService"

    invoke-virtual {v0, v2, v1}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 218
    invoke-direct {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->hasLocationPermissions()Z

    move-result v0

    const-string v1, "this.applicationContext"

    if-eqz v0, :cond_3

    invoke-direct {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->isBluetoothEnabled()Z

    move-result v0

    if-nez v0, :cond_1

    goto :goto_3

    :cond_1
    if-nez p1, :cond_2

    goto :goto_1

    .line 229
    :cond_2
    sget-object v0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$WhenMappings;->$EnumSwitchMapping$0:[I

    invoke-virtual {p1}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->ordinal()I

    move-result v3

    aget v0, v0, v3

    packed-switch v0, :pswitch_data_0

    goto :goto_1

    .line 254
    :pswitch_0
    invoke-direct {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->actionHealthCheck()V

    goto :goto_2

    .line 250
    :pswitch_1
    invoke-direct {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->actionStop()V

    goto :goto_2

    .line 246
    :pswitch_2
    invoke-direct {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->actionUpdateBm()V

    goto :goto_2

    .line 242
    :pswitch_3
    invoke-direct {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->actionAdvertise()V

    goto :goto_2

    .line 238
    :pswitch_4
    invoke-direct {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->actionScan()V

    goto :goto_2

    .line 231
    :pswitch_5
    invoke-direct {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->setupService()V

    .line 232
    invoke-direct {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->actionStart()V

    .line 233
    sget-object p1, Lau/gov/health/covidsafe/Utils;->INSTANCE:Lau/gov/health/covidsafe/Utils;

    invoke-virtual {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-wide/32 v2, 0xdbba0

    invoke-virtual {p1, v0, v2, v3}, Lau/gov/health/covidsafe/Utils;->scheduleNextHealthCheck(Landroid/content/Context;J)V

    .line 234
    sget-object p1, Lau/gov/health/covidsafe/Utils;->INSTANCE:Lau/gov/health/covidsafe/Utils;

    invoke-virtual {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-wide/32 v1, 0x83d60

    invoke-virtual {p1, v0, v1, v2}, Lau/gov/health/covidsafe/Utils;->scheduleBMUpdateCheck(Landroid/content/Context;J)V

    goto :goto_2

    .line 257
    :goto_1
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Invalid command: "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string p1, ". Nothing to do"

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v0, v2, p1}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    :goto_2
    return-void

    .line 219
    :cond_3
    :goto_3
    sget-object p1, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 221
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "location permission: "

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-direct {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->hasLocationPermissions()Z

    move-result v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    const-string v3, " bluetooth: "

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-direct {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->isBluetoothEnabled()Z

    move-result v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 219
    invoke-virtual {p1, v2, v0}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 224
    sget-object p1, Lau/gov/health/covidsafe/notifications/NotificationTemplates;->Companion:Lau/gov/health/covidsafe/notifications/NotificationTemplates$Companion;

    invoke-virtual {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v1, "COVIDSafe Updates"

    invoke-virtual {p1, v0, v1}, Lau/gov/health/covidsafe/notifications/NotificationTemplates$Companion;->lackingThingsNotification(Landroid/content/Context;Ljava/lang/String;)Landroid/app/Notification;

    move-result-object p1

    const v0, 0xbc5fb

    .line 225
    invoke-virtual {p0, v0, p1}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->startForeground(ILandroid/app/Notification;)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public final teardown()V
    .locals 3

    .line 122
    iget-object v0, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->streetPassServer:Lau/gov/health/covidsafe/streetpass/StreetPassServer;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lau/gov/health/covidsafe/streetpass/StreetPassServer;->tearDown()V

    :cond_0
    const/4 v0, 0x0

    .line 123
    move-object v1, v0

    check-cast v1, Lau/gov/health/covidsafe/streetpass/StreetPassServer;

    iput-object v1, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->streetPassServer:Lau/gov/health/covidsafe/streetpass/StreetPassServer;

    .line 125
    iget-object v1, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->streetPassScanner:Lau/gov/health/covidsafe/streetpass/StreetPassScanner;

    if-eqz v1, :cond_1

    invoke-virtual {v1}, Lau/gov/health/covidsafe/streetpass/StreetPassScanner;->stopScan()V

    .line 126
    :cond_1
    move-object v1, v0

    check-cast v1, Lau/gov/health/covidsafe/streetpass/StreetPassScanner;

    iput-object v1, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->streetPassScanner:Lau/gov/health/covidsafe/streetpass/StreetPassScanner;

    .line 128
    iget-object v1, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->commandHandler:Lau/gov/health/covidsafe/services/CommandHandler;

    if-nez v1, :cond_2

    const-string v2, "commandHandler"

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    :cond_2
    invoke-virtual {v1, v0}, Lau/gov/health/covidsafe/services/CommandHandler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    .line 130
    sget-object v0, Lau/gov/health/covidsafe/Utils;->INSTANCE:Lau/gov/health/covidsafe/Utils;

    invoke-virtual {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "this.applicationContext"

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lau/gov/health/covidsafe/Utils;->cancelBMUpdateCheck(Landroid/content/Context;)V

    .line 131
    sget-object v0, Lau/gov/health/covidsafe/Utils;->INSTANCE:Lau/gov/health/covidsafe/Utils;

    invoke-virtual {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lau/gov/health/covidsafe/Utils;->cancelNextScan(Landroid/content/Context;)V

    .line 132
    sget-object v0, Lau/gov/health/covidsafe/Utils;->INSTANCE:Lau/gov/health/covidsafe/Utils;

    invoke-virtual {p0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lau/gov/health/covidsafe/Utils;->cancelNextAdvertise(Landroid/content/Context;)V

    return-void
.end method
