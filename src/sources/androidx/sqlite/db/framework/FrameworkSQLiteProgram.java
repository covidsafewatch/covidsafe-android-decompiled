package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteProgram;
import androidx.sqlite.db.SupportSQLiteProgram;

class FrameworkSQLiteProgram implements SupportSQLiteProgram {
    private final SQLiteProgram mDelegate;

    FrameworkSQLiteProgram(SQLiteProgram sQLiteProgram) {
        this.mDelegate = sQLiteProgram;
    }

    public void bindNull(int i) {
        this.mDelegate.bindNull(i);
    }

    public void bindLong(int i, long j) {
        this.mDelegate.bindLong(i, j);
    }

    public void bindDouble(int i, double d) {
        this.mDelegate.bindDouble(i, d);
    }

    public void bindString(int i, String str) {
        this.mDelegate.bindString(i, str);
    }

    public void bindBlob(int i, byte[] bArr) {
        this.mDelegate.bindBlob(i, bArr);
    }

    public void clearBindings() {
        this.mDelegate.clearBindings();
    }

    public void close() {
        this.mDelegate.close();
    }
}
