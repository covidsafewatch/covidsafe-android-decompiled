package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

public interface EciesAeadDemParamsOrBuilder extends MessageLiteOrBuilder {
    KeyTemplate getAeadDem();

    boolean hasAeadDem();
}
