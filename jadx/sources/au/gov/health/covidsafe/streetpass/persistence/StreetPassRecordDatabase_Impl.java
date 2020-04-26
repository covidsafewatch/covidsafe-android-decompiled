package au.gov.health.covidsafe.streetpass.persistence;

import androidx.core.app.NotificationCompat;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import au.gov.health.covidsafe.status.persistence.StatusRecordDao;
import au.gov.health.covidsafe.status.persistence.StatusRecordDao_Impl;
import java.util.HashMap;
import java.util.HashSet;

public final class StreetPassRecordDatabase_Impl extends StreetPassRecordDatabase {
    private volatile StatusRecordDao _statusRecordDao;
    private volatile StreetPassRecordDao _streetPassRecordDao;

    /* access modifiers changed from: protected */
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(2) {
            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `record_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `timestamp` INTEGER NOT NULL, `v` INTEGER NOT NULL, `msg` TEXT NOT NULL, `org` TEXT NOT NULL, `modelP` TEXT NOT NULL, `modelC` TEXT NOT NULL, `rssi` INTEGER NOT NULL, `txPower` INTEGER)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `status_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `timestamp` INTEGER NOT NULL, `msg` TEXT NOT NULL)");
                supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '9a95fc8ad88c160bf76c0ba4747db316')");
            }

            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `record_table`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `status_table`");
                if (StreetPassRecordDatabase_Impl.this.mCallbacks != null) {
                    int size = StreetPassRecordDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) StreetPassRecordDatabase_Impl.this.mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            /* access modifiers changed from: protected */
            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (StreetPassRecordDatabase_Impl.this.mCallbacks != null) {
                    int size = StreetPassRecordDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) StreetPassRecordDatabase_Impl.this.mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase unused = StreetPassRecordDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
                StreetPassRecordDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (StreetPassRecordDatabase_Impl.this.mCallbacks != null) {
                    int size = StreetPassRecordDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) StreetPassRecordDatabase_Impl.this.mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
            }

            /* access modifiers changed from: protected */
            public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase supportSQLiteDatabase2 = supportSQLiteDatabase;
                HashMap hashMap = new HashMap(9);
                hashMap.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("v", new TableInfo.Column("v", "INTEGER", true, 0, (String) null, 1));
                hashMap.put(NotificationCompat.CATEGORY_MESSAGE, new TableInfo.Column(NotificationCompat.CATEGORY_MESSAGE, "TEXT", true, 0, (String) null, 1));
                hashMap.put("org", new TableInfo.Column("org", "TEXT", true, 0, (String) null, 1));
                hashMap.put("modelP", new TableInfo.Column("modelP", "TEXT", true, 0, (String) null, 1));
                hashMap.put("modelC", new TableInfo.Column("modelC", "TEXT", true, 0, (String) null, 1));
                hashMap.put("rssi", new TableInfo.Column("rssi", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("txPower", new TableInfo.Column("txPower", "INTEGER", false, 0, (String) null, 1));
                TableInfo tableInfo = new TableInfo("record_table", hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(supportSQLiteDatabase2, "record_table");
                if (!tableInfo.equals(read)) {
                    return new RoomOpenHelper.ValidationResult(false, "record_table(au.gov.health.covidsafe.streetpass.persistence.StreetPassRecord).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
                }
                HashMap hashMap2 = new HashMap(3);
                hashMap2.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap2.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put(NotificationCompat.CATEGORY_MESSAGE, new TableInfo.Column(NotificationCompat.CATEGORY_MESSAGE, "TEXT", true, 0, (String) null, 1));
                TableInfo tableInfo2 = new TableInfo("status_table", hashMap2, new HashSet(0), new HashSet(0));
                TableInfo read2 = TableInfo.read(supportSQLiteDatabase2, "status_table");
                if (tableInfo2.equals(read2)) {
                    return new RoomOpenHelper.ValidationResult(true, (String) null);
                }
                return new RoomOpenHelper.ValidationResult(false, "status_table(au.gov.health.covidsafe.status.persistence.StatusRecord).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
            }
        }, "9a95fc8ad88c160bf76c0ba4747db316", "336ef522c4c1738f91b0cd0ef01687c8")).build());
    }

    /* access modifiers changed from: protected */
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "record_table", "status_table");
    }

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `record_table`");
            writableDatabase.execSQL("DELETE FROM `status_table`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    public StreetPassRecordDao recordDao() {
        StreetPassRecordDao streetPassRecordDao;
        if (this._streetPassRecordDao != null) {
            return this._streetPassRecordDao;
        }
        synchronized (this) {
            if (this._streetPassRecordDao == null) {
                this._streetPassRecordDao = new StreetPassRecordDao_Impl(this);
            }
            streetPassRecordDao = this._streetPassRecordDao;
        }
        return streetPassRecordDao;
    }

    public StatusRecordDao statusDao() {
        StatusRecordDao statusRecordDao;
        if (this._statusRecordDao != null) {
            return this._statusRecordDao;
        }
        synchronized (this) {
            if (this._statusRecordDao == null) {
                this._statusRecordDao = new StatusRecordDao_Impl(this);
            }
            statusRecordDao = this._statusRecordDao;
        }
        return statusRecordDao;
    }
}
