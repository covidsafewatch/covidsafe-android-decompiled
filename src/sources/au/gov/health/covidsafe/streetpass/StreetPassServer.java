package au.gov.health.covidsafe.streetpass;

import android.content.Context;
import au.gov.health.covidsafe.bluetooth.gatt.GattServer;
import au.gov.health.covidsafe.bluetooth.gatt.GattService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0007\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lau/gov/health/covidsafe/streetpass/StreetPassServer;", "", "context", "Landroid/content/Context;", "serviceUUIDString", "", "(Landroid/content/Context;Ljava/lang/String;)V", "TAG", "getContext", "()Landroid/content/Context;", "gattServer", "Lau/gov/health/covidsafe/bluetooth/gatt/GattServer;", "setupGattServer", "tearDown", "", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: StreetPassServer.kt */
public final class StreetPassServer {
    private final String TAG = "StreetPassServer";
    private final Context context;
    private GattServer gattServer;

    public StreetPassServer(Context context2, String str) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(str, "serviceUUIDString");
        this.context = context2;
        this.gattServer = setupGattServer(context2, str);
    }

    public final Context getContext() {
        return this.context;
    }

    private final GattServer setupGattServer(Context context2, String str) {
        GattServer gattServer2 = new GattServer(context2, str);
        if (!gattServer2.startServer()) {
            return null;
        }
        gattServer2.addService(new GattService(context2, str));
        return gattServer2;
    }

    public final void tearDown() {
        GattServer gattServer2 = this.gattServer;
        if (gattServer2 != null) {
            gattServer2.stop();
        }
    }
}
