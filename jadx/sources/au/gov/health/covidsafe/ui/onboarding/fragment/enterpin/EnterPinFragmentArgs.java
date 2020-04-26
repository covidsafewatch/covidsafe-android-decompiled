package au.gov.health.covidsafe.ui.onboarding.fragment.enterpin;

import android.os.Bundle;
import androidx.navigation.NavArgs;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J+\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0006\u0010\u0015\u001a\u00020\u0016J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0019"}, d2 = {"Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs;", "Landroidx/navigation/NavArgs;", "session", "", "challengeName", "phoneNumber", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChallengeName", "()Ljava/lang/String;", "getPhoneNumber", "getSession", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toBundle", "Landroid/os/Bundle;", "toString", "Companion", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: EnterPinFragmentArgs.kt */
public final class EnterPinFragmentArgs implements NavArgs {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String challengeName;
    private final String phoneNumber;
    private final String session;

    public static /* synthetic */ EnterPinFragmentArgs copy$default(EnterPinFragmentArgs enterPinFragmentArgs, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = enterPinFragmentArgs.session;
        }
        if ((i & 2) != 0) {
            str2 = enterPinFragmentArgs.challengeName;
        }
        if ((i & 4) != 0) {
            str3 = enterPinFragmentArgs.phoneNumber;
        }
        return enterPinFragmentArgs.copy(str, str2, str3);
    }

    @JvmStatic
    public static final EnterPinFragmentArgs fromBundle(Bundle bundle) {
        return Companion.fromBundle(bundle);
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

    public final EnterPinFragmentArgs copy(String str, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(str3, "phoneNumber");
        return new EnterPinFragmentArgs(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EnterPinFragmentArgs)) {
            return false;
        }
        EnterPinFragmentArgs enterPinFragmentArgs = (EnterPinFragmentArgs) obj;
        return Intrinsics.areEqual((Object) this.session, (Object) enterPinFragmentArgs.session) && Intrinsics.areEqual((Object) this.challengeName, (Object) enterPinFragmentArgs.challengeName) && Intrinsics.areEqual((Object) this.phoneNumber, (Object) enterPinFragmentArgs.phoneNumber);
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
        return "EnterPinFragmentArgs(session=" + this.session + ", challengeName=" + this.challengeName + ", phoneNumber=" + this.phoneNumber + ")";
    }

    public EnterPinFragmentArgs(String str, String str2, String str3) {
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

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(EnterPinFragment.ENTER_PIN_SESSION, this.session);
        bundle.putString("challengeName", this.challengeName);
        bundle.putString("phoneNumber", this.phoneNumber);
        return bundle;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs$Companion;", "", "()V", "fromBundle", "Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs;", "bundle", "Landroid/os/Bundle;", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: EnterPinFragmentArgs.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final EnterPinFragmentArgs fromBundle(Bundle bundle) {
            Intrinsics.checkParameterIsNotNull(bundle, "bundle");
            bundle.setClassLoader(EnterPinFragmentArgs.class.getClassLoader());
            if (bundle.containsKey(EnterPinFragment.ENTER_PIN_SESSION)) {
                String string = bundle.getString(EnterPinFragment.ENTER_PIN_SESSION);
                if (bundle.containsKey("challengeName")) {
                    String string2 = bundle.getString("challengeName");
                    if (bundle.containsKey("phoneNumber")) {
                        String string3 = bundle.getString("phoneNumber");
                        if (string3 != null) {
                            return new EnterPinFragmentArgs(string, string2, string3);
                        }
                        throw new IllegalArgumentException("Argument \"phoneNumber\" is marked as non-null but was passed a null value.");
                    }
                    throw new IllegalArgumentException("Required argument \"phoneNumber\" is missing and does not have an android:defaultValue");
                }
                throw new IllegalArgumentException("Required argument \"challengeName\" is missing and does not have an android:defaultValue");
            }
            throw new IllegalArgumentException("Required argument \"session\" is missing and does not have an android:defaultValue");
        }
    }
}
