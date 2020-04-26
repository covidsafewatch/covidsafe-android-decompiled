package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.AesCtrHmacAeadKey;
import com.google.crypto.tink.proto.AesCtrHmacAeadKeyFormat;
import com.google.crypto.tink.proto.AesCtrKey;
import com.google.crypto.tink.proto.AesGcmKey;
import com.google.crypto.tink.proto.AesGcmKey.Builder;
import com.google.crypto.tink.proto.AesGcmKeyFormat;
import com.google.crypto.tink.proto.HmacKey;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.subtle.EciesAeadHkdfDemHelper;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
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
        if (typeUrl.equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            try {
                AesGcmKeyFormat parseFrom = AesGcmKeyFormat.parseFrom(keyTemplate.getValue());
                this.aesGcmKey = (AesGcmKey) Registry.newKey(keyTemplate);
                this.symmetricKeySize = parseFrom.getKeySize();
            } catch (InvalidProtocolBufferException e) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e);
            }
        } else if (this.demKeyTypeUrl.equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            try {
                AesCtrHmacAeadKeyFormat parseFrom2 = AesCtrHmacAeadKeyFormat.parseFrom(keyTemplate.getValue());
                this.aesCtrHmacAeadKey = (AesCtrHmacAeadKey) Registry.newKey(keyTemplate);
                this.aesCtrKeySize = parseFrom2.getAesCtrKeyFormat().getKeySize();
                this.symmetricKeySize = this.aesCtrKeySize + parseFrom2.getHmacKeyFormat().getKeySize();
            } catch (InvalidProtocolBufferException e2) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e2);
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("unsupported AEAD DEM key type: ");
            sb.append(this.demKeyTypeUrl);
            throw new GeneralSecurityException(sb.toString());
        }
    }

    public int getSymmetricKeySizeInBytes() {
        return this.symmetricKeySize;
    }

    public Aead getAead(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length != getSymmetricKeySizeInBytes()) {
            throw new GeneralSecurityException("Symmetric key has incorrect length");
        } else if (this.demKeyTypeUrl.equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            return (Aead) Registry.getPrimitive(this.demKeyTypeUrl, (MessageLite) (AesGcmKey) ((Builder) AesGcmKey.newBuilder().mergeFrom(this.aesGcmKey)).setKeyValue(ByteString.copyFrom(bArr, 0, this.symmetricKeySize)).build());
        } else if (this.demKeyTypeUrl.equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, this.aesCtrKeySize);
            HmacKey hmacKey = (HmacKey) ((HmacKey.Builder) HmacKey.newBuilder().mergeFrom(this.aesCtrHmacAeadKey.getHmacKey())).setKeyValue(ByteString.copyFrom(Arrays.copyOfRange(bArr, this.aesCtrKeySize, this.symmetricKeySize))).build();
            return (Aead) Registry.getPrimitive(this.demKeyTypeUrl, (MessageLite) (AesCtrHmacAeadKey) AesCtrHmacAeadKey.newBuilder().setVersion(this.aesCtrHmacAeadKey.getVersion()).setAesCtrKey((AesCtrKey) ((AesCtrKey.Builder) AesCtrKey.newBuilder().mergeFrom(this.aesCtrHmacAeadKey.getAesCtrKey())).setKeyValue(ByteString.copyFrom(copyOfRange)).build()).setHmacKey(hmacKey).build());
        } else {
            throw new GeneralSecurityException("unknown DEM key type");
        }
    }
}
