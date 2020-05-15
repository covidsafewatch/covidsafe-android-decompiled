package androidx.room;

import android.content.Context;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

public class DatabaseConfiguration {
    public final boolean allowDestructiveMigrationOnDowngrade;
    public final boolean allowMainThreadQueries;
    public final List<RoomDatabase.Callback> callbacks;
    public final Context context;
    public final String copyFromAssetPath;
    public final File copyFromFile;
    public final RoomDatabase.JournalMode journalMode;
    private final Set<Integer> mMigrationNotRequiredFrom;
    public final RoomDatabase.MigrationContainer migrationContainer;
    public final boolean multiInstanceInvalidation;
    public final String name;
    public final Executor queryExecutor;
    public final boolean requireMigration;
    public final SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory;
    public final Executor transactionExecutor;

    @Deprecated
    public DatabaseConfiguration(Context context2, String str, SupportSQLiteOpenHelper.Factory factory, RoomDatabase.MigrationContainer migrationContainer2, List<RoomDatabase.Callback> list, boolean z, RoomDatabase.JournalMode journalMode2, Executor executor, boolean z2, Set<Integer> set) {
        this(context2, str, factory, migrationContainer2, list, z, journalMode2, executor, executor, false, z2, false, set, (String) null, (File) null);
    }

    @Deprecated
    public DatabaseConfiguration(Context context2, String str, SupportSQLiteOpenHelper.Factory factory, RoomDatabase.MigrationContainer migrationContainer2, List<RoomDatabase.Callback> list, boolean z, RoomDatabase.JournalMode journalMode2, Executor executor, Executor executor2, boolean z2, boolean z3, boolean z4, Set<Integer> set) {
        this(context2, str, factory, migrationContainer2, list, z, journalMode2, executor, executor2, z2, z3, z4, set, (String) null, (File) null);
    }

    public DatabaseConfiguration(Context context2, String str, SupportSQLiteOpenHelper.Factory factory, RoomDatabase.MigrationContainer migrationContainer2, List<RoomDatabase.Callback> list, boolean z, RoomDatabase.JournalMode journalMode2, Executor executor, Executor executor2, boolean z2, boolean z3, boolean z4, Set<Integer> set, String str2, File file) {
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

    public boolean isMigrationRequired(int i, int i2) {
        Set<Integer> set;
        if ((i > i2) && this.allowDestructiveMigrationOnDowngrade) {
            return false;
        }
        if (!this.requireMigration || ((set = this.mMigrationNotRequiredFrom) != null && set.contains(Integer.valueOf(i)))) {
            return false;
        }
        return true;
    }
}
