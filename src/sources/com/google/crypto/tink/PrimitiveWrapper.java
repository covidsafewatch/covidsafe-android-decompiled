package com.google.crypto.tink;

import java.security.GeneralSecurityException;

public interface PrimitiveWrapper<P> {
    Class<P> getPrimitiveClass();

    P wrap(PrimitiveSet<P> primitiveSet) throws GeneralSecurityException;
}
