package au.gov.health.covidsafe.ui.upload.presentation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: VerifyUploadPinFragment.kt */
final class VerifyUploadPinFragment$onResume$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ VerifyUploadPinFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VerifyUploadPinFragment$onResume$1(VerifyUploadPinFragment verifyUploadPinFragment) {
        super(0);
        this.this$0 = verifyUploadPinFragment;
    }

    public final void invoke() {
        this.this$0.updateButtonState();
        this.this$0.hideInvalidOtp();
    }
}
