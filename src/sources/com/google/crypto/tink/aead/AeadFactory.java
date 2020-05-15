package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.subtle.Bytes;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

public final class AeadFactory {
    /* access modifiers changed from: private */
    public static final Logger logger = Logger.getLogger(AeadFactory.class.getName());

    public static Aead getPrimitive(KeysetHandle keysetHandle) throws GeneralSecurityException {
        return getPrimitive(keysetHandle, (KeyManager<Aead>) null);
    }

    public static Aead getPrimitive(KeysetHandle keysetHandle, KeyManager<Aead> keyManager) throws GeneralSecurityException {
        final PrimitiveSet<Aead> primitives = Registry.getPrimitives(keysetHandle, keyManager);
        validate(primitives);
        return new Aead() {
            public byte[] encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
                return Bytes.concat(PrimitiveSet.this.getPrimary().getIdentifier(), ((Aead) PrimitiveSet.this.getPrimary().getPrimitive()).encrypt(bArr, bArr2));
            }

            public byte[] decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
                if (bArr.length > 5) {
                    byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 5);
                    byte[] copyOfRange2 = Arrays.copyOfRange(bArr, 5, bArr.length);
                    for (PrimitiveSet.Entry primitive : PrimitiveSet.this.getPrimitive(copyOfRange)) {
                        try {
                            return ((Aead) primitive.getPrimitive()).decrypt(copyOfRange2, bArr2);
                        } catch (GeneralSecurityException e) {
                            Logger access$000 = AeadFactory.logger;
                            access$000.info("ciphertext prefix matches a key, but cannot decrypt: " + e.toString());
                        }
                    }
                }
                for (PrimitiveSet.Entry primitive2 : PrimitiveSet.this.getRawPrimitives()) {
                    try {
                        return ((Aead) primitive2.getPrimitive()).decrypt(bArr, bArr2);
                    } catch (GeneralSecurityException unused) {
                    }
                }
                throw new GeneralSecurityException("decryption failed");
            }
        };
    }

    private static void validate(PrimitiveSet<Aead> primitiveSet) throws GeneralSecurityException {
        for (List<PrimitiveSet.Entry<Aead>> it : primitiveSet.getAll()) {
            Iterator it2 = it.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (!(((PrimitiveSet.Entry) it2.next()).getPrimitive() instanceof Aead)) {
                        throw new GeneralSecurityException("invalid AEAD key material");
                    }
                }
            }
        }
    }
}
