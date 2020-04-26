package com.google.crypto.tink.proto;

import com.google.protobuf.MessageLiteOrBuilder;

public interface AesEaxKeyFormatOrBuilder extends MessageLiteOrBuilder {
    int getKeySize();

    AesEaxParams getParams();

    boolean hasParams();
}
