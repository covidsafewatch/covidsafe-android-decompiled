package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;

public final class JsonStreamParser implements Iterator<JsonElement> {
    private final Object lock;
    private final JsonReader parser;

    public JsonStreamParser(String str) {
        this((Reader) new StringReader(str));
    }

    public JsonStreamParser(Reader reader) {
        JsonReader jsonReader = new JsonReader(reader);
        this.parser = jsonReader;
        jsonReader.setLenient(true);
        this.lock = new Object();
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [java.lang.Throwable] */
    /* JADX WARNING: type inference failed for: r0v4, types: [java.util.NoSuchElementException] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.gson.JsonElement next() throws com.google.gson.JsonParseException {
        /*
            r3 = this;
            java.lang.String r0 = "Failed parsing JSON source to Json"
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L_0x002c
            com.google.gson.stream.JsonReader r1 = r3.parser     // Catch:{ StackOverflowError -> 0x0025, OutOfMemoryError -> 0x001e, JsonParseException -> 0x000f }
            com.google.gson.JsonElement r0 = com.google.gson.internal.Streams.parse(r1)     // Catch:{ StackOverflowError -> 0x0025, OutOfMemoryError -> 0x001e, JsonParseException -> 0x000f }
            return r0
        L_0x000f:
            r0 = move-exception
            java.lang.Throwable r1 = r0.getCause()
            boolean r1 = r1 instanceof java.io.EOFException
            if (r1 == 0) goto L_0x001d
            java.util.NoSuchElementException r0 = new java.util.NoSuchElementException
            r0.<init>()
        L_0x001d:
            throw r0
        L_0x001e:
            r1 = move-exception
            com.google.gson.JsonParseException r2 = new com.google.gson.JsonParseException
            r2.<init>(r0, r1)
            throw r2
        L_0x0025:
            r1 = move-exception
            com.google.gson.JsonParseException r2 = new com.google.gson.JsonParseException
            r2.<init>(r0, r1)
            throw r2
        L_0x002c:
            java.util.NoSuchElementException r0 = new java.util.NoSuchElementException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.JsonStreamParser.next():com.google.gson.JsonElement");
    }

    public boolean hasNext() {
        boolean z;
        synchronized (this.lock) {
            try {
                z = this.parser.peek() != JsonToken.END_DOCUMENT;
            } catch (MalformedJsonException e) {
                throw new JsonSyntaxException((Throwable) e);
            } catch (IOException e2) {
                throw new JsonIOException((Throwable) e2);
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
