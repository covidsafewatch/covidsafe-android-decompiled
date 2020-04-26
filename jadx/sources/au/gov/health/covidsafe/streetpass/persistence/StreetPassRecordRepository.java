package au.gov.health.covidsafe.streetpass.persistence;

import androidx.lifecycle.LiveData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordRepository;", "", "recordDao", "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDao;", "(Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDao;)V", "allRecords", "Landroidx/lifecycle/LiveData;", "", "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;", "getAllRecords", "()Landroidx/lifecycle/LiveData;", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: StreetPassRecordRepository.kt */
public final class StreetPassRecordRepository {
    private final LiveData<List<StreetPassRecord>> allRecords;

    public StreetPassRecordRepository(StreetPassRecordDao streetPassRecordDao) {
        Intrinsics.checkParameterIsNotNull(streetPassRecordDao, "recordDao");
        this.allRecords = streetPassRecordDao.getRecords();
    }

    public final LiveData<List<StreetPassRecord>> getAllRecords() {
        return this.allRecords;
    }
}
