package com.google.crypto.tink.subtle;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

abstract class Snuffle implements IndCpaCipher {
    public static final int BLOCK_SIZE_IN_BYTES = 64;
    public static final int BLOCK_SIZE_IN_INTS = 16;
    public static final int KEY_SIZE_IN_BYTES = 32;
    public static final int KEY_SIZE_IN_INTS = 8;
    static final int[] SIGMA = toIntArray(ByteBuffer.wrap(new byte[]{101, 120, 112, 97, 110, 100, 32, 51, 50, 45, 98, 121, 116, 101, 32, 107}));
    private final int initialCounter;
    final ImmutableByteArray key;

    static int rotateLeft(int i, int i2) {
        return (i >>> (-i2)) | (i << i2);
    }

    /* access modifiers changed from: package-private */
    public abstract ByteBuffer getKeyStreamBlock(byte[] bArr, int i);

    /* access modifiers changed from: package-private */
    public abstract int nonceSizeInBytes();

    Snuffle(byte[] bArr, int i) throws InvalidKeyException {
        if (bArr.length == 32) {
            this.key = ImmutableByteArray.of(bArr);
            this.initialCounter = i;
            return;
        }
        throw new InvalidKeyException("The key length in bytes must be 32.");
    }

    public byte[] encrypt(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length <= Integer.MAX_VALUE - nonceSizeInBytes()) {
            ByteBuffer allocate = ByteBuffer.allocate(nonceSizeInBytes() + bArr.length);
            encrypt(allocate, bArr);
            return allocate.array();
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    /* access modifiers changed from: package-private */
    public void encrypt(ByteBuffer byteBuffer, byte[] bArr) throws GeneralSecurityException {
        if (byteBuffer.remaining() - nonceSizeInBytes() >= bArr.length) {
            byte[] randBytes = Random.randBytes(nonceSizeInBytes());
            byteBuffer.put(randBytes);
            process(randBytes, byteBuffer, ByteBuffer.wrap(bArr));
            return;
        }
        throw new IllegalArgumentException("Given ByteBuffer output is too small");
    }

    public byte[] decrypt(byte[] bArr) throws GeneralSecurityException {
        return decrypt(ByteBuffer.wrap(bArr));
    }

    /* access modifiers changed from: package-private */
    public byte[] decrypt(ByteBuffer byteBuffer) throws GeneralSecurityException {
        if (byteBuffer.remaining() >= nonceSizeInBytes()) {
            byte[] bArr = new byte[nonceSizeInBytes()];
            byteBuffer.get(bArr);
            ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
            process(bArr, allocate, byteBuffer);
            return allocate.array();
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    private void process(byte[] bArr, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws GeneralSecurityException {
        int remaining = byteBuffer2.remaining();
        int i = (remaining / 64) + 1;
        for (int i2 = 0; i2 < i; i2++) {
            ByteBuffer keyStreamBlock = getKeyStreamBlock(bArr, this.initialCounter + i2);
            if (i2 == i - 1) {
                Bytes.xor(byteBuffer, byteBuffer2, keyStreamBlock, remaining % 64);
            } else {
                Bytes.xor(byteBuffer, byteBuffer2, keyStreamBlock, 64);
            }
        }
    }

    static int[] toIntArray(ByteBuffer byteBuffer) {
        IntBuffer asIntBuffer = byteBuffer.order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[asIntBuffer.remaining()];
        asIntBuffer.get(iArr);
        return iArr;
    }
}
