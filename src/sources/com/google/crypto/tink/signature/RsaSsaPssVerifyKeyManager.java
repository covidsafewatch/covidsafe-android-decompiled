package com.google.crypto.tink.signature;

import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.RsaSsaPssParams;
import com.google.crypto.tink.proto.RsaSsaPssPublicKey;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.EngineFactory;
import com.google.crypto.tink.subtle.RsaSsaPssVerifyJce;
import com.google.crypto.tink.subtle.Validators;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;

class RsaSsaPssVerifyKeyManager extends KeyTypeManager<RsaSsaPssPublicKey> {
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.RsaSsaPssPublicKey";
    }

    public int getVersion() {
        return 0;
    }

    public RsaSsaPssVerifyKeyManager() {
        super(RsaSsaPssPublicKey.class, new KeyTypeManager.PrimitiveFactory<PublicKeyVerify, RsaSsaPssPublicKey>(PublicKeyVerify.class) {
            public PublicKeyVerify getPrimitive(RsaSsaPssPublicKey rsaSsaPssPublicKey) throws GeneralSecurityException {
                RsaSsaPssParams params = rsaSsaPssPublicKey.getParams();
                return new RsaSsaPssVerifyJce((RSAPublicKey) EngineFactory.KEY_FACTORY.getInstance("RSA").generatePublic(new RSAPublicKeySpec(new BigInteger(1, rsaSsaPssPublicKey.getN().toByteArray()), new BigInteger(1, rsaSsaPssPublicKey.getE().toByteArray()))), SigUtil.toHashType(params.getSigHash()), SigUtil.toHashType(params.getMgf1Hash()), params.getSaltLength());
            }
        });
    }

    public KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC;
    }

    public RsaSsaPssPublicKey parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return RsaSsaPssPublicKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    public void validateKey(RsaSsaPssPublicKey rsaSsaPssPublicKey) throws GeneralSecurityException {
        Validators.validateVersion(rsaSsaPssPublicKey.getVersion(), getVersion());
        Validators.validateRsaModulusSize(new BigInteger(1, rsaSsaPssPublicKey.getN().toByteArray()).bitLength());
        SigUtil.validateRsaSsaPssParams(rsaSsaPssPublicKey.getParams());
    }
}
