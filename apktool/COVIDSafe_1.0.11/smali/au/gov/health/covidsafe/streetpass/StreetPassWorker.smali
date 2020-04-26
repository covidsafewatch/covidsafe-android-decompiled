.class public final Lau/gov/health/covidsafe/streetpass/StreetPassWorker;
.super Ljava/lang/Object;
.source "StreetPassWorker.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;,
        Lau/gov/health/covidsafe/streetpass/StreetPassWorker$DeviceProcessedReceiver;,
        Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassWorkReceiver;
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nStreetPassWorker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreetPassWorker.kt\nau/gov/health/covidsafe/streetpass/StreetPassWorker\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,723:1\n1556#2,3:724\n1853#2,3:727\n706#2:730\n783#2,2:731\n*E\n*S KotlinDebug\n*F\n+ 1 StreetPassWorker.kt\nau/gov/health/covidsafe/streetpass/StreetPassWorker\n*L\n162#1,3:724\n168#1,3:727\n261#1:730\n261#1,2:731\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008\u0007\u0018\u00002\u00020\u0001:\u0003012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0011J\u0006\u0010%\u001a\u00020&J\u000e\u0010\'\u001a\u00020&2\u0006\u0010$\u001a\u00020\u0011J\u0010\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020#2\u0008\u0010,\u001a\u0004\u0018\u00010\u0006J\u0008\u0010-\u001a\u00020&H\u0002J\u0006\u0010.\u001a\u00020&J\u0006\u0010/\u001a\u00020&R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00060\u0013R\u00020\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\u0017\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u00060!R\u00020\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00063"
    }
    d2 = {
        "Lau/gov/health/covidsafe/streetpass/StreetPassWorker;",
        "",
        "context",
        "Landroid/content/Context;",
        "(Landroid/content/Context;)V",
        "TAG",
        "",
        "blacklist",
        "",
        "Lau/gov/health/covidsafe/streetpass/BlacklistEntry;",
        "blacklistHandler",
        "Landroid/os/Handler;",
        "bluetoothManager",
        "Landroid/bluetooth/BluetoothManager;",
        "getContext",
        "()Landroid/content/Context;",
        "currentPendingConnection",
        "Lau/gov/health/covidsafe/streetpass/Work;",
        "deviceProcessedReceiver",
        "Lau/gov/health/covidsafe/streetpass/StreetPassWorker$DeviceProcessedReceiver;",
        "localBroadcastManager",
        "Landroidx/localbroadcastmanager/content/LocalBroadcastManager;",
        "onWorkTimeoutListener",
        "Lau/gov/health/covidsafe/streetpass/Work$OnWorkTimeoutListener;",
        "getOnWorkTimeoutListener",
        "()Lau/gov/health/covidsafe/streetpass/Work$OnWorkTimeoutListener;",
        "queueHandler",
        "serviceUUID",
        "Ljava/util/UUID;",
        "timeoutHandler",
        "workQueue",
        "Ljava/util/concurrent/PriorityBlockingQueue;",
        "workReceiver",
        "Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassWorkReceiver;",
        "addWork",
        "",
        "work",
        "doWork",
        "",
        "finishWork",
        "getConnectionStatus",
        "device",
        "Landroid/bluetooth/BluetoothDevice;",
        "isCurrentlyWorkedOn",
        "address",
        "prepare",
        "terminateConnections",
        "unregisterReceivers",
        "DeviceProcessedReceiver",
        "StreetPassGattCallback",
        "StreetPassWorkReceiver",
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

.field private final blacklist:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lau/gov/health/covidsafe/streetpass/BlacklistEntry;",
            ">;"
        }
    .end annotation
.end field

.field private blacklistHandler:Landroid/os/Handler;

.field private final bluetoothManager:Landroid/bluetooth/BluetoothManager;

.field private final context:Landroid/content/Context;

.field private currentPendingConnection:Lau/gov/health/covidsafe/streetpass/Work;

.field private final deviceProcessedReceiver:Lau/gov/health/covidsafe/streetpass/StreetPassWorker$DeviceProcessedReceiver;

.field private localBroadcastManager:Landroidx/localbroadcastmanager/content/LocalBroadcastManager;

.field private final onWorkTimeoutListener:Lau/gov/health/covidsafe/streetpass/Work$OnWorkTimeoutListener;

.field private queueHandler:Landroid/os/Handler;

.field private final serviceUUID:Ljava/util/UUID;

.field private timeoutHandler:Landroid/os/Handler;

.field private final workQueue:Ljava/util/concurrent/PriorityBlockingQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/PriorityBlockingQueue<",
            "Lau/gov/health/covidsafe/streetpass/Work;",
            ">;"
        }
    .end annotation
.end field

.field private final workReceiver:Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassWorkReceiver;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->context:Landroid/content/Context;

    .line 24
    new-instance p1, Ljava/util/concurrent/PriorityBlockingQueue;

    invoke-direct {p1}, Ljava/util/concurrent/PriorityBlockingQueue;-><init>()V

    iput-object p1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->workQueue:Ljava/util/concurrent/PriorityBlockingQueue;

    .line 25
    new-instance p1, Ljava/util/ArrayList;

    invoke-direct {p1}, Ljava/util/ArrayList;-><init>()V

    check-cast p1, Ljava/util/List;

    invoke-static {p1}, Ljava/util/Collections;->synchronizedList(Ljava/util/List;)Ljava/util/List;

    move-result-object p1

    const-string v0, "Collections.synchronizedList(ArrayList())"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    iput-object p1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->blacklist:Ljava/util/List;

    .line 27
    new-instance p1, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassWorkReceiver;

    invoke-direct {p1, p0}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassWorkReceiver;-><init>(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)V

    iput-object p1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->workReceiver:Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassWorkReceiver;

    .line 28
    new-instance p1, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$DeviceProcessedReceiver;

    invoke-direct {p1, p0}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$DeviceProcessedReceiver;-><init>(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)V

    iput-object p1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->deviceProcessedReceiver:Lau/gov/health/covidsafe/streetpass/StreetPassWorker$DeviceProcessedReceiver;

    const-string p1, "B82AB3FC-1595-4F6A-80F0-FE094CC218F9"

    .line 29
    invoke-static {p1}, Ljava/util/UUID;->fromString(Ljava/lang/String;)Ljava/util/UUID;

    move-result-object p1

    const-string v0, "UUID.fromString(BuildConfig.BLE_SSID)"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    iput-object p1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->serviceUUID:Ljava/util/UUID;

    const-string p1, "StreetPassWorker"

    .line 30
    iput-object p1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->TAG:Ljava/lang/String;

    .line 33
    iget-object p1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->context:Landroid/content/Context;

    const-string v0, "bluetooth"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p1

    if-eqz p1, :cond_0

    check-cast p1, Landroid/bluetooth/BluetoothManager;

    iput-object p1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->bluetoothManager:Landroid/bluetooth/BluetoothManager;

    .line 40
    iget-object p1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->context:Landroid/content/Context;

    invoke-static {p1}, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->getInstance(Landroid/content/Context;)Landroidx/localbroadcastmanager/content/LocalBroadcastManager;

    move-result-object p1

    const-string v0, "LocalBroadcastManager.getInstance(context)"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    iput-object p1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->localBroadcastManager:Landroidx/localbroadcastmanager/content/LocalBroadcastManager;

    .line 42
    new-instance p1, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$onWorkTimeoutListener$1;

    invoke-direct {p1, p0}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$onWorkTimeoutListener$1;-><init>(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)V

    check-cast p1, Lau/gov/health/covidsafe/streetpass/Work$OnWorkTimeoutListener;

    iput-object p1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->onWorkTimeoutListener:Lau/gov/health/covidsafe/streetpass/Work$OnWorkTimeoutListener;

    .line 132
    invoke-direct {p0}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->prepare()V

    return-void

    .line 33
    :cond_0
    new-instance p1, Lkotlin/TypeCastException;

    const-string v0, "null cannot be cast to non-null type android.bluetooth.BluetoothManager"

    invoke-direct {p1, v0}, Lkotlin/TypeCastException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public static final synthetic access$getBlacklist$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Ljava/util/List;
    .locals 0

    .line 22
    iget-object p0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->blacklist:Ljava/util/List;

    return-object p0
.end method

.method public static final synthetic access$getBlacklistHandler$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Landroid/os/Handler;
    .locals 1

    .line 22
    iget-object p0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->blacklistHandler:Landroid/os/Handler;

    if-nez p0, :cond_0

    const-string v0, "blacklistHandler"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    :cond_0
    return-object p0
.end method

.method public static final synthetic access$getCurrentPendingConnection$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Lau/gov/health/covidsafe/streetpass/Work;
    .locals 0

    .line 22
    iget-object p0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->currentPendingConnection:Lau/gov/health/covidsafe/streetpass/Work;

    return-object p0
.end method

.method public static final synthetic access$getServiceUUID$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Ljava/util/UUID;
    .locals 0

    .line 22
    iget-object p0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->serviceUUID:Ljava/util/UUID;

    return-object p0
.end method

.method public static final synthetic access$getTAG$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Ljava/lang/String;
    .locals 0

    .line 22
    iget-object p0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->TAG:Ljava/lang/String;

    return-object p0
.end method

.method public static final synthetic access$getTimeoutHandler$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Landroid/os/Handler;
    .locals 1

    .line 22
    iget-object p0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->timeoutHandler:Landroid/os/Handler;

    if-nez p0, :cond_0

    const-string v0, "timeoutHandler"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    :cond_0
    return-object p0
.end method

.method public static final synthetic access$getWorkQueue$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Ljava/util/concurrent/PriorityBlockingQueue;
    .locals 0

    .line 22
    iget-object p0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->workQueue:Ljava/util/concurrent/PriorityBlockingQueue;

    return-object p0
.end method

.method public static final synthetic access$setBlacklistHandler$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;Landroid/os/Handler;)V
    .locals 0

    .line 22
    iput-object p1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->blacklistHandler:Landroid/os/Handler;

    return-void
.end method

.method public static final synthetic access$setCurrentPendingConnection$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;Lau/gov/health/covidsafe/streetpass/Work;)V
    .locals 0

    .line 22
    iput-object p1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->currentPendingConnection:Lau/gov/health/covidsafe/streetpass/Work;

    return-void
.end method

.method public static final synthetic access$setTimeoutHandler$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;Landroid/os/Handler;)V
    .locals 0

    .line 22
    iput-object p1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->timeoutHandler:Landroid/os/Handler;

    return-void
.end method

.method private final getConnectionStatus(Landroid/bluetooth/BluetoothDevice;)Z
    .locals 4

    .line 359
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->bluetoothManager:Landroid/bluetooth/BluetoothManager;

    const/4 v1, 0x1

    new-array v1, v1, [I

    const/4 v2, 0x0

    const/4 v3, 0x2

    aput v3, v1, v2

    const/4 v2, 0x7

    invoke-virtual {v0, v2, v1}, Landroid/bluetooth/BluetoothManager;->getDevicesMatchingConnectionStates(I[I)Ljava/util/List;

    move-result-object v0

    .line 363
    invoke-interface {v0, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result p1

    return p1
.end method

.method private final prepare()V
    .locals 3

    .line 136
    new-instance v0, Landroid/content/IntentFilter;

    const-string v1, "au.gov.health.covidsafe.ACTION_DEVICE_SCANNED"

    invoke-direct {v0, v1}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    .line 137
    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->localBroadcastManager:Landroidx/localbroadcastmanager/content/LocalBroadcastManager;

    iget-object v2, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->workReceiver:Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassWorkReceiver;

    check-cast v2, Landroid/content/BroadcastReceiver;

    invoke-virtual {v1, v2, v0}, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)V

    .line 139
    new-instance v0, Landroid/content/IntentFilter;

    const-string v1, "au.gov.health.covidsafe.ACTION_DEVICE_PROCESSED"

    invoke-direct {v0, v1}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    .line 140
    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->localBroadcastManager:Landroidx/localbroadcastmanager/content/LocalBroadcastManager;

    iget-object v2, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->deviceProcessedReceiver:Lau/gov/health/covidsafe/streetpass/StreetPassWorker$DeviceProcessedReceiver;

    check-cast v2, Landroid/content/BroadcastReceiver;

    invoke-virtual {v1, v2, v0}, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)V

    .line 142
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->timeoutHandler:Landroid/os/Handler;

    .line 143
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->queueHandler:Landroid/os/Handler;

    .line 144
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->blacklistHandler:Landroid/os/Handler;

    return-void
.end method


# virtual methods
.method public final addWork(Lau/gov/health/covidsafe/streetpass/Work;)Z
    .locals 6

    const-string v0, "work"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 155
    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v0

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->isCurrentlyWorkedOn(Ljava/lang/String;)Z

    move-result v0

    const/4 v1, 0x0

    if-eqz v0, :cond_0

    .line 156
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v2, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object p1

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p1, " is being worked on, not adding to queue"

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v0, v2, p1}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    return v1

    .line 162
    :cond_0
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->blacklist:Ljava/util/List;

    check-cast v0, Ljava/lang/Iterable;

    .line 724
    instance-of v2, v0, Ljava/util/Collection;

    const/4 v3, 0x1

    if-eqz v2, :cond_2

    move-object v2, v0

    check-cast v2, Ljava/util/Collection;

    invoke-interface {v2}, Ljava/util/Collection;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_2

    :cond_1
    move v0, v1

    goto :goto_0

    .line 725
    :cond_2
    invoke-interface {v0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_3
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lau/gov/health/covidsafe/streetpass/BlacklistEntry;

    .line 162
    invoke-virtual {v2}, Lau/gov/health/covidsafe/streetpass/BlacklistEntry;->getUniqueIdentifier()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v4

    invoke-virtual {v4}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v4

    invoke-static {v2, v4}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    move v0, v3

    :goto_0
    if-eqz v0, :cond_4

    .line 163
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v2, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object p1

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p1, " is in blacklist, not adding to queue"

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v0, v2, p1}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    return v1

    .line 168
    :cond_4
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->workQueue:Ljava/util/concurrent/PriorityBlockingQueue;

    check-cast v0, Ljava/lang/Iterable;

    .line 727
    instance-of v2, v0, Ljava/util/Collection;

    if-eqz v2, :cond_6

    move-object v2, v0

    check-cast v2, Ljava/util/Collection;

    invoke-interface {v2}, Ljava/util/Collection;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_6

    :cond_5
    move v0, v3

    goto :goto_1

    .line 728
    :cond_6
    invoke-interface {v0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_7
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_5

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lau/gov/health/covidsafe/streetpass/Work;

    .line 168
    invoke-virtual {v2}, Lau/gov/health/covidsafe/streetpass/Work;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v2

    invoke-virtual {v2}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v4

    invoke-virtual {v4}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v4

    invoke-static {v2, v4}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_7

    move v0, v1

    :goto_1
    if-eqz v0, :cond_9

    .line 169
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->workQueue:Ljava/util/concurrent/PriorityBlockingQueue;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/PriorityBlockingQueue;->offer(Ljava/lang/Object;)Z

    .line 170
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->queueHandler:Landroid/os/Handler;

    if-nez v0, :cond_8

    const-string v1, "queueHandler"

    invoke-static {v1}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    :cond_8
    new-instance v1, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$addWork$3;

    invoke-direct {v1, p0, p1}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$addWork$3;-><init>(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;Lau/gov/health/covidsafe/streetpass/Work;)V

    check-cast v1, Ljava/lang/Runnable;

    const-wide/16 v4, 0x1b58

    invoke-virtual {v0, v1, v4, v5}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 179
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Added to work queue: "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object p1

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v0, v1, p1}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    return v3

    .line 186
    :cond_9
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v2, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v4

    invoke-virtual {v4}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v4, " is already in work queue"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 188
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->workQueue:Ljava/util/concurrent/PriorityBlockingQueue;

    check-cast v0, Ljava/lang/Iterable;

    invoke-interface {v0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_a
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_b

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    move-object v3, v2

    check-cast v3, Lau/gov/health/covidsafe/streetpass/Work;

    invoke-virtual {v3}, Lau/gov/health/covidsafe/streetpass/Work;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v3

    invoke-virtual {v3}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v4

    invoke-virtual {v4}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_a

    goto :goto_2

    :cond_b
    const/4 v2, 0x0

    :goto_2
    check-cast v2, Lau/gov/health/covidsafe/streetpass/Work;

    .line 189
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->workQueue:Ljava/util/concurrent/PriorityBlockingQueue;

    invoke-virtual {v0, v2}, Ljava/util/concurrent/PriorityBlockingQueue;->remove(Ljava/lang/Object;)Z

    move-result v0

    .line 190
    iget-object v2, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->workQueue:Ljava/util/concurrent/PriorityBlockingQueue;

    invoke-virtual {v2, p1}, Ljava/util/concurrent/PriorityBlockingQueue;->offer(Ljava/lang/Object;)Z

    move-result p1

    .line 192
    sget-object v2, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v3, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Queue entry updated - removed: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    const-string v0, ", added: "

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v2, v3, p1}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    return v1
.end method

.method public final doWork()V
    .locals 15

    const-string v0, "Moving on to next task"

    .line 200
    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->currentPendingConnection:Lau/gov/health/covidsafe/streetpass/Work;

    const/4 v2, 0x0

    const/4 v3, 0x1

    const/4 v4, 0x0

    if-eqz v1, :cond_b

    .line 201
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 202
    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->TAG:Ljava/lang/String;

    .line 203
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Already trying to connect to: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v6, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->currentPendingConnection:Lau/gov/health/covidsafe/streetpass/Work;

    if-eqz v6, :cond_0

    invoke-virtual {v6}, Lau/gov/health/covidsafe/streetpass/Work;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v6

    if-eqz v6, :cond_0

    invoke-virtual {v6}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v6

    goto :goto_0

    :cond_0
    move-object v6, v4

    :goto_0
    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 201
    invoke-virtual {v0, v1, v5}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 210
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iget-object v5, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->currentPendingConnection:Lau/gov/health/covidsafe/streetpass/Work;

    if-eqz v5, :cond_1

    invoke-virtual {v5}, Lau/gov/health/covidsafe/streetpass/Work;->getTimeout()J

    move-result-wide v5

    goto :goto_1

    :cond_1
    const-wide/16 v5, 0x0

    :goto_1
    cmp-long v0, v0, v5

    if-lez v0, :cond_2

    goto :goto_2

    :cond_2
    move v3, v2

    .line 211
    :goto_2
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->currentPendingConnection:Lau/gov/health/covidsafe/streetpass/Work;

    if-eqz v0, :cond_3

    invoke-virtual {v0}, Lau/gov/health/covidsafe/streetpass/Work;->getFinished()Z

    move-result v0

    goto :goto_3

    :cond_3
    move v0, v2

    :goto_3
    if-nez v0, :cond_4

    if-eqz v3, :cond_a

    .line 213
    :cond_4
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 214
    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->TAG:Ljava/lang/String;

    .line 215
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Handling erroneous current work for "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v6, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->currentPendingConnection:Lau/gov/health/covidsafe/streetpass/Work;

    if-eqz v6, :cond_5

    invoke-virtual {v6}, Lau/gov/health/covidsafe/streetpass/Work;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v6

    if-eqz v6, :cond_5

    invoke-virtual {v6}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v6

    goto :goto_4

    :cond_5
    move-object v6, v4

    :goto_4
    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v6, " : - finished: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v6, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->currentPendingConnection:Lau/gov/health/covidsafe/streetpass/Work;

    if-eqz v6, :cond_6

    invoke-virtual {v6}, Lau/gov/health/covidsafe/streetpass/Work;->getFinished()Z

    move-result v2

    .line 216
    :cond_6
    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    const-string v2, ", timedout: "

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 213
    invoke-virtual {v0, v1, v2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 219
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->currentPendingConnection:Lau/gov/health/covidsafe/streetpass/Work;

    if-eqz v0, :cond_9

    .line 220
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->bluetoothManager:Landroid/bluetooth/BluetoothManager;

    const/4 v1, 0x7

    invoke-virtual {v0, v1}, Landroid/bluetooth/BluetoothManager;->getConnectedDevices(I)Ljava/util/List;

    move-result-object v0

    .line 221
    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->currentPendingConnection:Lau/gov/health/covidsafe/streetpass/Work;

    if-eqz v1, :cond_7

    invoke-virtual {v1}, Lau/gov/health/covidsafe/streetpass/Work;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v1

    goto :goto_5

    :cond_7
    move-object v1, v4

    .line 220
    :goto_5
    invoke-interface {v0, v1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_a

    .line 224
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 225
    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->TAG:Ljava/lang/String;

    .line 226
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Disconnecting dangling connection to "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v3, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->currentPendingConnection:Lau/gov/health/covidsafe/streetpass/Work;

    if-eqz v3, :cond_8

    invoke-virtual {v3}, Lau/gov/health/covidsafe/streetpass/Work;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v3

    if-eqz v3, :cond_8

    invoke-virtual {v3}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v4

    :cond_8
    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 224
    invoke-virtual {v0, v1, v2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 228
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->currentPendingConnection:Lau/gov/health/covidsafe/streetpass/Work;

    if-eqz v0, :cond_a

    invoke-virtual {v0}, Lau/gov/health/covidsafe/streetpass/Work;->getGatt()Landroid/bluetooth/BluetoothGatt;

    move-result-object v0

    if-eqz v0, :cond_a

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothGatt;->disconnect()V

    goto :goto_6

    .line 231
    :cond_9
    invoke-virtual {p0}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->doWork()V

    :cond_a
    :goto_6
    return-void

    .line 238
    :cond_b
    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->workQueue:Ljava/util/concurrent/PriorityBlockingQueue;

    invoke-virtual {v1}, Ljava/util/concurrent/PriorityBlockingQueue;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_c

    .line 239
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->TAG:Ljava/lang/String;

    const-string v2, "Queue empty. Nothing to do."

    invoke-virtual {v0, v1, v2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    return-void

    .line 243
    :cond_c
    sget-object v1, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v5, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Queue size: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v7, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->workQueue:Ljava/util/concurrent/PriorityBlockingQueue;

    invoke-virtual {v7}, Ljava/util/concurrent/PriorityBlockingQueue;->size()I

    move-result v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v1, v5, v6}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 245
    move-object v1, v4

    check-cast v1, Lau/gov/health/covidsafe/streetpass/Work;

    .line 246
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    :goto_7
    move-object v7, v1

    :cond_d
    if-nez v7, :cond_e

    .line 248
    iget-object v8, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->workQueue:Ljava/util/concurrent/PriorityBlockingQueue;

    check-cast v8, Ljava/util/Collection;

    invoke-interface {v8}, Ljava/util/Collection;->isEmpty()Z

    move-result v8

    xor-int/2addr v8, v3

    if-eqz v8, :cond_e

    .line 249
    iget-object v7, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->workQueue:Ljava/util/concurrent/PriorityBlockingQueue;

    invoke-virtual {v7}, Ljava/util/concurrent/PriorityBlockingQueue;->poll()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lau/gov/health/covidsafe/streetpass/Work;

    if-eqz v7, :cond_d

    .line 251
    invoke-virtual {v7}, Lau/gov/health/covidsafe/streetpass/Work;->getTimeStamp()J

    move-result-wide v8

    sub-long v8, v5, v8

    const-wide/16 v10, 0x1b58

    cmp-long v8, v8, v10

    if-lez v8, :cond_d

    .line 252
    sget-object v8, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 253
    iget-object v9, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->TAG:Ljava/lang/String;

    .line 254
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "Work request for "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v7}, Lau/gov/health/covidsafe/streetpass/Work;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v7

    invoke-virtual {v7}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v10, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v7, " too old. Not doing"

    invoke-virtual {v10, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .line 252
    invoke-virtual {v8, v9, v7}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_7

    :cond_e
    if-eqz v7, :cond_17

    .line 263
    invoke-virtual {v7}, Lau/gov/health/covidsafe/streetpass/Work;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v5

    .line 265
    iget-object v6, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->blacklist:Ljava/util/List;

    check-cast v6, Ljava/lang/Iterable;

    .line 730
    new-instance v8, Ljava/util/ArrayList;

    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    check-cast v8, Ljava/util/Collection;

    .line 731
    invoke-interface {v6}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :cond_f
    :goto_8
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_10

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v9

    move-object v10, v9

    check-cast v10, Lau/gov/health/covidsafe/streetpass/BlacklistEntry;

    .line 265
    invoke-virtual {v10}, Lau/gov/health/covidsafe/streetpass/BlacklistEntry;->getUniqueIdentifier()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v11

    invoke-static {v10, v11}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_f

    invoke-interface {v8, v9}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    goto :goto_8

    .line 732
    :cond_10
    check-cast v8, Ljava/util/List;

    check-cast v8, Ljava/util/Collection;

    .line 265
    invoke-interface {v8}, Ljava/util/Collection;->isEmpty()Z

    move-result v6

    xor-int/2addr v6, v3

    if-eqz v6, :cond_11

    .line 266
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Already worked on "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v3, ". Skip."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 267
    invoke-virtual {p0}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->doWork()V

    return-void

    .line 273
    :cond_11
    invoke-direct {p0, v5}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->getConnectionStatus(Landroid/bluetooth/BluetoothDevice;)Z

    move-result v6

    .line 274
    sget-object v8, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v9, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->TAG:Ljava/lang/String;

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "Already connected to "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v11, " : "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v10, v6}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v8, v9, v10}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    if-eqz v6, :cond_12

    .line 279
    invoke-virtual {v7}, Lau/gov/health/covidsafe/streetpass/Work;->getChecklist()Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;

    move-result-object v0

    invoke-virtual {v0}, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->getSkipped()Lau/gov/health/covidsafe/streetpass/Work$Check;

    move-result-object v0

    invoke-virtual {v0, v3}, Lau/gov/health/covidsafe/streetpass/Work$Check;->setStatus(Z)V

    .line 280
    invoke-virtual {v7}, Lau/gov/health/covidsafe/streetpass/Work;->getChecklist()Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;

    move-result-object v0

    invoke-virtual {v0}, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->getSkipped()Lau/gov/health/covidsafe/streetpass/Work$Check;

    move-result-object v0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    invoke-virtual {v0, v1, v2}, Lau/gov/health/covidsafe/streetpass/Work$Check;->setTimePerformed(J)V

    .line 282
    invoke-virtual {p0, v7}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->finishWork(Lau/gov/health/covidsafe/streetpass/Work;)V

    goto/16 :goto_9

    :cond_12
    if-eqz v7, :cond_16

    .line 291
    new-instance v6, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;

    invoke-direct {v6, p0, v7}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;-><init>(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;Lau/gov/health/covidsafe/streetpass/Work;)V

    .line 292
    sget-object v8, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 293
    iget-object v9, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->TAG:Ljava/lang/String;

    .line 294
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "Starting work - connecting to device: "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v11, " @ "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v7}, Lau/gov/health/covidsafe/streetpass/Work;->getConnectable()Lau/gov/health/covidsafe/streetpass/ConnectablePeripheral;

    move-result-object v11

    invoke-virtual {v11}, Lau/gov/health/covidsafe/streetpass/ConnectablePeripheral;->getRssi()I

    move-result v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const/16 v11, 0x20

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v11

    invoke-virtual {v7}, Lau/gov/health/covidsafe/streetpass/Work;->getTimeStamp()J

    move-result-wide v13

    sub-long/2addr v11, v13

    invoke-virtual {v10, v11, v12}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    const-string v11, "ms ago"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    .line 292
    invoke-virtual {v8, v9, v10}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 296
    iput-object v7, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->currentPendingConnection:Lau/gov/health/covidsafe/streetpass/Work;

    .line 299
    :try_start_0
    invoke-virtual {v7}, Lau/gov/health/covidsafe/streetpass/Work;->getChecklist()Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;

    move-result-object v8

    invoke-virtual {v8}, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->getStarted()Lau/gov/health/covidsafe/streetpass/Work$Check;

    move-result-object v8

    invoke-virtual {v8, v3}, Lau/gov/health/covidsafe/streetpass/Work$Check;->setStatus(Z)V

    .line 300
    invoke-virtual {v7}, Lau/gov/health/covidsafe/streetpass/Work;->getChecklist()Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;

    move-result-object v3

    invoke-virtual {v3}, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->getStarted()Lau/gov/health/covidsafe/streetpass/Work$Check;

    move-result-object v3

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v8

    invoke-virtual {v3, v8, v9}, Lau/gov/health/covidsafe/streetpass/Work$Check;->setTimePerformed(J)V

    .line 302
    iget-object v3, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->context:Landroid/content/Context;

    invoke-virtual {v7, v3, v6}, Lau/gov/health/covidsafe/streetpass/Work;->startWork(Landroid/content/Context;Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;)V

    .line 304
    invoke-virtual {v7}, Lau/gov/health/covidsafe/streetpass/Work;->getGatt()Landroid/bluetooth/BluetoothGatt;

    move-result-object v3

    if-eqz v3, :cond_13

    invoke-virtual {v3}, Landroid/bluetooth/BluetoothGatt;->connect()Z

    move-result v2

    :cond_13
    if-nez v2, :cond_14

    .line 307
    sget-object v2, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 308
    iget-object v3, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->TAG:Ljava/lang/String;

    .line 309
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "not connecting to "

    invoke-virtual {v6, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v7}, Lau/gov/health/covidsafe/streetpass/Work;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v7

    invoke-virtual {v7}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v7, "??"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 307
    invoke-virtual {v2, v3, v6}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 313
    sget-object v2, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v3, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->TAG:Ljava/lang/String;

    invoke-virtual {v2, v3, v0}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 314
    check-cast v4, Lau/gov/health/covidsafe/streetpass/Work;

    iput-object v4, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->currentPendingConnection:Lau/gov/health/covidsafe/streetpass/Work;

    .line 315
    invoke-virtual {p0}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->doWork()V

    return-void

    .line 319
    :cond_14
    sget-object v2, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 320
    iget-object v3, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->TAG:Ljava/lang/String;

    .line 321
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Connection to "

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v7}, Lau/gov/health/covidsafe/streetpass/Work;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v6

    invoke-virtual {v6}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v6, " attempt in progress"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 319
    invoke-virtual {v2, v3, v4}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 325
    iget-object v2, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->timeoutHandler:Landroid/os/Handler;

    if-nez v2, :cond_15

    const-string v3, "timeoutHandler"

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    .line 326
    :cond_15
    invoke-virtual {v7}, Lau/gov/health/covidsafe/streetpass/Work;->getTimeoutRunnable()Ljava/lang/Runnable;

    move-result-object v3

    const-wide/16 v8, 0x1770

    .line 325
    invoke-virtual {v2, v3, v8, v9}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 330
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    add-long/2addr v2, v8

    invoke-virtual {v7, v2, v3}, Lau/gov/health/covidsafe/streetpass/Work;->setTimeout(J)V

    .line 332
    sget-object v2, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v3, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Timeout scheduled for "

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v7}, Lau/gov/health/covidsafe/streetpass/Work;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v6

    invoke-virtual {v6}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_9

    :catchall_0
    move-exception v2

    .line 334
    sget-object v3, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 335
    iget-object v4, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->TAG:Ljava/lang/String;

    .line 336
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Unexpected error while attempting to connect to "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v6, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v5, ": "

    invoke-virtual {v6, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/Throwable;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 334
    invoke-virtual {v3, v4, v2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 338
    sget-object v2, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v3, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->TAG:Ljava/lang/String;

    invoke-virtual {v2, v3, v0}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 339
    iput-object v1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->currentPendingConnection:Lau/gov/health/covidsafe/streetpass/Work;

    .line 340
    invoke-virtual {p0}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->doWork()V

    return-void

    .line 345
    :cond_16
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->TAG:Ljava/lang/String;

    const-string v2, "Work not started - missing Work Object"

    invoke-virtual {v0, v1, v2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->e(Ljava/lang/String;Ljava/lang/String;)V

    :cond_17
    :goto_9
    if-nez v7, :cond_18

    .line 352
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->TAG:Ljava/lang/String;

    const-string v2, "No outstanding work"

    invoke-virtual {v0, v1, v2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    :cond_18
    return-void
.end method

.method public final finishWork(Lau/gov/health/covidsafe/streetpass/Work;)V
    .locals 8

    const-string v0, "work"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 368
    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getFinished()Z

    move-result v0

    const-string v1, "Work on "

    if-eqz v0, :cond_0

    .line 369
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 370
    iget-object v2, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->TAG:Ljava/lang/String;

    .line 371
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object p1

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p1, " already finished and closed"

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    .line 369
    invoke-virtual {v0, v2, p1}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    return-void

    .line 376
    :cond_0
    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->isCriticalsCompleted()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 377
    sget-object v0, Lau/gov/health/covidsafe/Utils;->INSTANCE:Lau/gov/health/covidsafe/Utils;

    iget-object v2, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->context:Landroid/content/Context;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v3

    invoke-virtual {v3}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v3

    const-string v4, "work.device.address"

    invoke-static {v3, v4}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v0, v2, v3}, Lau/gov/health/covidsafe/Utils;->broadcastDeviceProcessed(Landroid/content/Context;Ljava/lang/String;)V

    .line 380
    :cond_1
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 381
    iget-object v2, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->TAG:Ljava/lang/String;

    .line 382
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v4

    invoke-virtual {v4}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v4, " stopped in: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getChecklist()Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;

    move-result-object v4

    invoke-virtual {v4}, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->getDisconnected()Lau/gov/health/covidsafe/streetpass/Work$Check;

    move-result-object v4

    invoke-virtual {v4}, Lau/gov/health/covidsafe/streetpass/Work$Check;->getTimePerformed()J

    move-result-wide v4

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getChecklist()Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;

    move-result-object v6

    invoke-virtual {v6}, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->getStarted()Lau/gov/health/covidsafe/streetpass/Work$Check;

    move-result-object v6

    invoke-virtual {v6}, Lau/gov/health/covidsafe/streetpass/Work$Check;->getTimePerformed()J

    move-result-wide v6

    sub-long/2addr v4, v6

    invoke-virtual {v3, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 380
    invoke-virtual {v0, v2, v3}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 385
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 386
    iget-object v2, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->TAG:Ljava/lang/String;

    .line 387
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v1

    invoke-virtual {v1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, " completed?: "

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->isCriticalsCompleted()Z

    move-result v1

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    const-string v1, ". Connected in: "

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getChecklist()Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;

    move-result-object v1

    invoke-virtual {v1}, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->getConnected()Lau/gov/health/covidsafe/streetpass/Work$Check;

    move-result-object v1

    invoke-virtual {v1}, Lau/gov/health/covidsafe/streetpass/Work$Check;->getTimePerformed()J

    move-result-wide v4

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getChecklist()Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;

    move-result-object v1

    invoke-virtual {v1}, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->getStarted()Lau/gov/health/covidsafe/streetpass/Work$Check;

    move-result-object v1

    invoke-virtual {v1}, Lau/gov/health/covidsafe/streetpass/Work$Check;->getTimePerformed()J

    move-result-wide v6

    sub-long/2addr v4, v6

    invoke-virtual {v3, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    const-string v1, ". connection lasted for: "

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getChecklist()Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;

    move-result-object v1

    invoke-virtual {v1}, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->getDisconnected()Lau/gov/health/covidsafe/streetpass/Work$Check;

    move-result-object v1

    invoke-virtual {v1}, Lau/gov/health/covidsafe/streetpass/Work$Check;->getTimePerformed()J

    move-result-wide v4

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getChecklist()Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;

    move-result-object v1

    invoke-virtual {v1}, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->getConnected()Lau/gov/health/covidsafe/streetpass/Work$Check;

    move-result-object v1

    invoke-virtual {v1}, Lau/gov/health/covidsafe/streetpass/Work$Check;->getTimePerformed()J

    move-result-wide v6

    sub-long/2addr v4, v6

    invoke-virtual {v3, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    const-string v1, ". Status: "

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getChecklist()Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;

    move-result-object v1

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 385
    invoke-virtual {v0, v2, v1}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 390
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->timeoutHandler:Landroid/os/Handler;

    if-nez v0, :cond_2

    const-string v1, "timeoutHandler"

    invoke-static {v1}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    :cond_2
    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getTimeoutRunnable()Ljava/lang/Runnable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 391
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Timeout removed for "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/Work;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v3

    invoke-virtual {v3}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v0, 0x1

    .line 393
    invoke-virtual {p1, v0}, Lau/gov/health/covidsafe/streetpass/Work;->setFinished(Z)V

    .line 394
    invoke-virtual {p0}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->doWork()V

    return-void
.end method

.method public final getContext()Landroid/content/Context;
    .locals 1

    .line 22
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->context:Landroid/content/Context;

    return-object v0
.end method

.method public final getOnWorkTimeoutListener()Lau/gov/health/covidsafe/streetpass/Work$OnWorkTimeoutListener;
    .locals 1

    .line 42
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->onWorkTimeoutListener:Lau/gov/health/covidsafe/streetpass/Work$OnWorkTimeoutListener;

    return-object v0
.end method

.method public final isCurrentlyWorkedOn(Ljava/lang/String;)Z
    .locals 1

    .line 148
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->currentPendingConnection:Lau/gov/health/covidsafe/streetpass/Work;

    if-eqz v0, :cond_0

    .line 149
    invoke-virtual {v0}, Lau/gov/health/covidsafe/streetpass/Work;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v0

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, p1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p1

    goto :goto_0

    :cond_0
    const/4 p1, 0x0

    :goto_0
    return p1
.end method

.method public final terminateConnections()V
    .locals 3

    .line 640
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->TAG:Ljava/lang/String;

    const-string v2, "Cleaning up worker."

    invoke-virtual {v0, v1, v2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 642
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->currentPendingConnection:Lau/gov/health/covidsafe/streetpass/Work;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lau/gov/health/covidsafe/streetpass/Work;->getGatt()Landroid/bluetooth/BluetoothGatt;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothGatt;->disconnect()V

    :cond_0
    const/4 v0, 0x0

    .line 643
    move-object v1, v0

    check-cast v1, Lau/gov/health/covidsafe/streetpass/Work;

    iput-object v1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->currentPendingConnection:Lau/gov/health/covidsafe/streetpass/Work;

    .line 645
    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->timeoutHandler:Landroid/os/Handler;

    if-nez v1, :cond_1

    const-string v2, "timeoutHandler"

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    :cond_1
    invoke-virtual {v1, v0}, Landroid/os/Handler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    .line 646
    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->queueHandler:Landroid/os/Handler;

    if-nez v1, :cond_2

    const-string v2, "queueHandler"

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    :cond_2
    invoke-virtual {v1, v0}, Landroid/os/Handler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    .line 647
    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->blacklistHandler:Landroid/os/Handler;

    if-nez v1, :cond_3

    const-string v2, "blacklistHandler"

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    :cond_3
    invoke-virtual {v1, v0}, Landroid/os/Handler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    .line 650
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->workQueue:Ljava/util/concurrent/PriorityBlockingQueue;

    invoke-virtual {v0}, Ljava/util/concurrent/PriorityBlockingQueue;->clear()V

    .line 651
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->blacklist:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    return-void
.end method

.method public final unregisterReceivers()V
    .locals 5

    const-string v0, "Unable to close receivers: "

    .line 656
    :try_start_0
    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->localBroadcastManager:Landroidx/localbroadcastmanager/content/LocalBroadcastManager;

    iget-object v2, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->deviceProcessedReceiver:Lau/gov/health/covidsafe/streetpass/StreetPassWorker$DeviceProcessedReceiver;

    check-cast v2, Landroid/content/BroadcastReceiver;

    invoke-virtual {v1, v2}, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v1

    .line 658
    sget-object v2, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v3, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/Throwable;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v3, v1}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 662
    :goto_0
    :try_start_1
    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->localBroadcastManager:Landroidx/localbroadcastmanager/content/LocalBroadcastManager;

    iget-object v2, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->workReceiver:Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassWorkReceiver;

    check-cast v2, Landroid/content/BroadcastReceiver;

    invoke-virtual {v1, v2}, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    goto :goto_1

    :catchall_1
    move-exception v1

    .line 664
    sget-object v2, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v3, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/Throwable;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v3, v0}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->e(Ljava/lang/String;Ljava/lang/String;)V

    :goto_1
    return-void
.end method
