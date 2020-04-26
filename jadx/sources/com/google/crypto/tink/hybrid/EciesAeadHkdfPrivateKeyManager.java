package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.HybridDecrypt;
import com.google.crypto.tink.PrivateKeyManager;
import com.google.crypto.tink.proto.EciesAeadHkdfKeyFormat;
import com.google.crypto.tink.proto.EciesAeadHkdfParams;
import com.google.crypto.tink.proto.EciesAeadHkdfPrivateKey;
import com.google.crypto.tink.proto.EciesAeadHkdfPublicKey;
import com.google.crypto.tink.proto.EciesHkdfKemParams;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.subtle.EciesAeadHkdfHybridDecrypt;
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

class EciesAeadHkdfPrivateKeyManager implements PrivateKeyManager<HybridDecrypt> {
    public static final String TYPE_URL = "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    private static final int VERSION = 0;

    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }

    public int getVersion() {
        return 0;
    }

    EciesAeadHkdfPrivateKeyManager() {
    }

    public HybridDecrypt getPrimitive(ByteString byteString) throws GeneralSecurityException {
        try {
            return getPrimitive((MessageLite) EciesAeadHkdfPrivateKey.parseFrom(byteString));
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("expected serialized EciesAeadHkdfPrivateKey proto", e);
        }
    }

    public HybridDecrypt getPrimitive(MessageLite messageLite) throws GeneralSecurityException {
        if (messageLite instanceof EciesAeadHkdfPrivateKey) {
            EciesAeadHkdfPrivateKey eciesAeadHkdfPrivateKey = (EciesAeadHkdfPrivateKey) messageLite;
            validate(eciesAeadHkdfPrivateKey);
            EciesAeadHkdfParams params = eciesAeadHkdfPrivateKey.getPublicKey().getParams();
            EciesHkdfKemParams kemParams = params.getKemParams();
            return new EciesAeadHkdfHybridDecrypt(EllipticCurves.getEcPrivateKey(HybridUtil.toCurveType(kemParams.getCurveType()), eciesAeadHkdfPrivateKey.getKeyValue().toByteArray()), kemParams.getHkdfSalt().toByteArray(), HybridUtil.toHmacAlgo(kemParams.getHkdfHashType()), HybridUtil.toPointFormatType(params.getEcPointFormat()), new RegistryEciesAeadHkdfDemHelper(params.getDemParams().getAeadDem()));
        }
        throw new GeneralSecurityException("expected EciesAeadHkdfPrivateKey proto");
    }

    public MessageLite newKey(ByteString byteString) throws GeneralSecurityException {
        try {
            return newKey((MessageLite) EciesAeadHkdfKeyFormat.parseFrom(byteString));
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("invalid EciesAeadHkdf key format", e);
        }
    }

    public MessageLite newKey(MessageLite messageLite) throws GeneralSecurityException {
        if (messageLite instanceof EciesAeadHkdfKeyFormat) {
            EciesAeadHkdfKeyFormat eciesAeadHkdfKeyFormat = (EciesAeadHkdfKeyFormat) messageLite;
            HybridUtil.validate(eciesAeadHkdfKeyFormat.getParams());
            KeyPair generateKeyPair = EllipticCurves.generateKeyPair(HybridUtil.toCurveType(eciesAeadHkdfKeyFormat.getParams().getKemParams().getCurveType()));
            ECPoint w = ((ECPublicKey) generateKeyPair.getPublic()).getW();
            return EciesAeadHkdfPrivateKey.newBuilder().setVersion(0).setPublicKey((EciesAeadHkdfPublicKey) EciesAeadHkdfPublicKey.newBuilder().setVersion(0).setParams(eciesAeadHkdfKeyFormat.getParams()).setX(ByteString.copyFrom(w.getAffineX().toByteArray())).setY(ByteString.copyFrom(w.getAffineY().toByteArray())).build()).setKeyValue(ByteString.copyFrom(((ECPrivateKey) generateKeyPair.getPrivate()).getS().toByteArray())).build();
        }
        throw new GeneralSecurityException("expected EciesAeadHkdfKeyFormat proto");
    }

    public KeyData newKeyData(ByteString byteString) throws GeneralSecurityException {
        return (KeyData) KeyData.newBuilder().setTypeUrl("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey").setValue(((EciesAeadHkdfPrivateKey) newKey(byteString)).toByteString()).setKeyMaterialType(KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE).build();
    }

    public KeyData getPublicKeyData(ByteString byteString) throws GeneralSecurityException {
        try {
            return (KeyData) KeyData.newBuilder().setTypeUrl("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey").setValue(EciesAeadHkdfPrivateKey.parseFrom(byteString).getPublicKey().toByteString()).setKeyMaterialType(KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC).build();
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("expected serialized EciesAeadHkdfPrivateKey proto", e);
        }
    }

    public boolean doesSupport(String str) {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey".equals(str);
    }

    private void validate(EciesAeadHkdfPrivateKey eciesAeadHkdfPrivateKey) throws GeneralSecurityException {
        Validators.validateVersion(eciesAeadHkdfPrivateKey.getVersion(), 0);
        HybridUtil.validate(eciesAeadHkdfPrivateKey.getPublicKey().getParams());
    }
}
