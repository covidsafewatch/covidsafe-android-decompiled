package okio;

import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lokio/OutputStreamSink;", "Lokio/Sink;", "out", "Ljava/io/OutputStream;", "timeout", "Lokio/Timeout;", "(Ljava/io/OutputStream;Lokio/Timeout;)V", "close", "", "flush", "toString", "", "write", "source", "Lokio/Buffer;", "byteCount", "", "okio"}, k = 1, mv = {1, 1, 16})
/* compiled from: Okio.kt */
final class OutputStreamSink implements Sink {
    private final OutputStream out;
    private final Timeout timeout;

    public OutputStreamSink(OutputStream outputStream, Timeout timeout2) {
        Intrinsics.checkParameterIsNotNull(outputStream, "out");
        Intrinsics.checkParameterIsNotNull(timeout2, "timeout");
        this.out = outputStream;
        this.timeout = timeout2;
    }

    public void write(Buffer buffer, long j) {
        Intrinsics.checkParameterIsNotNull(buffer, "source");
        Util.checkOffsetAndCount(buffer.size(), 0, j);
        while (j > 0) {
            this.timeout.throwIfReached();
            Segment segment = buffer.head;
            if (segment == null) {
                Intrinsics.throwNpe();
            }
            int min = (int) Math.min(j, (long) (segment.limit - segment.pos));
            this.out.write(segment.data, segment.pos, min);
            segment.pos += min;
            long j2 = (long) min;
            j -= j2;
            buffer.setSize$okio(buffer.size() - j2);
            if (segment.pos == segment.limit) {
                buffer.head = segment.pop();
                SegmentPool.INSTANCE.recycle(segment);
            }
        }
    }

    public void flush() {
        this.out.flush();
    }

    public void close() {
        this.out.close();
    }

    public Timeout timeout() {
        return this.timeout;
    }

    public String toString() {
        return "sink(" + this.out + ')';
    }
}
