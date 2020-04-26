.class public Lau/gov/health/covidsafe/ui/BaseFragment;
.super Landroidx/fragment/app/Fragment;
.source "BaseFragment.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00082\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u0004J\u0008\u0010\u000b\u001a\u00020\u0004H\u0016J\u0008\u0010\u000c\u001a\u00020\u0004H\u0004\u00a8\u0006\r"
    }
    d2 = {
        "Lau/gov/health/covidsafe/ui/BaseFragment;",
        "Landroidx/fragment/app/Fragment;",
        "()V",
        "navigateTo",
        "",
        "actionId",
        "",
        "bundle",
        "Landroid/os/Bundle;",
        "navigatorExtras",
        "Landroidx/navigation/Navigator$Extras;",
        "onResume",
        "popBackStack",
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
.field private _$_findViewCache:Ljava/util/HashMap;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9
    invoke-direct {p0}, Landroidx/fragment/app/Fragment;-><init>()V

    return-void
.end method

.method public static synthetic navigateTo$default(Lau/gov/health/covidsafe/ui/BaseFragment;ILandroid/os/Bundle;Landroidx/navigation/Navigator$Extras;ILjava/lang/Object;)V
    .locals 1

    if-nez p5, :cond_2

    and-int/lit8 p5, p4, 0x2

    const/4 v0, 0x0

    if-eqz p5, :cond_0

    .line 19
    move-object p2, v0

    check-cast p2, Landroid/os/Bundle;

    :cond_0
    and-int/lit8 p4, p4, 0x4

    if-eqz p4, :cond_1

    move-object p3, v0

    check-cast p3, Landroidx/navigation/Navigator$Extras;

    :cond_1
    invoke-virtual {p0, p1, p2, p3}, Lau/gov/health/covidsafe/ui/BaseFragment;->navigateTo(ILandroid/os/Bundle;Landroidx/navigation/Navigator$Extras;)V

    return-void

    .line 0
    :cond_2
    new-instance p0, Ljava/lang/UnsupportedOperationException;

    const-string p1, "Super calls with default arguments not supported in this target, function: navigateTo"

    invoke-direct {p0, p1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw p0
.end method


# virtual methods
.method public _$_clearFindViewByIdCache()V
    .locals 1

    iget-object v0, p0, Lau/gov/health/covidsafe/ui/BaseFragment;->_$_findViewCache:Ljava/util/HashMap;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    :cond_0
    return-void
.end method

.method public _$_findCachedViewById(I)Landroid/view/View;
    .locals 2

    iget-object v0, p0, Lau/gov/health/covidsafe/ui/BaseFragment;->_$_findViewCache:Ljava/util/HashMap;

    if-nez v0, :cond_0

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lau/gov/health/covidsafe/ui/BaseFragment;->_$_findViewCache:Ljava/util/HashMap;

    :cond_0
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/BaseFragment;->_$_findViewCache:Ljava/util/HashMap;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    if-nez v0, :cond_2

    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->getView()Landroid/view/View;

    move-result-object v0

    if-nez v0, :cond_1

    const/4 p1, 0x0

    return-object p1

    :cond_1
    invoke-virtual {v0, p1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iget-object v1, p0, Lau/gov/health/covidsafe/ui/BaseFragment;->_$_findViewCache:Ljava/util/HashMap;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    invoke-virtual {v1, p1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_2
    return-object v0
.end method

.method protected final navigateTo(ILandroid/os/Bundle;Landroidx/navigation/Navigator$Extras;)V
    .locals 2

    .line 20
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/BaseFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v0

    .line 21
    instance-of v1, v0, Lau/gov/health/covidsafe/HasBlockingState;

    if-eqz v1, :cond_0

    .line 22
    check-cast v0, Lau/gov/health/covidsafe/HasBlockingState;

    const/4 v1, 0x1

    invoke-interface {v0, v1}, Lau/gov/health/covidsafe/HasBlockingState;->setUiBlocked(Z)V

    .line 24
    :cond_0
    move-object v0, p0

    check-cast v0, Landroidx/fragment/app/Fragment;

    invoke-static {v0}, Landroidx/navigation/fragment/NavHostFragment;->findNavController(Landroidx/fragment/app/Fragment;)Landroidx/navigation/NavController;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, p1, p2, v1, p3}, Landroidx/navigation/NavController;->navigate(ILandroid/os/Bundle;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V

    return-void
.end method

.method public synthetic onDestroyView()V
    .locals 0

    invoke-super {p0}, Landroidx/fragment/app/Fragment;->onDestroyView()V

    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/BaseFragment;->_$_clearFindViewByIdCache()V

    return-void
.end method

.method public onResume()V
    .locals 2

    .line 12
    invoke-super {p0}, Landroidx/fragment/app/Fragment;->onResume()V

    .line 13
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/BaseFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v0

    .line 14
    instance-of v1, v0, Lau/gov/health/covidsafe/HasBlockingState;

    if-eqz v1, :cond_0

    .line 15
    check-cast v0, Lau/gov/health/covidsafe/HasBlockingState;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Lau/gov/health/covidsafe/HasBlockingState;->setUiBlocked(Z)V

    :cond_0
    return-void
.end method

.method protected final popBackStack()V
    .locals 2

    .line 28
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/BaseFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v0

    .line 29
    instance-of v1, v0, Lau/gov/health/covidsafe/HasBlockingState;

    if-eqz v1, :cond_0

    .line 30
    check-cast v0, Lau/gov/health/covidsafe/HasBlockingState;

    const/4 v1, 0x1

    invoke-interface {v0, v1}, Lau/gov/health/covidsafe/HasBlockingState;->setUiBlocked(Z)V

    .line 32
    :cond_0
    move-object v0, p0

    check-cast v0, Landroidx/fragment/app/Fragment;

    invoke-static {v0}, Landroidx/navigation/fragment/NavHostFragment;->findNavController(Landroidx/fragment/app/Fragment;)Landroidx/navigation/NavController;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/navigation/NavController;->popBackStack()Z

    return-void
.end method
