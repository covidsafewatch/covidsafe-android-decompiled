package com.google.crypto.tink.daead;

import com.google.crypto.tink.DeterministicAead;
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

public final class DeterministicAeadFactory {
    /* access modifiers changed from: private */
    public static final Logger logger = Logger.getLogger(DeterministicAeadFactory.class.getName());

    public static DeterministicAead getPrimitive(KeysetHandle keysetHandle) throws GeneralSecurityException {
        return getPrimitive(keysetHandle, (KeyManager<DeterministicAead>) null);
    }

    public static DeterministicAead getPrimitive(KeysetHandle keysetHandle, KeyManager<DeterministicAead> keyManager) throws GeneralSecurityException {
        final PrimitiveSet<DeterministicAead> primitives = Registry.getPrimitives(keysetHandle, keyManager);
        validate(primitives);
        return new DeterministicAead() {
            public byte[] encryptDeterministically(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
                return Bytes.concat(PrimitiveSet.this.getPrimary().getIdentifier(), ((DeterministicAead) PrimitiveSet.this.getPrimary().getPrimitive()).encryptDeterministically(bArr, bArr2));
            }

            public byte[] decryptDeterministically(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
                if (bArr.length > 5) {
                    byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 5);
                    byte[] copyOfRange2 = Arrays.copyOfRange(bArr, 5, bArr.length);
                    for (PrimitiveSet.Entry primitive : PrimitiveSet.this.getPrimitive(copyOfRange)) {
                        try {
                            return ((DeterministicAead) primitive.getPrimitive()).decryptDeterministically(copyOfRange2, bArr2);
                        } catch (GeneralSecurityException e) {
                            Logger access$000 = DeterministicAeadFactory.logger;
                            access$000.info("ciphertext prefix matches a key, but cannot decrypt: " + e.toString());
                        }
                    }
                }
                for (PrimitiveSet.Entry primitive2 : PrimitiveSet.this.getRawPrimitives()) {
                    try {
                        return ((DeterministicAead) primitive2.getPrimitive()).decryptDeterministically(bArr, bArr2);
                    } catch (GeneralSecurityException unused) {
                    }
                }
                throw new GeneralSecurityException("decryption failed");
            }
        };
    }

    private static void validate(PrimitiveSet<DeterministicAead> primitiveSet) throws GeneralSecurityException {
        for (List<PrimitiveSet.Entry<DeterministicAead>> it : primitiveSet.getAll()) {
            Iterator it2 = it.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (!(((PrimitiveSet.Entry) it2.next()).getPrimitive() instanceof DeterministicAead)) {
                        throw new GeneralSecurityException("invalid Deterministic AEAD key material");
                    }
                }
            }
        }
    }
}
