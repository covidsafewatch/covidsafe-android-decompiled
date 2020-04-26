package au.gov.health.covidsafe.networking.response;

import au.gov.health.covidsafe.ui.onboarding.fragment.enterpin.EnterPinFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lau/gov/health/covidsafe/networking/response/OTPChallengeResponse;", "", "session", "", "challengeName", "(Ljava/lang/String;Ljava/lang/String;)V", "getChallengeName", "()Ljava/lang/String;", "getSession", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: OTPChallengeResponse.kt */
public final class OTPChallengeResponse {
    private final String challengeName;
    private final String session;

    public static /* synthetic */ OTPChallengeResponse copy$default(OTPChallengeResponse oTPChallengeResponse, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = oTPChallengeResponse.session;
        }
        if ((i & 2) != 0) {
            str2 = oTPChallengeResponse.challengeName;
        }
        return oTPChallengeResponse.copy(str, str2);
    }

    public final String component1() {
        return this.session;
    }

    public final String component2() {
        return this.challengeName;
    }

    public final OTPChallengeResponse copy(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, EnterPinFragment.ENTER_PIN_SESSION);
        Intrinsics.checkParameterIsNotNull(str2, "challengeName");
        return new OTPChallengeResponse(str, str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.challengeName, (java.lang.Object) r3.challengeName) != false) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x001f
            boolean r0 = r3 instanceof au.gov.health.covidsafe.networking.response.OTPChallengeResponse
            if (r0 == 0) goto L_0x001d
            au.gov.health.covidsafe.networking.response.OTPChallengeResponse r3 = (au.gov.health.covidsafe.networking.response.OTPChallengeResponse) r3
            java.lang.String r0 = r2.session
            java.lang.String r1 = r3.session
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x001d
            java.lang.String r0 = r2.challengeName
            java.lang.String r3 = r3.challengeName
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r3 = 0
            return r3
        L_0x001f:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: au.gov.health.covidsafe.networking.response.OTPChallengeResponse.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.session;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.challengeName;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OTPChallengeResponse(session=");
        sb.append(this.session);
        sb.append(", challengeName=");
        sb.append(this.challengeName);
        sb.append(")");
        return sb.toString();
    }

    public OTPChallengeResponse(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, EnterPinFragment.ENTER_PIN_SESSION);
        Intrinsics.checkParameterIsNotNull(str2, "challengeName");
        this.session = str;
        this.challengeName = str2;
    }

    public final String getChallengeName() {
        return this.challengeName;
    }

    public final String getSession() {
        return this.session;
    }
}
