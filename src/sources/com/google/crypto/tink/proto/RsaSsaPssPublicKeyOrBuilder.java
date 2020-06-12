package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

public interface RsaSsaPssPublicKeyOrBuilder extends MessageLiteOrBuilder {
    ByteString getE();

    ByteString getN();

    RsaSsaPssParams getParams();

    int getVersion();

    boolean hasParams();
}
