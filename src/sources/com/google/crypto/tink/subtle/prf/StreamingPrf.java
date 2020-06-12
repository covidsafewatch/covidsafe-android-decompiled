package com.google.crypto.tink.subtle.prf;

import com.google.errorprone.annotations.Immutable;
import java.io.InputStream;

@Immutable
public interface StreamingPrf {
    InputStream computePrf(byte[] bArr);
}
