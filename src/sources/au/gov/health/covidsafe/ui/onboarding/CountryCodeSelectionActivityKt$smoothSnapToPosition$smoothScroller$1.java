package au.gov.health.covidsafe.ui.onboarding;

import android.content.Context;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0014J\b\u0010\u0004\u001a\u00020\u0003H\u0014¨\u0006\u0005"}, d2 = {"au/gov/health/covidsafe/ui/onboarding/CountryCodeSelectionActivityKt$smoothSnapToPosition$smoothScroller$1", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "getHorizontalSnapPreference", "", "getVerticalSnapPreference", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: CountryCodeSelectionActivity.kt */
public final class CountryCodeSelectionActivityKt$smoothSnapToPosition$smoothScroller$1 extends LinearSmoothScroller {
    final /* synthetic */ int $snapMode;
    final /* synthetic */ RecyclerView $this_smoothSnapToPosition;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CountryCodeSelectionActivityKt$smoothSnapToPosition$smoothScroller$1(RecyclerView recyclerView, int i, Context context) {
        super(context);
        this.$this_smoothSnapToPosition = recyclerView;
        this.$snapMode = i;
    }

    /* access modifiers changed from: protected */
    public int getVerticalSnapPreference() {
        return this.$snapMode;
    }

    /* access modifiers changed from: protected */
    public int getHorizontalSnapPreference() {
        return this.$snapMode;
    }
}
