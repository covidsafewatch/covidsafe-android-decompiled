package com.google.crypto.tink.proto;

import com.google.protobuf.MessageLiteOrBuilder;

public interface KmsAeadKeyOrBuilder extends MessageLiteOrBuilder {
    KmsAeadKeyFormat getParams();

    int getVersion();

    boolean hasParams();
}
