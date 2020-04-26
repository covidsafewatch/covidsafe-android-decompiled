package au.gov.health.covidsafe.ui.upload.presentation;

import android.app.Dialog;
import android.view.View;
import au.gov.health.covidsafe.R;
import au.gov.health.covidsafe.ui.upload.presentation.VerifyUploadPinFragment.OnUploadErrorInterface;
import au.gov.health.covidsafe.ui.view.PinInputView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005¸\u0006\u0000"}, d2 = {"au/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment$showGenericError$1$1", "Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment$OnUploadErrorInterface;", "onNegativeClicked", "", "onPositiveClicked", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: VerifyUploadPinFragment.kt */
public final class VerifyUploadPinFragment$showGenericError$$inlined$let$lambda$1 implements OnUploadErrorInterface {
    final /* synthetic */ VerifyUploadPinFragment this$0;

    VerifyUploadPinFragment$showGenericError$$inlined$let$lambda$1(VerifyUploadPinFragment verifyUploadPinFragment) {
        this.this$0 = verifyUploadPinFragment;
    }

    public void onPositiveClicked() {
        VerifyUploadPinPresenter access$getPresenter$p = VerifyUploadPinFragment.access$getPresenter$p(this.this$0);
        View requireView = this.this$0.requireView();
        Intrinsics.checkExpressionValueIsNotNull(requireView, "requireView()");
        access$getPresenter$p.uploadData$app_release(((PinInputView) requireView.findViewById(R.id.pin)).getValue());
    }

    public void onNegativeClicked() {
        Dialog access$getDialog$p = this.this$0.dialog;
        if (access$getDialog$p != null) {
            access$getDialog$p.dismiss();
        }
    }
}
