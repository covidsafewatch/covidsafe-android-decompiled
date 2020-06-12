package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.HybridEncrypt;
import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.proto.EciesAeadHkdfParams;
import com.google.crypto.tink.proto.EciesAeadHkdfPublicKey;
import com.google.crypto.tink.proto.EciesHkdfKemParams;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.EciesAeadHkdfHybridEncrypt;
import com.google.crypto.tink.subtle.EllipticCurves;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;

class EciesAeadHkdfPublicKeyManager extends KeyTypeManager<EciesAeadHkdfPublicKey> {
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey";
    }

    public int getVersion() {
        return 0;
    }

    public EciesAeadHkdfPublicKeyManager() {
        super(EciesAeadHkdfPublicKey.class, new KeyTypeManager.PrimitiveFactory<HybridEncrypt, EciesAeadHkdfPublicKey>(HybridEncrypt.class) {
            public HybridEncrypt getPrimitive(EciesAeadHkdfPublicKey eciesAeadHkdfPublicKey) throws GeneralSecurityException {
                EciesAeadHkdfParams params = eciesAeadHkdfPublicKey.getParams();
                EciesHkdfKemParams kemParams = params.getKemParams();
                return new EciesAeadHkdfHybridEncrypt(EllipticCurves.getEcPublicKey(HybridUtil.toCurveType(kemParams.getCurveType()), eciesAeadHkdfPublicKey.getX().toByteArray(), eciesAeadHkdfPublicKey.getY().toByteArray()), kemParams.getHkdfSalt().toByteArray(), HybridUtil.toHmacAlgo(kemParams.getHkdfHashType()), HybridUtil.toPointFormatType(params.getEcPointFormat()), new RegistryEciesAeadHkdfDemHelper(params.getDemParams().getAeadDem()));
            }
        });
    }

    public KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC;
    }

    public EciesAeadHkdfPublicKey parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return EciesAeadHkdfPublicKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    public void validateKey(EciesAeadHkdfPublicKey eciesAeadHkdfPublicKey) throws GeneralSecurityException {
        Validators.validateVersion(eciesAeadHkdfPublicKey.getVersion(), getVersion());
        HybridUtil.validate(eciesAeadHkdfPublicKey.getParams());
    }
}
