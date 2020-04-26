package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.proto.ChaCha20Poly1305Key;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.subtle.ChaCha20Poly1305;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import java.security.GeneralSecurityException;

class ChaCha20Poly1305KeyManager implements KeyManager<Aead> {
    private static final int KEY_SIZE_IN_BYTES = 32;
    public static final String TYPE_URL = "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    private static final int VERSION = 0;

    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    }

    public int getVersion() {
        return 0;
    }

    ChaCha20Poly1305KeyManager() {
    }

    public Aead getPrimitive(ByteString byteString) throws GeneralSecurityException {
        try {
            return getPrimitive((MessageLite) ChaCha20Poly1305Key.parseFrom(byteString));
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305 key", e);
        }
    }

    public Aead getPrimitive(MessageLite messageLite) throws GeneralSecurityException {
        if (messageLite instanceof ChaCha20Poly1305Key) {
            ChaCha20Poly1305Key chaCha20Poly1305Key = (ChaCha20Poly1305Key) messageLite;
            validate(chaCha20Poly1305Key);
            return new ChaCha20Poly1305(chaCha20Poly1305Key.getKeyValue().toByteArray());
        }
        throw new GeneralSecurityException("expected ChaCha20Poly1305Key proto");
    }

    public MessageLite newKey(ByteString byteString) throws GeneralSecurityException {
        return newKey();
    }

    public MessageLite newKey(MessageLite messageLite) throws GeneralSecurityException {
        return newKey();
    }

    public KeyData newKeyData(ByteString byteString) throws GeneralSecurityException {
        return (KeyData) KeyData.newBuilder().setTypeUrl("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key").setValue(newKey().toByteString()).setKeyMaterialType(KeyData.KeyMaterialType.SYMMETRIC).build();
    }

    public boolean doesSupport(String str) {
        return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key".equals(str);
    }

    private ChaCha20Poly1305Key newKey() throws GeneralSecurityException {
        return (ChaCha20Poly1305Key) ChaCha20Poly1305Key.newBuilder().setVersion(0).setKeyValue(ByteString.copyFrom(Random.randBytes(32))).build();
    }

    private void validate(ChaCha20Poly1305Key chaCha20Poly1305Key) throws GeneralSecurityException {
        Validators.validateVersion(chaCha20Poly1305Key.getVersion(), 0);
        if (chaCha20Poly1305Key.getKeyValue().size() != 32) {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
        }
    }
}
