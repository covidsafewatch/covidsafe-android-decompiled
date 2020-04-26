package au.gov.health.covidsafe.ui.onboarding.fragment.enternumber;

import android.widget.EditText;
import au.gov.health.covidsafe.R;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: EnterNumberFragment.kt */
final class EnterNumberFragment$getUploadButtonLayout$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ EnterNumberFragment this$0;

    EnterNumberFragment$getUploadButtonLayout$1(EnterNumberFragment enterNumberFragment) {
        this.this$0 = enterNumberFragment;
        super(0);
    }

    public final void invoke() {
        EnterNumberPresenter access$getEnterNumberPresenter$p = this.this$0.enterNumberPresenter;
        EditText editText = (EditText) this.this$0._$_findCachedViewById(R.id.enter_number_phone_number);
        Intrinsics.checkExpressionValueIsNotNull(editText, "enter_number_phone_number");
        String obj = editText.getText().toString();
        if (obj != null) {
            access$getEnterNumberPresenter$p.requestOTP$app_release(StringsKt.trim((CharSequence) obj).toString());
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }
}
