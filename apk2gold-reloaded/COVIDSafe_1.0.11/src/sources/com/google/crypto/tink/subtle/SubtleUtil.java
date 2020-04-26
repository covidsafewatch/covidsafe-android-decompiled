package com.google.crypto.tink.subtle;

import com.google.crypto.tink.subtle.Enums.HashType;
import java.security.GeneralSecurityException;

public class SubtleUtil {
    public static String toEcdsaAlgo(HashType hashType) throws GeneralSecurityException {
        Validators.validateSignatureHash(hashType);
        StringBuilder sb = new StringBuilder();
        sb.append(hashType);
        sb.append("withECDSA");
        return sb.toString();
    }

    public static String toRsaSsaPkcs1Algo(HashType hashType) throws GeneralSecurityException {
        Validators.validateSignatureHash(hashType);
        StringBuilder sb = new StringBuilder();
        sb.append(hashType);
        sb.append("withRSA");
        return sb.toString();
    }

    public static boolean isAndroid() {
        try {
            Class.forName("android.app.Application", false, null);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
