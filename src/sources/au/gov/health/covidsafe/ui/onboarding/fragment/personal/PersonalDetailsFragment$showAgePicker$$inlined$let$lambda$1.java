package au.gov.health.covidsafe.ui.onboarding.fragment.personal;

import android.content.DialogInterface;
import android.widget.TextView;
import au.gov.health.covidsafe.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick", "au/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment$showAgePicker$1$3"}, k = 3, mv = {1, 1, 16})
/* compiled from: PersonalDetailsFragment.kt */
final class PersonalDetailsFragment$showAgePicker$$inlined$let$lambda$1 implements DialogInterface.OnClickListener {
    final /* synthetic */ List $ages;
    final /* synthetic */ Ref.IntRef $selected;
    final /* synthetic */ PersonalDetailsFragment this$0;

    PersonalDetailsFragment$showAgePicker$$inlined$let$lambda$1(List list, Ref.IntRef intRef, PersonalDetailsFragment personalDetailsFragment) {
        this.$ages = list;
        this.$selected = intRef;
        this.this$0 = personalDetailsFragment;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.this$0.ageSelected = (Pair) this.$ages.get(this.$selected.element);
        TextView textView = (TextView) this.this$0._$_findCachedViewById(R.id.personal_details_age);
        Intrinsics.checkExpressionValueIsNotNull(textView, "personal_details_age");
        textView.setText((CharSequence) ((Pair) this.$ages.get(this.$selected.element)).getSecond());
        this.this$0.hideAgeError();
        this.this$0.updateButtonState();
    }
}
