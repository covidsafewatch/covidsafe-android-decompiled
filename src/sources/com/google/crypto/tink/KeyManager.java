package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.security.GeneralSecurityException;

public interface KeyManager<P> {
    boolean doesSupport(String str);

    String getKeyType();

    P getPrimitive(ByteString byteString) throws GeneralSecurityException;

    P getPrimitive(MessageLite messageLite) throws GeneralSecurityException;

    Class<P> getPrimitiveClass();

    int getVersion();

    MessageLite newKey(ByteString byteString) throws GeneralSecurityException;

    MessageLite newKey(MessageLite messageLite) throws GeneralSecurityException;

    KeyData newKeyData(ByteString byteString) throws GeneralSecurityException;
}
