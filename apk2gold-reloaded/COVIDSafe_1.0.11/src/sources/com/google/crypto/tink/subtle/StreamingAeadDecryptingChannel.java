package com.google.crypto.tink.subtle;

import com.atlassian.mobilekit.module.core.utils.StringUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.security.GeneralSecurityException;
import java.util.Arrays;

class StreamingAeadDecryptingChannel implements ReadableByteChannel {
    private static final int PLAINTEXT_SEGMENT_EXTRA_SIZE = 16;
    private byte[] aad;
    private ReadableByteChannel ciphertextChannel;
    private ByteBuffer ciphertextSegment;
    private final int ciphertextSegmentSize;
    private final StreamSegmentDecrypter decrypter;
    private boolean definedState = true;
    private boolean endOfCiphertext = false;
    private boolean endOfPlaintext = false;
    private final int firstCiphertextSegmentSize;
    private ByteBuffer header;
    private boolean headerRead = false;
    private ByteBuffer plaintextSegment;
    private int segmentNr = 0;

    public StreamingAeadDecryptingChannel(NonceBasedStreamingAead nonceBasedStreamingAead, ReadableByteChannel readableByteChannel, byte[] bArr) throws GeneralSecurityException, IOException {
        this.decrypter = nonceBasedStreamingAead.newStreamSegmentDecrypter();
        this.ciphertextChannel = readableByteChannel;
        this.header = ByteBuffer.allocate(nonceBasedStreamingAead.getHeaderLength());
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

    private void readSomeCiphertext(ByteBuffer byteBuffer) throws IOException {
        int read;
        do {
            read = this.ciphertextChannel.read(byteBuffer);
            if (read <= 0) {
                break;
            }
        } while (byteBuffer.remaining() > 0);
        if (read == -1) {
            this.endOfCiphertext = true;
        }
    }

    private boolean tryReadHeader() throws IOException {
        if (!this.endOfCiphertext) {
            readSomeCiphertext(this.header);
            if (this.header.remaining() > 0) {
                return false;
            }
            this.header.flip();
            try {
                this.decrypter.init(this.header, this.aad);
                this.headerRead = true;
                return true;
            } catch (GeneralSecurityException e) {
                setUndefinedState();
                throw new IOException(e);
            }
        } else {
            throw new IOException("Ciphertext is too short");
        }
    }

    private void setUndefinedState() {
        this.definedState = false;
        this.plaintextSegment.limit(0);
    }

    private boolean tryLoadSegment() throws IOException {
        if (!this.endOfCiphertext) {
            readSomeCiphertext(this.ciphertextSegment);
        }
        byte b = 0;
        if (this.ciphertextSegment.remaining() > 0 && !this.endOfCiphertext) {
            return false;
        }
        if (!this.endOfCiphertext) {
            ByteBuffer byteBuffer = this.ciphertextSegment;
            b = byteBuffer.get(byteBuffer.position() - 1);
            ByteBuffer byteBuffer2 = this.ciphertextSegment;
            byteBuffer2.position(byteBuffer2.position() - 1);
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
            return true;
        } catch (GeneralSecurityException e) {
            setUndefinedState();
            StringBuilder sb = new StringBuilder();
            sb.append(e.getMessage());
            sb.append(StringUtils.EOL);
            sb.append(toString());
            sb.append("\nsegmentNr:");
            sb.append(this.segmentNr);
            sb.append(" endOfCiphertext:");
            sb.append(this.endOfCiphertext);
            throw new IOException(sb.toString(), e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x008e, code lost:
        return r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int read(java.nio.ByteBuffer r7) throws java.io.IOException {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.definedState     // Catch:{ all -> 0x0097 }
            if (r0 == 0) goto L_0x008f
            boolean r0 = r6.headerRead     // Catch:{ all -> 0x0097 }
            r1 = 1
            if (r0 != 0) goto L_0x0020
            boolean r0 = r6.tryReadHeader()     // Catch:{ all -> 0x0097 }
            if (r0 != 0) goto L_0x0013
            r7 = 0
            monitor-exit(r6)
            return r7
        L_0x0013:
            java.nio.ByteBuffer r0 = r6.ciphertextSegment     // Catch:{ all -> 0x0097 }
            r0.clear()     // Catch:{ all -> 0x0097 }
            java.nio.ByteBuffer r0 = r6.ciphertextSegment     // Catch:{ all -> 0x0097 }
            int r2 = r6.firstCiphertextSegmentSize     // Catch:{ all -> 0x0097 }
            int r2 = r2 + r1
            r0.limit(r2)     // Catch:{ all -> 0x0097 }
        L_0x0020:
            boolean r0 = r6.endOfPlaintext     // Catch:{ all -> 0x0097 }
            r2 = -1
            if (r0 == 0) goto L_0x0027
            monitor-exit(r6)
            return r2
        L_0x0027:
            int r0 = r7.position()     // Catch:{ all -> 0x0097 }
        L_0x002b:
            int r3 = r7.remaining()     // Catch:{ all -> 0x0097 }
            if (r3 <= 0) goto L_0x0080
            java.nio.ByteBuffer r3 = r6.plaintextSegment     // Catch:{ all -> 0x0097 }
            int r3 = r3.remaining()     // Catch:{ all -> 0x0097 }
            if (r3 != 0) goto L_0x0047
            boolean r3 = r6.endOfCiphertext     // Catch:{ all -> 0x0097 }
            if (r3 == 0) goto L_0x0040
            r6.endOfPlaintext = r1     // Catch:{ all -> 0x0097 }
            goto L_0x0080
        L_0x0040:
            boolean r3 = r6.tryLoadSegment()     // Catch:{ all -> 0x0097 }
            if (r3 != 0) goto L_0x0047
            goto L_0x0080
        L_0x0047:
            java.nio.ByteBuffer r3 = r6.plaintextSegment     // Catch:{ all -> 0x0097 }
            int r3 = r3.remaining()     // Catch:{ all -> 0x0097 }
            int r4 = r7.remaining()     // Catch:{ all -> 0x0097 }
            if (r3 > r4) goto L_0x005e
            java.nio.ByteBuffer r3 = r6.plaintextSegment     // Catch:{ all -> 0x0097 }
            r3.remaining()     // Catch:{ all -> 0x0097 }
            java.nio.ByteBuffer r3 = r6.plaintextSegment     // Catch:{ all -> 0x0097 }
            r7.put(r3)     // Catch:{ all -> 0x0097 }
            goto L_0x002b
        L_0x005e:
            int r3 = r7.remaining()     // Catch:{ all -> 0x0097 }
            java.nio.ByteBuffer r4 = r6.plaintextSegment     // Catch:{ all -> 0x0097 }
            java.nio.ByteBuffer r4 = r4.duplicate()     // Catch:{ all -> 0x0097 }
            int r5 = r4.position()     // Catch:{ all -> 0x0097 }
            int r5 = r5 + r3
            r4.limit(r5)     // Catch:{ all -> 0x0097 }
            r7.put(r4)     // Catch:{ all -> 0x0097 }
            java.nio.ByteBuffer r4 = r6.plaintextSegment     // Catch:{ all -> 0x0097 }
            java.nio.ByteBuffer r5 = r6.plaintextSegment     // Catch:{ all -> 0x0097 }
            int r5 = r5.position()     // Catch:{ all -> 0x0097 }
            int r5 = r5 + r3
            r4.position(r5)     // Catch:{ all -> 0x0097 }
            goto L_0x002b
        L_0x0080:
            int r7 = r7.position()     // Catch:{ all -> 0x0097 }
            int r7 = r7 - r0
            if (r7 != 0) goto L_0x008d
            boolean r0 = r6.endOfPlaintext     // Catch:{ all -> 0x0097 }
            if (r0 == 0) goto L_0x008d
            monitor-exit(r6)
            return r2
        L_0x008d:
            monitor-exit(r6)
            return r7
        L_0x008f:
            java.io.IOException r7 = new java.io.IOException     // Catch:{ all -> 0x0097 }
            java.lang.String r0 = "This StreamingAeadDecryptingChannel is in an undefined state"
            r7.<init>(r0)     // Catch:{ all -> 0x0097 }
            throw r7     // Catch:{ all -> 0x0097 }
        L_0x0097:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.subtle.StreamingAeadDecryptingChannel.read(java.nio.ByteBuffer):int");
    }

    public synchronized void close() throws IOException {
        this.ciphertextChannel.close();
    }

    public synchronized boolean isOpen() {
        return this.ciphertextChannel.isOpen();
    }

    public synchronized String toString() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append("StreamingAeadDecryptingChannel");
        sb.append("\nsegmentNr:");
        sb.append(this.segmentNr);
        sb.append("\nciphertextSegmentSize:");
        sb.append(this.ciphertextSegmentSize);
        sb.append("\nheaderRead:");
        sb.append(this.headerRead);
        sb.append("\nendOfCiphertext:");
        sb.append(this.endOfCiphertext);
        sb.append("\nendOfPlaintext:");
        sb.append(this.endOfPlaintext);
        sb.append("\ndefinedState:");
        sb.append(this.definedState);
        sb.append("\nHeader");
        sb.append(" position:");
        sb.append(this.header.position());
        sb.append(" limit:");
        sb.append(this.header.position());
        sb.append("\nciphertextSgement");
        sb.append(" position:");
        sb.append(this.ciphertextSegment.position());
        sb.append(" limit:");
        sb.append(this.ciphertextSegment.limit());
        sb.append("\nplaintextSegment");
        sb.append(" position:");
        sb.append(this.plaintextSegment.position());
        sb.append(" limit:");
        sb.append(this.plaintextSegment.limit());
        return sb.toString();
    }
}
