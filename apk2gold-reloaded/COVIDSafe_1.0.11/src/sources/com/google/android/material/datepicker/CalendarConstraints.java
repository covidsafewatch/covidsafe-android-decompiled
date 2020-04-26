package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public final class CalendarConstraints implements Parcelable {
    public static final Creator<CalendarConstraints> CREATOR = new Creator<CalendarConstraints>() {
        public CalendarConstraints createFromParcel(Parcel parcel) {
            CalendarConstraints calendarConstraints = new CalendarConstraints((Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (DateValidator) parcel.readParcelable(DateValidator.class.getClassLoader()));
            return calendarConstraints;
        }

        public CalendarConstraints[] newArray(int i) {
            return new CalendarConstraints[i];
        }
    };
    /* access modifiers changed from: private */
    public final Month end;
    private final int monthSpan;
    /* access modifiers changed from: private */
    public final Month openAt;
    /* access modifiers changed from: private */
    public final Month start;
    /* access modifiers changed from: private */
    public final DateValidator validator;
    private final int yearSpan;

    public static final class Builder {
        private static final String DEEP_COPY_VALIDATOR_KEY = "DEEP_COPY_VALIDATOR_KEY";
        static final long DEFAULT_END = UtcDates.canonicalYearMonthDay(Month.create(2100, 11).timeInMillis);
        static final long DEFAULT_START = UtcDates.canonicalYearMonthDay(Month.create(1900, 0).timeInMillis);
        private long end = DEFAULT_END;
        private Long openAt;
        private long start = DEFAULT_START;
        private DateValidator validator = DateValidatorPointForward.from(Long.MIN_VALUE);

        public Builder() {
        }

        Builder(CalendarConstraints calendarConstraints) {
            this.start = calendarConstraints.start.timeInMillis;
            this.end = calendarConstraints.end.timeInMillis;
            this.openAt = Long.valueOf(calendarConstraints.openAt.timeInMillis);
            this.validator = calendarConstraints.validator;
        }

        public Builder setStart(long j) {
            this.start = j;
            return this;
        }

        public Builder setEnd(long j) {
            this.end = j;
            return this;
        }

        public Builder setOpenAt(long j) {
            this.openAt = Long.valueOf(j);
            return this;
        }

        public Builder setValidator(DateValidator dateValidator) {
            this.validator = dateValidator;
            return this;
        }

        public CalendarConstraints build() {
            if (this.openAt == null) {
                long thisMonthInUtcMilliseconds = MaterialDatePicker.thisMonthInUtcMilliseconds();
                if (this.start > thisMonthInUtcMilliseconds || thisMonthInUtcMilliseconds > this.end) {
                    thisMonthInUtcMilliseconds = this.start;
                }
                this.openAt = Long.valueOf(thisMonthInUtcMilliseconds);
            }
            Bundle bundle = new Bundle();
            DateValidator dateValidator = this.validator;
            String str = DEEP_COPY_VALIDATOR_KEY;
            bundle.putParcelable(str, dateValidator);
            CalendarConstraints calendarConstraints = new CalendarConstraints(Month.create(this.start), Month.create(this.end), Month.create(this.openAt.longValue()), (DateValidator) bundle.getParcelable(str));
            return calendarConstraints;
        }
    }

    public interface DateValidator extends Parcelable {
        boolean isValid(long j);
    }

    public int describeContents() {
        return 0;
    }

    private CalendarConstraints(Month month, Month month2, Month month3, DateValidator dateValidator) {
        this.start = month;
        this.end = month2;
        this.openAt = month3;
        this.validator = dateValidator;
        if (month.compareTo(month3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        } else if (month3.compareTo(month2) <= 0) {
            this.monthSpan = month.monthsUntil(month2) + 1;
            this.yearSpan = (month2.year - month.year) + 1;
        } else {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean isWithinBounds(long j) {
        if (this.start.getDay(1) <= j) {
            Month month = this.end;
            if (j <= month.getDay(month.daysInMonth)) {
                return true;
            }
        }
        return false;
    }

    public DateValidator getDateValidator() {
        return this.validator;
    }

    /* access modifiers changed from: 0000 */
    public Month getStart() {
        return this.start;
    }

    /* access modifiers changed from: 0000 */
    public Month getEnd() {
        return this.end;
    }

    /* access modifiers changed from: 0000 */
    public Month getOpenAt() {
        return this.openAt;
    }

    /* access modifiers changed from: 0000 */
    public int getMonthSpan() {
        return this.monthSpan;
    }

    /* access modifiers changed from: 0000 */
    public int getYearSpan() {
        return this.yearSpan;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarConstraints)) {
            return false;
        }
        CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
        if (!this.start.equals(calendarConstraints.start) || !this.end.equals(calendarConstraints.end) || !this.openAt.equals(calendarConstraints.openAt) || !this.validator.equals(calendarConstraints.validator)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.start, this.end, this.openAt, this.validator});
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.start, 0);
        parcel.writeParcelable(this.end, 0);
        parcel.writeParcelable(this.openAt, 0);
        parcel.writeParcelable(this.validator, 0);
    }
}
