.class public final Lau/gov/health/covidsafe/ui/home/HomePresenter;
.super Ljava/lang/Object;
.source "HomePresenter.kt"

# interfaces
.implements Landroidx/lifecycle/LifecycleObserver;


# annotations
.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"
    }
    d2 = {
        "Lau/gov/health/covidsafe/ui/home/HomePresenter;",
        "Landroidx/lifecycle/LifecycleObserver;",
        "fragment",
        "Lau/gov/health/covidsafe/ui/home/HomeFragment;",
        "(Lau/gov/health/covidsafe/ui/home/HomeFragment;)V",
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
.field private final fragment:Lau/gov/health/covidsafe/ui/home/HomeFragment;


# direct methods
.method public constructor <init>(Lau/gov/health/covidsafe/ui/home/HomeFragment;)V
    .locals 1

    const-string v0, "fragment"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lau/gov/health/covidsafe/ui/home/HomePresenter;->fragment:Lau/gov/health/covidsafe/ui/home/HomeFragment;

    .line 8
    invoke-virtual {p1}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->getLifecycle()Landroidx/lifecycle/Lifecycle;

    move-result-object p1

    move-object v0, p0

    check-cast v0, Landroidx/lifecycle/LifecycleObserver;

    invoke-virtual {p1, v0}, Landroidx/lifecycle/Lifecycle;->addObserver(Landroidx/lifecycle/LifecycleObserver;)V

    return-void
.end method
