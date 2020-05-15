package au.gov.health.covidsafe.ui.onboarding.fragment.permission;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 16})
/* compiled from: PermissionFragment.kt */
final class PermissionFragment$onActivityResult$3 implements Runnable {
    final /* synthetic */ PermissionFragment this$0;

    PermissionFragment$onActivityResult$3(PermissionFragment permissionFragment) {
        this.this$0 = permissionFragment;
    }

    public final void run() {
        this.this$0.navigateToNextPage();
    }
}
