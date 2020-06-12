package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.HybridDecrypt;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.KeysetHandle;
import java.security.GeneralSecurityException;

@Deprecated
public final class HybridDecryptFactory {
    @Deprecated
    public static HybridDecrypt getPrimitive(KeysetHandle keysetHandle) throws GeneralSecurityException {
        return getPrimitive(keysetHandle, (KeyManager<HybridDecrypt>) null);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.crypto.tink.KeyManager, com.google.crypto.tink.KeyManager<com.google.crypto.tink.HybridDecrypt>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.crypto.tink.HybridDecrypt getPrimitive(com.google.crypto.tink.KeysetHandle r1, com.google.crypto.tink.KeyManager<com.google.crypto.tink.HybridDecrypt> r2) throws java.security.GeneralSecurityException {
        /*
            com.google.crypto.tink.hybrid.HybridDecryptWrapper r0 = new com.google.crypto.tink.hybrid.HybridDecryptWrapper
            r0.<init>()
            com.google.crypto.tink.Registry.registerPrimitiveWrapper(r0)
            java.lang.Class<com.google.crypto.tink.HybridDecrypt> r0 = com.google.crypto.tink.HybridDecrypt.class
            com.google.crypto.tink.PrimitiveSet r1 = com.google.crypto.tink.Registry.getPrimitives(r1, r2, r0)
            java.lang.Object r1 = com.google.crypto.tink.Registry.wrap(r1)
            com.google.crypto.tink.HybridDecrypt r1 = (com.google.crypto.tink.HybridDecrypt) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.hybrid.HybridDecryptFactory.getPrimitive(com.google.crypto.tink.KeysetHandle, com.google.crypto.tink.KeyManager):com.google.crypto.tink.HybridDecrypt");
    }
}
