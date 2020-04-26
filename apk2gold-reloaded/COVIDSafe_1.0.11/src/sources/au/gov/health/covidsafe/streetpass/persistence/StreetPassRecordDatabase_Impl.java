package au.gov.health.covidsafe.streetpass.persistence;

import androidx.core.app.NotificationCompat;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase.Callback;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import au.gov.health.covidsafe.status.persistence.StatusRecordDao;
import au.gov.health.covidsafe.status.persistence.StatusRecordDao_Impl;
import java.util.HashMap;
import java.util.HashSet;

public final class StreetPassRecordDatabase_Impl extends StreetPassRecordDatabase {
    private volatile StatusRecordDao _statusRecordDao;
    private volatile StreetPassRecordDao _streetPassRecordDao;

    /* access modifiers changed from: protected */
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new Delegate(2) {
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
                        ((Callback) StreetPassRecordDatabase_Impl.this.mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            /* access modifiers changed from: protected */
            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (StreetPassRecordDatabase_Impl.this.mCallbacks != null) {
                    int size = StreetPassRecordDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((Callback) StreetPassRecordDatabase_Impl.this.mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                StreetPassRecordDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
                StreetPassRecordDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (StreetPassRecordDatabase_Impl.this.mCallbacks != null) {
                    int size = StreetPassRecordDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((Callback) StreetPassRecordDatabase_Impl.this.mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
            }

            /* access modifiers changed from: protected */
            public ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase supportSQLiteDatabase2 = supportSQLiteDatabase;
                HashMap hashMap = new HashMap(9);
                Column column = new Column("id", "INTEGER", true, 1, null, 1);
                String str = "id";
                hashMap.put(str, column);
                Column column2 = new Column("timestamp", "INTEGER", true, 0, null, 1);
                String str2 = "timestamp";
                hashMap.put(str2, column2);
                Column column3 = new Column("v", "INTEGER", true, 0, null, 1);
                hashMap.put("v", column3);
                Column column4 = new Column(NotificationCompat.CATEGORY_MESSAGE, "TEXT", true, 0, null, 1);
                String str3 = NotificationCompat.CATEGORY_MESSAGE;
                hashMap.put(str3, column4);
                Column column5 = new Column("org", "TEXT", true, 0, null, 1);
                hashMap.put("org", column5);
                Column column6 = new Column("modelP", "TEXT", true, 0, null, 1);
                hashMap.put("modelP", column6);
                Column column7 = new Column("modelC", "TEXT", true, 0, null, 1);
                hashMap.put("modelC", column7);
                Column column8 = new Column("rssi", "INTEGER", true, 0, null, 1);
                hashMap.put("rssi", column8);
                Column column9 = new Column("txPower", "INTEGER", false, 0, null, 1);
                hashMap.put("txPower", column9);
                String str4 = "record_table";
                TableInfo tableInfo = new TableInfo(str4, hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(supportSQLiteDatabase2, str4);
                String str5 = "\n Found:\n";
                if (!tableInfo.equals(read)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("record_table(au.gov.health.covidsafe.streetpass.persistence.StreetPassRecord).\n Expected:\n");
                    sb.append(tableInfo);
                    sb.append(str5);
                    sb.append(read);
                    return new ValidationResult(false, sb.toString());
                }
                HashMap hashMap2 = new HashMap(3);
                Column column10 = new Column("id", "INTEGER", true, 1, null, 1);
                hashMap2.put(str, column10);
                Column column11 = new Column("timestamp", "INTEGER", true, 0, null, 1);
                hashMap2.put(str2, column11);
                Column column12 = new Column(NotificationCompat.CATEGORY_MESSAGE, "TEXT", true, 0, null, 1);
                hashMap2.put(str3, column12);
                String str6 = "status_table";
                TableInfo tableInfo2 = new TableInfo(str6, hashMap2, new HashSet(0), new HashSet(0));
                TableInfo read2 = TableInfo.read(supportSQLiteDatabase2, str6);
                if (tableInfo2.equals(read2)) {
                    return new ValidationResult(true, null);
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("status_table(au.gov.health.covidsafe.status.persistence.StatusRecord).\n Expected:\n");
                sb2.append(tableInfo2);
                sb2.append(str5);
                sb2.append(read2);
                return new ValidationResult(false, sb2.toString());
            }
        }, "9a95fc8ad88c160bf76c0ba4747db316", "336ef522c4c1738f91b0cd0ef01687c8")).build());
    }

    /* access modifiers changed from: protected */
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "record_table", "status_table");
    }

    public void clearAllTables() {
        String str = "VACUUM";
        String str2 = "PRAGMA wal_checkpoint(FULL)";
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `record_table`");
            writableDatabase.execSQL("DELETE FROM `status_table`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query(str2).close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL(str);
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
