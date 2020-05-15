package au.gov.health.covidsafe.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.os.Handler;
import android.os.ParcelUuid;
import au.gov.health.covidsafe.logging.CentralLog;
import java.nio.charset.Charset;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\u0010\u0010&\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010'\u001a\u00020#H\u0002R\u000e\u0010\u0005\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0016\"\u0004\b\u001f\u0010\u0018R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;", "", "serviceUUID", "", "(Ljava/lang/String;)V", "TAG", "advertiser", "Landroid/bluetooth/le/BluetoothLeAdvertiser;", "callback", "Landroid/bluetooth/le/AdvertiseCallback;", "charLength", "", "data", "Landroid/bluetooth/le/AdvertiseData;", "getData", "()Landroid/bluetooth/le/AdvertiseData;", "setData", "(Landroid/bluetooth/le/AdvertiseData;)V", "handler", "Landroid/os/Handler;", "isAdvertising", "", "()Z", "setAdvertising", "(Z)V", "pUuid", "Landroid/os/ParcelUuid;", "settings", "Landroid/bluetooth/le/AdvertiseSettings;", "shouldBeAdvertising", "getShouldBeAdvertising", "setShouldBeAdvertising", "stopRunnable", "Ljava/lang/Runnable;", "startAdvertising", "", "timeoutInMillis", "", "startAdvertisingLegacy", "stopAdvertising", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: BLEAdvertiser.kt */
public final class BLEAdvertiser {
    /* access modifiers changed from: private */
    public final String TAG = "BLEAdvertiser";
    private BluetoothLeAdvertiser advertiser;
    private AdvertiseCallback callback = new BLEAdvertiser$callback$1(this);
    /* access modifiers changed from: private */
    public int charLength = 3;
    private AdvertiseData data;
    private Handler handler;
    private boolean isAdvertising;
    private final ParcelUuid pUuid;
    private final AdvertiseSettings settings;
    private boolean shouldBeAdvertising;
    private Runnable stopRunnable;

    public BLEAdvertiser(String str) {
        Intrinsics.checkParameterIsNotNull(str, "serviceUUID");
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        Intrinsics.checkExpressionValueIsNotNull(defaultAdapter, "BluetoothAdapter.getDefaultAdapter()");
        this.advertiser = defaultAdapter.getBluetoothLeAdvertiser();
        this.pUuid = new ParcelUuid(UUID.fromString(str));
        this.settings = new AdvertiseSettings.Builder().setTxPowerLevel(3).setAdvertiseMode(2).setConnectable(true).setTimeout(0).build();
        this.handler = new Handler();
        this.stopRunnable = new BLEAdvertiser$stopRunnable$1(this);
    }

    public final AdvertiseData getData() {
        return this.data;
    }

    public final void setData(AdvertiseData advertiseData) {
        this.data = advertiseData;
    }

    public final boolean isAdvertising() {
        return this.isAdvertising;
    }

    public final void setAdvertising(boolean z) {
        this.isAdvertising = z;
    }

    public final boolean getShouldBeAdvertising() {
        return this.shouldBeAdvertising;
    }

    public final void setShouldBeAdvertising(boolean z) {
        this.shouldBeAdvertising = z;
    }

    private final void startAdvertisingLegacy(long j) {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkExpressionValueIsNotNull(uuid, "UUID.randomUUID().toString()");
        int length = uuid.length() - this.charLength;
        int length2 = uuid.length();
        if (uuid != null) {
            String substring = uuid.substring(length, length2);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            CentralLog.Companion companion = CentralLog.Companion;
            String str = this.TAG;
            companion.d(str, "Unique string: " + substring);
            Charset charset = Charsets.UTF_8;
            if (substring != null) {
                byte[] bytes = substring.getBytes(charset);
                Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
                if (this.data == null) {
                    this.data = new AdvertiseData.Builder().setIncludeDeviceName(false).setIncludeTxPowerLevel(true).addServiceUuid(this.pUuid).addManufacturerData(1023, bytes).build();
                }
                try {
                    CentralLog.Companion.d(this.TAG, "Start advertising");
                    BluetoothLeAdvertiser bluetoothLeAdvertiser = this.advertiser;
                    if (bluetoothLeAdvertiser == null) {
                        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                        Intrinsics.checkExpressionValueIsNotNull(defaultAdapter, "BluetoothAdapter.getDefaultAdapter()");
                        bluetoothLeAdvertiser = defaultAdapter.getBluetoothLeAdvertiser();
                    }
                    this.advertiser = bluetoothLeAdvertiser;
                    if (bluetoothLeAdvertiser != null) {
                        bluetoothLeAdvertiser.startAdvertising(this.settings, this.data, this.callback);
                    }
                } catch (Throwable th) {
                    CentralLog.Companion companion2 = CentralLog.Companion;
                    String str2 = this.TAG;
                    companion2.e(str2, "Failed to start advertising legacy: " + th.getMessage());
                }
                this.handler.removeCallbacksAndMessages(this.stopRunnable);
                this.handler.postDelayed(this.stopRunnable, j);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public final void startAdvertising(long j) {
        startAdvertisingLegacy(j);
        this.shouldBeAdvertising = true;
    }

    /* access modifiers changed from: private */
    public final void stopAdvertising() {
        try {
            CentralLog.Companion.d(this.TAG, "stop advertising");
            BluetoothLeAdvertiser bluetoothLeAdvertiser = this.advertiser;
            if (bluetoothLeAdvertiser != null) {
                bluetoothLeAdvertiser.stopAdvertising(this.callback);
            }
        } catch (Throwable th) {
            CentralLog.Companion companion = CentralLog.Companion;
            String str = this.TAG;
            companion.e(str, "Failed to stop advertising: " + th.getMessage());
        }
        this.shouldBeAdvertising = false;
        this.handler.removeCallbacksAndMessages((Object) null);
    }
}
