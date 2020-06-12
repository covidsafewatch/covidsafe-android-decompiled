package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.OutputPrefixType;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class PrimitiveSet<P> {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private Entry<P> primary;
    private final Class<P> primitiveClass;
    private ConcurrentMap<String, List<Entry<P>>> primitives = new ConcurrentHashMap();

    public static final class Entry<P> {
        private final byte[] identifier;
        private final int keyId;
        private final OutputPrefixType outputPrefixType;
        private final P primitive;
        private final KeyStatusType status;

        Entry(P p, byte[] bArr, KeyStatusType keyStatusType, OutputPrefixType outputPrefixType2, int i) {
            this.primitive = p;
            this.identifier = Arrays.copyOf(bArr, bArr.length);
            this.status = keyStatusType;
            this.outputPrefixType = outputPrefixType2;
            this.keyId = i;
        }

        public P getPrimitive() {
            return this.primitive;
        }

        public KeyStatusType getStatus() {
            return this.status;
        }

        public OutputPrefixType getOutputPrefixType() {
            return this.outputPrefixType;
        }

        public final byte[] getIdentifier() {
            byte[] bArr = this.identifier;
            if (bArr == null) {
                return null;
            }
            return Arrays.copyOf(bArr, bArr.length);
        }

        public int getKeyId() {
            return this.keyId;
        }
    }

    public Entry<P> getPrimary() {
        return this.primary;
    }

    public List<Entry<P>> getRawPrimitives() {
        return getPrimitive(CryptoFormat.RAW_PREFIX);
    }

    public List<Entry<P>> getPrimitive(byte[] bArr) {
        List<Entry<P>> list = (List) this.primitives.get(new String(bArr, UTF_8));
        return list != null ? list : Collections.emptyList();
    }

    /* access modifiers changed from: protected */
    public List<Entry<P>> getPrimitive(Keyset.Key key) throws GeneralSecurityException {
        return getPrimitive(CryptoFormat.getOutputPrefix(key));
    }

    public Collection<List<Entry<P>>> getAll() {
        return this.primitives.values();
    }

    private PrimitiveSet(Class<P> cls) {
        this.primitiveClass = cls;
    }

    public static <P> PrimitiveSet<P> newPrimitiveSet(Class<P> cls) {
        return new PrimitiveSet<>(cls);
    }

    public void setPrimary(Entry<P> entry) {
        if (entry == null) {
            throw new IllegalArgumentException("the primary entry must be non-null");
        } else if (entry.getStatus() != KeyStatusType.ENABLED) {
            throw new IllegalArgumentException("the primary entry has to be ENABLED");
        } else if (!getPrimitive(entry.getIdentifier()).isEmpty()) {
            this.primary = entry;
        } else {
            throw new IllegalArgumentException("the primary entry cannot be set to an entry which is not held by this primitive set");
        }
    }

    public Entry<P> addPrimitive(P p, Keyset.Key key) throws GeneralSecurityException {
        if (key.getStatus() == KeyStatusType.ENABLED) {
            Entry entry = new Entry(p, CryptoFormat.getOutputPrefix(key), key.getStatus(), key.getOutputPrefixType(), key.getKeyId());
            ArrayList arrayList = new ArrayList();
            arrayList.add(entry);
            String str = new String(entry.getIdentifier(), UTF_8);
            List list = (List) this.primitives.put(str, Collections.unmodifiableList(arrayList));
            if (list != null) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(list);
                arrayList2.add(entry);
                this.primitives.put(str, Collections.unmodifiableList(arrayList2));
            }
            return entry;
        }
        throw new GeneralSecurityException("only ENABLED key is allowed");
    }

    public Class<P> getPrimitiveClass() {
        return this.primitiveClass;
    }
}
