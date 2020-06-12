package com.google.crypto.tink.subtle.prf;

import com.google.crypto.tink.prf.Prf;
import com.google.errorprone.annotations.Immutable;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;

@Immutable
public class PrfImpl implements Prf {
    private final StreamingPrf prfStreamer;

    private PrfImpl(StreamingPrf streamingPrf) {
        this.prfStreamer = streamingPrf;
    }

    public static PrfImpl wrap(StreamingPrf streamingPrf) {
        return new PrfImpl(streamingPrf);
    }

    private static byte[] readBytesFromStream(InputStream inputStream, int i) throws GeneralSecurityException {
        try {
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int read = inputStream.read(bArr, i2, i - i2);
                if (read > 0) {
                    i2 += read;
                } else {
                    throw new GeneralSecurityException("Provided StreamingPrf terminated before providing requested number of bytes.");
                }
            }
            return bArr;
        } catch (IOException e) {
            throw new GeneralSecurityException(e);
        }
    }

    public byte[] compute(byte[] bArr, int i) throws GeneralSecurityException {
        if (bArr == null) {
            throw new GeneralSecurityException("Invalid input provided.");
        } else if (i > 0) {
            return readBytesFromStream(this.prfStreamer.computePrf(bArr), i);
        } else {
            throw new GeneralSecurityException("Invalid outputLength specified.");
        }
    }
}
