.class final Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity$showLoading$1;
.super Lkotlin/jvm/internal/Lambda;
.source "OnboardingActivity.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function1;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity;->showLoading()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lkotlin/jvm/internal/Lambda;",
        "Lkotlin/jvm/functions/Function1<",
        "Lcom/github/razir/progressbutton/ProgressParams;",
        "Lkotlin/Unit;",
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
        "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n\u00a2\u0006\u0002\u0008\u0003"
    }
    d2 = {
        "<anonymous>",
        "",
        "Lcom/github/razir/progressbutton/ProgressParams;",
        "invoke"
    }
    k = 0x3
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# static fields
.field public static final INSTANCE:Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity$showLoading$1;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity$showLoading$1;

    invoke-direct {v0}, Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity$showLoading$1;-><init>()V

    sput-object v0, Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity$showLoading$1;->INSTANCE:Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity$showLoading$1;

    return-void
.end method

.method constructor <init>()V
    .locals 1

    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lkotlin/jvm/internal/Lambda;-><init>(I)V

    return-void
.end method


# virtual methods
.method public bridge synthetic invoke(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 0

    .line 20
    check-cast p1, Lcom/github/razir/progressbutton/ProgressParams;

    invoke-virtual {p0, p1}, Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity$showLoading$1;->invoke(Lcom/github/razir/progressbutton/ProgressParams;)V

    sget-object p1, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p1
.end method

.method public final invoke(Lcom/github/razir/progressbutton/ProgressParams;)V
    .locals 1

    const-string v0, "$receiver"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const v0, 0x7f0600cd

    .line 92
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/github/razir/progressbutton/ProgressParams;->setProgressColorRes(Ljava/lang/Integer;)V

    return-void
.end method
