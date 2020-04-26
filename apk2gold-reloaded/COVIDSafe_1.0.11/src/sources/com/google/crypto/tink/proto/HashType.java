package com.google.crypto.tink.proto;

import com.google.protobuf.Internal.EnumLite;
import com.google.protobuf.Internal.EnumLiteMap;

public enum HashType implements EnumLite {
    UNKNOWN_HASH(0),
    SHA1(1),
    SHA256(3),
    SHA512(4),
    UNRECOGNIZED(-1);
    
    public static final int SHA1_VALUE = 1;
    public static final int SHA256_VALUE = 3;
    public static final int SHA512_VALUE = 4;
    public static final int UNKNOWN_HASH_VALUE = 0;
    private static final EnumLiteMap<HashType> internalValueMap = null;
    private final int value;

    static {
        internalValueMap = new EnumLiteMap<HashType>() {
            public HashType findValueByNumber(int i) {
                return HashType.forNumber(i);
            }
        };
    }

    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static HashType valueOf(int i) {
        return forNumber(i);
    }

    public static HashType forNumber(int i) {
        if (i == 0) {
            return UNKNOWN_HASH;
        }
        if (i == 1) {
            return SHA1;
        }
        if (i == 3) {
            return SHA256;
        }
        if (i != 4) {
            return null;
        }
        return SHA512;
    }

    public static EnumLiteMap<HashType> internalGetValueMap() {
        return internalValueMap;
    }

    private HashType(int i) {
        this.value = i;
    }
}
