package au.gov.health.covidsafe.bluetooth.gatt;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattServerCallback;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import au.gov.health.covidsafe.TracerApp;
import au.gov.health.covidsafe.Utils;
import au.gov.health.covidsafe.logging.CentralLog;
import au.gov.health.covidsafe.streetpass.CentralDevice;
import au.gov.health.covidsafe.streetpass.ConnectionRecord;
import au.gov.health.covidsafe.streetpass.persistence.Encryption;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.Charsets;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001:\u0001\u001eJ,\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016JD\u0010\u0013\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0016J\"\u0010\u0018\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000fH\u0016J \u0010\u001b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u0015H\u0016J\u000e\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\u001f"}, d2 = {"au/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1", "Landroid/bluetooth/BluetoothGattServerCallback;", "readPayloadMap", "", "", "", "getReadPayloadMap", "()Ljava/util/Map;", "writeDataPayload", "getWriteDataPayload", "onCharacteristicReadRequest", "", "device", "Landroid/bluetooth/BluetoothDevice;", "requestId", "", "offset", "characteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "onCharacteristicWriteRequest", "preparedWrite", "", "responseNeeded", "value", "onConnectionStateChange", "status", "newState", "onExecuteWrite", "execute", "saveDataSaved", "ReadRequestEncryptedPayload", "app_release"}, k = 1, mv = {1, 1, 16})
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
            CentralLog.Companion companion = CentralLog.Companion;
            String access$getTAG$p = this.this$0.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append(bluetoothDevice != null ? bluetoothDevice.getAddress() : null);
            sb.append(" Disconnected from local GATT server.");
            companion.i(access$getTAG$p, sb.toString());
            Map<String, byte[]> map = this.readPayloadMap;
            if (bluetoothDevice != null) {
                str = bluetoothDevice.getAddress();
            }
            if (map != null) {
                TypeIntrinsics.asMutableMap(map).remove(str);
                if (bluetoothDevice != null) {
                    Utils.INSTANCE.broadcastDeviceDisconnected(this.this$0.getContext(), bluetoothDevice);
                    return;
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        } else if (i2 != 2) {
            CentralLog.Companion companion2 = CentralLog.Companion;
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
            CentralLog.Companion companion3 = CentralLog.Companion;
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
        int i3 = i;
        int i4 = i2;
        if (bluetoothDevice != null) {
            CentralLog.Companion companion = CentralLog.Companion;
            String access$getTAG$p = this.this$0.TAG;
            companion.i(access$getTAG$p, "onCharacteristicReadRequest from " + bluetoothDevice.getAddress());
            if (!Intrinsics.areEqual((Object) this.this$0.getServiceUUID(), (Object) bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getUuid() : null)) {
                CentralLog.Companion companion2 = CentralLog.Companion;
                String access$getTAG$p2 = this.this$0.TAG;
                companion2.i(access$getTAG$p2, "incorrect serviceUUID from " + bluetoothDevice.getAddress());
                BluetoothGattServer bluetoothGattServer = this.this$0.getBluetoothGattServer();
                if (bluetoothGattServer != null) {
                    bluetoothGattServer.sendResponse(bluetoothDevice, i, 0, 0, (byte[]) null);
                }
            } else if (Utils.INSTANCE.bmValid(this.this$0.getContext())) {
                String json = this.this$0.getGson().toJson((Object) new ReadRequestEncryptedPayload(this, TracerApp.Companion.asPeripheralDevice().getModelP(), TracerApp.Companion.thisDeviceMsg()));
                Intrinsics.checkExpressionValueIsNotNull(json, "plainRecord");
                Charset charset = Charsets.UTF_8;
                if (json != null) {
                    byte[] bytes = json.getBytes(charset);
                    Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
                    String encryptPayload = Encryption.INSTANCE.encryptPayload(bytes);
                    Map<String, byte[]> map = this.readPayloadMap;
                    String address = bluetoothDevice.getAddress();
                    Intrinsics.checkExpressionValueIsNotNull(address, "device.address");
                    byte[] bArr = map.get(address);
                    if (bArr == null) {
                        bArr = new ReadRequestPayload(2, encryptPayload, "AU_DTA", (String) null).getPayload();
                        map.put(address, bArr);
                    }
                    byte[] bArr2 = bArr;
                    byte[] copyOfRange = ArraysKt.copyOfRange(bArr2, i4, bArr2.length);
                    CentralLog.Companion companion3 = CentralLog.Companion;
                    String access$getTAG$p3 = this.this$0.TAG;
                    companion3.i(access$getTAG$p3, "onCharacteristicReadRequest from " + bluetoothDevice.getAddress() + " - " + i + "- " + i4 + " - " + new String(copyOfRange, Charsets.UTF_8));
                    BluetoothGattServer bluetoothGattServer2 = this.this$0.getBluetoothGattServer();
                    if (bluetoothGattServer2 != null) {
                        bluetoothGattServer2.sendResponse(bluetoothDevice, i, 0, 0, copyOfRange);
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            } else {
                CentralLog.Companion companion4 = CentralLog.Companion;
                String access$getTAG$p4 = this.this$0.TAG;
                companion4.i(access$getTAG$p4, "onCharacteristicReadRequest from " + bluetoothDevice.getAddress() + " - " + i + "- " + i4 + " - BM Expired");
                BluetoothGattServer bluetoothGattServer3 = this.this$0.getBluetoothGattServer();
                if (bluetoothGattServer3 != null) {
                    bluetoothGattServer3.sendResponse(bluetoothDevice, i, InputDeviceCompat.SOURCE_KEYBOARD, 0, new byte[0]);
                }
            }
        }
        if (bluetoothDevice == null) {
            CentralLog.Companion.i(this.this$0.TAG, "No device");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006*\u0001\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"au/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1.ReadRequestEncryptedPayload", "", "modelP", "", "msg", "(Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;Ljava/lang/String;Ljava/lang/String;)V", "getModelP", "()Ljava/lang/String;", "getMsg", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: GattServer.kt */
    public final class ReadRequestEncryptedPayload {
        private final String modelP;
        private final String msg;
        final /* synthetic */ GattServer$gattServerCallback$1 this$0;

        public ReadRequestEncryptedPayload(GattServer$gattServerCallback$1 gattServer$gattServerCallback$1, String str, String str2) {
            Intrinsics.checkParameterIsNotNull(str, "modelP");
            Intrinsics.checkParameterIsNotNull(str2, NotificationCompat.CATEGORY_MESSAGE);
            this.this$0 = gattServer$gattServerCallback$1;
            this.modelP = str;
            this.msg = str2;
        }

        public final String getModelP() {
            return this.modelP;
        }

        public final String getMsg() {
            return this.msg;
        }
    }

    public void onCharacteristicWriteRequest(BluetoothDevice bluetoothDevice, int i, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z, boolean z2, int i2, byte[] bArr) {
        boolean z3 = z;
        byte[] bArr2 = bArr;
        Intrinsics.checkParameterIsNotNull(bluetoothGattCharacteristic, "characteristic");
        if (bluetoothDevice != null) {
            CentralLog.Companion companion = CentralLog.Companion;
            String access$getTAG$p = this.this$0.TAG;
            companion.i(access$getTAG$p, "onCharacteristicWriteRequest - " + bluetoothDevice.getAddress() + " - preparedWrite: " + z3);
            CentralLog.Companion companion2 = CentralLog.Companion;
            String access$getTAG$p2 = this.this$0.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("onCharacteristicWriteRequest from ");
            sb.append(bluetoothDevice.getAddress());
            sb.append(" - ");
            int i3 = i;
            sb.append(i);
            sb.append(" - ");
            sb.append(i2);
            companion2.i(access$getTAG$p2, sb.toString());
            if (Intrinsics.areEqual((Object) this.this$0.getServiceUUID(), (Object) bluetoothGattCharacteristic.getUuid())) {
                String str = bArr2 != null ? new String(bArr2, Charsets.UTF_8) : "";
                CentralLog.Companion companion3 = CentralLog.Companion;
                String access$getTAG$p3 = this.this$0.TAG;
                companion3.i(access$getTAG$p3, "onCharacteristicWriteRequest from " + bluetoothDevice.getAddress() + " - " + str);
                if (bArr2 != null) {
                    byte[] bArr3 = this.writeDataPayload.get(bluetoothDevice.getAddress());
                    if (bArr3 == null) {
                        bArr3 = new byte[0];
                    }
                    byte[] plus = ArraysKt.plus(bArr3, bArr2);
                    Map<String, byte[]> map = this.writeDataPayload;
                    String address = bluetoothDevice.getAddress();
                    Intrinsics.checkExpressionValueIsNotNull(address, "device.address");
                    map.put(address, plus);
                    CentralLog.Companion companion4 = CentralLog.Companion;
                    String access$getTAG$p4 = this.this$0.TAG;
                    companion4.i(access$getTAG$p4, "Accumulated characteristic: " + new String(plus, Charsets.UTF_8));
                    if (z2) {
                        CentralLog.Companion companion5 = CentralLog.Companion;
                        String access$getTAG$p5 = this.this$0.TAG;
                        companion5.i(access$getTAG$p5, "Sending response offset: " + plus.length);
                        BluetoothGattServer bluetoothGattServer = this.this$0.getBluetoothGattServer();
                        if (bluetoothGattServer != null) {
                            bluetoothGattServer.sendResponse(bluetoothDevice, i, 0, plus.length, bArr);
                        }
                    }
                }
            } else {
                CentralLog.Companion companion6 = CentralLog.Companion;
                String access$getTAG$p6 = this.this$0.TAG;
                companion6.i(access$getTAG$p6, "no data from " + bluetoothDevice.getAddress());
                BluetoothGattServer bluetoothGattServer2 = this.this$0.getBluetoothGattServer();
                if (bluetoothGattServer2 != null) {
                    bluetoothGattServer2.sendResponse(bluetoothDevice, i, 0, 0, (byte[]) null);
                }
            }
            if (!z3) {
                CentralLog.Companion companion7 = CentralLog.Companion;
                String access$getTAG$p7 = this.this$0.TAG;
                companion7.i(access$getTAG$p7, "onCharacteristicWriteRequest - " + bluetoothDevice.getAddress() + " - preparedWrite: " + z3);
                saveDataSaved(bluetoothDevice);
                BluetoothGattServer bluetoothGattServer3 = this.this$0.getBluetoothGattServer();
                if (bluetoothGattServer3 != null) {
                    bluetoothGattServer3.sendResponse(bluetoothDevice, i, 0, 0, (byte[]) null);
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
        byte[] bArr = this.writeDataPayload.get(bluetoothDevice.getAddress());
        if (bArr != null) {
            CentralLog.Companion companion = CentralLog.Companion;
            String access$getTAG$p = this.this$0.TAG;
            companion.i(access$getTAG$p, "onExecuteWrite - " + i + "- " + bluetoothDevice.getAddress() + " - " + new String(bArr, Charsets.UTF_8));
            saveDataSaved(bluetoothDevice);
            BluetoothGattServer bluetoothGattServer = this.this$0.getBluetoothGattServer();
            if (bluetoothGattServer != null) {
                bluetoothGattServer.sendResponse(bluetoothDevice, i, 0, 0, (byte[]) null);
                return;
            }
            return;
        }
        BluetoothGattServer bluetoothGattServer2 = this.this$0.getBluetoothGattServer();
        if (bluetoothGattServer2 != null) {
            bluetoothGattServer2.sendResponse(bluetoothDevice, i, InputDeviceCompat.SOURCE_KEYBOARD, 0, (byte[]) null);
        }
    }

    public final void saveDataSaved(BluetoothDevice bluetoothDevice) {
        Intrinsics.checkParameterIsNotNull(bluetoothDevice, "device");
        byte[] bArr = this.writeDataPayload.get(bluetoothDevice.getAddress());
        if (bArr != null) {
            try {
                WriteRequestPayload createReadRequestPayload = WriteRequestPayload.Companion.createReadRequestPayload(bArr);
                Utils.INSTANCE.broadcastStreetPassReceived(this.this$0.getContext(), new ConnectionRecord(createReadRequestPayload.getV(), createReadRequestPayload.getMsg(), createReadRequestPayload.getOrg(), TracerApp.Companion.asPeripheralDevice(), new CentralDevice(createReadRequestPayload.getModelC(), bluetoothDevice.getAddress()), createReadRequestPayload.getRssi(), createReadRequestPayload.getTxPower()));
            } catch (Throwable th) {
                CentralLog.Companion companion = CentralLog.Companion;
                String access$getTAG$p = this.this$0.TAG;
                companion.e(access$getTAG$p, "Failed to save write payload - " + th.getMessage());
            }
            Utils utils = Utils.INSTANCE;
            Context context = this.this$0.getContext();
            String address = bluetoothDevice.getAddress();
            Intrinsics.checkExpressionValueIsNotNull(address, "device.address");
            utils.broadcastDeviceProcessed(context, address);
            this.writeDataPayload.remove(bluetoothDevice.getAddress());
            byte[] remove = this.readPayloadMap.remove(bluetoothDevice.getAddress());
        }
    }
}
