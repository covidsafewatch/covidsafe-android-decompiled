package com.google.crypto.tink.proto;

import com.google.protobuf.MessageLiteOrBuilder;

public interface HmacKeyFormatOrBuilder extends MessageLiteOrBuilder {
    int getKeySize();

    HmacParams getParams();

    boolean hasParams();
}
