package com.google.crypto.tink.proto;

import com.google.protobuf.MessageLiteOrBuilder;

public interface EcdsaKeyFormatOrBuilder extends MessageLiteOrBuilder {
    EcdsaParams getParams();

    boolean hasParams();
}
