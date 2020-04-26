package au.gov.health.covidsafe.ui.home;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.navigation.fragment.FragmentKt;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
/* compiled from: HomeFragment.kt */
final class HomeFragment$onViewCreated$2 implements OnClickListener {
    final /* synthetic */ HomeFragment this$0;

    HomeFragment$onViewCreated$2(HomeFragment homeFragment) {
        this.this$0 = homeFragment;
    }

    public final void onClick(View view) {
        HomeFragment homeFragment = this.this$0;
        homeFragment.counter = homeFragment.counter + 1;
        if (this.this$0.counter >= 2) {
            this.this$0.counter = 0;
            FragmentKt.findNavController(this.this$0).navigate(HomeFragmentDirections.Companion.actionHomeFragmentToPeekActivity());
        }
    }
}
