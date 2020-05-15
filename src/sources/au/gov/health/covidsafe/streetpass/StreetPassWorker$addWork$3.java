package au.gov.health.covidsafe.streetpass;

import au.gov.health.covidsafe.logging.CentralLog;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 16})
/* compiled from: StreetPassWorker.kt */
final class StreetPassWorker$addWork$3 implements Runnable {
    final /* synthetic */ Work $work;
    final /* synthetic */ StreetPassWorker this$0;

    StreetPassWorker$addWork$3(StreetPassWorker streetPassWorker, Work work) {
        this.this$0 = streetPassWorker;
        this.$work = work;
    }

    public final void run() {
        if (this.this$0.workQueue.contains(this.$work)) {
            CentralLog.Companion companion = CentralLog.Companion;
            String access$getTAG$p = this.this$0.TAG;
            companion.i(access$getTAG$p, "Work for " + this.$work.getDevice().getAddress() + " removed from queue? : " + this.this$0.workQueue.remove(this.$work));
        }
    }
}
