package au.gov.health.covidsafe.security.crypto;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.ArraySet;
import android.util.Pair;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.aead.AesGcmKeyManager;
import com.google.crypto.tink.config.TinkConfig;
import com.google.crypto.tink.daead.AesSivKeyManager;
import com.google.crypto.tink.integration.android.AndroidKeysetManager;
import com.google.crypto.tink.integration.android.AndroidKeystoreKmsClient;
import com.google.crypto.tink.subtle.Base64;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public final class EncryptedSharedPreferences implements SharedPreferences {
    private static final String KEY_KEYSET_ALIAS = "__androidx_security_crypto_encrypted_prefs_key_keyset__";
    private static final String NULL_VALUE = "__NULL__";
    private static final String VALUE_KEYSET_ALIAS = "__androidx_security_crypto_encrypted_prefs_value_keyset__";
    final String mFileName;
    final DeterministicAead mKeyDeterministicAead;
    final List<SharedPreferences.OnSharedPreferenceChangeListener> mListeners = new ArrayList();
    final String mMasterKeyAlias;
    final SharedPreferences mSharedPreferences;
    final Aead mValueAead;

    EncryptedSharedPreferences(String str, String str2, SharedPreferences sharedPreferences, Aead aead, DeterministicAead deterministicAead) {
        this.mFileName = str;
        this.mSharedPreferences = sharedPreferences;
        this.mMasterKeyAlias = str2;
        this.mValueAead = aead;
        this.mKeyDeterministicAead = deterministicAead;
    }

    public static SharedPreferences create(String str, String str2, Context context, PrefKeyEncryptionScheme prefKeyEncryptionScheme, PrefValueEncryptionScheme prefValueEncryptionScheme) throws GeneralSecurityException, IOException {
        TinkConfig.register();
        AndroidKeysetManager.Builder withSharedPref = new AndroidKeysetManager.Builder().withKeyTemplate(prefKeyEncryptionScheme.getKeyTemplate()).withSharedPref(context, KEY_KEYSET_ALIAS, str);
        KeysetHandle keysetHandle = withSharedPref.withMasterKeyUri(AndroidKeystoreKmsClient.PREFIX + str2).build().getKeysetHandle();
        AndroidKeysetManager.Builder withSharedPref2 = new AndroidKeysetManager.Builder().withKeyTemplate(prefValueEncryptionScheme.getKeyTemplate()).withSharedPref(context, VALUE_KEYSET_ALIAS, str);
        Aead aead = (Aead) withSharedPref2.withMasterKeyUri(AndroidKeystoreKmsClient.PREFIX + str2).build().getKeysetHandle().getPrimitive(Aead.class);
        return new EncryptedSharedPreferences(str, str2, context.getSharedPreferences(str, 0), aead, (DeterministicAead) keysetHandle.getPrimitive(DeterministicAead.class));
    }

    public enum PrefKeyEncryptionScheme {
        AES256_SIV(AesSivKeyManager.aes256SivTemplate());
        
        private final KeyTemplate mDeterministicAeadKeyTemplate;

        private PrefKeyEncryptionScheme(KeyTemplate keyTemplate) {
            this.mDeterministicAeadKeyTemplate = keyTemplate;
        }

        /* access modifiers changed from: package-private */
        public KeyTemplate getKeyTemplate() {
            return this.mDeterministicAeadKeyTemplate;
        }
    }

    public enum PrefValueEncryptionScheme {
        AES256_GCM(AesGcmKeyManager.aes256GcmTemplate());
        
        private final KeyTemplate mAeadKeyTemplate;

        private PrefValueEncryptionScheme(KeyTemplate keyTemplate) {
            this.mAeadKeyTemplate = keyTemplate;
        }

        /* access modifiers changed from: package-private */
        public KeyTemplate getKeyTemplate() {
            return this.mAeadKeyTemplate;
        }
    }

    private static final class Editor implements SharedPreferences.Editor {
        private AtomicBoolean mClearRequested = new AtomicBoolean(false);
        private final SharedPreferences.Editor mEditor;
        private final EncryptedSharedPreferences mEncryptedSharedPreferences;
        private final List<String> mKeysChanged;

        Editor(EncryptedSharedPreferences encryptedSharedPreferences, SharedPreferences.Editor editor) {
            this.mEncryptedSharedPreferences = encryptedSharedPreferences;
            this.mEditor = editor;
            this.mKeysChanged = new CopyOnWriteArrayList();
        }

        public SharedPreferences.Editor putString(String str, String str2) {
            if (str2 == null) {
                str2 = EncryptedSharedPreferences.NULL_VALUE;
            }
            byte[] bytes = str2.getBytes(StandardCharsets.UTF_8);
            int length = bytes.length;
            ByteBuffer allocate = ByteBuffer.allocate(length + 8);
            allocate.putInt(EncryptedType.STRING.getId());
            allocate.putInt(length);
            allocate.put(bytes);
            putEncryptedObject(str, allocate.array());
            return this;
        }

        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            if (set == null) {
                set = new ArraySet<>();
                set.add(EncryptedSharedPreferences.NULL_VALUE);
            }
            ArrayList<byte[]> arrayList = new ArrayList<>(set.size());
            int size = set.size() * 4;
            for (String bytes : set) {
                byte[] bytes2 = bytes.getBytes(StandardCharsets.UTF_8);
                arrayList.add(bytes2);
                size += bytes2.length;
            }
            ByteBuffer allocate = ByteBuffer.allocate(size + 4);
            allocate.putInt(EncryptedType.STRING_SET.getId());
            for (byte[] bArr : arrayList) {
                allocate.putInt(bArr.length);
                allocate.put(bArr);
            }
            putEncryptedObject(str, allocate.array());
            return this;
        }

        public SharedPreferences.Editor putInt(String str, int i) {
            ByteBuffer allocate = ByteBuffer.allocate(8);
            allocate.putInt(EncryptedType.INT.getId());
            allocate.putInt(i);
            putEncryptedObject(str, allocate.array());
            return this;
        }

        public SharedPreferences.Editor putLong(String str, long j) {
            ByteBuffer allocate = ByteBuffer.allocate(12);
            allocate.putInt(EncryptedType.LONG.getId());
            allocate.putLong(j);
            putEncryptedObject(str, allocate.array());
            return this;
        }

        public SharedPreferences.Editor putFloat(String str, float f) {
            ByteBuffer allocate = ByteBuffer.allocate(8);
            allocate.putInt(EncryptedType.FLOAT.getId());
            allocate.putFloat(f);
            putEncryptedObject(str, allocate.array());
            return this;
        }

        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            ByteBuffer allocate = ByteBuffer.allocate(5);
            allocate.putInt(EncryptedType.BOOLEAN.getId());
            allocate.put(z ? (byte) 1 : 0);
            putEncryptedObject(str, allocate.array());
            return this;
        }

        public SharedPreferences.Editor remove(String str) {
            if (!this.mEncryptedSharedPreferences.isReservedKey(str)) {
                this.mEditor.remove(this.mEncryptedSharedPreferences.encryptKey(str));
                this.mKeysChanged.remove(str);
                return this;
            }
            throw new SecurityException(str + " is a reserved key for the encryption keyset.");
        }

        public SharedPreferences.Editor clear() {
            this.mClearRequested.set(true);
            return this;
        }

        public boolean commit() {
            clearKeysIfNeeded();
            try {
                return this.mEditor.commit();
            } finally {
                notifyListeners();
                this.mKeysChanged.clear();
            }
        }

        public void apply() {
            clearKeysIfNeeded();
            this.mEditor.apply();
            notifyListeners();
        }

        private void clearKeysIfNeeded() {
            if (this.mClearRequested.getAndSet(false)) {
                for (String next : this.mEncryptedSharedPreferences.getAll().keySet()) {
                    if (!this.mKeysChanged.contains(next) && !this.mEncryptedSharedPreferences.isReservedKey(next)) {
                        this.mEditor.remove(this.mEncryptedSharedPreferences.encryptKey(next));
                    }
                }
            }
        }

        private void putEncryptedObject(String str, byte[] bArr) {
            if (!this.mEncryptedSharedPreferences.isReservedKey(str)) {
                this.mKeysChanged.add(str);
                if (str == null) {
                    str = EncryptedSharedPreferences.NULL_VALUE;
                }
                try {
                    Pair<String, String> encryptKeyValuePair = this.mEncryptedSharedPreferences.encryptKeyValuePair(str, bArr);
                    this.mEditor.putString((String) encryptKeyValuePair.first, (String) encryptKeyValuePair.second);
                } catch (GeneralSecurityException e) {
                    throw new SecurityException("Could not encrypt data: " + e.getMessage(), e);
                }
            } else {
                throw new SecurityException(str + " is a reserved key for the encryption keyset.");
            }
        }

        private void notifyListeners() {
            for (SharedPreferences.OnSharedPreferenceChangeListener next : this.mEncryptedSharedPreferences.mListeners) {
                for (String onSharedPreferenceChanged : this.mKeysChanged) {
                    next.onSharedPreferenceChanged(this.mEncryptedSharedPreferences, onSharedPreferenceChanged);
                }
            }
        }
    }

    public Map<String, ?> getAll() {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.mSharedPreferences.getAll().entrySet()) {
            if (!isReservedKey((String) next.getKey())) {
                String decryptKey = decryptKey((String) next.getKey());
                hashMap.put(decryptKey, getDecryptedObject(decryptKey));
            }
        }
        return hashMap;
    }

    public String getString(String str, String str2) {
        Object decryptedObject = getDecryptedObject(str);
        return (decryptedObject == null || !(decryptedObject instanceof String)) ? str2 : (String) decryptedObject;
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        Set<String> set2;
        Object decryptedObject = getDecryptedObject(str);
        if (decryptedObject instanceof Set) {
            set2 = (Set) decryptedObject;
        } else {
            set2 = new ArraySet<>();
        }
        return set2.size() > 0 ? set2 : set;
    }

    public int getInt(String str, int i) {
        Object decryptedObject = getDecryptedObject(str);
        return (decryptedObject == null || !(decryptedObject instanceof Integer)) ? i : ((Integer) decryptedObject).intValue();
    }

    public long getLong(String str, long j) {
        Object decryptedObject = getDecryptedObject(str);
        return (decryptedObject == null || !(decryptedObject instanceof Long)) ? j : ((Long) decryptedObject).longValue();
    }

    public float getFloat(String str, float f) {
        Object decryptedObject = getDecryptedObject(str);
        return (decryptedObject == null || !(decryptedObject instanceof Float)) ? f : ((Float) decryptedObject).floatValue();
    }

    public boolean getBoolean(String str, boolean z) {
        Object decryptedObject = getDecryptedObject(str);
        return (decryptedObject == null || !(decryptedObject instanceof Boolean)) ? z : ((Boolean) decryptedObject).booleanValue();
    }

    public boolean contains(String str) {
        if (!isReservedKey(str)) {
            return this.mSharedPreferences.contains(encryptKey(str));
        }
        throw new SecurityException(str + " is a reserved key for the encryption keyset.");
    }

    public SharedPreferences.Editor edit() {
        return new Editor(this, this.mSharedPreferences.edit());
    }

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.mListeners.add(onSharedPreferenceChangeListener);
    }

    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.mListeners.remove(onSharedPreferenceChangeListener);
    }

    private enum EncryptedType {
        STRING(0),
        STRING_SET(1),
        INT(2),
        LONG(3),
        FLOAT(4),
        BOOLEAN(5);
        
        private final int mId;

        private EncryptedType(int i) {
            this.mId = i;
        }

        public int getId() {
            return this.mId;
        }

        public static EncryptedType fromId(int i) {
            if (i == 0) {
                return STRING;
            }
            if (i == 1) {
                return STRING_SET;
            }
            if (i == 2) {
                return INT;
            }
            if (i == 3) {
                return LONG;
            }
            if (i == 4) {
                return FLOAT;
            }
            if (i != 5) {
                return null;
            }
            return BOOLEAN;
        }
    }

    private Object getDecryptedObject(String str) {
        if (!isReservedKey(str)) {
            if (str == null) {
                str = NULL_VALUE;
            }
            try {
                String encryptKey = encryptKey(str);
                String string = this.mSharedPreferences.getString(encryptKey, (String) null);
                if (string == null) {
                    return null;
                }
                boolean z = false;
                ByteBuffer wrap = ByteBuffer.wrap(this.mValueAead.decrypt(Base64.decode(string, 0), encryptKey.getBytes(StandardCharsets.UTF_8)));
                wrap.position(0);
                switch (AnonymousClass1.$SwitchMap$au$gov$health$covidsafe$security$crypto$EncryptedSharedPreferences$EncryptedType[EncryptedType.fromId(wrap.getInt()).ordinal()]) {
                    case 1:
                        int i = wrap.getInt();
                        ByteBuffer slice = wrap.slice();
                        wrap.limit(i);
                        String charBuffer = StandardCharsets.UTF_8.decode(slice).toString();
                        if (charBuffer.equals(NULL_VALUE)) {
                            return null;
                        }
                        return charBuffer;
                    case 2:
                        return Integer.valueOf(wrap.getInt());
                    case 3:
                        return Long.valueOf(wrap.getLong());
                    case 4:
                        return Float.valueOf(wrap.getFloat());
                    case 5:
                        if (wrap.get() != 0) {
                            z = true;
                        }
                        return Boolean.valueOf(z);
                    case 6:
                        ArraySet arraySet = new ArraySet();
                        while (wrap.hasRemaining()) {
                            int i2 = wrap.getInt();
                            ByteBuffer slice2 = wrap.slice();
                            slice2.limit(i2);
                            wrap.position(wrap.position() + i2);
                            arraySet.add(StandardCharsets.UTF_8.decode(slice2).toString());
                        }
                        if (arraySet.size() != 1 || !NULL_VALUE.equals(arraySet.valueAt(0))) {
                            return arraySet;
                        }
                        return null;
                    default:
                        return null;
                }
            } catch (GeneralSecurityException e) {
                throw new SecurityException("Could not decrypt value. " + e.getMessage(), e);
            }
        } else {
            throw new SecurityException(str + " is a reserved key for the encryption keyset.");
        }
    }

    /* renamed from: au.gov.health.covidsafe.security.crypto.EncryptedSharedPreferences$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$au$gov$health$covidsafe$security$crypto$EncryptedSharedPreferences$EncryptedType;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                au.gov.health.covidsafe.security.crypto.EncryptedSharedPreferences$EncryptedType[] r0 = au.gov.health.covidsafe.security.crypto.EncryptedSharedPreferences.EncryptedType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$au$gov$health$covidsafe$security$crypto$EncryptedSharedPreferences$EncryptedType = r0
                au.gov.health.covidsafe.security.crypto.EncryptedSharedPreferences$EncryptedType r1 = au.gov.health.covidsafe.security.crypto.EncryptedSharedPreferences.EncryptedType.STRING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$au$gov$health$covidsafe$security$crypto$EncryptedSharedPreferences$EncryptedType     // Catch:{ NoSuchFieldError -> 0x001d }
                au.gov.health.covidsafe.security.crypto.EncryptedSharedPreferences$EncryptedType r1 = au.gov.health.covidsafe.security.crypto.EncryptedSharedPreferences.EncryptedType.INT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$au$gov$health$covidsafe$security$crypto$EncryptedSharedPreferences$EncryptedType     // Catch:{ NoSuchFieldError -> 0x0028 }
                au.gov.health.covidsafe.security.crypto.EncryptedSharedPreferences$EncryptedType r1 = au.gov.health.covidsafe.security.crypto.EncryptedSharedPreferences.EncryptedType.LONG     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$au$gov$health$covidsafe$security$crypto$EncryptedSharedPreferences$EncryptedType     // Catch:{ NoSuchFieldError -> 0x0033 }
                au.gov.health.covidsafe.security.crypto.EncryptedSharedPreferences$EncryptedType r1 = au.gov.health.covidsafe.security.crypto.EncryptedSharedPreferences.EncryptedType.FLOAT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$au$gov$health$covidsafe$security$crypto$EncryptedSharedPreferences$EncryptedType     // Catch:{ NoSuchFieldError -> 0x003e }
                au.gov.health.covidsafe.security.crypto.EncryptedSharedPreferences$EncryptedType r1 = au.gov.health.covidsafe.security.crypto.EncryptedSharedPreferences.EncryptedType.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$au$gov$health$covidsafe$security$crypto$EncryptedSharedPreferences$EncryptedType     // Catch:{ NoSuchFieldError -> 0x0049 }
                au.gov.health.covidsafe.security.crypto.EncryptedSharedPreferences$EncryptedType r1 = au.gov.health.covidsafe.security.crypto.EncryptedSharedPreferences.EncryptedType.STRING_SET     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: au.gov.health.covidsafe.security.crypto.EncryptedSharedPreferences.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: package-private */
    public String encryptKey(String str) {
        if (str == null) {
            str = NULL_VALUE;
        }
        try {
            return Base64.encode(this.mKeyDeterministicAead.encryptDeterministically(str.getBytes(StandardCharsets.UTF_8), this.mFileName.getBytes()));
        } catch (GeneralSecurityException e) {
            throw new SecurityException("Could not encrypt key. " + e.getMessage(), e);
        }
    }

    /* access modifiers changed from: package-private */
    public String decryptKey(String str) {
        try {
            String str2 = new String(this.mKeyDeterministicAead.decryptDeterministically(Base64.decode(str, 0), this.mFileName.getBytes()), StandardCharsets.UTF_8);
            if (str2.equals(NULL_VALUE)) {
                return null;
            }
            return str2;
        } catch (GeneralSecurityException e) {
            throw new SecurityException("Could not decrypt key. " + e.getMessage(), e);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isReservedKey(String str) {
        return KEY_KEYSET_ALIAS.equals(str) || VALUE_KEYSET_ALIAS.equals(str);
    }

    /* access modifiers changed from: package-private */
    public Pair<String, String> encryptKeyValuePair(String str, byte[] bArr) throws GeneralSecurityException {
        String encryptKey = encryptKey(str);
        return new Pair<>(encryptKey, Base64.encode(this.mValueAead.encrypt(bArr, encryptKey.getBytes(StandardCharsets.UTF_8))));
    }
}
