package au.gov.health.covidsafe.ui.onboarding;

import android.view.View;
import android.widget.ImageView;
import au.gov.health.covidsafe.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange"}, k = 3, mv = {1, 1, 16})
/* compiled from: CountryCodeSelectionActivity.kt */
final class CountryCodeSelectionActivity$setupSearchFunctions$1 implements View.OnFocusChangeListener {
    final /* synthetic */ CountryCodeSelectionActivity this$0;

    CountryCodeSelectionActivity$setupSearchFunctions$1(CountryCodeSelectionActivity countryCodeSelectionActivity) {
        this.this$0 = countryCodeSelectionActivity;
    }

    public final void onFocusChange(View view, boolean z) {
        ImageView imageView = (ImageView) this.this$0._$_findCachedViewById(R.id.countrySearchImageView);
        Intrinsics.checkExpressionValueIsNotNull(imageView, "countrySearchImageView");
        imageView.setVisibility(z ? 8 : 0);
    }
}
