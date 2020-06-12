package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

public enum EllipticCurveType implements Internal.EnumLite {
    UNKNOWN_CURVE(0),
    NIST_P256(2),
    NIST_P384(3),
    NIST_P521(4),
    CURVE25519(5),
    UNRECOGNIZED(-1);
    
    public static final int CURVE25519_VALUE = 5;
    public static final int NIST_P256_VALUE = 2;
    public static final int NIST_P384_VALUE = 3;
    public static final int NIST_P521_VALUE = 4;
    public static final int UNKNOWN_CURVE_VALUE = 0;
    private static final Internal.EnumLiteMap<EllipticCurveType> internalValueMap = null;
    private final int value;

    static {
        internalValueMap = new Internal.EnumLiteMap<EllipticCurveType>() {
            public EllipticCurveType findValueByNumber(int i) {
                return EllipticCurveType.forNumber(i);
            }
        };
    }

    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
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
        if (i == 4) {
            return NIST_P521;
        }
        if (i != 5) {
            return null;
        }
        return CURVE25519;
    }

    public static Internal.EnumLiteMap<EllipticCurveType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return EllipticCurveTypeVerifier.INSTANCE;
    }

    private static final class EllipticCurveTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = null;

        private EllipticCurveTypeVerifier() {
        }

        static {
            INSTANCE = new EllipticCurveTypeVerifier();
        }

        public boolean isInRange(int i) {
            return EllipticCurveType.forNumber(i) != null;
        }
    }

    private EllipticCurveType(int i) {
        this.value = i;
    }
}
