package au.gov.health.covidsafe.ui.onboarding.fragment.personal;

import android.content.Context;
import au.gov.health.covidsafe.Preference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: PersonalDetailsFragment.kt */
final class PersonalDetailsFragment$getUploadButtonLayout$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PersonalDetailsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PersonalDetailsFragment$getUploadButtonLayout$1(PersonalDetailsFragment personalDetailsFragment) {
        super(0);
        this.this$0 = personalDetailsFragment;
    }

    public final void invoke() {
        Context requireContext = this.this$0.requireContext();
        Intrinsics.checkExpressionValueIsNotNull(requireContext, "this.requireContext()");
        Preference.INSTANCE.putName(requireContext, PersonalDetailsFragment.access$getName$p(this.this$0));
        Preference.INSTANCE.putAge(requireContext, String.valueOf(this.this$0.age));
        Preference.INSTANCE.putPostCode(requireContext, PersonalDetailsFragment.access$getPostcode$p(this.this$0));
        PersonalDetailsFragment personalDetailsFragment = this.this$0;
        personalDetailsFragment.navigateToNextPage(personalDetailsFragment.age < 16);
    }
}
