package au.gov.health.covidsafe.ui.onboarding.fragment.enterpin;

import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import au.gov.health.covidsafe.R;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentDirections;", "", "()V", "Companion", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: EnterPinFragmentDirections.kt */
public final class EnterPinFragmentDirections {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentDirections$Companion;", "", "()V", "actionEnterPinFragmentToUploadStepFourFragment", "Landroidx/navigation/NavDirections;", "actionOtpFragmentToPermissionFragment", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: EnterPinFragmentDirections.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NavDirections actionOtpFragmentToPermissionFragment() {
            return new ActionOnlyNavDirections(R.id.action_otpFragment_to_permissionFragment);
        }

        public final NavDirections actionEnterPinFragmentToUploadStepFourFragment() {
            return new ActionOnlyNavDirections(R.id.action_enterPinFragment_to_uploadStepFourFragment);
        }
    }

    private EnterPinFragmentDirections() {
    }
}
