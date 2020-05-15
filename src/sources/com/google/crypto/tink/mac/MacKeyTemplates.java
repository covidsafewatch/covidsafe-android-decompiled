package com.google.crypto.tink.mac;

import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.HmacKeyFormat;
import com.google.crypto.tink.proto.HmacParams;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;

public final class MacKeyTemplates {
    public static final KeyTemplate HMAC_SHA256_128BITTAG = createHmacKeyTemplate(32, 16, HashType.SHA256);
    public static final KeyTemplate HMAC_SHA256_256BITTAG = createHmacKeyTemplate(32, 32, HashType.SHA256);

    public static KeyTemplate createHmacKeyTemplate(int i, int i2, HashType hashType) {
        return (KeyTemplate) KeyTemplate.newBuilder().setValue(((HmacKeyFormat) HmacKeyFormat.newBuilder().setParams((HmacParams) HmacParams.newBuilder().setHash(hashType).setTagSize(i2).build()).setKeySize(i).build()).toByteString()).setTypeUrl("type.googleapis.com/google.crypto.tink.HmacKey").setOutputPrefixType(OutputPrefixType.TINK).build();
    }
}
