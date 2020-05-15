package androidx.navigation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
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
        throw new IllegalStateException("Activity " + activity + " does not have a NavController set on " + i);
    }

    public static NavController findNavController(View view) {
        NavController findViewNavController = findViewNavController(view);
        if (findViewNavController != null) {
            return findViewNavController;
        }
        throw new IllegalStateException("View " + view + " does not have a NavController set");
    }

    public static View.OnClickListener createNavigateOnClickListener(int i) {
        return createNavigateOnClickListener(i, (Bundle) null);
    }

    public static View.OnClickListener createNavigateOnClickListener(final int i, final Bundle bundle) {
        return new View.OnClickListener() {
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(i, bundle);
            }
        };
    }

    public static View.OnClickListener createNavigateOnClickListener(final NavDirections navDirections) {
        return new View.OnClickListener() {
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
