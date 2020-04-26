.class public final Lau/gov/health/covidsafe/extensions/PermissionExtensionsKt;
.super Ljava/lang/Object;
.source "PermissionExtensions.kt"


# annotations
.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nPermissionExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PermissionExtensions.kt\nau/gov/health/covidsafe/extensions/PermissionExtensionsKt\n*L\n1#1,138:1\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000$\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0008\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006\u001a\n\u0010\u0007\u001a\u00020\u0005*\u00020\u0006\u001a\u001c\u0010\u0008\u001a\u00020\u0005*\u00020\u00062\u0010\u0008\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n\u001a\u0011\u0010\u000b\u001a\u0004\u0018\u00010\u000c*\u00020\u0006\u00a2\u0006\u0002\u0010\r\u001a\u0011\u0010\u000e\u001a\u0004\u0018\u00010\u000c*\u00020\u0006\u00a2\u0006\u0002\u0010\r\u001a\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u000c*\u00020\u0006\u00a2\u0006\u0002\u0010\r\u001a\u0011\u0010\u0010\u001a\u0004\u0018\u00010\u000c*\u00020\u0006\u00a2\u0006\u0002\u0010\r\u001a\u0018\u0010\u0011\u001a\u00020\u0005*\u00020\u00062\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00050\n\u001a\n\u0010\u0012\u001a\u00020\u0005*\u00020\u0006\u001a\u001a\u0010\u0013\u001a\u00020\u0005*\u00020\u00062\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00050\nH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"
    }
    d2 = {
        "BATTERY_OPTIMISER",
        "",
        "LOCATION",
        "REQUEST_ENABLE_BT",
        "askForLocationPermission",
        "",
        "Landroidx/fragment/app/Fragment;",
        "checkBLESupport",
        "excludeFromBatteryOptimization",
        "onEndCallback",
        "Lkotlin/Function0;",
        "isBlueToothEnabled",
        "",
        "(Landroidx/fragment/app/Fragment;)Ljava/lang/Boolean;",
        "isFineLocationEnabled",
        "isNonBatteryOptimizationAllowed",
        "isPushNotificationEnabled",
        "requestAllPermissions",
        "requestBlueToothPermissionThenNextPermission",
        "requestFineLocationAndCheckBleSupportThenNextPermission",
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
.field public static final BATTERY_OPTIMISER:I = 0x315

.field public static final LOCATION:I = 0x159

.field public static final REQUEST_ENABLE_BT:I = 0x7b


# direct methods
.method public static final askForLocationPermission(Landroidx/fragment/app/Fragment;)V
    .locals 3

    const-string v0, "$this$askForLocationPermission"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 121
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 123
    check-cast v0, Landroid/content/Context;

    const-string v1, "android.permission.ACCESS_FINE_LOCATION"

    filled-new-array {v1}, [Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lpub/devrel/easypermissions/EasyPermissions;->hasPermissions(Landroid/content/Context;[Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    .line 126
    :cond_0
    invoke-static {v1}, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    invoke-static {p0, v0}, Lpub/devrel/easypermissions/EasyPermissions;->somePermissionPermanentlyDenied(Landroidx/fragment/app/Fragment;Ljava/util/List;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 127
    new-instance v0, Lpub/devrel/easypermissions/AppSettingsDialog$Builder;

    invoke-direct {v0, p0}, Lpub/devrel/easypermissions/AppSettingsDialog$Builder;-><init>(Landroidx/fragment/app/Fragment;)V

    invoke-virtual {v0}, Lpub/devrel/easypermissions/AppSettingsDialog$Builder;->build()Lpub/devrel/easypermissions/AppSettingsDialog;

    move-result-object p0

    invoke-virtual {p0}, Lpub/devrel/easypermissions/AppSettingsDialog;->show()V

    goto :goto_0

    .line 131
    :cond_1
    new-instance v0, Lpub/devrel/easypermissions/PermissionRequest$Builder;

    const/16 v2, 0x159

    filled-new-array {v1}, [Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, p0, v2, v1}, Lpub/devrel/easypermissions/PermissionRequest$Builder;-><init>(Landroidx/fragment/app/Fragment;I[Ljava/lang/String;)V

    const p0, 0x7f1300b5

    .line 132
    invoke-virtual {v0, p0}, Lpub/devrel/easypermissions/PermissionRequest$Builder;->setRationale(I)Lpub/devrel/easypermissions/PermissionRequest$Builder;

    move-result-object p0

    .line 133
    invoke-virtual {p0}, Lpub/devrel/easypermissions/PermissionRequest$Builder;->build()Lpub/devrel/easypermissions/PermissionRequest;

    move-result-object p0

    .line 130
    invoke-static {p0}, Lpub/devrel/easypermissions/EasyPermissions;->requestPermissions(Lpub/devrel/easypermissions/PermissionRequest;)V

    :cond_2
    :goto_0
    return-void
.end method

.method public static final checkBLESupport(Landroidx/fragment/app/Fragment;)V
    .locals 2

    const-string v0, "$this$checkBLESupport"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 37
    invoke-static {}, Landroid/bluetooth/BluetoothAdapter;->getDefaultAdapter()Landroid/bluetooth/BluetoothAdapter;

    move-result-object v0

    const/4 v1, 0x0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothAdapter;->isMultipleAdvertisementSupported()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v1, 0x1

    :cond_0
    if-eqz v1, :cond_1

    .line 38
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object p0

    if-eqz p0, :cond_1

    .line 39
    sget-object v0, Lau/gov/health/covidsafe/Utils;->INSTANCE:Lau/gov/health/covidsafe/Utils;

    const-string v1, "it"

    invoke-static {p0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast p0, Landroid/content/Context;

    invoke-virtual {v0, p0}, Lau/gov/health/covidsafe/Utils;->stopBluetoothMonitoringService(Landroid/content/Context;)V

    :cond_1
    return-void
.end method

.method public static final excludeFromBatteryOptimization(Landroidx/fragment/app/Fragment;Lkotlin/jvm/functions/Function0;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/fragment/app/Fragment;",
            "Lkotlin/jvm/functions/Function0<",
            "Lkotlin/Unit;",
            ">;)V"
        }
    .end annotation

    const-string v0, "$this$excludeFromBatteryOptimization"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 66
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v0

    if-eqz v0, :cond_3

    const-string v1, "power"

    .line 68
    invoke-virtual {v0, v1}, Landroidx/fragment/app/FragmentActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    if-eqz v1, :cond_2

    check-cast v1, Landroid/os/PowerManager;

    const-string v2, "it"

    .line 69
    invoke-static {v0, v2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v0}, Landroidx/fragment/app/FragmentActivity;->getPackageName()Ljava/lang/String;

    move-result-object v2

    .line 70
    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0x17

    if-lt v3, v4, :cond_3

    .line 71
    sget-object v3, Lau/gov/health/covidsafe/Utils;->INSTANCE:Lau/gov/health/covidsafe/Utils;

    const-string v4, "packageName"

    invoke-static {v2, v4}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v3, v2}, Lau/gov/health/covidsafe/Utils;->getBatteryOptimizerExemptionIntent(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v3

    .line 72
    invoke-virtual {v1, v2}, Landroid/os/PowerManager;->isIgnoringBatteryOptimizations(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 74
    sget-object v1, Lau/gov/health/covidsafe/Utils;->INSTANCE:Lau/gov/health/covidsafe/Utils;

    invoke-virtual {v0}, Landroidx/fragment/app/FragmentActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    invoke-virtual {v1, v3, v0}, Lau/gov/health/covidsafe/Utils;->canHandleIntent(Landroid/content/Intent;Landroid/content/pm/PackageManager;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/16 p1, 0x315

    .line 75
    invoke-virtual {p0, v3, p1}, Landroidx/fragment/app/Fragment;->startActivityForResult(Landroid/content/Intent;I)V

    goto :goto_0

    :cond_0
    if-eqz p1, :cond_3

    .line 78
    invoke-interface {p1}, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Lkotlin/Unit;

    goto :goto_0

    :cond_1
    if-eqz p1, :cond_3

    .line 81
    invoke-interface {p1}, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Lkotlin/Unit;

    goto :goto_0

    .line 68
    :cond_2
    new-instance p0, Lkotlin/TypeCastException;

    const-string p1, "null cannot be cast to non-null type android.os.PowerManager"

    invoke-direct {p0, p1}, Lkotlin/TypeCastException;-><init>(Ljava/lang/String;)V

    throw p0

    :cond_3
    :goto_0
    return-void
.end method

.method public static synthetic excludeFromBatteryOptimization$default(Landroidx/fragment/app/Fragment;Lkotlin/jvm/functions/Function0;ILjava/lang/Object;)V
    .locals 0

    and-int/lit8 p2, p2, 0x1

    if-eqz p2, :cond_0

    const/4 p1, 0x0

    .line 65
    check-cast p1, Lkotlin/jvm/functions/Function0;

    :cond_0
    invoke-static {p0, p1}, Lau/gov/health/covidsafe/extensions/PermissionExtensionsKt;->excludeFromBatteryOptimization(Landroidx/fragment/app/Fragment;Lkotlin/jvm/functions/Function0;)V

    return-void
.end method

.method public static final isBlueToothEnabled(Landroidx/fragment/app/Fragment;)Ljava/lang/Boolean;
    .locals 2

    const-string v0, "$this$isBlueToothEnabled"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 89
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object p0

    const/4 v0, 0x0

    if-eqz p0, :cond_0

    const-string v1, "bluetooth"

    invoke-virtual {p0, v1}, Landroidx/fragment/app/FragmentActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p0

    goto :goto_0

    :cond_0
    move-object p0, v0

    :goto_0
    check-cast p0, Landroid/bluetooth/BluetoothManager;

    if-eqz p0, :cond_1

    .line 90
    invoke-virtual {p0}, Landroid/bluetooth/BluetoothManager;->getAdapter()Landroid/bluetooth/BluetoothAdapter;

    move-result-object p0

    if-eqz p0, :cond_1

    invoke-virtual {p0}, Landroid/bluetooth/BluetoothAdapter;->isEnabled()Z

    move-result p0

    invoke-static {p0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    :cond_1
    return-object v0
.end method

.method public static final isFineLocationEnabled(Landroidx/fragment/app/Fragment;)Ljava/lang/Boolean;
    .locals 1

    const-string v0, "$this$isFineLocationEnabled"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 100
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object p0

    if-eqz p0, :cond_0

    .line 101
    check-cast p0, Landroid/content/Context;

    const-string v0, "android.permission.ACCESS_FINE_LOCATION"

    filled-new-array {v0}, [Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Lpub/devrel/easypermissions/EasyPermissions;->hasPermissions(Landroid/content/Context;[Ljava/lang/String;)Z

    move-result p0

    invoke-static {p0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object p0

    goto :goto_0

    :cond_0
    const/4 p0, 0x0

    :goto_0
    return-object p0
.end method

.method public static final isNonBatteryOptimizationAllowed(Landroidx/fragment/app/Fragment;)Ljava/lang/Boolean;
    .locals 4

    const-string v0, "$this$isNonBatteryOptimizationAllowed"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 106
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object p0

    const/4 v0, 0x0

    if-eqz p0, :cond_2

    const-string v1, "power"

    .line 107
    invoke-virtual {p0, v1}, Landroidx/fragment/app/FragmentActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/os/PowerManager;

    const-string v2, "activity"

    .line 108
    invoke-static {p0, v2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p0}, Landroidx/fragment/app/FragmentActivity;->getPackageName()Ljava/lang/String;

    move-result-object p0

    .line 110
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0x17

    if-lt v2, v3, :cond_1

    if-eqz v1, :cond_0

    .line 111
    invoke-virtual {v1, p0}, Landroid/os/PowerManager;->isIgnoringBatteryOptimizations(Ljava/lang/String;)Z

    move-result p0

    goto :goto_0

    :cond_0
    const/4 p0, 0x1

    :goto_0
    invoke-static {p0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object p0

    goto :goto_1

    :cond_1
    move-object p0, v0

    :goto_1
    if-eqz p0, :cond_2

    goto :goto_2

    .line 115
    :cond_2
    move-object p0, v0

    check-cast p0, Ljava/lang/Boolean;

    :goto_2
    return-object p0
.end method

.method public static final isPushNotificationEnabled(Landroidx/fragment/app/Fragment;)Ljava/lang/Boolean;
    .locals 1

    const-string v0, "$this$isPushNotificationEnabled"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 94
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object p0

    if-eqz p0, :cond_0

    .line 95
    check-cast p0, Landroid/content/Context;

    invoke-static {p0}, Landroidx/core/app/NotificationManagerCompat;->from(Landroid/content/Context;)Landroidx/core/app/NotificationManagerCompat;

    move-result-object p0

    invoke-virtual {p0}, Landroidx/core/app/NotificationManagerCompat;->areNotificationsEnabled()Z

    move-result p0

    invoke-static {p0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object p0

    goto :goto_0

    :cond_0
    const/4 p0, 0x0

    :goto_0
    return-object p0
.end method

.method public static final requestAllPermissions(Landroidx/fragment/app/Fragment;Lkotlin/jvm/functions/Function0;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/fragment/app/Fragment;",
            "Lkotlin/jvm/functions/Function0<",
            "Lkotlin/Unit;",
            ">;)V"
        }
    .end annotation

    const-string v0, "$this$requestAllPermissions"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "onEndCallback"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 24
    invoke-static {p0}, Lau/gov/health/covidsafe/extensions/PermissionExtensionsKt;->isBlueToothEnabled(Landroidx/fragment/app/Fragment;)Ljava/lang/Boolean;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    goto :goto_0

    :cond_0
    const/4 v0, 0x1

    :goto_0
    if-eqz v0, :cond_1

    .line 25
    invoke-static {p0, p1}, Lau/gov/health/covidsafe/extensions/PermissionExtensionsKt;->requestFineLocationAndCheckBleSupportThenNextPermission(Landroidx/fragment/app/Fragment;Lkotlin/jvm/functions/Function0;)V

    goto :goto_1

    .line 27
    :cond_1
    invoke-static {p0}, Lau/gov/health/covidsafe/extensions/PermissionExtensionsKt;->requestBlueToothPermissionThenNextPermission(Landroidx/fragment/app/Fragment;)V

    :goto_1
    return-void
.end method

.method public static final requestBlueToothPermissionThenNextPermission(Landroidx/fragment/app/Fragment;)V
    .locals 2

    const-string v0, "$this$requestBlueToothPermissionThenNextPermission"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 32
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.bluetooth.adapter.action.REQUEST_ENABLE"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    const/16 v1, 0x7b

    .line 33
    invoke-virtual {p0, v0, v1}, Landroidx/fragment/app/Fragment;->startActivityForResult(Landroid/content/Intent;I)V

    return-void
.end method

.method private static final requestFineLocationAndCheckBleSupportThenNextPermission(Landroidx/fragment/app/Fragment;Lkotlin/jvm/functions/Function0;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/fragment/app/Fragment;",
            "Lkotlin/jvm/functions/Function0<",
            "Lkotlin/Unit;",
            ">;)V"
        }
    .end annotation

    .line 45
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x17

    if-lt v0, v1, :cond_1

    .line 46
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 48
    check-cast v0, Landroid/content/Context;

    const-string v1, "android.permission.ACCESS_FINE_LOCATION"

    filled-new-array {v1}, [Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lpub/devrel/easypermissions/EasyPermissions;->hasPermissions(Landroid/content/Context;[Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 49
    invoke-static {p0}, Lau/gov/health/covidsafe/extensions/PermissionExtensionsKt;->checkBLESupport(Landroidx/fragment/app/Fragment;)V

    .line 50
    invoke-static {p0, p1}, Lau/gov/health/covidsafe/extensions/PermissionExtensionsKt;->excludeFromBatteryOptimization(Landroidx/fragment/app/Fragment;Lkotlin/jvm/functions/Function0;)V

    goto :goto_0

    .line 54
    :cond_0
    new-instance p1, Lpub/devrel/easypermissions/PermissionRequest$Builder;

    const/16 v0, 0x159

    filled-new-array {v1}, [Ljava/lang/String;

    move-result-object v1

    invoke-direct {p1, p0, v0, v1}, Lpub/devrel/easypermissions/PermissionRequest$Builder;-><init>(Landroidx/fragment/app/Fragment;I[Ljava/lang/String;)V

    const p0, 0x7f1300b5

    .line 55
    invoke-virtual {p1, p0}, Lpub/devrel/easypermissions/PermissionRequest$Builder;->setRationale(I)Lpub/devrel/easypermissions/PermissionRequest$Builder;

    move-result-object p0

    .line 56
    invoke-virtual {p0}, Lpub/devrel/easypermissions/PermissionRequest$Builder;->build()Lpub/devrel/easypermissions/PermissionRequest;

    move-result-object p0

    .line 53
    invoke-static {p0}, Lpub/devrel/easypermissions/EasyPermissions;->requestPermissions(Lpub/devrel/easypermissions/PermissionRequest;)V

    goto :goto_0

    .line 61
    :cond_1
    invoke-static {p0}, Lau/gov/health/covidsafe/extensions/PermissionExtensionsKt;->checkBLESupport(Landroidx/fragment/app/Fragment;)V

    :cond_2
    :goto_0
    return-void
.end method
