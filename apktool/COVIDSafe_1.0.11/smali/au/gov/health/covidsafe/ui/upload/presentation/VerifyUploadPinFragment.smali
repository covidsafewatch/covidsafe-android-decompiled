.class public final Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;
.super Lau/gov/health/covidsafe/ui/PagerChildFragment;
.source "VerifyUploadPinFragment.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment$OnUploadErrorInterface;
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nVerifyUploadPinFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VerifyUploadPinFragment.kt\nau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment\n*L\n1#1,127:1\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000c\u0018\u00002\u00020\u0001:\u0001+B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0008\u0010\u0010\u001a\u00020\u0011H\u0016J\u0008\u0010\u0012\u001a\u00020\u0013H\u0002J\u0006\u0010\u0014\u001a\u00020\u0013J\u0008\u0010\u0015\u001a\u00020\u0016H\u0002J\u0006\u0010\u0017\u001a\u00020\u0013J\u0006\u0010\u0018\u001a\u00020\u0013J&\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0008\u0010!\u001a\u00020\u0013H\u0016J\u0008\u0010\"\u001a\u00020\u0013H\u0016J\u0008\u0010#\u001a\u00020\u0013H\u0016J\u0008\u0010$\u001a\u00020\u0013H\u0016J\u001a\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u001a2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0006\u0010\'\u001a\u00020\u0013J\u0006\u0010(\u001a\u00020\u0013J\u0006\u0010)\u001a\u00020\u0013J\u0008\u0010*\u001a\u00020\u0013H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096D\u00a2\u0006\n\n\u0002\u0010\t\u001a\u0004\u0008\u0007\u0010\u0008R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000c\u001a\u0004\u0018\u00010\u0006X\u0096\u000e\u00a2\u0006\u0010\n\u0002\u0010\t\u001a\u0004\u0008\r\u0010\u0008\"\u0004\u0008\u000e\u0010\u000f\u00a8\u0006,"
    }
    d2 = {
        "Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;",
        "Lau/gov/health/covidsafe/ui/PagerChildFragment;",
        "()V",
        "dialog",
        "Landroid/app/Dialog;",
        "navigationIcon",
        "",
        "getNavigationIcon",
        "()Ljava/lang/Integer;",
        "Ljava/lang/Integer;",
        "presenter",
        "Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;",
        "stepProgress",
        "getStepProgress",
        "setStepProgress",
        "(Ljava/lang/Integer;)V",
        "getUploadButtonLayout",
        "Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;",
        "hideInvalidOtp",
        "",
        "hideKeyboard",
        "isIncorrectPinFormat",
        "",
        "navigateToNextPage",
        "navigateToRegister",
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
        "onStop",
        "onViewCreated",
        "view",
        "showDialogLoading",
        "showGenericError",
        "showInvalidOtp",
        "updateButtonState",
        "OnUploadErrorInterface",
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

.field private dialog:Landroid/app/Dialog;

.field private final navigationIcon:Ljava/lang/Integer;

.field private presenter:Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;

.field private stepProgress:Ljava/lang/Integer;


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 20
    invoke-direct {p0}, Lau/gov/health/covidsafe/ui/PagerChildFragment;-><init>()V

    const v0, 0x7f0800a9

    .line 34
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->navigationIcon:Ljava/lang/Integer;

    return-void
.end method

.method public static final synthetic access$getDialog$p(Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;)Landroid/app/Dialog;
    .locals 0

    .line 20
    iget-object p0, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->dialog:Landroid/app/Dialog;

    return-object p0
.end method

.method public static final synthetic access$getPresenter$p(Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;)Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;
    .locals 1

    .line 20
    iget-object p0, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->presenter:Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;

    if-nez p0, :cond_0

    const-string v0, "presenter"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    :cond_0
    return-object p0
.end method

.method public static final synthetic access$hideInvalidOtp(Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;)V
    .locals 0

    .line 20
    invoke-direct {p0}, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->hideInvalidOtp()V

    return-void
.end method

.method public static final synthetic access$setDialog$p(Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;Landroid/app/Dialog;)V
    .locals 0

    .line 20
    iput-object p1, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->dialog:Landroid/app/Dialog;

    return-void
.end method

.method public static final synthetic access$setPresenter$p(Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;)V
    .locals 0

    .line 20
    iput-object p1, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->presenter:Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;

    return-void
.end method

.method private final hideInvalidOtp()V
    .locals 2

    .line 83
    sget v0, Lau/gov/health/covidsafe/R$id;->enter_pin_error_label:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroidx/appcompat/widget/AppCompatTextView;

    const-string v1, "enter_pin_error_label"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroidx/appcompat/widget/AppCompatTextView;->setVisibility(I)V

    return-void
.end method

.method private final isIncorrectPinFormat()Z
    .locals 2

    .line 68
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->requireView()Landroid/view/View;

    move-result-object v0

    const-string v1, "requireView()"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    sget v1, Lau/gov/health/covidsafe/R$id;->pin:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lau/gov/health/covidsafe/ui/view/PinInputView;

    invoke-virtual {v0}, Lau/gov/health/covidsafe/ui/view/PinInputView;->isIncomplete()Z

    move-result v0

    return v0
.end method


# virtual methods
.method public _$_clearFindViewByIdCache()V
    .locals 1

    iget-object v0, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->_$_findViewCache:Ljava/util/HashMap;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    :cond_0
    return-void
.end method

.method public _$_findCachedViewById(I)Landroid/view/View;
    .locals 2

    iget-object v0, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->_$_findViewCache:Ljava/util/HashMap;

    if-nez v0, :cond_0

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->_$_findViewCache:Ljava/util/HashMap;

    :cond_0
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->_$_findViewCache:Ljava/util/HashMap;

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

    iget-object v1, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->_$_findViewCache:Ljava/util/HashMap;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    invoke-virtual {v1, p1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_2
    return-object v0
.end method

.method public getNavigationIcon()Ljava/lang/Integer;
    .locals 1

    .line 34
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->navigationIcon:Ljava/lang/Integer;

    return-object v0
.end method

.method public getStepProgress()Ljava/lang/Integer;
    .locals 1

    .line 35
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->stepProgress:Ljava/lang/Integer;

    return-object v0
.end method

.method public getUploadButtonLayout()Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;
    .locals 3

    .line 55
    new-instance v0, Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;

    new-instance v1, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment$getUploadButtonLayout$1;

    invoke-direct {v1, p0}, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment$getUploadButtonLayout$1;-><init>(Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;)V

    check-cast v1, Lkotlin/jvm/functions/Function0;

    const v2, 0x7f130021

    invoke-direct {v0, v2, v1}, Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;-><init>(ILkotlin/jvm/functions/Function0;)V

    return-object v0
.end method

.method public bridge synthetic getUploadButtonLayout()Lau/gov/health/covidsafe/ui/UploadButtonLayout;
    .locals 1

    .line 20
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->getUploadButtonLayout()Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;

    move-result-object v0

    check-cast v0, Lau/gov/health/covidsafe/ui/UploadButtonLayout;

    return-object v0
.end method

.method public final hideKeyboard()V
    .locals 1

    .line 72
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroidx/fragment/app/FragmentActivity;->getCurrentFocus()Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 73
    invoke-static {v0}, Lcom/atlassian/mobilekit/module/core/utils/SystemUtils;->hideSoftKeyboard(Landroid/view/View;)V

    :cond_0
    return-void
.end method

.method public final navigateToNextPage()V
    .locals 6

    const v1, 0x7f0a004d

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x6

    const/4 v5, 0x0

    move-object v0, p0

    .line 119
    invoke-static/range {v0 .. v5}, Lau/gov/health/covidsafe/ui/BaseFragment;->navigateTo$default(Lau/gov/health/covidsafe/ui/BaseFragment;ILandroid/os/Bundle;Landroidx/navigation/Navigator$Extras;ILjava/lang/Object;)V

    return-void
.end method

.method public final navigateToRegister()V
    .locals 9

    const/4 v0, 0x1

    new-array v0, v0, [Lkotlin/Pair;

    const v1, 0x7f0a0037

    .line 114
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "destination_id"

    invoke-static {v2, v1}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v1

    const/4 v2, 0x0

    aput-object v1, v0, v2

    .line 113
    invoke-static {v0}, Landroidx/core/os/BundleKt;->bundleOf([Lkotlin/Pair;)Landroid/os/Bundle;

    move-result-object v5

    .line 115
    sget-object v0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragmentDirections;->Companion:Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragmentDirections$Companion;

    invoke-virtual {v0}, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragmentDirections$Companion;->actionVerifyUploadPinFragmentToEnterNumberFragment()Landroidx/navigation/NavDirections;

    move-result-object v0

    invoke-interface {v0}, Landroidx/navigation/NavDirections;->getActionId()I

    move-result v4

    const/4 v6, 0x0

    const/4 v7, 0x4

    const/4 v8, 0x0

    move-object v3, p0

    invoke-static/range {v3 .. v8}, Lau/gov/health/covidsafe/ui/BaseFragment;->navigateTo$default(Lau/gov/health/covidsafe/ui/BaseFragment;ILandroid/os/Bundle;Landroidx/navigation/Navigator$Extras;ILjava/lang/Object;)V

    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 1

    const-string p3, "inflater"

    invoke-static {p1, p3}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const p3, 0x7f0d004b

    const/4 v0, 0x0

    .line 32
    invoke-virtual {p1, p3, p2, v0}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p1

    return-object p1
.end method

.method public onDestroyView()V
    .locals 1

    .line 108
    invoke-super {p0}, Lau/gov/health/covidsafe/ui/PagerChildFragment;->onDestroyView()V

    .line 109
    sget v0, Lau/gov/health/covidsafe/R$id;->root:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ScrollView;

    invoke-virtual {v0}, Landroid/widget/ScrollView;->removeAllViews()V

    .line 110
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->_$_clearFindViewByIdCache()V

    return-void
.end method

.method public onPause()V
    .locals 2

    .line 51
    invoke-super {p0}, Lau/gov/health/covidsafe/ui/PagerChildFragment;->onPause()V

    .line 52
    sget v0, Lau/gov/health/covidsafe/R$id;->pin:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lau/gov/health/covidsafe/ui/view/PinInputView;

    const/4 v1, 0x0

    check-cast v1, Lkotlin/jvm/functions/Function0;

    invoke-virtual {v0, v1}, Lau/gov/health/covidsafe/ui/view/PinInputView;->setOnPinChanged(Lkotlin/jvm/functions/Function0;)V

    return-void
.end method

.method public onResume()V
    .locals 2

    .line 43
    invoke-super {p0}, Lau/gov/health/covidsafe/ui/PagerChildFragment;->onResume()V

    .line 44
    sget v0, Lau/gov/health/covidsafe/R$id;->pin:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lau/gov/health/covidsafe/ui/view/PinInputView;

    new-instance v1, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment$onResume$1;

    invoke-direct {v1, p0}, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment$onResume$1;-><init>(Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;)V

    check-cast v1, Lkotlin/jvm/functions/Function0;

    invoke-virtual {v0, v1}, Lau/gov/health/covidsafe/ui/view/PinInputView;->setOnPinChanged(Lkotlin/jvm/functions/Function0;)V

    return-void
.end method

.method public onStop()V
    .locals 1

    .line 103
    invoke-super {p0}, Lau/gov/health/covidsafe/ui/PagerChildFragment;->onStop()V

    .line 104
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->dialog:Landroid/app/Dialog;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/app/Dialog;->dismiss()V

    :cond_0
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 1

    const-string v0, "view"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 38
    invoke-super {p0, p1, p2}, Lau/gov/health/covidsafe/ui/PagerChildFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 39
    new-instance p1, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;

    invoke-direct {p1, p0}, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;-><init>(Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;)V

    iput-object p1, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->presenter:Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;

    return-void
.end method

.method public setStepProgress(Ljava/lang/Integer;)V
    .locals 0

    .line 35
    iput-object p1, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->stepProgress:Ljava/lang/Integer;

    return-void
.end method

.method public final showDialogLoading()V
    .locals 3

    .line 123
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->dialog:Landroid/app/Dialog;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/app/Dialog;->dismiss()V

    .line 124
    :cond_0
    new-instance v0, Lau/gov/health/covidsafe/ui/view/UploadingDialog;

    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v1

    const-string v2, "requireActivity()"

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v1, Landroid/content/Context;

    invoke-direct {v0, v1}, Lau/gov/health/covidsafe/ui/view/UploadingDialog;-><init>(Landroid/content/Context;)V

    check-cast v0, Landroid/app/Dialog;

    iput-object v0, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->dialog:Landroid/app/Dialog;

    if-eqz v0, :cond_1

    .line 125
    invoke-virtual {v0}, Landroid/app/Dialog;->show()V

    :cond_1
    return-void
.end method

.method public final showGenericError()V
    .locals 3

    .line 87
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->dialog:Landroid/app/Dialog;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/app/Dialog;->dismiss()V

    .line 88
    :cond_0
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 89
    new-instance v1, Lau/gov/health/covidsafe/ui/view/UploadingErrorDialog;

    const-string v2, "it"

    invoke-static {v0, v2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Landroid/content/Context;

    new-instance v2, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment$showGenericError$$inlined$let$lambda$1;

    invoke-direct {v2, p0}, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment$showGenericError$$inlined$let$lambda$1;-><init>(Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;)V

    check-cast v2, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment$OnUploadErrorInterface;

    invoke-direct {v1, v0, v2}, Lau/gov/health/covidsafe/ui/view/UploadingErrorDialog;-><init>(Landroid/content/Context;Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment$OnUploadErrorInterface;)V

    check-cast v1, Landroid/app/Dialog;

    iput-object v1, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->dialog:Landroid/app/Dialog;

    if-eqz v1, :cond_1

    .line 98
    invoke-virtual {v1}, Landroid/app/Dialog;->show()V

    :cond_1
    return-void
.end method

.method public final showInvalidOtp()V
    .locals 2

    .line 78
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->dialog:Landroid/app/Dialog;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/app/Dialog;->dismiss()V

    .line 79
    :cond_0
    sget v0, Lau/gov/health/covidsafe/R$id;->enter_pin_error_label:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroidx/appcompat/widget/AppCompatTextView;

    const-string v1, "enter_pin_error_label"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroidx/appcompat/widget/AppCompatTextView;->setVisibility(I)V

    return-void
.end method

.method public updateButtonState()V
    .locals 1

    .line 60
    invoke-direct {p0}, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->isIncorrectPinFormat()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 61
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->disableContinueButton()V

    goto :goto_0

    .line 63
    :cond_0
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->enableContinueButton()V

    :goto_0
    return-void
.end method
