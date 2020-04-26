package au.gov.health.covidsafe.ui.onboarding.fragment.enterpin;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Ljava/lang/Exception;", "Lkotlin/Exception;", "invoke", "au/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinPresenter$resendCode$1$2"}, k = 3, mv = {1, 1, 16})
/* compiled from: EnterPinPresenter.kt */
final class EnterPinPresenter$resendCode$$inlined$let$lambda$2 extends Lambda implements Function1<Exception, Unit> {
    final /* synthetic */ EnterPinPresenter this$0;

    EnterPinPresenter$resendCode$$inlined$let$lambda$2(EnterPinPresenter enterPinPresenter) {
        this.this$0 = enterPinPresenter;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Exception) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Exception exc) {
        Intrinsics.checkParameterIsNotNull(exc, "it");
        this.this$0.enterPinFragment.showGenericError();
    }
}
