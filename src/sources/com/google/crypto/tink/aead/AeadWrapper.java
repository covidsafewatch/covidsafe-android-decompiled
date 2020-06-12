package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.subtle.Bytes;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Logger;

public class AeadWrapper implements PrimitiveWrapper<Aead> {
    /* access modifiers changed from: private */
    public static final Logger logger = Logger.getLogger(AeadWrapper.class.getName());

    private static class WrappedAead implements Aead {
        private final PrimitiveSet<Aead> pSet;

        private WrappedAead(PrimitiveSet<Aead> primitiveSet) {
            this.pSet = primitiveSet;
        }

        public byte[] encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            return Bytes.concat(this.pSet.getPrimary().getIdentifier(), this.pSet.getPrimary().getPrimitive().encrypt(bArr, bArr2));
        }

        public byte[] decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            if (bArr.length > 5) {
                byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 5);
                byte[] copyOfRange2 = Arrays.copyOfRange(bArr, 5, bArr.length);
                for (PrimitiveSet.Entry primitive : this.pSet.getPrimitive(copyOfRange)) {
                    try {
                        return ((Aead) primitive.getPrimitive()).decrypt(copyOfRange2, bArr2);
                    } catch (GeneralSecurityException e) {
                        Logger access$000 = AeadWrapper.logger;
                        access$000.info("ciphertext prefix matches a key, but cannot decrypt: " + e.toString());
                    }
                }
            }
            for (PrimitiveSet.Entry primitive2 : this.pSet.getRawPrimitives()) {
                try {
                    return ((Aead) primitive2.getPrimitive()).decrypt(bArr, bArr2);
                } catch (GeneralSecurityException unused) {
                }
            }
            throw new GeneralSecurityException("decryption failed");
        }
    }

    AeadWrapper() {
    }

    public Aead wrap(PrimitiveSet<Aead> primitiveSet) throws GeneralSecurityException {
        return new WrappedAead(primitiveSet);
    }

    public Class<Aead> getPrimitiveClass() {
        return Aead.class;
    }

    public static void register() throws GeneralSecurityException {
        Registry.registerPrimitiveWrapper(new AeadWrapper());
    }
}
