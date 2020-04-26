.class public final Lau/gov/health/covidsafe/ui/upload/UploadContainerFragment;
.super Landroidx/fragment/app/Fragment;
.source "UploadContainerFragment.kt"

# interfaces
.implements Lau/gov/health/covidsafe/ui/PagerContainer;


# annotations
.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nUploadContainerFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UploadContainerFragment.kt\nau/gov/health/covidsafe/ui/upload/UploadContainerFragment\n*L\n1#1,92:1\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0008\u0010\u0004\u001a\u00020\u0005H\u0016J\u0008\u0010\u0006\u001a\u00020\u0005H\u0016J\u0019\u0010\u0007\u001a\u00020\u00052\n\u0008\u0001\u0010\u0008\u001a\u0004\u0018\u00010\tH\u0016\u00a2\u0006\u0002\u0010\nJ&\u0010\u000b\u001a\u0004\u0018\u00010\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0008\u0010\u0013\u001a\u00020\u0005H\u0016J\u0008\u0010\u0014\u001a\u00020\u0005H\u0016J\u0008\u0010\u0015\u001a\u00020\u0005H\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0017\u0010\u0019\u001a\u00020\u00052\u0008\u0010\u001a\u001a\u0004\u0018\u00010\tH\u0016\u00a2\u0006\u0002\u0010\nJ\u0008\u0010\u001b\u001a\u00020\u0005H\u0016J\u0017\u0010\u001c\u001a\u00020\u00052\u0008\u0010\u001d\u001a\u0004\u0018\u00010\tH\u0016\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u001e"
    }
    d2 = {
        "Lau/gov/health/covidsafe/ui/upload/UploadContainerFragment;",
        "Landroidx/fragment/app/Fragment;",
        "Lau/gov/health/covidsafe/ui/PagerContainer;",
        "()V",
        "disableNextButton",
        "",
        "enableNextButton",
        "hideLoading",
        "stringRes",
        "",
        "(Ljava/lang/Integer;)V",
        "onCreateView",
        "Landroid/view/View;",
        "inflater",
        "Landroid/view/LayoutInflater;",
        "container",
        "Landroid/view/ViewGroup;",
        "savedInstanceState",
        "Landroid/os/Bundle;",
        "onDestroyView",
        "onPause",
        "onResume",
        "refreshButton",
        "uploadButtonLayout",
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


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19
    invoke-direct {p0}, Landroidx/fragment/app/Fragment;-><init>()V

    return-void
.end method


# virtual methods
.method public _$_clearFindViewByIdCache()V
    .locals 1

    iget-object v0, p0, Lau/gov/health/covidsafe/ui/upload/UploadContainerFragment;->_$_findViewCache:Ljava/util/HashMap;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    :cond_0
    return-void
.end method

.method public _$_findCachedViewById(I)Landroid/view/View;
    .locals 2

    iget-object v0, p0, Lau/gov/health/covidsafe/ui/upload/UploadContainerFragment;->_$_findViewCache:Ljava/util/HashMap;

    if-nez v0, :cond_0

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lau/gov/health/covidsafe/ui/upload/UploadContainerFragment;->_$_findViewCache:Ljava/util/HashMap;

    :cond_0
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/upload/UploadContainerFragment;->_$_findViewCache:Ljava/util/HashMap;

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

    iget-object v1, p0, Lau/gov/health/covidsafe/ui/upload/UploadContainerFragment;->_$_findViewCache:Ljava/util/HashMap;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    invoke-virtual {v1, p1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_2
    return-object v0
.end method

.method public disableNextButton()V
    .locals 2

    .line 71
    sget v0, Lau/gov/health/covidsafe/R$id;->upload_continue:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/upload/UploadContainerFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    const-string v1, "upload_continue"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setEnabled(Z)V

    return-void
.end method

.method public enableNextButton()V
    .locals 2

    .line 67
    sget v0, Lau/gov/health/covidsafe/R$id;->upload_continue:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/upload/UploadContainerFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    const-string v1, "upload_continue"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setEnabled(Z)V

    return-void
.end method

.method public hideLoading(Ljava/lang/Integer;)V
    .locals 2

    const-string v0, "upload_continue"

    if-nez p1, :cond_0

    .line 82
    sget p1, Lau/gov/health/covidsafe/R$id;->upload_continue:I

    invoke-virtual {p0, p1}, Lau/gov/health/covidsafe/ui/upload/UploadContainerFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroid/widget/Button;

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast p1, Landroid/widget/TextView;

    const/4 v0, 0x1

    const/4 v1, 0x0

    invoke-static {p1, v1, v0, v1}, Lcom/github/razir/progressbutton/DrawableButtonExtensionsKt;->hideProgress$default(Landroid/widget/TextView;Ljava/lang/String;ILjava/lang/Object;)V

    goto :goto_0

    .line 84
    :cond_0
    sget v1, Lau/gov/health/covidsafe/R$id;->upload_continue:I

    invoke-virtual {p0, v1}, Lau/gov/health/covidsafe/ui/upload/UploadContainerFragment;->_$_findCachedViewById(I)Landroid/view/View;

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

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 1

    const-string p3, "inflater"

    invoke-static {p1, p3}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const p3, 0x7f0d0049

    const/4 v0, 0x0

    .line 21
    invoke-virtual {p1, p3, p2, v0}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p1

    return-object p1
.end method

.method public onDestroyView()V
    .locals 1

    .line 89
    invoke-super {p0}, Landroidx/fragment/app/Fragment;->onDestroyView()V

    .line 90
    sget v0, Lau/gov/health/covidsafe/R$id;->root:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/upload/UploadContainerFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    invoke-virtual {v0}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 91
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/upload/UploadContainerFragment;->_$_clearFindViewByIdCache()V

    return-void
.end method

.method public onPause()V
    .locals 2

    .line 31
    invoke-super {p0}, Landroidx/fragment/app/Fragment;->onPause()V

    .line 32
    sget v0, Lau/gov/health/covidsafe/R$id;->toolbar:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/upload/UploadContainerFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroidx/appcompat/widget/Toolbar;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroidx/appcompat/widget/Toolbar;->setNavigationOnClickListener(Landroid/view/View$OnClickListener;)V

    return-void
.end method

.method public onResume()V
    .locals 2

    .line 24
    invoke-super {p0}, Landroidx/fragment/app/Fragment;->onResume()V

    .line 25
    sget v0, Lau/gov/health/covidsafe/R$id;->toolbar:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/upload/UploadContainerFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroidx/appcompat/widget/Toolbar;

    new-instance v1, Lau/gov/health/covidsafe/ui/upload/UploadContainerFragment$onResume$1;

    invoke-direct {v1, p0}, Lau/gov/health/covidsafe/ui/upload/UploadContainerFragment$onResume$1;-><init>(Lau/gov/health/covidsafe/ui/upload/UploadContainerFragment;)V

    check-cast v1, Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroidx/appcompat/widget/Toolbar;->setNavigationOnClickListener(Landroid/view/View$OnClickListener;)V

    return-void
.end method

.method public refreshButton(Lau/gov/health/covidsafe/ui/UploadButtonLayout;)V
    .locals 2

    const-string v0, "uploadButtonLayout"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 56
    instance-of v0, p1, Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;

    if-eqz v0, :cond_0

    .line 57
    sget v0, Lau/gov/health/covidsafe/R$id;->upload_continue:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/upload/UploadContainerFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    new-instance v1, Lau/gov/health/covidsafe/ui/upload/UploadContainerFragment$refreshButton$1;

    invoke-direct {v1, p1}, Lau/gov/health/covidsafe/ui/upload/UploadContainerFragment$refreshButton$1;-><init>(Lau/gov/health/covidsafe/ui/UploadButtonLayout;)V

    check-cast v1, Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 60
    sget v0, Lau/gov/health/covidsafe/R$id;->upload_continue:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/upload/UploadContainerFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    check-cast p1, Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;->getButtonText()I

    move-result p1

    invoke-virtual {v0, p1}, Landroid/widget/Button;->setText(I)V

    .line 61
    sget p1, Lau/gov/health/covidsafe/R$id;->upload_continue:I

    invoke-virtual {p0, p1}, Lau/gov/health/covidsafe/ui/upload/UploadContainerFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroid/widget/Button;

    const-string v0, "upload_continue"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/widget/Button;->setVisibility(I)V

    :cond_0
    return-void
.end method

.method public setNavigationIcon(Ljava/lang/Integer;)V
    .locals 3

    const-string v0, "toolbar"

    if-nez p1, :cond_0

    .line 46
    sget p1, Lau/gov/health/covidsafe/R$id;->toolbar:I

    invoke-virtual {p0, p1}, Lau/gov/health/covidsafe/ui/upload/UploadContainerFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroidx/appcompat/widget/Toolbar;

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v0, 0x0

    check-cast v0, Landroid/graphics/drawable/Drawable;

    invoke-virtual {p1, v0}, Landroidx/appcompat/widget/Toolbar;->setNavigationIcon(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0

    .line 48
    :cond_0
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/upload/UploadContainerFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 49
    sget v2, Lau/gov/health/covidsafe/R$id;->toolbar:I

    invoke-virtual {p0, v2}, Lau/gov/health/covidsafe/ui/upload/UploadContainerFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroidx/appcompat/widget/Toolbar;

    invoke-static {v2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v1, Landroid/content/Context;

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result p1

    invoke-static {v1, p1}, Landroidx/core/content/ContextCompat;->getDrawable(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object p1

    invoke-virtual {v2, p1}, Landroidx/appcompat/widget/Toolbar;->setNavigationIcon(Landroid/graphics/drawable/Drawable;)V

    :cond_1
    :goto_0
    return-void
.end method

.method public showLoading()V
    .locals 2

    .line 75
    sget v0, Lau/gov/health/covidsafe/R$id;->upload_continue:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/upload/UploadContainerFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    const-string v1, "upload_continue"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Landroid/widget/TextView;

    sget-object v1, Lau/gov/health/covidsafe/ui/upload/UploadContainerFragment$showLoading$1;->INSTANCE:Lau/gov/health/covidsafe/ui/upload/UploadContainerFragment$showLoading$1;

    check-cast v1, Lkotlin/jvm/functions/Function1;

    invoke-static {v0, v1}, Lcom/github/razir/progressbutton/DrawableButtonExtensionsKt;->showProgress(Landroid/widget/TextView;Lkotlin/jvm/functions/Function1;)V

    return-void
.end method

.method public updateProgressBar(Ljava/lang/Integer;)V
    .locals 2

    const-string v0, "upload_progress"

    if-nez p1, :cond_0

    .line 37
    sget p1, Lau/gov/health/covidsafe/R$id;->upload_progress:I

    invoke-virtual {p0, p1}, Lau/gov/health/covidsafe/ui/upload/UploadContainerFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Lau/gov/health/covidsafe/ui/view/SegmentedProgressBar;

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v0, 0x4

    invoke-virtual {p1, v0}, Lau/gov/health/covidsafe/ui/view/SegmentedProgressBar;->setVisibility(I)V

    goto :goto_0

    .line 39
    :cond_0
    sget v1, Lau/gov/health/covidsafe/R$id;->upload_progress:I

    invoke-virtual {p0, v1}, Lau/gov/health/covidsafe/ui/upload/UploadContainerFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lau/gov/health/covidsafe/ui/view/SegmentedProgressBar;

    invoke-static {v1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v0, 0x0

    invoke-virtual {v1, v0}, Lau/gov/health/covidsafe/ui/view/SegmentedProgressBar;->setVisibility(I)V

    .line 40
    sget v0, Lau/gov/health/covidsafe/R$id;->upload_progress:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/upload/UploadContainerFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lau/gov/health/covidsafe/ui/view/SegmentedProgressBar;

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result p1

    invoke-virtual {v0, p1}, Lau/gov/health/covidsafe/ui/view/SegmentedProgressBar;->setProgress(I)V

    :goto_0
    return-void
.end method
