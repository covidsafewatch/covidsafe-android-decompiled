package com.google.crypto.tink;

import androidx.core.app.NotificationCompat;
import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyData.KeyMaterialType;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.Keyset.Builder;
import com.google.crypto.tink.proto.Keyset.Key;
import com.google.crypto.tink.proto.KeysetInfo;
import com.google.crypto.tink.proto.KeysetInfo.KeyInfo;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.subtle.Base64;
import com.google.protobuf.ByteString;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Path;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsonKeysetReader implements KeysetReader {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final InputStream inputStream;
    private final JSONObject json;
    private boolean urlSafeBase64 = false;

    private JsonKeysetReader(InputStream inputStream2) {
        this.inputStream = inputStream2;
        this.json = null;
    }

    private JsonKeysetReader(JSONObject jSONObject) {
        this.json = jSONObject;
        this.inputStream = null;
    }

    public static KeysetReader withInputStream(InputStream inputStream2) throws IOException {
        return new JsonKeysetReader(inputStream2);
    }

    public static JsonKeysetReader withJsonObject(JSONObject jSONObject) {
        return new JsonKeysetReader(jSONObject);
    }

    public static JsonKeysetReader withString(String str) {
        return new JsonKeysetReader((InputStream) new ByteArrayInputStream(str.getBytes(UTF_8)));
    }

    public static JsonKeysetReader withBytes(byte[] bArr) {
        return new JsonKeysetReader((InputStream) new ByteArrayInputStream(bArr));
    }

    public static JsonKeysetReader withFile(File file) throws IOException {
        return new JsonKeysetReader((InputStream) new FileInputStream(file));
    }

    public static JsonKeysetReader withPath(String str) throws IOException {
        return withFile(new File(str));
    }

    public static JsonKeysetReader withPath(Path path) throws IOException {
        return withFile(path.toFile());
    }

    public JsonKeysetReader withUrlSafeBase64() {
        this.urlSafeBase64 = true;
        return this;
    }

    public Keyset read() throws IOException {
        try {
            if (this.json != null) {
                return keysetFromJson(this.json);
            }
            return keysetFromJson(new JSONObject(new String(Util.readAll(this.inputStream), UTF_8)));
        } catch (JSONException e) {
            throw new IOException(e);
        }
    }

    public EncryptedKeyset readEncrypted() throws IOException {
        try {
            if (this.json != null) {
                return encryptedKeysetFromJson(this.json);
            }
            return encryptedKeysetFromJson(new JSONObject(new String(Util.readAll(this.inputStream), UTF_8)));
        } catch (JSONException e) {
            throw new IOException(e);
        }
    }

    private Keyset keysetFromJson(JSONObject jSONObject) throws JSONException {
        validateKeyset(jSONObject);
        Builder newBuilder = Keyset.newBuilder();
        String str = "primaryKeyId";
        if (jSONObject.has(str)) {
            newBuilder.setPrimaryKeyId(jSONObject.getInt(str));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("key");
        for (int i = 0; i < jSONArray.length(); i++) {
            newBuilder.addKey(keyFromJson(jSONArray.getJSONObject(i)));
        }
        return (Keyset) newBuilder.build();
    }

    private EncryptedKeyset encryptedKeysetFromJson(JSONObject jSONObject) throws JSONException {
        byte[] bArr;
        validateEncryptedKeyset(jSONObject);
        String str = "encryptedKeyset";
        if (this.urlSafeBase64) {
            bArr = Base64.urlSafeDecode(jSONObject.getString(str));
        } else {
            bArr = Base64.decode(jSONObject.getString(str));
        }
        return (EncryptedKeyset) EncryptedKeyset.newBuilder().setEncryptedKeyset(ByteString.copyFrom(bArr)).setKeysetInfo(keysetInfoFromJson(jSONObject.getJSONObject("keysetInfo"))).build();
    }

    private Key keyFromJson(JSONObject jSONObject) throws JSONException {
        validateKey(jSONObject);
        return (Key) Key.newBuilder().setStatus(getStatus(jSONObject.getString(NotificationCompat.CATEGORY_STATUS))).setKeyId(jSONObject.getInt("keyId")).setOutputPrefixType(getOutputPrefixType(jSONObject.getString("outputPrefixType"))).setKeyData(keyDataFromJson(jSONObject.getJSONObject("keyData"))).build();
    }

    private KeysetInfo keysetInfoFromJson(JSONObject jSONObject) throws JSONException {
        KeysetInfo.Builder newBuilder = KeysetInfo.newBuilder();
        String str = "primaryKeyId";
        if (jSONObject.has(str)) {
            newBuilder.setPrimaryKeyId(jSONObject.getInt(str));
        }
        String str2 = "keyInfo";
        if (jSONObject.has(str2)) {
            JSONArray jSONArray = jSONObject.getJSONArray(str2);
            for (int i = 0; i < jSONArray.length(); i++) {
                newBuilder.addKeyInfo(keyInfoFromJson(jSONArray.getJSONObject(i)));
            }
        }
        return (KeysetInfo) newBuilder.build();
    }

    private KeyInfo keyInfoFromJson(JSONObject jSONObject) throws JSONException {
        return (KeyInfo) KeyInfo.newBuilder().setStatus(getStatus(jSONObject.getString(NotificationCompat.CATEGORY_STATUS))).setKeyId(jSONObject.getInt("keyId")).setOutputPrefixType(getOutputPrefixType(jSONObject.getString("outputPrefixType"))).setTypeUrl(jSONObject.getString("typeUrl")).build();
    }

    private KeyData keyDataFromJson(JSONObject jSONObject) throws JSONException {
        byte[] bArr;
        validateKeyData(jSONObject);
        String str = "value";
        if (this.urlSafeBase64) {
            bArr = Base64.urlSafeDecode(jSONObject.getString(str));
        } else {
            bArr = Base64.decode(jSONObject.getString(str));
        }
        return (KeyData) KeyData.newBuilder().setTypeUrl(jSONObject.getString("typeUrl")).setValue(ByteString.copyFrom(bArr)).setKeyMaterialType(getKeyMaterialType(jSONObject.getString("keyMaterialType"))).build();
    }

    private KeyStatusType getStatus(String str) throws JSONException {
        if (str.equals("ENABLED")) {
            return KeyStatusType.ENABLED;
        }
        if (str.equals("DISABLED")) {
            return KeyStatusType.DISABLED;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("unknown status: ");
        sb.append(str);
        throw new JSONException(sb.toString());
    }

    private OutputPrefixType getOutputPrefixType(String str) throws JSONException {
        if (str.equals("TINK")) {
            return OutputPrefixType.TINK;
        }
        if (str.equals("RAW")) {
            return OutputPrefixType.RAW;
        }
        if (str.equals("LEGACY")) {
            return OutputPrefixType.LEGACY;
        }
        if (str.equals("CRUNCHY")) {
            return OutputPrefixType.CRUNCHY;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("unknown output prefix type: ");
        sb.append(str);
        throw new JSONException(sb.toString());
    }

    private KeyMaterialType getKeyMaterialType(String str) throws JSONException {
        if (str.equals("SYMMETRIC")) {
            return KeyMaterialType.SYMMETRIC;
        }
        if (str.equals("ASYMMETRIC_PRIVATE")) {
            return KeyMaterialType.ASYMMETRIC_PRIVATE;
        }
        if (str.equals("ASYMMETRIC_PUBLIC")) {
            return KeyMaterialType.ASYMMETRIC_PUBLIC;
        }
        if (str.equals("REMOTE")) {
            return KeyMaterialType.REMOTE;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("unknown key material type: ");
        sb.append(str);
        throw new JSONException(sb.toString());
    }

    private void validateKeyset(JSONObject jSONObject) throws JSONException {
        String str = "key";
        if (!jSONObject.has(str) || jSONObject.getJSONArray(str).length() == 0) {
            throw new JSONException("invalid keyset");
        }
    }

    private void validateEncryptedKeyset(JSONObject jSONObject) throws JSONException {
        if (!jSONObject.has("encryptedKeyset")) {
            throw new JSONException("invalid encrypted keyset");
        }
    }

    private void validateKey(JSONObject jSONObject) throws JSONException {
        if (!jSONObject.has("keyData") || !jSONObject.has(NotificationCompat.CATEGORY_STATUS) || !jSONObject.has("keyId") || !jSONObject.has("outputPrefixType")) {
            throw new JSONException("invalid key");
        }
    }

    private void validateKeyData(JSONObject jSONObject) throws JSONException {
        if (!jSONObject.has("typeUrl") || !jSONObject.has("value") || !jSONObject.has("keyMaterialType")) {
            throw new JSONException("invalid keyData");
        }
    }
}
