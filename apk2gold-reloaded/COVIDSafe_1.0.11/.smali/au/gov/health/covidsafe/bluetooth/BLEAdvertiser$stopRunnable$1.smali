.class final Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser$stopRunnable$1;
.super Ljava/lang/Object;
.source "BLEAdvertiser.kt"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;-><init>(Ljava/lang/String;)V
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
.field final synthetic this$0:Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;


# direct methods
.method constructor <init>(Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;)V
    .locals 0

    iput-object p1, p0, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser$stopRunnable$1;->this$0:Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 3

    .line 78
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v1, p0, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser$stopRunnable$1;->this$0:Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;

    invoke-static {v1}, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->access$getTAG$p(Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "Advertising stopping as scheduled."

    invoke-virtual {v0, v1, v2}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 79
    iget-object v0, p0, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser$stopRunnable$1;->this$0:Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;

    invoke-static {v0}, Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;->access$stopAdvertising(Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;)V

    return-void
.end method
