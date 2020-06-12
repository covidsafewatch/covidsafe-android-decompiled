package com.google.crypto.tink.integration.android;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.CleartextKeysetHandle;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.KeysetManager;
import com.google.crypto.tink.KeysetReader;
import com.google.crypto.tink.KeysetWriter;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.Hex;
import com.google.crypto.tink.subtle.Random;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

public final class AndroidKeysetManager {
    private static final String TAG = AndroidKeysetManager.class.getSimpleName();
    private final KeyTemplate keyTemplate;
    private KeysetManager keysetManager;
    private final Aead masterKey;
    private final KeysetReader reader;
    private final boolean useKeystore;
    private final KeysetWriter writer;

    /* synthetic */ AndroidKeysetManager(Builder builder, AnonymousClass1 r2) throws GeneralSecurityException, IOException {
        this(builder);
    }

    private AndroidKeysetManager(Builder builder) throws GeneralSecurityException, IOException {
        KeysetReader access$000 = builder.reader;
        this.reader = access$000;
        if (access$000 != null) {
            KeysetWriter access$100 = builder.writer;
            this.writer = access$100;
            if (access$100 == null) {
                throw new IllegalArgumentException("need to specify where to write the keyset to with Builder#withSharedPref");
            } else if (!builder.useKeystore || builder.masterKeyUri != null) {
                this.useKeystore = builder.useKeystore && verifyAndroidKeystore();
                if (shouldUseKeystore()) {
                    this.masterKey = AndroidKeystoreKmsClient.getOrGenerateNewAeadKey(builder.masterKeyUri);
                } else {
                    this.masterKey = null;
                }
                this.keyTemplate = builder.keyTemplate;
                this.keysetManager = readOrGenerateNewKeyset();
            } else {
                throw new IllegalArgumentException("need a master key URI, please set it with Builder#masterKeyUri");
            }
        } else {
            throw new IllegalArgumentException("need to specify where to read the keyset from with Builder#withSharedPref");
        }
    }

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

        @Deprecated
        public Builder withKeyTemplate(com.google.crypto.tink.proto.KeyTemplate keyTemplate2) {
            this.keyTemplate = KeyTemplate.create(keyTemplate2.getTypeUrl(), keyTemplate2.getValue().toByteArray(), AndroidKeysetManager.fromProto(keyTemplate2.getOutputPrefixType()));
            return this;
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
            return new AndroidKeysetManager(this, (AnonymousClass1) null);
        }
    }

    public synchronized KeysetHandle getKeysetHandle() throws GeneralSecurityException {
        return this.keysetManager.getKeysetHandle();
    }

    @Deprecated
    public synchronized AndroidKeysetManager rotate(com.google.crypto.tink.proto.KeyTemplate keyTemplate2) throws GeneralSecurityException {
        KeysetManager rotate = this.keysetManager.rotate(keyTemplate2);
        this.keysetManager = rotate;
        write(rotate);
        return this;
    }

    @Deprecated
    public synchronized AndroidKeysetManager add(com.google.crypto.tink.proto.KeyTemplate keyTemplate2) throws GeneralSecurityException {
        KeysetManager add = this.keysetManager.add(keyTemplate2);
        this.keysetManager = add;
        write(add);
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

    public synchronized boolean isUsingKeystore() {
        return shouldUseKeystore();
    }

    private KeysetManager readOrGenerateNewKeyset() throws GeneralSecurityException, IOException {
        try {
            return read();
        } catch (IOException e) {
            String str = TAG;
            Log.i(str, "cannot read keyset: " + e);
            if (this.keyTemplate != null) {
                KeysetManager add = KeysetManager.withEmptyKeyset().add(this.keyTemplate);
                KeysetManager primary = add.setPrimary(add.getKeysetHandle().getKeysetInfo().getKeyInfo(0).getKeyId());
                write(primary);
                return primary;
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
                Log.i(str, "cannot decrypt keyset: " + e);
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
        return this.useKeystore && isAtLeastM();
    }

    /* renamed from: com.google.crypto.tink.integration.android.AndroidKeysetManager$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.google.crypto.tink.proto.OutputPrefixType[] r0 = com.google.crypto.tink.proto.OutputPrefixType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType = r0
                com.google.crypto.tink.proto.OutputPrefixType r1 = com.google.crypto.tink.proto.OutputPrefixType.TINK     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.crypto.tink.proto.OutputPrefixType r1 = com.google.crypto.tink.proto.OutputPrefixType.LEGACY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.crypto.tink.proto.OutputPrefixType r1 = com.google.crypto.tink.proto.OutputPrefixType.RAW     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.crypto.tink.proto.OutputPrefixType r1 = com.google.crypto.tink.proto.OutputPrefixType.CRUNCHY     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.integration.android.AndroidKeysetManager.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public static KeyTemplate.OutputPrefixType fromProto(OutputPrefixType outputPrefixType) {
        int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[outputPrefixType.ordinal()];
        if (i == 1) {
            return KeyTemplate.OutputPrefixType.TINK;
        }
        if (i == 2) {
            return KeyTemplate.OutputPrefixType.LEGACY;
        }
        if (i == 3) {
            return KeyTemplate.OutputPrefixType.RAW;
        }
        if (i == 4) {
            return KeyTemplate.OutputPrefixType.CRUNCHY;
        }
        throw new IllegalArgumentException("Unknown output prefix type");
    }

    private static boolean isAtLeastM() {
        return Build.VERSION.SDK_INT >= 23;
    }

    private static boolean verifyAndroidKeystore() {
        if (!isAtLeastM()) {
            return false;
        }
        try {
            String str = AndroidKeystoreKmsClient.PREFIX + new String(Random.randBytes(16), Charset.forName("UTF-8"));
            Aead orGenerateNewAeadKey = AndroidKeystoreKmsClient.getOrGenerateNewAeadKey(str);
            byte[] bArr = new byte[0];
            if (orGenerateNewAeadKey.decrypt(orGenerateNewAeadKey.encrypt(new byte[0], bArr), bArr).length != 0) {
                Log.i(TAG, "cannot use Android Keystore: encryption/decryption of empty message and empty aad returns incorrect results");
                return false;
            }
            byte[] randBytes = Random.randBytes(10);
            byte[] bArr2 = new byte[0];
            if (!Hex.encode(orGenerateNewAeadKey.decrypt(orGenerateNewAeadKey.encrypt(randBytes, bArr2), bArr2)).equals(Hex.encode(randBytes))) {
                Log.i(TAG, "cannot use Android Keystore: encryption/decryption of non-empty message and empty aad returns incorrect results");
                return false;
            }
            byte[] randBytes2 = Random.randBytes(10);
            byte[] randBytes3 = Random.randBytes(10);
            if (!Hex.encode(orGenerateNewAeadKey.decrypt(orGenerateNewAeadKey.encrypt(randBytes2, randBytes3), randBytes3)).equals(Hex.encode(randBytes2))) {
                Log.i(TAG, "cannot use Android Keystore: encryption/decryption of non-empty message and non-empty aad returns incorrect results");
                return false;
            }
            AndroidKeystoreKmsClient.delete(str);
            return true;
        } catch (Exception e) {
            Log.i(TAG, "cannot use Android Keystore: " + e);
            return false;
        }
    }
}
