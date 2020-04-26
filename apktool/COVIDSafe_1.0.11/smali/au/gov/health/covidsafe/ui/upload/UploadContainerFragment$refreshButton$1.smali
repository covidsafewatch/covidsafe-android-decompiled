.class final Lau/gov/health/covidsafe/ui/upload/UploadContainerFragment$refreshButton$1;
.super Ljava/lang/Object;
.source "UploadContainerFragment.kt"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lau/gov/health/covidsafe/ui/upload/UploadContainerFragment;->refreshButton(Lau/gov/health/covidsafe/ui/UploadButtonLayout;)V
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
.field final synthetic $uploadButtonLayout:Lau/gov/health/covidsafe/ui/UploadButtonLayout;


# direct methods
.method constructor <init>(Lau/gov/health/covidsafe/ui/UploadButtonLayout;)V
    .locals 0

    iput-object p1, p0, Lau/gov/health/covidsafe/ui/upload/UploadContainerFragment$refreshButton$1;->$uploadButtonLayout:Lau/gov/health/covidsafe/ui/UploadButtonLayout;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 0

    .line 58
    iget-object p1, p0, Lau/gov/health/covidsafe/ui/upload/UploadContainerFragment$refreshButton$1;->$uploadButtonLayout:Lau/gov/health/covidsafe/ui/UploadButtonLayout;

    check-cast p1, Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;->getButtonListener()Lkotlin/jvm/functions/Function0;

    move-result-object p1

    if-eqz p1, :cond_0

    invoke-interface {p1}, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lkotlin/Unit;

    :cond_0
    return-void
.end method
