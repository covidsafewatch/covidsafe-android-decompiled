package au.gov.health.covidsafe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\u0007\u001a\u00020\u0004H\u0014J\b\u0010\b\u001a\u00020\u0004H\u0014J\b\u0010\t\u001a\u00020\u0004H\u0014¨\u0006\n"}, d2 = {"Lau/gov/health/covidsafe/SelfIsolationDoneActivity;", "Landroidx/fragment/app/FragmentActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: SelfIsolationDoneActivity.kt */
public final class SelfIsolationDoneActivity extends FragmentActivity {
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
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_self_isolation);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        ((Button) _$_findCachedViewById(R.id.activity_self_isolation_next)).setOnClickListener(new SelfIsolationDoneActivity$onResume$1(this));
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        ((Button) _$_findCachedViewById(R.id.activity_self_isolation_next)).setOnClickListener((View.OnClickListener) null);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        ((LinearLayout) _$_findCachedViewById(R.id.root)).removeAllViews();
    }
}
