package com.google.crypto.tink.subtle;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

abstract class ChaCha20Base implements IndCpaCipher {
    public static final int BLOCK_SIZE_IN_BYTES = 64;
    public static final int BLOCK_SIZE_IN_INTS = 16;
    public static final int KEY_SIZE_IN_BYTES = 32;
    public static final int KEY_SIZE_IN_INTS = 8;
    private static final int[] SIGMA = toIntArray(new byte[]{101, 120, 112, 97, 110, 100, 32, 51, 50, 45, 98, 121, 116, 101, 32, 107});
    private final int initialCounter;
    int[] key;

    private static int rotateLeft(int i, int i2) {
        return (i >>> (-i2)) | (i << i2);
    }

    /* access modifiers changed from: package-private */
    public abstract int[] createInitialState(int[] iArr, int i);

    /* access modifiers changed from: package-private */
    public abstract int nonceSizeInBytes();

    ChaCha20Base(byte[] bArr, int i) throws InvalidKeyException {
        if (bArr.length == 32) {
            this.key = toIntArray(bArr);
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
            ByteBuffer chacha20Block = chacha20Block(bArr, this.initialCounter + i2);
            if (i2 == i - 1) {
                Bytes.xor(byteBuffer, byteBuffer2, chacha20Block, remaining % 64);
            } else {
                Bytes.xor(byteBuffer, byteBuffer2, chacha20Block, 64);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ByteBuffer chacha20Block(byte[] bArr, int i) {
        int[] createInitialState = createInitialState(toIntArray(bArr), i);
        int[] iArr = (int[]) createInitialState.clone();
        shuffleState(iArr);
        for (int i2 = 0; i2 < createInitialState.length; i2++) {
            createInitialState[i2] = createInitialState[i2] + iArr[i2];
        }
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(createInitialState, 0, 16);
        return order;
    }

    static void setSigmaAndKey(int[] iArr, int[] iArr2) {
        int[] iArr3 = SIGMA;
        System.arraycopy(iArr3, 0, iArr, 0, iArr3.length);
        System.arraycopy(iArr2, 0, iArr, SIGMA.length, 8);
    }

    static void shuffleState(int[] iArr) {
        int[] iArr2 = iArr;
        for (int i = 0; i < 10; i++) {
            quarterRound(iArr2, 0, 4, 8, 12);
            quarterRound(iArr2, 1, 5, 9, 13);
            quarterRound(iArr2, 2, 6, 10, 14);
            quarterRound(iArr2, 3, 7, 11, 15);
            quarterRound(iArr2, 0, 5, 10, 15);
            quarterRound(iArr2, 1, 6, 11, 12);
            quarterRound(iArr2, 2, 7, 8, 13);
            quarterRound(iArr2, 3, 4, 9, 14);
        }
    }

    static void quarterRound(int[] iArr, int i, int i2, int i3, int i4) {
        iArr[i] = iArr[i] + iArr[i2];
        iArr[i4] = rotateLeft(iArr[i4] ^ iArr[i], 16);
        iArr[i3] = iArr[i3] + iArr[i4];
        iArr[i2] = rotateLeft(iArr[i2] ^ iArr[i3], 12);
        iArr[i] = iArr[i] + iArr[i2];
        iArr[i4] = rotateLeft(iArr[i] ^ iArr[i4], 8);
        iArr[i3] = iArr[i3] + iArr[i4];
        iArr[i2] = rotateLeft(iArr[i2] ^ iArr[i3], 7);
    }

    static int[] toIntArray(byte[] bArr) {
        IntBuffer asIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[asIntBuffer.remaining()];
        asIntBuffer.get(iArr);
        return iArr;
    }
}
