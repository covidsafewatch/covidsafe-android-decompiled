package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

public interface EciesAeadHkdfPrivateKeyOrBuilder extends MessageLiteOrBuilder {
    ByteString getKeyValue();

    EciesAeadHkdfPublicKey getPublicKey();

    int getVersion();

    boolean hasPublicKey();
}
