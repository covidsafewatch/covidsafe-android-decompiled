package androidx.transition;

import android.os.Build;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ViewGroupUtils {
    private static Method sGetChildDrawingOrderMethod = null;
    private static boolean sGetChildDrawingOrderMethodFetched = false;
    private static boolean sTryHiddenSuppressLayout = true;

    static ViewGroupOverlayImpl getOverlay(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new ViewGroupOverlayApi18(viewGroup);
        }
        return ViewGroupOverlayApi14.createFrom(viewGroup);
    }

    static void suppressLayout(ViewGroup viewGroup, boolean z) {
        if (Build.VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(z);
        } else if (Build.VERSION.SDK_INT >= 18) {
            hiddenSuppressLayout(viewGroup, z);
        } else {
            ViewGroupUtilsApi14.suppressLayout(viewGroup, z);
        }
    }

    private static void hiddenSuppressLayout(ViewGroup viewGroup, boolean z) {
        if (sTryHiddenSuppressLayout) {
            try {
                viewGroup.suppressLayout(z);
            } catch (NoSuchMethodError unused) {
                sTryHiddenSuppressLayout = false;
            }
        }
    }

    static int getChildDrawingOrder(ViewGroup viewGroup, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            return viewGroup.getChildDrawingOrder(i);
        }
        if (!sGetChildDrawingOrderMethodFetched) {
            Class<ViewGroup> cls = ViewGroup.class;
            try {
                Method declaredMethod = cls.getDeclaredMethod("getChildDrawingOrder", new Class[]{Integer.TYPE, Integer.TYPE});
                sGetChildDrawingOrderMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            sGetChildDrawingOrderMethodFetched = true;
        }
        Method method = sGetChildDrawingOrderMethod;
        if (method != null) {
            try {
                return ((Integer) method.invoke(viewGroup, new Object[]{Integer.valueOf(viewGroup.getChildCount()), Integer.valueOf(i)})).intValue();
            } catch (IllegalAccessException | InvocationTargetException unused2) {
            }
        }
        return i;
    }

    private ViewGroupUtils() {
    }
}
