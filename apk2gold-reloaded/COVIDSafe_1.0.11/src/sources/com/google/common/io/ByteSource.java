package com.google.common.io;

import com.google.common.base.Ascii;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.hash.Funnels;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.LongCompanionObject;

public abstract class ByteSource {

    class AsCharSource extends CharSource {
        final Charset charset;

        AsCharSource(Charset charset2) {
            this.charset = (Charset) Preconditions.checkNotNull(charset2);
        }

        public ByteSource asByteSource(Charset charset2) {
            if (charset2.equals(this.charset)) {
                return ByteSource.this;
            }
            return super.asByteSource(charset2);
        }

        public Reader openStream() throws IOException {
            return new InputStreamReader(ByteSource.this.openStream(), this.charset);
        }

        public String read() throws IOException {
            return new String(ByteSource.this.read(), this.charset);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(ByteSource.this.toString());
            sb.append(".asCharSource(");
            sb.append(this.charset);
            sb.append(")");
            return sb.toString();
        }
    }

    private static class ByteArrayByteSource extends ByteSource {
        final byte[] bytes;
        final int length;
        final int offset;

        ByteArrayByteSource(byte[] bArr) {
            this(bArr, 0, bArr.length);
        }

        ByteArrayByteSource(byte[] bArr, int i, int i2) {
            this.bytes = bArr;
            this.offset = i;
            this.length = i2;
        }

        public InputStream openStream() {
            return new ByteArrayInputStream(this.bytes, this.offset, this.length);
        }

        public InputStream openBufferedStream() throws IOException {
            return openStream();
        }

        public boolean isEmpty() {
            return this.length == 0;
        }

        public long size() {
            return (long) this.length;
        }

        public Optional<Long> sizeIfKnown() {
            return Optional.of(Long.valueOf((long) this.length));
        }

        public byte[] read() {
            byte[] bArr = this.bytes;
            int i = this.offset;
            return Arrays.copyOfRange(bArr, i, this.length + i);
        }

        public <T> T read(ByteProcessor<T> byteProcessor) throws IOException {
            byteProcessor.processBytes(this.bytes, this.offset, this.length);
            return byteProcessor.getResult();
        }

        public long copyTo(OutputStream outputStream) throws IOException {
            outputStream.write(this.bytes, this.offset, this.length);
            return (long) this.length;
        }

        public HashCode hash(HashFunction hashFunction) throws IOException {
            return hashFunction.hashBytes(this.bytes, this.offset, this.length);
        }

        public ByteSource slice(long j, long j2) {
            boolean z = true;
            Preconditions.checkArgument(j >= 0, "offset (%s) may not be negative", j);
            if (j2 < 0) {
                z = false;
            }
            Preconditions.checkArgument(z, "length (%s) may not be negative", j2);
            long min = Math.min(j, (long) this.length);
            return new ByteArrayByteSource(this.bytes, this.offset + ((int) min), (int) Math.min(j2, ((long) this.length) - min));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ByteSource.wrap(");
            sb.append(Ascii.truncate(BaseEncoding.base16().encode(this.bytes, this.offset, this.length), 30, "..."));
            sb.append(")");
            return sb.toString();
        }
    }

    private static final class ConcatenatedByteSource extends ByteSource {
        final Iterable<? extends ByteSource> sources;

        ConcatenatedByteSource(Iterable<? extends ByteSource> iterable) {
            this.sources = (Iterable) Preconditions.checkNotNull(iterable);
        }

        public InputStream openStream() throws IOException {
            return new MultiInputStream(this.sources.iterator());
        }

        public boolean isEmpty() throws IOException {
            for (ByteSource isEmpty : this.sources) {
                if (!isEmpty.isEmpty()) {
                    return false;
                }
            }
            return true;
        }

        public Optional<Long> sizeIfKnown() {
            Iterable<? extends ByteSource> iterable = this.sources;
            if (!(iterable instanceof Collection)) {
                return Optional.absent();
            }
            long j = 0;
            for (ByteSource sizeIfKnown : iterable) {
                Optional sizeIfKnown2 = sizeIfKnown.sizeIfKnown();
                if (!sizeIfKnown2.isPresent()) {
                    return Optional.absent();
                }
                j += ((Long) sizeIfKnown2.get()).longValue();
                if (j < 0) {
                    return Optional.of(Long.valueOf(LongCompanionObject.MAX_VALUE));
                }
            }
            return Optional.of(Long.valueOf(j));
        }

        public long size() throws IOException {
            long j = 0;
            for (ByteSource size : this.sources) {
                j += size.size();
                if (j < 0) {
                    return LongCompanionObject.MAX_VALUE;
                }
            }
            return j;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ByteSource.concat(");
            sb.append(this.sources);
            sb.append(")");
            return sb.toString();
        }
    }

    private static final class EmptyByteSource extends ByteArrayByteSource {
        static final EmptyByteSource INSTANCE = new EmptyByteSource();

        public String toString() {
            return "ByteSource.empty()";
        }

        EmptyByteSource() {
            super(new byte[0]);
        }

        public CharSource asCharSource(Charset charset) {
            Preconditions.checkNotNull(charset);
            return CharSource.empty();
        }

        public byte[] read() {
            return this.bytes;
        }
    }

    private final class SlicedByteSource extends ByteSource {
        final long length;
        final long offset;

        SlicedByteSource(long j, long j2) {
            boolean z = true;
            Preconditions.checkArgument(j >= 0, "offset (%s) may not be negative", j);
            if (j2 < 0) {
                z = false;
            }
            Preconditions.checkArgument(z, "length (%s) may not be negative", j2);
            this.offset = j;
            this.length = j2;
        }

        public InputStream openStream() throws IOException {
            return sliceStream(ByteSource.this.openStream());
        }

        public InputStream openBufferedStream() throws IOException {
            return sliceStream(ByteSource.this.openBufferedStream());
        }

        private InputStream sliceStream(InputStream inputStream) throws IOException {
            Closer create;
            long j = this.offset;
            if (j > 0) {
                try {
                    if (ByteStreams.skipUpTo(inputStream, j) < this.offset) {
                        inputStream.close();
                        return new ByteArrayInputStream(new byte[0]);
                    }
                } catch (Throwable th) {
                    create.close();
                    throw th;
                }
            }
            return ByteStreams.limit(inputStream, this.length);
        }

        public ByteSource slice(long j, long j2) {
            boolean z = true;
            Preconditions.checkArgument(j >= 0, "offset (%s) may not be negative", j);
            if (j2 < 0) {
                z = false;
            }
            Preconditions.checkArgument(z, "length (%s) may not be negative", j2);
            return ByteSource.this.slice(this.offset + j, Math.min(j2, this.length - j));
        }

        public boolean isEmpty() throws IOException {
            return this.length == 0 || ByteSource.super.isEmpty();
        }

        public Optional<Long> sizeIfKnown() {
            Optional sizeIfKnown = ByteSource.this.sizeIfKnown();
            if (!sizeIfKnown.isPresent()) {
                return Optional.absent();
            }
            long longValue = ((Long) sizeIfKnown.get()).longValue();
            return Optional.of(Long.valueOf(Math.min(this.length, longValue - Math.min(this.offset, longValue))));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(ByteSource.this.toString());
            sb.append(".slice(");
            sb.append(this.offset);
            sb.append(", ");
            sb.append(this.length);
            sb.append(")");
            return sb.toString();
        }
    }

    public abstract InputStream openStream() throws IOException;

    protected ByteSource() {
    }

    public CharSource asCharSource(Charset charset) {
        return new AsCharSource(charset);
    }

    public InputStream openBufferedStream() throws IOException {
        InputStream openStream = openStream();
        return openStream instanceof BufferedInputStream ? (BufferedInputStream) openStream : new BufferedInputStream(openStream);
    }

    public ByteSource slice(long j, long j2) {
        SlicedByteSource slicedByteSource = new SlicedByteSource(j, j2);
        return slicedByteSource;
    }

    public boolean isEmpty() throws IOException {
        Optional sizeIfKnown = sizeIfKnown();
        boolean z = true;
        if (sizeIfKnown.isPresent()) {
            if (((Long) sizeIfKnown.get()).longValue() != 0) {
                z = false;
            }
            return z;
        }
        Closer create = Closer.create();
        try {
            if (((InputStream) create.register(openStream())).read() != -1) {
                z = false;
            }
            create.close();
            return z;
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    public Optional<Long> sizeIfKnown() {
        return Optional.absent();
    }

    public long size() throws IOException {
        Closer create;
        Optional sizeIfKnown = sizeIfKnown();
        if (sizeIfKnown.isPresent()) {
            return ((Long) sizeIfKnown.get()).longValue();
        }
        Closer create2 = Closer.create();
        try {
            long countBySkipping = countBySkipping((InputStream) create2.register(openStream()));
            create2.close();
            return countBySkipping;
        } catch (IOException unused) {
            create2.close();
            create = Closer.create();
            long exhaust = ByteStreams.exhaust((InputStream) create.register(openStream()));
            create.close();
            return exhaust;
        } catch (Throwable th) {
            try {
                throw create.rethrow(th);
            } catch (Throwable th2) {
                create.close();
                throw th2;
            }
        }
    }

    private long countBySkipping(InputStream inputStream) throws IOException {
        long j = 0;
        while (true) {
            long skipUpTo = ByteStreams.skipUpTo(inputStream, 2147483647L);
            if (skipUpTo <= 0) {
                return j;
            }
            j += skipUpTo;
        }
    }

    public long copyTo(OutputStream outputStream) throws IOException {
        Preconditions.checkNotNull(outputStream);
        Closer create = Closer.create();
        try {
            long copy = ByteStreams.copy((InputStream) create.register(openStream()), outputStream);
            create.close();
            return copy;
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    public long copyTo(ByteSink byteSink) throws IOException {
        Preconditions.checkNotNull(byteSink);
        Closer create = Closer.create();
        try {
            long copy = ByteStreams.copy((InputStream) create.register(openStream()), (OutputStream) create.register(byteSink.openStream()));
            create.close();
            return copy;
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    public byte[] read() throws IOException {
        byte[] bArr;
        Closer create = Closer.create();
        try {
            InputStream inputStream = (InputStream) create.register(openStream());
            Optional sizeIfKnown = sizeIfKnown();
            if (sizeIfKnown.isPresent()) {
                bArr = ByteStreams.toByteArray(inputStream, ((Long) sizeIfKnown.get()).longValue());
            } else {
                bArr = ByteStreams.toByteArray(inputStream);
            }
            create.close();
            return bArr;
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    public <T> T read(ByteProcessor<T> byteProcessor) throws IOException {
        Preconditions.checkNotNull(byteProcessor);
        Closer create = Closer.create();
        try {
            T readBytes = ByteStreams.readBytes((InputStream) create.register(openStream()), byteProcessor);
            create.close();
            return readBytes;
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    public HashCode hash(HashFunction hashFunction) throws IOException {
        Hasher newHasher = hashFunction.newHasher();
        copyTo(Funnels.asOutputStream(newHasher));
        return newHasher.hash();
    }

    public boolean contentEquals(ByteSource byteSource) throws IOException {
        int read;
        Preconditions.checkNotNull(byteSource);
        byte[] createBuffer = ByteStreams.createBuffer();
        byte[] createBuffer2 = ByteStreams.createBuffer();
        Closer create = Closer.create();
        try {
            InputStream inputStream = (InputStream) create.register(openStream());
            InputStream inputStream2 = (InputStream) create.register(byteSource.openStream());
            do {
                read = ByteStreams.read(inputStream, createBuffer, 0, createBuffer.length);
                if (read == ByteStreams.read(inputStream2, createBuffer2, 0, createBuffer2.length)) {
                    if (!Arrays.equals(createBuffer, createBuffer2)) {
                    }
                }
                create.close();
                return false;
            } while (read == createBuffer.length);
            create.close();
            return true;
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    public static ByteSource concat(Iterable<? extends ByteSource> iterable) {
        return new ConcatenatedByteSource(iterable);
    }

    public static ByteSource concat(Iterator<? extends ByteSource> it) {
        return concat((Iterable<? extends ByteSource>) ImmutableList.copyOf(it));
    }

    public static ByteSource concat(ByteSource... byteSourceArr) {
        return concat((Iterable<? extends ByteSource>) ImmutableList.copyOf((E[]) byteSourceArr));
    }

    public static ByteSource wrap(byte[] bArr) {
        return new ByteArrayByteSource(bArr);
    }

    public static ByteSource empty() {
        return EmptyByteSource.INSTANCE;
    }
}
