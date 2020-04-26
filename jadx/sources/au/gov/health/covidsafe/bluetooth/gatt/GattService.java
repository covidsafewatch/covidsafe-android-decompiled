package au.gov.health.covidsafe.bluetooth.gatt;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.Charsets;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8B@BX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR+\u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00128F@FX\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001aX\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lau/gov/health/covidsafe/bluetooth/gatt/GattService;", "", "context", "Landroid/content/Context;", "serviceUUIDString", "", "(Landroid/content/Context;Ljava/lang/String;)V", "getContext", "()Landroid/content/Context;", "<set-?>", "Landroid/bluetooth/BluetoothGattCharacteristic;", "devicePropertyCharacteristic", "getDevicePropertyCharacteristic", "()Landroid/bluetooth/BluetoothGattCharacteristic;", "setDevicePropertyCharacteristic", "(Landroid/bluetooth/BluetoothGattCharacteristic;)V", "devicePropertyCharacteristic$delegate", "Lkotlin/properties/ReadWriteProperty;", "Landroid/bluetooth/BluetoothGattService;", "gattService", "getGattService", "()Landroid/bluetooth/BluetoothGattService;", "setGattService", "(Landroid/bluetooth/BluetoothGattService;)V", "gattService$delegate", "serviceUUID", "Ljava/util/UUID;", "kotlin.jvm.PlatformType", "setValue", "", "value", "", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: GattService.kt */
public final class GattService {
    static final /* synthetic */ KProperty[] $$delegatedProperties;
    private final Context context;
    private final ReadWriteProperty devicePropertyCharacteristic$delegate = Delegates.INSTANCE.notNull();
    private final ReadWriteProperty gattService$delegate = Delegates.INSTANCE.notNull();
    private UUID serviceUUID;

    static {
        Class<GattService> cls = GattService.class;
        $$delegatedProperties = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "gattService", "getGattService()Landroid/bluetooth/BluetoothGattService;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "devicePropertyCharacteristic", "getDevicePropertyCharacteristic()Landroid/bluetooth/BluetoothGattCharacteristic;"))};
    }

    private final BluetoothGattCharacteristic getDevicePropertyCharacteristic() {
        return (BluetoothGattCharacteristic) this.devicePropertyCharacteristic$delegate.getValue(this, $$delegatedProperties[1]);
    }

    private final void setDevicePropertyCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.devicePropertyCharacteristic$delegate.setValue(this, $$delegatedProperties[1], bluetoothGattCharacteristic);
    }

    public final BluetoothGattService getGattService() {
        return (BluetoothGattService) this.gattService$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final void setGattService(BluetoothGattService bluetoothGattService) {
        Intrinsics.checkParameterIsNotNull(bluetoothGattService, "<set-?>");
        this.gattService$delegate.setValue(this, $$delegatedProperties[0], bluetoothGattService);
    }

    public GattService(Context context2, String str) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(str, "serviceUUIDString");
        this.context = context2;
        this.serviceUUID = UUID.fromString(str);
        setGattService(new BluetoothGattService(this.serviceUUID, 0));
        setDevicePropertyCharacteristic(new BluetoothGattCharacteristic(this.serviceUUID, 10, 17));
        getGattService().addCharacteristic(getDevicePropertyCharacteristic());
    }

    public final Context getContext() {
        return this.context;
    }

    public final void setValue(String str) {
        Intrinsics.checkParameterIsNotNull(str, "value");
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        setValue(bytes);
    }

    public final void setValue(byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "value");
        getDevicePropertyCharacteristic().setValue(bArr);
    }
}
