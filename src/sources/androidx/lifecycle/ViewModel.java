package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class ViewModel {
    private final Map<String, Object> mBagOfTags = new HashMap();
    private volatile boolean mCleared = false;

    /* access modifiers changed from: protected */
    public void onCleared() {
    }

    /* access modifiers changed from: package-private */
    public final void clear() {
        this.mCleared = true;
        Map<String, Object> map = this.mBagOfTags;
        if (map != null) {
            synchronized (map) {
                for (Object closeWithRuntimeException : this.mBagOfTags.values()) {
                    closeWithRuntimeException(closeWithRuntimeException);
                }
            }
        }
        onCleared();
    }

    /* access modifiers changed from: package-private */
    public <T> T setTagIfAbsent(String str, T t) {
        T t2;
        synchronized (this.mBagOfTags) {
            t2 = this.mBagOfTags.get(str);
            if (t2 == null) {
                this.mBagOfTags.put(str, t);
            }
        }
        if (t2 != null) {
            t = t2;
        }
        if (this.mCleared) {
            closeWithRuntimeException(t);
        }
        return t;
    }

    /* access modifiers changed from: package-private */
    public <T> T getTag(String str) {
        T t;
        Map<String, Object> map = this.mBagOfTags;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            t = this.mBagOfTags.get(str);
        }
        return t;
    }

    private static void closeWithRuntimeException(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
