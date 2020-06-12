package au.gov.health.covidsafe.streetpass.view;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import au.gov.health.covidsafe.streetpass.persistence.MigrationCallBack;
import au.gov.health.covidsafe.streetpass.persistence.StreetPassRecord;
import au.gov.health.covidsafe.streetpass.persistence.StreetPassRecordDatabase;
import au.gov.health.covidsafe.streetpass.persistence.StreetPassRecordRepository;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R&\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lau/gov/health/covidsafe/streetpass/view/RecordViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "(Landroid/app/Application;)V", "allRecords", "Landroidx/lifecycle/LiveData;", "", "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;", "getAllRecords", "()Landroidx/lifecycle/LiveData;", "setAllRecords", "(Landroidx/lifecycle/LiveData;)V", "repo", "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordRepository;", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: RecordViewModel.kt */
public final class RecordViewModel extends AndroidViewModel {
    private LiveData<List<StreetPassRecord>> allRecords;
    private StreetPassRecordRepository repo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecordViewModel(Application application) {
        super(application);
        Intrinsics.checkParameterIsNotNull(application, "app");
        StreetPassRecordRepository streetPassRecordRepository = new StreetPassRecordRepository(StreetPassRecordDatabase.Companion.getDatabase$default(StreetPassRecordDatabase.Companion, application, (MigrationCallBack) null, 2, (Object) null).recordDao());
        this.repo = streetPassRecordRepository;
        this.allRecords = streetPassRecordRepository.getAllRecords();
    }

    public final LiveData<List<StreetPassRecord>> getAllRecords() {
        return this.allRecords;
    }

    public final void setAllRecords(LiveData<List<StreetPassRecord>> liveData) {
        Intrinsics.checkParameterIsNotNull(liveData, "<set-?>");
        this.allRecords = liveData;
    }
}
