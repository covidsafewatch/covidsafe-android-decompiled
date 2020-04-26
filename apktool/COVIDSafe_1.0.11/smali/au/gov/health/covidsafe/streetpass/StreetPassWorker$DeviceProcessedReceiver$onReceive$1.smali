.class final Lau/gov/health/covidsafe/streetpass/StreetPassWorker$DeviceProcessedReceiver$onReceive$1;
.super Ljava/lang/Object;
.source "StreetPassWorker.kt"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lau/gov/health/covidsafe/streetpass/StreetPassWorker$DeviceProcessedReceiver;->onReceive(Landroid/content/Context;Landroid/content/Intent;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = null
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\u0008\u0002"
    }
    d2 = {
        "<anonymous>",
        "",
        "run"
    }
    k = 0x3
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# instance fields
.field final synthetic $entry:Lau/gov/health/covidsafe/streetpass/BlacklistEntry;

.field final synthetic this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker$DeviceProcessedReceiver;


# direct methods
.method constructor <init>(Lau/gov/health/covidsafe/streetpass/StreetPassWorker$DeviceProcessedReceiver;Lau/gov/health/covidsafe/streetpass/BlacklistEntry;)V
    .locals 0

    iput-object p1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$DeviceProcessedReceiver$onReceive$1;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker$DeviceProcessedReceiver;

    iput-object p2, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$DeviceProcessedReceiver$onReceive$1;->$entry:Lau/gov/health/covidsafe/streetpass/BlacklistEntry;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 5

    .line 677
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    .line 678
    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$DeviceProcessedReceiver$onReceive$1;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker$DeviceProcessedReceiver;

    iget-object v1, v1, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$DeviceProcessedReceiver;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-static {v1}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->access$getTAG$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Ljava/lang/String;

    move-result-object v1

    .line 679
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "blacklist for "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v3, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$DeviceProcessedReceiver$onReceive$1;->$entry:Lau/gov/health/covidsafe/streetpass/BlacklistEntry;

    invoke-virtual {v3}, Lau/gov/health/covidsafe/streetpass/BlacklistEntry;->getUniqueIdentifier()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v3, " removed? : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v3, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$DeviceProcessedReceiver$onReceive$1;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker$DeviceProcessedReceiver;

    iget-object v3, v3, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$DeviceProcessedReceiver;->this$0:Lau/gov/health/covidsafe/streetpass/StreetPassWorker;

    invoke-static {v3}, Lau/gov/health/covidsafe/streetpass/StreetPassWorker;->access$getBlacklist$p(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)Ljava/util/List;

    move-result-object v3

    iget-object v4, p0, Lau/gov/health/covidsafe/streetpass/StreetPassWorker$DeviceProcessedReceiver$onReceive$1;->$entry:Lau/gov/health/covidsafe/streetpass/BlacklistEntry;

    invoke-interface {v3, v4}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 677
    invoke-virtual {v0, v1, v2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method
