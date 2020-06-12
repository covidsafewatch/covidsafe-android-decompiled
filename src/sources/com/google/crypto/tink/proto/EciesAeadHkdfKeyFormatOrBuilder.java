package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

public interface EciesAeadHkdfKeyFormatOrBuilder extends MessageLiteOrBuilder {
    EciesAeadHkdfParams getParams();

    boolean hasParams();
}
