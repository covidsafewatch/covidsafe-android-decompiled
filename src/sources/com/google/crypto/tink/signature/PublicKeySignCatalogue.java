package com.google.crypto.tink.signature;

import com.google.crypto.tink.Catalogue;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.PublicKeySign;
import java.security.GeneralSecurityException;

class PublicKeySignCatalogue implements Catalogue<PublicKeySign> {
    public KeyManager<PublicKeySign> getKeyManager(String str, String str2, int i) throws GeneralSecurityException {
        String lowerCase = str2.toLowerCase();
        if (((lowerCase.hashCode() == -1213945325 && lowerCase.equals("publickeysign")) ? (char) 0 : 65535) == 0) {
            KeyManager<PublicKeySign> publicKeySignKeyManager = publicKeySignKeyManager(str);
            if (publicKeySignKeyManager.getVersion() >= i) {
                return publicKeySignKeyManager;
            }
            throw new GeneralSecurityException(String.format("No key manager for key type '%s' with version at least %d.", new Object[]{str, Integer.valueOf(i)}));
        }
        throw new GeneralSecurityException(String.format("No support for primitive '%s'.", new Object[]{str2}));
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.crypto.tink.KeyManager<com.google.crypto.tink.PublicKeySign> publicKeySignKeyManager(java.lang.String r5) throws java.security.GeneralSecurityException {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = -1470419991(0xffffffffa85b2be9, float:-1.2166464E-14)
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L_0x001b
            r1 = -359160126(0xffffffffea97a6c2, float:-9.1667645E25)
            if (r0 == r1) goto L_0x0011
            goto L_0x0025
        L_0x0011:
            java.lang.String r0 = "type.googleapis.com/google.crypto.tink.EcdsaPrivateKey"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0025
            r0 = r2
            goto L_0x0026
        L_0x001b:
            java.lang.String r0 = "type.googleapis.com/google.crypto.tink.Ed25519PrivateKey"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0025
            r0 = r3
            goto L_0x0026
        L_0x0025:
            r0 = -1
        L_0x0026:
            if (r0 == 0) goto L_0x0040
            if (r0 != r3) goto L_0x0030
            com.google.crypto.tink.signature.Ed25519PrivateKeyManager r5 = new com.google.crypto.tink.signature.Ed25519PrivateKeyManager
            r5.<init>()
            return r5
        L_0x0030:
            java.security.GeneralSecurityException r0 = new java.security.GeneralSecurityException
            java.lang.Object[] r1 = new java.lang.Object[r3]
            r1[r2] = r5
            java.lang.String r5 = "No support for primitive 'PublicKeySign' with key type '%s'."
            java.lang.String r5 = java.lang.String.format(r5, r1)
            r0.<init>(r5)
            throw r0
        L_0x0040:
            com.google.crypto.tink.signature.EcdsaSignKeyManager r5 = new com.google.crypto.tink.signature.EcdsaSignKeyManager
            r5.<init>()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.signature.PublicKeySignCatalogue.publicKeySignKeyManager(java.lang.String):com.google.crypto.tink.KeyManager");
    }
}
