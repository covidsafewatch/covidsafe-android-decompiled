.class final Lau/gov/health/covidsafe/SelfIsolationDoneActivity$onResume$1;
.super Ljava/lang/Object;
.source "SelfIsolationDoneActivity.kt"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lau/gov/health/covidsafe/SelfIsolationDoneActivity;->onResume()V
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
        "it",
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
.field final synthetic this$0:Lau/gov/health/covidsafe/SelfIsolationDoneActivity;


# direct methods
.method constructor <init>(Lau/gov/health/covidsafe/SelfIsolationDoneActivity;)V
    .locals 0

    iput-object p1, p0, Lau/gov/health/covidsafe/SelfIsolationDoneActivity$onResume$1;->this$0:Lau/gov/health/covidsafe/SelfIsolationDoneActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 2

    .line 18
    sget-object p1, Lau/gov/health/covidsafe/Preference;->INSTANCE:Lau/gov/health/covidsafe/Preference;

    iget-object v0, p0, Lau/gov/health/covidsafe/SelfIsolationDoneActivity$onResume$1;->this$0:Lau/gov/health/covidsafe/SelfIsolationDoneActivity;

    check-cast v0, Landroid/content/Context;

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Lau/gov/health/covidsafe/Preference;->setDataIsUploaded(Landroid/content/Context;Z)V

    .line 19
    new-instance p1, Landroid/content/Intent;

    iget-object v0, p0, Lau/gov/health/covidsafe/SelfIsolationDoneActivity$onResume$1;->this$0:Lau/gov/health/covidsafe/SelfIsolationDoneActivity;

    check-cast v0, Landroid/content/Context;

    const-class v1, Lau/gov/health/covidsafe/HomeActivity;

    invoke-direct {p1, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    const v0, 0x10008000

    .line 20
    invoke-virtual {p1, v0}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 21
    iget-object v0, p0, Lau/gov/health/covidsafe/SelfIsolationDoneActivity$onResume$1;->this$0:Lau/gov/health/covidsafe/SelfIsolationDoneActivity;

    invoke-virtual {v0, p1}, Lau/gov/health/covidsafe/SelfIsolationDoneActivity;->startActivity(Landroid/content/Intent;)V

    .line 22
    iget-object p1, p0, Lau/gov/health/covidsafe/SelfIsolationDoneActivity$onResume$1;->this$0:Lau/gov/health/covidsafe/SelfIsolationDoneActivity;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/SelfIsolationDoneActivity;->finish()V

    return-void
.end method
