package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.KeysetInfo;
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
        KeysetInfo.Builder primaryKeyId = KeysetInfo.newBuilder().setPrimaryKeyId(keyset.getPrimaryKeyId());
        for (Keyset.Key keyInfo : keyset.getKeyList()) {
            primaryKeyId.addKeyInfo(getKeyInfo(keyInfo));
        }
        return (KeysetInfo) primaryKeyId.build();
    }

    public static KeysetInfo.KeyInfo getKeyInfo(Keyset.Key key) {
        return (KeysetInfo.KeyInfo) KeysetInfo.KeyInfo.newBuilder().setTypeUrl(key.getKeyData().getTypeUrl()).setStatus(key.getStatus()).setOutputPrefixType(key.getOutputPrefixType()).setKeyId(key.getKeyId()).build();
    }

    public static void validateKey(Keyset.Key key) throws GeneralSecurityException {
        if (!key.hasKeyData()) {
            throw new GeneralSecurityException(String.format("key %d has no key data", new Object[]{Integer.valueOf(key.getKeyId())}));
        } else if (key.getOutputPrefixType() == OutputPrefixType.UNKNOWN_PREFIX) {
            throw new GeneralSecurityException(String.format("key %d has unknown prefix", new Object[]{Integer.valueOf(key.getKeyId())}));
        } else if (key.getStatus() == KeyStatusType.UNKNOWN_STATUS) {
            throw new GeneralSecurityException(String.format("key %d has unknown status", new Object[]{Integer.valueOf(key.getKeyId())}));
        }
    }

    public static void validateKeyset(Keyset keyset) throws GeneralSecurityException {
        int primaryKeyId = keyset.getPrimaryKeyId();
        int i = 0;
        boolean z = false;
        boolean z2 = true;
        for (Keyset.Key next : keyset.getKeyList()) {
            if (next.getStatus() == KeyStatusType.ENABLED) {
                validateKey(next);
                if (next.getKeyId() == primaryKeyId) {
                    if (!z) {
                        z = true;
                    } else {
                        throw new GeneralSecurityException("keyset contains multiple primary keys");
                    }
                }
                if (next.getKeyData().getKeyMaterialType() != KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC) {
                    z2 = false;
                }
                i++;
            }
        }
        if (i == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        } else if (!z && !z2) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
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
