package au.gov.health.covidsafe;

import androidx.lifecycle.Observer;
import au.gov.health.covidsafe.ui.splash.SplashNavigationEvent;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lau/gov/health/covidsafe/ui/splash/SplashNavigationEvent;", "kotlin.jvm.PlatformType", "onChanged"}, k = 3, mv = {1, 1, 16})
/* compiled from: SplashActivity.kt */
final class SplashActivity$onCreate$1<T> implements Observer<SplashNavigationEvent> {
    final /* synthetic */ SplashActivity this$0;

    SplashActivity$onCreate$1(SplashActivity splashActivity) {
        this.this$0 = splashActivity;
    }

    public final void onChanged(SplashNavigationEvent splashNavigationEvent) {
        if (splashNavigationEvent instanceof SplashNavigationEvent.GoToNextScreen) {
            this.this$0.goToNextScreen();
        } else if (splashNavigationEvent instanceof SplashNavigationEvent.ShowMigrationScreen) {
            this.this$0.migrationScreen();
        }
    }
}
