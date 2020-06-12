package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

public interface EcdsaPrivateKeyOrBuilder extends MessageLiteOrBuilder {
    ByteString getKeyValue();

    EcdsaPublicKey getPublicKey();

    int getVersion();

    boolean hasPublicKey();
}
