package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.HybridEncrypt;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.proto.EciesAeadHkdfParams;
import com.google.crypto.tink.proto.EciesAeadHkdfPublicKey;
import com.google.crypto.tink.proto.EciesHkdfKemParams;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.subtle.EciesAeadHkdfHybridEncrypt;
import com.google.crypto.tink.subtle.EllipticCurves;
import com.google.crypto.tink.subtle.Validators;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import java.security.GeneralSecurityException;

class EciesAeadHkdfPublicKeyManager implements KeyManager<HybridEncrypt> {
    public static final String TYPE_URL = "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey";
    private static final int VERSION = 0;

    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey";
    }

    public int getVersion() {
        return 0;
    }

    EciesAeadHkdfPublicKeyManager() {
    }

    public HybridEncrypt getPrimitive(ByteString byteString) throws GeneralSecurityException {
        try {
            return getPrimitive((MessageLite) EciesAeadHkdfPublicKey.parseFrom(byteString));
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("expected serialized EciesAeadHkdfPublicKey proto", e);
        }
    }

    public HybridEncrypt getPrimitive(MessageLite messageLite) throws GeneralSecurityException {
        if (messageLite instanceof EciesAeadHkdfPublicKey) {
            EciesAeadHkdfPublicKey eciesAeadHkdfPublicKey = (EciesAeadHkdfPublicKey) messageLite;
            validate(eciesAeadHkdfPublicKey);
            EciesAeadHkdfParams params = eciesAeadHkdfPublicKey.getParams();
            EciesHkdfKemParams kemParams = params.getKemParams();
            return new EciesAeadHkdfHybridEncrypt(EllipticCurves.getEcPublicKey(HybridUtil.toCurveType(kemParams.getCurveType()), eciesAeadHkdfPublicKey.getX().toByteArray(), eciesAeadHkdfPublicKey.getY().toByteArray()), kemParams.getHkdfSalt().toByteArray(), HybridUtil.toHmacAlgo(kemParams.getHkdfHashType()), HybridUtil.toPointFormatType(params.getEcPointFormat()), new RegistryEciesAeadHkdfDemHelper(params.getDemParams().getAeadDem()));
        }
        throw new GeneralSecurityException("expected EciesAeadHkdfPublicKey proto");
    }

    public MessageLite newKey(ByteString byteString) throws GeneralSecurityException {
        throw new GeneralSecurityException("Not implemented.");
    }

    public MessageLite newKey(MessageLite messageLite) throws GeneralSecurityException {
        throw new GeneralSecurityException("Not implemented.");
    }

    public KeyData newKeyData(ByteString byteString) throws GeneralSecurityException {
        throw new GeneralSecurityException("Not implemented.");
    }

    public boolean doesSupport(String str) {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey".equals(str);
    }

    private void validate(EciesAeadHkdfPublicKey eciesAeadHkdfPublicKey) throws GeneralSecurityException {
        Validators.validateVersion(eciesAeadHkdfPublicKey.getVersion(), 0);
        HybridUtil.validate(eciesAeadHkdfPublicKey.getParams());
    }
}
