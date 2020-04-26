package okio.internal;

import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.text.CharsKt;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Options;
import okio.PeekSource;
import okio.RealBufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import okio.Util;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\b\u001a%\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\b\u001a\u001d\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0006H\b\u001a\u001d\u0010\r\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0006H\b\u001a\r\u0010\u000f\u001a\u00020\u0010*\u00020\u0002H\b\u001a-\u0010\u0011\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\b\u001a%\u0010\u0016\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\b\u001a\u001d\u0010\u0016\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0006H\b\u001a\u0015\u0010\u001a\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u001bH\b\u001a\r\u0010\u001c\u001a\u00020\b*\u00020\u0002H\b\u001a\r\u0010\u001d\u001a\u00020\u0018*\u00020\u0002H\b\u001a\u0015\u0010\u001d\u001a\u00020\u0018*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\b\u001a\r\u0010\u001e\u001a\u00020\f*\u00020\u0002H\b\u001a\u0015\u0010\u001e\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\b\u001a\r\u0010\u001f\u001a\u00020\u0006*\u00020\u0002H\b\u001a\u0015\u0010 \u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\b\u001a\u001d\u0010 \u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0006H\b\u001a\r\u0010!\u001a\u00020\u0006*\u00020\u0002H\b\u001a\r\u0010\"\u001a\u00020\u0014*\u00020\u0002H\b\u001a\r\u0010#\u001a\u00020\u0014*\u00020\u0002H\b\u001a\r\u0010$\u001a\u00020\u0006*\u00020\u0002H\b\u001a\r\u0010%\u001a\u00020\u0006*\u00020\u0002H\b\u001a\r\u0010&\u001a\u00020'*\u00020\u0002H\b\u001a\r\u0010(\u001a\u00020'*\u00020\u0002H\b\u001a\r\u0010)\u001a\u00020**\u00020\u0002H\b\u001a\u0015\u0010)\u001a\u00020**\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\b\u001a\r\u0010+\u001a\u00020\u0014*\u00020\u0002H\b\u001a\u000f\u0010,\u001a\u0004\u0018\u00010**\u00020\u0002H\b\u001a\u0015\u0010-\u001a\u00020**\u00020\u00022\u0006\u0010.\u001a\u00020\u0006H\b\u001a\u0015\u0010/\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\b\u001a\u0015\u00100\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\b\u001a\u0015\u00101\u001a\u00020\u0014*\u00020\u00022\u0006\u00102\u001a\u000203H\b\u001a\u0015\u00104\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\b\u001a\r\u00105\u001a\u000206*\u00020\u0002H\b\u001a\r\u00107\u001a\u00020**\u00020\u0002H\b¨\u00068"}, d2 = {"commonClose", "", "Lokio/RealBufferedSource;", "commonExhausted", "", "commonIndexOf", "", "b", "", "fromIndex", "toIndex", "bytes", "Lokio/ByteString;", "commonIndexOfElement", "targetBytes", "commonPeek", "Lokio/BufferedSource;", "commonRangeEquals", "offset", "bytesOffset", "", "byteCount", "commonRead", "sink", "", "Lokio/Buffer;", "commonReadAll", "Lokio/Sink;", "commonReadByte", "commonReadByteArray", "commonReadByteString", "commonReadDecimalLong", "commonReadFully", "commonReadHexadecimalUnsignedLong", "commonReadInt", "commonReadIntLe", "commonReadLong", "commonReadLongLe", "commonReadShort", "", "commonReadShortLe", "commonReadUtf8", "", "commonReadUtf8CodePoint", "commonReadUtf8Line", "commonReadUtf8LineStrict", "limit", "commonRequest", "commonRequire", "commonSelect", "options", "Lokio/Options;", "commonSkip", "commonTimeout", "Lokio/Timeout;", "commonToString", "okio"}, k = 2, mv = {1, 1, 16})
/* compiled from: RealBufferedSource.kt */
public final class RealBufferedSourceKt {
    public static final long commonRead(RealBufferedSource realBufferedSource, Buffer buffer, long j) {
        Intrinsics.checkParameterIsNotNull(realBufferedSource, "$this$commonRead");
        Intrinsics.checkParameterIsNotNull(buffer, "sink");
        if (!(j >= 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString().toString());
        } else if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException("closed".toString());
        } else if (realBufferedSource.bufferField.size() == 0 && realBufferedSource.source.read(realBufferedSource.bufferField, (long) 8192) == -1) {
            return -1;
        } else {
            return realBufferedSource.bufferField.read(buffer, Math.min(j, realBufferedSource.bufferField.size()));
        }
    }

    public static final boolean commonExhausted(RealBufferedSource realBufferedSource) {
        Intrinsics.checkParameterIsNotNull(realBufferedSource, "$this$commonExhausted");
        if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException("closed".toString());
        } else if (!realBufferedSource.bufferField.exhausted() || realBufferedSource.source.read(realBufferedSource.bufferField, (long) 8192) != -1) {
            return false;
        } else {
            return true;
        }
    }

    public static final void commonRequire(RealBufferedSource realBufferedSource, long j) {
        Intrinsics.checkParameterIsNotNull(realBufferedSource, "$this$commonRequire");
        if (!realBufferedSource.request(j)) {
            throw new EOFException();
        }
    }

    public static final boolean commonRequest(RealBufferedSource realBufferedSource, long j) {
        Intrinsics.checkParameterIsNotNull(realBufferedSource, "$this$commonRequest");
        if (!(j >= 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString().toString());
        } else if (!realBufferedSource.closed) {
            while (realBufferedSource.bufferField.size() < j) {
                if (realBufferedSource.source.read(realBufferedSource.bufferField, (long) 8192) == -1) {
                    return false;
                }
            }
            return true;
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    public static final byte commonReadByte(RealBufferedSource realBufferedSource) {
        Intrinsics.checkParameterIsNotNull(realBufferedSource, "$this$commonReadByte");
        realBufferedSource.require(1);
        return realBufferedSource.bufferField.readByte();
    }

    public static final ByteString commonReadByteString(RealBufferedSource realBufferedSource, long j) {
        Intrinsics.checkParameterIsNotNull(realBufferedSource, "$this$commonReadByteString");
        realBufferedSource.require(j);
        return realBufferedSource.bufferField.readByteString(j);
    }

    public static final int commonSelect(RealBufferedSource realBufferedSource, Options options) {
        Intrinsics.checkParameterIsNotNull(realBufferedSource, "$this$commonSelect");
        Intrinsics.checkParameterIsNotNull(options, "options");
        if (!realBufferedSource.closed) {
            do {
                int selectPrefix = BufferKt.selectPrefix(realBufferedSource.bufferField, options, true);
                if (selectPrefix != -2) {
                    if (selectPrefix == -1) {
                        return -1;
                    }
                    realBufferedSource.bufferField.skip((long) options.getByteStrings$okio()[selectPrefix].size());
                    return selectPrefix;
                }
            } while (realBufferedSource.source.read(realBufferedSource.bufferField, (long) 8192) != -1);
            return -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final byte[] commonReadByteArray(RealBufferedSource realBufferedSource, long j) {
        Intrinsics.checkParameterIsNotNull(realBufferedSource, "$this$commonReadByteArray");
        realBufferedSource.require(j);
        return realBufferedSource.bufferField.readByteArray(j);
    }

    public static final void commonReadFully(RealBufferedSource realBufferedSource, byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(realBufferedSource, "$this$commonReadFully");
        Intrinsics.checkParameterIsNotNull(bArr, "sink");
        try {
            realBufferedSource.require((long) bArr.length);
            realBufferedSource.bufferField.readFully(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (realBufferedSource.bufferField.size() > 0) {
                int read = realBufferedSource.bufferField.read(bArr, i, (int) realBufferedSource.bufferField.size());
                if (read != -1) {
                    i += read;
                } else {
                    throw new AssertionError();
                }
            }
            throw e;
        }
    }

    public static final int commonRead(RealBufferedSource realBufferedSource, byte[] bArr, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(realBufferedSource, "$this$commonRead");
        Intrinsics.checkParameterIsNotNull(bArr, "sink");
        long j = (long) i2;
        Util.checkOffsetAndCount((long) bArr.length, (long) i, j);
        if (realBufferedSource.bufferField.size() == 0 && realBufferedSource.source.read(realBufferedSource.bufferField, (long) 8192) == -1) {
            return -1;
        }
        return realBufferedSource.bufferField.read(bArr, i, (int) Math.min(j, realBufferedSource.bufferField.size()));
    }

    public static final void commonReadFully(RealBufferedSource realBufferedSource, Buffer buffer, long j) {
        Intrinsics.checkParameterIsNotNull(realBufferedSource, "$this$commonReadFully");
        Intrinsics.checkParameterIsNotNull(buffer, "sink");
        try {
            realBufferedSource.require(j);
            realBufferedSource.bufferField.readFully(buffer, j);
        } catch (EOFException e) {
            buffer.writeAll(realBufferedSource.bufferField);
            throw e;
        }
    }

    public static final long commonReadAll(RealBufferedSource realBufferedSource, Sink sink) {
        Intrinsics.checkParameterIsNotNull(realBufferedSource, "$this$commonReadAll");
        Intrinsics.checkParameterIsNotNull(sink, "sink");
        long j = 0;
        while (realBufferedSource.source.read(realBufferedSource.bufferField, (long) 8192) != -1) {
            long completeSegmentByteCount = realBufferedSource.bufferField.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                j += completeSegmentByteCount;
                sink.write(realBufferedSource.bufferField, completeSegmentByteCount);
            }
        }
        if (realBufferedSource.bufferField.size() <= 0) {
            return j;
        }
        long size = j + realBufferedSource.bufferField.size();
        sink.write(realBufferedSource.bufferField, realBufferedSource.bufferField.size());
        return size;
    }

    public static final String commonReadUtf8(RealBufferedSource realBufferedSource, long j) {
        Intrinsics.checkParameterIsNotNull(realBufferedSource, "$this$commonReadUtf8");
        realBufferedSource.require(j);
        return realBufferedSource.bufferField.readUtf8(j);
    }

    public static final String commonReadUtf8Line(RealBufferedSource realBufferedSource) {
        Intrinsics.checkParameterIsNotNull(realBufferedSource, "$this$commonReadUtf8Line");
        long indexOf = realBufferedSource.indexOf((byte) 10);
        if (indexOf != -1) {
            return BufferKt.readUtf8Line(realBufferedSource.bufferField, indexOf);
        }
        if (realBufferedSource.bufferField.size() != 0) {
            return realBufferedSource.readUtf8(realBufferedSource.bufferField.size());
        }
        return null;
    }

    public static final String commonReadUtf8LineStrict(RealBufferedSource realBufferedSource, long j) {
        Intrinsics.checkParameterIsNotNull(realBufferedSource, "$this$commonReadUtf8LineStrict");
        if (j >= 0) {
            long j2 = j == LongCompanionObject.MAX_VALUE ? Long.MAX_VALUE : j + 1;
            byte b = (byte) 10;
            long indexOf = realBufferedSource.indexOf(b, 0, j2);
            if (indexOf != -1) {
                return BufferKt.readUtf8Line(realBufferedSource.bufferField, indexOf);
            }
            if (j2 < LongCompanionObject.MAX_VALUE && realBufferedSource.request(j2) && realBufferedSource.bufferField.getByte(j2 - 1) == ((byte) 13) && realBufferedSource.request(1 + j2) && realBufferedSource.bufferField.getByte(j2) == b) {
                return BufferKt.readUtf8Line(realBufferedSource.bufferField, j2);
            }
            Buffer buffer = new Buffer();
            realBufferedSource.bufferField.copyTo(buffer, 0, Math.min((long) 32, realBufferedSource.bufferField.size()));
            StringBuilder sb = new StringBuilder();
            sb.append("\\n not found: limit=");
            sb.append(Math.min(realBufferedSource.bufferField.size(), j));
            sb.append(" content=");
            sb.append(buffer.readByteString().hex());
            sb.append("…");
            throw new EOFException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("limit < 0: ");
        sb2.append(j);
        throw new IllegalArgumentException(sb2.toString().toString());
    }

    public static final int commonReadUtf8CodePoint(RealBufferedSource realBufferedSource) {
        Intrinsics.checkParameterIsNotNull(realBufferedSource, "$this$commonReadUtf8CodePoint");
        realBufferedSource.require(1);
        byte b = realBufferedSource.bufferField.getByte(0);
        if ((b & 224) == 192) {
            realBufferedSource.require(2);
        } else if ((b & 240) == 224) {
            realBufferedSource.require(3);
        } else if ((b & 248) == 240) {
            realBufferedSource.require(4);
        }
        return realBufferedSource.bufferField.readUtf8CodePoint();
    }

    public static final short commonReadShort(RealBufferedSource realBufferedSource) {
        Intrinsics.checkParameterIsNotNull(realBufferedSource, "$this$commonReadShort");
        realBufferedSource.require(2);
        return realBufferedSource.bufferField.readShort();
    }

    public static final short commonReadShortLe(RealBufferedSource realBufferedSource) {
        Intrinsics.checkParameterIsNotNull(realBufferedSource, "$this$commonReadShortLe");
        realBufferedSource.require(2);
        return realBufferedSource.bufferField.readShortLe();
    }

    public static final int commonReadInt(RealBufferedSource realBufferedSource) {
        Intrinsics.checkParameterIsNotNull(realBufferedSource, "$this$commonReadInt");
        realBufferedSource.require(4);
        return realBufferedSource.bufferField.readInt();
    }

    public static final int commonReadIntLe(RealBufferedSource realBufferedSource) {
        Intrinsics.checkParameterIsNotNull(realBufferedSource, "$this$commonReadIntLe");
        realBufferedSource.require(4);
        return realBufferedSource.bufferField.readIntLe();
    }

    public static final long commonReadLong(RealBufferedSource realBufferedSource) {
        Intrinsics.checkParameterIsNotNull(realBufferedSource, "$this$commonReadLong");
        realBufferedSource.require(8);
        return realBufferedSource.bufferField.readLong();
    }

    public static final long commonReadLongLe(RealBufferedSource realBufferedSource) {
        Intrinsics.checkParameterIsNotNull(realBufferedSource, "$this$commonReadLongLe");
        realBufferedSource.require(8);
        return realBufferedSource.bufferField.readLongLe();
    }

    public static final long commonReadDecimalLong(RealBufferedSource realBufferedSource) {
        Intrinsics.checkParameterIsNotNull(realBufferedSource, "$this$commonReadDecimalLong");
        realBufferedSource.require(1);
        long j = 0;
        while (true) {
            long j2 = j + 1;
            if (!realBufferedSource.request(j2)) {
                break;
            }
            byte b = realBufferedSource.bufferField.getByte(j);
            if (b < ((byte) 48) || b > ((byte) 57)) {
                int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                if (i != 0 || b != ((byte) 45)) {
                    if (i == 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Expected leading [0-9] or '-' character but was 0x");
                        String num = Integer.toString(b, CharsKt.checkRadix(CharsKt.checkRadix(16)));
                        Intrinsics.checkExpressionValueIsNotNull(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
                        sb.append(num);
                        throw new NumberFormatException(sb.toString());
                    }
                }
            }
            j = j2;
        }
        return realBufferedSource.bufferField.readDecimalLong();
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long commonReadHexadecimalUnsignedLong(okio.RealBufferedSource r5) {
        /*
            java.lang.String r0 = "$this$commonReadHexadecimalUnsignedLong"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            r0 = 1
            r5.require(r0)
            r0 = 0
        L_0x000b:
            int r1 = r0 + 1
            long r2 = (long) r1
            boolean r2 = r5.request(r2)
            if (r2 == 0) goto L_0x006b
            okio.Buffer r2 = r5.bufferField
            long r3 = (long) r0
            byte r2 = r2.getByte(r3)
            r3 = 48
            byte r3 = (byte) r3
            if (r2 < r3) goto L_0x0025
            r3 = 57
            byte r3 = (byte) r3
            if (r2 <= r3) goto L_0x003a
        L_0x0025:
            r3 = 97
            byte r3 = (byte) r3
            if (r2 < r3) goto L_0x002f
            r3 = 102(0x66, float:1.43E-43)
            byte r3 = (byte) r3
            if (r2 <= r3) goto L_0x003a
        L_0x002f:
            r3 = 65
            byte r3 = (byte) r3
            if (r2 < r3) goto L_0x003c
            r3 = 70
            byte r3 = (byte) r3
            if (r2 <= r3) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            r0 = r1
            goto L_0x000b
        L_0x003c:
            if (r0 == 0) goto L_0x003f
            goto L_0x006b
        L_0x003f:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = "Expected leading [0-9a-fA-F] character but was 0x"
            r5.append(r0)
            r0 = 16
            int r0 = kotlin.text.CharsKt.checkRadix(r0)
            int r0 = kotlin.text.CharsKt.checkRadix(r0)
            java.lang.String r0 = java.lang.Integer.toString(r2, r0)
            java.lang.String r1 = "java.lang.Integer.toStri…(this, checkRadix(radix))"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            r0.<init>(r5)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x006b:
            okio.Buffer r5 = r5.bufferField
            long r0 = r5.readHexadecimalUnsignedLong()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.RealBufferedSourceKt.commonReadHexadecimalUnsignedLong(okio.RealBufferedSource):long");
    }

    public static final void commonSkip(RealBufferedSource realBufferedSource, long j) {
        Intrinsics.checkParameterIsNotNull(realBufferedSource, "$this$commonSkip");
        if (!realBufferedSource.closed) {
            while (j > 0) {
                if (realBufferedSource.bufferField.size() == 0 && realBufferedSource.source.read(realBufferedSource.bufferField, (long) 8192) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j, realBufferedSource.bufferField.size());
                realBufferedSource.bufferField.skip(min);
                j -= min;
            }
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final long commonIndexOf(RealBufferedSource realBufferedSource, byte b, long j, long j2) {
        Intrinsics.checkParameterIsNotNull(realBufferedSource, "$this$commonIndexOf");
        boolean z = true;
        if (!realBufferedSource.closed) {
            if (0 > j || j2 < j) {
                z = false;
            }
            if (z) {
                while (j < j2) {
                    long indexOf = realBufferedSource.bufferField.indexOf(b, j, j2);
                    if (indexOf == -1) {
                        long size = realBufferedSource.bufferField.size();
                        if (size >= j2 || realBufferedSource.source.read(realBufferedSource.bufferField, (long) 8192) == -1) {
                            break;
                        }
                        j = Math.max(j, size);
                    } else {
                        return indexOf;
                    }
                }
                return -1;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("fromIndex=");
            sb.append(j);
            sb.append(" toIndex=");
            sb.append(j2);
            throw new IllegalArgumentException(sb.toString().toString());
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final long commonIndexOf(RealBufferedSource realBufferedSource, ByteString byteString, long j) {
        Intrinsics.checkParameterIsNotNull(realBufferedSource, "$this$commonIndexOf");
        Intrinsics.checkParameterIsNotNull(byteString, "bytes");
        if (!realBufferedSource.closed) {
            while (true) {
                long indexOf = realBufferedSource.bufferField.indexOf(byteString, j);
                if (indexOf != -1) {
                    return indexOf;
                }
                long size = realBufferedSource.bufferField.size();
                if (realBufferedSource.source.read(realBufferedSource.bufferField, (long) 8192) == -1) {
                    return -1;
                }
                j = Math.max(j, (size - ((long) byteString.size())) + 1);
            }
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    public static final long commonIndexOfElement(RealBufferedSource realBufferedSource, ByteString byteString, long j) {
        Intrinsics.checkParameterIsNotNull(realBufferedSource, "$this$commonIndexOfElement");
        Intrinsics.checkParameterIsNotNull(byteString, "targetBytes");
        if (!realBufferedSource.closed) {
            while (true) {
                long indexOfElement = realBufferedSource.bufferField.indexOfElement(byteString, j);
                if (indexOfElement != -1) {
                    return indexOfElement;
                }
                long size = realBufferedSource.bufferField.size();
                if (realBufferedSource.source.read(realBufferedSource.bufferField, (long) 8192) == -1) {
                    return -1;
                }
                j = Math.max(j, size);
            }
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    public static final boolean commonRangeEquals(RealBufferedSource realBufferedSource, long j, ByteString byteString, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(realBufferedSource, "$this$commonRangeEquals");
        Intrinsics.checkParameterIsNotNull(byteString, "bytes");
        if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException("closed".toString());
        } else if (j < 0 || i < 0 || i2 < 0 || byteString.size() - i < i2) {
            return false;
        } else {
            for (int i3 = 0; i3 < i2; i3++) {
                long j2 = ((long) i3) + j;
                if (!realBufferedSource.request(1 + j2) || realBufferedSource.bufferField.getByte(j2) != byteString.getByte(i + i3)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static final BufferedSource commonPeek(RealBufferedSource realBufferedSource) {
        Intrinsics.checkParameterIsNotNull(realBufferedSource, "$this$commonPeek");
        return Okio.buffer((Source) new PeekSource(realBufferedSource));
    }

    public static final void commonClose(RealBufferedSource realBufferedSource) {
        Intrinsics.checkParameterIsNotNull(realBufferedSource, "$this$commonClose");
        if (!realBufferedSource.closed) {
            realBufferedSource.closed = true;
            realBufferedSource.source.close();
            realBufferedSource.bufferField.clear();
        }
    }

    public static final Timeout commonTimeout(RealBufferedSource realBufferedSource) {
        Intrinsics.checkParameterIsNotNull(realBufferedSource, "$this$commonTimeout");
        return realBufferedSource.source.timeout();
    }

    public static final String commonToString(RealBufferedSource realBufferedSource) {
        Intrinsics.checkParameterIsNotNull(realBufferedSource, "$this$commonToString");
        StringBuilder sb = new StringBuilder();
        sb.append("buffer(");
        sb.append(realBufferedSource.source);
        sb.append(')');
        return sb.toString();
    }

    public static final ByteString commonReadByteString(RealBufferedSource realBufferedSource) {
        Intrinsics.checkParameterIsNotNull(realBufferedSource, "$this$commonReadByteString");
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readByteString();
    }

    public static final byte[] commonReadByteArray(RealBufferedSource realBufferedSource) {
        Intrinsics.checkParameterIsNotNull(realBufferedSource, "$this$commonReadByteArray");
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readByteArray();
    }

    public static final String commonReadUtf8(RealBufferedSource realBufferedSource) {
        Intrinsics.checkParameterIsNotNull(realBufferedSource, "$this$commonReadUtf8");
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readUtf8();
    }
}
