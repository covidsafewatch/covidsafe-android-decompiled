package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.Navigator.Extras;
import androidx.navigation.Navigator.Name;

@Name("NoOp")
class NoOpNavigator extends Navigator<NavDestination> {
    public NavDestination navigate(NavDestination navDestination, Bundle bundle, NavOptions navOptions, Extras extras) {
        return navDestination;
    }

    public boolean popBackStack() {
        return true;
    }

    NoOpNavigator() {
    }

    public NavDestination createDestination() {
        return new NavDestination((Navigator<? extends NavDestination>) this);
    }
}
