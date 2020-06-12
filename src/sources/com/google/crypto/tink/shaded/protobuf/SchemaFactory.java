package com.google.crypto.tink.shaded.protobuf;

interface SchemaFactory {
    <T> Schema<T> createSchema(Class<T> cls);
}
