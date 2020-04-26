.class final Lau/gov/health/covidsafe/PeekActivity$newPeek$6$1$2;
.super Ljava/lang/Object;
.source "PeekActivity.kt"

# interfaces
.implements Lio/reactivex/functions/Consumer;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lau/gov/health/covidsafe/PeekActivity$newPeek$6$1;->onClick(Landroid/content/DialogInterface;I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lio/reactivex/functions/Consumer<",
        "Ljava/lang/Boolean;",
        ">;"
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0004\u0008\u0005\u0010\u0006"
    }
    d2 = {
        "<anonymous>",
        "",
        "result",
        "",
        "kotlin.jvm.PlatformType",
        "accept",
        "(Ljava/lang/Boolean;)V"
    }
    k = 0x3
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# instance fields
.field final synthetic $dialog:Landroid/content/DialogInterface;

.field final synthetic this$0:Lau/gov/health/covidsafe/PeekActivity$newPeek$6$1;


# direct methods
.method constructor <init>(Lau/gov/health/covidsafe/PeekActivity$newPeek$6$1;Landroid/content/DialogInterface;)V
    .locals 0

    iput-object p1, p0, Lau/gov/health/covidsafe/PeekActivity$newPeek$6$1$2;->this$0:Lau/gov/health/covidsafe/PeekActivity$newPeek$6$1;

    iput-object p2, p0, Lau/gov/health/covidsafe/PeekActivity$newPeek$6$1$2;->$dialog:Landroid/content/DialogInterface;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final accept(Ljava/lang/Boolean;)V
    .locals 3

    .line 92
    iget-object v0, p0, Lau/gov/health/covidsafe/PeekActivity$newPeek$6$1$2;->this$0:Lau/gov/health/covidsafe/PeekActivity$newPeek$6$1;

    iget-object v0, v0, Lau/gov/health/covidsafe/PeekActivity$newPeek$6$1;->this$0:Lau/gov/health/covidsafe/PeekActivity$newPeek$6;

    iget-object v0, v0, Lau/gov/health/covidsafe/PeekActivity$newPeek$6;->this$0:Lau/gov/health/covidsafe/PeekActivity;

    check-cast v0, Landroid/content/Context;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Database nuked: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    check-cast p1, Ljava/lang/CharSequence;

    const/4 v1, 0x0

    invoke-static {v0, p1, v1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object p1

    .line 93
    invoke-virtual {p1}, Landroid/widget/Toast;->show()V

    .line 94
    iget-object p1, p0, Lau/gov/health/covidsafe/PeekActivity$newPeek$6$1$2;->this$0:Lau/gov/health/covidsafe/PeekActivity$newPeek$6$1;

    iget-object p1, p1, Lau/gov/health/covidsafe/PeekActivity$newPeek$6$1;->$view:Landroid/view/View;

    const-string v0, "view"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/view/View;->setEnabled(Z)V

    .line 95
    iget-object p1, p0, Lau/gov/health/covidsafe/PeekActivity$newPeek$6$1$2;->$dialog:Landroid/content/DialogInterface;

    invoke-interface {p1}, Landroid/content/DialogInterface;->cancel()V

    return-void
.end method

.method public bridge synthetic accept(Ljava/lang/Object;)V
    .locals 0

    .line 22
    check-cast p1, Ljava/lang/Boolean;

    invoke-virtual {p0, p1}, Lau/gov/health/covidsafe/PeekActivity$newPeek$6$1$2;->accept(Ljava/lang/Boolean;)V

    return-void
.end method
