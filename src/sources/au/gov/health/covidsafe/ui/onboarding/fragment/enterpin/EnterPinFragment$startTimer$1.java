package au.gov.health.covidsafe.ui.onboarding.fragment.enterpin;

import android.os.CountDownTimer;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import au.gov.health.covidsafe.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"au/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment$startTimer$1", "Landroid/os/CountDownTimer;", "onFinish", "", "onTick", "millisUntilFinished", "", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: EnterPinFragment.kt */
public final class EnterPinFragment$startTimer$1 extends CountDownTimer {
    final /* synthetic */ EnterPinFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EnterPinFragment$startTimer$1(EnterPinFragment enterPinFragment, long j, long j2) {
        super(j, j2);
        this.this$0 = enterPinFragment;
    }

    public void onTick(long j) {
        String str;
        double d = (double) j;
        int floor = (int) Math.floor((1.0d * d) / ((double) 60000));
        int floor2 = (int) Math.floor((d / 1000.0d) % ((double) 60));
        if (floor2 < 10) {
            StringBuilder sb = new StringBuilder();
            sb.append('0');
            sb.append(floor2);
            str = sb.toString();
        } else {
            str = String.valueOf(floor2);
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) this.this$0._$_findCachedViewById(R.id.enter_pin_timer_value);
        if (appCompatTextView != null) {
            appCompatTextView.setText(floor + ':' + str);
        }
    }

    public void onFinish() {
        AppCompatTextView appCompatTextView = (AppCompatTextView) this.this$0._$_findCachedViewById(R.id.enter_pin_timer_value);
        if (appCompatTextView != null) {
            appCompatTextView.setText("0:00");
        }
        TextView textView = (TextView) this.this$0._$_findCachedViewById(R.id.enter_pin_resend_pin);
        Intrinsics.checkExpressionValueIsNotNull(textView, "enter_pin_resend_pin");
        textView.setEnabled(true);
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            ((TextView) this.this$0._$_findCachedViewById(R.id.enter_pin_resend_pin)).setLinkTextColor(ContextCompat.getColor(activity, R.color.hyperlink_enabled));
        }
    }
}
