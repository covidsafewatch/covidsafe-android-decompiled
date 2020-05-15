package com.google.crypto.tink.subtle;

import com.google.crypto.tink.PublicKeySign;
import java.security.GeneralSecurityException;
import java.util.Arrays;

public final class Ed25519Sign implements PublicKeySign {
    public static final int SECRET_KEY_LEN = 32;
    private final byte[] hashedPrivateKey;
    private final byte[] publicKey;

    public Ed25519Sign(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length == 32) {
            byte[] hashedScalar = Ed25519.getHashedScalar(bArr);
            this.hashedPrivateKey = hashedScalar;
            this.publicKey = Ed25519.scalarMultWithBaseToBytes(hashedScalar);
            return;
        }
        throw new IllegalArgumentException(String.format("Given private key's length is not %s", new Object[]{32}));
    }

    public byte[] sign(byte[] bArr) throws GeneralSecurityException {
        return Ed25519.sign(bArr, this.publicKey, this.hashedPrivateKey);
    }

    public static final class KeyPair {
        private final byte[] privateKey;
        private final byte[] publicKey;

        private KeyPair(byte[] bArr, byte[] bArr2) {
            this.publicKey = bArr;
            this.privateKey = bArr2;
        }

        public byte[] getPublicKey() {
            byte[] bArr = this.publicKey;
            return Arrays.copyOf(bArr, bArr.length);
        }

        public byte[] getPrivateKey() {
            byte[] bArr = this.privateKey;
            return Arrays.copyOf(bArr, bArr.length);
        }

        public static KeyPair newKeyPair() throws GeneralSecurityException {
            byte[] randBytes = Random.randBytes(32);
            return new KeyPair(Ed25519.scalarMultWithBaseToBytes(Ed25519.getHashedScalar(randBytes)), randBytes);
        }
    }
}
