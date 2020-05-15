package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public final class JsonParser {
    public static JsonElement parseString(String str) throws JsonSyntaxException {
        return parseReader((Reader) new StringReader(str));
    }

    public static JsonElement parseReader(Reader reader) throws JsonIOException, JsonSyntaxException {
        try {
            JsonReader jsonReader = new JsonReader(reader);
            JsonElement parseReader = parseReader(jsonReader);
            if (!parseReader.isJsonNull()) {
                if (jsonReader.peek() != JsonToken.END_DOCUMENT) {
                    throw new JsonSyntaxException("Did not consume the entire document.");
                }
            }
            return parseReader;
        } catch (MalformedJsonException e) {
            throw new JsonSyntaxException((Throwable) e);
        } catch (IOException e2) {
            throw new JsonIOException((Throwable) e2);
        } catch (NumberFormatException e3) {
            throw new JsonSyntaxException((Throwable) e3);
        }
    }

    public static JsonElement parseReader(JsonReader jsonReader) throws JsonIOException, JsonSyntaxException {
        boolean isLenient = jsonReader.isLenient();
        jsonReader.setLenient(true);
        try {
            JsonElement parse = Streams.parse(jsonReader);
            jsonReader.setLenient(isLenient);
            return parse;
        } catch (StackOverflowError e) {
            throw new JsonParseException("Failed parsing JSON source: " + jsonReader + " to Json", e);
        } catch (OutOfMemoryError e2) {
            throw new JsonParseException("Failed parsing JSON source: " + jsonReader + " to Json", e2);
        } catch (Throwable th) {
            jsonReader.setLenient(isLenient);
            throw th;
        }
    }

    @Deprecated
    public JsonElement parse(String str) throws JsonSyntaxException {
        return parseString(str);
    }

    @Deprecated
    public JsonElement parse(Reader reader) throws JsonIOException, JsonSyntaxException {
        return parseReader(reader);
    }

    @Deprecated
    public JsonElement parse(JsonReader jsonReader) throws JsonIOException, JsonSyntaxException {
        return parseReader(jsonReader);
    }
}
