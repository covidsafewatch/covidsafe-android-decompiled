.class public final Lau/gov/health/covidsafe/ui/home/HomeFragment;
.super Lau/gov/health/covidsafe/ui/BaseFragment;
.source "HomeFragment.kt"

# interfaces
.implements Lpub/devrel/easypermissions/EasyPermissions$PermissionCallbacks;


# annotations
.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nHomeFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HomeFragment.kt\nau/gov/health/covidsafe/ui/home/HomeFragment\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,307:1\n253#2,2:308\n253#2,2:310\n253#2,2:312\n*E\n*S KotlinDebug\n*F\n+ 1 HomeFragment.kt\nau/gov/health/covidsafe/ui/home/HomeFragment\n*L\n175#1,2:308\n176#1,2:310\n182#1,2:312\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010!\n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\u0008\u000e\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0008\u0010\u000c\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0002J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0002J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0002J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0002J\u0008\u0010\u0014\u001a\u00020\u0015H\u0002J\u0008\u0010\u0016\u001a\u00020\u0015H\u0002J\u0012\u0010\u0017\u001a\u00020\u00152\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0008\u0010 \u001a\u00020\u0015H\u0016J\u0008\u0010!\u001a\u00020\u0015H\u0016J\u001e\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u00052\u000c\u0010$\u001a\u0008\u0012\u0004\u0012\u00020\u000e0%H\u0016J\u001e\u0010&\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u00052\u000c\u0010$\u001a\u0008\u0012\u0004\u0012\u00020\u000e0%H\u0016J-\u0010\'\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u00052\u000e\u0010(\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u000e0)2\u0006\u0010*\u001a\u00020+H\u0016\u00a2\u0006\u0002\u0010,J\u0008\u0010-\u001a\u00020\u0015H\u0016J\u001a\u0010.\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u001b2\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0008\u00100\u001a\u00020\u0015H\u0002J\u0008\u00101\u001a\u00020\u0015H\u0002J\u0008\u00102\u001a\u00020\u0015H\u0002J\u0008\u00103\u001a\u00020\u0015H\u0002J\u0008\u00104\u001a\u00020\u0015H\u0002J\u0008\u00105\u001a\u00020\u0015H\u0002J\u0008\u00106\u001a\u00020\u0015H\u0002J\u0008\u00107\u001a\u00020\u0015H\u0002J\u0008\u00108\u001a\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00069"
    }
    d2 = {
        "Lau/gov/health/covidsafe/ui/home/HomeFragment;",
        "Lau/gov/health/covidsafe/ui/BaseFragment;",
        "Lpub/devrel/easypermissions/EasyPermissions$PermissionCallbacks;",
        "()V",
        "counter",
        "",
        "mBroadcastListener",
        "Landroid/content/BroadcastReceiver;",
        "mIsBroadcastListenerRegistered",
        "",
        "presenter",
        "Lau/gov/health/covidsafe/ui/home/HomePresenter;",
        "allPermissionsEnabled",
        "formatBlueToothTitle",
        "",
        "on",
        "formatLocationTitle",
        "formatNonBatteryOptimizationTitle",
        "formatPushNotificationTitle",
        "getPermissionEnabledTitle",
        "goToCovidApp",
        "",
        "goToNewsWebsite",
        "onCreate",
        "savedInstanceState",
        "Landroid/os/Bundle;",
        "onCreateView",
        "Landroid/view/View;",
        "inflater",
        "Landroid/view/LayoutInflater;",
        "container",
        "Landroid/view/ViewGroup;",
        "onDestroyView",
        "onPause",
        "onPermissionsDenied",
        "requestCode",
        "perms",
        "",
        "onPermissionsGranted",
        "onRequestPermissionsResult",
        "permissions",
        "",
        "grantResults",
        "",
        "(I[Ljava/lang/String;[I)V",
        "onResume",
        "onViewCreated",
        "view",
        "refreshActionCards",
        "refreshSetupCompleteOrIncompleteUi",
        "refreshUploadedCard",
        "registerBroadcast",
        "shareThisApp",
        "updateBatteryOptimizationStatus",
        "updateBlueToothStatus",
        "updateLocationStatus",
        "updatePushNotificationStatus",
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

.field private counter:I

.field private final mBroadcastListener:Landroid/content/BroadcastReceiver;

.field private mIsBroadcastListenerRegistered:Z

.field private presenter:Lau/gov/health/covidsafe/ui/home/HomePresenter;


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 34
    invoke-direct {p0}, Lau/gov/health/covidsafe/ui/BaseFragment;-><init>()V

    .line 42
    new-instance v0, Lau/gov/health/covidsafe/ui/home/HomeFragment$mBroadcastListener$1;

    invoke-direct {v0, p0}, Lau/gov/health/covidsafe/ui/home/HomeFragment$mBroadcastListener$1;-><init>(Lau/gov/health/covidsafe/ui/home/HomeFragment;)V

    check-cast v0, Landroid/content/BroadcastReceiver;

    iput-object v0, p0, Lau/gov/health/covidsafe/ui/home/HomeFragment;->mBroadcastListener:Landroid/content/BroadcastReceiver;

    return-void
.end method

.method public static final synthetic access$formatBlueToothTitle(Lau/gov/health/covidsafe/ui/home/HomeFragment;Z)Ljava/lang/String;
    .locals 0

    .line 34
    invoke-direct {p0, p1}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->formatBlueToothTitle(Z)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static final synthetic access$getCounter$p(Lau/gov/health/covidsafe/ui/home/HomeFragment;)I
    .locals 0

    .line 34
    iget p0, p0, Lau/gov/health/covidsafe/ui/home/HomeFragment;->counter:I

    return p0
.end method

.method public static final synthetic access$goToCovidApp(Lau/gov/health/covidsafe/ui/home/HomeFragment;)V
    .locals 0

    .line 34
    invoke-direct {p0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->goToCovidApp()V

    return-void
.end method

.method public static final synthetic access$goToNewsWebsite(Lau/gov/health/covidsafe/ui/home/HomeFragment;)V
    .locals 0

    .line 34
    invoke-direct {p0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->goToNewsWebsite()V

    return-void
.end method

.method public static final synthetic access$refreshSetupCompleteOrIncompleteUi(Lau/gov/health/covidsafe/ui/home/HomeFragment;)V
    .locals 0

    .line 34
    invoke-direct {p0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->refreshSetupCompleteOrIncompleteUi()V

    return-void
.end method

.method public static final synthetic access$setCounter$p(Lau/gov/health/covidsafe/ui/home/HomeFragment;I)V
    .locals 0

    .line 34
    iput p1, p0, Lau/gov/health/covidsafe/ui/home/HomeFragment;->counter:I

    return-void
.end method

.method public static final synthetic access$shareThisApp(Lau/gov/health/covidsafe/ui/home/HomeFragment;)V
    .locals 0

    .line 34
    invoke-direct {p0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->shareThisApp()V

    return-void
.end method

.method private final allPermissionsEnabled()Z
    .locals 5

    .line 186
    invoke-static {p0}, Lau/gov/health/covidsafe/extensions/PermissionExtensionsKt;->isBlueToothEnabled(Landroidx/fragment/app/Fragment;)Ljava/lang/Boolean;

    move-result-object v0

    const/4 v1, 0x1

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    goto :goto_0

    :cond_0
    move v0, v1

    .line 187
    :goto_0
    invoke-static {p0}, Lau/gov/health/covidsafe/extensions/PermissionExtensionsKt;->isPushNotificationEnabled(Landroidx/fragment/app/Fragment;)Ljava/lang/Boolean;

    move-result-object v2

    if-eqz v2, :cond_1

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    goto :goto_1

    :cond_1
    move v2, v1

    .line 188
    :goto_1
    invoke-static {p0}, Lau/gov/health/covidsafe/extensions/PermissionExtensionsKt;->isNonBatteryOptimizationAllowed(Landroidx/fragment/app/Fragment;)Ljava/lang/Boolean;

    move-result-object v3

    if-eqz v3, :cond_2

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    goto :goto_2

    :cond_2
    move v3, v1

    .line 189
    :goto_2
    invoke-static {p0}, Lau/gov/health/covidsafe/extensions/PermissionExtensionsKt;->isFineLocationEnabled(Landroidx/fragment/app/Fragment;)Ljava/lang/Boolean;

    move-result-object v4

    if-eqz v4, :cond_3

    invoke-virtual {v4}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    goto :goto_3

    :cond_3
    move v4, v1

    :goto_3
    if-eqz v0, :cond_4

    if-eqz v2, :cond_4

    if-eqz v3, :cond_4

    if-eqz v4, :cond_4

    goto :goto_4

    :cond_4
    const/4 v1, 0x0

    :goto_4
    return v1
.end method

.method private final formatBlueToothTitle(Z)Ljava/lang/String;
    .locals 3

    .line 254
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    invoke-direct {p0, p1}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->getPermissionEnabledTitle(Z)Ljava/lang/String;

    move-result-object p1

    const/4 v2, 0x0

    aput-object p1, v1, v2

    const p1, 0x7f130050

    invoke-virtual {v0, p1, v1}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    const-string v0, "resources.getString(R.st\u2026rmissionEnabledTitle(on))"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    return-object p1
.end method

.method private final formatLocationTitle(Z)Ljava/lang/String;
    .locals 3

    .line 258
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    invoke-direct {p0, p1}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->getPermissionEnabledTitle(Z)Ljava/lang/String;

    move-result-object p1

    const/4 v2, 0x0

    aput-object p1, v1, v2

    const p1, 0x7f130058

    invoke-virtual {v0, p1, v1}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    const-string v0, "resources.getString(R.st\u2026rmissionEnabledTitle(on))"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    return-object p1
.end method

.method private final formatNonBatteryOptimizationTitle(Z)Ljava/lang/String;
    .locals 3

    .line 262
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    invoke-direct {p0, p1}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->getPermissionEnabledTitle(Z)Ljava/lang/String;

    move-result-object p1

    const/4 v2, 0x0

    aput-object p1, v1, v2

    const p1, 0x7f130059

    invoke-virtual {v0, p1, v1}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    const-string v0, "resources.getString(R.st\u2026rmissionEnabledTitle(on))"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    return-object p1
.end method

.method private final formatPushNotificationTitle(Z)Ljava/lang/String;
    .locals 3

    .line 266
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    invoke-direct {p0, p1}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->getPermissionEnabledTitle(Z)Ljava/lang/String;

    move-result-object p1

    const/4 v2, 0x0

    aput-object p1, v1, v2

    const p1, 0x7f13005c

    invoke-virtual {v0, p1, v1}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    const-string v0, "resources.getString(R.st\u2026rmissionEnabledTitle(on))"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    return-object p1
.end method

.method private final getPermissionEnabledTitle(Z)Ljava/lang/String;
    .locals 1

    .line 270
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    if-eqz p1, :cond_0

    const p1, 0x7f13005b

    goto :goto_0

    :cond_0
    const p1, 0x7f13005a

    :goto_0
    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object p1

    const-string v0, "resources.getString(if (\u2026ring.home_permission_off)"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    return-object p1
.end method

.method private final goToCovidApp()V
    .locals 3

    const v0, 0x7f130061

    .line 282
    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    const-string v1, "getString(R.string.home_\u2026te_external_link_app_url)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 283
    new-instance v1, Landroid/content/Intent;

    const-string v2, "android.intent.action.VIEW"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 284
    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 285
    invoke-virtual {p0, v1}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->startActivity(Landroid/content/Intent;)V

    return-void
.end method

.method private final goToNewsWebsite()V
    .locals 3

    const v0, 0x7f130064

    .line 274
    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    const-string v1, "getString(R.string.home_\u2026e_external_link_news_url)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 275
    new-instance v1, Landroid/content/Intent;

    const-string v2, "android.intent.action.VIEW"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 276
    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 277
    invoke-virtual {p0, v1}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->startActivity(Landroid/content/Intent;)V

    return-void
.end method

.method private final refreshActionCards()V
    .locals 5

    .line 167
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    const/4 v1, 0x0

    if-eqz v0, :cond_0

    .line 168
    sget-object v2, Lau/gov/health/covidsafe/Preference;->INSTANCE:Lau/gov/health/covidsafe/Preference;

    const-string v3, "it"

    invoke-static {v0, v3}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Lau/gov/health/covidsafe/Preference;->isDataUploaded(Landroid/content/Context;)Z

    move-result v0

    goto :goto_0

    .line 169
    :cond_0
    move-object v0, p0

    check-cast v0, Lau/gov/health/covidsafe/ui/home/HomeFragment;

    move v0, v1

    :goto_0
    if-eqz v0, :cond_1

    .line 173
    invoke-direct {p0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->refreshUploadedCard()V

    .line 175
    :cond_1
    sget v2, Lau/gov/health/covidsafe/R$id;->home_setup_complete_been_tested:I

    invoke-virtual {p0, v2}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroidx/cardview/widget/CardView;

    const-string v3, "home_setup_complete_been_tested"

    invoke-static {v2, v3}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v2, Landroid/view/View;

    xor-int/lit8 v3, v0, 0x1

    const/16 v4, 0x8

    if-eqz v3, :cond_2

    move v3, v1

    goto :goto_1

    :cond_2
    move v3, v4

    .line 308
    :goto_1
    invoke-virtual {v2, v3}, Landroid/view/View;->setVisibility(I)V

    .line 176
    sget v2, Lau/gov/health/covidsafe/R$id;->home_setup_complete_uploaded_card:I

    invoke-virtual {p0, v2}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroidx/cardview/widget/CardView;

    const-string v3, "home_setup_complete_uploaded_card"

    invoke-static {v2, v3}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v2, Landroid/view/View;

    if-eqz v0, :cond_3

    goto :goto_2

    :cond_3
    move v1, v4

    .line 310
    :goto_2
    invoke-virtual {v2, v1}, Landroid/view/View;->setVisibility(I)V

    return-void
.end method

.method private final refreshSetupCompleteOrIncompleteUi()V
    .locals 8

    .line 146
    invoke-direct {p0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->allPermissionsEnabled()Z

    move-result v0

    const-string v1, "content_setup_incomplete_group"

    const-string v2, "content_setup_complete"

    const-string v3, "header_setup_incomplete"

    const-string v4, "header_setup_complete"

    const/4 v5, 0x0

    const/16 v6, 0x8

    if-eqz v0, :cond_0

    .line 147
    sget v0, Lau/gov/health/covidsafe/R$id;->header_setup_complete:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/widget/Group;

    invoke-static {v0, v4}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v0, v5}, Landroidx/constraintlayout/widget/Group;->setVisibility(I)V

    .line 148
    sget v0, Lau/gov/health/covidsafe/R$id;->header_setup_incomplete:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/widget/Group;

    invoke-static {v0, v3}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v0, v6}, Landroidx/constraintlayout/widget/Group;->setVisibility(I)V

    .line 149
    sget v0, Lau/gov/health/covidsafe/R$id;->content_setup_complete:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/widget/Group;

    invoke-static {v0, v2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v0, v5}, Landroidx/constraintlayout/widget/Group;->setVisibility(I)V

    .line 150
    sget v0, Lau/gov/health/covidsafe/R$id;->content_setup_incomplete_group:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/widget/Group;

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v0, v6}, Landroidx/constraintlayout/widget/Group;->setVisibility(I)V

    .line 151
    invoke-direct {p0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->refreshActionCards()V

    goto :goto_0

    .line 153
    :cond_0
    sget v0, Lau/gov/health/covidsafe/R$id;->home_setup_complete_been_tested:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroidx/cardview/widget/CardView;

    const-string v7, "home_setup_complete_been_tested"

    invoke-static {v0, v7}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v0, v6}, Landroidx/cardview/widget/CardView;->setVisibility(I)V

    .line 154
    sget v0, Lau/gov/health/covidsafe/R$id;->home_setup_complete_uploaded_card:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroidx/cardview/widget/CardView;

    const-string v7, "home_setup_complete_uploaded_card"

    invoke-static {v0, v7}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v0, v6}, Landroidx/cardview/widget/CardView;->setVisibility(I)V

    .line 155
    sget v0, Lau/gov/health/covidsafe/R$id;->header_setup_complete:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/widget/Group;

    invoke-static {v0, v4}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v0, v6}, Landroidx/constraintlayout/widget/Group;->setVisibility(I)V

    .line 156
    sget v0, Lau/gov/health/covidsafe/R$id;->header_setup_incomplete:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/widget/Group;

    invoke-static {v0, v3}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v0, v5}, Landroidx/constraintlayout/widget/Group;->setVisibility(I)V

    .line 157
    sget v0, Lau/gov/health/covidsafe/R$id;->content_setup_complete:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/widget/Group;

    invoke-static {v0, v2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v0, v6}, Landroidx/constraintlayout/widget/Group;->setVisibility(I)V

    .line 158
    sget v0, Lau/gov/health/covidsafe/R$id;->content_setup_incomplete_group:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/widget/Group;

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v0, v5}, Landroidx/constraintlayout/widget/Group;->setVisibility(I)V

    .line 159
    invoke-direct {p0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->updateBlueToothStatus()V

    .line 160
    invoke-direct {p0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->updatePushNotificationStatus()V

    .line 161
    invoke-direct {p0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->updateBatteryOptimizationStatus()V

    .line 162
    invoke-direct {p0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->updateLocationStatus()V

    :goto_0
    return-void
.end method

.method private final refreshUploadedCard()V
    .locals 2

    .line 180
    sget v0, Lau/gov/health/covidsafe/R$id;->home_data_uploaded_icon:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    const v1, 0x7f080078

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 181
    sget v0, Lau/gov/health/covidsafe/R$id;->home_data_uploaded_title:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    const v1, 0x7f130053

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 182
    sget v0, Lau/gov/health/covidsafe/R$id;->home_data_uploaded_message:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    const-string v1, "home_data_uploaded_message"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Landroid/view/View;

    const/16 v1, 0x8

    .line 312
    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    return-void
.end method

.method private final registerBroadcast()V
    .locals 3

    .line 198
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 199
    new-instance v1, Landroid/content/IntentFilter;

    invoke-direct {v1}, Landroid/content/IntentFilter;-><init>()V

    .line 200
    iget-object v2, p0, Lau/gov/health/covidsafe/ui/home/HomeFragment;->mBroadcastListener:Landroid/content/BroadcastReceiver;

    invoke-virtual {v0, v2, v1}, Landroidx/fragment/app/FragmentActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 202
    new-instance v1, Landroid/content/IntentFilter;

    invoke-direct {v1}, Landroid/content/IntentFilter;-><init>()V

    const-string v2, "android.bluetooth.adapter.action.STATE_CHANGED"

    .line 203
    invoke-virtual {v1, v2}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 204
    iget-object v2, p0, Lau/gov/health/covidsafe/ui/home/HomeFragment;->mBroadcastListener:Landroid/content/BroadcastReceiver;

    invoke-virtual {v0, v2, v1}, Landroidx/fragment/app/FragmentActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    const/4 v0, 0x1

    .line 205
    iput-boolean v0, p0, Lau/gov/health/covidsafe/ui/home/HomeFragment;->mIsBroadcastListenerRegistered:Z

    :cond_0
    return-void
.end method

.method private final shareThisApp()V
    .locals 3

    .line 210
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.SEND"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    const-string v1, "text/plain"

    .line 211
    invoke-virtual {v0, v1}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    const v1, 0x7f1300d5

    .line 212
    invoke-virtual {p0, v1}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    const-string v2, "android.intent.extra.TEXT"

    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    const v1, 0x7f1300d6

    .line 213
    invoke-virtual {p0, v1}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    const-string v2, "android.intent.extra.HTML_TEXT"

    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    const/4 v1, 0x0

    .line 214
    invoke-static {v0, v1}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->startActivity(Landroid/content/Intent;)V

    return-void
.end method

.method private final updateBatteryOptimizationStatus()V
    .locals 3

    .line 236
    invoke-static {p0}, Lau/gov/health/covidsafe/extensions/PermissionExtensionsKt;->isNonBatteryOptimizationAllowed(Landroidx/fragment/app/Fragment;)Ljava/lang/Boolean;

    move-result-object v0

    const-string v1, "battery_card_view"

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    .line 237
    sget v2, Lau/gov/health/covidsafe/R$id;->battery_card_view:I

    invoke-virtual {p0, v2}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lau/gov/health/covidsafe/ui/home/view/PermissionStatusCard;

    invoke-static {v2, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v1, 0x0

    invoke-virtual {v2, v1}, Lau/gov/health/covidsafe/ui/home/view/PermissionStatusCard;->setVisibility(I)V

    .line 238
    sget v1, Lau/gov/health/covidsafe/R$id;->battery_card_view:I

    invoke-virtual {p0, v1}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lau/gov/health/covidsafe/ui/home/view/PermissionStatusCard;

    xor-int/lit8 v2, v0, 0x1

    invoke-direct {p0, v2}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->formatNonBatteryOptimizationTitle(Z)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Lau/gov/health/covidsafe/ui/home/view/PermissionStatusCard;->render(Ljava/lang/String;Z)V

    goto :goto_0

    .line 239
    :cond_0
    move-object v0, p0

    check-cast v0, Lau/gov/health/covidsafe/ui/home/HomeFragment;

    .line 240
    sget v2, Lau/gov/health/covidsafe/R$id;->battery_card_view:I

    invoke-virtual {v0, v2}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lau/gov/health/covidsafe/ui/home/view/PermissionStatusCard;

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lau/gov/health/covidsafe/ui/home/view/PermissionStatusCard;->setVisibility(I)V

    :goto_0
    return-void
.end method

.method private final updateBlueToothStatus()V
    .locals 3

    .line 218
    invoke-static {p0}, Lau/gov/health/covidsafe/extensions/PermissionExtensionsKt;->isBlueToothEnabled(Landroidx/fragment/app/Fragment;)Ljava/lang/Boolean;

    move-result-object v0

    const-string v1, "bluetooth_card_view"

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    .line 219
    sget v2, Lau/gov/health/covidsafe/R$id;->bluetooth_card_view:I

    invoke-virtual {p0, v2}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lau/gov/health/covidsafe/ui/home/view/PermissionStatusCard;

    invoke-static {v2, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v1, 0x0

    invoke-virtual {v2, v1}, Lau/gov/health/covidsafe/ui/home/view/PermissionStatusCard;->setVisibility(I)V

    .line 220
    sget v1, Lau/gov/health/covidsafe/R$id;->bluetooth_card_view:I

    invoke-virtual {p0, v1}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lau/gov/health/covidsafe/ui/home/view/PermissionStatusCard;

    invoke-direct {p0, v0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->formatBlueToothTitle(Z)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Lau/gov/health/covidsafe/ui/home/view/PermissionStatusCard;->render(Ljava/lang/String;Z)V

    goto :goto_0

    .line 221
    :cond_0
    move-object v0, p0

    check-cast v0, Lau/gov/health/covidsafe/ui/home/HomeFragment;

    .line 222
    sget v2, Lau/gov/health/covidsafe/R$id;->bluetooth_card_view:I

    invoke-virtual {v0, v2}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lau/gov/health/covidsafe/ui/home/view/PermissionStatusCard;

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lau/gov/health/covidsafe/ui/home/view/PermissionStatusCard;->setVisibility(I)V

    :goto_0
    return-void
.end method

.method private final updateLocationStatus()V
    .locals 4

    .line 245
    invoke-static {p0}, Lau/gov/health/covidsafe/extensions/PermissionExtensionsKt;->isFineLocationEnabled(Landroidx/fragment/app/Fragment;)Ljava/lang/Boolean;

    move-result-object v0

    const/4 v1, 0x0

    const-string v2, "location_card_view"

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    .line 246
    sget v3, Lau/gov/health/covidsafe/R$id;->location_card_view:I

    invoke-virtual {p0, v3}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lau/gov/health/covidsafe/ui/home/view/PermissionStatusCard;

    invoke-static {v3, v2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v3, v1}, Lau/gov/health/covidsafe/ui/home/view/PermissionStatusCard;->setVisibility(I)V

    .line 247
    sget v1, Lau/gov/health/covidsafe/R$id;->location_card_view:I

    invoke-virtual {p0, v1}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lau/gov/health/covidsafe/ui/home/view/PermissionStatusCard;

    invoke-direct {p0, v0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->formatLocationTitle(Z)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Lau/gov/health/covidsafe/ui/home/view/PermissionStatusCard;->render(Ljava/lang/String;Z)V

    goto :goto_0

    .line 248
    :cond_0
    move-object v0, p0

    check-cast v0, Lau/gov/health/covidsafe/ui/home/HomeFragment;

    .line 249
    sget v3, Lau/gov/health/covidsafe/R$id;->location_card_view:I

    invoke-virtual {v0, v3}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lau/gov/health/covidsafe/ui/home/view/PermissionStatusCard;

    invoke-static {v0, v2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lau/gov/health/covidsafe/ui/home/view/PermissionStatusCard;->setVisibility(I)V

    :goto_0
    return-void
.end method

.method private final updatePushNotificationStatus()V
    .locals 3

    .line 227
    invoke-static {p0}, Lau/gov/health/covidsafe/extensions/PermissionExtensionsKt;->isPushNotificationEnabled(Landroidx/fragment/app/Fragment;)Ljava/lang/Boolean;

    move-result-object v0

    const-string v1, "push_card_view"

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    .line 228
    sget v2, Lau/gov/health/covidsafe/R$id;->push_card_view:I

    invoke-virtual {p0, v2}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lau/gov/health/covidsafe/ui/home/view/PermissionStatusCard;

    invoke-static {v2, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v1, 0x0

    invoke-virtual {v2, v1}, Lau/gov/health/covidsafe/ui/home/view/PermissionStatusCard;->setVisibility(I)V

    .line 229
    sget v1, Lau/gov/health/covidsafe/R$id;->push_card_view:I

    invoke-virtual {p0, v1}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lau/gov/health/covidsafe/ui/home/view/PermissionStatusCard;

    invoke-direct {p0, v0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->formatPushNotificationTitle(Z)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Lau/gov/health/covidsafe/ui/home/view/PermissionStatusCard;->render(Ljava/lang/String;Z)V

    goto :goto_0

    .line 230
    :cond_0
    move-object v0, p0

    check-cast v0, Lau/gov/health/covidsafe/ui/home/HomeFragment;

    .line 231
    sget v2, Lau/gov/health/covidsafe/R$id;->push_card_view:I

    invoke-virtual {v0, v2}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lau/gov/health/covidsafe/ui/home/view/PermissionStatusCard;

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lau/gov/health/covidsafe/ui/home/view/PermissionStatusCard;->setVisibility(I)V

    :goto_0
    return-void
.end method


# virtual methods
.method public _$_clearFindViewByIdCache()V
    .locals 1

    iget-object v0, p0, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findViewCache:Ljava/util/HashMap;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    :cond_0
    return-void
.end method

.method public _$_findCachedViewById(I)Landroid/view/View;
    .locals 2

    iget-object v0, p0, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findViewCache:Ljava/util/HashMap;

    if-nez v0, :cond_0

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findViewCache:Ljava/util/HashMap;

    :cond_0
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findViewCache:Ljava/util/HashMap;

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

    iget-object v1, p0, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findViewCache:Ljava/util/HashMap;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    invoke-virtual {v1, p1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_2
    return-object v0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .line 66
    invoke-super {p0, p1}, Lau/gov/health/covidsafe/ui/BaseFragment;->onCreate(Landroid/os/Bundle;)V

    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 1

    const-string p3, "inflater"

    invoke-static {p1, p3}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 74
    new-instance p3, Lau/gov/health/covidsafe/ui/home/HomePresenter;

    invoke-direct {p3, p0}, Lau/gov/health/covidsafe/ui/home/HomePresenter;-><init>(Lau/gov/health/covidsafe/ui/home/HomeFragment;)V

    iput-object p3, p0, Lau/gov/health/covidsafe/ui/home/HomeFragment;->presenter:Lau/gov/health/covidsafe/ui/home/HomePresenter;

    const p3, 0x7f0d003a

    const/4 v0, 0x0

    .line 75
    invoke-virtual {p1, p3, p2, v0}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p1

    return-object p1
.end method

.method public onDestroyView()V
    .locals 1

    .line 141
    invoke-super {p0}, Lau/gov/health/covidsafe/ui/BaseFragment;->onDestroyView()V

    .line 142
    sget v0, Lau/gov/health/covidsafe/R$id;->home_root:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ScrollView;

    invoke-virtual {v0}, Landroid/widget/ScrollView;->removeAllViews()V

    .line 143
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_clearFindViewByIdCache()V

    return-void
.end method

.method public onPause()V
    .locals 2

    .line 124
    invoke-super {p0}, Lau/gov/health/covidsafe/ui/BaseFragment;->onPause()V

    .line 125
    sget v0, Lau/gov/health/covidsafe/R$id;->bluetooth_card_view:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lau/gov/health/covidsafe/ui/home/view/PermissionStatusCard;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lau/gov/health/covidsafe/ui/home/view/PermissionStatusCard;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 126
    sget v0, Lau/gov/health/covidsafe/R$id;->location_card_view:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lau/gov/health/covidsafe/ui/home/view/PermissionStatusCard;

    invoke-virtual {v0, v1}, Lau/gov/health/covidsafe/ui/home/view/PermissionStatusCard;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 127
    sget v0, Lau/gov/health/covidsafe/R$id;->battery_card_view:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lau/gov/health/covidsafe/ui/home/view/PermissionStatusCard;

    invoke-virtual {v0, v1}, Lau/gov/health/covidsafe/ui/home/view/PermissionStatusCard;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 128
    sget v0, Lau/gov/health/covidsafe/R$id;->home_been_tested_button:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 129
    sget v0, Lau/gov/health/covidsafe/R$id;->home_setup_complete_share:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lau/gov/health/covidsafe/ui/home/view/ExternalLinkCard;

    invoke-virtual {v0, v1}, Lau/gov/health/covidsafe/ui/home/view/ExternalLinkCard;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 130
    sget v0, Lau/gov/health/covidsafe/R$id;->home_setup_complete_news:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lau/gov/health/covidsafe/ui/home/view/ExternalLinkCard;

    invoke-virtual {v0, v1}, Lau/gov/health/covidsafe/ui/home/view/ExternalLinkCard;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 131
    sget v0, Lau/gov/health/covidsafe/R$id;->home_setup_complete_app:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lau/gov/health/covidsafe/ui/home/view/ExternalLinkCard;

    invoke-virtual {v0, v1}, Lau/gov/health/covidsafe/ui/home/view/ExternalLinkCard;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 132
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 133
    iget-boolean v1, p0, Lau/gov/health/covidsafe/ui/home/HomeFragment;->mIsBroadcastListenerRegistered:Z

    if-eqz v1, :cond_0

    .line 134
    iget-object v1, p0, Lau/gov/health/covidsafe/ui/home/HomeFragment;->mBroadcastListener:Landroid/content/BroadcastReceiver;

    invoke-virtual {v0, v1}, Landroidx/fragment/app/FragmentActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    const/4 v0, 0x0

    .line 135
    iput-boolean v0, p0, Lau/gov/health/covidsafe/ui/home/HomeFragment;->mIsBroadcastListenerRegistered:Z

    :cond_0
    return-void
.end method

.method public onPermissionsDenied(ILjava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    const-string v0, "perms"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const/16 p2, 0x159

    if-ne p1, p2, :cond_0

    .line 290
    move-object p1, p0

    check-cast p1, Landroidx/fragment/app/Fragment;

    const-string p2, "android.permission.ACCESS_FINE_LOCATION"

    invoke-static {p2}, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;

    move-result-object p2

    invoke-static {p1, p2}, Lpub/devrel/easypermissions/EasyPermissions;->somePermissionPermanentlyDenied(Landroidx/fragment/app/Fragment;Ljava/util/List;)Z

    move-result p2

    if-eqz p2, :cond_0

    .line 291
    new-instance p2, Lpub/devrel/easypermissions/AppSettingsDialog$Builder;

    invoke-direct {p2, p1}, Lpub/devrel/easypermissions/AppSettingsDialog$Builder;-><init>(Landroidx/fragment/app/Fragment;)V

    invoke-virtual {p2}, Lpub/devrel/easypermissions/AppSettingsDialog$Builder;->build()Lpub/devrel/easypermissions/AppSettingsDialog;

    move-result-object p1

    invoke-virtual {p1}, Lpub/devrel/easypermissions/AppSettingsDialog;->show()V

    :cond_0
    return-void
.end method

.method public onPermissionsGranted(ILjava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    const-string v0, "perms"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const/16 p2, 0x159

    if-ne p1, p2, :cond_0

    .line 297
    invoke-static {p0}, Lau/gov/health/covidsafe/extensions/PermissionExtensionsKt;->checkBLESupport(Landroidx/fragment/app/Fragment;)V

    :cond_0
    return-void
.end method

.method public onRequestPermissionsResult(I[Ljava/lang/String;[I)V
    .locals 2

    const-string v0, "permissions"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "grantResults"

    invoke-static {p3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 302
    invoke-super {p0, p1, p2, p3}, Lau/gov/health/covidsafe/ui/BaseFragment;->onRequestPermissionsResult(I[Ljava/lang/String;[I)V

    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    aput-object p0, v0, v1

    .line 303
    invoke-static {p1, p2, p3, v0}, Lpub/devrel/easypermissions/EasyPermissions;->onRequestPermissionsResult(I[Ljava/lang/String;[I[Ljava/lang/Object;)V

    return-void
.end method

.method public onResume()V
    .locals 2

    .line 100
    invoke-super {p0}, Lau/gov/health/covidsafe/ui/BaseFragment;->onResume()V

    .line 101
    sget v0, Lau/gov/health/covidsafe/R$id;->bluetooth_card_view:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lau/gov/health/covidsafe/ui/home/view/PermissionStatusCard;

    new-instance v1, Lau/gov/health/covidsafe/ui/home/HomeFragment$onResume$1;

    invoke-direct {v1, p0}, Lau/gov/health/covidsafe/ui/home/HomeFragment$onResume$1;-><init>(Lau/gov/health/covidsafe/ui/home/HomeFragment;)V

    check-cast v1, Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Lau/gov/health/covidsafe/ui/home/view/PermissionStatusCard;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 102
    sget v0, Lau/gov/health/covidsafe/R$id;->location_card_view:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lau/gov/health/covidsafe/ui/home/view/PermissionStatusCard;

    new-instance v1, Lau/gov/health/covidsafe/ui/home/HomeFragment$onResume$2;

    invoke-direct {v1, p0}, Lau/gov/health/covidsafe/ui/home/HomeFragment$onResume$2;-><init>(Lau/gov/health/covidsafe/ui/home/HomeFragment;)V

    check-cast v1, Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Lau/gov/health/covidsafe/ui/home/view/PermissionStatusCard;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 103
    sget v0, Lau/gov/health/covidsafe/R$id;->battery_card_view:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lau/gov/health/covidsafe/ui/home/view/PermissionStatusCard;

    new-instance v1, Lau/gov/health/covidsafe/ui/home/HomeFragment$onResume$3;

    invoke-direct {v1, p0}, Lau/gov/health/covidsafe/ui/home/HomeFragment$onResume$3;-><init>(Lau/gov/health/covidsafe/ui/home/HomeFragment;)V

    check-cast v1, Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Lau/gov/health/covidsafe/ui/home/view/PermissionStatusCard;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 104
    sget v0, Lau/gov/health/covidsafe/R$id;->home_been_tested_button:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    new-instance v1, Lau/gov/health/covidsafe/ui/home/HomeFragment$onResume$4;

    invoke-direct {v1, p0}, Lau/gov/health/covidsafe/ui/home/HomeFragment$onResume$4;-><init>(Lau/gov/health/covidsafe/ui/home/HomeFragment;)V

    check-cast v1, Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 107
    sget v0, Lau/gov/health/covidsafe/R$id;->home_setup_complete_share:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lau/gov/health/covidsafe/ui/home/view/ExternalLinkCard;

    new-instance v1, Lau/gov/health/covidsafe/ui/home/HomeFragment$onResume$5;

    invoke-direct {v1, p0}, Lau/gov/health/covidsafe/ui/home/HomeFragment$onResume$5;-><init>(Lau/gov/health/covidsafe/ui/home/HomeFragment;)V

    check-cast v1, Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Lau/gov/health/covidsafe/ui/home/view/ExternalLinkCard;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 110
    sget v0, Lau/gov/health/covidsafe/R$id;->home_setup_complete_news:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lau/gov/health/covidsafe/ui/home/view/ExternalLinkCard;

    new-instance v1, Lau/gov/health/covidsafe/ui/home/HomeFragment$onResume$6;

    invoke-direct {v1, p0}, Lau/gov/health/covidsafe/ui/home/HomeFragment$onResume$6;-><init>(Lau/gov/health/covidsafe/ui/home/HomeFragment;)V

    check-cast v1, Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Lau/gov/health/covidsafe/ui/home/view/ExternalLinkCard;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 113
    sget v0, Lau/gov/health/covidsafe/R$id;->home_setup_complete_app:I

    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lau/gov/health/covidsafe/ui/home/view/ExternalLinkCard;

    new-instance v1, Lau/gov/health/covidsafe/ui/home/HomeFragment$onResume$7;

    invoke-direct {v1, p0}, Lau/gov/health/covidsafe/ui/home/HomeFragment$onResume$7;-><init>(Lau/gov/health/covidsafe/ui/home/HomeFragment;)V

    check-cast v1, Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Lau/gov/health/covidsafe/ui/home/view/ExternalLinkCard;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 117
    iget-boolean v0, p0, Lau/gov/health/covidsafe/ui/home/HomeFragment;->mIsBroadcastListenerRegistered:Z

    if-nez v0, :cond_0

    .line 118
    invoke-direct {p0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->registerBroadcast()V

    .line 120
    :cond_0
    invoke-direct {p0}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->refreshSetupCompleteOrIncompleteUi()V

    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 2

    const-string v0, "view"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 79
    invoke-super {p0, p1, p2}, Lau/gov/health/covidsafe/ui/BaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 80
    sget p2, Lau/gov/health/covidsafe/R$id;->home_header_help:I

    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroid/widget/TextView;

    new-instance p2, Lau/gov/health/covidsafe/ui/home/HomeFragment$onViewCreated$1;

    invoke-direct {p2, p0}, Lau/gov/health/covidsafe/ui/home/HomeFragment$onViewCreated$1;-><init>(Lau/gov/health/covidsafe/ui/home/HomeFragment;)V

    check-cast p2, Landroid/view/View$OnClickListener;

    invoke-virtual {p1, p2}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 92
    sget p1, Lau/gov/health/covidsafe/R$id;->home_version_number:I

    invoke-virtual {p0, p1}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroid/widget/TextView;

    const-string p2, "home_version_number"

    invoke-static {p1, p2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 p2, 0x1

    new-array p2, p2, [Ljava/lang/Object;

    const/4 v0, 0x0

    const-string v1, "1.0.11"

    aput-object v1, p2, v0

    const v0, 0x7f13006b

    invoke-virtual {p0, v0, p2}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p2

    check-cast p2, Ljava/lang/CharSequence;

    invoke-virtual {p1, p2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 93
    sget p1, Lau/gov/health/covidsafe/R$id;->home_header_label_setup_complete_disclaimer_content:I

    invoke-virtual {p0, p1}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroid/widget/TextView;

    const-string p2, "home_header_label_setup_\u2026mplete_disclaimer_content"

    invoke-static {p1, p2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    new-instance v0, Lau/gov/health/covidsafe/ui/home/HomeFragment$onViewCreated$3;

    invoke-direct {v0, p0}, Lau/gov/health/covidsafe/ui/home/HomeFragment$onViewCreated$3;-><init>(Lau/gov/health/covidsafe/ui/home/HomeFragment;)V

    check-cast v0, Lkotlin/jvm/functions/Function0;

    const-string v1, "FAQ"

    invoke-static {p1, v1, v0}, Lau/gov/health/covidsafe/extensions/ViewExtensionsKt;->toHyperlink(Landroid/widget/TextView;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V

    .line 96
    sget p1, Lau/gov/health/covidsafe/R$id;->home_header_label_setup_complete_disclaimer_content:I

    invoke-virtual {p0, p1}, Lau/gov/health/covidsafe/ui/home/HomeFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroid/widget/TextView;

    invoke-static {p1, p2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object p2

    invoke-virtual {p1, p2}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    return-void
.end method
