package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

public interface AesCmacKeyFormatOrBuilder extends MessageLiteOrBuilder {
    int getKeySize();

    AesCmacParams getParams();

    boolean hasParams();
}
