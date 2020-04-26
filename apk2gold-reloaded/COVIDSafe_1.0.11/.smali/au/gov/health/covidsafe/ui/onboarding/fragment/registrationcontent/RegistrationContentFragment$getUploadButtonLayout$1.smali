.class final Lau/gov/health/covidsafe/ui/onboarding/fragment/registrationcontent/RegistrationContentFragment$getUploadButtonLayout$1;
.super Lkotlin/jvm/internal/Lambda;
.source "RegistrationContentFragment.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function0;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lau/gov/health/covidsafe/ui/onboarding/fragment/registrationcontent/RegistrationContentFragment;->getUploadButtonLayout()Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;
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
.field final synthetic this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/registrationcontent/RegistrationContentFragment;


# direct methods
.method constructor <init>(Lau/gov/health/covidsafe/ui/onboarding/fragment/registrationcontent/RegistrationContentFragment;)V
    .locals 0

    iput-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/registrationcontent/RegistrationContentFragment$getUploadButtonLayout$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/registrationcontent/RegistrationContentFragment;

    const/4 p1, 0x0

    invoke-direct {p0, p1}, Lkotlin/jvm/internal/Lambda;-><init>(I)V

    return-void
.end method


# virtual methods
.method public bridge synthetic invoke()Ljava/lang/Object;
    .locals 1

    .line 13
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/onboarding/fragment/registrationcontent/RegistrationContentFragment$getUploadButtonLayout$1;->invoke()V

    sget-object v0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object v0
.end method

.method public final invoke()V
    .locals 6

    .line 42
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/registrationcontent/RegistrationContentFragment$getUploadButtonLayout$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/registrationcontent/RegistrationContentFragment;

    sget-object v1, Lau/gov/health/covidsafe/ui/onboarding/fragment/registrationcontent/RegistrationContentFragmentDirections;->Companion:Lau/gov/health/covidsafe/ui/onboarding/fragment/registrationcontent/RegistrationContentFragmentDirections$Companion;

    invoke-virtual {v1}, Lau/gov/health/covidsafe/ui/onboarding/fragment/registrationcontent/RegistrationContentFragmentDirections$Companion;->actionRegistrationConsentFragmentToPersonalDetailsFragment()Landroidx/navigation/NavDirections;

    move-result-object v1

    invoke-interface {v1}, Landroidx/navigation/NavDirections;->getActionId()I

    move-result v1

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x6

    const/4 v5, 0x0

    invoke-static/range {v0 .. v5}, Lau/gov/health/covidsafe/ui/BaseFragment;->navigateTo$default(Lau/gov/health/covidsafe/ui/BaseFragment;ILandroid/os/Bundle;Landroidx/navigation/Navigator$Extras;ILjava/lang/Object;)V

    return-void
.end method
