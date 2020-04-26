.class public final Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter;
.super Ljava/lang/Object;
.source "EnterNumberPresenter.kt"

# interfaces
.implements Landroidx/lifecycle/LifecycleObserver;


# annotations
.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nEnterNumberPresenter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EnterNumberPresenter.kt\nau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter\n*L\n1#1,84:1\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0008\u0010\u000c\u001a\u00020\u000bH\u0003J\u0015\u0010\r\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0006H\u0000\u00a2\u0006\u0002\u0008\u000eJ\u0017\u0010\u000f\u001a\u00020\u00102\u0008\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0000\u00a2\u0006\u0002\u0008\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"
    }
    d2 = {
        "Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter;",
        "Landroidx/lifecycle/LifecycleObserver;",
        "enterNumberFragment",
        "Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;",
        "(Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;)V",
        "TAG",
        "",
        "getOnboardingOtp",
        "Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtp;",
        "phoneNumber",
        "makeOTPCall",
        "",
        "onCreate",
        "requestOTP",
        "requestOTP$app_release",
        "validateAuNumber",
        "",
        "validateAuNumber$app_release",
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
.field private final TAG:Ljava/lang/String;

.field private final enterNumberFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;

.field private getOnboardingOtp:Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtp;

.field private phoneNumber:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;)V
    .locals 1

    const-string v0, "enterNumberFragment"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter;->enterNumberFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;

    .line 18
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object p1

    const-string v0, "this.javaClass.simpleName"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    iput-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter;->TAG:Ljava/lang/String;

    .line 24
    iget-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter;->enterNumberFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;->getLifecycle()Landroidx/lifecycle/Lifecycle;

    move-result-object p1

    move-object v0, p0

    check-cast v0, Landroidx/lifecycle/LifecycleObserver;

    invoke-virtual {p1, v0}, Landroidx/lifecycle/Lifecycle;->addObserver(Landroidx/lifecycle/LifecycleObserver;)V

    return-void
.end method

.method public static final synthetic access$getEnterNumberFragment$p(Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter;)Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;
    .locals 0

    .line 16
    iget-object p0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter;->enterNumberFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;

    return-object p0
.end method

.method private final makeOTPCall(Ljava/lang/String;)V
    .locals 9

    .line 50
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter;->enterNumberFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;

    invoke-virtual {v0}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 51
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter;->enterNumberFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;

    invoke-virtual {v0}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;->disableContinueButton()V

    .line 52
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter;->enterNumberFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;

    invoke-virtual {v0}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;->showLoading()V

    .line 53
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter;->getOnboardingOtp:Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtp;

    if-nez v0, :cond_0

    const-string v1, "getOnboardingOtp"

    invoke-static {v1}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    :cond_0
    new-instance v1, Lau/gov/health/covidsafe/interactor/usecase/GetOtpParams;

    .line 54
    sget-object v2, Lau/gov/health/covidsafe/Preference;->INSTANCE:Lau/gov/health/covidsafe/Preference;

    iget-object v3, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter;->enterNumberFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;

    invoke-virtual {v3}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;->requireContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v2, v3}, Lau/gov/health/covidsafe/Preference;->getDeviceID(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v4

    .line 55
    sget-object v2, Lau/gov/health/covidsafe/Preference;->INSTANCE:Lau/gov/health/covidsafe/Preference;

    iget-object v3, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter;->enterNumberFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;

    invoke-virtual {v3}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;->requireContext()Landroid/content/Context;

    move-result-object v3

    const-string v5, "enterNumberFragment.requireContext()"

    invoke-static {v3, v5}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v2, v3}, Lau/gov/health/covidsafe/Preference;->getPostCode(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v6

    .line 56
    sget-object v2, Lau/gov/health/covidsafe/Preference;->INSTANCE:Lau/gov/health/covidsafe/Preference;

    iget-object v3, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter;->enterNumberFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;

    invoke-virtual {v3}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;->requireContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3, v5}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v2, v3}, Lau/gov/health/covidsafe/Preference;->getAge(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v7

    .line 57
    sget-object v2, Lau/gov/health/covidsafe/Preference;->INSTANCE:Lau/gov/health/covidsafe/Preference;

    iget-object v3, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter;->enterNumberFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;

    invoke-virtual {v3}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;->requireContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3, v5}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v2, v3}, Lau/gov/health/covidsafe/Preference;->getName(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v8

    move-object v2, v1

    move-object v3, p1

    move-object v5, v6

    move-object v6, v7

    move-object v7, v8

    .line 53
    invoke-direct/range {v2 .. v7}, Lau/gov/health/covidsafe/interactor/usecase/GetOtpParams;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 58
    new-instance v2, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter$makeOTPCall$$inlined$let$lambda$1;

    invoke-direct {v2, p0, p1}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter$makeOTPCall$$inlined$let$lambda$1;-><init>(Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter;Ljava/lang/String;)V

    check-cast v2, Lkotlin/jvm/functions/Function1;

    .line 64
    new-instance v3, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter$makeOTPCall$$inlined$let$lambda$2;

    invoke-direct {v3, p0, p1}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter$makeOTPCall$$inlined$let$lambda$2;-><init>(Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter;Ljava/lang/String;)V

    check-cast v3, Lkotlin/jvm/functions/Function1;

    .line 53
    invoke-virtual {v0, v1, v2, v3}, Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtp;->invoke(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V

    :cond_1
    return-void
.end method

.method private final onCreate()V
    .locals 4
    .annotation runtime Landroidx/lifecycle/OnLifecycleEvent;
        value = .enum Landroidx/lifecycle/Lifecycle$Event;->ON_CREATE:Landroidx/lifecycle/Lifecycle$Event;
    .end annotation

    .line 29
    new-instance v0, Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtp;

    sget-object v1, Lau/gov/health/covidsafe/factory/NetworkFactory;->Companion:Lau/gov/health/covidsafe/factory/NetworkFactory$Companion;

    invoke-virtual {v1}, Lau/gov/health/covidsafe/factory/NetworkFactory$Companion;->getAwsClient()Lau/gov/health/covidsafe/networking/service/AwsClient;

    move-result-object v1

    iget-object v2, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter;->enterNumberFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;

    invoke-virtual {v2}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;->getLifecycle()Landroidx/lifecycle/Lifecycle;

    move-result-object v2

    const-string v3, "enterNumberFragment.lifecycle"

    invoke-static {v2, v3}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {v0, v1, v2}, Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtp;-><init>(Lau/gov/health/covidsafe/networking/service/AwsClient;Landroidx/lifecycle/Lifecycle;)V

    iput-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter;->getOnboardingOtp:Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtp;

    return-void
.end method


# virtual methods
.method public final requestOTP$app_release(Ljava/lang/String;)V
    .locals 4

    const-string v0, "phoneNumber"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 33
    invoke-virtual {p0, p1}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter;->validateAuNumber$app_release(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    const/4 v0, 0x0

    const/4 v1, 0x2

    const/4 v2, 0x0

    const-string v3, "0"

    .line 34
    invoke-static {p1, v3, v0, v1, v2}, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 35
    sget-object v0, Lau/gov/health/covidsafe/TracerApp;->Companion:Lau/gov/health/covidsafe/TracerApp$Companion;

    invoke-virtual {v0}, Lau/gov/health/covidsafe/TracerApp$Companion;->getAppContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0b0003

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v0

    invoke-static {p1, v0}, Lkotlin/text/StringsKt;->takeLast(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object p1

    .line 37
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter;->enterNumberFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;

    invoke-virtual {v1}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f13003a

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 38
    sget-object v1, Lau/gov/health/covidsafe/Preference;->INSTANCE:Lau/gov/health/covidsafe/Preference;

    sget-object v2, Lau/gov/health/covidsafe/TracerApp;->Companion:Lau/gov/health/covidsafe/TracerApp$Companion;

    invoke-virtual {v2}, Lau/gov/health/covidsafe/TracerApp$Companion;->getAppContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Lau/gov/health/covidsafe/Preference;->putPhoneNumber(Landroid/content/Context;Ljava/lang/String;)V

    .line 39
    iput-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter;->phoneNumber:Ljava/lang/String;

    .line 40
    invoke-direct {p0, p1}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter;->makeOTPCall(Ljava/lang/String;)V

    goto :goto_0

    .line 42
    :cond_1
    iget-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter;->enterNumberFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;->showInvalidPhoneNumber()V

    :goto_0
    return-void
.end method

.method public final validateAuNumber$app_release(Ljava/lang/String;)Z
    .locals 6

    .line 77
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter;->enterNumberFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;

    invoke-virtual {v0}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0b0003

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v0

    const/4 v1, 0x1

    const/4 v2, 0x0

    if-eqz p1, :cond_0

    const/4 v3, 0x2

    const/4 v4, 0x0

    const-string v5, "0"

    .line 78
    invoke-static {p1, v5, v2, v3, v4}, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z

    move-result v3

    if-ne v3, v1, :cond_0

    add-int/lit8 v0, v0, 0x1

    :cond_0
    if-eqz p1, :cond_1

    .line 81
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result p1

    goto :goto_0

    :cond_1
    move p1, v2

    :goto_0
    if-ne p1, v0, :cond_2

    goto :goto_1

    :cond_2
    move v1, v2

    :goto_1
    return v1
.end method
