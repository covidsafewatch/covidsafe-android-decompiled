package au.gov.health.covidsafe.streetpass.persistence;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lau/gov/health/covidsafe/streetpass/persistence/MigrationCallBack;", "", "migrationFinished", "", "migrationStarted", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: StreetPassRecordDatabase.kt */
public interface MigrationCallBack {
    void migrationFinished();

    void migrationStarted();
}
