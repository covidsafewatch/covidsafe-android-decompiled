package androidx.navigation;

import android.os.Bundle;

public final class NavAction {
    private Bundle mDefaultArguments;
    private final int mDestinationId;
    private NavOptions mNavOptions;

    public NavAction(int i) {
        this(i, (NavOptions) null);
    }

    public NavAction(int i, NavOptions navOptions) {
        this(i, navOptions, (Bundle) null);
    }

    public NavAction(int i, NavOptions navOptions, Bundle bundle) {
        this.mDestinationId = i;
        this.mNavOptions = navOptions;
        this.mDefaultArguments = bundle;
    }

    public int getDestinationId() {
        return this.mDestinationId;
    }

    public void setNavOptions(NavOptions navOptions) {
        this.mNavOptions = navOptions;
    }

    public NavOptions getNavOptions() {
        return this.mNavOptions;
    }

    public Bundle getDefaultArguments() {
        return this.mDefaultArguments;
    }

    public void setDefaultArguments(Bundle bundle) {
        this.mDefaultArguments = bundle;
    }
}
