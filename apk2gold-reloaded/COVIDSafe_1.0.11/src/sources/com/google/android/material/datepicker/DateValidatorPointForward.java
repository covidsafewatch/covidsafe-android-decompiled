package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.material.datepicker.CalendarConstraints.DateValidator;
import java.util.Arrays;

public class DateValidatorPointForward implements DateValidator {
    public static final Creator<DateValidatorPointForward> CREATOR = new Creator<DateValidatorPointForward>() {
        public DateValidatorPointForward createFromParcel(Parcel parcel) {
            return new DateValidatorPointForward(parcel.readLong());
        }

        public DateValidatorPointForward[] newArray(int i) {
            return new DateValidatorPointForward[i];
        }
    };
    private final long point;

    public int describeContents() {
        return 0;
    }

    private DateValidatorPointForward(long j) {
        this.point = j;
    }

    public static DateValidatorPointForward from(long j) {
        return new DateValidatorPointForward(j);
    }

    public static DateValidatorPointForward now() {
        return from(UtcDates.getTodayCalendar().getTimeInMillis());
    }

    public boolean isValid(long j) {
        return j >= this.point;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.point);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DateValidatorPointForward)) {
            return false;
        }
        if (this.point != ((DateValidatorPointForward) obj).point) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.point)});
    }
}
