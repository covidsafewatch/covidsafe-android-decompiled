package rx.internal.util;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Producer;

public final class BackpressureDrainManager extends AtomicLong implements Producer {
    private static final long serialVersionUID = 2826241102729529449L;
    final BackpressureQueueCallback actual;
    boolean emitting;
    Throwable exception;
    volatile boolean terminated;

    public interface BackpressureQueueCallback {
        boolean accept(Object obj);

        void complete(Throwable th);

        Object peek();

        Object poll();
    }

    public BackpressureDrainManager(BackpressureQueueCallback backpressureQueueCallback) {
        this.actual = backpressureQueueCallback;
    }

    public boolean isTerminated() {
        return this.terminated;
    }

    public void terminate() {
        this.terminated = true;
    }

    public void terminate(Throwable th) {
        if (!this.terminated) {
            this.exception = th;
            this.terminated = true;
        }
    }

    public void terminateAndDrain() {
        this.terminated = true;
        drain();
    }

    public void terminateAndDrain(Throwable th) {
        if (!this.terminated) {
            this.exception = th;
            this.terminated = true;
            drain();
        }
    }

    public void request(long j) {
        boolean z;
        if (j != 0) {
            while (true) {
                long j2 = get();
                boolean z2 = true;
                z = j2 == 0;
                long j3 = LongCompanionObject.MAX_VALUE;
                if (j2 == LongCompanionObject.MAX_VALUE) {
                    break;
                }
                if (j == LongCompanionObject.MAX_VALUE) {
                    j3 = j;
                } else {
                    if (j2 <= LongCompanionObject.MAX_VALUE - j) {
                        j3 = j2 + j;
                    }
                    z2 = z;
                }
                if (compareAndSet(j2, j3)) {
                    z = z2;
                    break;
                }
            }
            if (z) {
                drain();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r5 = r13.actual;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0014, code lost:
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0015, code lost:
        r9 = (r2 > 0 ? 1 : (r2 == 0 ? 0 : -1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0019, code lost:
        if (r9 > 0) goto L_0x001d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001b, code lost:
        if (r1 == false) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001d, code lost:
        if (r1 == false) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0023, code lost:
        if (r5.peek() != null) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r5.complete(r13.exception);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002b, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002e, code lost:
        if (r9 != 0) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r9 = r5.poll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0035, code lost:
        if (r9 != null) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0037, code lost:
        monitor-enter(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r1 = r13.terminated;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x003e, code lost:
        if (r5.peek() == null) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0040, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0042, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x004e, code lost:
        if (get() != kotlin.jvm.internal.LongCompanionObject.MAX_VALUE) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0050, code lost:
        if (r2 != false) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0052, code lost:
        if (r1 != false) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        r13.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0056, code lost:
        monitor-exit(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0057, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0058, code lost:
        r2 = Long.MAX_VALUE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        r9 = addAndGet((long) (-r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0062, code lost:
        if (r9 == 0) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0064, code lost:
        if (r2 != false) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0066, code lost:
        if (r1 == false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0068, code lost:
        if (r2 == false) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x006b, code lost:
        r2 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x006c, code lost:
        monitor-exit(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        r13.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0070, code lost:
        monitor-exit(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0071, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0072, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0073, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0074, code lost:
        monitor-exit(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0076, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x007c, code lost:
        if (r5.accept(r9) == false) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x007e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x007f, code lost:
        r2 = r2 - 1;
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0085, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0086, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0087, code lost:
        if (r0 == false) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0089, code lost:
        monitor-enter(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        r13.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0091, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000d, code lost:
        r2 = get();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void drain() {
        /*
            r13 = this;
            monitor-enter(r13)
            boolean r0 = r13.emitting     // Catch:{ all -> 0x0092 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r13)     // Catch:{ all -> 0x0092 }
            return
        L_0x0007:
            r0 = 1
            r13.emitting = r0     // Catch:{ all -> 0x0092 }
            boolean r1 = r13.terminated     // Catch:{ all -> 0x0092 }
            monitor-exit(r13)     // Catch:{ all -> 0x0092 }
            long r2 = r13.get()
            r4 = 0
            rx.internal.util.BackpressureDrainManager$BackpressureQueueCallback r5 = r13.actual     // Catch:{ all -> 0x0085 }
        L_0x0014:
            r6 = r4
        L_0x0015:
            r7 = 0
            int r9 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r9 > 0) goto L_0x001d
            if (r1 == 0) goto L_0x0037
        L_0x001d:
            if (r1 == 0) goto L_0x0031
            java.lang.Object r10 = r5.peek()     // Catch:{ all -> 0x0085 }
            if (r10 != 0) goto L_0x002e
            java.lang.Throwable r1 = r13.exception     // Catch:{ all -> 0x002b }
            r5.complete(r1)     // Catch:{ all -> 0x002b }
            return
        L_0x002b:
            r1 = move-exception
            goto L_0x0087
        L_0x002e:
            if (r9 != 0) goto L_0x0031
            goto L_0x0037
        L_0x0031:
            java.lang.Object r9 = r5.poll()     // Catch:{ all -> 0x0085 }
            if (r9 != 0) goto L_0x0078
        L_0x0037:
            monitor-enter(r13)     // Catch:{ all -> 0x0085 }
            boolean r1 = r13.terminated     // Catch:{ all -> 0x0072 }
            java.lang.Object r2 = r5.peek()     // Catch:{ all -> 0x0072 }
            if (r2 == 0) goto L_0x0042
            r2 = r0
            goto L_0x0043
        L_0x0042:
            r2 = r4
        L_0x0043:
            long r9 = r13.get()     // Catch:{ all -> 0x0072 }
            r11 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r3 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r3 != 0) goto L_0x005a
            if (r2 != 0) goto L_0x0058
            if (r1 != 0) goto L_0x0058
            r13.emitting = r4     // Catch:{ all -> 0x0076 }
            monitor-exit(r13)     // Catch:{ all -> 0x0076 }
            return
        L_0x0058:
            r2 = r11
            goto L_0x006c
        L_0x005a:
            int r3 = -r6
            long r9 = (long) r3
            long r9 = r13.addAndGet(r9)     // Catch:{ all -> 0x0072 }
            int r3 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x0066
            if (r2 != 0) goto L_0x006b
        L_0x0066:
            if (r1 == 0) goto L_0x006e
            if (r2 == 0) goto L_0x006b
            goto L_0x006e
        L_0x006b:
            r2 = r9
        L_0x006c:
            monitor-exit(r13)     // Catch:{ all -> 0x0072 }
            goto L_0x0014
        L_0x006e:
            r13.emitting = r4     // Catch:{ all -> 0x0076 }
            monitor-exit(r13)     // Catch:{ all -> 0x0076 }
            return
        L_0x0072:
            r1 = move-exception
            r0 = r4
        L_0x0074:
            monitor-exit(r13)     // Catch:{ all -> 0x0076 }
            throw r1     // Catch:{ all -> 0x002b }
        L_0x0076:
            r1 = move-exception
            goto L_0x0074
        L_0x0078:
            boolean r7 = r5.accept(r9)     // Catch:{ all -> 0x0085 }
            if (r7 == 0) goto L_0x007f
            return
        L_0x007f:
            r7 = 1
            long r2 = r2 - r7
            int r6 = r6 + 1
            goto L_0x0015
        L_0x0085:
            r1 = move-exception
            r0 = r4
        L_0x0087:
            if (r0 != 0) goto L_0x0091
            monitor-enter(r13)
            r13.emitting = r4     // Catch:{ all -> 0x008e }
            monitor-exit(r13)     // Catch:{ all -> 0x008e }
            goto L_0x0091
        L_0x008e:
            r0 = move-exception
            monitor-exit(r13)     // Catch:{ all -> 0x008e }
            throw r0
        L_0x0091:
            throw r1
        L_0x0092:
            r0 = move-exception
            monitor-exit(r13)     // Catch:{ all -> 0x0092 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.util.BackpressureDrainManager.drain():void");
    }
}
