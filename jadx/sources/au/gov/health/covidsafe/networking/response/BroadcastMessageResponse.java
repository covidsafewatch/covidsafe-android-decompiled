package au.gov.health.covidsafe.networking.response;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BroadcastMessageResponse)) {
            return false;
        }
        BroadcastMessageResponse broadcastMessageResponse = (BroadcastMessageResponse) obj;
        return Intrinsics.areEqual((Object) this.tempId, (Object) broadcastMessageResponse.tempId) && Intrinsics.areEqual((Object) this.expiryTime, (Object) broadcastMessageResponse.expiryTime) && Intrinsics.areEqual((Object) this.refreshTime, (Object) broadcastMessageResponse.refreshTime);
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
        return "BroadcastMessageResponse(tempId=" + this.tempId + ", expiryTime=" + this.expiryTime + ", refreshTime=" + this.refreshTime + ")";
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
