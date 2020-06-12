package com.google.crypto.tink.mac;

import com.google.crypto.tink.Mac;
import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.subtle.Bytes;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Logger;

class MacWrapper implements PrimitiveWrapper<Mac> {
    /* access modifiers changed from: private */
    public static final Logger logger = Logger.getLogger(MacWrapper.class.getName());

    private static class WrappedMac implements Mac {
        private final byte[] formatVersion;
        private final PrimitiveSet<Mac> primitives;

        private WrappedMac(PrimitiveSet<Mac> primitiveSet) {
            this.formatVersion = new byte[]{0};
            this.primitives = primitiveSet;
        }

        public byte[] computeMac(byte[] bArr) throws GeneralSecurityException {
            if (this.primitives.getPrimary().getOutputPrefixType().equals(OutputPrefixType.LEGACY)) {
                return Bytes.concat(this.primitives.getPrimary().getIdentifier(), this.primitives.getPrimary().getPrimitive().computeMac(Bytes.concat(bArr, this.formatVersion)));
            }
            return Bytes.concat(this.primitives.getPrimary().getIdentifier(), this.primitives.getPrimary().getPrimitive().computeMac(bArr));
        }

        public void verifyMac(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            if (bArr.length > 5) {
                byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 5);
                byte[] copyOfRange2 = Arrays.copyOfRange(bArr, 5, bArr.length);
                for (PrimitiveSet.Entry next : this.primitives.getPrimitive(copyOfRange)) {
                    try {
                        if (next.getOutputPrefixType().equals(OutputPrefixType.LEGACY)) {
                            ((Mac) next.getPrimitive()).verifyMac(copyOfRange2, Bytes.concat(bArr2, this.formatVersion));
                            return;
                        }
                        ((Mac) next.getPrimitive()).verifyMac(copyOfRange2, bArr2);
                        return;
                    } catch (GeneralSecurityException e) {
                        Logger access$000 = MacWrapper.logger;
                        access$000.info("tag prefix matches a key, but cannot verify: " + e.toString());
                    }
                }
                for (PrimitiveSet.Entry primitive : this.primitives.getRawPrimitives()) {
                    try {
                        ((Mac) primitive.getPrimitive()).verifyMac(bArr, bArr2);
                        return;
                    } catch (GeneralSecurityException unused) {
                    }
                }
                throw new GeneralSecurityException("invalid MAC");
            }
            throw new GeneralSecurityException("tag too short");
        }
    }

    MacWrapper() {
    }

    public Mac wrap(PrimitiveSet<Mac> primitiveSet) throws GeneralSecurityException {
        return new WrappedMac(primitiveSet);
    }

    public Class<Mac> getPrimitiveClass() {
        return Mac.class;
    }

    public static void register() throws GeneralSecurityException {
        Registry.registerPrimitiveWrapper(new MacWrapper());
    }
}
