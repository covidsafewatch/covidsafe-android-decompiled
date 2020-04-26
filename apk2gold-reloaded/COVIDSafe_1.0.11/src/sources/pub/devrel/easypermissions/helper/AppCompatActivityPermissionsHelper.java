package pub.devrel.easypermissions.helper;

import android.app.Activity;
import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentManager;

class AppCompatActivityPermissionsHelper extends BaseSupportPermissionsHelper<AppCompatActivity> {
    public AppCompatActivityPermissionsHelper(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
    }

    public FragmentManager getSupportFragmentManager() {
        return ((AppCompatActivity) getHost()).getSupportFragmentManager();
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
}
