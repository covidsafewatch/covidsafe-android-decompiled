package au.gov.health.covidsafe.streetpass;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lau/gov/health/covidsafe/streetpass/BlacklistEntry;", "", "uniqueIdentifier", "", "(Ljava/lang/String;)V", "getUniqueIdentifier", "()Ljava/lang/String;", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: BlacklistEntry.kt */
public final class BlacklistEntry {
    private final String uniqueIdentifier;

    public BlacklistEntry(String str) {
        this.uniqueIdentifier = str;
    }

    public final String getUniqueIdentifier() {
        return this.uniqueIdentifier;
    }
}
