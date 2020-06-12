package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

public interface KeyDataOrBuilder extends MessageLiteOrBuilder {
    KeyData.KeyMaterialType getKeyMaterialType();

    int getKeyMaterialTypeValue();

    String getTypeUrl();

    ByteString getTypeUrlBytes();

    ByteString getValue();
}
