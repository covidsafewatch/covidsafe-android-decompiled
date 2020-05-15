package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Monitor {
    private Guard activeGuards;
    private final boolean fair;
    /* access modifiers changed from: private */
    public final ReentrantLock lock;

    public static abstract class Guard {
        final Condition condition;
        final Monitor monitor;
        @NullableDecl
        Guard next;
        int waiterCount = 0;

        public abstract boolean isSatisfied();

        protected Guard(Monitor monitor2) {
            this.monitor = (Monitor) Preconditions.checkNotNull(monitor2, "monitor");
            this.condition = monitor2.lock.newCondition();
        }
    }

    public Monitor() {
        this(false);
    }

    public Monitor(boolean z) {
        this.activeGuards = null;
        this.fair = z;
        this.lock = new ReentrantLock(z);
    }

    public void enter() {
        this.lock.lock();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:14|15|16) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r4 = remainingNanos(java.lang.System.nanoTime(), r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0031, code lost:
        r8 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0037, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x002b */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0037  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean enter(long r8, java.util.concurrent.TimeUnit r10) {
        /*
            r7 = this;
            long r8 = toSafeNanos(r8, r10)
            java.util.concurrent.locks.ReentrantLock r10 = r7.lock
            boolean r0 = r7.fair
            r1 = 1
            if (r0 != 0) goto L_0x0012
            boolean r0 = r10.tryLock()
            if (r0 == 0) goto L_0x0012
            return r1
        L_0x0012:
            boolean r0 = java.lang.Thread.interrupted()
            long r2 = java.lang.System.nanoTime()     // Catch:{ all -> 0x0033 }
            r4 = r8
        L_0x001b:
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ InterruptedException -> 0x002b }
            boolean r8 = r10.tryLock(r4, r6)     // Catch:{ InterruptedException -> 0x002b }
            if (r0 == 0) goto L_0x002a
            java.lang.Thread r9 = java.lang.Thread.currentThread()
            r9.interrupt()
        L_0x002a:
            return r8
        L_0x002b:
            long r4 = remainingNanos(r2, r8)     // Catch:{ all -> 0x0031 }
            r0 = r1
            goto L_0x001b
        L_0x0031:
            r8 = move-exception
            goto L_0x0035
        L_0x0033:
            r8 = move-exception
            r1 = r0
        L_0x0035:
            if (r1 == 0) goto L_0x003e
            java.lang.Thread r9 = java.lang.Thread.currentThread()
            r9.interrupt()
        L_0x003e:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Monitor.enter(long, java.util.concurrent.TimeUnit):boolean");
    }

    public void enterInterruptibly() throws InterruptedException {
        this.lock.lockInterruptibly();
    }

    public boolean enterInterruptibly(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.lock.tryLock(j, timeUnit);
    }

    public boolean tryEnter() {
        return this.lock.tryLock();
    }

    public void enterWhen(Guard guard) throws InterruptedException {
        if (guard.monitor == this) {
            ReentrantLock reentrantLock = this.lock;
            boolean isHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
            reentrantLock.lockInterruptibly();
            try {
                if (!guard.isSatisfied()) {
                    await(guard, isHeldByCurrentThread);
                }
            } catch (Throwable th) {
                leave();
                throw th;
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0047, code lost:
        if (awaitNanos(r11, r0, r3) != false) goto L_0x0049;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003a A[Catch:{ all -> 0x0050, all -> 0x0057 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean enterWhen(com.google.common.util.concurrent.Monitor.Guard r11, long r12, java.util.concurrent.TimeUnit r14) throws java.lang.InterruptedException {
        /*
            r10 = this;
            long r0 = toSafeNanos(r12, r14)
            com.google.common.util.concurrent.Monitor r2 = r11.monitor
            if (r2 != r10) goto L_0x0060
            java.util.concurrent.locks.ReentrantLock r2 = r10.lock
            boolean r3 = r2.isHeldByCurrentThread()
            boolean r4 = r10.fair
            r5 = 0
            r6 = 0
            if (r4 != 0) goto L_0x0029
            boolean r4 = java.lang.Thread.interrupted()
            if (r4 != 0) goto L_0x0023
            boolean r4 = r2.tryLock()
            if (r4 == 0) goto L_0x0029
            r8 = r6
            goto L_0x0034
        L_0x0023:
            java.lang.InterruptedException r11 = new java.lang.InterruptedException
            r11.<init>()
            throw r11
        L_0x0029:
            long r8 = initNanoTime(r0)
            boolean r12 = r2.tryLock(r12, r14)
            if (r12 != 0) goto L_0x0034
            return r5
        L_0x0034:
            boolean r12 = r11.isSatisfied()     // Catch:{ all -> 0x0050 }
            if (r12 != 0) goto L_0x0049
            int r12 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r12 != 0) goto L_0x003f
            goto L_0x0043
        L_0x003f:
            long r0 = remainingNanos(r8, r0)     // Catch:{ all -> 0x0050 }
        L_0x0043:
            boolean r11 = r10.awaitNanos(r11, r0, r3)     // Catch:{ all -> 0x0050 }
            if (r11 == 0) goto L_0x004a
        L_0x0049:
            r5 = 1
        L_0x004a:
            if (r5 != 0) goto L_0x004f
            r2.unlock()
        L_0x004f:
            return r5
        L_0x0050:
            r11 = move-exception
            if (r3 != 0) goto L_0x005c
            r10.signalNextWaiter()     // Catch:{ all -> 0x0057 }
            goto L_0x005c
        L_0x0057:
            r11 = move-exception
            r2.unlock()
            throw r11
        L_0x005c:
            r2.unlock()
            throw r11
        L_0x0060:
            java.lang.IllegalMonitorStateException r11 = new java.lang.IllegalMonitorStateException
            r11.<init>()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Monitor.enterWhen(com.google.common.util.concurrent.Monitor$Guard, long, java.util.concurrent.TimeUnit):boolean");
    }

    public void enterWhenUninterruptibly(Guard guard) {
        if (guard.monitor == this) {
            ReentrantLock reentrantLock = this.lock;
            boolean isHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
            reentrantLock.lock();
            try {
                if (!guard.isSatisfied()) {
                    awaitUninterruptibly(guard, isHeldByCurrentThread);
                }
            } catch (Throwable th) {
                leave();
                throw th;
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:39|40|41) */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        r9 = remainingNanos(r7, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0070, code lost:
        r12 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0071, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0076, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x006a */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0036 A[Catch:{ InterruptedException -> 0x005d, all -> 0x0058, all -> 0x0073 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0037 A[Catch:{ InterruptedException -> 0x005d, all -> 0x0058, all -> 0x0073 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004b A[SYNTHETIC, Splitter:B:25:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean enterWhenUninterruptibly(com.google.common.util.concurrent.Monitor.Guard r12, long r13, java.util.concurrent.TimeUnit r15) {
        /*
            r11 = this;
            long r13 = toSafeNanos(r13, r15)
            com.google.common.util.concurrent.Monitor r15 = r12.monitor
            if (r15 != r11) goto L_0x007e
            java.util.concurrent.locks.ReentrantLock r15 = r11.lock
            boolean r0 = r15.isHeldByCurrentThread()
            boolean r1 = java.lang.Thread.interrupted()
            r2 = 1
            boolean r3 = r11.fair     // Catch:{ all -> 0x0073 }
            r4 = 0
            r5 = 0
            if (r3 != 0) goto L_0x0023
            boolean r3 = r15.tryLock()     // Catch:{ all -> 0x0073 }
            if (r3 != 0) goto L_0x0021
            goto L_0x0023
        L_0x0021:
            r7 = r5
            goto L_0x0030
        L_0x0023:
            long r7 = initNanoTime(r13)     // Catch:{ all -> 0x0073 }
            r9 = r13
        L_0x0028:
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ InterruptedException -> 0x006a }
            boolean r3 = r15.tryLock(r9, r3)     // Catch:{ InterruptedException -> 0x006a }
            if (r3 == 0) goto L_0x0060
        L_0x0030:
            boolean r3 = r12.isSatisfied()     // Catch:{ InterruptedException -> 0x005d, all -> 0x0058 }
            if (r3 == 0) goto L_0x0037
            goto L_0x0049
        L_0x0037:
            int r3 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r3 != 0) goto L_0x0041
            long r7 = initNanoTime(r13)     // Catch:{ InterruptedException -> 0x005d, all -> 0x0058 }
            r9 = r13
            goto L_0x0045
        L_0x0041:
            long r9 = remainingNanos(r7, r13)     // Catch:{ InterruptedException -> 0x005d, all -> 0x0058 }
        L_0x0045:
            boolean r2 = r11.awaitNanos(r12, r9, r0)     // Catch:{ InterruptedException -> 0x005d, all -> 0x0058 }
        L_0x0049:
            if (r2 != 0) goto L_0x004e
            r15.unlock()     // Catch:{ all -> 0x0073 }
        L_0x004e:
            if (r1 == 0) goto L_0x0057
            java.lang.Thread r12 = java.lang.Thread.currentThread()
            r12.interrupt()
        L_0x0057:
            return r2
        L_0x0058:
            r12 = move-exception
            r15.unlock()     // Catch:{ all -> 0x0073 }
            throw r12     // Catch:{ all -> 0x0073 }
        L_0x005d:
            r1 = r2
            r0 = r4
            goto L_0x0030
        L_0x0060:
            if (r1 == 0) goto L_0x0069
            java.lang.Thread r12 = java.lang.Thread.currentThread()
            r12.interrupt()
        L_0x0069:
            return r4
        L_0x006a:
            long r9 = remainingNanos(r7, r13)     // Catch:{ all -> 0x0070 }
            r1 = r2
            goto L_0x0028
        L_0x0070:
            r12 = move-exception
            r1 = r2
            goto L_0x0074
        L_0x0073:
            r12 = move-exception
        L_0x0074:
            if (r1 == 0) goto L_0x007d
            java.lang.Thread r13 = java.lang.Thread.currentThread()
            r13.interrupt()
        L_0x007d:
            throw r12
        L_0x007e:
            java.lang.IllegalMonitorStateException r12 = new java.lang.IllegalMonitorStateException
            r12.<init>()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Monitor.enterWhenUninterruptibly(com.google.common.util.concurrent.Monitor$Guard, long, java.util.concurrent.TimeUnit):boolean");
    }

    public boolean enterIf(Guard guard) {
        if (guard.monitor == this) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                boolean isSatisfied = guard.isSatisfied();
                if (!isSatisfied) {
                }
                return isSatisfied;
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    public boolean enterIf(Guard guard, long j, TimeUnit timeUnit) {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        } else if (!enter(j, timeUnit)) {
            return false;
        } else {
            try {
                boolean isSatisfied = guard.isSatisfied();
                if (!isSatisfied) {
                }
                return isSatisfied;
            } finally {
                this.lock.unlock();
            }
        }
    }

    public boolean enterIfInterruptibly(Guard guard) throws InterruptedException {
        if (guard.monitor == this) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lockInterruptibly();
            try {
                boolean isSatisfied = guard.isSatisfied();
                if (!isSatisfied) {
                }
                return isSatisfied;
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    public boolean enterIfInterruptibly(Guard guard, long j, TimeUnit timeUnit) throws InterruptedException {
        if (guard.monitor == this) {
            ReentrantLock reentrantLock = this.lock;
            if (!reentrantLock.tryLock(j, timeUnit)) {
                return false;
            }
            try {
                boolean isSatisfied = guard.isSatisfied();
                if (!isSatisfied) {
                }
                return isSatisfied;
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    public boolean tryEnterIf(Guard guard) {
        if (guard.monitor == this) {
            ReentrantLock reentrantLock = this.lock;
            if (!reentrantLock.tryLock()) {
                return false;
            }
            try {
                boolean isSatisfied = guard.isSatisfied();
                if (!isSatisfied) {
                }
                return isSatisfied;
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    public void waitFor(Guard guard) throws InterruptedException {
        if (!(guard.monitor == this) || !this.lock.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        } else if (!guard.isSatisfied()) {
            await(guard, true);
        }
    }

    public boolean waitFor(Guard guard, long j, TimeUnit timeUnit) throws InterruptedException {
        long safeNanos = toSafeNanos(j, timeUnit);
        if (!(guard.monitor == this) || !this.lock.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        } else if (guard.isSatisfied()) {
            return true;
        } else {
            if (!Thread.interrupted()) {
                return awaitNanos(guard, safeNanos, true);
            }
            throw new InterruptedException();
        }
    }

    public void waitForUninterruptibly(Guard guard) {
        if (!(guard.monitor == this) || !this.lock.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        } else if (!guard.isSatisfied()) {
            awaitUninterruptibly(guard, true);
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0038 */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean waitForUninterruptibly(com.google.common.util.concurrent.Monitor.Guard r8, long r9, java.util.concurrent.TimeUnit r11) {
        /*
            r7 = this;
            long r9 = toSafeNanos(r9, r11)
            com.google.common.util.concurrent.Monitor r11 = r8.monitor
            r0 = 0
            r1 = 1
            if (r11 != r7) goto L_0x000c
            r11 = r1
            goto L_0x000d
        L_0x000c:
            r11 = r0
        L_0x000d:
            java.util.concurrent.locks.ReentrantLock r2 = r7.lock
            boolean r2 = r2.isHeldByCurrentThread()
            r11 = r11 & r2
            if (r11 == 0) goto L_0x0058
            boolean r11 = r8.isSatisfied()
            if (r11 == 0) goto L_0x001d
            return r1
        L_0x001d:
            long r2 = initNanoTime(r9)
            boolean r11 = java.lang.Thread.interrupted()
            r4 = r9
            r6 = r1
        L_0x0027:
            boolean r8 = r7.awaitNanos(r8, r4, r6)     // Catch:{ InterruptedException -> 0x0038, all -> 0x0035 }
            if (r11 == 0) goto L_0x0034
            java.lang.Thread r9 = java.lang.Thread.currentThread()
            r9.interrupt()
        L_0x0034:
            return r8
        L_0x0035:
            r8 = move-exception
            r1 = r11
            goto L_0x004e
        L_0x0038:
            boolean r11 = r8.isSatisfied()     // Catch:{ all -> 0x004d }
            if (r11 == 0) goto L_0x0046
            java.lang.Thread r8 = java.lang.Thread.currentThread()
            r8.interrupt()
            return r1
        L_0x0046:
            long r4 = remainingNanos(r2, r9)     // Catch:{ all -> 0x004d }
            r6 = r0
            r11 = r1
            goto L_0x0027
        L_0x004d:
            r8 = move-exception
        L_0x004e:
            if (r1 == 0) goto L_0x0057
            java.lang.Thread r9 = java.lang.Thread.currentThread()
            r9.interrupt()
        L_0x0057:
            throw r8
        L_0x0058:
            java.lang.IllegalMonitorStateException r8 = new java.lang.IllegalMonitorStateException
            r8.<init>()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Monitor.waitForUninterruptibly(com.google.common.util.concurrent.Monitor$Guard, long, java.util.concurrent.TimeUnit):boolean");
    }

    public void leave() {
        ReentrantLock reentrantLock = this.lock;
        try {
            if (reentrantLock.getHoldCount() == 1) {
                signalNextWaiter();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean isFair() {
        return this.fair;
    }

    public boolean isOccupied() {
        return this.lock.isLocked();
    }

    public boolean isOccupiedByCurrentThread() {
        return this.lock.isHeldByCurrentThread();
    }

    public int getOccupiedDepth() {
        return this.lock.getHoldCount();
    }

    public int getQueueLength() {
        return this.lock.getQueueLength();
    }

    public boolean hasQueuedThreads() {
        return this.lock.hasQueuedThreads();
    }

    public boolean hasQueuedThread(Thread thread) {
        return this.lock.hasQueuedThread(thread);
    }

    public boolean hasWaiters(Guard guard) {
        return getWaitQueueLength(guard) > 0;
    }

    public int getWaitQueueLength(Guard guard) {
        if (guard.monitor == this) {
            this.lock.lock();
            try {
                return guard.waiterCount;
            } finally {
                this.lock.unlock();
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    private static long toSafeNanos(long j, TimeUnit timeUnit) {
        return Longs.constrainToRange(timeUnit.toNanos(j), 0, 6917529027641081853L);
    }

    private static long initNanoTime(long j) {
        if (j <= 0) {
            return 0;
        }
        long nanoTime = System.nanoTime();
        if (nanoTime == 0) {
            return 1;
        }
        return nanoTime;
    }

    private static long remainingNanos(long j, long j2) {
        if (j2 <= 0) {
            return 0;
        }
        return j2 - (System.nanoTime() - j);
    }

    private void signalNextWaiter() {
        for (Guard guard = this.activeGuards; guard != null; guard = guard.next) {
            if (isSatisfied(guard)) {
                guard.condition.signal();
                return;
            }
        }
    }

    private boolean isSatisfied(Guard guard) {
        try {
            return guard.isSatisfied();
        } catch (Throwable th) {
            signalAllWaiters();
            throw th;
        }
    }

    private void signalAllWaiters() {
        for (Guard guard = this.activeGuards; guard != null; guard = guard.next) {
            guard.condition.signalAll();
        }
    }

    private void beginWaitingFor(Guard guard) {
        int i = guard.waiterCount;
        guard.waiterCount = i + 1;
        if (i == 0) {
            guard.next = this.activeGuards;
            this.activeGuards = guard;
        }
    }

    private void endWaitingFor(Guard guard) {
        int i = guard.waiterCount - 1;
        guard.waiterCount = i;
        if (i == 0) {
            Guard guard2 = this.activeGuards;
            Guard guard3 = null;
            while (guard2 != guard) {
                guard3 = guard2;
                guard2 = guard2.next;
            }
            if (guard3 == null) {
                this.activeGuards = guard2.next;
            } else {
                guard3.next = guard2.next;
            }
            guard2.next = null;
        }
    }

    private void await(Guard guard, boolean z) throws InterruptedException {
        if (z) {
            signalNextWaiter();
        }
        beginWaitingFor(guard);
        do {
            try {
                guard.condition.await();
            } finally {
                endWaitingFor(guard);
            }
        } while (!guard.isSatisfied());
    }

    private void awaitUninterruptibly(Guard guard, boolean z) {
        if (z) {
            signalNextWaiter();
        }
        beginWaitingFor(guard);
        do {
            try {
                guard.condition.awaitUninterruptibly();
            } finally {
                endWaitingFor(guard);
            }
        } while (!guard.isSatisfied());
    }

    private boolean awaitNanos(Guard guard, long j, boolean z) throws InterruptedException {
        boolean z2 = true;
        while (j > 0) {
            if (z2) {
                if (z) {
                    try {
                        signalNextWaiter();
                    } catch (Throwable th) {
                        if (!z2) {
                            endWaitingFor(guard);
                        }
                        throw th;
                    }
                }
                beginWaitingFor(guard);
                z2 = false;
            }
            j = guard.condition.awaitNanos(j);
            if (guard.isSatisfied()) {
                if (!z2) {
                    endWaitingFor(guard);
                }
                return true;
            }
        }
        if (!z2) {
            endWaitingFor(guard);
        }
        return false;
    }
}
