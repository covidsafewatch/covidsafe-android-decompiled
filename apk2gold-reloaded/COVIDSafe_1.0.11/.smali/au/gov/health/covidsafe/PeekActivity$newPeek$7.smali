.class final Lau/gov/health/covidsafe/PeekActivity$newPeek$7;
.super Ljava/lang/Object;
.source "PeekActivity.kt"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lau/gov/health/covidsafe/PeekActivity;->newPeek()V
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
        "\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\u0008\u0005"
    }
    d2 = {
        "<anonymous>",
        "",
        "view",
        "Landroid/view/View;",
        "kotlin.jvm.PlatformType",
        "onClick"
    }
    k = 0x3
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# instance fields
.field final synthetic this$0:Lau/gov/health/covidsafe/PeekActivity;


# direct methods
.method constructor <init>(Lau/gov/health/covidsafe/PeekActivity;)V
    .locals 0

    iput-object p1, p0, Lau/gov/health/covidsafe/PeekActivity$newPeek$7;->this$0:Lau/gov/health/covidsafe/PeekActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 2

    .line 111
    new-instance p1, Landroid/content/Intent;

    iget-object v0, p0, Lau/gov/health/covidsafe/PeekActivity$newPeek$7;->this$0:Lau/gov/health/covidsafe/PeekActivity;

    check-cast v0, Landroid/content/Context;

    const-class v1, Lau/gov/health/covidsafe/PlotActivity;

    invoke-direct {p1, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 112
    iget-object v0, p0, Lau/gov/health/covidsafe/PeekActivity$newPeek$7;->this$0:Lau/gov/health/covidsafe/PeekActivity;

    invoke-static {v0}, Lau/gov/health/covidsafe/PeekActivity;->access$nextTimePeriod(Lau/gov/health/covidsafe/PeekActivity;)I

    move-result v0

    const-string v1, "time_period"

    invoke-virtual {p1, v1, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 113
    iget-object v0, p0, Lau/gov/health/covidsafe/PeekActivity$newPeek$7;->this$0:Lau/gov/health/covidsafe/PeekActivity;

    invoke-virtual {v0, p1}, Lau/gov/health/covidsafe/PeekActivity;->startActivity(Landroid/content/Intent;)V

    return-void
.end method
