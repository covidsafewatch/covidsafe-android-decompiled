package androidx.navigation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import androidx.core.app.ActivityCompat;
import java.lang.ref.WeakReference;

public final class Navigation {
    private Navigation() {
    }

    public static NavController findNavController(Activity activity, int i) {
        NavController findViewNavController = findViewNavController(ActivityCompat.requireViewById(activity, i));
        if (findViewNavController != null) {
            return findViewNavController;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Activity ");
        sb.append(activity);
        sb.append(" does not have a NavController set on ");
        sb.append(i);
        throw new IllegalStateException(sb.toString());
    }

    public static NavController findNavController(View view) {
        NavController findViewNavController = findViewNavController(view);
        if (findViewNavController != null) {
            return findViewNavController;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("View ");
        sb.append(view);
        sb.append(" does not have a NavController set");
        throw new IllegalStateException(sb.toString());
    }

    public static OnClickListener createNavigateOnClickListener(int i) {
        return createNavigateOnClickListener(i, null);
    }

    public static OnClickListener createNavigateOnClickListener(final int i, final Bundle bundle) {
        return new OnClickListener() {
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(i, bundle);
            }
        };
    }

    public static OnClickListener createNavigateOnClickListener(final NavDirections navDirections) {
        return new OnClickListener() {
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(navDirections);
            }
        };
    }

    public static void setViewNavController(View view, NavController navController) {
        view.setTag(R.id.nav_controller_view_tag, navController);
    }

    private static NavController findViewNavController(View view) {
        while (view != null) {
            NavController viewNavController = getViewNavController(view);
            if (viewNavController != null) {
                return viewNavController;
            }
            ViewParent parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    private static NavController getViewNavController(View view) {
        Object tag = view.getTag(R.id.nav_controller_view_tag);
        if (tag instanceof WeakReference) {
            return (NavController) ((WeakReference) tag).get();
        }
        if (tag instanceof NavController) {
            return (NavController) tag;
        }
        return null;
    }
}
