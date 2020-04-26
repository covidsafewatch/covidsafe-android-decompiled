package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.Catalogue;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.StreamingAead;
import java.security.GeneralSecurityException;

class StreamingAeadCatalogue implements Catalogue<StreamingAead> {
    public KeyManager<StreamingAead> getKeyManager(String str, String str2, int i) throws GeneralSecurityException {
        String lowerCase = str2.toLowerCase();
        if (((lowerCase.hashCode() == 754366121 && lowerCase.equals("streamingaead")) ? (char) 0 : 65535) == 0) {
            KeyManager<StreamingAead> streamingAeadKeyManager = streamingAeadKeyManager(str);
            if (streamingAeadKeyManager.getVersion() >= i) {
                return streamingAeadKeyManager;
            }
            throw new GeneralSecurityException(String.format("No key manager for key type '%s' with version at least %d.", new Object[]{str, Integer.valueOf(i)}));
        }
        throw new GeneralSecurityException(String.format("No support for primitive '%s'.", new Object[]{str2}));
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.crypto.tink.KeyManager<com.google.crypto.tink.StreamingAead> streamingAeadKeyManager(java.lang.String r5) throws java.security.GeneralSecurityException {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = -2002307740(0xffffffff88a73564, float:-1.0063499E-33)
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L_0x001b
            r1 = -608502222(0xffffffffdbbafe32, float:-1.05267673E17)
            if (r0 == r1) goto L_0x0011
            goto L_0x0025
        L_0x0011:
            java.lang.String r0 = "type.googleapis.com/google.crypto.tink.AesGcmHkdfStreamingKey"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0025
            r0 = r3
            goto L_0x0026
        L_0x001b:
            java.lang.String r0 = "type.googleapis.com/google.crypto.tink.AesCtrHmacStreamingKey"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0025
            r0 = r2
            goto L_0x0026
        L_0x0025:
            r0 = -1
        L_0x0026:
            if (r0 == 0) goto L_0x0040
            if (r0 != r3) goto L_0x0030
            com.google.crypto.tink.streamingaead.AesGcmHkdfStreamingKeyManager r5 = new com.google.crypto.tink.streamingaead.AesGcmHkdfStreamingKeyManager
            r5.<init>()
            return r5
        L_0x0030:
            java.security.GeneralSecurityException r0 = new java.security.GeneralSecurityException
            java.lang.Object[] r1 = new java.lang.Object[r3]
            r1[r2] = r5
            java.lang.String r5 = "No support for primitive 'StreamingAead' with key type '%s'."
            java.lang.String r5 = java.lang.String.format(r5, r1)
            r0.<init>(r5)
            throw r0
        L_0x0040:
            com.google.crypto.tink.streamingaead.AesCtrHmacStreamingKeyManager r5 = new com.google.crypto.tink.streamingaead.AesCtrHmacStreamingKeyManager
            r5.<init>()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.streamingaead.StreamingAeadCatalogue.streamingAeadKeyManager(java.lang.String):com.google.crypto.tink.KeyManager");
    }
}
