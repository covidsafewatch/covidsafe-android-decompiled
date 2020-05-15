package au.gov.health.covidsafe.ui.onboarding;

import au.gov.health.covidsafe.R;
import com.github.razir.progressbutton.ProgressParams;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/github/razir/progressbutton/ProgressParams;", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: OnboardingActivity.kt */
final class OnboardingActivity$showLoading$1 extends Lambda implements Function1<ProgressParams, Unit> {
    public static final OnboardingActivity$showLoading$1 INSTANCE = new OnboardingActivity$showLoading$1();

    OnboardingActivity$showLoading$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ProgressParams) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ProgressParams progressParams) {
        Intrinsics.checkParameterIsNotNull(progressParams, "$receiver");
        progressParams.setProgressColorRes(Integer.valueOf(R.color.slack_black_2));
    }
}
