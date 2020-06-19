package au.gov.health.covidsafe.ui.onboarding;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "letterClicked", "", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: CountryCodeSelectionActivity.kt */
final class CountryCodeSelectionActivity$setupInitialLetterRecyclerView$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ CountryCodeSelectionActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CountryCodeSelectionActivity$setupInitialLetterRecyclerView$1(CountryCodeSelectionActivity countryCodeSelectionActivity) {
        super(1);
        this.this$0 = countryCodeSelectionActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        Intrinsics.checkParameterIsNotNull(str, "letterClicked");
        this.this$0.countryListScrollToPosition(new Function1<String, Integer>(this) {
            final /* synthetic */ CountryCodeSelectionActivity$setupInitialLetterRecyclerView$1 this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return Integer.valueOf(invoke((String) obj));
            }

            public final int invoke(String str) {
                Intrinsics.checkParameterIsNotNull(str, "letter");
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
                    }
                    i = i2;
                }
                return 0;
            }
        }.invoke(str));
    }
}
