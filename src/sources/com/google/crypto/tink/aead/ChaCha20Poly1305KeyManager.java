package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.ChaCha20Poly1305Key;
import com.google.crypto.tink.proto.ChaCha20Poly1305KeyFormat;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.ChaCha20Poly1305;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;

public class ChaCha20Poly1305KeyManager extends KeyTypeManager<ChaCha20Poly1305Key> {
    private static final int KEY_SIZE_IN_BYTES = 32;

    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    }

    public int getVersion() {
        return 0;
    }

    ChaCha20Poly1305KeyManager() {
        super(ChaCha20Poly1305Key.class, new KeyTypeManager.PrimitiveFactory<Aead, ChaCha20Poly1305Key>(Aead.class) {
            public Aead getPrimitive(ChaCha20Poly1305Key chaCha20Poly1305Key) throws GeneralSecurityException {
                return new ChaCha20Poly1305(chaCha20Poly1305Key.getKeyValue().toByteArray());
            }
        });
    }

    public KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }

    public void validateKey(ChaCha20Poly1305Key chaCha20Poly1305Key) throws GeneralSecurityException {
        Validators.validateVersion(chaCha20Poly1305Key.getVersion(), getVersion());
        if (chaCha20Poly1305Key.getKeyValue().size() != 32) {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
        }
    }

    public ChaCha20Poly1305Key parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return ChaCha20Poly1305Key.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    public KeyTypeManager.KeyFactory<ChaCha20Poly1305KeyFormat, ChaCha20Poly1305Key> keyFactory() {
        return new KeyTypeManager.KeyFactory<ChaCha20Poly1305KeyFormat, ChaCha20Poly1305Key>(ChaCha20Poly1305KeyFormat.class) {
            public void validateKeyFormat(ChaCha20Poly1305KeyFormat chaCha20Poly1305KeyFormat) throws GeneralSecurityException {
            }

            public ChaCha20Poly1305KeyFormat parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return ChaCha20Poly1305KeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            public ChaCha20Poly1305Key createKey(ChaCha20Poly1305KeyFormat chaCha20Poly1305KeyFormat) throws GeneralSecurityException {
                return (ChaCha20Poly1305Key) ChaCha20Poly1305Key.newBuilder().setVersion(ChaCha20Poly1305KeyManager.this.getVersion()).setKeyValue(ByteString.copyFrom(Random.randBytes(32))).build();
            }
        };
    }

    public static void register(boolean z) throws GeneralSecurityException {
        Registry.registerKeyManager(new ChaCha20Poly1305KeyManager(), z);
    }

    public static final KeyTemplate chaCha20Poly1305Template() {
        return KeyTemplate.create(new ChaCha20Poly1305KeyManager().getKeyType(), ChaCha20Poly1305KeyFormat.getDefaultInstance().toByteArray(), KeyTemplate.OutputPrefixType.TINK);
    }

    public static final KeyTemplate rawChaCha20Poly1305Template() {
        return KeyTemplate.create(new ChaCha20Poly1305KeyManager().getKeyType(), ChaCha20Poly1305KeyFormat.getDefaultInstance().toByteArray(), KeyTemplate.OutputPrefixType.RAW);
    }
}
