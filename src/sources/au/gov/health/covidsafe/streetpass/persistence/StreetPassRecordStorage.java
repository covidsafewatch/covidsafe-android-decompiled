package au.gov.health.covidsafe.streetpass.persistence;

import android.content.Context;
import au.gov.health.covidsafe.streetpass.persistence.StreetPassRecordDatabase;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0011\u0010\u0012\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordStorage;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "recordDao", "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDao;", "deleteDataOlderThan", "", "timeInMs", "", "getAllRecords", "", "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;", "nukeDb", "", "nukeDbAsync", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveRecord", "record", "(Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: StreetPassRecordStorage.kt */
public final class StreetPassRecordStorage {
    private final Context context;
    private final StreetPassRecordDao recordDao = StreetPassRecordDatabase.Companion.getDatabase$default(StreetPassRecordDatabase.Companion, this.context, (MigrationCallBack) null, 2, (Object) null).recordDao();

    public StreetPassRecordStorage(Context context2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        this.context = context2;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Object saveRecord(StreetPassRecord streetPassRecord, Continuation<? super Unit> continuation) {
        Object insert = this.recordDao.insert(streetPassRecord, continuation);
        if (insert == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return insert;
        }
        return Unit.INSTANCE;
    }

    public final int deleteDataOlderThan(long j) {
        return this.recordDao.deleteDataOlder(j);
    }

    public final void nukeDb() {
        this.recordDao.nukeDb();
    }

    public final Object nukeDbAsync(Continuation<? super Unit> continuation) {
        this.recordDao.nukeDb();
        return Unit.INSTANCE;
    }

    public final List<StreetPassRecord> getAllRecords() {
        return this.recordDao.getCurrentRecords();
    }
}
