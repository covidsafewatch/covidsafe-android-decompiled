package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.StreamingAead;
import com.google.crypto.tink.subtle.RewindableReadableByteChannel;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;

final class ReadableByteChannelDecrypter implements ReadableByteChannel {
    byte[] associatedData;
    boolean attemptedMatching = false;
    RewindableReadableByteChannel ciphertextChannel;
    ReadableByteChannel matchingChannel = null;
    PrimitiveSet<StreamingAead> primitives;

    public ReadableByteChannelDecrypter(PrimitiveSet<StreamingAead> primitiveSet, ReadableByteChannel readableByteChannel, byte[] bArr) {
        this.primitives = primitiveSet;
        this.ciphertextChannel = new RewindableReadableByteChannel(readableByteChannel);
        this.associatedData = (byte[]) bArr.clone();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0059, code lost:
        return r3;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x005a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int read(java.nio.ByteBuffer r6) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            int r0 = r6.remaining()     // Catch:{ all -> 0x007f }
            r1 = 0
            if (r0 != 0) goto L_0x000a
            monitor-exit(r5)
            return r1
        L_0x000a:
            java.nio.channels.ReadableByteChannel r0 = r5.matchingChannel     // Catch:{ all -> 0x007f }
            if (r0 == 0) goto L_0x0016
            java.nio.channels.ReadableByteChannel r0 = r5.matchingChannel     // Catch:{ all -> 0x007f }
            int r6 = r0.read(r6)     // Catch:{ all -> 0x007f }
            monitor-exit(r5)
            return r6
        L_0x0016:
            boolean r0 = r5.attemptedMatching     // Catch:{ all -> 0x007f }
            if (r0 != 0) goto L_0x0077
            r0 = 1
            r5.attemptedMatching = r0     // Catch:{ all -> 0x007f }
            com.google.crypto.tink.PrimitiveSet<com.google.crypto.tink.StreamingAead> r0 = r5.primitives     // Catch:{ GeneralSecurityException -> 0x006e }
            java.util.List r0 = r0.getRawPrimitives()     // Catch:{ GeneralSecurityException -> 0x006e }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x007f }
        L_0x0027:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x007f }
            if (r2 == 0) goto L_0x0066
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x007f }
            com.google.crypto.tink.PrimitiveSet$Entry r2 = (com.google.crypto.tink.PrimitiveSet.Entry) r2     // Catch:{ all -> 0x007f }
            java.lang.Object r2 = r2.getPrimitive()     // Catch:{ IOException -> 0x0060, GeneralSecurityException -> 0x005a }
            com.google.crypto.tink.StreamingAead r2 = (com.google.crypto.tink.StreamingAead) r2     // Catch:{ IOException -> 0x0060, GeneralSecurityException -> 0x005a }
            com.google.crypto.tink.subtle.RewindableReadableByteChannel r3 = r5.ciphertextChannel     // Catch:{ IOException -> 0x0060, GeneralSecurityException -> 0x005a }
            byte[] r4 = r5.associatedData     // Catch:{ IOException -> 0x0060, GeneralSecurityException -> 0x005a }
            java.nio.channels.ReadableByteChannel r2 = r2.newDecryptingChannel(r3, r4)     // Catch:{ IOException -> 0x0060, GeneralSecurityException -> 0x005a }
            int r3 = r2.read(r6)     // Catch:{ IOException -> 0x0060, GeneralSecurityException -> 0x005a }
            if (r3 <= 0) goto L_0x004f
            r5.matchingChannel = r2     // Catch:{ IOException -> 0x0060, GeneralSecurityException -> 0x005a }
            com.google.crypto.tink.subtle.RewindableReadableByteChannel r2 = r5.ciphertextChannel     // Catch:{ IOException -> 0x0060, GeneralSecurityException -> 0x005a }
            r2.disableRewinding()     // Catch:{ IOException -> 0x0060, GeneralSecurityException -> 0x005a }
            goto L_0x0058
        L_0x004f:
            if (r3 != 0) goto L_0x0058
            com.google.crypto.tink.subtle.RewindableReadableByteChannel r2 = r5.ciphertextChannel     // Catch:{ IOException -> 0x0060, GeneralSecurityException -> 0x005a }
            r2.rewind()     // Catch:{ IOException -> 0x0060, GeneralSecurityException -> 0x005a }
            r5.attemptedMatching = r1     // Catch:{ IOException -> 0x0060, GeneralSecurityException -> 0x005a }
        L_0x0058:
            monitor-exit(r5)
            return r3
        L_0x005a:
            com.google.crypto.tink.subtle.RewindableReadableByteChannel r2 = r5.ciphertextChannel     // Catch:{ all -> 0x007f }
            r2.rewind()     // Catch:{ all -> 0x007f }
            goto L_0x0027
        L_0x0060:
            com.google.crypto.tink.subtle.RewindableReadableByteChannel r2 = r5.ciphertextChannel     // Catch:{ all -> 0x007f }
            r2.rewind()     // Catch:{ all -> 0x007f }
            goto L_0x0027
        L_0x0066:
            java.io.IOException r6 = new java.io.IOException     // Catch:{ all -> 0x007f }
            java.lang.String r0 = "No matching key found for the ciphertext in the stream."
            r6.<init>(r0)     // Catch:{ all -> 0x007f }
            throw r6     // Catch:{ all -> 0x007f }
        L_0x006e:
            r6 = move-exception
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x007f }
            java.lang.String r1 = "Keyset failure: "
            r0.<init>(r1, r6)     // Catch:{ all -> 0x007f }
            throw r0     // Catch:{ all -> 0x007f }
        L_0x0077:
            java.io.IOException r6 = new java.io.IOException     // Catch:{ all -> 0x007f }
            java.lang.String r0 = "No matching key found for the ciphertext in the stream."
            r6.<init>(r0)     // Catch:{ all -> 0x007f }
            throw r6     // Catch:{ all -> 0x007f }
        L_0x007f:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.streamingaead.ReadableByteChannelDecrypter.read(java.nio.ByteBuffer):int");
    }

    public synchronized void close() throws IOException {
        this.ciphertextChannel.close();
    }

    public synchronized boolean isOpen() {
        return this.ciphertextChannel.isOpen();
    }
}
