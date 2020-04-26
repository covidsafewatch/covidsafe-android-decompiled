package au.gov.health.covidsafe.streetpass;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJV\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010'J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\b\u0010.\u001a\u00020\u0005H\u0016J\u0019\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\f\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016¨\u00064"}, d2 = {"Lau/gov/health/covidsafe/streetpass/ConnectionRecord;", "Landroid/os/Parcelable;", "version", "", "msg", "", "org", "peripheral", "Lau/gov/health/covidsafe/streetpass/PeripheralDevice;", "central", "Lau/gov/health/covidsafe/streetpass/CentralDevice;", "rssi", "txPower", "(ILjava/lang/String;Ljava/lang/String;Lau/gov/health/covidsafe/streetpass/PeripheralDevice;Lau/gov/health/covidsafe/streetpass/CentralDevice;ILjava/lang/Integer;)V", "getCentral", "()Lau/gov/health/covidsafe/streetpass/CentralDevice;", "getMsg", "()Ljava/lang/String;", "getOrg", "getPeripheral", "()Lau/gov/health/covidsafe/streetpass/PeripheralDevice;", "getRssi", "()I", "setRssi", "(I)V", "getTxPower", "()Ljava/lang/Integer;", "setTxPower", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(ILjava/lang/String;Ljava/lang/String;Lau/gov/health/covidsafe/streetpass/PeripheralDevice;Lau/gov/health/covidsafe/streetpass/CentralDevice;ILjava/lang/Integer;)Lau/gov/health/covidsafe/streetpass/ConnectionRecord;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: ConnectablePeripheral.kt */
public final class ConnectionRecord implements Parcelable {
    public static final android.os.Parcelable.Creator CREATOR = new Creator();
    private final CentralDevice central;
    private final String msg;

    /* renamed from: org reason: collision with root package name */
    private final String f7org;
    private final PeripheralDevice peripheral;
    private int rssi;
    private Integer txPower;
    private final int version;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public static class Creator implements android.os.Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            ConnectionRecord connectionRecord = new ConnectionRecord(parcel.readInt(), parcel.readString(), parcel.readString(), (PeripheralDevice) PeripheralDevice.CREATOR.createFromParcel(parcel), (CentralDevice) CentralDevice.CREATOR.createFromParcel(parcel), parcel.readInt(), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
            return connectionRecord;
        }

        public final Object[] newArray(int i) {
            return new ConnectionRecord[i];
        }
    }

    public static /* synthetic */ ConnectionRecord copy$default(ConnectionRecord connectionRecord, int i, String str, String str2, PeripheralDevice peripheralDevice, CentralDevice centralDevice, int i2, Integer num, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = connectionRecord.version;
        }
        if ((i3 & 2) != 0) {
            str = connectionRecord.msg;
        }
        String str3 = str;
        if ((i3 & 4) != 0) {
            str2 = connectionRecord.f7org;
        }
        String str4 = str2;
        if ((i3 & 8) != 0) {
            peripheralDevice = connectionRecord.peripheral;
        }
        PeripheralDevice peripheralDevice2 = peripheralDevice;
        if ((i3 & 16) != 0) {
            centralDevice = connectionRecord.central;
        }
        CentralDevice centralDevice2 = centralDevice;
        if ((i3 & 32) != 0) {
            i2 = connectionRecord.rssi;
        }
        int i4 = i2;
        if ((i3 & 64) != 0) {
            num = connectionRecord.txPower;
        }
        return connectionRecord.copy(i, str3, str4, peripheralDevice2, centralDevice2, i4, num);
    }

    public final int component1() {
        return this.version;
    }

    public final String component2() {
        return this.msg;
    }

    public final String component3() {
        return this.f7org;
    }

    public final PeripheralDevice component4() {
        return this.peripheral;
    }

    public final CentralDevice component5() {
        return this.central;
    }

    public final int component6() {
        return this.rssi;
    }

    public final Integer component7() {
        return this.txPower;
    }

    public final ConnectionRecord copy(int i, String str, String str2, PeripheralDevice peripheralDevice, CentralDevice centralDevice, int i2, Integer num) {
        String str3 = str;
        Intrinsics.checkParameterIsNotNull(str, NotificationCompat.CATEGORY_MESSAGE);
        String str4 = str2;
        Intrinsics.checkParameterIsNotNull(str2, "org");
        PeripheralDevice peripheralDevice2 = peripheralDevice;
        Intrinsics.checkParameterIsNotNull(peripheralDevice, "peripheral");
        CentralDevice centralDevice2 = centralDevice;
        Intrinsics.checkParameterIsNotNull(centralDevice, "central");
        ConnectionRecord connectionRecord = new ConnectionRecord(i, str3, str4, peripheralDevice2, centralDevice2, i2, num);
        return connectionRecord;
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0044, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.txPower, (java.lang.Object) r3.txPower) != false) goto L_0x0049;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0049
            boolean r0 = r3 instanceof au.gov.health.covidsafe.streetpass.ConnectionRecord
            if (r0 == 0) goto L_0x0047
            au.gov.health.covidsafe.streetpass.ConnectionRecord r3 = (au.gov.health.covidsafe.streetpass.ConnectionRecord) r3
            int r0 = r2.version
            int r1 = r3.version
            if (r0 != r1) goto L_0x0047
            java.lang.String r0 = r2.msg
            java.lang.String r1 = r3.msg
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0047
            java.lang.String r0 = r2.f7org
            java.lang.String r1 = r3.f7org
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0047
            au.gov.health.covidsafe.streetpass.PeripheralDevice r0 = r2.peripheral
            au.gov.health.covidsafe.streetpass.PeripheralDevice r1 = r3.peripheral
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0047
            au.gov.health.covidsafe.streetpass.CentralDevice r0 = r2.central
            au.gov.health.covidsafe.streetpass.CentralDevice r1 = r3.central
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0047
            int r0 = r2.rssi
            int r1 = r3.rssi
            if (r0 != r1) goto L_0x0047
            java.lang.Integer r0 = r2.txPower
            java.lang.Integer r3 = r3.txPower
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x0047
            goto L_0x0049
        L_0x0047:
            r3 = 0
            return r3
        L_0x0049:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: au.gov.health.covidsafe.streetpass.ConnectionRecord.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = this.version * 31;
        String str = this.msg;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f7org;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        PeripheralDevice peripheralDevice = this.peripheral;
        int hashCode3 = (hashCode2 + (peripheralDevice != null ? peripheralDevice.hashCode() : 0)) * 31;
        CentralDevice centralDevice = this.central;
        int hashCode4 = (((hashCode3 + (centralDevice != null ? centralDevice.hashCode() : 0)) * 31) + this.rssi) * 31;
        Integer num = this.txPower;
        if (num != null) {
            i2 = num.hashCode();
        }
        return hashCode4 + i2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeInt(this.version);
        parcel.writeString(this.msg);
        parcel.writeString(this.f7org);
        this.peripheral.writeToParcel(parcel, 0);
        this.central.writeToParcel(parcel, 0);
        parcel.writeInt(this.rssi);
        Integer num = this.txPower;
        if (num != null) {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
            return;
        }
        parcel.writeInt(0);
    }

    public ConnectionRecord(int i, String str, String str2, PeripheralDevice peripheralDevice, CentralDevice centralDevice, int i2, Integer num) {
        Intrinsics.checkParameterIsNotNull(str, NotificationCompat.CATEGORY_MESSAGE);
        Intrinsics.checkParameterIsNotNull(str2, "org");
        Intrinsics.checkParameterIsNotNull(peripheralDevice, "peripheral");
        Intrinsics.checkParameterIsNotNull(centralDevice, "central");
        this.version = i;
        this.msg = str;
        this.f7org = str2;
        this.peripheral = peripheralDevice;
        this.central = centralDevice;
        this.rssi = i2;
        this.txPower = num;
    }

    public final int getVersion() {
        return this.version;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final String getOrg() {
        return this.f7org;
    }

    public final PeripheralDevice getPeripheral() {
        return this.peripheral;
    }

    public final CentralDevice getCentral() {
        return this.central;
    }

    public final int getRssi() {
        return this.rssi;
    }

    public final void setRssi(int i) {
        this.rssi = i;
    }

    public final Integer getTxPower() {
        return this.txPower;
    }

    public final void setTxPower(Integer num) {
        this.txPower = num;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Central ");
        sb.append(this.central.getModelC());
        String str = " - ";
        sb.append(str);
        sb.append(this.central.getAddress());
        sb.append(" ---> Peripheral ");
        sb.append(this.peripheral.getModelP());
        sb.append(str);
        sb.append(this.peripheral.getAddress());
        return sb.toString();
    }
}
