package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class KeyTypeManager<KeyProtoT extends MessageLite> {
    private final Class<KeyProtoT> clazz;
    private final Map<Class<?>, PrimitiveFactory<?, KeyProtoT>> factories;
    private final Class<?> firstPrimitiveClass;

    public abstract String getKeyType();

    public abstract int getVersion();

    public abstract KeyData.KeyMaterialType keyMaterialType();

    public abstract KeyProtoT parseKey(ByteString byteString) throws InvalidProtocolBufferException;

    public abstract void validateKey(KeyProtoT keyprotot) throws GeneralSecurityException;

    protected static abstract class PrimitiveFactory<PrimitiveT, KeyT> {
        private final Class<PrimitiveT> clazz;

        public abstract PrimitiveT getPrimitive(KeyT keyt) throws GeneralSecurityException;

        public PrimitiveFactory(Class<PrimitiveT> cls) {
            this.clazz = cls;
        }

        /* access modifiers changed from: package-private */
        public final Class<PrimitiveT> getPrimitiveClass() {
            return this.clazz;
        }
    }

    @SafeVarargs
    protected KeyTypeManager(Class<KeyProtoT> cls, PrimitiveFactory<?, KeyProtoT>... primitiveFactoryArr) {
        this.clazz = cls;
        HashMap hashMap = new HashMap();
        int length = primitiveFactoryArr.length;
        int i = 0;
        while (i < length) {
            PrimitiveFactory<?, KeyProtoT> primitiveFactory = primitiveFactoryArr[i];
            if (!hashMap.containsKey(primitiveFactory.getPrimitiveClass())) {
                hashMap.put(primitiveFactory.getPrimitiveClass(), primitiveFactory);
                i++;
            } else {
                throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + primitiveFactory.getPrimitiveClass().getCanonicalName());
            }
        }
        if (primitiveFactoryArr.length > 0) {
            this.firstPrimitiveClass = primitiveFactoryArr[0].getPrimitiveClass();
        } else {
            this.firstPrimitiveClass = Void.class;
        }
        this.factories = Collections.unmodifiableMap(hashMap);
    }

    public final Class<KeyProtoT> getKeyClass() {
        return this.clazz;
    }

    public final <P> P getPrimitive(KeyProtoT keyprotot, Class<P> cls) throws GeneralSecurityException {
        PrimitiveFactory primitiveFactory = this.factories.get(cls);
        if (primitiveFactory != null) {
            return primitiveFactory.getPrimitive(keyprotot);
        }
        throw new IllegalArgumentException("Requested primitive class " + cls.getCanonicalName() + " not supported.");
    }

    public final Set<Class<?>> supportedPrimitives() {
        return this.factories.keySet();
    }

    /* access modifiers changed from: package-private */
    public final Class<?> firstSupportedPrimitiveClass() {
        return this.firstPrimitiveClass;
    }

    public static abstract class KeyFactory<KeyFormatProtoT extends MessageLite, KeyT> {
        private final Class<KeyFormatProtoT> clazz;

        public abstract KeyT createKey(KeyFormatProtoT keyformatprotot) throws GeneralSecurityException;

        public abstract KeyFormatProtoT parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException;

        public abstract void validateKeyFormat(KeyFormatProtoT keyformatprotot) throws GeneralSecurityException;

        public KeyFactory(Class<KeyFormatProtoT> cls) {
            this.clazz = cls;
        }

        public final Class<KeyFormatProtoT> getKeyFormatClass() {
            return this.clazz;
        }

        public KeyT deriveKey(KeyFormatProtoT keyformatprotot, InputStream inputStream) throws GeneralSecurityException {
            throw new GeneralSecurityException("deriveKey not implemented for key of type " + this.clazz.toString());
        }
    }

    public KeyFactory<?, KeyProtoT> keyFactory() {
        throw new UnsupportedOperationException("Creating keys is not supported.");
    }
}
