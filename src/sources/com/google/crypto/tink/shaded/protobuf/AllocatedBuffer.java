package com.google.crypto.tink.shaded.protobuf;

import java.nio.ByteBuffer;

abstract class AllocatedBuffer {
    public abstract byte[] array();

    public abstract int arrayOffset();

    public abstract boolean hasArray();

    public abstract boolean hasNioBuffer();

    public abstract int limit();

    public abstract ByteBuffer nioBuffer();

    public abstract int position();

    public abstract AllocatedBuffer position(int i);

    public abstract int remaining();

    AllocatedBuffer() {
    }

    public static AllocatedBuffer wrap(byte[] bArr) {
        return wrapNoCheck(bArr, 0, bArr.length);
    }

    public static AllocatedBuffer wrap(byte[] bArr, int i, int i2) {
        if (i >= 0 && i2 >= 0 && i + i2 <= bArr.length) {
            return wrapNoCheck(bArr, i, i2);
        }
        throw new IndexOutOfBoundsException(String.format("bytes.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
    }

    public static AllocatedBuffer wrap(final ByteBuffer byteBuffer) {
        Internal.checkNotNull(byteBuffer, "buffer");
        return new AllocatedBuffer() {
            public boolean hasNioBuffer() {
                return true;
            }

            public ByteBuffer nioBuffer() {
                return byteBuffer;
            }

            public boolean hasArray() {
                return byteBuffer.hasArray();
            }

            public byte[] array() {
                return byteBuffer.array();
            }

            public int arrayOffset() {
                return byteBuffer.arrayOffset();
            }

            public int position() {
                return byteBuffer.position();
            }

            public AllocatedBuffer position(int i) {
                byteBuffer.position(i);
                return this;
            }

            public int limit() {
                return byteBuffer.limit();
            }

            public int remaining() {
                return byteBuffer.remaining();
            }
        };
    }

    private static AllocatedBuffer wrapNoCheck(final byte[] bArr, final int i, final int i2) {
        return new AllocatedBuffer() {
            private int position;

            public boolean hasArray() {
                return true;
            }

            public boolean hasNioBuffer() {
                return false;
            }

            public ByteBuffer nioBuffer() {
                throw new UnsupportedOperationException();
            }

            public byte[] array() {
                return bArr;
            }

            public int arrayOffset() {
                return i;
            }

            public int position() {
                return this.position;
            }

            public AllocatedBuffer position(int i) {
                if (i < 0 || i > i2) {
                    throw new IllegalArgumentException("Invalid position: " + i);
                }
                this.position = i;
                return this;
            }

            public int limit() {
                return i2;
            }

            public int remaining() {
                return i2 - this.position;
            }
        };
    }
}
