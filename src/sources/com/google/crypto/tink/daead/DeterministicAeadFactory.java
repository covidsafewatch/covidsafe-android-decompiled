package com.google.crypto.tink.daead;

import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.KeysetHandle;
import java.security.GeneralSecurityException;

@Deprecated
public final class DeterministicAeadFactory {
    @Deprecated
    public static DeterministicAead getPrimitive(KeysetHandle keysetHandle) throws GeneralSecurityException {
        return getPrimitive(keysetHandle, (KeyManager<DeterministicAead>) null);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.crypto.tink.KeyManager, com.google.crypto.tink.KeyManager<com.google.crypto.tink.DeterministicAead>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.crypto.tink.DeterministicAead getPrimitive(com.google.crypto.tink.KeysetHandle r1, com.google.crypto.tink.KeyManager<com.google.crypto.tink.DeterministicAead> r2) throws java.security.GeneralSecurityException {
        /*
            com.google.crypto.tink.daead.DeterministicAeadWrapper r0 = new com.google.crypto.tink.daead.DeterministicAeadWrapper
            r0.<init>()
            com.google.crypto.tink.Registry.registerPrimitiveWrapper(r0)
            java.lang.Class<com.google.crypto.tink.DeterministicAead> r0 = com.google.crypto.tink.DeterministicAead.class
            com.google.crypto.tink.PrimitiveSet r1 = com.google.crypto.tink.Registry.getPrimitives(r1, r2, r0)
            java.lang.Object r1 = com.google.crypto.tink.Registry.wrap(r1)
            com.google.crypto.tink.DeterministicAead r1 = (com.google.crypto.tink.DeterministicAead) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.daead.DeterministicAeadFactory.getPrimitive(com.google.crypto.tink.KeysetHandle, com.google.crypto.tink.KeyManager):com.google.crypto.tink.DeterministicAead");
    }
}
