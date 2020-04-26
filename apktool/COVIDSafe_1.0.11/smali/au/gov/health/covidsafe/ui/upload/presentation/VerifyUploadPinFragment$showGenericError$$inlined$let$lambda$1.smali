.class public final Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment$showGenericError$$inlined$let$lambda$1;
.super Ljava/lang/Object;
.source "VerifyUploadPinFragment.kt"

# interfaces
.implements Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment$OnUploadErrorInterface;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->showGenericError()V
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
        "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016J\u0008\u0010\u0004\u001a\u00020\u0003H\u0016\u00a8\u0006\u0005\u00b8\u0006\u0000"
    }
    d2 = {
        "au/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment$showGenericError$1$1",
        "Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment$OnUploadErrorInterface;",
        "onNegativeClicked",
        "",
        "onPositiveClicked",
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
.field final synthetic this$0:Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;


# direct methods
.method constructor <init>(Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;)V
    .locals 0

    iput-object p1, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment$showGenericError$$inlined$let$lambda$1;->this$0:Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;

    .line 89
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onNegativeClicked()V
    .locals 1

    .line 95
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment$showGenericError$$inlined$let$lambda$1;->this$0:Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;

    invoke-static {v0}, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->access$getDialog$p(Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;)Landroid/app/Dialog;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/app/Dialog;->dismiss()V

    :cond_0
    return-void
.end method

.method public onPositiveClicked()V
    .locals 3

    .line 91
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment$showGenericError$$inlined$let$lambda$1;->this$0:Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;

    invoke-static {v0}, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->access$getPresenter$p(Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;)Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;

    move-result-object v0

    iget-object v1, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment$showGenericError$$inlined$let$lambda$1;->this$0:Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;

    invoke-virtual {v1}, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->requireView()Landroid/view/View;

    move-result-object v1

    const-string v2, "requireView()"

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    sget v2, Lau/gov/health/covidsafe/R$id;->pin:I

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lau/gov/health/covidsafe/ui/view/PinInputView;

    invoke-virtual {v1}, Lau/gov/health/covidsafe/ui/view/PinInputView;->getValue()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;->uploadData$app_release(Ljava/lang/String;)V

    return-void
.end method
