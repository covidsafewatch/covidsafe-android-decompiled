package com.google.crypto.tink.subtle;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.InvalidKeyException;

class ChaCha20 extends Snuffle {
    private static final byte[] ZERO_16_BYTES = new byte[16];

    /* access modifiers changed from: package-private */
    public int nonceSizeInBytes() {
        return 12;
    }

    ChaCha20(byte[] bArr, int i) throws InvalidKeyException {
        super(bArr, i);
    }

    private int[] createInitialState(byte[] bArr, int i) {
        int[] iArr = new int[16];
        setSigma(iArr);
        setKey(iArr, this.key.getBytes());
        iArr[12] = i;
        System.arraycopy(toIntArray(ByteBuffer.wrap(bArr)), 0, iArr, 13, nonceSizeInBytes() / 4);
        return iArr;
    }

    /* access modifiers changed from: package-private */
    public ByteBuffer getKeyStreamBlock(byte[] bArr, int i) {
        int[] createInitialState = createInitialState(bArr, i);
        int[] iArr = (int[]) createInitialState.clone();
        shuffleState(iArr);
        for (int i2 = 0; i2 < createInitialState.length; i2++) {
            createInitialState[i2] = createInitialState[i2] + iArr[i2];
        }
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(createInitialState, 0, 16);
        return order;
    }

    private static void setSigma(int[] iArr) {
        System.arraycopy(Snuffle.SIGMA, 0, iArr, 0, SIGMA.length);
    }

    private static void setKey(int[] iArr, byte[] bArr) {
        int[] intArray = toIntArray(ByteBuffer.wrap(bArr));
        System.arraycopy(intArray, 0, iArr, 4, intArray.length);
    }

    private static void shuffleState(int[] iArr) {
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
}
