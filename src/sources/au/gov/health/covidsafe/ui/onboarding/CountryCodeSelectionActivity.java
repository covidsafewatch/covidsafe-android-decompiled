package au.gov.health.covidsafe.ui.onboarding;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.health.covidsafe.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\"\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\u0012\u0010\u0011\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\tH\u0002J\b\u0010\u0015\u001a\u00020\tH\u0002J\b\u0010\u0016\u001a\u00020\tH\u0002J\b\u0010\u0017\u001a\u00020\tH\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lau/gov/health/covidsafe/ui/onboarding/CountryCodeSelectionActivity;", "Landroid/app/Activity;", "()V", "countryListItem", "", "Lau/gov/health/covidsafe/ui/onboarding/CountryListItemInterface;", "getCountryListItem", "()Ljava/util/List;", "countryListScrollToPosition", "", "positionOfLetter", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupCountryListRecyclerView", "setupInitialLetterRecyclerView", "setupSearchFunctions", "setupToolbar", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: CountryCodeSelectionActivity.kt */
public final class CountryCodeSelectionActivity extends Activity {
    private HashMap _$_findViewCache;
    private final List<CountryListItemInterface> countryListItem = CountryList.INSTANCE.getCountryList();

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

    public final List<CountryListItemInterface> getCountryListItem() {
        return this.countryListItem;
    }

    private final void setupToolbar() {
        ((Toolbar) _$_findCachedViewById(R.id.countrySelectionToolbar)).setNavigationOnClickListener(new CountryCodeSelectionActivity$setupToolbar$1(this));
        Toolbar toolbar = (Toolbar) _$_findCachedViewById(R.id.countrySelectionToolbar);
        Intrinsics.checkExpressionValueIsNotNull(toolbar, "countrySelectionToolbar");
        toolbar.setTitle((CharSequence) getString(R.string.select_country_or_region));
    }

    private final void setupCountryListRecyclerView() {
        Context context = this;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.countryListRecyclerView);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "countryListRecyclerView");
        recyclerView.setLayoutManager(linearLayoutManager);
        ((RecyclerView) _$_findCachedViewById(R.id.countryListRecyclerView)).addItemDecoration(new DividerItemDecoration(context, linearLayoutManager.getOrientation()));
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(R.id.countryListRecyclerView);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "countryListRecyclerView");
        recyclerView2.setAdapter(new CountryListRecyclerViewAdapter(context, this.countryListItem, new CountryCodeSelectionActivity$setupCountryListRecyclerView$1(this)));
    }

    /* access modifiers changed from: private */
    public final void countryListScrollToPosition(int i) {
        ((RecyclerView) _$_findCachedViewById(R.id.countryListRecyclerView)).scrollToPosition(i);
        new Thread(new CountryCodeSelectionActivity$countryListScrollToPosition$1(this, i)).start();
    }

    private final void setupSearchFunctions() {
        ((EditText) _$_findCachedViewById(R.id.countryRegionNameEditText)).setOnFocusChangeListener(new CountryCodeSelectionActivity$setupSearchFunctions$1(this));
        ((EditText) _$_findCachedViewById(R.id.countryRegionNameEditText)).addTextChangedListener(new CountryCodeSelectionActivity$setupSearchFunctions$2(this));
        ((ImageView) _$_findCachedViewById(R.id.microphoneImageView)).setOnClickListener(new CountryCodeSelectionActivity$setupSearchFunctions$3(this));
    }

    private final void setupInitialLetterRecyclerView() {
        ArrayList arrayList = new ArrayList();
        for (char c = 'A'; c <= 'Z'; c = (char) (c + 1)) {
            if (!(c == 'W' || c == 'X')) {
                arrayList.add(String.valueOf(c));
            }
        }
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.countryInitialLetterRecyclerView);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "countryInitialLetterRecyclerView");
        Context context = this;
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(R.id.countryInitialLetterRecyclerView);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "countryInitialLetterRecyclerView");
        recyclerView2.setAdapter(new CountryInitialLetterRecyclerViewAdapter(context, arrayList, new CountryCodeSelectionActivity$setupInitialLetterRecyclerView$1(this)));
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i, i2, intent);
        if (i == 2020 && i2 == -1 && intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("android.speech.extra.RESULTS")) != null) {
            ((EditText) _$_findCachedViewById(R.id.countryRegionNameEditText)).setText((CharSequence) CollectionsKt.first(stringArrayListExtra));
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_country_code_selection);
        setupToolbar();
        setupCountryListRecyclerView();
        setupInitialLetterRecyclerView();
        setupSearchFunctions();
    }
}
