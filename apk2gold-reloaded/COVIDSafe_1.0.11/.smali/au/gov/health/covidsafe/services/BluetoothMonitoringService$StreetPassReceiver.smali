.class public final Lau/gov/health/covidsafe/services/BluetoothMonitoringService$StreetPassReceiver;
.super Landroid/content/BroadcastReceiver;
.source "BluetoothMonitoringService.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lau/gov/health/covidsafe/services/BluetoothMonitoringService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x11
    name = "StreetPassReceiver"
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nBluetoothMonitoringService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BluetoothMonitoringService.kt\nau/gov/health/covidsafe/services/BluetoothMonitoringService$StreetPassReceiver\n*L\n1#1,671:1\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"
    }
    d2 = {
        "Lau/gov/health/covidsafe/services/BluetoothMonitoringService$StreetPassReceiver;",
        "Landroid/content/BroadcastReceiver;",
        "(Lau/gov/health/covidsafe/services/BluetoothMonitoringService;)V",
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

.field final synthetic this$0:Lau/gov/health/covidsafe/services/BluetoothMonitoringService;


# direct methods
.method public constructor <init>(Lau/gov/health/covidsafe/services/BluetoothMonitoringService;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .line 546
    iput-object p1, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$StreetPassReceiver;->this$0:Lau/gov/health/covidsafe/services/BluetoothMonitoringService;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    const-string p1, "StreetPassReceiver"

    .line 548
    iput-object p1, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$StreetPassReceiver;->TAG:Ljava/lang/String;

    return-void
.end method

.method public static final synthetic access$getTAG$p(Lau/gov/health/covidsafe/services/BluetoothMonitoringService$StreetPassReceiver;)Ljava/lang/String;
    .locals 0

    .line 546
    iget-object p0, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$StreetPassReceiver;->TAG:Ljava/lang/String;

    return-object p0
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 20

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    const-string v2, "context"

    move-object/from16 v3, p1

    invoke-static {v3, v2}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v2, "intent"

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 552
    invoke-virtual/range {p2 .. p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v2

    const-string v3, "au.gov.health.covidsafe.ACTION_RECEIVED_STREETPASS"

    invoke-static {v3, v2}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    const-string v2, "au.gov.health.covidsafe.STREET_PASS"

    .line 553
    invoke-virtual {v1, v2}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v1

    const-string v2, "intent.getParcelableExtra(STREET_PASS)"

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v1, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;

    .line 554
    sget-object v2, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 555
    iget-object v3, v0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$StreetPassReceiver;->TAG:Ljava/lang/String;

    .line 556
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "StreetPass received: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 554
    invoke-virtual {v2, v3, v4}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 559
    invoke-virtual {v1}, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->getMsg()Ljava/lang/String;

    move-result-object v2

    check-cast v2, Ljava/lang/CharSequence;

    invoke-interface {v2}, Ljava/lang/CharSequence;->length()I

    move-result v2

    if-lez v2, :cond_0

    const/4 v2, 0x1

    goto :goto_0

    :cond_0
    const/4 v2, 0x0

    :goto_0
    if-eqz v2, :cond_2

    .line 561
    iget-object v2, v0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$StreetPassReceiver;->this$0:Lau/gov/health/covidsafe/services/BluetoothMonitoringService;

    invoke-static {v2}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->access$getMBound$p(Lau/gov/health/covidsafe/services/BluetoothMonitoringService;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 562
    iget-object v2, v0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$StreetPassReceiver;->this$0:Lau/gov/health/covidsafe/services/BluetoothMonitoringService;

    invoke-static {v2}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->access$getMService$p(Lau/gov/health/covidsafe/services/BluetoothMonitoringService;)Lau/gov/health/covidsafe/services/SensorMonitoringService;

    move-result-object v2

    invoke-virtual {v2}, Lau/gov/health/covidsafe/services/SensorMonitoringService;->getProximity()F

    move-result v2

    .line 563
    iget-object v3, v0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$StreetPassReceiver;->this$0:Lau/gov/health/covidsafe/services/BluetoothMonitoringService;

    invoke-static {v3}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService;->access$getMService$p(Lau/gov/health/covidsafe/services/BluetoothMonitoringService;)Lau/gov/health/covidsafe/services/SensorMonitoringService;

    move-result-object v3

    invoke-virtual {v3}, Lau/gov/health/covidsafe/services/SensorMonitoringService;->getLight()F

    move-result v3

    .line 564
    sget-object v4, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 565
    iget-object v5, v0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$StreetPassReceiver;->TAG:Ljava/lang/String;

    .line 566
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Sensor values just before saving StreetPassRecord: proximity="

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    const-string v2, " light="

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 564
    invoke-virtual {v4, v5, v2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 570
    :cond_1
    new-instance v2, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;

    .line 571
    invoke-virtual {v1}, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->getVersion()I

    move-result v7

    .line 572
    invoke-virtual {v1}, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->getMsg()Ljava/lang/String;

    move-result-object v8

    .line 573
    invoke-virtual {v1}, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->getOrg()Ljava/lang/String;

    move-result-object v9

    .line 574
    invoke-virtual {v1}, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->getPeripheral()Lau/gov/health/covidsafe/streetpass/PeripheralDevice;

    move-result-object v3

    invoke-virtual {v3}, Lau/gov/health/covidsafe/streetpass/PeripheralDevice;->getModelP()Ljava/lang/String;

    move-result-object v10

    .line 575
    invoke-virtual {v1}, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->getCentral()Lau/gov/health/covidsafe/streetpass/CentralDevice;

    move-result-object v3

    invoke-virtual {v3}, Lau/gov/health/covidsafe/streetpass/CentralDevice;->getModelC()Ljava/lang/String;

    move-result-object v11

    .line 576
    invoke-virtual {v1}, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->getRssi()I

    move-result v12

    .line 577
    invoke-virtual {v1}, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->getTxPower()Ljava/lang/Integer;

    move-result-object v13

    move-object v6, v2

    .line 570
    invoke-direct/range {v6 .. v13}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;-><init>(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;)V

    .line 581
    iget-object v14, v0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$StreetPassReceiver;->this$0:Lau/gov/health/covidsafe/services/BluetoothMonitoringService;

    const/4 v15, 0x0

    const/16 v16, 0x0

    new-instance v1, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$StreetPassReceiver$onReceive$1;

    const/4 v3, 0x0

    invoke-direct {v1, v0, v2, v3}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$StreetPassReceiver$onReceive$1;-><init>(Lau/gov/health/covidsafe/services/BluetoothMonitoringService$StreetPassReceiver;Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;Lkotlin/coroutines/Continuation;)V

    move-object/from16 v17, v1

    check-cast v17, Lkotlin/jvm/functions/Function2;

    const/16 v18, 0x3

    const/16 v19, 0x0

    invoke-static/range {v14 .. v19}, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;ILjava/lang/Object;)Lkotlinx/coroutines/Job;

    :cond_2
    return-void
.end method
