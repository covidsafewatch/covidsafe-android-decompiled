package pub.devrel.easypermissions.helper;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;

class LowApiPermissionsHelper<T> extends PermissionHelper<T> {
    public boolean shouldShowRequestPermissionRationale(String str) {
        return false;
    }

    public LowApiPermissionsHelper(T t) {
        super(t);
    }

    public void directRequestPermissions(int i, String... strArr) {
        throw new IllegalStateException("Should never be requesting permissions on API < 23!");
    }

    public void showRequestPermissionRationale(String str, String str2, String str3, int i, int i2, String... strArr) {
        throw new IllegalStateException("Should never be requesting permissions on API < 23!");
    }

    public Context getContext() {
        if (getHost() instanceof Activity) {
            return (Context) getHost();
        }
        if (getHost() instanceof Fragment) {
            return ((Fragment) getHost()).getContext();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unknown host: ");
        sb.append(getHost());
        throw new IllegalStateException(sb.toString());
    }
}
