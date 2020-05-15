package kotlin.io;

import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0005\n\u0002\u0010\f\n\u0002\u0010\u0019\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\b\u001a\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\rH\b\u001a\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000eH\b\u001a\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000fH\b\u001a\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0010H\b\u001a\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0011H\b\u001a\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0012H\b\u001a\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0001H\b\u001a\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0013H\b\u001a\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0014H\b\u001a\t\u0010\u0015\u001a\u00020\nH\b\u001a\u0013\u0010\u0015\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\b\u001a\u0011\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\rH\b\u001a\u0011\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000eH\b\u001a\u0011\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000fH\b\u001a\u0011\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0010H\b\u001a\u0011\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0011H\b\u001a\u0011\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0012H\b\u001a\u0011\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0001H\b\u001a\u0011\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0013H\b\u001a\u0011\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0014H\b\u001a\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u001a\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\f\u0010\u001a\u001a\u00020\r*\u00020\u001bH\u0002\u001a\f\u0010\u001c\u001a\u00020\n*\u00020\u001dH\u0002\u001a\u0018\u0010\u001e\u001a\u00020\n*\u00020\u001b2\n\u0010\u001f\u001a\u00060 j\u0002`!H\u0002\u001a$\u0010\"\u001a\u00020\r*\u00020\u00042\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\rH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006'"}, d2 = {"BUFFER_SIZE", "", "LINE_SEPARATOR_MAX_LENGTH", "decoder", "Ljava/nio/charset/CharsetDecoder;", "getDecoder", "()Ljava/nio/charset/CharsetDecoder;", "decoder$delegate", "Lkotlin/Lazy;", "print", "", "message", "", "", "", "", "", "", "", "", "", "println", "readLine", "", "inputStream", "Ljava/io/InputStream;", "endsWithLineSeparator", "Ljava/nio/CharBuffer;", "flipBack", "Ljava/nio/Buffer;", "offloadPrefixTo", "builder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "tryDecode", "byteBuffer", "Ljava/nio/ByteBuffer;", "charBuffer", "isEndOfStream", "kotlin-stdlib"}, k = 2, mv = {1, 1, 16})
/* compiled from: Console.kt */
public final class ConsoleKt {
    private static final int BUFFER_SIZE = 32;
    private static final int LINE_SEPARATOR_MAX_LENGTH = 2;
    private static final Lazy decoder$delegate = LazyKt.lazy(ConsoleKt$decoder$2.INSTANCE);

    private static final CharsetDecoder getDecoder() {
        return (CharsetDecoder) decoder$delegate.getValue();
    }

    private static final void print(Object obj) {
        System.out.print(obj);
    }

    private static final void print(int i) {
        System.out.print(i);
    }

    private static final void print(long j) {
        System.out.print(j);
    }

    private static final void print(byte b) {
        System.out.print(Byte.valueOf(b));
    }

    private static final void print(short s) {
        System.out.print(Short.valueOf(s));
    }

    private static final void print(char c) {
        System.out.print(c);
    }

    private static final void print(boolean z) {
        System.out.print(z);
    }

    private static final void print(float f) {
        System.out.print(f);
    }

    private static final void print(double d) {
        System.out.print(d);
    }

    private static final void print(char[] cArr) {
        System.out.print(cArr);
    }

    private static final void println(Object obj) {
        System.out.println(obj);
    }

    private static final void println(int i) {
        System.out.println(i);
    }

    private static final void println(long j) {
        System.out.println(j);
    }

    private static final void println(byte b) {
        System.out.println(Byte.valueOf(b));
    }

    private static final void println(short s) {
        System.out.println(Short.valueOf(s));
    }

    private static final void println(char c) {
        System.out.println(c);
    }

    private static final void println(boolean z) {
        System.out.println(z);
    }

    private static final void println(float f) {
        System.out.println(f);
    }

    private static final void println(double d) {
        System.out.println(d);
    }

    private static final void println(char[] cArr) {
        System.out.println(cArr);
    }

    private static final void println() {
        System.out.println();
    }

    public static final String readLine() {
        InputStream inputStream = System.in;
        Intrinsics.checkExpressionValueIsNotNull(inputStream, "System.`in`");
        return readLine(inputStream, getDecoder());
    }

    public static final String readLine(InputStream inputStream, CharsetDecoder charsetDecoder) {
        Intrinsics.checkParameterIsNotNull(inputStream, "inputStream");
        Intrinsics.checkParameterIsNotNull(charsetDecoder, "decoder");
        if (charsetDecoder.maxCharsPerByte() <= ((float) 1)) {
            ByteBuffer allocate = ByteBuffer.allocate(32);
            CharBuffer allocate2 = CharBuffer.allocate(4);
            StringBuilder sb = new StringBuilder();
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            do {
                allocate.put((byte) read);
                Intrinsics.checkExpressionValueIsNotNull(allocate, "byteBuffer");
                Intrinsics.checkExpressionValueIsNotNull(allocate2, "charBuffer");
                if (tryDecode(charsetDecoder, allocate, allocate2, false)) {
                    if (endsWithLineSeparator(allocate2)) {
                        break;
                    } else if (allocate2.remaining() < 2) {
                        offloadPrefixTo(allocate2, sb);
                    }
                }
                read = inputStream.read();
            } while (read != -1);
            tryDecode(charsetDecoder, allocate, allocate2, true);
            charsetDecoder.reset();
            int position = allocate2.position();
            if (position > 0 && allocate2.get(position - 1) == 10 && position - 1 > 0 && allocate2.get(position - 1) == 13) {
                position--;
            }
            allocate2.flip();
            for (int i = 0; i < position; i++) {
                sb.append(allocate2.get());
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("Encodings with multiple chars per byte are not supported".toString());
    }

    private static final boolean tryDecode(CharsetDecoder charsetDecoder, ByteBuffer byteBuffer, CharBuffer charBuffer, boolean z) {
        int position = charBuffer.position();
        byteBuffer.flip();
        CoderResult decode = charsetDecoder.decode(byteBuffer, charBuffer, z);
        if (decode.isError()) {
            decode.throwException();
        }
        boolean z2 = charBuffer.position() > position;
        if (z2) {
            byteBuffer.clear();
        } else {
            flipBack(byteBuffer);
        }
        return z2;
    }

    private static final boolean endsWithLineSeparator(CharBuffer charBuffer) {
        int position = charBuffer.position();
        if (position <= 0 || charBuffer.get(position - 1) != 10) {
            return false;
        }
        return true;
    }

    private static final void flipBack(Buffer buffer) {
        buffer.position(buffer.limit());
        buffer.limit(buffer.capacity());
    }

    private static final void offloadPrefixTo(CharBuffer charBuffer, StringBuilder sb) {
        charBuffer.flip();
        int limit = charBuffer.limit() - 1;
        for (int i = 0; i < limit; i++) {
            sb.append(charBuffer.get());
        }
        charBuffer.compact();
    }
}
