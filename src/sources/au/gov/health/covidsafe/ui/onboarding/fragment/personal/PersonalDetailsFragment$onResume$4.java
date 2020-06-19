package au.gov.health.covidsafe.ui.onboarding.fragment.personal;

import android.view.KeyEvent;
import android.widget.TextView;
import au.gov.health.covidsafe.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "event", "Landroid/view/KeyEvent;", "onEditorAction"}, k = 3, mv = {1, 1, 16})
/* compiled from: PersonalDetailsFragment.kt */
final class PersonalDetailsFragment$onResume$4 implements TextView.OnEditorActionListener {
    final /* synthetic */ PersonalDetailsFragment this$0;

    PersonalDetailsFragment$onResume$4(PersonalDetailsFragment personalDetailsFragment) {
        this.this$0 = personalDetailsFragment;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if ((i == 3 || i == 6 || (keyEvent != null && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 66)) && (keyEvent == null || !keyEvent.isShiftPressed())) {
            this.this$0.updatePersonalDetailsDataField();
            this.this$0.updateButtonState();
            TextView textView2 = (TextView) this.this$0._$_findCachedViewById(R.id.personal_details_age_error);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "personal_details_age_error");
            int i2 = 8;
            textView2.setVisibility(this.this$0.isValidAge() ? 8 : 0);
            TextView textView3 = (TextView) this.this$0._$_findCachedViewById(R.id.personal_details_post_code_error);
            Intrinsics.checkExpressionValueIsNotNull(textView3, "personal_details_post_code_error");
            if (!this.this$0.isValidPostcode()) {
                i2 = 0;
            }
            textView3.setVisibility(i2);
        }
        return false;
    }
}
