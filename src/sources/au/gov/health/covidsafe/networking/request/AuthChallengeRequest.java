package au.gov.health.covidsafe.networking.request;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthChallengeRequest)) {
            return false;
        }
        AuthChallengeRequest authChallengeRequest = (AuthChallengeRequest) obj;
        return Intrinsics.areEqual((Object) this.session, (Object) authChallengeRequest.session) && Intrinsics.areEqual((Object) this.code, (Object) authChallengeRequest.code);
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
        return "AuthChallengeRequest(session=" + this.session + ", code=" + this.code + ")";
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
