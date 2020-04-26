package pub.devrel.easypermissions.helper;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

class SupportFragmentPermissionHelper extends BaseSupportPermissionsHelper<Fragment> {
    public SupportFragmentPermissionHelper(Fragment fragment) {
        super(fragment);
    }

    public FragmentManager getSupportFragmentManager() {
        return ((Fragment) getHost()).getChildFragmentManager();
    }

    public void directRequestPermissions(int i, String... strArr) {
        ((Fragment) getHost()).requestPermissions(strArr, i);
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        return ((Fragment) getHost()).shouldShowRequestPermissionRationale(str);
    }

    public Context getContext() {
        return ((Fragment) getHost()).getActivity();
    }
}
