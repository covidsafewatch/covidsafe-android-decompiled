package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

public interface HkdfPrfKeyFormatOrBuilder extends MessageLiteOrBuilder {
    int getKeySize();

    HkdfPrfParams getParams();

    int getVersion();

    boolean hasParams();
}
