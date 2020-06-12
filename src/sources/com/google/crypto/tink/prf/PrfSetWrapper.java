package com.google.crypto.tink.prf;

import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Immutable
public class PrfSetWrapper implements PrimitiveWrapper<PrfSet> {

    private static class WrappedPrfSet extends PrfSet {
        private final Map<Integer, Prf> keyIdToPrfMap;
        private final int primaryKeyId;

        private WrappedPrfSet(PrimitiveSet<PrfSet> primitiveSet) throws GeneralSecurityException {
            if (primitiveSet.getRawPrimitives().isEmpty()) {
                throw new GeneralSecurityException("No primitives provided.");
            } else if (primitiveSet.getPrimary() != null) {
                this.primaryKeyId = primitiveSet.getPrimary().getKeyId();
                List<PrimitiveSet.Entry<PrfSet>> rawPrimitives = primitiveSet.getRawPrimitives();
                HashMap hashMap = new HashMap();
                for (PrimitiveSet.Entry next : rawPrimitives) {
                    if (!next.getOutputPrefixType().equals(OutputPrefixType.RAW)) {
                        throw new GeneralSecurityException("Key " + next.getKeyId() + " has non raw prefix type");
                    } else if (((PrfSet) next.getPrimitive()).getPrfs().size() <= 1) {
                        hashMap.put(Integer.valueOf(next.getKeyId()), ((PrfSet) next.getPrimitive()).getPrfs().get(Integer.valueOf(((PrfSet) next.getPrimitive()).getPrimaryId())));
                    } else {
                        throw new GeneralSecurityException("More PRFs than expected in KeyTypeManager for key " + next.getKeyId());
                    }
                }
                this.keyIdToPrfMap = Collections.unmodifiableMap(hashMap);
            } else {
                throw new GeneralSecurityException("Primary key not set.");
            }
        }

        public int getPrimaryId() {
            return this.primaryKeyId;
        }

        public Map<Integer, Prf> getPrfs() throws GeneralSecurityException {
            return this.keyIdToPrfMap;
        }
    }

    public PrfSet wrap(PrimitiveSet<PrfSet> primitiveSet) throws GeneralSecurityException {
        return new WrappedPrfSet(primitiveSet);
    }

    public Class<PrfSet> getPrimitiveClass() {
        return PrfSet.class;
    }

    public static void register() throws GeneralSecurityException {
        Registry.registerPrimitiveWrapper(new PrfSetWrapper());
    }
}
