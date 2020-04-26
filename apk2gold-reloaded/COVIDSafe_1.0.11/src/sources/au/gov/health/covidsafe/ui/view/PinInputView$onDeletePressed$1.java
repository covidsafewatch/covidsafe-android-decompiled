package au.gov.health.covidsafe.ui.view;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "keyCode", "", "keyEvent", "Landroid/view/KeyEvent;", "onKey"}, k = 3, mv = {1, 1, 16})
/* compiled from: PinInputView.kt */
final class PinInputView$onDeletePressed$1 implements OnKeyListener {
    final /* synthetic */ EditText $prev;
    final /* synthetic */ EditText $this_onDeletePressed;
    final /* synthetic */ PinInputView this$0;

    PinInputView$onDeletePressed$1(PinInputView pinInputView, EditText editText, EditText editText2) {
        this.this$0 = pinInputView;
        this.$this_onDeletePressed = editText;
        this.$prev = editText2;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 67) {
            CharSequence text = this.$this_onDeletePressed.getText();
            if (text == null || text.length() == 0) {
                EditText editText = this.$prev;
                if (editText != null) {
                    editText.requestFocus();
                }
                Function0 onPinChanged = this.this$0.getOnPinChanged();
                if (onPinChanged == null) {
                    return true;
                }
                Unit unit = (Unit) onPinChanged.invoke();
                return true;
            }
        }
        return false;
    }
}
