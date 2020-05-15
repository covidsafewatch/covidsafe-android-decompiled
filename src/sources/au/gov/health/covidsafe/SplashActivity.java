package au.gov.health.covidsafe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import au.gov.health.covidsafe.ui.onboarding.OnboardingActivity;
import java.util.Calendar;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\"\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u0012\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010\u0017\u001a\u00020\rH\u0014J\b\u0010\u0018\u001a\u00020\rH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lau/gov/health/covidsafe/SplashActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "ERROR_DIALOG_REQUEST_CODE", "", "SPLASH_TIME", "", "mHandler", "Landroid/os/Handler;", "retryProviderInstall", "", "updateFlag", "goToNextScreen", "", "hideSystemUI", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: SplashActivity.kt */
public final class SplashActivity extends AppCompatActivity {
    private final int ERROR_DIALOG_REQUEST_CODE = 1;
    private final long SPLASH_TIME = 20000;
    private HashMap _$_findViewCache;
    private Handler mHandler;
    private boolean retryProviderInstall;
    private boolean updateFlag;

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
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_splash);
        hideSystemUI();
        this.mHandler = new Handler();
        String string = Settings.Secure.getString(getContentResolver(), "android_id");
        Intrinsics.checkExpressionValueIsNotNull(string, "Settings.Secure.getStrin…ttings.Secure.ANDROID_ID)");
        Preference.INSTANCE.putDeviceID(this, string);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        Handler handler = this.mHandler;
        if (handler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHandler");
        }
        handler.removeCallbacksAndMessages((Object) null);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (!this.updateFlag) {
            Handler handler = this.mHandler;
            if (handler == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHandler");
            }
            handler.postDelayed(new SplashActivity$onResume$1(this), this.SPLASH_TIME);
        }
    }

    /* access modifiers changed from: private */
    public final void goToNextScreen() {
        Class cls;
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "it");
        Context context = this;
        instance.setTimeInMillis(Preference.INSTANCE.getDataUploadedDateMs(context));
        Calendar instance2 = Calendar.getInstance();
        instance2.add(5, -14);
        if (!Preference.INSTANCE.isOnBoarded(context)) {
            cls = OnboardingActivity.class;
        } else if (instance.before(instance2)) {
            cls = SelfIsolationDoneActivity.class;
        } else {
            cls = HomeActivity.class;
        }
        startActivity(new Intent(context, cls));
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == this.ERROR_DIALOG_REQUEST_CODE) {
            this.retryProviderInstall = true;
        }
    }

    private final void hideSystemUI() {
        Window window = getWindow();
        Intrinsics.checkExpressionValueIsNotNull(window, "window");
        View decorView = window.getDecorView();
        Intrinsics.checkExpressionValueIsNotNull(decorView, "window.decorView");
        decorView.setSystemUiVisibility(1798);
    }
}
