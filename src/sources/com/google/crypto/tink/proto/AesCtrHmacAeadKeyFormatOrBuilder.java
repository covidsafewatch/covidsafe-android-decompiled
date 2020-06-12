package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

public interface AesCtrHmacAeadKeyFormatOrBuilder extends MessageLiteOrBuilder {
    AesCtrKeyFormat getAesCtrKeyFormat();

    HmacKeyFormat getHmacKeyFormat();

    boolean hasAesCtrKeyFormat();

    boolean hasHmacKeyFormat();
}
