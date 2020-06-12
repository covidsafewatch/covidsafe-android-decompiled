package com.google.crypto.tink.subtle;

import java.security.SecureRandom;

public final class Random {
    private static final ThreadLocal<SecureRandom> localRandom = new ThreadLocal<SecureRandom>() {
        /* access modifiers changed from: protected */
        public SecureRandom initialValue() {
            return Random.newDefaultSecureRandom();
        }
    };

    /* access modifiers changed from: private */
    public static SecureRandom newDefaultSecureRandom() {
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextLong();
        return secureRandom;
    }

    public static byte[] randBytes(int i) {
        byte[] bArr = new byte[i];
        localRandom.get().nextBytes(bArr);
        return bArr;
    }

    public static final int randInt(int i) {
        return localRandom.get().nextInt(i);
    }

    public static final int randInt() {
        return localRandom.get().nextInt();
    }
}
