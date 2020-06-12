package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

@Deprecated
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
