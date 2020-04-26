package pub.devrel.easypermissions;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.Log;
import androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import pub.devrel.easypermissions.PermissionRequest.Builder;
import pub.devrel.easypermissions.helper.PermissionHelper;

public class EasyPermissions {
    private static final String TAG = "EasyPermissions";

    public interface PermissionCallbacks extends OnRequestPermissionsResultCallback {
        void onPermissionsDenied(int i, List<String> list);

        void onPermissionsGranted(int i, List<String> list);
    }

    public interface RationaleCallbacks {
        void onRationaleAccepted(int i);

        void onRationaleDenied(int i);
    }

    public static boolean hasPermissions(Context context, String... strArr) {
        if (VERSION.SDK_INT < 23) {
            Log.w(TAG, "hasPermissions: API version < M, returning true by default");
            return true;
        } else if (context != null) {
            for (String checkSelfPermission : strArr) {
                if (ContextCompat.checkSelfPermission(context, checkSelfPermission) != 0) {
                    return false;
                }
            }
            return true;
        } else {
            throw new IllegalArgumentException("Can't check permissions for null context");
        }
    }

    public static void requestPermissions(Activity activity, String str, int i, String... strArr) {
        requestPermissions(new Builder(activity, i, strArr).setRationale(str).build());
    }

    public static void requestPermissions(Fragment fragment, String str, int i, String... strArr) {
        requestPermissions(new Builder(fragment, i, strArr).setRationale(str).build());
    }

    public static void requestPermissions(PermissionRequest permissionRequest) {
        if (hasPermissions(permissionRequest.getHelper().getContext(), permissionRequest.getPerms())) {
            notifyAlreadyHasPermissions(permissionRequest.getHelper().getHost(), permissionRequest.getRequestCode(), permissionRequest.getPerms());
        } else {
            permissionRequest.getHelper().requestPermissions(permissionRequest.getRationale(), permissionRequest.getPositiveButtonText(), permissionRequest.getNegativeButtonText(), permissionRequest.getTheme(), permissionRequest.getRequestCode(), permissionRequest.getPerms());
        }
    }

    public static void onRequestPermissionsResult(int i, String[] strArr, int[] iArr, Object... objArr) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            String str = strArr[i2];
            if (iArr[i2] == 0) {
                arrayList.add(str);
            } else {
                arrayList2.add(str);
            }
        }
        for (Object obj : objArr) {
            if (!arrayList.isEmpty() && (obj instanceof PermissionCallbacks)) {
                ((PermissionCallbacks) obj).onPermissionsGranted(i, arrayList);
            }
            if (!arrayList2.isEmpty() && (obj instanceof PermissionCallbacks)) {
                ((PermissionCallbacks) obj).onPermissionsDenied(i, arrayList2);
            }
            if (!arrayList.isEmpty() && arrayList2.isEmpty()) {
                runAnnotatedMethods(obj, i);
            }
        }
    }

    public static boolean somePermissionPermanentlyDenied(Activity activity, List<String> list) {
        return PermissionHelper.newInstance(activity).somePermissionPermanentlyDenied(list);
    }

    public static boolean somePermissionPermanentlyDenied(Fragment fragment, List<String> list) {
        return PermissionHelper.newInstance(fragment).somePermissionPermanentlyDenied(list);
    }

    public static boolean permissionPermanentlyDenied(Activity activity, String str) {
        return PermissionHelper.newInstance(activity).permissionPermanentlyDenied(str);
    }

    public static boolean permissionPermanentlyDenied(Fragment fragment, String str) {
        return PermissionHelper.newInstance(fragment).permissionPermanentlyDenied(str);
    }

    public static boolean somePermissionDenied(Activity activity, String... strArr) {
        return PermissionHelper.newInstance(activity).somePermissionDenied(strArr);
    }

    public static boolean somePermissionDenied(Fragment fragment, String... strArr) {
        return PermissionHelper.newInstance(fragment).somePermissionDenied(strArr);
    }

    private static void notifyAlreadyHasPermissions(Object obj, int i, String[] strArr) {
        int[] iArr = new int[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            iArr[i2] = 0;
        }
        onRequestPermissionsResult(i, strArr, iArr, obj);
    }

    private static void runAnnotatedMethods(Object obj, int i) {
        Method[] declaredMethods;
        String str = TAG;
        Class cls = obj.getClass();
        if (isUsingAndroidAnnotations(obj)) {
            cls = cls.getSuperclass();
        }
        while (cls != null) {
            for (Method method : cls.getDeclaredMethods()) {
                AfterPermissionGranted afterPermissionGranted = (AfterPermissionGranted) method.getAnnotation(AfterPermissionGranted.class);
                if (afterPermissionGranted != null && afterPermissionGranted.value() == i) {
                    if (method.getParameterTypes().length <= 0) {
                        try {
                            if (!method.isAccessible()) {
                                method.setAccessible(true);
                            }
                            method.invoke(obj, new Object[0]);
                        } catch (IllegalAccessException e) {
                            Log.e(str, "runDefaultMethod:IllegalAccessException", e);
                        } catch (InvocationTargetException e2) {
                            Log.e(str, "runDefaultMethod:InvocationTargetException", e2);
                        }
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Cannot execute method ");
                        sb.append(method.getName());
                        sb.append(" because it is non-void method and/or has input parameters.");
                        throw new RuntimeException(sb.toString());
                    }
                }
            }
            cls = cls.getSuperclass();
        }
    }

    private static boolean isUsingAndroidAnnotations(Object obj) {
        if (!obj.getClass().getSimpleName().endsWith("_")) {
            return false;
        }
        try {
            return Class.forName("org.androidannotations.api.view.HasViews").isInstance(obj);
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
