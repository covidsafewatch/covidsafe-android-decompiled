package au.gov.health.covidsafe.ui.onboarding.fragment.personal;

import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import au.gov.health.covidsafe.R;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragmentDirections;", "", "()V", "Companion", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: PersonalDetailsFragmentDirections.kt */
public final class PersonalDetailsFragmentDirections {
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragmentDirections$Companion;", "", "()V", "actionPersonalDetailsToEnterNumberFragment", "Landroidx/navigation/NavDirections;", "actionPersonalDetailsToUnderSixteenFragment", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: PersonalDetailsFragmentDirections.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NavDirections actionPersonalDetailsToEnterNumberFragment() {
            return new ActionOnlyNavDirections(R.id.action_personalDetails_to_enterNumberFragment);
        }

        public final NavDirections actionPersonalDetailsToUnderSixteenFragment() {
            return new ActionOnlyNavDirections(R.id.action_personalDetails_to_underSixteenFragment);
        }
    }

    private PersonalDetailsFragmentDirections() {
    }
}
