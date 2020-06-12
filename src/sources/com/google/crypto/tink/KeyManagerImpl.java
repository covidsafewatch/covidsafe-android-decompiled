package com.google.crypto.tink;

import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.security.GeneralSecurityException;

public class KeyManagerImpl<PrimitiveT, KeyProtoT extends MessageLite> implements KeyManager<PrimitiveT> {
    private final KeyTypeManager<KeyProtoT> keyTypeManager;
    private final Class<PrimitiveT> primitiveClass;

    public KeyManagerImpl(KeyTypeManager<KeyProtoT> keyTypeManager2, Class<PrimitiveT> cls) {
        if (keyTypeManager2.supportedPrimitives().contains(cls) || Void.class.equals(cls)) {
            this.keyTypeManager = keyTypeManager2;
            this.primitiveClass = cls;
            return;
        }
        throw new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", new Object[]{keyTypeManager2.toString(), cls.getName()}));
    }

    /* access modifiers changed from: private */
    public static <CastedT> CastedT castOrThrowSecurityException(Object obj, String str, Class<CastedT> cls) throws GeneralSecurityException {
        if (cls.isInstance(obj)) {
            return obj;
        }
        throw new GeneralSecurityException(str);
    }

    public final PrimitiveT getPrimitive(ByteString byteString) throws GeneralSecurityException {
        try {
            return validateKeyAndGetPrimitive(this.keyTypeManager.parseKey(byteString));
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("Failures parsing proto of type " + this.keyTypeManager.getKeyClass().getName(), e);
        }
    }

    public final PrimitiveT getPrimitive(MessageLite messageLite) throws GeneralSecurityException {
        return validateKeyAndGetPrimitive((MessageLite) castOrThrowSecurityException(messageLite, "Expected proto of type " + this.keyTypeManager.getKeyClass().getName(), this.keyTypeManager.getKeyClass()));
    }

    public final MessageLite newKey(ByteString byteString) throws GeneralSecurityException {
        try {
            return keyFactoryHelper().parseValidateCreate(byteString);
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("Failures parsing proto of type " + this.keyTypeManager.keyFactory().getKeyFormatClass().getName(), e);
        }
    }

    public final MessageLite newKey(MessageLite messageLite) throws GeneralSecurityException {
        return keyFactoryHelper().castValidateCreate(messageLite);
    }

    public final boolean doesSupport(String str) {
        return str.equals(getKeyType());
    }

    public final String getKeyType() {
        return this.keyTypeManager.getKeyType();
    }

    public int getVersion() {
        return this.keyTypeManager.getVersion();
    }

    public final KeyData newKeyData(ByteString byteString) throws GeneralSecurityException {
        try {
            return (KeyData) KeyData.newBuilder().setTypeUrl(getKeyType()).setValue(keyFactoryHelper().parseValidateCreate(byteString).toByteString()).setKeyMaterialType(this.keyTypeManager.keyMaterialType()).build();
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("Unexpected proto", e);
        }
    }

    public final Class<PrimitiveT> getPrimitiveClass() {
        return this.primitiveClass;
    }

    private PrimitiveT validateKeyAndGetPrimitive(KeyProtoT keyprotot) throws GeneralSecurityException {
        if (!Void.class.equals(this.primitiveClass)) {
            this.keyTypeManager.validateKey(keyprotot);
            return this.keyTypeManager.getPrimitive(keyprotot, this.primitiveClass);
        }
        throw new GeneralSecurityException("Cannot create a primitive for Void");
    }

    private static class KeyFactoryHelper<KeyFormatProtoT extends MessageLite, KeyProtoT extends MessageLite> {
        final KeyTypeManager.KeyFactory<KeyFormatProtoT, KeyProtoT> keyFactory;

        KeyFactoryHelper(KeyTypeManager.KeyFactory<KeyFormatProtoT, KeyProtoT> keyFactory2) {
            this.keyFactory = keyFactory2;
        }

        private KeyProtoT validateCreate(KeyFormatProtoT keyformatprotot) throws GeneralSecurityException {
            this.keyFactory.validateKeyFormat(keyformatprotot);
            return (MessageLite) this.keyFactory.createKey(keyformatprotot);
        }

        /* access modifiers changed from: package-private */
        public KeyProtoT parseValidateCreate(ByteString byteString) throws GeneralSecurityException, InvalidProtocolBufferException {
            return validateCreate(this.keyFactory.parseKeyFormat(byteString));
        }

        /* access modifiers changed from: package-private */
        public KeyProtoT castValidateCreate(MessageLite messageLite) throws GeneralSecurityException {
            return validateCreate((MessageLite) KeyManagerImpl.castOrThrowSecurityException(messageLite, "Expected proto of type " + this.keyFactory.getKeyFormatClass().getName(), this.keyFactory.getKeyFormatClass()));
        }
    }

    private KeyFactoryHelper<?, KeyProtoT> keyFactoryHelper() {
        return new KeyFactoryHelper<>(this.keyTypeManager.keyFactory());
    }
}
