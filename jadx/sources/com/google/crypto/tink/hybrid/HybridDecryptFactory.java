package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.HybridDecrypt;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.Registry;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

public final class HybridDecryptFactory {
    /* access modifiers changed from: private */
    public static final Logger logger = Logger.getLogger(HybridDecryptFactory.class.getName());

    public static HybridDecrypt getPrimitive(KeysetHandle keysetHandle) throws GeneralSecurityException {
        return getPrimitive(keysetHandle, (KeyManager<HybridDecrypt>) null);
    }

    public static HybridDecrypt getPrimitive(KeysetHandle keysetHandle, KeyManager<HybridDecrypt> keyManager) throws GeneralSecurityException {
        final PrimitiveSet<HybridDecrypt> primitives = Registry.getPrimitives(keysetHandle, keyManager);
        validate(primitives);
        return new HybridDecrypt() {
            public byte[] decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
                if (bArr.length > 5) {
                    byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 5);
                    byte[] copyOfRange2 = Arrays.copyOfRange(bArr, 5, bArr.length);
                    for (PrimitiveSet.Entry primitive : PrimitiveSet.this.getPrimitive(copyOfRange)) {
                        try {
                            return ((HybridDecrypt) primitive.getPrimitive()).decrypt(copyOfRange2, bArr2);
                        } catch (GeneralSecurityException e) {
                            Logger access$000 = HybridDecryptFactory.logger;
                            access$000.info("ciphertext prefix matches a key, but cannot decrypt: " + e.toString());
                        }
                    }
                }
                for (PrimitiveSet.Entry primitive2 : PrimitiveSet.this.getRawPrimitives()) {
                    try {
                        return ((HybridDecrypt) primitive2.getPrimitive()).decrypt(bArr, bArr2);
                    } catch (GeneralSecurityException unused) {
                    }
                }
                throw new GeneralSecurityException("decryption failed");
            }
        };
    }

    private static void validate(PrimitiveSet<HybridDecrypt> primitiveSet) throws GeneralSecurityException {
        for (List<PrimitiveSet.Entry<HybridDecrypt>> it : primitiveSet.getAll()) {
            Iterator it2 = it.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (!(((PrimitiveSet.Entry) it2.next()).getPrimitive() instanceof HybridDecrypt)) {
                        throw new GeneralSecurityException("invalid HybridDecrypt key material");
                    }
                }
            }
        }
    }
}
