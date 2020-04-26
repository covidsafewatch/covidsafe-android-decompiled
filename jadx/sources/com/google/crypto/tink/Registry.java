package com.google.crypto.tink;

import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.Keyset;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLite;
import java.security.GeneralSecurityException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;

public final class Registry {
    private static final ConcurrentMap<String, Catalogue> catalogueMap = new ConcurrentHashMap();
    private static final ConcurrentMap<String, KeyManager> keyManagerMap = new ConcurrentHashMap();
    private static final Logger logger = Logger.getLogger(Registry.class.getName());
    private static final ConcurrentMap<String, Boolean> newKeyAllowedMap = new ConcurrentHashMap();

    static synchronized void reset() {
        synchronized (Registry.class) {
            keyManagerMap.clear();
            newKeyAllowedMap.clear();
            catalogueMap.clear();
        }
    }

    public static synchronized <P> void addCatalogue(String str, Catalogue<P> catalogue) throws GeneralSecurityException {
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

    public static <P> Catalogue<P> getCatalogue(String str) throws GeneralSecurityException {
        if (str != null) {
            Catalogue<P> catalogue = (Catalogue) catalogueMap.get(str.toLowerCase());
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

    public static synchronized <P> void registerKeyManager(KeyManager<P> keyManager) throws GeneralSecurityException {
        synchronized (Registry.class) {
            registerKeyManager(keyManager, true);
        }
    }

    public static synchronized <P> void registerKeyManager(KeyManager<P> keyManager, boolean z) throws GeneralSecurityException {
        synchronized (Registry.class) {
            if (keyManager != null) {
                String keyType = keyManager.getKeyType();
                if (keyManagerMap.containsKey(keyType)) {
                    KeyManager keyManager2 = getKeyManager(keyType);
                    boolean booleanValue = ((Boolean) newKeyAllowedMap.get(keyType)).booleanValue();
                    if (keyManager.getClass().equals(keyManager2.getClass())) {
                        if (!booleanValue) {
                            if (!z) {
                            }
                        }
                    }
                    Logger logger2 = logger;
                    logger2.warning("Attempted overwrite of a registered key manager for key type " + keyType);
                    throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", new Object[]{keyType, keyManager2.getClass().getName(), keyManager.getClass().getName()}));
                }
                keyManagerMap.put(keyType, keyManager);
                newKeyAllowedMap.put(keyType, Boolean.valueOf(z));
            } else {
                throw new IllegalArgumentException("key manager must be non-null.");
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

    public static <P> KeyManager<P> getKeyManager(String str) throws GeneralSecurityException {
        KeyManager<P> keyManager = (KeyManager) keyManagerMap.get(str);
        if (keyManager != null) {
            return keyManager;
        }
        throw new GeneralSecurityException("No key manager found for key type: " + str + ".  Check the configuration of the registry.");
    }

    public static synchronized <P> KeyData newKeyData(KeyTemplate keyTemplate) throws GeneralSecurityException {
        KeyData newKeyData;
        synchronized (Registry.class) {
            KeyManager keyManager = getKeyManager(keyTemplate.getTypeUrl());
            if (((Boolean) newKeyAllowedMap.get(keyTemplate.getTypeUrl())).booleanValue()) {
                newKeyData = keyManager.newKeyData(keyTemplate.getValue());
            } else {
                throw new GeneralSecurityException("newKey-operation not permitted for key type " + keyTemplate.getTypeUrl());
            }
        }
        return newKeyData;
    }

    public static synchronized <P> MessageLite newKey(KeyTemplate keyTemplate) throws GeneralSecurityException {
        MessageLite newKey;
        synchronized (Registry.class) {
            KeyManager keyManager = getKeyManager(keyTemplate.getTypeUrl());
            if (((Boolean) newKeyAllowedMap.get(keyTemplate.getTypeUrl())).booleanValue()) {
                newKey = keyManager.newKey(keyTemplate.getValue());
            } else {
                throw new GeneralSecurityException("newKey-operation not permitted for key type " + keyTemplate.getTypeUrl());
            }
        }
        return newKey;
    }

    public static synchronized <P> MessageLite newKey(String str, MessageLite messageLite) throws GeneralSecurityException {
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

    public static <P> KeyData getPublicKeyData(String str, ByteString byteString) throws GeneralSecurityException {
        return ((PrivateKeyManager) getKeyManager(str)).getPublicKeyData(byteString);
    }

    public static <P> P getPrimitive(String str, MessageLite messageLite) throws GeneralSecurityException {
        return getKeyManager(str).getPrimitive(messageLite);
    }

    public static <P> P getPrimitive(String str, ByteString byteString) throws GeneralSecurityException {
        return getKeyManager(str).getPrimitive(byteString);
    }

    public static <P> P getPrimitive(String str, byte[] bArr) throws GeneralSecurityException {
        return getPrimitive(str, ByteString.copyFrom(bArr));
    }

    public static <P> P getPrimitive(KeyData keyData) throws GeneralSecurityException {
        return getPrimitive(keyData.getTypeUrl(), keyData.getValue());
    }

    public static <P> PrimitiveSet<P> getPrimitives(KeysetHandle keysetHandle) throws GeneralSecurityException {
        return getPrimitives(keysetHandle, (KeyManager) null);
    }

    public static <P> PrimitiveSet<P> getPrimitives(KeysetHandle keysetHandle, KeyManager<P> keyManager) throws GeneralSecurityException {
        P p;
        Util.validateKeyset(keysetHandle.getKeyset());
        PrimitiveSet<P> newPrimitiveSet = PrimitiveSet.newPrimitiveSet();
        for (Keyset.Key next : keysetHandle.getKeyset().getKeyList()) {
            if (next.getStatus() == KeyStatusType.ENABLED) {
                if (keyManager == null || !keyManager.doesSupport(next.getKeyData().getTypeUrl())) {
                    p = getPrimitive(next.getKeyData().getTypeUrl(), next.getKeyData().getValue());
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
}
