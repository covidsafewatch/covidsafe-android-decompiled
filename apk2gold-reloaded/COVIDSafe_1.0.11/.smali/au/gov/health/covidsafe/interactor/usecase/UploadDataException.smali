.class public abstract Lau/gov/health/covidsafe/interactor/usecase/UploadDataException;
.super Ljava/lang/Exception;
.source "UploadData.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lau/gov/health/covidsafe/interactor/usecase/UploadDataException$UploadDataIncorrectPinException;,
        Lau/gov/health/covidsafe/interactor/usecase/UploadDataException$UploadDataJwtExpiredException;
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0002\u0004\u0005B\u0007\u0008\u0002\u00a2\u0006\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007\u00a8\u0006\u0008"
    }
    d2 = {
        "Lau/gov/health/covidsafe/interactor/usecase/UploadDataException;",
        "Ljava/lang/Exception;",
        "Lkotlin/Exception;",
        "()V",
        "UploadDataIncorrectPinException",
        "UploadDataJwtExpiredException",
        "Lau/gov/health/covidsafe/interactor/usecase/UploadDataException$UploadDataIncorrectPinException;",
        "Lau/gov/health/covidsafe/interactor/usecase/UploadDataException$UploadDataJwtExpiredException;",
        "app_release"
    }
    k = 0x1
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .line 84
    invoke-direct {p0}, Ljava/lang/Exception;-><init>()V

    return-void
.end method

.method public synthetic constructor <init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    .locals 0

    .line 84
    invoke-direct {p0}, Lau/gov/health/covidsafe/interactor/usecase/UploadDataException;-><init>()V

    return-void
.end method
