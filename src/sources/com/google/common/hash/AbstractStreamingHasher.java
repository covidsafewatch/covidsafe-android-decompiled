package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

abstract class AbstractStreamingHasher extends AbstractHasher {
    private final ByteBuffer buffer;
    private final int bufferSize;
    private final int chunkSize;

    /* access modifiers changed from: protected */
    public abstract HashCode makeHash();

    /* access modifiers changed from: protected */
    public abstract void process(ByteBuffer byteBuffer);

    protected AbstractStreamingHasher(int i) {
        this(i, i);
    }

    protected AbstractStreamingHasher(int i, int i2) {
        Preconditions.checkArgument(i2 % i == 0);
        this.buffer = ByteBuffer.allocate(i2 + 7).order(ByteOrder.LITTLE_ENDIAN);
        this.bufferSize = i2;
        this.chunkSize = i;
    }

    /* access modifiers changed from: protected */
    public void processRemaining(ByteBuffer byteBuffer) {
        byteBuffer.position(byteBuffer.limit());
        byteBuffer.limit(this.chunkSize + 7);
        while (true) {
            int position = byteBuffer.position();
            int i = this.chunkSize;
            if (position < i) {
                byteBuffer.putLong(0);
            } else {
                byteBuffer.limit(i);
                byteBuffer.flip();
                process(byteBuffer);
                return;
            }
        }
    }

    public final Hasher putBytes(byte[] bArr, int i, int i2) {
        return putBytesInternal(ByteBuffer.wrap(bArr, i, i2).order(ByteOrder.LITTLE_ENDIAN));
    }

    /* JADX INFO: finally extract failed */
    public final Hasher putBytes(ByteBuffer byteBuffer) {
        ByteOrder order = byteBuffer.order();
        try {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            Hasher putBytesInternal = putBytesInternal(byteBuffer);
            byteBuffer.order(order);
            return putBytesInternal;
        } catch (Throwable th) {
            byteBuffer.order(order);
            throw th;
        }
    }

    private Hasher putBytesInternal(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= this.buffer.remaining()) {
            this.buffer.put(byteBuffer);
            munchIfFull();
            return this;
        }
        int position = this.bufferSize - this.buffer.position();
        for (int i = 0; i < position; i++) {
            this.buffer.put(byteBuffer.get());
        }
        munch();
        while (byteBuffer.remaining() >= this.chunkSize) {
            process(byteBuffer);
        }
        this.buffer.put(byteBuffer);
        return this;
    }

    public final Hasher putByte(byte b) {
        this.buffer.put(b);
        munchIfFull();
        return this;
    }

    public final Hasher putShort(short s) {
        this.buffer.putShort(s);
        munchIfFull();
        return this;
    }

    public final Hasher putChar(char c) {
        this.buffer.putChar(c);
        munchIfFull();
        return this;
    }

    public final Hasher putInt(int i) {
        this.buffer.putInt(i);
        munchIfFull();
        return this;
    }

    public final Hasher putLong(long j) {
        this.buffer.putLong(j);
        munchIfFull();
        return this;
    }

    public final HashCode hash() {
        munch();
        this.buffer.flip();
        if (this.buffer.remaining() > 0) {
            processRemaining(this.buffer);
            ByteBuffer byteBuffer = this.buffer;
            byteBuffer.position(byteBuffer.limit());
        }
        return makeHash();
    }

    private void munchIfFull() {
        if (this.buffer.remaining() < 8) {
            munch();
        }
    }

    private void munch() {
        this.buffer.flip();
        while (this.buffer.remaining() >= this.chunkSize) {
            process(this.buffer);
        }
        this.buffer.compact();
    }
}
