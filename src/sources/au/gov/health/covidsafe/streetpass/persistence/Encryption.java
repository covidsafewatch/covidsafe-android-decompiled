package au.gov.health.covidsafe.streetpass.persistence;

import android.util.Base64;
import au.gov.health.covidsafe.BuildConfig;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u000e\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0006J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\u0002J\b\u0010\"\u001a\u00020\u0019H\u0002J\b\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lau/gov/health/covidsafe/streetpass/persistence/Encryption;", "", "()V", "KEY_GEN_TIME_DELTA", "", "NONCE_PADDING", "", "TAG", "", "cachedAesKey", "Ljavax/crypto/SecretKey;", "cachedEphPubKey", "cachedMacKey", "counter", "keyGenTime", "", "serverPubKey", "Ljava/security/PublicKey;", "computeMAC", "key", "data", "counterBytes", "doKeyAgreement", "Ljavax/crypto/KeyAgreement;", "kp", "Ljava/security/KeyPair;", "encryptPayload", "encryptionKeys", "Lau/gov/health/covidsafe/streetpass/persistence/EncryptionKeys;", "generateKeys", "", "getPublicKey", "hash", "content", "makeECKeys", "makeSymCipher", "Ljavax/crypto/Cipher;", "readKey", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: Encryption.kt */
public final class Encryption {
    public static final Encryption INSTANCE;
    public static final int KEY_GEN_TIME_DELTA = 450000;
    private static final byte[] NONCE_PADDING;
    private static final String TAG;
    private static SecretKey cachedAesKey;
    private static byte[] cachedEphPubKey;
    private static SecretKey cachedMacKey;
    private static int counter;
    private static long keyGenTime = Long.MIN_VALUE;
    private static final PublicKey serverPubKey;

    private final byte[] counterBytes(int i) {
        return new byte[]{(byte) ((65280 & i) >> 8), (byte) (i & 255)};
    }

    static {
        Encryption encryption = new Encryption();
        INSTANCE = encryption;
        String simpleName = encryption.getClass().getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "this.javaClass.simpleName");
        TAG = simpleName;
        byte[] bArr = new byte[14];
        for (int i = 0; i < 14; i++) {
            bArr[i] = (byte) 14;
        }
        NONCE_PADDING = bArr;
        serverPubKey = encryption.readKey();
    }

    private Encryption() {
    }

    private final PublicKey readKey() {
        byte[] decode = Base64.decode(BuildConfig.ENCRYPTION_PUBLIC_KEY, 0);
        Intrinsics.checkExpressionValueIsNotNull(decode, "Base64.decode(BuildConfi…BLIC_KEY, Base64.DEFAULT)");
        PublicKey generatePublic = KeyFactory.getInstance("EC").generatePublic(new X509EncodedKeySpec(decode));
        Intrinsics.checkExpressionValueIsNotNull(generatePublic, "KeyFactory.getInstance(\"…).generatePublic(keySpec)");
        return generatePublic;
    }

    private final byte[] hash(byte[] bArr) {
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        Intrinsics.checkExpressionValueIsNotNull(instance, "MessageDigest.getInstance(\"SHA-256\")");
        instance.update(bArr);
        byte[] digest = instance.digest();
        Intrinsics.checkExpressionValueIsNotNull(digest, "hash.digest()");
        return digest;
    }

    private final KeyPair makeECKeys() {
        KeyPairGenerator instance = KeyPairGenerator.getInstance("EC");
        Intrinsics.checkExpressionValueIsNotNull(instance, "KeyPairGenerator.getInstance(\"EC\")");
        instance.initialize(256);
        KeyPair generateKeyPair = instance.generateKeyPair();
        Intrinsics.checkExpressionValueIsNotNull(generateKeyPair, "kpg.generateKeyPair()");
        return generateKeyPair;
    }

    private final byte[] getPublicKey(KeyPair keyPair) {
        PublicKey publicKey = keyPair.getPublic();
        Intrinsics.checkExpressionValueIsNotNull(publicKey, "kp.public");
        if (publicKey instanceof ECPublicKey) {
            ECPublicKey eCPublicKey = (ECPublicKey) publicKey;
            ECPoint w = eCPublicKey.getW();
            Intrinsics.checkExpressionValueIsNotNull(w, "key.w");
            if (Intrinsics.areEqual((Object) w.getAffineX(), (Object) BigInteger.ZERO)) {
                ECPoint w2 = eCPublicKey.getW();
                Intrinsics.checkExpressionValueIsNotNull(w2, "key.w");
                if (Intrinsics.areEqual((Object) w2.getAffineY(), (Object) BigInteger.ZERO)) {
                    return new byte[1];
                }
            }
            ECPoint w3 = eCPublicKey.getW();
            Intrinsics.checkExpressionValueIsNotNull(w3, "key.w");
            byte[] byteArray = w3.getAffineX().toByteArray();
            Intrinsics.checkExpressionValueIsNotNull(byteArray, "key.w.affineX.toByteArray()");
            if (byteArray.length == 33 && byteArray[0] == ((byte) 0)) {
                byteArray = ArraysKt.sliceArray(byteArray, new IntRange(1, 32));
            } else if (byteArray.length >= 33) {
                throw new IllegalStateException("Unexpected x coordinate in ECDH public key");
            } else if (byteArray.length < 32) {
                byteArray = ArraysKt.plus(new byte[(32 - byteArray.length)], byteArray);
            }
            ECPoint w4 = eCPublicKey.getW();
            Intrinsics.checkExpressionValueIsNotNull(w4, "key.w");
            BigInteger affineY = w4.getAffineY();
            Intrinsics.checkExpressionValueIsNotNull(affineY, "key.w.affineY");
            BigInteger valueOf = BigInteger.valueOf((long) 1);
            Intrinsics.checkExpressionValueIsNotNull(valueOf, "BigInteger.valueOf(this.toLong())");
            BigInteger and = affineY.and(valueOf);
            Intrinsics.checkExpressionValueIsNotNull(and, "this.and(other)");
            return ArraysKt.plus(new byte[]{(byte) (and.intValue() | 2)}, byteArray);
        }
        throw new IllegalStateException("Key pair does not contain an ECDH public key");
    }

    private final KeyAgreement doKeyAgreement(KeyPair keyPair) {
        KeyAgreement instance = KeyAgreement.getInstance("ECDH");
        Intrinsics.checkExpressionValueIsNotNull(instance, "KeyAgreement.getInstance(\"ECDH\")");
        instance.init(keyPair.getPrivate());
        instance.doPhase(serverPubKey, true);
        return instance;
    }

    private final byte[] computeMAC(SecretKey secretKey, byte[] bArr) {
        Mac instance = Mac.getInstance("HmacSHA256");
        Intrinsics.checkExpressionValueIsNotNull(instance, "Mac.getInstance(\"HmacSHA256\")");
        instance.init(secretKey);
        byte[] doFinal = instance.doFinal(bArr);
        Intrinsics.checkExpressionValueIsNotNull(doFinal, "mac.doFinal(data)");
        return ArraysKt.sliceArray(doFinal, new IntRange(0, 15));
    }

    private final Cipher makeSymCipher() {
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        Intrinsics.checkExpressionValueIsNotNull(instance, "Cipher.getInstance(\"AES/CBC/PKCS5Padding\")");
        return instance;
    }

    private final void generateKeys() {
        KeyPair makeECKeys = makeECKeys();
        byte[] generateSecret = doKeyAgreement(makeECKeys).generateSecret();
        Intrinsics.checkExpressionValueIsNotNull(generateSecret, "ka.generateSecret()");
        cachedEphPubKey = getPublicKey(makeECKeys);
        byte[] hash = hash(generateSecret);
        cachedAesKey = new SecretKeySpec(ArraysKt.sliceArray(hash, new IntRange(0, 15)), "AES");
        cachedMacKey = new SecretKeySpec(ArraysKt.sliceArray(hash, new IntRange(16, 31)), "HmacSHA256");
    }

    public final String encryptPayload(byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "data");
        EncryptionKeys encryptionKeys = encryptionKeys();
        byte[] plus = ArraysKt.plus(encryptionKeys.getEphPubKey(), encryptionKeys.getNonce());
        IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[16]);
        Cipher makeSymCipher = makeSymCipher();
        makeSymCipher.init(1, encryptionKeys.getAesKey(), ivParameterSpec);
        byte[] doFinal = makeSymCipher.doFinal(ArraysKt.plus(ArraysKt.plus(encryptionKeys.getNonce(), NONCE_PADDING), bArr));
        Intrinsics.checkExpressionValueIsNotNull(doFinal, "symCipher.doFinal(keys.n…ONCE_PADDING).plus(data))");
        byte[] plus2 = ArraysKt.plus(plus, ArraysKt.sliceArray(doFinal, new IntRange(16, doFinal.length - 1)));
        String encodeToString = Base64.encodeToString(ArraysKt.plus(plus2, computeMAC(encryptionKeys.getMacKey(), plus2)), 0);
        Intrinsics.checkExpressionValueIsNotNull(encodeToString, "Base64.encodeToString(bl…lus(mac), Base64.DEFAULT)");
        return encodeToString;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized au.gov.health.covidsafe.streetpass.persistence.EncryptionKeys encryptionKeys() {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = keyGenTime     // Catch:{ all -> 0x004d }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x004d }
            r4 = 450000(0x6ddd0, float:6.30584E-40)
            long r4 = (long) r4     // Catch:{ all -> 0x004d }
            long r2 = r2 - r4
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x001f
            int r0 = counter     // Catch:{ all -> 0x004d }
            r1 = 65535(0xffff, float:9.1834E-41)
            if (r0 < r1) goto L_0x0018
            goto L_0x001f
        L_0x0018:
            int r0 = counter     // Catch:{ all -> 0x004d }
            int r0 = r0 + 1
            counter = r0     // Catch:{ all -> 0x004d }
            goto L_0x002b
        L_0x001f:
            r6.generateKeys()     // Catch:{ all -> 0x004d }
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x004d }
            keyGenTime = r0     // Catch:{ all -> 0x004d }
            r0 = 0
            counter = r0     // Catch:{ all -> 0x004d }
        L_0x002b:
            au.gov.health.covidsafe.streetpass.persistence.EncryptionKeys r0 = new au.gov.health.covidsafe.streetpass.persistence.EncryptionKeys     // Catch:{ all -> 0x004d }
            byte[] r1 = cachedEphPubKey     // Catch:{ all -> 0x004d }
            if (r1 != 0) goto L_0x0034
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x004d }
        L_0x0034:
            javax.crypto.SecretKey r2 = cachedAesKey     // Catch:{ all -> 0x004d }
            if (r2 != 0) goto L_0x003b
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x004d }
        L_0x003b:
            javax.crypto.SecretKey r3 = cachedMacKey     // Catch:{ all -> 0x004d }
            if (r3 != 0) goto L_0x0042
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x004d }
        L_0x0042:
            int r4 = counter     // Catch:{ all -> 0x004d }
            byte[] r4 = r6.counterBytes(r4)     // Catch:{ all -> 0x004d }
            r0.<init>(r1, r2, r3, r4)     // Catch:{ all -> 0x004d }
            monitor-exit(r6)
            return r0
        L_0x004d:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: au.gov.health.covidsafe.streetpass.persistence.Encryption.encryptionKeys():au.gov.health.covidsafe.streetpass.persistence.EncryptionKeys");
    }
}
