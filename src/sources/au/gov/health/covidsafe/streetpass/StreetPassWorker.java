package au.gov.health.covidsafe.streetpass;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import au.gov.health.covidsafe.BuildConfig;
import au.gov.health.covidsafe.TracerApp;
import au.gov.health.covidsafe.Utils;
import au.gov.health.covidsafe.bluetooth.gatt.GATTKt;
import au.gov.health.covidsafe.bluetooth.gatt.ReadRequestPayload;
import au.gov.health.covidsafe.bluetooth.gatt.WriteRequestPayload;
import au.gov.health.covidsafe.logging.CentralLog;
import au.gov.health.covidsafe.streetpass.Work;
import au.gov.health.covidsafe.streetpass.persistence.Encryption;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.PriorityBlockingQueue;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0003345B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0011J\u0006\u0010(\u001a\u00020)J\u000e\u0010*\u001a\u00020)2\u0006\u0010'\u001a\u00020\u0011J\u0010\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u0010.\u001a\u00020&2\b\u0010/\u001a\u0004\u0018\u00010\u0006J\b\u00100\u001a\u00020)H\u0002J\u0006\u00101\u001a\u00020)J\u0006\u00102\u001a\u00020)R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00060\u0013R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \u0016*\u0004\u0018\u00010\u00150\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00110\"X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010#\u001a\u00060$R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lau/gov/health/covidsafe/streetpass/StreetPassWorker;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "blacklist", "", "Lau/gov/health/covidsafe/streetpass/BlacklistEntry;", "blacklistHandler", "Landroid/os/Handler;", "bluetoothManager", "Landroid/bluetooth/BluetoothManager;", "getContext", "()Landroid/content/Context;", "currentPendingConnection", "Lau/gov/health/covidsafe/streetpass/Work;", "deviceProcessedReceiver", "Lau/gov/health/covidsafe/streetpass/StreetPassWorker$DeviceProcessedReceiver;", "gson", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "localBroadcastManager", "Landroidx/localbroadcastmanager/content/LocalBroadcastManager;", "onWorkTimeoutListener", "Lau/gov/health/covidsafe/streetpass/Work$OnWorkTimeoutListener;", "getOnWorkTimeoutListener", "()Lau/gov/health/covidsafe/streetpass/Work$OnWorkTimeoutListener;", "queueHandler", "serviceUUID", "Ljava/util/UUID;", "timeoutHandler", "workQueue", "Ljava/util/concurrent/PriorityBlockingQueue;", "workReceiver", "Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassWorkReceiver;", "addWork", "", "work", "doWork", "", "finishWork", "getConnectionStatus", "device", "Landroid/bluetooth/BluetoothDevice;", "isCurrentlyWorkedOn", "address", "prepare", "terminateConnections", "unregisterReceivers", "DeviceProcessedReceiver", "StreetPassGattCallback", "StreetPassWorkReceiver", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: StreetPassWorker.kt */
public final class StreetPassWorker {
    /* access modifiers changed from: private */
    public final String TAG;
    /* access modifiers changed from: private */
    public final List<BlacklistEntry> blacklist;
    /* access modifiers changed from: private */
    public Handler blacklistHandler;
    private final BluetoothManager bluetoothManager;
    private final Context context;
    /* access modifiers changed from: private */
    public Work currentPendingConnection;
    private final DeviceProcessedReceiver deviceProcessedReceiver;
    /* access modifiers changed from: private */
    public final Gson gson;
    private LocalBroadcastManager localBroadcastManager;
    private final Work.OnWorkTimeoutListener onWorkTimeoutListener;
    private Handler queueHandler;
    /* access modifiers changed from: private */
    public final UUID serviceUUID;
    /* access modifiers changed from: private */
    public Handler timeoutHandler;
    /* access modifiers changed from: private */
    public final PriorityBlockingQueue<Work> workQueue = new PriorityBlockingQueue<>();
    private final StreetPassWorkReceiver workReceiver;

    public StreetPassWorker(Context context2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        this.context = context2;
        List<BlacklistEntry> synchronizedList = Collections.synchronizedList(new ArrayList());
        Intrinsics.checkExpressionValueIsNotNull(synchronizedList, "Collections.synchronizedList(ArrayList())");
        this.blacklist = synchronizedList;
        this.workReceiver = new StreetPassWorkReceiver();
        this.deviceProcessedReceiver = new DeviceProcessedReceiver();
        UUID fromString = UUID.fromString(BuildConfig.BLE_SSID);
        Intrinsics.checkExpressionValueIsNotNull(fromString, "UUID.fromString(BuildConfig.BLE_SSID)");
        this.serviceUUID = fromString;
        this.TAG = "StreetPassWorker";
        Object systemService = this.context.getSystemService("bluetooth");
        if (systemService != null) {
            this.bluetoothManager = (BluetoothManager) systemService;
            LocalBroadcastManager instance = LocalBroadcastManager.getInstance(this.context);
            Intrinsics.checkExpressionValueIsNotNull(instance, "LocalBroadcastManager.getInstance(context)");
            this.localBroadcastManager = instance;
            this.gson = new GsonBuilder().disableHtmlEscaping().create();
            this.onWorkTimeoutListener = new StreetPassWorker$onWorkTimeoutListener$1(this);
            prepare();
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.bluetooth.BluetoothManager");
    }

    public static final /* synthetic */ Handler access$getBlacklistHandler$p(StreetPassWorker streetPassWorker) {
        Handler handler = streetPassWorker.blacklistHandler;
        if (handler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blacklistHandler");
        }
        return handler;
    }

    public static final /* synthetic */ Handler access$getTimeoutHandler$p(StreetPassWorker streetPassWorker) {
        Handler handler = streetPassWorker.timeoutHandler;
        if (handler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timeoutHandler");
        }
        return handler;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Work.OnWorkTimeoutListener getOnWorkTimeoutListener() {
        return this.onWorkTimeoutListener;
    }

    private final void prepare() {
        this.localBroadcastManager.registerReceiver(this.workReceiver, new IntentFilter(StreetPassKt.ACTION_DEVICE_SCANNED));
        this.localBroadcastManager.registerReceiver(this.deviceProcessedReceiver, new IntentFilter(GATTKt.ACTION_DEVICE_PROCESSED));
        this.timeoutHandler = new Handler();
        this.queueHandler = new Handler();
        this.blacklistHandler = new Handler();
    }

    public final boolean isCurrentlyWorkedOn(String str) {
        Work work = this.currentPendingConnection;
        if (work != null) {
            return Intrinsics.areEqual((Object) work.getDevice().getAddress(), (Object) str);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x008f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean addWork(au.gov.health.covidsafe.streetpass.Work r7) {
        /*
            r6 = this;
            java.lang.String r0 = "work"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r7, r0)
            android.bluetooth.BluetoothDevice r0 = r7.getDevice()
            java.lang.String r0 = r0.getAddress()
            boolean r0 = r6.isCurrentlyWorkedOn(r0)
            r1 = 0
            if (r0 == 0) goto L_0x0035
            au.gov.health.covidsafe.logging.CentralLog$Companion r0 = au.gov.health.covidsafe.logging.CentralLog.Companion
            java.lang.String r2 = r6.TAG
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            android.bluetooth.BluetoothDevice r7 = r7.getDevice()
            java.lang.String r7 = r7.getAddress()
            r3.append(r7)
            java.lang.String r7 = " is being worked on, not adding to queue"
            r3.append(r7)
            java.lang.String r7 = r3.toString()
            r0.i(r2, r7)
            return r1
        L_0x0035:
            java.util.List<au.gov.health.covidsafe.streetpass.BlacklistEntry> r0 = r6.blacklist
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r2 = r0 instanceof java.util.Collection
            r3 = 1
            if (r2 == 0) goto L_0x0049
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0049
        L_0x0047:
            r0 = 0
            goto L_0x006c
        L_0x0049:
            java.util.Iterator r0 = r0.iterator()
        L_0x004d:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0047
            java.lang.Object r2 = r0.next()
            au.gov.health.covidsafe.streetpass.BlacklistEntry r2 = (au.gov.health.covidsafe.streetpass.BlacklistEntry) r2
            java.lang.String r2 = r2.getUniqueIdentifier()
            android.bluetooth.BluetoothDevice r4 = r7.getDevice()
            java.lang.String r4 = r4.getAddress()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r4)
            if (r2 == 0) goto L_0x004d
            r0 = 1
        L_0x006c:
            if (r0 == 0) goto L_0x008f
            au.gov.health.covidsafe.logging.CentralLog$Companion r0 = au.gov.health.covidsafe.logging.CentralLog.Companion
            java.lang.String r2 = r6.TAG
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            android.bluetooth.BluetoothDevice r7 = r7.getDevice()
            java.lang.String r7 = r7.getAddress()
            r3.append(r7)
            java.lang.String r7 = " is in blacklist, not adding to queue"
            r3.append(r7)
            java.lang.String r7 = r3.toString()
            r0.i(r2, r7)
            return r1
        L_0x008f:
            java.util.concurrent.PriorityBlockingQueue<au.gov.health.covidsafe.streetpass.Work> r0 = r6.workQueue
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r2 = r0 instanceof java.util.Collection
            if (r2 == 0) goto L_0x00a2
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x00a2
        L_0x00a0:
            r0 = 1
            goto L_0x00c9
        L_0x00a2:
            java.util.Iterator r0 = r0.iterator()
        L_0x00a6:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x00a0
            java.lang.Object r2 = r0.next()
            au.gov.health.covidsafe.streetpass.Work r2 = (au.gov.health.covidsafe.streetpass.Work) r2
            android.bluetooth.BluetoothDevice r2 = r2.getDevice()
            java.lang.String r2 = r2.getAddress()
            android.bluetooth.BluetoothDevice r4 = r7.getDevice()
            java.lang.String r4 = r4.getAddress()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r4)
            if (r2 == 0) goto L_0x00a6
            r0 = 0
        L_0x00c9:
            if (r0 == 0) goto L_0x0106
            java.util.concurrent.PriorityBlockingQueue<au.gov.health.covidsafe.streetpass.Work> r0 = r6.workQueue
            r0.offer(r7)
            android.os.Handler r0 = r6.queueHandler
            if (r0 != 0) goto L_0x00d9
            java.lang.String r1 = "queueHandler"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x00d9:
            au.gov.health.covidsafe.streetpass.StreetPassWorker$addWork$3 r1 = new au.gov.health.covidsafe.streetpass.StreetPassWorker$addWork$3
            r1.<init>(r6, r7)
            java.lang.Runnable r1 = (java.lang.Runnable) r1
            r4 = 7000(0x1b58, double:3.4585E-320)
            r0.postDelayed(r1, r4)
            au.gov.health.covidsafe.logging.CentralLog$Companion r0 = au.gov.health.covidsafe.logging.CentralLog.Companion
            java.lang.String r1 = r6.TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "Added to work queue: "
            r2.append(r4)
            android.bluetooth.BluetoothDevice r7 = r7.getDevice()
            java.lang.String r7 = r7.getAddress()
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            r0.i(r1, r7)
            return r3
        L_0x0106:
            au.gov.health.covidsafe.logging.CentralLog$Companion r0 = au.gov.health.covidsafe.logging.CentralLog.Companion
            java.lang.String r2 = r6.TAG
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            android.bluetooth.BluetoothDevice r4 = r7.getDevice()
            java.lang.String r4 = r4.getAddress()
            r3.append(r4)
            java.lang.String r4 = " is already in work queue"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r0.i(r2, r3)
            java.util.concurrent.PriorityBlockingQueue<au.gov.health.covidsafe.streetpass.Work> r0 = r6.workQueue
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x012e:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0152
            java.lang.Object r2 = r0.next()
            r3 = r2
            au.gov.health.covidsafe.streetpass.Work r3 = (au.gov.health.covidsafe.streetpass.Work) r3
            android.bluetooth.BluetoothDevice r3 = r3.getDevice()
            java.lang.String r3 = r3.getAddress()
            android.bluetooth.BluetoothDevice r4 = r7.getDevice()
            java.lang.String r4 = r4.getAddress()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 == 0) goto L_0x012e
            goto L_0x0153
        L_0x0152:
            r2 = 0
        L_0x0153:
            au.gov.health.covidsafe.streetpass.Work r2 = (au.gov.health.covidsafe.streetpass.Work) r2
            java.util.concurrent.PriorityBlockingQueue<au.gov.health.covidsafe.streetpass.Work> r0 = r6.workQueue
            boolean r0 = r0.remove(r2)
            java.util.concurrent.PriorityBlockingQueue<au.gov.health.covidsafe.streetpass.Work> r2 = r6.workQueue
            boolean r7 = r2.offer(r7)
            au.gov.health.covidsafe.logging.CentralLog$Companion r2 = au.gov.health.covidsafe.logging.CentralLog.Companion
            java.lang.String r3 = r6.TAG
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Queue entry updated - removed: "
            r4.append(r5)
            r4.append(r0)
            java.lang.String r0 = ", added: "
            r4.append(r0)
            r4.append(r7)
            java.lang.String r7 = r4.toString()
            r2.i(r3, r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: au.gov.health.covidsafe.streetpass.StreetPassWorker.addWork(au.gov.health.covidsafe.streetpass.Work):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001b, code lost:
        r6 = r6.getDevice();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void doWork() {
        /*
            r15 = this;
            java.lang.String r0 = "Moving on to next task"
            au.gov.health.covidsafe.streetpass.Work r1 = r15.currentPendingConnection
            r2 = 0
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x00e7
            au.gov.health.covidsafe.logging.CentralLog$Companion r0 = au.gov.health.covidsafe.logging.CentralLog.Companion
            java.lang.String r1 = r15.TAG
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Already trying to connect to: "
            r5.append(r6)
            au.gov.health.covidsafe.streetpass.Work r6 = r15.currentPendingConnection
            if (r6 == 0) goto L_0x0026
            android.bluetooth.BluetoothDevice r6 = r6.getDevice()
            if (r6 == 0) goto L_0x0026
            java.lang.String r6 = r6.getAddress()
            goto L_0x0027
        L_0x0026:
            r6 = r4
        L_0x0027:
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r0.i(r1, r5)
            long r0 = java.lang.System.currentTimeMillis()
            au.gov.health.covidsafe.streetpass.Work r5 = r15.currentPendingConnection
            if (r5 == 0) goto L_0x003e
            long r5 = r5.getTimeout()
            goto L_0x0040
        L_0x003e:
            r5 = 0
        L_0x0040:
            int r7 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0045
            goto L_0x0046
        L_0x0045:
            r3 = 0
        L_0x0046:
            au.gov.health.covidsafe.streetpass.Work r0 = r15.currentPendingConnection
            if (r0 == 0) goto L_0x004f
            boolean r0 = r0.getFinished()
            goto L_0x0050
        L_0x004f:
            r0 = 0
        L_0x0050:
            if (r0 != 0) goto L_0x0054
            if (r3 == 0) goto L_0x00e6
        L_0x0054:
            au.gov.health.covidsafe.logging.CentralLog$Companion r0 = au.gov.health.covidsafe.logging.CentralLog.Companion
            java.lang.String r1 = r15.TAG
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Handling erroneous current work for "
            r5.append(r6)
            au.gov.health.covidsafe.streetpass.Work r6 = r15.currentPendingConnection
            if (r6 == 0) goto L_0x0071
            android.bluetooth.BluetoothDevice r6 = r6.getDevice()
            if (r6 == 0) goto L_0x0071
            java.lang.String r6 = r6.getAddress()
            goto L_0x0072
        L_0x0071:
            r6 = r4
        L_0x0072:
            r5.append(r6)
            java.lang.String r6 = " : - finished: "
            r5.append(r6)
            au.gov.health.covidsafe.streetpass.Work r6 = r15.currentPendingConnection
            if (r6 == 0) goto L_0x0082
            boolean r2 = r6.getFinished()
        L_0x0082:
            r5.append(r2)
            java.lang.String r2 = ", timedout: "
            r5.append(r2)
            r5.append(r3)
            java.lang.String r2 = r5.toString()
            r0.w(r1, r2)
            au.gov.health.covidsafe.streetpass.Work r0 = r15.currentPendingConnection
            if (r0 == 0) goto L_0x00e3
            android.bluetooth.BluetoothManager r0 = r15.bluetoothManager
            r1 = 7
            java.util.List r0 = r0.getConnectedDevices(r1)
            au.gov.health.covidsafe.streetpass.Work r1 = r15.currentPendingConnection
            if (r1 == 0) goto L_0x00a8
            android.bluetooth.BluetoothDevice r1 = r1.getDevice()
            goto L_0x00a9
        L_0x00a8:
            r1 = r4
        L_0x00a9:
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x00e6
            au.gov.health.covidsafe.logging.CentralLog$Companion r0 = au.gov.health.covidsafe.logging.CentralLog.Companion
            java.lang.String r1 = r15.TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Disconnecting dangling connection to "
            r2.append(r3)
            au.gov.health.covidsafe.streetpass.Work r3 = r15.currentPendingConnection
            if (r3 == 0) goto L_0x00cb
            android.bluetooth.BluetoothDevice r3 = r3.getDevice()
            if (r3 == 0) goto L_0x00cb
            java.lang.String r4 = r3.getAddress()
        L_0x00cb:
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r0.w(r1, r2)
            au.gov.health.covidsafe.streetpass.Work r0 = r15.currentPendingConnection
            if (r0 == 0) goto L_0x00e6
            android.bluetooth.BluetoothGatt r0 = r0.getGatt()
            if (r0 == 0) goto L_0x00e6
            r0.disconnect()
            goto L_0x00e6
        L_0x00e3:
            r15.doWork()
        L_0x00e6:
            return
        L_0x00e7:
            java.util.concurrent.PriorityBlockingQueue<au.gov.health.covidsafe.streetpass.Work> r1 = r15.workQueue
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x00f9
            au.gov.health.covidsafe.logging.CentralLog$Companion r0 = au.gov.health.covidsafe.logging.CentralLog.Companion
            java.lang.String r1 = r15.TAG
            java.lang.String r2 = "Queue empty. Nothing to do."
            r0.i(r1, r2)
            return
        L_0x00f9:
            au.gov.health.covidsafe.logging.CentralLog$Companion r1 = au.gov.health.covidsafe.logging.CentralLog.Companion
            java.lang.String r5 = r15.TAG
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Queue size: "
            r6.append(r7)
            java.util.concurrent.PriorityBlockingQueue<au.gov.health.covidsafe.streetpass.Work> r7 = r15.workQueue
            int r7 = r7.size()
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r1.i(r5, r6)
            r1 = r4
            au.gov.health.covidsafe.streetpass.Work r1 = (au.gov.health.covidsafe.streetpass.Work) r1
            long r5 = java.lang.System.currentTimeMillis()
        L_0x011e:
            r7 = r1
        L_0x011f:
            if (r7 != 0) goto L_0x0168
            java.util.concurrent.PriorityBlockingQueue<au.gov.health.covidsafe.streetpass.Work> r8 = r15.workQueue
            java.util.Collection r8 = (java.util.Collection) r8
            boolean r8 = r8.isEmpty()
            r8 = r8 ^ r3
            if (r8 == 0) goto L_0x0168
            java.util.concurrent.PriorityBlockingQueue<au.gov.health.covidsafe.streetpass.Work> r7 = r15.workQueue
            java.lang.Object r7 = r7.poll()
            au.gov.health.covidsafe.streetpass.Work r7 = (au.gov.health.covidsafe.streetpass.Work) r7
            if (r7 == 0) goto L_0x011f
            long r8 = r7.getTimeStamp()
            long r8 = r5 - r8
            r10 = 7000(0x1b58, double:3.4585E-320)
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 <= 0) goto L_0x011f
            au.gov.health.covidsafe.logging.CentralLog$Companion r8 = au.gov.health.covidsafe.logging.CentralLog.Companion
            java.lang.String r9 = r15.TAG
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Work request for "
            r10.append(r11)
            android.bluetooth.BluetoothDevice r7 = r7.getDevice()
            java.lang.String r7 = r7.getAddress()
            r10.append(r7)
            java.lang.String r7 = " too old. Not doing"
            r10.append(r7)
            java.lang.String r7 = r10.toString()
            r8.w(r9, r7)
            goto L_0x011e
        L_0x0168:
            if (r7 == 0) goto L_0x035e
            android.bluetooth.BluetoothDevice r5 = r7.getDevice()
            java.util.List<au.gov.health.covidsafe.streetpass.BlacklistEntry> r6 = r15.blacklist
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r6 = r6.iterator()
        L_0x017d:
            boolean r9 = r6.hasNext()
            if (r9 == 0) goto L_0x019c
            java.lang.Object r9 = r6.next()
            r10 = r9
            au.gov.health.covidsafe.streetpass.BlacklistEntry r10 = (au.gov.health.covidsafe.streetpass.BlacklistEntry) r10
            java.lang.String r10 = r10.getUniqueIdentifier()
            java.lang.String r11 = r5.getAddress()
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r11)
            if (r10 == 0) goto L_0x017d
            r8.add(r9)
            goto L_0x017d
        L_0x019c:
            java.util.List r8 = (java.util.List) r8
            java.util.Collection r8 = (java.util.Collection) r8
            boolean r6 = r8.isEmpty()
            r6 = r6 ^ r3
            if (r6 == 0) goto L_0x01cc
            au.gov.health.covidsafe.logging.CentralLog$Companion r0 = au.gov.health.covidsafe.logging.CentralLog.Companion
            java.lang.String r1 = r15.TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Already worked on "
            r2.append(r3)
            java.lang.String r3 = r5.getAddress()
            r2.append(r3)
            java.lang.String r3 = ". Skip."
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.w(r1, r2)
            r15.doWork()
            return
        L_0x01cc:
            boolean r6 = r15.getConnectionStatus(r5)
            au.gov.health.covidsafe.logging.CentralLog$Companion r8 = au.gov.health.covidsafe.logging.CentralLog.Companion
            java.lang.String r9 = r15.TAG
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Already connected to "
            r10.append(r11)
            java.lang.String r11 = r5.getAddress()
            r10.append(r11)
            java.lang.String r11 = " : "
            r10.append(r11)
            r10.append(r6)
            java.lang.String r10 = r10.toString()
            r8.i(r9, r10)
            if (r6 == 0) goto L_0x0215
            au.gov.health.covidsafe.streetpass.Work$WorkCheckList r0 = r7.getChecklist()
            au.gov.health.covidsafe.streetpass.Work$Check r0 = r0.getSkipped()
            r0.setStatus(r3)
            au.gov.health.covidsafe.streetpass.Work$WorkCheckList r0 = r7.getChecklist()
            au.gov.health.covidsafe.streetpass.Work$Check r0 = r0.getSkipped()
            long r1 = java.lang.System.currentTimeMillis()
            r0.setTimePerformed(r1)
            r15.finishWork(r7)
            goto L_0x035e
        L_0x0215:
            if (r7 == 0) goto L_0x0355
            au.gov.health.covidsafe.streetpass.StreetPassWorker$StreetPassGattCallback r6 = new au.gov.health.covidsafe.streetpass.StreetPassWorker$StreetPassGattCallback
            r6.<init>(r15, r7)
            au.gov.health.covidsafe.logging.CentralLog$Companion r8 = au.gov.health.covidsafe.logging.CentralLog.Companion
            java.lang.String r9 = r15.TAG
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Starting work - connecting to device: "
            r10.append(r11)
            java.lang.String r11 = r5.getAddress()
            r10.append(r11)
            java.lang.String r11 = " @ "
            r10.append(r11)
            au.gov.health.covidsafe.streetpass.ConnectablePeripheral r11 = r7.getConnectable()
            int r11 = r11.getRssi()
            r10.append(r11)
            r11 = 32
            r10.append(r11)
            long r11 = java.lang.System.currentTimeMillis()
            long r13 = r7.getTimeStamp()
            long r11 = r11 - r13
            r10.append(r11)
            java.lang.String r11 = "ms ago"
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r8.i(r9, r10)
            r15.currentPendingConnection = r7
            au.gov.health.covidsafe.streetpass.Work$WorkCheckList r8 = r7.getChecklist()     // Catch:{ all -> 0x031f }
            au.gov.health.covidsafe.streetpass.Work$Check r8 = r8.getStarted()     // Catch:{ all -> 0x031f }
            r8.setStatus(r3)     // Catch:{ all -> 0x031f }
            au.gov.health.covidsafe.streetpass.Work$WorkCheckList r3 = r7.getChecklist()     // Catch:{ all -> 0x031f }
            au.gov.health.covidsafe.streetpass.Work$Check r3 = r3.getStarted()     // Catch:{ all -> 0x031f }
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x031f }
            r3.setTimePerformed(r8)     // Catch:{ all -> 0x031f }
            android.content.Context r3 = r15.context     // Catch:{ all -> 0x031f }
            r7.startWork(r3, r6)     // Catch:{ all -> 0x031f }
            android.bluetooth.BluetoothGatt r3 = r7.getGatt()     // Catch:{ all -> 0x031f }
            if (r3 == 0) goto L_0x0289
            boolean r2 = r3.connect()     // Catch:{ all -> 0x031f }
        L_0x0289:
            if (r2 != 0) goto L_0x02bf
            au.gov.health.covidsafe.logging.CentralLog$Companion r2 = au.gov.health.covidsafe.logging.CentralLog.Companion     // Catch:{ all -> 0x031f }
            java.lang.String r3 = r15.TAG     // Catch:{ all -> 0x031f }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x031f }
            r6.<init>()     // Catch:{ all -> 0x031f }
            java.lang.String r8 = "not connecting to "
            r6.append(r8)     // Catch:{ all -> 0x031f }
            android.bluetooth.BluetoothDevice r7 = r7.getDevice()     // Catch:{ all -> 0x031f }
            java.lang.String r7 = r7.getAddress()     // Catch:{ all -> 0x031f }
            r6.append(r7)     // Catch:{ all -> 0x031f }
            java.lang.String r7 = "??"
            r6.append(r7)     // Catch:{ all -> 0x031f }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x031f }
            r2.e(r3, r6)     // Catch:{ all -> 0x031f }
            au.gov.health.covidsafe.logging.CentralLog$Companion r2 = au.gov.health.covidsafe.logging.CentralLog.Companion     // Catch:{ all -> 0x031f }
            java.lang.String r3 = r15.TAG     // Catch:{ all -> 0x031f }
            r2.e(r3, r0)     // Catch:{ all -> 0x031f }
            au.gov.health.covidsafe.streetpass.Work r4 = (au.gov.health.covidsafe.streetpass.Work) r4     // Catch:{ all -> 0x031f }
            r15.currentPendingConnection = r4     // Catch:{ all -> 0x031f }
            r15.doWork()     // Catch:{ all -> 0x031f }
            return
        L_0x02bf:
            au.gov.health.covidsafe.logging.CentralLog$Companion r2 = au.gov.health.covidsafe.logging.CentralLog.Companion     // Catch:{ all -> 0x031f }
            java.lang.String r3 = r15.TAG     // Catch:{ all -> 0x031f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x031f }
            r4.<init>()     // Catch:{ all -> 0x031f }
            java.lang.String r6 = "Connection to "
            r4.append(r6)     // Catch:{ all -> 0x031f }
            android.bluetooth.BluetoothDevice r6 = r7.getDevice()     // Catch:{ all -> 0x031f }
            java.lang.String r6 = r6.getAddress()     // Catch:{ all -> 0x031f }
            r4.append(r6)     // Catch:{ all -> 0x031f }
            java.lang.String r6 = " attempt in progress"
            r4.append(r6)     // Catch:{ all -> 0x031f }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x031f }
            r2.i(r3, r4)     // Catch:{ all -> 0x031f }
            android.os.Handler r2 = r15.timeoutHandler     // Catch:{ all -> 0x031f }
            if (r2 != 0) goto L_0x02ed
            java.lang.String r3 = "timeoutHandler"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)     // Catch:{ all -> 0x031f }
        L_0x02ed:
            java.lang.Runnable r3 = r7.getTimeoutRunnable()     // Catch:{ all -> 0x031f }
            r8 = 6000(0x1770, double:2.9644E-320)
            r2.postDelayed(r3, r8)     // Catch:{ all -> 0x031f }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x031f }
            long r2 = r2 + r8
            r7.setTimeout(r2)     // Catch:{ all -> 0x031f }
            au.gov.health.covidsafe.logging.CentralLog$Companion r2 = au.gov.health.covidsafe.logging.CentralLog.Companion     // Catch:{ all -> 0x031f }
            java.lang.String r3 = r15.TAG     // Catch:{ all -> 0x031f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x031f }
            r4.<init>()     // Catch:{ all -> 0x031f }
            java.lang.String r6 = "Timeout scheduled for "
            r4.append(r6)     // Catch:{ all -> 0x031f }
            android.bluetooth.BluetoothDevice r6 = r7.getDevice()     // Catch:{ all -> 0x031f }
            java.lang.String r6 = r6.getAddress()     // Catch:{ all -> 0x031f }
            r4.append(r6)     // Catch:{ all -> 0x031f }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x031f }
            r2.i(r3, r4)     // Catch:{ all -> 0x031f }
            goto L_0x035e
        L_0x031f:
            r2 = move-exception
            au.gov.health.covidsafe.logging.CentralLog$Companion r3 = au.gov.health.covidsafe.logging.CentralLog.Companion
            java.lang.String r4 = r15.TAG
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Unexpected error while attempting to connect to "
            r6.append(r7)
            java.lang.String r5 = r5.getAddress()
            r6.append(r5)
            java.lang.String r5 = ": "
            r6.append(r5)
            java.lang.String r2 = r2.getLocalizedMessage()
            r6.append(r2)
            java.lang.String r2 = r6.toString()
            r3.e(r4, r2)
            au.gov.health.covidsafe.logging.CentralLog$Companion r2 = au.gov.health.covidsafe.logging.CentralLog.Companion
            java.lang.String r3 = r15.TAG
            r2.e(r3, r0)
            r15.currentPendingConnection = r1
            r15.doWork()
            return
        L_0x0355:
            au.gov.health.covidsafe.logging.CentralLog$Companion r0 = au.gov.health.covidsafe.logging.CentralLog.Companion
            java.lang.String r1 = r15.TAG
            java.lang.String r2 = "Work not started - missing Work Object"
            r0.e(r1, r2)
        L_0x035e:
            if (r7 != 0) goto L_0x0369
            au.gov.health.covidsafe.logging.CentralLog$Companion r0 = au.gov.health.covidsafe.logging.CentralLog.Companion
            java.lang.String r1 = r15.TAG
            java.lang.String r2 = "No outstanding work"
            r0.i(r1, r2)
        L_0x0369:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: au.gov.health.covidsafe.streetpass.StreetPassWorker.doWork():void");
    }

    private final boolean getConnectionStatus(BluetoothDevice bluetoothDevice) {
        return this.bluetoothManager.getDevicesMatchingConnectionStates(7, new int[]{2}).contains(bluetoothDevice);
    }

    public final void finishWork(Work work) {
        Intrinsics.checkParameterIsNotNull(work, "work");
        if (work.getFinished()) {
            CentralLog.Companion companion = CentralLog.Companion;
            String str = this.TAG;
            companion.i(str, "Work on " + work.getDevice().getAddress() + " already finished and closed");
            return;
        }
        if (work.isCriticalsCompleted()) {
            Utils utils = Utils.INSTANCE;
            Context context2 = this.context;
            String address = work.getDevice().getAddress();
            Intrinsics.checkExpressionValueIsNotNull(address, "work.device.address");
            utils.broadcastDeviceProcessed(context2, address);
        }
        CentralLog.Companion companion2 = CentralLog.Companion;
        String str2 = this.TAG;
        companion2.i(str2, "Work on " + work.getDevice().getAddress() + " stopped in: " + (work.getChecklist().getDisconnected().getTimePerformed() - work.getChecklist().getStarted().getTimePerformed()));
        CentralLog.Companion companion3 = CentralLog.Companion;
        String str3 = this.TAG;
        companion3.i(str3, "Work on " + work.getDevice().getAddress() + " completed?: " + work.isCriticalsCompleted() + ". Connected in: " + (work.getChecklist().getConnected().getTimePerformed() - work.getChecklist().getStarted().getTimePerformed()) + ". connection lasted for: " + (work.getChecklist().getDisconnected().getTimePerformed() - work.getChecklist().getConnected().getTimePerformed()) + ". Status: " + work.getChecklist());
        Handler handler = this.timeoutHandler;
        if (handler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timeoutHandler");
        }
        handler.removeCallbacks(work.getTimeoutRunnable());
        CentralLog.Companion companion4 = CentralLog.Companion;
        String str4 = this.TAG;
        companion4.i(str4, "Timeout removed for " + work.getDevice().getAddress());
        work.setFinished(true);
        doWork();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J \u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\"\u0010\u000f\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0016J\"\u0010\u0011\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;", "Landroid/bluetooth/BluetoothGattCallback;", "work", "Lau/gov/health/covidsafe/streetpass/Work;", "(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;Lau/gov/health/covidsafe/streetpass/Work;)V", "endWorkConnection", "", "gatt", "Landroid/bluetooth/BluetoothGatt;", "onCharacteristicRead", "characteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "status", "", "onCharacteristicWrite", "onConnectionStateChange", "newState", "onMtuChanged", "mtu", "onServicesDiscovered", "EncryptedWriteRequestPayload", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: StreetPassWorker.kt */
    public final class StreetPassGattCallback extends BluetoothGattCallback {
        final /* synthetic */ StreetPassWorker this$0;
        private final Work work;

        public StreetPassGattCallback(StreetPassWorker streetPassWorker, Work work2) {
            Intrinsics.checkParameterIsNotNull(work2, "work");
            this.this$0 = streetPassWorker;
            this.work = work2;
        }

        private final void endWorkConnection(BluetoothGatt bluetoothGatt) {
            CentralLog.Companion companion = CentralLog.Companion;
            String access$getTAG$p = this.this$0.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Ending connection with: ");
            BluetoothDevice device = bluetoothGatt.getDevice();
            Intrinsics.checkExpressionValueIsNotNull(device, "gatt.device");
            sb.append(device.getAddress());
            companion.i(access$getTAG$p, sb.toString());
            bluetoothGatt.disconnect();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x011b, code lost:
            r7 = r7.getDevice();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onConnectionStateChange(android.bluetooth.BluetoothGatt r5, int r6, int r7) {
            /*
                r4 = this;
                if (r5 == 0) goto L_0x013e
                r6 = 1
                java.lang.String r0 = "gatt.device"
                if (r7 == 0) goto L_0x008e
                r1 = 2
                if (r7 == r1) goto L_0x003e
                au.gov.health.covidsafe.logging.CentralLog$Companion r6 = au.gov.health.covidsafe.logging.CentralLog.Companion
                au.gov.health.covidsafe.streetpass.StreetPassWorker r1 = r4.this$0
                java.lang.String r1 = r1.TAG
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Connection status for "
                r2.append(r3)
                android.bluetooth.BluetoothDevice r3 = r5.getDevice()
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r0)
                java.lang.String r0 = r3.getAddress()
                r2.append(r0)
                java.lang.String r0 = ": "
                r2.append(r0)
                r2.append(r7)
                java.lang.String r7 = r2.toString()
                r6.i(r1, r7)
                r4.endWorkConnection(r5)
                goto L_0x013e
            L_0x003e:
                au.gov.health.covidsafe.logging.CentralLog$Companion r7 = au.gov.health.covidsafe.logging.CentralLog.Companion
                au.gov.health.covidsafe.streetpass.StreetPassWorker r1 = r4.this$0
                java.lang.String r1 = r1.TAG
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Connected to other GATT server - "
                r2.append(r3)
                android.bluetooth.BluetoothDevice r3 = r5.getDevice()
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r0)
                java.lang.String r0 = r3.getAddress()
                r2.append(r0)
                java.lang.String r0 = r2.toString()
                r7.i(r1, r0)
                r7 = 0
                r5.requestConnectionPriority(r7)
                r7 = 512(0x200, float:7.175E-43)
                r5.requestMtu(r7)
                au.gov.health.covidsafe.streetpass.Work r5 = r4.work
                au.gov.health.covidsafe.streetpass.Work$WorkCheckList r5 = r5.getChecklist()
                au.gov.health.covidsafe.streetpass.Work$Check r5 = r5.getConnected()
                r5.setStatus(r6)
                au.gov.health.covidsafe.streetpass.Work r5 = r4.work
                au.gov.health.covidsafe.streetpass.Work$WorkCheckList r5 = r5.getChecklist()
                au.gov.health.covidsafe.streetpass.Work$Check r5 = r5.getConnected()
                long r6 = java.lang.System.currentTimeMillis()
                r5.setTimePerformed(r6)
                goto L_0x013e
            L_0x008e:
                au.gov.health.covidsafe.logging.CentralLog$Companion r7 = au.gov.health.covidsafe.logging.CentralLog.Companion
                au.gov.health.covidsafe.streetpass.StreetPassWorker r1 = r4.this$0
                java.lang.String r1 = r1.TAG
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Disconnected from other GATT server - "
                r2.append(r3)
                android.bluetooth.BluetoothDevice r3 = r5.getDevice()
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r0)
                java.lang.String r0 = r3.getAddress()
                r2.append(r0)
                java.lang.String r0 = r2.toString()
                r7.i(r1, r0)
                au.gov.health.covidsafe.streetpass.Work r7 = r4.work
                au.gov.health.covidsafe.streetpass.Work$WorkCheckList r7 = r7.getChecklist()
                au.gov.health.covidsafe.streetpass.Work$Check r7 = r7.getDisconnected()
                r7.setStatus(r6)
                au.gov.health.covidsafe.streetpass.Work r6 = r4.work
                au.gov.health.covidsafe.streetpass.Work$WorkCheckList r6 = r6.getChecklist()
                au.gov.health.covidsafe.streetpass.Work$Check r6 = r6.getDisconnected()
                long r0 = java.lang.System.currentTimeMillis()
                r6.setTimePerformed(r0)
                au.gov.health.covidsafe.streetpass.StreetPassWorker r6 = r4.this$0
                android.os.Handler r6 = au.gov.health.covidsafe.streetpass.StreetPassWorker.access$getTimeoutHandler$p(r6)
                au.gov.health.covidsafe.streetpass.Work r7 = r4.work
                java.lang.Runnable r7 = r7.getTimeoutRunnable()
                r6.removeCallbacks(r7)
                au.gov.health.covidsafe.logging.CentralLog$Companion r6 = au.gov.health.covidsafe.logging.CentralLog.Companion
                au.gov.health.covidsafe.streetpass.StreetPassWorker r7 = r4.this$0
                java.lang.String r7 = r7.TAG
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Timeout removed for "
                r0.append(r1)
                au.gov.health.covidsafe.streetpass.Work r1 = r4.work
                android.bluetooth.BluetoothDevice r1 = r1.getDevice()
                java.lang.String r1 = r1.getAddress()
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r6.i(r7, r0)
                au.gov.health.covidsafe.streetpass.Work r6 = r4.work
                android.bluetooth.BluetoothDevice r6 = r6.getDevice()
                java.lang.String r6 = r6.getAddress()
                au.gov.health.covidsafe.streetpass.StreetPassWorker r7 = r4.this$0
                au.gov.health.covidsafe.streetpass.Work r7 = r7.currentPendingConnection
                r0 = 0
                if (r7 == 0) goto L_0x0126
                android.bluetooth.BluetoothDevice r7 = r7.getDevice()
                if (r7 == 0) goto L_0x0126
                java.lang.String r7 = r7.getAddress()
                goto L_0x0127
            L_0x0126:
                r7 = r0
            L_0x0127:
                boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
                if (r6 == 0) goto L_0x0134
                au.gov.health.covidsafe.streetpass.StreetPassWorker r6 = r4.this$0
                au.gov.health.covidsafe.streetpass.Work r0 = (au.gov.health.covidsafe.streetpass.Work) r0
                r6.currentPendingConnection = r0
            L_0x0134:
                r5.close()
                au.gov.health.covidsafe.streetpass.StreetPassWorker r5 = r4.this$0
                au.gov.health.covidsafe.streetpass.Work r6 = r4.work
                r5.finishWork(r6)
            L_0x013e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: au.gov.health.covidsafe.streetpass.StreetPassWorker.StreetPassGattCallback.onConnectionStateChange(android.bluetooth.BluetoothGatt, int, int):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x003e, code lost:
            r4 = r6.getDevice();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onMtuChanged(android.bluetooth.BluetoothGatt r6, int r7, int r8) {
            /*
                r5 = this;
                au.gov.health.covidsafe.streetpass.Work r0 = r5.work
                au.gov.health.covidsafe.streetpass.Work$WorkCheckList r0 = r0.getChecklist()
                au.gov.health.covidsafe.streetpass.Work$Check r0 = r0.getMtuChanged()
                boolean r0 = r0.getStatus()
                if (r0 != 0) goto L_0x009f
                au.gov.health.covidsafe.streetpass.Work r0 = r5.work
                au.gov.health.covidsafe.streetpass.Work$WorkCheckList r0 = r0.getChecklist()
                au.gov.health.covidsafe.streetpass.Work$Check r0 = r0.getMtuChanged()
                r1 = 1
                r0.setStatus(r1)
                au.gov.health.covidsafe.streetpass.Work r0 = r5.work
                au.gov.health.covidsafe.streetpass.Work$WorkCheckList r0 = r0.getChecklist()
                au.gov.health.covidsafe.streetpass.Work$Check r0 = r0.getMtuChanged()
                long r2 = java.lang.System.currentTimeMillis()
                r0.setTimePerformed(r2)
                au.gov.health.covidsafe.logging.CentralLog$Companion r0 = au.gov.health.covidsafe.logging.CentralLog.Companion
                au.gov.health.covidsafe.streetpass.StreetPassWorker r2 = r5.this$0
                java.lang.String r2 = r2.TAG
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                if (r6 == 0) goto L_0x0049
                android.bluetooth.BluetoothDevice r4 = r6.getDevice()
                if (r4 == 0) goto L_0x0049
                java.lang.String r4 = r4.getAddress()
                goto L_0x004a
            L_0x0049:
                r4 = 0
            L_0x004a:
                r3.append(r4)
                java.lang.String r4 = " MTU is "
                r3.append(r4)
                r3.append(r7)
                java.lang.String r7 = ". Was change successful? : "
                r3.append(r7)
                if (r8 != 0) goto L_0x005d
                goto L_0x005e
            L_0x005d:
                r1 = 0
            L_0x005e:
                r3.append(r1)
                java.lang.String r7 = r3.toString()
                r0.i(r2, r7)
                if (r6 == 0) goto L_0x009f
                boolean r7 = r6.discoverServices()
                au.gov.health.covidsafe.logging.CentralLog$Companion r8 = au.gov.health.covidsafe.logging.CentralLog.Companion
                au.gov.health.covidsafe.streetpass.StreetPassWorker r0 = r5.this$0
                java.lang.String r0 = r0.TAG
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Attempting to start service discovery on "
                r1.append(r2)
                android.bluetooth.BluetoothDevice r6 = r6.getDevice()
                java.lang.String r2 = "gatt.device"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r2)
                java.lang.String r6 = r6.getAddress()
                r1.append(r6)
                java.lang.String r6 = ": "
                r1.append(r6)
                r1.append(r7)
                java.lang.String r6 = r1.toString()
                r8.i(r0, r6)
            L_0x009f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: au.gov.health.covidsafe.streetpass.StreetPassWorker.StreetPassGattCallback.onMtuChanged(android.bluetooth.BluetoothGatt, int, int):void");
        }

        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            Intrinsics.checkParameterIsNotNull(bluetoothGatt, "gatt");
            if (i != 0) {
                CentralLog.Companion companion = CentralLog.Companion;
                String access$getTAG$p = this.this$0.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("No services discovered on ");
                BluetoothDevice device = bluetoothGatt.getDevice();
                Intrinsics.checkExpressionValueIsNotNull(device, "gatt.device");
                sb.append(device.getAddress());
                companion.w(access$getTAG$p, sb.toString());
                endWorkConnection(bluetoothGatt);
                return;
            }
            CentralLog.Companion companion2 = CentralLog.Companion;
            String access$getTAG$p2 = this.this$0.TAG;
            companion2.i(access$getTAG$p2, "onServicesDiscovered received: BluetoothGatt.GATT_SUCCESS - " + i);
            CentralLog.Companion companion3 = CentralLog.Companion;
            String access$getTAG$p3 = this.this$0.TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Discovered ");
            sb2.append(bluetoothGatt.getServices().size());
            sb2.append(" services on ");
            BluetoothDevice device2 = bluetoothGatt.getDevice();
            Intrinsics.checkExpressionValueIsNotNull(device2, "gatt.device");
            sb2.append(device2.getAddress());
            companion3.i(access$getTAG$p3, sb2.toString());
            BluetoothGattService service = bluetoothGatt.getService(this.this$0.serviceUUID);
            if (service != null) {
                BluetoothGattCharacteristic characteristic = service.getCharacteristic(this.this$0.serviceUUID);
                if (characteristic != null) {
                    StreetPassPairingFix.INSTANCE.bypassAuthenticationRetry(bluetoothGatt);
                    boolean readCharacteristic = bluetoothGatt.readCharacteristic(characteristic);
                    CentralLog.Companion companion4 = CentralLog.Companion;
                    String access$getTAG$p4 = this.this$0.TAG;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Attempt to read characteristic of our service on ");
                    BluetoothDevice device3 = bluetoothGatt.getDevice();
                    Intrinsics.checkExpressionValueIsNotNull(device3, "gatt.device");
                    sb3.append(device3.getAddress());
                    sb3.append(": ");
                    sb3.append(readCharacteristic);
                    companion4.i(access$getTAG$p4, sb3.toString());
                } else {
                    CentralLog.Companion companion5 = CentralLog.Companion;
                    String access$getTAG$p5 = this.this$0.TAG;
                    StringBuilder sb4 = new StringBuilder();
                    BluetoothDevice device4 = bluetoothGatt.getDevice();
                    Intrinsics.checkExpressionValueIsNotNull(device4, "gatt.device");
                    sb4.append(device4.getAddress());
                    sb4.append(" does not have our characteristic");
                    companion5.e(access$getTAG$p5, sb4.toString());
                    endWorkConnection(bluetoothGatt);
                }
            }
            if (service == null) {
                CentralLog.Companion companion6 = CentralLog.Companion;
                String access$getTAG$p6 = this.this$0.TAG;
                StringBuilder sb5 = new StringBuilder();
                BluetoothDevice device5 = bluetoothGatt.getDevice();
                Intrinsics.checkExpressionValueIsNotNull(device5, "gatt.device");
                sb5.append(device5.getAddress());
                sb5.append(" does not have our service");
                companion6.e(access$getTAG$p6, sb5.toString());
                endWorkConnection(bluetoothGatt);
            }
        }

        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            Intrinsics.checkParameterIsNotNull(bluetoothGatt, "gatt");
            Intrinsics.checkParameterIsNotNull(bluetoothGattCharacteristic, "characteristic");
            CentralLog.Companion companion = CentralLog.Companion;
            String access$getTAG$p = this.this$0.TAG;
            companion.i(access$getTAG$p, "Read Status: " + i);
            if (i != 0) {
                CentralLog.Companion companion2 = CentralLog.Companion;
                String access$getTAG$p2 = this.this$0.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to read characteristics from ");
                BluetoothDevice device = bluetoothGatt.getDevice();
                Intrinsics.checkExpressionValueIsNotNull(device, "gatt.device");
                sb.append(device.getAddress());
                sb.append(": ");
                sb.append(i);
                companion2.w(access$getTAG$p2, sb.toString());
            } else {
                CentralLog.Companion companion3 = CentralLog.Companion;
                String access$getTAG$p3 = this.this$0.TAG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Characteristic read from ");
                BluetoothDevice device2 = bluetoothGatt.getDevice();
                Intrinsics.checkExpressionValueIsNotNull(device2, "gatt.device");
                sb2.append(device2.getAddress());
                sb2.append(": ");
                sb2.append(bluetoothGattCharacteristic.getStringValue(0));
                companion3.i(access$getTAG$p3, sb2.toString());
                if (Intrinsics.areEqual((Object) bluetoothGattCharacteristic.getUuid(), (Object) this.this$0.serviceUUID)) {
                    CentralLog.Companion companion4 = CentralLog.Companion;
                    String access$getTAG$p4 = this.this$0.TAG;
                    companion4.i(access$getTAG$p4, "onCharacteristicRead: " + this.work.getDevice().getAddress() + " - [" + this.work.getConnectable().getRssi() + ']');
                    byte[] value = bluetoothGattCharacteristic.getValue();
                    try {
                        ReadRequestPayload.Companion companion5 = ReadRequestPayload.Companion;
                        Intrinsics.checkExpressionValueIsNotNull(value, "dataBytes");
                        ReadRequestPayload createReadRequestPayload = companion5.createReadRequestPayload(value);
                        Utils.INSTANCE.broadcastStreetPassReceived(this.this$0.getContext(), new ConnectionRecord(createReadRequestPayload.getV(), createReadRequestPayload.getMsg(), createReadRequestPayload.getOrg(), new PeripheralDevice(createReadRequestPayload.getModelP(), this.work.getDevice().getAddress()), TracerApp.Companion.asCentralDevice(), this.work.getConnectable().getRssi(), this.work.getConnectable().getTransmissionPower()));
                    } catch (Throwable th) {
                        CentralLog.Companion companion6 = CentralLog.Companion;
                        String access$getTAG$p5 = this.this$0.TAG;
                        companion6.e(access$getTAG$p5, "Failed to de-serialize request payload object - " + th.getMessage());
                    }
                }
                this.work.getChecklist().getReadCharacteristic().setStatus(true);
                this.work.getChecklist().getReadCharacteristic().setTimePerformed(System.currentTimeMillis());
            }
            if (Utils.INSTANCE.bmValid(this.this$0.getContext())) {
                String json = this.this$0.gson.toJson((Object) new EncryptedWriteRequestPayload(this, TracerApp.Companion.asCentralDevice().getModelC(), this.work.getConnectable().getRssi(), this.work.getConnectable().getTransmissionPower(), TracerApp.Companion.thisDeviceMsg()));
                Intrinsics.checkExpressionValueIsNotNull(json, "gson.toJson(EncryptedWri…acerApp.thisDeviceMsg()))");
                Charset charset = Charsets.UTF_8;
                if (json != null) {
                    byte[] bytes = json.getBytes(charset);
                    Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
                    bluetoothGattCharacteristic.setValue(new WriteRequestPayload(2, Encryption.INSTANCE.encryptPayload(bytes), "AU_DTA", "", 999, 999).getPayload());
                    StreetPassPairingFix.INSTANCE.bypassAuthenticationRetry(bluetoothGatt);
                    boolean writeCharacteristic = bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
                    CentralLog.Companion companion7 = CentralLog.Companion;
                    String access$getTAG$p6 = this.this$0.TAG;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Attempt to write characteristic to our service on ");
                    BluetoothDevice device3 = bluetoothGatt.getDevice();
                    Intrinsics.checkExpressionValueIsNotNull(device3, "gatt.device");
                    sb3.append(device3.getAddress());
                    sb3.append(": ");
                    sb3.append(writeCharacteristic);
                    companion7.i(access$getTAG$p6, sb3.toString());
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            CentralLog.Companion companion8 = CentralLog.Companion;
            String access$getTAG$p7 = this.this$0.TAG;
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Expired BM. Skipping attempt to write characteristic to our service on ");
            BluetoothDevice device4 = bluetoothGatt.getDevice();
            Intrinsics.checkExpressionValueIsNotNull(device4, "gatt.device");
            sb4.append(device4.getAddress());
            companion8.i(access$getTAG$p7, sb4.toString());
            endWorkConnection(bluetoothGatt);
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback$EncryptedWriteRequestPayload;", "", "modelC", "", "rssi", "", "txPower", "msg", "(Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassGattCallback;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;)V", "getModelC", "()Ljava/lang/String;", "getMsg", "getRssi", "()I", "getTxPower", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "app_release"}, k = 1, mv = {1, 1, 16})
        /* compiled from: StreetPassWorker.kt */
        public final class EncryptedWriteRequestPayload {
            private final String modelC;
            private final String msg;
            private final int rssi;
            final /* synthetic */ StreetPassGattCallback this$0;
            private final Integer txPower;

            public EncryptedWriteRequestPayload(StreetPassGattCallback streetPassGattCallback, String str, int i, Integer num, String str2) {
                Intrinsics.checkParameterIsNotNull(str, "modelC");
                Intrinsics.checkParameterIsNotNull(str2, NotificationCompat.CATEGORY_MESSAGE);
                this.this$0 = streetPassGattCallback;
                this.modelC = str;
                this.rssi = i;
                this.txPower = num;
                this.msg = str2;
            }

            public final String getModelC() {
                return this.modelC;
            }

            public final String getMsg() {
                return this.msg;
            }

            public final int getRssi() {
                return this.rssi;
            }

            public final Integer getTxPower() {
                return this.txPower;
            }
        }

        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            Intrinsics.checkParameterIsNotNull(bluetoothGatt, "gatt");
            Intrinsics.checkParameterIsNotNull(bluetoothGattCharacteristic, "characteristic");
            if (i != 0) {
                CentralLog.Companion companion = CentralLog.Companion;
                String access$getTAG$p = this.this$0.TAG;
                companion.i(access$getTAG$p, "Failed to write characteristics: " + i);
            } else {
                CentralLog.Companion.i(this.this$0.TAG, "Characteristic wrote successfully");
                this.work.getChecklist().getWriteCharacteristic().setStatus(true);
                this.work.getChecklist().getWriteCharacteristic().setTimePerformed(System.currentTimeMillis());
            }
            endWorkConnection(bluetoothGatt);
        }
    }

    public final void terminateConnections() {
        BluetoothGatt gatt;
        CentralLog.Companion.d(this.TAG, "Cleaning up worker.");
        Work work = this.currentPendingConnection;
        if (!(work == null || (gatt = work.getGatt()) == null)) {
            gatt.disconnect();
        }
        this.currentPendingConnection = null;
        Handler handler = this.timeoutHandler;
        if (handler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timeoutHandler");
        }
        handler.removeCallbacksAndMessages((Object) null);
        Handler handler2 = this.queueHandler;
        if (handler2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("queueHandler");
        }
        handler2.removeCallbacksAndMessages((Object) null);
        Handler handler3 = this.blacklistHandler;
        if (handler3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blacklistHandler");
        }
        handler3.removeCallbacksAndMessages((Object) null);
        this.workQueue.clear();
        this.blacklist.clear();
    }

    public final void unregisterReceivers() {
        try {
            this.localBroadcastManager.unregisterReceiver(this.deviceProcessedReceiver);
        } catch (Throwable th) {
            CentralLog.Companion companion = CentralLog.Companion;
            String str = this.TAG;
            companion.e(str, "Unable to close receivers: " + th.getLocalizedMessage());
        }
        try {
            this.localBroadcastManager.unregisterReceiver(this.workReceiver);
        } catch (Throwable th2) {
            CentralLog.Companion companion2 = CentralLog.Companion;
            String str2 = this.TAG;
            companion2.e(str2, "Unable to close receivers: " + th2.getLocalizedMessage());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lau/gov/health/covidsafe/streetpass/StreetPassWorker$DeviceProcessedReceiver;", "Landroid/content/BroadcastReceiver;", "(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: StreetPassWorker.kt */
    public final class DeviceProcessedReceiver extends BroadcastReceiver {
        public DeviceProcessedReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(intent, "intent");
            if (Intrinsics.areEqual((Object) GATTKt.ACTION_DEVICE_PROCESSED, (Object) intent.getAction())) {
                String stringExtra = intent.getStringExtra(GATTKt.DEVICE_ADDRESS);
                CentralLog.Companion companion = CentralLog.Companion;
                String access$getTAG$p = StreetPassWorker.this.TAG;
                companion.d(access$getTAG$p, "Adding to blacklist: " + stringExtra);
                BlacklistEntry blacklistEntry = new BlacklistEntry(stringExtra);
                StreetPassWorker.this.blacklist.add(blacklistEntry);
                StreetPassWorker.access$getBlacklistHandler$p(StreetPassWorker.this).postDelayed(new StreetPassWorker$DeviceProcessedReceiver$onReceive$1(this, blacklistEntry), 100000);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lau/gov/health/covidsafe/streetpass/StreetPassWorker$StreetPassWorkReceiver;", "Landroid/content/BroadcastReceiver;", "(Lau/gov/health/covidsafe/streetpass/StreetPassWorker;)V", "TAG", "", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: StreetPassWorker.kt */
    public final class StreetPassWorkReceiver extends BroadcastReceiver {
        private final String TAG = "StreetPassWorkReceiver";

        public StreetPassWorkReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && Intrinsics.areEqual((Object) StreetPassKt.ACTION_DEVICE_SCANNED, (Object) intent.getAction())) {
                BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                ConnectablePeripheral connectablePeripheral = (ConnectablePeripheral) intent.getParcelableExtra(GATTKt.CONNECTION_DATA);
                boolean z = true;
                boolean z2 = bluetoothDevice != null;
                if (connectablePeripheral == null) {
                    z = false;
                }
                CentralLog.Companion companion = CentralLog.Companion;
                String str = this.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("Device received: ");
                sb.append(bluetoothDevice != null ? bluetoothDevice.getAddress() : null);
                sb.append(". Device present: ");
                sb.append(z2);
                sb.append(", Connectable Present: ");
                sb.append(z);
                companion.i(str, sb.toString());
                if (bluetoothDevice != null && connectablePeripheral != null) {
                    if (StreetPassWorker.this.addWork(new Work(bluetoothDevice, connectablePeripheral, StreetPassWorker.this.getOnWorkTimeoutListener()))) {
                        StreetPassWorker.this.doWork();
                    }
                }
            }
        }
    }
}
