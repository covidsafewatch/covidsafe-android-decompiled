package au.gov.health.covidsafe.streetpass.persistence;

import android.database.Cursor;
import androidx.core.app.NotificationCompat;
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
                return "INSERT OR IGNORE INTO `record_table` (`id`,`timestamp`,`v`,`msg`,`org`,`modelP`,`modelC`,`rssi`,`txPower`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, StreetPassRecord streetPassRecord) {
                supportSQLiteStatement.bindLong(1, (long) streetPassRecord.getId());
                supportSQLiteStatement.bindLong(2, streetPassRecord.getTimestamp());
                supportSQLiteStatement.bindLong(3, (long) streetPassRecord.getV());
                if (streetPassRecord.getMsg() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, streetPassRecord.getMsg());
                }
                if (streetPassRecord.getOrg() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, streetPassRecord.getOrg());
                }
                if (streetPassRecord.getModelP() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, streetPassRecord.getModelP());
                }
                if (streetPassRecord.getModelC() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, streetPassRecord.getModelC());
                }
                supportSQLiteStatement.bindLong(8, (long) streetPassRecord.getRssi());
                if (streetPassRecord.getTxPower() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindLong(9, (long) streetPassRecord.getTxPower().intValue());
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
                Integer num;
                Cursor query = DBUtil.query(StreetPassRecordDao_Impl.this.__db, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "timestamp");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "v");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, NotificationCompat.CATEGORY_MESSAGE);
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "org");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "modelP");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "modelC");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "rssi");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "txPower");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        int i = query.getInt(columnIndexOrThrow3);
                        String string = query.getString(columnIndexOrThrow4);
                        String string2 = query.getString(columnIndexOrThrow5);
                        String string3 = query.getString(columnIndexOrThrow6);
                        String string4 = query.getString(columnIndexOrThrow7);
                        int i2 = query.getInt(columnIndexOrThrow8);
                        if (query.isNull(columnIndexOrThrow9)) {
                            num = null;
                        } else {
                            num = Integer.valueOf(query.getInt(columnIndexOrThrow9));
                        }
                        StreetPassRecord streetPassRecord = new StreetPassRecord(i, string, string2, string3, string4, i2, num);
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
            /* JADX WARNING: type inference failed for: r3v0 */
            /* JADX WARNING: type inference failed for: r3v1, types: [au.gov.health.covidsafe.streetpass.persistence.StreetPassRecord] */
            /* JADX WARNING: type inference failed for: r3v3, types: [java.lang.Integer] */
            /* JADX WARNING: type inference failed for: r3v4 */
            /* JADX WARNING: type inference failed for: r20v0, types: [java.lang.Integer] */
            /* JADX WARNING: type inference failed for: r13v0, types: [au.gov.health.covidsafe.streetpass.persistence.StreetPassRecord] */
            /* JADX WARNING: type inference failed for: r3v6 */
            /* JADX WARNING: type inference failed for: r13v1, types: [au.gov.health.covidsafe.streetpass.persistence.StreetPassRecord] */
            /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r3v0
              assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], au.gov.health.covidsafe.streetpass.persistence.StreetPassRecord, java.lang.Integer]
              uses: [au.gov.health.covidsafe.streetpass.persistence.StreetPassRecord, ?[OBJECT, ARRAY]]
              mth insns count: 52
            	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1378)
            	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
            	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
            	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1378)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1378)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
            	at jadx.core.ProcessClass.process(ProcessClass.java:30)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
             */
            /* JADX WARNING: Unknown variable types count: 4 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public au.gov.health.covidsafe.streetpass.persistence.StreetPassRecord call() throws java.lang.Exception {
                /*
                    r21 = this;
                    r1 = r21
                    au.gov.health.covidsafe.streetpass.persistence.StreetPassRecordDao_Impl r0 = au.gov.health.covidsafe.streetpass.persistence.StreetPassRecordDao_Impl.this
                    androidx.room.RoomDatabase r0 = r0.__db
                    androidx.room.RoomSQLiteQuery r2 = r1
                    r3 = 0
                    r4 = 0
                    android.database.Cursor r2 = androidx.room.util.DBUtil.query(r0, r2, r4, r3)
                    java.lang.String r0 = "id"
                    int r0 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r0)     // Catch:{ all -> 0x008e }
                    java.lang.String r4 = "timestamp"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r4)     // Catch:{ all -> 0x008e }
                    java.lang.String r5 = "v"
                    int r5 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r5)     // Catch:{ all -> 0x008e }
                    java.lang.String r6 = "msg"
                    int r6 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r6)     // Catch:{ all -> 0x008e }
                    java.lang.String r7 = "org"
                    int r7 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r7)     // Catch:{ all -> 0x008e }
                    java.lang.String r8 = "modelP"
                    int r8 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r8)     // Catch:{ all -> 0x008e }
                    java.lang.String r9 = "modelC"
                    int r9 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r9)     // Catch:{ all -> 0x008e }
                    java.lang.String r10 = "rssi"
                    int r10 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r10)     // Catch:{ all -> 0x008e }
                    java.lang.String r11 = "txPower"
                    int r11 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r11)     // Catch:{ all -> 0x008e }
                    boolean r12 = r2.moveToFirst()     // Catch:{ all -> 0x008e }
                    if (r12 == 0) goto L_0x008a
                    int r14 = r2.getInt(r5)     // Catch:{ all -> 0x008e }
                    java.lang.String r15 = r2.getString(r6)     // Catch:{ all -> 0x008e }
                    java.lang.String r16 = r2.getString(r7)     // Catch:{ all -> 0x008e }
                    java.lang.String r17 = r2.getString(r8)     // Catch:{ all -> 0x008e }
                    java.lang.String r18 = r2.getString(r9)     // Catch:{ all -> 0x008e }
                    int r19 = r2.getInt(r10)     // Catch:{ all -> 0x008e }
                    boolean r5 = r2.isNull(r11)     // Catch:{ all -> 0x008e }
                    if (r5 == 0) goto L_0x006d
                L_0x006a:
                    r20 = r3
                    goto L_0x0076
                L_0x006d:
                    int r3 = r2.getInt(r11)     // Catch:{ all -> 0x008e }
                    java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x008e }
                    goto L_0x006a
                L_0x0076:
                    au.gov.health.covidsafe.streetpass.persistence.StreetPassRecord r3 = new au.gov.health.covidsafe.streetpass.persistence.StreetPassRecord     // Catch:{ all -> 0x008e }
                    r13 = r3
                    r13.<init>(r14, r15, r16, r17, r18, r19, r20)     // Catch:{ all -> 0x008e }
                    int r0 = r2.getInt(r0)     // Catch:{ all -> 0x008e }
                    r3.setId(r0)     // Catch:{ all -> 0x008e }
                    long r4 = r2.getLong(r4)     // Catch:{ all -> 0x008e }
                    r3.setTimestamp(r4)     // Catch:{ all -> 0x008e }
                L_0x008a:
                    r2.close()
                    return r3
                L_0x008e:
                    r0 = move-exception
                    r2.close()
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: au.gov.health.covidsafe.streetpass.persistence.StreetPassRecordDao_Impl.AnonymousClass6.call():au.gov.health.covidsafe.streetpass.persistence.StreetPassRecord");
            }

            /* access modifiers changed from: protected */
            public void finalize() {
                acquire.release();
            }
        });
    }

    public List<StreetPassRecord> getCurrentRecords() {
        Integer num;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * from record_table ORDER BY timestamp ASC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "timestamp");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "v");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, NotificationCompat.CATEGORY_MESSAGE);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "org");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "modelP");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "modelC");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "rssi");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "txPower");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                int i = query.getInt(columnIndexOrThrow3);
                String string = query.getString(columnIndexOrThrow4);
                String string2 = query.getString(columnIndexOrThrow5);
                String string3 = query.getString(columnIndexOrThrow6);
                String string4 = query.getString(columnIndexOrThrow7);
                int i2 = query.getInt(columnIndexOrThrow8);
                if (query.isNull(columnIndexOrThrow9)) {
                    num = null;
                } else {
                    num = Integer.valueOf(query.getInt(columnIndexOrThrow9));
                }
                StreetPassRecord streetPassRecord = new StreetPassRecord(i, string, string2, string3, string4, i2, num);
                streetPassRecord.setId(query.getInt(columnIndexOrThrow));
                int i3 = columnIndexOrThrow;
                streetPassRecord.setTimestamp(query.getLong(columnIndexOrThrow2));
                arrayList.add(streetPassRecord);
                columnIndexOrThrow = i3;
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<StreetPassRecord> getRecordsViaQuery(SupportSQLiteQuery supportSQLiteQuery) {
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, supportSQLiteQuery, false, null);
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
        String str3;
        String str4;
        Cursor cursor2 = cursor;
        int columnIndex = cursor2.getColumnIndex("id");
        int columnIndex2 = cursor2.getColumnIndex("timestamp");
        int columnIndex3 = cursor2.getColumnIndex("v");
        int columnIndex4 = cursor2.getColumnIndex(NotificationCompat.CATEGORY_MESSAGE);
        int columnIndex5 = cursor2.getColumnIndex("org");
        int columnIndex6 = cursor2.getColumnIndex("modelP");
        int columnIndex7 = cursor2.getColumnIndex("modelC");
        int columnIndex8 = cursor2.getColumnIndex("rssi");
        int columnIndex9 = cursor2.getColumnIndex("txPower");
        int i2 = 0;
        if (columnIndex3 == -1) {
            i = 0;
        } else {
            i = cursor2.getInt(columnIndex3);
        }
        Integer num = null;
        if (columnIndex4 == -1) {
            str = null;
        } else {
            str = cursor2.getString(columnIndex4);
        }
        if (columnIndex5 == -1) {
            str2 = null;
        } else {
            str2 = cursor2.getString(columnIndex5);
        }
        if (columnIndex6 == -1) {
            str3 = null;
        } else {
            str3 = cursor2.getString(columnIndex6);
        }
        if (columnIndex7 == -1) {
            str4 = null;
        } else {
            str4 = cursor2.getString(columnIndex7);
        }
        if (columnIndex8 != -1) {
            i2 = cursor2.getInt(columnIndex8);
        }
        int i3 = i2;
        if (columnIndex9 != -1 && !cursor2.isNull(columnIndex9)) {
            num = Integer.valueOf(cursor2.getInt(columnIndex9));
        }
        StreetPassRecord streetPassRecord = new StreetPassRecord(i, str, str2, str3, str4, i3, num);
        if (columnIndex != -1) {
            streetPassRecord.setId(cursor2.getInt(columnIndex));
        }
        if (columnIndex2 != -1) {
            streetPassRecord.setTimestamp(cursor2.getLong(columnIndex2));
        }
        return streetPassRecord;
    }
}
