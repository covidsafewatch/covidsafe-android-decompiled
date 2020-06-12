package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import java.security.GeneralSecurityException;

public interface PrivateKeyManager<P> extends KeyManager<P> {
    KeyData getPublicKeyData(ByteString byteString) throws GeneralSecurityException;
}
