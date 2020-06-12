package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class ScheduledRunnable extends AtomicReferenceArray<Object> implements Runnable, Callable<Object>, Disposable {
    static final Object ASYNC_DISPOSED = new Object();
    static final Object DONE = new Object();
    static final int FUTURE_INDEX = 1;
    static final Object PARENT_DISPOSED = new Object();
    static final int PARENT_INDEX = 0;
    static final Object SYNC_DISPOSED = new Object();
    static final int THREAD_INDEX = 2;
    private static final long serialVersionUID = -6120223772001106981L;
    final Runnable actual;

    public ScheduledRunnable(Runnable runnable, DisposableContainer disposableContainer) {
        super(3);
        this.actual = runnable;
        lazySet(0, disposableContainer);
    }

    public Object call() {
        run();
        return null;
    }

    public void run() {
        Object obj;
        Object obj2;
        lazySet(2, Thread.currentThread());
        try {
            this.actual.run();
        } catch (Throwable th) {
            lazySet(2, (Object) null);
            Object obj3 = get(0);
            if (!(obj3 == PARENT_DISPOSED || !compareAndSet(0, obj3, DONE) || obj3 == null)) {
                ((DisposableContainer) obj3).delete(this);
            }
            do {
                obj2 = get(1);
                if (obj2 == SYNC_DISPOSED || obj2 == ASYNC_DISPOSED || compareAndSet(1, obj2, DONE)) {
                    throw th;
                }
                obj2 = get(1);
                break;
            } while (compareAndSet(1, obj2, DONE));
            throw th;
        }
        lazySet(2, (Object) null);
        Object obj4 = get(0);
        if (!(obj4 == PARENT_DISPOSED || !compareAndSet(0, obj4, DONE) || obj4 == null)) {
            ((DisposableContainer) obj4).delete(this);
        }
        do {
            obj = get(1);
            if (obj == SYNC_DISPOSED || obj == ASYNC_DISPOSED || compareAndSet(1, obj, DONE)) {
            }
            obj = get(1);
            return;
        } while (compareAndSet(1, obj, DONE));
    }

    public void setFuture(Future<?> future) {
        Object obj;
        do {
            obj = get(1);
            if (obj != DONE) {
                if (obj == SYNC_DISPOSED) {
                    future.cancel(false);
                    return;
                } else if (obj == ASYNC_DISPOSED) {
                    future.cancel(true);
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dispose() {
        /*
            r5 = this;
        L_0x0000:
            r0 = 1
            java.lang.Object r1 = r5.get(r0)
            java.lang.Object r2 = DONE
            r3 = 0
            if (r1 == r2) goto L_0x0035
            java.lang.Object r2 = SYNC_DISPOSED
            if (r1 == r2) goto L_0x0035
            java.lang.Object r2 = ASYNC_DISPOSED
            if (r1 != r2) goto L_0x0013
            goto L_0x0035
        L_0x0013:
            r2 = 2
            java.lang.Object r2 = r5.get(r2)
            java.lang.Thread r4 = java.lang.Thread.currentThread()
            if (r2 == r4) goto L_0x0020
            r2 = 1
            goto L_0x0021
        L_0x0020:
            r2 = 0
        L_0x0021:
            if (r2 == 0) goto L_0x0026
            java.lang.Object r4 = ASYNC_DISPOSED
            goto L_0x0028
        L_0x0026:
            java.lang.Object r4 = SYNC_DISPOSED
        L_0x0028:
            boolean r0 = r5.compareAndSet(r0, r1, r4)
            if (r0 == 0) goto L_0x0000
            if (r1 == 0) goto L_0x0035
            java.util.concurrent.Future r1 = (java.util.concurrent.Future) r1
            r1.cancel(r2)
        L_0x0035:
            java.lang.Object r0 = r5.get(r3)
            java.lang.Object r1 = DONE
            if (r0 == r1) goto L_0x004f
            java.lang.Object r1 = PARENT_DISPOSED
            if (r0 == r1) goto L_0x004f
            if (r0 != 0) goto L_0x0044
            goto L_0x004f
        L_0x0044:
            boolean r1 = r5.compareAndSet(r3, r0, r1)
            if (r1 == 0) goto L_0x0035
            io.reactivex.internal.disposables.DisposableContainer r0 = (io.reactivex.internal.disposables.DisposableContainer) r0
            r0.delete(r5)
        L_0x004f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.schedulers.ScheduledRunnable.dispose():void");
    }

    public boolean isDisposed() {
        Object obj = get(0);
        if (obj == PARENT_DISPOSED || obj == DONE) {
            return true;
        }
        return false;
    }
}
