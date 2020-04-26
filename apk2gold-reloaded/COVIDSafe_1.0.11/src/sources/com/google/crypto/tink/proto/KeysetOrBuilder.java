package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.Keyset.Key;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface KeysetOrBuilder extends MessageLiteOrBuilder {
    Key getKey(int i);

    int getKeyCount();

    List<Key> getKeyList();

    int getPrimaryKeyId();
}
