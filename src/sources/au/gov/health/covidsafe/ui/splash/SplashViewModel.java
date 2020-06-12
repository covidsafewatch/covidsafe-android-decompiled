package au.gov.health.covidsafe.ui.splash;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import au.gov.health.covidsafe.streetpass.persistence.MigrationCallBack;
import au.gov.health.covidsafe.streetpass.persistence.StreetPassRecordDatabase;
import au.gov.health.covidsafe.ui.splash.SplashNavigationEvent;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lau/gov/health/covidsafe/ui/splash/SplashViewModel;", "Landroidx/lifecycle/ViewModel;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "SPLASH_TIME", "", "db", "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase;", "getDb", "()Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase;", "migrated", "", "splashNavigationLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lau/gov/health/covidsafe/ui/splash/SplashNavigationEvent;", "getSplashNavigationLiveData", "()Landroidx/lifecycle/MutableLiveData;", "splashScreenPassed", "release", "", "setupUI", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: SplashViewModel.kt */
public final class SplashViewModel extends ViewModel {
    /* access modifiers changed from: private */
    public final long SPLASH_TIME = 2000;
    private final StreetPassRecordDatabase db;
    /* access modifiers changed from: private */
    public boolean migrated;
    private final MutableLiveData<SplashNavigationEvent> splashNavigationLiveData = new MutableLiveData<>(SplashNavigationEvent.ShowSplashScreen.INSTANCE);
    /* access modifiers changed from: private */
    public boolean splashScreenPassed;

    public SplashViewModel(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.db = StreetPassRecordDatabase.Companion.getDatabase(context, new SplashViewModel$db$1(this));
    }

    public final MutableLiveData<SplashNavigationEvent> getSplashNavigationLiveData() {
        return this.splashNavigationLiveData;
    }

    public final StreetPassRecordDatabase getDb() {
        return this.db;
    }

    public final void setupUI() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new SplashViewModel$setupUI$1(this, (Continuation) null), 3, (Object) null);
    }

    public final void release() {
        StreetPassRecordDatabase.Companion.setMigrationCallback((MigrationCallBack) null);
        CoroutineScopeKt.cancel$default(ViewModelKt.getViewModelScope(this), (CancellationException) null, 1, (Object) null);
    }
}
