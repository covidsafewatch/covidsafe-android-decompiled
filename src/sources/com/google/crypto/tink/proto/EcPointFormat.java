package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

public enum EcPointFormat implements Internal.EnumLite {
    UNKNOWN_FORMAT(0),
    UNCOMPRESSED(1),
    COMPRESSED(2),
    DO_NOT_USE_CRUNCHY_UNCOMPRESSED(3),
    UNRECOGNIZED(-1);
    
    public static final int COMPRESSED_VALUE = 2;
    public static final int DO_NOT_USE_CRUNCHY_UNCOMPRESSED_VALUE = 3;
    public static final int UNCOMPRESSED_VALUE = 1;
    public static final int UNKNOWN_FORMAT_VALUE = 0;
    private static final Internal.EnumLiteMap<EcPointFormat> internalValueMap = null;
    private final int value;

    static {
        internalValueMap = new Internal.EnumLiteMap<EcPointFormat>() {
            public EcPointFormat findValueByNumber(int i) {
                return EcPointFormat.forNumber(i);
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
    public static EcPointFormat valueOf(int i) {
        return forNumber(i);
    }

    public static EcPointFormat forNumber(int i) {
        if (i == 0) {
            return UNKNOWN_FORMAT;
        }
        if (i == 1) {
            return UNCOMPRESSED;
        }
        if (i == 2) {
            return COMPRESSED;
        }
        if (i != 3) {
            return null;
        }
        return DO_NOT_USE_CRUNCHY_UNCOMPRESSED;
    }

    public static Internal.EnumLiteMap<EcPointFormat> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return EcPointFormatVerifier.INSTANCE;
    }

    private static final class EcPointFormatVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = null;

        private EcPointFormatVerifier() {
        }

        static {
            INSTANCE = new EcPointFormatVerifier();
        }

        public boolean isInRange(int i) {
            return EcPointFormat.forNumber(i) != null;
        }
    }

    private EcPointFormat(int i) {
        this.value = i;
    }
}
