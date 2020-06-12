package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

public interface ChaCha20Poly1305KeyOrBuilder extends MessageLiteOrBuilder {
    ByteString getKeyValue();

    int getVersion();
}
