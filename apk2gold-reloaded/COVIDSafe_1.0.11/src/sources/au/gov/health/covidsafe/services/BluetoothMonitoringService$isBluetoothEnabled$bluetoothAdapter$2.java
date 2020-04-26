package au.gov.health.covidsafe.services;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/bluetooth/BluetoothAdapter;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: BluetoothMonitoringService.kt */
final class BluetoothMonitoringService$isBluetoothEnabled$bluetoothAdapter$2 extends Lambda implements Function0<BluetoothAdapter> {
    final /* synthetic */ BluetoothMonitoringService this$0;

    BluetoothMonitoringService$isBluetoothEnabled$bluetoothAdapter$2(BluetoothMonitoringService bluetoothMonitoringService) {
        this.this$0 = bluetoothMonitoringService;
        super(0);
    }

    public final BluetoothAdapter invoke() {
        Object systemService = this.this$0.getSystemService("bluetooth");
        if (systemService != null) {
            return ((BluetoothManager) systemService).getAdapter();
        }
        throw new TypeCastException("null cannot be cast to non-null type android.bluetooth.BluetoothManager");
    }
}
