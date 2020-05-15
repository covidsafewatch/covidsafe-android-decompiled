package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\t\u0010\u0006\u001a\u00020\u0007H\b\u001a\t\u0010\b\u001a\u00020\u0007H\b\u001a\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\b\u001a\t\u0010\u000e\u001a\u00020\nH\b\u001a\t\u0010\u000f\u001a\u00020\nH\b\u001a\t\u0010\u0010\u001a\u00020\nH\b\u001a\u0011\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\b\u001a\t\u0010\u0014\u001a\u00020\nH\b\u001a\u0019\u0010\u0015\u001a\u00060\u0016j\u0002`\u00172\n\u0010\u0018\u001a\u00060\u0016j\u0002`\u0017H\b\"\u001c\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0004\b\u0004\u0010\u0005¨\u0006\u0019"}, d2 = {"timeSource", "Lkotlinx/coroutines/TimeSource;", "getTimeSource", "()Lkotlinx/coroutines/TimeSource;", "setTimeSource", "(Lkotlinx/coroutines/TimeSource;)V", "currentTimeMillis", "", "nanoTime", "parkNanos", "", "blocker", "", "nanos", "registerTimeLoopThread", "trackTask", "unTrackTask", "unpark", "thread", "Ljava/lang/Thread;", "unregisterTimeLoopThread", "wrapTask", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 16})
/* compiled from: TimeSource.kt */
public final class TimeSourceKt {
    private static TimeSource timeSource;

    public static final TimeSource getTimeSource() {
        return timeSource;
    }

    public static final void setTimeSource(TimeSource timeSource2) {
        timeSource = timeSource2;
    }

    private static final long currentTimeMillis() {
        TimeSource timeSource2 = getTimeSource();
        return timeSource2 != null ? timeSource2.currentTimeMillis() : System.currentTimeMillis();
    }

    private static final long nanoTime() {
        TimeSource timeSource2 = getTimeSource();
        return timeSource2 != null ? timeSource2.nanoTime() : System.nanoTime();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.wrapTask(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final java.lang.Runnable wrapTask(java.lang.Runnable r1) {
        /*
            kotlinx.coroutines.TimeSource r0 = getTimeSource()
            if (r0 == 0) goto L_0x000d
            java.lang.Runnable r0 = r0.wrapTask(r1)
            if (r0 == 0) goto L_0x000d
            r1 = r0
        L_0x000d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.TimeSourceKt.wrapTask(java.lang.Runnable):java.lang.Runnable");
    }

    private static final void trackTask() {
        TimeSource timeSource2 = getTimeSource();
        if (timeSource2 != null) {
            timeSource2.trackTask();
        }
    }

    private static final void unTrackTask() {
        TimeSource timeSource2 = getTimeSource();
        if (timeSource2 != null) {
            timeSource2.unTrackTask();
        }
    }

    private static final void registerTimeLoopThread() {
        TimeSource timeSource2 = getTimeSource();
        if (timeSource2 != null) {
            timeSource2.registerTimeLoopThread();
        }
    }

    private static final void unregisterTimeLoopThread() {
        TimeSource timeSource2 = getTimeSource();
        if (timeSource2 != null) {
            timeSource2.unregisterTimeLoopThread();
        }
    }

    private static final void parkNanos(Object obj, long j) {
        TimeSource timeSource2 = getTimeSource();
        if (timeSource2 != null) {
            timeSource2.parkNanos(obj, j);
        } else {
            LockSupport.parkNanos(obj, j);
        }
    }

    private static final void unpark(Thread thread) {
        TimeSource timeSource2 = getTimeSource();
        if (timeSource2 != null) {
            timeSource2.unpark(thread);
        } else {
            LockSupport.unpark(thread);
        }
    }
}
