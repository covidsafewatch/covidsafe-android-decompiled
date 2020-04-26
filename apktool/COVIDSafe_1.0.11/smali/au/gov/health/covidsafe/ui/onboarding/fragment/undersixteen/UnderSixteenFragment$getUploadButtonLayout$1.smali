.class final Lau/gov/health/covidsafe/ui/onboarding/fragment/undersixteen/UnderSixteenFragment$getUploadButtonLayout$1;
.super Lkotlin/jvm/internal/Lambda;
.source "UnderSixteenFragment.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function0;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lau/gov/health/covidsafe/ui/onboarding/fragment/undersixteen/UnderSixteenFragment;->getUploadButtonLayout()Lau/gov/health/covidsafe/ui/UploadButtonLayout;
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
.field final synthetic this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/undersixteen/UnderSixteenFragment;


# direct methods
.method constructor <init>(Lau/gov/health/covidsafe/ui/onboarding/fragment/undersixteen/UnderSixteenFragment;)V
    .locals 0

    iput-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/undersixteen/UnderSixteenFragment$getUploadButtonLayout$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/undersixteen/UnderSixteenFragment;

    const/4 p1, 0x0

    invoke-direct {p0, p1}, Lkotlin/jvm/internal/Lambda;-><init>(I)V

    return-void
.end method


# virtual methods
.method public bridge synthetic invoke()Ljava/lang/Object;
    .locals 1

    .line 15
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/onboarding/fragment/undersixteen/UnderSixteenFragment$getUploadButtonLayout$1;->invoke()V

    sget-object v0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object v0
.end method

.method public final invoke()V
    .locals 9

    const/4 v0, 0x2

    new-array v1, v0, [Lkotlin/Pair;

    const v2, 0x7f0a0043

    .line 40
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v3, "destination_id"

    invoke-static {v3, v2}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v2

    const/4 v3, 0x0

    aput-object v2, v1, v3

    .line 41
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    const-string v2, "progress"

    invoke-static {v2, v0}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v0

    const/4 v2, 0x1

    aput-object v0, v1, v2

    .line 39
    invoke-static {v1}, Landroidx/core/os/BundleKt;->bundleOf([Lkotlin/Pair;)Landroid/os/Bundle;

    move-result-object v5

    .line 42
    iget-object v3, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/undersixteen/UnderSixteenFragment$getUploadButtonLayout$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/undersixteen/UnderSixteenFragment;

    sget-object v0, Lau/gov/health/covidsafe/ui/onboarding/fragment/undersixteen/UnderSixteenFragmentDirections;->Companion:Lau/gov/health/covidsafe/ui/onboarding/fragment/undersixteen/UnderSixteenFragmentDirections$Companion;

    invoke-virtual {v0}, Lau/gov/health/covidsafe/ui/onboarding/fragment/undersixteen/UnderSixteenFragmentDirections$Companion;->actionUnderSixteenFragmentToEnterNumberFragment()Landroidx/navigation/NavDirections;

    move-result-object v0

    invoke-interface {v0}, Landroidx/navigation/NavDirections;->getActionId()I

    move-result v4

    const/4 v6, 0x0

    const/4 v7, 0x4

    const/4 v8, 0x0

    invoke-static/range {v3 .. v8}, Lau/gov/health/covidsafe/ui/BaseFragment;->navigateTo$default(Lau/gov/health/covidsafe/ui/BaseFragment;ILandroid/os/Bundle;Landroidx/navigation/Navigator$Extras;ILjava/lang/Object;)V

    return-void
.end method
