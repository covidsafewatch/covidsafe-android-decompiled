package com.google.crypto.tink.signature;

import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.subtle.Bytes;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Logger;

class PublicKeyVerifyWrapper implements PrimitiveWrapper<PublicKeyVerify> {
    /* access modifiers changed from: private */
    public static final Logger logger = Logger.getLogger(PublicKeyVerifyWrapper.class.getName());

    PublicKeyVerifyWrapper() {
    }

    private static class WrappedPublicKeyVerify implements PublicKeyVerify {
        private final PrimitiveSet<PublicKeyVerify> primitives;

        public WrappedPublicKeyVerify(PrimitiveSet<PublicKeyVerify> primitiveSet) {
            this.primitives = primitiveSet;
        }

        public void verify(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            if (bArr.length > 5) {
                byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 5);
                byte[] copyOfRange2 = Arrays.copyOfRange(bArr, 5, bArr.length);
                for (PrimitiveSet.Entry next : this.primitives.getPrimitive(copyOfRange)) {
                    try {
                        if (next.getOutputPrefixType().equals(OutputPrefixType.LEGACY)) {
                            ((PublicKeyVerify) next.getPrimitive()).verify(copyOfRange2, Bytes.concat(bArr2, new byte[]{0}));
                            return;
                        }
                        ((PublicKeyVerify) next.getPrimitive()).verify(copyOfRange2, bArr2);
                        return;
                    } catch (GeneralSecurityException e) {
                        Logger access$000 = PublicKeyVerifyWrapper.logger;
                        access$000.info("signature prefix matches a key, but cannot verify: " + e.toString());
                    }
                }
                for (PrimitiveSet.Entry primitive : this.primitives.getRawPrimitives()) {
                    try {
                        ((PublicKeyVerify) primitive.getPrimitive()).verify(bArr, bArr2);
                        return;
                    } catch (GeneralSecurityException unused) {
                    }
                }
                throw new GeneralSecurityException("invalid signature");
            }
            throw new GeneralSecurityException("signature too short");
        }
    }

    public PublicKeyVerify wrap(PrimitiveSet<PublicKeyVerify> primitiveSet) {
        return new WrappedPublicKeyVerify(primitiveSet);
    }

    public Class<PublicKeyVerify> getPrimitiveClass() {
        return PublicKeyVerify.class;
    }

    public static void register() throws GeneralSecurityException {
        Registry.registerPrimitiveWrapper(new PublicKeyVerifyWrapper());
    }
}
