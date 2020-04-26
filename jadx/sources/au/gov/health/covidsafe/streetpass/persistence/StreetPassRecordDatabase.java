package au.gov.health.covidsafe.streetpass.persistence;

import android.content.Context;
import android.database.Cursor;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import au.gov.health.covidsafe.status.persistence.StatusRecordDao;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&¨\u0006\b"}, d2 = {"Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase;", "Landroidx/room/RoomDatabase;", "()V", "recordDao", "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDao;", "statusDao", "Lau/gov/health/covidsafe/status/persistence/StatusRecordDao;", "Companion", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: StreetPassRecordDatabase.kt */
public abstract class StreetPassRecordDatabase extends RoomDatabase {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static volatile StreetPassRecordDatabase INSTANCE;
    /* access modifiers changed from: private */
    public static final StreetPassRecordDatabase$Companion$MIGRATION_1_2$1 MIGRATION_1_2 = new StreetPassRecordDatabase$Companion$MIGRATION_1_2$1(1, 2);

    public abstract StreetPassRecordDao recordDao();

    public abstract StatusRecordDao statusDao();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0012"}, d2 = {"Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase$Companion;", "", "()V", "INSTANCE", "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase;", "MIGRATION_1_2", "au/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase$Companion$MIGRATION_1_2$1", "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase$Companion$MIGRATION_1_2$1;", "getDatabase", "context", "Landroid/content/Context;", "isFieldExist", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "tableName", "", "fieldName", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: StreetPassRecordDatabase.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final StreetPassRecordDatabase getDatabase(Context context) {
            StreetPassRecordDatabase streetPassRecordDatabase;
            Intrinsics.checkParameterIsNotNull(context, "context");
            StreetPassRecordDatabase access$getINSTANCE$cp = StreetPassRecordDatabase.INSTANCE;
            if (access$getINSTANCE$cp != null) {
                return access$getINSTANCE$cp;
            }
            synchronized (this) {
                StreetPassRecordDatabase build = Room.databaseBuilder(context, StreetPassRecordDatabase.class, "record_database").addMigrations(StreetPassRecordDatabase.MIGRATION_1_2).build();
                Intrinsics.checkExpressionValueIsNotNull(build, "Room.databaseBuilder(\n  …                 .build()");
                streetPassRecordDatabase = build;
                StreetPassRecordDatabase.INSTANCE = streetPassRecordDatabase;
            }
            return streetPassRecordDatabase;
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
}
