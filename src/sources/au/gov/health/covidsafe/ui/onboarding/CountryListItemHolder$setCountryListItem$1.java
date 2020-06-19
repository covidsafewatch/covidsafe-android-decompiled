package au.gov.health.covidsafe.ui.onboarding;

import android.view.View;
import au.gov.health.covidsafe.Preference;
import au.gov.health.covidsafe.TracerApp;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
/* compiled from: CountryListRecyclerView.kt */
final class CountryListItemHolder$setCountryListItem$1 implements View.OnClickListener {
    final /* synthetic */ int $callingCode;
    final /* synthetic */ int $countryNameResId;
    final /* synthetic */ int $flagResID;
    final /* synthetic */ CountryListItemHolder this$0;

    CountryListItemHolder$setCountryListItem$1(CountryListItemHolder countryListItemHolder, int i, int i2, int i3) {
        this.this$0 = countryListItemHolder;
        this.$countryNameResId = i;
        this.$callingCode = i2;
        this.$flagResID = i3;
    }

    public final void onClick(View view) {
        Preference.INSTANCE.putCountryNameResID(TracerApp.Companion.getAppContext(), this.$countryNameResId);
        Preference.INSTANCE.putCallingCode(TracerApp.Companion.getAppContext(), this.$callingCode);
        Preference.INSTANCE.putNationalFlagResID(TracerApp.Companion.getAppContext(), this.$flagResID);
        this.this$0.onCountryClicked.invoke();
    }
}
