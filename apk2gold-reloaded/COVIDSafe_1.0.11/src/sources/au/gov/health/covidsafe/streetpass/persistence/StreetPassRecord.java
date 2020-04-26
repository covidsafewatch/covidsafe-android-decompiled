package au.gov.health.covidsafe.streetpass.persistence;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\t\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\b\u0010%\u001a\u00020\u0005H\u0016R\u001e\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0012\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0016R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000eR\u001e\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u000e\"\u0004\b$\u0010\u0010¨\u0006&"}, d2 = {"Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;", "", "v", "", "msg", "", "org", "modelP", "modelC", "rssi", "txPower", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;)V", "id", "getId", "()I", "setId", "(I)V", "getModelC", "()Ljava/lang/String;", "getModelP", "getMsg", "setMsg", "(Ljava/lang/String;)V", "getOrg", "setOrg", "getRssi", "timestamp", "", "getTimestamp", "()J", "setTimestamp", "(J)V", "getTxPower", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getV", "setV", "toString", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: StreetPassRecord.kt */
public final class StreetPassRecord {
    private int id;
    private final String modelC;
    private final String modelP;
    private String msg;

    /* renamed from: org reason: collision with root package name */
    private String f8org;
    private final int rssi;
    private long timestamp = System.currentTimeMillis();
    private final Integer txPower;
    private int v;

    public StreetPassRecord(int i, String str, String str2, String str3, String str4, int i2, Integer num) {
        Intrinsics.checkParameterIsNotNull(str, NotificationCompat.CATEGORY_MESSAGE);
        Intrinsics.checkParameterIsNotNull(str2, "org");
        Intrinsics.checkParameterIsNotNull(str3, "modelP");
        Intrinsics.checkParameterIsNotNull(str4, "modelC");
        this.v = i;
        this.msg = str;
        this.f8org = str2;
        this.modelP = str3;
        this.modelC = str4;
        this.rssi = i2;
        this.txPower = num;
    }

    public final int getV() {
        return this.v;
    }

    public final void setV(int i) {
        this.v = i;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final void setMsg(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.msg = str;
    }

    public final String getOrg() {
        return this.f8org;
    }

    public final void setOrg(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.f8org = str;
    }

    public final String getModelP() {
        return this.modelP;
    }

    public final String getModelC() {
        return this.modelC;
    }

    public final int getRssi() {
        return this.rssi;
    }

    public final Integer getTxPower() {
        return this.txPower;
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
        StringBuilder sb = new StringBuilder();
        sb.append("StreetPassRecord(v=");
        sb.append(this.v);
        sb.append(", msg='");
        sb.append(this.msg);
        sb.append("', org='");
        sb.append(this.f8org);
        sb.append("', modelP='");
        sb.append(this.modelP);
        sb.append("', modelC='");
        sb.append(this.modelC);
        sb.append("', rssi=");
        sb.append(this.rssi);
        sb.append(", txPower=");
        sb.append(this.txPower);
        sb.append(", id=");
        sb.append(this.id);
        sb.append(", timestamp=");
        sb.append(this.timestamp);
        sb.append(')');
        return sb.toString();
    }
}
