package com.google.common.hash;

import com.google.common.base.Ascii;
import com.google.common.primitives.Longs;
import java.nio.ByteOrder;
import sun.misc.Unsafe;

final class LittleEndianByteArray {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final LittleEndianBytes byteArray;

    private enum JavaLittleEndianBytes implements LittleEndianBytes {
        INSTANCE {
            public long getLongLittleEndian(byte[] bArr, int i) {
                return Longs.fromBytes(bArr[i + 7], bArr[i + 6], bArr[i + 5], bArr[i + 4], bArr[i + 3], bArr[i + 2], bArr[i + 1], bArr[i]);
            }

            public void putLongLittleEndian(byte[] bArr, int i, long j) {
                long j2 = 255;
                for (int i2 = 0; i2 < 8; i2++) {
                    bArr[i + i2] = (byte) ((int) ((j & j2) >> (i2 * 8)));
                    j2 <<= 8;
                }
            }
        }
    }

    private interface LittleEndianBytes {
        long getLongLittleEndian(byte[] bArr, int i);

        void putLongLittleEndian(byte[] bArr, int i, long j);
    }

    static long load64(byte[] bArr, int i) {
        return byteArray.getLongLittleEndian(bArr, i);
    }

    static long load64Safely(byte[] bArr, int i, int i2) {
        int min = Math.min(i2, 8);
        long j = 0;
        for (int i3 = 0; i3 < min; i3++) {
            j |= (((long) bArr[i + i3]) & 255) << (i3 * 8);
        }
        return j;
    }

    static void store64(byte[] bArr, int i, long j) {
        byteArray.putLongLittleEndian(bArr, i, j);
    }

    static int load32(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << Ascii.CAN) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << Ascii.DLE);
    }

    static boolean usingUnsafe() {
        return byteArray instanceof UnsafeByteArray;
    }

    private enum UnsafeByteArray implements LittleEndianBytes {
        UNSAFE_LITTLE_ENDIAN {
            public long getLongLittleEndian(byte[] bArr, int i) {
                return UnsafeByteArray.theUnsafe.getLong(bArr, ((long) i) + ((long) UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET));
            }

            public void putLongLittleEndian(byte[] bArr, int i, long j) {
                UnsafeByteArray.theUnsafe.putLong(bArr, ((long) i) + ((long) UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET), j);
            }
        },
        UNSAFE_BIG_ENDIAN {
            public long getLongLittleEndian(byte[] bArr, int i) {
                return Long.reverseBytes(UnsafeByteArray.theUnsafe.getLong(bArr, ((long) i) + ((long) UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET)));
            }

            public void putLongLittleEndian(byte[] bArr, int i, long j) {
                long reverseBytes = Long.reverseBytes(j);
                UnsafeByteArray.theUnsafe.putLong(bArr, ((long) i) + ((long) UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET), reverseBytes);
            }
        };
        
        /* access modifiers changed from: private */
        public static final int BYTE_ARRAY_BASE_OFFSET = 0;
        /* access modifiers changed from: private */
        public static final Unsafe theUnsafe = null;

        static {
            Class<byte[]> cls;
            Unsafe unsafe = getUnsafe();
            theUnsafe = unsafe;
            BYTE_ARRAY_BASE_OFFSET = unsafe.arrayBaseOffset(cls);
            if (theUnsafe.arrayIndexScale(cls) != 1) {
                throw new AssertionError();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0010, code lost:
            return (sun.misc.Unsafe) java.security.AccessController.doPrivileged(new com.google.common.hash.LittleEndianByteArray.UnsafeByteArray.AnonymousClass3());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0011, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
            throw new java.lang.RuntimeException("Could not initialize intrinsics", r0.getCause());
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0005 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static sun.misc.Unsafe getUnsafe() {
            /*
                sun.misc.Unsafe r0 = sun.misc.Unsafe.getUnsafe()     // Catch:{ SecurityException -> 0x0005 }
                return r0
            L_0x0005:
                com.google.common.hash.LittleEndianByteArray$UnsafeByteArray$3 r0 = new com.google.common.hash.LittleEndianByteArray$UnsafeByteArray$3     // Catch:{ PrivilegedActionException -> 0x0011 }
                r0.<init>()     // Catch:{ PrivilegedActionException -> 0x0011 }
                java.lang.Object r0 = java.security.AccessController.doPrivileged(r0)     // Catch:{ PrivilegedActionException -> 0x0011 }
                sun.misc.Unsafe r0 = (sun.misc.Unsafe) r0     // Catch:{ PrivilegedActionException -> 0x0011 }
                return r0
            L_0x0011:
                r0 = move-exception
                java.lang.RuntimeException r1 = new java.lang.RuntimeException
                java.lang.Throwable r0 = r0.getCause()
                java.lang.String r2 = "Could not initialize intrinsics"
                r1.<init>(r2, r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.hash.LittleEndianByteArray.UnsafeByteArray.getUnsafe():sun.misc.Unsafe");
        }
    }

    static {
        LittleEndianBytes littleEndianBytes = JavaLittleEndianBytes.INSTANCE;
        try {
            if ("amd64".equals(System.getProperty("os.arch"))) {
                littleEndianBytes = ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN) ? UnsafeByteArray.UNSAFE_LITTLE_ENDIAN : UnsafeByteArray.UNSAFE_BIG_ENDIAN;
            }
        } catch (Throwable unused) {
        }
        byteArray = littleEndianBytes;
    }

    private LittleEndianByteArray() {
    }
}
