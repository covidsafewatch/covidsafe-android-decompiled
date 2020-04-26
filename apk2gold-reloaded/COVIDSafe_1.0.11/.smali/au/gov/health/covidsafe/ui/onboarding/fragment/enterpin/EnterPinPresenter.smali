.class public final Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;
.super Ljava/lang/Object;
.source "EnterPinPresenter.kt"

# interfaces
.implements Landroidx/lifecycle/LifecycleObserver;


# annotations
.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nEnterPinPresenter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EnterPinPresenter.kt\nau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter\n*L\n1#1,101:1\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0008J\u0008\u0010\u000e\u001a\u00020\u000fH\u0003J\u0008\u0010\u0010\u001a\u00020\u000fH\u0002J\r\u0010\u0011\u001a\u00020\u000fH\u0000\u00a2\u0006\u0002\u0008\u0012J\u0015\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0005H\u0000\u00a2\u0006\u0002\u0008\u0015R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"
    }
    d2 = {
        "Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;",
        "Landroidx/lifecycle/LifecycleObserver;",
        "enterPinFragment",
        "Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;",
        "session",
        "",
        "challengeName",
        "phoneNumber",
        "(Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V",
        "TAG",
        "awsClient",
        "Lau/gov/health/covidsafe/networking/service/AwsClient;",
        "getOtp",
        "Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtp;",
        "onCreate",
        "",
        "onError",
        "resendCode",
        "resendCode$app_release",
        "validateOTP",
        "otp",
        "validateOTP$app_release",
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

.field private awsClient:Lau/gov/health/covidsafe/networking/service/AwsClient;

.field private challengeName:Ljava/lang/String;

.field private final enterPinFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;

.field private getOtp:Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtp;

.field private final phoneNumber:Ljava/lang/String;

.field private session:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    const-string v0, "enterPinFragment"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;->enterPinFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;

    iput-object p2, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;->session:Ljava/lang/String;

    iput-object p3, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;->challengeName:Ljava/lang/String;

    iput-object p4, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;->phoneNumber:Ljava/lang/String;

    .line 23
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object p1

    const-string p2, "this.javaClass.simpleName"

    invoke-static {p1, p2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    iput-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;->TAG:Ljava/lang/String;

    .line 25
    sget-object p1, Lau/gov/health/covidsafe/factory/NetworkFactory;->Companion:Lau/gov/health/covidsafe/factory/NetworkFactory$Companion;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/factory/NetworkFactory$Companion;->getAwsClient()Lau/gov/health/covidsafe/networking/service/AwsClient;

    move-result-object p1

    iput-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;->awsClient:Lau/gov/health/covidsafe/networking/service/AwsClient;

    .line 29
    iget-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;->enterPinFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;->getLifecycle()Landroidx/lifecycle/Lifecycle;

    move-result-object p1

    move-object p2, p0

    check-cast p2, Landroidx/lifecycle/LifecycleObserver;

    invoke-virtual {p1, p2}, Landroidx/lifecycle/Lifecycle;->addObserver(Landroidx/lifecycle/LifecycleObserver;)V

    return-void
.end method

.method public static final synthetic access$getChallengeName$p(Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;)Ljava/lang/String;
    .locals 0

    .line 18
    iget-object p0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;->challengeName:Ljava/lang/String;

    return-object p0
.end method

.method public static final synthetic access$getEnterPinFragment$p(Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;)Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;
    .locals 0

    .line 18
    iget-object p0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;->enterPinFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;

    return-object p0
.end method

.method public static final synthetic access$getSession$p(Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;)Ljava/lang/String;
    .locals 0

    .line 18
    iget-object p0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;->session:Ljava/lang/String;

    return-object p0
.end method

.method public static final synthetic access$getTAG$p(Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;)Ljava/lang/String;
    .locals 0

    .line 18
    iget-object p0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;->TAG:Ljava/lang/String;

    return-object p0
.end method

.method public static final synthetic access$onError(Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;)V
    .locals 0

    .line 18
    invoke-direct {p0}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;->onError()V

    return-void
.end method

.method public static final synthetic access$setChallengeName$p(Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;Ljava/lang/String;)V
    .locals 0

    .line 18
    iput-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;->challengeName:Ljava/lang/String;

    return-void
.end method

.method public static final synthetic access$setSession$p(Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;Ljava/lang/String;)V
    .locals 0

    .line 18
    iput-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;->session:Ljava/lang/String;

    return-void
.end method

.method private final onCreate()V
    .locals 4
    .annotation runtime Landroidx/lifecycle/OnLifecycleEvent;
        value = .enum Landroidx/lifecycle/Lifecycle$Event;->ON_CREATE:Landroidx/lifecycle/Lifecycle$Event;
    .end annotation

    .line 34
    new-instance v0, Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtp;

    iget-object v1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;->awsClient:Lau/gov/health/covidsafe/networking/service/AwsClient;

    iget-object v2, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;->enterPinFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;

    invoke-virtual {v2}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;->getLifecycle()Landroidx/lifecycle/Lifecycle;

    move-result-object v2

    const-string v3, "enterPinFragment.lifecycle"

    invoke-static {v2, v3}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {v0, v1, v2}, Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtp;-><init>(Lau/gov/health/covidsafe/networking/service/AwsClient;Landroidx/lifecycle/Lifecycle;)V

    iput-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;->getOtp:Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtp;

    return-void
.end method

.method private final onError()V
    .locals 1

    .line 96
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;->enterPinFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;

    invoke-virtual {v0}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;->enableContinueButton()V

    .line 97
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;->enterPinFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;

    invoke-virtual {v0}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;->hideLoading()V

    .line 98
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;->enterPinFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;

    invoke-virtual {v0}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;->hideKeyboard()V

    .line 99
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;->enterPinFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;

    invoke-virtual {v0}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;->showInvalidOtp()V

    return-void
.end method


# virtual methods
.method public final resendCode$app_release()V
    .locals 9

    .line 38
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;->enterPinFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;

    invoke-virtual {v0}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 39
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;->phoneNumber:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 40
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;->enterPinFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;

    invoke-virtual {v0}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;->showGenericError()V

    goto :goto_0

    .line 42
    :cond_0
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;->getOtp:Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtp;

    if-nez v0, :cond_1

    const-string v1, "getOtp"

    invoke-static {v1}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    :cond_1
    new-instance v1, Lau/gov/health/covidsafe/interactor/usecase/GetOtpParams;

    iget-object v3, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;->phoneNumber:Ljava/lang/String;

    .line 43
    sget-object v2, Lau/gov/health/covidsafe/Preference;->INSTANCE:Lau/gov/health/covidsafe/Preference;

    iget-object v4, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;->enterPinFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;

    invoke-virtual {v4}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;->requireContext()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v2, v4}, Lau/gov/health/covidsafe/Preference;->getDeviceID(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v4

    .line 44
    sget-object v2, Lau/gov/health/covidsafe/Preference;->INSTANCE:Lau/gov/health/covidsafe/Preference;

    iget-object v5, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;->enterPinFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;

    invoke-virtual {v5}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;->requireContext()Landroid/content/Context;

    move-result-object v5

    const-string v6, "enterPinFragment.requireContext()"

    invoke-static {v5, v6}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v2, v5}, Lau/gov/health/covidsafe/Preference;->getPostCode(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v5

    .line 45
    sget-object v2, Lau/gov/health/covidsafe/Preference;->INSTANCE:Lau/gov/health/covidsafe/Preference;

    iget-object v7, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;->enterPinFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;

    invoke-virtual {v7}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;->requireContext()Landroid/content/Context;

    move-result-object v7

    invoke-static {v7, v6}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v2, v7}, Lau/gov/health/covidsafe/Preference;->getAge(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v7

    .line 46
    sget-object v2, Lau/gov/health/covidsafe/Preference;->INSTANCE:Lau/gov/health/covidsafe/Preference;

    iget-object v8, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;->enterPinFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;

    invoke-virtual {v8}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;->requireContext()Landroid/content/Context;

    move-result-object v8

    invoke-static {v8, v6}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v2, v8}, Lau/gov/health/covidsafe/Preference;->getName(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v8

    move-object v2, v1

    move-object v6, v7

    move-object v7, v8

    .line 42
    invoke-direct/range {v2 .. v7}, Lau/gov/health/covidsafe/interactor/usecase/GetOtpParams;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 47
    new-instance v2, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter$resendCode$$inlined$let$lambda$1;

    invoke-direct {v2, p0}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter$resendCode$$inlined$let$lambda$1;-><init>(Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;)V

    check-cast v2, Lkotlin/jvm/functions/Function1;

    .line 52
    new-instance v3, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter$resendCode$$inlined$let$lambda$2;

    invoke-direct {v3, p0}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter$resendCode$$inlined$let$lambda$2;-><init>(Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;)V

    check-cast v3, Lkotlin/jvm/functions/Function1;

    .line 42
    invoke-virtual {v0, v1, v2, v3}, Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtp;->invoke(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V

    :cond_2
    :goto_0
    return-void
.end method

.method public final validateOTP$app_release(Ljava/lang/String;)V
    .locals 3

    const-string v0, "otp"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 60
    move-object v0, p1

    check-cast v0, Ljava/lang/CharSequence;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    const/4 v1, 0x6

    if-eq v0, v1, :cond_0

    goto :goto_0

    .line 64
    :cond_0
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;->enterPinFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;

    invoke-virtual {v0}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;->disableContinueButton()V

    .line 65
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;->enterPinFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;

    invoke-virtual {v0}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;->showLoading()V

    .line 66
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;->awsClient:Lau/gov/health/covidsafe/networking/service/AwsClient;

    new-instance v1, Lau/gov/health/covidsafe/networking/request/AuthChallengeRequest;

    iget-object v2, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;->session:Ljava/lang/String;

    invoke-direct {v1, v2, p1}, Lau/gov/health/covidsafe/networking/request/AuthChallengeRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Lau/gov/health/covidsafe/networking/service/AwsClient;->respondToAuthChallenge(Lau/gov/health/covidsafe/networking/request/AuthChallengeRequest;)Lretrofit2/Call;

    move-result-object p1

    .line 67
    new-instance v0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter$validateOTP$1;

    invoke-direct {v0, p0}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter$validateOTP$1;-><init>(Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;)V

    check-cast v0, Lretrofit2/Callback;

    invoke-interface {p1, v0}, Lretrofit2/Call;->enqueue(Lretrofit2/Callback;)V

    return-void

    .line 61
    :cond_1
    :goto_0
    iget-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;->enterPinFragment:Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;->showErrorOtpMustBeSixDigits()V

    return-void
.end method
