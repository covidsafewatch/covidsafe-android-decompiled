package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

public interface KmsAeadKeyOrBuilder extends MessageLiteOrBuilder {
    KmsAeadKeyFormat getParams();

    int getVersion();

    boolean hasParams();
}
