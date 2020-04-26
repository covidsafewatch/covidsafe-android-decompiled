package androidx.room;

import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Factory;
import java.io.File;

class SQLiteCopyOpenHelperFactory implements Factory {
    private final String mCopyFromAssetPath;
    private final File mCopyFromFile;
    private final Factory mDelegate;

    SQLiteCopyOpenHelperFactory(String str, File file, Factory factory) {
        this.mCopyFromAssetPath = str;
        this.mCopyFromFile = file;
        this.mDelegate = factory;
    }

    public SupportSQLiteOpenHelper create(Configuration configuration) {
        SQLiteCopyOpenHelper sQLiteCopyOpenHelper = new SQLiteCopyOpenHelper(configuration.context, this.mCopyFromAssetPath, this.mCopyFromFile, configuration.callback.version, this.mDelegate.create(configuration));
        return sQLiteCopyOpenHelper;
    }
}
