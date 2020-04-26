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
    public static final Companion Companion = new Companion(null);

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

        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.phoneNumber, (java.lang.Object) r3.phoneNumber) != false) goto L_0x0029;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r3) {
            /*
                r2 = this;
                if (r2 == r3) goto L_0x0029
                boolean r0 = r3 instanceof au.gov.health.covidsafe.ui.onboarding.fragment.enternumber.EnterNumberFragmentDirections.ActionEnterNumberFragmentToOtpFragment
                if (r0 == 0) goto L_0x0027
                au.gov.health.covidsafe.ui.onboarding.fragment.enternumber.EnterNumberFragmentDirections$ActionEnterNumberFragmentToOtpFragment r3 = (au.gov.health.covidsafe.ui.onboarding.fragment.enternumber.EnterNumberFragmentDirections.ActionEnterNumberFragmentToOtpFragment) r3
                java.lang.String r0 = r2.session
                java.lang.String r1 = r3.session
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x0027
                java.lang.String r0 = r2.challengeName
                java.lang.String r1 = r3.challengeName
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x0027
                java.lang.String r0 = r2.phoneNumber
                java.lang.String r3 = r3.phoneNumber
                boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
                if (r3 == 0) goto L_0x0027
                goto L_0x0029
            L_0x0027:
                r3 = 0
                return r3
            L_0x0029:
                r3 = 1
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: au.gov.health.covidsafe.ui.onboarding.fragment.enternumber.EnterNumberFragmentDirections.ActionEnterNumberFragmentToOtpFragment.equals(java.lang.Object):boolean");
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
            StringBuilder sb = new StringBuilder();
            sb.append("ActionEnterNumberFragmentToOtpFragment(session=");
            sb.append(this.session);
            sb.append(", challengeName=");
            sb.append(this.challengeName);
            sb.append(", phoneNumber=");
            sb.append(this.phoneNumber);
            sb.append(")");
            return sb.toString();
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

    private EnterNumberFragmentDirections() {
    }
}
