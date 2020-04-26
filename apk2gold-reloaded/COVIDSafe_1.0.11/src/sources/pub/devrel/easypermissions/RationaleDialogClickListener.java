package pub.devrel.easypermissions;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import androidx.fragment.app.Fragment;
import java.util.Arrays;
import pub.devrel.easypermissions.EasyPermissions.PermissionCallbacks;
import pub.devrel.easypermissions.EasyPermissions.RationaleCallbacks;
import pub.devrel.easypermissions.helper.PermissionHelper;

class RationaleDialogClickListener implements OnClickListener {
    private PermissionCallbacks mCallbacks;
    private RationaleDialogConfig mConfig;
    private Object mHost;
    private RationaleCallbacks mRationaleCallbacks;

    RationaleDialogClickListener(RationaleDialogFragmentCompat rationaleDialogFragmentCompat, RationaleDialogConfig rationaleDialogConfig, PermissionCallbacks permissionCallbacks, RationaleCallbacks rationaleCallbacks) {
        Object obj;
        if (rationaleDialogFragmentCompat.getParentFragment() != null) {
            obj = rationaleDialogFragmentCompat.getParentFragment();
        } else {
            obj = rationaleDialogFragmentCompat.getActivity();
        }
        this.mHost = obj;
        this.mConfig = rationaleDialogConfig;
        this.mCallbacks = permissionCallbacks;
        this.mRationaleCallbacks = rationaleCallbacks;
    }

    RationaleDialogClickListener(RationaleDialogFragment rationaleDialogFragment, RationaleDialogConfig rationaleDialogConfig, PermissionCallbacks permissionCallbacks, RationaleCallbacks rationaleCallbacks) {
        this.mHost = rationaleDialogFragment.getActivity();
        this.mConfig = rationaleDialogConfig;
        this.mCallbacks = permissionCallbacks;
        this.mRationaleCallbacks = rationaleCallbacks;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        int i2 = this.mConfig.requestCode;
        if (i == -1) {
            String[] strArr = this.mConfig.permissions;
            RationaleCallbacks rationaleCallbacks = this.mRationaleCallbacks;
            if (rationaleCallbacks != null) {
                rationaleCallbacks.onRationaleAccepted(i2);
            }
            Object obj = this.mHost;
            if (obj instanceof Fragment) {
                PermissionHelper.newInstance((Fragment) obj).directRequestPermissions(i2, strArr);
            } else if (obj instanceof Activity) {
                PermissionHelper.newInstance((Activity) obj).directRequestPermissions(i2, strArr);
            } else {
                throw new RuntimeException("Host must be an Activity or Fragment!");
            }
        } else {
            RationaleCallbacks rationaleCallbacks2 = this.mRationaleCallbacks;
            if (rationaleCallbacks2 != null) {
                rationaleCallbacks2.onRationaleDenied(i2);
            }
            notifyPermissionDenied();
        }
    }

    private void notifyPermissionDenied() {
        PermissionCallbacks permissionCallbacks = this.mCallbacks;
        if (permissionCallbacks != null) {
            permissionCallbacks.onPermissionsDenied(this.mConfig.requestCode, Arrays.asList(this.mConfig.permissions));
        }
    }
}
