package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;

public class ParcelableSparseIntArray extends SparseIntArray implements Parcelable {
    public static final Parcelable.Creator<ParcelableSparseIntArray> CREATOR = new Parcelable.Creator<ParcelableSparseIntArray>() {
        public ParcelableSparseIntArray createFromParcel(Parcel parcel) {
            int readInt = parcel.readInt();
            ParcelableSparseIntArray parcelableSparseIntArray = new ParcelableSparseIntArray(readInt);
            int[] iArr = new int[readInt];
            int[] iArr2 = new int[readInt];
            parcel.readIntArray(iArr);
            parcel.readIntArray(iArr2);
            for (int i = 0; i < readInt; i++) {
                parcelableSparseIntArray.put(iArr[i], iArr2[i]);
            }
            return parcelableSparseIntArray;
        }

        public ParcelableSparseIntArray[] newArray(int i) {
            return new ParcelableSparseIntArray[i];
        }
    };

    public int describeContents() {
        return 0;
    }

    public ParcelableSparseIntArray() {
    }

    public ParcelableSparseIntArray(int i) {
        super(i);
    }

    public ParcelableSparseIntArray(SparseIntArray sparseIntArray) {
        for (int i = 0; i < sparseIntArray.size(); i++) {
            put(sparseIntArray.keyAt(i), sparseIntArray.valueAt(i));
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        int[] iArr = new int[size()];
        int[] iArr2 = new int[size()];
        for (int i2 = 0; i2 < size(); i2++) {
            iArr[i2] = keyAt(i2);
            iArr2[i2] = valueAt(i2);
        }
        parcel.writeInt(size());
        parcel.writeIntArray(iArr);
        parcel.writeIntArray(iArr2);
    }
}
