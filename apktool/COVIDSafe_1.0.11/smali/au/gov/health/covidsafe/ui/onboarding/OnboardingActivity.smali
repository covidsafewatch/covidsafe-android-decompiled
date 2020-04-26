.class public final Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity;
.super Landroidx/fragment/app/FragmentActivity;
.source "OnboardingActivity.kt"

# interfaces
.implements Lau/gov/health/covidsafe/HasBlockingState;
.implements Lau/gov/health/covidsafe/ui/PagerContainer;


# annotations
.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nOnboardingActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OnboardingActivity.kt\nau/gov/health/covidsafe/ui/onboarding/OnboardingActivity\n*L\n1#1,105:1\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0008\u0010\u000b\u001a\u00020\u000cH\u0016J\u0008\u0010\r\u001a\u00020\u000cH\u0016J\u0019\u0010\u000e\u001a\u00020\u000c2\n\u0008\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016\u00a2\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u000c2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u000c2\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\u0008\u0010\u0018\u001a\u00020\u000cH\u0014J\u0008\u0010\u0019\u001a\u00020\u000cH\u0014J\u0010\u0010\u001a\u001a\u00020\u000c2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0017\u0010\u001d\u001a\u00020\u000c2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u0010H\u0016\u00a2\u0006\u0002\u0010\u0011J\u0008\u0010\u001f\u001a\u00020\u000cH\u0016J\u0017\u0010 \u001a\u00020\u000c2\u0008\u0010!\u001a\u0004\u0018\u00010\u0010H\u0016\u00a2\u0006\u0002\u0010\u0011R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@VX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008\"\u0004\u0008\t\u0010\n\u00a8\u0006\""
    }
    d2 = {
        "Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity;",
        "Landroidx/fragment/app/FragmentActivity;",
        "Lau/gov/health/covidsafe/HasBlockingState;",
        "Lau/gov/health/covidsafe/ui/PagerContainer;",
        "()V",
        "value",
        "",
        "isUiBlocked",
        "()Z",
        "setUiBlocked",
        "(Z)V",
        "disableNextButton",
        "",
        "enableNextButton",
        "hideLoading",
        "stringRes",
        "",
        "(Ljava/lang/Integer;)V",
        "onAttachFragment",
        "fragment",
        "Landroidx/fragment/app/Fragment;",
        "onCreate",
        "savedInstanceState",
        "Landroid/os/Bundle;",
        "onPause",
        "onResume",
        "refreshButton",
        "updateButtonLayout",
        "Lau/gov/health/covidsafe/ui/UploadButtonLayout;",
        "setNavigationIcon",
        "navigationIcon",
        "showLoading",
        "updateProgressBar",
        "stepProgress",
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

.field private isUiBlocked:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20
    invoke-direct {p0}, Landroidx/fragment/app/FragmentActivity;-><init>()V

    return-void
.end method

.method public static final synthetic access$onBackPressed$s-1060241814(Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity;)V
    .locals 0

    .line 20
    invoke-super {p0}, Landroidx/fragment/app/FragmentActivity;->onBackPressed()V

    return-void
.end method


# virtual methods
.method public _$_clearFindViewByIdCache()V
    .locals 1

    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity;->_$_findViewCache:Ljava/util/HashMap;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    :cond_0
    return-void
.end method

.method public _$_findCachedViewById(I)Landroid/view/View;
    .locals 2

    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity;->_$_findViewCache:Ljava/util/HashMap;

    if-nez v0, :cond_0

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity;->_$_findViewCache:Ljava/util/HashMap;

    :cond_0
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity;->_$_findViewCache:Ljava/util/HashMap;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    if-nez v0, :cond_1

    invoke-virtual {p0, p1}, Landroidx/fragment/app/FragmentActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iget-object v1, p0, Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity;->_$_findViewCache:Ljava/util/HashMap;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    invoke-virtual {v1, p1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_1
    return-object v0
.end method

.method public disableNextButton()V
    .locals 2

    .line 87
    sget v0, Lau/gov/health/covidsafe/R$id;->onboarding_next:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    const-string v1, "onboarding_next"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setEnabled(Z)V

    return-void
.end method

.method public enableNextButton()V
    .locals 2

    .line 83
    sget v0, Lau/gov/health/covidsafe/R$id;->onboarding_next:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    const-string v1, "onboarding_next"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setEnabled(Z)V

    return-void
.end method

.method public hideLoading(Ljava/lang/Integer;)V
    .locals 2

    const-string v0, "onboarding_next"

    if-nez p1, :cond_0

    .line 98
    sget p1, Lau/gov/health/covidsafe/R$id;->onboarding_next:I

    invoke-virtual {p0, p1}, Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroid/widget/Button;

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast p1, Landroid/widget/TextView;

    const/4 v0, 0x1

    const/4 v1, 0x0

    invoke-static {p1, v1, v0, v1}, Lcom/github/razir/progressbutton/DrawableButtonExtensionsKt;->hideProgress$default(Landroid/widget/TextView;Ljava/lang/String;ILjava/lang/Object;)V

    goto :goto_0

    .line 100
    :cond_0
    sget v1, Lau/gov/health/covidsafe/R$id;->onboarding_next:I

    invoke-virtual {p0, v1}, Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    invoke-static {v1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v1, Landroid/widget/TextView;

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result p1

    invoke-static {v1, p1}, Lcom/github/razir/progressbutton/DrawableButtonExtensionsKt;->hideProgress(Landroid/widget/TextView;I)V

    :goto_0
    return-void
.end method

.method public isUiBlocked()Z
    .locals 1

    .line 22
    iget-boolean v0, p0, Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity;->isUiBlocked:Z

    return v0
.end method

.method public onAttachFragment(Landroidx/fragment/app/Fragment;)V
    .locals 1

    const-string v0, "fragment"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 38
    invoke-super {p0, p1}, Landroidx/fragment/app/FragmentActivity;->onAttachFragment(Landroidx/fragment/app/Fragment;)V

    const/4 p1, 0x0

    .line 39
    invoke-virtual {p0, p1}, Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity;->setUiBlocked(Z)V

    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 1

    .line 29
    invoke-super {p0, p1}, Landroidx/fragment/app/FragmentActivity;->onCreate(Landroid/os/Bundle;)V

    const p1, 0x7f0d001e

    .line 30
    invoke-virtual {p0, p1}, Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity;->setContentView(I)V

    .line 31
    sget p1, Lau/gov/health/covidsafe/R$id;->onboarding_next:I

    invoke-virtual {p0, p1}, Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroid/widget/Button;

    const-string v0, "onboarding_next"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast p1, Landroid/widget/TextView;

    invoke-static {p0, p1}, Lcom/github/razir/progressbutton/ProgressButtonHolderKt;->bindProgressButton(Landroidx/lifecycle/LifecycleOwner;Landroid/widget/TextView;)V

    .line 32
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity;->isUiBlocked()Z

    move-result p1

    if-eqz p1, :cond_0

    .line 33
    sget p1, Lau/gov/health/covidsafe/R$id;->loadingProgressBarFrame:I

    invoke-virtual {p0, p1}, Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroid/widget/FrameLayout;

    if-eqz p1, :cond_0

    check-cast p1, Landroid/view/View;

    const/4 v0, 0x1

    invoke-static {p1, v0}, Landroidx/core/view/ViewKt;->setVisible(Landroid/view/View;Z)V

    :cond_0
    return-void
.end method

.method protected onPause()V
    .locals 2

    .line 77
    invoke-super {p0}, Landroidx/fragment/app/FragmentActivity;->onPause()V

    .line 78
    sget v0, Lau/gov/health/covidsafe/R$id;->onboarding_next:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 79
    sget v0, Lau/gov/health/covidsafe/R$id;->toolbar:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroidx/appcompat/widget/Toolbar;

    invoke-virtual {v0, v1}, Landroidx/appcompat/widget/Toolbar;->setNavigationOnClickListener(Landroid/view/View$OnClickListener;)V

    return-void
.end method

.method protected onResume()V
    .locals 2

    .line 43
    invoke-super {p0}, Landroidx/fragment/app/FragmentActivity;->onResume()V

    .line 45
    sget v0, Lau/gov/health/covidsafe/R$id;->toolbar:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroidx/appcompat/widget/Toolbar;

    new-instance v1, Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity$onResume$1;

    invoke-direct {v1, p0}, Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity$onResume$1;-><init>(Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity;)V

    check-cast v1, Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroidx/appcompat/widget/Toolbar;->setNavigationOnClickListener(Landroid/view/View$OnClickListener;)V

    return-void
.end method

.method public refreshButton(Lau/gov/health/covidsafe/ui/UploadButtonLayout;)V
    .locals 2

    const-string v0, "updateButtonLayout"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 68
    instance-of v0, p1, Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;

    if-eqz v0, :cond_0

    .line 69
    sget v0, Lau/gov/health/covidsafe/R$id;->onboarding_next:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    move-object v1, p1

    check-cast v1, Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;

    invoke-virtual {v1}, Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;->getButtonText()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setText(I)V

    .line 70
    sget v0, Lau/gov/health/covidsafe/R$id;->onboarding_next:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    new-instance v1, Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity$refreshButton$1;

    invoke-direct {v1, p1}, Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity$refreshButton$1;-><init>(Lau/gov/health/covidsafe/ui/UploadButtonLayout;)V

    check-cast v1, Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    :cond_0
    return-void
.end method

.method public setNavigationIcon(Ljava/lang/Integer;)V
    .locals 2

    const-string v0, "toolbar"

    if-nez p1, :cond_0

    .line 61
    sget p1, Lau/gov/health/covidsafe/R$id;->toolbar:I

    invoke-virtual {p0, p1}, Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroidx/appcompat/widget/Toolbar;

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v0, 0x0

    check-cast v0, Landroid/graphics/drawable/Drawable;

    invoke-virtual {p1, v0}, Landroidx/appcompat/widget/Toolbar;->setNavigationIcon(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0

    .line 63
    :cond_0
    sget v1, Lau/gov/health/covidsafe/R$id;->toolbar:I

    invoke-virtual {p0, v1}, Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroidx/appcompat/widget/Toolbar;

    invoke-static {v1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    move-object v0, p0

    check-cast v0, Landroid/content/Context;

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result p1

    invoke-static {v0, p1}, Landroidx/core/content/ContextCompat;->getDrawable(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object p1

    invoke-virtual {v1, p1}, Landroidx/appcompat/widget/Toolbar;->setNavigationIcon(Landroid/graphics/drawable/Drawable;)V

    :goto_0
    return-void
.end method

.method public setUiBlocked(Z)V
    .locals 1

    .line 24
    sget v0, Lau/gov/health/covidsafe/R$id;->loadingProgressBarFrame:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    if-eqz v0, :cond_0

    check-cast v0, Landroid/view/View;

    invoke-static {v0, p1}, Landroidx/core/view/ViewKt;->setVisible(Landroid/view/View;Z)V

    .line 25
    :cond_0
    iput-boolean p1, p0, Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity;->isUiBlocked:Z

    return-void
.end method

.method public showLoading()V
    .locals 2

    .line 91
    sget v0, Lau/gov/health/covidsafe/R$id;->onboarding_next:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    const-string v1, "onboarding_next"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Landroid/widget/TextView;

    sget-object v1, Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity$showLoading$1;->INSTANCE:Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity$showLoading$1;

    check-cast v1, Lkotlin/jvm/functions/Function1;

    invoke-static {v0, v1}, Lcom/github/razir/progressbutton/DrawableButtonExtensionsKt;->showProgress(Landroid/widget/TextView;Lkotlin/jvm/functions/Function1;)V

    return-void
.end method

.method public updateProgressBar(Ljava/lang/Integer;)V
    .locals 2

    const-string v0, "onboarding_progress_bar"

    if-eqz p1, :cond_0

    .line 51
    check-cast p1, Ljava/lang/Number;

    invoke-virtual {p1}, Ljava/lang/Number;->intValue()I

    move-result p1

    .line 52
    sget v1, Lau/gov/health/covidsafe/R$id;->onboarding_progress_bar:I

    invoke-virtual {p0, v1}, Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lau/gov/health/covidsafe/ui/view/SegmentedProgressBar;

    invoke-static {v1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v0, 0x0

    invoke-virtual {v1, v0}, Lau/gov/health/covidsafe/ui/view/SegmentedProgressBar;->setVisibility(I)V

    .line 53
    sget v0, Lau/gov/health/covidsafe/R$id;->onboarding_progress_bar:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lau/gov/health/covidsafe/ui/view/SegmentedProgressBar;

    invoke-virtual {v0, p1}, Lau/gov/health/covidsafe/ui/view/SegmentedProgressBar;->setProgress(I)V

    goto :goto_0

    .line 54
    :cond_0
    move-object p1, p0

    check-cast p1, Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity;

    .line 55
    sget v1, Lau/gov/health/covidsafe/R$id;->onboarding_progress_bar:I

    invoke-virtual {p1, v1}, Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Lau/gov/health/covidsafe/ui/view/SegmentedProgressBar;

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const/16 v0, 0x8

    invoke-virtual {p1, v0}, Lau/gov/health/covidsafe/ui/view/SegmentedProgressBar;->setVisibility(I)V

    :goto_0
    return-void
.end method
