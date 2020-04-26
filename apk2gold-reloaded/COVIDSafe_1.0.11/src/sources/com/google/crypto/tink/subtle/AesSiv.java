package com.google.crypto.tink.subtle;

import com.google.crypto.tink.DeterministicAead;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.util.Arrays;
import java.util.Collection;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class AesSiv implements DeterministicAead {
    private static final byte[] BLOCK_ONE = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
    private static final byte[] BLOCK_ZERO = new byte[16];
    private static final Collection<Integer> KEY_SIZES = Arrays.asList(new Integer[]{Integer.valueOf(64)});
    private final byte[] aesCtrKey;
    private final AesCmac cmacForS2V;

    public AesSiv(byte[] bArr) throws GeneralSecurityException {
        if (KEY_SIZES.contains(Integer.valueOf(bArr.length))) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length / 2);
            this.aesCtrKey = Arrays.copyOfRange(bArr, bArr.length / 2, bArr.length);
            this.cmacForS2V = new AesCmac(copyOfRange, 16);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("invalid key size: ");
        sb.append(bArr.length);
        sb.append(" bytes; key must have 64 bytes");
        throw new InvalidKeyException(sb.toString());
    }

    private byte[] s2v(byte[]... bArr) throws GeneralSecurityException {
        byte[] bArr2;
        if (bArr.length == 0) {
            return this.cmacForS2V.computeMac(BLOCK_ONE);
        }
        byte[] computeMac = this.cmacForS2V.computeMac(BLOCK_ZERO);
        for (int i = 0; i < bArr.length - 1; i++) {
            computeMac = Bytes.xor(AesUtil.dbl(computeMac), this.cmacForS2V.computeMac(bArr[i]));
        }
        byte[] bArr3 = bArr[bArr.length - 1];
        if (bArr3.length >= 16) {
            bArr2 = Bytes.xorEnd(bArr3, computeMac);
        } else {
            bArr2 = Bytes.xor(AesUtil.cmacPad(bArr3), AesUtil.dbl(computeMac));
        }
        return this.cmacForS2V.computeMac(bArr2);
    }

    public byte[] encryptDeterministically(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length <= 2147483631) {
            Cipher cipher = (Cipher) EngineFactory.CIPHER.getInstance("AES/CTR/NoPadding");
            byte[] s2v = s2v(bArr2, bArr);
            byte[] bArr3 = (byte[]) s2v.clone();
            bArr3[8] = (byte) (bArr3[8] & Byte.MAX_VALUE);
            bArr3[12] = (byte) (bArr3[12] & Byte.MAX_VALUE);
            cipher.init(1, new SecretKeySpec(this.aesCtrKey, "AES"), new IvParameterSpec(bArr3));
            return Bytes.concat(s2v, cipher.doFinal(bArr));
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    public byte[] decryptDeterministically(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length >= 16) {
            Cipher cipher = (Cipher) EngineFactory.CIPHER.getInstance("AES/CTR/NoPadding");
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 16);
            byte[] bArr3 = (byte[]) copyOfRange.clone();
            bArr3[8] = (byte) (bArr3[8] & Byte.MAX_VALUE);
            bArr3[12] = (byte) (bArr3[12] & Byte.MAX_VALUE);
            cipher.init(2, new SecretKeySpec(this.aesCtrKey, "AES"), new IvParameterSpec(bArr3));
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, 16, bArr.length);
            byte[] doFinal = cipher.doFinal(copyOfRange2);
            if (copyOfRange2.length == 0 && doFinal == null && SubtleUtil.isAndroid()) {
                doFinal = new byte[0];
            }
            if (Bytes.equal(copyOfRange, s2v(bArr2, doFinal))) {
                return doFinal;
            }
            throw new AEADBadTagException("Integrity check failed.");
        }
        throw new GeneralSecurityException("Ciphertext too short.");
    }
}
