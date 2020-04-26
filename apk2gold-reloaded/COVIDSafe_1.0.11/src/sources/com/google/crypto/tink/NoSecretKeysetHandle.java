package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyData.KeyMaterialType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.Keyset.Key;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import java.security.GeneralSecurityException;

public final class NoSecretKeysetHandle {
    @Deprecated
    public static final KeysetHandle parseFrom(byte[] bArr) throws GeneralSecurityException {
        try {
            Keyset parseFrom = Keyset.parseFrom(bArr);
            validate(parseFrom);
            return KeysetHandle.fromKeyset(parseFrom);
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }

    public static final KeysetHandle read(KeysetReader keysetReader) throws GeneralSecurityException, IOException {
        Keyset read = keysetReader.read();
        validate(read);
        return KeysetHandle.fromKeyset(read);
    }

    private static void validate(Keyset keyset) throws GeneralSecurityException {
        for (Key key : keyset.getKeyList()) {
            if (key.getKeyData().getKeyMaterialType() == KeyMaterialType.UNKNOWN_KEYMATERIAL || key.getKeyData().getKeyMaterialType() == KeyMaterialType.SYMMETRIC) {
                throw new GeneralSecurityException("keyset contains secret key material");
            } else if (key.getKeyData().getKeyMaterialType() == KeyMaterialType.ASYMMETRIC_PRIVATE) {
                throw new GeneralSecurityException("keyset contains secret key material");
            }
        }
    }
}
