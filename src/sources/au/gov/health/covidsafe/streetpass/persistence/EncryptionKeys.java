package au.gov.health.covidsafe.streetpass.persistence;

import java.util.Arrays;
import javax.crypto.SecretKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001b"}, d2 = {"Lau/gov/health/covidsafe/streetpass/persistence/EncryptionKeys;", "", "ephPubKey", "", "aesKey", "Ljavax/crypto/SecretKey;", "macKey", "nonce", "([BLjavax/crypto/SecretKey;Ljavax/crypto/SecretKey;[B)V", "getAesKey", "()Ljavax/crypto/SecretKey;", "getEphPubKey", "()[B", "getMacKey", "getNonce", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: Encryption.kt */
public final class EncryptionKeys {
    private final SecretKey aesKey;
    private final byte[] ephPubKey;
    private final SecretKey macKey;
    private final byte[] nonce;

    public static /* synthetic */ EncryptionKeys copy$default(EncryptionKeys encryptionKeys, byte[] bArr, SecretKey secretKey, SecretKey secretKey2, byte[] bArr2, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr = encryptionKeys.ephPubKey;
        }
        if ((i & 2) != 0) {
            secretKey = encryptionKeys.aesKey;
        }
        if ((i & 4) != 0) {
            secretKey2 = encryptionKeys.macKey;
        }
        if ((i & 8) != 0) {
            bArr2 = encryptionKeys.nonce;
        }
        return encryptionKeys.copy(bArr, secretKey, secretKey2, bArr2);
    }

    public final byte[] component1() {
        return this.ephPubKey;
    }

    public final SecretKey component2() {
        return this.aesKey;
    }

    public final SecretKey component3() {
        return this.macKey;
    }

    public final byte[] component4() {
        return this.nonce;
    }

    public final EncryptionKeys copy(byte[] bArr, SecretKey secretKey, SecretKey secretKey2, byte[] bArr2) {
        Intrinsics.checkParameterIsNotNull(bArr, "ephPubKey");
        Intrinsics.checkParameterIsNotNull(secretKey, "aesKey");
        Intrinsics.checkParameterIsNotNull(secretKey2, "macKey");
        Intrinsics.checkParameterIsNotNull(bArr2, "nonce");
        return new EncryptionKeys(bArr, secretKey, secretKey2, bArr2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EncryptionKeys)) {
            return false;
        }
        EncryptionKeys encryptionKeys = (EncryptionKeys) obj;
        return Intrinsics.areEqual((Object) this.ephPubKey, (Object) encryptionKeys.ephPubKey) && Intrinsics.areEqual((Object) this.aesKey, (Object) encryptionKeys.aesKey) && Intrinsics.areEqual((Object) this.macKey, (Object) encryptionKeys.macKey) && Intrinsics.areEqual((Object) this.nonce, (Object) encryptionKeys.nonce);
    }

    public int hashCode() {
        byte[] bArr = this.ephPubKey;
        int i = 0;
        int hashCode = (bArr != null ? Arrays.hashCode(bArr) : 0) * 31;
        SecretKey secretKey = this.aesKey;
        int hashCode2 = (hashCode + (secretKey != null ? secretKey.hashCode() : 0)) * 31;
        SecretKey secretKey2 = this.macKey;
        int hashCode3 = (hashCode2 + (secretKey2 != null ? secretKey2.hashCode() : 0)) * 31;
        byte[] bArr2 = this.nonce;
        if (bArr2 != null) {
            i = Arrays.hashCode(bArr2);
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "EncryptionKeys(ephPubKey=" + Arrays.toString(this.ephPubKey) + ", aesKey=" + this.aesKey + ", macKey=" + this.macKey + ", nonce=" + Arrays.toString(this.nonce) + ")";
    }

    public EncryptionKeys(byte[] bArr, SecretKey secretKey, SecretKey secretKey2, byte[] bArr2) {
        Intrinsics.checkParameterIsNotNull(bArr, "ephPubKey");
        Intrinsics.checkParameterIsNotNull(secretKey, "aesKey");
        Intrinsics.checkParameterIsNotNull(secretKey2, "macKey");
        Intrinsics.checkParameterIsNotNull(bArr2, "nonce");
        this.ephPubKey = bArr;
        this.aesKey = secretKey;
        this.macKey = secretKey2;
        this.nonce = bArr2;
    }

    public final SecretKey getAesKey() {
        return this.aesKey;
    }

    public final byte[] getEphPubKey() {
        return this.ephPubKey;
    }

    public final SecretKey getMacKey() {
        return this.macKey;
    }

    public final byte[] getNonce() {
        return this.nonce;
    }
}
