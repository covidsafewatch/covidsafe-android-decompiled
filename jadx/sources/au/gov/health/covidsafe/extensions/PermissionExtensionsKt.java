package au.gov.health.covidsafe.extensions;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Intent;
import android.os.Build;
import android.os.PowerManager;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import au.gov.health.covidsafe.R;
import au.gov.health.covidsafe.Utils;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;
import pub.devrel.easypermissions.PermissionRequest;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006\u001a\n\u0010\u0007\u001a\u00020\u0005*\u00020\u0006\u001a\u001c\u0010\b\u001a\u00020\u0005*\u00020\u00062\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n\u001a\u0011\u0010\u000b\u001a\u0004\u0018\u00010\f*\u00020\u0006¢\u0006\u0002\u0010\r\u001a\u0011\u0010\u000e\u001a\u0004\u0018\u00010\f*\u00020\u0006¢\u0006\u0002\u0010\r\u001a\u0011\u0010\u000f\u001a\u0004\u0018\u00010\f*\u00020\u0006¢\u0006\u0002\u0010\r\u001a\u0011\u0010\u0010\u001a\u0004\u0018\u00010\f*\u00020\u0006¢\u0006\u0002\u0010\r\u001a\u0018\u0010\u0011\u001a\u00020\u0005*\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n\u001a\n\u0010\u0012\u001a\u00020\u0005*\u00020\u0006\u001a\u001a\u0010\u0013\u001a\u00020\u0005*\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"BATTERY_OPTIMISER", "", "LOCATION", "REQUEST_ENABLE_BT", "askForLocationPermission", "", "Landroidx/fragment/app/Fragment;", "checkBLESupport", "excludeFromBatteryOptimization", "onEndCallback", "Lkotlin/Function0;", "isBlueToothEnabled", "", "(Landroidx/fragment/app/Fragment;)Ljava/lang/Boolean;", "isFineLocationEnabled", "isNonBatteryOptimizationAllowed", "isPushNotificationEnabled", "requestAllPermissions", "requestBlueToothPermissionThenNextPermission", "requestFineLocationAndCheckBleSupportThenNextPermission", "app_release"}, k = 2, mv = {1, 1, 16})
/* compiled from: PermissionExtensions.kt */
public final class PermissionExtensionsKt {
    public static final int BATTERY_OPTIMISER = 789;
    public static final int LOCATION = 345;
    public static final int REQUEST_ENABLE_BT = 123;

    public static final void requestAllPermissions(Fragment fragment, Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(fragment, "$this$requestAllPermissions");
        Intrinsics.checkParameterIsNotNull(function0, "onEndCallback");
        Boolean isBlueToothEnabled = isBlueToothEnabled(fragment);
        if (isBlueToothEnabled != null ? isBlueToothEnabled.booleanValue() : true) {
            requestFineLocationAndCheckBleSupportThenNextPermission(fragment, function0);
        } else {
            requestBlueToothPermissionThenNextPermission(fragment);
        }
    }

    public static final void requestBlueToothPermissionThenNextPermission(Fragment fragment) {
        Intrinsics.checkParameterIsNotNull(fragment, "$this$requestBlueToothPermissionThenNextPermission");
        fragment.startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 123);
    }

    public static final void checkBLESupport(Fragment fragment) {
        FragmentActivity activity;
        Intrinsics.checkParameterIsNotNull(fragment, "$this$checkBLESupport");
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        boolean z = false;
        if (defaultAdapter != null && !defaultAdapter.isMultipleAdvertisementSupported()) {
            z = true;
        }
        if (z && (activity = fragment.getActivity()) != null) {
            Utils utils = Utils.INSTANCE;
            Intrinsics.checkExpressionValueIsNotNull(activity, "it");
            utils.stopBluetoothMonitoringService(activity);
        }
    }

    private static final void requestFineLocationAndCheckBleSupportThenNextPermission(Fragment fragment, Function0<Unit> function0) {
        if (Build.VERSION.SDK_INT >= 23) {
            FragmentActivity activity = fragment.getActivity();
            if (activity == null) {
                return;
            }
            if (EasyPermissions.hasPermissions(activity, "android.permission.ACCESS_FINE_LOCATION")) {
                checkBLESupport(fragment);
                excludeFromBatteryOptimization(fragment, function0);
                return;
            }
            EasyPermissions.requestPermissions(new PermissionRequest.Builder(fragment, (int) LOCATION, "android.permission.ACCESS_FINE_LOCATION").setRationale((int) R.string.permission_location_rationale).build());
            return;
        }
        checkBLESupport(fragment);
    }

    public static /* synthetic */ void excludeFromBatteryOptimization$default(Fragment fragment, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        excludeFromBatteryOptimization(fragment, function0);
    }

    public static final void excludeFromBatteryOptimization(Fragment fragment, Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(fragment, "$this$excludeFromBatteryOptimization");
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            Object systemService = activity.getSystemService("power");
            if (systemService != null) {
                PowerManager powerManager = (PowerManager) systemService;
                Intrinsics.checkExpressionValueIsNotNull(activity, "it");
                String packageName = activity.getPackageName();
                if (Build.VERSION.SDK_INT >= 23) {
                    Utils utils = Utils.INSTANCE;
                    Intrinsics.checkExpressionValueIsNotNull(packageName, "packageName");
                    Intent batteryOptimizerExemptionIntent = utils.getBatteryOptimizerExemptionIntent(packageName);
                    if (!powerManager.isIgnoringBatteryOptimizations(packageName)) {
                        if (Utils.INSTANCE.canHandleIntent(batteryOptimizerExemptionIntent, activity.getPackageManager())) {
                            fragment.startActivityForResult(batteryOptimizerExemptionIntent, BATTERY_OPTIMISER);
                        } else if (function0 != null) {
                            Unit invoke = function0.invoke();
                        }
                    } else if (function0 != null) {
                        Unit invoke2 = function0.invoke();
                    }
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type android.os.PowerManager");
            }
        }
    }

    public static final Boolean isBlueToothEnabled(Fragment fragment) {
        BluetoothAdapter adapter;
        Intrinsics.checkParameterIsNotNull(fragment, "$this$isBlueToothEnabled");
        FragmentActivity activity = fragment.getActivity();
        BluetoothManager bluetoothManager = (BluetoothManager) (activity != null ? activity.getSystemService("bluetooth") : null);
        if (bluetoothManager == null || (adapter = bluetoothManager.getAdapter()) == null) {
            return null;
        }
        return Boolean.valueOf(adapter.isEnabled());
    }

    public static final Boolean isPushNotificationEnabled(Fragment fragment) {
        Intrinsics.checkParameterIsNotNull(fragment, "$this$isPushNotificationEnabled");
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            return Boolean.valueOf(NotificationManagerCompat.from(activity).areNotificationsEnabled());
        }
        return null;
    }

    public static final Boolean isFineLocationEnabled(Fragment fragment) {
        Intrinsics.checkParameterIsNotNull(fragment, "$this$isFineLocationEnabled");
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            return Boolean.valueOf(EasyPermissions.hasPermissions(activity, "android.permission.ACCESS_FINE_LOCATION"));
        }
        return null;
    }

    public static final Boolean isNonBatteryOptimizationAllowed(Fragment fragment) {
        Boolean bool;
        Intrinsics.checkParameterIsNotNull(fragment, "$this$isNonBatteryOptimizationAllowed");
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            PowerManager powerManager = (PowerManager) activity.getSystemService("power");
            Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
            String packageName = activity.getPackageName();
            if (Build.VERSION.SDK_INT >= 23) {
                bool = Boolean.valueOf(powerManager != null ? powerManager.isIgnoringBatteryOptimizations(packageName) : true);
            } else {
                bool = null;
            }
            if (bool != null) {
                return bool;
            }
        }
        return null;
    }

    public static final void askForLocationPermission(Fragment fragment) {
        Intrinsics.checkParameterIsNotNull(fragment, "$this$askForLocationPermission");
        FragmentActivity activity = fragment.getActivity();
        if (activity != null && !EasyPermissions.hasPermissions(activity, "android.permission.ACCESS_FINE_LOCATION")) {
            if (EasyPermissions.somePermissionPermanentlyDenied(fragment, (List<String>) CollectionsKt.listOf("android.permission.ACCESS_FINE_LOCATION"))) {
                new AppSettingsDialog.Builder(fragment).build().show();
            } else {
                EasyPermissions.requestPermissions(new PermissionRequest.Builder(fragment, (int) LOCATION, "android.permission.ACCESS_FINE_LOCATION").setRationale((int) R.string.permission_location_rationale).build());
            }
        }
    }
}
