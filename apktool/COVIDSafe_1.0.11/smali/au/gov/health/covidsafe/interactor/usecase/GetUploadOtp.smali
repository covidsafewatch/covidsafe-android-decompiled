.class public final Lau/gov/health/covidsafe/interactor/usecase/GetUploadOtp;
.super Lau/gov/health/covidsafe/interactor/UseCase;
.source "GetUploadOtp.kt"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lau/gov/health/covidsafe/interactor/UseCase<",
        "Lau/gov/health/covidsafe/networking/response/UploadOTPResponse;",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\u0008J+\u0010\n\u001a\u0014\u0012\u0008\u0012\u00060\u000cj\u0002`\r\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0003H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019\u00a8\u0006\u0010"
    }
    d2 = {
        "Lau/gov/health/covidsafe/interactor/usecase/GetUploadOtp;",
        "Lau/gov/health/covidsafe/interactor/UseCase;",
        "Lau/gov/health/covidsafe/networking/response/UploadOTPResponse;",
        "",
        "awsClient",
        "Lau/gov/health/covidsafe/networking/service/AwsClient;",
        "lifecycle",
        "Landroidx/lifecycle/Lifecycle;",
        "(Lau/gov/health/covidsafe/networking/service/AwsClient;Landroidx/lifecycle/Lifecycle;)V",
        "TAG",
        "run",
        "Lau/gov/health/covidsafe/interactor/Either;",
        "Ljava/lang/Exception;",
        "Lkotlin/Exception;",
        "params",
        "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;",
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

    iput-object p1, p0, Lau/gov/health/covidsafe/interactor/usecase/GetUploadOtp;->awsClient:Lau/gov/health/covidsafe/networking/service/AwsClient;

    .line 15
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object p1

    const-string p2, "this.javaClass.simpleName"

    invoke-static {p1, p2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    iput-object p1, p0, Lau/gov/health/covidsafe/interactor/usecase/GetUploadOtp;->TAG:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public bridge synthetic run(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    .locals 0

    .line 12
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1, p2}, Lau/gov/health/covidsafe/interactor/usecase/GetUploadOtp;->run(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method

.method public run(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lkotlin/coroutines/Continuation<",
            "-",
            "Lau/gov/health/covidsafe/interactor/Either<",
            "+",
            "Ljava/lang/Exception;",
            "Lau/gov/health/covidsafe/networking/response/UploadOTPResponse;",
            ">;>;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    .line 19
    :try_start_0
    iget-object p2, p0, Lau/gov/health/covidsafe/interactor/usecase/GetUploadOtp;->awsClient:Lau/gov/health/covidsafe/networking/service/AwsClient;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Bearer "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-interface {p2, p1}, Lau/gov/health/covidsafe/networking/service/AwsClient;->requestUploadOtp(Ljava/lang/String;)Lretrofit2/Call;

    move-result-object p1

    invoke-interface {p1}, Lretrofit2/Call;->execute()Lretrofit2/Response;

    move-result-object p1

    .line 20
    invoke-virtual {p1}, Lretrofit2/Response;->code()I

    move-result p2

    const/16 v0, 0xc8

    if-ne p2, v0, :cond_0

    .line 21
    sget-object p2, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v0, p0, Lau/gov/health/covidsafe/interactor/usecase/GetUploadOtp;->TAG:Ljava/lang/String;

    const-string v1, "onCodeUpload"

    invoke-virtual {p2, v0, v1}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 22
    new-instance p2, Lau/gov/health/covidsafe/interactor/Success;

    invoke-virtual {p1}, Lretrofit2/Response;->body()Ljava/lang/Object;

    move-result-object p1

    invoke-direct {p2, p1}, Lau/gov/health/covidsafe/interactor/Success;-><init>(Ljava/lang/Object;)V

    check-cast p2, Lau/gov/health/covidsafe/interactor/Either;

    goto :goto_0

    .line 24
    :cond_0
    new-instance p2, Lau/gov/health/covidsafe/interactor/Failure;

    new-instance v0, Lau/gov/health/covidsafe/interactor/usecase/GetUploadOtpException$GetUploadOtpServiceException;

    invoke-virtual {p1}, Lretrofit2/Response;->code()I

    move-result p1

    invoke-static {p1}, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;

    move-result-object p1

    invoke-direct {v0, p1}, Lau/gov/health/covidsafe/interactor/usecase/GetUploadOtpException$GetUploadOtpServiceException;-><init>(Ljava/lang/Integer;)V

    invoke-direct {p2, v0}, Lau/gov/health/covidsafe/interactor/Failure;-><init>(Ljava/lang/Object;)V

    check-cast p2, Lau/gov/health/covidsafe/interactor/Either;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-object p2

    :catch_0
    move-exception p1

    .line 27
    new-instance p2, Lau/gov/health/covidsafe/interactor/Failure;

    invoke-direct {p2, p1}, Lau/gov/health/covidsafe/interactor/Failure;-><init>(Ljava/lang/Object;)V

    return-object p2
.end method
