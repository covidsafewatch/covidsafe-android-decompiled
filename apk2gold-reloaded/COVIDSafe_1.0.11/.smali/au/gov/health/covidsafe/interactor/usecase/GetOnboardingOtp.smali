.class public final Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtp;
.super Lau/gov/health/covidsafe/interactor/UseCase;
.source "GetOnboardingOtp.kt"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lau/gov/health/covidsafe/interactor/UseCase<",
        "Lau/gov/health/covidsafe/networking/response/OTPChallengeResponse;",
        "Lau/gov/health/covidsafe/interactor/usecase/GetOtpParams;",
        ">;"
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nGetOnboardingOtp.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GetOnboardingOtp.kt\nau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtp\n*L\n1#1,60:1\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\u0008J)\u0010\u000b\u001a\u0012\u0012\u0008\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u00020\u000c2\u0006\u0010\u000f\u001a\u00020\u0003H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019\u00a8\u0006\u0011"
    }
    d2 = {
        "Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtp;",
        "Lau/gov/health/covidsafe/interactor/UseCase;",
        "Lau/gov/health/covidsafe/networking/response/OTPChallengeResponse;",
        "Lau/gov/health/covidsafe/interactor/usecase/GetOtpParams;",
        "awsClient",
        "Lau/gov/health/covidsafe/networking/service/AwsClient;",
        "lifecycle",
        "Landroidx/lifecycle/Lifecycle;",
        "(Lau/gov/health/covidsafe/networking/service/AwsClient;Landroidx/lifecycle/Lifecycle;)V",
        "TAG",
        "",
        "run",
        "Lau/gov/health/covidsafe/interactor/Either;",
        "Ljava/lang/Exception;",
        "Lkotlin/Exception;",
        "params",
        "(Lau/gov/health/covidsafe/interactor/usecase/GetOtpParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;",
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

.field private final awsClient:Lau/gov/health/covidsafe/networking/service/AwsClient;


# direct methods
.method public constructor <init>(Lau/gov/health/covidsafe/networking/service/AwsClient;Landroidx/lifecycle/Lifecycle;)V
    .locals 1

    const-string v0, "awsClient"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "lifecycle"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 13
    invoke-direct {p0, p2}, Lau/gov/health/covidsafe/interactor/UseCase;-><init>(Landroidx/lifecycle/Lifecycle;)V

    iput-object p1, p0, Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtp;->awsClient:Lau/gov/health/covidsafe/networking/service/AwsClient;

    .line 15
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object p1

    const-string p2, "this.javaClass.simpleName"

    invoke-static {p1, p2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    iput-object p1, p0, Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtp;->TAG:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public run(Lau/gov/health/covidsafe/interactor/usecase/GetOtpParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lau/gov/health/covidsafe/interactor/usecase/GetOtpParams;",
            "Lkotlin/coroutines/Continuation<",
            "-",
            "Lau/gov/health/covidsafe/interactor/Either<",
            "+",
            "Ljava/lang/Exception;",
            "Lau/gov/health/covidsafe/networking/response/OTPChallengeResponse;",
            ">;>;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    .line 19
    :try_start_0
    iget-object p2, p0, Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtp;->awsClient:Lau/gov/health/covidsafe/networking/service/AwsClient;

    .line 20
    new-instance v6, Lau/gov/health/covidsafe/networking/request/OTPChallengeRequest;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/interactor/usecase/GetOtpParams;->getPhoneNumber$app_release()Ljava/lang/String;

    move-result-object v1

    .line 21
    invoke-virtual {p1}, Lau/gov/health/covidsafe/interactor/usecase/GetOtpParams;->getDeviceId$app_release()Ljava/lang/String;

    move-result-object v2

    .line 22
    invoke-virtual {p1}, Lau/gov/health/covidsafe/interactor/usecase/GetOtpParams;->getPostCode$app_release()Ljava/lang/String;

    move-result-object v3

    .line 23
    invoke-virtual {p1}, Lau/gov/health/covidsafe/interactor/usecase/GetOtpParams;->getAge$app_release()Ljava/lang/String;

    move-result-object v4

    .line 24
    invoke-virtual {p1}, Lau/gov/health/covidsafe/interactor/usecase/GetOtpParams;->getName$app_release()Ljava/lang/String;

    move-result-object v5

    move-object v0, v6

    .line 20
    invoke-direct/range {v0 .. v5}, Lau/gov/health/covidsafe/networking/request/OTPChallengeRequest;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 19
    invoke-interface {p2, v6}, Lau/gov/health/covidsafe/networking/service/AwsClient;->initiateAuth(Lau/gov/health/covidsafe/networking/request/OTPChallengeRequest;)Lretrofit2/Call;

    move-result-object p1

    .line 24
    invoke-interface {p1}, Lretrofit2/Call;->execute()Lretrofit2/Response;

    move-result-object p1

    .line 26
    invoke-virtual {p1}, Lretrofit2/Response;->code()I

    move-result p2

    const/16 v0, 0xc8

    if-ne p2, v0, :cond_2

    .line 27
    invoke-virtual {p1}, Lretrofit2/Response;->body()Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Lau/gov/health/covidsafe/networking/response/OTPChallengeResponse;

    if-eqz p2, :cond_1

    .line 28
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v1, p0, Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtp;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "onCodeSent: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Lretrofit2/Response;->body()Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lau/gov/health/covidsafe/networking/response/OTPChallengeResponse;

    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lau/gov/health/covidsafe/networking/response/OTPChallengeResponse;->getChallengeName()Ljava/lang/String;

    move-result-object p1

    goto :goto_0

    :cond_0
    const/4 p1, 0x0

    :goto_0
    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v0, v1, p1}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 29
    new-instance p1, Lau/gov/health/covidsafe/interactor/Success;

    invoke-direct {p1, p2}, Lau/gov/health/covidsafe/interactor/Success;-><init>(Ljava/lang/Object;)V

    .line 27
    check-cast p1, Lau/gov/health/covidsafe/interactor/Either;

    goto :goto_1

    .line 30
    :cond_1
    move-object p2, p0

    check-cast p2, Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtp;

    .line 31
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object p2, p2, Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtp;->TAG:Ljava/lang/String;

    const-string v1, "AWSAuthInvalidBody"

    invoke-virtual {v0, p2, v1}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 32
    new-instance p2, Lau/gov/health/covidsafe/interactor/Failure;

    new-instance v0, Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtpException$GetOtpServiceException;

    invoke-virtual {p1}, Lretrofit2/Response;->code()I

    move-result p1

    invoke-static {p1}, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;

    move-result-object p1

    invoke-direct {v0, p1}, Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtpException$GetOtpServiceException;-><init>(Ljava/lang/Integer;)V

    invoke-direct {p2, v0}, Lau/gov/health/covidsafe/interactor/Failure;-><init>(Ljava/lang/Object;)V

    .line 30
    move-object p1, p2

    check-cast p1, Lau/gov/health/covidsafe/interactor/Either;

    goto :goto_1

    .line 35
    :cond_2
    invoke-virtual {p1}, Lretrofit2/Response;->code()I

    move-result p2

    const/16 v0, 0x190

    if-ne p2, v0, :cond_3

    .line 36
    sget-object p1, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object p2, p0, Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtp;->TAG:Ljava/lang/String;

    const-string v0, "AWSAuthInvalidNumber"

    invoke-virtual {p1, p2, v0}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 37
    new-instance p1, Lau/gov/health/covidsafe/interactor/Failure;

    sget-object p2, Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtpException$GetOtpInvalidNumberException;->INSTANCE:Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtpException$GetOtpInvalidNumberException;

    invoke-direct {p1, p2}, Lau/gov/health/covidsafe/interactor/Failure;-><init>(Ljava/lang/Object;)V

    check-cast p1, Lau/gov/health/covidsafe/interactor/Either;

    goto :goto_1

    .line 40
    :cond_3
    sget-object p2, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v0, p0, Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtp;->TAG:Ljava/lang/String;

    const-string v1, "AWSAuthServiceError"

    invoke-virtual {p2, v0, v1}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 41
    new-instance p2, Lau/gov/health/covidsafe/interactor/Failure;

    new-instance v0, Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtpException$GetOtpServiceException;

    invoke-virtual {p1}, Lretrofit2/Response;->code()I

    move-result p1

    invoke-static {p1}, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;

    move-result-object p1

    invoke-direct {v0, p1}, Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtpException$GetOtpServiceException;-><init>(Ljava/lang/Integer;)V

    invoke-direct {p2, v0}, Lau/gov/health/covidsafe/interactor/Failure;-><init>(Ljava/lang/Object;)V

    move-object p1, p2

    check-cast p1, Lau/gov/health/covidsafe/interactor/Either;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    :catch_0
    move-exception p1

    .line 45
    sget-object p2, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v0, p0, Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtp;->TAG:Ljava/lang/String;

    check-cast p1, Ljava/lang/Throwable;

    const-string v1, "AWSAuthInvalidChallengeRequest"

    invoke-virtual {p2, v0, v1, p1}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 46
    new-instance p1, Lau/gov/health/covidsafe/interactor/Failure;

    sget-object p2, Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtpException$GetOtpInvalidNumberException;->INSTANCE:Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtpException$GetOtpInvalidNumberException;

    invoke-direct {p1, p2}, Lau/gov/health/covidsafe/interactor/Failure;-><init>(Ljava/lang/Object;)V

    check-cast p1, Lau/gov/health/covidsafe/interactor/Either;

    :goto_1
    return-object p1
.end method

.method public bridge synthetic run(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    .locals 0

    .line 13
    check-cast p1, Lau/gov/health/covidsafe/interactor/usecase/GetOtpParams;

    invoke-virtual {p0, p1, p2}, Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtp;->run(Lau/gov/health/covidsafe/interactor/usecase/GetOtpParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method
