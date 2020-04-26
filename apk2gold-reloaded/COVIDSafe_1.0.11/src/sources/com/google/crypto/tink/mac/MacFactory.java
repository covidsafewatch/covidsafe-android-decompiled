package com.google.crypto.tink.mac;

import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.PrimitiveSet.Entry;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.subtle.Bytes;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Logger;

public final class MacFactory {
    /* access modifiers changed from: private */
    public static final Logger logger = Logger.getLogger(MacFactory.class.getName());

    public static Mac getPrimitive(KeysetHandle keysetHandle) throws GeneralSecurityException {
        return getPrimitive(keysetHandle, null);
    }

    public static Mac getPrimitive(KeysetHandle keysetHandle, KeyManager<Mac> keyManager) throws GeneralSecurityException {
        final PrimitiveSet primitives = Registry.getPrimitives(keysetHandle, keyManager);
        validate(primitives);
        final byte[] bArr = {0};
        return new Mac() {
            public byte[] computeMac(byte[] bArr) throws GeneralSecurityException {
                if (PrimitiveSet.this.getPrimary().getOutputPrefixType().equals(OutputPrefixType.LEGACY)) {
                    return Bytes.concat(PrimitiveSet.this.getPrimary().getIdentifier(), ((Mac) PrimitiveSet.this.getPrimary().getPrimitive()).computeMac(Bytes.concat(bArr, bArr)));
                }
                return Bytes.concat(PrimitiveSet.this.getPrimary().getIdentifier(), ((Mac) PrimitiveSet.this.getPrimary().getPrimitive()).computeMac(bArr));
            }

            public void verifyMac(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
                if (bArr.length > 5) {
                    byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 5);
                    byte[] copyOfRange2 = Arrays.copyOfRange(bArr, 5, bArr.length);
                    for (Entry entry : PrimitiveSet.this.getPrimitive(copyOfRange)) {
                        try {
                            if (entry.getOutputPrefixType().equals(OutputPrefixType.LEGACY)) {
                                ((Mac) entry.getPrimitive()).verifyMac(copyOfRange2, Bytes.concat(bArr2, bArr));
                            } else {
                                ((Mac) entry.getPrimitive()).verifyMac(copyOfRange2, bArr2);
                            }
                            return;
                        } catch (GeneralSecurityException e) {
                            Logger access$000 = MacFactory.logger;
                            StringBuilder sb = new StringBuilder();
                            sb.append("tag prefix matches a key, but cannot verify: ");
                            sb.append(e.toString());
                            access$000.info(sb.toString());
                        }
                    }
                    for (Entry primitive : PrimitiveSet.this.getRawPrimitives()) {
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
        };
    }

    private static void validate(PrimitiveSet<Mac> primitiveSet) throws GeneralSecurityException {
        for (Collection it : primitiveSet.getAll()) {
            Iterator it2 = it.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (!(((Entry) it2.next()).getPrimitive() instanceof Mac)) {
                        throw new GeneralSecurityException("invalid MAC key material");
                    }
                }
            }
        }
    }
}
