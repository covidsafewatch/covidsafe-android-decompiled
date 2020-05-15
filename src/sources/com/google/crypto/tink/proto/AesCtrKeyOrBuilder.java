package com.google.crypto.tink.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface AesCtrKeyOrBuilder extends MessageLiteOrBuilder {
    ByteString getKeyValue();

    AesCtrParams getParams();

    int getVersion();

    boolean hasParams();
}
