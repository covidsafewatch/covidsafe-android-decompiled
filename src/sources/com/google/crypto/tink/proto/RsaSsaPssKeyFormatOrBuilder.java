package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

public interface RsaSsaPssKeyFormatOrBuilder extends MessageLiteOrBuilder {
    int getModulusSizeInBits();

    RsaSsaPssParams getParams();

    ByteString getPublicExponent();

    boolean hasParams();
}
