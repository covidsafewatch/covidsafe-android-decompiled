.class public interface abstract Lau/gov/health/covidsafe/networking/service/AwsClient;
.super Ljava/lang/Object;
.source "AwsClient.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\n\u0008\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\'J\u0018\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00032\u0008\u0008\u0001\u0010\t\u001a\u00020\nH\'J\u001a\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u00032\n\u0008\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\'J$\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u00032\n\u0008\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0008\u0008\u0001\u0010\u000e\u001a\u00020\u0006H\'J\u001a\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u00032\n\u0008\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\'J\u0018\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u00032\u0008\u0008\u0001\u0010\t\u001a\u00020\u0013H\'\u00a8\u0006\u0014"
    }
    d2 = {
        "Lau/gov/health/covidsafe/networking/service/AwsClient;",
        "",
        "getTempId",
        "Lretrofit2/Call;",
        "Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;",
        "jwtToken",
        "",
        "initiateAuth",
        "Lau/gov/health/covidsafe/networking/response/OTPChallengeResponse;",
        "body",
        "Lau/gov/health/covidsafe/networking/request/OTPChallengeRequest;",
        "initiateReUpload",
        "Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;",
        "initiateUpload",
        "pin",
        "requestUploadOtp",
        "Lau/gov/health/covidsafe/networking/response/UploadOTPResponse;",
        "respondToAuthChallenge",
        "Lau/gov/health/covidsafe/networking/response/AuthChallengeResponse;",
        "Lau/gov/health/covidsafe/networking/request/AuthChallengeRequest;",
        "app_release"
    }
    k = 0x1
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# virtual methods
.method public abstract getTempId(Ljava/lang/String;)Lretrofit2/Call;
    .param p1    # Ljava/lang/String;
        .annotation runtime Lretrofit2/http/Header;
            value = "Authorization"
        .end annotation
    .end param
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Lretrofit2/Call<",
            "Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;",
            ">;"
        }
    .end annotation

    .annotation runtime Lretrofit2/http/GET;
        value = "/prod/getTempId"
    .end annotation
.end method

.method public abstract initiateAuth(Lau/gov/health/covidsafe/networking/request/OTPChallengeRequest;)Lretrofit2/Call;
    .param p1    # Lau/gov/health/covidsafe/networking/request/OTPChallengeRequest;
        .annotation runtime Lretrofit2/http/Body;
        .end annotation
    .end param
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lau/gov/health/covidsafe/networking/request/OTPChallengeRequest;",
            ")",
            "Lretrofit2/Call<",
            "Lau/gov/health/covidsafe/networking/response/OTPChallengeResponse;",
            ">;"
        }
    .end annotation

    .annotation runtime Lretrofit2/http/POST;
        value = "/prod/initiateAuth"
    .end annotation
.end method

.method public abstract initiateReUpload(Ljava/lang/String;)Lretrofit2/Call;
    .param p1    # Ljava/lang/String;
        .annotation runtime Lretrofit2/http/Header;
            value = "Authorization"
        .end annotation
    .end param
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Lretrofit2/Call<",
            "Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;",
            ">;"
        }
    .end annotation

    .annotation runtime Lretrofit2/http/GET;
        value = "/prod/initiateDataUpload"
    .end annotation
.end method

.method public abstract initiateUpload(Ljava/lang/String;Ljava/lang/String;)Lretrofit2/Call;
    .param p1    # Ljava/lang/String;
        .annotation runtime Lretrofit2/http/Header;
            value = "Authorization"
        .end annotation
    .end param
    .param p2    # Ljava/lang/String;
        .annotation runtime Lretrofit2/http/Header;
            value = "pin"
        .end annotation
    .end param
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Lretrofit2/Call<",
            "Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;",
            ">;"
        }
    .end annotation

    .annotation runtime Lretrofit2/http/GET;
        value = "/prod/initiateDataUpload"
    .end annotation
.end method

.method public abstract requestUploadOtp(Ljava/lang/String;)Lretrofit2/Call;
    .param p1    # Ljava/lang/String;
        .annotation runtime Lretrofit2/http/Header;
            value = "Authorization"
        .end annotation
    .end param
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Lretrofit2/Call<",
            "Lau/gov/health/covidsafe/networking/response/UploadOTPResponse;",
            ">;"
        }
    .end annotation

    .annotation runtime Lretrofit2/http/GET;
        value = "/prod/requestUploadOtp"
    .end annotation
.end method

.method public abstract respondToAuthChallenge(Lau/gov/health/covidsafe/networking/request/AuthChallengeRequest;)Lretrofit2/Call;
    .param p1    # Lau/gov/health/covidsafe/networking/request/AuthChallengeRequest;
        .annotation runtime Lretrofit2/http/Body;
        .end annotation
    .end param
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lau/gov/health/covidsafe/networking/request/AuthChallengeRequest;",
            ")",
            "Lretrofit2/Call<",
            "Lau/gov/health/covidsafe/networking/response/AuthChallengeResponse;",
            ">;"
        }
    .end annotation

    .annotation runtime Lretrofit2/http/POST;
        value = "/prod/respondToAuthChallenge"
    .end annotation
.end method
