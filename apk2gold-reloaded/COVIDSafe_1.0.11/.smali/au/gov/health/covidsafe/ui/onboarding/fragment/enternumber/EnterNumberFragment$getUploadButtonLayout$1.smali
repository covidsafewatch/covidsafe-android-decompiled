.class final Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment$getUploadButtonLayout$1;
.super Lkotlin/jvm/internal/Lambda;
.source "EnterNumberFragment.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function0;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;->getUploadButtonLayout()Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lkotlin/jvm/internal/Lambda;",
        "Lkotlin/jvm/functions/Function0<",
        "Lkotlin/Unit;",
        ">;"
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nEnterNumberFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EnterNumberFragment.kt\nau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment$getUploadButtonLayout$1\n*L\n1#1,134:1\n*E\n"
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
        "invoke"
    }
    k = 0x3
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# instance fields
.field final synthetic this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;


# direct methods
.method constructor <init>(Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;)V
    .locals 0

    iput-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment$getUploadButtonLayout$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;

    const/4 p1, 0x0

    invoke-direct {p0, p1}, Lkotlin/jvm/internal/Lambda;-><init>(I)V

    return-void
.end method


# virtual methods
.method public bridge synthetic invoke()Ljava/lang/Object;
    .locals 1

    .line 25
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment$getUploadButtonLayout$1;->invoke()V

    sget-object v0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object v0
.end method

.method public final invoke()V
    .locals 3

    .line 130
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment$getUploadButtonLayout$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;

    invoke-static {v0}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;->access$getEnterNumberPresenter$p(Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;)Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter;

    move-result-object v0

    iget-object v1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment$getUploadButtonLayout$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;

    sget v2, Lau/gov/health/covidsafe/R$id;->enter_number_phone_number:I

    invoke-virtual {v1, v2}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/EditText;

    const-string v2, "enter_number_phone_number"

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    check-cast v1, Ljava/lang/CharSequence;

    invoke-static {v1}, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter;->requestOTP$app_release(Ljava/lang/String;)V

    return-void

    :cond_0
    new-instance v0, Lkotlin/TypeCastException;

    const-string v1, "null cannot be cast to non-null type kotlin.CharSequence"

    invoke-direct {v0, v1}, Lkotlin/TypeCastException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
