package au.gov.health.covidsafe.ui.view;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f¸\u0006\u0010"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "text", "", "start", "", "count", "after", "onTextChanged", "before", "core-ktx_release", "androidx/core/widget/TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$1"}, k = 1, mv = {1, 1, 16})
/* compiled from: TextView.kt */
public final class PinInputView$onDigitChanged$$inlined$doAfterTextChanged$1 implements TextWatcher {
    final /* synthetic */ EditText $next$inlined;
    final /* synthetic */ PinInputView this$0;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public PinInputView$onDigitChanged$$inlined$doAfterTextChanged$1(PinInputView pinInputView, EditText editText) {
        this.this$0 = pinInputView;
        this.$next$inlined = editText;
    }

    public void afterTextChanged(Editable editable) {
        Function0<Unit> onPinChanged;
        boolean z = true;
        if (editable == null || editable.length() != 1) {
            CharSequence charSequence = editable;
            if (charSequence != null && !StringsKt.isBlank(charSequence)) {
                z = false;
            }
            if (z && (onPinChanged = this.this$0.getOnPinChanged()) != null) {
                Unit invoke = onPinChanged.invoke();
                return;
            }
            return;
        }
        EditText editText = this.$next$inlined;
        if (editText != null) {
            editText.requestFocus();
        }
        Function0<Unit> onPinChanged2 = this.this$0.getOnPinChanged();
        if (onPinChanged2 != null) {
            Unit invoke2 = onPinChanged2.invoke();
        }
    }
}
