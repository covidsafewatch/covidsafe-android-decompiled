package au.gov.health.covidsafe.services;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import au.gov.health.covidsafe.services.SensorMonitoringService.LocalBinder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"au/gov/health/covidsafe/services/BluetoothMonitoringService$connection$1", "Landroid/content/ServiceConnection;", "onServiceConnected", "", "className", "Landroid/content/ComponentName;", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "arg0", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: BluetoothMonitoringService.kt */
public final class BluetoothMonitoringService$connection$1 implements ServiceConnection {
    final /* synthetic */ BluetoothMonitoringService this$0;

    BluetoothMonitoringService$connection$1(BluetoothMonitoringService bluetoothMonitoringService) {
        this.this$0 = bluetoothMonitoringService;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Intrinsics.checkParameterIsNotNull(componentName, "className");
        Intrinsics.checkParameterIsNotNull(iBinder, NotificationCompat.CATEGORY_SERVICE);
        this.this$0.mService = ((LocalBinder) iBinder).getService();
        this.this$0.mBound = true;
    }

    public void onServiceDisconnected(ComponentName componentName) {
        Intrinsics.checkParameterIsNotNull(componentName, "arg0");
        this.this$0.mBound = false;
    }
}
