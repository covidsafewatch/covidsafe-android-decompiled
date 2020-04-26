package au.gov.health.covidsafe;

import androidx.lifecycle.Observer;
import au.gov.health.covidsafe.streetpass.persistence.StreetPassRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "records", "", "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;", "kotlin.jvm.PlatformType", "onChanged"}, k = 3, mv = {1, 1, 16})
/* compiled from: PeekActivity.kt */
final class PeekActivity$newPeek$1<T> implements Observer<List<? extends StreetPassRecord>> {
    final /* synthetic */ RecordListAdapter $adapter;

    PeekActivity$newPeek$1(RecordListAdapter recordListAdapter) {
        this.$adapter = recordListAdapter;
    }

    public final void onChanged(List<StreetPassRecord> list) {
        RecordListAdapter recordListAdapter = this.$adapter;
        Intrinsics.checkExpressionValueIsNotNull(list, "records");
        recordListAdapter.setSourceData$app_release(list);
    }
}
