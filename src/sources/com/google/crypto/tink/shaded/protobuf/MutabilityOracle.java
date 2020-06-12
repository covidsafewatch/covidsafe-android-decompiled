package com.google.crypto.tink.shaded.protobuf;

interface MutabilityOracle {
    public static final MutabilityOracle IMMUTABLE = new MutabilityOracle() {
        public void ensureMutable() {
            throw new UnsupportedOperationException();
        }
    };

    void ensureMutable();
}
