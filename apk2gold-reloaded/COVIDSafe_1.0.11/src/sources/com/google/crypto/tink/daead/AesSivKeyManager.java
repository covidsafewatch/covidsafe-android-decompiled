package com.google.crypto.tink.daead;

import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.proto.AesSivKey;
import com.google.crypto.tink.proto.AesSivKeyFormat;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyData.KeyMaterialType;
import com.google.crypto.tink.subtle.AesSiv;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;

class AesSivKeyManager implements KeyManager<DeterministicAead> {
    public static final String TYPE_URL = "type.googleapis.com/google.crypto.tink.AesSivKey";
    private static final int VERSION = 0;

    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesSivKey";
    }

    public int getVersion() {
        return 0;
    }

    AesSivKeyManager() {
    }

    public DeterministicAead getPrimitive(ByteString byteString) throws GeneralSecurityException {
        try {
            return getPrimitive((MessageLite) AesSivKey.parseFrom(byteString));
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("expected AesSivKey proto");
        }
    }

    public DeterministicAead getPrimitive(MessageLite messageLite) throws GeneralSecurityException {
        if (messageLite instanceof AesSivKey) {
            AesSivKey aesSivKey = (AesSivKey) messageLite;
            validate(aesSivKey);
            return new AesSiv(aesSivKey.getKeyValue().toByteArray());
        }
        throw new GeneralSecurityException("expected AesSivKey proto");
    }

    public MessageLite newKey(ByteString byteString) throws GeneralSecurityException {
        try {
            return newKey((MessageLite) AesSivKeyFormat.parseFrom(byteString));
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("expected serialized AesSivKeyFormat proto", e);
        }
    }

    public MessageLite newKey(MessageLite messageLite) throws GeneralSecurityException {
        if (messageLite instanceof AesSivKeyFormat) {
            AesSivKeyFormat aesSivKeyFormat = (AesSivKeyFormat) messageLite;
            validate(aesSivKeyFormat);
            return AesSivKey.newBuilder().setKeyValue(ByteString.copyFrom(Random.randBytes(aesSivKeyFormat.getKeySize()))).setVersion(0).build();
        }
        throw new GeneralSecurityException("expected AesSivKeyFormat proto");
    }

    public KeyData newKeyData(ByteString byteString) throws GeneralSecurityException {
        return (KeyData) KeyData.newBuilder().setTypeUrl("type.googleapis.com/google.crypto.tink.AesSivKey").setValue(((AesSivKey) newKey(byteString)).toByteString()).setKeyMaterialType(KeyMaterialType.SYMMETRIC).build();
    }

    public boolean doesSupport(String str) {
        return str.equals("type.googleapis.com/google.crypto.tink.AesSivKey");
    }

    private void validate(AesSivKey aesSivKey) throws GeneralSecurityException {
        Validators.validateVersion(aesSivKey.getVersion(), 0);
        if (aesSivKey.getKeyValue().size() != 64) {
            StringBuilder sb = new StringBuilder();
            sb.append("invalid key size: ");
            sb.append(aesSivKey.getKeyValue().size());
            sb.append(". Valid keys must have 64 bytes.");
            throw new InvalidKeyException(sb.toString());
        }
    }

    private void validate(AesSivKeyFormat aesSivKeyFormat) throws GeneralSecurityException {
        if (aesSivKeyFormat.getKeySize() != 64) {
            StringBuilder sb = new StringBuilder();
            sb.append("invalid key size: ");
            sb.append(aesSivKeyFormat.getKeySize());
            sb.append(". Valid keys must have 64 bytes.");
            throw new InvalidAlgorithmParameterException(sb.toString());
        }
    }
}
