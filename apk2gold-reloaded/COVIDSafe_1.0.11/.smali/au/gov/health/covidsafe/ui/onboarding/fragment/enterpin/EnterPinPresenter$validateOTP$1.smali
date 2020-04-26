.class public final Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter$validateOTP$1;
.super Ljava/lang/Object;
.source "EnterPinPresenter.kt"

# interfaces
.implements Lretrofit2/Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;->validateOTP$app_release(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lretrofit2/Callback<",
        "Lau/gov/health/covidsafe/networking/response/AuthChallengeResponse;",
        ">;"
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nEnterPinPresenter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EnterPinPresenter.kt\nau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter$validateOTP$1\n*L\n1#1,101:1\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001J\u001e\u0010\u0003\u001a\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016J$\u0010\t\u001a\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00062\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u000bH\u0016\u00a8\u0006\u000c"
    }
    d2 = {
        "au/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter$validateOTP$1",
        "Lretrofit2/Callback;",
        "Lau/gov/health/covidsafe/networking/response/AuthChallengeResponse;",
        "onFailure",
        "",
        "call",
        "Lretrofit2/Call;",
        "t",
        "",
        "onResponse",
        "response",
        "Lretrofit2/Response;",
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
.field final synthetic this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;


# direct methods
.method constructor <init>(Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .line 67
    iput-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter$validateOTP$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onFailure(Lretrofit2/Call;Ljava/lang/Throwable;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lretrofit2/Call<",
            "Lau/gov/health/covidsafe/networking/response/AuthChallengeResponse;",
            ">;",
            "Ljava/lang/Throwable;",
            ")V"
        }
    .end annotation

    const-string v0, "call"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p1, "t"

    invoke-static {p2, p1}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 90
    iget-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter$validateOTP$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;

    invoke-static {p1}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;->access$onError(Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;)V

    return-void
.end method

.method public onResponse(Lretrofit2/Call;Lretrofit2/Response;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lretrofit2/Call<",
            "Lau/gov/health/covidsafe/networking/response/AuthChallengeResponse;",
            ">;",
            "Lretrofit2/Response<",
            "Lau/gov/health/covidsafe/networking/response/AuthChallengeResponse;",
            ">;)V"
        }
    .end annotation

    const-string v0, "call"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p1, "response"

    invoke-static {p2, p1}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 69
    invoke-virtual {p2}, Lretrofit2/Response;->code()I

    move-result p1

    const/16 v0, 0xc8

    if-ne p1, v0, :cond_3

    .line 70
    sget-object p1, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter$validateOTP$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;

    invoke-static {v0}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;->access$getTAG$p(Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "code received"

    invoke-virtual {p1, v0, v1}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 72
    invoke-virtual {p2}, Lretrofit2/Response;->body()Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lau/gov/health/covidsafe/networking/response/AuthChallengeResponse;

    const/4 p2, 0x0

    if-eqz p1, :cond_0

    .line 74
    invoke-virtual {p1}, Lau/gov/health/covidsafe/networking/response/AuthChallengeResponse;->getPin()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_0
    move-object v0, p2

    :goto_0
    if-eqz v0, :cond_1

    .line 76
    sget-object v1, Lau/gov/health/covidsafe/Preference;->INSTANCE:Lau/gov/health/covidsafe/Preference;

    iget-object v2, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter$validateOTP$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;

    invoke-static {v2}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;->access$getEnterPinFragment$p(Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;)Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;

    move-result-object v2

    invoke-virtual {v2}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Lau/gov/health/covidsafe/Preference;->putHandShakePin(Landroid/content/Context;Ljava/lang/String;)V

    :cond_1
    if-eqz p1, :cond_2

    .line 78
    invoke-virtual {p1}, Lau/gov/health/covidsafe/networking/response/AuthChallengeResponse;->getToken()Ljava/lang/String;

    move-result-object p2

    .line 80
    :cond_2
    sget-object p1, Lau/gov/health/covidsafe/Preference;->INSTANCE:Lau/gov/health/covidsafe/Preference;

    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter$validateOTP$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;

    invoke-static {v0}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;->access$getEnterPinFragment$p(Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;)Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;

    move-result-object v0

    invoke-virtual {v0}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;->requireContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {p1, v0, p2}, Lau/gov/health/covidsafe/Preference;->putEncrypterJWTToken(Landroid/content/Context;Ljava/lang/String;)V

    .line 82
    iget-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter$validateOTP$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;

    invoke-static {p1}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;->access$getEnterPinFragment$p(Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;)Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;

    move-result-object p1

    invoke-virtual {p1}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;->hideKeyboard()V

    .line 83
    iget-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter$validateOTP$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;

    invoke-static {p1}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;->access$getEnterPinFragment$p(Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;)Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;

    move-result-object p1

    invoke-virtual {p1}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;->navigateToNextPage()V

    goto :goto_1

    .line 85
    :cond_3
    iget-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter$validateOTP$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;

    invoke-static {p1}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;->access$onError(Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter;)V

    :goto_1
    return-void
.end method
