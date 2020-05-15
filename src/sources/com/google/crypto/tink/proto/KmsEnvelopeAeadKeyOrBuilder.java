package com.google.crypto.tink.proto;

import com.google.protobuf.MessageLiteOrBuilder;

public interface KmsEnvelopeAeadKeyOrBuilder extends MessageLiteOrBuilder {
    KmsEnvelopeAeadKeyFormat getParams();

    int getVersion();

    boolean hasParams();
}
