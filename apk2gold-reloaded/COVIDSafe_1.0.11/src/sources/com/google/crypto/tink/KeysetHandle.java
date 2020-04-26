package com.google.crypto.tink;

import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyData.KeyMaterialType;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.Keyset.Builder;
import com.google.crypto.tink.proto.Keyset.Key;
import com.google.crypto.tink.proto.KeysetInfo;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import java.security.GeneralSecurityException;

public final class KeysetHandle {
    private Keyset keyset;

    private KeysetHandle(Keyset keyset2) {
        this.keyset = keyset2;
    }

    static final KeysetHandle fromKeyset(Keyset keyset2) throws GeneralSecurityException {
        assertEnoughKeyMaterial(keyset2);
        return new KeysetHandle(keyset2);
    }

    /* access modifiers changed from: 0000 */
    public Keyset getKeyset() {
        return this.keyset;
    }

    public KeysetInfo getKeysetInfo() {
        return Util.getKeysetInfo(this.keyset);
    }

    public static final KeysetHandle generateNew(KeyTemplate keyTemplate) throws GeneralSecurityException {
        return KeysetManager.withEmptyKeyset().rotate(keyTemplate).getKeysetHandle();
    }

    public static final KeysetHandle read(KeysetReader keysetReader, Aead aead) throws GeneralSecurityException, IOException {
        EncryptedKeyset readEncrypted = keysetReader.readEncrypted();
        assertEnoughEncryptedKeyMaterial(readEncrypted);
        return new KeysetHandle(decrypt(readEncrypted, aead));
    }

    public void write(KeysetWriter keysetWriter, Aead aead) throws GeneralSecurityException, IOException {
        keysetWriter.write(encrypt(this.keyset, aead));
    }

    private static EncryptedKeyset encrypt(Keyset keyset2, Aead aead) throws GeneralSecurityException {
        byte[] encrypt = aead.encrypt(keyset2.toByteArray(), new byte[0]);
        try {
            if (Keyset.parseFrom(aead.decrypt(encrypt, new byte[0])).equals(keyset2)) {
                return (EncryptedKeyset) EncryptedKeyset.newBuilder().setEncryptedKeyset(ByteString.copyFrom(encrypt)).setKeysetInfo(Util.getKeysetInfo(keyset2)).build();
            }
            throw new GeneralSecurityException("cannot encrypt keyset");
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    private static Keyset decrypt(EncryptedKeyset encryptedKeyset, Aead aead) throws GeneralSecurityException {
        try {
            Keyset parseFrom = Keyset.parseFrom(aead.decrypt(encryptedKeyset.getEncryptedKeyset().toByteArray(), new byte[0]));
            assertEnoughKeyMaterial(parseFrom);
            return parseFrom;
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    public KeysetHandle getPublicKeysetHandle() throws GeneralSecurityException {
        if (this.keyset != null) {
            Builder newBuilder = Keyset.newBuilder();
            for (Key key : this.keyset.getKeyList()) {
                newBuilder.addKey((Key) ((Key.Builder) Key.newBuilder().mergeFrom(key)).setKeyData(createPublicKeyData(key.getKeyData())).build());
            }
            newBuilder.setPrimaryKeyId(this.keyset.getPrimaryKeyId());
            return new KeysetHandle((Keyset) newBuilder.build());
        }
        throw new GeneralSecurityException("cleartext keyset is not available");
    }

    private static KeyData createPublicKeyData(KeyData keyData) throws GeneralSecurityException {
        if (keyData.getKeyMaterialType() == KeyMaterialType.ASYMMETRIC_PRIVATE) {
            KeyData publicKeyData = Registry.getPublicKeyData(keyData.getTypeUrl(), keyData.getValue());
            validate(publicKeyData);
            return publicKeyData;
        }
        throw new GeneralSecurityException("The keyset contains a non-private key");
    }

    private static void validate(KeyData keyData) throws GeneralSecurityException {
        Registry.getPrimitive(keyData);
    }

    public String toString() {
        return getKeysetInfo().toString();
    }

    public static void assertEnoughKeyMaterial(Keyset keyset2) throws GeneralSecurityException {
        if (keyset2 == null || keyset2.getKeyCount() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    public static void assertEnoughEncryptedKeyMaterial(EncryptedKeyset encryptedKeyset) throws GeneralSecurityException {
        if (encryptedKeyset == null || encryptedKeyset.getEncryptedKeyset().size() == 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }
}
