package au.gov.health.covidsafe.bluetooth.gatt;

import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import au.gov.health.covidsafe.logging.CentralLog;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u001a\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020$R\u000e\u0010\u0007\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f8B@BX\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0004\n\u0002\u0010\u001bR+\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u000e\u001a\u00020\u001c8B@BX\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u0016\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006*"}, d2 = {"Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;", "", "context", "Landroid/content/Context;", "serviceUUIDString", "", "(Landroid/content/Context;Ljava/lang/String;)V", "TAG", "bluetoothGattServer", "Landroid/bluetooth/BluetoothGattServer;", "getBluetoothGattServer", "()Landroid/bluetooth/BluetoothGattServer;", "setBluetoothGattServer", "(Landroid/bluetooth/BluetoothGattServer;)V", "<set-?>", "Landroid/bluetooth/BluetoothManager;", "bluetoothManager", "getBluetoothManager", "()Landroid/bluetooth/BluetoothManager;", "setBluetoothManager", "(Landroid/bluetooth/BluetoothManager;)V", "bluetoothManager$delegate", "Lkotlin/properties/ReadWriteProperty;", "getContext", "()Landroid/content/Context;", "gattServerCallback", "au/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1", "Lau/gov/health/covidsafe/bluetooth/gatt/GattServer$gattServerCallback$1;", "Ljava/util/UUID;", "serviceUUID", "getServiceUUID", "()Ljava/util/UUID;", "setServiceUUID", "(Ljava/util/UUID;)V", "serviceUUID$delegate", "addService", "", "service", "Lau/gov/health/covidsafe/bluetooth/gatt/GattService;", "startServer", "", "stop", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: GattServer.kt */
public final class GattServer {
    static final /* synthetic */ KProperty[] $$delegatedProperties;
    /* access modifiers changed from: private */
    public final String TAG = "GattServer";
    private BluetoothGattServer bluetoothGattServer;
    private final ReadWriteProperty bluetoothManager$delegate = Delegates.INSTANCE.notNull();
    private final Context context;
    private final GattServer$gattServerCallback$1 gattServerCallback;
    private final ReadWriteProperty serviceUUID$delegate = Delegates.INSTANCE.notNull();

    static {
        Class<GattServer> cls = GattServer.class;
        $$delegatedProperties = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "bluetoothManager", "getBluetoothManager()Landroid/bluetooth/BluetoothManager;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "serviceUUID", "getServiceUUID()Ljava/util/UUID;"))};
    }

    /* access modifiers changed from: private */
    public final BluetoothManager getBluetoothManager() {
        return (BluetoothManager) this.bluetoothManager$delegate.getValue(this, $$delegatedProperties[0]);
    }

    /* access modifiers changed from: private */
    public final UUID getServiceUUID() {
        return (UUID) this.serviceUUID$delegate.getValue(this, $$delegatedProperties[1]);
    }

    /* access modifiers changed from: private */
    public final void setBluetoothManager(BluetoothManager bluetoothManager) {
        this.bluetoothManager$delegate.setValue(this, $$delegatedProperties[0], bluetoothManager);
    }

    /* access modifiers changed from: private */
    public final void setServiceUUID(UUID uuid) {
        this.serviceUUID$delegate.setValue(this, $$delegatedProperties[1], uuid);
    }

    public GattServer(Context context2, String str) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(str, "serviceUUIDString");
        this.context = context2;
        Object systemService = this.context.getSystemService("bluetooth");
        if (systemService != null) {
            setBluetoothManager((BluetoothManager) systemService);
            UUID fromString = UUID.fromString(str);
            Intrinsics.checkExpressionValueIsNotNull(fromString, "UUID.fromString(serviceUUIDString)");
            setServiceUUID(fromString);
            this.gattServerCallback = new GattServer$gattServerCallback$1(this);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.bluetooth.BluetoothManager");
    }

    public final Context getContext() {
        return this.context;
    }

    public final BluetoothGattServer getBluetoothGattServer() {
        return this.bluetoothGattServer;
    }

    public final void setBluetoothGattServer(BluetoothGattServer bluetoothGattServer2) {
        this.bluetoothGattServer = bluetoothGattServer2;
    }

    public final boolean startServer() {
        BluetoothGattServer openGattServer = getBluetoothManager().openGattServer(this.context, this.gattServerCallback);
        this.bluetoothGattServer = openGattServer;
        if (openGattServer == null) {
            return false;
        }
        openGattServer.clearServices();
        return true;
    }

    public final void addService(GattService gattService) {
        Intrinsics.checkParameterIsNotNull(gattService, NotificationCompat.CATEGORY_SERVICE);
        BluetoothGattServer bluetoothGattServer2 = this.bluetoothGattServer;
        if (bluetoothGattServer2 != null) {
            bluetoothGattServer2.addService(gattService.getGattService());
        }
    }

    public final void stop() {
        try {
            BluetoothGattServer bluetoothGattServer2 = this.bluetoothGattServer;
            if (bluetoothGattServer2 != null) {
                bluetoothGattServer2.clearServices();
            }
            BluetoothGattServer bluetoothGattServer3 = this.bluetoothGattServer;
            if (bluetoothGattServer3 != null) {
                bluetoothGattServer3.close();
            }
        } catch (Throwable th) {
            CentralLog.Companion companion = CentralLog.Companion;
            String str = this.TAG;
            companion.e(str, "GATT server can't be closed elegantly " + th.getLocalizedMessage());
        }
    }
}
