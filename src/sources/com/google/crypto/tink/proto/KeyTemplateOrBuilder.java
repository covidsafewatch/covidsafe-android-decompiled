package com.google.crypto.tink.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface KeyTemplateOrBuilder extends MessageLiteOrBuilder {
    OutputPrefixType getOutputPrefixType();

    int getOutputPrefixTypeValue();

    String getTypeUrl();

    ByteString getTypeUrlBytes();

    ByteString getValue();
}
