package au.gov.health.covidsafe;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import au.gov.health.covidsafe.bluetooth.gatt.GATTKt;
import au.gov.health.covidsafe.logging.CentralLog;
import au.gov.health.covidsafe.scheduler.Scheduler;
import au.gov.health.covidsafe.services.BluetoothMonitoringService;
import au.gov.health.covidsafe.status.Status;
import au.gov.health.covidsafe.streetpass.ConnectablePeripheral;
import au.gov.health.covidsafe.streetpass.ConnectionRecord;
import au.gov.health.covidsafe.streetpass.StreetPassKt;
import java.io.File;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0004J\u001e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014J\u0016\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017J\u0018\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u000e\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010 \u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u0004J\u000e\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020%J\u0011\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040'¢\u0006\u0002\u0010(J\u0006\u0010)\u001a\u00020\u0006J\u000e\u0010*\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010+\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010,\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010-\u001a\u00020%J\u0016\u0010.\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010/\u001a\u00020%J\u0016\u00100\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010/\u001a\u00020%J\u000e\u00101\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u00102\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u00103\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u00104\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lau/gov/health/covidsafe/Utils;", "", "()V", "TAG", "", "bmValid", "", "context", "Landroid/content/Context;", "broadcastDeviceDisconnected", "", "device", "Landroid/bluetooth/BluetoothDevice;", "broadcastDeviceProcessed", "deviceAddress", "broadcastDeviceScanned", "connectableBleDevice", "Lau/gov/health/covidsafe/streetpass/ConnectablePeripheral;", "broadcastStatusReceived", "statusRecord", "Lau/gov/health/covidsafe/status/Status;", "broadcastStreetPassReceived", "streetpass", "Lau/gov/health/covidsafe/streetpass/ConnectionRecord;", "canHandleIntent", "batteryExemptionIntent", "Landroid/content/Intent;", "packageManager", "Landroid/content/pm/PackageManager;", "cancelBMUpdateCheck", "cancelNextAdvertise", "cancelNextHealthCheck", "cancelNextScan", "getBatteryOptimizerExemptionIntent", "packageName", "getDate", "milliSeconds", "", "getRequiredPermissions", "", "()[Ljava/lang/String;", "isBluetoothAvailable", "needToUpdate", "retrieveBroadcastMessage", "scheduleBMUpdateCheck", "bmCheckInterval", "scheduleNextHealthCheck", "timeInMillis", "scheduleStartMonitoringService", "startBluetoothMonitoringService", "stopBluetoothMonitoringService", "storeBroadcastMessage", "packet", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: Utils.kt */
public final class Utils {
    public static final Utils INSTANCE = new Utils();
    private static final String TAG = "Utils";

    private Utils() {
    }

    public final String[] getRequiredPermissions() {
        return new String[]{"android.permission.ACCESS_FINE_LOCATION"};
    }

    public final Intent getBatteryOptimizerExemptionIntent(String str) {
        Intrinsics.checkParameterIsNotNull(str, "packageName");
        Intent intent = new Intent();
        intent.setAction("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
        intent.setData(Uri.parse("package:" + str));
        return intent;
    }

    public final boolean canHandleIntent(Intent intent, PackageManager packageManager) {
        Intrinsics.checkParameterIsNotNull(intent, "batteryExemptionIntent");
        return (packageManager == null || intent.resolveActivity(packageManager) == null) ? false : true;
    }

    public final String getDate(long j) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "calendar");
        instance.setTimeInMillis(j);
        String format = simpleDateFormat.format(instance.getTime());
        Intrinsics.checkExpressionValueIsNotNull(format, "formatter.format(calendar.time)");
        return format;
    }

    public final void startBluetoothMonitoringService(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intent intent = new Intent(context, BluetoothMonitoringService.class);
        intent.putExtra(BluetoothMonitoringService.COMMAND_KEY, BluetoothMonitoringService.Command.ACTION_START.getIndex());
        context.startService(intent);
    }

    public final void scheduleStartMonitoringService(Context context, long j) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intent intent = new Intent(context, BluetoothMonitoringService.class);
        intent.putExtra(BluetoothMonitoringService.COMMAND_KEY, BluetoothMonitoringService.Command.ACTION_START.getIndex());
        Scheduler.INSTANCE.scheduleServiceIntent(6, context, intent, j);
    }

    public final void scheduleBMUpdateCheck(Context context, long j) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        cancelBMUpdateCheck(context);
        Intent intent = new Intent(context, BluetoothMonitoringService.class);
        intent.putExtra(BluetoothMonitoringService.COMMAND_KEY, BluetoothMonitoringService.Command.ACTION_UPDATE_BM.getIndex());
        Scheduler.INSTANCE.scheduleServiceIntent(11, context, intent, j);
    }

    public final void cancelBMUpdateCheck(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intent intent = new Intent(context, BluetoothMonitoringService.class);
        intent.putExtra(BluetoothMonitoringService.COMMAND_KEY, BluetoothMonitoringService.Command.ACTION_UPDATE_BM.getIndex());
        Scheduler.INSTANCE.cancelServiceIntent(11, context, intent);
    }

    public final void stopBluetoothMonitoringService(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intent intent = new Intent(context, BluetoothMonitoringService.class);
        intent.putExtra(BluetoothMonitoringService.COMMAND_KEY, BluetoothMonitoringService.Command.ACTION_STOP.getIndex());
        cancelNextScan(context);
        cancelNextHealthCheck(context);
        context.stopService(intent);
    }

    public final void cancelNextScan(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intent intent = new Intent(context, BluetoothMonitoringService.class);
        intent.putExtra(BluetoothMonitoringService.COMMAND_KEY, BluetoothMonitoringService.Command.ACTION_SCAN.getIndex());
        Scheduler.INSTANCE.cancelServiceIntent(7, context, intent);
    }

    public final void cancelNextAdvertise(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intent intent = new Intent(context, BluetoothMonitoringService.class);
        intent.putExtra(BluetoothMonitoringService.COMMAND_KEY, BluetoothMonitoringService.Command.ACTION_ADVERTISE.getIndex());
        Scheduler.INSTANCE.cancelServiceIntent(8, context, intent);
    }

    public final void scheduleNextHealthCheck(Context context, long j) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        cancelNextHealthCheck(context);
        Intent intent = new Intent(context, BluetoothMonitoringService.class);
        intent.putExtra(BluetoothMonitoringService.COMMAND_KEY, BluetoothMonitoringService.Command.ACTION_SELF_CHECK.getIndex());
        Scheduler.INSTANCE.scheduleServiceIntent(9, context, intent, j);
    }

    private final void cancelNextHealthCheck(Context context) {
        Intent intent = new Intent(context, BluetoothMonitoringService.class);
        intent.putExtra(BluetoothMonitoringService.COMMAND_KEY, BluetoothMonitoringService.Command.ACTION_SELF_CHECK.getIndex());
        Scheduler.INSTANCE.cancelServiceIntent(9, context, intent);
    }

    public final void broadcastDeviceScanned(Context context, BluetoothDevice bluetoothDevice, ConnectablePeripheral connectablePeripheral) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(bluetoothDevice, "device");
        Intrinsics.checkParameterIsNotNull(connectablePeripheral, "connectableBleDevice");
        Intent intent = new Intent(StreetPassKt.ACTION_DEVICE_SCANNED);
        intent.putExtra("android.bluetooth.device.extra.DEVICE", bluetoothDevice);
        intent.putExtra(GATTKt.CONNECTION_DATA, connectablePeripheral);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public final void broadcastDeviceProcessed(Context context, String str) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "deviceAddress");
        Intent intent = new Intent(GATTKt.ACTION_DEVICE_PROCESSED);
        intent.putExtra(GATTKt.DEVICE_ADDRESS, str);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public final void broadcastStreetPassReceived(Context context, ConnectionRecord connectionRecord) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(connectionRecord, "streetpass");
        Intent intent = new Intent(GATTKt.ACTION_RECEIVED_STREETPASS);
        intent.putExtra(GATTKt.STREET_PASS, connectionRecord);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public final void broadcastStatusReceived(Context context, Status status) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(status, "statusRecord");
        Intent intent = new Intent(GATTKt.ACTION_RECEIVED_STATUS);
        intent.putExtra(GATTKt.STATUS, status);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public final void broadcastDeviceDisconnected(Context context, BluetoothDevice bluetoothDevice) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(bluetoothDevice, "device");
        Intent intent = new Intent(GATTKt.ACTION_GATT_DISCONNECTED);
        intent.putExtra("android.bluetooth.device.extra.DEVICE", bluetoothDevice);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public final boolean isBluetoothAvailable() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        return defaultAdapter != null && defaultAdapter.isEnabled() && defaultAdapter.getState() == 12;
    }

    public final void storeBroadcastMessage(Context context, String str) {
        Intrinsics.checkParameterIsNotNull(str, "packet");
        CentralLog.Companion.d(TAG, "Storing packet into internal storage...");
        FilesKt.writeText$default(new File(context != null ? context.getFilesDir() : null, "packet"), str, (Charset) null, 2, (Object) null);
    }

    public final String retrieveBroadcastMessage(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        File file = new File(context.getFilesDir(), "packet");
        if (!file.exists()) {
            return null;
        }
        String readText$default = FilesKt.readText$default(file, (Charset) null, 1, (Object) null);
        CentralLog.Companion companion = CentralLog.Companion;
        companion.d(TAG, "fetched broadcastmessage from file:  " + readText$default);
        return readText$default;
    }

    public final boolean needToUpdate(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        long nextFetchTimeInMillis = Preference.INSTANCE.getNextFetchTimeInMillis(context);
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = currentTimeMillis >= nextFetchTimeInMillis;
        CentralLog.Companion companion = CentralLog.Companion;
        companion.i(TAG, "Need to update BM? " + nextFetchTimeInMillis + " vs " + currentTimeMillis + ": " + z);
        return z;
    }

    public final boolean bmValid(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        long expiryTimeInMillis = Preference.INSTANCE.getExpiryTimeInMillis(context);
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = currentTimeMillis < expiryTimeInMillis;
        CentralLog.Companion companion = CentralLog.Companion;
        companion.i(TAG, "Is BM Valid? " + expiryTimeInMillis + " vs " + currentTimeMillis + ": " + z);
        return true;
    }
}
