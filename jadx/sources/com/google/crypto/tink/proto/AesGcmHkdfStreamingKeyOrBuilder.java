package com.google.crypto.tink.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface AesGcmHkdfStreamingKeyOrBuilder extends MessageLiteOrBuilder {
    ByteString getKeyValue();

    AesGcmHkdfStreamingParams getParams();

    int getVersion();

    boolean hasParams();
}
