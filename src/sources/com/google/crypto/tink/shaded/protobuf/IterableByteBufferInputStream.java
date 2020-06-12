package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;

class IterableByteBufferInputStream extends InputStream {
    private long currentAddress;
    private byte[] currentArray;
    private int currentArrayOffset;
    private ByteBuffer currentByteBuffer;
    private int currentByteBufferPos;
    private int currentIndex;
    private int dataSize = 0;
    private boolean hasArray;
    private Iterator<ByteBuffer> iterator;

    IterableByteBufferInputStream(Iterable<ByteBuffer> iterable) {
        this.iterator = iterable.iterator();
        for (ByteBuffer next : iterable) {
            this.dataSize++;
        }
        this.currentIndex = -1;
        if (!getNextByteBuffer()) {
            this.currentByteBuffer = Internal.EMPTY_BYTE_BUFFER;
            this.currentIndex = 0;
            this.currentByteBufferPos = 0;
            this.currentAddress = 0;
        }
    }

    private boolean getNextByteBuffer() {
        this.currentIndex++;
        if (!this.iterator.hasNext()) {
            return false;
        }
        ByteBuffer next = this.iterator.next();
        this.currentByteBuffer = next;
        this.currentByteBufferPos = next.position();
        if (this.currentByteBuffer.hasArray()) {
            this.hasArray = true;
            this.currentArray = this.currentByteBuffer.array();
            this.currentArrayOffset = this.currentByteBuffer.arrayOffset();
        } else {
            this.hasArray = false;
            this.currentAddress = UnsafeUtil.addressOffset(this.currentByteBuffer);
            this.currentArray = null;
        }
        return true;
    }

    private void updateCurrentByteBufferPos(int i) {
        int i2 = this.currentByteBufferPos + i;
        this.currentByteBufferPos = i2;
        if (i2 == this.currentByteBuffer.limit()) {
            getNextByteBuffer();
        }
    }

    public int read() throws IOException {
        if (this.currentIndex == this.dataSize) {
            return -1;
        }
        if (this.hasArray) {
            byte b = this.currentArray[this.currentByteBufferPos + this.currentArrayOffset] & 255;
            updateCurrentByteBufferPos(1);
            return b;
        }
        byte b2 = UnsafeUtil.getByte(((long) this.currentByteBufferPos) + this.currentAddress) & 255;
        updateCurrentByteBufferPos(1);
        return b2;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.currentIndex == this.dataSize) {
            return -1;
        }
        int limit = this.currentByteBuffer.limit() - this.currentByteBufferPos;
        if (i2 > limit) {
            i2 = limit;
        }
        if (this.hasArray) {
            System.arraycopy(this.currentArray, this.currentByteBufferPos + this.currentArrayOffset, bArr, i, i2);
            updateCurrentByteBufferPos(i2);
        } else {
            int position = this.currentByteBuffer.position();
            this.currentByteBuffer.position(this.currentByteBufferPos);
            this.currentByteBuffer.get(bArr, i, i2);
            this.currentByteBuffer.position(position);
            updateCurrentByteBufferPos(i2);
        }
        return i2;
    }
}
