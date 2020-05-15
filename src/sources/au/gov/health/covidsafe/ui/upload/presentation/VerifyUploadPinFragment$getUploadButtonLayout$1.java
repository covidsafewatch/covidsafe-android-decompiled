package au.gov.health.covidsafe.ui.upload.presentation;

import android.view.View;
import au.gov.health.covidsafe.R;
import au.gov.health.covidsafe.ui.view.PinInputView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: VerifyUploadPinFragment.kt */
final class VerifyUploadPinFragment$getUploadButtonLayout$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ VerifyUploadPinFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VerifyUploadPinFragment$getUploadButtonLayout$1(VerifyUploadPinFragment verifyUploadPinFragment) {
        super(0);
        this.this$0 = verifyUploadPinFragment;
    }

    public final void invoke() {
        VerifyUploadPinPresenter access$getPresenter$p = VerifyUploadPinFragment.access$getPresenter$p(this.this$0);
        View requireView = this.this$0.requireView();
        Intrinsics.checkExpressionValueIsNotNull(requireView, "requireView()");
        access$getPresenter$p.uploadData$app_release(((PinInputView) requireView.findViewById(R.id.pin)).getValue());
    }
}
