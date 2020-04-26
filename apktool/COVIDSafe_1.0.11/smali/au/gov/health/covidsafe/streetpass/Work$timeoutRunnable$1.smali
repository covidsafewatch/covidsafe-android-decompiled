.class final Lau/gov/health/covidsafe/streetpass/Work$timeoutRunnable$1;
.super Ljava/lang/Object;
.source "Work.kt"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lau/gov/health/covidsafe/streetpass/Work;-><init>(Landroid/bluetooth/BluetoothDevice;Lau/gov/health/covidsafe/streetpass/ConnectablePeripheral;Lau/gov/health/covidsafe/streetpass/Work$OnWorkTimeoutListener;)V
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
.field final synthetic this$0:Lau/gov/health/covidsafe/streetpass/Work;


# direct methods
.method constructor <init>(Lau/gov/health/covidsafe/streetpass/Work;)V
    .locals 0

    iput-object p1, p0, Lau/gov/health/covidsafe/streetpass/Work$timeoutRunnable$1;->this$0:Lau/gov/health/covidsafe/streetpass/Work;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 2

    .line 24
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/Work$timeoutRunnable$1;->this$0:Lau/gov/health/covidsafe/streetpass/Work;

    invoke-static {v0}, Lau/gov/health/covidsafe/streetpass/Work;->access$getOnWorkTimeoutListener$p(Lau/gov/health/covidsafe/streetpass/Work;)Lau/gov/health/covidsafe/streetpass/Work$OnWorkTimeoutListener;

    move-result-object v0

    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/Work$timeoutRunnable$1;->this$0:Lau/gov/health/covidsafe/streetpass/Work;

    invoke-interface {v0, v1}, Lau/gov/health/covidsafe/streetpass/Work$OnWorkTimeoutListener;->onWorkTimeout(Lau/gov/health/covidsafe/streetpass/Work;)V

    return-void
.end method
