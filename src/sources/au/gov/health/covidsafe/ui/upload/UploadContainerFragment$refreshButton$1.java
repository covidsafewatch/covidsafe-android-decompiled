package au.gov.health.covidsafe.ui.upload;

import android.view.View;
import au.gov.health.covidsafe.ui.UploadButtonLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
/* compiled from: UploadContainerFragment.kt */
final class UploadContainerFragment$refreshButton$1 implements View.OnClickListener {
    final /* synthetic */ UploadButtonLayout $uploadButtonLayout;

    UploadContainerFragment$refreshButton$1(UploadButtonLayout uploadButtonLayout) {
        this.$uploadButtonLayout = uploadButtonLayout;
    }

    public final void onClick(View view) {
        Function0<Unit> buttonListener = ((UploadButtonLayout.ContinueLayout) this.$uploadButtonLayout).getButtonListener();
        if (buttonListener != null) {
            Unit invoke = buttonListener.invoke();
        }
    }
}
