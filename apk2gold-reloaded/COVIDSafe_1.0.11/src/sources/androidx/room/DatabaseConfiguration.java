package androidx.room;

import android.content.Context;
import androidx.room.RoomDatabase.Callback;
import androidx.room.RoomDatabase.JournalMode;
import androidx.room.RoomDatabase.MigrationContainer;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Factory;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

public class DatabaseConfiguration {
    public final boolean allowDestructiveMigrationOnDowngrade;
    public final boolean allowMainThreadQueries;
    public final List<Callback> callbacks;
    public final Context context;
    public final String copyFromAssetPath;
    public final File copyFromFile;
    public final JournalMode journalMode;
    private final Set<Integer> mMigrationNotRequiredFrom;
    public final MigrationContainer migrationContainer;
    public final boolean multiInstanceInvalidation;
    public final String name;
    public final Executor queryExecutor;
    public final boolean requireMigration;
    public final Factory sqliteOpenHelperFactory;
    public final Executor transactionExecutor;

    @Deprecated
    public DatabaseConfiguration(Context context2, String str, Factory factory, MigrationContainer migrationContainer2, List<Callback> list, boolean z, JournalMode journalMode2, Executor executor, boolean z2, Set<Integer> set) {
        this(context2, str, factory, migrationContainer2, list, z, journalMode2, executor, executor, false, z2, false, set, null, null);
    }

    @Deprecated
    public DatabaseConfiguration(Context context2, String str, Factory factory, MigrationContainer migrationContainer2, List<Callback> list, boolean z, JournalMode journalMode2, Executor executor, Executor executor2, boolean z2, boolean z3, boolean z4, Set<Integer> set) {
        this(context2, str, factory, migrationContainer2, list, z, journalMode2, executor, executor2, z2, z3, z4, set, null, null);
    }

    public DatabaseConfiguration(Context context2, String str, Factory factory, MigrationContainer migrationContainer2, List<Callback> list, boolean z, JournalMode journalMode2, Executor executor, Executor executor2, boolean z2, boolean z3, boolean z4, Set<Integer> set, String str2, File file) {
        this.sqliteOpenHelperFactory = factory;
        this.context = context2;
        this.name = str;
        this.migrationContainer = migrationContainer2;
        this.callbacks = list;
        this.allowMainThreadQueries = z;
        this.journalMode = journalMode2;
        this.queryExecutor = executor;
        this.transactionExecutor = executor2;
        this.multiInstanceInvalidation = z2;
        this.requireMigration = z3;
        this.allowDestructiveMigrationOnDowngrade = z4;
        this.mMigrationNotRequiredFrom = set;
        this.copyFromAssetPath = str2;
        this.copyFromFile = file;
    }

    @Deprecated
    public boolean isMigrationRequiredFrom(int i) {
        return isMigrationRequired(i, i + 1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001e, code lost:
        if (r4.contains(java.lang.Integer.valueOf(r3)) != false) goto L_0x0021;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isMigrationRequired(int r3, int r4) {
        /*
            r2 = this;
            r0 = 1
            r1 = 0
            if (r3 <= r4) goto L_0x0006
            r4 = r0
            goto L_0x0007
        L_0x0006:
            r4 = r1
        L_0x0007:
            if (r4 == 0) goto L_0x000e
            boolean r4 = r2.allowDestructiveMigrationOnDowngrade
            if (r4 == 0) goto L_0x000e
            return r1
        L_0x000e:
            boolean r4 = r2.requireMigration
            if (r4 == 0) goto L_0x0021
            java.util.Set<java.lang.Integer> r4 = r2.mMigrationNotRequiredFrom
            if (r4 == 0) goto L_0x0022
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            boolean r3 = r4.contains(r3)
            if (r3 != 0) goto L_0x0021
            goto L_0x0022
        L_0x0021:
            r0 = r1
        L_0x0022:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.DatabaseConfiguration.isMigrationRequired(int, int):boolean");
    }
}
