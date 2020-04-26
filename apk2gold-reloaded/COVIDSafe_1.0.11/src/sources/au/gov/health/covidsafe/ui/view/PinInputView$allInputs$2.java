package au.gov.health.covidsafe.ui.view;

import android.widget.EditText;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/widget/EditText;", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: PinInputView.kt */
final class PinInputView$allInputs$2 extends Lambda implements Function0<List<? extends EditText>> {
    final /* synthetic */ PinInputView this$0;

    PinInputView$allInputs$2(PinInputView pinInputView) {
        this.this$0 = pinInputView;
        super(0);
    }

    public final List<EditText> invoke() {
        return CollectionsKt.listOf(this.this$0.getPinOne(), this.this$0.getPinTwo(), this.this$0.getPinThree(), this.this$0.getPinFour(), this.this$0.getPinFive(), this.this$0.getPinSix());
    }
}
