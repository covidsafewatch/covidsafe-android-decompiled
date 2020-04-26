.class public abstract Lau/gov/health/covidsafe/interactor/Either;
.super Ljava/lang/Object;
.source "Either.kt"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<F:",
        "Ljava/lang/Object;",
        "S:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u0001*\u0006\u0008\u0001\u0010\u0002 \u00012\u00020\u0003B\u0007\u0008\u0002\u00a2\u0006\u0002\u0010\u0004J<\u0010\u0005\u001a\u0002H\u0006\"\u0004\u0008\u0002\u0010\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00060\u00082\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u0002H\u00060\u0008H\u0086\u0008\u00a2\u0006\u0002\u0010\n\u0082\u0001\u0002\u000b\u000c\u00a8\u0006\r"
    }
    d2 = {
        "Lau/gov/health/covidsafe/interactor/Either;",
        "F",
        "S",
        "",
        "()V",
        "fold",
        "T",
        "failed",
        "Lkotlin/Function1;",
        "succeeded",
        "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;",
        "Lau/gov/health/covidsafe/interactor/Failure;",
        "Lau/gov/health/covidsafe/interactor/Success;",
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

    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public synthetic constructor <init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    .locals 0

    .line 3
    invoke-direct {p0}, Lau/gov/health/covidsafe/interactor/Either;-><init>()V

    return-void
.end method


# virtual methods
.method public final fold(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lkotlin/jvm/functions/Function1<",
            "-TF;+TT;>;",
            "Lkotlin/jvm/functions/Function1<",
            "-TS;+TT;>;)TT;"
        }
    .end annotation

    const-string v0, "failed"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "succeeded"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 7
    instance-of v0, p0, Lau/gov/health/covidsafe/interactor/Failure;

    if-eqz v0, :cond_0

    move-object p2, p0

    check-cast p2, Lau/gov/health/covidsafe/interactor/Failure;

    invoke-virtual {p2}, Lau/gov/health/covidsafe/interactor/Failure;->getFailure()Ljava/lang/Object;

    move-result-object p2

    invoke-interface {p1, p2}, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    goto :goto_0

    .line 8
    :cond_0
    instance-of p1, p0, Lau/gov/health/covidsafe/interactor/Success;

    if-eqz p1, :cond_1

    move-object p1, p0

    check-cast p1, Lau/gov/health/covidsafe/interactor/Success;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/interactor/Success;->getSuccess()Ljava/lang/Object;

    move-result-object p1

    invoke-interface {p2, p1}, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    :goto_0
    return-object p1

    :cond_1
    new-instance p1, Lkotlin/NoWhenBranchMatchedException;

    invoke-direct {p1}, Lkotlin/NoWhenBranchMatchedException;-><init>()V

    throw p1
.end method
