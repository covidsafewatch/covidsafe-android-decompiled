package au.gov.health.covidsafe.ui.onboarding.fragment.enterpin;

import au.gov.health.covidsafe.networking.response.OTPChallengeResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "it", "Lau/gov/health/covidsafe/networking/response/OTPChallengeResponse;", "invoke", "au/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter$resendCode$1$1"}, k = 3, mv = {1, 1, 16})
/* compiled from: EnterPinPresenter.kt */
final class EnterPinPresenter$resendCode$$inlined$let$lambda$1 extends Lambda implements Function1<OTPChallengeResponse, Unit> {
    final /* synthetic */ EnterPinPresenter this$0;

    EnterPinPresenter$resendCode$$inlined$let$lambda$1(EnterPinPresenter enterPinPresenter) {
        this.this$0 = enterPinPresenter;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((OTPChallengeResponse) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(OTPChallengeResponse oTPChallengeResponse) {
        Intrinsics.checkParameterIsNotNull(oTPChallengeResponse, "it");
        this.this$0.session = oTPChallengeResponse.getSession();
        this.this$0.challengeName = oTPChallengeResponse.getChallengeName();
        this.this$0.enterPinFragment.resetTimer();
    }
}
