package com.google.crypto.tink.proto;

import com.google.protobuf.MessageLiteOrBuilder;

public interface AesCtrHmacStreamingKeyFormatOrBuilder extends MessageLiteOrBuilder {
    int getKeySize();

    AesCtrHmacStreamingParams getParams();

    boolean hasParams();
}
