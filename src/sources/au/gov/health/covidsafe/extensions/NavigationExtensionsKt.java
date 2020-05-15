package au.gov.health.covidsafe.extensions;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.navigation.fragment.NavHostFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, d2 = {"navigateTo", "", "Landroidx/fragment/app/Fragment;", "actionId", "", "bundle", "Landroid/os/Bundle;", "navigatorExtras", "Landroidx/navigation/Navigator$Extras;", "app_release"}, k = 2, mv = {1, 1, 16})
/* compiled from: NavigationExtensions.kt */
public final class NavigationExtensionsKt {
    public static final void navigateTo(Fragment fragment, int i, Bundle bundle, Navigator.Extras extras) {
        Intrinsics.checkParameterIsNotNull(fragment, "$this$navigateTo");
        NavHostFragment.findNavController(fragment).navigate(i, bundle, (NavOptions) null, extras);
    }

    public static /* synthetic */ void navigateTo$default(Fragment fragment, int i, Bundle bundle, Navigator.Extras extras, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            bundle = null;
        }
        if ((i2 & 4) != 0) {
            extras = null;
        }
        navigateTo(fragment, i, bundle, extras);
    }
}
