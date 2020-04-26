package okio.internal;

import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.RealBufferedSink;
import okio.Source;
import okio.Timeout;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\b\u001a\r\u0010\u0005\u001a\u00020\u0004*\u00020\u0002H\b\u001a\r\u0010\u0006\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\u0007\u001a\u00020\b*\u00020\u0002H\b\u001a\r\u0010\t\u001a\u00020\n*\u00020\u0002H\b\u001a\u0015\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\b\u001a%\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\b\u001a\u001d\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0012H\b\u001a\u0015\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\b\u001a%\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\b\u001a\u001d\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0012H\b\u001a\u0015\u0010\u0016\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0015H\b\u001a\u0015\u0010\u0017\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000fH\b\u001a\u0015\u0010\u0019\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0012H\b\u001a\u0015\u0010\u001b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0012H\b\u001a\u0015\u0010\u001c\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u000fH\b\u001a\u0015\u0010\u001e\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u000fH\b\u001a\u0015\u0010\u001f\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0012H\b\u001a\u0015\u0010 \u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0012H\b\u001a\u0015\u0010!\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\"\u001a\u00020\u000fH\b\u001a\u0015\u0010#\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\"\u001a\u00020\u000fH\b\u001a\u0015\u0010$\u001a\u00020\u0004*\u00020\u00022\u0006\u0010%\u001a\u00020\nH\b\u001a%\u0010$\u001a\u00020\u0004*\u00020\u00022\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u000fH\b\u001a\u0015\u0010(\u001a\u00020\u0004*\u00020\u00022\u0006\u0010)\u001a\u00020\u000fH\b¨\u0006*"}, d2 = {"commonClose", "", "Lokio/RealBufferedSink;", "commonEmit", "Lokio/BufferedSink;", "commonEmitCompleteSegments", "commonFlush", "commonTimeout", "Lokio/Timeout;", "commonToString", "", "commonWrite", "source", "", "offset", "", "byteCount", "Lokio/Buffer;", "", "byteString", "Lokio/ByteString;", "Lokio/Source;", "commonWriteAll", "commonWriteByte", "b", "commonWriteDecimalLong", "v", "commonWriteHexadecimalUnsignedLong", "commonWriteInt", "i", "commonWriteIntLe", "commonWriteLong", "commonWriteLongLe", "commonWriteShort", "s", "commonWriteShortLe", "commonWriteUtf8", "string", "beginIndex", "endIndex", "commonWriteUtf8CodePoint", "codePoint", "okio"}, k = 2, mv = {1, 1, 16})
/* compiled from: RealBufferedSink.kt */
public final class RealBufferedSinkKt {
    public static final void commonWrite(RealBufferedSink realBufferedSink, Buffer buffer, long j) {
        Intrinsics.checkParameterIsNotNull(realBufferedSink, "$this$commonWrite");
        Intrinsics.checkParameterIsNotNull(buffer, "source");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(buffer, j);
            realBufferedSink.emitCompleteSegments();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWrite(RealBufferedSink realBufferedSink, ByteString byteString) {
        Intrinsics.checkParameterIsNotNull(realBufferedSink, "$this$commonWrite");
        Intrinsics.checkParameterIsNotNull(byteString, "byteString");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(byteString);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWrite(RealBufferedSink realBufferedSink, ByteString byteString, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(realBufferedSink, "$this$commonWrite");
        Intrinsics.checkParameterIsNotNull(byteString, "byteString");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(byteString, i, i2);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteUtf8(RealBufferedSink realBufferedSink, String str) {
        Intrinsics.checkParameterIsNotNull(realBufferedSink, "$this$commonWriteUtf8");
        Intrinsics.checkParameterIsNotNull(str, "string");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeUtf8(str);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteUtf8(RealBufferedSink realBufferedSink, String str, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(realBufferedSink, "$this$commonWriteUtf8");
        Intrinsics.checkParameterIsNotNull(str, "string");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeUtf8(str, i, i2);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteUtf8CodePoint(RealBufferedSink realBufferedSink, int i) {
        Intrinsics.checkParameterIsNotNull(realBufferedSink, "$this$commonWriteUtf8CodePoint");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeUtf8CodePoint(i);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWrite(RealBufferedSink realBufferedSink, byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(realBufferedSink, "$this$commonWrite");
        Intrinsics.checkParameterIsNotNull(bArr, "source");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(bArr);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWrite(RealBufferedSink realBufferedSink, byte[] bArr, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(realBufferedSink, "$this$commonWrite");
        Intrinsics.checkParameterIsNotNull(bArr, "source");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(bArr, i, i2);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteByte(RealBufferedSink realBufferedSink, int i) {
        Intrinsics.checkParameterIsNotNull(realBufferedSink, "$this$commonWriteByte");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeByte(i);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteShort(RealBufferedSink realBufferedSink, int i) {
        Intrinsics.checkParameterIsNotNull(realBufferedSink, "$this$commonWriteShort");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeShort(i);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteShortLe(RealBufferedSink realBufferedSink, int i) {
        Intrinsics.checkParameterIsNotNull(realBufferedSink, "$this$commonWriteShortLe");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeShortLe(i);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteInt(RealBufferedSink realBufferedSink, int i) {
        Intrinsics.checkParameterIsNotNull(realBufferedSink, "$this$commonWriteInt");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeInt(i);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteIntLe(RealBufferedSink realBufferedSink, int i) {
        Intrinsics.checkParameterIsNotNull(realBufferedSink, "$this$commonWriteIntLe");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeIntLe(i);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteLong(RealBufferedSink realBufferedSink, long j) {
        Intrinsics.checkParameterIsNotNull(realBufferedSink, "$this$commonWriteLong");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeLong(j);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteLongLe(RealBufferedSink realBufferedSink, long j) {
        Intrinsics.checkParameterIsNotNull(realBufferedSink, "$this$commonWriteLongLe");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeLongLe(j);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteDecimalLong(RealBufferedSink realBufferedSink, long j) {
        Intrinsics.checkParameterIsNotNull(realBufferedSink, "$this$commonWriteDecimalLong");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeDecimalLong(j);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteHexadecimalUnsignedLong(RealBufferedSink realBufferedSink, long j) {
        Intrinsics.checkParameterIsNotNull(realBufferedSink, "$this$commonWriteHexadecimalUnsignedLong");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeHexadecimalUnsignedLong(j);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonEmitCompleteSegments(RealBufferedSink realBufferedSink) {
        Intrinsics.checkParameterIsNotNull(realBufferedSink, "$this$commonEmitCompleteSegments");
        if (!realBufferedSink.closed) {
            long completeSegmentByteCount = realBufferedSink.bufferField.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                realBufferedSink.sink.write(realBufferedSink.bufferField, completeSegmentByteCount);
            }
            return realBufferedSink;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonEmit(RealBufferedSink realBufferedSink) {
        Intrinsics.checkParameterIsNotNull(realBufferedSink, "$this$commonEmit");
        if (!realBufferedSink.closed) {
            long size = realBufferedSink.bufferField.size();
            if (size > 0) {
                realBufferedSink.sink.write(realBufferedSink.bufferField, size);
            }
            return realBufferedSink;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final void commonFlush(RealBufferedSink realBufferedSink) {
        Intrinsics.checkParameterIsNotNull(realBufferedSink, "$this$commonFlush");
        if (!realBufferedSink.closed) {
            if (realBufferedSink.bufferField.size() > 0) {
                realBufferedSink.sink.write(realBufferedSink.bufferField, realBufferedSink.bufferField.size());
            }
            realBufferedSink.sink.flush();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final void commonClose(RealBufferedSink realBufferedSink) {
        Intrinsics.checkParameterIsNotNull(realBufferedSink, "$this$commonClose");
        if (!realBufferedSink.closed) {
            Throwable th = null;
            try {
                if (realBufferedSink.bufferField.size() > 0) {
                    realBufferedSink.sink.write(realBufferedSink.bufferField, realBufferedSink.bufferField.size());
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                realBufferedSink.sink.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            realBufferedSink.closed = true;
            if (th != null) {
                throw th;
            }
        }
    }

    public static final Timeout commonTimeout(RealBufferedSink realBufferedSink) {
        Intrinsics.checkParameterIsNotNull(realBufferedSink, "$this$commonTimeout");
        return realBufferedSink.sink.timeout();
    }

    public static final String commonToString(RealBufferedSink realBufferedSink) {
        Intrinsics.checkParameterIsNotNull(realBufferedSink, "$this$commonToString");
        return "buffer(" + realBufferedSink.sink + ')';
    }

    public static final long commonWriteAll(RealBufferedSink realBufferedSink, Source source) {
        Intrinsics.checkParameterIsNotNull(realBufferedSink, "$this$commonWriteAll");
        Intrinsics.checkParameterIsNotNull(source, "source");
        long j = 0;
        while (true) {
            long read = source.read(realBufferedSink.bufferField, (long) 8192);
            if (read == -1) {
                return j;
            }
            j += read;
            realBufferedSink.emitCompleteSegments();
        }
    }

    public static final BufferedSink commonWrite(RealBufferedSink realBufferedSink, Source source, long j) {
        Intrinsics.checkParameterIsNotNull(realBufferedSink, "$this$commonWrite");
        Intrinsics.checkParameterIsNotNull(source, "source");
        while (j > 0) {
            long read = source.read(realBufferedSink.bufferField, j);
            if (read != -1) {
                j -= read;
                realBufferedSink.emitCompleteSegments();
            } else {
                throw new EOFException();
            }
        }
        return realBufferedSink;
    }
}
