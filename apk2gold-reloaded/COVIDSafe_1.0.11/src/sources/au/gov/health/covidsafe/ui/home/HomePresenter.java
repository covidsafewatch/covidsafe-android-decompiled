package au.gov.health.covidsafe.ui.home;

import androidx.lifecycle.LifecycleObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lau/gov/health/covidsafe/ui/home/HomePresenter;", "Landroidx/lifecycle/LifecycleObserver;", "fragment", "Lau/gov/health/covidsafe/ui/home/HomeFragment;", "(Lau/gov/health/covidsafe/ui/home/HomeFragment;)V", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: HomePresenter.kt */
public final class HomePresenter implements LifecycleObserver {
    private final HomeFragment fragment;

    public HomePresenter(HomeFragment homeFragment) {
        Intrinsics.checkParameterIsNotNull(homeFragment, "fragment");
        this.fragment = homeFragment;
        homeFragment.getLifecycle().addObserver(this);
    }
}
