package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.aead.AeadConfig;
import com.google.crypto.tink.proto.AesCtrHmacAeadKey;
import com.google.crypto.tink.proto.AesCtrHmacAeadKeyFormat;
import com.google.crypto.tink.proto.AesCtrKey;
import com.google.crypto.tink.proto.AesGcmKey;
import com.google.crypto.tink.proto.AesGcmKeyFormat;
import com.google.crypto.tink.proto.HmacKey;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.subtle.EciesAeadHkdfDemHelper;
import java.security.GeneralSecurityException;
import java.util.Arrays;

class RegistryEciesAeadHkdfDemHelper implements EciesAeadHkdfDemHelper {
    private AesCtrHmacAeadKey aesCtrHmacAeadKey;
    private int aesCtrKeySize;
    private AesGcmKey aesGcmKey;
    private final String demKeyTypeUrl;
    private final int symmetricKeySize;

    RegistryEciesAeadHkdfDemHelper(KeyTemplate keyTemplate) throws GeneralSecurityException {
        String typeUrl = keyTemplate.getTypeUrl();
        this.demKeyTypeUrl = typeUrl;
        if (typeUrl.equals(AeadConfig.AES_GCM_TYPE_URL)) {
            try {
                AesGcmKeyFormat parseFrom = AesGcmKeyFormat.parseFrom(keyTemplate.getValue(), ExtensionRegistryLite.getEmptyRegistry());
                this.aesGcmKey = (AesGcmKey) Registry.newKey(keyTemplate);
                this.symmetricKeySize = parseFrom.getKeySize();
            } catch (InvalidProtocolBufferException e) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e);
            }
        } else if (this.demKeyTypeUrl.equals(AeadConfig.AES_CTR_HMAC_AEAD_TYPE_URL)) {
            try {
                AesCtrHmacAeadKeyFormat parseFrom2 = AesCtrHmacAeadKeyFormat.parseFrom(keyTemplate.getValue(), ExtensionRegistryLite.getEmptyRegistry());
                this.aesCtrHmacAeadKey = (AesCtrHmacAeadKey) Registry.newKey(keyTemplate);
                this.aesCtrKeySize = parseFrom2.getAesCtrKeyFormat().getKeySize();
                this.symmetricKeySize = this.aesCtrKeySize + parseFrom2.getHmacKeyFormat().getKeySize();
            } catch (InvalidProtocolBufferException e2) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e2);
            }
        } else {
            throw new GeneralSecurityException("unsupported AEAD DEM key type: " + this.demKeyTypeUrl);
        }
    }

    public int getSymmetricKeySizeInBytes() {
        return this.symmetricKeySize;
    }

    public Aead getAead(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length != getSymmetricKeySizeInBytes()) {
            throw new GeneralSecurityException("Symmetric key has incorrect length");
        } else if (this.demKeyTypeUrl.equals(AeadConfig.AES_GCM_TYPE_URL)) {
            return (Aead) Registry.getPrimitive(this.demKeyTypeUrl, (MessageLite) (AesGcmKey) ((AesGcmKey.Builder) AesGcmKey.newBuilder().mergeFrom(this.aesGcmKey)).setKeyValue(ByteString.copyFrom(bArr, 0, this.symmetricKeySize)).build(), Aead.class);
        } else if (this.demKeyTypeUrl.equals(AeadConfig.AES_CTR_HMAC_AEAD_TYPE_URL)) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, this.aesCtrKeySize);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, this.aesCtrKeySize, this.symmetricKeySize);
            AesCtrHmacAeadKey.Builder aesCtrKey = AesCtrHmacAeadKey.newBuilder().setVersion(this.aesCtrHmacAeadKey.getVersion()).setAesCtrKey((AesCtrKey) ((AesCtrKey.Builder) AesCtrKey.newBuilder().mergeFrom(this.aesCtrHmacAeadKey.getAesCtrKey())).setKeyValue(ByteString.copyFrom(copyOfRange)).build());
            return (Aead) Registry.getPrimitive(this.demKeyTypeUrl, (MessageLite) (AesCtrHmacAeadKey) aesCtrKey.setHmacKey((HmacKey) ((HmacKey.Builder) HmacKey.newBuilder().mergeFrom(this.aesCtrHmacAeadKey.getHmacKey())).setKeyValue(ByteString.copyFrom(copyOfRange2)).build()).build(), Aead.class);
        } else {
            throw new GeneralSecurityException("unknown DEM key type");
        }
    }
}
