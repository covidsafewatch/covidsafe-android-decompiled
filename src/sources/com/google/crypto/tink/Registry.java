package com.google.crypto.tink;

import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;

public final class Registry {
    private static final ConcurrentMap<String, Catalogue<?>> catalogueMap = new ConcurrentHashMap();
    private static final ConcurrentMap<String, KeyDeriverContainer> keyDeriverMap = new ConcurrentHashMap();
    private static final ConcurrentMap<String, KeyManagerContainer> keyManagerMap = new ConcurrentHashMap();
    private static final Logger logger = Logger.getLogger(Registry.class.getName());
    private static final ConcurrentMap<String, Boolean> newKeyAllowedMap = new ConcurrentHashMap();
    private static final ConcurrentMap<Class<?>, PrimitiveWrapper<?>> primitiveWrapperMap = new ConcurrentHashMap();

    private interface KeyDeriverContainer {
        KeyData deriveKey(ByteString byteString, InputStream inputStream) throws GeneralSecurityException;
    }

    private interface KeyManagerContainer {
        Class<?> getImplementingClass();

        <P> KeyManager<P> getKeyManager(Class<P> cls) throws GeneralSecurityException;

        KeyManager<?> getUntypedKeyManager();

        MessageLite parseKey(ByteString byteString) throws GeneralSecurityException, InvalidProtocolBufferException;

        Class<?> publicKeyManagerClassOrNull();

        Set<Class<?>> supportedPrimitives();
    }

    private static <P> KeyManagerContainer createContainerFor(final KeyManager<P> keyManager) {
        return new KeyManagerContainer() {
            public MessageLite parseKey(ByteString byteString) throws GeneralSecurityException, InvalidProtocolBufferException {
                return null;
            }

            public Class<?> publicKeyManagerClassOrNull() {
                return null;
            }

            public <Q> KeyManager<Q> getKeyManager(Class<Q> cls) throws GeneralSecurityException {
                if (KeyManager.this.getPrimitiveClass().equals(cls)) {
                    return KeyManager.this;
                }
                throw new InternalError("This should never be called, as we always first check supportedPrimitives.");
            }

            public KeyManager<?> getUntypedKeyManager() {
                return KeyManager.this;
            }

            public Class<?> getImplementingClass() {
                return KeyManager.this.getClass();
            }

            public Set<Class<?>> supportedPrimitives() {
                return Collections.singleton(KeyManager.this.getPrimitiveClass());
            }
        };
    }

    private static <KeyProtoT extends MessageLite> KeyManagerContainer createContainerFor(final KeyTypeManager<KeyProtoT> keyTypeManager) {
        return new KeyManagerContainer() {
            public Class<?> publicKeyManagerClassOrNull() {
                return null;
            }

            public <Q> KeyManager<Q> getKeyManager(Class<Q> cls) throws GeneralSecurityException {
                try {
                    return new KeyManagerImpl(KeyTypeManager.this, cls);
                } catch (IllegalArgumentException e) {
                    throw new GeneralSecurityException("Primitive type not supported", e);
                }
            }

            public KeyManager<?> getUntypedKeyManager() {
                KeyTypeManager keyTypeManager = KeyTypeManager.this;
                return new KeyManagerImpl(keyTypeManager, keyTypeManager.firstSupportedPrimitiveClass());
            }

            public Class<?> getImplementingClass() {
                return KeyTypeManager.this.getClass();
            }

            public Set<Class<?>> supportedPrimitives() {
                return KeyTypeManager.this.supportedPrimitives();
            }

            public MessageLite parseKey(ByteString byteString) throws GeneralSecurityException, InvalidProtocolBufferException {
                MessageLite parseKey = KeyTypeManager.this.parseKey(byteString);
                KeyTypeManager.this.validateKey(parseKey);
                return parseKey;
            }
        };
    }

    private static <KeyProtoT extends MessageLite, PublicKeyProtoT extends MessageLite> KeyManagerContainer createPrivateKeyContainerFor(final PrivateKeyTypeManager<KeyProtoT, PublicKeyProtoT> privateKeyTypeManager, final KeyTypeManager<PublicKeyProtoT> keyTypeManager) {
        return new KeyManagerContainer() {
            public <Q> KeyManager<Q> getKeyManager(Class<Q> cls) throws GeneralSecurityException {
                try {
                    return new PrivateKeyManagerImpl(PrivateKeyTypeManager.this, keyTypeManager, cls);
                } catch (IllegalArgumentException e) {
                    throw new GeneralSecurityException("Primitive type not supported", e);
                }
            }

            public KeyManager<?> getUntypedKeyManager() {
                PrivateKeyTypeManager privateKeyTypeManager = PrivateKeyTypeManager.this;
                return new PrivateKeyManagerImpl(privateKeyTypeManager, keyTypeManager, privateKeyTypeManager.firstSupportedPrimitiveClass());
            }

            public Class<?> getImplementingClass() {
                return PrivateKeyTypeManager.this.getClass();
            }

            public Set<Class<?>> supportedPrimitives() {
                return PrivateKeyTypeManager.this.supportedPrimitives();
            }

            public Class<?> publicKeyManagerClassOrNull() {
                return keyTypeManager.getClass();
            }

            public MessageLite parseKey(ByteString byteString) throws GeneralSecurityException, InvalidProtocolBufferException {
                MessageLite parseKey = PrivateKeyTypeManager.this.parseKey(byteString);
                PrivateKeyTypeManager.this.validateKey(parseKey);
                return parseKey;
            }
        };
    }

    private static <KeyProtoT extends MessageLite> KeyDeriverContainer createDeriverFor(final KeyTypeManager<KeyProtoT> keyTypeManager) {
        return new KeyDeriverContainer() {
            private <KeyFormatProtoT extends MessageLite> MessageLite deriveKeyWithFactory(ByteString byteString, InputStream inputStream, KeyTypeManager.KeyFactory<KeyFormatProtoT, KeyProtoT> keyFactory) throws GeneralSecurityException {
                try {
                    KeyFormatProtoT parseKeyFormat = keyFactory.parseKeyFormat(byteString);
                    keyFactory.validateKeyFormat(parseKeyFormat);
                    return (MessageLite) keyFactory.deriveKey(parseKeyFormat, inputStream);
                } catch (InvalidProtocolBufferException e) {
                    throw new GeneralSecurityException("parsing key format failed in deriveKey", e);
                }
            }

            public KeyData deriveKey(ByteString byteString, InputStream inputStream) throws GeneralSecurityException {
                return (KeyData) KeyData.newBuilder().setTypeUrl(KeyTypeManager.this.getKeyType()).setValue(deriveKeyWithFactory(byteString, inputStream, KeyTypeManager.this.keyFactory()).toByteString()).setKeyMaterialType(KeyTypeManager.this.keyMaterialType()).build();
            }
        };
    }

    private static synchronized KeyManagerContainer getKeyManagerContainerOrThrow(String str) throws GeneralSecurityException {
        KeyManagerContainer keyManagerContainer;
        synchronized (Registry.class) {
            if (keyManagerMap.containsKey(str)) {
                keyManagerContainer = (KeyManagerContainer) keyManagerMap.get(str);
            } else {
                throw new GeneralSecurityException("No key manager found for key type " + str);
            }
        }
        return keyManagerContainer;
    }

    static synchronized void reset() {
        synchronized (Registry.class) {
            keyManagerMap.clear();
            keyDeriverMap.clear();
            newKeyAllowedMap.clear();
            catalogueMap.clear();
            primitiveWrapperMap.clear();
        }
    }

    @Deprecated
    public static synchronized void addCatalogue(String str, Catalogue<?> catalogue) throws GeneralSecurityException {
        synchronized (Registry.class) {
            if (str == null) {
                throw new IllegalArgumentException("catalogueName must be non-null.");
            } else if (catalogue != null) {
                if (catalogueMap.containsKey(str.toLowerCase())) {
                    if (!catalogue.getClass().equals(((Catalogue) catalogueMap.get(str.toLowerCase())).getClass())) {
                        Logger logger2 = logger;
                        logger2.warning("Attempted overwrite of a catalogueName catalogue for name " + str);
                        throw new GeneralSecurityException("catalogue for name " + str + " has been already registered");
                    }
                }
                catalogueMap.put(str.toLowerCase(), catalogue);
            } else {
                throw new IllegalArgumentException("catalogue must be non-null.");
            }
        }
    }

    @Deprecated
    public static Catalogue<?> getCatalogue(String str) throws GeneralSecurityException {
        if (str != null) {
            Catalogue<?> catalogue = (Catalogue) catalogueMap.get(str.toLowerCase());
            if (catalogue != null) {
                return catalogue;
            }
            String format = String.format("no catalogue found for %s. ", new Object[]{str});
            if (str.toLowerCase().startsWith("tinkaead")) {
                format = format + "Maybe call AeadConfig.register().";
            }
            if (str.toLowerCase().startsWith("tinkdeterministicaead")) {
                format = format + "Maybe call DeterministicAeadConfig.register().";
            } else if (str.toLowerCase().startsWith("tinkstreamingaead")) {
                format = format + "Maybe call StreamingAeadConfig.register().";
            } else if (str.toLowerCase().startsWith("tinkhybriddecrypt") || str.toLowerCase().startsWith("tinkhybridencrypt")) {
                format = format + "Maybe call HybridConfig.register().";
            } else if (str.toLowerCase().startsWith("tinkmac")) {
                format = format + "Maybe call MacConfig.register().";
            } else if (str.toLowerCase().startsWith("tinkpublickeysign") || str.toLowerCase().startsWith("tinkpublickeyverify")) {
                format = format + "Maybe call SignatureConfig.register().";
            } else if (str.toLowerCase().startsWith("tink")) {
                format = format + "Maybe call TinkConfig.register().";
            }
            throw new GeneralSecurityException(format);
        }
        throw new IllegalArgumentException("catalogueName must be non-null.");
    }

    private static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    public static synchronized <P> void registerKeyManager(KeyManager<P> keyManager) throws GeneralSecurityException {
        synchronized (Registry.class) {
            registerKeyManager(keyManager, true);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0048, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void ensureKeyManagerInsertable(java.lang.String r5, java.lang.Class<?> r6, boolean r7) throws java.security.GeneralSecurityException {
        /*
            java.lang.Class<com.google.crypto.tink.Registry> r0 = com.google.crypto.tink.Registry.class
            monitor-enter(r0)
            java.util.concurrent.ConcurrentMap<java.lang.String, com.google.crypto.tink.Registry$KeyManagerContainer> r1 = keyManagerMap     // Catch:{ all -> 0x0083 }
            boolean r1 = r1.containsKey(r5)     // Catch:{ all -> 0x0083 }
            if (r1 != 0) goto L_0x000d
            monitor-exit(r0)
            return
        L_0x000d:
            java.util.concurrent.ConcurrentMap<java.lang.String, com.google.crypto.tink.Registry$KeyManagerContainer> r1 = keyManagerMap     // Catch:{ all -> 0x0083 }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x0083 }
            com.google.crypto.tink.Registry$KeyManagerContainer r1 = (com.google.crypto.tink.Registry.KeyManagerContainer) r1     // Catch:{ all -> 0x0083 }
            java.lang.Class r2 = r1.getImplementingClass()     // Catch:{ all -> 0x0083 }
            boolean r2 = r2.equals(r6)     // Catch:{ all -> 0x0083 }
            if (r2 == 0) goto L_0x0049
            if (r7 == 0) goto L_0x0047
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Boolean> r6 = newKeyAllowedMap     // Catch:{ all -> 0x0083 }
            java.lang.Object r6 = r6.get(r5)     // Catch:{ all -> 0x0083 }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ all -> 0x0083 }
            boolean r6 = r6.booleanValue()     // Catch:{ all -> 0x0083 }
            if (r6 == 0) goto L_0x0030
            goto L_0x0047
        L_0x0030:
            java.security.GeneralSecurityException r6 = new java.security.GeneralSecurityException     // Catch:{ all -> 0x0083 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0083 }
            r7.<init>()     // Catch:{ all -> 0x0083 }
            java.lang.String r1 = "New keys are already disallowed for key type "
            r7.append(r1)     // Catch:{ all -> 0x0083 }
            r7.append(r5)     // Catch:{ all -> 0x0083 }
            java.lang.String r5 = r7.toString()     // Catch:{ all -> 0x0083 }
            r6.<init>(r5)     // Catch:{ all -> 0x0083 }
            throw r6     // Catch:{ all -> 0x0083 }
        L_0x0047:
            monitor-exit(r0)
            return
        L_0x0049:
            java.util.logging.Logger r7 = logger     // Catch:{ all -> 0x0083 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0083 }
            r2.<init>()     // Catch:{ all -> 0x0083 }
            java.lang.String r3 = "Attempted overwrite of a registered key manager for key type "
            r2.append(r3)     // Catch:{ all -> 0x0083 }
            r2.append(r5)     // Catch:{ all -> 0x0083 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0083 }
            r7.warning(r2)     // Catch:{ all -> 0x0083 }
            java.security.GeneralSecurityException r7 = new java.security.GeneralSecurityException     // Catch:{ all -> 0x0083 }
            java.lang.String r2 = "typeUrl (%s) is already registered with %s, cannot be re-registered with %s"
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0083 }
            r4 = 0
            r3[r4] = r5     // Catch:{ all -> 0x0083 }
            r5 = 1
            java.lang.Class r1 = r1.getImplementingClass()     // Catch:{ all -> 0x0083 }
            java.lang.String r1 = r1.getName()     // Catch:{ all -> 0x0083 }
            r3[r5] = r1     // Catch:{ all -> 0x0083 }
            r5 = 2
            java.lang.String r6 = r6.getName()     // Catch:{ all -> 0x0083 }
            r3[r5] = r6     // Catch:{ all -> 0x0083 }
            java.lang.String r5 = java.lang.String.format(r2, r3)     // Catch:{ all -> 0x0083 }
            r7.<init>(r5)     // Catch:{ all -> 0x0083 }
            throw r7     // Catch:{ all -> 0x0083 }
        L_0x0083:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.Registry.ensureKeyManagerInsertable(java.lang.String, java.lang.Class, boolean):void");
    }

    public static synchronized <P> void registerKeyManager(KeyManager<P> keyManager, boolean z) throws GeneralSecurityException {
        synchronized (Registry.class) {
            if (keyManager != null) {
                String keyType = keyManager.getKeyType();
                ensureKeyManagerInsertable(keyType, keyManager.getClass(), z);
                if (!keyManagerMap.containsKey(keyType)) {
                    keyManagerMap.put(keyType, createContainerFor(keyManager));
                }
                newKeyAllowedMap.put(keyType, Boolean.valueOf(z));
            } else {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
        }
    }

    public static synchronized <KeyProtoT extends MessageLite> void registerKeyManager(KeyTypeManager<KeyProtoT> keyTypeManager, boolean z) throws GeneralSecurityException {
        synchronized (Registry.class) {
            if (keyTypeManager != null) {
                String keyType = keyTypeManager.getKeyType();
                ensureKeyManagerInsertable(keyType, keyTypeManager.getClass(), z);
                if (!keyManagerMap.containsKey(keyType)) {
                    keyManagerMap.put(keyType, createContainerFor(keyTypeManager));
                    keyDeriverMap.put(keyType, createDeriverFor(keyTypeManager));
                }
                newKeyAllowedMap.put(keyType, Boolean.valueOf(z));
            } else {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
        }
    }

    public static synchronized <KeyProtoT extends MessageLite, PublicKeyProtoT extends MessageLite> void registerAsymmetricKeyManagers(PrivateKeyTypeManager<KeyProtoT, PublicKeyProtoT> privateKeyTypeManager, KeyTypeManager<PublicKeyProtoT> keyTypeManager, boolean z) throws GeneralSecurityException {
        Class<?> publicKeyManagerClassOrNull;
        synchronized (Registry.class) {
            if (privateKeyTypeManager == null || keyTypeManager == null) {
                throw new IllegalArgumentException("given key managers must be non-null.");
            }
            String keyType = privateKeyTypeManager.getKeyType();
            String keyType2 = keyTypeManager.getKeyType();
            ensureKeyManagerInsertable(keyType, privateKeyTypeManager.getClass(), z);
            ensureKeyManagerInsertable(keyType2, keyTypeManager.getClass(), false);
            if (!keyType.equals(keyType2)) {
                if (keyManagerMap.containsKey(keyType) && (publicKeyManagerClassOrNull = ((KeyManagerContainer) keyManagerMap.get(keyType)).publicKeyManagerClassOrNull()) != null) {
                    if (!publicKeyManagerClassOrNull.equals(keyTypeManager.getClass())) {
                        Logger logger2 = logger;
                        logger2.warning("Attempted overwrite of a registered key manager for key type " + keyType + " with inconsistent public key type " + keyType2);
                        throw new GeneralSecurityException(String.format("public key manager corresponding to %s is already registered with %s, cannot be re-registered with %s", new Object[]{privateKeyTypeManager.getClass().getName(), publicKeyManagerClassOrNull.getName(), keyTypeManager.getClass().getName()}));
                    }
                }
                if (!keyManagerMap.containsKey(keyType) || ((KeyManagerContainer) keyManagerMap.get(keyType)).publicKeyManagerClassOrNull() == null) {
                    keyManagerMap.put(keyType, createPrivateKeyContainerFor(privateKeyTypeManager, keyTypeManager));
                    keyDeriverMap.put(keyType, createDeriverFor(privateKeyTypeManager));
                }
                newKeyAllowedMap.put(keyType, Boolean.valueOf(z));
                if (!keyManagerMap.containsKey(keyType2)) {
                    keyManagerMap.put(keyType2, createContainerFor(keyTypeManager));
                }
                newKeyAllowedMap.put(keyType2, false);
            } else {
                throw new GeneralSecurityException("Private and public key type must be different.");
            }
        }
    }

    @Deprecated
    public static synchronized <P> void registerKeyManager(String str, KeyManager<P> keyManager) throws GeneralSecurityException {
        synchronized (Registry.class) {
            registerKeyManager(str, keyManager, true);
        }
    }

    @Deprecated
    public static synchronized <P> void registerKeyManager(String str, KeyManager<P> keyManager, boolean z) throws GeneralSecurityException {
        synchronized (Registry.class) {
            if (keyManager != null) {
                try {
                    if (str.equals(keyManager.getKeyType())) {
                        registerKeyManager(keyManager, z);
                    } else {
                        throw new GeneralSecurityException("Manager does not support key type " + str + ".");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
        }
    }

    public static synchronized <P> void registerPrimitiveWrapper(PrimitiveWrapper<P> primitiveWrapper) throws GeneralSecurityException {
        synchronized (Registry.class) {
            if (primitiveWrapper != null) {
                Class<P> primitiveClass = primitiveWrapper.getPrimitiveClass();
                if (primitiveWrapperMap.containsKey(primitiveClass)) {
                    PrimitiveWrapper primitiveWrapper2 = (PrimitiveWrapper) primitiveWrapperMap.get(primitiveClass);
                    if (!primitiveWrapper.getClass().equals(primitiveWrapper2.getClass())) {
                        Logger logger2 = logger;
                        logger2.warning("Attempted overwrite of a registered SetWrapper for type " + primitiveClass.toString());
                        throw new GeneralSecurityException(String.format("SetWrapper for primitive (%s) is already registered to be %s, cannot be re-registered with %s", new Object[]{primitiveClass.getName(), primitiveWrapper2.getClass().getName(), primitiveWrapper.getClass().getName()}));
                    }
                }
                primitiveWrapperMap.put(primitiveClass, primitiveWrapper);
            } else {
                throw new IllegalArgumentException("wrapper must be non-null");
            }
        }
    }

    @Deprecated
    public static <P> KeyManager<P> getKeyManager(String str) throws GeneralSecurityException {
        return getKeyManagerInternal(str, (Class) null);
    }

    public static KeyManager<?> getUntypedKeyManager(String str) throws GeneralSecurityException {
        return getKeyManagerContainerOrThrow(str).getUntypedKeyManager();
    }

    public static <P> KeyManager<P> getKeyManager(String str, Class<P> cls) throws GeneralSecurityException {
        return getKeyManagerInternal(str, (Class) checkNotNull(cls));
    }

    private static String toCommaSeparatedString(Set<Class<?>> set) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Class next : set) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(next.getCanonicalName());
            z = false;
        }
        return sb.toString();
    }

    private static <P> KeyManager<P> getKeyManagerInternal(String str, Class<P> cls) throws GeneralSecurityException {
        KeyManagerContainer keyManagerContainerOrThrow = getKeyManagerContainerOrThrow(str);
        if (cls == null) {
            return keyManagerContainerOrThrow.getUntypedKeyManager();
        }
        if (keyManagerContainerOrThrow.supportedPrimitives().contains(cls)) {
            return keyManagerContainerOrThrow.getKeyManager(cls);
        }
        throw new GeneralSecurityException("Primitive type " + cls.getName() + " not supported by key manager of type " + keyManagerContainerOrThrow.getImplementingClass() + ", supported primitives: " + toCommaSeparatedString(keyManagerContainerOrThrow.supportedPrimitives()));
    }

    public static synchronized KeyData newKeyData(KeyTemplate keyTemplate) throws GeneralSecurityException {
        KeyData newKeyData;
        synchronized (Registry.class) {
            KeyManager<?> untypedKeyManager = getUntypedKeyManager(keyTemplate.getTypeUrl());
            if (((Boolean) newKeyAllowedMap.get(keyTemplate.getTypeUrl())).booleanValue()) {
                newKeyData = untypedKeyManager.newKeyData(keyTemplate.getValue());
            } else {
                throw new GeneralSecurityException("newKey-operation not permitted for key type " + keyTemplate.getTypeUrl());
            }
        }
        return newKeyData;
    }

    public static synchronized MessageLite newKey(KeyTemplate keyTemplate) throws GeneralSecurityException {
        MessageLite newKey;
        synchronized (Registry.class) {
            KeyManager<?> untypedKeyManager = getUntypedKeyManager(keyTemplate.getTypeUrl());
            if (((Boolean) newKeyAllowedMap.get(keyTemplate.getTypeUrl())).booleanValue()) {
                newKey = untypedKeyManager.newKey(keyTemplate.getValue());
            } else {
                throw new GeneralSecurityException("newKey-operation not permitted for key type " + keyTemplate.getTypeUrl());
            }
        }
        return newKey;
    }

    public static synchronized MessageLite newKey(String str, MessageLite messageLite) throws GeneralSecurityException {
        MessageLite newKey;
        synchronized (Registry.class) {
            KeyManager keyManager = getKeyManager(str);
            if (((Boolean) newKeyAllowedMap.get(str)).booleanValue()) {
                newKey = keyManager.newKey(messageLite);
            } else {
                throw new GeneralSecurityException("newKey-operation not permitted for key type " + str);
            }
        }
        return newKey;
    }

    static synchronized KeyData deriveKey(KeyTemplate keyTemplate, InputStream inputStream) throws GeneralSecurityException {
        KeyData deriveKey;
        synchronized (Registry.class) {
            String typeUrl = keyTemplate.getTypeUrl();
            if (keyDeriverMap.containsKey(typeUrl)) {
                deriveKey = ((KeyDeriverContainer) keyDeriverMap.get(typeUrl)).deriveKey(keyTemplate.getValue(), inputStream);
            } else {
                throw new GeneralSecurityException("No keymanager registered or key manager cannot derive keys for " + typeUrl);
            }
        }
        return deriveKey;
    }

    public static KeyData getPublicKeyData(String str, ByteString byteString) throws GeneralSecurityException {
        KeyManager keyManager = getKeyManager(str);
        if (keyManager instanceof PrivateKeyManager) {
            return ((PrivateKeyManager) keyManager).getPublicKeyData(byteString);
        }
        throw new GeneralSecurityException("manager for key type " + str + " is not a PrivateKeyManager");
    }

    @Deprecated
    public static <P> P getPrimitive(String str, MessageLite messageLite) throws GeneralSecurityException {
        return getPrimitiveInternal(str, messageLite, (Class) null);
    }

    public static <P> P getPrimitive(String str, MessageLite messageLite, Class<P> cls) throws GeneralSecurityException {
        return getPrimitiveInternal(str, messageLite, (Class) checkNotNull(cls));
    }

    private static <P> P getPrimitiveInternal(String str, MessageLite messageLite, Class<P> cls) throws GeneralSecurityException {
        return getKeyManagerInternal(str, cls).getPrimitive(messageLite);
    }

    @Deprecated
    public static <P> P getPrimitive(String str, ByteString byteString) throws GeneralSecurityException {
        return getPrimitiveInternal(str, byteString, (Class) null);
    }

    public static <P> P getPrimitive(String str, ByteString byteString, Class<P> cls) throws GeneralSecurityException {
        return getPrimitiveInternal(str, byteString, (Class) checkNotNull(cls));
    }

    private static <P> P getPrimitiveInternal(String str, ByteString byteString, Class<P> cls) throws GeneralSecurityException {
        return getKeyManagerInternal(str, cls).getPrimitive(byteString);
    }

    @Deprecated
    public static <P> P getPrimitive(String str, byte[] bArr) throws GeneralSecurityException {
        return getPrimitive(str, ByteString.copyFrom(bArr));
    }

    public static <P> P getPrimitive(String str, byte[] bArr, Class<P> cls) throws GeneralSecurityException {
        return getPrimitive(str, ByteString.copyFrom(bArr), cls);
    }

    @Deprecated
    public static <P> P getPrimitive(KeyData keyData) throws GeneralSecurityException {
        return getPrimitive(keyData.getTypeUrl(), keyData.getValue());
    }

    public static <P> P getPrimitive(KeyData keyData, Class<P> cls) throws GeneralSecurityException {
        return getPrimitive(keyData.getTypeUrl(), keyData.getValue(), cls);
    }

    @Deprecated
    public static <P> PrimitiveSet<P> getPrimitives(KeysetHandle keysetHandle) throws GeneralSecurityException {
        return getPrimitives(keysetHandle, (KeyManager) null);
    }

    public static <P> PrimitiveSet<P> getPrimitives(KeysetHandle keysetHandle, Class<P> cls) throws GeneralSecurityException {
        return getPrimitives(keysetHandle, (KeyManager) null, cls);
    }

    @Deprecated
    public static <P> PrimitiveSet<P> getPrimitives(KeysetHandle keysetHandle, KeyManager<P> keyManager) throws GeneralSecurityException {
        return getPrimitivesInternal(keysetHandle, keyManager, (Class) null);
    }

    public static <P> PrimitiveSet<P> getPrimitives(KeysetHandle keysetHandle, KeyManager<P> keyManager, Class<P> cls) throws GeneralSecurityException {
        return getPrimitivesInternal(keysetHandle, keyManager, (Class) checkNotNull(cls));
    }

    private static <P> PrimitiveSet<P> getPrimitivesInternal(KeysetHandle keysetHandle, KeyManager<P> keyManager, Class<P> cls) throws GeneralSecurityException {
        P p;
        Util.validateKeyset(keysetHandle.getKeyset());
        PrimitiveSet<P> newPrimitiveSet = PrimitiveSet.newPrimitiveSet(cls);
        for (Keyset.Key next : keysetHandle.getKeyset().getKeyList()) {
            if (next.getStatus() == KeyStatusType.ENABLED) {
                if (keyManager == null || !keyManager.doesSupport(next.getKeyData().getTypeUrl())) {
                    p = getPrimitiveInternal(next.getKeyData().getTypeUrl(), next.getKeyData().getValue(), cls);
                } else {
                    p = keyManager.getPrimitive(next.getKeyData().getValue());
                }
                PrimitiveSet.Entry<P> addPrimitive = newPrimitiveSet.addPrimitive(p, next);
                if (next.getKeyId() == keysetHandle.getKeyset().getPrimaryKeyId()) {
                    newPrimitiveSet.setPrimary(addPrimitive);
                }
            }
        }
        return newPrimitiveSet;
    }

    public static <P> P wrap(PrimitiveSet<P> primitiveSet) throws GeneralSecurityException {
        PrimitiveWrapper primitiveWrapper = (PrimitiveWrapper) primitiveWrapperMap.get(primitiveSet.getPrimitiveClass());
        if (primitiveWrapper != null) {
            return primitiveWrapper.wrap(primitiveSet);
        }
        throw new GeneralSecurityException("No wrapper found for " + primitiveSet.getPrimitiveClass().getName());
    }

    static MessageLite parseKeyData(KeyData keyData) throws GeneralSecurityException, InvalidProtocolBufferException {
        return getKeyManagerContainerOrThrow(keyData.getTypeUrl()).parseKey(keyData.getValue());
    }
}
