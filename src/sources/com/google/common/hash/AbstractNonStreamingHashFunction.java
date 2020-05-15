package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Arrays;

@Immutable
abstract class AbstractNonStreamingHashFunction extends AbstractHashFunction {
    public abstract HashCode hashBytes(byte[] bArr, int i, int i2);

    AbstractNonStreamingHashFunction() {
    }

    public Hasher newHasher() {
        return newHasher(32);
    }

    public Hasher newHasher(int i) {
        Preconditions.checkArgument(i >= 0);
        return new BufferingHasher(i);
    }

    public HashCode hashInt(int i) {
        return hashBytes(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(i).array());
    }

    public HashCode hashLong(long j) {
        return hashBytes(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(j).array());
    }

    public HashCode hashUnencodedChars(CharSequence charSequence) {
        int length = charSequence.length();
        ByteBuffer order = ByteBuffer.allocate(length * 2).order(ByteOrder.LITTLE_ENDIAN);
        for (int i = 0; i < length; i++) {
            order.putChar(charSequence.charAt(i));
        }
        return hashBytes(order.array());
    }

    public HashCode hashString(CharSequence charSequence, Charset charset) {
        return hashBytes(charSequence.toString().getBytes(charset));
    }

    public HashCode hashBytes(ByteBuffer byteBuffer) {
        return newHasher(byteBuffer.remaining()).putBytes(byteBuffer).hash();
    }

    private final class BufferingHasher extends AbstractHasher {
        final ExposedByteArrayOutputStream stream;

        BufferingHasher(int i) {
            this.stream = new ExposedByteArrayOutputStream(i);
        }

        public Hasher putByte(byte b) {
            this.stream.write(b);
            return this;
        }

        public Hasher putBytes(byte[] bArr, int i, int i2) {
            this.stream.write(bArr, i, i2);
            return this;
        }

        public Hasher putBytes(ByteBuffer byteBuffer) {
            this.stream.write(byteBuffer);
            return this;
        }

        public HashCode hash() {
            return AbstractNonStreamingHashFunction.this.hashBytes(this.stream.byteArray(), 0, this.stream.length());
        }
    }

    private static final class ExposedByteArrayOutputStream extends ByteArrayOutputStream {
        ExposedByteArrayOutputStream(int i) {
            super(i);
        }

        /* access modifiers changed from: package-private */
        public void write(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (this.count + remaining > this.buf.length) {
                this.buf = Arrays.copyOf(this.buf, this.count + remaining);
            }
            byteBuffer.get(this.buf, this.count, remaining);
            this.count += remaining;
        }

        /* access modifiers changed from: package-private */
        public byte[] byteArray() {
            return this.buf;
        }

        /* access modifiers changed from: package-private */
        public int length() {
            return this.count;
        }
    }
}
