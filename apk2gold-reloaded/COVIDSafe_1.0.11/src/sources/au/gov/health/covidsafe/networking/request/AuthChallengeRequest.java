package au.gov.health.covidsafe.networking.request;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lau/gov/health/covidsafe/networking/request/AuthChallengeRequest;", "", "session", "", "code", "(Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getSession", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: AuthChallengeRequest.kt */
public final class AuthChallengeRequest {
    private final String code;
    private final String session;

    public static /* synthetic */ AuthChallengeRequest copy$default(AuthChallengeRequest authChallengeRequest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = authChallengeRequest.session;
        }
        if ((i & 2) != 0) {
            str2 = authChallengeRequest.code;
        }
        return authChallengeRequest.copy(str, str2);
    }

    public final String component1() {
        return this.session;
    }

    public final String component2() {
        return this.code;
    }

    public final AuthChallengeRequest copy(String str, String str2) {
        return new AuthChallengeRequest(str, str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.code, (java.lang.Object) r3.code) != false) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x001f
            boolean r0 = r3 instanceof au.gov.health.covidsafe.networking.request.AuthChallengeRequest
            if (r0 == 0) goto L_0x001d
            au.gov.health.covidsafe.networking.request.AuthChallengeRequest r3 = (au.gov.health.covidsafe.networking.request.AuthChallengeRequest) r3
            java.lang.String r0 = r2.session
            java.lang.String r1 = r3.session
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x001d
            java.lang.String r0 = r2.code
            java.lang.String r3 = r3.code
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
        throw new UnsupportedOperationException("Method not decompiled: au.gov.health.covidsafe.networking.request.AuthChallengeRequest.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.session;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.code;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AuthChallengeRequest(session=");
        sb.append(this.session);
        sb.append(", code=");
        sb.append(this.code);
        sb.append(")");
        return sb.toString();
    }

    public AuthChallengeRequest(String str, String str2) {
        this.session = str;
        this.code = str2;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getSession() {
        return this.session;
    }
}
