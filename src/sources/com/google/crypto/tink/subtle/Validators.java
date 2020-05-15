package com.google.crypto.tink.subtle;

import com.google.crypto.tink.subtle.Enums;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.regex.Pattern;

public final class Validators {
    private static final Pattern GCP_KMS_CRYPTO_KEY_PATTERN = Pattern.compile(String.format("^projects/%s/locations/%s/keyRings/%s/cryptoKeys/%s$", new Object[]{URI_UNRESERVED_CHARS, URI_UNRESERVED_CHARS, URI_UNRESERVED_CHARS, URI_UNRESERVED_CHARS}), 2);
    private static final Pattern GCP_KMS_CRYPTO_KEY_VERSION_PATTERN = Pattern.compile(String.format("^projects/%s/locations/%s/keyRings/%s/cryptoKeys/%s/cryptoKeyVersions/%s$", new Object[]{URI_UNRESERVED_CHARS, URI_UNRESERVED_CHARS, URI_UNRESERVED_CHARS, URI_UNRESERVED_CHARS, URI_UNRESERVED_CHARS}), 2);
    private static final String TYPE_URL_PREFIX = "type.googleapis.com/";
    private static final String URI_UNRESERVED_CHARS = "([0-9a-zA-Z\\-\\.\\_~])+";

    public static void validateTypeUrl(String str) throws GeneralSecurityException {
        if (!str.startsWith(TYPE_URL_PREFIX)) {
            throw new GeneralSecurityException(String.format("Error: type URL %s is invalid; it must start with %s.\n", new Object[]{str, TYPE_URL_PREFIX}));
        } else if (str.length() == 20) {
            throw new GeneralSecurityException(String.format("Error: type URL %s is invalid; it has no message name.\n", new Object[]{str}));
        }
    }

    public static void validateAesKeySize(int i) throws InvalidAlgorithmParameterException {
        if (i != 16 && i != 32) {
            throw new InvalidAlgorithmParameterException("invalid key size; only 128-bit and 256-bit AES keys are supported");
        }
    }

    public static void validateVersion(int i, int i2) throws GeneralSecurityException {
        if (i < 0 || i > i2) {
            throw new GeneralSecurityException(String.format("key has version %d; only keys with version in range [0..%d] are supported", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        }
    }

    /* renamed from: com.google.crypto.tink.subtle.Validators$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.google.crypto.tink.subtle.Enums$HashType[] r0 = com.google.crypto.tink.subtle.Enums.HashType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType = r0
                com.google.crypto.tink.subtle.Enums$HashType r1 = com.google.crypto.tink.subtle.Enums.HashType.SHA256     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.crypto.tink.subtle.Enums$HashType r1 = com.google.crypto.tink.subtle.Enums.HashType.SHA512     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.crypto.tink.subtle.Enums$HashType r1 = com.google.crypto.tink.subtle.Enums.HashType.SHA1     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.subtle.Validators.AnonymousClass1.<clinit>():void");
        }
    }

    public static void validateSignatureHash(Enums.HashType hashType) throws GeneralSecurityException {
        int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[hashType.ordinal()];
        if (i != 1 && i != 2) {
            if (i != 3) {
                throw new GeneralSecurityException("Unsupported hash " + hashType);
            }
            throw new GeneralSecurityException("SHA1 is not safe for signature");
        }
    }

    public static void validateNotExists(File file) throws IOException {
        if (file.exists()) {
            throw new IOException(String.format("%s exists, please choose another file\n", new Object[]{file.toString()}));
        }
    }

    public static void validateExists(File file) throws IOException {
        if (!file.exists()) {
            throw new IOException(String.format("Error: %s doesn't exist, please choose another file\n", new Object[]{file.toString()}));
        }
    }

    public static String validateKmsKeyUriAndRemovePrefix(String str, String str2) throws IllegalArgumentException {
        if (str2.toLowerCase().startsWith(str)) {
            return str2.substring(str.length());
        }
        throw new IllegalArgumentException(String.format("key URI must start with %s", new Object[]{str}));
    }

    public static void validateCryptoKeyUri(String str) throws GeneralSecurityException {
        if (GCP_KMS_CRYPTO_KEY_PATTERN.matcher(str).matches()) {
            return;
        }
        if (GCP_KMS_CRYPTO_KEY_VERSION_PATTERN.matcher(str).matches()) {
            throw new GeneralSecurityException("Invalid Google Cloud KMS Key URI. The URI must point to a CryptoKey, not a CryptoKeyVersion");
        }
        throw new GeneralSecurityException("Invalid Google Cloud KMS Key URI. The URI must point to a CryptoKey in the format projects/*/locations/*/keyRings/*/cryptoKeys/*. See https://cloud.google.com/kms/docs/reference/rest/v1/projects.locations.keyRings.cryptoKeys#CryptoKey");
    }
}
