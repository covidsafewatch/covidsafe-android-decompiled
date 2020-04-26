package com.google.crypto.tink.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface Ed25519PrivateKeyOrBuilder extends MessageLiteOrBuilder {
    ByteString getKeyValue();

    Ed25519PublicKey getPublicKey();

    int getVersion();

    boolean hasPublicKey();
}
