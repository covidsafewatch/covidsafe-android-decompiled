package pub.devrel.easypermissions.helper;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import pub.devrel.easypermissions.RationaleDialogFragment;

class ActivityPermissionHelper extends PermissionHelper<Activity> {
    private static final String TAG = "ActPermissionHelper";

    public ActivityPermissionHelper(Activity activity) {
        super(activity);
    }

    public void directRequestPermissions(int i, String... strArr) {
        ActivityCompat.requestPermissions((Activity) getHost(), strArr, i);
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        return ActivityCompat.shouldShowRequestPermissionRationale((Activity) getHost(), str);
    }

    public Context getContext() {
        return (Context) getHost();
    }

    public void showRequestPermissionRationale(String str, String str2, String str3, int i, int i2, String... strArr) {
        FragmentManager fragmentManager = ((Activity) getHost()).getFragmentManager();
        String str4 = RationaleDialogFragment.TAG;
        if (fragmentManager.findFragmentByTag(str4) instanceof RationaleDialogFragment) {
            Log.d(TAG, "Found existing fragment, not showing rationale.");
        } else {
            RationaleDialogFragment.newInstance(str2, str3, str, i, i2, strArr).showAllowingStateLoss(fragmentManager, str4);
        }
    }
}
