package au.gov.health.covidsafe.streetpass;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lau/gov/health/covidsafe/streetpass/ConnectablePeripheral;", "Landroid/os/Parcelable;", "transmissionPower", "", "rssi", "(Ljava/lang/Integer;I)V", "getRssi", "()I", "setRssi", "(I)V", "getTransmissionPower", "()Ljava/lang/Integer;", "setTransmissionPower", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: ConnectablePeripheral.kt */
public final class ConnectablePeripheral implements Parcelable {
    public static final android.os.Parcelable.Creator CREATOR = new Creator();
    private int rssi;
    private Integer transmissionPower;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public static class Creator implements android.os.Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            return new ConnectablePeripheral(parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readInt());
        }

        public final Object[] newArray(int i) {
            return new ConnectablePeripheral[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        Integer num = this.transmissionPower;
        if (num != null) {
            parcel.writeInt(1);
            i2 = num.intValue();
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeInt(this.rssi);
    }

    public ConnectablePeripheral(Integer num, int i) {
        this.transmissionPower = num;
        this.rssi = i;
    }

    public final Integer getTransmissionPower() {
        return this.transmissionPower;
    }

    public final void setTransmissionPower(Integer num) {
        this.transmissionPower = num;
    }

    public final int getRssi() {
        return this.rssi;
    }

    public final void setRssi(int i) {
        this.rssi = i;
    }
}
