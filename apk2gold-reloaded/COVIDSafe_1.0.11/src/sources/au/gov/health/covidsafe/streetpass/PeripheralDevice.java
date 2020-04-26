package au.gov.health.covidsafe.streetpass;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lau/gov/health/covidsafe/streetpass/PeripheralDevice;", "Landroid/os/Parcelable;", "modelP", "", "address", "(Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "getModelP", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: ConnectablePeripheral.kt */
public final class PeripheralDevice implements Parcelable {
    public static final android.os.Parcelable.Creator CREATOR = new Creator();
    private final String address;
    private final String modelP;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public static class Creator implements android.os.Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            return new PeripheralDevice(parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new PeripheralDevice[i];
        }
    }

    public static /* synthetic */ PeripheralDevice copy$default(PeripheralDevice peripheralDevice, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = peripheralDevice.modelP;
        }
        if ((i & 2) != 0) {
            str2 = peripheralDevice.address;
        }
        return peripheralDevice.copy(str, str2);
    }

    public final String component1() {
        return this.modelP;
    }

    public final String component2() {
        return this.address;
    }

    public final PeripheralDevice copy(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "modelP");
        return new PeripheralDevice(str, str2);
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.address, (java.lang.Object) r3.address) != false) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x001f
            boolean r0 = r3 instanceof au.gov.health.covidsafe.streetpass.PeripheralDevice
            if (r0 == 0) goto L_0x001d
            au.gov.health.covidsafe.streetpass.PeripheralDevice r3 = (au.gov.health.covidsafe.streetpass.PeripheralDevice) r3
            java.lang.String r0 = r2.modelP
            java.lang.String r1 = r3.modelP
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x001d
            java.lang.String r0 = r2.address
            java.lang.String r3 = r3.address
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r3 = 0
            return r3
        L_0x001f:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: au.gov.health.covidsafe.streetpass.PeripheralDevice.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.modelP;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.address;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PeripheralDevice(modelP=");
        sb.append(this.modelP);
        sb.append(", address=");
        sb.append(this.address);
        sb.append(")");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.modelP);
        parcel.writeString(this.address);
    }

    public PeripheralDevice(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "modelP");
        this.modelP = str;
        this.address = str2;
    }

    public final String getModelP() {
        return this.modelP;
    }

    public final String getAddress() {
        return this.address;
    }
}
