package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.HybridDecrypt;
import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.Registry;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Logger;

public class HybridDecryptWrapper implements PrimitiveWrapper<HybridDecrypt> {
    /* access modifiers changed from: private */
    public static final Logger logger = Logger.getLogger(HybridDecryptWrapper.class.getName());

    private static class WrappedHybridDecrypt implements HybridDecrypt {
        private final PrimitiveSet<HybridDecrypt> primitives;

        public WrappedHybridDecrypt(PrimitiveSet<HybridDecrypt> primitiveSet) {
            this.primitives = primitiveSet;
        }

        public byte[] decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            if (bArr.length > 5) {
                byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 5);
                byte[] copyOfRange2 = Arrays.copyOfRange(bArr, 5, bArr.length);
                for (PrimitiveSet.Entry primitive : this.primitives.getPrimitive(copyOfRange)) {
                    try {
                        return ((HybridDecrypt) primitive.getPrimitive()).decrypt(copyOfRange2, bArr2);
                    } catch (GeneralSecurityException e) {
                        Logger access$000 = HybridDecryptWrapper.logger;
                        access$000.info("ciphertext prefix matches a key, but cannot decrypt: " + e.toString());
                    }
                }
            }
            for (PrimitiveSet.Entry primitive2 : this.primitives.getRawPrimitives()) {
                try {
                    return ((HybridDecrypt) primitive2.getPrimitive()).decrypt(bArr, bArr2);
                } catch (GeneralSecurityException unused) {
                }
            }
            throw new GeneralSecurityException("decryption failed");
        }
    }

    HybridDecryptWrapper() {
    }

    public HybridDecrypt wrap(PrimitiveSet<HybridDecrypt> primitiveSet) {
        return new WrappedHybridDecrypt(primitiveSet);
    }

    public Class<HybridDecrypt> getPrimitiveClass() {
        return HybridDecrypt.class;
    }

    public static void register() throws GeneralSecurityException {
        Registry.registerPrimitiveWrapper(new HybridDecryptWrapper());
    }
}
