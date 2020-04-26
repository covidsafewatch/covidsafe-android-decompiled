package com.google.crypto.tink.integration.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.crypto.tink.KeysetReader;
import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.subtle.Hex;
import java.io.IOException;

public final class SharedPrefKeysetReader implements KeysetReader {
    private final String keysetName;
    private final SharedPreferences sharedPreferences;

    public SharedPrefKeysetReader(Context context, String str, String str2) throws IOException {
        if (str != null) {
            this.keysetName = str;
            Context applicationContext = context.getApplicationContext();
            if (str2 == null) {
                this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
            } else {
                this.sharedPreferences = applicationContext.getSharedPreferences(str2, 0);
            }
        } else {
            throw new IllegalArgumentException("keysetName cannot be null");
        }
    }

    private byte[] readPref() throws IOException {
        try {
            String string = this.sharedPreferences.getString(this.keysetName, null);
            if (string != null) {
                return Hex.decode(string);
            }
            throw new IOException(String.format("can't read keyset; the pref value %s does not exist", new Object[]{this.keysetName}));
        } catch (ClassCastException | IllegalArgumentException e) {
            throw new IOException(String.format("can't read keyset; the pref value %s is not a valid hex string", new Object[]{this.keysetName}), e);
        }
    }

    public Keyset read() throws IOException {
        return Keyset.parseFrom(readPref());
    }

    public EncryptedKeyset readEncrypted() throws IOException {
        return EncryptedKeyset.parseFrom(readPref());
    }
}
