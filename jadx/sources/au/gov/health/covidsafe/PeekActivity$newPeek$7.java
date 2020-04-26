package au.gov.health.covidsafe;

import android.content.Intent;
import android.view.View;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
/* compiled from: PeekActivity.kt */
final class PeekActivity$newPeek$7 implements View.OnClickListener {
    final /* synthetic */ PeekActivity this$0;

    PeekActivity$newPeek$7(PeekActivity peekActivity) {
        this.this$0 = peekActivity;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.this$0, PlotActivity.class);
        intent.putExtra("time_period", this.this$0.nextTimePeriod());
        this.this$0.startActivity(intent);
    }
}
