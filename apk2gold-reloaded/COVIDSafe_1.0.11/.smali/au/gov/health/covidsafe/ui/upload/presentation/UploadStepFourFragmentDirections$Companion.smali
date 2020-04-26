.class public final Lau/gov/health/covidsafe/ui/upload/presentation/UploadStepFourFragmentDirections$Companion;
.super Ljava/lang/Object;
.source "UploadStepFourFragmentDirections.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lau/gov/health/covidsafe/ui/upload/presentation/UploadStepFourFragmentDirections;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Companion"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"
    }
    d2 = {
        "Lau/gov/health/covidsafe/ui/upload/presentation/UploadStepFourFragmentDirections$Companion;",
        "",
        "()V",
        "actionUploadStepFourFragmentToVerifyUploadPinFragment",
        "Landroidx/navigation/NavDirections;",
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

    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public synthetic constructor <init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    .locals 0

    .line 8
    invoke-direct {p0}, Lau/gov/health/covidsafe/ui/upload/presentation/UploadStepFourFragmentDirections$Companion;-><init>()V

    return-void
.end method


# virtual methods
.method public final actionUploadStepFourFragmentToVerifyUploadPinFragment()Landroidx/navigation/NavDirections;
    .locals 2

    .line 10
    new-instance v0, Landroidx/navigation/ActionOnlyNavDirections;

    const v1, 0x7f0a004b

    invoke-direct {v0, v1}, Landroidx/navigation/ActionOnlyNavDirections;-><init>(I)V

    check-cast v0, Landroidx/navigation/NavDirections;

    return-object v0
.end method
