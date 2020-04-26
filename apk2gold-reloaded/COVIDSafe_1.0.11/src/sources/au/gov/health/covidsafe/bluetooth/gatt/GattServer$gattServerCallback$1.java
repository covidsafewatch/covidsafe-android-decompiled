package au.gov.health.covidsafe.bluetooth.gatt;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattServerCallback;
import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import au.gov.health.covidsafe.TracerApp;
import au.gov.health.covidsafe.Utils;
import au.gov.health.covidsafe.logging.CentralLog;
import au.gov.health.covidsafe.logging.CentralLog.Companion;
import au.gov.health.covidsafe.streetpass.CentralDevice;
import au.gov.health.covidsafe.streetpass.ConnectionRecord;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016JD\u0010\u0013\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0016J\"\u0010\u0018\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000fH\u0016J \u0010\u001b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u0015H\u0016J\u000e\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\u001e"}, d2 = {"au/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1", "Landroid/bluetooth/BluetoothGattServerCallback;", "readPayloadMap", "", "", "", "getReadPayloadMap", "()Ljava/util/Map;", "writeDataPayload", "getWriteDataPayload", "onCharacteristicReadRequest", "", "device", "Landroid/bluetooth/BluetoothDevice;", "requestId", "", "offset", "characteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "onCharacteristicWriteRequest", "preparedWrite", "", "responseNeeded", "value", "onConnectionStateChange", "status", "newState", "onExecuteWrite", "execute", "saveDataSaved", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: GattServer.kt */
public final class GattServer$gattServerCallback$1 extends BluetoothGattServerCallback {
    private final Map<String, byte[]> readPayloadMap = new HashMap();
    final /* synthetic */ GattServer this$0;
    private final Map<String, byte[]> writeDataPayload = new HashMap();

    GattServer$gattServerCallback$1(GattServer gattServer) {
        this.this$0 = gattServer;
    }

    public final Map<String, byte[]> getWriteDataPayload() {
        return this.writeDataPayload;
    }

    public final Map<String, byte[]> getReadPayloadMap() {
        return this.readPayloadMap;
    }

    public void onConnectionStateChange(BluetoothDevice bluetoothDevice, int i, int i2) {
        String str = null;
        if (i2 == 0) {
            Companion companion = CentralLog.Companion;
            String access$getTAG$p = this.this$0.TAG;
            StringBuilder sb = new StringBuilder();
            if (bluetoothDevice != null) {
                str = bluetoothDevice.getAddress();
            }
            sb.append(str);
            sb.append(" Disconnected from local GATT server.");
            companion.i(access$getTAG$p, sb.toString());
            if (bluetoothDevice != null) {
                Utils.INSTANCE.broadcastDeviceDisconnected(this.this$0.getContext(), bluetoothDevice);
            }
        } else if (i2 != 2) {
            Companion companion2 = CentralLog.Companion;
            String access$getTAG$p2 = this.this$0.TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Connection status: ");
            sb2.append(i2);
            sb2.append(" - ");
            if (bluetoothDevice != null) {
                str = bluetoothDevice.getAddress();
            }
            sb2.append(str);
            companion2.i(access$getTAG$p2, sb2.toString());
        } else {
            Companion companion3 = CentralLog.Companion;
            String access$getTAG$p3 = this.this$0.TAG;
            StringBuilder sb3 = new StringBuilder();
            if (bluetoothDevice != null) {
                str = bluetoothDevice.getAddress();
            }
            sb3.append(str);
            sb3.append(" Connected to local GATT server");
            companion3.i(access$getTAG$p3, sb3.toString());
            if (bluetoothDevice != null) {
                this.this$0.getBluetoothManager().getConnectedDevices(7).contains(bluetoothDevice);
            }
        }
    }

    public void onCharacteristicReadRequest(BluetoothDevice bluetoothDevice, int i, int i2, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (bluetoothDevice != null) {
            Companion companion = CentralLog.Companion;
            String access$getTAG$p = this.this$0.TAG;
            StringBuilder sb = new StringBuilder();
            String str = "onCharacteristicReadRequest from ";
            sb.append(str);
            sb.append(bluetoothDevice.getAddress());
            companion.i(access$getTAG$p, sb.toString());
            if (Intrinsics.areEqual((Object) this.this$0.getServiceUUID(), (Object) bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getUuid() : null)) {
                String str2 = "- ";
                String str3 = " - ";
                if (Utils.INSTANCE.bmValid(this.this$0.getContext())) {
                    Map<String, byte[]> map = this.readPayloadMap;
                    String address = bluetoothDevice.getAddress();
                    Intrinsics.checkExpressionValueIsNotNull(address, "device.address");
                    Object obj = map.get(address);
                    if (obj == null) {
                        obj = new ReadRequestPayload(1, TracerApp.Companion.thisDeviceMsg(), "AU_DTA", TracerApp.Companion.asPeripheralDevice()).getPayload();
                        map.put(address, obj);
                    }
                    byte[] bArr = (byte[]) obj;
                    byte[] copyOfRange = ArraysKt.copyOfRange(bArr, i2, bArr.length);
                    Companion companion2 = CentralLog.Companion;
                    String access$getTAG$p2 = this.this$0.TAG;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(bluetoothDevice.getAddress());
                    sb2.append(str3);
                    sb2.append(i);
                    sb2.append(str2);
                    sb2.append(i2);
                    sb2.append(str3);
                    sb2.append(new String(copyOfRange, Charsets.UTF_8));
                    companion2.i(access$getTAG$p2, sb2.toString());
                    BluetoothGattServer bluetoothGattServer = this.this$0.getBluetoothGattServer();
                    if (bluetoothGattServer != null) {
                        bluetoothGattServer.sendResponse(bluetoothDevice, i, 0, 0, copyOfRange);
                    }
                } else {
                    Companion companion3 = CentralLog.Companion;
                    String access$getTAG$p3 = this.this$0.TAG;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str);
                    sb3.append(bluetoothDevice.getAddress());
                    sb3.append(str3);
                    sb3.append(i);
                    sb3.append(str2);
                    sb3.append(i2);
                    sb3.append(" - BM Expired");
                    companion3.i(access$getTAG$p3, sb3.toString());
                    BluetoothGattServer bluetoothGattServer2 = this.this$0.getBluetoothGattServer();
                    if (bluetoothGattServer2 != null) {
                        bluetoothGattServer2.sendResponse(bluetoothDevice, i, InputDeviceCompat.SOURCE_KEYBOARD, 0, new byte[0]);
                    }
                }
            } else {
                Companion companion4 = CentralLog.Companion;
                String access$getTAG$p4 = this.this$0.TAG;
                StringBuilder sb4 = new StringBuilder();
                sb4.append("incorrect serviceUUID from ");
                sb4.append(bluetoothDevice.getAddress());
                companion4.i(access$getTAG$p4, sb4.toString());
                BluetoothGattServer bluetoothGattServer3 = this.this$0.getBluetoothGattServer();
                if (bluetoothGattServer3 != null) {
                    bluetoothGattServer3.sendResponse(bluetoothDevice, i, 0, 0, null);
                }
            }
        }
        if (bluetoothDevice == null) {
            CentralLog.Companion.i(this.this$0.TAG, "No device");
        }
    }

    public void onCharacteristicWriteRequest(BluetoothDevice bluetoothDevice, int i, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z, boolean z2, int i2, byte[] bArr) {
        boolean z3 = z;
        byte[] bArr2 = bArr;
        Intrinsics.checkParameterIsNotNull(bluetoothGattCharacteristic, "characteristic");
        if (bluetoothDevice != null) {
            Companion companion = CentralLog.Companion;
            String access$getTAG$p = this.this$0.TAG;
            StringBuilder sb = new StringBuilder();
            String str = "onCharacteristicWriteRequest - ";
            sb.append(str);
            sb.append(bluetoothDevice.getAddress());
            String str2 = " - preparedWrite: ";
            sb.append(str2);
            sb.append(z3);
            companion.i(access$getTAG$p, sb.toString());
            Companion companion2 = CentralLog.Companion;
            String access$getTAG$p2 = this.this$0.TAG;
            StringBuilder sb2 = new StringBuilder();
            String str3 = "onCharacteristicWriteRequest from ";
            sb2.append(str3);
            sb2.append(bluetoothDevice.getAddress());
            String str4 = " - ";
            sb2.append(str4);
            int i3 = i;
            sb2.append(i);
            sb2.append(str4);
            sb2.append(i2);
            companion2.i(access$getTAG$p2, sb2.toString());
            if (Intrinsics.areEqual((Object) this.this$0.getServiceUUID(), (Object) bluetoothGattCharacteristic.getUuid())) {
                String str5 = bArr2 != null ? new String(bArr2, Charsets.UTF_8) : "";
                Companion companion3 = CentralLog.Companion;
                String access$getTAG$p3 = this.this$0.TAG;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str3);
                sb3.append(bluetoothDevice.getAddress());
                sb3.append(str4);
                sb3.append(str5);
                companion3.i(access$getTAG$p3, sb3.toString());
                if (bArr2 != null) {
                    byte[] bArr3 = (byte[]) this.writeDataPayload.get(bluetoothDevice.getAddress());
                    if (bArr3 == null) {
                        bArr3 = new byte[0];
                    }
                    byte[] plus = ArraysKt.plus(bArr3, bArr2);
                    Map<String, byte[]> map = this.writeDataPayload;
                    String address = bluetoothDevice.getAddress();
                    Intrinsics.checkExpressionValueIsNotNull(address, "device.address");
                    map.put(address, plus);
                    Companion companion4 = CentralLog.Companion;
                    String access$getTAG$p4 = this.this$0.TAG;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Accumulated characteristic: ");
                    sb4.append(new String(plus, Charsets.UTF_8));
                    companion4.i(access$getTAG$p4, sb4.toString());
                    if (z2) {
                        Companion companion5 = CentralLog.Companion;
                        String access$getTAG$p5 = this.this$0.TAG;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("Sending response offset: ");
                        sb5.append(plus.length);
                        companion5.i(access$getTAG$p5, sb5.toString());
                        BluetoothGattServer bluetoothGattServer = this.this$0.getBluetoothGattServer();
                        if (bluetoothGattServer != null) {
                            bluetoothGattServer.sendResponse(bluetoothDevice, i, 0, plus.length, bArr);
                        }
                    }
                }
            } else {
                Companion companion6 = CentralLog.Companion;
                String access$getTAG$p6 = this.this$0.TAG;
                StringBuilder sb6 = new StringBuilder();
                sb6.append("no data from ");
                sb6.append(bluetoothDevice.getAddress());
                companion6.i(access$getTAG$p6, sb6.toString());
                BluetoothGattServer bluetoothGattServer2 = this.this$0.getBluetoothGattServer();
                if (bluetoothGattServer2 != null) {
                    bluetoothGattServer2.sendResponse(bluetoothDevice, i, 0, 0, null);
                }
            }
            if (!z3) {
                Companion companion7 = CentralLog.Companion;
                String access$getTAG$p7 = this.this$0.TAG;
                StringBuilder sb7 = new StringBuilder();
                sb7.append(str);
                sb7.append(bluetoothDevice.getAddress());
                sb7.append(str2);
                sb7.append(z3);
                companion7.i(access$getTAG$p7, sb7.toString());
                saveDataSaved(bluetoothDevice);
                BluetoothGattServer bluetoothGattServer3 = this.this$0.getBluetoothGattServer();
                if (bluetoothGattServer3 != null) {
                    bluetoothGattServer3.sendResponse(bluetoothDevice, i, 0, 0, null);
                }
            }
        }
        if (bluetoothDevice == null) {
            CentralLog.Companion.e(this.this$0.TAG, "Write stopped - no device");
        }
    }

    public void onExecuteWrite(BluetoothDevice bluetoothDevice, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(bluetoothDevice, "device");
        super.onExecuteWrite(bluetoothDevice, i, z);
        byte[] bArr = (byte[]) this.writeDataPayload.get(bluetoothDevice.getAddress());
        if (bArr != null) {
            Companion companion = CentralLog.Companion;
            String access$getTAG$p = this.this$0.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("onExecuteWrite - ");
            sb.append(i);
            sb.append("- ");
            sb.append(bluetoothDevice.getAddress());
            sb.append(" - ");
            sb.append(new String(bArr, Charsets.UTF_8));
            companion.i(access$getTAG$p, sb.toString());
            saveDataSaved(bluetoothDevice);
            BluetoothGattServer bluetoothGattServer = this.this$0.getBluetoothGattServer();
            if (bluetoothGattServer != null) {
                bluetoothGattServer.sendResponse(bluetoothDevice, i, 0, 0, null);
                return;
            }
            return;
        }
        BluetoothGattServer bluetoothGattServer2 = this.this$0.getBluetoothGattServer();
        if (bluetoothGattServer2 != null) {
            bluetoothGattServer2.sendResponse(bluetoothDevice, i, InputDeviceCompat.SOURCE_KEYBOARD, 0, null);
        }
    }

    public final void saveDataSaved(BluetoothDevice bluetoothDevice) {
        Intrinsics.checkParameterIsNotNull(bluetoothDevice, "device");
        byte[] bArr = (byte[]) this.writeDataPayload.get(bluetoothDevice.getAddress());
        if (bArr != null) {
            try {
                WriteRequestPayload createReadRequestPayload = WriteRequestPayload.Companion.createReadRequestPayload(bArr);
                ConnectionRecord connectionRecord = new ConnectionRecord(createReadRequestPayload.getV(), createReadRequestPayload.getMsg(), createReadRequestPayload.getOrg(), TracerApp.Companion.asPeripheralDevice(), new CentralDevice(createReadRequestPayload.getModelC(), bluetoothDevice.getAddress()), createReadRequestPayload.getRssi(), createReadRequestPayload.getTxPower());
                Utils.INSTANCE.broadcastStreetPassReceived(this.this$0.getContext(), connectionRecord);
            } catch (Throwable th) {
                Companion companion = CentralLog.Companion;
                String access$getTAG$p = this.this$0.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to save write payload - ");
                sb.append(th.getMessage());
                companion.e(access$getTAG$p, sb.toString());
            }
            Utils utils = Utils.INSTANCE;
            Context context = this.this$0.getContext();
            String address = bluetoothDevice.getAddress();
            Intrinsics.checkExpressionValueIsNotNull(address, "device.address");
            utils.broadcastDeviceProcessed(context, address);
            this.writeDataPayload.remove(bluetoothDevice.getAddress());
            byte[] bArr2 = (byte[]) this.readPayloadMap.remove(bluetoothDevice.getAddress());
        }
    }
}
