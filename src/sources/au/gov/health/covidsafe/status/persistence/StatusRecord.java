package au.gov.health.covidsafe.status.persistence;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u0004R\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lau/gov/health/covidsafe/status/persistence/StatusRecord;", "", "msg", "", "(Ljava/lang/String;)V", "id", "", "getId", "()I", "setId", "(I)V", "getMsg", "()Ljava/lang/String;", "setMsg", "timestamp", "", "getTimestamp", "()J", "setTimestamp", "(J)V", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: StatusRecord.kt */
public final class StatusRecord {
    private int id;
    private String msg;
    private long timestamp = System.currentTimeMillis();

    public StatusRecord(String str) {
        Intrinsics.checkParameterIsNotNull(str, NotificationCompat.CATEGORY_MESSAGE);
        this.msg = str;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final void setMsg(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.msg = str;
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
}
