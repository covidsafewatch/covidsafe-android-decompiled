package au.gov.health.covidsafe.streetpass;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.content.Context;
import android.os.Build;
import au.gov.health.covidsafe.logging.CentralLog;
import au.gov.health.covidsafe.streetpass.StreetPassWorker;
import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0003@ABB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0000H\u0002J\u0006\u00108\u001a\u00020\u001aJ\u001a\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\n\u0010=\u001a\u00060>R\u00020?R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00060\fR\u00020\u0000X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R+\u0010'\u001a\u00020&2\u0006\u0010%\u001a\u00020&8F@FX\u0002¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010.\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010)\"\u0004\b0\u0010+R\u0011\u00101\u001a\u000202¢\u0006\b\n\u0000\u001a\u0004\b3\u00104¨\u0006C"}, d2 = {"Lau/gov/health/covidsafe/streetpass/Work;", "", "device", "Landroid/bluetooth/BluetoothDevice;", "connectable", "Lau/gov/health/covidsafe/streetpass/ConnectablePeripheral;", "onWorkTimeoutListener", "Lau/gov/health/covidsafe/streetpass/Work$OnWorkTimeoutListener;", "(Landroid/bluetooth/BluetoothDevice;Lau/gov/health/covidsafe/streetpass/ConnectablePeripheral;Lau/gov/health/covidsafe/streetpass/Work$OnWorkTimeoutListener;)V", "TAG", "", "checklist", "Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;", "getChecklist", "()Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;", "setChecklist", "(Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;)V", "getConnectable", "()Lau/gov/health/covidsafe/streetpass/ConnectablePeripheral;", "setConnectable", "(Lau/gov/health/covidsafe/streetpass/ConnectablePeripheral;)V", "getDevice", "()Landroid/bluetooth/BluetoothDevice;", "setDevice", "(Landroid/bluetooth/BluetoothDevice;)V", "finished", "", "getFinished", "()Z", "setFinished", "(Z)V", "gatt", "Landroid/bluetooth/BluetoothGatt;", "getGatt", "()Landroid/bluetooth/BluetoothGatt;", "setGatt", "(Landroid/bluetooth/BluetoothGatt;)V", "<set-?>", "", "timeStamp", "getTimeStamp", "()J", "setTimeStamp", "(J)V", "timeStamp$delegate", "Lkotlin/properties/ReadWriteProperty;", "timeout", "getTimeout", "setTimeout", "timeoutRunnable", "Ljava/lang/Runnable;", "getTimeoutRunnable", "()Ljava/lang/Runnable;", "compareTo", "", "other", "isCriticalsCompleted", "startWork", "", "context", "Landroid/content/Context;", "gattCallback", "Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;", "Lau/gov/health/covidsafe/streetpass/StreetPassWorker;", "Check", "OnWorkTimeoutListener", "WorkCheckList", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: Work.kt */
public final class Work implements Comparable<Work> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(Work.class), "timeStamp", "getTimeStamp()J"))};
    private final String TAG = "Work";
    private WorkCheckList checklist = new WorkCheckList();
    private ConnectablePeripheral connectable;
    private BluetoothDevice device;
    private boolean finished;
    private BluetoothGatt gatt;
    /* access modifiers changed from: private */
    public final OnWorkTimeoutListener onWorkTimeoutListener;
    private final ReadWriteProperty timeStamp$delegate = Delegates.INSTANCE.notNull();
    private long timeout;
    private final Runnable timeoutRunnable = new Work$timeoutRunnable$1(this);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lau/gov/health/covidsafe/streetpass/Work$OnWorkTimeoutListener;", "", "onWorkTimeout", "", "work", "Lau/gov/health/covidsafe/streetpass/Work;", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: Work.kt */
    public interface OnWorkTimeoutListener {
        void onWorkTimeout(Work work);
    }

    public final long getTimeStamp() {
        return ((Number) this.timeStamp$delegate.getValue(this, $$delegatedProperties[0])).longValue();
    }

    public final void setTimeStamp(long j) {
        this.timeStamp$delegate.setValue(this, $$delegatedProperties[0], Long.valueOf(j));
    }

    public Work(BluetoothDevice bluetoothDevice, ConnectablePeripheral connectablePeripheral, OnWorkTimeoutListener onWorkTimeoutListener2) {
        Intrinsics.checkParameterIsNotNull(bluetoothDevice, "device");
        Intrinsics.checkParameterIsNotNull(connectablePeripheral, "connectable");
        Intrinsics.checkParameterIsNotNull(onWorkTimeoutListener2, "onWorkTimeoutListener");
        this.device = bluetoothDevice;
        this.connectable = connectablePeripheral;
        this.onWorkTimeoutListener = onWorkTimeoutListener2;
        setTimeStamp(System.currentTimeMillis());
    }

    public final BluetoothDevice getDevice() {
        return this.device;
    }

    public final void setDevice(BluetoothDevice bluetoothDevice) {
        Intrinsics.checkParameterIsNotNull(bluetoothDevice, "<set-?>");
        this.device = bluetoothDevice;
    }

    public final ConnectablePeripheral getConnectable() {
        return this.connectable;
    }

    public final void setConnectable(ConnectablePeripheral connectablePeripheral) {
        Intrinsics.checkParameterIsNotNull(connectablePeripheral, "<set-?>");
        this.connectable = connectablePeripheral;
    }

    public final WorkCheckList getChecklist() {
        return this.checklist;
    }

    public final void setChecklist(WorkCheckList workCheckList) {
        Intrinsics.checkParameterIsNotNull(workCheckList, "<set-?>");
        this.checklist = workCheckList;
    }

    public final BluetoothGatt getGatt() {
        return this.gatt;
    }

    public final void setGatt(BluetoothGatt bluetoothGatt) {
        this.gatt = bluetoothGatt;
    }

    public final boolean getFinished() {
        return this.finished;
    }

    public final void setFinished(boolean z) {
        this.finished = z;
    }

    public final long getTimeout() {
        return this.timeout;
    }

    public final void setTimeout(long j) {
        this.timeout = j;
    }

    public final Runnable getTimeoutRunnable() {
        return this.timeoutRunnable;
    }

    public final boolean isCriticalsCompleted() {
        return (this.checklist.getConnected().getStatus() && this.checklist.getReadCharacteristic().getStatus() && this.checklist.getWriteCharacteristic().getStatus()) || this.checklist.getSkipped().getStatus();
    }

    public final void startWork(Context context, StreetPassWorker.StreetPassGattCallback streetPassGattCallback) {
        BluetoothGatt bluetoothGatt;
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(streetPassGattCallback, "gattCallback");
        if (Build.VERSION.SDK_INT >= 23) {
            bluetoothGatt = this.device.connectGatt(context, false, streetPassGattCallback, 2);
        } else {
            bluetoothGatt = this.device.connectGatt(context, false, streetPassGattCallback);
        }
        this.gatt = bluetoothGatt;
        if (bluetoothGatt == null) {
            CentralLog.Companion companion = CentralLog.Companion;
            String str = this.TAG;
            companion.e(str, "Unable to connect to " + this.device.getAddress());
        }
    }

    public int compareTo(Work work) {
        Intrinsics.checkParameterIsNotNull(work, "other");
        return -((int) (getTimeStamp() - work.getTimeStamp()));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u001e\u0010\u0003\u001a\u00060\u0004R\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00060\u0004R\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00060\u0004R\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001e\u0010\u0010\u001a\u00060\u0004R\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001e\u0010\u0013\u001a\u00060\u0004R\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001e\u0010\u0016\u001a\u00060\u0004R\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001e\u0010\u0019\u001a\u00060\u0004R\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\t¨\u0006\u001e"}, d2 = {"Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;", "", "(Lau/gov/health/covidsafe/streetpass/Work;)V", "connected", "Lau/gov/health/covidsafe/streetpass/Work$Check;", "Lau/gov/health/covidsafe/streetpass/Work;", "getConnected", "()Lau/gov/health/covidsafe/streetpass/Work$Check;", "setConnected", "(Lau/gov/health/covidsafe/streetpass/Work$Check;)V", "disconnected", "getDisconnected", "setDisconnected", "mtuChanged", "getMtuChanged", "setMtuChanged", "readCharacteristic", "getReadCharacteristic", "setReadCharacteristic", "skipped", "getSkipped", "setSkipped", "started", "getStarted", "setStarted", "writeCharacteristic", "getWriteCharacteristic", "setWriteCharacteristic", "toString", "", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: Work.kt */
    public final class WorkCheckList {
        private Check connected;
        private Check disconnected;
        private Check mtuChanged;
        private Check readCharacteristic;
        private Check skipped;
        private Check started;
        private Check writeCharacteristic;

        public WorkCheckList() {
            this.started = new Check();
            this.connected = new Check();
            this.mtuChanged = new Check();
            this.readCharacteristic = new Check();
            this.writeCharacteristic = new Check();
            this.disconnected = new Check();
            this.skipped = new Check();
        }

        public final Check getStarted() {
            return this.started;
        }

        public final void setStarted(Check check) {
            Intrinsics.checkParameterIsNotNull(check, "<set-?>");
            this.started = check;
        }

        public final Check getConnected() {
            return this.connected;
        }

        public final void setConnected(Check check) {
            Intrinsics.checkParameterIsNotNull(check, "<set-?>");
            this.connected = check;
        }

        public final Check getMtuChanged() {
            return this.mtuChanged;
        }

        public final void setMtuChanged(Check check) {
            Intrinsics.checkParameterIsNotNull(check, "<set-?>");
            this.mtuChanged = check;
        }

        public final Check getReadCharacteristic() {
            return this.readCharacteristic;
        }

        public final void setReadCharacteristic(Check check) {
            Intrinsics.checkParameterIsNotNull(check, "<set-?>");
            this.readCharacteristic = check;
        }

        public final Check getWriteCharacteristic() {
            return this.writeCharacteristic;
        }

        public final void setWriteCharacteristic(Check check) {
            Intrinsics.checkParameterIsNotNull(check, "<set-?>");
            this.writeCharacteristic = check;
        }

        public final Check getDisconnected() {
            return this.disconnected;
        }

        public final void setDisconnected(Check check) {
            Intrinsics.checkParameterIsNotNull(check, "<set-?>");
            this.disconnected = check;
        }

        public final Check getSkipped() {
            return this.skipped;
        }

        public final void setSkipped(Check check) {
            Intrinsics.checkParameterIsNotNull(check, "<set-?>");
            this.skipped = check;
        }

        public String toString() {
            String json = new Gson().toJson((Object) this);
            Intrinsics.checkExpressionValueIsNotNull(json, "Gson().toJson(this)");
            return json;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lau/gov/health/covidsafe/streetpass/Work$Check;", "", "(Lau/gov/health/covidsafe/streetpass/Work;)V", "status", "", "getStatus", "()Z", "setStatus", "(Z)V", "timePerformed", "", "getTimePerformed", "()J", "setTimePerformed", "(J)V", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: Work.kt */
    public final class Check {
        private boolean status;
        private long timePerformed;

        public Check() {
        }

        public final boolean getStatus() {
            return this.status;
        }

        public final void setStatus(boolean z) {
            this.status = z;
        }

        public final long getTimePerformed() {
            return this.timePerformed;
        }

        public final void setTimePerformed(long j) {
            this.timePerformed = j;
        }
    }
}
