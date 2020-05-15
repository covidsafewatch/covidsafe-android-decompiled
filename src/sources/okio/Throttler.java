package okio;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001d\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\fJ$\u0010\u0006\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0007J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011J\u0015\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0013J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\f\u0010\u0016\u001a\u00020\u0004*\u00020\u0004H\u0002J\f\u0010\u0017\u001a\u00020\u0004*\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lokio/Throttler;", "", "()V", "allocatedUntil", "", "(J)V", "bytesPerSecond", "maxByteCount", "waitByteCount", "byteCountOrWaitNanos", "now", "byteCount", "byteCountOrWaitNanos$okio", "", "sink", "Lokio/Sink;", "source", "Lokio/Source;", "take", "take$okio", "waitNanos", "nanosToWait", "bytesToNanos", "nanosToBytes", "okio"}, k = 1, mv = {1, 1, 16})
/* compiled from: Throttler.kt */
public final class Throttler {
    private long allocatedUntil;
    private long bytesPerSecond;
    private long maxByteCount;
    private long waitByteCount;

    public final void bytesPerSecond(long j) {
        bytesPerSecond$default(this, j, 0, 0, 6, (Object) null);
    }

    public final void bytesPerSecond(long j, long j2) {
        bytesPerSecond$default(this, j, j2, 0, 4, (Object) null);
    }

    public Throttler(long j) {
        this.allocatedUntil = j;
        this.waitByteCount = 8192;
        this.maxByteCount = 262144;
    }

    public Throttler() {
        this(System.nanoTime());
    }

    public static /* synthetic */ void bytesPerSecond$default(Throttler throttler, long j, long j2, long j3, int i, Object obj) {
        if ((i & 2) != 0) {
            j2 = throttler.waitByteCount;
        }
        long j4 = j2;
        if ((i & 4) != 0) {
            j3 = throttler.maxByteCount;
        }
        throttler.bytesPerSecond(j, j4, j3);
    }

    public final long byteCountOrWaitNanos$okio(long j, long j2) {
        if (this.bytesPerSecond == 0) {
            return j2;
        }
        long max = Math.max(this.allocatedUntil - j, 0);
        long nanosToBytes = this.maxByteCount - nanosToBytes(max);
        if (nanosToBytes >= j2) {
            this.allocatedUntil = j + max + bytesToNanos(j2);
            return j2;
        }
        long j3 = this.waitByteCount;
        if (nanosToBytes >= j3) {
            this.allocatedUntil = j + bytesToNanos(this.maxByteCount);
            return nanosToBytes;
        }
        long min = Math.min(j3, j2);
        long bytesToNanos = max + bytesToNanos(min - this.maxByteCount);
        if (bytesToNanos != 0) {
            return -bytesToNanos;
        }
        this.allocatedUntil = j + bytesToNanos(this.maxByteCount);
        return min;
    }

    private final long nanosToBytes(long j) {
        return (j * this.bytesPerSecond) / 1000000000;
    }

    private final long bytesToNanos(long j) {
        return (j * 1000000000) / this.bytesPerSecond;
    }

    private final void waitNanos(long j) {
        long j2 = j / 1000000;
        wait(j2, (int) (j - (1000000 * j2)));
    }

    public final Source source(Source source) {
        Intrinsics.checkParameterIsNotNull(source, "source");
        return new Throttler$source$1(this, source, source);
    }

    public final Sink sink(Sink sink) {
        Intrinsics.checkParameterIsNotNull(sink, "sink");
        return new Throttler$sink$1(this, sink, sink);
    }

    public final void bytesPerSecond(long j, long j2, long j3) {
        synchronized (this) {
            boolean z = true;
            if (j >= 0) {
                if (j2 > 0) {
                    if (j3 < j2) {
                        z = false;
                    }
                    if (z) {
                        this.bytesPerSecond = j;
                        this.waitByteCount = j2;
                        this.maxByteCount = j3;
                        notifyAll();
                        Unit unit = Unit.INSTANCE;
                    } else {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                } else {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            } else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }
    }

    public final long take$okio(long j) {
        long byteCountOrWaitNanos$okio;
        if (j > 0) {
            synchronized (this) {
                while (true) {
                    byteCountOrWaitNanos$okio = byteCountOrWaitNanos$okio(System.nanoTime(), j);
                    if (byteCountOrWaitNanos$okio < 0) {
                        waitNanos(-byteCountOrWaitNanos$okio);
                    }
                }
            }
            return byteCountOrWaitNanos$okio;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}
