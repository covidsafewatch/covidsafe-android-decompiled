package com.google.crypto.tink.subtle;

import com.google.crypto.tink.StreamingAead;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.security.GeneralSecurityException;

abstract class NonceBasedStreamingAead implements StreamingAead {
    public abstract int getCiphertextOffset();

    public abstract int getCiphertextOverhead();

    public abstract int getCiphertextSegmentSize();

    public abstract int getHeaderLength();

    public abstract int getPlaintextSegmentSize();

    public abstract StreamSegmentDecrypter newStreamSegmentDecrypter() throws GeneralSecurityException;

    public abstract StreamSegmentEncrypter newStreamSegmentEncrypter(byte[] bArr) throws GeneralSecurityException;

    NonceBasedStreamingAead() {
    }

    public WritableByteChannel newEncryptingChannel(WritableByteChannel writableByteChannel, byte[] bArr) throws GeneralSecurityException, IOException {
        return new StreamingAeadEncryptingChannel(this, writableByteChannel, bArr);
    }

    public ReadableByteChannel newDecryptingChannel(ReadableByteChannel readableByteChannel, byte[] bArr) throws GeneralSecurityException, IOException {
        return new StreamingAeadDecryptingChannel(this, readableByteChannel, bArr);
    }

    public SeekableByteChannel newSeekableDecryptingChannel(SeekableByteChannel seekableByteChannel, byte[] bArr) throws GeneralSecurityException, IOException {
        return new StreamingAeadSeekableDecryptingChannel(this, seekableByteChannel, bArr);
    }

    public OutputStream newEncryptingStream(OutputStream outputStream, byte[] bArr) throws GeneralSecurityException, IOException {
        return new StreamingAeadEncryptingStream(this, outputStream, bArr);
    }

    public InputStream newDecryptingStream(InputStream inputStream, byte[] bArr) throws GeneralSecurityException, IOException {
        return new StreamingAeadDecryptingStream(this, inputStream, bArr);
    }
}
