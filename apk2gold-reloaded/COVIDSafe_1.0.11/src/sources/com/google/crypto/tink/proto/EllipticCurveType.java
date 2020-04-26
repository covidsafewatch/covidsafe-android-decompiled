package com.google.crypto.tink.proto;

import com.google.protobuf.Internal.EnumLite;
import com.google.protobuf.Internal.EnumLiteMap;

public enum EllipticCurveType implements EnumLite {
    UNKNOWN_CURVE(0),
    NIST_P256(2),
    NIST_P384(3),
    NIST_P521(4),
    UNRECOGNIZED(-1);
    
    public static final int NIST_P256_VALUE = 2;
    public static final int NIST_P384_VALUE = 3;
    public static final int NIST_P521_VALUE = 4;
    public static final int UNKNOWN_CURVE_VALUE = 0;
    private static final EnumLiteMap<EllipticCurveType> internalValueMap = null;
    private final int value;

    static {
        internalValueMap = new EnumLiteMap<EllipticCurveType>() {
            public EllipticCurveType findValueByNumber(int i) {
                return EllipticCurveType.forNumber(i);
            }
        };
    }

    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static EllipticCurveType valueOf(int i) {
        return forNumber(i);
    }

    public static EllipticCurveType forNumber(int i) {
        if (i == 0) {
            return UNKNOWN_CURVE;
        }
        if (i == 2) {
            return NIST_P256;
        }
        if (i == 3) {
            return NIST_P384;
        }
        if (i != 4) {
            return null;
        }
        return NIST_P521;
    }

    public static EnumLiteMap<EllipticCurveType> internalGetValueMap() {
        return internalValueMap;
    }

    private EllipticCurveType(int i) {
        this.value = i;
    }
}
