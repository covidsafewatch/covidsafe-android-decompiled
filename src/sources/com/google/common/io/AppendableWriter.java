package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

class AppendableWriter extends Writer {
    private boolean closed;
    private final Appendable target;

    AppendableWriter(Appendable appendable) {
        this.target = (Appendable) Preconditions.checkNotNull(appendable);
    }

    public void write(char[] cArr, int i, int i2) throws IOException {
        checkNotClosed();
        this.target.append(new String(cArr, i, i2));
    }

    public void write(int i) throws IOException {
        checkNotClosed();
        this.target.append((char) i);
    }

    public void write(@NullableDecl String str) throws IOException {
        checkNotClosed();
        this.target.append(str);
    }

    public void write(@NullableDecl String str, int i, int i2) throws IOException {
        checkNotClosed();
        this.target.append(str, i, i2 + i);
    }

    public void flush() throws IOException {
        checkNotClosed();
        Appendable appendable = this.target;
        if (appendable instanceof Flushable) {
            ((Flushable) appendable).flush();
        }
    }

    public void close() throws IOException {
        this.closed = true;
        Appendable appendable = this.target;
        if (appendable instanceof Closeable) {
            ((Closeable) appendable).close();
        }
    }

    public Writer append(char c) throws IOException {
        checkNotClosed();
        this.target.append(c);
        return this;
    }

    public Writer append(@NullableDecl CharSequence charSequence) throws IOException {
        checkNotClosed();
        this.target.append(charSequence);
        return this;
    }

    public Writer append(@NullableDecl CharSequence charSequence, int i, int i2) throws IOException {
        checkNotClosed();
        this.target.append(charSequence, i, i2);
        return this;
    }

    private void checkNotClosed() throws IOException {
        if (this.closed) {
            throw new IOException("Cannot write to a closed writer.");
        }
    }
}
