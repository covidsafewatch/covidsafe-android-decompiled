package androidx.navigation;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.TaskStackBuilder;
import androidx.navigation.Navigator.Extras;
import java.util.ArrayDeque;
import java.util.Iterator;

public final class NavDeepLinkBuilder {
    private Bundle mArgs;
    private final Context mContext;
    private int mDestId;
    private NavGraph mGraph;
    private final Intent mIntent;

    private static class PermissiveNavigatorProvider extends NavigatorProvider {
        private final Navigator<NavDestination> mDestNavigator = new Navigator<NavDestination>() {
            public NavDestination createDestination() {
                return new NavDestination("permissive");
            }

            public NavDestination navigate(NavDestination navDestination, Bundle bundle, NavOptions navOptions, Extras extras) {
                throw new IllegalStateException("navigate is not supported");
            }

            public boolean popBackStack() {
                throw new IllegalStateException("popBackStack is not supported");
            }
        };

        PermissiveNavigatorProvider() {
            addNavigator(new NavGraphNavigator(this));
        }

        public Navigator<? extends NavDestination> getNavigator(String str) {
            try {
                return super.getNavigator(str);
            } catch (IllegalStateException unused) {
                return this.mDestNavigator;
            }
        }
    }

    public NavDeepLinkBuilder(Context context) {
        this.mContext = context;
        if (context instanceof Activity) {
            Context context2 = this.mContext;
            this.mIntent = new Intent(context2, context2.getClass());
        } else {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(this.mContext.getPackageName());
            if (launchIntentForPackage == null) {
                launchIntentForPackage = new Intent();
            }
            this.mIntent = launchIntentForPackage;
        }
        this.mIntent.addFlags(268468224);
    }

    NavDeepLinkBuilder(NavController navController) {
        this(navController.getContext());
        this.mGraph = navController.getGraph();
    }

    public NavDeepLinkBuilder setComponentName(Class<? extends Activity> cls) {
        return setComponentName(new ComponentName(this.mContext, cls));
    }

    public NavDeepLinkBuilder setComponentName(ComponentName componentName) {
        this.mIntent.setComponent(componentName);
        return this;
    }

    public NavDeepLinkBuilder setGraph(int i) {
        return setGraph(new NavInflater(this.mContext, new PermissiveNavigatorProvider()).inflate(i));
    }

    public NavDeepLinkBuilder setGraph(NavGraph navGraph) {
        this.mGraph = navGraph;
        if (this.mDestId != 0) {
            fillInIntent();
        }
        return this;
    }

    public NavDeepLinkBuilder setDestination(int i) {
        this.mDestId = i;
        if (this.mGraph != null) {
            fillInIntent();
        }
        return this;
    }

    private void fillInIntent() {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(this.mGraph);
        NavDestination navDestination = null;
        while (!arrayDeque.isEmpty() && navDestination == null) {
            NavDestination navDestination2 = (NavDestination) arrayDeque.poll();
            if (navDestination2.getId() == this.mDestId) {
                navDestination = navDestination2;
            } else if (navDestination2 instanceof NavGraph) {
                Iterator it = ((NavGraph) navDestination2).iterator();
                while (it.hasNext()) {
                    arrayDeque.add((NavDestination) it.next());
                }
            }
        }
        if (navDestination != null) {
            this.mIntent.putExtra("android-support-nav:controller:deepLinkIds", navDestination.buildDeepLinkIds());
            return;
        }
        String displayName = NavDestination.getDisplayName(this.mContext, this.mDestId);
        StringBuilder sb = new StringBuilder();
        sb.append("navigation destination ");
        sb.append(displayName);
        sb.append(" is unknown to this NavController");
        throw new IllegalArgumentException(sb.toString());
    }

    public NavDeepLinkBuilder setArguments(Bundle bundle) {
        this.mArgs = bundle;
        this.mIntent.putExtra("android-support-nav:controller:deepLinkExtras", bundle);
        return this;
    }

    public TaskStackBuilder createTaskStackBuilder() {
        if (this.mIntent.getIntArrayExtra("android-support-nav:controller:deepLinkIds") != null) {
            TaskStackBuilder addNextIntentWithParentStack = TaskStackBuilder.create(this.mContext).addNextIntentWithParentStack(new Intent(this.mIntent));
            for (int i = 0; i < addNextIntentWithParentStack.getIntentCount(); i++) {
                addNextIntentWithParentStack.editIntentAt(i).putExtra(NavController.KEY_DEEP_LINK_INTENT, this.mIntent);
            }
            return addNextIntentWithParentStack;
        } else if (this.mGraph == null) {
            throw new IllegalStateException("You must call setGraph() before constructing the deep link");
        } else {
            throw new IllegalStateException("You must call setDestination() before constructing the deep link");
        }
    }

    public PendingIntent createPendingIntent() {
        Bundle bundle = this.mArgs;
        int i = 0;
        if (bundle != null) {
            int i2 = 0;
            for (String str : bundle.keySet()) {
                Object obj = this.mArgs.get(str);
                i2 = (i2 * 31) + (obj != null ? obj.hashCode() : 0);
            }
            i = i2;
        }
        return createTaskStackBuilder().getPendingIntent((i * 31) + this.mDestId, 134217728);
    }
}
