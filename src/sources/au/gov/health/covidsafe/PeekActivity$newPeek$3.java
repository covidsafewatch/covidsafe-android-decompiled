package au.gov.health.covidsafe;

import android.view.View;
import au.gov.health.covidsafe.RecordListAdapter;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
/* compiled from: PeekActivity.kt */
final class PeekActivity$newPeek$3 implements View.OnClickListener {
    final /* synthetic */ RecordListAdapter $adapter;
    final /* synthetic */ PeekActivity this$0;

    PeekActivity$newPeek$3(PeekActivity peekActivity, RecordListAdapter recordListAdapter) {
        this.this$0 = peekActivity;
        this.$adapter = recordListAdapter;
    }

    public final void onClick(View view) {
        if (PeekActivity.access$getViewModel$p(this.this$0).getAllRecords().getValue() != null) {
            this.$adapter.setMode(RecordListAdapter.MODE.COLLAPSE);
        }
    }
}
