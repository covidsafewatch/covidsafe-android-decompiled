package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.Catalogue;
import com.google.crypto.tink.KeyManager;
import java.security.GeneralSecurityException;

class AeadCatalogue implements Catalogue<Aead> {
    public KeyManager<Aead> getKeyManager(String str, String str2, int i) throws GeneralSecurityException {
        String lowerCase = str2.toLowerCase();
        if (((lowerCase.hashCode() == 2989895 && lowerCase.equals("aead")) ? (char) 0 : 65535) == 0) {
            KeyManager<Aead> aeadKeyManager = aeadKeyManager(str);
            if (aeadKeyManager.getVersion() >= i) {
                return aeadKeyManager;
            }
            throw new GeneralSecurityException(String.format("No key manager for key type '%s' with version at least %d.", new Object[]{str, Integer.valueOf(i)}));
        }
        throw new GeneralSecurityException(String.format("No support for primitive '%s'.", new Object[]{str2}));
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.crypto.tink.KeyManager<com.google.crypto.tink.Aead> aeadKeyManager(java.lang.String r8) throws java.security.GeneralSecurityException {
        /*
            r7 = this;
            int r0 = r8.hashCode()
            r1 = 0
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r0) {
                case 360753376: goto L_0x0040;
                case 1215885937: goto L_0x0036;
                case 1469984853: goto L_0x002c;
                case 1797113348: goto L_0x0022;
                case 1855890991: goto L_0x0018;
                case 2079211877: goto L_0x000e;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x004a
        L_0x000e:
            java.lang.String r0 = "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x004a
            r0 = r2
            goto L_0x004b
        L_0x0018:
            java.lang.String r0 = "type.googleapis.com/google.crypto.tink.AesGcmKey"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x004a
            r0 = r5
            goto L_0x004b
        L_0x0022:
            java.lang.String r0 = "type.googleapis.com/google.crypto.tink.AesEaxKey"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x004a
            r0 = r6
            goto L_0x004b
        L_0x002c:
            java.lang.String r0 = "type.googleapis.com/google.crypto.tink.KmsAeadKey"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x004a
            r0 = r3
            goto L_0x004b
        L_0x0036:
            java.lang.String r0 = "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x004a
            r0 = r1
            goto L_0x004b
        L_0x0040:
            java.lang.String r0 = "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x004a
            r0 = r4
            goto L_0x004b
        L_0x004a:
            r0 = -1
        L_0x004b:
            if (r0 == 0) goto L_0x0085
            if (r0 == r6) goto L_0x007f
            if (r0 == r5) goto L_0x0079
            if (r0 == r4) goto L_0x0073
            if (r0 == r3) goto L_0x006d
            if (r0 != r2) goto L_0x005d
            com.google.crypto.tink.aead.KmsEnvelopeAeadKeyManager r8 = new com.google.crypto.tink.aead.KmsEnvelopeAeadKeyManager
            r8.<init>()
            return r8
        L_0x005d:
            java.security.GeneralSecurityException r0 = new java.security.GeneralSecurityException
            java.lang.Object[] r2 = new java.lang.Object[r6]
            r2[r1] = r8
            java.lang.String r8 = "No support for primitive 'Aead' with key type '%s'."
            java.lang.String r8 = java.lang.String.format(r8, r2)
            r0.<init>(r8)
            throw r0
        L_0x006d:
            com.google.crypto.tink.aead.KmsAeadKeyManager r8 = new com.google.crypto.tink.aead.KmsAeadKeyManager
            r8.<init>()
            return r8
        L_0x0073:
            com.google.crypto.tink.aead.ChaCha20Poly1305KeyManager r8 = new com.google.crypto.tink.aead.ChaCha20Poly1305KeyManager
            r8.<init>()
            return r8
        L_0x0079:
            com.google.crypto.tink.aead.AesGcmKeyManager r8 = new com.google.crypto.tink.aead.AesGcmKeyManager
            r8.<init>()
            return r8
        L_0x007f:
            com.google.crypto.tink.aead.AesEaxKeyManager r8 = new com.google.crypto.tink.aead.AesEaxKeyManager
            r8.<init>()
            return r8
        L_0x0085:
            com.google.crypto.tink.aead.AesCtrHmacAeadKeyManager r8 = new com.google.crypto.tink.aead.AesCtrHmacAeadKeyManager
            r8.<init>()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.aead.AeadCatalogue.aeadKeyManager(java.lang.String):com.google.crypto.tink.KeyManager");
    }
}
