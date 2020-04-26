.class public final Lau/gov/health/covidsafe/ui/home/HomeFragment$mBroadcastListener$1;
.super Landroid/content/BroadcastReceiver;
.source "HomeFragment.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lau/gov/health/covidsafe/ui/home/HomeFragment;-><init>()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = null
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\u0008"
    }
    d2 = {
        "au/gov/health/covidsafe/ui/home/HomeFragment$mBroadcastListener$1",
        "Landroid/content/BroadcastReceiver;",
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
.field final synthetic this$0:Lau/gov/health/covidsafe/ui/home/HomeFragment;


# direct methods
.method constructor <init>(Lau/gov/health/covidsafe/ui/home/HomeFragment;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .line 42
    iput-object p1, p0, Lau/gov/health/covidsafe/ui/home/HomeFragment$mBroadcastListener$1;->this$0:Lau/gov/health/covidsafe/ui/home/HomeFragment;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 1

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p1, "intent"

    invoke-static {p2, p1}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 44
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object p1

    const-string v0, "android.bluetooth.adapter.action.STATE_CHANGED"

    .line 45
    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_3

    const/4 p1, -0x1

    const-string v0, "android.bluetooth.adapter.extra.STATE"

    .line 46
    invoke-virtual {p2, v0, p1}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result p1

    const/16 p2, 0xa

    const/4 v0, 0x0

    if-eq p1, p2, :cond_2

    const/16 p2, 0xc

    if-eq p1, p2, :cond_1

    const/16 p2, 0xd

    if-eq p1, p2, :cond_0

    goto :goto_0

    .line 52
    :cond_0
    iget-object p1, p0, Lau/gov/health/covidsafe/ui/home/HomeFragment$mBroadcastListener$1;->this$0:Lau/gov/health/covidsafe/ui/home/HomeFragment;

    sget p2, Lau/gov/health/covidsafe/R$id;->bluetooth_card_view:I

    invoke-virtual {p1, p2}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Lau/gov/health/covidsafe/ui/home/view/PermissionStatusCard;

    iget-object p2, p0, Lau/gov/health/covidsafe/ui/home/HomeFragment$mBroadcastListener$1;->this$0:Lau/gov/health/covidsafe/ui/home/HomeFragment;

    invoke-static {p2, v0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->access$formatBlueToothTitle(Lau/gov/health/covidsafe/ui/home/HomeFragment;Z)Ljava/lang/String;

    move-result-object p2

    invoke-virtual {p1, p2, v0}, Lau/gov/health/covidsafe/ui/home/view/PermissionStatusCard;->render(Ljava/lang/String;Z)V

    .line 53
    iget-object p1, p0, Lau/gov/health/covidsafe/ui/home/HomeFragment$mBroadcastListener$1;->this$0:Lau/gov/health/covidsafe/ui/home/HomeFragment;

    invoke-static {p1}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->access$refreshSetupCompleteOrIncompleteUi(Lau/gov/health/covidsafe/ui/home/HomeFragment;)V

    goto :goto_0

    .line 56
    :cond_1
    iget-object p1, p0, Lau/gov/health/covidsafe/ui/home/HomeFragment$mBroadcastListener$1;->this$0:Lau/gov/health/covidsafe/ui/home/HomeFragment;

    sget p2, Lau/gov/health/covidsafe/R$id;->bluetooth_card_view:I

    invoke-virtual {p1, p2}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Lau/gov/health/covidsafe/ui/home/view/PermissionStatusCard;

    iget-object p2, p0, Lau/gov/health/covidsafe/ui/home/HomeFragment$mBroadcastListener$1;->this$0:Lau/gov/health/covidsafe/ui/home/HomeFragment;

    const/4 v0, 0x1

    invoke-static {p2, v0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->access$formatBlueToothTitle(Lau/gov/health/covidsafe/ui/home/HomeFragment;Z)Ljava/lang/String;

    move-result-object p2

    invoke-virtual {p1, p2, v0}, Lau/gov/health/covidsafe/ui/home/view/PermissionStatusCard;->render(Ljava/lang/String;Z)V

    .line 57
    iget-object p1, p0, Lau/gov/health/covidsafe/ui/home/HomeFragment$mBroadcastListener$1;->this$0:Lau/gov/health/covidsafe/ui/home/HomeFragment;

    invoke-static {p1}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->access$refreshSetupCompleteOrIncompleteUi(Lau/gov/health/covidsafe/ui/home/HomeFragment;)V

    goto :goto_0

    .line 48
    :cond_2
    iget-object p1, p0, Lau/gov/health/covidsafe/ui/home/HomeFragment$mBroadcastListener$1;->this$0:Lau/gov/health/covidsafe/ui/home/HomeFragment;

    sget p2, Lau/gov/health/covidsafe/R$id;->bluetooth_card_view:I

    invoke-virtual {p1, p2}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Lau/gov/health/covidsafe/ui/home/view/PermissionStatusCard;

    iget-object p2, p0, Lau/gov/health/covidsafe/ui/home/HomeFragment$mBroadcastListener$1;->this$0:Lau/gov/health/covidsafe/ui/home/HomeFragment;

    invoke-static {p2, v0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->access$formatBlueToothTitle(Lau/gov/health/covidsafe/ui/home/HomeFragment;Z)Ljava/lang/String;

    move-result-object p2

    invoke-virtual {p1, p2, v0}, Lau/gov/health/covidsafe/ui/home/view/PermissionStatusCard;->render(Ljava/lang/String;Z)V

    .line 49
    iget-object p1, p0, Lau/gov/health/covidsafe/ui/home/HomeFragment$mBroadcastListener$1;->this$0:Lau/gov/health/covidsafe/ui/home/HomeFragment;

    invoke-static {p1}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->access$refreshSetupCompleteOrIncompleteUi(Lau/gov/health/covidsafe/ui/home/HomeFragment;)V

    :cond_3
    :goto_0
    return-void
.end method
