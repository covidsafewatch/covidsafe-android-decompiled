.class public final Lau/gov/health/covidsafe/interactor/UseCaseKt;
.super Ljava/lang/Object;
.source "UseCase.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u0008\n\u0000\n\u0002\u0010\u0008\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0002"
    }
    d2 = {
        "RETRIES_LIMIT",
        "",
        "app_release"
    }
    k = 0x2
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# static fields
.field private static final RETRIES_LIMIT:I = 0x3


# direct methods
.method static constructor <clinit>()V
    .locals 0

    return-void
.end method

.method public static final synthetic access$getRETRIES_LIMIT$p()I
    .locals 1

    .line 1
    sget v0, Lau/gov/health/covidsafe/interactor/UseCaseKt;->RETRIES_LIMIT:I

    return v0
.end method
