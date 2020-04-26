package au.gov.health.covidsafe.ui.onboarding.fragment.undersixteen;

import androidx.core.os.BundleKt;
import au.gov.health.covidsafe.R;
import au.gov.health.covidsafe.ui.BaseFragment;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: UnderSixteenFragment.kt */
final class UnderSixteenFragment$getUploadButtonLayout$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ UnderSixteenFragment this$0;

    UnderSixteenFragment$getUploadButtonLayout$1(UnderSixteenFragment underSixteenFragment) {
        this.this$0 = underSixteenFragment;
        super(0);
    }

    public final void invoke() {
        BaseFragment.navigateTo$default(this.this$0, UnderSixteenFragmentDirections.Companion.actionUnderSixteenFragmentToEnterNumberFragment().getActionId(), BundleKt.bundleOf(TuplesKt.to("destination_id", Integer.valueOf(R.id.action_otpFragment_to_permissionFragment)), TuplesKt.to("progress", Integer.valueOf(2))), null, 4, null);
    }
}
