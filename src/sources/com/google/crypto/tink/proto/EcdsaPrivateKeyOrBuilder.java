package com.google.crypto.tink.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface EcdsaPrivateKeyOrBuilder extends MessageLiteOrBuilder {
    ByteString getKeyValue();

    EcdsaPublicKey getPublicKey();

    int getVersion();

    boolean hasPublicKey();
}
