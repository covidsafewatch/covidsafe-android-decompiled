package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

public abstract class ByteSink {

    private final class AsCharSink extends CharSink {
        private final Charset charset;

        private AsCharSink(Charset charset2) {
            this.charset = (Charset) Preconditions.checkNotNull(charset2);
        }

        public Writer openStream() throws IOException {
            return new OutputStreamWriter(ByteSink.this.openStream(), this.charset);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(ByteSink.this.toString());
            sb.append(".asCharSink(");
            sb.append(this.charset);
            sb.append(")");
            return sb.toString();
        }
    }

    public abstract OutputStream openStream() throws IOException;

    protected ByteSink() {
    }

    public CharSink asCharSink(Charset charset) {
        return new AsCharSink(charset);
    }

    public OutputStream openBufferedStream() throws IOException {
        OutputStream openStream = openStream();
        return openStream instanceof BufferedOutputStream ? (BufferedOutputStream) openStream : new BufferedOutputStream(openStream);
    }

    public void write(byte[] bArr) throws IOException {
        Preconditions.checkNotNull(bArr);
        Closer create = Closer.create();
        try {
            OutputStream outputStream = (OutputStream) create.register(openStream());
            outputStream.write(bArr);
            outputStream.flush();
            create.close();
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    public long writeFrom(InputStream inputStream) throws IOException {
        Preconditions.checkNotNull(inputStream);
        Closer create = Closer.create();
        try {
            OutputStream outputStream = (OutputStream) create.register(openStream());
            long copy = ByteStreams.copy(inputStream, outputStream);
            outputStream.flush();
            create.close();
            return copy;
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }
}
