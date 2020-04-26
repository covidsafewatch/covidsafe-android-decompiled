package androidx.navigation.ui;

import android.view.Menu;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavGraph;
import androidx.navigation.ui.AppBarConfiguration.Builder;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\n\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\b\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\n\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\b\u001a3\u0010\u0000\u001a\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\n\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\b¨\u0006\u000e"}, d2 = {"AppBarConfiguration", "Landroidx/navigation/ui/AppBarConfiguration;", "topLevelMenu", "Landroid/view/Menu;", "drawerLayout", "Landroidx/drawerlayout/widget/DrawerLayout;", "fallbackOnNavigateUpListener", "Lkotlin/Function0;", "", "navGraph", "Landroidx/navigation/NavGraph;", "topLevelDestinationIds", "", "", "navigation-ui-ktx_release"}, k = 2, mv = {1, 1, 15})
/* compiled from: AppBarConfiguration.kt */
public final class AppBarConfigurationKt {
    public static /* synthetic */ AppBarConfiguration AppBarConfiguration$default(NavGraph navGraph, DrawerLayout drawerLayout, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            drawerLayout = null;
        }
        if ((i & 4) != 0) {
            function0 = AppBarConfigurationKt$AppBarConfiguration$1.INSTANCE;
        }
        Intrinsics.checkParameterIsNotNull(navGraph, "navGraph");
        Intrinsics.checkParameterIsNotNull(function0, "fallbackOnNavigateUpListener");
        AppBarConfiguration build = new Builder(navGraph).setDrawerLayout(drawerLayout).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(function0)).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "AppBarConfiguration.Buil…eUpListener)\n    .build()");
        return build;
    }

    public static final AppBarConfiguration AppBarConfiguration(NavGraph navGraph, DrawerLayout drawerLayout, Function0<Boolean> function0) {
        Intrinsics.checkParameterIsNotNull(navGraph, "navGraph");
        Intrinsics.checkParameterIsNotNull(function0, "fallbackOnNavigateUpListener");
        AppBarConfiguration build = new Builder(navGraph).setDrawerLayout(drawerLayout).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(function0)).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "AppBarConfiguration.Buil…eUpListener)\n    .build()");
        return build;
    }

    public static /* synthetic */ AppBarConfiguration AppBarConfiguration$default(Menu menu, DrawerLayout drawerLayout, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            drawerLayout = null;
        }
        if ((i & 4) != 0) {
            function0 = AppBarConfigurationKt$AppBarConfiguration$2.INSTANCE;
        }
        Intrinsics.checkParameterIsNotNull(menu, "topLevelMenu");
        Intrinsics.checkParameterIsNotNull(function0, "fallbackOnNavigateUpListener");
        AppBarConfiguration build = new Builder(menu).setDrawerLayout(drawerLayout).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(function0)).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "AppBarConfiguration.Buil…eUpListener)\n    .build()");
        return build;
    }

    public static final AppBarConfiguration AppBarConfiguration(Menu menu, DrawerLayout drawerLayout, Function0<Boolean> function0) {
        Intrinsics.checkParameterIsNotNull(menu, "topLevelMenu");
        Intrinsics.checkParameterIsNotNull(function0, "fallbackOnNavigateUpListener");
        AppBarConfiguration build = new Builder(menu).setDrawerLayout(drawerLayout).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(function0)).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "AppBarConfiguration.Buil…eUpListener)\n    .build()");
        return build;
    }

    public static /* synthetic */ AppBarConfiguration AppBarConfiguration$default(Set set, DrawerLayout drawerLayout, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            drawerLayout = null;
        }
        if ((i & 4) != 0) {
            function0 = AppBarConfigurationKt$AppBarConfiguration$3.INSTANCE;
        }
        Intrinsics.checkParameterIsNotNull(set, "topLevelDestinationIds");
        Intrinsics.checkParameterIsNotNull(function0, "fallbackOnNavigateUpListener");
        AppBarConfiguration build = new Builder(set).setDrawerLayout(drawerLayout).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(function0)).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "AppBarConfiguration.Buil…eUpListener)\n    .build()");
        return build;
    }

    public static final AppBarConfiguration AppBarConfiguration(Set<Integer> set, DrawerLayout drawerLayout, Function0<Boolean> function0) {
        Intrinsics.checkParameterIsNotNull(set, "topLevelDestinationIds");
        Intrinsics.checkParameterIsNotNull(function0, "fallbackOnNavigateUpListener");
        AppBarConfiguration build = new Builder(set).setDrawerLayout(drawerLayout).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(function0)).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "AppBarConfiguration.Buil…eUpListener)\n    .build()");
        return build;
    }
}
