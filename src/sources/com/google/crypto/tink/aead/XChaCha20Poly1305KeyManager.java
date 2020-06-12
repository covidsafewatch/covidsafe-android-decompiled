package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.XChaCha20Poly1305Key;
import com.google.crypto.tink.proto.XChaCha20Poly1305KeyFormat;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import com.google.crypto.tink.subtle.XChaCha20Poly1305;
import java.security.GeneralSecurityException;

public class XChaCha20Poly1305KeyManager extends KeyTypeManager<XChaCha20Poly1305Key> {
    private static final int KEY_SIZE_IN_BYTES = 32;

    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key";
    }

    public int getVersion() {
        return 0;
    }

    XChaCha20Poly1305KeyManager() {
        super(XChaCha20Poly1305Key.class, new KeyTypeManager.PrimitiveFactory<Aead, XChaCha20Poly1305Key>(Aead.class) {
            public Aead getPrimitive(XChaCha20Poly1305Key xChaCha20Poly1305Key) throws GeneralSecurityException {
                return new XChaCha20Poly1305(xChaCha20Poly1305Key.getKeyValue().toByteArray());
            }
        });
    }

    public KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }

    public void validateKey(XChaCha20Poly1305Key xChaCha20Poly1305Key) throws GeneralSecurityException {
        Validators.validateVersion(xChaCha20Poly1305Key.getVersion(), getVersion());
        if (xChaCha20Poly1305Key.getKeyValue().size() != 32) {
            throw new GeneralSecurityException("invalid XChaCha20Poly1305Key: incorrect key length");
        }
    }

    public XChaCha20Poly1305Key parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return XChaCha20Poly1305Key.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    public KeyTypeManager.KeyFactory<XChaCha20Poly1305KeyFormat, XChaCha20Poly1305Key> keyFactory() {
        return new KeyTypeManager.KeyFactory<XChaCha20Poly1305KeyFormat, XChaCha20Poly1305Key>(XChaCha20Poly1305KeyFormat.class) {
            public void validateKeyFormat(XChaCha20Poly1305KeyFormat xChaCha20Poly1305KeyFormat) throws GeneralSecurityException {
            }

            public XChaCha20Poly1305KeyFormat parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return XChaCha20Poly1305KeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            public XChaCha20Poly1305Key createKey(XChaCha20Poly1305KeyFormat xChaCha20Poly1305KeyFormat) throws GeneralSecurityException {
                return (XChaCha20Poly1305Key) XChaCha20Poly1305Key.newBuilder().setVersion(XChaCha20Poly1305KeyManager.this.getVersion()).setKeyValue(ByteString.copyFrom(Random.randBytes(32))).build();
            }
        };
    }

    public static void register(boolean z) throws GeneralSecurityException {
        Registry.registerKeyManager(new XChaCha20Poly1305KeyManager(), z);
    }

    public static final KeyTemplate xChaCha20Poly1305Template() {
        return KeyTemplate.create(new XChaCha20Poly1305KeyManager().getKeyType(), XChaCha20Poly1305KeyFormat.getDefaultInstance().toByteArray(), KeyTemplate.OutputPrefixType.TINK);
    }

    public static final KeyTemplate rawXChaCha20Poly1305Template() {
        return KeyTemplate.create(new XChaCha20Poly1305KeyManager().getKeyType(), XChaCha20Poly1305KeyFormat.getDefaultInstance().toByteArray(), KeyTemplate.OutputPrefixType.RAW);
    }
}
