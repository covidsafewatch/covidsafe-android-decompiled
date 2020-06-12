package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyTypeEntry;
import com.google.crypto.tink.proto.RegistryConfig;
import java.security.GeneralSecurityException;

public final class Config {
    public static KeyTypeEntry getTinkKeyTypeEntry(String str, String str2, String str3, int i, boolean z) {
        KeyTypeEntry.Builder primitiveName = KeyTypeEntry.newBuilder().setPrimitiveName(str2);
        return (KeyTypeEntry) primitiveName.setTypeUrl("type.googleapis.com/google.crypto.tink." + str3).setKeyManagerVersion(i).setNewKeyAllowed(z).setCatalogueName(str).build();
    }

    public static void register(RegistryConfig registryConfig) throws GeneralSecurityException {
        for (KeyTypeEntry registerKeyType : registryConfig.getEntryList()) {
            registerKeyType(registerKeyType);
        }
    }

    public static void registerKeyType(KeyTypeEntry keyTypeEntry) throws GeneralSecurityException {
        validate(keyTypeEntry);
        if (!keyTypeEntry.getCatalogueName().equals("TinkAead") && !keyTypeEntry.getCatalogueName().equals("TinkMac") && !keyTypeEntry.getCatalogueName().equals("TinkHybridDecrypt") && !keyTypeEntry.getCatalogueName().equals("TinkHybridEncrypt") && !keyTypeEntry.getCatalogueName().equals("TinkPublicKeySign") && !keyTypeEntry.getCatalogueName().equals("TinkPublicKeyVerify") && !keyTypeEntry.getCatalogueName().equals("TinkStreamingAead") && !keyTypeEntry.getCatalogueName().equals("TinkDeterministicAead")) {
            Catalogue<?> catalogue = Registry.getCatalogue(keyTypeEntry.getCatalogueName());
            Registry.registerPrimitiveWrapper(catalogue.getPrimitiveWrapper());
            Registry.registerKeyManager(catalogue.getKeyManager(keyTypeEntry.getTypeUrl(), keyTypeEntry.getPrimitiveName(), keyTypeEntry.getKeyManagerVersion()), keyTypeEntry.getNewKeyAllowed());
        }
    }

    private static void validate(KeyTypeEntry keyTypeEntry) throws GeneralSecurityException {
        if (keyTypeEntry.getTypeUrl().isEmpty()) {
            throw new GeneralSecurityException("Missing type_url.");
        } else if (keyTypeEntry.getPrimitiveName().isEmpty()) {
            throw new GeneralSecurityException("Missing primitive_name.");
        } else if (keyTypeEntry.getCatalogueName().isEmpty()) {
            throw new GeneralSecurityException("Missing catalogue_name.");
        }
    }
}
