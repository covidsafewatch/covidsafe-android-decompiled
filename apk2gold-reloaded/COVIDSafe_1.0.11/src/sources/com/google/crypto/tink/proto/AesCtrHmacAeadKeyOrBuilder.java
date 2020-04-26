package com.google.crypto.tink.proto;

import com.google.protobuf.MessageLiteOrBuilder;

public interface AesCtrHmacAeadKeyOrBuilder extends MessageLiteOrBuilder {
    AesCtrKey getAesCtrKey();

    HmacKey getHmacKey();

    int getVersion();

    boolean hasAesCtrKey();

    boolean hasHmacKey();
}
