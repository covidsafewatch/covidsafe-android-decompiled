package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

public interface RsaSsaPkcs1ParamsOrBuilder extends MessageLiteOrBuilder {
    HashType getHashType();

    int getHashTypeValue();
}
