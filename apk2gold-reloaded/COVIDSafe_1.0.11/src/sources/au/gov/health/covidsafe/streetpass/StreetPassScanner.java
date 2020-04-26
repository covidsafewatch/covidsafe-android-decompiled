package au.gov.health.covidsafe.streetpass;

import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.os.Handler;
import au.gov.health.covidsafe.Utils;
import au.gov.health.covidsafe.bluetooth.BLEScanner;
import au.gov.health.covidsafe.logging.CentralLog;
import au.gov.health.covidsafe.logging.CentralLog.Companion;
import au.gov.health.covidsafe.status.Status;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001'B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020%R\u000e\u0010\t\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R+\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00038B@BX\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00060\u0014R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R+\u0010\u0016\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u00158B@BX\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006("}, d2 = {"Lau/gov/health/covidsafe/streetpass/StreetPassScanner;", "", "context", "Landroid/content/Context;", "serviceUUIDString", "", "scanDurationInMillis", "", "(Landroid/content/Context;Ljava/lang/String;J)V", "TAG", "<set-?>", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "context$delegate", "Lkotlin/properties/ReadWriteProperty;", "handler", "Landroid/os/Handler;", "scanCallback", "Lau/gov/health/covidsafe/streetpass/StreetPassScanner$BleScanCallback;", "Lau/gov/health/covidsafe/bluetooth/BLEScanner;", "scanner", "getScanner", "()Lau/gov/health/covidsafe/bluetooth/BLEScanner;", "setScanner", "(Lau/gov/health/covidsafe/bluetooth/BLEScanner;)V", "scanner$delegate", "scannerCount", "", "getScannerCount", "()I", "setScannerCount", "(I)V", "isScanning", "", "startScan", "", "stopScan", "BleScanCallback", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: StreetPassScanner.kt */
public final class StreetPassScanner {
    static final /* synthetic */ KProperty[] $$delegatedProperties;
    private final String TAG = "StreetPassScanner";
    private final ReadWriteProperty context$delegate = Delegates.INSTANCE.notNull();
    private Handler handler = new Handler();
    private final BleScanCallback scanCallback = new BleScanCallback();
    private final long scanDurationInMillis;
    private final ReadWriteProperty scanner$delegate = Delegates.INSTANCE.notNull();
    private int scannerCount;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lau/gov/health/covidsafe/streetpass/StreetPassScanner$BleScanCallback;", "Landroid/bluetooth/le/ScanCallback;", "(Lau/gov/health/covidsafe/streetpass/StreetPassScanner;)V", "TAG", "", "onScanFailed", "", "errorCode", "", "onScanResult", "callbackType", "result", "Landroid/bluetooth/le/ScanResult;", "processScanResult", "scanResult", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: StreetPassScanner.kt */
    public final class BleScanCallback extends ScanCallback {
        private final String TAG = "BleScanCallback";

        public BleScanCallback() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0031, code lost:
            if (r7 != null) goto L_0x0041;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void processScanResult(android.bluetooth.le.ScanResult r7) {
            /*
                r6 = this;
                if (r7 == 0) goto L_0x0081
                android.bluetooth.BluetoothDevice r0 = r7.getDevice()
                int r1 = r7.getRssi()
                r2 = 0
                java.lang.Integer r2 = (java.lang.Integer) r2
                int r3 = android.os.Build.VERSION.SDK_INT
                r4 = 26
                if (r3 < r4) goto L_0x0025
                int r3 = r7.getTxPower()
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                int r4 = r3.intValue()
                r5 = 127(0x7f, float:1.78E-43)
                if (r4 != r5) goto L_0x0024
                goto L_0x0025
            L_0x0024:
                r2 = r3
            L_0x0025:
                android.bluetooth.le.ScanRecord r7 = r7.getScanRecord()
                if (r7 == 0) goto L_0x0034
                r3 = 1023(0x3ff, float:1.434E-42)
                byte[] r7 = r7.getManufacturerSpecificData(r3)
                if (r7 == 0) goto L_0x0034
                goto L_0x0041
            L_0x0034:
                java.nio.charset.Charset r7 = kotlin.text.Charsets.UTF_8
                java.lang.String r3 = "N.A"
                byte[] r7 = r3.getBytes(r7)
                java.lang.String r3 = "(this as java.lang.String).getBytes(charset)"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r3)
            L_0x0041:
                java.nio.charset.Charset r3 = kotlin.text.Charsets.UTF_8
                java.lang.String r4 = new java.lang.String
                r4.<init>(r7, r3)
                au.gov.health.covidsafe.streetpass.ConnectablePeripheral r7 = new au.gov.health.covidsafe.streetpass.ConnectablePeripheral
                r7.<init>(r2, r1)
                au.gov.health.covidsafe.logging.CentralLog$Companion r1 = au.gov.health.covidsafe.logging.CentralLog.Companion
                java.lang.String r2 = r6.TAG
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r5 = "Scanned: "
                r3.append(r5)
                r3.append(r4)
                java.lang.String r4 = " - "
                r3.append(r4)
                java.lang.String r4 = "device"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r4)
                java.lang.String r4 = r0.getAddress()
                r3.append(r4)
                java.lang.String r3 = r3.toString()
                r1.i(r2, r3)
                au.gov.health.covidsafe.Utils r1 = au.gov.health.covidsafe.Utils.INSTANCE
                au.gov.health.covidsafe.streetpass.StreetPassScanner r2 = au.gov.health.covidsafe.streetpass.StreetPassScanner.this
                android.content.Context r2 = r2.getContext()
                r1.broadcastDeviceScanned(r2, r0, r7)
            L_0x0081:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: au.gov.health.covidsafe.streetpass.StreetPassScanner.BleScanCallback.processScanResult(android.bluetooth.le.ScanResult):void");
        }

        public void onScanResult(int i, ScanResult scanResult) {
            super.onScanResult(i, scanResult);
            processScanResult(scanResult);
        }

        public void onScanFailed(int i) {
            String str;
            super.onScanFailed(i);
            if (i == 1) {
                StringBuilder sb = new StringBuilder();
                sb.append(i);
                sb.append(" - SCAN_FAILED_ALREADY_STARTED");
                str = sb.toString();
            } else if (i == 2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i);
                sb2.append(" - SCAN_FAILED_APPLICATION_REGISTRATION_FAILED");
                str = sb2.toString();
            } else if (i == 3) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(i);
                sb3.append(" - SCAN_FAILED_INTERNAL_ERROR");
                str = sb3.toString();
            } else if (i != 4) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(i);
                sb4.append(" - UNDOCUMENTED");
                str = sb4.toString();
            } else {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(i);
                sb5.append(" - SCAN_FAILED_FEATURE_UNSUPPORTED");
                str = sb5.toString();
            }
            Companion companion = CentralLog.Companion;
            String str2 = this.TAG;
            StringBuilder sb6 = new StringBuilder();
            sb6.append("BT Scan failed: ");
            sb6.append(str);
            companion.e(str2, sb6.toString());
            if (StreetPassScanner.this.getScannerCount() > 0) {
                StreetPassScanner streetPassScanner = StreetPassScanner.this;
                streetPassScanner.setScannerCount(streetPassScanner.getScannerCount() - 1);
            }
        }
    }

    static {
        Class<StreetPassScanner> cls = StreetPassScanner.class;
        $$delegatedProperties = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "scanner", "getScanner()Lau/gov/health/covidsafe/bluetooth/BLEScanner;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "context", "getContext()Landroid/content/Context;"))};
    }

    /* access modifiers changed from: private */
    public final Context getContext() {
        return (Context) this.context$delegate.getValue(this, $$delegatedProperties[1]);
    }

    private final BLEScanner getScanner() {
        return (BLEScanner) this.scanner$delegate.getValue(this, $$delegatedProperties[0]);
    }

    /* access modifiers changed from: private */
    public final void setContext(Context context) {
        this.context$delegate.setValue(this, $$delegatedProperties[1], context);
    }

    private final void setScanner(BLEScanner bLEScanner) {
        this.scanner$delegate.setValue(this, $$delegatedProperties[0], bLEScanner);
    }

    public StreetPassScanner(Context context, String str, long j) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "serviceUUIDString");
        this.scanDurationInMillis = j;
        setScanner(new BLEScanner(context, str, 0));
        setContext(context);
    }

    public final int getScannerCount() {
        return this.scannerCount;
    }

    public final void setScannerCount(int i) {
        this.scannerCount = i;
    }

    public final void startScan() {
        Utils.INSTANCE.broadcastStatusReceived(getContext(), new Status("Scanning Started"));
        getScanner().startScan(this.scanCallback);
        this.scannerCount++;
        this.handler.postDelayed(new StreetPassScanner$startScan$1(this), this.scanDurationInMillis);
        CentralLog.Companion.d(this.TAG, "scanning started");
    }

    public final void stopScan() {
        if (this.scannerCount > 0) {
            Utils.INSTANCE.broadcastStatusReceived(getContext(), new Status("Scanning Stopped"));
            this.scannerCount--;
            getScanner().stopScan();
        }
    }

    public final boolean isScanning() {
        return this.scannerCount > 0;
    }
}
