package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

public interface AesCmacKeyOrBuilder extends MessageLiteOrBuilder {
    ByteString getKeyValue();

    AesCmacParams getParams();

    int getVersion();

    boolean hasParams();
}
