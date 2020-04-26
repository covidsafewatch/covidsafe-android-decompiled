.class public final Lau/gov/health/covidsafe/services/CommandHandler;
.super Landroid/os/Handler;
.source "CommandHandler.kt"


# annotations
.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nCommandHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommandHandler.kt\nau/gov/health/covidsafe/services/CommandHandler\n*L\n1#1,55:1\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u0013\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u0008\u0010\u0008\u001a\u00020\tH\u0002J\u0008\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\u000b\u001a\u00020\t2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\rH\u0016J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0013H\u0002J\u0006\u0010\u0019\u001a\u00020\tR\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\u00a8\u0006\u001a"
    }
    d2 = {
        "Lau/gov/health/covidsafe/services/CommandHandler;",
        "Landroid/os/Handler;",
        "service",
        "Ljava/lang/ref/WeakReference;",
        "Lau/gov/health/covidsafe/services/BluetoothMonitoringService;",
        "(Ljava/lang/ref/WeakReference;)V",
        "getService",
        "()Ljava/lang/ref/WeakReference;",
        "cancelNextAdvertise",
        "",
        "cancelNextScan",
        "handleMessage",
        "msg",
        "Landroid/os/Message;",
        "hasAdvertiseScheduled",
        "",
        "hasScanScheduled",
        "scheduleNextAdvertise",
        "timeInMillis",
        "",
        "scheduleNextScan",
        "sendCommandMsg",
        "cmd",
        "Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;",
        "delay",
        "startBluetoothMonitoringService",
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
.field private final service:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference<",
            "Lau/gov/health/covidsafe/services/BluetoothMonitoringService;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/ref/WeakReference;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/ref/WeakReference<",
            "Lau/gov/health/covidsafe/services/BluetoothMonitoringService;",
            ">;)V"
        }
    .end annotation

    const-string v0, "service"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 7
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    iput-object p1, p0, Lau/gov/health/covidsafe/services/CommandHandler;->service:Ljava/lang/ref/WeakReference;

    return-void
.end method

.method private final cancelNextAdvertise()V
    .locals 1

    .line 49
    sget-object v0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->ACTION_ADVERTISE:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

    invoke-virtual {v0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->getIndex()I

    move-result v0

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/services/CommandHandler;->removeMessages(I)V

    return-void
.end method

.method private final cancelNextScan()V
    .locals 1

    .line 36
    sget-object v0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->ACTION_SCAN:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

    invoke-virtual {v0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->getIndex()I

    move-result v0

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/services/CommandHandler;->removeMessages(I)V

    return-void
.end method

.method private final sendCommandMsg(Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;)V
    .locals 1

    .line 21
    invoke-virtual {p1}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->getIndex()I

    move-result v0

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/services/CommandHandler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v0

    .line 22
    invoke-virtual {p1}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->getIndex()I

    move-result p1

    iput p1, v0, Landroid/os/Message;->arg1:I

    .line 23
    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/services/CommandHandler;->sendMessage(Landroid/os/Message;)Z

    return-void
.end method

.method private final sendCommandMsg(Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;J)V
    .locals 1

    .line 16
    move-object v0, p0

    check-cast v0, Landroid/os/Handler;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->getIndex()I

    move-result p1

    invoke-static {v0, p1}, Landroid/os/Message;->obtain(Landroid/os/Handler;I)Landroid/os/Message;

    move-result-object p1

    .line 17
    invoke-virtual {p0, p1, p2, p3}, Lau/gov/health/covidsafe/services/CommandHandler;->sendMessageDelayed(Landroid/os/Message;J)Z

    return-void
.end method


# virtual methods
.method public final getService()Ljava/lang/ref/WeakReference;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/lang/ref/WeakReference<",
            "Lau/gov/health/covidsafe/services/BluetoothMonitoringService;",
            ">;"
        }
    .end annotation

    .line 7
    iget-object v0, p0, Lau/gov/health/covidsafe/services/CommandHandler;->service:Ljava/lang/ref/WeakReference;

    return-object v0
.end method

.method public handleMessage(Landroid/os/Message;)V
    .locals 2

    if-eqz p1, :cond_0

    .line 10
    iget p1, p1, Landroid/os/Message;->what:I

    .line 11
    iget-object v0, p0, Lau/gov/health/covidsafe/services/CommandHandler;->service:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;

    if-eqz v0, :cond_0

    sget-object v1, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->Companion:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command$Companion;

    invoke-virtual {v1, p1}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command$Companion;->findByValue(I)Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

    move-result-object p1

    invoke-virtual {v0, p1}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->runService(Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;)V

    :cond_0
    return-void
.end method

.method public final hasAdvertiseScheduled()Z
    .locals 1

    .line 53
    sget-object v0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->ACTION_ADVERTISE:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

    invoke-virtual {v0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->getIndex()I

    move-result v0

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/services/CommandHandler;->hasMessages(I)Z

    move-result v0

    return v0
.end method

.method public final hasScanScheduled()Z
    .locals 1

    .line 40
    sget-object v0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->ACTION_SCAN:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

    invoke-virtual {v0}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->getIndex()I

    move-result v0

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/services/CommandHandler;->hasMessages(I)Z

    move-result v0

    return v0
.end method

.method public final scheduleNextAdvertise(J)V
    .locals 1

    .line 44
    invoke-direct {p0}, Lau/gov/health/covidsafe/services/CommandHandler;->cancelNextAdvertise()V

    .line 45
    sget-object v0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->ACTION_ADVERTISE:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

    invoke-direct {p0, v0, p1, p2}, Lau/gov/health/covidsafe/services/CommandHandler;->sendCommandMsg(Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;J)V

    return-void
.end method

.method public final scheduleNextScan(J)V
    .locals 1

    .line 31
    invoke-direct {p0}, Lau/gov/health/covidsafe/services/CommandHandler;->cancelNextScan()V

    .line 32
    sget-object v0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->ACTION_SCAN:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

    invoke-direct {p0, v0, p1, p2}, Lau/gov/health/covidsafe/services/CommandHandler;->sendCommandMsg(Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;J)V

    return-void
.end method

.method public final startBluetoothMonitoringService()V
    .locals 1

    .line 27
    sget-object v0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->ACTION_START:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

    invoke-direct {p0, v0}, Lau/gov/health/covidsafe/services/CommandHandler;->sendCommandMsg(Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;)V

    return-void
.end method
