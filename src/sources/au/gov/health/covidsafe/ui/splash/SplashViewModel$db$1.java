package au.gov.health.covidsafe.ui.splash;

import androidx.lifecycle.ViewModelKt;
import au.gov.health.covidsafe.streetpass.persistence.MigrationCallBack;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"au/gov/health/covidsafe/ui/splash/SplashViewModel$db$1", "Lau/gov/health/covidsafe/streetpass/persistence/MigrationCallBack;", "migrationFinished", "", "migrationStarted", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: SplashViewModel.kt */
public final class SplashViewModel$db$1 implements MigrationCallBack {
    final /* synthetic */ SplashViewModel this$0;

    SplashViewModel$db$1(SplashViewModel splashViewModel) {
        this.this$0 = splashViewModel;
    }

    public void migrationStarted() {
        this.this$0.migrated = false;
        if (this.this$0.splashScreenPassed) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), (CoroutineContext) null, (CoroutineStart) null, new SplashViewModel$db$1$migrationStarted$1(this, (Continuation) null), 3, (Object) null);
        }
    }

    public void migrationFinished() {
        this.this$0.migrated = true;
        if (this.this$0.splashScreenPassed) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), (CoroutineContext) null, (CoroutineStart) null, new SplashViewModel$db$1$migrationFinished$1(this, (Continuation) null), 3, (Object) null);
        }
    }
}
