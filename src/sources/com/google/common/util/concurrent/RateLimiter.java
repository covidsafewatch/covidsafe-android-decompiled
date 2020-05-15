package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.SmoothRateLimiter;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

public abstract class RateLimiter {
    @MonotonicNonNullDecl
    private volatile Object mutexDoNotUseDirectly;
    private final SleepingStopwatch stopwatch;

    /* access modifiers changed from: package-private */
    public abstract double doGetRate();

    /* access modifiers changed from: package-private */
    public abstract void doSetRate(double d, long j);

    /* access modifiers changed from: package-private */
    public abstract long queryEarliestAvailable(long j);

    /* access modifiers changed from: package-private */
    public abstract long reserveEarliestAvailable(int i, long j);

    public static RateLimiter create(double d) {
        return create(d, SleepingStopwatch.createFromSystemTimer());
    }

    static RateLimiter create(double d, SleepingStopwatch sleepingStopwatch) {
        SmoothRateLimiter.SmoothBursty smoothBursty = new SmoothRateLimiter.SmoothBursty(sleepingStopwatch, 1.0d);
        smoothBursty.setRate(d);
        return smoothBursty;
    }

    public static RateLimiter create(double d, long j, TimeUnit timeUnit) {
        Preconditions.checkArgument(j >= 0, "warmupPeriod must not be negative: %s", j);
        return create(d, j, timeUnit, 3.0d, SleepingStopwatch.createFromSystemTimer());
    }

    static RateLimiter create(double d, long j, TimeUnit timeUnit, double d2, SleepingStopwatch sleepingStopwatch) {
        SmoothRateLimiter.SmoothWarmingUp smoothWarmingUp = new SmoothRateLimiter.SmoothWarmingUp(sleepingStopwatch, j, timeUnit, d2);
        smoothWarmingUp.setRate(d);
        return smoothWarmingUp;
    }

    private Object mutex() {
        Object obj = this.mutexDoNotUseDirectly;
        if (obj == null) {
            synchronized (this) {
                obj = this.mutexDoNotUseDirectly;
                if (obj == null) {
                    obj = new Object();
                    this.mutexDoNotUseDirectly = obj;
                }
            }
        }
        return obj;
    }

    RateLimiter(SleepingStopwatch sleepingStopwatch) {
        this.stopwatch = (SleepingStopwatch) Preconditions.checkNotNull(sleepingStopwatch);
    }

    public final void setRate(double d) {
        Preconditions.checkArgument(d > 0.0d && !Double.isNaN(d), "rate must be positive");
        synchronized (mutex()) {
            doSetRate(d, this.stopwatch.readMicros());
        }
    }

    public final double getRate() {
        double doGetRate;
        synchronized (mutex()) {
            doGetRate = doGetRate();
        }
        return doGetRate;
    }

    public double acquire() {
        return acquire(1);
    }

    public double acquire(int i) {
        long reserve = reserve(i);
        this.stopwatch.sleepMicrosUninterruptibly(reserve);
        return (((double) reserve) * 1.0d) / ((double) TimeUnit.SECONDS.toMicros(1));
    }

    /* access modifiers changed from: package-private */
    public final long reserve(int i) {
        long reserveAndGetWaitLength;
        checkPermits(i);
        synchronized (mutex()) {
            reserveAndGetWaitLength = reserveAndGetWaitLength(i, this.stopwatch.readMicros());
        }
        return reserveAndGetWaitLength;
    }

    public boolean tryAcquire(long j, TimeUnit timeUnit) {
        return tryAcquire(1, j, timeUnit);
    }

    public boolean tryAcquire(int i) {
        return tryAcquire(i, 0, TimeUnit.MICROSECONDS);
    }

    public boolean tryAcquire() {
        return tryAcquire(1, 0, TimeUnit.MICROSECONDS);
    }

    public boolean tryAcquire(int i, long j, TimeUnit timeUnit) {
        long max = Math.max(timeUnit.toMicros(j), 0);
        checkPermits(i);
        synchronized (mutex()) {
            long readMicros = this.stopwatch.readMicros();
            if (!canAcquire(readMicros, max)) {
                return false;
            }
            long reserveAndGetWaitLength = reserveAndGetWaitLength(i, readMicros);
            this.stopwatch.sleepMicrosUninterruptibly(reserveAndGetWaitLength);
            return true;
        }
    }

    private boolean canAcquire(long j, long j2) {
        return queryEarliestAvailable(j) - j2 <= j;
    }

    /* access modifiers changed from: package-private */
    public final long reserveAndGetWaitLength(int i, long j) {
        return Math.max(reserveEarliestAvailable(i, j) - j, 0);
    }

    public String toString() {
        return String.format(Locale.ROOT, "RateLimiter[stableRate=%3.1fqps]", new Object[]{Double.valueOf(getRate())});
    }

    static abstract class SleepingStopwatch {
        /* access modifiers changed from: protected */
        public abstract long readMicros();

        /* access modifiers changed from: protected */
        public abstract void sleepMicrosUninterruptibly(long j);

        protected SleepingStopwatch() {
        }

        public static SleepingStopwatch createFromSystemTimer() {
            return new SleepingStopwatch() {
                final Stopwatch stopwatch = Stopwatch.createStarted();

                /* access modifiers changed from: protected */
                public long readMicros() {
                    return this.stopwatch.elapsed(TimeUnit.MICROSECONDS);
                }

                /* access modifiers changed from: protected */
                public void sleepMicrosUninterruptibly(long j) {
                    if (j > 0) {
                        Uninterruptibles.sleepUninterruptibly(j, TimeUnit.MICROSECONDS);
                    }
                }
            };
        }
    }

    private static void checkPermits(int i) {
        Preconditions.checkArgument(i > 0, "Requested permits (%s) must be positive", i);
    }
}
