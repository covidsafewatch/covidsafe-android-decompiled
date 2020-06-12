package com.google.crypto.tink.shaded.protobuf;

final class ExtensionSchemas {
    private static final ExtensionSchema<?> FULL_SCHEMA = loadSchemaForFullRuntime();
    private static final ExtensionSchema<?> LITE_SCHEMA = new ExtensionSchemaLite();

    ExtensionSchemas() {
    }

    private static ExtensionSchema<?> loadSchemaForFullRuntime() {
        try {
            return (ExtensionSchema) Class.forName("com.google.crypto.tink.shaded.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static ExtensionSchema<?> lite() {
        return LITE_SCHEMA;
    }

    static ExtensionSchema<?> full() {
        ExtensionSchema<?> extensionSchema = FULL_SCHEMA;
        if (extensionSchema != null) {
            return extensionSchema;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
