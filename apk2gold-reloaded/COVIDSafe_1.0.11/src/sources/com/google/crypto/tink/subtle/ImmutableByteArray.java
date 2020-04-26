package com.google.crypto.tink.subtle;

public final class ImmutableByteArray {
    private final byte[] data;

    public static ImmutableByteArray of(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return of(bArr, 0, bArr.length);
    }

    public static ImmutableByteArray of(byte[] bArr, int i, int i2) {
        return new ImmutableByteArray(bArr, i, i2);
    }

    public byte[] getBytes() {
        byte[] bArr = this.data;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public int getLength() {
        return this.data.length;
    }

    private ImmutableByteArray(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        this.data = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
    }
}
