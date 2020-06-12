package au.gov.health.covidsafe.security.crypto;

import android.security.keystore.KeyGenParameterSpec;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.Arrays;
import javax.crypto.KeyGenerator;

public final class MasterKeys {
    public static final KeyGenParameterSpec AES256_GCM_SPEC = createAES256GCMKeyGenParameterSpec(MASTER_KEY_ALIAS);
    private static final String ANDROID_KEYSTORE = "AndroidKeyStore";
    static final String KEYSTORE_PATH_URI = "android-keystore://";
    private static final int KEY_SIZE = 256;
    static final String MASTER_KEY_ALIAS = "_androidx_security_master_key_";

    private MasterKeys() {
    }

    private static KeyGenParameterSpec createAES256GCMKeyGenParameterSpec(String str) {
        return new KeyGenParameterSpec.Builder(str, 3).setBlockModes(new String[]{"GCM"}).setEncryptionPaddings(new String[]{"NoPadding"}).setKeySize(256).build();
    }

    public static String getOrCreate(KeyGenParameterSpec keyGenParameterSpec) throws GeneralSecurityException, IOException {
        validate(keyGenParameterSpec);
        if (!keyExists(keyGenParameterSpec.getKeystoreAlias())) {
            generateKey(keyGenParameterSpec);
        }
        return keyGenParameterSpec.getKeystoreAlias();
    }

    static void validate(KeyGenParameterSpec keyGenParameterSpec) {
        if (keyGenParameterSpec.getKeySize() != 256) {
            throw new IllegalArgumentException("invalid key size, want 256 bits got " + keyGenParameterSpec.getKeySize() + " bits");
        } else if (!Arrays.equals(keyGenParameterSpec.getBlockModes(), new String[]{"GCM"})) {
            throw new IllegalArgumentException("invalid block mode, want GCM got " + Arrays.toString(keyGenParameterSpec.getBlockModes()));
        } else if (keyGenParameterSpec.getPurposes() != 3) {
            throw new IllegalArgumentException("invalid purposes mode, want PURPOSE_ENCRYPT | PURPOSE_DECRYPT got " + keyGenParameterSpec.getPurposes());
        } else if (!Arrays.equals(keyGenParameterSpec.getEncryptionPaddings(), new String[]{"NoPadding"})) {
            throw new IllegalArgumentException("invalid padding mode, want NoPadding got " + Arrays.toString(keyGenParameterSpec.getEncryptionPaddings()));
        } else if (keyGenParameterSpec.isUserAuthenticationRequired() && keyGenParameterSpec.getUserAuthenticationValidityDurationSeconds() < 1) {
            throw new IllegalArgumentException("per-operation authentication is not supported (UserAuthenticationValidityDurationSeconds must be >0)");
        }
    }

    private static void generateKey(KeyGenParameterSpec keyGenParameterSpec) throws GeneralSecurityException {
        KeyGenerator instance = KeyGenerator.getInstance("AES", ANDROID_KEYSTORE);
        instance.init(keyGenParameterSpec);
        instance.generateKey();
    }

    private static boolean keyExists(String str) throws GeneralSecurityException, IOException {
        KeyStore instance = KeyStore.getInstance(ANDROID_KEYSTORE);
        instance.load((KeyStore.LoadStoreParameter) null);
        return instance.containsAlias(str);
    }
}
