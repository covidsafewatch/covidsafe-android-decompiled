package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

public interface HmacParamsOrBuilder extends MessageLiteOrBuilder {
    HashType getHash();

    int getHashValue();

    int getTagSize();
}
