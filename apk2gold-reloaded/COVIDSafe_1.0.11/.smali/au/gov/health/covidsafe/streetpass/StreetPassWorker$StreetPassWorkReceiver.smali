.class public final Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassWorkReceiver;
.super Landroid/content/BroadcastReceiver;
.source "StreetPassWorker.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lau/gov/health/covidsafe/streetpass/StreetPassWorker;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x11
    name = "StreetPassWorkReceiver"
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nStreetPassWorker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreetPassWorker.kt\nau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassWorkReceiver\n*L\n1#1,723:1\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\u00020\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00082\u0008\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"
    }
    d2 = {
        "Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassWorkReceiver;",
        "Landroid/content/BroadcastReceiver;",
        "(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)V",
        "TAG",
        "",
        "onReceive",
        "",
        "context",
        "Landroid/content/Context;",
        "intent",
        "Landroid/content/Intent;",
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

.field final synthetic this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;


# direct methods
.method public constructor <init>(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .line 686
    iput-object p1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassWorkReceiver;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    const-string p1, "StreetPassWorkReceiver"

    .line 688
    iput-object p1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassWorkReceiver;->TAG:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 6

    if-eqz p2, :cond_3

    .line 694
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object p1

    const-string v0, "au.gov.health.covidsafe.ACTION_DEVICE_SCANNED"

    invoke-static {v0, p1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_3

    const-string p1, "android.bluetooth.device.extra.DEVICE"

    .line 697
    invoke-virtual {p2, p1}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object p1

    .line 696
    check-cast p1, Landroid/bluetooth/BluetoothDevice;

    const-string v0, "au.gov.health.covidsafe.CONNECTION_DATA"

    .line 699
    invoke-virtual {p2, v0}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object p2

    .line 698
    check-cast p2, Lau/gov/health/covidsafe/streetpass/ConnectablePeripheral;

    const/4 v0, 0x1

    const/4 v1, 0x0

    if-eqz p1, :cond_0

    move v2, v0

    goto :goto_0

    :cond_0
    move v2, v1

    :goto_0
    if-eqz p2, :cond_1

    goto :goto_1

    :cond_1
    move v0, v1

    .line 704
    :goto_1
    sget-object v1, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 705
    iget-object v3, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassWorkReceiver;->TAG:Ljava/lang/String;

    .line 706
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Device received: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    if-eqz p1, :cond_2

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v5

    goto :goto_2

    :cond_2
    const/4 v5, 0x0

    :goto_2
    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v5, ". Device present: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    const-string v2, ", Connectable Present: "

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 704
    invoke-virtual {v1, v3, v0}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    if-eqz p1, :cond_3

    if-eqz p2, :cond_3

    .line 711
    new-instance v0, Lau/gov/health/covidsafe/streetpass/Work;

    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassWorkReceiver;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-virtual {v1}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->getOnWorkTimeoutListener()Lau/gov/health/covidsafe/streetpass/Work$OnWorkTimeoutListener;

    move-result-object v1

    invoke-direct {v0, p1, p2, v1}, Lau/gov/health/covidsafe/streetpass/Work;-><init>(Landroid/bluetooth/BluetoothDevice;Lau/gov/health/covidsafe/streetpass/ConnectablePeripheral;Lau/gov/health/covidsafe/streetpass/Work$OnWorkTimeoutListener;)V

    .line 712
    iget-object p1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassWorkReceiver;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-virtual {p1, v0}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->addWork(Lau/gov/health/covidsafe/streetpass/Work;)Z

    move-result p1

    if-eqz p1, :cond_3

    .line 713
    iget-object p1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassWorkReceiver;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->doWork()V

    :cond_3
    return-void
.end method
