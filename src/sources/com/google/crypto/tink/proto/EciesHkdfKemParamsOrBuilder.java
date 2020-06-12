package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

public interface EciesHkdfKemParamsOrBuilder extends MessageLiteOrBuilder {
    EllipticCurveType getCurveType();

    int getCurveTypeValue();

    HashType getHkdfHashType();

    int getHkdfHashTypeValue();

    ByteString getHkdfSalt();
}
