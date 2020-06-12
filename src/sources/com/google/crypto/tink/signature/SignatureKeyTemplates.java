package com.google.crypto.tink.signature;

import com.google.crypto.tink.proto.EcdsaKeyFormat;
import com.google.crypto.tink.proto.EcdsaParams;
import com.google.crypto.tink.proto.EcdsaSignatureEncoding;
import com.google.crypto.tink.proto.EllipticCurveType;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.proto.RsaSsaPkcs1KeyFormat;
import com.google.crypto.tink.proto.RsaSsaPkcs1Params;
import com.google.crypto.tink.proto.RsaSsaPssKeyFormat;
import com.google.crypto.tink.proto.RsaSsaPssParams;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import java.math.BigInteger;
import java.security.spec.RSAKeyGenParameterSpec;

@Deprecated
public final class SignatureKeyTemplates {
    public static final KeyTemplate ECDSA_P256 = createEcdsaKeyTemplate(HashType.SHA256, EllipticCurveType.NIST_P256, EcdsaSignatureEncoding.DER, OutputPrefixType.TINK);
    public static final KeyTemplate ECDSA_P256_IEEE_P1363 = createEcdsaKeyTemplate(HashType.SHA256, EllipticCurveType.NIST_P256, EcdsaSignatureEncoding.IEEE_P1363, OutputPrefixType.TINK);
    public static final KeyTemplate ECDSA_P256_IEEE_P1363_WITHOUT_PREFIX = createEcdsaKeyTemplate(HashType.SHA256, EllipticCurveType.NIST_P256, EcdsaSignatureEncoding.IEEE_P1363, OutputPrefixType.RAW);
    public static final KeyTemplate ECDSA_P384 = createEcdsaKeyTemplate(HashType.SHA512, EllipticCurveType.NIST_P384, EcdsaSignatureEncoding.DER, OutputPrefixType.TINK);
    public static final KeyTemplate ECDSA_P384_IEEE_P1363 = createEcdsaKeyTemplate(HashType.SHA512, EllipticCurveType.NIST_P384, EcdsaSignatureEncoding.IEEE_P1363, OutputPrefixType.TINK);
    public static final KeyTemplate ECDSA_P521 = createEcdsaKeyTemplate(HashType.SHA512, EllipticCurveType.NIST_P521, EcdsaSignatureEncoding.DER, OutputPrefixType.TINK);
    public static final KeyTemplate ECDSA_P521_IEEE_P1363 = createEcdsaKeyTemplate(HashType.SHA512, EllipticCurveType.NIST_P521, EcdsaSignatureEncoding.IEEE_P1363, OutputPrefixType.TINK);
    public static final KeyTemplate ED25519 = ((KeyTemplate) KeyTemplate.newBuilder().setTypeUrl(new Ed25519PrivateKeyManager().getKeyType()).setOutputPrefixType(OutputPrefixType.TINK).build());
    public static final KeyTemplate ED25519WithRawOutput = ((KeyTemplate) KeyTemplate.newBuilder().setTypeUrl(new Ed25519PrivateKeyManager().getKeyType()).setOutputPrefixType(OutputPrefixType.RAW).build());
    public static final KeyTemplate RSA_SSA_PKCS1_3072_SHA256_F4 = createRsaSsaPkcs1KeyTemplate(HashType.SHA256, 3072, RSAKeyGenParameterSpec.F4, OutputPrefixType.TINK);
    public static final KeyTemplate RSA_SSA_PKCS1_3072_SHA256_F4_WITHOUT_PREFIX = createRsaSsaPkcs1KeyTemplate(HashType.SHA256, 3072, RSAKeyGenParameterSpec.F4, OutputPrefixType.RAW);
    public static final KeyTemplate RSA_SSA_PKCS1_4096_SHA512_F4 = createRsaSsaPkcs1KeyTemplate(HashType.SHA512, 4096, RSAKeyGenParameterSpec.F4, OutputPrefixType.TINK);
    public static final KeyTemplate RSA_SSA_PSS_3072_SHA256_SHA256_32_F4 = createRsaSsaPssKeyTemplate(HashType.SHA256, HashType.SHA256, 32, 3072, RSAKeyGenParameterSpec.F4);
    public static final KeyTemplate RSA_SSA_PSS_4096_SHA512_SHA512_64_F4 = createRsaSsaPssKeyTemplate(HashType.SHA512, HashType.SHA512, 64, 4096, RSAKeyGenParameterSpec.F4);

    public static KeyTemplate createEcdsaKeyTemplate(HashType hashType, EllipticCurveType ellipticCurveType, EcdsaSignatureEncoding ecdsaSignatureEncoding, OutputPrefixType outputPrefixType) {
        return (KeyTemplate) KeyTemplate.newBuilder().setValue(((EcdsaKeyFormat) EcdsaKeyFormat.newBuilder().setParams((EcdsaParams) EcdsaParams.newBuilder().setHashType(hashType).setCurve(ellipticCurveType).setEncoding(ecdsaSignatureEncoding).build()).build()).toByteString()).setTypeUrl(new EcdsaSignKeyManager().getKeyType()).setOutputPrefixType(outputPrefixType).build();
    }

    public static KeyTemplate createRsaSsaPkcs1KeyTemplate(HashType hashType, int i, BigInteger bigInteger, OutputPrefixType outputPrefixType) {
        return (KeyTemplate) KeyTemplate.newBuilder().setValue(((RsaSsaPkcs1KeyFormat) RsaSsaPkcs1KeyFormat.newBuilder().setParams((RsaSsaPkcs1Params) RsaSsaPkcs1Params.newBuilder().setHashType(hashType).build()).setModulusSizeInBits(i).setPublicExponent(ByteString.copyFrom(bigInteger.toByteArray())).build()).toByteString()).setTypeUrl(new RsaSsaPkcs1SignKeyManager().getKeyType()).setOutputPrefixType(outputPrefixType).build();
    }

    public static KeyTemplate createRsaSsaPssKeyTemplate(HashType hashType, HashType hashType2, int i, int i2, BigInteger bigInteger) {
        return (KeyTemplate) KeyTemplate.newBuilder().setValue(((RsaSsaPssKeyFormat) RsaSsaPssKeyFormat.newBuilder().setParams((RsaSsaPssParams) RsaSsaPssParams.newBuilder().setSigHash(hashType).setMgf1Hash(hashType2).setSaltLength(i).build()).setModulusSizeInBits(i2).setPublicExponent(ByteString.copyFrom(bigInteger.toByteArray())).build()).toByteString()).setTypeUrl(new RsaSsaPssSignKeyManager().getKeyType()).setOutputPrefixType(OutputPrefixType.TINK).build();
    }
}
