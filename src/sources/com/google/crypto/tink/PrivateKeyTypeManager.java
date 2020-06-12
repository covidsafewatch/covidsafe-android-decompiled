package com.google.crypto.tink;

import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.security.GeneralSecurityException;

public abstract class PrivateKeyTypeManager<KeyProtoT extends MessageLite, PublicKeyProtoT extends MessageLite> extends KeyTypeManager<KeyProtoT> {
    private final Class<PublicKeyProtoT> publicKeyClazz;

    public abstract PublicKeyProtoT getPublicKey(KeyProtoT keyprotot) throws GeneralSecurityException;

    @SafeVarargs
    protected PrivateKeyTypeManager(Class<KeyProtoT> cls, Class<PublicKeyProtoT> cls2, KeyTypeManager.PrimitiveFactory<?, KeyProtoT>... primitiveFactoryArr) {
        super(cls, primitiveFactoryArr);
        this.publicKeyClazz = cls2;
    }

    public final Class<PublicKeyProtoT> getPublicKeyClass() {
        return this.publicKeyClazz;
    }
}
