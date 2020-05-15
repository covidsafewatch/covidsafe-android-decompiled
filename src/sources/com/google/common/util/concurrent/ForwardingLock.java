package com.google.common.util.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

abstract class ForwardingLock implements Lock {
    /* access modifiers changed from: package-private */
    public abstract Lock delegate();

    ForwardingLock() {
    }

    public void lock() {
        delegate().lock();
    }

    public void lockInterruptibly() throws InterruptedException {
        delegate().lockInterruptibly();
    }

    public boolean tryLock() {
        return delegate().tryLock();
    }

    public boolean tryLock(long j, TimeUnit timeUnit) throws InterruptedException {
        return delegate().tryLock(j, timeUnit);
    }

    public void unlock() {
        delegate().unlock();
    }

    public Condition newCondition() {
        return delegate().newCondition();
    }
}
