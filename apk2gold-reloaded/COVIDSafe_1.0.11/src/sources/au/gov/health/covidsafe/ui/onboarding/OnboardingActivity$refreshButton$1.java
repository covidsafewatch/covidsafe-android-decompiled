package au.gov.health.covidsafe.ui.onboarding;

import android.view.View;
import android.view.View.OnClickListener;
import au.gov.health.covidsafe.ui.UploadButtonLayout;
import au.gov.health.covidsafe.ui.UploadButtonLayout.ContinueLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
/* compiled from: OnboardingActivity.kt */
final class OnboardingActivity$refreshButton$1 implements OnClickListener {
    final /* synthetic */ UploadButtonLayout $updateButtonLayout;

    OnboardingActivity$refreshButton$1(UploadButtonLayout uploadButtonLayout) {
        this.$updateButtonLayout = uploadButtonLayout;
    }

    public final void onClick(View view) {
        Function0 buttonListener = ((ContinueLayout) this.$updateButtonLayout).getButtonListener();
        if (buttonListener != null) {
            Unit unit = (Unit) buttonListener.invoke();
        }
    }
}
