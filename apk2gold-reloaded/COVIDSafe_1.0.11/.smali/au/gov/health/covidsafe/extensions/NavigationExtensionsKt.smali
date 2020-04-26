.class public final Lau/gov/health/covidsafe/extensions/NavigationExtensionsKt;
.super Ljava/lang/Object;
.source "NavigationExtensions.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0008\u00a8\u0006\t"
    }
    d2 = {
        "navigateTo",
        "",
        "Landroidx/fragment/app/Fragment;",
        "actionId",
        "",
        "bundle",
        "Landroid/os/Bundle;",
        "navigatorExtras",
        "Landroidx/navigation/Navigator$Extras;",
        "app_release"
    }
    k = 0x2
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# direct methods
.method public static final navigateTo(Landroidx/fragment/app/Fragment;ILandroid/os/Bundle;Landroidx/navigation/Navigator$Extras;)V
    .locals 1

    const-string v0, "$this$navigateTo"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 8
    invoke-static {p0}, Landroidx/navigation/fragment/NavHostFragment;->findNavController(Landroidx/fragment/app/Fragment;)Landroidx/navigation/NavController;

    move-result-object p0

    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, v0, p3}, Landroidx/navigation/NavController;->navigate(ILandroid/os/Bundle;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V

    return-void
.end method

.method public static synthetic navigateTo$default(Landroidx/fragment/app/Fragment;ILandroid/os/Bundle;Landroidx/navigation/Navigator$Extras;ILjava/lang/Object;)V
    .locals 1

    and-int/lit8 p5, p4, 0x2

    const/4 v0, 0x0

    if-eqz p5, :cond_0

    .line 8
    move-object p2, v0

    check-cast p2, Landroid/os/Bundle;

    :cond_0
    and-int/lit8 p4, p4, 0x4

    if-eqz p4, :cond_1

    move-object p3, v0

    check-cast p3, Landroidx/navigation/Navigator$Extras;

    :cond_1
    invoke-static {p0, p1, p2, p3}, Lau/gov/health/covidsafe/extensions/NavigationExtensionsKt;->navigateTo(Landroidx/fragment/app/Fragment;ILandroid/os/Bundle;Landroidx/navigation/Navigator$Extras;)V

    return-void
.end method
