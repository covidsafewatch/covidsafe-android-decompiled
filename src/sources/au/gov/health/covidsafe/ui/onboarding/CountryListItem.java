package au.gov.health.covidsafe.ui.onboarding;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lau/gov/health/covidsafe/ui/onboarding/CountryListItem;", "Lau/gov/health/covidsafe/ui/onboarding/CountryListItemInterface;", "countryNameResId", "", "callingCode", "flagResID", "(III)V", "getCallingCode", "()I", "getCountryNameResId", "getFlagResID", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: CountryListRecyclerView.kt */
public final class CountryListItem implements CountryListItemInterface {
    private final int callingCode;
    private final int countryNameResId;
    private final int flagResID;

    public CountryListItem(int i, int i2, int i3) {
        this.countryNameResId = i;
        this.callingCode = i2;
        this.flagResID = i3;
    }

    public final int getCountryNameResId() {
        return this.countryNameResId;
    }

    public final int getCallingCode() {
        return this.callingCode;
    }

    public final int getFlagResID() {
        return this.flagResID;
    }
}
