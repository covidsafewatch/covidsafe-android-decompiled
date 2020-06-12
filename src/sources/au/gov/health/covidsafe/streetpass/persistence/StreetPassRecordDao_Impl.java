package au.gov.health.covidsafe.streetpass.persistence;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

public final class StreetPassRecordDao_Impl implements StreetPassRecordDao {
    /* access modifiers changed from: private */
    public final RoomDatabase __db;
    /* access modifiers changed from: private */
    public final EntityInsertionAdapter<StreetPassRecord> __insertionAdapterOfStreetPassRecord;
    private final SharedSQLiteStatement __preparedStmtOfDeleteDataOlder;
    private final SharedSQLiteStatement __preparedStmtOfNukeDb;

    public StreetPassRecordDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfStreetPassRecord = new EntityInsertionAdapter<StreetPassRecord>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR IGNORE INTO `record_table` (`id`,`timestamp`,`v`,`org`,`localBlob`,`remoteBlob`) VALUES (nullif(?, 0),?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, StreetPassRecord streetPassRecord) {
                supportSQLiteStatement.bindLong(1, (long) streetPassRecord.getId());
                supportSQLiteStatement.bindLong(2, streetPassRecord.getTimestamp());
                supportSQLiteStatement.bindLong(3, (long) streetPassRecord.getV());
                if (streetPassRecord.getOrg() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, streetPassRecord.getOrg());
                }
                if (streetPassRecord.getLocalBlob() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, streetPassRecord.getLocalBlob());
                }
                if (streetPassRecord.getRemoteBlob() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, streetPassRecord.getRemoteBlob());
                }
            }
        };
        this.__preparedStmtOfDeleteDataOlder = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM record_table WHERE timestamp <= ?";
            }
        };
        this.__preparedStmtOfNukeDb = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM record_table";
            }
        };
    }

    public Object insert(final StreetPassRecord streetPassRecord, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() throws Exception {
                StreetPassRecordDao_Impl.this.__db.beginTransaction();
                try {
                    StreetPassRecordDao_Impl.this.__insertionAdapterOfStreetPassRecord.insert(streetPassRecord);
                    StreetPassRecordDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    StreetPassRecordDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public int deleteDataOlder(long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteDataOlder.acquire();
        acquire.bindLong(1, j);
        this.__db.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteDataOlder.release(acquire);
        }
    }

    public void nukeDb() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfNukeDb.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfNukeDb.release(acquire);
        }
    }

    public LiveData<List<StreetPassRecord>> getRecords() {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * from record_table ORDER BY timestamp ASC", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"record_table"}, false, new Callable<List<StreetPassRecord>>() {
            public List<StreetPassRecord> call() throws Exception {
                Cursor query = DBUtil.query(StreetPassRecordDao_Impl.this.__db, acquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "timestamp");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "v");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "org");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "localBlob");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "remoteBlob");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        StreetPassRecord streetPassRecord = new StreetPassRecord(query.getInt(columnIndexOrThrow3), query.getString(columnIndexOrThrow4), query.getString(columnIndexOrThrow5), query.getString(columnIndexOrThrow6));
                        streetPassRecord.setId(query.getInt(columnIndexOrThrow));
                        streetPassRecord.setTimestamp(query.getLong(columnIndexOrThrow2));
                        arrayList.add(streetPassRecord);
                    }
                    return arrayList;
                } finally {
                    query.close();
                }
            }

            /* access modifiers changed from: protected */
            public void finalize() {
                acquire.release();
            }
        });
    }

    public LiveData<StreetPassRecord> getMostRecentRecord() {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * from record_table ORDER BY timestamp DESC LIMIT 1", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"record_table"}, false, new Callable<StreetPassRecord>() {
            public StreetPassRecord call() throws Exception {
                StreetPassRecord streetPassRecord = null;
                Cursor query = DBUtil.query(StreetPassRecordDao_Impl.this.__db, acquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "timestamp");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "v");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "org");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "localBlob");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "remoteBlob");
                    if (query.moveToFirst()) {
                        StreetPassRecord streetPassRecord2 = new StreetPassRecord(query.getInt(columnIndexOrThrow3), query.getString(columnIndexOrThrow4), query.getString(columnIndexOrThrow5), query.getString(columnIndexOrThrow6));
                        streetPassRecord2.setId(query.getInt(columnIndexOrThrow));
                        streetPassRecord2.setTimestamp(query.getLong(columnIndexOrThrow2));
                        streetPassRecord = streetPassRecord2;
                    }
                    return streetPassRecord;
                } finally {
                    query.close();
                }
            }

            /* access modifiers changed from: protected */
            public void finalize() {
                acquire.release();
            }
        });
    }

    public List<StreetPassRecord> getCurrentRecords() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * from record_table ORDER BY timestamp ASC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "timestamp");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "v");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "org");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "localBlob");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "remoteBlob");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                StreetPassRecord streetPassRecord = new StreetPassRecord(query.getInt(columnIndexOrThrow3), query.getString(columnIndexOrThrow4), query.getString(columnIndexOrThrow5), query.getString(columnIndexOrThrow6));
                streetPassRecord.setId(query.getInt(columnIndexOrThrow));
                streetPassRecord.setTimestamp(query.getLong(columnIndexOrThrow2));
                arrayList.add(streetPassRecord);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<StreetPassRecord> getRecordsViaQuery(SupportSQLiteQuery supportSQLiteQuery) {
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, supportSQLiteQuery, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(__entityCursorConverter_auGovHealthCovidsafeStreetpassPersistenceStreetPassRecord(query));
            }
            return arrayList;
        } finally {
            query.close();
        }
    }

    private StreetPassRecord __entityCursorConverter_auGovHealthCovidsafeStreetpassPersistenceStreetPassRecord(Cursor cursor) {
        int i;
        String str;
        String str2;
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("timestamp");
        int columnIndex3 = cursor.getColumnIndex("v");
        int columnIndex4 = cursor.getColumnIndex("org");
        int columnIndex5 = cursor.getColumnIndex("localBlob");
        int columnIndex6 = cursor.getColumnIndex("remoteBlob");
        if (columnIndex3 == -1) {
            i = 0;
        } else {
            i = cursor.getInt(columnIndex3);
        }
        String str3 = null;
        if (columnIndex4 == -1) {
            str = null;
        } else {
            str = cursor.getString(columnIndex4);
        }
        if (columnIndex5 == -1) {
            str2 = null;
        } else {
            str2 = cursor.getString(columnIndex5);
        }
        if (columnIndex6 != -1) {
            str3 = cursor.getString(columnIndex6);
        }
        StreetPassRecord streetPassRecord = new StreetPassRecord(i, str, str2, str3);
        if (columnIndex != -1) {
            streetPassRecord.setId(cursor.getInt(columnIndex));
        }
        if (columnIndex2 != -1) {
            streetPassRecord.setTimestamp(cursor.getLong(columnIndex2));
        }
        return streetPassRecord;
    }
}
