package com.google.crypto.tink.proto;

import com.google.protobuf.MessageLiteOrBuilder;

public interface HmacParamsOrBuilder extends MessageLiteOrBuilder {
    HashType getHash();

    int getHashValue();

    int getTagSize();
}
