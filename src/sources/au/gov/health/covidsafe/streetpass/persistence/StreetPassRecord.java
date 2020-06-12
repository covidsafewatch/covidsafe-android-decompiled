package au.gov.health.covidsafe.streetpass.persistence;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\b\u0010\u001c\u001a\u00020\u0005H\u0016R\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000f\"\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000b\"\u0004\b\u001b\u0010\r¨\u0006\u001d"}, d2 = {"Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;", "", "v", "", "org", "", "localBlob", "remoteBlob", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "id", "getId", "()I", "setId", "(I)V", "getLocalBlob", "()Ljava/lang/String;", "getOrg", "setOrg", "(Ljava/lang/String;)V", "getRemoteBlob", "timestamp", "", "getTimestamp", "()J", "setTimestamp", "(J)V", "getV", "setV", "toString", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: StreetPassRecord.kt */
public final class StreetPassRecord {
    private int id;
    private final String localBlob;

    /* renamed from: org  reason: collision with root package name */
    private String f8org;
    private final String remoteBlob;
    private long timestamp = System.currentTimeMillis();
    private int v;

    public StreetPassRecord(int i, String str, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(str, "org");
        Intrinsics.checkParameterIsNotNull(str2, "localBlob");
        Intrinsics.checkParameterIsNotNull(str3, "remoteBlob");
        this.v = i;
        this.f8org = str;
        this.localBlob = str2;
        this.remoteBlob = str3;
    }

    public final int getV() {
        return this.v;
    }

    public final void setV(int i) {
        this.v = i;
    }

    public final String getOrg() {
        return this.f8org;
    }

    public final void setOrg(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.f8org = str;
    }

    public final String getLocalBlob() {
        return this.localBlob;
    }

    public final String getRemoteBlob() {
        return this.remoteBlob;
    }

    public final int getId() {
        return this.id;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final void setTimestamp(long j) {
        this.timestamp = j;
    }

    public String toString() {
        return "StreetPassRecord(v=" + this.v + ", , org='" + this.f8org + "', id=" + this.id + ", timestamp=" + this.timestamp + ",localBlob=" + this.localBlob + ", remoteBlob=" + this.remoteBlob + ')';
    }
}
