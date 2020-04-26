package com.google.common.hash;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.math.DoubleMath;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.RoundingMode;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class BloomFilter<T> implements Predicate<T>, Serializable {
    /* access modifiers changed from: private */
    public final LockFreeBitArray bits;
    /* access modifiers changed from: private */
    public final Funnel<? super T> funnel;
    /* access modifiers changed from: private */
    public final int numHashFunctions;
    /* access modifiers changed from: private */
    public final Strategy strategy;

    private static class SerialForm<T> implements Serializable {
        private static final long serialVersionUID = 1;
        final long[] data;
        final Funnel<? super T> funnel;
        final int numHashFunctions;
        final Strategy strategy;

        SerialForm(BloomFilter<T> bloomFilter) {
            this.data = LockFreeBitArray.toPlainArray(bloomFilter.bits.data);
            this.numHashFunctions = bloomFilter.numHashFunctions;
            this.funnel = bloomFilter.funnel;
            this.strategy = bloomFilter.strategy;
        }

        /* access modifiers changed from: 0000 */
        public Object readResolve() {
            BloomFilter bloomFilter = new BloomFilter(new LockFreeBitArray(this.data), this.numHashFunctions, this.funnel, this.strategy);
            return bloomFilter;
        }
    }

    interface Strategy extends Serializable {
        <T> boolean mightContain(T t, Funnel<? super T> funnel, int i, LockFreeBitArray lockFreeBitArray);

        int ordinal();

        <T> boolean put(T t, Funnel<? super T> funnel, int i, LockFreeBitArray lockFreeBitArray);
    }

    private BloomFilter(LockFreeBitArray lockFreeBitArray, int i, Funnel<? super T> funnel2, Strategy strategy2) {
        boolean z = true;
        Preconditions.checkArgument(i > 0, "numHashFunctions (%s) must be > 0", i);
        if (i > 255) {
            z = false;
        }
        Preconditions.checkArgument(z, "numHashFunctions (%s) must be <= 255", i);
        this.bits = (LockFreeBitArray) Preconditions.checkNotNull(lockFreeBitArray);
        this.numHashFunctions = i;
        this.funnel = (Funnel) Preconditions.checkNotNull(funnel2);
        this.strategy = (Strategy) Preconditions.checkNotNull(strategy2);
    }

    public BloomFilter<T> copy() {
        return new BloomFilter<>(this.bits.copy(), this.numHashFunctions, this.funnel, this.strategy);
    }

    public boolean mightContain(T t) {
        return this.strategy.mightContain(t, this.funnel, this.numHashFunctions, this.bits);
    }

    @Deprecated
    public boolean apply(T t) {
        return mightContain(t);
    }

    public boolean put(T t) {
        return this.strategy.put(t, this.funnel, this.numHashFunctions, this.bits);
    }

    public double expectedFpp() {
        return Math.pow(((double) this.bits.bitCount()) / ((double) bitSize()), (double) this.numHashFunctions);
    }

    public long approximateElementCount() {
        double bitSize = (double) this.bits.bitSize();
        return DoubleMath.roundToLong(((-Math.log1p(-(((double) this.bits.bitCount()) / bitSize))) * bitSize) / ((double) this.numHashFunctions), RoundingMode.HALF_UP);
    }

    /* access modifiers changed from: 0000 */
    public long bitSize() {
        return this.bits.bitSize();
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=com.google.common.hash.BloomFilter<T>, code=com.google.common.hash.BloomFilter, for r5v0, types: [com.google.common.hash.BloomFilter<T>, com.google.common.hash.BloomFilter, java.lang.Object] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isCompatible(com.google.common.hash.BloomFilter r5) {
        /*
            r4 = this;
            com.google.common.base.Preconditions.checkNotNull(r5)
            if (r4 == r5) goto L_0x002d
            int r0 = r4.numHashFunctions
            int r1 = r5.numHashFunctions
            if (r0 != r1) goto L_0x002d
            long r0 = r4.bitSize()
            long r2 = r5.bitSize()
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x002d
            com.google.common.hash.BloomFilter$Strategy r0 = r4.strategy
            com.google.common.hash.BloomFilter$Strategy r1 = r5.strategy
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x002d
            com.google.common.hash.Funnel<? super T> r0 = r4.funnel
            com.google.common.hash.Funnel<? super T> r5 = r5.funnel
            boolean r5 = r0.equals(r5)
            if (r5 == 0) goto L_0x002d
            r5 = 1
            goto L_0x002e
        L_0x002d:
            r5 = 0
        L_0x002e:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.hash.BloomFilter.isCompatible(com.google.common.hash.BloomFilter):boolean");
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=com.google.common.hash.BloomFilter<T>, code=com.google.common.hash.BloomFilter, for r10v0, types: [com.google.common.hash.BloomFilter<T>, com.google.common.hash.BloomFilter, java.lang.Object] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void putAll(com.google.common.hash.BloomFilter r10) {
        /*
            r9 = this;
            com.google.common.base.Preconditions.checkNotNull(r10)
            r0 = 1
            r1 = 0
            if (r9 == r10) goto L_0x0009
            r2 = r0
            goto L_0x000a
        L_0x0009:
            r2 = r1
        L_0x000a:
            java.lang.String r3 = "Cannot combine a BloomFilter with itself."
            com.google.common.base.Preconditions.checkArgument(r2, r3)
            int r2 = r9.numHashFunctions
            int r3 = r10.numHashFunctions
            if (r2 != r3) goto L_0x0017
            r2 = r0
            goto L_0x0018
        L_0x0017:
            r2 = r1
        L_0x0018:
            int r3 = r9.numHashFunctions
            int r4 = r10.numHashFunctions
            java.lang.String r5 = "BloomFilters must have the same number of hash functions (%s != %s)"
            com.google.common.base.Preconditions.checkArgument(r2, r5, r3, r4)
            long r2 = r9.bitSize()
            long r4 = r10.bitSize()
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x002f
            r3 = r0
            goto L_0x0030
        L_0x002f:
            r3 = r1
        L_0x0030:
            long r5 = r9.bitSize()
            long r7 = r10.bitSize()
            java.lang.String r4 = "BloomFilters must have the same size underlying bit arrays (%s != %s)"
            com.google.common.base.Preconditions.checkArgument(r3, r4, r5, r7)
            com.google.common.hash.BloomFilter$Strategy r0 = r9.strategy
            com.google.common.hash.BloomFilter$Strategy r1 = r10.strategy
            boolean r0 = r0.equals(r1)
            com.google.common.hash.BloomFilter$Strategy r1 = r9.strategy
            com.google.common.hash.BloomFilter$Strategy r2 = r10.strategy
            java.lang.String r3 = "BloomFilters must have equal strategies (%s != %s)"
            com.google.common.base.Preconditions.checkArgument(r0, r3, r1, r2)
            com.google.common.hash.Funnel<? super T> r0 = r9.funnel
            com.google.common.hash.Funnel<? super T> r1 = r10.funnel
            boolean r0 = r0.equals(r1)
            com.google.common.hash.Funnel<? super T> r1 = r9.funnel
            com.google.common.hash.Funnel<? super T> r2 = r10.funnel
            java.lang.String r3 = "BloomFilters must have equal funnels (%s != %s)"
            com.google.common.base.Preconditions.checkArgument(r0, r3, r1, r2)
            com.google.common.hash.BloomFilterStrategies$LockFreeBitArray r0 = r9.bits
            com.google.common.hash.BloomFilterStrategies$LockFreeBitArray r10 = r10.bits
            r0.putAll(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.hash.BloomFilter.putAll(com.google.common.hash.BloomFilter):void");
    }

    public boolean equals(@NullableDecl Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BloomFilter)) {
            return false;
        }
        BloomFilter bloomFilter = (BloomFilter) obj;
        if (this.numHashFunctions != bloomFilter.numHashFunctions || !this.funnel.equals(bloomFilter.funnel) || !this.bits.equals(bloomFilter.bits) || !this.strategy.equals(bloomFilter.strategy)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.numHashFunctions), this.funnel, this.strategy, this.bits);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel2, int i, double d) {
        return create(funnel2, (long) i, d);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel2, long j, double d) {
        return create(funnel2, j, d, BloomFilterStrategies.MURMUR128_MITZ_64);
    }

    static <T> BloomFilter<T> create(Funnel<? super T> funnel2, long j, double d, Strategy strategy2) {
        Preconditions.checkNotNull(funnel2);
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        boolean z = true;
        Preconditions.checkArgument(i >= 0, "Expected insertions (%s) must be >= 0", j);
        Preconditions.checkArgument(d > 0.0d, "False positive probability (%s) must be > 0.0", (Object) Double.valueOf(d));
        if (d >= 1.0d) {
            z = false;
        }
        Preconditions.checkArgument(z, "False positive probability (%s) must be < 1.0", (Object) Double.valueOf(d));
        Preconditions.checkNotNull(strategy2);
        if (i == 0) {
            j = 1;
        }
        long optimalNumOfBits = optimalNumOfBits(j, d);
        try {
            return new BloomFilter<>(new LockFreeBitArray(optimalNumOfBits), optimalNumOfHashFunctions(j, optimalNumOfBits), funnel2, strategy2);
        } catch (IllegalArgumentException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not create BloomFilter of ");
            sb.append(optimalNumOfBits);
            sb.append(" bits");
            throw new IllegalArgumentException(sb.toString(), e);
        }
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel2, int i) {
        return create(funnel2, (long) i);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel2, long j) {
        return create(funnel2, j, 0.03d);
    }

    static int optimalNumOfHashFunctions(long j, long j2) {
        return Math.max(1, (int) Math.round((((double) j2) / ((double) j)) * Math.log(2.0d)));
    }

    static long optimalNumOfBits(long j, double d) {
        if (d == 0.0d) {
            d = Double.MIN_VALUE;
        }
        return (long) ((((double) (-j)) * Math.log(d)) / (Math.log(2.0d) * Math.log(2.0d)));
    }

    private Object writeReplace() {
        return new SerialForm(this);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeByte(SignedBytes.checkedCast((long) this.strategy.ordinal()));
        dataOutputStream.writeByte(UnsignedBytes.checkedCast((long) this.numHashFunctions));
        dataOutputStream.writeInt(this.bits.data.length());
        for (int i = 0; i < this.bits.data.length(); i++) {
            dataOutputStream.writeLong(this.bits.data.get(i));
        }
    }

    public static <T> BloomFilter<T> readFrom(InputStream inputStream, Funnel<? super T> funnel2) throws IOException {
        int i;
        int i2;
        Preconditions.checkNotNull(inputStream, "InputStream");
        Preconditions.checkNotNull(funnel2, "Funnel");
        int i3 = -1;
        try {
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            byte readByte = dataInputStream.readByte();
            try {
                i2 = UnsignedBytes.toInt(dataInputStream.readByte());
                try {
                    int readInt = dataInputStream.readInt();
                    BloomFilterStrategies bloomFilterStrategies = BloomFilterStrategies.values()[readByte];
                    long[] jArr = new long[readInt];
                    for (int i4 = 0; i4 < readInt; i4++) {
                        jArr[i4] = dataInputStream.readLong();
                    }
                    return new BloomFilter<>(new LockFreeBitArray(jArr), i2, funnel2, bloomFilterStrategies);
                } catch (RuntimeException e) {
                    e = e;
                    i3 = readByte;
                    i = -1;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: ");
                    sb.append(i3);
                    sb.append(" numHashFunctions: ");
                    sb.append(i2);
                    sb.append(" dataLength: ");
                    sb.append(i);
                    throw new IOException(sb.toString(), e);
                }
            } catch (RuntimeException e2) {
                e = e2;
                i2 = -1;
                i3 = readByte;
                i = -1;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: ");
                sb2.append(i3);
                sb2.append(" numHashFunctions: ");
                sb2.append(i2);
                sb2.append(" dataLength: ");
                sb2.append(i);
                throw new IOException(sb2.toString(), e);
            }
        } catch (RuntimeException e3) {
            e = e3;
            i = -1;
            i2 = -1;
            StringBuilder sb22 = new StringBuilder();
            sb22.append("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: ");
            sb22.append(i3);
            sb22.append(" numHashFunctions: ");
            sb22.append(i2);
            sb22.append(" dataLength: ");
            sb22.append(i);
            throw new IOException(sb22.toString(), e);
        }
    }
}
