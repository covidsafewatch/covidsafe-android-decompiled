package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.StreamingAead;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

final class InputStreamDecrypter extends InputStream {
    byte[] associatedData;
    boolean attemptedMatching = false;
    InputStream ciphertextStream;
    InputStream matchingStream = null;
    PrimitiveSet<StreamingAead> primitives;

    public boolean markSupported() {
        return false;
    }

    public InputStreamDecrypter(PrimitiveSet<StreamingAead> primitiveSet, InputStream inputStream, byte[] bArr) {
        this.primitives = primitiveSet;
        if (inputStream.markSupported()) {
            this.ciphertextStream = inputStream;
        } else {
            this.ciphertextStream = new BufferedInputStream(inputStream);
        }
        this.ciphertextStream.mark(Integer.MAX_VALUE);
        this.associatedData = (byte[]) bArr.clone();
    }

    private void rewind() throws IOException {
        this.ciphertextStream.reset();
    }

    private void disableRewinding() throws IOException {
        this.ciphertextStream.mark(0);
    }

    public synchronized int available() throws IOException {
        if (this.matchingStream == null) {
            return 0;
        }
        return this.matchingStream.available();
    }

    public synchronized int read() throws IOException {
        byte[] bArr = new byte[1];
        if (read(bArr) != 1) {
            return -1;
        }
        return bArr[0];
    }

    public synchronized int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004f, code lost:
        return r3;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0050 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int read(byte[] r6, int r7, int r8) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            if (r8 != 0) goto L_0x0006
            monitor-exit(r5)
            return r0
        L_0x0006:
            java.io.InputStream r1 = r5.matchingStream     // Catch:{ all -> 0x0068 }
            if (r1 == 0) goto L_0x0012
            java.io.InputStream r0 = r5.matchingStream     // Catch:{ all -> 0x0068 }
            int r6 = r0.read(r6, r7, r8)     // Catch:{ all -> 0x0068 }
            monitor-exit(r5)
            return r6
        L_0x0012:
            boolean r1 = r5.attemptedMatching     // Catch:{ all -> 0x0068 }
            if (r1 != 0) goto L_0x0060
            r1 = 1
            r5.attemptedMatching = r1     // Catch:{ all -> 0x0068 }
            com.google.crypto.tink.PrimitiveSet<com.google.crypto.tink.StreamingAead> r1 = r5.primitives     // Catch:{ all -> 0x0068 }
            java.util.List r1 = r1.getRawPrimitives()     // Catch:{ all -> 0x0068 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0068 }
        L_0x0023:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0068 }
            if (r2 == 0) goto L_0x0058
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0068 }
            com.google.crypto.tink.PrimitiveSet$Entry r2 = (com.google.crypto.tink.PrimitiveSet.Entry) r2     // Catch:{ all -> 0x0068 }
            java.lang.Object r2 = r2.getPrimitive()     // Catch:{ IOException -> 0x0054, GeneralSecurityException -> 0x0050 }
            com.google.crypto.tink.StreamingAead r2 = (com.google.crypto.tink.StreamingAead) r2     // Catch:{ IOException -> 0x0054, GeneralSecurityException -> 0x0050 }
            java.io.InputStream r3 = r5.ciphertextStream     // Catch:{ IOException -> 0x0054, GeneralSecurityException -> 0x0050 }
            byte[] r4 = r5.associatedData     // Catch:{ IOException -> 0x0054, GeneralSecurityException -> 0x0050 }
            java.io.InputStream r2 = r2.newDecryptingStream(r3, r4)     // Catch:{ IOException -> 0x0054, GeneralSecurityException -> 0x0050 }
            int r3 = r2.read(r6, r7, r8)     // Catch:{ IOException -> 0x0054, GeneralSecurityException -> 0x0050 }
            if (r3 != 0) goto L_0x0049
            r5.rewind()     // Catch:{ IOException -> 0x0054, GeneralSecurityException -> 0x0050 }
            r5.attemptedMatching = r0     // Catch:{ IOException -> 0x0054, GeneralSecurityException -> 0x0050 }
            goto L_0x004e
        L_0x0049:
            r5.matchingStream = r2     // Catch:{ IOException -> 0x0054, GeneralSecurityException -> 0x0050 }
            r5.disableRewinding()     // Catch:{ IOException -> 0x0054, GeneralSecurityException -> 0x0050 }
        L_0x004e:
            monitor-exit(r5)
            return r3
        L_0x0050:
            r5.rewind()     // Catch:{ all -> 0x0068 }
            goto L_0x0023
        L_0x0054:
            r5.rewind()     // Catch:{ all -> 0x0068 }
            goto L_0x0023
        L_0x0058:
            java.io.IOException r6 = new java.io.IOException     // Catch:{ all -> 0x0068 }
            java.lang.String r7 = "No matching key found for the ciphertext in the stream."
            r6.<init>(r7)     // Catch:{ all -> 0x0068 }
            throw r6     // Catch:{ all -> 0x0068 }
        L_0x0060:
            java.io.IOException r6 = new java.io.IOException     // Catch:{ all -> 0x0068 }
            java.lang.String r7 = "No matching key found for the ciphertext in the stream."
            r6.<init>(r7)     // Catch:{ all -> 0x0068 }
            throw r6     // Catch:{ all -> 0x0068 }
        L_0x0068:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.streamingaead.InputStreamDecrypter.read(byte[], int, int):int");
    }

    public synchronized void close() throws IOException {
        this.ciphertextStream.close();
    }
}
