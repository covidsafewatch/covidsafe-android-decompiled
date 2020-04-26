package com.google.crypto.tink;

import com.google.crypto.tink.PrimitiveSet.Entry;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.Keyset.Key;
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
                        StringBuilder sb = new StringBuilder();
                        sb.append("Attempted overwrite of a catalogueName catalogue for name ");
                        sb.append(str);
                        logger2.warning(sb.toString());
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("catalogue for name ");
                        sb2.append(str);
                        sb2.append(" has been already registered");
                        throw new GeneralSecurityException(sb2.toString());
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
                StringBuilder sb = new StringBuilder();
                sb.append(format);
                sb.append("Maybe call AeadConfig.register().");
                format = sb.toString();
            }
            if (str.toLowerCase().startsWith("tinkdeterministicaead")) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(format);
                sb2.append("Maybe call DeterministicAeadConfig.register().");
                format = sb2.toString();
            } else if (str.toLowerCase().startsWith("tinkstreamingaead")) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(format);
                sb3.append("Maybe call StreamingAeadConfig.register().");
                format = sb3.toString();
            } else if (str.toLowerCase().startsWith("tinkhybriddecrypt") || str.toLowerCase().startsWith("tinkhybridencrypt")) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(format);
                sb4.append("Maybe call HybridConfig.register().");
                format = sb4.toString();
            } else if (str.toLowerCase().startsWith("tinkmac")) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(format);
                sb5.append("Maybe call MacConfig.register().");
                format = sb5.toString();
            } else if (str.toLowerCase().startsWith("tinkpublickeysign") || str.toLowerCase().startsWith("tinkpublickeyverify")) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append(format);
                sb6.append("Maybe call SignatureConfig.register().");
                format = sb6.toString();
            } else if (str.toLowerCase().startsWith("tink")) {
                StringBuilder sb7 = new StringBuilder();
                sb7.append(format);
                sb7.append("Maybe call TinkConfig.register().");
                format = sb7.toString();
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
                    StringBuilder sb = new StringBuilder();
                    sb.append("Attempted overwrite of a registered key manager for key type ");
                    sb.append(keyType);
                    logger2.warning(sb.toString());
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
                        StringBuilder sb = new StringBuilder();
                        sb.append("Manager does not support key type ");
                        sb.append(str);
                        sb.append(".");
                        throw new GeneralSecurityException(sb.toString());
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
        StringBuilder sb = new StringBuilder();
        sb.append("No key manager found for key type: ");
        sb.append(str);
        sb.append(".  Check the configuration of the registry.");
        throw new GeneralSecurityException(sb.toString());
    }

    public static synchronized <P> KeyData newKeyData(KeyTemplate keyTemplate) throws GeneralSecurityException {
        KeyData newKeyData;
        synchronized (Registry.class) {
            KeyManager keyManager = getKeyManager(keyTemplate.getTypeUrl());
            if (((Boolean) newKeyAllowedMap.get(keyTemplate.getTypeUrl())).booleanValue()) {
                newKeyData = keyManager.newKeyData(keyTemplate.getValue());
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("newKey-operation not permitted for key type ");
                sb.append(keyTemplate.getTypeUrl());
                throw new GeneralSecurityException(sb.toString());
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
                StringBuilder sb = new StringBuilder();
                sb.append("newKey-operation not permitted for key type ");
                sb.append(keyTemplate.getTypeUrl());
                throw new GeneralSecurityException(sb.toString());
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
                StringBuilder sb = new StringBuilder();
                sb.append("newKey-operation not permitted for key type ");
                sb.append(str);
                throw new GeneralSecurityException(sb.toString());
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
        return getPrimitives(keysetHandle, null);
    }

    public static <P> PrimitiveSet<P> getPrimitives(KeysetHandle keysetHandle, KeyManager<P> keyManager) throws GeneralSecurityException {
        Object obj;
        Util.validateKeyset(keysetHandle.getKeyset());
        PrimitiveSet<P> newPrimitiveSet = PrimitiveSet.newPrimitiveSet();
        for (Key key : keysetHandle.getKeyset().getKeyList()) {
            if (key.getStatus() == KeyStatusType.ENABLED) {
                if (keyManager == null || !keyManager.doesSupport(key.getKeyData().getTypeUrl())) {
                    obj = getPrimitive(key.getKeyData().getTypeUrl(), key.getKeyData().getValue());
                } else {
                    obj = keyManager.getPrimitive(key.getKeyData().getValue());
                }
                Entry addPrimitive = newPrimitiveSet.addPrimitive(obj, key);
                if (key.getKeyId() == keysetHandle.getKeyset().getPrimaryKeyId()) {
                    newPrimitiveSet.setPrimary(addPrimitive);
                }
            }
        }
        return newPrimitiveSet;
    }
}
