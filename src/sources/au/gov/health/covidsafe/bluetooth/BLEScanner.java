package au.gov.health.covidsafe.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.os.ParcelUuid;
import au.gov.health.covidsafe.Utils;
import au.gov.health.covidsafe.logging.CentralLog;
import java.util.ArrayList;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010 \u001a\u00020!2\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\"\u001a\u00020!R\u000e\u0010\t\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R+\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00038B@BX\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR+\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00078B@BX\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R+\u0010\u001a\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00058B@BX\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lau/gov/health/covidsafe/bluetooth/BLEScanner;", "", "context", "Landroid/content/Context;", "uuid", "", "reportDelay", "", "(Landroid/content/Context;Ljava/lang/String;J)V", "TAG", "<set-?>", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "context$delegate", "Lkotlin/properties/ReadWriteProperty;", "getReportDelay", "()J", "setReportDelay", "(J)V", "reportDelay$delegate", "scanCallback", "Landroid/bluetooth/le/ScanCallback;", "scanner", "Landroid/bluetooth/le/BluetoothLeScanner;", "serviceUUID", "getServiceUUID", "()Ljava/lang/String;", "setServiceUUID", "(Ljava/lang/String;)V", "serviceUUID$delegate", "startScan", "", "stopScan", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: BLEScanner.kt */
public final class BLEScanner {
    static final /* synthetic */ KProperty[] $$delegatedProperties;
    private final String TAG;
    private final ReadWriteProperty context$delegate = Delegates.INSTANCE.notNull();
    private final ReadWriteProperty reportDelay$delegate = Delegates.INSTANCE.notNull();
    private ScanCallback scanCallback;
    private BluetoothLeScanner scanner;
    private final ReadWriteProperty serviceUUID$delegate = Delegates.INSTANCE.notNull();

    static {
        Class<BLEScanner> cls = BLEScanner.class;
        $$delegatedProperties = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "serviceUUID", "getServiceUUID()Ljava/lang/String;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "context", "getContext()Landroid/content/Context;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "reportDelay", "getReportDelay()J"))};
    }

    private final Context getContext() {
        return (Context) this.context$delegate.getValue(this, $$delegatedProperties[1]);
    }

    private final long getReportDelay() {
        return ((Number) this.reportDelay$delegate.getValue(this, $$delegatedProperties[2])).longValue();
    }

    private final String getServiceUUID() {
        return (String) this.serviceUUID$delegate.getValue(this, $$delegatedProperties[0]);
    }

    private final void setContext(Context context) {
        this.context$delegate.setValue(this, $$delegatedProperties[1], context);
    }

    private final void setReportDelay(long j) {
        this.reportDelay$delegate.setValue(this, $$delegatedProperties[2], Long.valueOf(j));
    }

    private final void setServiceUUID(String str) {
        this.serviceUUID$delegate.setValue(this, $$delegatedProperties[0], str);
    }

    public BLEScanner(Context context, String str, long j) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "uuid");
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        Intrinsics.checkExpressionValueIsNotNull(defaultAdapter, "BluetoothAdapter.getDefaultAdapter()");
        this.scanner = defaultAdapter.getBluetoothLeScanner();
        this.TAG = "BLEScanner";
        setServiceUUID(str);
        setContext(context);
        setReportDelay(j);
    }

    public final void startScan(ScanCallback scanCallback2) {
        Intrinsics.checkParameterIsNotNull(scanCallback2, "scanCallback");
        ScanFilter build = new ScanFilter.Builder().setServiceUuid(new ParcelUuid(UUID.fromString(getServiceUUID()))).build();
        ArrayList arrayList = new ArrayList();
        arrayList.add(build);
        ScanSettings build2 = new ScanSettings.Builder().setReportDelay(getReportDelay()).setScanMode(2).build();
        this.scanCallback = scanCallback2;
        BluetoothLeScanner bluetoothLeScanner = this.scanner;
        if (bluetoothLeScanner == null) {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            Intrinsics.checkExpressionValueIsNotNull(defaultAdapter, "BluetoothAdapter.getDefaultAdapter()");
            bluetoothLeScanner = defaultAdapter.getBluetoothLeScanner();
        }
        this.scanner = bluetoothLeScanner;
        if (bluetoothLeScanner != null) {
            bluetoothLeScanner.startScan(arrayList, build2, scanCallback2);
        }
    }

    public final void stopScan() {
        try {
            if (this.scanCallback != null && Utils.INSTANCE.isBluetoothAvailable()) {
                BluetoothLeScanner bluetoothLeScanner = this.scanner;
                if (bluetoothLeScanner != null) {
                    bluetoothLeScanner.stopScan(this.scanCallback);
                }
                CentralLog.Companion.d(this.TAG, "scanning stopped");
            }
        } catch (Throwable th) {
            CentralLog.Companion companion = CentralLog.Companion;
            String str = this.TAG;
            companion.e(str, "unable to stop scanning - callback null or bluetooth off? : " + th.getLocalizedMessage());
        }
    }
}
