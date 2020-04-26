package androidx.security.crypto;

import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyGenParameterSpec.Builder;
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
        return new Builder(str, 3).setBlockModes(new String[]{"GCM"}).setEncryptionPaddings(new String[]{"NoPadding"}).setKeySize(256).build();
    }

    public static String getOrCreate(KeyGenParameterSpec keyGenParameterSpec) throws GeneralSecurityException, IOException {
        validate(keyGenParameterSpec);
        if (!keyExists(keyGenParameterSpec.getKeystoreAlias())) {
            generateKey(keyGenParameterSpec);
        }
        return keyGenParameterSpec.getKeystoreAlias();
    }

    private static void validate(KeyGenParameterSpec keyGenParameterSpec) {
        if (keyGenParameterSpec.getKeySize() != 256) {
            StringBuilder sb = new StringBuilder();
            sb.append("invalid key size, want 256 bits got ");
            sb.append(keyGenParameterSpec.getKeySize());
            sb.append(" bits");
            throw new IllegalArgumentException(sb.toString());
        } else if (keyGenParameterSpec.getBlockModes().equals(new String[]{"GCM"})) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("invalid block mode, want GCM got ");
            sb2.append(Arrays.toString(keyGenParameterSpec.getBlockModes()));
            throw new IllegalArgumentException(sb2.toString());
        } else if (keyGenParameterSpec.getPurposes() != 3) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("invalid purposes mode, want PURPOSE_ENCRYPT | PURPOSE_DECRYPT got ");
            sb3.append(keyGenParameterSpec.getPurposes());
            throw new IllegalArgumentException(sb3.toString());
        } else if (keyGenParameterSpec.getEncryptionPaddings().equals(new String[]{"NoPadding"})) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("invalid padding mode, want NoPadding got ");
            sb4.append(Arrays.toString(keyGenParameterSpec.getEncryptionPaddings()));
            throw new IllegalArgumentException(sb4.toString());
        }
    }

    private static void generateKey(KeyGenParameterSpec keyGenParameterSpec) throws GeneralSecurityException {
        KeyGenerator instance = KeyGenerator.getInstance("AES", ANDROID_KEYSTORE);
        instance.init(keyGenParameterSpec);
        instance.generateKey();
    }

    private static boolean keyExists(String str) throws GeneralSecurityException, IOException {
        KeyStore instance = KeyStore.getInstance(ANDROID_KEYSTORE);
        instance.load(null);
        return instance.containsAlias(str);
    }
}
