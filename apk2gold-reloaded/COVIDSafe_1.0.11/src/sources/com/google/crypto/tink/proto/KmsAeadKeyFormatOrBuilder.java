package com.google.crypto.tink.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface KmsAeadKeyFormatOrBuilder extends MessageLiteOrBuilder {
    String getKeyUri();

    ByteString getKeyUriBytes();
}
