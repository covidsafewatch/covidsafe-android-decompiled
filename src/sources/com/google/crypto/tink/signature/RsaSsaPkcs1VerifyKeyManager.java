package com.google.crypto.tink.signature;

import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.RsaSsaPkcs1PublicKey;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.EngineFactory;
import com.google.crypto.tink.subtle.RsaSsaPkcs1VerifyJce;
import com.google.crypto.tink.subtle.Validators;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;

class RsaSsaPkcs1VerifyKeyManager extends KeyTypeManager<RsaSsaPkcs1PublicKey> {
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.RsaSsaPkcs1PublicKey";
    }

    public int getVersion() {
        return 0;
    }

    public RsaSsaPkcs1VerifyKeyManager() {
        super(RsaSsaPkcs1PublicKey.class, new KeyTypeManager.PrimitiveFactory<PublicKeyVerify, RsaSsaPkcs1PublicKey>(PublicKeyVerify.class) {
            public PublicKeyVerify getPrimitive(RsaSsaPkcs1PublicKey rsaSsaPkcs1PublicKey) throws GeneralSecurityException {
                return new RsaSsaPkcs1VerifyJce((RSAPublicKey) EngineFactory.KEY_FACTORY.getInstance("RSA").generatePublic(new RSAPublicKeySpec(new BigInteger(1, rsaSsaPkcs1PublicKey.getN().toByteArray()), new BigInteger(1, rsaSsaPkcs1PublicKey.getE().toByteArray()))), SigUtil.toHashType(rsaSsaPkcs1PublicKey.getParams().getHashType()));
            }
        });
    }

    public KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC;
    }

    public RsaSsaPkcs1PublicKey parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return RsaSsaPkcs1PublicKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    public void validateKey(RsaSsaPkcs1PublicKey rsaSsaPkcs1PublicKey) throws GeneralSecurityException {
        Validators.validateVersion(rsaSsaPkcs1PublicKey.getVersion(), getVersion());
        Validators.validateRsaModulusSize(new BigInteger(1, rsaSsaPkcs1PublicKey.getN().toByteArray()).bitLength());
        SigUtil.validateRsaSsaPkcs1Params(rsaSsaPkcs1PublicKey.getParams());
    }
}
