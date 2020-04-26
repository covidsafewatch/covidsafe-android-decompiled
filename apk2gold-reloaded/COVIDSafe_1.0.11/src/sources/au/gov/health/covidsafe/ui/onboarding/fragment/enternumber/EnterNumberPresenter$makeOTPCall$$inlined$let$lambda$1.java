package au.gov.health.covidsafe.ui.onboarding.fragment.enternumber;

import au.gov.health.covidsafe.networking.response.OTPChallengeResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "it", "Lau/gov/health/covidsafe/networking/response/OTPChallengeResponse;", "invoke", "au/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter$makeOTPCall$1$1"}, k = 3, mv = {1, 1, 16})
/* compiled from: EnterNumberPresenter.kt */
final class EnterNumberPresenter$makeOTPCall$$inlined$let$lambda$1 extends Lambda implements Function1<OTPChallengeResponse, Unit> {
    final /* synthetic */ String $phoneNumber$inlined;
    final /* synthetic */ EnterNumberPresenter this$0;

    EnterNumberPresenter$makeOTPCall$$inlined$let$lambda$1(EnterNumberPresenter enterNumberPresenter, String str) {
        this.this$0 = enterNumberPresenter;
        this.$phoneNumber$inlined = str;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((OTPChallengeResponse) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(OTPChallengeResponse oTPChallengeResponse) {
        Intrinsics.checkParameterIsNotNull(oTPChallengeResponse, "it");
        this.this$0.enterNumberFragment.navigateToOTPPage(oTPChallengeResponse.getSession(), oTPChallengeResponse.getChallengeName(), this.$phoneNumber$inlined);
    }
}
