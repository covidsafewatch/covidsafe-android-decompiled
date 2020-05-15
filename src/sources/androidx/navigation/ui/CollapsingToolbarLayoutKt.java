package androidx.navigation.ui;

import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"setupWithNavController", "", "Lcom/google/android/material/appbar/CollapsingToolbarLayout;", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "navController", "Landroidx/navigation/NavController;", "drawerLayout", "Landroidx/drawerlayout/widget/DrawerLayout;", "configuration", "Landroidx/navigation/ui/AppBarConfiguration;", "navigation-ui-ktx_release"}, k = 2, mv = {1, 1, 15})
/* compiled from: CollapsingToolbarLayout.kt */
public final class CollapsingToolbarLayoutKt {
    /* JADX WARNING: type inference failed for: r0v5, types: [androidx.navigation.ui.AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void setupWithNavController(com.google.android.material.appbar.CollapsingToolbarLayout r3, androidx.appcompat.widget.Toolbar r4, androidx.navigation.NavController r5, androidx.drawerlayout.widget.DrawerLayout r6) {
        /*
            java.lang.String r0 = "$this$setupWithNavController"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            java.lang.String r0 = "toolbar"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            java.lang.String r0 = "navController"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            androidx.navigation.NavGraph r0 = r5.getGraph()
            java.lang.String r1 = "navController.graph"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            androidx.navigation.ui.AppBarConfigurationKt$AppBarConfiguration$1 r1 = androidx.navigation.ui.AppBarConfigurationKt$AppBarConfiguration$1.INSTANCE
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            androidx.navigation.ui.AppBarConfiguration$Builder r2 = new androidx.navigation.ui.AppBarConfiguration$Builder
            r2.<init>((androidx.navigation.NavGraph) r0)
            androidx.navigation.ui.AppBarConfiguration$Builder r6 = r2.setDrawerLayout(r6)
            if (r1 == 0) goto L_0x002d
            androidx.navigation.ui.AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0 r0 = new androidx.navigation.ui.AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0
            r0.<init>(r1)
            r1 = r0
        L_0x002d:
            androidx.navigation.ui.AppBarConfiguration$OnNavigateUpListener r1 = (androidx.navigation.ui.AppBarConfiguration.OnNavigateUpListener) r1
            androidx.navigation.ui.AppBarConfiguration$Builder r6 = r6.setFallbackOnNavigateUpListener(r1)
            androidx.navigation.ui.AppBarConfiguration r6 = r6.build()
            java.lang.String r0 = "AppBarConfiguration.Buil…eUpListener)\n    .build()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r0)
            androidx.navigation.ui.NavigationUI.setupWithNavController((com.google.android.material.appbar.CollapsingToolbarLayout) r3, (androidx.appcompat.widget.Toolbar) r4, (androidx.navigation.NavController) r5, (androidx.navigation.ui.AppBarConfiguration) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.ui.CollapsingToolbarLayoutKt.setupWithNavController(com.google.android.material.appbar.CollapsingToolbarLayout, androidx.appcompat.widget.Toolbar, androidx.navigation.NavController, androidx.drawerlayout.widget.DrawerLayout):void");
    }

    /* JADX WARNING: type inference failed for: r5v6, types: [androidx.navigation.ui.AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void setupWithNavController$default(com.google.android.material.appbar.CollapsingToolbarLayout r1, androidx.appcompat.widget.Toolbar r2, androidx.navigation.NavController r3, androidx.navigation.ui.AppBarConfiguration r4, int r5, java.lang.Object r6) {
        /*
            r5 = r5 & 4
            if (r5 == 0) goto L_0x0034
            androidx.navigation.NavGraph r4 = r3.getGraph()
            java.lang.String r5 = "navController.graph"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r5)
            r5 = 0
            androidx.drawerlayout.widget.DrawerLayout r5 = (androidx.drawerlayout.widget.DrawerLayout) r5
            androidx.navigation.ui.AppBarConfigurationKt$AppBarConfiguration$1 r6 = androidx.navigation.ui.AppBarConfigurationKt$AppBarConfiguration$1.INSTANCE
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            androidx.navigation.ui.AppBarConfiguration$Builder r0 = new androidx.navigation.ui.AppBarConfiguration$Builder
            r0.<init>((androidx.navigation.NavGraph) r4)
            androidx.navigation.ui.AppBarConfiguration$Builder r4 = r0.setDrawerLayout(r5)
            if (r6 == 0) goto L_0x0025
            androidx.navigation.ui.AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0 r5 = new androidx.navigation.ui.AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0
            r5.<init>(r6)
            r6 = r5
        L_0x0025:
            androidx.navigation.ui.AppBarConfiguration$OnNavigateUpListener r6 = (androidx.navigation.ui.AppBarConfiguration.OnNavigateUpListener) r6
            androidx.navigation.ui.AppBarConfiguration$Builder r4 = r4.setFallbackOnNavigateUpListener(r6)
            androidx.navigation.ui.AppBarConfiguration r4 = r4.build()
            java.lang.String r5 = "AppBarConfiguration.Buil…eUpListener)\n    .build()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r5)
        L_0x0034:
            setupWithNavController((com.google.android.material.appbar.CollapsingToolbarLayout) r1, (androidx.appcompat.widget.Toolbar) r2, (androidx.navigation.NavController) r3, (androidx.navigation.ui.AppBarConfiguration) r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.ui.CollapsingToolbarLayoutKt.setupWithNavController$default(com.google.android.material.appbar.CollapsingToolbarLayout, androidx.appcompat.widget.Toolbar, androidx.navigation.NavController, androidx.navigation.ui.AppBarConfiguration, int, java.lang.Object):void");
    }

    public static final void setupWithNavController(CollapsingToolbarLayout collapsingToolbarLayout, Toolbar toolbar, NavController navController, AppBarConfiguration appBarConfiguration) {
        Intrinsics.checkParameterIsNotNull(collapsingToolbarLayout, "$this$setupWithNavController");
        Intrinsics.checkParameterIsNotNull(toolbar, "toolbar");
        Intrinsics.checkParameterIsNotNull(navController, "navController");
        Intrinsics.checkParameterIsNotNull(appBarConfiguration, "configuration");
        NavigationUI.setupWithNavController(collapsingToolbarLayout, toolbar, navController, appBarConfiguration);
    }
}
