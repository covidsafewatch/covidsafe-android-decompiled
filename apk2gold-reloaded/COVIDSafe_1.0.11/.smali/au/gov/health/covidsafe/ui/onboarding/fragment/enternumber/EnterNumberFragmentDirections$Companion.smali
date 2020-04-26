.class public final Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragmentDirections$Companion;
.super Ljava/lang/Object;
.source "EnterNumberFragmentDirections.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragmentDirections;
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
        "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0008\u001a\u00020\u0006\u00a8\u0006\t"
    }
    d2 = {
        "Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragmentDirections$Companion;",
        "",
        "()V",
        "actionEnterNumberFragmentToOtpFragment",
        "Landroidx/navigation/NavDirections;",
        "session",
        "",
        "challengeName",
        "phoneNumber",
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

    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public synthetic constructor <init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    .locals 0

    .line 26
    invoke-direct {p0}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragmentDirections$Companion;-><init>()V

    return-void
.end method


# virtual methods
.method public final actionEnterNumberFragmentToOtpFragment(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroidx/navigation/NavDirections;
    .locals 1

    const-string v0, "phoneNumber"

    invoke-static {p3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 31
    new-instance v0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragmentDirections$ActionEnterNumberFragmentToOtpFragment;

    invoke-direct {v0, p1, p2, p3}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragmentDirections$ActionEnterNumberFragmentToOtpFragment;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    check-cast v0, Landroidx/navigation/NavDirections;

    return-object v0
.end method
