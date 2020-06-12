package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.KeyTemplate;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

public final class KmsEnvelopeAead implements Aead {
    private static final byte[] EMPTY_AAD = new byte[0];
    private static final int LENGTH_ENCRYPTED_DEK = 4;
    private final KeyTemplate dekTemplate;
    private final Aead remote;

    public KmsEnvelopeAead(KeyTemplate keyTemplate, Aead aead) {
        this.dekTemplate = keyTemplate;
        this.remote = aead;
    }

    public byte[] encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] byteArray = Registry.newKey(this.dekTemplate).toByteArray();
        return buildCiphertext(this.remote.encrypt(byteArray, EMPTY_AAD), ((Aead) Registry.getPrimitive(this.dekTemplate.getTypeUrl(), byteArray, Aead.class)).encrypt(bArr, bArr2));
    }

    public byte[] decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int i = wrap.getInt();
            if (i <= 0 || i > bArr.length - 4) {
                throw new GeneralSecurityException("invalid ciphertext");
            }
            byte[] bArr3 = new byte[i];
            wrap.get(bArr3, 0, i);
            byte[] bArr4 = new byte[wrap.remaining()];
            wrap.get(bArr4, 0, wrap.remaining());
            return ((Aead) Registry.getPrimitive(this.dekTemplate.getTypeUrl(), this.remote.decrypt(bArr3, EMPTY_AAD), Aead.class)).decrypt(bArr4, bArr2);
        } catch (IndexOutOfBoundsException | NegativeArraySizeException | BufferUnderflowException e) {
            throw new GeneralSecurityException("invalid ciphertext", e);
        }
    }

    private byte[] buildCiphertext(byte[] bArr, byte[] bArr2) {
        return ByteBuffer.allocate(bArr.length + 4 + bArr2.length).putInt(bArr.length).put(bArr).put(bArr2).array();
    }
}
