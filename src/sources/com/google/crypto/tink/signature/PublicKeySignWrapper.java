package com.google.crypto.tink.signature;

import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.subtle.Bytes;
import java.security.GeneralSecurityException;

public class PublicKeySignWrapper implements PrimitiveWrapper<PublicKeySign> {

    private static class WrappedPublicKeySign implements PublicKeySign {
        private final PrimitiveSet<PublicKeySign> primitives;

        public WrappedPublicKeySign(PrimitiveSet<PublicKeySign> primitiveSet) {
            this.primitives = primitiveSet;
        }

        public byte[] sign(byte[] bArr) throws GeneralSecurityException {
            if (this.primitives.getPrimary().getOutputPrefixType().equals(OutputPrefixType.LEGACY)) {
                return Bytes.concat(this.primitives.getPrimary().getIdentifier(), this.primitives.getPrimary().getPrimitive().sign(Bytes.concat(bArr, new byte[]{0})));
            }
            return Bytes.concat(this.primitives.getPrimary().getIdentifier(), this.primitives.getPrimary().getPrimitive().sign(bArr));
        }
    }

    PublicKeySignWrapper() {
    }

    public PublicKeySign wrap(PrimitiveSet<PublicKeySign> primitiveSet) {
        return new WrappedPublicKeySign(primitiveSet);
    }

    public Class<PublicKeySign> getPrimitiveClass() {
        return PublicKeySign.class;
    }

    public static void register() throws GeneralSecurityException {
        Registry.registerPrimitiveWrapper(new PublicKeySignWrapper());
    }
}
