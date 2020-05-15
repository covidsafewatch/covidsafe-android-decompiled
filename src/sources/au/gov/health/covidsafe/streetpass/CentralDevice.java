package au.gov.health.covidsafe.streetpass;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lau/gov/health/covidsafe/streetpass/CentralDevice;", "Landroid/os/Parcelable;", "modelC", "", "address", "(Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "getModelC", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: ConnectablePeripheral.kt */
public final class CentralDevice implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final String address;
    private final String modelC;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            return new CentralDevice(parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new CentralDevice[i];
        }
    }

    public static /* synthetic */ CentralDevice copy$default(CentralDevice centralDevice, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = centralDevice.modelC;
        }
        if ((i & 2) != 0) {
            str2 = centralDevice.address;
        }
        return centralDevice.copy(str, str2);
    }

    public final String component1() {
        return this.modelC;
    }

    public final String component2() {
        return this.address;
    }

    public final CentralDevice copy(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "modelC");
        return new CentralDevice(str, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CentralDevice)) {
            return false;
        }
        CentralDevice centralDevice = (CentralDevice) obj;
        return Intrinsics.areEqual((Object) this.modelC, (Object) centralDevice.modelC) && Intrinsics.areEqual((Object) this.address, (Object) centralDevice.address);
    }

    public int hashCode() {
        String str = this.modelC;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.address;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "CentralDevice(modelC=" + this.modelC + ", address=" + this.address + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.modelC);
        parcel.writeString(this.address);
    }

    public CentralDevice(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "modelC");
        this.modelC = str;
        this.address = str2;
    }

    public final String getModelC() {
        return this.modelC;
    }

    public final String getAddress() {
        return this.address;
    }
}
