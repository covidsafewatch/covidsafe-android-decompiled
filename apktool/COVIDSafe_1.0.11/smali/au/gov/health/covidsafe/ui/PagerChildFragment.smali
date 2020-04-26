.class public abstract Lau/gov/health/covidsafe/ui/PagerChildFragment;
.super Lau/gov/health/covidsafe/ui/BaseFragment;
.source "PagerChildFragment.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\u000cJ\u0006\u0010\r\u001a\u00020\u000cJ\u0008\u0010\u000e\u001a\u00020\u000fH&J\u0006\u0010\u0010\u001a\u00020\u000cJ\u0008\u0010\u0011\u001a\u00020\u000cH\u0016J\u0006\u0010\u0012\u001a\u00020\u000cJ\u0008\u0010\u0013\u001a\u00020\u000cH\u0002J\u0008\u0010\u0014\u001a\u00020\u000cH&J\u0008\u0010\u0015\u001a\u00020\u000cH\u0002J\u0008\u0010\u0016\u001a\u00020\u000cH\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u00a6\u000e\u00a2\u0006\u000c\u001a\u0004\u0008\u0008\u0010\u0006\"\u0004\u0008\t\u0010\n\u00a8\u0006\u0017"
    }
    d2 = {
        "Lau/gov/health/covidsafe/ui/PagerChildFragment;",
        "Lau/gov/health/covidsafe/ui/BaseFragment;",
        "()V",
        "navigationIcon",
        "",
        "getNavigationIcon",
        "()Ljava/lang/Integer;",
        "stepProgress",
        "getStepProgress",
        "setStepProgress",
        "(Ljava/lang/Integer;)V",
        "disableContinueButton",
        "",
        "enableContinueButton",
        "getUploadButtonLayout",
        "Lau/gov/health/covidsafe/ui/UploadButtonLayout;",
        "hideLoading",
        "onResume",
        "showLoading",
        "updateButton",
        "updateButtonState",
        "updateProgressBar",
        "updateToolBar",
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


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 5
    invoke-direct {p0}, Lau/gov/health/covidsafe/ui/BaseFragment;-><init>()V

    return-void
.end method

.method private final updateButton()V
    .locals 4

    .line 25
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/PagerChildFragment;->getUploadButtonLayout()Lau/gov/health/covidsafe/ui/UploadButtonLayout;

    move-result-object v0

    .line 26
    instance-of v1, v0, Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;

    if-eqz v1, :cond_0

    .line 27
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/PagerChildFragment;->updateButtonState()V

    .line 29
    :cond_0
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/PagerChildFragment;->getParentFragment()Landroidx/fragment/app/Fragment;

    move-result-object v1

    const/4 v2, 0x0

    if-eqz v1, :cond_1

    invoke-virtual {v1}, Landroidx/fragment/app/Fragment;->getParentFragment()Landroidx/fragment/app/Fragment;

    move-result-object v1

    goto :goto_0

    :cond_1
    move-object v1, v2

    :goto_0
    instance-of v3, v1, Lau/gov/health/covidsafe/ui/PagerContainer;

    if-nez v3, :cond_2

    move-object v1, v2

    :cond_2
    check-cast v1, Lau/gov/health/covidsafe/ui/PagerContainer;

    if-eqz v1, :cond_3

    invoke-interface {v1, v0}, Lau/gov/health/covidsafe/ui/PagerContainer;->refreshButton(Lau/gov/health/covidsafe/ui/UploadButtonLayout;)V

    .line 30
    :cond_3
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/PagerChildFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v1

    instance-of v3, v1, Lau/gov/health/covidsafe/ui/PagerContainer;

    if-nez v3, :cond_4

    goto :goto_1

    :cond_4
    move-object v2, v1

    :goto_1
    check-cast v2, Lau/gov/health/covidsafe/ui/PagerContainer;

    if-eqz v2, :cond_5

    invoke-interface {v2, v0}, Lau/gov/health/covidsafe/ui/PagerContainer;->refreshButton(Lau/gov/health/covidsafe/ui/UploadButtonLayout;)V

    :cond_5
    return-void
.end method

.method private final updateProgressBar()V
    .locals 3

    .line 15
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/PagerChildFragment;->getParentFragment()Landroidx/fragment/app/Fragment;

    move-result-object v0

    const/4 v1, 0x0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroidx/fragment/app/Fragment;->getParentFragment()Landroidx/fragment/app/Fragment;

    move-result-object v0

    goto :goto_0

    :cond_0
    move-object v0, v1

    :goto_0
    instance-of v2, v0, Lau/gov/health/covidsafe/ui/PagerContainer;

    if-nez v2, :cond_1

    move-object v0, v1

    :cond_1
    check-cast v0, Lau/gov/health/covidsafe/ui/PagerContainer;

    if-eqz v0, :cond_2

    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/PagerChildFragment;->getStepProgress()Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v2}, Lau/gov/health/covidsafe/ui/PagerContainer;->updateProgressBar(Ljava/lang/Integer;)V

    .line 16
    :cond_2
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/PagerChildFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v0

    instance-of v2, v0, Lau/gov/health/covidsafe/ui/PagerContainer;

    if-nez v2, :cond_3

    goto :goto_1

    :cond_3
    move-object v1, v0

    :goto_1
    check-cast v1, Lau/gov/health/covidsafe/ui/PagerContainer;

    if-eqz v1, :cond_4

    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/PagerChildFragment;->getStepProgress()Ljava/lang/Integer;

    move-result-object v0

    invoke-interface {v1, v0}, Lau/gov/health/covidsafe/ui/PagerContainer;->updateProgressBar(Ljava/lang/Integer;)V

    :cond_4
    return-void
.end method

.method private final updateToolBar()V
    .locals 3

    .line 20
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/PagerChildFragment;->getParentFragment()Landroidx/fragment/app/Fragment;

    move-result-object v0

    const/4 v1, 0x0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroidx/fragment/app/Fragment;->getParentFragment()Landroidx/fragment/app/Fragment;

    move-result-object v0

    goto :goto_0

    :cond_0
    move-object v0, v1

    :goto_0
    instance-of v2, v0, Lau/gov/health/covidsafe/ui/PagerContainer;

    if-nez v2, :cond_1

    move-object v0, v1

    :cond_1
    check-cast v0, Lau/gov/health/covidsafe/ui/PagerContainer;

    if-eqz v0, :cond_2

    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/PagerChildFragment;->getNavigationIcon()Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v2}, Lau/gov/health/covidsafe/ui/PagerContainer;->setNavigationIcon(Ljava/lang/Integer;)V

    .line 21
    :cond_2
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/PagerChildFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v0

    instance-of v2, v0, Lau/gov/health/covidsafe/ui/PagerContainer;

    if-nez v2, :cond_3

    goto :goto_1

    :cond_3
    move-object v1, v0

    :goto_1
    check-cast v1, Lau/gov/health/covidsafe/ui/PagerContainer;

    if-eqz v1, :cond_4

    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/PagerChildFragment;->getNavigationIcon()Ljava/lang/Integer;

    move-result-object v0

    invoke-interface {v1, v0}, Lau/gov/health/covidsafe/ui/PagerContainer;->setNavigationIcon(Ljava/lang/Integer;)V

    :cond_4
    return-void
.end method


# virtual methods
.method public _$_clearFindViewByIdCache()V
    .locals 1

    iget-object v0, p0, Lau/gov/health/covidsafe/ui/PagerChildFragment;->_$_findViewCache:Ljava/util/HashMap;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    :cond_0
    return-void
.end method

.method public _$_findCachedViewById(I)Landroid/view/View;
    .locals 2

    iget-object v0, p0, Lau/gov/health/covidsafe/ui/PagerChildFragment;->_$_findViewCache:Ljava/util/HashMap;

    if-nez v0, :cond_0

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lau/gov/health/covidsafe/ui/PagerChildFragment;->_$_findViewCache:Ljava/util/HashMap;

    :cond_0
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/PagerChildFragment;->_$_findViewCache:Ljava/util/HashMap;

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

    iget-object v1, p0, Lau/gov/health/covidsafe/ui/PagerChildFragment;->_$_findViewCache:Ljava/util/HashMap;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    invoke-virtual {v1, p1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_2
    return-object v0
.end method

.method public final disableContinueButton()V
    .locals 3

    .line 39
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/PagerChildFragment;->getParentFragment()Landroidx/fragment/app/Fragment;

    move-result-object v0

    const/4 v1, 0x0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroidx/fragment/app/Fragment;->getParentFragment()Landroidx/fragment/app/Fragment;

    move-result-object v0

    goto :goto_0

    :cond_0
    move-object v0, v1

    :goto_0
    instance-of v2, v0, Lau/gov/health/covidsafe/ui/PagerContainer;

    if-nez v2, :cond_1

    move-object v0, v1

    :cond_1
    check-cast v0, Lau/gov/health/covidsafe/ui/PagerContainer;

    if-eqz v0, :cond_2

    invoke-interface {v0}, Lau/gov/health/covidsafe/ui/PagerContainer;->disableNextButton()V

    .line 40
    :cond_2
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/PagerChildFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v0

    instance-of v2, v0, Lau/gov/health/covidsafe/ui/PagerContainer;

    if-nez v2, :cond_3

    goto :goto_1

    :cond_3
    move-object v1, v0

    :goto_1
    check-cast v1, Lau/gov/health/covidsafe/ui/PagerContainer;

    if-eqz v1, :cond_4

    invoke-interface {v1}, Lau/gov/health/covidsafe/ui/PagerContainer;->disableNextButton()V

    :cond_4
    return-void
.end method

.method public final enableContinueButton()V
    .locals 3

    .line 34
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/PagerChildFragment;->getParentFragment()Landroidx/fragment/app/Fragment;

    move-result-object v0

    const/4 v1, 0x0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroidx/fragment/app/Fragment;->getParentFragment()Landroidx/fragment/app/Fragment;

    move-result-object v0

    goto :goto_0

    :cond_0
    move-object v0, v1

    :goto_0
    instance-of v2, v0, Lau/gov/health/covidsafe/ui/PagerContainer;

    if-nez v2, :cond_1

    move-object v0, v1

    :cond_1
    check-cast v0, Lau/gov/health/covidsafe/ui/PagerContainer;

    if-eqz v0, :cond_2

    invoke-interface {v0}, Lau/gov/health/covidsafe/ui/PagerContainer;->enableNextButton()V

    .line 35
    :cond_2
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/PagerChildFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v0

    instance-of v2, v0, Lau/gov/health/covidsafe/ui/PagerContainer;

    if-nez v2, :cond_3

    goto :goto_1

    :cond_3
    move-object v1, v0

    :goto_1
    check-cast v1, Lau/gov/health/covidsafe/ui/PagerContainer;

    if-eqz v1, :cond_4

    invoke-interface {v1}, Lau/gov/health/covidsafe/ui/PagerContainer;->enableNextButton()V

    :cond_4
    return-void
.end method

.method public abstract getNavigationIcon()Ljava/lang/Integer;
.end method

.method public abstract getStepProgress()Ljava/lang/Integer;
.end method

.method public abstract getUploadButtonLayout()Lau/gov/health/covidsafe/ui/UploadButtonLayout;
.end method

.method public final hideLoading()V
    .locals 4

    .line 49
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/PagerChildFragment;->getParentFragment()Landroidx/fragment/app/Fragment;

    move-result-object v0

    const/4 v1, 0x0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroidx/fragment/app/Fragment;->getParentFragment()Landroidx/fragment/app/Fragment;

    move-result-object v0

    goto :goto_0

    :cond_0
    move-object v0, v1

    :goto_0
    instance-of v2, v0, Lau/gov/health/covidsafe/ui/PagerContainer;

    if-nez v2, :cond_1

    move-object v0, v1

    :cond_1
    check-cast v0, Lau/gov/health/covidsafe/ui/PagerContainer;

    if-eqz v0, :cond_4

    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/PagerChildFragment;->getUploadButtonLayout()Lau/gov/health/covidsafe/ui/UploadButtonLayout;

    move-result-object v2

    instance-of v3, v2, Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;

    if-nez v3, :cond_2

    move-object v2, v1

    :cond_2
    check-cast v2, Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;

    if-eqz v2, :cond_3

    invoke-virtual {v2}, Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;->getButtonText()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    goto :goto_1

    :cond_3
    move-object v2, v1

    :goto_1
    invoke-interface {v0, v2}, Lau/gov/health/covidsafe/ui/PagerContainer;->hideLoading(Ljava/lang/Integer;)V

    .line 50
    :cond_4
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/PagerChildFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v0

    instance-of v2, v0, Lau/gov/health/covidsafe/ui/PagerContainer;

    if-nez v2, :cond_5

    move-object v0, v1

    :cond_5
    check-cast v0, Lau/gov/health/covidsafe/ui/PagerContainer;

    if-eqz v0, :cond_8

    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/PagerChildFragment;->getUploadButtonLayout()Lau/gov/health/covidsafe/ui/UploadButtonLayout;

    move-result-object v2

    instance-of v3, v2, Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;

    if-nez v3, :cond_6

    move-object v2, v1

    :cond_6
    check-cast v2, Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;

    if-eqz v2, :cond_7

    invoke-virtual {v2}, Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;->getButtonText()I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    :cond_7
    invoke-interface {v0, v1}, Lau/gov/health/covidsafe/ui/PagerContainer;->hideLoading(Ljava/lang/Integer;)V

    :cond_8
    return-void
.end method

.method public synthetic onDestroyView()V
    .locals 0

    invoke-super {p0}, Lau/gov/health/covidsafe/ui/BaseFragment;->onDestroyView()V

    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/PagerChildFragment;->_$_clearFindViewByIdCache()V

    return-void
.end method

.method public onResume()V
    .locals 0

    .line 7
    invoke-super {p0}, Lau/gov/health/covidsafe/ui/BaseFragment;->onResume()V

    .line 8
    invoke-direct {p0}, Lau/gov/health/covidsafe/ui/PagerChildFragment;->updateToolBar()V

    .line 9
    invoke-direct {p0}, Lau/gov/health/covidsafe/ui/PagerChildFragment;->updateButton()V

    .line 10
    invoke-direct {p0}, Lau/gov/health/covidsafe/ui/PagerChildFragment;->updateProgressBar()V

    .line 11
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/PagerChildFragment;->updateButtonState()V

    return-void
.end method

.method public abstract setStepProgress(Ljava/lang/Integer;)V
.end method

.method public final showLoading()V
    .locals 3

    .line 44
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/PagerChildFragment;->getParentFragment()Landroidx/fragment/app/Fragment;

    move-result-object v0

    const/4 v1, 0x0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroidx/fragment/app/Fragment;->getParentFragment()Landroidx/fragment/app/Fragment;

    move-result-object v0

    goto :goto_0

    :cond_0
    move-object v0, v1

    :goto_0
    instance-of v2, v0, Lau/gov/health/covidsafe/ui/PagerContainer;

    if-nez v2, :cond_1

    move-object v0, v1

    :cond_1
    check-cast v0, Lau/gov/health/covidsafe/ui/PagerContainer;

    if-eqz v0, :cond_2

    invoke-interface {v0}, Lau/gov/health/covidsafe/ui/PagerContainer;->showLoading()V

    .line 45
    :cond_2
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/PagerChildFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v0

    instance-of v2, v0, Lau/gov/health/covidsafe/ui/PagerContainer;

    if-nez v2, :cond_3

    goto :goto_1

    :cond_3
    move-object v1, v0

    :goto_1
    check-cast v1, Lau/gov/health/covidsafe/ui/PagerContainer;

    if-eqz v1, :cond_4

    invoke-interface {v1}, Lau/gov/health/covidsafe/ui/PagerContainer;->showLoading()V

    :cond_4
    return-void
.end method

.method public abstract updateButtonState()V
.end method
