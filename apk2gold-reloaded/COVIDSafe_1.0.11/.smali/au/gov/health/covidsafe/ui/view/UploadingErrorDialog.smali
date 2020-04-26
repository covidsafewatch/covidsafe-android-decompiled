.class public final Lau/gov/health/covidsafe/ui/view/UploadingErrorDialog;
.super Landroid/app/Dialog;
.source "UploadingErrorDialog.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\u00082\u0008\u0010\t\u001a\u0004\u0018\u00010\nH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"
    }
    d2 = {
        "Lau/gov/health/covidsafe/ui/view/UploadingErrorDialog;",
        "Landroid/app/Dialog;",
        "context",
        "Landroid/content/Context;",
        "listener",
        "Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment$OnUploadErrorInterface;",
        "(Landroid/content/Context;Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment$OnUploadErrorInterface;)V",
        "onCreate",
        "",
        "savedInstanceState",
        "Landroid/os/Bundle;",
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
.field private final listener:Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment$OnUploadErrorInterface;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment$OnUploadErrorInterface;)V
    .locals 1

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "listener"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 12
    invoke-direct {p0, p1}, Landroid/app/Dialog;-><init>(Landroid/content/Context;)V

    iput-object p2, p0, Lau/gov/health/covidsafe/ui/view/UploadingErrorDialog;->listener:Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment$OnUploadErrorInterface;

    const/4 p1, 0x0

    .line 15
    invoke-virtual {p0, p1}, Lau/gov/health/covidsafe/ui/view/UploadingErrorDialog;->setCancelable(Z)V

    .line 16
    invoke-virtual {p0, p1}, Lau/gov/health/covidsafe/ui/view/UploadingErrorDialog;->setCanceledOnTouchOutside(Z)V

    return-void
.end method

.method public static final synthetic access$getListener$p(Lau/gov/health/covidsafe/ui/view/UploadingErrorDialog;)Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment$OnUploadErrorInterface;
    .locals 0

    .line 12
    iget-object p0, p0, Lau/gov/health/covidsafe/ui/view/UploadingErrorDialog;->listener:Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment$OnUploadErrorInterface;

    return-object p0
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 2

    .line 20
    invoke-super {p0, p1}, Landroid/app/Dialog;->onCreate(Landroid/os/Bundle;)V

    const/4 p1, 0x1

    .line 21
    invoke-virtual {p0, p1}, Lau/gov/health/covidsafe/ui/view/UploadingErrorDialog;->requestWindowFeature(I)Z

    const p1, 0x7f0d0034

    .line 22
    invoke-virtual {p0, p1}, Lau/gov/health/covidsafe/ui/view/UploadingErrorDialog;->setContentView(I)V

    .line 23
    sget p1, Lau/gov/health/covidsafe/R$id;->dialog_error_positive:I

    invoke-virtual {p0, p1}, Landroid/app/Dialog;->findViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroid/widget/Button;

    new-instance v0, Lau/gov/health/covidsafe/ui/view/UploadingErrorDialog$onCreate$1;

    invoke-direct {v0, p0}, Lau/gov/health/covidsafe/ui/view/UploadingErrorDialog$onCreate$1;-><init>(Lau/gov/health/covidsafe/ui/view/UploadingErrorDialog;)V

    check-cast v0, Landroid/view/View$OnClickListener;

    invoke-virtual {p1, v0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 26
    sget p1, Lau/gov/health/covidsafe/R$id;->dialog_error_negative:I

    invoke-virtual {p0, p1}, Landroid/app/Dialog;->findViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroid/widget/Button;

    new-instance v0, Lau/gov/health/covidsafe/ui/view/UploadingErrorDialog$onCreate$2;

    invoke-direct {v0, p0}, Lau/gov/health/covidsafe/ui/view/UploadingErrorDialog$onCreate$2;-><init>(Lau/gov/health/covidsafe/ui/view/UploadingErrorDialog;)V

    check-cast v0, Landroid/view/View$OnClickListener;

    invoke-virtual {p1, v0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 29
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/view/UploadingErrorDialog;->getWindow()Landroid/view/Window;

    move-result-object p1

    if-eqz p1, :cond_0

    const/4 v0, -0x1

    const/4 v1, -0x2

    .line 30
    invoke-virtual {p1, v0, v1}, Landroid/view/Window;->setLayout(II)V

    :cond_0
    return-void
.end method
