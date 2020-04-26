package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.StreamingAead;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.security.GeneralSecurityException;

final class StreamingAeadHelper implements StreamingAead {
    PrimitiveSet<StreamingAead> primitives;

    public StreamingAeadHelper(PrimitiveSet<StreamingAead> primitiveSet) throws GeneralSecurityException {
        if (primitiveSet.getPrimary() != null) {
            this.primitives = primitiveSet;
            return;
        }
        throw new GeneralSecurityException("Missing primary primitive.");
    }

    public WritableByteChannel newEncryptingChannel(WritableByteChannel writableByteChannel, byte[] bArr) throws GeneralSecurityException, IOException {
        return ((StreamingAead) this.primitives.getPrimary().getPrimitive()).newEncryptingChannel(writableByteChannel, bArr);
    }

    public ReadableByteChannel newDecryptingChannel(ReadableByteChannel readableByteChannel, byte[] bArr) throws GeneralSecurityException, IOException {
        return new ReadableByteChannelDecrypter(this.primitives, readableByteChannel, bArr);
    }

    public SeekableByteChannel newSeekableDecryptingChannel(SeekableByteChannel seekableByteChannel, byte[] bArr) throws GeneralSecurityException, IOException {
        return new SeekableByteChannelDecrypter(this.primitives, seekableByteChannel, bArr);
    }

    public InputStream newDecryptingStream(InputStream inputStream, byte[] bArr) throws GeneralSecurityException, IOException {
        return new InputStreamDecrypter(this.primitives, inputStream, bArr);
    }

    public OutputStream newEncryptingStream(OutputStream outputStream, byte[] bArr) throws GeneralSecurityException, IOException {
        return ((StreamingAead) this.primitives.getPrimary().getPrimitive()).newEncryptingStream(outputStream, bArr);
    }
}
