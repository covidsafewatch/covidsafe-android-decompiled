package au.gov.health.covidsafe.streetpass;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 16})
/* compiled from: Work.kt */
final class Work$timeoutRunnable$1 implements Runnable {
    final /* synthetic */ Work this$0;

    Work$timeoutRunnable$1(Work work) {
        this.this$0 = work;
    }

    public final void run() {
        this.this$0.onWorkTimeoutListener.onWorkTimeout(this.this$0);
    }
}
