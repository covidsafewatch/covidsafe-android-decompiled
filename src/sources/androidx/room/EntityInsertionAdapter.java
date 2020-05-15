package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class EntityInsertionAdapter<T> extends SharedSQLiteStatement {
    /* access modifiers changed from: protected */
    public abstract void bind(SupportSQLiteStatement supportSQLiteStatement, T t);

    public EntityInsertionAdapter(RoomDatabase roomDatabase) {
        super(roomDatabase);
    }

    public final void insert(T t) {
        SupportSQLiteStatement acquire = acquire();
        try {
            bind(acquire, t);
            acquire.executeInsert();
        } finally {
            release(acquire);
        }
    }

    public final void insert(T[] tArr) {
        SupportSQLiteStatement acquire = acquire();
        try {
            for (T bind : tArr) {
                bind(acquire, bind);
                acquire.executeInsert();
            }
        } finally {
            release(acquire);
        }
    }

    public final void insert(Iterable<? extends T> iterable) {
        SupportSQLiteStatement acquire = acquire();
        try {
            for (Object bind : iterable) {
                bind(acquire, bind);
                acquire.executeInsert();
            }
        } finally {
            release(acquire);
        }
    }

    public final long insertAndReturnId(T t) {
        SupportSQLiteStatement acquire = acquire();
        try {
            bind(acquire, t);
            return acquire.executeInsert();
        } finally {
            release(acquire);
        }
    }

    public final long[] insertAndReturnIdsArray(Collection<? extends T> collection) {
        SupportSQLiteStatement acquire = acquire();
        try {
            long[] jArr = new long[collection.size()];
            int i = 0;
            for (Object bind : collection) {
                bind(acquire, bind);
                jArr[i] = acquire.executeInsert();
                i++;
            }
            return jArr;
        } finally {
            release(acquire);
        }
    }

    public final long[] insertAndReturnIdsArray(T[] tArr) {
        SupportSQLiteStatement acquire = acquire();
        try {
            long[] jArr = new long[tArr.length];
            int i = 0;
            for (T bind : tArr) {
                bind(acquire, bind);
                jArr[i] = acquire.executeInsert();
                i++;
            }
            return jArr;
        } finally {
            release(acquire);
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(Collection<? extends T> collection) {
        SupportSQLiteStatement acquire = acquire();
        try {
            Long[] lArr = new Long[collection.size()];
            int i = 0;
            for (Object bind : collection) {
                bind(acquire, bind);
                lArr[i] = Long.valueOf(acquire.executeInsert());
                i++;
            }
            return lArr;
        } finally {
            release(acquire);
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(T[] tArr) {
        SupportSQLiteStatement acquire = acquire();
        try {
            Long[] lArr = new Long[tArr.length];
            int i = 0;
            for (T bind : tArr) {
                bind(acquire, bind);
                lArr[i] = Long.valueOf(acquire.executeInsert());
                i++;
            }
            return lArr;
        } finally {
            release(acquire);
        }
    }

    public final List<Long> insertAndReturnIdsList(T[] tArr) {
        SupportSQLiteStatement acquire = acquire();
        try {
            ArrayList arrayList = new ArrayList(tArr.length);
            int i = 0;
            for (T bind : tArr) {
                bind(acquire, bind);
                arrayList.add(i, Long.valueOf(acquire.executeInsert()));
                i++;
            }
            return arrayList;
        } finally {
            release(acquire);
        }
    }

    public final List<Long> insertAndReturnIdsList(Collection<? extends T> collection) {
        SupportSQLiteStatement acquire = acquire();
        try {
            ArrayList arrayList = new ArrayList(collection.size());
            int i = 0;
            for (Object bind : collection) {
                bind(acquire, bind);
                arrayList.add(i, Long.valueOf(acquire.executeInsert()));
                i++;
            }
            return arrayList;
        } finally {
            release(acquire);
        }
    }
}
