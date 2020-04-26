package au.gov.health.covidsafe.ui.home;

import android.view.View;
import com.atlassian.mobilekit.module.feedback.FeedbackModule;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
/* compiled from: HelpFragment.kt */
final class HelpFragment$onViewCreated$1 implements View.OnClickListener {
    public static final HelpFragment$onViewCreated$1 INSTANCE = new HelpFragment$onViewCreated$1();

    HelpFragment$onViewCreated$1() {
    }

    public final void onClick(View view) {
        FeedbackModule.showFeedbackScreen();
    }
}
