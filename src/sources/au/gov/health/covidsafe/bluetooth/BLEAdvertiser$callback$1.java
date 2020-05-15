package au.gov.health.covidsafe.bluetooth;

import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseSettings;
import au.gov.health.covidsafe.logging.CentralLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"au/gov/health/covidsafe/bluetooth/BLEAdvertiser$callback$1", "Landroid/bluetooth/le/AdvertiseCallback;", "onStartFailure", "", "errorCode", "", "onStartSuccess", "settingsInEffect", "Landroid/bluetooth/le/AdvertiseSettings;", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: BLEAdvertiser.kt */
public final class BLEAdvertiser$callback$1 extends AdvertiseCallback {
    final /* synthetic */ BLEAdvertiser this$0;

    BLEAdvertiser$callback$1(BLEAdvertiser bLEAdvertiser) {
        this.this$0 = bLEAdvertiser;
    }

    public void onStartSuccess(AdvertiseSettings advertiseSettings) {
        Intrinsics.checkParameterIsNotNull(advertiseSettings, "settingsInEffect");
        super.onStartSuccess(advertiseSettings);
        CentralLog.Companion.i(this.this$0.TAG, "Advertising onStartSuccess");
        CentralLog.Companion companion = CentralLog.Companion;
        String access$getTAG$p = this.this$0.TAG;
        String advertiseSettings2 = advertiseSettings.toString();
        Intrinsics.checkExpressionValueIsNotNull(advertiseSettings2, "settingsInEffect.toString()");
        companion.i(access$getTAG$p, advertiseSettings2);
        this.this$0.setAdvertising(true);
    }

    public void onStartFailure(int i) {
        String str;
        super.onStartFailure(i);
        if (i == 1) {
            this.this$0.setAdvertising(false);
            BLEAdvertiser bLEAdvertiser = this.this$0;
            bLEAdvertiser.charLength = bLEAdvertiser.charLength - 1;
            str = "ADVERTISE_FAILED_DATA_TOO_LARGE";
        } else if (i == 2) {
            this.this$0.setAdvertising(false);
            str = "ADVERTISE_FAILED_TOO_MANY_ADVERTISERS";
        } else if (i == 3) {
            this.this$0.setAdvertising(true);
            str = "ADVERTISE_FAILED_ALREADY_STARTED";
        } else if (i == 4) {
            this.this$0.setAdvertising(false);
            str = "ADVERTISE_FAILED_INTERNAL_ERROR";
        } else if (i != 5) {
            str = "UNDOCUMENTED";
        } else {
            this.this$0.setAdvertising(false);
            str = "ADVERTISE_FAILED_FEATURE_UNSUPPORTED";
        }
        CentralLog.Companion companion = CentralLog.Companion;
        String access$getTAG$p = this.this$0.TAG;
        companion.d(access$getTAG$p, "Advertising onStartFailure: " + i + " - " + str);
    }
}
