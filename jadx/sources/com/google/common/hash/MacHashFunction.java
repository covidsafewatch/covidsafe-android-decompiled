package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;

@Immutable
final class MacHashFunction extends AbstractHashFunction {
    private final int bits = (this.prototype.getMacLength() * 8);
    private final Key key;
    private final Mac prototype;
    private final boolean supportsClone = supportsClone(this.prototype);
    private final String toString;

    MacHashFunction(String str, Key key2, String str2) {
        this.prototype = getMac(str, key2);
        this.key = (Key) Preconditions.checkNotNull(key2);
        this.toString = (String) Preconditions.checkNotNull(str2);
    }

    public int bits() {
        return this.bits;
    }

    private static boolean supportsClone(Mac mac) {
        try {
            mac.clone();
            return true;
        } catch (CloneNotSupportedException unused) {
            return false;
        }
    }

    private static Mac getMac(String str, Key key2) {
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(key2);
            return instance;
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        } catch (InvalidKeyException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public Hasher newHasher() {
        if (this.supportsClone) {
            try {
                return new MacHasher((Mac) this.prototype.clone());
            } catch (CloneNotSupportedException unused) {
            }
        }
        return new MacHasher(getMac(this.prototype.getAlgorithm(), this.key));
    }

    public String toString() {
        return this.toString;
    }

    private static final class MacHasher extends AbstractByteHasher {
        private boolean done;
        private final Mac mac;

        private MacHasher(Mac mac2) {
            this.mac = mac2;
        }

        /* access modifiers changed from: protected */
        public void update(byte b) {
            checkNotDone();
            this.mac.update(b);
        }

        /* access modifiers changed from: protected */
        public void update(byte[] bArr) {
            checkNotDone();
            this.mac.update(bArr);
        }

        /* access modifiers changed from: protected */
        public void update(byte[] bArr, int i, int i2) {
            checkNotDone();
            this.mac.update(bArr, i, i2);
        }

        /* access modifiers changed from: protected */
        public void update(ByteBuffer byteBuffer) {
            checkNotDone();
            Preconditions.checkNotNull(byteBuffer);
            this.mac.update(byteBuffer);
        }

        private void checkNotDone() {
            Preconditions.checkState(!this.done, "Cannot re-use a Hasher after calling hash() on it");
        }

        public HashCode hash() {
            checkNotDone();
            this.done = true;
            return HashCode.fromBytesNoCopy(this.mac.doFinal());
        }
    }
}
