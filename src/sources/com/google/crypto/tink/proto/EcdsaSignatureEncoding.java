package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

public enum EcdsaSignatureEncoding implements Internal.EnumLite {
    UNKNOWN_ENCODING(0),
    IEEE_P1363(1),
    DER(2),
    UNRECOGNIZED(-1);
    
    public static final int DER_VALUE = 2;
    public static final int IEEE_P1363_VALUE = 1;
    public static final int UNKNOWN_ENCODING_VALUE = 0;
    private static final Internal.EnumLiteMap<EcdsaSignatureEncoding> internalValueMap = null;
    private final int value;

    static {
        internalValueMap = new Internal.EnumLiteMap<EcdsaSignatureEncoding>() {
            public EcdsaSignatureEncoding findValueByNumber(int i) {
                return EcdsaSignatureEncoding.forNumber(i);
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
    public static EcdsaSignatureEncoding valueOf(int i) {
        return forNumber(i);
    }

    public static EcdsaSignatureEncoding forNumber(int i) {
        if (i == 0) {
            return UNKNOWN_ENCODING;
        }
        if (i == 1) {
            return IEEE_P1363;
        }
        if (i != 2) {
            return null;
        }
        return DER;
    }

    public static Internal.EnumLiteMap<EcdsaSignatureEncoding> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return EcdsaSignatureEncodingVerifier.INSTANCE;
    }

    private static final class EcdsaSignatureEncodingVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = null;

        private EcdsaSignatureEncodingVerifier() {
        }

        static {
            INSTANCE = new EcdsaSignatureEncodingVerifier();
        }

        public boolean isInRange(int i) {
            return EcdsaSignatureEncoding.forNumber(i) != null;
        }
    }

    private EcdsaSignatureEncoding(int i) {
        this.value = i;
    }
}
