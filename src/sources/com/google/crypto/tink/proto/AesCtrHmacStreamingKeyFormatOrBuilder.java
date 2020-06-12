package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

public interface AesCtrHmacStreamingKeyFormatOrBuilder extends MessageLiteOrBuilder {
    int getKeySize();

    AesCtrHmacStreamingParams getParams();

    boolean hasParams();
}
