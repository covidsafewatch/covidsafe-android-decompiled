package com.google.crypto.tink.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface ChaCha20Poly1305KeyOrBuilder extends MessageLiteOrBuilder {
    ByteString getKeyValue();

    int getVersion();
}
