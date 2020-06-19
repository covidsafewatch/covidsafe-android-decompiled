package au.gov.health.covidsafe.ui.onboarding;

import androidx.recyclerview.widget.RecyclerView;
import au.gov.health.covidsafe.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 16})
/* compiled from: CountryCodeSelectionActivity.kt */
final class CountryCodeSelectionActivity$countryListScrollToPosition$1 implements Runnable {
    final /* synthetic */ int $positionOfLetter;
    final /* synthetic */ CountryCodeSelectionActivity this$0;

    CountryCodeSelectionActivity$countryListScrollToPosition$1(CountryCodeSelectionActivity countryCodeSelectionActivity, int i) {
        this.this$0 = countryCodeSelectionActivity;
        this.$positionOfLetter = i;
    }

    public final void run() {
        Thread.sleep(100);
        this.this$0.runOnUiThread(new Runnable(this) {
            final /* synthetic */ CountryCodeSelectionActivity$countryListScrollToPosition$1 this$0;

            {
                this.this$0 = r1;
            }

            public final void run() {
                RecyclerView recyclerView = (RecyclerView) this.this$0.this$0._$_findCachedViewById(R.id.countryListRecyclerView);
                Intrinsics.checkExpressionValueIsNotNull(recyclerView, "countryListRecyclerView");
                CountryCodeSelectionActivityKt.smoothSnapToPosition$default(recyclerView, this.this$0.$positionOfLetter, 0, 2, (Object) null);
            }
        });
    }
}
