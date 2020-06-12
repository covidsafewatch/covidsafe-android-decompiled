package au.gov.health.covidsafe.ui.splash;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lau/gov/health/covidsafe/ui/splash/SplashNavigationEvent;", "", "()V", "GoToNextScreen", "ShowMigrationScreen", "ShowSplashScreen", "Lau/gov/health/covidsafe/ui/splash/SplashNavigationEvent$ShowSplashScreen;", "Lau/gov/health/covidsafe/ui/splash/SplashNavigationEvent$ShowMigrationScreen;", "Lau/gov/health/covidsafe/ui/splash/SplashNavigationEvent$GoToNextScreen;", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: SplashViewModel.kt */
public abstract class SplashNavigationEvent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lau/gov/health/covidsafe/ui/splash/SplashNavigationEvent$ShowSplashScreen;", "Lau/gov/health/covidsafe/ui/splash/SplashNavigationEvent;", "()V", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: SplashViewModel.kt */
    public static final class ShowSplashScreen extends SplashNavigationEvent {
        public static final ShowSplashScreen INSTANCE = new ShowSplashScreen();

        private ShowSplashScreen() {
            super((DefaultConstructorMarker) null);
        }
    }

    private SplashNavigationEvent() {
    }

    public /* synthetic */ SplashNavigationEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lau/gov/health/covidsafe/ui/splash/SplashNavigationEvent$ShowMigrationScreen;", "Lau/gov/health/covidsafe/ui/splash/SplashNavigationEvent;", "()V", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: SplashViewModel.kt */
    public static final class ShowMigrationScreen extends SplashNavigationEvent {
        public static final ShowMigrationScreen INSTANCE = new ShowMigrationScreen();

        private ShowMigrationScreen() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lau/gov/health/covidsafe/ui/splash/SplashNavigationEvent$GoToNextScreen;", "Lau/gov/health/covidsafe/ui/splash/SplashNavigationEvent;", "()V", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: SplashViewModel.kt */
    public static final class GoToNextScreen extends SplashNavigationEvent {
        public static final GoToNextScreen INSTANCE = new GoToNextScreen();

        private GoToNextScreen() {
            super((DefaultConstructorMarker) null);
        }
    }
}
