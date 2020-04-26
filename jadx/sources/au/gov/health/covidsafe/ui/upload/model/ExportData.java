package au.gov.health.covidsafe.ui.upload.model;

import au.gov.health.covidsafe.streetpass.persistence.StreetPassRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"Lau/gov/health/covidsafe/ui/upload/model/ExportData;", "", "records", "", "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;", "(Ljava/util/List;)V", "getRecords", "()Ljava/util/List;", "setRecords", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: ExportData.kt */
public final class ExportData {
    private List<StreetPassRecord> records;

    public ExportData(List<StreetPassRecord> list) {
        Intrinsics.checkParameterIsNotNull(list, "records");
        this.records = list;
    }

    public final List<StreetPassRecord> getRecords() {
        return this.records;
    }

    public final void setRecords(List<StreetPassRecord> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.records = list;
    }
}
