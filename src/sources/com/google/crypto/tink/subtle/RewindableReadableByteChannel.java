package com.google.crypto.tink.subtle;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;

public final class RewindableReadableByteChannel implements ReadableByteChannel {
    final ReadableByteChannel baseChannel;
    ByteBuffer buffer = null;
    boolean canRewind = true;
    boolean directRead = false;

    public RewindableReadableByteChannel(ReadableByteChannel readableByteChannel) {
        this.baseChannel = readableByteChannel;
    }

    public synchronized void disableRewinding() {
        this.canRewind = false;
    }

    public synchronized void rewind() throws IOException {
        if (!this.canRewind) {
            throw new IOException("Cannot rewind anymore.");
        } else if (this.buffer != null) {
            this.buffer.position(0);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0042, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0064, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int read(java.nio.ByteBuffer r6) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.directRead     // Catch:{ all -> 0x00b9 }
            if (r0 == 0) goto L_0x000d
            java.nio.channels.ReadableByteChannel r0 = r5.baseChannel     // Catch:{ all -> 0x00b9 }
            int r6 = r0.read(r6)     // Catch:{ all -> 0x00b9 }
            monitor-exit(r5)
            return r6
        L_0x000d:
            int r0 = r6.remaining()     // Catch:{ all -> 0x00b9 }
            if (r0 != 0) goto L_0x0016
            r6 = 0
            monitor-exit(r5)
            return r6
        L_0x0016:
            java.nio.ByteBuffer r1 = r5.buffer     // Catch:{ all -> 0x00b9 }
            r2 = 1
            if (r1 != 0) goto L_0x0043
            boolean r1 = r5.canRewind     // Catch:{ all -> 0x00b9 }
            if (r1 != 0) goto L_0x0029
            r5.directRead = r2     // Catch:{ all -> 0x00b9 }
            java.nio.channels.ReadableByteChannel r0 = r5.baseChannel     // Catch:{ all -> 0x00b9 }
            int r6 = r0.read(r6)     // Catch:{ all -> 0x00b9 }
            monitor-exit(r5)
            return r6
        L_0x0029:
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.allocate(r0)     // Catch:{ all -> 0x00b9 }
            r5.buffer = r0     // Catch:{ all -> 0x00b9 }
            java.nio.channels.ReadableByteChannel r1 = r5.baseChannel     // Catch:{ all -> 0x00b9 }
            int r0 = r1.read(r0)     // Catch:{ all -> 0x00b9 }
            if (r0 <= 0) goto L_0x0041
            java.nio.ByteBuffer r1 = r5.buffer     // Catch:{ all -> 0x00b9 }
            r1.flip()     // Catch:{ all -> 0x00b9 }
            java.nio.ByteBuffer r1 = r5.buffer     // Catch:{ all -> 0x00b9 }
            r6.put(r1)     // Catch:{ all -> 0x00b9 }
        L_0x0041:
            monitor-exit(r5)
            return r0
        L_0x0043:
            java.nio.ByteBuffer r1 = r5.buffer     // Catch:{ all -> 0x00b9 }
            int r1 = r1.remaining()     // Catch:{ all -> 0x00b9 }
            if (r1 < r0) goto L_0x0065
            byte[] r1 = new byte[r0]     // Catch:{ all -> 0x00b9 }
            java.nio.ByteBuffer r3 = r5.buffer     // Catch:{ all -> 0x00b9 }
            r3.get(r1)     // Catch:{ all -> 0x00b9 }
            r6.put(r1)     // Catch:{ all -> 0x00b9 }
            boolean r6 = r5.canRewind     // Catch:{ all -> 0x00b9 }
            if (r6 != 0) goto L_0x0063
            java.nio.ByteBuffer r6 = r5.buffer     // Catch:{ all -> 0x00b9 }
            int r6 = r6.remaining()     // Catch:{ all -> 0x00b9 }
            if (r6 != 0) goto L_0x0063
            r5.directRead = r2     // Catch:{ all -> 0x00b9 }
        L_0x0063:
            monitor-exit(r5)
            return r0
        L_0x0065:
            java.nio.ByteBuffer r1 = r5.buffer     // Catch:{ all -> 0x00b9 }
            int r1 = r1.remaining()     // Catch:{ all -> 0x00b9 }
            int r0 = r0 - r1
            java.nio.ByteBuffer r3 = r5.buffer     // Catch:{ all -> 0x00b9 }
            r6.put(r3)     // Catch:{ all -> 0x00b9 }
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocate(r0)     // Catch:{ all -> 0x00b9 }
            java.nio.channels.ReadableByteChannel r4 = r5.baseChannel     // Catch:{ all -> 0x00b9 }
            int r4 = r4.read(r3)     // Catch:{ all -> 0x00b9 }
            if (r4 <= 0) goto L_0x0083
            r3.flip()     // Catch:{ all -> 0x00b9 }
            r6.put(r3)     // Catch:{ all -> 0x00b9 }
        L_0x0083:
            boolean r6 = r5.canRewind     // Catch:{ all -> 0x00b9 }
            if (r6 == 0) goto L_0x00b1
            java.nio.ByteBuffer r6 = r5.buffer     // Catch:{ all -> 0x00b9 }
            int r6 = r6.limit()     // Catch:{ all -> 0x00b9 }
            int r6 = r6 + r0
            java.nio.ByteBuffer r6 = java.nio.ByteBuffer.allocate(r6)     // Catch:{ all -> 0x00b9 }
            java.nio.ByteBuffer r0 = r5.buffer     // Catch:{ all -> 0x00b9 }
            r0.flip()     // Catch:{ all -> 0x00b9 }
            java.nio.ByteBuffer r0 = r5.buffer     // Catch:{ all -> 0x00b9 }
            r6.put(r0)     // Catch:{ all -> 0x00b9 }
            if (r4 <= 0) goto L_0x00a4
            r3.flip()     // Catch:{ all -> 0x00b9 }
            r6.put(r3)     // Catch:{ all -> 0x00b9 }
        L_0x00a4:
            r6.flip()     // Catch:{ all -> 0x00b9 }
            int r0 = r6.limit()     // Catch:{ all -> 0x00b9 }
            r6.position(r0)     // Catch:{ all -> 0x00b9 }
            r5.buffer = r6     // Catch:{ all -> 0x00b9 }
            goto L_0x00b6
        L_0x00b1:
            r6 = 0
            r5.buffer = r6     // Catch:{ all -> 0x00b9 }
            r5.directRead = r2     // Catch:{ all -> 0x00b9 }
        L_0x00b6:
            int r1 = r1 + r4
            monitor-exit(r5)
            return r1
        L_0x00b9:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.subtle.RewindableReadableByteChannel.read(java.nio.ByteBuffer):int");
    }

    public synchronized void close() throws IOException {
        this.canRewind = false;
        this.directRead = true;
        this.baseChannel.close();
    }

    public synchronized boolean isOpen() {
        return this.baseChannel.isOpen();
    }
}
