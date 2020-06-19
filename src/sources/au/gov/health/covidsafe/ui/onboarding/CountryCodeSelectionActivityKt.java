package au.gov.health.covidsafe.ui.onboarding;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"VOICE_TO_TEXT_REQUEST_CODE", "", "smoothSnapToPosition", "", "Landroidx/recyclerview/widget/RecyclerView;", "position", "snapMode", "app_release"}, k = 2, mv = {1, 1, 16})
/* compiled from: CountryCodeSelectionActivity.kt */
public final class CountryCodeSelectionActivityKt {
    public static final int VOICE_TO_TEXT_REQUEST_CODE = 2020;

    public static /* synthetic */ void smoothSnapToPosition$default(RecyclerView recyclerView, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = -1;
        }
        smoothSnapToPosition(recyclerView, i, i2);
    }

    public static final void smoothSnapToPosition(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "$this$smoothSnapToPosition");
        CountryCodeSelectionActivityKt$smoothSnapToPosition$smoothScroller$1 countryCodeSelectionActivityKt$smoothSnapToPosition$smoothScroller$1 = new CountryCodeSelectionActivityKt$smoothSnapToPosition$smoothScroller$1(recyclerView, i2, recyclerView.getContext());
        countryCodeSelectionActivityKt$smoothSnapToPosition$smoothScroller$1.setTargetPosition(i);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            layoutManager.startSmoothScroll(countryCodeSelectionActivityKt$smoothSnapToPosition$smoothScroller$1);
        }
    }
}
