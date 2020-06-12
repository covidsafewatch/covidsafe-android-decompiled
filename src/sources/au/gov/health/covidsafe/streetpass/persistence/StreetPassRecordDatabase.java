package au.gov.health.covidsafe.streetpass.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import androidx.core.app.NotificationCompat;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import au.gov.health.covidsafe.LocalBlobV2;
import au.gov.health.covidsafe.logging.CentralLog;
import au.gov.health.covidsafe.status.persistence.StatusRecordDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&¨\u0006\b"}, d2 = {"Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase;", "Landroidx/room/RoomDatabase;", "()V", "recordDao", "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDao;", "statusDao", "Lau/gov/health/covidsafe/status/persistence/StatusRecordDao;", "Companion", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: StreetPassRecordDatabase.kt */
public abstract class StreetPassRecordDatabase extends RoomDatabase {
    /* access modifiers changed from: private */
    public static final StreetPassRecordDatabase$Companion$CALLBACK$1 CALLBACK = new StreetPassRecordDatabase$Companion$CALLBACK$1();
    public static final Companion Companion;
    public static final String DUMMY_DEVICE = "";
    public static final int DUMMY_RSSI = 999;
    public static final int DUMMY_TXPOWER = 999;
    private static final String EMPTY_DICT = "{}";
    private static final byte[] EMPTY_DICT_BYTE_ARRAY;
    /* access modifiers changed from: private */
    public static final String ENCRYPTED_EMPTY_DICT = Encryption.INSTANCE.encryptPayload(EMPTY_DICT_BYTE_ARRAY);
    private static final int ID_COLUMN_INDEX = 0;
    /* access modifiers changed from: private */
    public static volatile StreetPassRecordDatabase INSTANCE = null;
    private static final int MESSAGE_COLUMN_INDEX = 3;
    /* access modifiers changed from: private */
    public static final StreetPassRecordDatabase$Companion$MIGRATION_1_2$1 MIGRATION_1_2 = new StreetPassRecordDatabase$Companion$MIGRATION_1_2$1(1, 2);
    /* access modifiers changed from: private */
    public static final StreetPassRecordDatabase$Companion$MIGRATION_2_3$1 MIGRATION_2_3 = new StreetPassRecordDatabase$Companion$MIGRATION_2_3$1(2, 3);
    private static final int MODELC_COLUMN_INDEX = 6;
    private static final int MODELP_COLUMN_INDEX = 5;
    private static final int ORG_COLUMN_INDEX = 4;
    private static final int RSSI_COLUMN_INDEX = 7;
    /* access modifiers changed from: private */
    public static final String TAG;
    private static final int TIMESTAMP_COLUMN_INDEX = 1;
    private static final int TX_POWER_COLUMN_INDEX = 8;
    private static final int VERSION_COLUMN_INDEX = 2;
    public static final int VERSION_ONE = 1;
    public static final int VERSION_TWO = 2;
    /* access modifiers changed from: private */
    public static MigrationCallBack migrationCallback;

    public abstract StreetPassRecordDao recordDao();

    public abstract StatusRecordDao statusDao();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0003\u0004\u0016\u0019\b\u0003\u0018\u00002\u00020\u0001:\u00017B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.J\u001a\u0010/\u001a\u00020\u00132\u0006\u00100\u001a\u0002012\n\b\u0002\u00102\u001a\u0004\u0018\u00010&J\u001e\u00103\u001a\u0002042\u0006\u0010-\u001a\u00020.2\u0006\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u0010\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u00068"}, d2 = {"Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase$Companion;", "", "()V", "CALLBACK", "au/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase$Companion$CALLBACK$1", "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase$Companion$CALLBACK$1;", "DUMMY_DEVICE", "", "DUMMY_RSSI", "", "DUMMY_TXPOWER", "EMPTY_DICT", "EMPTY_DICT_BYTE_ARRAY", "", "ENCRYPTED_EMPTY_DICT", "getENCRYPTED_EMPTY_DICT", "()Ljava/lang/String;", "ID_COLUMN_INDEX", "INSTANCE", "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase;", "MESSAGE_COLUMN_INDEX", "MIGRATION_1_2", "au/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase$Companion$MIGRATION_1_2$1", "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase$Companion$MIGRATION_1_2$1;", "MIGRATION_2_3", "au/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase$Companion$MIGRATION_2_3$1", "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase$Companion$MIGRATION_2_3$1;", "MODELC_COLUMN_INDEX", "MODELP_COLUMN_INDEX", "ORG_COLUMN_INDEX", "RSSI_COLUMN_INDEX", "TAG", "TIMESTAMP_COLUMN_INDEX", "TX_POWER_COLUMN_INDEX", "VERSION_COLUMN_INDEX", "VERSION_ONE", "VERSION_TWO", "migrationCallback", "Lau/gov/health/covidsafe/streetpass/persistence/MigrationCallBack;", "getMigrationCallback", "()Lau/gov/health/covidsafe/streetpass/persistence/MigrationCallBack;", "setMigrationCallback", "(Lau/gov/health/covidsafe/streetpass/persistence/MigrationCallBack;)V", "encryptExistingRecords", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "getDatabase", "context", "Landroid/content/Context;", "migrationCallBack", "isFieldExist", "", "tableName", "fieldName", "EncryptedRecord", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: StreetPassRecordDatabase.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getENCRYPTED_EMPTY_DICT() {
            return StreetPassRecordDatabase.ENCRYPTED_EMPTY_DICT;
        }

        public final MigrationCallBack getMigrationCallback() {
            return StreetPassRecordDatabase.migrationCallback;
        }

        public final void setMigrationCallback(MigrationCallBack migrationCallBack) {
            StreetPassRecordDatabase.migrationCallback = migrationCallBack;
        }

        public static /* synthetic */ StreetPassRecordDatabase getDatabase$default(Companion companion, Context context, MigrationCallBack migrationCallBack, int i, Object obj) {
            if ((i & 2) != 0) {
                migrationCallBack = null;
            }
            return companion.getDatabase(context, migrationCallBack);
        }

        public final StreetPassRecordDatabase getDatabase(Context context, MigrationCallBack migrationCallBack) {
            StreetPassRecordDatabase streetPassRecordDatabase;
            Intrinsics.checkParameterIsNotNull(context, "context");
            StreetPassRecordDatabase access$getINSTANCE$cp = StreetPassRecordDatabase.INSTANCE;
            if (access$getINSTANCE$cp != null) {
                return access$getINSTANCE$cp;
            }
            setMigrationCallback(migrationCallBack);
            synchronized (this) {
                StreetPassRecordDatabase build = Room.databaseBuilder(context, StreetPassRecordDatabase.class, "record_database").addMigrations(StreetPassRecordDatabase.MIGRATION_1_2, StreetPassRecordDatabase.MIGRATION_2_3).addCallback(StreetPassRecordDatabase.CALLBACK).build();
                Intrinsics.checkExpressionValueIsNotNull(build, "Room.databaseBuilder(\n  …                 .build()");
                streetPassRecordDatabase = build;
                StreetPassRecordDatabase.INSTANCE = streetPassRecordDatabase;
            }
            return streetPassRecordDatabase;
        }

        public final void encryptExistingRecords(SupportSQLiteDatabase supportSQLiteDatabase) {
            Integer num;
            String encryptPayload;
            SupportSQLiteDatabase supportSQLiteDatabase2 = supportSQLiteDatabase;
            Intrinsics.checkParameterIsNotNull(supportSQLiteDatabase2, "db");
            Gson create = new GsonBuilder().disableHtmlEscaping().create();
            Intrinsics.checkExpressionValueIsNotNull(create, "GsonBuilder().disableHtmlEscaping().create()");
            Cursor query = supportSQLiteDatabase2.query("SELECT * FROM record_table");
            CentralLog.Companion companion = CentralLog.Companion;
            String access$getTAG$cp = StreetPassRecordDatabase.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("starting encryption of ");
            Intrinsics.checkExpressionValueIsNotNull(query, "allRecs");
            sb.append(query.getCount());
            sb.append(" records");
            companion.d(access$getTAG$cp, sb.toString());
            if (query.moveToFirst()) {
                while (true) {
                    ContentValues contentValues = new ContentValues();
                    int i = query.getInt(0);
                    int i2 = query.getInt(2);
                    long j = query.getLong(1);
                    String string = query.getString(3);
                    String string2 = query.getString(4);
                    String string3 = query.getString(5);
                    String string4 = query.getString(6);
                    int i3 = query.getInt(7);
                    int i4 = query.getInt(8);
                    Intrinsics.checkExpressionValueIsNotNull(string3, "modelP");
                    Intrinsics.checkExpressionValueIsNotNull(string4, "modelC");
                    Integer valueOf = Integer.valueOf(i4);
                    Intrinsics.checkExpressionValueIsNotNull(string, NotificationCompat.CATEGORY_MESSAGE);
                    int i5 = i3;
                    String str = string4;
                    Cursor cursor = query;
                    String str2 = string3;
                    int i6 = i4;
                    long j2 = j;
                    String str3 = string2;
                    String json = create.toJson((Object) new EncryptedRecord(string3, str, i5, valueOf, string));
                    Intrinsics.checkExpressionValueIsNotNull(json, "gson.toJson(EncryptedRec…elC, rssi, txPower, msg))");
                    Charset charset = Charsets.UTF_8;
                    if (json != null) {
                        byte[] bytes = json.getBytes(charset);
                        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
                        if (i2 == 1) {
                            string = Encryption.INSTANCE.encryptPayload(bytes);
                        }
                        if (i2 == 1) {
                            encryptPayload = getENCRYPTED_EMPTY_DICT();
                        } else {
                            Integer num2 = null;
                            if (Intrinsics.areEqual((Object) "", (Object) str2)) {
                                str2 = null;
                            }
                            String str4 = str;
                            String str5 = Intrinsics.areEqual((Object) "", (Object) str4) ? null : str4;
                            int i7 = i5;
                            if (999 == i7) {
                                num = null;
                            } else {
                                num = Integer.valueOf(i7);
                            }
                            if (999 != i6) {
                                num2 = Integer.valueOf(i6);
                            }
                            String json2 = create.toJson((Object) new LocalBlobV2(str2, str5, num, num2));
                            Intrinsics.checkExpressionValueIsNotNull(json2, "gson.toJson(LocalBlobV2(…, modelC, rssi, txPower))");
                            Charset charset2 = Charsets.UTF_8;
                            if (json2 != null) {
                                byte[] bytes2 = json2.getBytes(charset2);
                                Intrinsics.checkExpressionValueIsNotNull(bytes2, "(this as java.lang.String).getBytes(charset)");
                                encryptPayload = Encryption.INSTANCE.encryptPayload(bytes2);
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                            }
                        }
                        contentValues.put("v", 2);
                        contentValues.put("org", str3);
                        contentValues.put("localBlob", encryptPayload);
                        contentValues.put("remoteBlob", string);
                        contentValues.put("id", Integer.valueOf(i));
                        contentValues.put("timestamp", Long.valueOf(j2));
                        SupportSQLiteDatabase supportSQLiteDatabase3 = supportSQLiteDatabase;
                        supportSQLiteDatabase3.insert("encrypted_record_table", 5, contentValues);
                        if (!cursor.moveToNext()) {
                            break;
                        }
                        SupportSQLiteDatabase supportSQLiteDatabase4 = supportSQLiteDatabase3;
                        query = cursor;
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                }
            }
            CentralLog.Companion.d(StreetPassRecordDatabase.TAG, "encryption done");
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase$Companion$EncryptedRecord;", "", "modelP", "", "modelC", "rssi", "", "txPower", "msg", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;)V", "getModelC", "()Ljava/lang/String;", "setModelC", "(Ljava/lang/String;)V", "getModelP", "setModelP", "getMsg", "setMsg", "getRssi", "()I", "setRssi", "(I)V", "getTxPower", "()Ljava/lang/Integer;", "setTxPower", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "app_release"}, k = 1, mv = {1, 1, 16})
        /* compiled from: StreetPassRecordDatabase.kt */
        public static final class EncryptedRecord {
            private String modelC;
            private String modelP;
            private String msg;
            private int rssi;
            private Integer txPower;

            public EncryptedRecord(String str, String str2, int i, Integer num, String str3) {
                Intrinsics.checkParameterIsNotNull(str, "modelP");
                Intrinsics.checkParameterIsNotNull(str2, "modelC");
                Intrinsics.checkParameterIsNotNull(str3, NotificationCompat.CATEGORY_MESSAGE);
                this.modelP = str;
                this.modelC = str2;
                this.rssi = i;
                this.txPower = num;
                this.msg = str3;
            }

            public final String getModelC() {
                return this.modelC;
            }

            public final String getModelP() {
                return this.modelP;
            }

            public final String getMsg() {
                return this.msg;
            }

            public final int getRssi() {
                return this.rssi;
            }

            public final Integer getTxPower() {
                return this.txPower;
            }

            public final void setModelC(String str) {
                Intrinsics.checkParameterIsNotNull(str, "<set-?>");
                this.modelC = str;
            }

            public final void setModelP(String str) {
                Intrinsics.checkParameterIsNotNull(str, "<set-?>");
                this.modelP = str;
            }

            public final void setMsg(String str) {
                Intrinsics.checkParameterIsNotNull(str, "<set-?>");
                this.msg = str;
            }

            public final void setRssi(int i) {
                this.rssi = i;
            }

            public final void setTxPower(Integer num) {
                this.txPower = num;
            }
        }

        public final boolean isFieldExist(SupportSQLiteDatabase supportSQLiteDatabase, String str, String str2) {
            Intrinsics.checkParameterIsNotNull(supportSQLiteDatabase, "db");
            Intrinsics.checkParameterIsNotNull(str, "tableName");
            Intrinsics.checkParameterIsNotNull(str2, "fieldName");
            Cursor query = supportSQLiteDatabase.query("PRAGMA table_info(" + str + ')', (Object[]) null);
            query.moveToFirst();
            boolean z = false;
            do {
                if (Intrinsics.areEqual((Object) query.getString(1), (Object) str2)) {
                    z = true;
                }
            } while (query.moveToNext());
            return z;
        }
    }

    static {
        Companion companion = new Companion((DefaultConstructorMarker) null);
        Companion = companion;
        String simpleName = companion.getClass().getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "this.javaClass.simpleName");
        TAG = simpleName;
        byte[] bytes = EMPTY_DICT.getBytes(Charsets.UTF_8);
        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        EMPTY_DICT_BYTE_ARRAY = bytes;
    }
}
