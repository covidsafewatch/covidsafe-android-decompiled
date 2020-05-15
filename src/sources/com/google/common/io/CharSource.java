package com.google.common.io;

import com.google.common.base.Ascii;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.LongCompanionObject;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class CharSource {
    public abstract Reader openStream() throws IOException;

    protected CharSource() {
    }

    public ByteSource asByteSource(Charset charset) {
        return new AsByteSource(charset);
    }

    public BufferedReader openBufferedStream() throws IOException {
        Reader openStream = openStream();
        return openStream instanceof BufferedReader ? (BufferedReader) openStream : new BufferedReader(openStream);
    }

    public Optional<Long> lengthIfKnown() {
        return Optional.absent();
    }

    public long length() throws IOException {
        Optional<Long> lengthIfKnown = lengthIfKnown();
        if (lengthIfKnown.isPresent()) {
            return lengthIfKnown.get().longValue();
        }
        Closer create = Closer.create();
        try {
            long countBySkipping = countBySkipping((Reader) create.register(openStream()));
            create.close();
            return countBySkipping;
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    private long countBySkipping(Reader reader) throws IOException {
        long j = 0;
        while (true) {
            long skip = reader.skip(LongCompanionObject.MAX_VALUE);
            if (skip == 0) {
                return j;
            }
            j += skip;
        }
    }

    public long copyTo(Appendable appendable) throws IOException {
        Preconditions.checkNotNull(appendable);
        Closer create = Closer.create();
        try {
            long copy = CharStreams.copy((Reader) create.register(openStream()), appendable);
            create.close();
            return copy;
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    public long copyTo(CharSink charSink) throws IOException {
        Preconditions.checkNotNull(charSink);
        Closer create = Closer.create();
        try {
            long copy = CharStreams.copy((Reader) create.register(openStream()), (Writer) create.register(charSink.openStream()));
            create.close();
            return copy;
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    public String read() throws IOException {
        Closer create = Closer.create();
        try {
            String charStreams = CharStreams.toString((Reader) create.register(openStream()));
            create.close();
            return charStreams;
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    @NullableDecl
    public String readFirstLine() throws IOException {
        Closer create = Closer.create();
        try {
            String readLine = ((BufferedReader) create.register(openBufferedStream())).readLine();
            create.close();
            return readLine;
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    public ImmutableList<String> readLines() throws IOException {
        Closer create = Closer.create();
        try {
            BufferedReader bufferedReader = (BufferedReader) create.register(openBufferedStream());
            ArrayList newArrayList = Lists.newArrayList();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    newArrayList.add(readLine);
                } else {
                    ImmutableList<String> copyOf = ImmutableList.copyOf(newArrayList);
                    create.close();
                    return copyOf;
                }
            }
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    public <T> T readLines(LineProcessor<T> lineProcessor) throws IOException {
        Preconditions.checkNotNull(lineProcessor);
        Closer create = Closer.create();
        try {
            T readLines = CharStreams.readLines((Reader) create.register(openStream()), lineProcessor);
            create.close();
            return readLines;
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    public boolean isEmpty() throws IOException {
        Optional<Long> lengthIfKnown = lengthIfKnown();
        boolean z = true;
        if (!lengthIfKnown.isPresent()) {
            Closer create = Closer.create();
            try {
                if (((Reader) create.register(openStream())).read() != -1) {
                    z = false;
                }
                create.close();
                return z;
            } catch (Throwable th) {
                create.close();
                throw th;
            }
        } else if (lengthIfKnown.get().longValue() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static CharSource concat(Iterable<? extends CharSource> iterable) {
        return new ConcatenatedCharSource(iterable);
    }

    public static CharSource concat(Iterator<? extends CharSource> it) {
        return concat((Iterable<? extends CharSource>) ImmutableList.copyOf(it));
    }

    public static CharSource concat(CharSource... charSourceArr) {
        return concat((Iterable<? extends CharSource>) ImmutableList.copyOf((E[]) charSourceArr));
    }

    public static CharSource wrap(CharSequence charSequence) {
        return charSequence instanceof String ? new StringCharSource((String) charSequence) : new CharSequenceCharSource(charSequence);
    }

    public static CharSource empty() {
        return EmptyCharSource.INSTANCE;
    }

    private final class AsByteSource extends ByteSource {
        final Charset charset;

        AsByteSource(Charset charset2) {
            this.charset = (Charset) Preconditions.checkNotNull(charset2);
        }

        public CharSource asCharSource(Charset charset2) {
            if (charset2.equals(this.charset)) {
                return CharSource.this;
            }
            return super.asCharSource(charset2);
        }

        public InputStream openStream() throws IOException {
            return new ReaderInputStream(CharSource.this.openStream(), this.charset, 8192);
        }

        public String toString() {
            return CharSource.this.toString() + ".asByteSource(" + this.charset + ")";
        }
    }

    private static class CharSequenceCharSource extends CharSource {
        /* access modifiers changed from: private */
        public static final Splitter LINE_SPLITTER = Splitter.onPattern("\r\n|\n|\r");
        protected final CharSequence seq;

        protected CharSequenceCharSource(CharSequence charSequence) {
            this.seq = (CharSequence) Preconditions.checkNotNull(charSequence);
        }

        public Reader openStream() {
            return new CharSequenceReader(this.seq);
        }

        public String read() {
            return this.seq.toString();
        }

        public boolean isEmpty() {
            return this.seq.length() == 0;
        }

        public long length() {
            return (long) this.seq.length();
        }

        public Optional<Long> lengthIfKnown() {
            return Optional.of(Long.valueOf((long) this.seq.length()));
        }

        private Iterator<String> linesIterator() {
            return new AbstractIterator<String>() {
                Iterator<String> lines = CharSequenceCharSource.LINE_SPLITTER.split(CharSequenceCharSource.this.seq).iterator();

                /* access modifiers changed from: protected */
                public String computeNext() {
                    if (this.lines.hasNext()) {
                        String next = this.lines.next();
                        if (this.lines.hasNext() || !next.isEmpty()) {
                            return next;
                        }
                    }
                    return (String) endOfData();
                }
            };
        }

        public String readFirstLine() {
            Iterator<String> linesIterator = linesIterator();
            if (linesIterator.hasNext()) {
                return linesIterator.next();
            }
            return null;
        }

        public ImmutableList<String> readLines() {
            return ImmutableList.copyOf(linesIterator());
        }

        /* JADX WARNING: Removed duplicated region for block: B:1:0x0004 A[LOOP:0: B:1:0x0004->B:4:0x0014, LOOP_START] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public <T> T readLines(com.google.common.io.LineProcessor<T> r3) throws java.io.IOException {
            /*
                r2 = this;
                java.util.Iterator r0 = r2.linesIterator()
            L_0x0004:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L_0x0016
                java.lang.Object r1 = r0.next()
                java.lang.String r1 = (java.lang.String) r1
                boolean r1 = r3.processLine(r1)
                if (r1 != 0) goto L_0x0004
            L_0x0016:
                java.lang.Object r3 = r3.getResult()
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.CharSource.CharSequenceCharSource.readLines(com.google.common.io.LineProcessor):java.lang.Object");
        }

        public String toString() {
            return "CharSource.wrap(" + Ascii.truncate(this.seq, 30, "...") + ")";
        }
    }

    private static class StringCharSource extends CharSequenceCharSource {
        protected StringCharSource(String str) {
            super(str);
        }

        public Reader openStream() {
            return new StringReader((String) this.seq);
        }

        public long copyTo(Appendable appendable) throws IOException {
            appendable.append(this.seq);
            return (long) this.seq.length();
        }

        public long copyTo(CharSink charSink) throws IOException {
            Preconditions.checkNotNull(charSink);
            Closer create = Closer.create();
            try {
                ((Writer) create.register(charSink.openStream())).write((String) this.seq);
                long length = (long) this.seq.length();
                create.close();
                return length;
            } catch (Throwable th) {
                create.close();
                throw th;
            }
        }
    }

    private static final class EmptyCharSource extends StringCharSource {
        /* access modifiers changed from: private */
        public static final EmptyCharSource INSTANCE = new EmptyCharSource();

        public String toString() {
            return "CharSource.empty()";
        }

        private EmptyCharSource() {
            super("");
        }
    }

    private static final class ConcatenatedCharSource extends CharSource {
        private final Iterable<? extends CharSource> sources;

        ConcatenatedCharSource(Iterable<? extends CharSource> iterable) {
            this.sources = (Iterable) Preconditions.checkNotNull(iterable);
        }

        public Reader openStream() throws IOException {
            return new MultiReader(this.sources.iterator());
        }

        public boolean isEmpty() throws IOException {
            for (CharSource isEmpty : this.sources) {
                if (!isEmpty.isEmpty()) {
                    return false;
                }
            }
            return true;
        }

        public Optional<Long> lengthIfKnown() {
            long j = 0;
            for (CharSource lengthIfKnown : this.sources) {
                Optional<Long> lengthIfKnown2 = lengthIfKnown.lengthIfKnown();
                if (!lengthIfKnown2.isPresent()) {
                    return Optional.absent();
                }
                j += lengthIfKnown2.get().longValue();
            }
            return Optional.of(Long.valueOf(j));
        }

        public long length() throws IOException {
            long j = 0;
            for (CharSource length : this.sources) {
                j += length.length();
            }
            return j;
        }

        public String toString() {
            return "CharSource.concat(" + this.sources + ")";
        }
    }
}
