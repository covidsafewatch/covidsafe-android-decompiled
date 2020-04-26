.class public final Lau/gov/health/covidsafe/ui/onboarding/fragment/dataprivacy/DataPrivacyFragment;
.super Lau/gov/health/covidsafe/ui/PagerChildFragment;
.source "DataPrivacyFragment.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0008\u0010\u000c\u001a\u00020\rH\u0016J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0008\u0010\u0016\u001a\u00020\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000f2\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0008\u0010\u001a\u001a\u00020\u0017H\u0016R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096D\u00a2\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u001e\u0010\u0008\u001a\u0004\u0018\u00010\u0004X\u0096\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006\"\u0004\u0008\n\u0010\u000b\u00a8\u0006\u001b"
    }
    d2 = {
        "Lau/gov/health/covidsafe/ui/onboarding/fragment/dataprivacy/DataPrivacyFragment;",
        "Lau/gov/health/covidsafe/ui/PagerChildFragment;",
        "()V",
        "navigationIcon",
        "",
        "getNavigationIcon",
        "()Ljava/lang/Integer;",
        "Ljava/lang/Integer;",
        "stepProgress",
        "getStepProgress",
        "setStepProgress",
        "(Ljava/lang/Integer;)V",
        "getUploadButtonLayout",
        "Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;",
        "onCreateView",
        "Landroid/view/View;",
        "inflater",
        "Landroid/view/LayoutInflater;",
        "container",
        "Landroid/view/ViewGroup;",
        "savedInstanceState",
        "Landroid/os/Bundle;",
        "onDestroyView",
        "",
        "onViewCreated",
        "view",
        "updateButtonState",
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
.field private _$_findViewCache:Ljava/util/HashMap;

.field private final navigationIcon:Ljava/lang/Integer;

.field private stepProgress:Ljava/lang/Integer;


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 14
    invoke-direct {p0}, Lau/gov/health/covidsafe/ui/PagerChildFragment;-><init>()V

    const v0, 0x7f0800a9

    .line 16
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/dataprivacy/DataPrivacyFragment;->navigationIcon:Ljava/lang/Integer;

    return-void
.end method


# virtual methods
.method public _$_clearFindViewByIdCache()V
    .locals 1

    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/dataprivacy/DataPrivacyFragment;->_$_findViewCache:Ljava/util/HashMap;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    :cond_0
    return-void
.end method

.method public _$_findCachedViewById(I)Landroid/view/View;
    .locals 2

    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/dataprivacy/DataPrivacyFragment;->_$_findViewCache:Ljava/util/HashMap;

    if-nez v0, :cond_0

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/dataprivacy/DataPrivacyFragment;->_$_findViewCache:Ljava/util/HashMap;

    :cond_0
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/dataprivacy/DataPrivacyFragment;->_$_findViewCache:Ljava/util/HashMap;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    if-nez v0, :cond_2

    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->getView()Landroid/view/View;

    move-result-object v0

    if-nez v0, :cond_1

    const/4 p1, 0x0

    return-object p1

    :cond_1
    invoke-virtual {v0, p1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iget-object v1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/dataprivacy/DataPrivacyFragment;->_$_findViewCache:Ljava/util/HashMap;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    invoke-virtual {v1, p1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_2
    return-object v0
.end method

.method public getNavigationIcon()Ljava/lang/Integer;
    .locals 1

    .line 16
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/dataprivacy/DataPrivacyFragment;->navigationIcon:Ljava/lang/Integer;

    return-object v0
.end method

.method public getStepProgress()Ljava/lang/Integer;
    .locals 1

    .line 17
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/dataprivacy/DataPrivacyFragment;->stepProgress:Ljava/lang/Integer;

    return-object v0
.end method

.method public getUploadButtonLayout()Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;
    .locals 3

    .line 27
    new-instance v0, Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;

    new-instance v1, Lau/gov/health/covidsafe/ui/onboarding/fragment/dataprivacy/DataPrivacyFragment$getUploadButtonLayout$1;

    invoke-direct {v1, p0}, Lau/gov/health/covidsafe/ui/onboarding/fragment/dataprivacy/DataPrivacyFragment$getUploadButtonLayout$1;-><init>(Lau/gov/health/covidsafe/ui/onboarding/fragment/dataprivacy/DataPrivacyFragment;)V

    check-cast v1, Lkotlin/jvm/functions/Function0;

    const v2, 0x7f13002e

    invoke-direct {v0, v2, v1}, Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;-><init>(ILkotlin/jvm/functions/Function0;)V

    return-object v0
.end method

.method public bridge synthetic getUploadButtonLayout()Lau/gov/health/covidsafe/ui/UploadButtonLayout;
    .locals 1

    .line 14
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/onboarding/fragment/dataprivacy/DataPrivacyFragment;->getUploadButtonLayout()Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;

    move-result-object v0

    check-cast v0, Lau/gov/health/covidsafe/ui/UploadButtonLayout;

    return-object v0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 1

    const-string p3, "inflater"

    invoke-static {p1, p3}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const p3, 0x7f0d0036

    const/4 v0, 0x0

    .line 20
    invoke-virtual {p1, p3, p2, v0}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p1

    return-object p1
.end method

.method public onDestroyView()V
    .locals 1

    .line 36
    invoke-super {p0}, Lau/gov/health/covidsafe/ui/PagerChildFragment;->onDestroyView()V

    .line 37
    sget v0, Lau/gov/health/covidsafe/R$id;->root:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/onboarding/fragment/dataprivacy/DataPrivacyFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ScrollView;

    invoke-virtual {v0}, Landroid/widget/ScrollView;->removeAllViews()V

    .line 38
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/onboarding/fragment/dataprivacy/DataPrivacyFragment;->_$_clearFindViewByIdCache()V

    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 1

    const-string v0, "view"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 23
    invoke-super {p0, p1, p2}, Lau/gov/health/covidsafe/ui/PagerChildFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 24
    sget p2, Lau/gov/health/covidsafe/R$id;->data_privacy_content:I

    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroid/widget/TextView;

    const-string p2, "view.data_privacy_content"

    invoke-static {p1, p2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object p2

    invoke-virtual {p1, p2}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    return-void
.end method

.method public setStepProgress(Ljava/lang/Integer;)V
    .locals 0

    .line 17
    iput-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/dataprivacy/DataPrivacyFragment;->stepProgress:Ljava/lang/Integer;

    return-void
.end method

.method public updateButtonState()V
    .locals 0

    .line 32
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/onboarding/fragment/dataprivacy/DataPrivacyFragment;->enableContinueButton()V

    return-void
.end method
