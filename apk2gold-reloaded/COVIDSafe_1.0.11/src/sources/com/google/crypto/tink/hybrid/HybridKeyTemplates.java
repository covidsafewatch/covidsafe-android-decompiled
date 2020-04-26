package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.aead.AeadKeyTemplates;
import com.google.crypto.tink.proto.EcPointFormat;
import com.google.crypto.tink.proto.EciesAeadDemParams;
import com.google.crypto.tink.proto.EciesAeadHkdfKeyFormat;
import com.google.crypto.tink.proto.EciesAeadHkdfParams;
import com.google.crypto.tink.proto.EciesHkdfKemParams;
import com.google.crypto.tink.proto.EllipticCurveType;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.protobuf.ByteString;

public final class HybridKeyTemplates {
    public static final KeyTemplate ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256 = createEciesAeadHkdfKeyTemplate(EllipticCurveType.NIST_P256, HashType.SHA256, EcPointFormat.UNCOMPRESSED, AeadKeyTemplates.AES128_CTR_HMAC_SHA256, EMPTY_SALT);
    public static final KeyTemplate ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM = createEciesAeadHkdfKeyTemplate(EllipticCurveType.NIST_P256, HashType.SHA256, EcPointFormat.UNCOMPRESSED, AeadKeyTemplates.AES128_GCM, EMPTY_SALT);
    private static final byte[] EMPTY_SALT = new byte[0];

    public static KeyTemplate createEciesAeadHkdfKeyTemplate(EllipticCurveType ellipticCurveType, HashType hashType, EcPointFormat ecPointFormat, KeyTemplate keyTemplate, byte[] bArr) {
        return (KeyTemplate) KeyTemplate.newBuilder().setTypeUrl("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey").setOutputPrefixType(OutputPrefixType.TINK).setValue(((EciesAeadHkdfKeyFormat) EciesAeadHkdfKeyFormat.newBuilder().setParams(createEciesAeadHkdfParams(ellipticCurveType, hashType, ecPointFormat, keyTemplate, bArr)).build()).toByteString()).build();
    }

    public static EciesAeadHkdfParams createEciesAeadHkdfParams(EllipticCurveType ellipticCurveType, HashType hashType, EcPointFormat ecPointFormat, KeyTemplate keyTemplate, byte[] bArr) {
        EciesHkdfKemParams eciesHkdfKemParams = (EciesHkdfKemParams) EciesHkdfKemParams.newBuilder().setCurveType(ellipticCurveType).setHkdfHashType(hashType).setHkdfSalt(ByteString.copyFrom(bArr)).build();
        return (EciesAeadHkdfParams) EciesAeadHkdfParams.newBuilder().setKemParams(eciesHkdfKemParams).setDemParams((EciesAeadDemParams) EciesAeadDemParams.newBuilder().setAeadDem(keyTemplate).build()).setEcPointFormat(ecPointFormat).build();
    }
}
