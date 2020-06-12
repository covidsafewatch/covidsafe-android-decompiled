package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

public interface EcdsaKeyFormatOrBuilder extends MessageLiteOrBuilder {
    EcdsaParams getParams();

    boolean hasParams();
}
