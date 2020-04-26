package au.gov.health.covidsafe.bluetooth.gatt;

import androidx.core.app.NotificationCompat;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u0006\u0010\u0015\u001a\u00020\u0016R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010¨\u0006\u0018"}, d2 = {"Lau/gov/health/covidsafe/bluetooth/gatt/WriteRequestPayload;", "", "v", "", "msg", "", "org", "modelC", "rssi", "txPower", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;)V", "getModelC", "()Ljava/lang/String;", "getMsg", "getOrg", "getRssi", "()I", "getTxPower", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getV", "getPayload", "", "Companion", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: GATT.kt */
public final class WriteRequestPayload {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public static final Gson gson;
    private final String modelC;
    private final String msg;

    /* renamed from: org reason: collision with root package name */
    private final String f6org;
    private final int rssi;
    private final Integer txPower;
    private final int v;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lau/gov/health/covidsafe/bluetooth/gatt/WriteRequestPayload$Companion;", "", "()V", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "createReadRequestPayload", "Lau/gov/health/covidsafe/bluetooth/gatt/WriteRequestPayload;", "dataBytes", "", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: GATT.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Gson getGson() {
            return WriteRequestPayload.gson;
        }

        public final WriteRequestPayload createReadRequestPayload(byte[] bArr) {
            Intrinsics.checkParameterIsNotNull(bArr, "dataBytes");
            Object fromJson = getGson().fromJson(new String(bArr, Charsets.UTF_8), WriteRequestPayload.class);
            Intrinsics.checkExpressionValueIsNotNull(fromJson, "gson.fromJson(dataString…questPayload::class.java)");
            return (WriteRequestPayload) fromJson;
        }
    }

    public WriteRequestPayload(int i, String str, String str2, String str3, int i2, Integer num) {
        Intrinsics.checkParameterIsNotNull(str, NotificationCompat.CATEGORY_MESSAGE);
        Intrinsics.checkParameterIsNotNull(str2, "org");
        Intrinsics.checkParameterIsNotNull(str3, "modelC");
        this.v = i;
        this.msg = str;
        this.f6org = str2;
        this.modelC = str3;
        this.rssi = i2;
        this.txPower = num;
    }

    public final int getV() {
        return this.v;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final String getOrg() {
        return this.f6org;
    }

    public final String getModelC() {
        return this.modelC;
    }

    public final int getRssi() {
        return this.rssi;
    }

    public final Integer getTxPower() {
        return this.txPower;
    }

    public final byte[] getPayload() {
        String json = gson.toJson((Object) this);
        Intrinsics.checkExpressionValueIsNotNull(json, "gson.toJson(this)");
        Charset charset = Charsets.UTF_8;
        if (json != null) {
            byte[] bytes = json.getBytes(charset);
            Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
            return bytes;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    static {
        Gson create = new GsonBuilder().disableHtmlEscaping().create();
        Intrinsics.checkExpressionValueIsNotNull(create, "GsonBuilder().disableHtmlEscaping().create()");
        gson = create;
    }
}
