package com.google.crypto.tink.integration.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.crypto.tink.KeysetWriter;
import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.subtle.Hex;
import java.io.IOException;

public final class SharedPrefKeysetWriter implements KeysetWriter {
    private final SharedPreferences.Editor editor;
    private final String keysetName;

    public SharedPrefKeysetWriter(Context context, String str, String str2) {
        if (str != null) {
            this.keysetName = str;
            Context applicationContext = context.getApplicationContext();
            if (str2 == null) {
                this.editor = PreferenceManager.getDefaultSharedPreferences(applicationContext).edit();
            } else {
                this.editor = applicationContext.getSharedPreferences(str2, 0).edit();
            }
        } else {
            throw new IllegalArgumentException("keysetName cannot be null");
        }
    }

    public void write(Keyset keyset) throws IOException {
        if (!this.editor.putString(this.keysetName, Hex.encode(keyset.toByteArray())).commit()) {
            throw new IOException("Failed to write to SharedPreferences");
        }
    }

    public void write(EncryptedKeyset encryptedKeyset) throws IOException {
        if (!this.editor.putString(this.keysetName, Hex.encode(encryptedKeyset.toByteArray())).commit()) {
            throw new IOException("Failed to write to SharedPreferences");
        }
    }
}
