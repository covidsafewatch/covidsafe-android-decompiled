package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

public interface AesGcmKeyOrBuilder extends MessageLiteOrBuilder {
    ByteString getKeyValue();

    int getVersion();
}
