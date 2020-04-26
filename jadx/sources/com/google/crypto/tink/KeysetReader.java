package com.google.crypto.tink;

import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.Keyset;
import java.io.IOException;

public interface KeysetReader {
    Keyset read() throws IOException;

    EncryptedKeyset readEncrypted() throws IOException;
}
