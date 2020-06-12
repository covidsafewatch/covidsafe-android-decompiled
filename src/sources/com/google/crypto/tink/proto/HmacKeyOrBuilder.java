package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

public interface HmacKeyOrBuilder extends MessageLiteOrBuilder {
    ByteString getKeyValue();

    HmacParams getParams();

    int getVersion();

    boolean hasParams();
}
