package au.gov.health.covidsafe;

import au.gov.health.covidsafe.streetpass.persistence.StreetPassRecord;
import au.gov.health.covidsafe.streetpass.persistence.StreetPassRecordStorage;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012 \u0010\u0002\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0005 \u0006*\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00040\u00040\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "it", "Lio/reactivex/ObservableEmitter;", "", "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;", "kotlin.jvm.PlatformType", "subscribe"}, k = 3, mv = {1, 1, 16})
/* compiled from: PlotActivity.kt */
final class PlotActivity$onCreate$observableStreetRecords$1<T> implements ObservableOnSubscribe<T> {
    final /* synthetic */ PlotActivity this$0;

    PlotActivity$onCreate$observableStreetRecords$1(PlotActivity plotActivity) {
        this.this$0 = plotActivity;
    }

    public final void subscribe(ObservableEmitter<List<StreetPassRecord>> observableEmitter) {
        Intrinsics.checkParameterIsNotNull(observableEmitter, "it");
        observableEmitter.onNext(new StreetPassRecordStorage(this.this$0).getAllRecords());
    }
}
