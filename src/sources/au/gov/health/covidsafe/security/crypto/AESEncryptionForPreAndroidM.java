package au.gov.health.covidsafe.security.crypto;

import android.content.Context;
import android.security.KeyPairGeneratorSpec;
import android.util.Base64;
import au.gov.health.covidsafe.Preference;
import au.gov.health.covidsafe.TracerApp;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Calendar;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.x500.X500Principal;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0018H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u001c"}, d2 = {"Lau/gov/health/covidsafe/security/crypto/AESEncryptionForPreAndroidM;", "", "()V", "AES_MODE", "", "ANDROID_KEY_STORE", "RSA_KEY_ALIAS", "RSA_MODE", "keyStore", "Ljava/security/KeyStore;", "getKeyStore", "()Ljava/security/KeyStore;", "setKeyStore", "(Ljava/security/KeyStore;)V", "decrypt", "aesEncryptedText", "encrypt", "plainText", "generateAndStoreRSAKeyPairs", "", "generateEncryptAndStoreAESKey", "getAESKeyFromSharedPreferences", "Ljava/security/Key;", "rsaDecrypt", "", "encrypted", "rsaEncrypt", "plainBytes", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: AESEncryptionForPreAndroidM.kt */
public final class AESEncryptionForPreAndroidM {
    private static final String AES_MODE = AES_MODE;
    private static final String ANDROID_KEY_STORE = ANDROID_KEY_STORE;
    public static final AESEncryptionForPreAndroidM INSTANCE;
    private static final String RSA_KEY_ALIAS = RSA_KEY_ALIAS;
    private static final String RSA_MODE = RSA_MODE;
    public static KeyStore keyStore;

    static {
        AESEncryptionForPreAndroidM aESEncryptionForPreAndroidM = new AESEncryptionForPreAndroidM();
        INSTANCE = aESEncryptionForPreAndroidM;
        aESEncryptionForPreAndroidM.generateAndStoreRSAKeyPairs();
        aESEncryptionForPreAndroidM.generateEncryptAndStoreAESKey();
    }

    private AESEncryptionForPreAndroidM() {
    }

    public final KeyStore getKeyStore() {
        KeyStore keyStore2 = keyStore;
        if (keyStore2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("keyStore");
        }
        return keyStore2;
    }

    public final void setKeyStore(KeyStore keyStore2) {
        Intrinsics.checkParameterIsNotNull(keyStore2, "<set-?>");
        keyStore = keyStore2;
    }

    private final void generateAndStoreRSAKeyPairs() {
        KeyStore instance = KeyStore.getInstance(ANDROID_KEY_STORE);
        Intrinsics.checkExpressionValueIsNotNull(instance, "KeyStore.getInstance(ANDROID_KEY_STORE)");
        keyStore = instance;
        if (instance == null) {
            Intrinsics.throwUninitializedPropertyAccessException("keyStore");
        }
        instance.load((KeyStore.LoadStoreParameter) null);
        KeyStore keyStore2 = keyStore;
        if (keyStore2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("keyStore");
        }
        if (!keyStore2.containsAlias(RSA_KEY_ALIAS)) {
            Calendar instance2 = Calendar.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(instance2, "Calendar.getInstance()");
            Calendar instance3 = Calendar.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(instance3, "Calendar.getInstance()");
            instance3.add(1, 1);
            KeyPairGeneratorSpec.Builder alias = new KeyPairGeneratorSpec.Builder(TracerApp.Companion.getAppContext()).setAlias(RSA_KEY_ALIAS);
            KeyPairGeneratorSpec build = alias.setSubject(new X500Principal("CN=" + RSA_KEY_ALIAS)).setSerialNumber(BigInteger.TEN).setStartDate(instance2.getTime()).setEndDate(instance3.getTime()).setKeySize(2048).build();
            Intrinsics.checkExpressionValueIsNotNull(build, "KeyPairGeneratorSpec.Bui…                 .build()");
            KeyPairGenerator instance4 = KeyPairGenerator.getInstance("RSA", ANDROID_KEY_STORE);
            Intrinsics.checkExpressionValueIsNotNull(instance4, "KeyPairGenerator.getInst…D_KEY_STORE\n            )");
            instance4.initialize(build);
            instance4.generateKeyPair();
        }
    }

    private final byte[] rsaEncrypt(byte[] bArr) {
        KeyStore keyStore2 = keyStore;
        if (keyStore2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("keyStore");
        }
        KeyStore.Entry entry = keyStore2.getEntry(RSA_KEY_ALIAS, (KeyStore.ProtectionParameter) null);
        if (entry != null) {
            Cipher instance = Cipher.getInstance(RSA_MODE);
            Intrinsics.checkExpressionValueIsNotNull(instance, "Cipher.getInstance(RSA_MODE)");
            Certificate certificate = ((KeyStore.PrivateKeyEntry) entry).getCertificate();
            Intrinsics.checkExpressionValueIsNotNull(certificate, "privateKeyEntry.certificate");
            instance.init(1, certificate.getPublicKey());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            CipherOutputStream cipherOutputStream = new CipherOutputStream(byteArrayOutputStream, instance);
            cipherOutputStream.write(bArr);
            cipherOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            Intrinsics.checkExpressionValueIsNotNull(byteArray, "outputStream.toByteArray()");
            return byteArray;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.security.KeyStore.PrivateKeyEntry");
    }

    private final byte[] rsaDecrypt(byte[] bArr) {
        KeyStore keyStore2 = keyStore;
        if (keyStore2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("keyStore");
        }
        KeyStore.Entry entry = keyStore2.getEntry(RSA_KEY_ALIAS, (KeyStore.ProtectionParameter) null);
        if (entry != null) {
            Cipher instance = Cipher.getInstance(RSA_MODE);
            instance.init(2, ((KeyStore.PrivateKeyEntry) entry).getPrivateKey());
            CipherInputStream cipherInputStream = new CipherInputStream(new ByteArrayInputStream(bArr), instance);
            ArrayList arrayList = new ArrayList();
            Ref.IntRef intRef = new Ref.IntRef();
            while (true) {
                int read = cipherInputStream.read();
                intRef.element = read;
                if (read == -1) {
                    break;
                }
                arrayList.add(Byte.valueOf((byte) intRef.element));
            }
            int size = arrayList.size();
            byte[] bArr2 = new byte[size];
            for (int i = 0; i < size; i++) {
                Object obj = arrayList.get(i);
                Intrinsics.checkExpressionValueIsNotNull(obj, "values[i]");
                bArr2[i] = ((Number) obj).byteValue();
            }
            return bArr2;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.security.KeyStore.PrivateKeyEntry");
    }

    private final void generateEncryptAndStoreAESKey() {
        if (Preference.INSTANCE.getEncodedRSAEncryptedAESKey(TracerApp.Companion.getAppContext()) == null) {
            SecureRandom secureRandom = new SecureRandom();
            byte[] bArr = new byte[16];
            secureRandom.nextBytes(bArr);
            byte[] bArr2 = new byte[16];
            secureRandom.nextBytes(bArr2);
            Preference preference = Preference.INSTANCE;
            Context appContext = TracerApp.Companion.getAppContext();
            String encodeToString = Base64.encodeToString(bArr2, 0);
            Intrinsics.checkExpressionValueIsNotNull(encodeToString, "Base64.encodeToString(\n …ULT\n                    )");
            preference.putEncodedAESInitialisationVector(appContext, encodeToString);
            String encodeToString2 = Base64.encodeToString(rsaEncrypt(bArr), 0);
            Preference preference2 = Preference.INSTANCE;
            Context appContext2 = TracerApp.Companion.getAppContext();
            Intrinsics.checkExpressionValueIsNotNull(encodeToString2, "encodedRSAEncryptedAESKey");
            preference2.putEncodedRSAEncryptedAESKey(appContext2, encodeToString2);
        }
    }

    private final Key getAESKeyFromSharedPreferences() {
        String encodedRSAEncryptedAESKey = Preference.INSTANCE.getEncodedRSAEncryptedAESKey(TracerApp.Companion.getAppContext());
        if (encodedRSAEncryptedAESKey != null) {
            byte[] decode = Base64.decode(encodedRSAEncryptedAESKey, 0);
            AESEncryptionForPreAndroidM aESEncryptionForPreAndroidM = INSTANCE;
            Intrinsics.checkExpressionValueIsNotNull(decode, "rsaEncryptedAESKey");
            return new SecretKeySpec(aESEncryptionForPreAndroidM.rsaDecrypt(decode), "AES");
        }
        throw new IllegalStateException("Encrypted AES Key not available in shared preferences.");
    }

    public final String encrypt(String str) {
        Intrinsics.checkParameterIsNotNull(str, "plainText");
        String encodedAESInitialisationVector = Preference.INSTANCE.getEncodedAESInitialisationVector(TracerApp.Companion.getAppContext());
        if (encodedAESInitialisationVector != null) {
            byte[] decode = Base64.decode(encodedAESInitialisationVector, 0);
            Cipher instance = Cipher.getInstance(AES_MODE);
            instance.init(1, INSTANCE.getAESKeyFromSharedPreferences(), new IvParameterSpec(decode));
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
            String encodeToString = Base64.encodeToString(instance.doFinal(bytes), 0);
            Intrinsics.checkExpressionValueIsNotNull(encodeToString, "Base64.encodeToString(en…dedBytes, Base64.DEFAULT)");
            return encodeToString;
        }
        throw new IllegalStateException("AES IV not available in shared preferences.");
    }

    public final String decrypt(String str) {
        Intrinsics.checkParameterIsNotNull(str, "aesEncryptedText");
        String encodedAESInitialisationVector = Preference.INSTANCE.getEncodedAESInitialisationVector(TracerApp.Companion.getAppContext());
        if (encodedAESInitialisationVector != null) {
            byte[] decode = Base64.decode(encodedAESInitialisationVector, 0);
            byte[] decode2 = Base64.decode(str, 0);
            Cipher instance = Cipher.getInstance(AES_MODE);
            instance.init(2, INSTANCE.getAESKeyFromSharedPreferences(), new IvParameterSpec(decode));
            byte[] doFinal = instance.doFinal(decode2);
            Intrinsics.checkExpressionValueIsNotNull(doFinal, "cipher.doFinal(encryptedBytes)");
            return new String(doFinal, Charsets.UTF_8);
        }
        throw new IllegalStateException("AES IV not available in shared preferences.");
    }
}
