package com.google.crypto.tink.signature;

import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.subtle.Bytes;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

public final class PublicKeyVerifyFactory {
    /* access modifiers changed from: private */
    public static final Logger logger = Logger.getLogger(PublicKeyVerifyFactory.class.getName());

    public static PublicKeyVerify getPrimitive(KeysetHandle keysetHandle) throws GeneralSecurityException {
        return getPrimitive(keysetHandle, (KeyManager<PublicKeyVerify>) null);
    }

    public static PublicKeyVerify getPrimitive(KeysetHandle keysetHandle, KeyManager<PublicKeyVerify> keyManager) throws GeneralSecurityException {
        final PrimitiveSet<PublicKeyVerify> primitives = Registry.getPrimitives(keysetHandle, keyManager);
        validate(primitives);
        return new PublicKeyVerify() {
            public void verify(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
                if (bArr.length > 5) {
                    byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 5);
                    byte[] copyOfRange2 = Arrays.copyOfRange(bArr, 5, bArr.length);
                    for (PrimitiveSet.Entry entry : PrimitiveSet.this.getPrimitive(copyOfRange)) {
                        try {
                            if (entry.getOutputPrefixType().equals(OutputPrefixType.LEGACY)) {
                                ((PublicKeyVerify) entry.getPrimitive()).verify(copyOfRange2, Bytes.concat(bArr2, new byte[]{0}));
                                return;
                            }
                            ((PublicKeyVerify) entry.getPrimitive()).verify(copyOfRange2, bArr2);
                            return;
                        } catch (GeneralSecurityException e) {
                            Logger access$000 = PublicKeyVerifyFactory.logger;
                            access$000.info("signature prefix matches a key, but cannot verify: " + e.toString());
                        }
                    }
                    for (PrimitiveSet.Entry primitive : PrimitiveSet.this.getRawPrimitives()) {
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
        };
    }

    private static void validate(PrimitiveSet<PublicKeyVerify> primitiveSet) throws GeneralSecurityException {
        for (List<PrimitiveSet.Entry<PublicKeyVerify>> it : primitiveSet.getAll()) {
            Iterator it2 = it.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (!(((PrimitiveSet.Entry) it2.next()).getPrimitive() instanceof PublicKeyVerify)) {
                        throw new GeneralSecurityException("invalid PublicKeyVerify key material");
                    }
                }
            }
        }
    }
}
