package com.google.crypto.tink.signature;

import com.google.crypto.tink.PrivateKeyManager;
import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.proto.EcdsaKeyFormat;
import com.google.crypto.tink.proto.EcdsaParams;
import com.google.crypto.tink.proto.EcdsaPrivateKey;
import com.google.crypto.tink.proto.EcdsaPublicKey;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.subtle.EcdsaSignJce;
import com.google.crypto.tink.subtle.EllipticCurves;
import com.google.crypto.tink.subtle.Validators;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;

class EcdsaSignKeyManager implements PrivateKeyManager<PublicKeySign> {
    public static final String TYPE_URL = "type.googleapis.com/google.crypto.tink.EcdsaPrivateKey";
    private static final int VERSION = 0;

    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.EcdsaPrivateKey";
    }

    public int getVersion() {
        return 0;
    }

    EcdsaSignKeyManager() {
    }

    public PublicKeySign getPrimitive(ByteString byteString) throws GeneralSecurityException {
        try {
            return getPrimitive((MessageLite) EcdsaPrivateKey.parseFrom(byteString));
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("expected serialized EcdsaPrivateKey proto", e);
        }
    }

    public PublicKeySign getPrimitive(MessageLite messageLite) throws GeneralSecurityException {
        if (messageLite instanceof EcdsaPrivateKey) {
            EcdsaPrivateKey ecdsaPrivateKey = (EcdsaPrivateKey) messageLite;
            validateKey(ecdsaPrivateKey);
            return new EcdsaSignJce(EllipticCurves.getEcPrivateKey(SigUtil.toCurveType(ecdsaPrivateKey.getPublicKey().getParams().getCurve()), ecdsaPrivateKey.getKeyValue().toByteArray()), SigUtil.toHashType(ecdsaPrivateKey.getPublicKey().getParams().getHashType()), SigUtil.toEcdsaEncoding(ecdsaPrivateKey.getPublicKey().getParams().getEncoding()));
        }
        throw new GeneralSecurityException("expected EcdsaPrivateKey proto");
    }

    public MessageLite newKey(ByteString byteString) throws GeneralSecurityException {
        try {
            return newKey((MessageLite) EcdsaKeyFormat.parseFrom(byteString));
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("expected EcdsaKeyFormat proto", e);
        }
    }

    public MessageLite newKey(MessageLite messageLite) throws GeneralSecurityException {
        if (messageLite instanceof EcdsaKeyFormat) {
            EcdsaParams params = ((EcdsaKeyFormat) messageLite).getParams();
            SigUtil.validateEcdsaParams(params);
            KeyPair generateKeyPair = EllipticCurves.generateKeyPair(SigUtil.toCurveType(params.getCurve()));
            ECPoint w = ((ECPublicKey) generateKeyPair.getPublic()).getW();
            return EcdsaPrivateKey.newBuilder().setVersion(0).setPublicKey((EcdsaPublicKey) EcdsaPublicKey.newBuilder().setVersion(0).setParams(params).setX(ByteString.copyFrom(w.getAffineX().toByteArray())).setY(ByteString.copyFrom(w.getAffineY().toByteArray())).build()).setKeyValue(ByteString.copyFrom(((ECPrivateKey) generateKeyPair.getPrivate()).getS().toByteArray())).build();
        }
        throw new GeneralSecurityException("expected EcdsaKeyFormat proto");
    }

    public KeyData newKeyData(ByteString byteString) throws GeneralSecurityException {
        return (KeyData) KeyData.newBuilder().setTypeUrl("type.googleapis.com/google.crypto.tink.EcdsaPrivateKey").setValue(((EcdsaPrivateKey) newKey(byteString)).toByteString()).setKeyMaterialType(KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE).build();
    }

    public KeyData getPublicKeyData(ByteString byteString) throws GeneralSecurityException {
        try {
            return (KeyData) KeyData.newBuilder().setTypeUrl("type.googleapis.com/google.crypto.tink.EcdsaPublicKey").setValue(EcdsaPrivateKey.parseFrom(byteString).getPublicKey().toByteString()).setKeyMaterialType(KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC).build();
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("expected serialized EcdsaPrivateKey proto", e);
        }
    }

    public boolean doesSupport(String str) {
        return "type.googleapis.com/google.crypto.tink.EcdsaPrivateKey".equals(str);
    }

    private void validateKey(EcdsaPrivateKey ecdsaPrivateKey) throws GeneralSecurityException {
        Validators.validateVersion(ecdsaPrivateKey.getVersion(), 0);
        SigUtil.validateEcdsaParams(ecdsaPrivateKey.getPublicKey().getParams());
    }
}
