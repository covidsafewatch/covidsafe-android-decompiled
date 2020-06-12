package com.google.crypto.tink;

import androidx.core.app.NotificationCompat;
import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.KeysetInfo;
import com.google.crypto.tink.subtle.Base64;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Path;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsonKeysetWriter implements KeysetWriter {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final OutputStream outputStream;

    private long toUnsignedLong(int i) {
        return ((long) i) & 4294967295L;
    }

    private JsonKeysetWriter(OutputStream outputStream2) {
        this.outputStream = outputStream2;
    }

    public static KeysetWriter withOutputStream(OutputStream outputStream2) {
        return new JsonKeysetWriter(outputStream2);
    }

    public static KeysetWriter withFile(File file) throws IOException {
        return new JsonKeysetWriter(new FileOutputStream(file));
    }

    public static KeysetWriter withPath(String str) throws IOException {
        return withFile(new File(str));
    }

    public static KeysetWriter withPath(Path path) throws IOException {
        return withFile(path.toFile());
    }

    public void write(Keyset keyset) throws IOException {
        try {
            this.outputStream.write(toJson(keyset).toString(4).getBytes(UTF_8));
        } catch (JSONException e) {
            throw new IOException(e);
        }
    }

    public void write(EncryptedKeyset encryptedKeyset) throws IOException {
        try {
            this.outputStream.write(toJson(encryptedKeyset).toString(4).getBytes(UTF_8));
        } catch (JSONException e) {
            throw new IOException(e);
        }
    }

    private JSONObject toJson(Keyset keyset) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("primaryKeyId", toUnsignedLong(keyset.getPrimaryKeyId()));
        JSONArray jSONArray = new JSONArray();
        for (Keyset.Key json : keyset.getKeyList()) {
            jSONArray.put(toJson(json));
        }
        jSONObject.put("key", jSONArray);
        return jSONObject;
    }

    private JSONObject toJson(Keyset.Key key) throws JSONException {
        return new JSONObject().put("keyData", toJson(key.getKeyData())).put(NotificationCompat.CATEGORY_STATUS, key.getStatus().name()).put("keyId", toUnsignedLong(key.getKeyId())).put("outputPrefixType", key.getOutputPrefixType().name());
    }

    private JSONObject toJson(KeyData keyData) throws JSONException {
        return new JSONObject().put("typeUrl", keyData.getTypeUrl()).put("value", Base64.encode(keyData.getValue().toByteArray())).put("keyMaterialType", keyData.getKeyMaterialType().name());
    }

    private JSONObject toJson(EncryptedKeyset encryptedKeyset) throws JSONException {
        return new JSONObject().put("encryptedKeyset", Base64.encode(encryptedKeyset.getEncryptedKeyset().toByteArray())).put("keysetInfo", toJson(encryptedKeyset.getKeysetInfo()));
    }

    private JSONObject toJson(KeysetInfo keysetInfo) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("primaryKeyId", toUnsignedLong(keysetInfo.getPrimaryKeyId()));
        JSONArray jSONArray = new JSONArray();
        for (KeysetInfo.KeyInfo json : keysetInfo.getKeyInfoList()) {
            jSONArray.put(toJson(json));
        }
        jSONObject.put("keyInfo", jSONArray);
        return jSONObject;
    }

    private JSONObject toJson(KeysetInfo.KeyInfo keyInfo) throws JSONException {
        return new JSONObject().put("typeUrl", keyInfo.getTypeUrl()).put(NotificationCompat.CATEGORY_STATUS, keyInfo.getStatus().name()).put("keyId", keyInfo.getKeyId()).put("outputPrefixType", keyInfo.getOutputPrefixType().name());
    }
}
