.class final Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment$getUploadButtonLayout$1;
.super Lkotlin/jvm/internal/Lambda;
.source "PersonalDetailsFragment.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function0;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;->getUploadButtonLayout()Lau/gov/health/covidsafe/ui/UploadButtonLayout;
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
.field final synthetic this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;


# direct methods
.method constructor <init>(Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;)V
    .locals 0

    iput-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment$getUploadButtonLayout$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;

    const/4 p1, 0x0

    invoke-direct {p0, p1}, Lkotlin/jvm/internal/Lambda;-><init>(I)V

    return-void
.end method


# virtual methods
.method public bridge synthetic invoke()Ljava/lang/Object;
    .locals 1

    .line 23
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment$getUploadButtonLayout$1;->invoke()V

    sget-object v0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object v0
.end method

.method public final invoke()V
    .locals 4

    .line 84
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment$getUploadButtonLayout$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;

    invoke-static {v0}, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;->access$getPresenter$p(Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;)Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsPresenter;

    move-result-object v0

    iget-object v1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment$getUploadButtonLayout$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;

    sget v2, Lau/gov/health/covidsafe/R$id;->personal_details_name:I

    invoke-virtual {v1, v2}, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/EditText;

    const-string v2, "personal_details_name"

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment$getUploadButtonLayout$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;

    sget v3, Lau/gov/health/covidsafe/R$id;->personal_details_post_code:I

    invoke-virtual {v2, v3}, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/EditText;

    const-string v3, "personal_details_post_code"

    invoke-static {v2, v3}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment$getUploadButtonLayout$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;

    invoke-static {v3}, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;->access$getMidAgeToSend(Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v1, v2, v3}, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsPresenter;->saveInfos(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method
