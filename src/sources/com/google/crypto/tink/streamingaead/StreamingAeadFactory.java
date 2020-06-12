package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.StreamingAead;
import java.security.GeneralSecurityException;

@Deprecated
public final class StreamingAeadFactory {
    public static StreamingAead getPrimitive(KeysetHandle keysetHandle) throws GeneralSecurityException {
        return getPrimitive(keysetHandle, (KeyManager<StreamingAead>) null);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.crypto.tink.KeyManager, com.google.crypto.tink.KeyManager<com.google.crypto.tink.StreamingAead>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.crypto.tink.StreamingAead getPrimitive(com.google.crypto.tink.KeysetHandle r1, com.google.crypto.tink.KeyManager<com.google.crypto.tink.StreamingAead> r2) throws java.security.GeneralSecurityException {
        /*
            com.google.crypto.tink.streamingaead.StreamingAeadWrapper r0 = new com.google.crypto.tink.streamingaead.StreamingAeadWrapper
            r0.<init>()
            com.google.crypto.tink.Registry.registerPrimitiveWrapper(r0)
            java.lang.Class<com.google.crypto.tink.StreamingAead> r0 = com.google.crypto.tink.StreamingAead.class
            com.google.crypto.tink.PrimitiveSet r1 = com.google.crypto.tink.Registry.getPrimitives(r1, r2, r0)
            java.lang.Object r1 = com.google.crypto.tink.Registry.wrap(r1)
            com.google.crypto.tink.StreamingAead r1 = (com.google.crypto.tink.StreamingAead) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.streamingaead.StreamingAeadFactory.getPrimitive(com.google.crypto.tink.KeysetHandle, com.google.crypto.tink.KeyManager):com.google.crypto.tink.StreamingAead");
    }
}
