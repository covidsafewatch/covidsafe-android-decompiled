package au.gov.health.covidsafe.ui.onboarding;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"getPositionOfCountryName", "", "searchText", "", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: CountryCodeSelectionActivity.kt */
final class CountryCodeSelectionActivity$setupSearchFunctions$2$afterTextChanged$1 extends Lambda implements Function1<String, Integer> {
    final /* synthetic */ CountryCodeSelectionActivity$setupSearchFunctions$2 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CountryCodeSelectionActivity$setupSearchFunctions$2$afterTextChanged$1(CountryCodeSelectionActivity$setupSearchFunctions$2 countryCodeSelectionActivity$setupSearchFunctions$2) {
        super(1);
        this.this$0 = countryCodeSelectionActivity$setupSearchFunctions$2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Integer.valueOf(invoke((String) obj));
    }

    public final int invoke(String str) {
        Intrinsics.checkParameterIsNotNull(str, "searchText");
        int i = 0;
        for (Object next : this.this$0.this$0.getCountryListItem()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            CountryListItemInterface countryListItemInterface = (CountryListItemInterface) next;
            if (countryListItemInterface instanceof CountryGroupTitle) {
                String string = this.this$0.this$0.getString(((CountryGroupTitle) countryListItemInterface).getTitleResId());
                Intrinsics.checkExpressionValueIsNotNull(string, "getString(countryListItemInterface.titleResId)");
                if (StringsKt.startsWith(string, str, true)) {
                    return i;
                }
            } else if (countryListItemInterface instanceof CountryListItem) {
                CountryListItem countryListItem = (CountryListItem) countryListItemInterface;
                String string2 = this.this$0.this$0.getString(countryListItem.getCountryNameResId());
                Intrinsics.checkExpressionValueIsNotNull(string2, "getString(countryListIte…terface.countryNameResId)");
                if (StringsKt.contains((CharSequence) string2, (CharSequence) str, true) || StringsKt.startsWith(String.valueOf(countryListItem.getCallingCode()), str, true)) {
                    return i;
                }
            } else {
                continue;
            }
            i = i2;
        }
        return -1;
    }
}
