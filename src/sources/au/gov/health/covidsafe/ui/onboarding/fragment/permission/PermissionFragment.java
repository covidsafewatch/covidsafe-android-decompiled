package au.gov.health.covidsafe.ui.onboarding.fragment.permission;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.Navigator;
import au.gov.health.covidsafe.HomeActivity;
import au.gov.health.covidsafe.R;
import au.gov.health.covidsafe.TracerApp;
import au.gov.health.covidsafe.extensions.PermissionExtensionsKt;
import au.gov.health.covidsafe.ui.BaseFragment;
import au.gov.health.covidsafe.ui.PagerChildFragment;
import au.gov.health.covidsafe.ui.UploadButtonLayout;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pub.devrel.easypermissions.EasyPermissions;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u0001/B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\nH\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\"\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u0013H\u0016J\u001e\u0010#\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00052\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%H\u0016J\u001e\u0010'\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00052\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%H\u0016J-\u0010(\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00052\u000e\u0010)\u001a\n\u0012\u0006\b\u0001\u0012\u00020&0*2\u0006\u0010+\u001a\u00020,H\u0016¢\u0006\u0002\u0010-J\b\u0010.\u001a\u00020\u0013H\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0005XD¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\u000e¨\u00060"}, d2 = {"Lau/gov/health/covidsafe/ui/onboarding/fragment/permission/PermissionFragment;", "Lau/gov/health/covidsafe/ui/PagerChildFragment;", "Lpub/devrel/easypermissions/EasyPermissions$PermissionCallbacks;", "()V", "navigationIcon", "", "getNavigationIcon", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "navigationStarted", "", "stepProgress", "getStepProgress", "setStepProgress", "(Ljava/lang/Integer;)V", "getUploadButtonLayout", "Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;", "hasAllPermissionsAndBluetoothOn", "navigateToMainActivity", "", "navigateToNextPage", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onPermissionsDenied", "perms", "", "", "onPermissionsGranted", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "updateButtonState", "Companion", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: PermissionFragment.kt */
public final class PermissionFragment extends PagerChildFragment implements EasyPermissions.PermissionCallbacks {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final String[] requiredPermissions = {"android.permission.BLUETOOTH", "android.permission.BLUETOOTH_ADMIN", "android.permission.ACCESS_FINE_LOCATION"};
    private HashMap _$_findViewCache;
    private final Integer navigationIcon = Integer.valueOf(R.drawable.ic_up);
    /* access modifiers changed from: private */
    public boolean navigationStarted;
    private Integer stepProgress = 5;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lau/gov/health/covidsafe/ui/onboarding/fragment/permission/PermissionFragment$Companion;", "", "()V", "requiredPermissions", "", "", "getRequiredPermissions", "()[Ljava/lang/String;", "[Ljava/lang/String;", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: PermissionFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String[] getRequiredPermissions() {
            return PermissionFragment.requiredPermissions;
        }
    }

    public Integer getNavigationIcon() {
        return this.navigationIcon;
    }

    public Integer getStepProgress() {
        return this.stepProgress;
    }

    public void setStepProgress(Integer num) {
        this.stepProgress = num;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_permission, viewGroup, false);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 123) {
            if (i2 == 0) {
                PermissionExtensionsKt.excludeFromBatteryOptimization(this, new PermissionFragment$onActivityResult$1(this));
            } else {
                PermissionExtensionsKt.requestAllPermissions(this, new PermissionFragment$onActivityResult$2(this));
            }
        } else if (i == 789) {
            new Handler().postDelayed(new PermissionFragment$onActivityResult$3(this), 1000);
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    /* access modifiers changed from: private */
    public final void navigateToNextPage() {
        this.navigationStarted = false;
        if (hasAllPermissionsAndBluetoothOn()) {
            BaseFragment.navigateTo$default(this, R.id.action_permissionFragment_to_permissionSuccessFragment, (Bundle) null, (Navigator.Extras) null, 6, (Object) null);
        } else {
            navigateToMainActivity();
        }
    }

    private final boolean hasAllPermissionsAndBluetoothOn() {
        boolean z;
        Context appContext = TracerApp.Companion.getAppContext();
        if (Intrinsics.areEqual((Object) PermissionExtensionsKt.isBlueToothEnabled(this), (Object) true)) {
            String[] strArr = requiredPermissions;
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = true;
                    break;
                }
                if (!(ContextCompat.checkSelfPermission(appContext, strArr[i]) == 0)) {
                    z = false;
                    break;
                }
                i++;
            }
            if (z) {
                PowerManager powerManager = (PowerManager) ContextCompat.getSystemService(appContext, PowerManager.class);
                if (powerManager != null ? powerManager.isIgnoringBatteryOptimizations(appContext.getPackageName()) : true) {
                    return true;
                }
            }
        }
        return false;
    }

    private final void navigateToMainActivity() {
        Intent intent = new Intent(getContext(), HomeActivity.class);
        intent.setFlags(268468224);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.startActivity(intent);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    public void onPermissionsDenied(int i, List<String> list) {
        Intrinsics.checkParameterIsNotNull(list, "perms");
        if (i == 345) {
            PermissionExtensionsKt.excludeFromBatteryOptimization(this, new PermissionFragment$onPermissionsDenied$1(this));
        } else {
            PermissionExtensionsKt.requestAllPermissions(this, new PermissionFragment$onPermissionsDenied$2(this));
        }
    }

    public void onPermissionsGranted(int i, List<String> list) {
        Intrinsics.checkParameterIsNotNull(list, "perms");
        PermissionExtensionsKt.requestAllPermissions(this, new PermissionFragment$onPermissionsGranted$1(this));
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Intrinsics.checkParameterIsNotNull(strArr, "permissions");
        Intrinsics.checkParameterIsNotNull(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        EasyPermissions.onRequestPermissionsResult(i, strArr, iArr, this);
    }

    public UploadButtonLayout.ContinueLayout getUploadButtonLayout() {
        return new UploadButtonLayout.ContinueLayout(R.string.permission_button, new PermissionFragment$getUploadButtonLayout$1(this));
    }

    public void updateButtonState() {
        if (this.navigationStarted) {
            disableContinueButton();
        } else {
            enableContinueButton();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        ((ScrollView) _$_findCachedViewById(R.id.root)).removeAllViews();
        _$_clearFindViewByIdCache();
    }
}
