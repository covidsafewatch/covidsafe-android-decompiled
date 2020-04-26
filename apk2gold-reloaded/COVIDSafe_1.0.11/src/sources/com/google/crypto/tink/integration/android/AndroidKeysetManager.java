package com.google.crypto.tink.integration.android;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.Log;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.CleartextKeysetHandle;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.KeysetManager;
import com.google.crypto.tink.KeysetReader;
import com.google.crypto.tink.KeysetWriter;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import java.security.GeneralSecurityException;

public final class AndroidKeysetManager {
    private static final String TAG = AndroidKeysetManager.class.getName();
    private final KeyTemplate keyTemplate;
    private KeysetManager keysetManager;
    private final Aead masterKey;
    private final KeysetReader reader;
    private final boolean useKeystore;
    private final KeysetWriter writer;

    public static final class Builder {
        /* access modifiers changed from: private */
        public KeyTemplate keyTemplate = null;
        /* access modifiers changed from: private */
        public String masterKeyUri = null;
        /* access modifiers changed from: private */
        public KeysetReader reader = null;
        /* access modifiers changed from: private */
        public boolean useKeystore = true;
        /* access modifiers changed from: private */
        public KeysetWriter writer = null;

        public Builder withSharedPref(Context context, String str, String str2) throws IOException {
            if (context == null) {
                throw new IllegalArgumentException("need an Android context");
            } else if (str != null) {
                this.reader = new SharedPrefKeysetReader(context, str, str2);
                this.writer = new SharedPrefKeysetWriter(context, str, str2);
                return this;
            } else {
                throw new IllegalArgumentException("need a keyset name");
            }
        }

        public Builder withMasterKeyUri(String str) {
            if (str.startsWith(AndroidKeystoreKmsClient.PREFIX)) {
                this.masterKeyUri = str;
                return this;
            }
            throw new IllegalArgumentException("key URI must start with android-keystore://");
        }

        public Builder withKeyTemplate(KeyTemplate keyTemplate2) {
            this.keyTemplate = keyTemplate2;
            return this;
        }

        public Builder doNotUseKeystore() {
            this.useKeystore = false;
            return this;
        }

        public AndroidKeysetManager build() throws GeneralSecurityException, IOException {
            return new AndroidKeysetManager(this);
        }
    }

    private AndroidKeysetManager(Builder builder) throws GeneralSecurityException, IOException {
        KeysetReader access$000 = builder.reader;
        this.reader = access$000;
        if (access$000 != null) {
            KeysetWriter access$100 = builder.writer;
            this.writer = access$100;
            if (access$100 != null) {
                boolean access$200 = builder.useKeystore;
                this.useKeystore = access$200;
                if (!access$200 || builder.masterKeyUri != null) {
                    if (shouldUseKeystore()) {
                        this.masterKey = AndroidKeystoreKmsClient.getOrGenerateNewAeadKey(builder.masterKeyUri);
                    } else {
                        this.masterKey = null;
                    }
                    this.keyTemplate = builder.keyTemplate;
                    this.keysetManager = readOrGenerateNewKeyset();
                    return;
                }
                throw new IllegalArgumentException("need a master key URI, please set it with Builder#masterKeyUri");
            }
            throw new IllegalArgumentException("need to specify where to write the keyset to with Builder#withSharedPref");
        }
        throw new IllegalArgumentException("need to specify where to read the keyset from with Builder#withSharedPref");
    }

    public synchronized KeysetHandle getKeysetHandle() throws GeneralSecurityException {
        return this.keysetManager.getKeysetHandle();
    }

    public synchronized AndroidKeysetManager rotate(KeyTemplate keyTemplate2) throws GeneralSecurityException {
        KeysetManager rotate = this.keysetManager.rotate(keyTemplate2);
        this.keysetManager = rotate;
        write(rotate);
        return this;
    }

    public synchronized AndroidKeysetManager add(KeyTemplate keyTemplate2) throws GeneralSecurityException {
        KeysetManager add = this.keysetManager.add(keyTemplate2);
        this.keysetManager = add;
        write(add);
        return this;
    }

    public synchronized AndroidKeysetManager setPrimary(int i) throws GeneralSecurityException {
        KeysetManager primary = this.keysetManager.setPrimary(i);
        this.keysetManager = primary;
        write(primary);
        return this;
    }

    @Deprecated
    public synchronized AndroidKeysetManager promote(int i) throws GeneralSecurityException {
        return setPrimary(i);
    }

    public synchronized AndroidKeysetManager enable(int i) throws GeneralSecurityException {
        KeysetManager enable = this.keysetManager.enable(i);
        this.keysetManager = enable;
        write(enable);
        return this;
    }

    public synchronized AndroidKeysetManager disable(int i) throws GeneralSecurityException {
        KeysetManager disable = this.keysetManager.disable(i);
        this.keysetManager = disable;
        write(disable);
        return this;
    }

    public synchronized AndroidKeysetManager delete(int i) throws GeneralSecurityException {
        KeysetManager delete = this.keysetManager.delete(i);
        this.keysetManager = delete;
        write(delete);
        return this;
    }

    public synchronized AndroidKeysetManager destroy(int i) throws GeneralSecurityException {
        KeysetManager destroy = this.keysetManager.destroy(i);
        this.keysetManager = destroy;
        write(destroy);
        return this;
    }

    private KeysetManager readOrGenerateNewKeyset() throws GeneralSecurityException, IOException {
        try {
            return read();
        } catch (IOException e) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("cannot read keyset: ");
            sb.append(e.toString());
            Log.i(str, sb.toString());
            if (this.keyTemplate != null) {
                KeysetManager rotate = KeysetManager.withEmptyKeyset().rotate(this.keyTemplate);
                write(rotate);
                return rotate;
            }
            throw new GeneralSecurityException("cannot obtain keyset handle");
        }
    }

    private KeysetManager read() throws GeneralSecurityException, IOException {
        if (shouldUseKeystore()) {
            try {
                return KeysetManager.withKeysetHandle(KeysetHandle.read(this.reader, this.masterKey));
            } catch (InvalidProtocolBufferException | GeneralSecurityException e) {
                String str = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("cannot decrypt keyset: ");
                sb.append(e.toString());
                Log.i(str, sb.toString());
            }
        }
        KeysetHandle read = CleartextKeysetHandle.read(this.reader);
        if (shouldUseKeystore()) {
            read.write(this.writer, this.masterKey);
        }
        return KeysetManager.withKeysetHandle(read);
    }

    private void write(KeysetManager keysetManager2) throws GeneralSecurityException {
        try {
            if (shouldUseKeystore()) {
                keysetManager2.getKeysetHandle().write(this.writer, this.masterKey);
            } else {
                CleartextKeysetHandle.write(keysetManager2.getKeysetHandle(), this.writer);
            }
        } catch (IOException e) {
            throw new GeneralSecurityException(e);
        }
    }

    private boolean shouldUseKeystore() {
        return this.useKeystore && VERSION.SDK_INT >= 23;
    }
}
