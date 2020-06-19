package au.gov.health.covidsafe.ui.onboarding;

import android.text.Editable;
import android.text.TextWatcher;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"au/gov/health/covidsafe/ui/onboarding/CountryCodeSelectionActivity$setupSearchFunctions$2", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: CountryCodeSelectionActivity.kt */
public final class CountryCodeSelectionActivity$setupSearchFunctions$2 implements TextWatcher {
    final /* synthetic */ CountryCodeSelectionActivity this$0;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    CountryCodeSelectionActivity$setupSearchFunctions$2(CountryCodeSelectionActivity countryCodeSelectionActivity) {
        this.this$0 = countryCodeSelectionActivity;
    }

    public void afterTextChanged(Editable editable) {
        String obj;
        int invoke;
        CountryCodeSelectionActivity$setupSearchFunctions$2$afterTextChanged$1 countryCodeSelectionActivity$setupSearchFunctions$2$afterTextChanged$1 = new CountryCodeSelectionActivity$setupSearchFunctions$2$afterTextChanged$1(this);
        if (editable != null && (obj = editable.toString()) != null && (invoke = countryCodeSelectionActivity$setupSearchFunctions$2$afterTextChanged$1.invoke(obj)) != -1) {
            this.this$0.countryListScrollToPosition(invoke);
        }
    }
}
