package au.gov.health.covidsafe;

import android.content.Intent;
import android.view.View;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
/* compiled from: SelfIsolationDoneActivity.kt */
final class SelfIsolationDoneActivity$onResume$1 implements View.OnClickListener {
    final /* synthetic */ SelfIsolationDoneActivity this$0;

    SelfIsolationDoneActivity$onResume$1(SelfIsolationDoneActivity selfIsolationDoneActivity) {
        this.this$0 = selfIsolationDoneActivity;
    }

    public final void onClick(View view) {
        Preference.INSTANCE.setDataIsUploaded(this.this$0, false);
        Intent intent = new Intent(this.this$0, HomeActivity.class);
        intent.setFlags(268468224);
        this.this$0.startActivity(intent);
        this.this$0.finish();
    }
}
