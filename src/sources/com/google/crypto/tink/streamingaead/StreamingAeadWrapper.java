package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.StreamingAead;
import java.security.GeneralSecurityException;

public class StreamingAeadWrapper implements PrimitiveWrapper<StreamingAead> {
    StreamingAeadWrapper() {
    }

    public StreamingAead wrap(PrimitiveSet<StreamingAead> primitiveSet) throws GeneralSecurityException {
        return new StreamingAeadHelper(primitiveSet);
    }

    public Class<StreamingAead> getPrimitiveClass() {
        return StreamingAead.class;
    }

    public static void register() throws GeneralSecurityException {
        Registry.registerPrimitiveWrapper(new StreamingAeadWrapper());
    }
}
