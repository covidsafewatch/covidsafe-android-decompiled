package au.gov.health.covidsafe;

import au.gov.health.covidsafe.streetpass.persistence.StreetPassRecord;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: PlotActivity.kt */
final class PlotActivity$onCreate$zipResult$2$individualData$1$x1$1 extends Lambda implements Function1<StreetPassRecord, String> {
    final /* synthetic */ PlotActivity$onCreate$zipResult$2$individualData$1 this$0;

    PlotActivity$onCreate$zipResult$2$individualData$1$x1$1(PlotActivity$onCreate$zipResult$2$individualData$1 plotActivity$onCreate$zipResult$2$individualData$1) {
        this.this$0 = plotActivity$onCreate$zipResult$2$individualData$1;
        super(1);
    }

    public final String invoke(StreetPassRecord streetPassRecord) {
        Intrinsics.checkParameterIsNotNull(streetPassRecord, "it");
        String format = this.this$0.$dateFormatter.format(new Date(streetPassRecord.getTimestamp()));
        Intrinsics.checkExpressionValueIsNotNull(format, "dateFormatter.format(Date(it.timestamp))");
        return format;
    }
}
