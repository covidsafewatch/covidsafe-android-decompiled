package com.google.crypto.tink.signature;

import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.subtle.Bytes;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

public final class PublicKeySignFactory {
    public static PublicKeySign getPrimitive(KeysetHandle keysetHandle) throws GeneralSecurityException {
        return getPrimitive(keysetHandle, (KeyManager<PublicKeySign>) null);
    }

    public static PublicKeySign getPrimitive(KeysetHandle keysetHandle, KeyManager<PublicKeySign> keyManager) throws GeneralSecurityException {
        final PrimitiveSet<PublicKeySign> primitives = Registry.getPrimitives(keysetHandle, keyManager);
        validate(primitives);
        return new PublicKeySign() {
            public byte[] sign(byte[] bArr) throws GeneralSecurityException {
                if (PrimitiveSet.this.getPrimary().getOutputPrefixType().equals(OutputPrefixType.LEGACY)) {
                    return Bytes.concat(PrimitiveSet.this.getPrimary().getIdentifier(), ((PublicKeySign) PrimitiveSet.this.getPrimary().getPrimitive()).sign(Bytes.concat(bArr, new byte[]{0})));
                }
                return Bytes.concat(PrimitiveSet.this.getPrimary().getIdentifier(), ((PublicKeySign) PrimitiveSet.this.getPrimary().getPrimitive()).sign(bArr));
            }
        };
    }

    private static void validate(PrimitiveSet<PublicKeySign> primitiveSet) throws GeneralSecurityException {
        for (List<PrimitiveSet.Entry<PublicKeySign>> it : primitiveSet.getAll()) {
            Iterator it2 = it.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (!(((PrimitiveSet.Entry) it2.next()).getPrimitive() instanceof PublicKeySign)) {
                        throw new GeneralSecurityException("invalid PublicKeySign key material");
                    }
                }
            }
        }
    }
}
