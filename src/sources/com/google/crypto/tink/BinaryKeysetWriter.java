package com.google.crypto.tink;

import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.Keyset;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class BinaryKeysetWriter implements KeysetWriter {
    private final OutputStream outputStream;

    private BinaryKeysetWriter(OutputStream outputStream2) {
        this.outputStream = outputStream2;
    }

    public static KeysetWriter withOutputStream(OutputStream outputStream2) {
        return new BinaryKeysetWriter(outputStream2);
    }

    public static KeysetWriter withFile(File file) throws IOException {
        return new BinaryKeysetWriter(new FileOutputStream(file));
    }

    public void write(Keyset keyset) throws IOException {
        this.outputStream.write(keyset.toByteArray());
    }

    public void write(EncryptedKeyset encryptedKeyset) throws IOException {
        this.outputStream.write(encryptedKeyset.toByteArray());
    }
}
