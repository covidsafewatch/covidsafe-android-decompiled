package au.gov.health.covidsafe.streetpass.persistence;

import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"au/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase$Companion$CALLBACK$1", "Landroidx/room/RoomDatabase$Callback;", "onOpen", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: StreetPassRecordDatabase.kt */
public final class StreetPassRecordDatabase$Companion$CALLBACK$1 extends RoomDatabase.Callback {
    StreetPassRecordDatabase$Companion$CALLBACK$1() {
    }

    public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkParameterIsNotNull(supportSQLiteDatabase, "db");
        super.onOpen(supportSQLiteDatabase);
        MigrationCallBack migrationCallback = StreetPassRecordDatabase.Companion.getMigrationCallback();
        if (migrationCallback != null) {
            migrationCallback.migrationFinished();
        }
    }
}
