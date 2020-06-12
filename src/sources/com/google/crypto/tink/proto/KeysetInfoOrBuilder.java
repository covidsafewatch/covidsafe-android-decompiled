package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.KeysetInfo;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface KeysetInfoOrBuilder extends MessageLiteOrBuilder {
    KeysetInfo.KeyInfo getKeyInfo(int i);

    int getKeyInfoCount();

    List<KeysetInfo.KeyInfo> getKeyInfoList();

    int getPrimaryKeyId();
}
