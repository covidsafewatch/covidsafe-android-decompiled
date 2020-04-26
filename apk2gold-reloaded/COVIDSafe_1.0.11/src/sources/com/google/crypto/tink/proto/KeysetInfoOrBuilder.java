package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.KeysetInfo.KeyInfo;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface KeysetInfoOrBuilder extends MessageLiteOrBuilder {
    KeyInfo getKeyInfo(int i);

    int getKeyInfoCount();

    List<KeyInfo> getKeyInfoList();

    int getPrimaryKeyId();
}
