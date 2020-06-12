package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.StreamingAead;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.NonWritableChannelException;
import java.nio.channels.SeekableByteChannel;

final class SeekableByteChannelDecrypter implements SeekableByteChannel {
    byte[] associatedData;
    boolean attemptedMatching = false;
    long cachedPosition;
    SeekableByteChannel ciphertextChannel;
    SeekableByteChannel matchingChannel = null;
    PrimitiveSet<StreamingAead> primitives;
    long startingPosition;

    public SeekableByteChannelDecrypter(PrimitiveSet<StreamingAead> primitiveSet, SeekableByteChannel seekableByteChannel, byte[] bArr) throws IOException {
        this.primitives = primitiveSet;
        this.ciphertextChannel = seekableByteChannel;
        this.cachedPosition = -1;
        this.startingPosition = seekableByteChannel.position();
        this.associatedData = (byte[]) bArr.clone();
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x0066 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int read(java.nio.ByteBuffer r9) throws java.io.IOException {
        /*
            r8 = this;
            monitor-enter(r8)
            int r0 = r9.remaining()     // Catch:{ all -> 0x0086 }
            r1 = 0
            if (r0 != 0) goto L_0x000a
            monitor-exit(r8)
            return r1
        L_0x000a:
            java.nio.channels.SeekableByteChannel r0 = r8.matchingChannel     // Catch:{ all -> 0x0086 }
            if (r0 == 0) goto L_0x0016
            java.nio.channels.SeekableByteChannel r0 = r8.matchingChannel     // Catch:{ all -> 0x0086 }
            int r9 = r0.read(r9)     // Catch:{ all -> 0x0086 }
            monitor-exit(r8)
            return r9
        L_0x0016:
            boolean r0 = r8.attemptedMatching     // Catch:{ all -> 0x0086 }
            if (r0 != 0) goto L_0x007e
            r0 = 1
            r8.attemptedMatching = r0     // Catch:{ all -> 0x0086 }
            com.google.crypto.tink.PrimitiveSet<com.google.crypto.tink.StreamingAead> r0 = r8.primitives     // Catch:{ all -> 0x0086 }
            java.util.List r0 = r0.getRawPrimitives()     // Catch:{ all -> 0x0086 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0086 }
        L_0x0027:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x0086 }
            if (r2 == 0) goto L_0x0076
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x0086 }
            com.google.crypto.tink.PrimitiveSet$Entry r2 = (com.google.crypto.tink.PrimitiveSet.Entry) r2     // Catch:{ all -> 0x0086 }
            java.lang.Object r2 = r2.getPrimitive()     // Catch:{ IOException -> 0x006e, GeneralSecurityException -> 0x0066 }
            com.google.crypto.tink.StreamingAead r2 = (com.google.crypto.tink.StreamingAead) r2     // Catch:{ IOException -> 0x006e, GeneralSecurityException -> 0x0066 }
            java.nio.channels.SeekableByteChannel r3 = r8.ciphertextChannel     // Catch:{ IOException -> 0x006e, GeneralSecurityException -> 0x0066 }
            byte[] r4 = r8.associatedData     // Catch:{ IOException -> 0x006e, GeneralSecurityException -> 0x0066 }
            java.nio.channels.SeekableByteChannel r2 = r2.newSeekableDecryptingChannel(r3, r4)     // Catch:{ IOException -> 0x006e, GeneralSecurityException -> 0x0066 }
            long r3 = r8.cachedPosition     // Catch:{ IOException -> 0x006e, GeneralSecurityException -> 0x0066 }
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 < 0) goto L_0x004e
            long r3 = r8.cachedPosition     // Catch:{ IOException -> 0x006e, GeneralSecurityException -> 0x0066 }
            r2.position(r3)     // Catch:{ IOException -> 0x006e, GeneralSecurityException -> 0x0066 }
        L_0x004e:
            int r3 = r2.read(r9)     // Catch:{ IOException -> 0x006e, GeneralSecurityException -> 0x0066 }
            if (r3 <= 0) goto L_0x0057
            r8.matchingChannel = r2     // Catch:{ IOException -> 0x006e, GeneralSecurityException -> 0x0066 }
            goto L_0x0062
        L_0x0057:
            if (r3 != 0) goto L_0x0062
            java.nio.channels.SeekableByteChannel r4 = r8.ciphertextChannel     // Catch:{ IOException -> 0x006e, GeneralSecurityException -> 0x0066 }
            long r5 = r8.startingPosition     // Catch:{ IOException -> 0x006e, GeneralSecurityException -> 0x0066 }
            r4.position(r5)     // Catch:{ IOException -> 0x006e, GeneralSecurityException -> 0x0066 }
            r8.attemptedMatching = r1     // Catch:{ IOException -> 0x006e, GeneralSecurityException -> 0x0066 }
        L_0x0062:
            r8.matchingChannel = r2     // Catch:{ IOException -> 0x006e, GeneralSecurityException -> 0x0066 }
            monitor-exit(r8)
            return r3
        L_0x0066:
            java.nio.channels.SeekableByteChannel r2 = r8.ciphertextChannel     // Catch:{ all -> 0x0086 }
            long r3 = r8.startingPosition     // Catch:{ all -> 0x0086 }
            r2.position(r3)     // Catch:{ all -> 0x0086 }
            goto L_0x0027
        L_0x006e:
            java.nio.channels.SeekableByteChannel r2 = r8.ciphertextChannel     // Catch:{ all -> 0x0086 }
            long r3 = r8.startingPosition     // Catch:{ all -> 0x0086 }
            r2.position(r3)     // Catch:{ all -> 0x0086 }
            goto L_0x0027
        L_0x0076:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ all -> 0x0086 }
            java.lang.String r0 = "No matching key found for the ciphertext in the stream."
            r9.<init>(r0)     // Catch:{ all -> 0x0086 }
            throw r9     // Catch:{ all -> 0x0086 }
        L_0x007e:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ all -> 0x0086 }
            java.lang.String r0 = "No matching key found for the ciphertext in the stream."
            r9.<init>(r0)     // Catch:{ all -> 0x0086 }
            throw r9     // Catch:{ all -> 0x0086 }
        L_0x0086:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.streamingaead.SeekableByteChannelDecrypter.read(java.nio.ByteBuffer):int");
    }

    public synchronized SeekableByteChannel position(long j) throws IOException {
        if (this.matchingChannel != null) {
            this.matchingChannel.position(j);
        } else if (j >= 0) {
            this.cachedPosition = j;
        } else {
            throw new IllegalArgumentException("Position must be non-negative");
        }
        return this;
    }

    public synchronized long position() throws IOException {
        if (this.matchingChannel != null) {
            return this.matchingChannel.position();
        }
        return this.cachedPosition;
    }

    public synchronized long size() throws IOException {
        if (this.matchingChannel != null) {
        } else {
            throw new IOException("Cannot determine size before first read()-call.");
        }
        return this.matchingChannel.size();
    }

    public SeekableByteChannel truncate(long j) throws IOException {
        throw new NonWritableChannelException();
    }

    public int write(ByteBuffer byteBuffer) throws IOException {
        throw new NonWritableChannelException();
    }

    public synchronized void close() throws IOException {
        this.ciphertextChannel.close();
    }

    public synchronized boolean isOpen() {
        return this.ciphertextChannel.isOpen();
    }
}
