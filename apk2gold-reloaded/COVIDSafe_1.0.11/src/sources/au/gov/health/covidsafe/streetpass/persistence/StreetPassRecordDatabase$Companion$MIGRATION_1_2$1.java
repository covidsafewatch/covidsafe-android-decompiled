package au.gov.health.covidsafe.streetpass.persistence;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"au/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase$Companion$MIGRATION_1_2$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: StreetPassRecordDatabase.kt */
public final class StreetPassRecordDatabase$Companion$MIGRATION_1_2$1 extends Migration {
    StreetPassRecordDatabase$Companion$MIGRATION_1_2$1(int i, int i2) {
        super(i, i2);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkParameterIsNotNull(supportSQLiteDatabase, "database");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `status_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `timestamp` INTEGER NOT NULL, `msg` TEXT NOT NULL)");
        String str = "record_table";
        if (!StreetPassRecordDatabase.Companion.isFieldExist(supportSQLiteDatabase, str, "v")) {
            supportSQLiteDatabase.execSQL("ALTER TABLE `record_table` ADD COLUMN `v` INTEGER NOT NULL DEFAULT 1");
        }
        if (!StreetPassRecordDatabase.Companion.isFieldExist(supportSQLiteDatabase, str, "org")) {
            supportSQLiteDatabase.execSQL("ALTER TABLE `record_table` ADD COLUMN `org` TEXT NOT NULL DEFAULT 'AU_DTA'");
        }
    }
}
