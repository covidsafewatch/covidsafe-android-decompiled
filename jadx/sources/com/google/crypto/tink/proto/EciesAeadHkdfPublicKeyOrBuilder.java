package com.google.crypto.tink.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface EciesAeadHkdfPublicKeyOrBuilder extends MessageLiteOrBuilder {
    EciesAeadHkdfParams getParams();

    int getVersion();

    ByteString getX();

    ByteString getY();

    boolean hasParams();
}
