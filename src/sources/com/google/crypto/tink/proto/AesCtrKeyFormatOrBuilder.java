package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

public interface AesCtrKeyFormatOrBuilder extends MessageLiteOrBuilder {
    int getKeySize();

    AesCtrParams getParams();

    boolean hasParams();
}
