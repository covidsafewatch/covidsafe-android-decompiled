package io.reactivex.android;

import android.os.Looper;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class MainThreadDisposable implements Disposable {
    private final AtomicBoolean unsubscribed = new AtomicBoolean();

    /* access modifiers changed from: protected */
    public abstract void onDispose();

    public static void verifyMainThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("Expected to be called on the main thread but was " + Thread.currentThread().getName());
        }
    }

    public final boolean isDisposed() {
        return this.unsubscribed.get();
    }

    public final void dispose() {
        if (!this.unsubscribed.compareAndSet(false, true)) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            onDispose();
        } else {
            AndroidSchedulers.mainThread().scheduleDirect(new Runnable() {
                public void run() {
                    MainThreadDisposable.this.onDispose();
                }
            });
        }
    }
}
