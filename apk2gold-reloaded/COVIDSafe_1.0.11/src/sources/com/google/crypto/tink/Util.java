package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyData.KeyMaterialType;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.Keyset.Key;
import com.google.crypto.tink.proto.KeysetInfo;
import com.google.crypto.tink.proto.KeysetInfo.Builder;
import com.google.crypto.tink.proto.KeysetInfo.KeyInfo;
import com.google.crypto.tink.proto.OutputPrefixType;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

class Util {
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    Util() {
    }

    public static KeysetInfo getKeysetInfo(Keyset keyset) {
        Builder primaryKeyId = KeysetInfo.newBuilder().setPrimaryKeyId(keyset.getPrimaryKeyId());
        for (Key keyInfo : keyset.getKeyList()) {
            primaryKeyId.addKeyInfo(getKeyInfo(keyInfo));
        }
        return (KeysetInfo) primaryKeyId.build();
    }

    public static KeyInfo getKeyInfo(Key key) {
        return (KeyInfo) KeyInfo.newBuilder().setTypeUrl(key.getKeyData().getTypeUrl()).setStatus(key.getStatus()).setOutputPrefixType(key.getOutputPrefixType()).setKeyId(key.getKeyId()).build();
    }

    public static void validateKey(Key key) throws GeneralSecurityException {
        if (!key.hasKeyData()) {
            throw new GeneralSecurityException(String.format("key %d has no key data", new Object[]{Integer.valueOf(key.getKeyId())}));
        } else if (key.getOutputPrefixType() == OutputPrefixType.UNKNOWN_PREFIX) {
            throw new GeneralSecurityException(String.format("key %d has unknown prefix", new Object[]{Integer.valueOf(key.getKeyId())}));
        } else if (key.getStatus() == KeyStatusType.UNKNOWN_STATUS) {
            throw new GeneralSecurityException(String.format("key %d has unknown status", new Object[]{Integer.valueOf(key.getKeyId())}));
        }
    }

    public static void validateKeyset(Keyset keyset) throws GeneralSecurityException {
        if (keyset.getKeyCount() != 0) {
            int primaryKeyId = keyset.getPrimaryKeyId();
            boolean z = true;
            boolean z2 = false;
            for (Key key : keyset.getKeyList()) {
                validateKey(key);
                if (key.getStatus() == KeyStatusType.ENABLED && key.getKeyId() == primaryKeyId) {
                    if (!z2) {
                        z2 = true;
                    } else {
                        throw new GeneralSecurityException("keyset contains multiple primary keys");
                    }
                }
                if (key.getKeyData().getKeyMaterialType() != KeyMaterialType.ASYMMETRIC_PUBLIC) {
                    z = false;
                }
            }
            if (!z2 && !z) {
                throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
            }
            return;
        }
        throw new GeneralSecurityException("empty keyset");
    }

    public static byte[] readAll(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }
}
