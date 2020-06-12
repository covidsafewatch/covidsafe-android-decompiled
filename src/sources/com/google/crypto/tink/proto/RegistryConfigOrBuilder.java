package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;
import java.util.List;

@Deprecated
public interface RegistryConfigOrBuilder extends MessageLiteOrBuilder {
    String getConfigName();

    ByteString getConfigNameBytes();

    KeyTypeEntry getEntry(int i);

    int getEntryCount();

    List<KeyTypeEntry> getEntryList();
}
