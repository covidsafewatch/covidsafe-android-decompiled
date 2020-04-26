package com.google.crypto.tink.proto;

import com.google.protobuf.MessageLiteOrBuilder;

public interface AesGcmHkdfStreamingParamsOrBuilder extends MessageLiteOrBuilder {
    int getCiphertextSegmentSize();

    int getDerivedKeySize();

    HashType getHkdfHashType();

    int getHkdfHashTypeValue();
}
