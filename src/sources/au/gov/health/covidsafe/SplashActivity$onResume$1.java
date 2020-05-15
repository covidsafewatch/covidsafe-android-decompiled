package au.gov.health.covidsafe;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 16})
/* compiled from: SplashActivity.kt */
final class SplashActivity$onResume$1 implements Runnable {
    final /* synthetic */ SplashActivity this$0;

    SplashActivity$onResume$1(SplashActivity splashActivity) {
        this.this$0 = splashActivity;
    }

    public final void run() {
        this.this$0.goToNextScreen();
        this.this$0.finish();
    }
}
