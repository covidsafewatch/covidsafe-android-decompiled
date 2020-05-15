package au.gov.health.covidsafe.streetpass;

import au.gov.health.covidsafe.logging.CentralLog;
import au.gov.health.covidsafe.streetpass.StreetPassWorker;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 16})
/* compiled from: StreetPassWorker.kt */
final class StreetPassWorker$DeviceProcessedReceiver$onReceive$1 implements Runnable {
    final /* synthetic */ BlacklistEntry $entry;
    final /* synthetic */ StreetPassWorker.DeviceProcessedReceiver this$0;

    StreetPassWorker$DeviceProcessedReceiver$onReceive$1(StreetPassWorker.DeviceProcessedReceiver deviceProcessedReceiver, BlacklistEntry blacklistEntry) {
        this.this$0 = deviceProcessedReceiver;
        this.$entry = blacklistEntry;
    }

    public final void run() {
        CentralLog.Companion companion = CentralLog.Companion;
        String access$getTAG$p = StreetPassWorker.this.TAG;
        companion.i(access$getTAG$p, "blacklist for " + this.$entry.getUniqueIdentifier() + " removed? : " + StreetPassWorker.this.blacklist.remove(this.$entry));
    }
}
