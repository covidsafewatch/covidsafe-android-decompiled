package com.google.crypto.tink.signature;

import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.proto.EcdsaPublicKey;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.EcdsaVerifyJce;
import com.google.crypto.tink.subtle.EllipticCurves;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;

class EcdsaVerifyKeyManager extends KeyTypeManager<EcdsaPublicKey> {
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.EcdsaPublicKey";
    }

    public int getVersion() {
        return 0;
    }

    public EcdsaVerifyKeyManager() {
        super(EcdsaPublicKey.class, new KeyTypeManager.PrimitiveFactory<PublicKeyVerify, EcdsaPublicKey>(PublicKeyVerify.class) {
            public PublicKeyVerify getPrimitive(EcdsaPublicKey ecdsaPublicKey) throws GeneralSecurityException {
                return new EcdsaVerifyJce(EllipticCurves.getEcPublicKey(SigUtil.toCurveType(ecdsaPublicKey.getParams().getCurve()), ecdsaPublicKey.getX().toByteArray(), ecdsaPublicKey.getY().toByteArray()), SigUtil.toHashType(ecdsaPublicKey.getParams().getHashType()), SigUtil.toEcdsaEncoding(ecdsaPublicKey.getParams().getEncoding()));
            }
        });
    }

    public KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC;
    }

    public EcdsaPublicKey parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return EcdsaPublicKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    public void validateKey(EcdsaPublicKey ecdsaPublicKey) throws GeneralSecurityException {
        Validators.validateVersion(ecdsaPublicKey.getVersion(), getVersion());
        SigUtil.validateEcdsaParams(ecdsaPublicKey.getParams());
    }
}
