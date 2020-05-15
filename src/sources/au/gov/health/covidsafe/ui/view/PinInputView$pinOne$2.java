package au.gov.health.covidsafe.ui.view;

import au.gov.health.covidsafe.R;
import com.google.android.material.textfield.TextInputEditText;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/android/material/textfield/TextInputEditText;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: PinInputView.kt */
final class PinInputView$pinOne$2 extends Lambda implements Function0<TextInputEditText> {
    final /* synthetic */ PinInputView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PinInputView$pinOne$2(PinInputView pinInputView) {
        super(0);
        this.this$0 = pinInputView;
    }

    public final TextInputEditText invoke() {
        return (TextInputEditText) this.this$0._$_findCachedViewById(R.id.pin_1);
    }
}
