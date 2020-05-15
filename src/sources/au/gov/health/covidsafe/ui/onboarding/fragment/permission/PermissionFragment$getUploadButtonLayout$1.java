package au.gov.health.covidsafe.ui.onboarding.fragment.permission;

import androidx.fragment.app.FragmentActivity;
import au.gov.health.covidsafe.Preference;
import au.gov.health.covidsafe.extensions.PermissionExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: PermissionFragment.kt */
final class PermissionFragment$getUploadButtonLayout$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PermissionFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PermissionFragment$getUploadButtonLayout$1(PermissionFragment permissionFragment) {
        super(0);
        this.this$0 = permissionFragment;
    }

    public final void invoke() {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            Preference preference = Preference.INSTANCE;
            Intrinsics.checkExpressionValueIsNotNull(activity, "it");
            preference.putIsOnBoarded(activity, true);
        }
        PermissionExtensionsKt.requestAllPermissions(this.this$0, new Function0<Unit>(this) {
            final /* synthetic */ PermissionFragment$getUploadButtonLayout$1 this$0;

            {
                this.this$0 = r1;
            }

            public final void invoke() {
                this.this$0.this$0.navigateToNextPage();
            }
        });
    }
}
