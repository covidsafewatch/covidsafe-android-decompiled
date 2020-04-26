package au.gov.health.covidsafe.ui;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.navigation.fragment.NavHostFragment;
import au.gov.health.covidsafe.HasBlockingState;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u0004J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0004¨\u0006\r"}, d2 = {"Lau/gov/health/covidsafe/ui/BaseFragment;", "Landroidx/fragment/app/Fragment;", "()V", "navigateTo", "", "actionId", "", "bundle", "Landroid/os/Bundle;", "navigatorExtras", "Landroidx/navigation/Navigator$Extras;", "onResume", "popBackStack", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: BaseFragment.kt */
public class BaseFragment extends Fragment {
    private HashMap _$_findViewCache;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onResume() {
        super.onResume();
        FragmentActivity activity = getActivity();
        if (activity instanceof HasBlockingState) {
            ((HasBlockingState) activity).setUiBlocked(false);
        }
    }

    public static /* synthetic */ void navigateTo$default(BaseFragment baseFragment, int i, Bundle bundle, Navigator.Extras extras, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                bundle = null;
            }
            if ((i2 & 4) != 0) {
                extras = null;
            }
            baseFragment.navigateTo(i, bundle, extras);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigateTo");
    }

    /* access modifiers changed from: protected */
    public final void navigateTo(int i, Bundle bundle, Navigator.Extras extras) {
        FragmentActivity activity = getActivity();
        if (activity instanceof HasBlockingState) {
            ((HasBlockingState) activity).setUiBlocked(true);
        }
        NavHostFragment.findNavController(this).navigate(i, bundle, (NavOptions) null, extras);
    }

    /* access modifiers changed from: protected */
    public final void popBackStack() {
        FragmentActivity activity = getActivity();
        if (activity instanceof HasBlockingState) {
            ((HasBlockingState) activity).setUiBlocked(true);
        }
        NavHostFragment.findNavController(this).popBackStack();
    }
}
