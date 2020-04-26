package au.gov.health.covidsafe.services;

import android.os.Handler;
import android.os.Message;
import androidx.core.app.NotificationCompat;
import au.gov.health.covidsafe.services.BluetoothMonitoringService;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\u000b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0013H\u0002J\u0006\u0010\u0019\u001a\u00020\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001a"}, d2 = {"Lau/gov/health/covidsafe/services/CommandHandler;", "Landroid/os/Handler;", "service", "Ljava/lang/ref/WeakReference;", "Lau/gov/health/covidsafe/services/BluetoothMonitoringService;", "(Ljava/lang/ref/WeakReference;)V", "getService", "()Ljava/lang/ref/WeakReference;", "cancelNextAdvertise", "", "cancelNextScan", "handleMessage", "msg", "Landroid/os/Message;", "hasAdvertiseScheduled", "", "hasScanScheduled", "scheduleNextAdvertise", "timeInMillis", "", "scheduleNextScan", "sendCommandMsg", "cmd", "Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;", "delay", "startBluetoothMonitoringService", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: CommandHandler.kt */
public final class CommandHandler extends Handler {
    private final WeakReference<BluetoothMonitoringService> service;

    public CommandHandler(WeakReference<BluetoothMonitoringService> weakReference) {
        Intrinsics.checkParameterIsNotNull(weakReference, NotificationCompat.CATEGORY_SERVICE);
        this.service = weakReference;
    }

    public final WeakReference<BluetoothMonitoringService> getService() {
        return this.service;
    }

    public void handleMessage(Message message) {
        if (message != null) {
            int i = message.what;
            BluetoothMonitoringService bluetoothMonitoringService = (BluetoothMonitoringService) this.service.get();
            if (bluetoothMonitoringService != null) {
                bluetoothMonitoringService.runService(BluetoothMonitoringService.Command.Companion.findByValue(i));
            }
        }
    }

    private final void sendCommandMsg(BluetoothMonitoringService.Command command, long j) {
        sendMessageDelayed(Message.obtain(this, command.getIndex()), j);
    }

    private final void sendCommandMsg(BluetoothMonitoringService.Command command) {
        Message obtainMessage = obtainMessage(command.getIndex());
        obtainMessage.arg1 = command.getIndex();
        sendMessage(obtainMessage);
    }

    public final void startBluetoothMonitoringService() {
        sendCommandMsg(BluetoothMonitoringService.Command.ACTION_START);
    }

    public final void scheduleNextScan(long j) {
        cancelNextScan();
        sendCommandMsg(BluetoothMonitoringService.Command.ACTION_SCAN, j);
    }

    private final void cancelNextScan() {
        removeMessages(BluetoothMonitoringService.Command.ACTION_SCAN.getIndex());
    }

    public final boolean hasScanScheduled() {
        return hasMessages(BluetoothMonitoringService.Command.ACTION_SCAN.getIndex());
    }

    public final void scheduleNextAdvertise(long j) {
        cancelNextAdvertise();
        sendCommandMsg(BluetoothMonitoringService.Command.ACTION_ADVERTISE, j);
    }

    private final void cancelNextAdvertise() {
        removeMessages(BluetoothMonitoringService.Command.ACTION_ADVERTISE.getIndex());
    }

    public final boolean hasAdvertiseScheduled() {
        return hasMessages(BluetoothMonitoringService.Command.ACTION_ADVERTISE.getIndex());
    }
}
