package au.gov.health.covidsafe.ui.onboarding.fragment.enternumber;

import android.os.Bundle;
import androidx.navigation.NavDirections;
import au.gov.health.covidsafe.R;
import au.gov.health.covidsafe.ui.onboarding.fragment.enterpin.EnterPinFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragmentDirections;", "", "()V", "ActionEnterNumberFragmentToOtpFragment", "Companion", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: EnterNumberFragmentDirections.kt */
public final class EnterNumberFragmentDirections {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J+\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\t\u0010\u0017\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0019"}, d2 = {"Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragmentDirections$ActionEnterNumberFragmentToOtpFragment;", "Landroidx/navigation/NavDirections;", "session", "", "challengeName", "phoneNumber", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChallengeName", "()Ljava/lang/String;", "getPhoneNumber", "getSession", "component1", "component2", "component3", "copy", "equals", "", "other", "", "getActionId", "", "getArguments", "Landroid/os/Bundle;", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: EnterNumberFragmentDirections.kt */
    private static final class ActionEnterNumberFragmentToOtpFragment implements NavDirections {
        private final String challengeName;
        private final String phoneNumber;
        private final String session;

        public static /* synthetic */ ActionEnterNumberFragmentToOtpFragment copy$default(ActionEnterNumberFragmentToOtpFragment actionEnterNumberFragmentToOtpFragment, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = actionEnterNumberFragmentToOtpFragment.session;
            }
            if ((i & 2) != 0) {
                str2 = actionEnterNumberFragmentToOtpFragment.challengeName;
            }
            if ((i & 4) != 0) {
                str3 = actionEnterNumberFragmentToOtpFragment.phoneNumber;
            }
            return actionEnterNumberFragmentToOtpFragment.copy(str, str2, str3);
        }

        public final String component1() {
            return this.session;
        }

        public final String component2() {
            return this.challengeName;
        }

        public final String component3() {
            return this.phoneNumber;
        }

        public final ActionEnterNumberFragmentToOtpFragment copy(String str, String str2, String str3) {
            Intrinsics.checkParameterIsNotNull(str3, "phoneNumber");
            return new ActionEnterNumberFragmentToOtpFragment(str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ActionEnterNumberFragmentToOtpFragment)) {
                return false;
            }
            ActionEnterNumberFragmentToOtpFragment actionEnterNumberFragmentToOtpFragment = (ActionEnterNumberFragmentToOtpFragment) obj;
            return Intrinsics.areEqual((Object) this.session, (Object) actionEnterNumberFragmentToOtpFragment.session) && Intrinsics.areEqual((Object) this.challengeName, (Object) actionEnterNumberFragmentToOtpFragment.challengeName) && Intrinsics.areEqual((Object) this.phoneNumber, (Object) actionEnterNumberFragmentToOtpFragment.phoneNumber);
        }

        public int getActionId() {
            return R.id.action_enterNumberFragment_to_otpFragment;
        }

        public int hashCode() {
            String str = this.session;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.challengeName;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.phoneNumber;
            if (str3 != null) {
                i = str3.hashCode();
            }
            return hashCode2 + i;
        }

        public String toString() {
            return "ActionEnterNumberFragmentToOtpFragment(session=" + this.session + ", challengeName=" + this.challengeName + ", phoneNumber=" + this.phoneNumber + ")";
        }

        public ActionEnterNumberFragmentToOtpFragment(String str, String str2, String str3) {
            Intrinsics.checkParameterIsNotNull(str3, "phoneNumber");
            this.session = str;
            this.challengeName = str2;
            this.phoneNumber = str3;
        }

        public final String getSession() {
            return this.session;
        }

        public final String getChallengeName() {
            return this.challengeName;
        }

        public final String getPhoneNumber() {
            return this.phoneNumber;
        }

        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            bundle.putString(EnterPinFragment.ENTER_PIN_SESSION, this.session);
            bundle.putString("challengeName", this.challengeName);
            bundle.putString("phoneNumber", this.phoneNumber);
            return bundle;
        }
    }

    private EnterNumberFragmentDirections() {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0006¨\u0006\t"}, d2 = {"Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragmentDirections$Companion;", "", "()V", "actionEnterNumberFragmentToOtpFragment", "Landroidx/navigation/NavDirections;", "session", "", "challengeName", "phoneNumber", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: EnterNumberFragmentDirections.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NavDirections actionEnterNumberFragmentToOtpFragment(String str, String str2, String str3) {
            Intrinsics.checkParameterIsNotNull(str3, "phoneNumber");
            return new ActionEnterNumberFragmentToOtpFragment(str, str2, str3);
        }
    }
}
