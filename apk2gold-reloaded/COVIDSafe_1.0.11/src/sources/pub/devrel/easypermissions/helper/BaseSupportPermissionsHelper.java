package pub.devrel.easypermissions.helper;

import android.util.Log;
import androidx.fragment.app.FragmentManager;
import pub.devrel.easypermissions.RationaleDialogFragmentCompat;

public abstract class BaseSupportPermissionsHelper<T> extends PermissionHelper<T> {
    private static final String TAG = "BSPermissionsHelper";

    public abstract FragmentManager getSupportFragmentManager();

    public BaseSupportPermissionsHelper(T t) {
        super(t);
    }

    public void showRequestPermissionRationale(String str, String str2, String str3, int i, int i2, String... strArr) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        String str4 = RationaleDialogFragmentCompat.TAG;
        if (supportFragmentManager.findFragmentByTag(str4) instanceof RationaleDialogFragmentCompat) {
            Log.d(TAG, "Found existing fragment, not showing rationale.");
        } else {
            RationaleDialogFragmentCompat.newInstance(str, str2, str3, i, i2, strArr).showAllowingStateLoss(supportFragmentManager, str4);
        }
    }
}
