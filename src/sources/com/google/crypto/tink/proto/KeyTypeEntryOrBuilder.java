package com.google.crypto.tink.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface KeyTypeEntryOrBuilder extends MessageLiteOrBuilder {
    String getCatalogueName();

    ByteString getCatalogueNameBytes();

    int getKeyManagerVersion();

    boolean getNewKeyAllowed();

    String getPrimitiveName();

    ByteString getPrimitiveNameBytes();

    String getTypeUrl();

    ByteString getTypeUrlBytes();
}
