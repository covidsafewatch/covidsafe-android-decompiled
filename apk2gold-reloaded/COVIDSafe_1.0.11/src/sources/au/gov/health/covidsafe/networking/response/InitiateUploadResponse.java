package au.gov.health.covidsafe.networking.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;", "", "uploadLink", "", "expiresIn", "uploadPrefix", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getExpiresIn", "()Ljava/lang/String;", "getUploadLink", "getUploadPrefix", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: InitiateUploadResponse.kt */
public final class InitiateUploadResponse {
    @SerializedName("ExpiresIn")
    private final String expiresIn;
    @SerializedName("UploadLink")
    private final String uploadLink;
    @SerializedName("UploadPrefix")
    private final String uploadPrefix;

    public static /* synthetic */ InitiateUploadResponse copy$default(InitiateUploadResponse initiateUploadResponse, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = initiateUploadResponse.uploadLink;
        }
        if ((i & 2) != 0) {
            str2 = initiateUploadResponse.expiresIn;
        }
        if ((i & 4) != 0) {
            str3 = initiateUploadResponse.uploadPrefix;
        }
        return initiateUploadResponse.copy(str, str2, str3);
    }

    public final String component1() {
        return this.uploadLink;
    }

    public final String component2() {
        return this.expiresIn;
    }

    public final String component3() {
        return this.uploadPrefix;
    }

    public final InitiateUploadResponse copy(String str, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(str, "uploadLink");
        Intrinsics.checkParameterIsNotNull(str2, "expiresIn");
        Intrinsics.checkParameterIsNotNull(str3, "uploadPrefix");
        return new InitiateUploadResponse(str, str2, str3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.uploadPrefix, (java.lang.Object) r3.uploadPrefix) != false) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0029
            boolean r0 = r3 instanceof au.gov.health.covidsafe.networking.response.InitiateUploadResponse
            if (r0 == 0) goto L_0x0027
            au.gov.health.covidsafe.networking.response.InitiateUploadResponse r3 = (au.gov.health.covidsafe.networking.response.InitiateUploadResponse) r3
            java.lang.String r0 = r2.uploadLink
            java.lang.String r1 = r3.uploadLink
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0027
            java.lang.String r0 = r2.expiresIn
            java.lang.String r1 = r3.expiresIn
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0027
            java.lang.String r0 = r2.uploadPrefix
            java.lang.String r3 = r3.uploadPrefix
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
        throw new UnsupportedOperationException("Method not decompiled: au.gov.health.covidsafe.networking.response.InitiateUploadResponse.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.uploadLink;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.expiresIn;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.uploadPrefix;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InitiateUploadResponse(uploadLink=");
        sb.append(this.uploadLink);
        sb.append(", expiresIn=");
        sb.append(this.expiresIn);
        sb.append(", uploadPrefix=");
        sb.append(this.uploadPrefix);
        sb.append(")");
        return sb.toString();
    }

    public InitiateUploadResponse(String str, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(str, "uploadLink");
        Intrinsics.checkParameterIsNotNull(str2, "expiresIn");
        Intrinsics.checkParameterIsNotNull(str3, "uploadPrefix");
        this.uploadLink = str;
        this.expiresIn = str2;
        this.uploadPrefix = str3;
    }

    public final String getUploadLink() {
        return this.uploadLink;
    }

    public final String getExpiresIn() {
        return this.expiresIn;
    }

    public final String getUploadPrefix() {
        return this.uploadPrefix;
    }
}
