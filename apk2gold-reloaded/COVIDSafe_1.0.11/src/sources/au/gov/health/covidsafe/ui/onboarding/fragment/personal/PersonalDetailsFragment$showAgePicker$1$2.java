package au.gov.health.covidsafe.ui.onboarding.fragment.personal;

import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref.IntRef;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/NumberPicker;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "newVal", "onValueChange"}, k = 3, mv = {1, 1, 16})
/* compiled from: PersonalDetailsFragment.kt */
final class PersonalDetailsFragment$showAgePicker$1$2 implements OnValueChangeListener {
    final /* synthetic */ IntRef $selected;

    PersonalDetailsFragment$showAgePicker$1$2(IntRef intRef) {
        this.$selected = intRef;
    }

    public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
        this.$selected.element = i2;
    }
}
