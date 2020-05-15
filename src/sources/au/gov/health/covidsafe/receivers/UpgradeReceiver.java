package au.gov.health.covidsafe.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import au.gov.health.covidsafe.Utils;
import au.gov.health.covidsafe.logging.CentralLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lau/gov/health/covidsafe/receivers/UpgradeReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: UpgradeReceiver.kt */
public final class UpgradeReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            try {
                Intrinsics.throwNpe();
            } catch (Exception e) {
                CentralLog.Companion companion = CentralLog.Companion;
                companion.e("UpgradeReceiver", "Unable to handle upgrade: " + e.getLocalizedMessage());
                return;
            }
        }
        if (!(!Intrinsics.areEqual((Object) "android.intent.action.MY_PACKAGE_REPLACED", (Object) intent.getAction())) && context != null) {
            CentralLog.Companion.i("UpgradeReceiver", "Starting service from upgrade receiver");
            Utils.INSTANCE.startBluetoothMonitoringService(context);
        }
    }
}
