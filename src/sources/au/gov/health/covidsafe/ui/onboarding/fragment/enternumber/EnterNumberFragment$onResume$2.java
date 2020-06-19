package au.gov.health.covidsafe.ui.onboarding.fragment.enternumber;

import android.view.KeyEvent;
import android.widget.TextView;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "event", "Landroid/view/KeyEvent;", "onEditorAction"}, k = 3, mv = {1, 1, 16})
/* compiled from: EnterNumberFragment.kt */
final class EnterNumberFragment$onResume$2 implements TextView.OnEditorActionListener {
    final /* synthetic */ EnterNumberFragment this$0;

    EnterNumberFragment$onResume$2(EnterNumberFragment enterNumberFragment) {
        this.this$0 = enterNumberFragment;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 3 && i != 6 && (keyEvent == null || keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 66)) {
            return false;
        }
        if (keyEvent != null && keyEvent.isShiftPressed()) {
            return false;
        }
        this.this$0.updateButtonState();
        return false;
    }
}
