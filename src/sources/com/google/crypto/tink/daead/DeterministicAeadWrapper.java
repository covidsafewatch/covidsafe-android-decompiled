package com.google.crypto.tink.daead;

import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.subtle.Bytes;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Logger;

public class DeterministicAeadWrapper implements PrimitiveWrapper<DeterministicAead> {
    /* access modifiers changed from: private */
    public static final Logger logger = Logger.getLogger(DeterministicAeadWrapper.class.getName());

    private static class WrappedDeterministicAead implements DeterministicAead {
        private PrimitiveSet<DeterministicAead> primitives;

        public WrappedDeterministicAead(PrimitiveSet<DeterministicAead> primitiveSet) {
            this.primitives = primitiveSet;
        }

        public byte[] encryptDeterministically(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            return Bytes.concat(this.primitives.getPrimary().getIdentifier(), this.primitives.getPrimary().getPrimitive().encryptDeterministically(bArr, bArr2));
        }

        public byte[] decryptDeterministically(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            if (bArr.length > 5) {
                byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 5);
                byte[] copyOfRange2 = Arrays.copyOfRange(bArr, 5, bArr.length);
                for (PrimitiveSet.Entry primitive : this.primitives.getPrimitive(copyOfRange)) {
                    try {
                        return ((DeterministicAead) primitive.getPrimitive()).decryptDeterministically(copyOfRange2, bArr2);
                    } catch (GeneralSecurityException e) {
                        Logger access$000 = DeterministicAeadWrapper.logger;
                        access$000.info("ciphertext prefix matches a key, but cannot decrypt: " + e.toString());
                    }
                }
            }
            for (PrimitiveSet.Entry primitive2 : this.primitives.getRawPrimitives()) {
                try {
                    return ((DeterministicAead) primitive2.getPrimitive()).decryptDeterministically(bArr, bArr2);
                } catch (GeneralSecurityException unused) {
                }
            }
            throw new GeneralSecurityException("decryption failed");
        }
    }

    DeterministicAeadWrapper() {
    }

    public DeterministicAead wrap(PrimitiveSet<DeterministicAead> primitiveSet) {
        return new WrappedDeterministicAead(primitiveSet);
    }

    public Class<DeterministicAead> getPrimitiveClass() {
        return DeterministicAead.class;
    }

    public static void register() throws GeneralSecurityException {
        Registry.registerPrimitiveWrapper(new DeterministicAeadWrapper());
    }
}
