package com.google.crypto.tink;

import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import java.security.GeneralSecurityException;

@Deprecated
public final class NoSecretKeysetHandle {
    @Deprecated
    public static final KeysetHandle parseFrom(byte[] bArr) throws GeneralSecurityException {
        try {
            Keyset parseFrom = Keyset.parseFrom(bArr, ExtensionRegistryLite.getEmptyRegistry());
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

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void validate(com.google.crypto.tink.proto.Keyset r3) throws java.security.GeneralSecurityException {
        /*
            java.util.List r3 = r3.getKeyList()
            java.util.Iterator r3 = r3.iterator()
        L_0x0008:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x0041
            java.lang.Object r0 = r3.next()
            com.google.crypto.tink.proto.Keyset$Key r0 = (com.google.crypto.tink.proto.Keyset.Key) r0
            com.google.crypto.tink.proto.KeyData r1 = r0.getKeyData()
            com.google.crypto.tink.proto.KeyData$KeyMaterialType r1 = r1.getKeyMaterialType()
            com.google.crypto.tink.proto.KeyData$KeyMaterialType r2 = com.google.crypto.tink.proto.KeyData.KeyMaterialType.UNKNOWN_KEYMATERIAL
            if (r1 == r2) goto L_0x0039
            com.google.crypto.tink.proto.KeyData r1 = r0.getKeyData()
            com.google.crypto.tink.proto.KeyData$KeyMaterialType r1 = r1.getKeyMaterialType()
            com.google.crypto.tink.proto.KeyData$KeyMaterialType r2 = com.google.crypto.tink.proto.KeyData.KeyMaterialType.SYMMETRIC
            if (r1 == r2) goto L_0x0039
            com.google.crypto.tink.proto.KeyData r0 = r0.getKeyData()
            com.google.crypto.tink.proto.KeyData$KeyMaterialType r0 = r0.getKeyMaterialType()
            com.google.crypto.tink.proto.KeyData$KeyMaterialType r1 = com.google.crypto.tink.proto.KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE
            if (r0 == r1) goto L_0x0039
            goto L_0x0008
        L_0x0039:
            java.security.GeneralSecurityException r3 = new java.security.GeneralSecurityException
            java.lang.String r0 = "keyset contains secret key material"
            r3.<init>(r0)
            throw r3
        L_0x0041:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.NoSecretKeysetHandle.validate(com.google.crypto.tink.proto.Keyset):void");
    }
}
