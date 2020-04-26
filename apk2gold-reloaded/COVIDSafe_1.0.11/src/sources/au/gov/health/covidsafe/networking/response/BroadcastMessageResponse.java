package au.gov.health.covidsafe.networking.response;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;", "", "tempId", "", "expiryTime", "refreshTime", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getExpiryTime", "()Ljava/lang/String;", "getRefreshTime", "getTempId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: BroadcastMessageResponse.kt */
public final class BroadcastMessageResponse {
    private final String expiryTime;
    private final String refreshTime;
    private final String tempId;

    public static /* synthetic */ BroadcastMessageResponse copy$default(BroadcastMessageResponse broadcastMessageResponse, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = broadcastMessageResponse.tempId;
        }
        if ((i & 2) != 0) {
            str2 = broadcastMessageResponse.expiryTime;
        }
        if ((i & 4) != 0) {
            str3 = broadcastMessageResponse.refreshTime;
        }
        return broadcastMessageResponse.copy(str, str2, str3);
    }

    public final String component1() {
        return this.tempId;
    }

    public final String component2() {
        return this.expiryTime;
    }

    public final String component3() {
        return this.refreshTime;
    }

    public final BroadcastMessageResponse copy(String str, String str2, String str3) {
        return new BroadcastMessageResponse(str, str2, str3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.refreshTime, (java.lang.Object) r3.refreshTime) != false) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0029
            boolean r0 = r3 instanceof au.gov.health.covidsafe.networking.response.BroadcastMessageResponse
            if (r0 == 0) goto L_0x0027
            au.gov.health.covidsafe.networking.response.BroadcastMessageResponse r3 = (au.gov.health.covidsafe.networking.response.BroadcastMessageResponse) r3
            java.lang.String r0 = r2.tempId
            java.lang.String r1 = r3.tempId
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0027
            java.lang.String r0 = r2.expiryTime
            java.lang.String r1 = r3.expiryTime
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0027
            java.lang.String r0 = r2.refreshTime
            java.lang.String r3 = r3.refreshTime
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
        throw new UnsupportedOperationException("Method not decompiled: au.gov.health.covidsafe.networking.response.BroadcastMessageResponse.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.tempId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.expiryTime;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.refreshTime;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BroadcastMessageResponse(tempId=");
        sb.append(this.tempId);
        sb.append(", expiryTime=");
        sb.append(this.expiryTime);
        sb.append(", refreshTime=");
        sb.append(this.refreshTime);
        sb.append(")");
        return sb.toString();
    }

    public BroadcastMessageResponse(String str, String str2, String str3) {
        this.tempId = str;
        this.expiryTime = str2;
        this.refreshTime = str3;
    }

    public final String getExpiryTime() {
        return this.expiryTime;
    }

    public final String getRefreshTime() {
        return this.refreshTime;
    }

    public final String getTempId() {
        return this.tempId;
    }
}
