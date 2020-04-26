package com.google.crypto.tink;

import com.google.common.base.Ascii;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.Keyset.Builder;
import com.google.crypto.tink.proto.Keyset.Key;
import com.google.crypto.tink.proto.OutputPrefixType;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;

public final class KeysetManager {
    private final Builder keysetBuilder;

    private KeysetManager(Builder builder) {
        this.keysetBuilder = builder;
    }

    public static KeysetManager withKeysetHandle(KeysetHandle keysetHandle) {
        return new KeysetManager((Builder) keysetHandle.getKeyset().toBuilder());
    }

    public static KeysetManager withEmptyKeyset() {
        return new KeysetManager(Keyset.newBuilder());
    }

    public synchronized KeysetHandle getKeysetHandle() throws GeneralSecurityException {
        return KeysetHandle.fromKeyset((Keyset) this.keysetBuilder.build());
    }

    public synchronized KeysetManager rotate(KeyTemplate keyTemplate) throws GeneralSecurityException {
        Key newKey = newKey(keyTemplate);
        this.keysetBuilder.addKey(newKey).setPrimaryKeyId(newKey.getKeyId());
        return this;
    }

    public synchronized KeysetManager add(KeyTemplate keyTemplate) throws GeneralSecurityException {
        this.keysetBuilder.addKey(newKey(keyTemplate));
        return this;
    }

    public synchronized KeysetManager setPrimary(int i) throws GeneralSecurityException {
        int i2 = 0;
        while (i2 < this.keysetBuilder.getKeyCount()) {
            Key key = this.keysetBuilder.getKey(i2);
            if (key.getKeyId() != i) {
                i2++;
            } else if (key.getStatus().equals(KeyStatusType.ENABLED)) {
                this.keysetBuilder.setPrimaryKeyId(i);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("cannot set key as primary because it's not enabled: ");
                sb.append(i);
                throw new GeneralSecurityException(sb.toString());
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("key not found: ");
        sb2.append(i);
        throw new GeneralSecurityException(sb2.toString());
        return this;
    }

    @Deprecated
    public synchronized KeysetManager promote(int i) throws GeneralSecurityException {
        return setPrimary(i);
    }

    public synchronized KeysetManager enable(int i) throws GeneralSecurityException {
        int i2 = 0;
        while (i2 < this.keysetBuilder.getKeyCount()) {
            Key key = this.keysetBuilder.getKey(i2);
            if (key.getKeyId() == i) {
                if (key.getStatus() != KeyStatusType.ENABLED) {
                    if (key.getStatus() != KeyStatusType.DISABLED) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("cannot enable key with id ");
                        sb.append(i);
                        sb.append(" and status ");
                        sb.append(key.getStatus());
                        throw new GeneralSecurityException(sb.toString());
                    }
                }
                this.keysetBuilder.setKey(i2, (Key) ((Key.Builder) key.toBuilder()).setStatus(KeyStatusType.ENABLED).build());
            } else {
                i2++;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("key not found: ");
        sb2.append(i);
        throw new GeneralSecurityException(sb2.toString());
        return this;
    }

    public synchronized KeysetManager disable(int i) throws GeneralSecurityException {
        if (i != this.keysetBuilder.getPrimaryKeyId()) {
            int i2 = 0;
            while (i2 < this.keysetBuilder.getKeyCount()) {
                Key key = this.keysetBuilder.getKey(i2);
                if (key.getKeyId() == i) {
                    if (key.getStatus() != KeyStatusType.ENABLED) {
                        if (key.getStatus() != KeyStatusType.DISABLED) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("cannot disable key with id ");
                            sb.append(i);
                            sb.append(" and status ");
                            sb.append(key.getStatus());
                            throw new GeneralSecurityException(sb.toString());
                        }
                    }
                    this.keysetBuilder.setKey(i2, (Key) ((Key.Builder) key.toBuilder()).setStatus(KeyStatusType.DISABLED).build());
                } else {
                    i2++;
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("key not found: ");
            sb2.append(i);
            throw new GeneralSecurityException(sb2.toString());
        }
        throw new GeneralSecurityException("cannot disable the primary key");
        return this;
    }

    public synchronized KeysetManager delete(int i) throws GeneralSecurityException {
        if (i != this.keysetBuilder.getPrimaryKeyId()) {
            int i2 = 0;
            while (i2 < this.keysetBuilder.getKeyCount()) {
                if (this.keysetBuilder.getKey(i2).getKeyId() == i) {
                    this.keysetBuilder.removeKey(i2);
                } else {
                    i2++;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("key not found: ");
            sb.append(i);
            throw new GeneralSecurityException(sb.toString());
        }
        throw new GeneralSecurityException("cannot delete the primary key");
        return this;
    }

    public synchronized KeysetManager destroy(int i) throws GeneralSecurityException {
        if (i != this.keysetBuilder.getPrimaryKeyId()) {
            int i2 = 0;
            while (i2 < this.keysetBuilder.getKeyCount()) {
                Key key = this.keysetBuilder.getKey(i2);
                if (key.getKeyId() == i) {
                    if (!(key.getStatus() == KeyStatusType.ENABLED || key.getStatus() == KeyStatusType.DISABLED)) {
                        if (key.getStatus() != KeyStatusType.DESTROYED) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("cannot destroy key with id ");
                            sb.append(i);
                            sb.append(" and status ");
                            sb.append(key.getStatus());
                            throw new GeneralSecurityException(sb.toString());
                        }
                    }
                    this.keysetBuilder.setKey(i2, (Key) ((Key.Builder) key.toBuilder()).setStatus(KeyStatusType.DESTROYED).clearKeyData().build());
                } else {
                    i2++;
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("key not found: ");
            sb2.append(i);
            throw new GeneralSecurityException(sb2.toString());
        }
        throw new GeneralSecurityException("cannot destroy the primary key");
        return this;
    }

    private synchronized Key newKey(KeyTemplate keyTemplate) throws GeneralSecurityException {
        KeyData newKeyData;
        int newKeyId;
        OutputPrefixType outputPrefixType;
        newKeyData = Registry.newKeyData(keyTemplate);
        newKeyId = newKeyId();
        outputPrefixType = keyTemplate.getOutputPrefixType();
        if (outputPrefixType == OutputPrefixType.UNKNOWN_PREFIX) {
            outputPrefixType = OutputPrefixType.TINK;
        }
        return (Key) Key.newBuilder().setKeyData(newKeyData).setKeyId(newKeyId).setStatus(KeyStatusType.ENABLED).setOutputPrefixType(outputPrefixType).build();
    }

    private synchronized int newKeyId() {
        int randPositiveInt;
        randPositiveInt = randPositiveInt();
        for (Key keyId : this.keysetBuilder.getKeyList()) {
            if (keyId.getKeyId() == randPositiveInt) {
                randPositiveInt = randPositiveInt();
            }
        }
        return randPositiveInt;
    }

    private static int randPositiveInt() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bArr = new byte[4];
        byte b = 0;
        while (b == 0) {
            secureRandom.nextBytes(bArr);
            b = ((bArr[0] & Byte.MAX_VALUE) << Ascii.CAN) | ((bArr[1] & 255) << Ascii.DLE) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        }
        return b;
    }
}
