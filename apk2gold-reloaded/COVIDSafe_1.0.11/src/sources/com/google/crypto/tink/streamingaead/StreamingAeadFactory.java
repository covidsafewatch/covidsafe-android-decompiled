package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.PrimitiveSet.Entry;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.StreamingAead;
import java.security.GeneralSecurityException;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Logger;

public final class StreamingAeadFactory {
    private static final Logger logger = Logger.getLogger(StreamingAeadFactory.class.getName());

    public static StreamingAead getPrimitive(KeysetHandle keysetHandle) throws GeneralSecurityException {
        return getPrimitive(keysetHandle, null);
    }

    public static StreamingAead getPrimitive(KeysetHandle keysetHandle, KeyManager<StreamingAead> keyManager) throws GeneralSecurityException {
        PrimitiveSet primitives = Registry.getPrimitives(keysetHandle, keyManager);
        validate(primitives);
        return new StreamingAeadHelper(primitives);
    }

    private static void validate(PrimitiveSet<StreamingAead> primitiveSet) throws GeneralSecurityException {
        for (Collection it : primitiveSet.getAll()) {
            Iterator it2 = it.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (!(((Entry) it2.next()).getPrimitive() instanceof StreamingAead)) {
                        throw new GeneralSecurityException("invalid StreamingAead key material");
                    }
                }
            }
        }
    }
}
