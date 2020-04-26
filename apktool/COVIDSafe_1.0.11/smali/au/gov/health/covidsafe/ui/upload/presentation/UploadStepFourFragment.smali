.class public final Lau/gov/health/covidsafe/ui/upload/presentation/UploadStepFourFragment;
.super Lau/gov/health/covidsafe/ui/PagerChildFragment;
.source "UploadStepFourFragment.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0008\u0010\u000e\u001a\u00020\u000fH\u0016J\u0008\u0010\u0010\u001a\u00020\u0011H\u0002J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0008\u0010\u001a\u001a\u00020\u0011H\u0016J\u0008\u0010\u001b\u001a\u00020\u0011H\u0016J\u001a\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00132\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0006\u0010\u001e\u001a\u00020\u0011J\u0008\u0010\u001f\u001a\u00020\u0011H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096D\u00a2\u0006\n\n\u0002\u0010\t\u001a\u0004\u0008\u0007\u0010\u0008R\u001e\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0096\u000e\u00a2\u0006\u0010\n\u0002\u0010\t\u001a\u0004\u0008\u000b\u0010\u0008\"\u0004\u0008\u000c\u0010\r\u00a8\u0006 "
    }
    d2 = {
        "Lau/gov/health/covidsafe/ui/upload/presentation/UploadStepFourFragment;",
        "Lau/gov/health/covidsafe/ui/PagerChildFragment;",
        "()V",
        "alertDialog",
        "Landroid/app/AlertDialog;",
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
        "navigateToVerifyUploadPin",
        "",
        "onCreateView",
        "Landroid/view/View;",
        "inflater",
        "Landroid/view/LayoutInflater;",
        "container",
        "Landroid/view/ViewGroup;",
        "savedInstanceState",
        "Landroid/os/Bundle;",
        "onDestroyView",
        "onResume",
        "onViewCreated",
        "view",
        "showGenericError",
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

.field private alertDialog:Landroid/app/AlertDialog;

.field private final navigationIcon:Ljava/lang/Integer;

.field private stepProgress:Ljava/lang/Integer;


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 18
    invoke-direct {p0}, Lau/gov/health/covidsafe/ui/PagerChildFragment;-><init>()V

    const v0, 0x7f0800a9

    .line 47
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lau/gov/health/covidsafe/ui/upload/presentation/UploadStepFourFragment;->navigationIcon:Ljava/lang/Integer;

    return-void
.end method

.method public static final synthetic access$navigateToVerifyUploadPin(Lau/gov/health/covidsafe/ui/upload/presentation/UploadStepFourFragment;)V
    .locals 0

    .line 18
    invoke-direct {p0}, Lau/gov/health/covidsafe/ui/upload/presentation/UploadStepFourFragment;->navigateToVerifyUploadPin()V

    return-void
.end method

.method private final navigateToVerifyUploadPin()V
    .locals 6

    const v1, 0x7f0a004b

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x6

    const/4 v5, 0x0

    move-object v0, p0

    .line 55
    invoke-static/range {v0 .. v5}, Lau/gov/health/covidsafe/ui/BaseFragment;->navigateTo$default(Lau/gov/health/covidsafe/ui/BaseFragment;ILandroid/os/Bundle;Landroidx/navigation/Navigator$Extras;ILjava/lang/Object;)V

    return-void
.end method


# virtual methods
.method public _$_clearFindViewByIdCache()V
    .locals 1

    iget-object v0, p0, Lau/gov/health/covidsafe/ui/upload/presentation/UploadStepFourFragment;->_$_findViewCache:Ljava/util/HashMap;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    :cond_0
    return-void
.end method

.method public _$_findCachedViewById(I)Landroid/view/View;
    .locals 2

    iget-object v0, p0, Lau/gov/health/covidsafe/ui/upload/presentation/UploadStepFourFragment;->_$_findViewCache:Ljava/util/HashMap;

    if-nez v0, :cond_0

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lau/gov/health/covidsafe/ui/upload/presentation/UploadStepFourFragment;->_$_findViewCache:Ljava/util/HashMap;

    :cond_0
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/upload/presentation/UploadStepFourFragment;->_$_findViewCache:Ljava/util/HashMap;

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

    iget-object v1, p0, Lau/gov/health/covidsafe/ui/upload/presentation/UploadStepFourFragment;->_$_findViewCache:Ljava/util/HashMap;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    invoke-virtual {v1, p1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_2
    return-object v0
.end method

.method public getNavigationIcon()Ljava/lang/Integer;
    .locals 1

    .line 47
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/upload/presentation/UploadStepFourFragment;->navigationIcon:Ljava/lang/Integer;

    return-object v0
.end method

.method public getStepProgress()Ljava/lang/Integer;
    .locals 1

    .line 21
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/upload/presentation/UploadStepFourFragment;->stepProgress:Ljava/lang/Integer;

    return-object v0
.end method

.method public getUploadButtonLayout()Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;
    .locals 3

    .line 49
    new-instance v0, Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;

    .line 50
    new-instance v1, Lau/gov/health/covidsafe/ui/upload/presentation/UploadStepFourFragment$getUploadButtonLayout$1;

    invoke-direct {v1, p0}, Lau/gov/health/covidsafe/ui/upload/presentation/UploadStepFourFragment$getUploadButtonLayout$1;-><init>(Lau/gov/health/covidsafe/ui/upload/presentation/UploadStepFourFragment;)V

    check-cast v1, Lkotlin/jvm/functions/Function0;

    const v2, 0x7f13001b

    .line 49
    invoke-direct {v0, v2, v1}, Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;-><init>(ILkotlin/jvm/functions/Function0;)V

    return-object v0
.end method

.method public bridge synthetic getUploadButtonLayout()Lau/gov/health/covidsafe/ui/UploadButtonLayout;
    .locals 1

    .line 18
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/upload/presentation/UploadStepFourFragment;->getUploadButtonLayout()Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;

    move-result-object v0

    check-cast v0, Lau/gov/health/covidsafe/ui/UploadButtonLayout;

    return-object v0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 1

    const-string p3, "inflater"

    invoke-static {p1, p3}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const p3, 0x7f0d004a

    const/4 v0, 0x0

    .line 24
    invoke-virtual {p1, p3, p2, v0}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p1

    return-object p1
.end method

.method public onDestroyView()V
    .locals 1

    .line 67
    invoke-super {p0}, Lau/gov/health/covidsafe/ui/PagerChildFragment;->onDestroyView()V

    .line 68
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/upload/presentation/UploadStepFourFragment;->alertDialog:Landroid/app/AlertDialog;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/app/AlertDialog;->dismiss()V

    .line 69
    :cond_0
    sget v0, Lau/gov/health/covidsafe/R$id;->root:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/upload/presentation/UploadStepFourFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ScrollView;

    invoke-virtual {v0}, Landroid/widget/ScrollView;->removeAllViews()V

    .line 70
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/upload/presentation/UploadStepFourFragment;->_$_clearFindViewByIdCache()V

    return-void
.end method

.method public onResume()V
    .locals 2

    .line 33
    invoke-super {p0}, Lau/gov/health/covidsafe/ui/PagerChildFragment;->onResume()V

    .line 34
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/upload/presentation/UploadStepFourFragment;->disableContinueButton()V

    .line 35
    sget v0, Lau/gov/health/covidsafe/R$id;->upload_consent_checkbox:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/upload/presentation/UploadStepFourFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/google/android/material/checkbox/MaterialCheckBox;

    new-instance v1, Lau/gov/health/covidsafe/ui/upload/presentation/UploadStepFourFragment$onResume$1;

    invoke-direct {v1, p0}, Lau/gov/health/covidsafe/ui/upload/presentation/UploadStepFourFragment$onResume$1;-><init>(Lau/gov/health/covidsafe/ui/upload/presentation/UploadStepFourFragment;)V

    check-cast v1, Landroid/widget/CompoundButton$OnCheckedChangeListener;

    invoke-virtual {v0, v1}, Lcom/google/android/material/checkbox/MaterialCheckBox;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 1

    const-string v0, "view"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 27
    invoke-super {p0, p1, p2}, Lau/gov/health/covidsafe/ui/PagerChildFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 28
    sget p1, Lau/gov/health/covidsafe/R$id;->subHeader:I

    invoke-virtual {p0, p1}, Lau/gov/health/covidsafe/ui/upload/presentation/UploadStepFourFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroid/widget/TextView;

    const-string p2, "subHeader"

    invoke-static {p1, p2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object p2

    invoke-virtual {p1, p2}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    return-void
.end method

.method public setStepProgress(Ljava/lang/Integer;)V
    .locals 0

    .line 21
    iput-object p1, p0, Lau/gov/health/covidsafe/ui/upload/presentation/UploadStepFourFragment;->stepProgress:Ljava/lang/Integer;

    return-void
.end method

.method public final showGenericError()V
    .locals 3

    .line 59
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/upload/presentation/UploadStepFourFragment;->alertDialog:Landroid/app/AlertDialog;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/app/AlertDialog;->dismiss()V

    .line 60
    :cond_0
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/upload/presentation/UploadStepFourFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v1

    check-cast v1, Landroid/content/Context;

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    const v1, 0x7f13004b

    .line 61
    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(I)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    const v1, 0x1080027

    .line 62
    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setIcon(I)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    const v1, 0x1040013

    const/4 v2, 0x0

    .line 63
    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    move-result-object v0

    iput-object v0, p0, Lau/gov/health/covidsafe/ui/upload/presentation/UploadStepFourFragment;->alertDialog:Landroid/app/AlertDialog;

    return-void
.end method

.method public updateButtonState()V
    .locals 2

    .line 40
    sget v0, Lau/gov/health/covidsafe/R$id;->upload_consent_checkbox:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/upload/presentation/UploadStepFourFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/google/android/material/checkbox/MaterialCheckBox;

    const-string v1, "upload_consent_checkbox"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v0}, Lcom/google/android/material/checkbox/MaterialCheckBox;->isChecked()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 41
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/upload/presentation/UploadStepFourFragment;->enableContinueButton()V

    goto :goto_0

    .line 43
    :cond_0
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/upload/presentation/UploadStepFourFragment;->disableContinueButton()V

    :goto_0
    return-void
.end method
