package com.google.crypto.tink;

import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.Keyset;
import java.io.IOException;

public interface KeysetWriter {
    void write(EncryptedKeyset encryptedKeyset) throws IOException;

    void write(Keyset keyset) throws IOException;
}
