package au.gov.health.covidsafe.networking.response;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lau/gov/health/covidsafe/networking/response/AuthChallengeResponse;", "", "token", "", "uuid", "token_expiry", "pin", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPin", "()Ljava/lang/String;", "getToken", "getToken_expiry", "getUuid", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: AuthChallengeResponse.kt */
public final class AuthChallengeResponse {
    private final String pin;
    private final String token;
    private final String token_expiry;
    private final String uuid;

    public static /* synthetic */ AuthChallengeResponse copy$default(AuthChallengeResponse authChallengeResponse, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = authChallengeResponse.token;
        }
        if ((i & 2) != 0) {
            str2 = authChallengeResponse.uuid;
        }
        if ((i & 4) != 0) {
            str3 = authChallengeResponse.token_expiry;
        }
        if ((i & 8) != 0) {
            str4 = authChallengeResponse.pin;
        }
        return authChallengeResponse.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.token;
    }

    public final String component2() {
        return this.uuid;
    }

    public final String component3() {
        return this.token_expiry;
    }

    public final String component4() {
        return this.pin;
    }

    public final AuthChallengeResponse copy(String str, String str2, String str3, String str4) {
        Intrinsics.checkParameterIsNotNull(str, "token");
        Intrinsics.checkParameterIsNotNull(str2, "uuid");
        Intrinsics.checkParameterIsNotNull(str3, "token_expiry");
        Intrinsics.checkParameterIsNotNull(str4, "pin");
        return new AuthChallengeResponse(str, str2, str3, str4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.pin, (java.lang.Object) r3.pin) != false) goto L_0x0033;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0033
            boolean r0 = r3 instanceof au.gov.health.covidsafe.networking.response.AuthChallengeResponse
            if (r0 == 0) goto L_0x0031
            au.gov.health.covidsafe.networking.response.AuthChallengeResponse r3 = (au.gov.health.covidsafe.networking.response.AuthChallengeResponse) r3
            java.lang.String r0 = r2.token
            java.lang.String r1 = r3.token
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0031
            java.lang.String r0 = r2.uuid
            java.lang.String r1 = r3.uuid
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0031
            java.lang.String r0 = r2.token_expiry
            java.lang.String r1 = r3.token_expiry
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0031
            java.lang.String r0 = r2.pin
            java.lang.String r3 = r3.pin
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r3 = 0
            return r3
        L_0x0033:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: au.gov.health.covidsafe.networking.response.AuthChallengeResponse.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.token;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.uuid;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.token_expiry;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.pin;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AuthChallengeResponse(token=");
        sb.append(this.token);
        sb.append(", uuid=");
        sb.append(this.uuid);
        sb.append(", token_expiry=");
        sb.append(this.token_expiry);
        sb.append(", pin=");
        sb.append(this.pin);
        sb.append(")");
        return sb.toString();
    }

    public AuthChallengeResponse(String str, String str2, String str3, String str4) {
        Intrinsics.checkParameterIsNotNull(str, "token");
        Intrinsics.checkParameterIsNotNull(str2, "uuid");
        Intrinsics.checkParameterIsNotNull(str3, "token_expiry");
        Intrinsics.checkParameterIsNotNull(str4, "pin");
        this.token = str;
        this.uuid = str2;
        this.token_expiry = str3;
        this.pin = str4;
    }

    public final String getPin() {
        return this.pin;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getToken_expiry() {
        return this.token_expiry;
    }

    public final String getUuid() {
        return this.uuid;
    }
}
