package au.gov.health.covidsafe.ui.onboarding.fragment.personal;

import android.view.View;
import android.widget.TextView;
import au.gov.health.covidsafe.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange"}, k = 3, mv = {1, 1, 16})
/* compiled from: PersonalDetailsFragment.kt */
final class PersonalDetailsFragment$onResume$3 implements View.OnFocusChangeListener {
    final /* synthetic */ PersonalDetailsFragment this$0;

    PersonalDetailsFragment$onResume$3(PersonalDetailsFragment personalDetailsFragment) {
        this.this$0 = personalDetailsFragment;
    }

    public final void onFocusChange(View view, boolean z) {
        if (z) {
            this.this$0.updatePersonalDetailsDataField();
            this.this$0.updateButtonState();
            TextView textView = (TextView) this.this$0._$_findCachedViewById(R.id.personal_details_age_error);
            Intrinsics.checkExpressionValueIsNotNull(textView, "personal_details_age_error");
            textView.setVisibility(this.this$0.isValidAge() ? 8 : 0);
        }
    }
}
