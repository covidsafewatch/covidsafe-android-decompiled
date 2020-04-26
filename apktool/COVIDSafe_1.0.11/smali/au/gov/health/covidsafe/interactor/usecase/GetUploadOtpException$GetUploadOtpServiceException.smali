.class public final Lau/gov/health/covidsafe/interactor/usecase/GetUploadOtpException$GetUploadOtpServiceException;
.super Lau/gov/health/covidsafe/interactor/usecase/GetUploadOtpException;
.source "GetUploadOtp.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lau/gov/health/covidsafe/interactor/usecase/GetUploadOtpException;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "GetUploadOtpServiceException"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006\u00a8\u0006\u0008"
    }
    d2 = {
        "Lau/gov/health/covidsafe/interactor/usecase/GetUploadOtpException$GetUploadOtpServiceException;",
        "Lau/gov/health/covidsafe/interactor/usecase/GetUploadOtpException;",
        "code",
        "",
        "(Ljava/lang/Integer;)V",
        "getCode",
        "()Ljava/lang/Integer;",
        "Ljava/lang/Integer;",
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
.field private final code:Ljava/lang/Integer;


# direct methods
.method public constructor <init>(Ljava/lang/Integer;)V
    .locals 1

    const/4 v0, 0x0

    .line 33
    invoke-direct {p0, v0}, Lau/gov/health/covidsafe/interactor/usecase/GetUploadOtpException;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V

    iput-object p1, p0, Lau/gov/health/covidsafe/interactor/usecase/GetUploadOtpException$GetUploadOtpServiceException;->code:Ljava/lang/Integer;

    return-void
.end method


# virtual methods
.method public final getCode()Ljava/lang/Integer;
    .locals 1

    .line 33
    iget-object v0, p0, Lau/gov/health/covidsafe/interactor/usecase/GetUploadOtpException$GetUploadOtpServiceException;->code:Ljava/lang/Integer;

    return-object v0
.end method
