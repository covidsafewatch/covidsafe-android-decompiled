package au.gov.health.covidsafe.streetpass.persistence;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"au/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase$Companion$MIGRATION_2_3$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: StreetPassRecordDatabase.kt */
public final class StreetPassRecordDatabase$Companion$MIGRATION_2_3$1 extends Migration {
    StreetPassRecordDatabase$Companion$MIGRATION_2_3$1(int i, int i2) {
        super(i, i2);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkParameterIsNotNull(supportSQLiteDatabase, "database");
        MigrationCallBack migrationCallback = StreetPassRecordDatabase.Companion.getMigrationCallback();
        if (migrationCallback != null) {
            migrationCallback.migrationStarted();
        }
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `encrypted_record_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `timestamp` INTEGER NOT NULL, `v` INTEGER NOT NULL, `org` TEXT NOT NULL, `localBlob` TEXT NOT NULL, `remoteBlob` TEXT NOT NULL)");
        StreetPassRecordDatabase.Companion.encryptExistingRecords(supportSQLiteDatabase);
        supportSQLiteDatabase.execSQL("DROP TABLE `record_table`");
        supportSQLiteDatabase.execSQL("ALTER TABLE `encrypted_record_table` RENAME TO `record_table`");
    }
}
