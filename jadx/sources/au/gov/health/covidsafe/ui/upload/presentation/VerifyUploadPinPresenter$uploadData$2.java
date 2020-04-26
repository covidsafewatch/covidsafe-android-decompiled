package au.gov.health.covidsafe.ui.upload.presentation;

import au.gov.health.covidsafe.interactor.usecase.UploadDataException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Ljava/lang/Exception;", "Lkotlin/Exception;", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: VerifyUploadPinPresenter.kt */
final class VerifyUploadPinPresenter$uploadData$2 extends Lambda implements Function1<Exception, Unit> {
    final /* synthetic */ VerifyUploadPinPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VerifyUploadPinPresenter$uploadData$2(VerifyUploadPinPresenter verifyUploadPinPresenter) {
        super(1);
        this.this$0 = verifyUploadPinPresenter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Exception) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Exception exc) {
        Intrinsics.checkParameterIsNotNull(exc, "it");
        if (exc instanceof UploadDataException.UploadDataIncorrectPinException) {
            this.this$0.fragment.showInvalidOtp();
        } else if (exc instanceof UploadDataException.UploadDataJwtExpiredException) {
            this.this$0.fragment.navigateToRegister();
        } else {
            this.this$0.fragment.showGenericError();
        }
        this.this$0.fragment.enableContinueButton();
        this.this$0.fragment.hideKeyboard();
        this.this$0.fragment.hideLoading();
    }
}
