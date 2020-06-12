package com.google.crypto.tink.prf;

import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.Map;

@Immutable
public abstract class PrfSet {
    public abstract Map<Integer, Prf> getPrfs() throws GeneralSecurityException;

    public abstract int getPrimaryId();

    public byte[] computePrimary(byte[] bArr, int i) throws GeneralSecurityException {
        return getPrfs().get(Integer.valueOf(getPrimaryId())).compute(bArr, i);
    }
}
