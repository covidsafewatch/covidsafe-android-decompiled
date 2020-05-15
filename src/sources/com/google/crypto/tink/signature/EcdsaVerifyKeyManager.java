package com.google.crypto.tink.signature;

import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.proto.EcdsaPublicKey;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.subtle.EcdsaVerifyJce;
import com.google.crypto.tink.subtle.EllipticCurves;
import com.google.crypto.tink.subtle.Validators;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import java.security.GeneralSecurityException;

class EcdsaVerifyKeyManager implements KeyManager<PublicKeyVerify> {
    public static final String TYPE_URL = "type.googleapis.com/google.crypto.tink.EcdsaPublicKey";
    private static final int VERSION = 0;

    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.EcdsaPublicKey";
    }

    public int getVersion() {
        return 0;
    }

    EcdsaVerifyKeyManager() {
    }

    public PublicKeyVerify getPrimitive(ByteString byteString) throws GeneralSecurityException {
        try {
            return getPrimitive((MessageLite) EcdsaPublicKey.parseFrom(byteString));
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("expected serialized EcdsaPublicKey proto", e);
        }
    }

    public PublicKeyVerify getPrimitive(MessageLite messageLite) throws GeneralSecurityException {
        if (messageLite instanceof EcdsaPublicKey) {
            EcdsaPublicKey ecdsaPublicKey = (EcdsaPublicKey) messageLite;
            validate(ecdsaPublicKey);
            return new EcdsaVerifyJce(EllipticCurves.getEcPublicKey(SigUtil.toCurveType(ecdsaPublicKey.getParams().getCurve()), ecdsaPublicKey.getX().toByteArray(), ecdsaPublicKey.getY().toByteArray()), SigUtil.toHashType(ecdsaPublicKey.getParams().getHashType()), SigUtil.toEcdsaEncoding(ecdsaPublicKey.getParams().getEncoding()));
        }
        throw new GeneralSecurityException("expected EcdsaPublicKey proto");
    }

    public MessageLite newKey(ByteString byteString) throws GeneralSecurityException {
        throw new GeneralSecurityException("Not implemented");
    }

    public MessageLite newKey(MessageLite messageLite) throws GeneralSecurityException {
        throw new GeneralSecurityException("Not implemented");
    }

    public KeyData newKeyData(ByteString byteString) throws GeneralSecurityException {
        throw new GeneralSecurityException("Not implemented");
    }

    public boolean doesSupport(String str) {
        return "type.googleapis.com/google.crypto.tink.EcdsaPublicKey".equals(str);
    }

    private void validate(EcdsaPublicKey ecdsaPublicKey) throws GeneralSecurityException {
        Validators.validateVersion(ecdsaPublicKey.getVersion(), 0);
        SigUtil.validateEcdsaParams(ecdsaPublicKey.getParams());
    }
}
