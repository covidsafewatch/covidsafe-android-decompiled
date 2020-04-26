package au.gov.health.covidsafe.status.persistence;

import android.content.Context;
import au.gov.health.covidsafe.streetpass.persistence.StreetPassRecordDatabase;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lau/gov/health/covidsafe/status/persistence/StatusRecordStorage;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "statusDao", "Lau/gov/health/covidsafe/status/persistence/StatusRecordDao;", "deleteDataOlderThan", "", "timeInMs", "", "getAllRecords", "", "Lau/gov/health/covidsafe/status/persistence/StatusRecord;", "saveRecord", "", "record", "(Lau/gov/health/covidsafe/status/persistence/StatusRecord;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: StatusRecordStorage.kt */
public final class StatusRecordStorage {
    private final Context context;
    private final StatusRecordDao statusDao = StreetPassRecordDatabase.Companion.getDatabase(this.context).statusDao();

    public StatusRecordStorage(Context context2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        this.context = context2;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Object saveRecord(StatusRecord statusRecord, Continuation<? super Unit> continuation) {
        Object insert = this.statusDao.insert(statusRecord, continuation);
        if (insert == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return insert;
        }
        return Unit.INSTANCE;
    }

    public final List<StatusRecord> getAllRecords() {
        return this.statusDao.getCurrentRecords();
    }

    public final int deleteDataOlderThan(long j) {
        return this.statusDao.deleteDataOlder(j);
    }
}
