package com.google.crypto.tink.subtle;

import com.google.crypto.tink.Aead;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import javax.crypto.AEADBadTagException;

abstract class SnufflePoly1305 implements Aead {
    private final byte[] key;
    private final Snuffle macKeysnuffle;
    private final Snuffle snuffle;

    /* access modifiers changed from: 0000 */
    public abstract Snuffle createSnuffleInstance(byte[] bArr, int i) throws InvalidKeyException;

    SnufflePoly1305(byte[] bArr) throws InvalidKeyException {
        this.key = (byte[]) bArr.clone();
        this.snuffle = createSnuffleInstance(bArr, 1);
        this.macKeysnuffle = createSnuffleInstance(bArr, 0);
    }

    public byte[] encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length <= (Integer.MAX_VALUE - this.snuffle.nonceSizeInBytes()) - 16) {
            ByteBuffer allocate = ByteBuffer.allocate(bArr.length + this.snuffle.nonceSizeInBytes() + 16);
            encrypt(allocate, bArr, bArr2);
            return allocate.array();
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    private void encrypt(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (byteBuffer.remaining() >= bArr.length + this.snuffle.nonceSizeInBytes() + 16) {
            int position = byteBuffer.position();
            this.snuffle.encrypt(byteBuffer, bArr);
            byteBuffer.position(position);
            byte[] bArr3 = new byte[this.snuffle.nonceSizeInBytes()];
            byteBuffer.get(bArr3);
            byteBuffer.limit(byteBuffer.limit() - 16);
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            byte[] computeMac = Poly1305.computeMac(getMacKey(bArr3), macDataRfc7539(bArr2, byteBuffer));
            byteBuffer.limit(byteBuffer.limit() + 16);
            byteBuffer.put(computeMac);
            return;
        }
        throw new IllegalArgumentException("Given ByteBuffer output is too small");
    }

    public byte[] decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return decrypt(ByteBuffer.wrap(bArr), bArr2);
    }

    private byte[] decrypt(ByteBuffer byteBuffer, byte[] bArr) throws GeneralSecurityException {
        if (byteBuffer.remaining() >= this.snuffle.nonceSizeInBytes() + 16) {
            int position = byteBuffer.position();
            byte[] bArr2 = new byte[16];
            byteBuffer.position(byteBuffer.limit() - 16);
            byteBuffer.get(bArr2);
            byteBuffer.position(position);
            byteBuffer.limit(byteBuffer.limit() - 16);
            byte[] bArr3 = new byte[this.snuffle.nonceSizeInBytes()];
            byteBuffer.get(bArr3);
            if (bArr == null) {
                bArr = new byte[0];
            }
            try {
                Poly1305.verifyMac(getMacKey(bArr3), macDataRfc7539(bArr, byteBuffer), bArr2);
                byteBuffer.position(position);
                return this.snuffle.decrypt(byteBuffer);
            } catch (GeneralSecurityException e) {
                throw new AEADBadTagException(e.toString());
            }
        } else {
            throw new GeneralSecurityException("ciphertext too short");
        }
    }

    static byte[] macDataRfc7539(byte[] bArr, ByteBuffer byteBuffer) {
        int length = bArr.length % 16 == 0 ? bArr.length : (bArr.length + 16) - (bArr.length % 16);
        int remaining = byteBuffer.remaining();
        int i = remaining % 16;
        int i2 = (i == 0 ? remaining : (remaining + 16) - i) + length;
        ByteBuffer order = ByteBuffer.allocate(i2 + 16).order(ByteOrder.LITTLE_ENDIAN);
        order.put(bArr);
        order.position(length);
        order.put(byteBuffer);
        order.position(i2);
        order.putLong((long) bArr.length);
        order.putLong((long) remaining);
        return order.array();
    }

    private byte[] getMacKey(byte[] bArr) throws InvalidKeyException {
        byte[] bArr2 = new byte[32];
        this.macKeysnuffle.getKeyStreamBlock(bArr, 0).get(bArr2);
        return bArr2;
    }
}
