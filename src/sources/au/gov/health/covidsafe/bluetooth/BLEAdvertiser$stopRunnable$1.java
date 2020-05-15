package au.gov.health.covidsafe.bluetooth;

import au.gov.health.covidsafe.logging.CentralLog;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 16})
/* compiled from: BLEAdvertiser.kt */
final class BLEAdvertiser$stopRunnable$1 implements Runnable {
    final /* synthetic */ BLEAdvertiser this$0;

    BLEAdvertiser$stopRunnable$1(BLEAdvertiser bLEAdvertiser) {
        this.this$0 = bLEAdvertiser;
    }

    public final void run() {
        CentralLog.Companion.i(this.this$0.TAG, "Advertising stopping as scheduled.");
        this.this$0.stopAdvertising();
    }
}
