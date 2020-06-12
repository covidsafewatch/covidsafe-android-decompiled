package com.google.crypto.tink.integration.android;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KmsClient;
import com.google.crypto.tink.subtle.Validators;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import javax.crypto.KeyGenerator;

public final class AndroidKeystoreKmsClient implements KmsClient {
    public static final String PREFIX = "android-keystore://";
    private String keyUri;

    public AndroidKeystoreKmsClient() throws GeneralSecurityException {
        if (!isAtLeastM()) {
            throw new GeneralSecurityException("needs Android Keystore on Android M or newer");
        }
    }

    public AndroidKeystoreKmsClient(String str) {
        if (str.toLowerCase().startsWith(PREFIX)) {
            this.keyUri = str;
            return;
        }
        throw new IllegalArgumentException("key URI must starts with android-keystore://");
    }

    public boolean doesSupport(String str) {
        String str2 = this.keyUri;
        if (str2 != null && str2.equals(str)) {
            return true;
        }
        if (this.keyUri != null || !str.toLowerCase().startsWith(PREFIX)) {
            return false;
        }
        return true;
    }

    public KmsClient withCredentials(String str) throws GeneralSecurityException {
        return new AndroidKeystoreKmsClient();
    }

    public KmsClient withDefaultCredentials() throws GeneralSecurityException {
        return new AndroidKeystoreKmsClient();
    }

    private boolean isAtLeastM() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public Aead getAead(String str) throws GeneralSecurityException {
        String str2 = this.keyUri;
        if (str2 == null || str2.equals(str)) {
            try {
                return new AndroidKeystoreAesGcm(Validators.validateKmsKeyUriAndRemovePrefix(PREFIX, str));
            } catch (IOException e) {
                throw new GeneralSecurityException(e);
            }
        } else {
            throw new GeneralSecurityException(String.format("this client is bound to %s, cannot load keys bound to %s", new Object[]{this.keyUri, str}));
        }
    }

    public static Aead getOrGenerateNewAeadKey(String str) throws GeneralSecurityException, IOException {
        String validateKmsKeyUriAndRemovePrefix = Validators.validateKmsKeyUriAndRemovePrefix(PREFIX, str);
        KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
        instance.load((KeyStore.LoadStoreParameter) null);
        if (!instance.containsAlias(validateKmsKeyUriAndRemovePrefix)) {
            generateNewAeadKey(str);
        }
        return new AndroidKeystoreKmsClient().getAead(str);
    }

    public static void generateNewAeadKey(String str) throws GeneralSecurityException {
        String validateKmsKeyUriAndRemovePrefix = Validators.validateKmsKeyUriAndRemovePrefix(PREFIX, str);
        KeyGenerator instance = KeyGenerator.getInstance("AES", "AndroidKeyStore");
        instance.init(new KeyGenParameterSpec.Builder(validateKmsKeyUriAndRemovePrefix, 3).setKeySize(256).setBlockModes(new String[]{"GCM"}).setEncryptionPaddings(new String[]{"NoPadding"}).build());
        instance.generateKey();
    }

    static void delete(String str) throws GeneralSecurityException, IOException {
        String validateKmsKeyUriAndRemovePrefix = Validators.validateKmsKeyUriAndRemovePrefix(PREFIX, str);
        KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
        instance.load((KeyStore.LoadStoreParameter) null);
        instance.deleteEntry(validateKmsKeyUriAndRemovePrefix);
    }
}
