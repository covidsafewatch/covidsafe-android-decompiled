package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class Protobuf {
    private static final Protobuf INSTANCE = new Protobuf();
    private final ConcurrentMap<Class<?>, Schema<?>> schemaCache = new ConcurrentHashMap();
    private final SchemaFactory schemaFactory = new ManifestSchemaFactory();

    public static Protobuf getInstance() {
        return INSTANCE;
    }

    public <T> void writeTo(T t, Writer writer) throws IOException {
        schemaFor(t).writeTo(t, writer);
    }

    public <T> void mergeFrom(T t, Reader reader) throws IOException {
        mergeFrom(t, reader, ExtensionRegistryLite.getEmptyRegistry());
    }

    public <T> void mergeFrom(T t, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        schemaFor(t).mergeFrom(t, reader, extensionRegistryLite);
    }

    public <T> void makeImmutable(T t) {
        schemaFor(t).makeImmutable(t);
    }

    public <T> boolean isInitialized(T t) {
        return schemaFor(t).isInitialized(t);
    }

    public <T> Schema<T> schemaFor(Class<T> cls) {
        Internal.checkNotNull(cls, "messageType");
        Schema<T> schema = (Schema) this.schemaCache.get(cls);
        if (schema != null) {
            return schema;
        }
        Schema<T> createSchema = this.schemaFactory.createSchema(cls);
        Schema<?> registerSchema = registerSchema(cls, createSchema);
        return registerSchema != null ? registerSchema : createSchema;
    }

    public <T> Schema<T> schemaFor(T t) {
        return schemaFor(t.getClass());
    }

    public Schema<?> registerSchema(Class<?> cls, Schema<?> schema) {
        Internal.checkNotNull(cls, "messageType");
        Internal.checkNotNull(schema, "schema");
        return this.schemaCache.putIfAbsent(cls, schema);
    }

    public Schema<?> registerSchemaOverride(Class<?> cls, Schema<?> schema) {
        Internal.checkNotNull(cls, "messageType");
        Internal.checkNotNull(schema, "schema");
        return (Schema) this.schemaCache.put(cls, schema);
    }

    private Protobuf() {
    }

    /* access modifiers changed from: package-private */
    public int getTotalSchemaSize() {
        int i = 0;
        for (Schema schema : this.schemaCache.values()) {
            if (schema instanceof MessageSchema) {
                i += ((MessageSchema) schema).getSchemaSize();
            }
        }
        return i;
    }
}
