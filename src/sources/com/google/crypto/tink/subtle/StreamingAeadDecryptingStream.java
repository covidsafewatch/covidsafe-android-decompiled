package com.google.crypto.tink.subtle;

import com.atlassian.mobilekit.module.core.utils.StringUtils;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

class StreamingAeadDecryptingStream extends FilterInputStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int PLAINTEXT_SEGMENT_EXTRA_SIZE = 16;
    private byte[] aad;
    private ByteBuffer ciphertextSegment;
    private final int ciphertextSegmentSize;
    private final StreamSegmentDecrypter decrypter;
    private boolean definedState = true;
    private boolean endOfCiphertext = false;
    private boolean endOfPlaintext = false;
    private final int firstCiphertextSegmentSize;
    private int headerLength;
    private boolean headerRead = false;
    private ByteBuffer plaintextSegment;
    private int segmentNr = 0;

    public boolean markSupported() {
        return false;
    }

    public StreamingAeadDecryptingStream(NonceBasedStreamingAead nonceBasedStreamingAead, InputStream inputStream, byte[] bArr) throws GeneralSecurityException, IOException {
        super(inputStream);
        this.decrypter = nonceBasedStreamingAead.newStreamSegmentDecrypter();
        this.headerLength = nonceBasedStreamingAead.getHeaderLength();
        this.aad = Arrays.copyOf(bArr, bArr.length);
        int ciphertextSegmentSize2 = nonceBasedStreamingAead.getCiphertextSegmentSize();
        this.ciphertextSegmentSize = ciphertextSegmentSize2;
        ByteBuffer allocate = ByteBuffer.allocate(ciphertextSegmentSize2 + 1);
        this.ciphertextSegment = allocate;
        allocate.limit(0);
        this.firstCiphertextSegmentSize = this.ciphertextSegmentSize - nonceBasedStreamingAead.getCiphertextOffset();
        ByteBuffer allocate2 = ByteBuffer.allocate(nonceBasedStreamingAead.getPlaintextSegmentSize() + 16);
        this.plaintextSegment = allocate2;
        allocate2.limit(0);
    }

    private void readHeader() throws IOException {
        byte[] bArr = new byte[this.headerLength];
        if (this.in.read(bArr) == this.headerLength) {
            try {
                this.decrypter.init(ByteBuffer.wrap(bArr), this.aad);
                this.headerRead = true;
            } catch (GeneralSecurityException e) {
                throw new IOException(e);
            }
        } else {
            setUndefinedState();
            throw new IOException("Ciphertext is too short");
        }
    }

    private void setUndefinedState() {
        this.definedState = false;
        this.plaintextSegment.limit(0);
    }

    private void loadSegment() throws IOException {
        while (!this.endOfCiphertext && this.ciphertextSegment.remaining() > 0) {
            int read = this.in.read(this.ciphertextSegment.array(), this.ciphertextSegment.position(), this.ciphertextSegment.remaining());
            if (read > 0) {
                ByteBuffer byteBuffer = this.ciphertextSegment;
                byteBuffer.position(byteBuffer.position() + read);
            } else if (read == -1) {
                this.endOfCiphertext = true;
            } else if (read == 0) {
                throw new IOException("Could not read bytes from the ciphertext stream");
            }
        }
        byte b = 0;
        if (!this.endOfCiphertext) {
            ByteBuffer byteBuffer2 = this.ciphertextSegment;
            b = byteBuffer2.get(byteBuffer2.position() - 1);
            ByteBuffer byteBuffer3 = this.ciphertextSegment;
            byteBuffer3.position(byteBuffer3.position() - 1);
        }
        this.ciphertextSegment.flip();
        this.plaintextSegment.clear();
        try {
            this.decrypter.decryptSegment(this.ciphertextSegment, this.segmentNr, this.endOfCiphertext, this.plaintextSegment);
            this.segmentNr++;
            this.plaintextSegment.flip();
            this.ciphertextSegment.clear();
            if (!this.endOfCiphertext) {
                this.ciphertextSegment.clear();
                this.ciphertextSegment.limit(this.ciphertextSegmentSize + 1);
                this.ciphertextSegment.put(b);
            }
        } catch (GeneralSecurityException e) {
            setUndefinedState();
            throw new IOException(e.getMessage() + StringUtils.EOL + toString() + "\nsegmentNr:" + this.segmentNr + " endOfCiphertext:" + this.endOfCiphertext, e);
        }
    }

    public int read() throws IOException {
        byte[] bArr = new byte[1];
        int read = read(bArr, 0, 1);
        if (read == 1) {
            return bArr[0] & 255;
        }
        if (read == -1) {
            return read;
        }
        throw new IOException("Reading failed");
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0054, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int read(byte[] r7, int r8, int r9) throws java.io.IOException {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.definedState     // Catch:{ all -> 0x005d }
            if (r0 == 0) goto L_0x0055
            boolean r0 = r6.headerRead     // Catch:{ all -> 0x005d }
            r1 = 1
            if (r0 != 0) goto L_0x001a
            r6.readHeader()     // Catch:{ all -> 0x005d }
            java.nio.ByteBuffer r0 = r6.ciphertextSegment     // Catch:{ all -> 0x005d }
            r0.clear()     // Catch:{ all -> 0x005d }
            java.nio.ByteBuffer r0 = r6.ciphertextSegment     // Catch:{ all -> 0x005d }
            int r2 = r6.firstCiphertextSegmentSize     // Catch:{ all -> 0x005d }
            int r2 = r2 + r1
            r0.limit(r2)     // Catch:{ all -> 0x005d }
        L_0x001a:
            boolean r0 = r6.endOfPlaintext     // Catch:{ all -> 0x005d }
            r2 = -1
            if (r0 == 0) goto L_0x0021
            monitor-exit(r6)
            return r2
        L_0x0021:
            r0 = 0
        L_0x0022:
            if (r0 >= r9) goto L_0x004b
            java.nio.ByteBuffer r3 = r6.plaintextSegment     // Catch:{ all -> 0x005d }
            int r3 = r3.remaining()     // Catch:{ all -> 0x005d }
            if (r3 != 0) goto L_0x0036
            boolean r3 = r6.endOfCiphertext     // Catch:{ all -> 0x005d }
            if (r3 == 0) goto L_0x0033
            r6.endOfPlaintext = r1     // Catch:{ all -> 0x005d }
            goto L_0x004b
        L_0x0033:
            r6.loadSegment()     // Catch:{ all -> 0x005d }
        L_0x0036:
            java.nio.ByteBuffer r3 = r6.plaintextSegment     // Catch:{ all -> 0x005d }
            int r3 = r3.remaining()     // Catch:{ all -> 0x005d }
            int r4 = r9 - r0
            int r3 = java.lang.Math.min(r3, r4)     // Catch:{ all -> 0x005d }
            java.nio.ByteBuffer r4 = r6.plaintextSegment     // Catch:{ all -> 0x005d }
            int r5 = r0 + r8
            r4.get(r7, r5, r3)     // Catch:{ all -> 0x005d }
            int r0 = r0 + r3
            goto L_0x0022
        L_0x004b:
            if (r0 != 0) goto L_0x0053
            boolean r7 = r6.endOfPlaintext     // Catch:{ all -> 0x005d }
            if (r7 == 0) goto L_0x0053
            monitor-exit(r6)
            return r2
        L_0x0053:
            monitor-exit(r6)
            return r0
        L_0x0055:
            java.io.IOException r7 = new java.io.IOException     // Catch:{ all -> 0x005d }
            java.lang.String r8 = "This StreamingAeadDecryptingStream is in an undefined state"
            r7.<init>(r8)     // Catch:{ all -> 0x005d }
            throw r7     // Catch:{ all -> 0x005d }
        L_0x005d:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.subtle.StreamingAeadDecryptingStream.read(byte[], int, int):int");
    }

    public synchronized void close() throws IOException {
        super.close();
    }

    public synchronized int available() {
        return this.plaintextSegment.remaining();
    }

    public synchronized void mark(int i) {
    }

    public long skip(long j) throws IOException {
        int read;
        long j2 = (long) this.ciphertextSegmentSize;
        if (j <= 0) {
            return 0;
        }
        int min = (int) Math.min(j2, j);
        byte[] bArr = new byte[min];
        long j3 = j;
        while (j3 > 0 && (read = read(bArr, 0, (int) Math.min((long) min, j3))) > 0) {
            j3 -= (long) read;
        }
        return j - j3;
    }

    public synchronized String toString() {
        return "StreamingAeadDecryptingStream" + "\nsegmentNr:" + this.segmentNr + "\nciphertextSegmentSize:" + this.ciphertextSegmentSize + "\nheaderRead:" + this.headerRead + "\nendOfCiphertext:" + this.endOfCiphertext + "\nendOfPlaintext:" + this.endOfPlaintext + "\ndefinedState:" + this.definedState + "\nciphertextSgement" + " position:" + this.ciphertextSegment.position() + " limit:" + this.ciphertextSegment.limit() + "\nplaintextSegment" + " position:" + this.plaintextSegment.position() + " limit:" + this.plaintextSegment.limit();
    }
}
