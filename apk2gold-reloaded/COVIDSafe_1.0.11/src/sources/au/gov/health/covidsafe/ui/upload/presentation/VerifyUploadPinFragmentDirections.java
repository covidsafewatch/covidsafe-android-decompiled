package au.gov.health.covidsafe.ui.upload.presentation;

import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import au.gov.health.covidsafe.R;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragmentDirections;", "", "()V", "Companion", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: VerifyUploadPinFragmentDirections.kt */
public final class VerifyUploadPinFragmentDirections {
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragmentDirections$Companion;", "", "()V", "actionVerifyUploadPinFragmentToEnterNumberFragment", "Landroidx/navigation/NavDirections;", "actionVerifyUploadPinFragmentToUploadFinishedFragment", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: VerifyUploadPinFragmentDirections.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NavDirections actionVerifyUploadPinFragmentToUploadFinishedFragment() {
            return new ActionOnlyNavDirections(R.id.action_verifyUploadPinFragment_to_uploadFinishedFragment);
        }

        public final NavDirections actionVerifyUploadPinFragmentToEnterNumberFragment() {
            return new ActionOnlyNavDirections(R.id.action_verifyUploadPinFragment_to_enterNumberFragment);
        }
    }

    private VerifyUploadPinFragmentDirections() {
    }
}
