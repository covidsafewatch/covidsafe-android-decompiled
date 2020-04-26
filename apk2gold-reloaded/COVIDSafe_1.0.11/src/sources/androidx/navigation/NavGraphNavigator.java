package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.Navigator.Extras;
import androidx.navigation.Navigator.Name;

@Name("navigation")
public class NavGraphNavigator extends Navigator<NavGraph> {
    private final NavigatorProvider mNavigatorProvider;

    public boolean popBackStack() {
        return true;
    }

    public NavGraphNavigator(NavigatorProvider navigatorProvider) {
        this.mNavigatorProvider = navigatorProvider;
    }

    public NavGraph createDestination() {
        return new NavGraph(this);
    }

    public NavDestination navigate(NavGraph navGraph, Bundle bundle, NavOptions navOptions, Extras extras) {
        int startDestination = navGraph.getStartDestination();
        if (startDestination != 0) {
            NavDestination findNode = navGraph.findNode(startDestination, false);
            if (findNode != null) {
                return this.mNavigatorProvider.getNavigator(findNode.getNavigatorName()).navigate(findNode, findNode.addInDefaultArgs(bundle), navOptions, extras);
            }
            String startDestDisplayName = navGraph.getStartDestDisplayName();
            StringBuilder sb = new StringBuilder();
            sb.append("navigation destination ");
            sb.append(startDestDisplayName);
            sb.append(" is not a direct child of this NavGraph");
            throw new IllegalArgumentException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("no start destination defined via app:startDestination for ");
        sb2.append(navGraph.getDisplayName());
        throw new IllegalStateException(sb2.toString());
    }
}
