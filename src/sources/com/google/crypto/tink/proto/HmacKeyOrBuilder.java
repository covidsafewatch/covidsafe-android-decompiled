package com.google.crypto.tink.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface HmacKeyOrBuilder extends MessageLiteOrBuilder {
    ByteString getKeyValue();

    HmacParams getParams();

    int getVersion();

    boolean hasParams();
}
