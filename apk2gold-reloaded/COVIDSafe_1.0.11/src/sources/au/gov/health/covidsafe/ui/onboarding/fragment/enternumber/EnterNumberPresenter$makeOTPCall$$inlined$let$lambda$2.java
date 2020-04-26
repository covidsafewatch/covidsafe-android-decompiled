package au.gov.health.covidsafe.ui.onboarding.fragment.enternumber;

import au.gov.health.covidsafe.interactor.usecase.GetOnboardingOtpException.GetOtpInvalidNumberException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Ljava/lang/Exception;", "Lkotlin/Exception;", "invoke", "au/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter$makeOTPCall$1$2"}, k = 3, mv = {1, 1, 16})
/* compiled from: EnterNumberPresenter.kt */
final class EnterNumberPresenter$makeOTPCall$$inlined$let$lambda$2 extends Lambda implements Function1<Exception, Unit> {
    final /* synthetic */ String $phoneNumber$inlined;
    final /* synthetic */ EnterNumberPresenter this$0;

    EnterNumberPresenter$makeOTPCall$$inlined$let$lambda$2(EnterNumberPresenter enterNumberPresenter, String str) {
        this.this$0 = enterNumberPresenter;
        this.$phoneNumber$inlined = str;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Exception) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Exception exc) {
        Intrinsics.checkParameterIsNotNull(exc, "it");
        if (exc instanceof GetOtpInvalidNumberException) {
            this.this$0.enterNumberFragment.showInvalidPhoneNumber();
        } else {
            this.this$0.enterNumberFragment.showGenericError();
        }
        this.this$0.enterNumberFragment.hideLoading();
        this.this$0.enterNumberFragment.enableContinueButton();
    }
}
