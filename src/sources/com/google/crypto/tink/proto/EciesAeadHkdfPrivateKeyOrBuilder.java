package com.google.crypto.tink.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface EciesAeadHkdfPrivateKeyOrBuilder extends MessageLiteOrBuilder {
    ByteString getKeyValue();

    EciesAeadHkdfPublicKey getPublicKey();

    int getVersion();

    boolean hasPublicKey();
}
