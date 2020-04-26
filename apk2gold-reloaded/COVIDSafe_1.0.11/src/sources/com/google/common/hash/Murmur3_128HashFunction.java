package com.google.common.hash;

import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@Immutable
final class Murmur3_128HashFunction extends AbstractHashFunction implements Serializable {
    static final HashFunction GOOD_FAST_HASH_128 = new Murmur3_128HashFunction(Hashing.GOOD_FAST_HASH_SEED);
    static final HashFunction MURMUR3_128 = new Murmur3_128HashFunction(0);
    private static final long serialVersionUID = 0;
    private final int seed;

    private static final class Murmur3_128Hasher extends AbstractStreamingHasher {
        private static final long C1 = -8663945395140668459L;
        private static final long C2 = 5545529020109919103L;
        private static final int CHUNK_SIZE = 16;
        private long h1;
        private long h2;
        private int length = 0;

        private static long fmix64(long j) {
            long j2 = (j ^ (j >>> 33)) * -49064778989728563L;
            long j3 = (j2 ^ (j2 >>> 33)) * -4265267296055464877L;
            return j3 ^ (j3 >>> 33);
        }

        Murmur3_128Hasher(int i) {
            super(16);
            long j = (long) i;
            this.h1 = j;
            this.h2 = j;
        }

        /* access modifiers changed from: protected */
        public void process(ByteBuffer byteBuffer) {
            bmix64(byteBuffer.getLong(), byteBuffer.getLong());
            this.length += 16;
        }

        private void bmix64(long j, long j2) {
            long mixK1 = mixK1(j) ^ this.h1;
            this.h1 = mixK1;
            long rotateLeft = Long.rotateLeft(mixK1, 27);
            this.h1 = rotateLeft;
            long j3 = this.h2;
            long j4 = rotateLeft + j3;
            this.h1 = j4;
            this.h1 = (j4 * 5) + 1390208809;
            long mixK2 = mixK2(j2) ^ j3;
            this.h2 = mixK2;
            long rotateLeft2 = Long.rotateLeft(mixK2, 31);
            this.h2 = rotateLeft2;
            long j5 = rotateLeft2 + this.h1;
            this.h2 = j5;
            this.h2 = (j5 * 5) + 944331445;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0055, code lost:
            r0 = r0 ^ (((long) com.google.common.primitives.UnsignedBytes.toInt(r12.get(11))) << 24);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0064, code lost:
            r0 = r0 ^ (((long) com.google.common.primitives.UnsignedBytes.toInt(r12.get(10))) << 16);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0073, code lost:
            r0 = r0 ^ (((long) com.google.common.primitives.UnsignedBytes.toInt(r12.get(9))) << 8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0082, code lost:
            r0 = r0 ^ ((long) com.google.common.primitives.UnsignedBytes.toInt(r12.get(8)));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x008e, code lost:
            r2 = r12.getLong() ^ 0;
            r6 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a4, code lost:
            r0 = r0 ^ (((long) com.google.common.primitives.UnsignedBytes.toInt(r12.get(5))) << 40);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00b2, code lost:
            r0 = r0 ^ (((long) com.google.common.primitives.UnsignedBytes.toInt(r12.get(4))) << 32);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x00c1, code lost:
            r0 = r0 ^ (((long) com.google.common.primitives.UnsignedBytes.toInt(r12.get(3))) << 24);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x00cf, code lost:
            r0 = r0 ^ (((long) com.google.common.primitives.UnsignedBytes.toInt(r12.get(2))) << 16);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x00dd, code lost:
            r0 = r0 ^ (((long) com.google.common.primitives.UnsignedBytes.toInt(r12.get(1))) << 8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00eb, code lost:
            r2 = ((long) com.google.common.primitives.UnsignedBytes.toInt(r12.get(0))) ^ r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x00f6, code lost:
            r11.h1 ^= mixK1(r2);
            r11.h2 ^= mixK2(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0108, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0036, code lost:
            r0 = r0 ^ (((long) com.google.common.primitives.UnsignedBytes.toInt(r12.get(13))) << 40);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0045, code lost:
            r0 = r0 ^ (((long) com.google.common.primitives.UnsignedBytes.toInt(r12.get(12))) << 32);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void processRemaining(java.nio.ByteBuffer r12) {
            /*
                r11 = this;
                int r0 = r11.length
                int r1 = r12.remaining()
                int r0 = r0 + r1
                r11.length = r0
                int r0 = r12.remaining()
                r1 = 48
                r2 = 40
                r3 = 32
                r4 = 24
                r5 = 16
                r6 = 0
                r8 = 8
                switch(r0) {
                    case 1: goto L_0x00ea;
                    case 2: goto L_0x00dc;
                    case 3: goto L_0x00ce;
                    case 4: goto L_0x00c0;
                    case 5: goto L_0x00b1;
                    case 6: goto L_0x00a3;
                    case 7: goto L_0x0095;
                    case 8: goto L_0x008d;
                    case 9: goto L_0x0081;
                    case 10: goto L_0x0072;
                    case 11: goto L_0x0063;
                    case 12: goto L_0x0054;
                    case 13: goto L_0x0044;
                    case 14: goto L_0x0035;
                    case 15: goto L_0x0026;
                    default: goto L_0x001e;
                }
            L_0x001e:
                java.lang.AssertionError r12 = new java.lang.AssertionError
                java.lang.String r0 = "Should never get here."
                r12.<init>(r0)
                throw r12
            L_0x0026:
                r0 = 14
                byte r0 = r12.get(r0)
                int r0 = com.google.common.primitives.UnsignedBytes.toInt(r0)
                long r9 = (long) r0
                long r0 = r9 << r1
                long r0 = r0 ^ r6
                goto L_0x0036
            L_0x0035:
                r0 = r6
            L_0x0036:
                r9 = 13
                byte r9 = r12.get(r9)
                int r9 = com.google.common.primitives.UnsignedBytes.toInt(r9)
                long r9 = (long) r9
                long r9 = r9 << r2
                long r0 = r0 ^ r9
                goto L_0x0045
            L_0x0044:
                r0 = r6
            L_0x0045:
                r2 = 12
                byte r2 = r12.get(r2)
                int r2 = com.google.common.primitives.UnsignedBytes.toInt(r2)
                long r9 = (long) r2
                long r2 = r9 << r3
                long r0 = r0 ^ r2
                goto L_0x0055
            L_0x0054:
                r0 = r6
            L_0x0055:
                r2 = 11
                byte r2 = r12.get(r2)
                int r2 = com.google.common.primitives.UnsignedBytes.toInt(r2)
                long r2 = (long) r2
                long r2 = r2 << r4
                long r0 = r0 ^ r2
                goto L_0x0064
            L_0x0063:
                r0 = r6
            L_0x0064:
                r2 = 10
                byte r2 = r12.get(r2)
                int r2 = com.google.common.primitives.UnsignedBytes.toInt(r2)
                long r2 = (long) r2
                long r2 = r2 << r5
                long r0 = r0 ^ r2
                goto L_0x0073
            L_0x0072:
                r0 = r6
            L_0x0073:
                r2 = 9
                byte r2 = r12.get(r2)
                int r2 = com.google.common.primitives.UnsignedBytes.toInt(r2)
                long r2 = (long) r2
                long r2 = r2 << r8
                long r0 = r0 ^ r2
                goto L_0x0082
            L_0x0081:
                r0 = r6
            L_0x0082:
                byte r2 = r12.get(r8)
                int r2 = com.google.common.primitives.UnsignedBytes.toInt(r2)
                long r2 = (long) r2
                long r0 = r0 ^ r2
                goto L_0x008e
            L_0x008d:
                r0 = r6
            L_0x008e:
                long r2 = r12.getLong()
                long r2 = r2 ^ r6
                r6 = r0
                goto L_0x00f6
            L_0x0095:
                r0 = 6
                byte r0 = r12.get(r0)
                int r0 = com.google.common.primitives.UnsignedBytes.toInt(r0)
                long r9 = (long) r0
                long r0 = r9 << r1
                long r0 = r0 ^ r6
                goto L_0x00a4
            L_0x00a3:
                r0 = r6
            L_0x00a4:
                r9 = 5
                byte r9 = r12.get(r9)
                int r9 = com.google.common.primitives.UnsignedBytes.toInt(r9)
                long r9 = (long) r9
                long r9 = r9 << r2
                long r0 = r0 ^ r9
                goto L_0x00b2
            L_0x00b1:
                r0 = r6
            L_0x00b2:
                r2 = 4
                byte r2 = r12.get(r2)
                int r2 = com.google.common.primitives.UnsignedBytes.toInt(r2)
                long r9 = (long) r2
                long r2 = r9 << r3
                long r0 = r0 ^ r2
                goto L_0x00c1
            L_0x00c0:
                r0 = r6
            L_0x00c1:
                r2 = 3
                byte r2 = r12.get(r2)
                int r2 = com.google.common.primitives.UnsignedBytes.toInt(r2)
                long r2 = (long) r2
                long r2 = r2 << r4
                long r0 = r0 ^ r2
                goto L_0x00cf
            L_0x00ce:
                r0 = r6
            L_0x00cf:
                r2 = 2
                byte r2 = r12.get(r2)
                int r2 = com.google.common.primitives.UnsignedBytes.toInt(r2)
                long r2 = (long) r2
                long r2 = r2 << r5
                long r0 = r0 ^ r2
                goto L_0x00dd
            L_0x00dc:
                r0 = r6
            L_0x00dd:
                r2 = 1
                byte r2 = r12.get(r2)
                int r2 = com.google.common.primitives.UnsignedBytes.toInt(r2)
                long r2 = (long) r2
                long r2 = r2 << r8
                long r0 = r0 ^ r2
                goto L_0x00eb
            L_0x00ea:
                r0 = r6
            L_0x00eb:
                r2 = 0
                byte r12 = r12.get(r2)
                int r12 = com.google.common.primitives.UnsignedBytes.toInt(r12)
                long r2 = (long) r12
                long r2 = r2 ^ r0
            L_0x00f6:
                long r0 = r11.h1
                long r2 = mixK1(r2)
                long r0 = r0 ^ r2
                r11.h1 = r0
                long r0 = r11.h2
                long r2 = mixK2(r6)
                long r0 = r0 ^ r2
                r11.h2 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.hash.Murmur3_128HashFunction.Murmur3_128Hasher.processRemaining(java.nio.ByteBuffer):void");
        }

        public HashCode makeHash() {
            long j = this.h1;
            int i = this.length;
            long j2 = j ^ ((long) i);
            this.h1 = j2;
            long j3 = this.h2 ^ ((long) i);
            this.h2 = j3;
            long j4 = j2 + j3;
            this.h1 = j4;
            this.h2 = j3 + j4;
            this.h1 = fmix64(j4);
            long fmix64 = fmix64(this.h2);
            this.h2 = fmix64;
            long j5 = this.h1 + fmix64;
            this.h1 = j5;
            this.h2 = fmix64 + j5;
            return HashCode.fromBytesNoCopy(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.h1).putLong(this.h2).array());
        }

        private static long mixK1(long j) {
            return Long.rotateLeft(j * C1, 31) * C2;
        }

        private static long mixK2(long j) {
            return Long.rotateLeft(j * C2, 33) * C1;
        }
    }

    public int bits() {
        return 128;
    }

    Murmur3_128HashFunction(int i) {
        this.seed = i;
    }

    public Hasher newHasher() {
        return new Murmur3_128Hasher(this.seed);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hashing.murmur3_128(");
        sb.append(this.seed);
        sb.append(")");
        return sb.toString();
    }

    public boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof Murmur3_128HashFunction)) {
            return false;
        }
        if (this.seed == ((Murmur3_128HashFunction) obj).seed) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return getClass().hashCode() ^ this.seed;
    }
}
