package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

public interface RsaSsaPkcs1PublicKeyOrBuilder extends MessageLiteOrBuilder {
    ByteString getE();

    ByteString getN();

    RsaSsaPkcs1Params getParams();

    int getVersion();

    boolean hasParams();
}
